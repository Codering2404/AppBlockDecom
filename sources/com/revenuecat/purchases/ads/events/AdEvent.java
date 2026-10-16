package com.revenuecat.purchases.ads.events;

import com.revenuecat.purchases.common.events.FeatureEvent;
import com.sun.jna.Function;
import java.util.UUID;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface AdEvent extends FeatureEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isPriorityEvent(AdEvent adEvent) {
            return AdEvent.super.isPriorityEvent();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Displayed implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Displayed(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, adEventType, j3, str2, str3, str4, str5, str6, str7);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q */
        public String mo469getAdFormaty0COY5Q() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4 */
        public String mo470getMediatorNameGyoM_N4() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        private Displayed(String id, int i3, AdEventType type, long j3, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            this.id = id;
            this.eventVersion = i3;
            this.type = type;
            this.timestamp = j3;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Displayed(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i4 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i4 & 2) != 0 ? 1 : i3, (i4 & 4) != 0 ? AdEventType.DISPLAYED : adEventType, (i4 & 8) != 0 ? System.currentTimeMillis() : j3, str2, str3, str4, str5, str6, str7, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FailedToLoad implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final Integer mediatorErrorCode;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ FailedToLoad(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, adEventType, j3, str2, str3, str4, str5, str6, num);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q */
        public String mo469getAdFormaty0COY5Q() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4 */
        public String mo470getMediatorNameGyoM_N4() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        private FailedToLoad(String id, int i3, AdEventType type, long j3, String mediatorName, String adFormat, String str, String adUnitId, String str2, Integer num) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            this.id = id;
            this.eventVersion = i3;
            this.type = type;
            this.timestamp = j3;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str;
            this.adUnitId = adUnitId;
            this.impressionId = str2;
            this.mediatorErrorCode = num;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ FailedToLoad(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            String str7;
            if ((i4 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str7 = string;
            } else {
                str7 = str;
            }
            this(str7, (i4 & 2) != 0 ? 1 : i3, (i4 & 4) != 0 ? AdEventType.FAILED_TO_LOAD : adEventType, (i4 & 8) != 0 ? System.currentTimeMillis() : j3, str2, str3, str4, str5, (i4 & Function.MAX_NARGS) != 0 ? null : str6, num, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loaded implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Loaded(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, adEventType, j3, str2, str3, str4, str5, str6, str7);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q */
        public String mo469getAdFormaty0COY5Q() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4 */
        public String mo470getMediatorNameGyoM_N4() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        private Loaded(String id, int i3, AdEventType type, long j3, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            this.id = id;
            this.eventVersion = i3;
            this.type = type;
            this.timestamp = j3;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Loaded(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i4 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i4 & 2) != 0 ? 1 : i3, (i4 & 4) != 0 ? AdEventType.LOADED : adEventType, (i4 & 8) != 0 ? System.currentTimeMillis() : j3, str2, str3, str4, str5, str6, str7, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Open implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Open(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, adEventType, j3, str2, str3, str4, str5, str6, str7);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q */
        public String mo469getAdFormaty0COY5Q() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4 */
        public String mo470getMediatorNameGyoM_N4() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        private Open(String id, int i3, AdEventType type, long j3, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            this.id = id;
            this.eventVersion = i3;
            this.type = type;
            this.timestamp = j3;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Open(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            String str8;
            if ((i4 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str8 = string;
            } else {
                str8 = str;
            }
            this(str8, (i4 & 2) != 0 ? 1 : i3, (i4 & 4) != 0 ? AdEventType.OPENED : adEventType, (i4 & 8) != 0 ? System.currentTimeMillis() : j3, str2, str3, str4, str5, str6, str7, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Revenue implements AdEvent {
        private final String adFormat;
        private final String adUnitId;
        private final String currency;
        private final int eventVersion;
        private final String id;
        private final String impressionId;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final String precision;
        private final long revenueMicros;
        private final long timestamp;
        private final AdEventType type;

        public /* synthetic */ Revenue(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, long j4, String str8, String str9, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, adEventType, j3, str2, str3, str4, str5, str6, str7, j4, str8, str9);
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getAdFormat-y0COY5Q */
        public String mo469getAdFormaty0COY5Q() {
            return this.adFormat;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getAdUnitId() {
            return this.adUnitId;
        }

        public final String getCurrency() {
            return this.currency;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public int getEventVersion() {
            return this.eventVersion;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getId() {
            return this.id;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getImpressionId() {
            return this.impressionId;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        /* JADX INFO: renamed from: getMediatorName-GyoM_N4 */
        public String mo470getMediatorNameGyoM_N4() {
            return this.mediatorName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getNetworkName() {
            return this.networkName;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public String getPlacement() {
            return this.placement;
        }

        /* JADX INFO: renamed from: getPrecision-rAcPn4k, reason: not valid java name */
        public final String m471getPrecisionrAcPn4k() {
            return this.precision;
        }

        public final long getRevenueMicros() {
            return this.revenueMicros;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public long getTimestamp() {
            return this.timestamp;
        }

        @Override // com.revenuecat.purchases.ads.events.AdEvent
        public AdEventType getType() {
            return this.type;
        }

        private Revenue(String id, int i3, AdEventType type, long j3, String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, long j4, String currency, String precision) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adFormat, "adFormat");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(impressionId, "impressionId");
            Intrinsics.checkNotNullParameter(currency, "currency");
            Intrinsics.checkNotNullParameter(precision, "precision");
            this.id = id;
            this.eventVersion = i3;
            this.type = type;
            this.timestamp = j3;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = adFormat;
            this.placement = str2;
            this.adUnitId = adUnitId;
            this.impressionId = impressionId;
            this.revenueMicros = j4;
            this.currency = currency;
            this.precision = precision;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Revenue(String str, int i3, AdEventType adEventType, long j3, String str2, String str3, String str4, String str5, String str6, String str7, long j4, String str8, String str9, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            String str10;
            if ((i4 & 1) != 0) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
                str10 = string;
            } else {
                str10 = str;
            }
            this(str10, (i4 & 2) != 0 ? 1 : i3, (i4 & 4) != 0 ? AdEventType.REVENUE : adEventType, (i4 & 8) != 0 ? System.currentTimeMillis() : j3, str2, str3, str4, str5, str6, str7, j4, str8, str9, null);
        }
    }

    /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: not valid java name */
    String mo469getAdFormaty0COY5Q();

    String getAdUnitId();

    int getEventVersion();

    String getId();

    String getImpressionId();

    /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: not valid java name */
    String mo470getMediatorNameGyoM_N4();

    String getNetworkName();

    String getPlacement();

    long getTimestamp();

    AdEventType getType();
}
