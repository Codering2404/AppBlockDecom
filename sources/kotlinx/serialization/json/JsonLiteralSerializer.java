package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonLiteralSerializer f143015a = new JsonLiteralSerializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerialDescriptor f143016b = SerialDescriptorsKt.c("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING.f142732a);

    private JsonLiteralSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonLiteral deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement jsonElementG = JsonElementSerializersKt.d(decoder).g();
        if (jsonElementG instanceof JsonLiteral) {
            return (JsonLiteral) jsonElementG;
        }
        throw JsonExceptionsKt.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.b(jsonElementG.getClass()), jsonElementG.toString());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonLiteral value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.h(encoder);
        if (value.b()) {
            encoder.G(value.a());
            return;
        }
        if (value.d() != null) {
            encoder.l(value.d()).G(value.a());
            return;
        }
        Long lW = StringsKt.w(value.a());
        if (lW != null) {
            encoder.m(lW.longValue());
            return;
        }
        ULong uLongI = UStringsKt.i(value.a());
        if (uLongI != null) {
            encoder.l(BuiltinSerializersKt.x(ULong.f139796b).getDescriptor()).m(uLongI.g());
            return;
        }
        Double dR = StringsKt.r(value.a());
        if (dR != null) {
            encoder.g(dR.doubleValue());
            return;
        }
        Boolean boolS1 = StringsKt.s1(value.a());
        if (boolS1 != null) {
            encoder.r(boolS1.booleanValue());
        } else {
            encoder.G(value.a());
        }
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return f143016b;
    }
}
