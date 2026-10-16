package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.savedstate.serialization.serializers.CharSequenceArraySerializer;
import androidx.savedstate.serialization.serializers.CharSequenceListSerializer;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultJavaSerializableSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.IBinderSerializer;
import androidx.savedstate.serialization.serializers.ParcelableArraySerializer;
import androidx.savedstate.serialization.serializers.ParcelableListSerializer;
import androidx.savedstate.serialization.serializers.SparseParcelableArraySerializer;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
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
public final class SavedStateEncoder_androidKt {
    public static final boolean a(SavedStateEncoder savedStateEncoder, SerializationStrategy strategy, Object obj) {
        Intrinsics.checkNotNullParameter(savedStateEncoder, "<this>");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        SerialDescriptor descriptor = strategy.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.g())) {
            CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.f53076a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            charSequenceSerializer.serialize(savedStateEncoder, (CharSequence) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.l())) {
            DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.f53079b;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.os.Parcelable");
            defaultParcelableSerializer.serialize(savedStateEncoder, (Parcelable) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.j())) {
            DefaultJavaSerializableSerializer defaultJavaSerializableSerializer = DefaultJavaSerializableSerializer.f53078b;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.io.Serializable");
            defaultJavaSerializableSerializer.serialize(savedStateEncoder, (Serializable) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.i())) {
            IBinderSerializer iBinderSerializer = IBinderSerializer.f53080a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.os.IBinder");
            iBinderSerializer.serialize(savedStateEncoder, (IBinder) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.a()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.f())) {
            CharSequenceArraySerializer charSequenceArraySerializer = CharSequenceArraySerializer.f53072a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
            charSequenceArraySerializer.serialize(savedStateEncoder, (CharSequence[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.b()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.h())) {
            CharSequenceListSerializer charSequenceListSerializer = CharSequenceListSerializer.f53074a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.CharSequence>");
            charSequenceListSerializer.serialize(savedStateEncoder, (List) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.d()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.k())) {
            ParcelableArraySerializer parcelableArraySerializer = ParcelableArraySerializer.f53085a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
            parcelableArraySerializer.serialize(savedStateEncoder, (Parcelable[]) obj);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.e()) || Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.m())) {
            ParcelableListSerializer parcelableListSerializer = ParcelableListSerializer.f53087a;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<android.os.Parcelable>");
            parcelableListSerializer.serialize(savedStateEncoder, (List) obj);
            return true;
        }
        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.o()) && !Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.n()) && !Intrinsics.areEqual(descriptor, SavedStateCodecUtils_androidKt.c())) {
            return false;
        }
        SparseParcelableArraySerializer sparseParcelableArraySerializer = SparseParcelableArraySerializer.f53103a;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.util.SparseArray<android.os.Parcelable>");
        sparseParcelableArraySerializer.serialize(savedStateEncoder, (SparseArray) obj);
        return true;
    }
}
