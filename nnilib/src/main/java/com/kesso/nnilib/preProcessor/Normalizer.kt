package com.kesso.nnilib.preProcessor

/**
 * TODO
 *
 */
class Normalizer: IPreProcessor {
    override fun preProcessing(pixel: Byte): Float = pixel.toFloat() / 255.0f
}