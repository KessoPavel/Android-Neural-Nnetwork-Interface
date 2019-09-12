package com.kesso.nnilib.preProcessor

class Empty: IPreProcessor {
    override fun preProcessing(pixel: Byte): Float = pixel.toFloat()
}