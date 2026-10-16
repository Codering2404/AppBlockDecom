package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
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
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f142827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KSerializer f142828b;

    public /* synthetic */ KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    protected abstract Object a(Object obj);

    protected final KSerializer b() {
        return this.f142827a;
    }

    protected abstract Object c(Object obj);

    protected final KSerializer d() {
        return this.f142828b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Object deserialize(Decoder decoder) {
        Object objE;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor);
        if (compositeDecoderB.p()) {
            objE = e(CompositeDecoder.DefaultImpls.c(compositeDecoderB, getDescriptor(), 0, b(), null, 8, null), CompositeDecoder.DefaultImpls.c(compositeDecoderB, getDescriptor(), 1, d(), null, 8, null));
        } else {
            Object objC = TuplesKt.f142900a;
            Object objC2 = TuplesKt.f142900a;
            while (true) {
                int iO = compositeDecoderB.o(getDescriptor());
                if (iO != -1) {
                    if (iO == 0) {
                        objC = CompositeDecoder.DefaultImpls.c(compositeDecoderB, getDescriptor(), 0, b(), null, 8, null);
                    } else {
                        if (iO != 1) {
                            throw new SerializationException("Invalid index: " + iO);
                        }
                        objC2 = CompositeDecoder.DefaultImpls.c(compositeDecoderB, getDescriptor(), 1, d(), null, 8, null);
                    }
                } else {
                    if (objC == TuplesKt.f142900a) {
                        throw new SerializationException("Element 'key' is missing");
                    }
                    if (objC2 == TuplesKt.f142900a) {
                        throw new SerializationException("Element 'value' is missing");
                    }
                    objE = e(objC, objC2);
                }
            }
        }
        compositeDecoderB.c(descriptor);
        return objE;
    }

    protected abstract Object e(Object obj, Object obj2);

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder compositeEncoderB = encoder.b(getDescriptor());
        compositeEncoderB.C(getDescriptor(), 0, this.f142827a, a(obj));
        compositeEncoderB.C(getDescriptor(), 1, this.f142828b, c(obj));
        compositeEncoderB.c(getDescriptor());
    }

    private KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        this.f142827a = kSerializer;
        this.f142828b = kSerializer2;
    }
}
