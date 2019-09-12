package com.kesso.nnilib.classifier

import android.app.Activity
import com.kesso.nnilib.preProcessor.IPreProcessor
import com.kesso.nnilib.recognition.Recognition
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.gpu.GpuDelegate
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import kotlin.collections.ArrayList

class Classifier(
    override val shapeX: Int,
    override val shapeY: Int,
    override val channels: Int,
    override val device: Device,
    override val modelPath: String,
    override val numberOfClasses: Int,
    override val labels: Array<String>,
    override val preProcessor: IPreProcessor,
    activity: Activity
) : IClassifier {
    private var model: MappedByteBuffer
    private var options: Interpreter.Options
    private var tfLite: Interpreter
    private var gpuDelegate: GpuDelegate? = null
    private var inputShapeData: ByteBuffer

    init {
        require(shapeX > 0) { "Classifier init error. shapeX must be greater than zero." }
        require(shapeY > 0) { "Classifier init error. shapeY must be greater than zero." }
        require(channels > 0) { "Classifier init error. channels must be greater than zero." }
        require(numberOfClasses > 0) { "Classifier init error. numberOfClasses must be greater than zero." }

        if(labels.size != numberOfClasses)
            throw ArrayIndexOutOfBoundsException("Classifier init error. Label length must match the number of classes.")

        model = loadModel(activity)
        options = Interpreter.Options()

        when (device){
            Device.GPU -> {
                gpuDelegate = GpuDelegate()
                options.addDelegate(gpuDelegate)
            }
            Device.NNAPI ->
                options.setUseNNAPI(true)
            else ->
                options.setUseNNAPI(false)
        }

        options.setNumThreads(1)
        tfLite = Interpreter(model, options)
        inputShapeData = ByteBuffer.allocate(
            shapeX
                    * shapeY
                    * channels
                    * pixelSize
        )
        inputShapeData.order(ByteOrder.nativeOrder())
    }


    private fun loadModel(activity: Activity): MappedByteBuffer {
        val fileDescription = activity.assets.openFd(modelPath)
        val inputStream = FileInputStream(fileDescription.fileDescriptor)
        val fileChanel = inputStream.channel

        val offset = fileDescription.startOffset
        val length = fileDescription.declaredLength

        return fileChanel.map(FileChannel.MapMode.READ_ONLY, offset, length)
    }

    override fun classify(image: ByteArray): List<Recognition> {
        val predict = arrayOf(FloatArray(numberOfClasses))
        val recognitions = ArrayList<Recognition>()

        preProcessing(image)
        tfLite.run(inputShapeData, predict)

        for (i in 0 until numberOfClasses){
            recognitions.add(
                Recognition(
                    i.toString(),
                    labels[i],
                    predict[0][i]
                )
            )
        }

        return recognitions
    }

    private fun preProcessing(image: ByteArray) {
        inputShapeData.position(0)

        for (pixel in image){
            inputShapeData.putFloat(preProcessor.preProcessing(pixel))
        }
    }

    companion object {
        const val pixelSize = 4
    }

    data class Builder(
        var shapeX: Int? = null,
        var shapeY: Int? = null,
        var channels: Int? = null,
        var device: Device? = null,
        var modelPath: String? = null,
        var numberOfClasses: Int? = null,
        var labels: Array<String> = emptyArray(),
        var preProcessor: IPreProcessor? = null,
        var activity: Activity? = null)
    {
        fun shapeX(shapeX: Int) = apply { this.shapeX = shapeX }
        fun shapeY(shapeY: Int) = apply { this.shapeY = shapeY }
        fun channels(channels: Int) = apply { this.channels = channels }
        fun device(device: Device) = apply { this.device = device }
        fun modelPath(modelPath: String) = apply { this.modelPath = modelPath }
        fun numberOfClasses(numberOfClasses: Int) = apply { this.numberOfClasses = numberOfClasses }
        fun labels(labels: Array<String>) = apply { this.labels = labels }
        fun preProcessor(preProcessor: IPreProcessor) = apply { this.preProcessor = preProcessor }
        fun activity(activity: Activity) = apply { this.activity = activity }
        fun build(): Classifier =
            Classifier(
                shapeX = shapeX!!,
                shapeY = shapeY!!,
                channels = channels!!,
                device = device!!,
                modelPath = modelPath!!,
                numberOfClasses = numberOfClasses!!,
                labels = labels,
                preProcessor = preProcessor!!,
                activity = activity!!
            )
    }
}