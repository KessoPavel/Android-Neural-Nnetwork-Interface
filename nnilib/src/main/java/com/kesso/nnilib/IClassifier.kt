package com.kesso.nnilib

interface IClassifier {
    var maxResult: Int

    val imageSizeX: Int
    val imageSizeY: Int

    val modelPath: String
    val labelPath: String
    val labels: Array<String>

    val batchSize: Int
    val pixelSize: Int
    val pixelPerChannel: Int
    val pixelLogic: PixelValueLogic
    
    fun recognize(image: ByteArray): List<Recognition>
}