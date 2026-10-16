package androidx.savedstate.serialization;

import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;

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
public final class SavedStateDecoder_androidKt {
    public static final Object a(SavedStateDecoder savedStateDecoder, DeserializationStrategy strategy) {
        Intrinsics.checkNotNullParameter(savedStateDecoder, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        SerialDescriptor descriptor = strategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.g())) {
            return CharSequenceSerializer.f53076a.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.l())) {
            return DefaultParcelableSerializer.f53079b.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.j())) {
            return DefaultJavaSerializableSerializer.f53078b.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.i())) {
            return IBinderSerializer.f53080a.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.a()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.f())) {
            return CharSequenceArraySerializer.f53072a.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.b()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.h())) {
            return CharSequenceListSerializer.f53074a.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.d())) {
            Parcelable[] parcelableArrA = ParcelableArraySerializer.f53085a.deserialize(savedStateDecoder);
            return Arrays.copyOf(parcelableArrA, parcelableArrA.length, JvmClassMappingKt.a(b(strategy)));
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.k())) {
            return ParcelableArraySerializer.f53085a.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.e()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.m())) {
            return ParcelableListSerializer.f53087a.deserialize(savedStateDecoder);
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.o()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.n()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.c())) {
            return SparseParcelableArraySerializer.f53103a.deserialize(savedStateDecoder);
        }
        return null;
    }

    private static final KClass b(DeserializationStrategy deserializationStrategy) {
        Object objDeserialize = deserializationStrategy.deserialize(EmptyArrayDecoder.f53024a);
        Intrinsics.checkNotNull(objDeserialize);
        return Reflection.b(objDeserialize.getClass());
    }
}
