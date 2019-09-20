package com.kesso.nnilib.simpleNetwork

import android.app.Activity
import com.kesso.nnilib.Device
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.gpu.GpuDelegate
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel


class SimpleNetwork(
    override val inputSize: Int,
    override val outputSize: Int,
    override val device: Device,
    override val modelPath: String,
    activity: Activity
) : ISimpleNetwork {

    private var model: MappedByteBuffer
    private var options: Interpreter.Options
    private var tfLite: Interpreter
    private var gpuDelegate: GpuDelegate? = null

    init {
        require(inputSize > 0) { "Classifier init error. inputSize must be greater than zero." }
        require(outputSize > 0) { "Classifier init error. outputSize must be greater than zero." }

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
    }

    override fun predict(input: ByteBuffer): FloatArray {
        val output = ByteBuffer.allocate(4)
        output.order(ByteOrder.nativeOrder())
        tfLite.run(input, output)
        return FloatArray(1)
    }

    override fun predict(input: FloatArray): FloatArray {
        val buffer = ByteBuffer.allocate(inputSize * 4)
        buffer.order(ByteOrder.nativeOrder())

        for (i in input)
            buffer.putFloat(i)

        return predict(buffer)
    }

    private fun loadModel(activity: Activity): MappedByteBuffer {
        val fileDescription = activity.assets.openFd(modelPath)
        val inputStream = FileInputStream(fileDescription.fileDescriptor)
        val fileChanel = inputStream.channel

        val offset = fileDescription.startOffset
        val length = fileDescription.declaredLength

        return fileChanel.map(FileChannel.MapMode.READ_ONLY, offset, length)
    }
}