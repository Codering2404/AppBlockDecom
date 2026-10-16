package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class DistanceAndFlags {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27317a;

    public static final int a(long j3, long j4) {
        boolean zG = g(j3);
        if (zG != g(j4)) {
            return zG ? -1 : 1;
        }
        return (Math.min(d(j3), d(j4)) >= 0.0f && f(j3) != f(j4)) ? f(j3) ? -1 : 1 : (int) Math.signum(d(j3) - d(j4));
    }

    public static boolean c(long j3, Object obj) {
        return (obj instanceof DistanceAndFlags) && j3 == ((DistanceAndFlags) obj).i();
    }

    public static final float d(long j3) {
        return Float.intBitsToFloat((int) (j3 >> 32));
    }

    public static int e(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean f(long j3) {
        return (j3 & 2) != 0;
    }

    public static final boolean g(long j3) {
        return (j3 & 1) != 0;
    }

    public static String h(long j3) {
        return "DistanceAndFlags(packedValue=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f27317a, obj);
    }

    public int hashCode() {
        return e(this.f27317a);
    }

    public final /* synthetic */ long i() {
        return this.f27317a;
    }

    public String toString() {
        return h(this.f27317a);
    }

    public static long b(long j3) {
        return j3;
    }
}
