package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
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
public final class SavedStateCodecUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SerialDescriptor f53026a = BuiltinSerializersKt.h(BuiltinSerializersKt.F(IntCompanionObject.f140132a)).getDescriptor();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerialDescriptor f53027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SerialDescriptor f53028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SerialDescriptor f53029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SerialDescriptor f53030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SerialDescriptor f53031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SerialDescriptor f53032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SerialDescriptor f53033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final SerialDescriptor f53034i;

    static {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        f53027b = BuiltinSerializersKt.h(BuiltinSerializersKt.I(stringCompanionObject)).getDescriptor();
        f53028c = BuiltinSerializersKt.b().getDescriptor();
        f53029d = BuiltinSerializersKt.d().getDescriptor();
        f53030e = BuiltinSerializersKt.e().getDescriptor();
        f53031f = BuiltinSerializersKt.f().getDescriptor();
        f53032g = BuiltinSerializersKt.g().getDescriptor();
        f53033h = BuiltinSerializersKt.i().getDescriptor();
        f53034i = BuiltinSerializersKt.a(Reflection.b(String.class), BuiltinSerializersKt.I(stringCompanionObject)).getDescriptor();
    }

    public static final SerialDescriptor a() {
        return f53028c;
    }

    public static final SerialDescriptor b() {
        return f53029d;
    }

    public static final SerialDescriptor c() {
        return f53030e;
    }

    public static final SerialDescriptor d() {
        return f53031f;
    }

    public static final SerialDescriptor e() {
        return f53032g;
    }

    public static final SerialDescriptor f() {
        return f53026a;
    }

    public static final SerialDescriptor g() {
        return f53033h;
    }

    public static final SerialDescriptor h() {
        return f53034i;
    }

    public static final SerialDescriptor i() {
        return f53027b;
    }
}
