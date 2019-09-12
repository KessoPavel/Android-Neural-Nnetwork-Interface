package com.kesso.nnilib.preProcessor

object PreProcessorFactory {
    fun getPreProcessor(type: PreProcessor): IPreProcessor {
        return when(type) {
            PreProcessor.normalizer -> Normalizer()
            PreProcessor.empty -> Empty()
        }
    }
}