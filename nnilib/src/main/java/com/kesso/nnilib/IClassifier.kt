package com.kesso.nnilib

interface IClassifier {
    val shapeX: Int
    val shapeY: Int
    val channels: Int

    val modelPath: String
    val numberOfClasses: Int
    val labels: Array<String>

    fun recognize(image: ByteArray): List<Recognition>
}