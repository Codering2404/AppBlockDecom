package com.revenuecat.purchases.common.subscriberattributes;

import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public enum ReservedSubscriberAttribute {
    EMAIL("$email"),
    DISPLAY_NAME("$displayName"),
    PHONE_NUMBER("$phoneNumber"),
    FCM_TOKENS("$fcmTokens"),
    IDFA("$idfa"),
    IDFV("$idfv"),
    IP("$ip"),
    DEVICE_VERSION("$deviceVersion"),
    GPS_AD_ID("$gpsAdId"),
    AMAZON_AD_ID("$amazonAdId"),
    ADJUST_ID("$adjustId"),
    APPSFLYER_ID("$appsflyerId"),
    APPSTACK_ID("$appstackId"),
    FB_ANON_ID("$fbAnonId"),
    MPARTICLE_ID("$mparticleId"),
    ONESIGNAL_ID("$onesignalId"),
    ONESIGNAL_USER_ID("$onesignalUserId"),
    AIRSHIP_CHANNEL_ID("$airshipChannelId"),
    CLEVER_TAP_ID("$clevertapId"),
    KOCHAVA_DEVICE_ID("$kochavaDeviceId"),
    AIRBRIDGE_DEVICE_ID("$airbridgeDeviceId"),
    SOLAR_ENGINE_DISTINCT_ID("$solarEngineDistinctId"),
    SOLAR_ENGINE_ACCOUNT_ID("$solarEngineAccountId"),
    SOLAR_ENGINE_VISITOR_ID("$solarEngineVisitorId"),
    MIXPANEL_DISTINCT_ID("$mixpanelDistinctId"),
    FIREBASE_APP_INSTANCE_ID("$firebaseAppInstanceId"),
    TENJIN_ANALYTICS_INSTALLATION_ID("$tenjinId"),
    POSTHOG_USER_ID(KrzujOtzIk.NDmVHRbWPepm),
    MEDIA_SOURCE("$mediaSource"),
    CAMPAIGN("$campaign"),
    AD_GROUP("$adGroup"),
    AD("$ad"),
    KEYWORD("$keyword"),
    CREATIVE("$creative");

    private final String value;

    ReservedSubscriberAttribute(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
