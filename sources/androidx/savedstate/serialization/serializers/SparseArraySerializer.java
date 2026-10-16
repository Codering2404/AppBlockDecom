package androidx.savedstate.serialization.serializers;

import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SparseArraySerializer<T> implements KSerializer<SparseArray<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f53096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerialDescriptor f53097b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    static final class SparseArraySurrogate<T> {
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Lazy[] f53098c = {LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: androidx.savedstate.serialization.serializers.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SparseArraySerializer.SparseArraySurrogate.b();
            }
        }), null};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final SerialDescriptor f53099d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f53100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f53101b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final <T> KSerializer<SparseArraySurrogate<T>> serializer(KSerializer<T> typeSerial0) {
                Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
                return new SparseArraySerializer$SparseArraySurrogate$$serializer(typeSerial0);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("androidx.savedstate.serialization.serializers.SparseArraySerializer.SparseArraySurrogate", null, 2);
            pluginGeneratedSerialDescriptor.p("keys", false);
            pluginGeneratedSerialDescriptor.p("values", false);
            f53099d = pluginGeneratedSerialDescriptor;
        }

        public /* synthetic */ SparseArraySurrogate(int i3, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, f53099d);
            }
            this.f53100a = list;
            this.f53101b = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer b() {
            return new ArrayListSerializer(IntSerializer.f142823a);
        }

        public static final /* synthetic */ void f(SparseArraySurrogate sparseArraySurrogate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer) {
            compositeEncoder.C(serialDescriptor, 0, (SerializationStrategy) f53098c[0].getValue(), sparseArraySurrogate.f53100a);
            compositeEncoder.C(serialDescriptor, 1, new ArrayListSerializer(kSerializer), sparseArraySurrogate.f53101b);
        }

        public final List d() {
            return this.f53100a;
        }

        public final List e() {
            return this.f53101b;
        }

        public SparseArraySurrogate(List keys, List values) {
            Intrinsics.checkNotNullParameter(keys, "keys");
            Intrinsics.checkNotNullParameter(values, "values");
            this.f53100a = keys;
            this.f53101b = values;
        }
    }

    public SparseArraySerializer(KSerializer elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        KSerializer<SparseArraySurrogate<T>> kSerializerSerializer = SparseArraySurrogate.Companion.serializer(elementSerializer);
        this.f53096a = kSerializerSerializer;
        this.f53097b = kSerializerSerializer.getDescriptor();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SparseArray deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SparseArraySurrogate sparseArraySurrogate = (SparseArraySurrogate) decoder.G(this.f53096a);
        if (sparseArraySurrogate.d().size() != sparseArraySurrogate.e().size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        SparseArray sparseArray = new SparseArray(sparseArraySurrogate.d().size());
        int size = sparseArraySurrogate.d().size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.append(((Number) sparseArraySurrogate.d().get(i3)).intValue(), sparseArraySurrogate.e().get(i3));
        }
        return sparseArray;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, SparseArray value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        int size = value.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(Integer.valueOf(value.keyAt(i3)));
        }
        int size2 = value.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList2.add(value.valueAt(i4));
        }
        encoder.e(this.f53096a, new SparseArraySurrogate(arrayList, arrayList2));
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.f53097b;
    }
}
