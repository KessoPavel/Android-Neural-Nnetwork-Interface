[nnilib](../../index.md) / [com.kesso.nnilib.classifier](../index.md) / [IClassifier](./index.md)

# IClassifier

`interface IClassifier`

describes the general structure of the image classifier

### Properties

| Name | Summary |
|---|---|
| [channels](channels.md) | `abstract val channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>number of channels in the input image |
| [device](device.md) | `abstract val device: `[`Device`](../-device/index.md)<br>device on which the calculations will be performed |
| [labels](labels.md) | `abstract val labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>class names |
| [modelPath](model-path.md) | `abstract val modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>way to a frozen neural network model |
| [numberOfClasses](number-of-classes.md) | `abstract val numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>number of classes |
| [preProcessor](pre-processor.md) | `abstract val preProcessor: `[`IPreProcessor`](../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)<br>input image pre processor |
| [shapeX](shape-x.md) | `abstract val shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>input image width (in pixels) |
| [shapeY](shape-y.md) | `abstract val shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>input image height (in pixels) |

### Functions

| Name | Summary |
|---|---|
| [classify](classify.md) | `abstract fun classify(image: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Recognition`](../../com.kesso.nnilib.recognition/-recognition/index.md)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [Classifier](../-classifier/index.md) | `class Classifier : `[`IClassifier`](./index.md) |
