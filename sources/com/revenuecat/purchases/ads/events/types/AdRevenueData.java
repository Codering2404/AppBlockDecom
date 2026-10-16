package com.revenuecat.purchases.ads.events.types;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AdRevenueData {
    private final String adFormat;
    private final String adUnitId;
    private final String currency;
    private final String impressionId;
    private final String mediatorName;
    private final String networkName;
    private final String placement;
    private final String precision;
    private final long revenueMicros;

    public /* synthetic */ AdRevenueData(String str, String str2, String str3, String str4, String str5, String str6, long j3, String str7, String str8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, j3, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdRevenueData)) {
            return false;
        }
        AdRevenueData adRevenueData = (AdRevenueData) obj;
        return Intrinsics.areEqual(this.networkName, adRevenueData.networkName) && AdMediatorName.m496equalsimpl0(this.mediatorName, adRevenueData.mediatorName) && AdFormat.m479equalsimpl0(this.adFormat, adRevenueData.adFormat) && Intrinsics.areEqual(this.placement, adRevenueData.placement) && Intrinsics.areEqual(this.adUnitId, adRevenueData.adUnitId) && Intrinsics.areEqual(this.impressionId, adRevenueData.impressionId) && this.revenueMicros == adRevenueData.revenueMicros && Intrinsics.areEqual(this.currency, adRevenueData.currency) && AdRevenuePrecision.m511equalsimpl0(this.precision, adRevenueData.precision);
    }

    /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: not valid java name */
    public final String m505getAdFormaty0COY5Q() {
        return this.adFormat;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getImpressionId() {
        return this.impressionId;
    }

    /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: not valid java name */
    public final String m506getMediatorNameGyoM_N4() {
        return this.mediatorName;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final String getPlacement() {
        return this.placement;
    }

    /* JADX INFO: renamed from: getPrecision-rAcPn4k, reason: not valid java name */
    public final String m507getPrecisionrAcPn4k() {
        return this.precision;
    }

    public final long getRevenueMicros() {
        return this.revenueMicros;
    }

    public int hashCode() {
        String str = this.networkName;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + AdMediatorName.m497hashCodeimpl(this.mediatorName)) * 31) + AdFormat.m480hashCodeimpl(this.adFormat)) * 31;
        String str2 = this.placement;
        return ((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.adUnitId.hashCode()) * 31) + this.impressionId.hashCode()) * 31) + Long.hashCode(this.revenueMicros)) * 31) + this.currency.hashCode()) * 31) + AdRevenuePrecision.m512hashCodeimpl(this.precision);
    }

    public String toString() {
        return "AdRevenueData(networkName=" + this.networkName + ", mediatorName=" + ((Object) AdMediatorName.m498toStringimpl(this.mediatorName)) + ", adFormat=" + ((Object) AdFormat.m481toStringimpl(this.adFormat)) + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ", revenueMicros=" + this.revenueMicros + ", currency=" + this.currency + ", precision=" + ((Object) AdRevenuePrecision.m513toStringimpl(this.precision)) + ')';
    }

    private AdRevenueData(String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, long j3, String currency, String precision) {
        Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(precision, "precision");
        this.networkName = str;
        this.mediatorName = mediatorName;
        this.adFormat = adFormat;
        this.placement = str2;
        this.adUnitId = adUnitId;
        this.impressionId = impressionId;
        this.revenueMicros = j3;
        this.currency = currency;
        this.precision = precision;
    }
}
