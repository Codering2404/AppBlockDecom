package androidx.collection;

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
public final class FloatFloatPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2832a;

    public static long a(float f3, float f4) {
        return b((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32));
    }

    public static boolean c(long j3, Object obj) {
        return (obj instanceof FloatFloatPair) && j3 == ((FloatFloatPair) obj).f();
    }

    public static int d(long j3) {
        return Long.hashCode(j3);
    }

    public static String e(long j3) {
        return '(' + Float.intBitsToFloat((int) (j3 >> 32)) + ", " + Float.intBitsToFloat((int) (j3 & 4294967295L)) + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f2832a, obj);
    }

    public final /* synthetic */ long f() {
        return this.f2832a;
    }

    public int hashCode() {
        return d(this.f2832a);
    }

    public String toString() {
        return e(this.f2832a);
    }

    public static long b(long j3) {
        return j3;
    }
}
