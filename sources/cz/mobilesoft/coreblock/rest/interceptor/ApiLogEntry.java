package cz.mobilesoft.coreblock.rest.interceptor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ApiLogEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f98503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f98504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f98505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f98506d;

    public ApiLogEntry(long j3, long j4, String censored, String full) {
        Intrinsics.checkNotNullParameter(censored, "censored");
        Intrinsics.checkNotNullParameter(full, "full");
        this.f98503a = j3;
        this.f98504b = j4;
        this.f98505c = censored;
        this.f98506d = full;
    }

    public final long a() {
        return this.f98504b;
    }

    public final String b() {
        return "timestamp: " + this.f98503a + " | " + this.f98505c;
    }

    public final String c() {
        return "timestamp: " + this.f98503a + " | " + this.f98506d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiLogEntry)) {
            return false;
        }
        ApiLogEntry apiLogEntry = (ApiLogEntry) obj;
        return this.f98503a == apiLogEntry.f98503a && this.f98504b == apiLogEntry.f98504b && Intrinsics.areEqual(this.f98505c, apiLogEntry.f98505c) && Intrinsics.areEqual(this.f98506d, apiLogEntry.f98506d);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f98503a) * 31) + Long.hashCode(this.f98504b)) * 31) + this.f98505c.hashCode()) * 31) + this.f98506d.hashCode();
    }

    public String toString() {
        return "ApiLogEntry(timestamp=" + this.f98503a + ", callId=" + this.f98504b + ", censored=" + this.f98505c + ", full=" + this.f98506d + ")";
    }
}
