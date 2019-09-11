package com.kesso.nnilib

interface IClassifier {
    val shapeX: Int
    val shapeY: Int
    val channels: Int

    val device: Device
    val modelPath: String
    val numberOfClasses: Int
    val labels: Array<String>

    val preProcessor: PreProcessor

    fun classify(image: ByteArray): List<Recognition>
}