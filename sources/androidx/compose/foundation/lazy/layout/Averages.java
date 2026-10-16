package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

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
final class Averages {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7978b;

    private final long a(long j3, long j4) {
        if (j4 == 0) {
            return j3;
        }
        long j5 = 4;
        return ((j4 / j5) * ((long) 3)) + (j3 / j5);
    }

    public final Averages b() {
        Averages averages = new Averages();
        averages.f7977a = this.f7977a;
        averages.f7978b = this.f7978b;
        return averages;
    }

    public final long c() {
        return this.f7977a;
    }

    public final long d() {
        return this.f7978b;
    }

    public final void e(long j3) {
        this.f7977a = a(j3, this.f7977a);
    }

    public final void f(long j3) {
        this.f7978b = a(j3, this.f7978b);
    }
}
