package com.kesso.nnilib.classifier

import com.kesso.nnilib.preProcessor.IPreProcessor
import com.kesso.nnilib.recognition.Recognition

/**
 * describes the general structure of the image classifier
 *
 */
interface IClassifier {
    /**
     * input image width (in pixels)
     */
    val shapeX: Int
    /**
     * input image height (in pixels)
     */
    val shapeY: Int
    /**
     * number of channels in the input image
     */
    val channels: Int

    /**
     * device on which the calculations will be performed
     */
    val device: Device
    /**
     * way to a frozen neural network model
     */
    val modelPath: String
    /**
     * number of classes
     */
    val numberOfClasses: Int
    /**
     * class names
     */
    val labels: Array<String>

    /**
     * input image pre processor
     */
    val preProcessor: IPreProcessor

    /**
     * @param image input image
     * @return list of predictions. the number of predictions([Recognition]) is equal to the number of classes
     */
    fun classify(image: ByteArray): List<Recognition>
}