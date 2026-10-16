package androidx.compose.foundation.lazy.grid;

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
public final class GridItemSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7639a;

    private /* synthetic */ GridItemSpan(long j3) {
        this.f7639a = j3;
    }

    public static final /* synthetic */ GridItemSpan a(long j3) {
        return new GridItemSpan(j3);
    }

    public static boolean c(long j3, Object obj) {
        return (obj instanceof GridItemSpan) && j3 == ((GridItemSpan) obj).g();
    }

    public static final int d(long j3) {
        return (int) j3;
    }

    public static int e(long j3) {
        return Long.hashCode(j3);
    }

    public static String f(long j3) {
        return "GridItemSpan(packedValue=" + j3 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f7639a, obj);
    }

    public final /* synthetic */ long g() {
        return this.f7639a;
    }

    public int hashCode() {
        return e(this.f7639a);
    }

    public String toString() {
        return f(this.f7639a);
    }

    public static long b(long j3) {
        return j3;
    }
}
