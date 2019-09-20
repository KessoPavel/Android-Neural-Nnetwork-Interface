package com.kesso.nnilib.simpleNetwork

import com.kesso.nnilib.Device
import java.nio.ByteBuffer


interface ISimpleNetwork {
    val inputSize: Int
    val outputSize: Int

    val device: Device
    val modelPath: String

    fun predict(input: ByteBuffer): FloatArray
    fun predict(input: FloatArray): FloatArray
}