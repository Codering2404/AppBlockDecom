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
public final class AdOpenedData {
    private final String adFormat;
    private final String adUnitId;
    private final String impressionId;
    private final String mediatorName;
    private final String networkName;
    private final String placement;

    public /* synthetic */ AdOpenedData(String str, String str2, String str3, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdOpenedData)) {
            return false;
        }
        AdOpenedData adOpenedData = (AdOpenedData) obj;
        return Intrinsics.areEqual(this.networkName, adOpenedData.networkName) && AdMediatorName.m496equalsimpl0(this.mediatorName, adOpenedData.mediatorName) && AdFormat.m479equalsimpl0(this.adFormat, adOpenedData.adFormat) && Intrinsics.areEqual(this.placement, adOpenedData.placement) && Intrinsics.areEqual(this.adUnitId, adOpenedData.adUnitId) && Intrinsics.areEqual(this.impressionId, adOpenedData.impressionId);
    }

    /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: not valid java name */
    public final String m503getAdFormaty0COY5Q() {
        return this.adFormat;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getImpressionId() {
        return this.impressionId;
    }

    /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: not valid java name */
    public final String m504getMediatorNameGyoM_N4() {
        return this.mediatorName;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public int hashCode() {
        String str = this.networkName;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + AdMediatorName.m497hashCodeimpl(this.mediatorName)) * 31) + AdFormat.m480hashCodeimpl(this.adFormat)) * 31;
        String str2 = this.placement;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.adUnitId.hashCode()) * 31) + this.impressionId.hashCode();
    }

    public String toString() {
        return "AdOpenedData(networkName=" + this.networkName + ", mediatorName=" + ((Object) AdMediatorName.m498toStringimpl(this.mediatorName)) + ", adFormat=" + ((Object) AdFormat.m481toStringimpl(this.adFormat)) + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ')';
    }

    private AdOpenedData(String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId) {
        Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        this.networkName = str;
        this.mediatorName = mediatorName;
        this.adFormat = adFormat;
        this.placement = str2;
        this.adUnitId = adUnitId;
        this.impressionId = impressionId;
    }
}
