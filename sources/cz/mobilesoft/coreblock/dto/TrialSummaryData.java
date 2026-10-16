package cz.mobilesoft.coreblock.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class TrialSummaryData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f96941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f96942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f96943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Double f96944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f96945e;

    public TrialSummaryData(int i3, Double d3, int i4, Double d4, long j3) {
        this.f96941a = i3;
        this.f96942b = d3;
        this.f96943c = i4;
        this.f96944d = d4;
        this.f96945e = j3;
    }

    public final int a() {
        Double d3 = this.f96942b;
        if (d3 != null) {
            return (int) (d3.doubleValue() / ((double) RangesKt.f(this.f96941a, 1)));
        }
        return 0;
    }

    public final long b() {
        return this.f96945e;
    }

    public final int c() {
        return (a() - d()) * this.f96943c;
    }

    public final int d() {
        Double d3 = this.f96944d;
        if (d3 != null) {
            return (int) (d3.doubleValue() / ((double) RangesKt.f(this.f96943c, 1)));
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrialSummaryData)) {
            return false;
        }
        TrialSummaryData trialSummaryData = (TrialSummaryData) obj;
        return this.f96941a == trialSummaryData.f96941a && Intrinsics.areEqual((Object) this.f96942b, (Object) trialSummaryData.f96942b) && this.f96943c == trialSummaryData.f96943c && Intrinsics.areEqual((Object) this.f96944d, (Object) trialSummaryData.f96944d) && this.f96945e == trialSummaryData.f96945e;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f96941a) * 31;
        Double d3 = this.f96942b;
        int iHashCode2 = (((iHashCode + (d3 == null ? 0 : d3.hashCode())) * 31) + Integer.hashCode(this.f96943c)) * 31;
        Double d4 = this.f96944d;
        return ((iHashCode2 + (d4 != null ? d4.hashCode() : 0)) * 31) + Long.hashCode(this.f96945e);
    }

    public String toString() {
        return "TrialSummaryData(preTrialDuration=" + this.f96941a + ", preTrialUsage=" + this.f96942b + ", trialDuration=" + this.f96943c + ", trialUsage=" + this.f96944d + ", totalBlockScreenCount=" + this.f96945e + ")";
    }
}
