package com.superwall.sdk.models.paywall;

import android.graphics.Color;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.config.models.OnDeviceCaching;
import com.superwall.sdk.config.models.OnDeviceCachingSerializer;
import com.superwall.sdk.config.models.Survey;
import com.superwall.sdk.config.models.Survey$$serializer;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.SerializableEntity;
import com.superwall.sdk.models.config.ComputedPropertyRequest;
import com.superwall.sdk.models.config.ComputedPropertyRequest$$serializer;
import com.superwall.sdk.models.config.FeatureGatingBehavior;
import com.superwall.sdk.models.config.FeatureGatingBehaviorSerializer;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.models.paywall.PaywallWebviewUrl;
import com.superwall.sdk.models.product.CrossplatformProduct;
import com.superwall.sdk.models.product.CrossplatformProductSerializer;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.product.ProductItemSerializer;
import com.superwall.sdk.models.product.ProductVariable;
import com.superwall.sdk.models.product.ProductVariableSerializer;
import com.superwall.sdk.models.serialization.DateSerializer;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.EnumsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Serializable
public final class Paywall implements SerializableEntity {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private List<ProductItem> _productItems;
    private List<CrossplatformProduct> _productItemsV3;
    private List<ProductItem> _products;
    private final Lazy backgroundColor$delegate;
    private final String backgroundColorHex;
    private final String buildId;
    private final String cacheKey;
    private PaywallCloseReason closeReason;
    private List<ComputedPropertyRequest> computedPropertyRequests;
    private final Lazy darkBackgroundColor$delegate;
    private final String darkBackgroundColorHex;
    private final String databaseId;
    private final PaywallPresentationStyle expandedPresentationStyle;
    private Experiment experiment;
    private FeatureGatingBehavior featureGating;
    private final String htmlSubstitutions;
    private String identifier;
    private final IntroOfferEligibility introOfferEligibility;
    private boolean isFreeTrialAvailable;
    private final Boolean isScrollEnabled;
    private List<LocalNotification> localNotifications;
    private final String name;
    private OnDeviceCaching onDeviceCache;
    private String paywalljsVersion;
    private PaywallPresentationInfo presentation;
    private final String presentationCondition;
    private final long presentationDelay;
    private String presentationId;
    private String presentationSourceType;
    private final String presentationStyle;
    private List<String> productIds;
    private List<ProductVariable> productVariables;
    private LoadingInfo productsLoadingInfo;
    private final ToggleMode rerouteBackButton;
    private LoadingInfo responseLoadingInfo;
    private LoadingInfo shimmerLoadingInfo;
    private Map<String, ? extends Object> state;
    private List<Survey> surveys;
    private List<ProductVariable> swProductVariablesTemplate;
    private final String url;
    private final PaywallWebviewUrl.Config urlConfig;
    private LoadingInfo webviewLoadingInfo;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Paywall> serializer() {
            return Paywall$$serializer.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Paywall stub() {
            String strM1297constructorimpl = PaywallURL.m1297constructorimpl("https://google.com");
            PaywallPresentationStyle.Modal modal = PaywallPresentationStyle.Modal.INSTANCE;
            PaywallPresentationInfo paywallPresentationInfo = new PaywallPresentationInfo(modal, 300L);
            ArrayList arrayList = new ArrayList();
            List listEmptyList = CollectionsKt.emptyList();
            Date date = null;
            LoadingInfo loadingInfo = new LoadingInfo((Date) null, date, (Date) null, 7, (DefaultConstructorMarker) null);
            Date date2 = null;
            LoadingInfo loadingInfo2 = new LoadingInfo(date, (Date) (0 == true ? 1 : 0), date2, 7, (DefaultConstructorMarker) null);
            Object[] objArr = 0 == true ? 1 : 0;
            LoadingInfo loadingInfo3 = new LoadingInfo((Date) objArr, date2, (Date) null, 7, (DefaultConstructorMarker) null);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            FeatureGatingBehavior.NonGated nonGated = FeatureGatingBehavior.NonGated.INSTANCE;
            ArrayList arrayList4 = new ArrayList();
            PaywallWebviewUrl.Config config = new PaywallWebviewUrl.Config(3, CollectionsKt.listOf(new PaywallWebviewUrl("https://google.com", 1000L, 1)));
            ToggleMode toggleMode = ToggleMode.DISABLED;
            String str = "";
            boolean z2 = false;
            String str2 = null;
            List list = null;
            OnDeviceCaching onDeviceCaching = null;
            Experiment experiment = null;
            PaywallCloseReason paywallCloseReason = null;
            Map map = null;
            String str3 = null;
            String str4 = "123";
            String str5 = "test";
            List list2 = null;
            IntroOfferEligibility introOfferEligibility = null;
            int i3 = -184008704;
            return new Paywall("id", "identifier", "abac", strM1297constructorimpl, "", "MODAL", modal, 300L, "CHECK_USER_SUBSCRIPTION", paywallPresentationInfo, "000000", null, listEmptyList, CollectionsKt.emptyList(), null, arrayList, loadingInfo, loadingInfo2, loadingInfo3, 0 == true ? 1 : 0, arrayList2, arrayList3, str, z2, str2, nonGated, list, arrayList4, onDeviceCaching, experiment, paywallCloseReason, map, str3, config, str4, str5, list2, Boolean.TRUE, toggleMode, introOfferEligibility, i3, 145, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class LoadingInfo {
        public static final Companion Companion = new Companion(null);
        private Date endAt;
        private Date failAt;
        private Date startAt;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<LoadingInfo> serializer() {
                return Paywall$LoadingInfo$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public LoadingInfo() {
            this((Date) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ LoadingInfo copy$default(LoadingInfo loadingInfo, Date date, Date date2, Date date3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                date = loadingInfo.startAt;
            }
            if ((i3 & 2) != 0) {
                date2 = loadingInfo.endAt;
            }
            if ((i3 & 4) != 0) {
                date3 = loadingInfo.failAt;
            }
            return loadingInfo.copy(date, date2, date3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(LoadingInfo loadingInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            if (compositeEncoder.z(serialDescriptor, 0) || loadingInfo.startAt != null) {
                compositeEncoder.i(serialDescriptor, 0, DateSerializer.INSTANCE, loadingInfo.startAt);
            }
            if (compositeEncoder.z(serialDescriptor, 1) || loadingInfo.endAt != null) {
                compositeEncoder.i(serialDescriptor, 1, DateSerializer.INSTANCE, loadingInfo.endAt);
            }
            if (!compositeEncoder.z(serialDescriptor, 2) && loadingInfo.failAt == null) {
                return;
            }
            compositeEncoder.i(serialDescriptor, 2, DateSerializer.INSTANCE, loadingInfo.failAt);
        }

        public final Date component1() {
            return this.startAt;
        }

        public final Date component2() {
            return this.endAt;
        }

        public final Date component3() {
            return this.failAt;
        }

        public final LoadingInfo copy(Date date, Date date2, Date date3) {
            return new LoadingInfo(date, date2, date3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadingInfo)) {
                return false;
            }
            LoadingInfo loadingInfo = (LoadingInfo) obj;
            return Intrinsics.areEqual(this.startAt, loadingInfo.startAt) && Intrinsics.areEqual(this.endAt, loadingInfo.endAt) && Intrinsics.areEqual(this.failAt, loadingInfo.failAt);
        }

        public final Date getEndAt() {
            return this.endAt;
        }

        public final Date getFailAt() {
            return this.failAt;
        }

        public final Date getStartAt() {
            return this.startAt;
        }

        public int hashCode() {
            Date date = this.startAt;
            int iHashCode = (date == null ? 0 : date.hashCode()) * 31;
            Date date2 = this.endAt;
            int iHashCode2 = (iHashCode + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.failAt;
            return iHashCode2 + (date3 != null ? date3.hashCode() : 0);
        }

        public final void setEndAt(Date date) {
            this.endAt = date;
        }

        public final void setFailAt(Date date) {
            this.failAt = date;
        }

        public final void setStartAt(Date date) {
            this.startAt = date;
        }

        public String toString() {
            return "LoadingInfo(startAt=" + this.startAt + ", endAt=" + this.endAt + ", failAt=" + this.failAt + ")";
        }

        public /* synthetic */ LoadingInfo(int i3, Date date, Date date2, Date date3, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i3 & 1) == 0) {
                this.startAt = null;
            } else {
                this.startAt = date;
            }
            if ((i3 & 2) == 0) {
                this.endAt = null;
            } else {
                this.endAt = date2;
            }
            if ((i3 & 4) == 0) {
                this.failAt = null;
            } else {
                this.failAt = date3;
            }
        }

        public LoadingInfo(Date date, Date date2, Date date3) {
            this.startAt = date;
            this.endAt = date2;
            this.failAt = date3;
        }

        public /* synthetic */ LoadingInfo(Date date, Date date2, Date date3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : date, (i3 & 2) != 0 ? null : date2, (i3 & 4) != 0 ? null : date3);
        }

        @Serializable(with = DateSerializer.class)
        public static /* synthetic */ void getEndAt$annotations() {
        }

        @Serializable(with = DateSerializer.class)
        public static /* synthetic */ void getFailAt$annotations() {
        }

        @Serializable(with = DateSerializer.class)
        public static /* synthetic */ void getStartAt$annotations() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ToggleMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ToggleMode[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
        public static final Companion Companion;

        @SerialName
        public static final ToggleMode ENABLED = new ToggleMode("ENABLED", 0);

        @SerialName
        public static final ToggleMode DISABLED = new ToggleMode("DISABLED", 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) ToggleMode.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<ToggleMode> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ToggleMode[] $values() {
            return new ToggleMode[]{ENABLED, DISABLED};
        }

        static {
            ToggleMode[] toggleModeArr$values = $values();
            $VALUES = toggleModeArr$values;
            $ENTRIES = EnumEntriesKt.a(toggleModeArr$values);
            Companion = new Companion(null);
            $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Paywall.ToggleMode._init_$_anonymous_();
                }
            });
        }

        private ToggleMode(String str, int i3) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.a("com.superwall.sdk.models.paywall.Paywall.ToggleMode", values(), new String[]{"ENABLED", "DISABLED"}, new Annotation[][]{null, null}, null);
        }

        public static EnumEntries<ToggleMode> getEntries() {
            return $ENTRIES;
        }

        public static ToggleMode valueOf(String str) {
            return (ToggleMode) Enum.valueOf(ToggleMode.class, str);
        }

        public static ToggleMode[] values() {
            return (ToggleMode[]) $VALUES.clone();
        }
    }

    static {
        KSerializer<PaywallPresentationStyle> kSerializerSerializer = PaywallPresentationStyle.Companion.serializer();
        ArrayListSerializer arrayListSerializer = new ArrayListSerializer(CrossplatformProductSerializer.INSTANCE);
        ArrayListSerializer arrayListSerializer2 = new ArrayListSerializer(ProductItemSerializer.INSTANCE);
        ProductVariableSerializer productVariableSerializer = ProductVariableSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, null, kSerializerSerializer, null, null, null, null, arrayListSerializer, arrayListSerializer2, new ArrayListSerializer(productVariableSerializer), new ArrayListSerializer(productVariableSerializer), null, null, null, null, new ArrayListSerializer(ComputedPropertyRequest$$serializer.INSTANCE), new ArrayListSerializer(LocalNotification$$serializer.INSTANCE), null, null, null, null, new ArrayListSerializer(Survey$$serializer.INSTANCE), null, ToggleMode.Companion.serializer(), IntroOfferEligibility.Companion.serializer()};
    }

    public /* synthetic */ Paywall(int i3, String str, String str2, String str3, String str4, String str5, String str6, PaywallPresentationStyle paywallPresentationStyle, long j3, String str7, String str8, String str9, List list, List list2, List list3, List list4, String str10, boolean z2, String str11, FeatureGatingBehavior featureGatingBehavior, List list5, List list6, OnDeviceCaching onDeviceCaching, PaywallWebviewUrl.Config config, String str12, String str13, List list7, Boolean bool, ToggleMode toggleMode, IntroOfferEligibility introOfferEligibility, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, str3, str4, str5, str6, paywallPresentationStyle, j3, str7, str8, str9, list, list2, list3, list4, str10, z2, str11, featureGatingBehavior, list5, list6, onDeviceCaching, config, str12, str13, list7, bool, toggleMode, introOfferEligibility, serializationConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$19(Paywall paywall) {
        try {
            return Color.parseColor(paywall.backgroundColorHex);
        } catch (Throwable unused) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallView, "Invalid paywall background color: " + paywall.backgroundColorHex + ". Defaulting to white.", (Map) null, (Throwable) null, 24, (Object) null);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer _init_$lambda$20(Paywall paywall) {
        try {
            return Integer.valueOf(Color.parseColor(paywall.darkBackgroundColorHex));
        } catch (Throwable unused) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallView, "Invalid paywall background color: " + paywall.darkBackgroundColorHex + ". Defaulting to white.", (Map) null, (Throwable) null, 24, (Object) null);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int backgroundColor_delegate$lambda$13(Paywall paywall) {
        try {
            return Color.parseColor(paywall.backgroundColorHex);
        } catch (Throwable unused) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallView, "Invalid paywall background color: " + paywall.backgroundColorHex + ". Defaulting to white.", (Map) null, (Throwable) null, 24, (Object) null);
            return -1;
        }
    }

    private final List<ProductItem> component13() {
        return this._products;
    }

    private final String component6() {
        return this.presentationStyle;
    }

    private final PaywallPresentationStyle component7() {
        return this.expandedPresentationStyle;
    }

    private final long component8() {
        return this.presentationDelay;
    }

    private final String component9() {
        return this.presentationCondition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer darkBackgroundColor_delegate$lambda$14(Paywall paywall) {
        try {
            return Integer.valueOf(Color.parseColor(paywall.darkBackgroundColorHex));
        } catch (Throwable unused) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallView, "Invalid paywall background color: " + paywall.darkBackgroundColorHex + ". Defaulting to white.", (Map) null, (Throwable) null, 24, (Object) null);
            return null;
        }
    }

    @SerialName
    public static /* synthetic */ void getBackgroundColorHex$annotations() {
    }

    @SerialName
    @Serializable
    public static /* synthetic */ void getBuildId$annotations() {
    }

    @SerialName
    @Serializable
    public static /* synthetic */ void getCacheKey$annotations() {
    }

    @Transient
    public static /* synthetic */ void getCloseReason$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getComputedPropertyRequests$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDarkBackgroundColorHex$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getDatabaseId$annotations() {
    }

    @SerialName
    private static /* synthetic */ void getExpandedPresentationStyle$annotations() {
    }

    @Transient
    public static /* synthetic */ void getExperiment$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getFeatureGating$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getHtmlSubstitutions$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getIdentifier$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getIntroOfferEligibility$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLocalNotifications$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getOnDeviceCache$annotations() {
    }

    @Transient
    public static /* synthetic */ void getPresentation$annotations() {
    }

    @SerialName
    private static /* synthetic */ void getPresentationCondition$annotations() {
    }

    @SerialName
    private static /* synthetic */ void getPresentationDelay$annotations() {
    }

    @Transient
    public static /* synthetic */ void getPresentationId$annotations() {
    }

    @SerialName
    private static /* synthetic */ void getPresentationStyle$annotations() {
    }

    @Transient
    public static /* synthetic */ void getProductIds$annotations() {
    }

    @Transient
    public static /* synthetic */ void getProductsLoadingInfo$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getRerouteBackButton$annotations() {
    }

    @Transient
    public static /* synthetic */ void getResponseLoadingInfo$annotations() {
    }

    @Transient
    public static /* synthetic */ void getShimmerLoadingInfo$annotations() {
    }

    @Transient
    public static /* synthetic */ void getState$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSurveys$annotations() {
    }

    @SerialName
    /* JADX INFO: renamed from: getUrl-24UBhI0$annotations, reason: not valid java name */
    public static /* synthetic */ void m1292getUrl24UBhI0$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getUrlConfig$annotations() {
    }

    @Transient
    public static /* synthetic */ void getWebviewLoadingInfo$annotations() {
    }

    @SerialName
    public static /* synthetic */ void get_productItems$superwall_release$annotations() {
    }

    @SerialName
    public static /* synthetic */ void get_productItemsV3$superwall_release$annotations() {
    }

    @Transient
    private static /* synthetic */ void get_products$annotations() {
    }

    @SerialName
    public static /* synthetic */ void isScrollEnabled$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(Paywall paywall, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, paywall.databaseId);
        compositeEncoder.y(serialDescriptor, 1, paywall.identifier);
        compositeEncoder.y(serialDescriptor, 2, paywall.name);
        compositeEncoder.C(serialDescriptor, 3, PaywallURL$$serializer.INSTANCE, PaywallURL.m1296boximpl(paywall.url));
        compositeEncoder.y(serialDescriptor, 4, paywall.htmlSubstitutions);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        compositeEncoder.i(serialDescriptor, 5, stringSerializer, paywall.presentationStyle);
        compositeEncoder.i(serialDescriptor, 6, kSerializerArr[6], paywall.expandedPresentationStyle);
        compositeEncoder.F(serialDescriptor, 7, paywall.presentationDelay);
        compositeEncoder.y(serialDescriptor, 8, paywall.presentationCondition);
        compositeEncoder.y(serialDescriptor, 9, paywall.backgroundColorHex);
        if (compositeEncoder.z(serialDescriptor, 10) || paywall.darkBackgroundColorHex != null) {
            compositeEncoder.i(serialDescriptor, 10, stringSerializer, paywall.darkBackgroundColorHex);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || !Intrinsics.areEqual(paywall._productItemsV3, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 11, kSerializerArr[11], paywall._productItemsV3);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || !Intrinsics.areEqual(paywall._productItems, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 12, kSerializerArr[12], paywall._productItems);
        }
        if (compositeEncoder.z(serialDescriptor, 13) || paywall.productVariables != null) {
            compositeEncoder.i(serialDescriptor, 13, kSerializerArr[13], paywall.productVariables);
        }
        if (compositeEncoder.z(serialDescriptor, 14) || paywall.swProductVariablesTemplate != null) {
            compositeEncoder.i(serialDescriptor, 14, kSerializerArr[14], paywall.swProductVariablesTemplate);
        }
        if (compositeEncoder.z(serialDescriptor, 15) || paywall.paywalljsVersion != null) {
            compositeEncoder.i(serialDescriptor, 15, stringSerializer, paywall.paywalljsVersion);
        }
        if (compositeEncoder.z(serialDescriptor, 16) || paywall.isFreeTrialAvailable) {
            compositeEncoder.x(serialDescriptor, 16, paywall.isFreeTrialAvailable);
        }
        if (compositeEncoder.z(serialDescriptor, 17) || paywall.presentationSourceType != null) {
            compositeEncoder.i(serialDescriptor, 17, stringSerializer, paywall.presentationSourceType);
        }
        if (compositeEncoder.z(serialDescriptor, 18) || !Intrinsics.areEqual(paywall.featureGating, FeatureGatingBehavior.NonGated.INSTANCE)) {
            compositeEncoder.C(serialDescriptor, 18, FeatureGatingBehaviorSerializer.INSTANCE, paywall.featureGating);
        }
        if (compositeEncoder.z(serialDescriptor, 19) || !Intrinsics.areEqual(paywall.computedPropertyRequests, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 19, kSerializerArr[19], paywall.computedPropertyRequests);
        }
        if (compositeEncoder.z(serialDescriptor, 20) || !Intrinsics.areEqual(paywall.localNotifications, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 20, kSerializerArr[20], paywall.localNotifications);
        }
        if (compositeEncoder.z(serialDescriptor, 21) || !Intrinsics.areEqual(paywall.onDeviceCache, OnDeviceCaching.Disabled.INSTANCE)) {
            compositeEncoder.C(serialDescriptor, 21, OnDeviceCachingSerializer.INSTANCE, paywall.onDeviceCache);
        }
        if (compositeEncoder.z(serialDescriptor, 22) || paywall.urlConfig != null) {
            compositeEncoder.i(serialDescriptor, 22, PaywallWebviewUrl$Config$$serializer.INSTANCE, paywall.urlConfig);
        }
        compositeEncoder.y(serialDescriptor, 23, paywall.cacheKey);
        compositeEncoder.y(serialDescriptor, 24, paywall.buildId);
        if (compositeEncoder.z(serialDescriptor, 25) || !Intrinsics.areEqual(paywall.surveys, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 25, kSerializerArr[25], paywall.surveys);
        }
        if (compositeEncoder.z(serialDescriptor, 26) || !Intrinsics.areEqual(paywall.isScrollEnabled, Boolean.TRUE)) {
            compositeEncoder.i(serialDescriptor, 26, BooleanSerializer.f142767a, paywall.isScrollEnabled);
        }
        if (compositeEncoder.z(serialDescriptor, 27) || paywall.rerouteBackButton != null) {
            compositeEncoder.i(serialDescriptor, 27, kSerializerArr[27], paywall.rerouteBackButton);
        }
        if (!compositeEncoder.z(serialDescriptor, 28) && paywall.introOfferEligibility == IntroOfferEligibility.AUTOMATIC) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 28, kSerializerArr[28], paywall.introOfferEligibility);
    }

    public final String component1() {
        return this.databaseId;
    }

    public final PaywallPresentationInfo component10() {
        return this.presentation;
    }

    public final String component11() {
        return this.backgroundColorHex;
    }

    public final String component12() {
        return this.darkBackgroundColorHex;
    }

    public final List<CrossplatformProduct> component14$superwall_release() {
        return this._productItemsV3;
    }

    public final List<ProductItem> component15$superwall_release() {
        return this._productItems;
    }

    public final List<String> component16() {
        return this.productIds;
    }

    public final LoadingInfo component17() {
        return this.responseLoadingInfo;
    }

    public final LoadingInfo component18() {
        return this.webviewLoadingInfo;
    }

    public final LoadingInfo component19() {
        return this.productsLoadingInfo;
    }

    public final String component2() {
        return this.identifier;
    }

    public final LoadingInfo component20() {
        return this.shimmerLoadingInfo;
    }

    public final List<ProductVariable> component21() {
        return this.productVariables;
    }

    public final List<ProductVariable> component22() {
        return this.swProductVariablesTemplate;
    }

    public final String component23() {
        return this.paywalljsVersion;
    }

    public final boolean component24() {
        return this.isFreeTrialAvailable;
    }

    public final String component25() {
        return this.presentationSourceType;
    }

    public final FeatureGatingBehavior component26() {
        return this.featureGating;
    }

    public final List<ComputedPropertyRequest> component27() {
        return this.computedPropertyRequests;
    }

    public final List<LocalNotification> component28() {
        return this.localNotifications;
    }

    public final OnDeviceCaching component29() {
        return this.onDeviceCache;
    }

    public final String component3() {
        return this.name;
    }

    public final Experiment component30() {
        return this.experiment;
    }

    public final PaywallCloseReason component31() {
        return this.closeReason;
    }

    public final Map<String, Object> component32() {
        return this.state;
    }

    public final String component33() {
        return this.presentationId;
    }

    public final PaywallWebviewUrl.Config component34() {
        return this.urlConfig;
    }

    public final String component35() {
        return this.cacheKey;
    }

    public final String component36() {
        return this.buildId;
    }

    public final List<Survey> component37() {
        return this.surveys;
    }

    public final Boolean component38() {
        return this.isScrollEnabled;
    }

    public final ToggleMode component39() {
        return this.rerouteBackButton;
    }

    /* JADX INFO: renamed from: component4-24UBhI0, reason: not valid java name */
    public final String m1293component424UBhI0() {
        return this.url;
    }

    public final IntroOfferEligibility component40() {
        return this.introOfferEligibility;
    }

    public final String component5() {
        return this.htmlSubstitutions;
    }

    /* JADX INFO: renamed from: copy-BiBlP3E, reason: not valid java name */
    public final Paywall m1294copyBiBlP3E(String databaseId, String identifier, String name, String url, String htmlSubstitutions, String str, PaywallPresentationStyle paywallPresentationStyle, long j3, String presentationCondition, PaywallPresentationInfo presentation, String backgroundColorHex, String str2, List<ProductItem> _products, List<CrossplatformProduct> _productItemsV3, List<ProductItem> _productItems, List<String> productIds, LoadingInfo responseLoadingInfo, LoadingInfo webviewLoadingInfo, LoadingInfo productsLoadingInfo, LoadingInfo shimmerLoadingInfo, List<ProductVariable> list, List<ProductVariable> list2, String str3, boolean z2, String str4, FeatureGatingBehavior featureGating, List<ComputedPropertyRequest> computedPropertyRequests, List<LocalNotification> localNotifications, OnDeviceCaching onDeviceCache, Experiment experiment, PaywallCloseReason closeReason, Map<String, ? extends Object> state, String str5, PaywallWebviewUrl.Config config, String cacheKey, String buildId, List<Survey> surveys, Boolean bool, ToggleMode toggleMode, IntroOfferEligibility introOfferEligibility) {
        Intrinsics.checkNotNullParameter(databaseId, "databaseId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(htmlSubstitutions, "htmlSubstitutions");
        Intrinsics.checkNotNullParameter(presentationCondition, "presentationCondition");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(backgroundColorHex, "backgroundColorHex");
        Intrinsics.checkNotNullParameter(_products, "_products");
        Intrinsics.checkNotNullParameter(_productItemsV3, "_productItemsV3");
        Intrinsics.checkNotNullParameter(_productItems, "_productItems");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(responseLoadingInfo, "responseLoadingInfo");
        Intrinsics.checkNotNullParameter(webviewLoadingInfo, "webviewLoadingInfo");
        Intrinsics.checkNotNullParameter(productsLoadingInfo, "productsLoadingInfo");
        Intrinsics.checkNotNullParameter(shimmerLoadingInfo, "shimmerLoadingInfo");
        Intrinsics.checkNotNullParameter(featureGating, "featureGating");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(localNotifications, "localNotifications");
        Intrinsics.checkNotNullParameter(onDeviceCache, "onDeviceCache");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(introOfferEligibility, "introOfferEligibility");
        return new Paywall(databaseId, identifier, name, url, htmlSubstitutions, str, paywallPresentationStyle, j3, presentationCondition, presentation, backgroundColorHex, str2, _products, _productItemsV3, _productItems, productIds, responseLoadingInfo, webviewLoadingInfo, productsLoadingInfo, shimmerLoadingInfo, list, list2, str3, z2, str4, featureGating, computedPropertyRequests, localNotifications, onDeviceCache, experiment, closeReason, state, str5, config, cacheKey, buildId, surveys, bool, toggleMode, introOfferEligibility, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Paywall)) {
            return false;
        }
        Paywall paywall = (Paywall) obj;
        return Intrinsics.areEqual(this.databaseId, paywall.databaseId) && Intrinsics.areEqual(this.identifier, paywall.identifier) && Intrinsics.areEqual(this.name, paywall.name) && PaywallURL.m1299equalsimpl0(this.url, paywall.url) && Intrinsics.areEqual(this.htmlSubstitutions, paywall.htmlSubstitutions) && Intrinsics.areEqual(this.presentationStyle, paywall.presentationStyle) && Intrinsics.areEqual(this.expandedPresentationStyle, paywall.expandedPresentationStyle) && this.presentationDelay == paywall.presentationDelay && Intrinsics.areEqual(this.presentationCondition, paywall.presentationCondition) && Intrinsics.areEqual(this.presentation, paywall.presentation) && Intrinsics.areEqual(this.backgroundColorHex, paywall.backgroundColorHex) && Intrinsics.areEqual(this.darkBackgroundColorHex, paywall.darkBackgroundColorHex) && Intrinsics.areEqual(this._products, paywall._products) && Intrinsics.areEqual(this._productItemsV3, paywall._productItemsV3) && Intrinsics.areEqual(this._productItems, paywall._productItems) && Intrinsics.areEqual(this.productIds, paywall.productIds) && Intrinsics.areEqual(this.responseLoadingInfo, paywall.responseLoadingInfo) && Intrinsics.areEqual(this.webviewLoadingInfo, paywall.webviewLoadingInfo) && Intrinsics.areEqual(this.productsLoadingInfo, paywall.productsLoadingInfo) && Intrinsics.areEqual(this.shimmerLoadingInfo, paywall.shimmerLoadingInfo) && Intrinsics.areEqual(this.productVariables, paywall.productVariables) && Intrinsics.areEqual(this.swProductVariablesTemplate, paywall.swProductVariablesTemplate) && Intrinsics.areEqual(this.paywalljsVersion, paywall.paywalljsVersion) && this.isFreeTrialAvailable == paywall.isFreeTrialAvailable && Intrinsics.areEqual(this.presentationSourceType, paywall.presentationSourceType) && Intrinsics.areEqual(this.featureGating, paywall.featureGating) && Intrinsics.areEqual(this.computedPropertyRequests, paywall.computedPropertyRequests) && Intrinsics.areEqual(this.localNotifications, paywall.localNotifications) && Intrinsics.areEqual(this.onDeviceCache, paywall.onDeviceCache) && Intrinsics.areEqual(this.experiment, paywall.experiment) && Intrinsics.areEqual(this.closeReason, paywall.closeReason) && Intrinsics.areEqual(this.state, paywall.state) && Intrinsics.areEqual(this.presentationId, paywall.presentationId) && Intrinsics.areEqual(this.urlConfig, paywall.urlConfig) && Intrinsics.areEqual(this.cacheKey, paywall.cacheKey) && Intrinsics.areEqual(this.buildId, paywall.buildId) && Intrinsics.areEqual(this.surveys, paywall.surveys) && Intrinsics.areEqual(this.isScrollEnabled, paywall.isScrollEnabled) && this.rerouteBackButton == paywall.rerouteBackButton && this.introOfferEligibility == paywall.introOfferEligibility;
    }

    public final int getBackgroundColor() {
        return ((Number) this.backgroundColor$delegate.getValue()).intValue();
    }

    public final String getBackgroundColorHex() {
        return this.backgroundColorHex;
    }

    public final String getBuildId() {
        return this.buildId;
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final PaywallCloseReason getCloseReason() {
        return this.closeReason;
    }

    public final List<ComputedPropertyRequest> getComputedPropertyRequests() {
        return this.computedPropertyRequests;
    }

    public final List<CrossplatformProduct> getCustomProducts() {
        List<CrossplatformProduct> list = this._productItemsV3;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CrossplatformProduct) obj).getStoreProduct() instanceof CrossplatformProduct.StoreProduct.Custom) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final Integer getDarkBackgroundColor() {
        return (Integer) this.darkBackgroundColor$delegate.getValue();
    }

    public final String getDarkBackgroundColorHex() {
        return this.darkBackgroundColorHex;
    }

    public final String getDatabaseId() {
        return this.databaseId;
    }

    public final Experiment getExperiment() {
        return this.experiment;
    }

    public final FeatureGatingBehavior getFeatureGating() {
        return this.featureGating;
    }

    public final String getHtmlSubstitutions() {
        return this.htmlSubstitutions;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final PaywallInfo getInfo(EventData eventData) {
        String str = this.databaseId;
        String str2 = this.identifier;
        String str3 = this.name;
        String str4 = this.url;
        List<ProductItem> products = getProducts();
        List<String> list = this.productIds;
        Date startAt = this.responseLoadingInfo.getStartAt();
        Date endAt = this.responseLoadingInfo.getEndAt();
        Date failAt = this.responseLoadingInfo.getFailAt();
        Date startAt2 = this.webviewLoadingInfo.getStartAt();
        Date endAt2 = this.webviewLoadingInfo.getEndAt();
        Date failAt2 = this.webviewLoadingInfo.getFailAt();
        Date startAt3 = this.productsLoadingInfo.getStartAt();
        Date failAt3 = this.productsLoadingInfo.getFailAt();
        Date endAt3 = this.productsLoadingInfo.getEndAt();
        Date startAt4 = this.shimmerLoadingInfo.getStartAt();
        Date endAt4 = this.shimmerLoadingInfo.getEndAt();
        Experiment experiment = this.experiment;
        String str5 = this.paywalljsVersion;
        boolean z2 = this.isFreeTrialAvailable;
        String str6 = this.presentationSourceType;
        FeatureGatingBehavior featureGatingBehavior = this.featureGating;
        PaywallCloseReason paywallCloseReason = this.closeReason;
        List<LocalNotification> list2 = this.localNotifications;
        List<ComputedPropertyRequest> list3 = this.computedPropertyRequests;
        List<Survey> list4 = this.surveys;
        PaywallPresentationInfo paywallPresentationInfo = this.presentation;
        String str7 = this.cacheKey;
        String str8 = this.buildId;
        Boolean bool = this.isScrollEnabled;
        return new PaywallInfo(str, str2, str3, str4, products, list, eventData, startAt, endAt, failAt, startAt2, endAt2, failAt2, startAt3, failAt3, endAt3, startAt4, endAt4, experiment, str5, z2, str6, featureGatingBehavior, list2, list3, paywallCloseReason, list4, paywallPresentationInfo, str8, str7, bool != null ? bool.booleanValue() : true, this.state, null, this.presentationId, 0, 1, null);
    }

    public final IntroOfferEligibility getIntroOfferEligibility() {
        return this.introOfferEligibility;
    }

    public final List<LocalNotification> getLocalNotifications() {
        return this.localNotifications;
    }

    public final String getName() {
        return this.name;
    }

    public final OnDeviceCaching getOnDeviceCache() {
        return this.onDeviceCache;
    }

    public final List<CrossplatformProduct> getPaddleProducts() {
        List<CrossplatformProduct> list = this._productItemsV3;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CrossplatformProduct) obj).getStoreProduct() instanceof CrossplatformProduct.StoreProduct.Paddle) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final String getPaywalljsVersion() {
        return this.paywalljsVersion;
    }

    public final List<CrossplatformProduct> getPlayStoreProducts() {
        if (!this._productItemsV3.isEmpty() || getProductItems().isEmpty()) {
            List<CrossplatformProduct> list = this._productItemsV3;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((CrossplatformProduct) obj).getStoreProduct() instanceof CrossplatformProduct.StoreProduct.PlayStore) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        List<ProductItem> productItems = getProductItems();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : productItems) {
            if (((ProductItem) obj2).getType() instanceof ProductItem.StoreProductType.PlayStore) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            ProductItem productItem = (ProductItem) obj3;
            ProductItem.StoreProductType type = productItem.getType();
            Intrinsics.checkNotNull(type, "null cannot be cast to non-null type com.superwall.sdk.models.product.ProductItem.StoreProductType.PlayStore");
            ProductItem.StoreProductType.PlayStore playStore = (ProductItem.StoreProductType.PlayStore) type;
            arrayList3.add(new CrossplatformProduct(productItem.getCompositeId(), new CrossplatformProduct.StoreProduct.PlayStore(playStore.getProduct().getProductIdentifier(), playStore.getProduct().getBasePlanIdentifier(), playStore.getProduct().getOffer()), CollectionsKt.toList(productItem.getEntitlements()), productItem.getName()));
        }
        return arrayList3;
    }

    public final PaywallPresentationInfo getPresentation() {
        return this.presentation;
    }

    public final String getPresentationId() {
        return this.presentationId;
    }

    public final String getPresentationSourceType() {
        return this.presentationSourceType;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final List<ProductItem> getProductItems() {
        List<ProductItem> list = this._productItems;
        if (list.isEmpty()) {
            List<CrossplatformProduct> list2 = this._productItemsV3;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(CrossplatformProduct.Companion.toProductItem((CrossplatformProduct) it.next()));
            }
            list = arrayList;
        }
        return list;
    }

    public final List<ProductVariable> getProductVariables() {
        return this.productVariables;
    }

    public final List<ProductItem> getProducts() {
        return this._products;
    }

    public final LoadingInfo getProductsLoadingInfo() {
        return this.productsLoadingInfo;
    }

    public final ToggleMode getRerouteBackButton() {
        return this.rerouteBackButton;
    }

    public final LoadingInfo getResponseLoadingInfo() {
        return this.responseLoadingInfo;
    }

    public final LoadingInfo getShimmerLoadingInfo() {
        return this.shimmerLoadingInfo;
    }

    public final Map<String, Object> getState() {
        return this.state;
    }

    public final List<CrossplatformProduct> getStripeProducts() {
        List<CrossplatformProduct> list = this._productItemsV3;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((CrossplatformProduct) obj).getStoreProduct() instanceof CrossplatformProduct.StoreProduct.Stripe) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<Survey> getSurveys() {
        return this.surveys;
    }

    public final List<ProductVariable> getSwProductVariablesTemplate() {
        return this.swProductVariablesTemplate;
    }

    /* JADX INFO: renamed from: getUrl-24UBhI0, reason: not valid java name */
    public final String m1295getUrl24UBhI0() {
        return this.url;
    }

    public final PaywallWebviewUrl.Config getUrlConfig() {
        return this.urlConfig;
    }

    public final LoadingInfo getWebviewLoadingInfo() {
        return this.webviewLoadingInfo;
    }

    public final List<ProductItem> get_productItems$superwall_release() {
        return this._productItems;
    }

    public final List<CrossplatformProduct> get_productItemsV3$superwall_release() {
        return this._productItemsV3;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.databaseId.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.name.hashCode()) * 31) + PaywallURL.m1300hashCodeimpl(this.url)) * 31) + this.htmlSubstitutions.hashCode()) * 31;
        String str = this.presentationStyle;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        PaywallPresentationStyle paywallPresentationStyle = this.expandedPresentationStyle;
        int iHashCode3 = (((((((((iHashCode2 + (paywallPresentationStyle == null ? 0 : paywallPresentationStyle.hashCode())) * 31) + Long.hashCode(this.presentationDelay)) * 31) + this.presentationCondition.hashCode()) * 31) + this.presentation.hashCode()) * 31) + this.backgroundColorHex.hashCode()) * 31;
        String str2 = this.darkBackgroundColorHex;
        int iHashCode4 = (((((((((((((((((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this._products.hashCode()) * 31) + this._productItemsV3.hashCode()) * 31) + this._productItems.hashCode()) * 31) + this.productIds.hashCode()) * 31) + this.responseLoadingInfo.hashCode()) * 31) + this.webviewLoadingInfo.hashCode()) * 31) + this.productsLoadingInfo.hashCode()) * 31) + this.shimmerLoadingInfo.hashCode()) * 31;
        List<ProductVariable> list = this.productVariables;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<ProductVariable> list2 = this.swProductVariablesTemplate;
        int iHashCode6 = (iHashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str3 = this.paywalljsVersion;
        int iHashCode7 = (((iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isFreeTrialAvailable)) * 31;
        String str4 = this.presentationSourceType;
        int iHashCode8 = (((((((((iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.featureGating.hashCode()) * 31) + this.computedPropertyRequests.hashCode()) * 31) + this.localNotifications.hashCode()) * 31) + this.onDeviceCache.hashCode()) * 31;
        Experiment experiment = this.experiment;
        int iHashCode9 = (((((iHashCode8 + (experiment == null ? 0 : experiment.hashCode())) * 31) + this.closeReason.hashCode()) * 31) + this.state.hashCode()) * 31;
        String str5 = this.presentationId;
        int iHashCode10 = (iHashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        PaywallWebviewUrl.Config config = this.urlConfig;
        int iHashCode11 = (((((((iHashCode10 + (config == null ? 0 : config.hashCode())) * 31) + this.cacheKey.hashCode()) * 31) + this.buildId.hashCode()) * 31) + this.surveys.hashCode()) * 31;
        Boolean bool = this.isScrollEnabled;
        int iHashCode12 = (iHashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        ToggleMode toggleMode = this.rerouteBackButton;
        return ((iHashCode12 + (toggleMode != null ? toggleMode.hashCode() : 0)) * 31) + this.introOfferEligibility.hashCode();
    }

    public final boolean isFreeTrialAvailable() {
        return this.isFreeTrialAvailable;
    }

    public final Boolean isScrollEnabled() {
        return this.isScrollEnabled;
    }

    public final void setCloseReason(PaywallCloseReason paywallCloseReason) {
        Intrinsics.checkNotNullParameter(paywallCloseReason, "<set-?>");
        this.closeReason = paywallCloseReason;
    }

    public final void setComputedPropertyRequests(List<ComputedPropertyRequest> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.computedPropertyRequests = list;
    }

    public final void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public final void setFeatureGating(FeatureGatingBehavior featureGatingBehavior) {
        Intrinsics.checkNotNullParameter(featureGatingBehavior, "<set-?>");
        this.featureGating = featureGatingBehavior;
    }

    public final void setFreeTrialAvailable(boolean z2) {
        this.isFreeTrialAvailable = z2;
    }

    public final void setIdentifier(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.identifier = str;
    }

    public final void setLocalNotifications(List<LocalNotification> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.localNotifications = list;
    }

    public final void setOnDeviceCache(OnDeviceCaching onDeviceCaching) {
        Intrinsics.checkNotNullParameter(onDeviceCaching, "<set-?>");
        this.onDeviceCache = onDeviceCaching;
    }

    public final void setPaywalljsVersion(String str) {
        this.paywalljsVersion = str;
    }

    public final void setPresentation(PaywallPresentationInfo paywallPresentationInfo) {
        Intrinsics.checkNotNullParameter(paywallPresentationInfo, "<set-?>");
        this.presentation = paywallPresentationInfo;
    }

    public final void setPresentationId(String str) {
        this.presentationId = str;
    }

    public final void setPresentationSourceType(String str) {
        this.presentationSourceType = str;
    }

    public final void setProductIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.productIds = list;
    }

    public final void setProductItems(List<ProductItem> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._productItems = value;
        this._products = value;
        List<ProductItem> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ProductItem) it.next()).getFullProductId());
        }
        this.productIds = arrayList;
    }

    public final void setProductVariables(List<ProductVariable> list) {
        this.productVariables = list;
    }

    public final void setProductsLoadingInfo(LoadingInfo loadingInfo) {
        Intrinsics.checkNotNullParameter(loadingInfo, "<set-?>");
        this.productsLoadingInfo = loadingInfo;
    }

    public final void setResponseLoadingInfo(LoadingInfo loadingInfo) {
        Intrinsics.checkNotNullParameter(loadingInfo, "<set-?>");
        this.responseLoadingInfo = loadingInfo;
    }

    public final void setShimmerLoadingInfo(LoadingInfo loadingInfo) {
        Intrinsics.checkNotNullParameter(loadingInfo, "<set-?>");
        this.shimmerLoadingInfo = loadingInfo;
    }

    public final void setState(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.state = map;
    }

    public final void setSurveys(List<Survey> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.surveys = list;
    }

    public final void setSwProductVariablesTemplate(List<ProductVariable> list) {
        this.swProductVariablesTemplate = list;
    }

    public final void setWebviewLoadingInfo(LoadingInfo loadingInfo) {
        Intrinsics.checkNotNullParameter(loadingInfo, "<set-?>");
        this.webviewLoadingInfo = loadingInfo;
    }

    public final void set_productItemsV3$superwall_release(List<CrossplatformProduct> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this._productItemsV3 = list;
    }

    public String toString() {
        return "Paywall(databaseId=" + this.databaseId + ", identifier=" + this.identifier + ", name=" + this.name + ", url=" + PaywallURL.m1301toStringimpl(this.url) + ", htmlSubstitutions=" + this.htmlSubstitutions + ", presentationStyle=" + this.presentationStyle + ", expandedPresentationStyle=" + this.expandedPresentationStyle + ", presentationDelay=" + this.presentationDelay + ", presentationCondition=" + this.presentationCondition + ", presentation=" + this.presentation + ", backgroundColorHex=" + this.backgroundColorHex + ", darkBackgroundColorHex=" + this.darkBackgroundColorHex + ", _products=" + this._products + ", _productItemsV3=" + this._productItemsV3 + ", _productItems=" + this._productItems + ", productIds=" + this.productIds + ", responseLoadingInfo=" + this.responseLoadingInfo + ", webviewLoadingInfo=" + this.webviewLoadingInfo + ", productsLoadingInfo=" + this.productsLoadingInfo + ", shimmerLoadingInfo=" + this.shimmerLoadingInfo + ", productVariables=" + this.productVariables + ", swProductVariablesTemplate=" + this.swProductVariablesTemplate + ", paywalljsVersion=" + this.paywalljsVersion + ", isFreeTrialAvailable=" + this.isFreeTrialAvailable + ", presentationSourceType=" + this.presentationSourceType + ", featureGating=" + this.featureGating + ", computedPropertyRequests=" + this.computedPropertyRequests + ", localNotifications=" + this.localNotifications + ", onDeviceCache=" + this.onDeviceCache + ", experiment=" + this.experiment + ", closeReason=" + this.closeReason + ", state=" + this.state + ", presentationId=" + this.presentationId + ", urlConfig=" + this.urlConfig + ", cacheKey=" + this.cacheKey + ", buildId=" + this.buildId + ", surveys=" + this.surveys + ", isScrollEnabled=" + this.isScrollEnabled + ", rerouteBackButton=" + this.rerouteBackButton + ", introOfferEligibility=" + this.introOfferEligibility + ")";
    }

    public final void update(Paywall paywall) {
        Intrinsics.checkNotNullParameter(paywall, "paywall");
        setProductItems(paywall.getProductItems());
        this.productVariables = paywall.productVariables;
        this.swProductVariablesTemplate = paywall.swProductVariablesTemplate;
        this.isFreeTrialAvailable = paywall.isFreeTrialAvailable;
        this.productsLoadingInfo = paywall.productsLoadingInfo;
        this.presentationSourceType = paywall.presentationSourceType;
        this.experiment = paywall.experiment;
    }

    public /* synthetic */ Paywall(String str, String str2, String str3, String str4, String str5, String str6, PaywallPresentationStyle paywallPresentationStyle, long j3, String str7, PaywallPresentationInfo paywallPresentationInfo, String str8, String str9, List list, List list2, List list3, List list4, LoadingInfo loadingInfo, LoadingInfo loadingInfo2, LoadingInfo loadingInfo3, LoadingInfo loadingInfo4, List list5, List list6, String str10, boolean z2, String str11, FeatureGatingBehavior featureGatingBehavior, List list7, List list8, OnDeviceCaching onDeviceCaching, Experiment experiment, PaywallCloseReason paywallCloseReason, Map map, String str12, PaywallWebviewUrl.Config config, String str13, String str14, List list9, Boolean bool, ToggleMode toggleMode, IntroOfferEligibility introOfferEligibility, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, paywallPresentationStyle, j3, str7, paywallPresentationInfo, str8, str9, list, list2, list3, list4, loadingInfo, loadingInfo2, loadingInfo3, loadingInfo4, list5, list6, str10, z2, str11, featureGatingBehavior, list7, list8, onDeviceCaching, experiment, paywallCloseReason, map, str12, config, str13, str14, list9, bool, toggleMode, introOfferEligibility);
    }

    public final void set_productItems$superwall_release(List<ProductItem> list) {
        Intrinsics.checkNotNullParameter(list, bfIdKSjLOVjG.hhUOnOMBhmuB);
        this._productItems = list;
    }

    private /* synthetic */ Paywall(int i3, String str, String str2, String str3, String str4, String str5, String str6, PaywallPresentationStyle paywallPresentationStyle, long j3, String str7, String str8, String str9, List list, List list2, List list3, List list4, String str10, boolean z2, String str11, FeatureGatingBehavior featureGatingBehavior, List list5, List list6, OnDeviceCaching onDeviceCaching, PaywallWebviewUrl.Config config, String str12, String str13, List list7, Boolean bool, ToggleMode toggleMode, IntroOfferEligibility introOfferEligibility, SerializationConstructorMarker serializationConstructorMarker) {
        PaywallPresentationStyle paywallPresentationStyle2;
        if (25166847 != (i3 & 25166847)) {
            PluginExceptionsKt.b(i3, 25166847, Paywall$$serializer.INSTANCE.getDescriptor());
        }
        this.databaseId = str;
        this.identifier = str2;
        this.name = str3;
        this.url = str4;
        this.htmlSubstitutions = str5;
        this.presentationStyle = str6;
        this.expandedPresentationStyle = paywallPresentationStyle;
        this.presentationDelay = j3;
        this.presentationCondition = str7;
        if (paywallPresentationStyle == null) {
            paywallPresentationStyle2 = PaywallPresentationStyle.None.INSTANCE;
            Logger.debug$default(Logger.INSTANCE, LogLevel.warn, LogScope.paywallPresentation, "Unknown or unsupported presentation style: " + str6, (Map) null, (Throwable) null, 24, (Object) null);
        } else {
            paywallPresentationStyle2 = paywallPresentationStyle;
        }
        this.presentation = new PaywallPresentationInfo(paywallPresentationStyle2, j3);
        this.backgroundColorHex = str8;
        if ((i3 & 1024) == 0) {
            this.darkBackgroundColorHex = null;
        } else {
            this.darkBackgroundColorHex = str9;
        }
        this._products = CollectionsKt.emptyList();
        this._productItemsV3 = (i3 & 2048) == 0 ? CollectionsKt.emptyList() : list;
        this._productItems = (i3 & 4096) == 0 ? CollectionsKt.emptyList() : list2;
        List<ProductItem> list8 = this._productItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
        Iterator<T> it = list8.iterator();
        while (it.hasNext()) {
            arrayList.add(((ProductItem) it.next()).getCompositeId());
        }
        if (arrayList.isEmpty()) {
            List<CrossplatformProduct> list9 = this._productItemsV3;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
            Iterator<T> it2 = list9.iterator();
            while (it2.hasNext()) {
                arrayList.add(((CrossplatformProduct) it2.next()).getFullProductId());
            }
        }
        this.productIds = arrayList;
        int i4 = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Date date = null;
        Date date2 = null;
        Date date3 = null;
        this.responseLoadingInfo = new LoadingInfo(date, date2, date3, i4, defaultConstructorMarker);
        this.webviewLoadingInfo = new LoadingInfo(date, date2, date3, i4, defaultConstructorMarker);
        this.productsLoadingInfo = new LoadingInfo(date, date2, date3, i4, defaultConstructorMarker);
        this.shimmerLoadingInfo = new LoadingInfo(date, date2, date3, i4, defaultConstructorMarker);
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            this.productVariables = null;
        } else {
            this.productVariables = list3;
        }
        if ((i3 & 16384) == 0) {
            this.swProductVariablesTemplate = null;
        } else {
            this.swProductVariablesTemplate = list4;
        }
        if ((32768 & i3) == 0) {
            this.paywalljsVersion = null;
        } else {
            this.paywalljsVersion = str10;
        }
        this.isFreeTrialAvailable = (65536 & i3) == 0 ? false : z2;
        if ((131072 & i3) == 0) {
            this.presentationSourceType = null;
        } else {
            this.presentationSourceType = str11;
        }
        this.featureGating = (262144 & i3) == 0 ? FeatureGatingBehavior.NonGated.INSTANCE : featureGatingBehavior;
        this.computedPropertyRequests = (524288 & i3) == 0 ? CollectionsKt.emptyList() : list5;
        this.localNotifications = (1048576 & i3) == 0 ? CollectionsKt.emptyList() : list6;
        this.onDeviceCache = (2097152 & i3) == 0 ? OnDeviceCaching.Disabled.INSTANCE : onDeviceCaching;
        this.experiment = null;
        this.closeReason = PaywallCloseReason.None.INSTANCE;
        this.state = MapsKt.emptyMap();
        this.presentationId = null;
        if ((4194304 & i3) == 0) {
            this.urlConfig = null;
        } else {
            this.urlConfig = config;
        }
        this.cacheKey = str12;
        this.buildId = str13;
        this.surveys = (33554432 & i3) == 0 ? CollectionsKt.emptyList() : list7;
        this.isScrollEnabled = (67108864 & i3) == 0 ? Boolean.TRUE : bool;
        if ((134217728 & i3) == 0) {
            this.rerouteBackButton = null;
        } else {
            this.rerouteBackButton = toggleMode;
        }
        this.introOfferEligibility = (i3 & 268435456) == 0 ? IntroOfferEligibility.AUTOMATIC : introOfferEligibility;
        this.backgroundColor$delegate = LazyKt.b(new Function0() { // from class: g0.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(Paywall._init_$lambda$19(this.f134669a));
            }
        });
        this.darkBackgroundColor$delegate = LazyKt.b(new Function0() { // from class: g0.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Paywall._init_$lambda$20(this.f134670a);
            }
        });
    }

    private Paywall(String databaseId, String identifier, String name, String url, String htmlSubstitutions, String str, PaywallPresentationStyle paywallPresentationStyle, long j3, String presentationCondition, PaywallPresentationInfo presentation, String backgroundColorHex, String str2, List<ProductItem> _products, List<CrossplatformProduct> _productItemsV3, List<ProductItem> _productItems, List<String> productIds, LoadingInfo responseLoadingInfo, LoadingInfo webviewLoadingInfo, LoadingInfo productsLoadingInfo, LoadingInfo shimmerLoadingInfo, List<ProductVariable> list, List<ProductVariable> list2, String str3, boolean z2, String str4, FeatureGatingBehavior featureGating, List<ComputedPropertyRequest> computedPropertyRequests, List<LocalNotification> localNotifications, OnDeviceCaching onDeviceCache, Experiment experiment, PaywallCloseReason closeReason, Map<String, ? extends Object> state, String str5, PaywallWebviewUrl.Config config, String cacheKey, String buildId, List<Survey> surveys, Boolean bool, ToggleMode toggleMode, IntroOfferEligibility introOfferEligibility) {
        Intrinsics.checkNotNullParameter(databaseId, "databaseId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(htmlSubstitutions, "htmlSubstitutions");
        Intrinsics.checkNotNullParameter(presentationCondition, "presentationCondition");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(backgroundColorHex, "backgroundColorHex");
        Intrinsics.checkNotNullParameter(_products, "_products");
        Intrinsics.checkNotNullParameter(_productItemsV3, "_productItemsV3");
        Intrinsics.checkNotNullParameter(_productItems, "_productItems");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(responseLoadingInfo, "responseLoadingInfo");
        Intrinsics.checkNotNullParameter(webviewLoadingInfo, "webviewLoadingInfo");
        Intrinsics.checkNotNullParameter(productsLoadingInfo, "productsLoadingInfo");
        Intrinsics.checkNotNullParameter(shimmerLoadingInfo, "shimmerLoadingInfo");
        Intrinsics.checkNotNullParameter(featureGating, "featureGating");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(localNotifications, "localNotifications");
        Intrinsics.checkNotNullParameter(onDeviceCache, "onDeviceCache");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(introOfferEligibility, "introOfferEligibility");
        this.databaseId = databaseId;
        this.identifier = identifier;
        this.name = name;
        this.url = url;
        this.htmlSubstitutions = htmlSubstitutions;
        this.presentationStyle = str;
        this.expandedPresentationStyle = paywallPresentationStyle;
        this.presentationDelay = j3;
        this.presentationCondition = presentationCondition;
        this.presentation = presentation;
        this.backgroundColorHex = backgroundColorHex;
        this.darkBackgroundColorHex = str2;
        this._products = _products;
        this._productItemsV3 = _productItemsV3;
        this._productItems = _productItems;
        this.productIds = productIds;
        this.responseLoadingInfo = responseLoadingInfo;
        this.webviewLoadingInfo = webviewLoadingInfo;
        this.productsLoadingInfo = productsLoadingInfo;
        this.shimmerLoadingInfo = shimmerLoadingInfo;
        this.productVariables = list;
        this.swProductVariablesTemplate = list2;
        this.paywalljsVersion = str3;
        this.isFreeTrialAvailable = z2;
        this.presentationSourceType = str4;
        this.featureGating = featureGating;
        this.computedPropertyRequests = computedPropertyRequests;
        this.localNotifications = localNotifications;
        this.onDeviceCache = onDeviceCache;
        this.experiment = experiment;
        this.closeReason = closeReason;
        this.state = state;
        this.presentationId = str5;
        this.urlConfig = config;
        this.cacheKey = cacheKey;
        this.buildId = buildId;
        this.surveys = surveys;
        this.isScrollEnabled = bool;
        this.rerouteBackButton = toggleMode;
        this.introOfferEligibility = introOfferEligibility;
        this.backgroundColor$delegate = LazyKt.b(new Function0() { // from class: g0.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(Paywall.backgroundColor_delegate$lambda$13(this.f134671a));
            }
        });
        this.darkBackgroundColor$delegate = LazyKt.b(new Function0() { // from class: g0.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Paywall.darkBackgroundColor_delegate$lambda$14(this.f134672a);
            }
        });
    }

    public /* synthetic */ Paywall(String str, String str2, String str3, String str4, String str5, String str6, PaywallPresentationStyle paywallPresentationStyle, long j3, String str7, PaywallPresentationInfo paywallPresentationInfo, String str8, String str9, List list, List list2, List list3, List list4, LoadingInfo loadingInfo, LoadingInfo loadingInfo2, LoadingInfo loadingInfo3, LoadingInfo loadingInfo4, List list5, List list6, String str10, boolean z2, String str11, FeatureGatingBehavior featureGatingBehavior, List list7, List list8, OnDeviceCaching onDeviceCaching, Experiment experiment, PaywallCloseReason paywallCloseReason, Map map, String str12, PaywallWebviewUrl.Config config, String str13, String str14, List list9, Boolean bool, ToggleMode toggleMode, IntroOfferEligibility introOfferEligibility, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        String str15;
        long j4;
        PaywallPresentationInfo paywallPresentationInfo2;
        List list10;
        PaywallPresentationStyle paywallPresentationStyle2;
        if ((i3 & 512) != 0) {
            if (paywallPresentationStyle == null) {
                paywallPresentationStyle2 = PaywallPresentationStyle.None.INSTANCE;
                Logger logger = Logger.INSTANCE;
                LogLevel logLevel = LogLevel.warn;
                LogScope logScope = LogScope.paywallPresentation;
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown or unsupported presentation style: ");
                str15 = str6;
                sb.append(str15);
                Logger.debug$default(logger, logLevel, logScope, sb.toString(), (Map) null, (Throwable) null, 24, (Object) null);
            } else {
                str15 = str6;
                paywallPresentationStyle2 = paywallPresentationStyle;
            }
            j4 = j3;
            paywallPresentationInfo2 = new PaywallPresentationInfo(paywallPresentationStyle2, j4);
        } else {
            str15 = str6;
            j4 = j3;
            paywallPresentationInfo2 = paywallPresentationInfo;
        }
        String str16 = (i3 & 2048) != 0 ? null : str9;
        List listEmptyList = (i3 & 4096) != 0 ? CollectionsKt.emptyList() : list;
        List listEmptyList2 = (i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? CollectionsKt.emptyList() : list2;
        List listEmptyList3 = (i3 & 16384) != 0 ? CollectionsKt.emptyList() : list3;
        if ((32768 & i3) != 0) {
            List list11 = listEmptyList3;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list11, 10));
            Iterator it = list11.iterator();
            while (it.hasNext()) {
                arrayList.add(((ProductItem) it.next()).getCompositeId());
            }
            if (arrayList.isEmpty()) {
                List list12 = listEmptyList2;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
                Iterator it2 = list12.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((CrossplatformProduct) it2.next()).getFullProductId());
                }
            }
            list10 = arrayList;
        } else {
            list10 = list4;
        }
        this(str, str2, str3, str4, str5, str15, paywallPresentationStyle, j4, str7, paywallPresentationInfo2, str8, str16, listEmptyList, listEmptyList2, listEmptyList3, list10, (65536 & i3) != 0 ? new LoadingInfo((Date) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null) : loadingInfo, (131072 & i3) != 0 ? new LoadingInfo((Date) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null) : loadingInfo2, (262144 & i3) != 0 ? new LoadingInfo((Date) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null) : loadingInfo3, (524288 & i3) != 0 ? new LoadingInfo((Date) null, (Date) null, (Date) null, 7, (DefaultConstructorMarker) null) : loadingInfo4, (1048576 & i3) != 0 ? null : list5, (2097152 & i3) != 0 ? null : list6, (4194304 & i3) != 0 ? null : str10, (8388608 & i3) != 0 ? false : z2, (16777216 & i3) != 0 ? null : str11, (33554432 & i3) != 0 ? FeatureGatingBehavior.NonGated.INSTANCE : featureGatingBehavior, (67108864 & i3) != 0 ? CollectionsKt.emptyList() : list7, (134217728 & i3) != 0 ? CollectionsKt.emptyList() : list8, (268435456 & i3) != 0 ? OnDeviceCaching.Disabled.INSTANCE : onDeviceCaching, (536870912 & i3) != 0 ? null : experiment, (1073741824 & i3) != 0 ? PaywallCloseReason.None.INSTANCE : paywallCloseReason, (i3 & Integer.MIN_VALUE) != 0 ? MapsKt.emptyMap() : map, (i4 & 1) != 0 ? null : str12, (i4 & 2) != 0 ? null : config, str13, str14, (i4 & 16) != 0 ? CollectionsKt.emptyList() : list9, (i4 & 32) != 0 ? Boolean.TRUE : bool, (i4 & 64) != 0 ? null : toggleMode, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? IntroOfferEligibility.AUTOMATIC : introOfferEligibility, null);
    }
}
