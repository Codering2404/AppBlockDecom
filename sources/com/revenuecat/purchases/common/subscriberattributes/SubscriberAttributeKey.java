package com.revenuecat.purchases.common.subscriberattributes;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public abstract class SubscriberAttributeKey {
    private final String backendKey;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class AttributionIds extends SubscriberAttributeKey {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Adjust extends AttributionIds {
            public static final Adjust INSTANCE = new Adjust();

            private Adjust() {
                super(ReservedSubscriberAttribute.ADJUST_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Airbridge extends AttributionIds {
            public static final Airbridge INSTANCE = new Airbridge();

            private Airbridge() {
                super(ReservedSubscriberAttribute.AIRBRIDGE_DEVICE_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AppsFlyer extends AttributionIds {
            public static final AppsFlyer INSTANCE = new AppsFlyer();

            private AppsFlyer() {
                super(ReservedSubscriberAttribute.APPSFLYER_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Appstack extends AttributionIds {
            public static final Appstack INSTANCE = new Appstack();

            private Appstack() {
                super(ReservedSubscriberAttribute.APPSTACK_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CleverTap extends AttributionIds {
            public static final CleverTap INSTANCE = new CleverTap();

            private CleverTap() {
                super(ReservedSubscriberAttribute.CLEVER_TAP_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Facebook extends AttributionIds {
            public static final Facebook INSTANCE = new Facebook();

            private Facebook() {
                super(ReservedSubscriberAttribute.FB_ANON_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Kochava extends AttributionIds {
            public static final Kochava INSTANCE = new Kochava();

            private Kochava() {
                super(ReservedSubscriberAttribute.KOCHAVA_DEVICE_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Mparticle extends AttributionIds {
            public static final Mparticle INSTANCE = new Mparticle();

            private Mparticle() {
                super(ReservedSubscriberAttribute.MPARTICLE_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SolarEngineAccountId extends AttributionIds {
            public static final SolarEngineAccountId INSTANCE = new SolarEngineAccountId();

            private SolarEngineAccountId() {
                super(ReservedSubscriberAttribute.SOLAR_ENGINE_ACCOUNT_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SolarEngineDistinctId extends AttributionIds {
            public static final SolarEngineDistinctId INSTANCE = new SolarEngineDistinctId();

            private SolarEngineDistinctId() {
                super(ReservedSubscriberAttribute.SOLAR_ENGINE_DISTINCT_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SolarEngineVisitorId extends AttributionIds {
            public static final SolarEngineVisitorId INSTANCE = new SolarEngineVisitorId();

            private SolarEngineVisitorId() {
                super(ReservedSubscriberAttribute.SOLAR_ENGINE_VISITOR_ID, null);
            }
        }

        public /* synthetic */ AttributionIds(ReservedSubscriberAttribute reservedSubscriberAttribute, DefaultConstructorMarker defaultConstructorMarker) {
            this(reservedSubscriberAttribute);
        }

        private AttributionIds(ReservedSubscriberAttribute reservedSubscriberAttribute) {
            super(reservedSubscriberAttribute.getValue(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class CampaignParameters extends SubscriberAttributeKey {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Ad extends CampaignParameters {
            public static final Ad INSTANCE = new Ad();

            private Ad() {
                super(ReservedSubscriberAttribute.AD, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AdGroup extends CampaignParameters {
            public static final AdGroup INSTANCE = new AdGroup();

            private AdGroup() {
                super(ReservedSubscriberAttribute.AD_GROUP, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Campaign extends CampaignParameters {
            public static final Campaign INSTANCE = new Campaign();

            private Campaign() {
                super(ReservedSubscriberAttribute.CAMPAIGN, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creative extends CampaignParameters {
            public static final Creative INSTANCE = new Creative();

            private Creative() {
                super(ReservedSubscriberAttribute.CREATIVE, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Keyword extends CampaignParameters {
            public static final Keyword INSTANCE = new Keyword();

            private Keyword() {
                super(ReservedSubscriberAttribute.KEYWORD, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MediaSource extends CampaignParameters {
            public static final MediaSource INSTANCE = new MediaSource();

            private MediaSource() {
                super(ReservedSubscriberAttribute.MEDIA_SOURCE, null);
            }
        }

        public /* synthetic */ CampaignParameters(ReservedSubscriberAttribute reservedSubscriberAttribute, DefaultConstructorMarker defaultConstructorMarker) {
            this(reservedSubscriberAttribute);
        }

        private CampaignParameters(ReservedSubscriberAttribute reservedSubscriberAttribute) {
            super(reservedSubscriberAttribute.getValue(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Custom extends SubscriberAttributeKey {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String value) {
            super(value, null);
            Intrinsics.checkNotNullParameter(value, "value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class DeviceIdentifiers {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class AmazonAdID extends SubscriberAttributeKey {
            public static final AmazonAdID INSTANCE = new AmazonAdID();

            private AmazonAdID() {
                super(ReservedSubscriberAttribute.AMAZON_AD_ID.getValue(), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DeviceVersion extends SubscriberAttributeKey {
            public static final DeviceVersion INSTANCE = new DeviceVersion();

            private DeviceVersion() {
                super(ReservedSubscriberAttribute.DEVICE_VERSION.getValue(), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class GPSAdID extends SubscriberAttributeKey {
            public static final GPSAdID INSTANCE = new GPSAdID();

            private GPSAdID() {
                super(ReservedSubscriberAttribute.GPS_AD_ID.getValue(), null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class IP extends SubscriberAttributeKey {
            public static final IP INSTANCE = new IP();

            private IP() {
                super(ReservedSubscriberAttribute.IP.getValue(), null);
            }
        }

        public /* synthetic */ DeviceIdentifiers(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private DeviceIdentifiers() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DisplayName extends SubscriberAttributeKey {
        public static final DisplayName INSTANCE = new DisplayName();

        private DisplayName() {
            super(ReservedSubscriberAttribute.DISPLAY_NAME.getValue(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Email extends SubscriberAttributeKey {
        public static final Email INSTANCE = new Email();

        private Email() {
            super(ReservedSubscriberAttribute.EMAIL.getValue(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FCMTokens extends SubscriberAttributeKey {
        public static final FCMTokens INSTANCE = new FCMTokens();

        private FCMTokens() {
            super(ReservedSubscriberAttribute.FCM_TOKENS.getValue(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class IntegrationIds extends SubscriberAttributeKey {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Airship extends IntegrationIds {
            public static final Airship INSTANCE = new Airship();

            private Airship() {
                super(ReservedSubscriberAttribute.AIRSHIP_CHANNEL_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class FirebaseAppInstanceId extends IntegrationIds {
            public static final FirebaseAppInstanceId INSTANCE = new FirebaseAppInstanceId();

            private FirebaseAppInstanceId() {
                super(ReservedSubscriberAttribute.FIREBASE_APP_INSTANCE_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MixpanelDistinctId extends IntegrationIds {
            public static final MixpanelDistinctId INSTANCE = new MixpanelDistinctId();

            private MixpanelDistinctId() {
                super(ReservedSubscriberAttribute.MIXPANEL_DISTINCT_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OneSignal extends IntegrationIds {
            public static final OneSignal INSTANCE = new OneSignal();

            private OneSignal() {
                super(ReservedSubscriberAttribute.ONESIGNAL_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OneSignalUserId extends IntegrationIds {
            public static final OneSignalUserId INSTANCE = new OneSignalUserId();

            private OneSignalUserId() {
                super(ReservedSubscriberAttribute.ONESIGNAL_USER_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PostHogUserId extends IntegrationIds {
            public static final PostHogUserId INSTANCE = new PostHogUserId();

            private PostHogUserId() {
                super(ReservedSubscriberAttribute.POSTHOG_USER_ID, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TenjinAnalyticsInstallationId extends IntegrationIds {
            public static final TenjinAnalyticsInstallationId INSTANCE = new TenjinAnalyticsInstallationId();

            private TenjinAnalyticsInstallationId() {
                super(ReservedSubscriberAttribute.TENJIN_ANALYTICS_INSTALLATION_ID, null);
            }
        }

        public /* synthetic */ IntegrationIds(ReservedSubscriberAttribute reservedSubscriberAttribute, DefaultConstructorMarker defaultConstructorMarker) {
            this(reservedSubscriberAttribute);
        }

        private IntegrationIds(ReservedSubscriberAttribute reservedSubscriberAttribute) {
            super(reservedSubscriberAttribute.getValue(), null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PhoneNumber extends SubscriberAttributeKey {
        public static final PhoneNumber INSTANCE = new PhoneNumber();

        private PhoneNumber() {
            super(ReservedSubscriberAttribute.PHONE_NUMBER.getValue(), null);
        }
    }

    public /* synthetic */ SubscriberAttributeKey(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey");
        return Intrinsics.areEqual(this.backendKey, ((SubscriberAttributeKey) obj).backendKey);
    }

    public final String getBackendKey() {
        return this.backendKey;
    }

    public int hashCode() {
        return this.backendKey.hashCode();
    }

    public String toString() {
        return "SubscriberAttributeKey('" + this.backendKey + "')";
    }

    private SubscriberAttributeKey(String str) {
        this.backendKey = str;
    }
}
