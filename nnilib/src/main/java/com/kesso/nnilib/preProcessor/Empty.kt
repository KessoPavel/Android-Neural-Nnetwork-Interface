package com.kesso.nnilib.preProcessor

/**
 * TODO
 *
 */
class Empty: IPreProcessor {
    override fun preProcessing(pixel: Byte): Float = pixel.toFloat()
}