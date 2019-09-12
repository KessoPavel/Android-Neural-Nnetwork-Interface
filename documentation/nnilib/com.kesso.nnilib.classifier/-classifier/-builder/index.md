[nnilib](../../../index.md) / [com.kesso.nnilib.classifier](../../index.md) / [Classifier](../index.md) / [Builder](./index.md)

# Builder

`data class Builder`

TODO

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Builder(shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, device: `[`Device`](../../-device/index.md)`? = null, modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = null, labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = emptyArray(), preProcessor: `[`IPreProcessor`](../../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)`? = null, activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`? = null)`<br>TODO |

### Properties

| Name | Summary |
|---|---|
| [activity](activity.md) | `var activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`?` |
| [channels](channels.md) | `var channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [device](device.md) | `var device: `[`Device`](../../-device/index.md)`?` |
| [labels](labels.md) | `var labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [modelPath](model-path.md) | `var modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [numberOfClasses](number-of-classes.md) | `var numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [preProcessor](pre-processor.md) | `var preProcessor: `[`IPreProcessor`](../../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)`?` |
| [shapeX](shape-x.md) | `var shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [shapeY](shape-y.md) | `var shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [activity](activity.md) | `fun activity(activity: `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`): `[`Classifier.Builder`](./index.md) |
| [build](build.md) | `fun build(): `[`Classifier`](../index.md)<br>build new classifier |
| [channels](channels.md) | `fun channels(channels: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Classifier.Builder`](./index.md) |
| [device](device.md) | `fun device(device: `[`Device`](../../-device/index.md)`): `[`Classifier.Builder`](./index.md) |
| [labels](labels.md) | `fun labels(labels: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Classifier.Builder`](./index.md) |
| [modelPath](model-path.md) | `fun modelPath(modelPath: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Classifier.Builder`](./index.md) |
| [numberOfClasses](number-of-classes.md) | `fun numberOfClasses(numberOfClasses: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Classifier.Builder`](./index.md) |
| [preProcessor](pre-processor.md) | `fun preProcessor(preProcessor: `[`IPreProcessor`](../../../com.kesso.nnilib.pre-processor/-i-pre-processor/index.md)`): `[`Classifier.Builder`](./index.md) |
| [shapeX](shape-x.md) | `fun shapeX(shapeX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Classifier.Builder`](./index.md) |
| [shapeY](shape-y.md) | `fun shapeY(shapeY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Classifier.Builder`](./index.md) |
