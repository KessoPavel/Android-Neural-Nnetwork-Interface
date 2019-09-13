package com.kesso.nnilib.preProcessor

/**
 *
 */
object PreProcessorFactory {
    /**
     * TODO
     *
     * @param type
     * @return
     */
    fun getPreProcessor(type: PreProcessor): IPreProcessor {
        return when(type) {
            PreProcessor.normalizer -> Normalizer()
            PreProcessor.empty -> Empty()
        }
    }
}