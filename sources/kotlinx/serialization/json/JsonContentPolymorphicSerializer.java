package kotlinx.serialization.json;

import androidx.glance.session.ecY.lisODU;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
public abstract class JsonContentPolymorphicSerializer<T> implements KSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass f143006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerialDescriptor f143007b;

    protected abstract DeserializationStrategy a(JsonElement jsonElement);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoderD = JsonElementSerializersKt.d(decoder);
        JsonElement jsonElementG = jsonDecoderD.g();
        DeserializationStrategy deserializationStrategyA = a(jsonElementG);
        Intrinsics.checkNotNull(deserializationStrategyA, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.json.JsonContentPolymorphicSerializer>");
        return jsonDecoderD.d().c((KSerializer) deserializationStrategyA, jsonElementG);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.f143007b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        KSerializer kSerializerF = encoder.a().f(this.f143006a, value);
        if (kSerializerF == null) {
            KSerializer kSerializerE = SerializersKt.e(Reflection.b(value.getClass()));
            if (kSerializerE == null) {
                b(Reflection.b(value.getClass()), this.f143006a);
                throw new KotlinNothingValueException();
            }
            kSerializerF = kSerializerE;
        }
        ((KSerializer) kSerializerF).serialize(encoder, value);
    }

    private final Void b(KClass kClass, KClass kClass2) {
        String strM = kClass.m();
        if (strM == null) {
            strM = String.valueOf(kClass);
        }
        throw new SerializationException(lisODU.RofApjvQxHClP + strM + "' is not registered for polymorphic serialization " + ("in the scope of '" + kClass2.m() + '\'') + ".\nMark the base class as 'sealed' or register the serializer explicitly.");
    }
}
