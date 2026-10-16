package androidx.savedstate.serialization;

import android.os.IBinder;
import android.os.Parcelable;
import androidx.savedstate.serialization.serializers.CharSequenceSerializer;
import androidx.savedstate.serialization.serializers.DefaultParcelableSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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
public final class SavedStateCodecUtils_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SerialDescriptor f53035a = new PolymorphicSerializer(Reflection.b(CharSequence.class)).getDescriptor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerialDescriptor f53036b = new PolymorphicSerializer(Reflection.b(Parcelable.class)).getDescriptor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SerialDescriptor f53037c = new PolymorphicSerializer(Reflection.b(Serializable.class)).getDescriptor();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SerialDescriptor f53038d = new PolymorphicSerializer(Reflection.b(IBinder.class)).getDescriptor();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SerialDescriptor f53039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SerialDescriptor f53040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SerialDescriptor f53041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SerialDescriptor f53042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SerialDescriptor f53043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final SerialDescriptor f53044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final SerialDescriptor f53045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final SerialDescriptor f53046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final SerialDescriptor f53047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final SerialDescriptor f53048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final SerialDescriptor f53049o;

    static {
        DefaultParcelableSerializer defaultParcelableSerializer = DefaultParcelableSerializer.f53079b;
        f53039e = BuiltinSerializersKt.a(Reflection.b(Parcelable.class), defaultParcelableSerializer).getDescriptor();
        f53040f = BuiltinSerializersKt.a(Reflection.b(Parcelable.class), new PolymorphicSerializer(Reflection.b(Parcelable.class))).getDescriptor();
        f53041g = BuiltinSerializersKt.h(defaultParcelableSerializer).getDescriptor();
        f53042h = BuiltinSerializersKt.h(new PolymorphicSerializer(Reflection.b(Parcelable.class))).getDescriptor();
        CharSequenceSerializer charSequenceSerializer = CharSequenceSerializer.f53076a;
        f53043i = BuiltinSerializersKt.a(Reflection.b(CharSequence.class), charSequenceSerializer).getDescriptor();
        f53044j = BuiltinSerializersKt.a(Reflection.b(CharSequence.class), new PolymorphicSerializer(Reflection.b(CharSequence.class))).getDescriptor();
        f53045k = BuiltinSerializersKt.h(charSequenceSerializer).getDescriptor();
        f53046l = BuiltinSerializersKt.h(new PolymorphicSerializer(Reflection.b(CharSequence.class))).getDescriptor();
        f53047m = new SparseArraySerializer(defaultParcelableSerializer).getDescriptor();
        f53048n = new SparseArraySerializer(new PolymorphicSerializer(Reflection.b(Parcelable.class))).getDescriptor();
        f53049o = new SparseArraySerializer(BuiltinSerializersKt.u(new PolymorphicSerializer(Reflection.b(Parcelable.class)))).getDescriptor();
    }

    public static final SerialDescriptor a() {
        return f53043i;
    }

    public static final SerialDescriptor b() {
        return f53045k;
    }

    public static final SerialDescriptor c() {
        return f53049o;
    }

    public static final SerialDescriptor d() {
        return f53039e;
    }

    public static final SerialDescriptor e() {
        return f53041g;
    }

    public static final SerialDescriptor f() {
        return f53044j;
    }

    public static final SerialDescriptor g() {
        return f53035a;
    }

    public static final SerialDescriptor h() {
        return f53046l;
    }

    public static final SerialDescriptor i() {
        return f53038d;
    }

    public static final SerialDescriptor j() {
        return f53037c;
    }

    public static final SerialDescriptor k() {
        return f53040f;
    }

    public static final SerialDescriptor l() {
        return f53036b;
    }

    public static final SerialDescriptor m() {
        return f53042h;
    }

    public static final SerialDescriptor n() {
        return f53048n;
    }

    public static final SerialDescriptor o() {
        return f53047m;
    }
}
