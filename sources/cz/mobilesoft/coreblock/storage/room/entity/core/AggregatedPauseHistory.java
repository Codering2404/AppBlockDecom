package cz.mobilesoft.coreblock.storage.room.entity.core;

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
public final class AggregatedPauseHistory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f126541b;

    public AggregatedPauseHistory(long j3, Long l3) {
        this.f126540a = j3;
        this.f126541b = l3;
    }

    public final long a() {
        return this.f126540a;
    }

    public final Long b() {
        return this.f126541b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregatedPauseHistory)) {
            return false;
        }
        AggregatedPauseHistory aggregatedPauseHistory = (AggregatedPauseHistory) obj;
        return this.f126540a == aggregatedPauseHistory.f126540a && Intrinsics.areEqual(this.f126541b, aggregatedPauseHistory.f126541b);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f126540a) * 31;
        Long l3 = this.f126541b;
        return iHashCode + (l3 == null ? 0 : l3.hashCode());
    }

    public String toString() {
        return "AggregatedPauseHistory(count=" + this.f126540a + ", total=" + this.f126541b + ")";
    }
}
