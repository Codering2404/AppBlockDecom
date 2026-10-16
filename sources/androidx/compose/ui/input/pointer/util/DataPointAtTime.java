package androidx.compose.ui.input.pointer.util;

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
public final class DataPointAtTime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f26977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f26978b;

    public DataPointAtTime(long j3, float f3) {
        this.f26977a = j3;
        this.f26978b = f3;
    }

    public final float a() {
        return this.f26978b;
    }

    public final long b() {
        return this.f26977a;
    }

    public final void c(float f3) {
        this.f26978b = f3;
    }

    public final void d(long j3) {
        this.f26977a = j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataPointAtTime)) {
            return false;
        }
        DataPointAtTime dataPointAtTime = (DataPointAtTime) obj;
        return this.f26977a == dataPointAtTime.f26977a && Float.compare(this.f26978b, dataPointAtTime.f26978b) == 0;
    }

    public int hashCode() {
        return (Long.hashCode(this.f26977a) * 31) + Float.hashCode(this.f26978b);
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.f26977a + ", dataPoint=" + this.f26978b + ')';
    }
}
