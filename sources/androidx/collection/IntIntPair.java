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
public final class IntIntPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2875a;

    private /* synthetic */ IntIntPair(long j3) {
        this.f2875a = j3;
    }

    public static final /* synthetic */ IntIntPair a(long j3) {
        return new IntIntPair(j3);
    }

    public static long b(int i3, int i4) {
        return c((((long) i4) & 4294967295L) | (((long) i3) << 32));
    }

    public static boolean d(long j3, Object obj) {
        return (obj instanceof IntIntPair) && j3 == ((IntIntPair) obj).i();
    }

    public static final int e(long j3) {
        return (int) (j3 >> 32);
    }

    public static final int f(long j3) {
        return (int) (j3 & 4294967295L);
    }

    public static int g(long j3) {
        return Long.hashCode(j3);
    }

    public static String h(long j3) {
        return '(' + e(j3) + ", " + f(j3) + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f2875a, obj);
    }

    public int hashCode() {
        return g(this.f2875a);
    }

    public final /* synthetic */ long i() {
        return this.f2875a;
    }

    public String toString() {
        return h(this.f2875a);
    }

    public static long c(long j3) {
        return j3;
    }
}
