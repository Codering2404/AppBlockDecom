package com.revenuecat.purchases.paywalls.events;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class BackendPaywallComponentFields {
    private final String componentName;
    private final String componentType;
    private final String componentUrl;
    private final String componentValue;
    private final String currentPackageIdentifier;
    private final String currentProductIdentifier;
    private final Integer defaultIndex;
    private final String defaultPackageIdentifier;
    private final String defaultProductIdentifier;
    private final String destinationContextName;
    private final Integer destinationIndex;
    private final String destinationPackageIdentifier;
    private final String destinationProductIdentifier;
    private final String originContextName;
    private final Integer originIndex;
    private final String originPackageIdentifier;
    private final String originProductIdentifier;
    private final String resultingPackageIdentifier;
    private final String resultingProductIdentifier;

    public BackendPaywallComponentFields() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ BackendPaywallComponentFields copy$default(BackendPaywallComponentFields backendPaywallComponentFields, String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i3, Object obj) {
        String str17;
        String str18;
        String str19 = (i3 & 1) != 0 ? backendPaywallComponentFields.componentType : str;
        String str20 = (i3 & 2) != 0 ? backendPaywallComponentFields.componentName : str2;
        String str21 = (i3 & 4) != 0 ? backendPaywallComponentFields.componentValue : str3;
        String str22 = (i3 & 8) != 0 ? backendPaywallComponentFields.componentUrl : str4;
        Integer num4 = (i3 & 16) != 0 ? backendPaywallComponentFields.originIndex : num;
        Integer num5 = (i3 & 32) != 0 ? backendPaywallComponentFields.destinationIndex : num2;
        String str23 = (i3 & 64) != 0 ? backendPaywallComponentFields.originContextName : str5;
        String str24 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? backendPaywallComponentFields.destinationContextName : str6;
        Integer num6 = (i3 & Function.MAX_NARGS) != 0 ? backendPaywallComponentFields.defaultIndex : num3;
        String str25 = (i3 & 512) != 0 ? backendPaywallComponentFields.originPackageIdentifier : str7;
        String str26 = (i3 & 1024) != 0 ? backendPaywallComponentFields.destinationPackageIdentifier : str8;
        String str27 = (i3 & 2048) != 0 ? backendPaywallComponentFields.defaultPackageIdentifier : str9;
        String str28 = (i3 & 4096) != 0 ? backendPaywallComponentFields.originProductIdentifier : str10;
        String str29 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? backendPaywallComponentFields.destinationProductIdentifier : str11;
        String str30 = str19;
        String str31 = (i3 & 16384) != 0 ? backendPaywallComponentFields.defaultProductIdentifier : str12;
        String str32 = (i3 & 32768) != 0 ? backendPaywallComponentFields.currentPackageIdentifier : str13;
        String str33 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? backendPaywallComponentFields.resultingPackageIdentifier : str14;
        String str34 = (i3 & 131072) != 0 ? backendPaywallComponentFields.currentProductIdentifier : str15;
        if ((i3 & 262144) != 0) {
            str18 = str34;
            str17 = backendPaywallComponentFields.resultingProductIdentifier;
        } else {
            str17 = str16;
            str18 = str34;
        }
        return backendPaywallComponentFields.copy(str30, str20, str21, str22, num4, num5, str23, str24, num6, str25, str26, str27, str28, str29, str31, str32, str33, str18, str17);
    }

    public final String component1() {
        return this.componentType;
    }

    public final String component10() {
        return this.originPackageIdentifier;
    }

    public final String component11() {
        return this.destinationPackageIdentifier;
    }

    public final String component12() {
        return this.defaultPackageIdentifier;
    }

    public final String component13() {
        return this.originProductIdentifier;
    }

    public final String component14() {
        return this.destinationProductIdentifier;
    }

    public final String component15() {
        return this.defaultProductIdentifier;
    }

    public final String component16() {
        return this.currentPackageIdentifier;
    }

    public final String component17() {
        return this.resultingPackageIdentifier;
    }

    public final String component18() {
        return this.currentProductIdentifier;
    }

    public final String component19() {
        return this.resultingProductIdentifier;
    }

    public final String component2() {
        return this.componentName;
    }

    public final String component3() {
        return this.componentValue;
    }

    public final String component4() {
        return this.componentUrl;
    }

    public final Integer component5() {
        return this.originIndex;
    }

    public final Integer component6() {
        return this.destinationIndex;
    }

    public final String component7() {
        return this.originContextName;
    }

    public final String component8() {
        return this.destinationContextName;
    }

    public final Integer component9() {
        return this.defaultIndex;
    }

    public final BackendPaywallComponentFields copy(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        return new BackendPaywallComponentFields(str, str2, str3, str4, num, num2, str5, str6, num3, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackendPaywallComponentFields)) {
            return false;
        }
        BackendPaywallComponentFields backendPaywallComponentFields = (BackendPaywallComponentFields) obj;
        return Intrinsics.areEqual(this.componentType, backendPaywallComponentFields.componentType) && Intrinsics.areEqual(this.componentName, backendPaywallComponentFields.componentName) && Intrinsics.areEqual(this.componentValue, backendPaywallComponentFields.componentValue) && Intrinsics.areEqual(this.componentUrl, backendPaywallComponentFields.componentUrl) && Intrinsics.areEqual(this.originIndex, backendPaywallComponentFields.originIndex) && Intrinsics.areEqual(this.destinationIndex, backendPaywallComponentFields.destinationIndex) && Intrinsics.areEqual(this.originContextName, backendPaywallComponentFields.originContextName) && Intrinsics.areEqual(this.destinationContextName, backendPaywallComponentFields.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, backendPaywallComponentFields.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, backendPaywallComponentFields.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, backendPaywallComponentFields.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, backendPaywallComponentFields.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, backendPaywallComponentFields.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, backendPaywallComponentFields.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, backendPaywallComponentFields.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, backendPaywallComponentFields.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, backendPaywallComponentFields.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, backendPaywallComponentFields.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, backendPaywallComponentFields.resultingProductIdentifier);
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final String getComponentType() {
        return this.componentType;
    }

    public final String getComponentUrl() {
        return this.componentUrl;
    }

    public final String getComponentValue() {
        return this.componentValue;
    }

    public final String getCurrentPackageIdentifier() {
        return this.currentPackageIdentifier;
    }

    public final String getCurrentProductIdentifier() {
        return this.currentProductIdentifier;
    }

    public final Integer getDefaultIndex() {
        return this.defaultIndex;
    }

    public final String getDefaultPackageIdentifier() {
        return this.defaultPackageIdentifier;
    }

    public final String getDefaultProductIdentifier() {
        return this.defaultProductIdentifier;
    }

    public final String getDestinationContextName() {
        return this.destinationContextName;
    }

    public final Integer getDestinationIndex() {
        return this.destinationIndex;
    }

    public final String getDestinationPackageIdentifier() {
        return this.destinationPackageIdentifier;
    }

    public final String getDestinationProductIdentifier() {
        return this.destinationProductIdentifier;
    }

    public final String getOriginContextName() {
        return this.originContextName;
    }

    public final Integer getOriginIndex() {
        return this.originIndex;
    }

    public final String getOriginPackageIdentifier() {
        return this.originPackageIdentifier;
    }

    public final String getOriginProductIdentifier() {
        return this.originProductIdentifier;
    }

    public final String getResultingPackageIdentifier() {
        return this.resultingPackageIdentifier;
    }

    public final String getResultingProductIdentifier() {
        return this.resultingProductIdentifier;
    }

    public int hashCode() {
        String str = this.componentType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.componentName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.componentValue;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.componentUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.originIndex;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.destinationIndex;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.originContextName;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.destinationContextName;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num3 = this.defaultIndex;
        int iHashCode9 = (iHashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str7 = this.originPackageIdentifier;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.destinationPackageIdentifier;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.defaultPackageIdentifier;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.originProductIdentifier;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.destinationProductIdentifier;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.defaultProductIdentifier;
        int iHashCode15 = (iHashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.currentPackageIdentifier;
        int iHashCode16 = (iHashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.resultingPackageIdentifier;
        int iHashCode17 = (iHashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.currentProductIdentifier;
        int iHashCode18 = (iHashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.resultingProductIdentifier;
        return iHashCode18 + (str16 != null ? str16.hashCode() : 0);
    }

    public String toString() {
        return "BackendPaywallComponentFields(componentType=" + this.componentType + ", componentName=" + this.componentName + ", componentValue=" + this.componentValue + ", componentUrl=" + this.componentUrl + ", originIndex=" + this.originIndex + ", destinationIndex=" + this.destinationIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ", defaultIndex=" + this.defaultIndex + ", originPackageIdentifier=" + this.originPackageIdentifier + ", destinationPackageIdentifier=" + this.destinationPackageIdentifier + ", defaultPackageIdentifier=" + this.defaultPackageIdentifier + ", originProductIdentifier=" + this.originProductIdentifier + ", destinationProductIdentifier=" + this.destinationProductIdentifier + ", defaultProductIdentifier=" + this.defaultProductIdentifier + ", currentPackageIdentifier=" + this.currentPackageIdentifier + ", resultingPackageIdentifier=" + this.resultingPackageIdentifier + ", currentProductIdentifier=" + this.currentProductIdentifier + ", resultingProductIdentifier=" + this.resultingProductIdentifier + ')';
    }

    public BackendPaywallComponentFields(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.componentType = str;
        this.componentName = str2;
        this.componentValue = str3;
        this.componentUrl = str4;
        this.originIndex = num;
        this.destinationIndex = num2;
        this.originContextName = str5;
        this.destinationContextName = str6;
        this.defaultIndex = num3;
        this.originPackageIdentifier = str7;
        this.destinationPackageIdentifier = str8;
        this.defaultPackageIdentifier = str9;
        this.originProductIdentifier = str10;
        this.destinationProductIdentifier = str11;
        this.defaultProductIdentifier = str12;
        this.currentPackageIdentifier = str13;
        this.resultingPackageIdentifier = str14;
        this.currentProductIdentifier = str15;
        this.resultingProductIdentifier = str16;
    }

    public /* synthetic */ BackendPaywallComponentFields(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, String str6, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : num2, (i3 & 64) != 0 ? null : str5, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str6, (i3 & Function.MAX_NARGS) != 0 ? null : num3, (i3 & 512) != 0 ? null : str7, (i3 & 1024) != 0 ? null : str8, (i3 & 2048) != 0 ? null : str9, (i3 & 4096) != 0 ? null : str10, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str11, (i3 & 16384) != 0 ? null : str12, (i3 & 32768) != 0 ? null : str13, (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : str14, (i3 & 131072) != 0 ? null : str15, (i3 & 262144) != 0 ? null : str16);
    }
}
