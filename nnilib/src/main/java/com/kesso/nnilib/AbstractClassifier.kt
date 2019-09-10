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

abstract class AbstractClassifier(
    final override val shapeX: Int,
    final override val shapeY: Int,
    final override val channels: Int,
    final override val device: Device,
    final override val modelPath: String,
    final override val numberOfClasses: Int,
    final override val labels: Array<String>,
    activity: Activity
) : IClassifier {

    private var model: MappedByteBuffer
    private var options: Interpreter.Options
    private var tfLite: Interpreter
    private var gpuDelegate: GpuDelegate? = null
    private var inputShapeData: ByteBuffer

    init {
        if (shapeX <= 0)
            throw IllegalArgumentException("Classifier init error. shapeX must be greater than zero.")

        if (shapeY <= 0)
            throw IllegalArgumentException("Classifier init error. shapeY must be greater than zero.")

        if (channels <= 0)
            throw IllegalArgumentException("Classifier init error. channels must be greater than zero.")

        if (numberOfClasses >= 0)
            throw IllegalArgumentException("Classifier init error. numberOfClasses must be greater than zero.")

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

    companion object {
        const val pixelSize = 4
    }
}