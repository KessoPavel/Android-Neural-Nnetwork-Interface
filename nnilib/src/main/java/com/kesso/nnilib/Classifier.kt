package com.kesso.nnilib

import android.app.Activity
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.gpu.GpuDelegate
import java.io.FileInputStream
import java.lang.IllegalArgumentException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class Classifier(
    override val shapeX: Int,
    override val shapeY: Int,
    override val channels: Int,
    override val device: Device,
    override val modelPath: String,
    override val numberOfClasses: Int,
    override val labels: Array<String>,
    override val preProcessor: PreProcessor,
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
            recognitions.add(Recognition(i.toString(), labels[i],predict[0][i]))
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
}