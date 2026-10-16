package com.superwall.sdk.models.internal;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.models.internal.StoreIdentifiers;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonElement;
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
@JsonClassDiscriminator(discriminator = AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
@Metadata
@Serializable
public abstract class RedemptionResult {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: f0.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return RedemptionResult._init_$_anonymous_();
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) RedemptionResult.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<RedemptionResult> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Error extends RedemptionResult {
        public static final Companion Companion = new Companion(null);
        private final String code;
        private final ErrorInfo error;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Error> serializer() {
                return RedemptionResult$Error$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(int i3, String str, ErrorInfo errorInfo, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, RedemptionResult$Error$$serializer.INSTANCE.getDescriptor());
            }
            this.code = str;
            this.error = errorInfo;
        }

        public static /* synthetic */ Error copy$default(Error error, String str, ErrorInfo errorInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = error.code;
            }
            if ((i3 & 2) != 0) {
                errorInfo = error.error;
            }
            return error.copy(str, errorInfo);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Error error, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            RedemptionResult.write$Self(error, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, error.getCode());
            compositeEncoder.C(serialDescriptor, 1, ErrorInfo$$serializer.INSTANCE, error.error);
        }

        public final String component1() {
            return this.code;
        }

        public final ErrorInfo component2() {
            return this.error;
        }

        public final Error copy(String code, ErrorInfo error) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(code, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual(this.code, error.code) && Intrinsics.areEqual(this.error, error.error);
        }

        @Override // com.superwall.sdk.models.internal.RedemptionResult
        public String getCode() {
            return this.code;
        }

        public final ErrorInfo getError() {
            return this.error;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "Error(code=" + this.code + ", error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String code, ErrorInfo error) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(error, "error");
            this.code = code;
            this.error = error;
        }

        @SerialName
        public static /* synthetic */ void getCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getError$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class Expired extends RedemptionResult {
        public static final Companion Companion = new Companion(null);
        private final String code;
        private final ExpiredInfo expired;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Expired> serializer() {
                return RedemptionResult$Expired$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Expired(int i3, String str, ExpiredInfo expiredInfo, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, RedemptionResult$Expired$$serializer.INSTANCE.getDescriptor());
            }
            this.code = str;
            this.expired = expiredInfo;
        }

        public static /* synthetic */ Expired copy$default(Expired expired, String str, ExpiredInfo expiredInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = expired.code;
            }
            if ((i3 & 2) != 0) {
                expiredInfo = expired.expired;
            }
            return expired.copy(str, expiredInfo);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(Expired expired, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            RedemptionResult.write$Self(expired, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, expired.getCode());
            compositeEncoder.C(serialDescriptor, 1, ExpiredInfo$$serializer.INSTANCE, expired.expired);
        }

        public final String component1() {
            return this.code;
        }

        public final ExpiredInfo component2() {
            return this.expired;
        }

        public final Expired copy(String code, ExpiredInfo expired) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(expired, "expired");
            return new Expired(code, expired);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Expired)) {
                return false;
            }
            Expired expired = (Expired) obj;
            return Intrinsics.areEqual(this.code, expired.code) && Intrinsics.areEqual(this.expired, expired.expired);
        }

        @Override // com.superwall.sdk.models.internal.RedemptionResult
        public String getCode() {
            return this.code;
        }

        public final ExpiredInfo getExpired() {
            return this.expired;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.expired.hashCode();
        }

        public String toString() {
            return "Expired(code=" + this.code + ", expired=" + this.expired + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Expired(String code, ExpiredInfo expired) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(expired, "expired");
            this.code = code;
            this.expired = expired;
        }

        @SerialName
        public static /* synthetic */ void getCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getExpired$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class ExpiredSubscription extends RedemptionResult {
        public static final Companion Companion = new Companion(null);
        private final String code;
        private final RedemptionInfo redemptionInfo;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ExpiredSubscription> serializer() {
                return RedemptionResult$ExpiredSubscription$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExpiredSubscription(int i3, String str, RedemptionInfo redemptionInfo, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, RedemptionResult$ExpiredSubscription$$serializer.INSTANCE.getDescriptor());
            }
            this.code = str;
            this.redemptionInfo = redemptionInfo;
        }

        public static /* synthetic */ ExpiredSubscription copy$default(ExpiredSubscription expiredSubscription, String str, RedemptionInfo redemptionInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = expiredSubscription.code;
            }
            if ((i3 & 2) != 0) {
                redemptionInfo = expiredSubscription.redemptionInfo;
            }
            return expiredSubscription.copy(str, redemptionInfo);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(ExpiredSubscription expiredSubscription, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            RedemptionResult.write$Self(expiredSubscription, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, expiredSubscription.getCode());
            compositeEncoder.C(serialDescriptor, 1, RedemptionInfo$$serializer.INSTANCE, expiredSubscription.redemptionInfo);
        }

        public final String component1() {
            return this.code;
        }

        public final RedemptionInfo component2() {
            return this.redemptionInfo;
        }

        public final ExpiredSubscription copy(String code, RedemptionInfo redemptionInfo) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(redemptionInfo, "redemptionInfo");
            return new ExpiredSubscription(code, redemptionInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExpiredSubscription)) {
                return false;
            }
            ExpiredSubscription expiredSubscription = (ExpiredSubscription) obj;
            return Intrinsics.areEqual(this.code, expiredSubscription.code) && Intrinsics.areEqual(this.redemptionInfo, expiredSubscription.redemptionInfo);
        }

        @Override // com.superwall.sdk.models.internal.RedemptionResult
        public String getCode() {
            return this.code;
        }

        public final RedemptionInfo getRedemptionInfo() {
            return this.redemptionInfo;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.redemptionInfo.hashCode();
        }

        public String toString() {
            return "ExpiredSubscription(code=" + this.code + ", redemptionInfo=" + this.redemptionInfo + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExpiredSubscription(String code, RedemptionInfo redemptionInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(redemptionInfo, "redemptionInfo");
            this.code = code;
            this.redemptionInfo = redemptionInfo;
        }

        @SerialName
        public static /* synthetic */ void getCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRedemptionInfo$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    @SerialName
    public static final class InvalidCode extends RedemptionResult {
        public static final Companion Companion = new Companion(null);
        private final String code;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<InvalidCode> serializer() {
                return RedemptionResult$InvalidCode$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ InvalidCode(int i3, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i3, serializationConstructorMarker);
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, RedemptionResult$InvalidCode$$serializer.INSTANCE.getDescriptor());
            }
            this.code = str;
        }

        public static /* synthetic */ InvalidCode copy$default(InvalidCode invalidCode, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = invalidCode.code;
            }
            return invalidCode.copy(str);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(InvalidCode invalidCode, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            RedemptionResult.write$Self(invalidCode, compositeEncoder, serialDescriptor);
            compositeEncoder.y(serialDescriptor, 0, invalidCode.getCode());
        }

        public final String component1() {
            return this.code;
        }

        public final InvalidCode copy(String code) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new InvalidCode(code);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InvalidCode) && Intrinsics.areEqual(this.code, ((InvalidCode) obj).code);
        }

        @Override // com.superwall.sdk.models.internal.RedemptionResult
        public String getCode() {
            return this.code;
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "InvalidCode(code=" + this.code + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidCode(String code) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
        }

        @SerialName
        public static /* synthetic */ void getCode$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class PaywallInfo {
        private final String experimentId;
        private final String identifier;
        private final String placementName;
        private final Map<String, JsonElement> placementParams;
        private PaywallProduct product;
        private final String productIdentifier;
        private final String variantId;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new LinkedHashMapSerializer(StringSerializer.f142891a, JsonElementSerializer.f143009a), null, null, null, null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<PaywallInfo> serializer() {
                return RedemptionResult$PaywallInfo$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class PaywallProduct {
            public static final Companion Companion = new Companion(null);
            private final String currencyCode;
            private final String currencySymbol;
            private final String dailyPrice;
            private final String identifier;
            private final String languageCode;
            private final String locale;
            private final String localizedPeriod;
            private final String monthlyPrice;
            private final String period;
            private final String periodAlt;
            private final int periodDays;
            private final int periodMonths;
            private final int periodWeeks;
            private final int periodYears;
            private final String periodly;
            private final String price;
            private final double rawPrice;
            private final double rawTrialPeriodPrice;
            private final String trialPeriodDailyPrice;
            private final int trialPeriodDays;
            private final String trialPeriodEndDate;
            private final String trialPeriodMonthlyPrice;
            private final int trialPeriodMonths;
            private final String trialPeriodPrice;
            private final String trialPeriodText;
            private final String trialPeriodWeeklyPrice;
            private final int trialPeriodWeeks;
            private final String trialPeriodYearlyPrice;
            private final int trialPeriodYears;
            private final String weeklyPrice;
            private final String yearlyPrice;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<PaywallProduct> serializer() {
                    return RedemptionResult$PaywallInfo$PaywallProduct$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ PaywallProduct(int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i4, int i5, int i6, int i7, double d3, String str10, String str11, String str12, String str13, String str14, double d4, String str15, String str16, String str17, String str18, String str19, int i8, int i9, int i10, int i11, String str20, String str21, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i3 & 1)) {
                    PluginExceptionsKt.b(i3, 1, RedemptionResult$PaywallInfo$PaywallProduct$$serializer.INSTANCE.getDescriptor());
                }
                this.identifier = str;
                if ((i3 & 2) == 0) {
                    this.languageCode = "";
                } else {
                    this.languageCode = str2;
                }
                if ((i3 & 4) == 0) {
                    this.locale = "";
                } else {
                    this.locale = str3;
                }
                if ((i3 & 8) == 0) {
                    this.currencyCode = "";
                } else {
                    this.currencyCode = str4;
                }
                if ((i3 & 16) == 0) {
                    this.currencySymbol = "";
                } else {
                    this.currencySymbol = str5;
                }
                if ((i3 & 32) == 0) {
                    this.period = "";
                } else {
                    this.period = str6;
                }
                if ((i3 & 64) == 0) {
                    this.periodly = "";
                } else {
                    this.periodly = str7;
                }
                if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                    this.localizedPeriod = "";
                } else {
                    this.localizedPeriod = str8;
                }
                if ((i3 & Function.MAX_NARGS) == 0) {
                    this.periodAlt = "";
                } else {
                    this.periodAlt = str9;
                }
                if ((i3 & 512) == 0) {
                    this.periodDays = 0;
                } else {
                    this.periodDays = i4;
                }
                if ((i3 & 1024) == 0) {
                    this.periodWeeks = 0;
                } else {
                    this.periodWeeks = i5;
                }
                if ((i3 & 2048) == 0) {
                    this.periodMonths = 0;
                } else {
                    this.periodMonths = i6;
                }
                if ((i3 & 4096) == 0) {
                    this.periodYears = 0;
                } else {
                    this.periodYears = i7;
                }
                if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
                    this.rawPrice = 0.0d;
                } else {
                    this.rawPrice = d3;
                }
                if ((i3 & 16384) == 0) {
                    this.price = "";
                } else {
                    this.price = str10;
                }
                if ((32768 & i3) == 0) {
                    this.dailyPrice = "";
                } else {
                    this.dailyPrice = str11;
                }
                if ((65536 & i3) == 0) {
                    this.weeklyPrice = "";
                } else {
                    this.weeklyPrice = str12;
                }
                if ((131072 & i3) == 0) {
                    this.monthlyPrice = "";
                } else {
                    this.monthlyPrice = str13;
                }
                if ((262144 & i3) == 0) {
                    this.yearlyPrice = "";
                } else {
                    this.yearlyPrice = str14;
                }
                this.rawTrialPeriodPrice = (524288 & i3) != 0 ? d4 : 0.0d;
                if ((1048576 & i3) == 0) {
                    this.trialPeriodPrice = "";
                } else {
                    this.trialPeriodPrice = str15;
                }
                if ((2097152 & i3) == 0) {
                    this.trialPeriodDailyPrice = "";
                } else {
                    this.trialPeriodDailyPrice = str16;
                }
                if ((4194304 & i3) == 0) {
                    this.trialPeriodWeeklyPrice = "";
                } else {
                    this.trialPeriodWeeklyPrice = str17;
                }
                if ((8388608 & i3) == 0) {
                    this.trialPeriodMonthlyPrice = "";
                } else {
                    this.trialPeriodMonthlyPrice = str18;
                }
                if ((16777216 & i3) == 0) {
                    this.trialPeriodYearlyPrice = "";
                } else {
                    this.trialPeriodYearlyPrice = str19;
                }
                if ((33554432 & i3) == 0) {
                    this.trialPeriodDays = 0;
                } else {
                    this.trialPeriodDays = i8;
                }
                if ((67108864 & i3) == 0) {
                    this.trialPeriodWeeks = 0;
                } else {
                    this.trialPeriodWeeks = i9;
                }
                if ((134217728 & i3) == 0) {
                    this.trialPeriodMonths = 0;
                } else {
                    this.trialPeriodMonths = i10;
                }
                if ((268435456 & i3) == 0) {
                    this.trialPeriodYears = 0;
                } else {
                    this.trialPeriodYears = i11;
                }
                if ((536870912 & i3) == 0) {
                    this.trialPeriodText = "";
                } else {
                    this.trialPeriodText = str20;
                }
                if ((i3 & 1073741824) == 0) {
                    this.trialPeriodEndDate = "";
                } else {
                    this.trialPeriodEndDate = str21;
                }
            }

            public static /* synthetic */ PaywallProduct copy$default(PaywallProduct paywallProduct, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, int i4, int i5, int i6, double d3, String str10, String str11, String str12, String str13, String str14, double d4, String str15, String str16, String str17, String str18, String str19, int i7, int i8, int i9, int i10, String str20, String str21, int i11, Object obj) {
                String str22;
                String str23;
                String str24;
                String str25;
                String str26;
                String str27;
                double d5;
                String str28;
                String str29;
                String str30;
                int i12;
                int i13;
                int i14;
                int i15;
                String str31;
                String str32;
                String str33;
                String str34;
                String str35;
                String str36;
                String str37;
                int i16;
                int i17;
                int i18;
                int i19;
                String str38;
                String str39;
                double d6;
                String str40;
                String str41;
                String str42 = (i11 & 1) != 0 ? paywallProduct.identifier : str;
                String str43 = (i11 & 2) != 0 ? paywallProduct.languageCode : str2;
                String str44 = (i11 & 4) != 0 ? paywallProduct.locale : str3;
                String str45 = (i11 & 8) != 0 ? paywallProduct.currencyCode : str4;
                String str46 = (i11 & 16) != 0 ? paywallProduct.currencySymbol : str5;
                String str47 = (i11 & 32) != 0 ? paywallProduct.period : str6;
                String str48 = (i11 & 64) != 0 ? paywallProduct.periodly : str7;
                String str49 = (i11 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywallProduct.localizedPeriod : str8;
                String str50 = (i11 & Function.MAX_NARGS) != 0 ? paywallProduct.periodAlt : str9;
                int i20 = (i11 & 512) != 0 ? paywallProduct.periodDays : i3;
                int i21 = (i11 & 1024) != 0 ? paywallProduct.periodWeeks : i4;
                int i22 = (i11 & 2048) != 0 ? paywallProduct.periodMonths : i5;
                int i23 = (i11 & 4096) != 0 ? paywallProduct.periodYears : i6;
                String str51 = str42;
                String str52 = str43;
                double d7 = (i11 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywallProduct.rawPrice : d3;
                String str53 = (i11 & 16384) != 0 ? paywallProduct.price : str10;
                String str54 = (i11 & 32768) != 0 ? paywallProduct.dailyPrice : str11;
                String str55 = (i11 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywallProduct.weeklyPrice : str12;
                String str56 = (i11 & 131072) != 0 ? paywallProduct.monthlyPrice : str13;
                String str57 = (i11 & 262144) != 0 ? paywallProduct.yearlyPrice : str14;
                double d8 = d7;
                double d9 = (i11 & 524288) != 0 ? paywallProduct.rawTrialPeriodPrice : d4;
                String str58 = (i11 & 1048576) != 0 ? paywallProduct.trialPeriodPrice : str15;
                double d10 = d9;
                String str59 = (i11 & 2097152) != 0 ? paywallProduct.trialPeriodDailyPrice : str16;
                String str60 = (i11 & 4194304) != 0 ? paywallProduct.trialPeriodWeeklyPrice : str17;
                String str61 = str59;
                String str62 = (i11 & 8388608) != 0 ? paywallProduct.trialPeriodMonthlyPrice : str18;
                String str63 = (i11 & 16777216) != 0 ? paywallProduct.trialPeriodYearlyPrice : str19;
                int i24 = (i11 & 33554432) != 0 ? paywallProduct.trialPeriodDays : i7;
                int i25 = (i11 & 67108864) != 0 ? paywallProduct.trialPeriodWeeks : i8;
                int i26 = (i11 & 134217728) != 0 ? paywallProduct.trialPeriodMonths : i9;
                int i27 = (i11 & 268435456) != 0 ? paywallProduct.trialPeriodYears : i10;
                String str64 = (i11 & 536870912) != 0 ? paywallProduct.trialPeriodText : str20;
                if ((i11 & 1073741824) != 0) {
                    str23 = str64;
                    str22 = paywallProduct.trialPeriodEndDate;
                    str25 = str55;
                    str26 = str56;
                    str27 = str57;
                    d5 = d10;
                    str28 = str61;
                    str29 = str62;
                    str30 = str63;
                    i12 = i24;
                    i13 = i25;
                    i14 = i26;
                    i15 = i27;
                    str31 = str60;
                    str32 = str58;
                    str33 = str44;
                    str34 = str45;
                    str35 = str48;
                    str36 = str49;
                    str37 = str50;
                    i16 = i20;
                    i17 = i21;
                    i18 = i22;
                    i19 = i23;
                    str38 = str53;
                    str24 = str54;
                    d6 = d8;
                    str40 = str46;
                    str41 = str47;
                    str39 = str52;
                } else {
                    str22 = str21;
                    str23 = str64;
                    str24 = str54;
                    str25 = str55;
                    str26 = str56;
                    str27 = str57;
                    d5 = d10;
                    str28 = str61;
                    str29 = str62;
                    str30 = str63;
                    i12 = i24;
                    i13 = i25;
                    i14 = i26;
                    i15 = i27;
                    str31 = str60;
                    str32 = str58;
                    str33 = str44;
                    str34 = str45;
                    str35 = str48;
                    str36 = str49;
                    str37 = str50;
                    i16 = i20;
                    i17 = i21;
                    i18 = i22;
                    i19 = i23;
                    str38 = str53;
                    str39 = str52;
                    d6 = d8;
                    str40 = str46;
                    str41 = str47;
                }
                return paywallProduct.copy(str51, str39, str33, str34, str40, str41, str35, str36, str37, i16, i17, i18, i19, d6, str38, str24, str25, str26, str27, d5, str32, str28, str31, str29, str30, i12, i13, i14, i15, str23, str22);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(PaywallProduct paywallProduct, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.y(serialDescriptor, 0, paywallProduct.identifier);
                if (compositeEncoder.z(serialDescriptor, 1) || !Intrinsics.areEqual(paywallProduct.languageCode, "")) {
                    compositeEncoder.y(serialDescriptor, 1, paywallProduct.languageCode);
                }
                if (compositeEncoder.z(serialDescriptor, 2) || !Intrinsics.areEqual(paywallProduct.locale, "")) {
                    compositeEncoder.y(serialDescriptor, 2, paywallProduct.locale);
                }
                if (compositeEncoder.z(serialDescriptor, 3) || !Intrinsics.areEqual(paywallProduct.currencyCode, "")) {
                    compositeEncoder.y(serialDescriptor, 3, paywallProduct.currencyCode);
                }
                if (compositeEncoder.z(serialDescriptor, 4) || !Intrinsics.areEqual(paywallProduct.currencySymbol, "")) {
                    compositeEncoder.y(serialDescriptor, 4, paywallProduct.currencySymbol);
                }
                if (compositeEncoder.z(serialDescriptor, 5) || !Intrinsics.areEqual(paywallProduct.period, "")) {
                    compositeEncoder.y(serialDescriptor, 5, paywallProduct.period);
                }
                if (compositeEncoder.z(serialDescriptor, 6) || !Intrinsics.areEqual(paywallProduct.periodly, "")) {
                    compositeEncoder.y(serialDescriptor, 6, paywallProduct.periodly);
                }
                if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(paywallProduct.localizedPeriod, "")) {
                    compositeEncoder.y(serialDescriptor, 7, paywallProduct.localizedPeriod);
                }
                if (compositeEncoder.z(serialDescriptor, 8) || !Intrinsics.areEqual(paywallProduct.periodAlt, "")) {
                    compositeEncoder.y(serialDescriptor, 8, paywallProduct.periodAlt);
                }
                if (compositeEncoder.z(serialDescriptor, 9) || paywallProduct.periodDays != 0) {
                    compositeEncoder.w(serialDescriptor, 9, paywallProduct.periodDays);
                }
                if (compositeEncoder.z(serialDescriptor, 10) || paywallProduct.periodWeeks != 0) {
                    compositeEncoder.w(serialDescriptor, 10, paywallProduct.periodWeeks);
                }
                if (compositeEncoder.z(serialDescriptor, 11) || paywallProduct.periodMonths != 0) {
                    compositeEncoder.w(serialDescriptor, 11, paywallProduct.periodMonths);
                }
                if (compositeEncoder.z(serialDescriptor, 12) || paywallProduct.periodYears != 0) {
                    compositeEncoder.w(serialDescriptor, 12, paywallProduct.periodYears);
                }
                if (compositeEncoder.z(serialDescriptor, 13) || Double.compare(paywallProduct.rawPrice, 0.0d) != 0) {
                    compositeEncoder.E(serialDescriptor, 13, paywallProduct.rawPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 14) || !Intrinsics.areEqual(paywallProduct.price, "")) {
                    compositeEncoder.y(serialDescriptor, 14, paywallProduct.price);
                }
                if (compositeEncoder.z(serialDescriptor, 15) || !Intrinsics.areEqual(paywallProduct.dailyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 15, paywallProduct.dailyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 16) || !Intrinsics.areEqual(paywallProduct.weeklyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 16, paywallProduct.weeklyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 17) || !Intrinsics.areEqual(paywallProduct.monthlyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 17, paywallProduct.monthlyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 18) || !Intrinsics.areEqual(paywallProduct.yearlyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 18, paywallProduct.yearlyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 19) || Double.compare(paywallProduct.rawTrialPeriodPrice, 0.0d) != 0) {
                    compositeEncoder.E(serialDescriptor, 19, paywallProduct.rawTrialPeriodPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 20) || !Intrinsics.areEqual(paywallProduct.trialPeriodPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 20, paywallProduct.trialPeriodPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 21) || !Intrinsics.areEqual(paywallProduct.trialPeriodDailyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 21, paywallProduct.trialPeriodDailyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 22) || !Intrinsics.areEqual(paywallProduct.trialPeriodWeeklyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 22, paywallProduct.trialPeriodWeeklyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 23) || !Intrinsics.areEqual(paywallProduct.trialPeriodMonthlyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 23, paywallProduct.trialPeriodMonthlyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 24) || !Intrinsics.areEqual(paywallProduct.trialPeriodYearlyPrice, "")) {
                    compositeEncoder.y(serialDescriptor, 24, paywallProduct.trialPeriodYearlyPrice);
                }
                if (compositeEncoder.z(serialDescriptor, 25) || paywallProduct.trialPeriodDays != 0) {
                    compositeEncoder.w(serialDescriptor, 25, paywallProduct.trialPeriodDays);
                }
                if (compositeEncoder.z(serialDescriptor, 26) || paywallProduct.trialPeriodWeeks != 0) {
                    compositeEncoder.w(serialDescriptor, 26, paywallProduct.trialPeriodWeeks);
                }
                if (compositeEncoder.z(serialDescriptor, 27) || paywallProduct.trialPeriodMonths != 0) {
                    compositeEncoder.w(serialDescriptor, 27, paywallProduct.trialPeriodMonths);
                }
                if (compositeEncoder.z(serialDescriptor, 28) || paywallProduct.trialPeriodYears != 0) {
                    compositeEncoder.w(serialDescriptor, 28, paywallProduct.trialPeriodYears);
                }
                if (compositeEncoder.z(serialDescriptor, 29) || !Intrinsics.areEqual(paywallProduct.trialPeriodText, "")) {
                    compositeEncoder.y(serialDescriptor, 29, paywallProduct.trialPeriodText);
                }
                if (!compositeEncoder.z(serialDescriptor, 30) && Intrinsics.areEqual(paywallProduct.trialPeriodEndDate, "")) {
                    return;
                }
                compositeEncoder.y(serialDescriptor, 30, paywallProduct.trialPeriodEndDate);
            }

            public final String component1() {
                return this.identifier;
            }

            public final int component10() {
                return this.periodDays;
            }

            public final int component11() {
                return this.periodWeeks;
            }

            public final int component12() {
                return this.periodMonths;
            }

            public final int component13() {
                return this.periodYears;
            }

            public final double component14() {
                return this.rawPrice;
            }

            public final String component15() {
                return this.price;
            }

            public final String component16() {
                return this.dailyPrice;
            }

            public final String component17() {
                return this.weeklyPrice;
            }

            public final String component18() {
                return this.monthlyPrice;
            }

            public final String component19() {
                return this.yearlyPrice;
            }

            public final String component2() {
                return this.languageCode;
            }

            public final double component20() {
                return this.rawTrialPeriodPrice;
            }

            public final String component21() {
                return this.trialPeriodPrice;
            }

            public final String component22() {
                return this.trialPeriodDailyPrice;
            }

            public final String component23() {
                return this.trialPeriodWeeklyPrice;
            }

            public final String component24() {
                return this.trialPeriodMonthlyPrice;
            }

            public final String component25() {
                return this.trialPeriodYearlyPrice;
            }

            public final int component26() {
                return this.trialPeriodDays;
            }

            public final int component27() {
                return this.trialPeriodWeeks;
            }

            public final int component28() {
                return this.trialPeriodMonths;
            }

            public final int component29() {
                return this.trialPeriodYears;
            }

            public final String component3() {
                return this.locale;
            }

            public final String component30() {
                return this.trialPeriodText;
            }

            public final String component31() {
                return this.trialPeriodEndDate;
            }

            public final String component4() {
                return this.currencyCode;
            }

            public final String component5() {
                return this.currencySymbol;
            }

            public final String component6() {
                return this.period;
            }

            public final String component7() {
                return this.periodly;
            }

            public final String component8() {
                return this.localizedPeriod;
            }

            public final String component9() {
                return this.periodAlt;
            }

            public final PaywallProduct copy(String identifier, String languageCode, String locale, String currencyCode, String currencySymbol, String period, String periodly, String localizedPeriod, String periodAlt, int i3, int i4, int i5, int i6, double d3, String price, String dailyPrice, String weeklyPrice, String monthlyPrice, String yearlyPrice, double d4, String trialPeriodPrice, String trialPeriodDailyPrice, String trialPeriodWeeklyPrice, String trialPeriodMonthlyPrice, String trialPeriodYearlyPrice, int i7, int i8, int i9, int i10, String trialPeriodText, String trialPeriodEndDate) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(languageCode, "languageCode");
                Intrinsics.checkNotNullParameter(locale, "locale");
                Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
                Intrinsics.checkNotNullParameter(currencySymbol, "currencySymbol");
                Intrinsics.checkNotNullParameter(period, "period");
                Intrinsics.checkNotNullParameter(periodly, "periodly");
                Intrinsics.checkNotNullParameter(localizedPeriod, "localizedPeriod");
                Intrinsics.checkNotNullParameter(periodAlt, "periodAlt");
                Intrinsics.checkNotNullParameter(price, "price");
                Intrinsics.checkNotNullParameter(dailyPrice, "dailyPrice");
                Intrinsics.checkNotNullParameter(weeklyPrice, "weeklyPrice");
                Intrinsics.checkNotNullParameter(monthlyPrice, "monthlyPrice");
                Intrinsics.checkNotNullParameter(yearlyPrice, "yearlyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodPrice, "trialPeriodPrice");
                Intrinsics.checkNotNullParameter(trialPeriodDailyPrice, "trialPeriodDailyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodWeeklyPrice, "trialPeriodWeeklyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodMonthlyPrice, "trialPeriodMonthlyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodYearlyPrice, "trialPeriodYearlyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodText, "trialPeriodText");
                Intrinsics.checkNotNullParameter(trialPeriodEndDate, "trialPeriodEndDate");
                return new PaywallProduct(identifier, languageCode, locale, currencyCode, currencySymbol, period, periodly, localizedPeriod, periodAlt, i3, i4, i5, i6, d3, price, dailyPrice, weeklyPrice, monthlyPrice, yearlyPrice, d4, trialPeriodPrice, trialPeriodDailyPrice, trialPeriodWeeklyPrice, trialPeriodMonthlyPrice, trialPeriodYearlyPrice, i7, i8, i9, i10, trialPeriodText, trialPeriodEndDate);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PaywallProduct)) {
                    return false;
                }
                PaywallProduct paywallProduct = (PaywallProduct) obj;
                return Intrinsics.areEqual(this.identifier, paywallProduct.identifier) && Intrinsics.areEqual(this.languageCode, paywallProduct.languageCode) && Intrinsics.areEqual(this.locale, paywallProduct.locale) && Intrinsics.areEqual(this.currencyCode, paywallProduct.currencyCode) && Intrinsics.areEqual(this.currencySymbol, paywallProduct.currencySymbol) && Intrinsics.areEqual(this.period, paywallProduct.period) && Intrinsics.areEqual(this.periodly, paywallProduct.periodly) && Intrinsics.areEqual(this.localizedPeriod, paywallProduct.localizedPeriod) && Intrinsics.areEqual(this.periodAlt, paywallProduct.periodAlt) && this.periodDays == paywallProduct.periodDays && this.periodWeeks == paywallProduct.periodWeeks && this.periodMonths == paywallProduct.periodMonths && this.periodYears == paywallProduct.periodYears && Double.compare(this.rawPrice, paywallProduct.rawPrice) == 0 && Intrinsics.areEqual(this.price, paywallProduct.price) && Intrinsics.areEqual(this.dailyPrice, paywallProduct.dailyPrice) && Intrinsics.areEqual(this.weeklyPrice, paywallProduct.weeklyPrice) && Intrinsics.areEqual(this.monthlyPrice, paywallProduct.monthlyPrice) && Intrinsics.areEqual(this.yearlyPrice, paywallProduct.yearlyPrice) && Double.compare(this.rawTrialPeriodPrice, paywallProduct.rawTrialPeriodPrice) == 0 && Intrinsics.areEqual(this.trialPeriodPrice, paywallProduct.trialPeriodPrice) && Intrinsics.areEqual(this.trialPeriodDailyPrice, paywallProduct.trialPeriodDailyPrice) && Intrinsics.areEqual(this.trialPeriodWeeklyPrice, paywallProduct.trialPeriodWeeklyPrice) && Intrinsics.areEqual(this.trialPeriodMonthlyPrice, paywallProduct.trialPeriodMonthlyPrice) && Intrinsics.areEqual(this.trialPeriodYearlyPrice, paywallProduct.trialPeriodYearlyPrice) && this.trialPeriodDays == paywallProduct.trialPeriodDays && this.trialPeriodWeeks == paywallProduct.trialPeriodWeeks && this.trialPeriodMonths == paywallProduct.trialPeriodMonths && this.trialPeriodYears == paywallProduct.trialPeriodYears && Intrinsics.areEqual(this.trialPeriodText, paywallProduct.trialPeriodText) && Intrinsics.areEqual(this.trialPeriodEndDate, paywallProduct.trialPeriodEndDate);
            }

            public final String getCurrencyCode() {
                return this.currencyCode;
            }

            public final String getCurrencySymbol() {
                return this.currencySymbol;
            }

            public final String getDailyPrice() {
                return this.dailyPrice;
            }

            public final String getIdentifier() {
                return this.identifier;
            }

            public final String getLanguageCode() {
                return this.languageCode;
            }

            public final String getLocale() {
                return this.locale;
            }

            public final String getLocalizedPeriod() {
                return this.localizedPeriod;
            }

            public final String getMonthlyPrice() {
                return this.monthlyPrice;
            }

            public final String getPeriod() {
                return this.period;
            }

            public final String getPeriodAlt() {
                return this.periodAlt;
            }

            public final int getPeriodDays() {
                return this.periodDays;
            }

            public final int getPeriodMonths() {
                return this.periodMonths;
            }

            public final int getPeriodWeeks() {
                return this.periodWeeks;
            }

            public final int getPeriodYears() {
                return this.periodYears;
            }

            public final String getPeriodly() {
                return this.periodly;
            }

            public final String getPrice() {
                return this.price;
            }

            public final double getRawPrice() {
                return this.rawPrice;
            }

            public final double getRawTrialPeriodPrice() {
                return this.rawTrialPeriodPrice;
            }

            public final String getTrialPeriodDailyPrice() {
                return this.trialPeriodDailyPrice;
            }

            public final int getTrialPeriodDays() {
                return this.trialPeriodDays;
            }

            public final String getTrialPeriodEndDate() {
                return this.trialPeriodEndDate;
            }

            public final String getTrialPeriodMonthlyPrice() {
                return this.trialPeriodMonthlyPrice;
            }

            public final int getTrialPeriodMonths() {
                return this.trialPeriodMonths;
            }

            public final String getTrialPeriodPrice() {
                return this.trialPeriodPrice;
            }

            public final String getTrialPeriodText() {
                return this.trialPeriodText;
            }

            public final String getTrialPeriodWeeklyPrice() {
                return this.trialPeriodWeeklyPrice;
            }

            public final int getTrialPeriodWeeks() {
                return this.trialPeriodWeeks;
            }

            public final String getTrialPeriodYearlyPrice() {
                return this.trialPeriodYearlyPrice;
            }

            public final int getTrialPeriodYears() {
                return this.trialPeriodYears;
            }

            public final String getWeeklyPrice() {
                return this.weeklyPrice;
            }

            public final String getYearlyPrice() {
                return this.yearlyPrice;
            }

            public int hashCode() {
                return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.identifier.hashCode() * 31) + this.languageCode.hashCode()) * 31) + this.locale.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.currencySymbol.hashCode()) * 31) + this.period.hashCode()) * 31) + this.periodly.hashCode()) * 31) + this.localizedPeriod.hashCode()) * 31) + this.periodAlt.hashCode()) * 31) + Integer.hashCode(this.periodDays)) * 31) + Integer.hashCode(this.periodWeeks)) * 31) + Integer.hashCode(this.periodMonths)) * 31) + Integer.hashCode(this.periodYears)) * 31) + Double.hashCode(this.rawPrice)) * 31) + this.price.hashCode()) * 31) + this.dailyPrice.hashCode()) * 31) + this.weeklyPrice.hashCode()) * 31) + this.monthlyPrice.hashCode()) * 31) + this.yearlyPrice.hashCode()) * 31) + Double.hashCode(this.rawTrialPeriodPrice)) * 31) + this.trialPeriodPrice.hashCode()) * 31) + this.trialPeriodDailyPrice.hashCode()) * 31) + this.trialPeriodWeeklyPrice.hashCode()) * 31) + this.trialPeriodMonthlyPrice.hashCode()) * 31) + this.trialPeriodYearlyPrice.hashCode()) * 31) + Integer.hashCode(this.trialPeriodDays)) * 31) + Integer.hashCode(this.trialPeriodWeeks)) * 31) + Integer.hashCode(this.trialPeriodMonths)) * 31) + Integer.hashCode(this.trialPeriodYears)) * 31) + this.trialPeriodText.hashCode()) * 31) + this.trialPeriodEndDate.hashCode();
            }

            public String toString() {
                return "PaywallProduct(identifier=" + this.identifier + ", languageCode=" + this.languageCode + ", locale=" + this.locale + ", currencyCode=" + this.currencyCode + ", currencySymbol=" + this.currencySymbol + ", period=" + this.period + ", periodly=" + this.periodly + ", localizedPeriod=" + this.localizedPeriod + ", periodAlt=" + this.periodAlt + ", periodDays=" + this.periodDays + ", periodWeeks=" + this.periodWeeks + ", periodMonths=" + this.periodMonths + ", periodYears=" + this.periodYears + ", rawPrice=" + this.rawPrice + ", price=" + this.price + ", dailyPrice=" + this.dailyPrice + ", weeklyPrice=" + this.weeklyPrice + ", monthlyPrice=" + this.monthlyPrice + ", yearlyPrice=" + this.yearlyPrice + ", rawTrialPeriodPrice=" + this.rawTrialPeriodPrice + ", trialPeriodPrice=" + this.trialPeriodPrice + ", trialPeriodDailyPrice=" + this.trialPeriodDailyPrice + ", trialPeriodWeeklyPrice=" + this.trialPeriodWeeklyPrice + ", trialPeriodMonthlyPrice=" + this.trialPeriodMonthlyPrice + ", trialPeriodYearlyPrice=" + this.trialPeriodYearlyPrice + ", trialPeriodDays=" + this.trialPeriodDays + ", trialPeriodWeeks=" + this.trialPeriodWeeks + ", trialPeriodMonths=" + this.trialPeriodMonths + ", trialPeriodYears=" + this.trialPeriodYears + ", trialPeriodText=" + this.trialPeriodText + ", trialPeriodEndDate=" + this.trialPeriodEndDate + ")";
            }

            public PaywallProduct(String identifier, String languageCode, String locale, String currencyCode, String currencySymbol, String period, String periodly, String localizedPeriod, String periodAlt, int i3, int i4, int i5, int i6, double d3, String price, String dailyPrice, String weeklyPrice, String monthlyPrice, String yearlyPrice, double d4, String trialPeriodPrice, String trialPeriodDailyPrice, String trialPeriodWeeklyPrice, String trialPeriodMonthlyPrice, String trialPeriodYearlyPrice, int i7, int i8, int i9, int i10, String trialPeriodText, String trialPeriodEndDate) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(languageCode, "languageCode");
                Intrinsics.checkNotNullParameter(locale, "locale");
                Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
                Intrinsics.checkNotNullParameter(currencySymbol, "currencySymbol");
                Intrinsics.checkNotNullParameter(period, "period");
                Intrinsics.checkNotNullParameter(periodly, "periodly");
                Intrinsics.checkNotNullParameter(localizedPeriod, "localizedPeriod");
                Intrinsics.checkNotNullParameter(periodAlt, "periodAlt");
                Intrinsics.checkNotNullParameter(price, "price");
                Intrinsics.checkNotNullParameter(dailyPrice, "dailyPrice");
                Intrinsics.checkNotNullParameter(weeklyPrice, "weeklyPrice");
                Intrinsics.checkNotNullParameter(monthlyPrice, "monthlyPrice");
                Intrinsics.checkNotNullParameter(yearlyPrice, "yearlyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodPrice, "trialPeriodPrice");
                Intrinsics.checkNotNullParameter(trialPeriodDailyPrice, "trialPeriodDailyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodWeeklyPrice, "trialPeriodWeeklyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodMonthlyPrice, "trialPeriodMonthlyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodYearlyPrice, "trialPeriodYearlyPrice");
                Intrinsics.checkNotNullParameter(trialPeriodText, "trialPeriodText");
                Intrinsics.checkNotNullParameter(trialPeriodEndDate, "trialPeriodEndDate");
                this.identifier = identifier;
                this.languageCode = languageCode;
                this.locale = locale;
                this.currencyCode = currencyCode;
                this.currencySymbol = currencySymbol;
                this.period = period;
                this.periodly = periodly;
                this.localizedPeriod = localizedPeriod;
                this.periodAlt = periodAlt;
                this.periodDays = i3;
                this.periodWeeks = i4;
                this.periodMonths = i5;
                this.periodYears = i6;
                this.rawPrice = d3;
                this.price = price;
                this.dailyPrice = dailyPrice;
                this.weeklyPrice = weeklyPrice;
                this.monthlyPrice = monthlyPrice;
                this.yearlyPrice = yearlyPrice;
                this.rawTrialPeriodPrice = d4;
                this.trialPeriodPrice = trialPeriodPrice;
                this.trialPeriodDailyPrice = trialPeriodDailyPrice;
                this.trialPeriodWeeklyPrice = trialPeriodWeeklyPrice;
                this.trialPeriodMonthlyPrice = trialPeriodMonthlyPrice;
                this.trialPeriodYearlyPrice = trialPeriodYearlyPrice;
                this.trialPeriodDays = i7;
                this.trialPeriodWeeks = i8;
                this.trialPeriodMonths = i9;
                this.trialPeriodYears = i10;
                this.trialPeriodText = trialPeriodText;
                this.trialPeriodEndDate = trialPeriodEndDate;
            }

            @SerialName
            public static /* synthetic */ void getCurrencyCode$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getCurrencySymbol$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getDailyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getIdentifier$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getLanguageCode$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getLocale$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getLocalizedPeriod$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getMonthlyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriod$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriodAlt$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriodDays$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriodMonths$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriodWeeks$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriodYears$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPeriodly$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getRawPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getRawTrialPeriodPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodDailyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodDays$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodEndDate$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodMonthlyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodMonths$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodText$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodWeeklyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodWeeks$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodYearlyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getTrialPeriodYears$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getWeeklyPrice$annotations() {
            }

            @SerialName
            public static /* synthetic */ void getYearlyPrice$annotations() {
            }

            public /* synthetic */ PaywallProduct(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i3, int i4, int i5, int i6, double d3, String str10, String str11, String str12, String str13, String str14, double d4, String str15, String str16, String str17, String str18, String str19, int i7, int i8, int i9, int i10, String str20, String str21, int i11, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3, (i11 & 8) != 0 ? "" : str4, (i11 & 16) != 0 ? "" : str5, (i11 & 32) != 0 ? "" : str6, (i11 & 64) != 0 ? "" : str7, (i11 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? "" : str8, (i11 & Function.MAX_NARGS) != 0 ? "" : str9, (i11 & 512) != 0 ? 0 : i3, (i11 & 1024) != 0 ? 0 : i4, (i11 & 2048) != 0 ? 0 : i5, (i11 & 4096) != 0 ? 0 : i6, (i11 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? 0.0d : d3, (i11 & 16384) != 0 ? "" : str10, (i11 & 32768) != 0 ? "" : str11, (i11 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? "" : str12, (i11 & 131072) != 0 ? "" : str13, (i11 & 262144) != 0 ? "" : str14, (i11 & 524288) == 0 ? d4 : 0.0d, (i11 & 1048576) != 0 ? "" : str15, (i11 & 2097152) != 0 ? "" : str16, (i11 & 4194304) != 0 ? "" : str17, (i11 & 8388608) != 0 ? "" : str18, (i11 & 16777216) != 0 ? "" : str19, (i11 & 33554432) != 0 ? 0 : i7, (i11 & 67108864) != 0 ? 0 : i8, (i11 & 134217728) != 0 ? 0 : i9, (i11 & 268435456) == 0 ? i10 : 0, (i11 & 536870912) != 0 ? "" : str20, (i11 & 1073741824) != 0 ? "" : str21);
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PaywallInfo(String identifier, String placementName, Map<String, ? extends JsonElement> placementParams, String variantId, String experimentId) {
            this(identifier, placementName, placementParams, variantId, experimentId, null, 32, null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(placementParams, "placementParams");
            Intrinsics.checkNotNullParameter(variantId, "variantId");
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PaywallInfo copy$default(PaywallInfo paywallInfo, String str, String str2, Map map, String str3, String str4, String str5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallInfo.identifier;
            }
            if ((i3 & 2) != 0) {
                str2 = paywallInfo.placementName;
            }
            if ((i3 & 4) != 0) {
                map = paywallInfo.placementParams;
            }
            if ((i3 & 8) != 0) {
                str3 = paywallInfo.variantId;
            }
            if ((i3 & 16) != 0) {
                str4 = paywallInfo.experimentId;
            }
            if ((i3 & 32) != 0) {
                str5 = paywallInfo.productIdentifier;
            }
            String str6 = str4;
            String str7 = str5;
            return paywallInfo.copy(str, str2, map, str3, str6, str7);
        }

        @SerialName
        public static /* synthetic */ void getExperimentId$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPlacementName$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPlacementParams$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getProduct$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getProductIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getVariantId$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(PaywallInfo paywallInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.y(serialDescriptor, 0, paywallInfo.identifier);
            compositeEncoder.y(serialDescriptor, 1, paywallInfo.placementName);
            compositeEncoder.C(serialDescriptor, 2, kSerializerArr[2], paywallInfo.placementParams);
            compositeEncoder.y(serialDescriptor, 3, paywallInfo.variantId);
            compositeEncoder.y(serialDescriptor, 4, paywallInfo.experimentId);
            if (compositeEncoder.z(serialDescriptor, 5) || paywallInfo.productIdentifier != null) {
                compositeEncoder.i(serialDescriptor, 5, StringSerializer.f142891a, paywallInfo.productIdentifier);
            }
            if (!compositeEncoder.z(serialDescriptor, 6) && paywallInfo.product == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 6, RedemptionResult$PaywallInfo$PaywallProduct$$serializer.INSTANCE, paywallInfo.product);
        }

        public final String component1() {
            return this.identifier;
        }

        public final String component2() {
            return this.placementName;
        }

        public final Map<String, JsonElement> component3() {
            return this.placementParams;
        }

        public final String component4() {
            return this.variantId;
        }

        public final String component5() {
            return this.experimentId;
        }

        public final String component6() {
            return this.productIdentifier;
        }

        public final PaywallProduct component7() {
            return this.product;
        }

        public final PaywallInfo copy(String identifier, String placementName, Map<String, ? extends JsonElement> placementParams, String variantId, String experimentId, String str) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(placementParams, "placementParams");
            Intrinsics.checkNotNullParameter(variantId, "variantId");
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            return new PaywallInfo(identifier, placementName, placementParams, variantId, experimentId, str, this.product);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PaywallInfo)) {
                return false;
            }
            PaywallInfo paywallInfo = (PaywallInfo) obj;
            return Intrinsics.areEqual(this.identifier, paywallInfo.identifier) && Intrinsics.areEqual(this.placementName, paywallInfo.placementName) && Intrinsics.areEqual(this.placementParams, paywallInfo.placementParams) && Intrinsics.areEqual(this.variantId, paywallInfo.variantId) && Intrinsics.areEqual(this.experimentId, paywallInfo.experimentId) && Intrinsics.areEqual(this.productIdentifier, paywallInfo.productIdentifier) && Intrinsics.areEqual(this.product, paywallInfo.product);
        }

        public final String getExperimentId() {
            return this.experimentId;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getPlacementName() {
            return this.placementName;
        }

        public final Map<String, JsonElement> getPlacementParams() {
            return this.placementParams;
        }

        public final PaywallProduct getProduct() {
            return this.product;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final String getVariantId() {
            return this.variantId;
        }

        public int hashCode() {
            return CollectionsKt.listOf(this.identifier, this.placementName, this.placementParams, this.variantId, this.experimentId, this.productIdentifier, this.product).hashCode();
        }

        public /* synthetic */ PaywallInfo(int i3, String str, String str2, Map map, String str3, String str4, String str5, PaywallProduct paywallProduct, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i3 & 31)) {
                PluginExceptionsKt.b(i3, 31, RedemptionResult$PaywallInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = str;
            this.placementName = str2;
            this.placementParams = map;
            this.variantId = str3;
            this.experimentId = str4;
            if ((i3 & 32) == 0) {
                this.productIdentifier = null;
            } else {
                this.productIdentifier = str5;
            }
            if ((i3 & 64) == 0) {
                this.product = null;
            } else {
                this.product = paywallProduct;
            }
        }

        public final PaywallInfo copy(String identifier, String placementName, Map<String, ? extends JsonElement> placementParams, String variantId, String experimentId, String str, PaywallProduct paywallProduct) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(placementParams, "placementParams");
            Intrinsics.checkNotNullParameter(variantId, "variantId");
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            return new PaywallInfo(identifier, placementName, placementParams, variantId, experimentId, str, paywallProduct);
        }

        public String toString() {
            return "PaywallInfo(identifier=" + this.identifier + ", placementName=" + this.placementName + ", placementParams=" + this.placementParams + ", variantId=" + this.variantId + ", experimentId=" + this.experimentId + SbbqvQlxi.UILKxjEXVKwU + this.productIdentifier + ", product=" + this.product + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PaywallInfo(String identifier, String placementName, Map<String, ? extends JsonElement> placementParams, String variantId, String experimentId, String str) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(placementParams, "placementParams");
            Intrinsics.checkNotNullParameter(variantId, "variantId");
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            this.identifier = identifier;
            this.placementName = placementName;
            this.placementParams = placementParams;
            this.variantId = variantId;
            this.experimentId = experimentId;
            this.productIdentifier = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PaywallInfo copy$default(PaywallInfo paywallInfo, String str, String str2, Map map, String str3, String str4, String str5, PaywallProduct paywallProduct, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallInfo.identifier;
            }
            if ((i3 & 2) != 0) {
                str2 = paywallInfo.placementName;
            }
            if ((i3 & 4) != 0) {
                map = paywallInfo.placementParams;
            }
            if ((i3 & 8) != 0) {
                str3 = paywallInfo.variantId;
            }
            if ((i3 & 16) != 0) {
                str4 = paywallInfo.experimentId;
            }
            if ((i3 & 32) != 0) {
                str5 = paywallInfo.productIdentifier;
            }
            String str6 = str5;
            String str7 = str4;
            Map map2 = map;
            return paywallInfo.copy(str, str2, map2, str3, str7, str6, paywallProduct);
        }

        public /* synthetic */ PaywallInfo(String str, String str2, Map map, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, map, str3, str4, (i3 & 32) != 0 ? null : str5);
        }

        public /* synthetic */ PaywallInfo(String str, String str2, Map map, String str3, String str4, String str5, PaywallProduct paywallProduct, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, map, str3, str4, (i3 & 32) != 0 ? null : str5, paywallProduct);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PaywallInfo(String identifier, String placementName, Map<String, ? extends JsonElement> placementParams, String variantId, String experimentId, String str, PaywallProduct paywallProduct) {
            this(identifier, placementName, placementParams, variantId, experimentId, str);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(placementParams, "placementParams");
            Intrinsics.checkNotNullParameter(variantId, "variantId");
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            this.product = paywallProduct;
        }
    }

    public /* synthetic */ RedemptionResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("com.superwall.sdk.models.internal.RedemptionResult", Reflection.b(RedemptionResult.class), new KClass[]{Reflection.b(Error.class), Reflection.b(Expired.class), Reflection.b(ExpiredSubscription.class), Reflection.b(InvalidCode.class), Reflection.b(Success.class)}, new KSerializer[]{RedemptionResult$Error$$serializer.INSTANCE, RedemptionResult$Expired$$serializer.INSTANCE, RedemptionResult$ExpiredSubscription$$serializer.INSTANCE, RedemptionResult$InvalidCode$$serializer.INSTANCE, DirectSuccessSerializer.INSTANCE}, new Annotation[]{new RedemptionResult$Error$$serializer$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)});
    }

    public abstract String getCode();

    public final List<String> getPaddleSubscriptionIds() {
        StoreIdentifiers.Paddle paddle;
        List<String> paddleSubscriptionIds;
        if (!(this instanceof Success)) {
            return CollectionsKt.emptyList();
        }
        Success success = (Success) this;
        PurchaserInfo purchaserInfo = success.getRedemptionInfo().getPurchaserInfo();
        if (!((purchaserInfo != null ? purchaserInfo.getStoreIdentifiers() : null) instanceof StoreIdentifiers.Paddle)) {
            return CollectionsKt.emptyList();
        }
        PurchaserInfo purchaserInfo2 = success.getRedemptionInfo().getPurchaserInfo();
        return (purchaserInfo2 == null || (paddle = (StoreIdentifiers.Paddle) purchaserInfo2.getStoreIdentifiers()) == null || (paddleSubscriptionIds = paddle.getPaddleSubscriptionIds()) == null) ? CollectionsKt.emptyList() : paddleSubscriptionIds;
    }

    public final List<String> getStripeSubscriptionId() {
        StoreIdentifiers.Stripe stripe;
        List<String> subscriptionIds;
        if (!(this instanceof Success)) {
            return CollectionsKt.emptyList();
        }
        Success success = (Success) this;
        PurchaserInfo purchaserInfo = success.getRedemptionInfo().getPurchaserInfo();
        if (!((purchaserInfo != null ? purchaserInfo.getStoreIdentifiers() : null) instanceof StoreIdentifiers.Stripe)) {
            return CollectionsKt.emptyList();
        }
        PurchaserInfo purchaserInfo2 = success.getRedemptionInfo().getPurchaserInfo();
        return (purchaserInfo2 == null || (stripe = (StoreIdentifiers.Stripe) purchaserInfo2.getStoreIdentifiers()) == null || (subscriptionIds = stripe.getSubscriptionIds()) == null) ? CollectionsKt.emptyList() : subscriptionIds;
    }

    public final List<String> getSubscriptionIds() {
        return CollectionsKt.plus((Collection) getStripeSubscriptionId(), (Iterable) getPaddleSubscriptionIds());
    }

    private RedemptionResult() {
    }

    public /* synthetic */ RedemptionResult(int i3, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = DirectSuccessSerializer.class)
    @SerialName
    public static final class Success extends RedemptionResult {
        public static final Companion Companion = new Companion(null);
        private final String code;
        private final RedemptionInfo redemptionInfo;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Success> serializer() {
                return DirectSuccessSerializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String code, RedemptionInfo redemptionInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(redemptionInfo, "redemptionInfo");
            this.code = code;
            this.redemptionInfo = redemptionInfo;
        }

        public static /* synthetic */ Success copy$default(Success success, String str, RedemptionInfo redemptionInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = success.code;
            }
            if ((i3 & 2) != 0) {
                redemptionInfo = success.redemptionInfo;
            }
            return success.copy(str, redemptionInfo);
        }

        public final String component1() {
            return this.code;
        }

        public final RedemptionInfo component2() {
            return this.redemptionInfo;
        }

        public final Success copy(String code, RedemptionInfo redemptionInfo) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(redemptionInfo, "redemptionInfo");
            return new Success(code, redemptionInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual(this.code, success.code) && Intrinsics.areEqual(this.redemptionInfo, success.redemptionInfo);
        }

        @Override // com.superwall.sdk.models.internal.RedemptionResult
        public String getCode() {
            return this.code;
        }

        public final RedemptionInfo getRedemptionInfo() {
            return this.redemptionInfo;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.redemptionInfo.hashCode();
        }

        public String toString() {
            return "Success(code=" + this.code + ", redemptionInfo=" + this.redemptionInfo + ")";
        }

        @SerialName
        public static /* synthetic */ void getCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getRedemptionInfo$annotations() {
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(RedemptionResult redemptionResult, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }
}
