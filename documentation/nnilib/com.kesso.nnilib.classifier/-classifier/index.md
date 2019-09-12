[nnilib](../../index.md) / [com.kesso.nnilib.classifier](../index.md) / [Classifier](./index.md)

# Classifier

`class Classifier : `[`IClassifier`](../-i-classifier/index.md)

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `data class Builder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Classifier(shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, device: `[`Device`](../-device/index.md)`, modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, preProcessor: `[`IPreProcessor`](../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)`, activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [channels](channels.md) | `val channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>number of channels in the input image |
| [device](device.md) | `val device: `[`Device`](../-device/index.md)<br>device on which the calculations will be performed |
| [labels](labels.md) | `val labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>class names |
| [modelPath](model-path.md) | `val modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>way to a frozen neural network model |
| [numberOfClasses](number-of-classes.md) | `val numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>number of classes |
| [preProcessor](pre-processor.md) | `val preProcessor: `[`IPreProcessor`](../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)<br>input image pre processor |
| [shapeX](shape-x.md) | `val shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>input image width (in pixels) |
| [shapeY](shape-y.md) | `val shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>input image height (in pixels) |

### Functions

| Name | Summary |
|---|---|
| [classify](classify.md) | `fun classify(image: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Recognition`](../../com.kesso.nnilib.recognition/-recognition/index.md)`>` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [pixelSize](pixel-size.md) | `const val pixelSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
