package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
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
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f142896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KSerializer f142897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final KSerializer f142898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SerialDescriptor f142899d;

    public TripleSerializer(KSerializer aSerializer, KSerializer bSerializer, KSerializer cSerializer) {
        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
        this.f142896a = aSerializer;
        this.f142897b = bSerializer;
        this.f142898c = cSerializer;
        this.f142899d = SerialDescriptorsKt.d("kotlin.Triple", new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.internal.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TripleSerializer.d(this.f142947a, (ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    private final Triple b(CompositeDecoder compositeDecoder) {
        Object objC = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 0, this.f142896a, null, 8, null);
        Object objC2 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 1, this.f142897b, null, 8, null);
        Object objC3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 2, this.f142898c, null, 8, null);
        compositeDecoder.c(getDescriptor());
        return new Triple(objC, objC2, objC3);
    }

    private final Triple c(CompositeDecoder compositeDecoder) {
        CompositeDecoder compositeDecoder2;
        Object objC = TuplesKt.f142900a;
        Object objC2 = TuplesKt.f142900a;
        Object objC3 = TuplesKt.f142900a;
        while (true) {
            int iO = compositeDecoder.o(getDescriptor());
            if (iO == -1) {
                compositeDecoder.c(getDescriptor());
                if (objC == TuplesKt.f142900a) {
                    throw new SerializationException("Element 'first' is missing");
                }
                if (objC2 == TuplesKt.f142900a) {
                    throw new SerializationException("Element 'second' is missing");
                }
                if (objC3 != TuplesKt.f142900a) {
                    return new Triple(objC, objC2, objC3);
                }
                throw new SerializationException("Element 'third' is missing");
            }
            if (iO == 0) {
                compositeDecoder2 = compositeDecoder;
                objC = CompositeDecoder.DefaultImpls.c(compositeDecoder2, getDescriptor(), 0, this.f142896a, null, 8, null);
            } else if (iO == 1) {
                compositeDecoder2 = compositeDecoder;
                objC2 = CompositeDecoder.DefaultImpls.c(compositeDecoder2, getDescriptor(), 1, this.f142897b, null, 8, null);
            } else {
                if (iO != 2) {
                    throw new SerializationException("Unexpected index " + iO);
                }
                objC3 = CompositeDecoder.DefaultImpls.c(compositeDecoder, getDescriptor(), 2, this.f142898c, null, 8, null);
            }
            compositeDecoder = compositeDecoder2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(TripleSerializer tripleSerializer, ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "first", tripleSerializer.f142896a.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "second", tripleSerializer.f142897b.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "third", tripleSerializer.f142898c.getDescriptor(), null, false, 12, null);
        return Unit.f139807a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Triple deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder compositeDecoderB = decoder.b(getDescriptor());
        return compositeDecoderB.p() ? b(compositeDecoderB) : c(compositeDecoderB);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, Triple value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        CompositeEncoder compositeEncoderB = encoder.b(getDescriptor());
        compositeEncoderB.C(getDescriptor(), 0, this.f142896a, value.d());
        compositeEncoderB.C(getDescriptor(), 1, this.f142897b, value.e());
        compositeEncoderB.C(getDescriptor(), 2, this.f142898c, value.f());
        compositeEncoderB.c(getDescriptor());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.f142899d;
    }
}
