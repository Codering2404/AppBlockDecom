package com.revenuecat.purchases.paywalls.events;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Serializable
public final class PaywallComponentInteractionData {
    private final String componentName;
    private final PaywallComponentType componentType;
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
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {PaywallComponentType.Companion.serializer(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PaywallComponentInteractionData> serializer() {
            return PaywallComponentInteractionData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    @Deprecated
    public /* synthetic */ PaywallComponentInteractionData(int i3, PaywallComponentType paywallComponentType, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, SerializationConstructorMarker serializationConstructorMarker) {
        if (5 != (i3 & 5)) {
            PluginExceptionsKt.b(i3, 5, PaywallComponentInteractionData$$serializer.INSTANCE.getDescriptor());
        }
        this.componentType = paywallComponentType;
        if ((i3 & 2) == 0) {
            this.componentName = null;
        } else {
            this.componentName = str;
        }
        this.componentValue = str2;
        if ((i3 & 8) == 0) {
            this.componentUrl = null;
        } else {
            this.componentUrl = str3;
        }
        if ((i3 & 16) == 0) {
            this.originIndex = null;
        } else {
            this.originIndex = num;
        }
        if ((i3 & 32) == 0) {
            this.destinationIndex = null;
        } else {
            this.destinationIndex = num2;
        }
        if ((i3 & 64) == 0) {
            this.originContextName = null;
        } else {
            this.originContextName = str4;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.destinationContextName = null;
        } else {
            this.destinationContextName = str5;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.defaultIndex = null;
        } else {
            this.defaultIndex = num3;
        }
        if ((i3 & 512) == 0) {
            this.originPackageIdentifier = null;
        } else {
            this.originPackageIdentifier = str6;
        }
        if ((i3 & 1024) == 0) {
            this.destinationPackageIdentifier = null;
        } else {
            this.destinationPackageIdentifier = str7;
        }
        if ((i3 & 2048) == 0) {
            this.defaultPackageIdentifier = null;
        } else {
            this.defaultPackageIdentifier = str8;
        }
        if ((i3 & 4096) == 0) {
            this.originProductIdentifier = null;
        } else {
            this.originProductIdentifier = str9;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.destinationProductIdentifier = null;
        } else {
            this.destinationProductIdentifier = str10;
        }
        if ((i3 & 16384) == 0) {
            this.defaultProductIdentifier = null;
        } else {
            this.defaultProductIdentifier = str11;
        }
        if ((32768 & i3) == 0) {
            this.currentPackageIdentifier = null;
        } else {
            this.currentPackageIdentifier = str12;
        }
        if ((65536 & i3) == 0) {
            this.resultingPackageIdentifier = null;
        } else {
            this.resultingPackageIdentifier = str13;
        }
        if ((131072 & i3) == 0) {
            this.currentProductIdentifier = null;
        } else {
            this.currentProductIdentifier = str14;
        }
        if ((i3 & 262144) == 0) {
            this.resultingProductIdentifier = null;
        } else {
            this.resultingProductIdentifier = str15;
        }
    }

    public static /* synthetic */ PaywallComponentInteractionData copy$default(PaywallComponentInteractionData paywallComponentInteractionData, PaywallComponentType paywallComponentType, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i3, Object obj) {
        String str16;
        String str17;
        PaywallComponentType paywallComponentType2 = (i3 & 1) != 0 ? paywallComponentInteractionData.componentType : paywallComponentType;
        String str18 = (i3 & 2) != 0 ? paywallComponentInteractionData.componentName : str;
        String str19 = (i3 & 4) != 0 ? paywallComponentInteractionData.componentValue : str2;
        String str20 = (i3 & 8) != 0 ? paywallComponentInteractionData.componentUrl : str3;
        Integer num4 = (i3 & 16) != 0 ? paywallComponentInteractionData.originIndex : num;
        Integer num5 = (i3 & 32) != 0 ? paywallComponentInteractionData.destinationIndex : num2;
        String str21 = (i3 & 64) != 0 ? paywallComponentInteractionData.originContextName : str4;
        String str22 = (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywallComponentInteractionData.destinationContextName : str5;
        Integer num6 = (i3 & Function.MAX_NARGS) != 0 ? paywallComponentInteractionData.defaultIndex : num3;
        String str23 = (i3 & 512) != 0 ? paywallComponentInteractionData.originPackageIdentifier : str6;
        String str24 = (i3 & 1024) != 0 ? paywallComponentInteractionData.destinationPackageIdentifier : str7;
        String str25 = (i3 & 2048) != 0 ? paywallComponentInteractionData.defaultPackageIdentifier : str8;
        String str26 = (i3 & 4096) != 0 ? paywallComponentInteractionData.originProductIdentifier : str9;
        String str27 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywallComponentInteractionData.destinationProductIdentifier : str10;
        PaywallComponentType paywallComponentType3 = paywallComponentType2;
        String str28 = (i3 & 16384) != 0 ? paywallComponentInteractionData.defaultProductIdentifier : str11;
        String str29 = (i3 & 32768) != 0 ? paywallComponentInteractionData.currentPackageIdentifier : str12;
        String str30 = (i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywallComponentInteractionData.resultingPackageIdentifier : str13;
        String str31 = (i3 & 131072) != 0 ? paywallComponentInteractionData.currentProductIdentifier : str14;
        if ((i3 & 262144) != 0) {
            str17 = str31;
            str16 = paywallComponentInteractionData.resultingProductIdentifier;
        } else {
            str16 = str15;
            str17 = str31;
        }
        return paywallComponentInteractionData.copy(paywallComponentType3, str18, str19, str20, num4, num5, str21, str22, num6, str23, str24, str25, str26, str27, str28, str29, str30, str17, str16);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PaywallComponentInteractionData paywallComponentInteractionData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], paywallComponentInteractionData.componentType);
        if (compositeEncoder.z(serialDescriptor, 1) || paywallComponentInteractionData.componentName != null) {
            compositeEncoder.i(serialDescriptor, 1, StringSerializer.f142891a, paywallComponentInteractionData.componentName);
        }
        compositeEncoder.y(serialDescriptor, 2, paywallComponentInteractionData.componentValue);
        if (compositeEncoder.z(serialDescriptor, 3) || paywallComponentInteractionData.componentUrl != null) {
            compositeEncoder.i(serialDescriptor, 3, StringSerializer.f142891a, paywallComponentInteractionData.componentUrl);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || paywallComponentInteractionData.originIndex != null) {
            compositeEncoder.i(serialDescriptor, 4, IntSerializer.f142823a, paywallComponentInteractionData.originIndex);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || paywallComponentInteractionData.destinationIndex != null) {
            compositeEncoder.i(serialDescriptor, 5, IntSerializer.f142823a, paywallComponentInteractionData.destinationIndex);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || paywallComponentInteractionData.originContextName != null) {
            compositeEncoder.i(serialDescriptor, 6, StringSerializer.f142891a, paywallComponentInteractionData.originContextName);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || paywallComponentInteractionData.destinationContextName != null) {
            compositeEncoder.i(serialDescriptor, 7, StringSerializer.f142891a, paywallComponentInteractionData.destinationContextName);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || paywallComponentInteractionData.defaultIndex != null) {
            compositeEncoder.i(serialDescriptor, 8, IntSerializer.f142823a, paywallComponentInteractionData.defaultIndex);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || paywallComponentInteractionData.originPackageIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 9, StringSerializer.f142891a, paywallComponentInteractionData.originPackageIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || paywallComponentInteractionData.destinationPackageIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 10, StringSerializer.f142891a, paywallComponentInteractionData.destinationPackageIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || paywallComponentInteractionData.defaultPackageIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 11, StringSerializer.f142891a, paywallComponentInteractionData.defaultPackageIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || paywallComponentInteractionData.originProductIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 12, StringSerializer.f142891a, paywallComponentInteractionData.originProductIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 13) || paywallComponentInteractionData.destinationProductIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 13, StringSerializer.f142891a, paywallComponentInteractionData.destinationProductIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 14) || paywallComponentInteractionData.defaultProductIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 14, StringSerializer.f142891a, paywallComponentInteractionData.defaultProductIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 15) || paywallComponentInteractionData.currentPackageIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 15, StringSerializer.f142891a, paywallComponentInteractionData.currentPackageIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 16) || paywallComponentInteractionData.resultingPackageIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 16, StringSerializer.f142891a, paywallComponentInteractionData.resultingPackageIdentifier);
        }
        if (compositeEncoder.z(serialDescriptor, 17) || paywallComponentInteractionData.currentProductIdentifier != null) {
            compositeEncoder.i(serialDescriptor, 17, StringSerializer.f142891a, paywallComponentInteractionData.currentProductIdentifier);
        }
        if (!compositeEncoder.z(serialDescriptor, 18) && paywallComponentInteractionData.resultingProductIdentifier == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 18, StringSerializer.f142891a, paywallComponentInteractionData.resultingProductIdentifier);
    }

    public final PaywallComponentType component1() {
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

    public final PaywallComponentInteractionData copy(PaywallComponentType componentType, String str, String componentValue, String str2, Integer num, Integer num2, String str3, String str4, Integer num3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(componentValue, "componentValue");
        return new PaywallComponentInteractionData(componentType, str, componentValue, str2, num, num2, str3, str4, num3, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentInteractionData)) {
            return false;
        }
        PaywallComponentInteractionData paywallComponentInteractionData = (PaywallComponentInteractionData) obj;
        return this.componentType == paywallComponentInteractionData.componentType && Intrinsics.areEqual(this.componentName, paywallComponentInteractionData.componentName) && Intrinsics.areEqual(this.componentValue, paywallComponentInteractionData.componentValue) && Intrinsics.areEqual(this.componentUrl, paywallComponentInteractionData.componentUrl) && Intrinsics.areEqual(this.originIndex, paywallComponentInteractionData.originIndex) && Intrinsics.areEqual(this.destinationIndex, paywallComponentInteractionData.destinationIndex) && Intrinsics.areEqual(this.originContextName, paywallComponentInteractionData.originContextName) && Intrinsics.areEqual(this.destinationContextName, paywallComponentInteractionData.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, paywallComponentInteractionData.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, paywallComponentInteractionData.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, paywallComponentInteractionData.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, paywallComponentInteractionData.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, paywallComponentInteractionData.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, paywallComponentInteractionData.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, paywallComponentInteractionData.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, paywallComponentInteractionData.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, paywallComponentInteractionData.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, paywallComponentInteractionData.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, paywallComponentInteractionData.resultingProductIdentifier);
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final PaywallComponentType getComponentType() {
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
        int iHashCode = this.componentType.hashCode() * 31;
        String str = this.componentName;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.componentValue.hashCode()) * 31;
        String str2 = this.componentUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.originIndex;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.destinationIndex;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.originContextName;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.destinationContextName;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num3 = this.defaultIndex;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str5 = this.originPackageIdentifier;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.destinationPackageIdentifier;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.defaultPackageIdentifier;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.originProductIdentifier;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.destinationProductIdentifier;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.defaultProductIdentifier;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.currentPackageIdentifier;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.resultingPackageIdentifier;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.currentProductIdentifier;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.resultingProductIdentifier;
        return iHashCode17 + (str14 != null ? str14.hashCode() : 0);
    }

    public PaywallComponentInteractionData(PaywallComponentType componentType, String str, String componentValue, String str2, Integer num, Integer num2, String str3, String str4, Integer num3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(componentValue, "componentValue");
        this.componentType = componentType;
        this.componentName = str;
        this.componentValue = componentValue;
        this.componentUrl = str2;
        this.originIndex = num;
        this.destinationIndex = num2;
        this.originContextName = str3;
        this.destinationContextName = str4;
        this.defaultIndex = num3;
        this.originPackageIdentifier = str5;
        this.destinationPackageIdentifier = str6;
        this.defaultPackageIdentifier = str7;
        this.originProductIdentifier = str8;
        this.destinationProductIdentifier = str9;
        this.defaultProductIdentifier = str10;
        this.currentPackageIdentifier = str11;
        this.resultingPackageIdentifier = str12;
        this.currentProductIdentifier = str13;
        this.resultingProductIdentifier = str14;
    }

    public String toString() {
        return "PaywallComponentInteractionData(componentType=" + this.componentType + ", componentName=" + this.componentName + ", componentValue=" + this.componentValue + ", componentUrl=" + this.componentUrl + ", originIndex=" + this.originIndex + ", destinationIndex=" + this.destinationIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ", defaultIndex=" + this.defaultIndex + ", originPackageIdentifier=" + this.originPackageIdentifier + ", destinationPackageIdentifier=" + this.destinationPackageIdentifier + ", defaultPackageIdentifier=" + this.defaultPackageIdentifier + ", originProductIdentifier=" + this.originProductIdentifier + ", destinationProductIdentifier=" + this.destinationProductIdentifier + ", defaultProductIdentifier=" + this.defaultProductIdentifier + ", currentPackageIdentifier=" + this.currentPackageIdentifier + ", resultingPackageIdentifier=" + this.resultingPackageIdentifier + rnFwbPAQmQTnL.JbpbZZZ + this.currentProductIdentifier + ", resultingProductIdentifier=" + this.resultingProductIdentifier + ')';
    }

    public /* synthetic */ PaywallComponentInteractionData(PaywallComponentType paywallComponentType, String str, String str2, String str3, Integer num, Integer num2, String str4, String str5, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(paywallComponentType, (i3 & 2) != 0 ? null : str, str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : num2, (i3 & 64) != 0 ? null : str4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str5, (i3 & Function.MAX_NARGS) != 0 ? null : num3, (i3 & 512) != 0 ? null : str6, (i3 & 1024) != 0 ? null : str7, (i3 & 2048) != 0 ? null : str8, (i3 & 4096) != 0 ? null : str9, (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str10, (i3 & 16384) != 0 ? null : str11, (32768 & i3) != 0 ? null : str12, (65536 & i3) != 0 ? null : str13, (131072 & i3) != 0 ? null : str14, (i3 & 262144) != 0 ? null : str15);
    }
}
