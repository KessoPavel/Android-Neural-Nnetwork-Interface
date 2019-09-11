package com.kesso.nnilib

interface PreProcessor {
    fun preProcessing(pixel: Byte): Float
}