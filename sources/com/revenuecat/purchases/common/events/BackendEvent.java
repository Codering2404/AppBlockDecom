package com.revenuecat.purchases.common.events;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.Event;
import com.sun.jna.Function;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public abstract class BackendEvent implements Event {
    public static final int AD_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOMER_CENTER_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION = 1;
    public static final int PAYWALL_EVENT_SCHEMA_VERSION = 1;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.common.events.BackendEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.events.BackendEvent", Reflection.b(BackendEvent.class), new KClass[]{Reflection.b(Ad.class), Reflection.b(CustomPaywall.class), Reflection.b(CustomerCenter.class), Reflection.b(Paywalls.class)}, new KSerializer[]{BackendEvent$Ad$$serializer.INSTANCE, BackendEvent$CustomPaywall$$serializer.INSTANCE, BackendEvent$CustomerCenter$$serializer.INSTANCE, BackendEvent$Paywalls$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Ad extends BackendEvent {
        public static final Companion Companion = new Companion(null);
        private final String adFormat;
        private final String adUnitId;
        private final String appSessionID;
        private final String appUserID;
        private final String currency;
        private final String id;
        private final String impressionId;
        private final Integer mediatorErrorCode;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final String precision;
        private final Long revenueMicros;
        private final long timestamp;
        private final String type;
        private final int version;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Ad> serializer() {
                return BackendEvent$Ad$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Ad(int i3, String str, int i4, String str2, @SerialName long j3, @SerialName String str3, @SerialName String str4, @SerialName String str5, String str6, @SerialName String str7, @SerialName String str8, @SerialName String str9, @SerialName String str10, @SerialName Long l3, String str11, String str12, @SerialName Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (4015 != (i3 & 4015)) {
                PluginExceptionsKt.b(i3, 4015, BackendEvent$Ad$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i4;
            this.type = str2;
            this.timestamp = j3;
            if ((i3 & 16) == 0) {
                this.networkName = null;
            } else {
                this.networkName = str3;
            }
            this.mediatorName = str4;
            if ((i3 & 64) == 0) {
                this.adFormat = null;
            } else {
                this.adFormat = str5;
            }
            this.placement = str6;
            this.adUnitId = str7;
            this.impressionId = str8;
            this.appUserID = str9;
            this.appSessionID = str10;
            if ((i3 & 4096) == 0) {
                this.revenueMicros = null;
            } else {
                this.revenueMicros = l3;
            }
            if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                this.currency = null;
            } else {
                this.currency = str11;
            }
            if ((i3 & 16384) == 0) {
                this.precision = null;
            } else {
                this.precision = str12;
            }
            if ((i3 & 32768) == 0) {
                this.mediatorErrorCode = null;
            } else {
                this.mediatorErrorCode = num;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Ad ad, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendEvent.write$Self(ad, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, ad.id);
            compositeEncoder.w(serialDescriptor, 1, ad.version);
            compositeEncoder.y(serialDescriptor, 2, ad.type);
            compositeEncoder.F(serialDescriptor, 3, ad.timestamp);
            if (compositeEncoder.z(serialDescriptor, 4) || ad.networkName != null) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, ad.networkName);
            }
            compositeEncoder.y(serialDescriptor, 5, ad.mediatorName);
            if (compositeEncoder.z(serialDescriptor, 6) || ad.adFormat != null) {
                compositeEncoder.i(serialDescriptor, 6, StringSerializer.f142891a, ad.adFormat);
            }
            StringSerializer stringSerializer = StringSerializer.f142891a;
            compositeEncoder.i(serialDescriptor, 7, stringSerializer, ad.placement);
            compositeEncoder.y(serialDescriptor, 8, ad.adUnitId);
            compositeEncoder.i(serialDescriptor, 9, stringSerializer, ad.impressionId);
            compositeEncoder.y(serialDescriptor, 10, ad.appUserID);
            compositeEncoder.y(serialDescriptor, 11, ad.appSessionID);
            if (compositeEncoder.z(serialDescriptor, 12) || ad.revenueMicros != null) {
                compositeEncoder.i(serialDescriptor, 12, LongSerializer.f142836a, ad.revenueMicros);
            }
            if (compositeEncoder.z(serialDescriptor, 13) || ad.currency != null) {
                compositeEncoder.i(serialDescriptor, 13, stringSerializer, ad.currency);
            }
            if (compositeEncoder.z(serialDescriptor, 14) || ad.precision != null) {
                compositeEncoder.i(serialDescriptor, 14, stringSerializer, ad.precision);
            }
            if (!compositeEncoder.z(serialDescriptor, 15) && ad.mediatorErrorCode == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 15, IntSerializer.f142823a, ad.mediatorErrorCode);
        }

        public final String component1() {
            return this.id;
        }

        public final String component10() {
            return this.impressionId;
        }

        public final String component11() {
            return this.appUserID;
        }

        public final String component12() {
            return this.appSessionID;
        }

        public final Long component13() {
            return this.revenueMicros;
        }

        public final String component14() {
            return this.currency;
        }

        public final String component15() {
            return this.precision;
        }

        public final Integer component16() {
            return this.mediatorErrorCode;
        }

        public final int component2() {
            return this.version;
        }

        public final String component3() {
            return this.type;
        }

        public final long component4() {
            return this.timestamp;
        }

        public final String component5() {
            return this.networkName;
        }

        public final String component6() {
            return this.mediatorName;
        }

        public final String component7() {
            return this.adFormat;
        }

        public final String component8() {
            return this.placement;
        }

        public final String component9() {
            return this.adUnitId;
        }

        public final Ad copy(String id, int i3, String type, long j3, String str, String mediatorName, String str2, String str3, String adUnitId, String str4, String appUserID, String appSessionID, Long l3, String str5, String str6, Integer num) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            return new Ad(id, i3, type, j3, str, mediatorName, str2, str3, adUnitId, str4, appUserID, appSessionID, l3, str5, str6, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ad)) {
                return false;
            }
            Ad ad = (Ad) obj;
            return Intrinsics.areEqual(this.id, ad.id) && this.version == ad.version && Intrinsics.areEqual(this.type, ad.type) && this.timestamp == ad.timestamp && Intrinsics.areEqual(this.networkName, ad.networkName) && Intrinsics.areEqual(this.mediatorName, ad.mediatorName) && Intrinsics.areEqual(this.adFormat, ad.adFormat) && Intrinsics.areEqual(this.placement, ad.placement) && Intrinsics.areEqual(this.adUnitId, ad.adUnitId) && Intrinsics.areEqual(this.impressionId, ad.impressionId) && Intrinsics.areEqual(this.appUserID, ad.appUserID) && Intrinsics.areEqual(this.appSessionID, ad.appSessionID) && Intrinsics.areEqual(this.revenueMicros, ad.revenueMicros) && Intrinsics.areEqual(this.currency, ad.currency) && Intrinsics.areEqual(this.precision, ad.precision) && Intrinsics.areEqual(this.mediatorErrorCode, ad.mediatorErrorCode);
        }

        public final String getAdFormat() {
            return this.adFormat;
        }

        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getId() {
            return this.id;
        }

        public final String getImpressionId() {
            return this.impressionId;
        }

        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        public final String getMediatorName() {
            return this.mediatorName;
        }

        public final String getNetworkName() {
            return this.networkName;
        }

        public final String getPlacement() {
            return this.placement;
        }

        public final String getPrecision() {
            return this.precision;
        }

        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str = this.networkName;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mediatorName.hashCode()) * 31;
            String str2 = this.adFormat;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.placement;
            int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.adUnitId.hashCode()) * 31;
            String str4 = this.impressionId;
            int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31;
            Long l3 = this.revenueMicros;
            int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
            String str5 = this.currency;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.precision;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num = this.mediatorErrorCode;
            return iHashCode8 + (num != null ? num.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Ad(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", timestamp=" + this.timestamp + ", networkName=" + this.networkName + ", mediatorName=" + this.mediatorName + ", adFormat=" + this.adFormat + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", revenueMicros=" + this.revenueMicros + ", currency=" + this.currency + ", precision=" + this.precision + ", mediatorErrorCode=" + this.mediatorErrorCode + ')';
        }

        public /* synthetic */ Ad(String str, int i3, String str2, long j3, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l3, String str11, String str12, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, str2, j3, (i4 & 16) != 0 ? null : str3, str4, (i4 & 64) != 0 ? null : str5, str6, str7, str8, str9, str10, (i4 & 4096) != 0 ? null : l3, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str11, (i4 & 16384) != 0 ? null : str12, (i4 & 32768) != 0 ? null : num);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(String id, int i3, String type, long j3, String str, String mediatorName, String str2, String str3, String adUnitId, String str4, String appUserID, String appSessionID, Long l3, String str5, String str6, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            this.id = id;
            this.version = i3;
            this.type = type;
            this.timestamp = j3;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = str2;
            this.placement = str3;
            this.adUnitId = adUnitId;
            this.impressionId = str4;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.revenueMicros = l3;
            this.currency = str5;
            this.precision = str6;
            this.mediatorErrorCode = num;
        }

        @SerialName
        public static /* synthetic */ void getAdFormat$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getAdUnitId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getImpressionId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getMediatorErrorCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getMediatorName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getNetworkName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRevenueMicros$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTimestamp$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) BackendEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<BackendEvent> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class CustomPaywall extends BackendEvent {
        public static final Companion Companion = new Companion(null);
        private final String appSessionID;
        private final String appUserID;
        private final String id;
        private final String offeringID;
        private final String paywallID;
        private final long timestamp;
        private final String type;
        private final int version;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomPaywall> serializer() {
                return BackendEvent$CustomPaywall$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomPaywall(int i3, String str, int i4, String str2, @SerialName String str3, @SerialName String str4, long j3, @SerialName String str5, @SerialName String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (47 != (i3 & 47)) {
                PluginExceptionsKt.b(i3, 47, BackendEvent$CustomPaywall$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i4;
            this.type = str2;
            this.appUserID = str3;
            if ((i3 & 16) == 0) {
                this.appSessionID = null;
            } else {
                this.appSessionID = str4;
            }
            this.timestamp = j3;
            if ((i3 & 64) == 0) {
                this.paywallID = null;
            } else {
                this.paywallID = str5;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                this.offeringID = null;
            } else {
                this.offeringID = str6;
            }
        }

        public static /* synthetic */ CustomPaywall copy$default(CustomPaywall customPaywall, String str, int i3, String str2, String str3, String str4, long j3, String str5, String str6, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = customPaywall.id;
            }
            if ((i4 & 2) != 0) {
                i3 = customPaywall.version;
            }
            if ((i4 & 4) != 0) {
                str2 = customPaywall.type;
            }
            if ((i4 & 8) != 0) {
                str3 = customPaywall.appUserID;
            }
            if ((i4 & 16) != 0) {
                str4 = customPaywall.appSessionID;
            }
            if ((i4 & 32) != 0) {
                j3 = customPaywall.timestamp;
            }
            if ((i4 & 64) != 0) {
                str5 = customPaywall.paywallID;
            }
            if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                str6 = customPaywall.offeringID;
            }
            long j4 = j3;
            String str7 = str3;
            String str8 = str4;
            String str9 = str2;
            return customPaywall.copy(str, i3, str9, str7, str8, j4, str5, str6);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomPaywall customPaywall, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendEvent.write$Self(customPaywall, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, customPaywall.id);
            compositeEncoder.w(serialDescriptor, 1, customPaywall.version);
            compositeEncoder.y(serialDescriptor, 2, customPaywall.type);
            compositeEncoder.y(serialDescriptor, 3, customPaywall.appUserID);
            if (compositeEncoder.z(serialDescriptor, 4) || customPaywall.appSessionID != null) {
                compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, customPaywall.appSessionID);
            }
            compositeEncoder.F(serialDescriptor, 5, customPaywall.timestamp);
            if (compositeEncoder.z(serialDescriptor, 6) || customPaywall.paywallID != null) {
                compositeEncoder.i(serialDescriptor, 6, StringSerializer.f142891a, customPaywall.paywallID);
            }
            if (!compositeEncoder.z(serialDescriptor, 7) && customPaywall.offeringID == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 7, StringSerializer.f142891a, customPaywall.offeringID);
        }

        public final String component1() {
            return this.id;
        }

        public final int component2() {
            return this.version;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.appUserID;
        }

        public final String component5() {
            return this.appSessionID;
        }

        public final long component6() {
            return this.timestamp;
        }

        public final String component7() {
            return this.paywallID;
        }

        public final String component8() {
            return this.offeringID;
        }

        public final CustomPaywall copy(String id, int i3, String type, String appUserID, String str, long j3, String str2, String str3) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            return new CustomPaywall(id, i3, type, appUserID, str, j3, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomPaywall)) {
                return false;
            }
            CustomPaywall customPaywall = (CustomPaywall) obj;
            return Intrinsics.areEqual(this.id, customPaywall.id) && this.version == customPaywall.version && Intrinsics.areEqual(this.type, customPaywall.type) && Intrinsics.areEqual(this.appUserID, customPaywall.appUserID) && Intrinsics.areEqual(this.appSessionID, customPaywall.appSessionID) && this.timestamp == customPaywall.timestamp && Intrinsics.areEqual(this.paywallID, customPaywall.paywallID) && Intrinsics.areEqual(this.offeringID, customPaywall.offeringID);
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getId() {
            return this.id;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31;
            String str = this.appSessionID;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str2 = this.paywallID;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.offeringID;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomPaywall(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ", paywallID=" + this.paywallID + ", offeringID=" + this.offeringID + ')';
        }

        public /* synthetic */ CustomPaywall(String str, int i3, String str2, String str3, String str4, long j3, String str5, String str6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, str2, str3, (i4 & 16) != 0 ? null : str4, j3, (i4 & 64) != 0 ? null : str5, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str6);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPaywall(String id, int i3, String type, String appUserID, String str, long j3, String str2, String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            this.id = id;
            this.version = i3;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = str;
            this.timestamp = j3;
            this.paywallID = str2;
            this.offeringID = str3;
        }

        @SerialName
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOfferingID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPaywallID$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class CustomerCenter extends BackendEvent {
        private final String appSessionID;
        private final String appUserID;
        private final boolean darkMode;
        private final CustomerCenterDisplayMode displayMode;
        private final String id;
        private final String locale;
        private final CustomerCenterConfigData.HelpPath.PathType path;
        private final int revisionID;
        private final String surveyOptionID;
        private final long timestamp;
        private final CustomerCenterEventType type;
        private final String url;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, CustomerCenterEventType.Companion.serializer(), null, null, null, null, null, CustomerCenterDisplayMode.Companion.serializer(), CustomerCenterConfigData.HelpPath.PathType.Companion.serializer(), null, null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomerCenter> serializer() {
                return BackendEvent$CustomerCenter$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomerCenter(int i3, String str, @SerialName int i4, CustomerCenterEventType customerCenterEventType, @SerialName String str2, @SerialName String str3, long j3, @SerialName boolean z2, String str4, @SerialName CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, @SerialName String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (4095 != (i3 & 4095)) {
                PluginExceptionsKt.b(i3, 4095, BackendEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.revisionID = i4;
            this.type = customerCenterEventType;
            this.appUserID = str2;
            this.appSessionID = str3;
            this.timestamp = j3;
            this.darkMode = z2;
            this.locale = str4;
            this.displayMode = customerCenterDisplayMode;
            this.path = pathType;
            this.url = str5;
            this.surveyOptionID = str6;
        }

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, String str, int i3, CustomerCenterEventType customerCenterEventType, String str2, String str3, long j3, boolean z2, String str4, CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, String str6, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = customerCenter.id;
            }
            return customerCenter.copy(str, (i4 & 2) != 0 ? customerCenter.revisionID : i3, (i4 & 4) != 0 ? customerCenter.type : customerCenterEventType, (i4 & 8) != 0 ? customerCenter.appUserID : str2, (i4 & 16) != 0 ? customerCenter.appSessionID : str3, (i4 & 32) != 0 ? customerCenter.timestamp : j3, (i4 & 64) != 0 ? customerCenter.darkMode : z2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? customerCenter.locale : str4, (i4 & Function.MAX_NARGS) != 0 ? customerCenter.displayMode : customerCenterDisplayMode, (i4 & 512) != 0 ? customerCenter.path : pathType, (i4 & 1024) != 0 ? customerCenter.url : str5, (i4 & 2048) != 0 ? customerCenter.surveyOptionID : str6);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenter customerCenter, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendEvent.write$Self(customerCenter, compositeEncoder, serialDescriptor);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, customerCenter.id);
            compositeEncoder.w(serialDescriptor, 1, customerCenter.revisionID);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], customerCenter.type);
            compositeEncoder.y(serialDescriptor, 3, customerCenter.appUserID);
            compositeEncoder.y(serialDescriptor, 4, customerCenter.appSessionID);
            compositeEncoder.F(serialDescriptor, 5, customerCenter.timestamp);
            compositeEncoder.x(serialDescriptor, 6, customerCenter.darkMode);
            compositeEncoder.y(serialDescriptor, 7, customerCenter.locale);
            compositeEncoder.C(serialDescriptor, 8, kSerializerArr[8], customerCenter.displayMode);
            compositeEncoder.i(serialDescriptor, 9, kSerializerArr[9], customerCenter.path);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            compositeEncoder.i(serialDescriptor, 10, stringSerializer, customerCenter.url);
            compositeEncoder.i(serialDescriptor, 11, stringSerializer, customerCenter.surveyOptionID);
        }

        public final String component1() {
            return this.id;
        }

        public final CustomerCenterConfigData.HelpPath.PathType component10() {
            return this.path;
        }

        public final String component11() {
            return this.url;
        }

        public final String component12() {
            return this.surveyOptionID;
        }

        public final int component2() {
            return this.revisionID;
        }

        public final CustomerCenterEventType component3() {
            return this.type;
        }

        public final String component4() {
            return this.appUserID;
        }

        public final String component5() {
            return this.appSessionID;
        }

        public final long component6() {
            return this.timestamp;
        }

        public final boolean component7() {
            return this.darkMode;
        }

        public final String component8() {
            return this.locale;
        }

        public final CustomerCenterDisplayMode component9() {
            return this.displayMode;
        }

        public final CustomerCenter copy(String id, int i3, CustomerCenterEventType type, String appUserID, String appSessionID, long j3, boolean z2, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            return new CustomerCenter(id, i3, type, appUserID, appSessionID, j3, z2, locale, displayMode, pathType, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomerCenter)) {
                return false;
            }
            CustomerCenter customerCenter = (CustomerCenter) obj;
            return Intrinsics.areEqual(this.id, customerCenter.id) && this.revisionID == customerCenter.revisionID && this.type == customerCenter.type && Intrinsics.areEqual(this.appUserID, customerCenter.appUserID) && Intrinsics.areEqual(this.appSessionID, customerCenter.appSessionID) && this.timestamp == customerCenter.timestamp && this.darkMode == customerCenter.darkMode && Intrinsics.areEqual(this.locale, customerCenter.locale) && this.displayMode == customerCenter.displayMode && this.path == customerCenter.path && Intrinsics.areEqual(this.url, customerCenter.url) && Intrinsics.areEqual(this.surveyOptionID, customerCenter.surveyOptionID);
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        public final int getRevisionID() {
            return this.revisionID;
        }

        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final CustomerCenterEventType getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.revisionID)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.locale.hashCode()) * 31) + this.displayMode.hashCode()) * 31;
            CustomerCenterConfigData.HelpPath.PathType pathType = this.path;
            int iHashCode2 = (iHashCode + (pathType == null ? 0 : pathType.hashCode())) * 31;
            String str = this.url;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.surveyOptionID;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomerCenter(id=" + this.id + ", revisionID=" + this.revisionID + ", type=" + this.type + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ", darkMode=" + this.darkMode + ", locale=" + this.locale + ", displayMode=" + this.displayMode + ", path=" + this.path + ", url=" + this.url + ", surveyOptionID=" + this.surveyOptionID + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(String id, int i3, CustomerCenterEventType type, String appUserID, String appSessionID, long j3, boolean z2, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            this.id = id;
            this.revisionID = i3;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.timestamp = j3;
            this.darkMode = z2;
            this.locale = locale;
            this.displayMode = displayMode;
            this.path = pathType;
            this.url = str;
            this.surveyOptionID = str2;
        }

        @SerialName
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDarkMode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRevisionID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getSurveyOptionID$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Paywalls extends BackendEvent {
        public static final Companion Companion = new Companion(null);
        private final String appUserID;
        private final String componentName;
        private final String componentType;
        private final String componentUrl;
        private final String componentValue;
        private final String currentPackageIdentifier;
        private final String currentProductIdentifier;
        private final boolean darkMode;
        private final Integer defaultIndex;
        private final String defaultPackageIdentifier;
        private final String defaultProductIdentifier;
        private final String destinationContextName;
        private final Integer destinationIndex;
        private final String destinationPackageIdentifier;
        private final String destinationProductIdentifier;
        private final String displayMode;
        private final Integer errorCode;
        private final String errorMessage;
        private final String exitOfferType;
        private final String exitOfferingID;
        private final String id;
        private final String localeIdentifier;
        private final String offeringID;
        private final String originContextName;
        private final Integer originIndex;
        private final String originPackageIdentifier;
        private final String originProductIdentifier;
        private final String packageID;
        private final String paywallID;
        private final int paywallRevision;
        private final PresentedOfferingContextData presentedOfferingContext;
        private final String productID;
        private final String resultingPackageIdentifier;
        private final String resultingProductIdentifier;
        private final String sessionID;
        private final long timestamp;
        private final String type;
        private final int version;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Paywalls> serializer() {
                return BackendEvent$Paywalls$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Paywalls(int i3, int i4, String str, int i5, String str2, @SerialName String str3, @SerialName String str4, @SerialName String str5, @SerialName String str6, @SerialName int i6, long j3, @SerialName String str7, @SerialName boolean z2, @SerialName String str8, @SerialName PresentedOfferingContextData presentedOfferingContextData, @SerialName String str9, @SerialName String str10, @SerialName String str11, @SerialName String str12, @SerialName Integer num, @SerialName String str13, @SerialName String str14, @SerialName String str15, @SerialName String str16, @SerialName String str17, @SerialName Integer num2, @SerialName Integer num3, @SerialName String str18, @SerialName String str19, @SerialName Integer num4, @SerialName String str20, @SerialName String str21, @SerialName String str22, @SerialName String str23, @SerialName String str24, @SerialName String str25, @SerialName String str26, @SerialName String str27, @SerialName String str28, @SerialName String str29, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (4095 != (i3 & 4095)) {
                PluginExceptionsKt.a(new int[]{i3, i4}, new int[]{4095, 0}, BackendEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i5;
            this.type = str2;
            this.appUserID = str3;
            this.sessionID = str4;
            this.offeringID = str5;
            this.paywallID = str6;
            this.paywallRevision = i6;
            this.timestamp = j3;
            this.displayMode = str7;
            this.darkMode = z2;
            this.localeIdentifier = str8;
            if ((i3 & 4096) == 0) {
                this.presentedOfferingContext = null;
            } else {
                this.presentedOfferingContext = presentedOfferingContextData;
            }
            if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                this.exitOfferType = null;
            } else {
                this.exitOfferType = str9;
            }
            if ((i3 & 16384) == 0) {
                this.exitOfferingID = null;
            } else {
                this.exitOfferingID = str10;
            }
            if ((32768 & i3) == 0) {
                this.packageID = null;
            } else {
                this.packageID = str11;
            }
            if ((65536 & i3) == 0) {
                this.productID = null;
            } else {
                this.productID = str12;
            }
            if ((131072 & i3) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num;
            }
            if ((262144 & i3) == 0) {
                this.errorMessage = null;
            } else {
                this.errorMessage = str13;
            }
            if ((524288 & i3) == 0) {
                this.componentType = null;
            } else {
                this.componentType = str14;
            }
            if ((1048576 & i3) == 0) {
                this.componentName = null;
            } else {
                this.componentName = str15;
            }
            if ((2097152 & i3) == 0) {
                this.componentValue = null;
            } else {
                this.componentValue = str16;
            }
            if ((4194304 & i3) == 0) {
                this.componentUrl = null;
            } else {
                this.componentUrl = str17;
            }
            if ((8388608 & i3) == 0) {
                this.originIndex = null;
            } else {
                this.originIndex = num2;
            }
            if ((16777216 & i3) == 0) {
                this.destinationIndex = null;
            } else {
                this.destinationIndex = num3;
            }
            if ((33554432 & i3) == 0) {
                this.originContextName = null;
            } else {
                this.originContextName = str18;
            }
            if ((67108864 & i3) == 0) {
                this.destinationContextName = null;
            } else {
                this.destinationContextName = str19;
            }
            if ((134217728 & i3) == 0) {
                this.defaultIndex = null;
            } else {
                this.defaultIndex = num4;
            }
            if ((268435456 & i3) == 0) {
                this.originPackageIdentifier = null;
            } else {
                this.originPackageIdentifier = str20;
            }
            if ((536870912 & i3) == 0) {
                this.destinationPackageIdentifier = null;
            } else {
                this.destinationPackageIdentifier = str21;
            }
            if ((1073741824 & i3) == 0) {
                this.defaultPackageIdentifier = null;
            } else {
                this.defaultPackageIdentifier = str22;
            }
            if ((i3 & Integer.MIN_VALUE) == 0) {
                this.originProductIdentifier = null;
            } else {
                this.originProductIdentifier = str23;
            }
            if ((i4 & 1) == 0) {
                this.destinationProductIdentifier = null;
            } else {
                this.destinationProductIdentifier = str24;
            }
            if ((i4 & 2) == 0) {
                this.defaultProductIdentifier = null;
            } else {
                this.defaultProductIdentifier = str25;
            }
            if ((i4 & 4) == 0) {
                this.currentPackageIdentifier = null;
            } else {
                this.currentPackageIdentifier = str26;
            }
            if ((i4 & 8) == 0) {
                this.resultingPackageIdentifier = null;
            } else {
                this.resultingPackageIdentifier = str27;
            }
            if ((i4 & 16) == 0) {
                this.currentProductIdentifier = null;
            } else {
                this.currentProductIdentifier = str28;
            }
            if ((i4 & 32) == 0) {
                this.resultingProductIdentifier = null;
            } else {
                this.resultingProductIdentifier = str29;
            }
        }

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, String str, int i3, String str2, String str3, String str4, String str5, String str6, int i4, long j3, String str7, boolean z2, String str8, PresentedOfferingContextData presentedOfferingContextData, String str9, String str10, String str11, String str12, Integer num, String str13, String str14, String str15, String str16, String str17, Integer num2, Integer num3, String str18, String str19, Integer num4, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, int i5, int i6, Object obj) {
            String str30;
            String str31;
            String str32;
            String str33;
            Integer num5;
            Integer num6;
            String str34;
            String str35;
            Integer num7;
            String str36;
            String str37;
            String str38;
            String str39;
            String str40;
            String str41;
            String str42;
            String str43;
            String str44;
            int i7;
            long j4;
            String str45;
            boolean z3;
            String str46;
            PresentedOfferingContextData presentedOfferingContextData2;
            String str47;
            String str48;
            String str49;
            Integer num8;
            String str50;
            String str51;
            String str52;
            int i8;
            String str53;
            String str54;
            String str55;
            String str56;
            String str57;
            String str58 = (i5 & 1) != 0 ? paywalls.id : str;
            int i9 = (i5 & 2) != 0 ? paywalls.version : i3;
            String str59 = (i5 & 4) != 0 ? paywalls.type : str2;
            String str60 = (i5 & 8) != 0 ? paywalls.appUserID : str3;
            String str61 = (i5 & 16) != 0 ? paywalls.sessionID : str4;
            String str62 = (i5 & 32) != 0 ? paywalls.offeringID : str5;
            String str63 = (i5 & 64) != 0 ? paywalls.paywallID : str6;
            int i10 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywalls.paywallRevision : i4;
            long j5 = (i5 & Function.MAX_NARGS) != 0 ? paywalls.timestamp : j3;
            String str64 = (i5 & 512) != 0 ? paywalls.displayMode : str7;
            boolean z4 = (i5 & 1024) != 0 ? paywalls.darkMode : z2;
            String str65 = (i5 & 2048) != 0 ? paywalls.localeIdentifier : str8;
            PresentedOfferingContextData presentedOfferingContextData3 = (i5 & 4096) != 0 ? paywalls.presentedOfferingContext : presentedOfferingContextData;
            String str66 = str58;
            String str67 = (i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywalls.exitOfferType : str9;
            String str68 = (i5 & 16384) != 0 ? paywalls.exitOfferingID : str10;
            String str69 = (i5 & 32768) != 0 ? paywalls.packageID : str11;
            String str70 = (i5 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywalls.productID : str12;
            Integer num9 = (i5 & 131072) != 0 ? paywalls.errorCode : num;
            String str71 = (i5 & 262144) != 0 ? paywalls.errorMessage : str13;
            String str72 = (i5 & 524288) != 0 ? paywalls.componentType : str14;
            String str73 = (i5 & 1048576) != 0 ? paywalls.componentName : str15;
            String str74 = (i5 & 2097152) != 0 ? paywalls.componentValue : str16;
            String str75 = (i5 & 4194304) != 0 ? paywalls.componentUrl : str17;
            Integer num10 = (i5 & 8388608) != 0 ? paywalls.originIndex : num2;
            Integer num11 = (i5 & 16777216) != 0 ? paywalls.destinationIndex : num3;
            String str76 = (i5 & 33554432) != 0 ? paywalls.originContextName : str18;
            String str77 = (i5 & 67108864) != 0 ? paywalls.destinationContextName : str19;
            Integer num12 = (i5 & 134217728) != 0 ? paywalls.defaultIndex : num4;
            String str78 = (i5 & 268435456) != 0 ? paywalls.originPackageIdentifier : str20;
            String str79 = (i5 & 536870912) != 0 ? paywalls.destinationPackageIdentifier : str21;
            String str80 = (i5 & 1073741824) != 0 ? paywalls.defaultPackageIdentifier : str22;
            String str81 = (i5 & Integer.MIN_VALUE) != 0 ? paywalls.originProductIdentifier : str23;
            String str82 = (i6 & 1) != 0 ? paywalls.destinationProductIdentifier : str24;
            String str83 = (i6 & 2) != 0 ? paywalls.defaultProductIdentifier : str25;
            String str84 = (i6 & 4) != 0 ? paywalls.currentPackageIdentifier : str26;
            String str85 = (i6 & 8) != 0 ? paywalls.resultingPackageIdentifier : str27;
            String str86 = (i6 & 16) != 0 ? paywalls.currentProductIdentifier : str28;
            if ((i6 & 32) != 0) {
                str31 = str86;
                str30 = paywalls.resultingProductIdentifier;
                str33 = str75;
                num5 = num10;
                num6 = num11;
                str34 = str76;
                str35 = str77;
                num7 = num12;
                str36 = str78;
                str37 = str79;
                str38 = str80;
                str39 = str81;
                str40 = str82;
                str41 = str83;
                str42 = str84;
                str43 = str85;
                str44 = str68;
                j4 = j5;
                str45 = str64;
                z3 = z4;
                str46 = str65;
                presentedOfferingContextData2 = presentedOfferingContextData3;
                str47 = str67;
                str48 = str69;
                str49 = str70;
                num8 = num9;
                str50 = str71;
                str51 = str72;
                str52 = str73;
                str32 = str74;
                i8 = i9;
                str53 = str59;
                str54 = str60;
                str55 = str61;
                str56 = str62;
                str57 = str63;
                i7 = i10;
            } else {
                str30 = str29;
                str31 = str86;
                str32 = str74;
                str33 = str75;
                num5 = num10;
                num6 = num11;
                str34 = str76;
                str35 = str77;
                num7 = num12;
                str36 = str78;
                str37 = str79;
                str38 = str80;
                str39 = str81;
                str40 = str82;
                str41 = str83;
                str42 = str84;
                str43 = str85;
                str44 = str68;
                i7 = i10;
                j4 = j5;
                str45 = str64;
                z3 = z4;
                str46 = str65;
                presentedOfferingContextData2 = presentedOfferingContextData3;
                str47 = str67;
                str48 = str69;
                str49 = str70;
                num8 = num9;
                str50 = str71;
                str51 = str72;
                str52 = str73;
                i8 = i9;
                str53 = str59;
                str54 = str60;
                str55 = str61;
                str56 = str62;
                str57 = str63;
            }
            return paywalls.copy(str66, i8, str53, str54, str55, str56, str57, i7, j4, str45, z3, str46, presentedOfferingContextData2, str47, str44, str48, str49, num8, str50, str51, str52, str32, str33, num5, num6, str34, str35, num7, str36, str37, str38, str39, str40, str41, str42, str43, str31, str30);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Paywalls paywalls, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            BackendEvent.write$Self(paywalls, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, paywalls.id);
            compositeEncoder.w(serialDescriptor, 1, paywalls.version);
            compositeEncoder.y(serialDescriptor, 2, paywalls.type);
            compositeEncoder.y(serialDescriptor, 3, paywalls.appUserID);
            compositeEncoder.y(serialDescriptor, 4, paywalls.sessionID);
            compositeEncoder.y(serialDescriptor, 5, paywalls.offeringID);
            StringSerializer stringSerializer = StringSerializer.f142891a;
            compositeEncoder.i(serialDescriptor, 6, stringSerializer, paywalls.paywallID);
            compositeEncoder.w(serialDescriptor, 7, paywalls.paywallRevision);
            compositeEncoder.F(serialDescriptor, 8, paywalls.timestamp);
            compositeEncoder.y(serialDescriptor, 9, paywalls.displayMode);
            compositeEncoder.x(serialDescriptor, 10, paywalls.darkMode);
            compositeEncoder.y(serialDescriptor, 11, paywalls.localeIdentifier);
            if (compositeEncoder.z(serialDescriptor, 12) || paywalls.presentedOfferingContext != null) {
                compositeEncoder.i(serialDescriptor, 12, BackendEvent$PresentedOfferingContextData$$serializer.INSTANCE, paywalls.presentedOfferingContext);
            }
            if (compositeEncoder.z(serialDescriptor, 13) || paywalls.exitOfferType != null) {
                compositeEncoder.i(serialDescriptor, 13, stringSerializer, paywalls.exitOfferType);
            }
            if (compositeEncoder.z(serialDescriptor, 14) || paywalls.exitOfferingID != null) {
                compositeEncoder.i(serialDescriptor, 14, stringSerializer, paywalls.exitOfferingID);
            }
            if (compositeEncoder.z(serialDescriptor, 15) || paywalls.packageID != null) {
                compositeEncoder.i(serialDescriptor, 15, stringSerializer, paywalls.packageID);
            }
            if (compositeEncoder.z(serialDescriptor, 16) || paywalls.productID != null) {
                compositeEncoder.i(serialDescriptor, 16, stringSerializer, paywalls.productID);
            }
            if (compositeEncoder.z(serialDescriptor, 17) || paywalls.errorCode != null) {
                compositeEncoder.i(serialDescriptor, 17, IntSerializer.f142823a, paywalls.errorCode);
            }
            if (compositeEncoder.z(serialDescriptor, 18) || paywalls.errorMessage != null) {
                compositeEncoder.i(serialDescriptor, 18, stringSerializer, paywalls.errorMessage);
            }
            if (compositeEncoder.z(serialDescriptor, 19) || paywalls.componentType != null) {
                compositeEncoder.i(serialDescriptor, 19, stringSerializer, paywalls.componentType);
            }
            if (compositeEncoder.z(serialDescriptor, 20) || paywalls.componentName != null) {
                compositeEncoder.i(serialDescriptor, 20, stringSerializer, paywalls.componentName);
            }
            if (compositeEncoder.z(serialDescriptor, 21) || paywalls.componentValue != null) {
                compositeEncoder.i(serialDescriptor, 21, stringSerializer, paywalls.componentValue);
            }
            if (compositeEncoder.z(serialDescriptor, 22) || paywalls.componentUrl != null) {
                compositeEncoder.i(serialDescriptor, 22, stringSerializer, paywalls.componentUrl);
            }
            if (compositeEncoder.z(serialDescriptor, 23) || paywalls.originIndex != null) {
                compositeEncoder.i(serialDescriptor, 23, IntSerializer.f142823a, paywalls.originIndex);
            }
            if (compositeEncoder.z(serialDescriptor, 24) || paywalls.destinationIndex != null) {
                compositeEncoder.i(serialDescriptor, 24, IntSerializer.f142823a, paywalls.destinationIndex);
            }
            if (compositeEncoder.z(serialDescriptor, 25) || paywalls.originContextName != null) {
                compositeEncoder.i(serialDescriptor, 25, stringSerializer, paywalls.originContextName);
            }
            if (compositeEncoder.z(serialDescriptor, 26) || paywalls.destinationContextName != null) {
                compositeEncoder.i(serialDescriptor, 26, stringSerializer, paywalls.destinationContextName);
            }
            if (compositeEncoder.z(serialDescriptor, 27) || paywalls.defaultIndex != null) {
                compositeEncoder.i(serialDescriptor, 27, IntSerializer.f142823a, paywalls.defaultIndex);
            }
            if (compositeEncoder.z(serialDescriptor, 28) || paywalls.originPackageIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 28, stringSerializer, paywalls.originPackageIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 29) || paywalls.destinationPackageIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 29, stringSerializer, paywalls.destinationPackageIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 30) || paywalls.defaultPackageIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 30, stringSerializer, paywalls.defaultPackageIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 31) || paywalls.originProductIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 31, stringSerializer, paywalls.originProductIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 32) || paywalls.destinationProductIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 32, stringSerializer, paywalls.destinationProductIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 33) || paywalls.defaultProductIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 33, stringSerializer, paywalls.defaultProductIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 34) || paywalls.currentPackageIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 34, stringSerializer, paywalls.currentPackageIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 35) || paywalls.resultingPackageIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 35, stringSerializer, paywalls.resultingPackageIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 36) || paywalls.currentProductIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 36, stringSerializer, paywalls.currentProductIdentifier);
            }
            if (!compositeEncoder.z(serialDescriptor, 37) && paywalls.resultingProductIdentifier == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 37, stringSerializer, paywalls.resultingProductIdentifier);
        }

        public final String component1() {
            return this.id;
        }

        public final String component10() {
            return this.displayMode;
        }

        public final boolean component11() {
            return this.darkMode;
        }

        public final String component12() {
            return this.localeIdentifier;
        }

        public final PresentedOfferingContextData component13() {
            return this.presentedOfferingContext;
        }

        public final String component14() {
            return this.exitOfferType;
        }

        public final String component15() {
            return this.exitOfferingID;
        }

        public final String component16() {
            return this.packageID;
        }

        public final String component17() {
            return this.productID;
        }

        public final Integer component18() {
            return this.errorCode;
        }

        public final String component19() {
            return this.errorMessage;
        }

        public final int component2() {
            return this.version;
        }

        public final String component20() {
            return this.componentType;
        }

        public final String component21() {
            return this.componentName;
        }

        public final String component22() {
            return this.componentValue;
        }

        public final String component23() {
            return this.componentUrl;
        }

        public final Integer component24() {
            return this.originIndex;
        }

        public final Integer component25() {
            return this.destinationIndex;
        }

        public final String component26() {
            return this.originContextName;
        }

        public final String component27() {
            return this.destinationContextName;
        }

        public final Integer component28() {
            return this.defaultIndex;
        }

        public final String component29() {
            return this.originPackageIdentifier;
        }

        public final String component3() {
            return this.type;
        }

        public final String component30() {
            return this.destinationPackageIdentifier;
        }

        public final String component31() {
            return this.defaultPackageIdentifier;
        }

        public final String component32() {
            return this.originProductIdentifier;
        }

        public final String component33() {
            return this.destinationProductIdentifier;
        }

        public final String component34() {
            return this.defaultProductIdentifier;
        }

        public final String component35() {
            return this.currentPackageIdentifier;
        }

        public final String component36() {
            return this.resultingPackageIdentifier;
        }

        public final String component37() {
            return this.currentProductIdentifier;
        }

        public final String component38() {
            return this.resultingProductIdentifier;
        }

        public final String component4() {
            return this.appUserID;
        }

        public final String component5() {
            return this.sessionID;
        }

        public final String component6() {
            return this.offeringID;
        }

        public final String component7() {
            return this.paywallID;
        }

        public final int component8() {
            return this.paywallRevision;
        }

        public final long component9() {
            return this.timestamp;
        }

        public final Paywalls copy(String id, int i3, String type, String appUserID, String sessionID, String offeringID, String str, int i4, long j3, String displayMode, boolean z2, String localeIdentifier, PresentedOfferingContextData presentedOfferingContextData, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, Integer num2, Integer num3, String str11, String str12, Integer num4, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new Paywalls(id, i3, type, appUserID, sessionID, offeringID, str, i4, j3, displayMode, z2, localeIdentifier, presentedOfferingContextData, str2, str3, str4, str5, num, str6, str7, str8, str9, str10, num2, num3, str11, str12, num4, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Paywalls)) {
                return false;
            }
            Paywalls paywalls = (Paywalls) obj;
            return Intrinsics.areEqual(this.id, paywalls.id) && this.version == paywalls.version && Intrinsics.areEqual(this.type, paywalls.type) && Intrinsics.areEqual(this.appUserID, paywalls.appUserID) && Intrinsics.areEqual(this.sessionID, paywalls.sessionID) && Intrinsics.areEqual(this.offeringID, paywalls.offeringID) && Intrinsics.areEqual(this.paywallID, paywalls.paywallID) && this.paywallRevision == paywalls.paywallRevision && this.timestamp == paywalls.timestamp && Intrinsics.areEqual(this.displayMode, paywalls.displayMode) && this.darkMode == paywalls.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywalls.localeIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, paywalls.presentedOfferingContext) && Intrinsics.areEqual(this.exitOfferType, paywalls.exitOfferType) && Intrinsics.areEqual(this.exitOfferingID, paywalls.exitOfferingID) && Intrinsics.areEqual(this.packageID, paywalls.packageID) && Intrinsics.areEqual(this.productID, paywalls.productID) && Intrinsics.areEqual(this.errorCode, paywalls.errorCode) && Intrinsics.areEqual(this.errorMessage, paywalls.errorMessage) && Intrinsics.areEqual(this.componentType, paywalls.componentType) && Intrinsics.areEqual(this.componentName, paywalls.componentName) && Intrinsics.areEqual(this.componentValue, paywalls.componentValue) && Intrinsics.areEqual(this.componentUrl, paywalls.componentUrl) && Intrinsics.areEqual(this.originIndex, paywalls.originIndex) && Intrinsics.areEqual(this.destinationIndex, paywalls.destinationIndex) && Intrinsics.areEqual(this.originContextName, paywalls.originContextName) && Intrinsics.areEqual(this.destinationContextName, paywalls.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, paywalls.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, paywalls.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, paywalls.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, paywalls.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, paywalls.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, paywalls.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, paywalls.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, paywalls.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, paywalls.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, paywalls.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, paywalls.resultingProductIdentifier);
        }

        public final String getAppUserID() {
            return this.appUserID;
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

        public final boolean getDarkMode() {
            return this.darkMode;
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

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getOfferingID() {
            return this.offeringID;
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

        public final String getPackageID() {
            return this.packageID;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final PresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final String getProductID() {
            return this.productID;
        }

        public final String getResultingPackageIdentifier() {
            return this.resultingPackageIdentifier;
        }

        public final String getResultingProductIdentifier() {
            return this.resultingProductIdentifier;
        }

        public final String getSessionID() {
            return this.sessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + this.offeringID.hashCode()) * 31;
            String str = this.paywallID;
            int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.displayMode.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.localeIdentifier.hashCode()) * 31;
            PresentedOfferingContextData presentedOfferingContextData = this.presentedOfferingContext;
            int iHashCode3 = (iHashCode2 + (presentedOfferingContextData == null ? 0 : presentedOfferingContextData.hashCode())) * 31;
            String str2 = this.exitOfferType;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.exitOfferingID;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.packageID;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.productID;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.errorCode;
            int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
            String str6 = this.errorMessage;
            int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.componentType;
            int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.componentName;
            int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.componentValue;
            int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.componentUrl;
            int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Integer num2 = this.originIndex;
            int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.destinationIndex;
            int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str11 = this.originContextName;
            int iHashCode16 = (iHashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.destinationContextName;
            int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Integer num4 = this.defaultIndex;
            int iHashCode18 = (iHashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str13 = this.originPackageIdentifier;
            int iHashCode19 = (iHashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.destinationPackageIdentifier;
            int iHashCode20 = (iHashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.defaultPackageIdentifier;
            int iHashCode21 = (iHashCode20 + (str15 == null ? 0 : str15.hashCode())) * 31;
            String str16 = this.originProductIdentifier;
            int iHashCode22 = (iHashCode21 + (str16 == null ? 0 : str16.hashCode())) * 31;
            String str17 = this.destinationProductIdentifier;
            int iHashCode23 = (iHashCode22 + (str17 == null ? 0 : str17.hashCode())) * 31;
            String str18 = this.defaultProductIdentifier;
            int iHashCode24 = (iHashCode23 + (str18 == null ? 0 : str18.hashCode())) * 31;
            String str19 = this.currentPackageIdentifier;
            int iHashCode25 = (iHashCode24 + (str19 == null ? 0 : str19.hashCode())) * 31;
            String str20 = this.resultingPackageIdentifier;
            int iHashCode26 = (iHashCode25 + (str20 == null ? 0 : str20.hashCode())) * 31;
            String str21 = this.currentProductIdentifier;
            int iHashCode27 = (iHashCode26 + (str21 == null ? 0 : str21.hashCode())) * 31;
            String str22 = this.resultingProductIdentifier;
            return iHashCode27 + (str22 != null ? str22.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Paywalls(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", sessionID=" + this.sessionID + ", offeringID=" + this.offeringID + ", paywallID=" + this.paywallID + ", paywallRevision=" + this.paywallRevision + ", timestamp=" + this.timestamp + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ", exitOfferType=" + this.exitOfferType + ", exitOfferingID=" + this.exitOfferingID + ", packageID=" + this.packageID + ", productID=" + this.productID + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", componentType=" + this.componentType + ", componentName=" + this.componentName + ", componentValue=" + this.componentValue + ", componentUrl=" + this.componentUrl + ", originIndex=" + this.originIndex + ", destinationIndex=" + this.destinationIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ", defaultIndex=" + this.defaultIndex + ", originPackageIdentifier=" + this.originPackageIdentifier + ", destinationPackageIdentifier=" + this.destinationPackageIdentifier + ", defaultPackageIdentifier=" + this.defaultPackageIdentifier + ", originProductIdentifier=" + this.originProductIdentifier + ", destinationProductIdentifier=" + this.destinationProductIdentifier + ", defaultProductIdentifier=" + this.defaultProductIdentifier + ", currentPackageIdentifier=" + this.currentPackageIdentifier + ", resultingPackageIdentifier=" + this.resultingPackageIdentifier + ", currentProductIdentifier=" + this.currentProductIdentifier + ", resultingProductIdentifier=" + this.resultingProductIdentifier + ')';
        }

        public /* synthetic */ Paywalls(String str, int i3, String str2, String str3, String str4, String str5, String str6, int i4, long j3, String str7, boolean z2, String str8, PresentedOfferingContextData presentedOfferingContextData, String str9, String str10, String str11, String str12, Integer num, String str13, String str14, String str15, String str16, String str17, Integer num2, Integer num3, String str18, String str19, Integer num4, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, str2, str3, str4, str5, str6, i4, j3, str7, z2, str8, (i5 & 4096) != 0 ? null : presentedOfferingContextData, (i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str9, (i5 & 16384) != 0 ? null : str10, (32768 & i5) != 0 ? null : str11, (65536 & i5) != 0 ? null : str12, (131072 & i5) != 0 ? null : num, (262144 & i5) != 0 ? null : str13, (524288 & i5) != 0 ? null : str14, (1048576 & i5) != 0 ? null : str15, (2097152 & i5) != 0 ? null : str16, (4194304 & i5) != 0 ? null : str17, (8388608 & i5) != 0 ? null : num2, (16777216 & i5) != 0 ? null : num3, (33554432 & i5) != 0 ? null : str18, (67108864 & i5) != 0 ? null : str19, (134217728 & i5) != 0 ? null : num4, (268435456 & i5) != 0 ? null : str20, (536870912 & i5) != 0 ? null : str21, (1073741824 & i5) != 0 ? null : str22, (i5 & Integer.MIN_VALUE) != 0 ? null : str23, (i6 & 1) != 0 ? null : str24, (i6 & 2) != 0 ? null : str25, (i6 & 4) != 0 ? null : str26, (i6 & 8) != 0 ? null : str27, (i6 & 16) != 0 ? null : str28, (i6 & 32) != 0 ? null : str29);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(String id, int i3, String type, String appUserID, String sessionID, String offeringID, String str, int i4, long j3, String displayMode, boolean z2, String localeIdentifier, PresentedOfferingContextData presentedOfferingContextData, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, Integer num2, Integer num3, String str11, String str12, Integer num4, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.id = id;
            this.version = i3;
            this.type = type;
            this.appUserID = appUserID;
            this.sessionID = sessionID;
            this.offeringID = offeringID;
            this.paywallID = str;
            this.paywallRevision = i4;
            this.timestamp = j3;
            this.displayMode = displayMode;
            this.darkMode = z2;
            this.localeIdentifier = localeIdentifier;
            this.presentedOfferingContext = presentedOfferingContextData;
            this.exitOfferType = str2;
            this.exitOfferingID = str3;
            this.packageID = str4;
            this.productID = str5;
            this.errorCode = num;
            this.errorMessage = str6;
            this.componentType = str7;
            this.componentName = str8;
            this.componentValue = str9;
            this.componentUrl = str10;
            this.originIndex = num2;
            this.destinationIndex = num3;
            this.originContextName = str11;
            this.destinationContextName = str12;
            this.defaultIndex = num4;
            this.originPackageIdentifier = str13;
            this.destinationPackageIdentifier = str14;
            this.defaultPackageIdentifier = str15;
            this.originProductIdentifier = str16;
            this.destinationProductIdentifier = str17;
            this.defaultProductIdentifier = str18;
            this.currentPackageIdentifier = str19;
            this.resultingPackageIdentifier = str20;
            this.currentProductIdentifier = str21;
            this.resultingProductIdentifier = str22;
        }

        @SerialName
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getComponentName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getComponentType$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getComponentUrl$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getComponentValue$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getCurrentPackageIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getCurrentProductIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDarkMode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDefaultIndex$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDefaultPackageIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDefaultProductIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDestinationContextName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDestinationIndex$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDestinationPackageIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDestinationProductIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getErrorCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getErrorMessage$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getExitOfferType$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getExitOfferingID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getLocaleIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOfferingID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOriginContextName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOriginIndex$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOriginPackageIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getOriginProductIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPackageID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPaywallID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPaywallRevision$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPresentedOfferingContext$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getProductID$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getResultingPackageIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getResultingProductIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getSessionID$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class PresentedOfferingContextData {
        public static final Companion Companion = new Companion(null);
        private final String placementIdentifier;
        private final Integer targetingRevision;
        private final String targetingRuleId;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PresentedOfferingContextData fromContext(PresentedOfferingContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                if (context.getPlacementIdentifier() == null && context.getTargetingContext() == null) {
                    return null;
                }
                String placementIdentifier = context.getPlacementIdentifier();
                PresentedOfferingContext.TargetingContext targetingContext = context.getTargetingContext();
                Integer numValueOf = targetingContext != null ? Integer.valueOf(targetingContext.getRevision()) : null;
                PresentedOfferingContext.TargetingContext targetingContext2 = context.getTargetingContext();
                return new PresentedOfferingContextData(placementIdentifier, numValueOf, targetingContext2 != null ? targetingContext2.getRuleId() : null);
            }

            public final KSerializer<PresentedOfferingContextData> serializer() {
                return BackendEvent$PresentedOfferingContextData$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public PresentedOfferingContextData() {
            this((String) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PresentedOfferingContextData copy$default(PresentedOfferingContextData presentedOfferingContextData, String str, Integer num, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = presentedOfferingContextData.placementIdentifier;
            }
            if ((i3 & 2) != 0) {
                num = presentedOfferingContextData.targetingRevision;
            }
            if ((i3 & 4) != 0) {
                str2 = presentedOfferingContextData.targetingRuleId;
            }
            return presentedOfferingContextData.copy(str, num, str2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PresentedOfferingContextData presentedOfferingContextData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (compositeEncoder.z(serialDescriptor, 0) || presentedOfferingContextData.placementIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 0, StringSerializer.f142891a, presentedOfferingContextData.placementIdentifier);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || presentedOfferingContextData.targetingRevision != null) {
                compositeEncoder.i(serialDescriptor, 1, IntSerializer.f142823a, presentedOfferingContextData.targetingRevision);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && presentedOfferingContextData.targetingRuleId == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 2, StringSerializer.f142891a, presentedOfferingContextData.targetingRuleId);
        }

        public final String component1() {
            return this.placementIdentifier;
        }

        public final Integer component2() {
            return this.targetingRevision;
        }

        public final String component3() {
            return this.targetingRuleId;
        }

        public final PresentedOfferingContextData copy(String str, Integer num, String str2) {
            return new PresentedOfferingContextData(str, num, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PresentedOfferingContextData)) {
                return false;
            }
            PresentedOfferingContextData presentedOfferingContextData = (PresentedOfferingContextData) obj;
            return Intrinsics.areEqual(this.placementIdentifier, presentedOfferingContextData.placementIdentifier) && Intrinsics.areEqual(this.targetingRevision, presentedOfferingContextData.targetingRevision) && Intrinsics.areEqual(this.targetingRuleId, presentedOfferingContextData.targetingRuleId);
        }

        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        public int hashCode() {
            String str = this.placementIdentifier;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.targetingRevision;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.targetingRuleId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "PresentedOfferingContextData(placementIdentifier=" + this.placementIdentifier + ", targetingRevision=" + this.targetingRevision + ", targetingRuleId=" + this.targetingRuleId + ')';
        }

        @Deprecated
        public /* synthetic */ PresentedOfferingContextData(int i3, @SerialName String str, @SerialName Integer num, @SerialName String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i3 & 1) == 0) {
                this.placementIdentifier = null;
            } else {
                this.placementIdentifier = str;
            }
            if ((i3 & 2) == 0) {
                this.targetingRevision = null;
            } else {
                this.targetingRevision = num;
            }
            if ((i3 & 4) == 0) {
                this.targetingRuleId = null;
            } else {
                this.targetingRuleId = str2;
            }
        }

        public PresentedOfferingContextData(String str, Integer num, String str2) {
            this.placementIdentifier = str;
            this.targetingRevision = num;
            this.targetingRuleId = str2;
        }

        public /* synthetic */ PresentedOfferingContextData(String str, Integer num, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str2);
        }

        @SerialName
        public static /* synthetic */ void getPlacementIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTargetingRevision$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTargetingRuleId$annotations() {
        }
    }

    public /* synthetic */ BackendEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BackendEvent() {
    }

    @Deprecated
    public /* synthetic */ BackendEvent(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(BackendEvent backendEvent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
