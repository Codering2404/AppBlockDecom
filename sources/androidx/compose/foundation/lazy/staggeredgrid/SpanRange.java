package androidx.compose.foundation.lazy.staggeredgrid;

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
public final class SpanRange {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8596a;

    public static long a(int i3, int i4) {
        return b((((long) (i4 + i3)) & 4294967295L) | (((long) i3) << 32));
    }

    public static boolean c(long j3, Object obj) {
        return (obj instanceof SpanRange) && j3 == ((SpanRange) obj).f();
    }

    public static int d(long j3) {
        return Long.hashCode(j3);
    }

    public static String e(long j3) {
        return "SpanRange(packedValue=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f8596a, obj);
    }

    public final /* synthetic */ long f() {
        return this.f8596a;
    }

    public int hashCode() {
        return d(this.f8596a);
    }

    public String toString() {
        return e(this.f8596a);
    }

    private static long b(long j3) {
        return j3;
    }
}
