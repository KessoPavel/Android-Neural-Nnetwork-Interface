package com.kesso.nnilib.preProcessor

/**
 *
 *
 */
interface IPreProcessor {
    /**
     *
     *
     * @param pixel
     * @return
     */
    fun preProcessing(pixel: Byte): Float
}