[nnilib](../../index.md) / [com.kesso.nnilib.classifier](../index.md) / [IClassifier](index.md) / [classify](./classify.md)

# classify

`abstract fun classify(image: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Recognition`](../../com.kesso.nnilib.recognition/-recognition/index.md)`>`

### Parameters

`image` - input image

**Return**
list of predictions. the number of predictions([Recognition](../../com.kesso.nnilib.recognition/-recognition/index.md)) is equal to the number of classes

