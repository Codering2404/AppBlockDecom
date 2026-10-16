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
public final class AggregatedCategoryRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f133694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f133695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f133696c;

    public AggregatedCategoryRecord(int i3, Integer num, String str) {
        this.f133694a = i3;
        this.f133695b = num;
        this.f133696c = str;
    }

    public final String a() {
        return this.f133696c;
    }

    public final int b() {
        return this.f133694a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregatedCategoryRecord)) {
            return false;
        }
        AggregatedCategoryRecord aggregatedCategoryRecord = (AggregatedCategoryRecord) obj;
        return this.f133694a == aggregatedCategoryRecord.f133694a && Intrinsics.areEqual(this.f133695b, aggregatedCategoryRecord.f133695b) && Intrinsics.areEqual(this.f133696c, aggregatedCategoryRecord.f133696c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f133694a) * 31;
        Integer num = this.f133695b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f133696c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AggregatedCategoryRecord(duration=" + this.f133694a + ", launchCount=" + this.f133695b + ", category=" + this.f133696c + ")";
    }
}
