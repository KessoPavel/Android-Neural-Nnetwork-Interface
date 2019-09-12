package com.kesso.nnilib.preProcessor

class Normalizer: IPreProcessor {
    override fun preProcessing(pixel: Byte): Float = pixel.toFloat() / 255.0f
}