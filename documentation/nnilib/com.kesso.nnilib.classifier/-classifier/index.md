[nnilib](../../index.md) / [com.kesso.nnilib.classifier](../index.md) / [Classifier](./index.md)

# Classifier

`class Classifier : `[`IClassifier`](../-i-classifier/index.md)

классификатор изображения основанный на .tflite модели нейронной сети

### Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | `data class Builder`<br>TODO |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Classifier(shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, device: `[`Device`](../-device/index.md)`, modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, preProcessor: `[`IPreProcessor`](../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)`, activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`)`<br>классификатор изображения основанный на .tflite модели нейронной сети |

### Properties

| Name | Summary |
|---|---|
| [channels](channels.md) | `val channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [device](device.md) | `val device: `[`Device`](../-device/index.md) |
| [labels](labels.md) | `val labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [modelPath](model-path.md) | `val modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>сожержит путь к файлу .tflite |
| [numberOfClasses](number-of-classes.md) | `val numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [preProcessor](pre-processor.md) | `val preProcessor: `[`IPreProcessor`](../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md) |
| [shapeX](shape-x.md) | `val shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [shapeY](shape-y.md) | `val shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [classify](classify.md) | `fun classify(image: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Recognition`](../../com.kesso.nnilib.recognition/-recognition/index.md)`>` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [pixelSize](pixel-size.md) | `const val pixelSize: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
