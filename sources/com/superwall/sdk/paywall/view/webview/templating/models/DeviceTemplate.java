package com.superwall.sdk.paywall.view.webview.templating.models;

import com.superwall.sdk.storage.core_data.ConvertersKt;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class DeviceTemplate {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final List<String> activeEntitlements;
    private final List<Map<String, String>> activeEntitlementsObject;
    private final List<String> activeProducts;
    private final List<String> aliases;
    private final String appBuildString;
    private final Integer appBuildStringNumber;
    private final String appInstallDate;
    private final String appUserId;
    private final String appVersion;
    private final String appVersionPadded;
    private final String bundleId;
    private final List<String> capabilities;
    private final JsonElement capabilitiesConfig;
    private final int daysSinceInstall;
    private final Integer daysSinceLastPaywallView;
    private final String deviceCurrencyCode;
    private final String deviceCurrencySymbol;
    private final String deviceId;
    private final String deviceLanguageCode;
    private final String deviceLocale;
    private final String deviceModel;
    private final String deviceTier;
    private final float fontScale;
    private final int fontSize;
    private final String interfaceStyle;
    private final String interfaceStyleMode;
    private final boolean isFirstAppOpen;
    private final boolean isLowPowerModeEnabled;
    private final boolean isMac;
    private final String isSandbox;
    private final String kotlinVersion;
    private final String localDate;
    private final String localDateTime;
    private final String localTime;
    private final int minutesSinceInstall;
    private final Integer minutesSinceLastPaywallView;
    private final String osVersion;
    private final String platform;
    private final String platformWrapper;
    private final String platformWrapperVersion;
    private final String preferredLanguageCode;
    private final String preferredLocale;
    private final String preferredRegionCode;
    private final String publicApiKey;
    private final String radioType;
    private final String regionCode;
    private final int reviewRequestCount;
    private final String sdkVersion;
    private final String sdkVersionPadded;
    private final String storeFrontCountryCode;
    private final String subscriptionStatus;
    private final int timezoneOffset;
    private final int totalPaywallViews;
    private final String utcDate;
    private final String utcDateTime;
    private final String utcTime;
    private final String vendorId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<DeviceTemplate> serializer() {
            return DeviceTemplate$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        $childSerializers = new KSerializer[]{null, null, null, new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(stringSerializer), new ArrayListSerializer(new LinkedHashMapSerializer(stringSerializer, stringSerializer)), null, new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, null};
    }

    public /* synthetic */ DeviceTemplate(int i3, int i4, String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i5, String str18, String str19, int i6, float f3, boolean z2, String str20, String str21, boolean z3, int i7, int i8, Integer num, Integer num2, int i9, String str22, String str23, String str24, String str25, String str26, String str27, String str28, List list2, List list3, String str29, List list4, boolean z4, String str30, String str31, String str32, Integer num3, String str33, List list5, JsonElement jsonElement, String str34, String str35, String str36, int i10, String str37, String str38, SerializationConstructorMarker serializationConstructorMarker) {
        if ((16777215 != (i4 & 16777215)) | (-1 != i3)) {
            PluginExceptionsKt.a(new int[]{i3, i4}, new int[]{-1, 16777215}, DeviceTemplate$$serializer.INSTANCE.getDescriptor());
        }
        this.publicApiKey = str;
        this.platform = str2;
        this.appUserId = str3;
        this.aliases = list;
        this.vendorId = str4;
        this.deviceId = str5;
        this.appVersion = str6;
        this.appVersionPadded = str7;
        this.osVersion = str8;
        this.deviceModel = str9;
        this.deviceLocale = str10;
        this.preferredLocale = str11;
        this.deviceLanguageCode = str12;
        this.preferredLanguageCode = str13;
        this.regionCode = str14;
        this.preferredRegionCode = str15;
        this.deviceCurrencyCode = str16;
        this.deviceCurrencySymbol = str17;
        this.timezoneOffset = i5;
        this.radioType = str18;
        this.interfaceStyle = str19;
        this.fontSize = i6;
        this.fontScale = f3;
        this.isLowPowerModeEnabled = z2;
        this.bundleId = str20;
        this.appInstallDate = str21;
        this.isMac = z3;
        this.daysSinceInstall = i7;
        this.minutesSinceInstall = i8;
        this.daysSinceLastPaywallView = num;
        this.minutesSinceLastPaywallView = num2;
        this.totalPaywallViews = i9;
        this.utcDate = str22;
        this.localDate = str23;
        this.utcTime = str24;
        this.localTime = str25;
        this.utcDateTime = str26;
        this.localDateTime = str27;
        this.isSandbox = str28;
        this.activeEntitlements = list2;
        this.activeEntitlementsObject = list3;
        this.subscriptionStatus = str29;
        this.activeProducts = list4;
        this.isFirstAppOpen = z4;
        this.sdkVersion = str30;
        this.sdkVersionPadded = str31;
        this.appBuildString = str32;
        this.appBuildStringNumber = num3;
        this.interfaceStyleMode = str33;
        this.capabilities = list5;
        this.capabilitiesConfig = jsonElement;
        this.platformWrapper = str34;
        this.platformWrapperVersion = str35;
        this.deviceTier = str36;
        this.reviewRequestCount = i10;
        this.kotlinVersion = str37;
        this.storeFrontCountryCode = (16777216 & i4) == 0 ? null : str38;
    }

    @SerialName
    public static /* synthetic */ void getCapabilities$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getCapabilitiesConfig$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPlatformWrapper$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPlatformWrapperVersion$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(DeviceTemplate deviceTemplate, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, deviceTemplate.publicApiKey);
        compositeEncoder.y(serialDescriptor, 1, deviceTemplate.platform);
        compositeEncoder.y(serialDescriptor, 2, deviceTemplate.appUserId);
        compositeEncoder.C(serialDescriptor, 3, kSerializerArr[3], deviceTemplate.aliases);
        compositeEncoder.y(serialDescriptor, 4, deviceTemplate.vendorId);
        compositeEncoder.y(serialDescriptor, 5, deviceTemplate.deviceId);
        compositeEncoder.y(serialDescriptor, 6, deviceTemplate.appVersion);
        compositeEncoder.y(serialDescriptor, 7, deviceTemplate.appVersionPadded);
        compositeEncoder.y(serialDescriptor, 8, deviceTemplate.osVersion);
        compositeEncoder.y(serialDescriptor, 9, deviceTemplate.deviceModel);
        compositeEncoder.y(serialDescriptor, 10, deviceTemplate.deviceLocale);
        compositeEncoder.y(serialDescriptor, 11, deviceTemplate.preferredLocale);
        compositeEncoder.y(serialDescriptor, 12, deviceTemplate.deviceLanguageCode);
        compositeEncoder.y(serialDescriptor, 13, deviceTemplate.preferredLanguageCode);
        compositeEncoder.y(serialDescriptor, 14, deviceTemplate.regionCode);
        compositeEncoder.y(serialDescriptor, 15, deviceTemplate.preferredRegionCode);
        compositeEncoder.y(serialDescriptor, 16, deviceTemplate.deviceCurrencyCode);
        compositeEncoder.y(serialDescriptor, 17, deviceTemplate.deviceCurrencySymbol);
        compositeEncoder.w(serialDescriptor, 18, deviceTemplate.timezoneOffset);
        compositeEncoder.y(serialDescriptor, 19, deviceTemplate.radioType);
        compositeEncoder.y(serialDescriptor, 20, deviceTemplate.interfaceStyle);
        compositeEncoder.w(serialDescriptor, 21, deviceTemplate.fontSize);
        compositeEncoder.s(serialDescriptor, 22, deviceTemplate.fontScale);
        compositeEncoder.x(serialDescriptor, 23, deviceTemplate.isLowPowerModeEnabled);
        compositeEncoder.y(serialDescriptor, 24, deviceTemplate.bundleId);
        compositeEncoder.y(serialDescriptor, 25, deviceTemplate.appInstallDate);
        compositeEncoder.x(serialDescriptor, 26, deviceTemplate.isMac);
        compositeEncoder.w(serialDescriptor, 27, deviceTemplate.daysSinceInstall);
        compositeEncoder.w(serialDescriptor, 28, deviceTemplate.minutesSinceInstall);
        IntSerializer intSerializer = IntSerializer.f142823a;
        compositeEncoder.i(serialDescriptor, 29, intSerializer, deviceTemplate.daysSinceLastPaywallView);
        compositeEncoder.i(serialDescriptor, 30, intSerializer, deviceTemplate.minutesSinceLastPaywallView);
        compositeEncoder.w(serialDescriptor, 31, deviceTemplate.totalPaywallViews);
        compositeEncoder.y(serialDescriptor, 32, deviceTemplate.utcDate);
        compositeEncoder.y(serialDescriptor, 33, deviceTemplate.localDate);
        compositeEncoder.y(serialDescriptor, 34, deviceTemplate.utcTime);
        compositeEncoder.y(serialDescriptor, 35, deviceTemplate.localTime);
        compositeEncoder.y(serialDescriptor, 36, deviceTemplate.utcDateTime);
        compositeEncoder.y(serialDescriptor, 37, deviceTemplate.localDateTime);
        compositeEncoder.y(serialDescriptor, 38, deviceTemplate.isSandbox);
        compositeEncoder.C(serialDescriptor, 39, kSerializerArr[39], deviceTemplate.activeEntitlements);
        compositeEncoder.C(serialDescriptor, 40, kSerializerArr[40], deviceTemplate.activeEntitlementsObject);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        compositeEncoder.i(serialDescriptor, 41, stringSerializer, deviceTemplate.subscriptionStatus);
        compositeEncoder.C(serialDescriptor, 42, kSerializerArr[42], deviceTemplate.activeProducts);
        compositeEncoder.x(serialDescriptor, 43, deviceTemplate.isFirstAppOpen);
        compositeEncoder.y(serialDescriptor, 44, deviceTemplate.sdkVersion);
        compositeEncoder.y(serialDescriptor, 45, deviceTemplate.sdkVersionPadded);
        compositeEncoder.y(serialDescriptor, 46, deviceTemplate.appBuildString);
        compositeEncoder.i(serialDescriptor, 47, intSerializer, deviceTemplate.appBuildStringNumber);
        compositeEncoder.y(serialDescriptor, 48, deviceTemplate.interfaceStyleMode);
        compositeEncoder.C(serialDescriptor, 49, kSerializerArr[49], deviceTemplate.capabilities);
        compositeEncoder.C(serialDescriptor, 50, JsonElementSerializer.f143009a, deviceTemplate.capabilitiesConfig);
        compositeEncoder.y(serialDescriptor, 51, deviceTemplate.platformWrapper);
        compositeEncoder.y(serialDescriptor, 52, deviceTemplate.platformWrapperVersion);
        compositeEncoder.y(serialDescriptor, 53, deviceTemplate.deviceTier);
        compositeEncoder.w(serialDescriptor, 54, deviceTemplate.reviewRequestCount);
        compositeEncoder.y(serialDescriptor, 55, deviceTemplate.kotlinVersion);
        if (!compositeEncoder.z(serialDescriptor, 56) && deviceTemplate.storeFrontCountryCode == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 56, stringSerializer, deviceTemplate.storeFrontCountryCode);
    }

    public final String component1() {
        return this.publicApiKey;
    }

    public final String component10() {
        return this.deviceModel;
    }

    public final String component11() {
        return this.deviceLocale;
    }

    public final String component12() {
        return this.preferredLocale;
    }

    public final String component13() {
        return this.deviceLanguageCode;
    }

    public final String component14() {
        return this.preferredLanguageCode;
    }

    public final String component15() {
        return this.regionCode;
    }

    public final String component16() {
        return this.preferredRegionCode;
    }

    public final String component17() {
        return this.deviceCurrencyCode;
    }

    public final String component18() {
        return this.deviceCurrencySymbol;
    }

    public final int component19() {
        return this.timezoneOffset;
    }

    public final String component2() {
        return this.platform;
    }

    public final String component20() {
        return this.radioType;
    }

    public final String component21() {
        return this.interfaceStyle;
    }

    public final int component22() {
        return this.fontSize;
    }

    public final float component23() {
        return this.fontScale;
    }

    public final boolean component24() {
        return this.isLowPowerModeEnabled;
    }

    public final String component25() {
        return this.bundleId;
    }

    public final String component26() {
        return this.appInstallDate;
    }

    public final boolean component27() {
        return this.isMac;
    }

    public final int component28() {
        return this.daysSinceInstall;
    }

    public final int component29() {
        return this.minutesSinceInstall;
    }

    public final String component3() {
        return this.appUserId;
    }

    public final Integer component30() {
        return this.daysSinceLastPaywallView;
    }

    public final Integer component31() {
        return this.minutesSinceLastPaywallView;
    }

    public final int component32() {
        return this.totalPaywallViews;
    }

    public final String component33() {
        return this.utcDate;
    }

    public final String component34() {
        return this.localDate;
    }

    public final String component35() {
        return this.utcTime;
    }

    public final String component36() {
        return this.localTime;
    }

    public final String component37() {
        return this.utcDateTime;
    }

    public final String component38() {
        return this.localDateTime;
    }

    public final String component39() {
        return this.isSandbox;
    }

    public final List<String> component4() {
        return this.aliases;
    }

    public final List<String> component40() {
        return this.activeEntitlements;
    }

    public final List<Map<String, String>> component41() {
        return this.activeEntitlementsObject;
    }

    public final String component42() {
        return this.subscriptionStatus;
    }

    public final List<String> component43() {
        return this.activeProducts;
    }

    public final boolean component44() {
        return this.isFirstAppOpen;
    }

    public final String component45() {
        return this.sdkVersion;
    }

    public final String component46() {
        return this.sdkVersionPadded;
    }

    public final String component47() {
        return this.appBuildString;
    }

    public final Integer component48() {
        return this.appBuildStringNumber;
    }

    public final String component49() {
        return this.interfaceStyleMode;
    }

    public final String component5() {
        return this.vendorId;
    }

    public final List<String> component50() {
        return this.capabilities;
    }

    public final JsonElement component51() {
        return this.capabilitiesConfig;
    }

    public final String component52() {
        return this.platformWrapper;
    }

    public final String component53() {
        return this.platformWrapperVersion;
    }

    public final String component54() {
        return this.deviceTier;
    }

    public final int component55() {
        return this.reviewRequestCount;
    }

    public final String component56() {
        return this.kotlinVersion;
    }

    public final String component57() {
        return this.storeFrontCountryCode;
    }

    public final String component6() {
        return this.deviceId;
    }

    public final String component7() {
        return this.appVersion;
    }

    public final String component8() {
        return this.appVersionPadded;
    }

    public final String component9() {
        return this.osVersion;
    }

    public final DeviceTemplate copy(String publicApiKey, String platform, String appUserId, List<String> aliases, String vendorId, String deviceId, String appVersion, String appVersionPadded, String osVersion, String deviceModel, String deviceLocale, String preferredLocale, String deviceLanguageCode, String preferredLanguageCode, String regionCode, String preferredRegionCode, String deviceCurrencyCode, String deviceCurrencySymbol, int i3, String radioType, String interfaceStyle, int i4, float f3, boolean z2, String bundleId, String appInstallDate, boolean z3, int i5, int i6, Integer num, Integer num2, int i7, String utcDate, String localDate, String utcTime, String localTime, String utcDateTime, String localDateTime, String isSandbox, List<String> activeEntitlements, List<? extends Map<String, String>> activeEntitlementsObject, String str, List<String> activeProducts, boolean z4, String sdkVersion, String sdkVersionPadded, String appBuildString, Integer num3, String interfaceStyleMode, List<String> capabilities, JsonElement capabilitiesConfig, String platformWrapper, String platformWrapperVersion, String deviceTier, int i8, String kotlinVersion, String str2) {
        Intrinsics.checkNotNullParameter(publicApiKey, "publicApiKey");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appVersionPadded, "appVersionPadded");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceLocale, "deviceLocale");
        Intrinsics.checkNotNullParameter(preferredLocale, "preferredLocale");
        Intrinsics.checkNotNullParameter(deviceLanguageCode, "deviceLanguageCode");
        Intrinsics.checkNotNullParameter(preferredLanguageCode, "preferredLanguageCode");
        Intrinsics.checkNotNullParameter(regionCode, "regionCode");
        Intrinsics.checkNotNullParameter(preferredRegionCode, "preferredRegionCode");
        Intrinsics.checkNotNullParameter(deviceCurrencyCode, "deviceCurrencyCode");
        Intrinsics.checkNotNullParameter(deviceCurrencySymbol, "deviceCurrencySymbol");
        Intrinsics.checkNotNullParameter(radioType, "radioType");
        Intrinsics.checkNotNullParameter(interfaceStyle, "interfaceStyle");
        Intrinsics.checkNotNullParameter(bundleId, "bundleId");
        Intrinsics.checkNotNullParameter(appInstallDate, "appInstallDate");
        Intrinsics.checkNotNullParameter(utcDate, "utcDate");
        Intrinsics.checkNotNullParameter(localDate, "localDate");
        Intrinsics.checkNotNullParameter(utcTime, "utcTime");
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        Intrinsics.checkNotNullParameter(utcDateTime, "utcDateTime");
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        Intrinsics.checkNotNullParameter(isSandbox, "isSandbox");
        Intrinsics.checkNotNullParameter(activeEntitlements, "activeEntitlements");
        Intrinsics.checkNotNullParameter(activeEntitlementsObject, "activeEntitlementsObject");
        Intrinsics.checkNotNullParameter(activeProducts, "activeProducts");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(sdkVersionPadded, "sdkVersionPadded");
        Intrinsics.checkNotNullParameter(appBuildString, "appBuildString");
        Intrinsics.checkNotNullParameter(interfaceStyleMode, "interfaceStyleMode");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(capabilitiesConfig, "capabilitiesConfig");
        Intrinsics.checkNotNullParameter(platformWrapper, "platformWrapper");
        Intrinsics.checkNotNullParameter(platformWrapperVersion, "platformWrapperVersion");
        Intrinsics.checkNotNullParameter(deviceTier, "deviceTier");
        Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
        return new DeviceTemplate(publicApiKey, platform, appUserId, aliases, vendorId, deviceId, appVersion, appVersionPadded, osVersion, deviceModel, deviceLocale, preferredLocale, deviceLanguageCode, preferredLanguageCode, regionCode, preferredRegionCode, deviceCurrencyCode, deviceCurrencySymbol, i3, radioType, interfaceStyle, i4, f3, z2, bundleId, appInstallDate, z3, i5, i6, num, num2, i7, utcDate, localDate, utcTime, localTime, utcDateTime, localDateTime, isSandbox, activeEntitlements, activeEntitlementsObject, str, activeProducts, z4, sdkVersion, sdkVersionPadded, appBuildString, num3, interfaceStyleMode, capabilities, capabilitiesConfig, platformWrapper, platformWrapperVersion, deviceTier, i8, kotlinVersion, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceTemplate)) {
            return false;
        }
        DeviceTemplate deviceTemplate = (DeviceTemplate) obj;
        return Intrinsics.areEqual(this.publicApiKey, deviceTemplate.publicApiKey) && Intrinsics.areEqual(this.platform, deviceTemplate.platform) && Intrinsics.areEqual(this.appUserId, deviceTemplate.appUserId) && Intrinsics.areEqual(this.aliases, deviceTemplate.aliases) && Intrinsics.areEqual(this.vendorId, deviceTemplate.vendorId) && Intrinsics.areEqual(this.deviceId, deviceTemplate.deviceId) && Intrinsics.areEqual(this.appVersion, deviceTemplate.appVersion) && Intrinsics.areEqual(this.appVersionPadded, deviceTemplate.appVersionPadded) && Intrinsics.areEqual(this.osVersion, deviceTemplate.osVersion) && Intrinsics.areEqual(this.deviceModel, deviceTemplate.deviceModel) && Intrinsics.areEqual(this.deviceLocale, deviceTemplate.deviceLocale) && Intrinsics.areEqual(this.preferredLocale, deviceTemplate.preferredLocale) && Intrinsics.areEqual(this.deviceLanguageCode, deviceTemplate.deviceLanguageCode) && Intrinsics.areEqual(this.preferredLanguageCode, deviceTemplate.preferredLanguageCode) && Intrinsics.areEqual(this.regionCode, deviceTemplate.regionCode) && Intrinsics.areEqual(this.preferredRegionCode, deviceTemplate.preferredRegionCode) && Intrinsics.areEqual(this.deviceCurrencyCode, deviceTemplate.deviceCurrencyCode) && Intrinsics.areEqual(this.deviceCurrencySymbol, deviceTemplate.deviceCurrencySymbol) && this.timezoneOffset == deviceTemplate.timezoneOffset && Intrinsics.areEqual(this.radioType, deviceTemplate.radioType) && Intrinsics.areEqual(this.interfaceStyle, deviceTemplate.interfaceStyle) && this.fontSize == deviceTemplate.fontSize && Float.compare(this.fontScale, deviceTemplate.fontScale) == 0 && this.isLowPowerModeEnabled == deviceTemplate.isLowPowerModeEnabled && Intrinsics.areEqual(this.bundleId, deviceTemplate.bundleId) && Intrinsics.areEqual(this.appInstallDate, deviceTemplate.appInstallDate) && this.isMac == deviceTemplate.isMac && this.daysSinceInstall == deviceTemplate.daysSinceInstall && this.minutesSinceInstall == deviceTemplate.minutesSinceInstall && Intrinsics.areEqual(this.daysSinceLastPaywallView, deviceTemplate.daysSinceLastPaywallView) && Intrinsics.areEqual(this.minutesSinceLastPaywallView, deviceTemplate.minutesSinceLastPaywallView) && this.totalPaywallViews == deviceTemplate.totalPaywallViews && Intrinsics.areEqual(this.utcDate, deviceTemplate.utcDate) && Intrinsics.areEqual(this.localDate, deviceTemplate.localDate) && Intrinsics.areEqual(this.utcTime, deviceTemplate.utcTime) && Intrinsics.areEqual(this.localTime, deviceTemplate.localTime) && Intrinsics.areEqual(this.utcDateTime, deviceTemplate.utcDateTime) && Intrinsics.areEqual(this.localDateTime, deviceTemplate.localDateTime) && Intrinsics.areEqual(this.isSandbox, deviceTemplate.isSandbox) && Intrinsics.areEqual(this.activeEntitlements, deviceTemplate.activeEntitlements) && Intrinsics.areEqual(this.activeEntitlementsObject, deviceTemplate.activeEntitlementsObject) && Intrinsics.areEqual(this.subscriptionStatus, deviceTemplate.subscriptionStatus) && Intrinsics.areEqual(this.activeProducts, deviceTemplate.activeProducts) && this.isFirstAppOpen == deviceTemplate.isFirstAppOpen && Intrinsics.areEqual(this.sdkVersion, deviceTemplate.sdkVersion) && Intrinsics.areEqual(this.sdkVersionPadded, deviceTemplate.sdkVersionPadded) && Intrinsics.areEqual(this.appBuildString, deviceTemplate.appBuildString) && Intrinsics.areEqual(this.appBuildStringNumber, deviceTemplate.appBuildStringNumber) && Intrinsics.areEqual(this.interfaceStyleMode, deviceTemplate.interfaceStyleMode) && Intrinsics.areEqual(this.capabilities, deviceTemplate.capabilities) && Intrinsics.areEqual(this.capabilitiesConfig, deviceTemplate.capabilitiesConfig) && Intrinsics.areEqual(this.platformWrapper, deviceTemplate.platformWrapper) && Intrinsics.areEqual(this.platformWrapperVersion, deviceTemplate.platformWrapperVersion) && Intrinsics.areEqual(this.deviceTier, deviceTemplate.deviceTier) && this.reviewRequestCount == deviceTemplate.reviewRequestCount && Intrinsics.areEqual(this.kotlinVersion, deviceTemplate.kotlinVersion) && Intrinsics.areEqual(this.storeFrontCountryCode, deviceTemplate.storeFrontCountryCode);
    }

    public final List<String> getActiveEntitlements() {
        return this.activeEntitlements;
    }

    public final List<Map<String, String>> getActiveEntitlementsObject() {
        return this.activeEntitlementsObject;
    }

    public final List<String> getActiveProducts() {
        return this.activeProducts;
    }

    public final List<String> getAliases() {
        return this.aliases;
    }

    public final String getAppBuildString() {
        return this.appBuildString;
    }

    public final Integer getAppBuildStringNumber() {
        return this.appBuildStringNumber;
    }

    public final String getAppInstallDate() {
        return this.appInstallDate;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAppVersionPadded() {
        return this.appVersionPadded;
    }

    public final String getBundleId() {
        return this.bundleId;
    }

    public final List<String> getCapabilities() {
        return this.capabilities;
    }

    public final JsonElement getCapabilitiesConfig() {
        return this.capabilitiesConfig;
    }

    public final int getDaysSinceInstall() {
        return this.daysSinceInstall;
    }

    public final Integer getDaysSinceLastPaywallView() {
        return this.daysSinceLastPaywallView;
    }

    public final String getDeviceCurrencyCode() {
        return this.deviceCurrencyCode;
    }

    public final String getDeviceCurrencySymbol() {
        return this.deviceCurrencySymbol;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceLanguageCode() {
        return this.deviceLanguageCode;
    }

    public final String getDeviceLocale() {
        return this.deviceLocale;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDeviceTier() {
        return this.deviceTier;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final String getInterfaceStyle() {
        return this.interfaceStyle;
    }

    public final String getInterfaceStyleMode() {
        return this.interfaceStyleMode;
    }

    public final String getKotlinVersion() {
        return this.kotlinVersion;
    }

    public final String getLocalDate() {
        return this.localDate;
    }

    public final String getLocalDateTime() {
        return this.localDateTime;
    }

    public final String getLocalTime() {
        return this.localTime;
    }

    public final int getMinutesSinceInstall() {
        return this.minutesSinceInstall;
    }

    public final Integer getMinutesSinceLastPaywallView() {
        return this.minutesSinceLastPaywallView;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getPlatformWrapper() {
        return this.platformWrapper;
    }

    public final String getPlatformWrapperVersion() {
        return this.platformWrapperVersion;
    }

    public final String getPreferredLanguageCode() {
        return this.preferredLanguageCode;
    }

    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    public final String getPreferredRegionCode() {
        return this.preferredRegionCode;
    }

    public final String getPublicApiKey() {
        return this.publicApiKey;
    }

    public final String getRadioType() {
        return this.radioType;
    }

    public final String getRegionCode() {
        return this.regionCode;
    }

    public final int getReviewRequestCount() {
        return this.reviewRequestCount;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getSdkVersionPadded() {
        return this.sdkVersionPadded;
    }

    public final String getStoreFrontCountryCode() {
        return this.storeFrontCountryCode;
    }

    public final String getSubscriptionStatus() {
        return this.subscriptionStatus;
    }

    public final int getTimezoneOffset() {
        return this.timezoneOffset;
    }

    public final int getTotalPaywallViews() {
        return this.totalPaywallViews;
    }

    public final String getUtcDate() {
        return this.utcDate;
    }

    public final String getUtcDateTime() {
        return this.utcDateTime;
    }

    public final String getUtcTime() {
        return this.utcTime;
    }

    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.publicApiKey.hashCode() * 31) + this.platform.hashCode()) * 31) + this.appUserId.hashCode()) * 31) + this.aliases.hashCode()) * 31) + this.vendorId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.appVersionPadded.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.deviceLocale.hashCode()) * 31) + this.preferredLocale.hashCode()) * 31) + this.deviceLanguageCode.hashCode()) * 31) + this.preferredLanguageCode.hashCode()) * 31) + this.regionCode.hashCode()) * 31) + this.preferredRegionCode.hashCode()) * 31) + this.deviceCurrencyCode.hashCode()) * 31) + this.deviceCurrencySymbol.hashCode()) * 31) + Integer.hashCode(this.timezoneOffset)) * 31) + this.radioType.hashCode()) * 31) + this.interfaceStyle.hashCode()) * 31) + Integer.hashCode(this.fontSize)) * 31) + Float.hashCode(this.fontScale)) * 31) + Boolean.hashCode(this.isLowPowerModeEnabled)) * 31) + this.bundleId.hashCode()) * 31) + this.appInstallDate.hashCode()) * 31) + Boolean.hashCode(this.isMac)) * 31) + Integer.hashCode(this.daysSinceInstall)) * 31) + Integer.hashCode(this.minutesSinceInstall)) * 31;
        Integer num = this.daysSinceLastPaywallView;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.minutesSinceLastPaywallView;
        int iHashCode3 = (((((((((((((((((((((iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.totalPaywallViews)) * 31) + this.utcDate.hashCode()) * 31) + this.localDate.hashCode()) * 31) + this.utcTime.hashCode()) * 31) + this.localTime.hashCode()) * 31) + this.utcDateTime.hashCode()) * 31) + this.localDateTime.hashCode()) * 31) + this.isSandbox.hashCode()) * 31) + this.activeEntitlements.hashCode()) * 31) + this.activeEntitlementsObject.hashCode()) * 31;
        String str = this.subscriptionStatus;
        int iHashCode4 = (((((((((((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.activeProducts.hashCode()) * 31) + Boolean.hashCode(this.isFirstAppOpen)) * 31) + this.sdkVersion.hashCode()) * 31) + this.sdkVersionPadded.hashCode()) * 31) + this.appBuildString.hashCode()) * 31;
        Integer num3 = this.appBuildStringNumber;
        int iHashCode5 = (((((((((((((((((iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.interfaceStyleMode.hashCode()) * 31) + this.capabilities.hashCode()) * 31) + this.capabilitiesConfig.hashCode()) * 31) + this.platformWrapper.hashCode()) * 31) + this.platformWrapperVersion.hashCode()) * 31) + this.deviceTier.hashCode()) * 31) + Integer.hashCode(this.reviewRequestCount)) * 31) + this.kotlinVersion.hashCode()) * 31;
        String str2 = this.storeFrontCountryCode;
        return iHashCode5 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isFirstAppOpen() {
        return this.isFirstAppOpen;
    }

    public final boolean isLowPowerModeEnabled() {
        return this.isLowPowerModeEnabled;
    }

    public final boolean isMac() {
        return this.isMac;
    }

    public final String isSandbox() {
        return this.isSandbox;
    }

    public final Map<String, Object> toDictionary(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return ConvertersKt.toNullableTypedMap(JsonElementKt.o(json.e(Companion.serializer(), this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceTemplate(String publicApiKey, String platform, String appUserId, List<String> aliases, String vendorId, String deviceId, String appVersion, String appVersionPadded, String osVersion, String deviceModel, String deviceLocale, String preferredLocale, String deviceLanguageCode, String preferredLanguageCode, String regionCode, String preferredRegionCode, String deviceCurrencyCode, String deviceCurrencySymbol, int i3, String radioType, String interfaceStyle, int i4, float f3, boolean z2, String bundleId, String appInstallDate, boolean z3, int i5, int i6, Integer num, Integer num2, int i7, String utcDate, String localDate, String utcTime, String localTime, String utcDateTime, String localDateTime, String isSandbox, List<String> activeEntitlements, List<? extends Map<String, String>> activeEntitlementsObject, String str, List<String> activeProducts, boolean z4, String sdkVersion, String sdkVersionPadded, String appBuildString, Integer num3, String interfaceStyleMode, List<String> capabilities, JsonElement capabilitiesConfig, String platformWrapper, String platformWrapperVersion, String deviceTier, int i8, String kotlinVersion, String str2) {
        Intrinsics.checkNotNullParameter(publicApiKey, "publicApiKey");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(appUserId, "appUserId");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appVersionPadded, "appVersionPadded");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(deviceLocale, "deviceLocale");
        Intrinsics.checkNotNullParameter(preferredLocale, "preferredLocale");
        Intrinsics.checkNotNullParameter(deviceLanguageCode, "deviceLanguageCode");
        Intrinsics.checkNotNullParameter(preferredLanguageCode, "preferredLanguageCode");
        Intrinsics.checkNotNullParameter(regionCode, "regionCode");
        Intrinsics.checkNotNullParameter(preferredRegionCode, "preferredRegionCode");
        Intrinsics.checkNotNullParameter(deviceCurrencyCode, "deviceCurrencyCode");
        Intrinsics.checkNotNullParameter(deviceCurrencySymbol, "deviceCurrencySymbol");
        Intrinsics.checkNotNullParameter(radioType, "radioType");
        Intrinsics.checkNotNullParameter(interfaceStyle, "interfaceStyle");
        Intrinsics.checkNotNullParameter(bundleId, "bundleId");
        Intrinsics.checkNotNullParameter(appInstallDate, "appInstallDate");
        Intrinsics.checkNotNullParameter(utcDate, "utcDate");
        Intrinsics.checkNotNullParameter(localDate, "localDate");
        Intrinsics.checkNotNullParameter(utcTime, "utcTime");
        Intrinsics.checkNotNullParameter(localTime, "localTime");
        Intrinsics.checkNotNullParameter(utcDateTime, "utcDateTime");
        Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
        Intrinsics.checkNotNullParameter(isSandbox, "isSandbox");
        Intrinsics.checkNotNullParameter(activeEntitlements, "activeEntitlements");
        Intrinsics.checkNotNullParameter(activeEntitlementsObject, "activeEntitlementsObject");
        Intrinsics.checkNotNullParameter(activeProducts, "activeProducts");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(sdkVersionPadded, "sdkVersionPadded");
        Intrinsics.checkNotNullParameter(appBuildString, "appBuildString");
        Intrinsics.checkNotNullParameter(interfaceStyleMode, "interfaceStyleMode");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(capabilitiesConfig, "capabilitiesConfig");
        Intrinsics.checkNotNullParameter(platformWrapper, "platformWrapper");
        Intrinsics.checkNotNullParameter(platformWrapperVersion, "platformWrapperVersion");
        Intrinsics.checkNotNullParameter(deviceTier, "deviceTier");
        Intrinsics.checkNotNullParameter(kotlinVersion, "kotlinVersion");
        this.publicApiKey = publicApiKey;
        this.platform = platform;
        this.appUserId = appUserId;
        this.aliases = aliases;
        this.vendorId = vendorId;
        this.deviceId = deviceId;
        this.appVersion = appVersion;
        this.appVersionPadded = appVersionPadded;
        this.osVersion = osVersion;
        this.deviceModel = deviceModel;
        this.deviceLocale = deviceLocale;
        this.preferredLocale = preferredLocale;
        this.deviceLanguageCode = deviceLanguageCode;
        this.preferredLanguageCode = preferredLanguageCode;
        this.regionCode = regionCode;
        this.preferredRegionCode = preferredRegionCode;
        this.deviceCurrencyCode = deviceCurrencyCode;
        this.deviceCurrencySymbol = deviceCurrencySymbol;
        this.timezoneOffset = i3;
        this.radioType = radioType;
        this.interfaceStyle = interfaceStyle;
        this.fontSize = i4;
        this.fontScale = f3;
        this.isLowPowerModeEnabled = z2;
        this.bundleId = bundleId;
        this.appInstallDate = appInstallDate;
        this.isMac = z3;
        this.daysSinceInstall = i5;
        this.minutesSinceInstall = i6;
        this.daysSinceLastPaywallView = num;
        this.minutesSinceLastPaywallView = num2;
        this.totalPaywallViews = i7;
        this.utcDate = utcDate;
        this.localDate = localDate;
        this.utcTime = utcTime;
        this.localTime = localTime;
        this.utcDateTime = utcDateTime;
        this.localDateTime = localDateTime;
        this.isSandbox = isSandbox;
        this.activeEntitlements = activeEntitlements;
        this.activeEntitlementsObject = activeEntitlementsObject;
        this.subscriptionStatus = str;
        this.activeProducts = activeProducts;
        this.isFirstAppOpen = z4;
        this.sdkVersion = sdkVersion;
        this.sdkVersionPadded = sdkVersionPadded;
        this.appBuildString = appBuildString;
        this.appBuildStringNumber = num3;
        this.interfaceStyleMode = interfaceStyleMode;
        this.capabilities = capabilities;
        this.capabilitiesConfig = capabilitiesConfig;
        this.platformWrapper = platformWrapper;
        this.platformWrapperVersion = platformWrapperVersion;
        this.deviceTier = deviceTier;
        this.reviewRequestCount = i8;
        this.kotlinVersion = kotlinVersion;
        this.storeFrontCountryCode = str2;
    }

    public String toString() {
        return "DeviceTemplate(publicApiKey=" + this.publicApiKey + ", platform=" + this.platform + ", appUserId=" + this.appUserId + ", aliases=" + this.aliases + ", vendorId=" + this.vendorId + ", deviceId=" + this.deviceId + ", appVersion=" + this.appVersion + ", appVersionPadded=" + this.appVersionPadded + ", osVersion=" + this.osVersion + ", deviceModel=" + this.deviceModel + ", deviceLocale=" + this.deviceLocale + ", preferredLocale=" + this.preferredLocale + ", deviceLanguageCode=" + this.deviceLanguageCode + ", preferredLanguageCode=" + this.preferredLanguageCode + ", regionCode=" + this.regionCode + ", preferredRegionCode=" + this.preferredRegionCode + ", deviceCurrencyCode=" + this.deviceCurrencyCode + ", deviceCurrencySymbol=" + this.deviceCurrencySymbol + ", timezoneOffset=" + this.timezoneOffset + ", radioType=" + this.radioType + ", interfaceStyle=" + this.interfaceStyle + ", fontSize=" + this.fontSize + ", fontScale=" + this.fontScale + ", isLowPowerModeEnabled=" + this.isLowPowerModeEnabled + ", bundleId=" + this.bundleId + ", appInstallDate=" + this.appInstallDate + ", isMac=" + this.isMac + ", daysSinceInstall=" + this.daysSinceInstall + ", minutesSinceInstall=" + this.minutesSinceInstall + ", daysSinceLastPaywallView=" + this.daysSinceLastPaywallView + ", minutesSinceLastPaywallView=" + this.minutesSinceLastPaywallView + ", totalPaywallViews=" + this.totalPaywallViews + ", utcDate=" + this.utcDate + ", localDate=" + this.localDate + ", utcTime=" + this.utcTime + ", localTime=" + this.localTime + ", utcDateTime=" + this.utcDateTime + ", localDateTime=" + this.localDateTime + ", isSandbox=" + this.isSandbox + MrGIhy.ZkAAIfJkGaGN + this.activeEntitlements + ", activeEntitlementsObject=" + this.activeEntitlementsObject + ", subscriptionStatus=" + this.subscriptionStatus + ", activeProducts=" + this.activeProducts + ", isFirstAppOpen=" + this.isFirstAppOpen + ", sdkVersion=" + this.sdkVersion + ", sdkVersionPadded=" + this.sdkVersionPadded + ", appBuildString=" + this.appBuildString + ", appBuildStringNumber=" + this.appBuildStringNumber + ", interfaceStyleMode=" + this.interfaceStyleMode + ", capabilities=" + this.capabilities + ", capabilitiesConfig=" + this.capabilitiesConfig + ", platformWrapper=" + this.platformWrapper + ", platformWrapperVersion=" + this.platformWrapperVersion + ", deviceTier=" + this.deviceTier + ", reviewRequestCount=" + this.reviewRequestCount + ", kotlinVersion=" + this.kotlinVersion + ", storeFrontCountryCode=" + this.storeFrontCountryCode + ")";
    }

    public /* synthetic */ DeviceTemplate(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i3, String str18, String str19, int i4, float f3, boolean z2, String str20, String str21, boolean z3, int i5, int i6, Integer num, Integer num2, int i7, String str22, String str23, String str24, String str25, String str26, String str27, String str28, List list2, List list3, String str29, List list4, boolean z4, String str30, String str31, String str32, Integer num3, String str33, List list5, JsonElement jsonElement, String str34, String str35, String str36, int i8, String str37, String str38, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, list, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, i3, str18, str19, i4, f3, z2, str20, str21, z3, i5, i6, num, num2, i7, str22, str23, str24, str25, str26, str27, str28, list2, list3, str29, list4, z4, str30, str31, str32, num3, str33, list5, jsonElement, str34, str35, str36, i8, str37, (i10 & 16777216) != 0 ? null : str38);
    }
}
