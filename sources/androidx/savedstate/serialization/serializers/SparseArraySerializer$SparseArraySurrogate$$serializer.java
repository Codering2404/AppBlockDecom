package androidx.savedstate.serialization.serializers;

import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@Deprecated
public /* synthetic */ class SparseArraySerializer$SparseArraySurrogate$$serializer<T> implements GeneratedSerializer<SparseArraySerializer.SparseArraySurrogate<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ KSerializer f53102a;
    private final SerialDescriptor descriptor;

    private SparseArraySerializer$SparseArraySurrogate$$serializer() {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", this, 2);
        pluginGeneratedSerialDescriptor.p("keys", false);
        pluginGeneratedSerialDescriptor.p("values", false);
        this.descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SparseArraySerializer.SparseArraySurrogate deserialize(Decoder decoder) {
        List list;
        List list2;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = this.descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        Lazy[] lazyArr = SparseArraySerializer.SparseArraySurrogate.f53098c;
        if (compositeDecoderB.p()) {
            list = (List) compositeDecoderB.y(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
            list2 = (List) compositeDecoderB.y(serialDescriptor, 1, new ArrayListSerializer(this.f53102a), null);
            i3 = 3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            List list3 = null;
            List list4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    list3 = (List) compositeDecoderB.y(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list3);
                    i4 |= 1;
                } else {
                    if (iO != 1) {
                        throw new UnknownFieldException(iO);
                    }
                    list4 = (List) compositeDecoderB.y(serialDescriptor, 1, new ArrayListSerializer(this.f53102a), list4);
                    i4 |= 2;
                }
            }
            list = list3;
            list2 = list4;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new SparseArraySerializer.SparseArraySurrogate(i3, list, list2, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, SparseArraySerializer.SparseArraySurrogate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = this.descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SparseArraySerializer.SparseArraySurrogate.f(value, compositeEncoderB, serialDescriptor, this.f53102a);
        compositeEncoderB.c(serialDescriptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{SparseArraySerializer.SparseArraySurrogate.f53098c[0].getValue(), new ArrayListSerializer(this.f53102a)};
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] typeParametersSerializers() {
        return new KSerializer[]{this.f53102a};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparseArraySerializer$SparseArraySurrogate$$serializer(KSerializer typeSerial0) {
        this();
        Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
        this.f53102a = typeSerial0;
    }
}
