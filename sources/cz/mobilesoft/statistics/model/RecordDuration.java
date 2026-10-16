package cz.mobilesoft.statistics.model;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RecordDuration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f133737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f133738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f133739c;

    public RecordDuration(long j3, String name, long j4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133737a = j3;
        this.f133738b = name;
        this.f133739c = j4;
    }

    public final String a() {
        return this.f133738b;
    }

    public final long b() {
        return this.f133737a;
    }

    public final long c() {
        return this.f133739c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordDuration)) {
            return false;
        }
        RecordDuration recordDuration = (RecordDuration) obj;
        return this.f133737a == recordDuration.f133737a && Intrinsics.areEqual(this.f133738b, recordDuration.f133738b) && this.f133739c == recordDuration.f133739c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f133737a) * 31) + this.f133738b.hashCode()) * 31) + Long.hashCode(this.f133739c);
    }

    public String toString() {
        return "RecordDuration(timestamp=" + this.f133737a + ", name=" + this.f133738b + ", total=" + this.f133739c + ")";
    }
}
