package com.superwall.sdk.models.attribution;

import com.superwall.sdk.models.attribution.AttributionProvider;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class AttributionProvider {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AttributionProvider[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final String rawName;

    @SerialName
    public static final AttributionProvider ADJUST_ID = new AttributionProvider("ADJUST_ID", 0, "adjustId");

    @SerialName
    public static final AttributionProvider SINGULAR_DEVICE_ID = new AttributionProvider("SINGULAR_DEVICE_ID", 1, "singularDeviceId");

    @SerialName
    public static final AttributionProvider AMPLITUDE_DEVICE_ID = new AttributionProvider("AMPLITUDE_DEVICE_ID", 2, "amplitudeDeviceId");

    @SerialName
    public static final AttributionProvider AMPLITUDE_USER_ID = new AttributionProvider("AMPLITUDE_USER_ID", 3, "amplitudeUserId");

    @SerialName
    public static final AttributionProvider APPSFLYER_ID = new AttributionProvider("APPSFLYER_ID", 4, "appsflyerId");

    @SerialName
    public static final AttributionProvider BRAZE_ALIAS_NAME = new AttributionProvider("BRAZE_ALIAS_NAME", 5, "brazeAliasName");

    @SerialName
    public static final AttributionProvider BRAZE_ALIAS_LABEL = new AttributionProvider("BRAZE_ALIAS_LABEL", 6, "brazeAliasLabel");

    @SerialName
    public static final AttributionProvider ONESIGNAL_ID = new AttributionProvider("ONESIGNAL_ID", 7, "onesignalId");

    @SerialName
    public static final AttributionProvider FB_ANON_ID = new AttributionProvider("FB_ANON_ID", 8, "fbAnonId");

    @SerialName
    public static final AttributionProvider FIREBASE_APP_INSTANCE_ID = new AttributionProvider("FIREBASE_APP_INSTANCE_ID", 9, "firebaseAppInstanceId");

    @SerialName
    public static final AttributionProvider ITERABLE_USER_ID = new AttributionProvider("ITERABLE_USER_ID", 10, "iterableUserId");

    @SerialName
    public static final AttributionProvider ITERABLE_CAMPAIGN_ID = new AttributionProvider("ITERABLE_CAMPAIGN_ID", 11, "iterableCampaignId");

    @SerialName
    public static final AttributionProvider ITERABLE_TEMPLATE_ID = new AttributionProvider("ITERABLE_TEMPLATE_ID", 12, "iterableTemplateId");

    @SerialName
    public static final AttributionProvider MIXPANEL_DISTINCT_ID = new AttributionProvider("MIXPANEL_DISTINCT_ID", 13, "mixpanelDistinctId");

    @SerialName
    public static final AttributionProvider MPARTICLE_ID = new AttributionProvider("MPARTICLE_ID", 14, "mparticleId");

    @SerialName
    public static final AttributionProvider CLEVERTAP_ID = new AttributionProvider("CLEVERTAP_ID", 15, "clevertapId");

    @SerialName
    public static final AttributionProvider AIRSHIP_CHANNEL_ID = new AttributionProvider("AIRSHIP_CHANNEL_ID", 16, "airshipChannelId");

    @SerialName
    public static final AttributionProvider KOCHAVA_DEVICE_ID = new AttributionProvider("KOCHAVA_DEVICE_ID", 17, "kochavaDeviceId");

    @SerialName
    public static final AttributionProvider TENJIN_ID = new AttributionProvider("TENJIN_ID", 18, "tenjinId");

    @SerialName
    public static final AttributionProvider POSTHOG_USER_ID = new AttributionProvider("POSTHOG_USER_ID", 19, "posthogUserId");

    @SerialName
    public static final AttributionProvider CUSTOMERIO_ID = new AttributionProvider("CUSTOMERIO_ID", 20, "customerioId");

    @SerialName
    public static final AttributionProvider META = new AttributionProvider("META", 21, "meta");

    @SerialName
    public static final AttributionProvider AMPLITUDE = new AttributionProvider("AMPLITUDE", 22, "amplitude");

    @SerialName
    public static final AttributionProvider MIXPANEL = new AttributionProvider("MIXPANEL", 23, "mixpanel");

    @SerialName
    public static final AttributionProvider GOOGLE_ADS = new AttributionProvider("GOOGLE_ADS", 24, "googleAds");

    @SerialName
    public static final AttributionProvider GOOGLE_APP_SET = new AttributionProvider("GOOGLE_APP_SET", 25, "googleAppSetId");

    @SerialName
    public static final AttributionProvider APPSTACK = new AttributionProvider("APPSTACK", 26, "appstackId");

    @SerialName
    public static final AttributionProvider CUSTOM = new AttributionProvider("CUSTOM", 27, "custom");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) AttributionProvider.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<AttributionProvider> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ AttributionProvider[] $values() {
        return new AttributionProvider[]{ADJUST_ID, SINGULAR_DEVICE_ID, AMPLITUDE_DEVICE_ID, AMPLITUDE_USER_ID, APPSFLYER_ID, BRAZE_ALIAS_NAME, BRAZE_ALIAS_LABEL, ONESIGNAL_ID, FB_ANON_ID, FIREBASE_APP_INSTANCE_ID, ITERABLE_USER_ID, ITERABLE_CAMPAIGN_ID, ITERABLE_TEMPLATE_ID, MIXPANEL_DISTINCT_ID, MPARTICLE_ID, CLEVERTAP_ID, AIRSHIP_CHANNEL_ID, KOCHAVA_DEVICE_ID, TENJIN_ID, POSTHOG_USER_ID, CUSTOMERIO_ID, META, AMPLITUDE, MIXPANEL, GOOGLE_ADS, GOOGLE_APP_SET, APPSTACK, CUSTOM};
    }

    static {
        AttributionProvider[] attributionProviderArr$values = $values();
        $VALUES = attributionProviderArr$values;
        $ENTRIES = EnumEntriesKt.a(attributionProviderArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: d0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AttributionProvider._init_$_anonymous_();
            }
        });
    }

    private AttributionProvider(String str, int i3, String str2) {
        this.rawName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.models.attribution.AttributionProvider", values(), new String[]{"adjustId", "singularDeviceId", "amplitudeDeviceId", "amplitudeUserId", "appsflyerId", "brazeAliasName", "brazeAliasLabel", "onesignalId", "fbAnonId", "firebaseAppInstanceId", "iterableUserId", "iterableCampaignId", "iterableTemplateId", "mixpanelDistinctId", "mparticleId", "clevertapId", "airshipChannelId", "kochavaDeviceId", "tenjinId", "posthogUserId", "customerioId", "meta", "amplitude", "mixpanel", "googleAds", "googleAppSetId", "appstackId", "custom"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
    }

    public static EnumEntries<AttributionProvider> getEntries() {
        return $ENTRIES;
    }

    public static AttributionProvider valueOf(String str) {
        return (AttributionProvider) Enum.valueOf(AttributionProvider.class, str);
    }

    public static AttributionProvider[] values() {
        return (AttributionProvider[]) $VALUES.clone();
    }

    public final String getRawName() {
        return this.rawName;
    }
}
