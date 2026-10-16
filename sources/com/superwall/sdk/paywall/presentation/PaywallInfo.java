package com.superwall.sdk.paywall.presentation;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.config.models.Survey;
import com.superwall.sdk.config.models.Survey$$serializer;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.String_Helpers_ktKt;
import com.superwall.sdk.models.config.ComputedPropertyRequest;
import com.superwall.sdk.models.config.ComputedPropertyRequest$$serializer;
import com.superwall.sdk.models.config.FeatureGatingBehavior;
import com.superwall.sdk.models.config.FeatureGatingBehaviorSerializer;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.customer.CustomerInfo$$serializer;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.paywall.LocalNotification;
import com.superwall.sdk.models.paywall.LocalNotification$$serializer;
import com.superwall.sdk.models.paywall.PaywallPresentationInfo;
import com.superwall.sdk.models.paywall.PaywallPresentationInfo$$serializer;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.models.paywall.PaywallURL;
import com.superwall.sdk.models.paywall.PaywallURL$$serializer;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.product.ProductItemSerializer;
import com.superwall.sdk.models.serialization.AnyMapSerializer;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.Experiment$$serializer;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.utilities.DateUtilsKt;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

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
public final class PaywallInfo {
    private final String buildId;
    private final String cacheKey;
    private final PaywallCloseReason closeReason;
    private final List<ComputedPropertyRequest> computedPropertyRequests;
    private final CustomerInfo customerInfo;
    private final String databaseId;
    private final Experiment experiment;
    private final FeatureGatingBehavior featureGatingBehavior;
    private final String identifier;
    private final boolean isFreeTrialAvailable;
    private final boolean isScrollEnabled;
    private final List<LocalNotification> localNotifications;
    private final String name;
    private final String paywalljsVersion;
    private final PaywallPresentationInfo presentation;
    private final String presentationId;
    private final String presentationSourceType;
    private final String presentedBy;
    private final String presentedByEventAt;
    private final String presentedByEventWithId;
    private final String presentedByEventWithName;
    private final List<String> productIds;
    private final List<ProductItem> products;
    private final String productsLoadCompleteTime;
    private final Double productsLoadDuration;
    private final String productsLoadFailTime;
    private final String productsLoadStartTime;
    private final String responseLoadCompleteTime;
    private final Double responseLoadDuration;
    private final String responseLoadFailTime;
    private final String responseLoadStartTime;
    private final String shimmerLoadCompleteTime;
    private final String shimmerLoadStartTime;
    private final Map<String, Object> state;
    private final List<Survey> surveys;
    private final String url;
    private final String webViewLoadCompleteTime;
    private final Double webViewLoadDuration;
    private final String webViewLoadFailTime;
    private final String webViewLoadStartTime;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(ProductItemSerializer.INSTANCE), new ArrayListSerializer(StringSerializer.f142891a), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, PaywallCloseReason.Companion.serializer(), new ArrayListSerializer(LocalNotification$$serializer.INSTANCE), new ArrayListSerializer(ComputedPropertyRequest$$serializer.INSTANCE), new ArrayListSerializer(Survey$$serializer.INSTANCE), null, null, null, null, null, null, null};
    private static final Json json = JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.paywall.presentation.c
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PaywallInfo.json$lambda$26((JsonBuilder) obj);
        }
    }, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallInfo empty() {
            return new PaywallInfo("", "", "", PaywallURL.m1297constructorimpl(""), (Experiment) null, CollectionsKt.emptyList(), CollectionsKt.emptyList(), (String) null, (String) null, (String) null, "", (String) null, (String) null, (String) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (Double) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Double) null, (String) null, false, (FeatureGatingBehavior) FeatureGatingBehavior.NonGated.INSTANCE, (PaywallCloseReason) PaywallCloseReason.None.INSTANCE, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), new PaywallPresentationInfo(PaywallPresentationStyle.None.INSTANCE, 0L), "", "", true, (Map) null, (CustomerInfo) null, (String) null, 0, 224, (DefaultConstructorMarker) null);
        }

        public final KSerializer<PaywallInfo> serializer() {
            return PaywallInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallInfo(int i3, int i4, String str, String str2, String str3, String str4, Experiment experiment, List list, List list2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Double d3, String str13, String str14, String str15, Double d4, String str16, String str17, String str18, String str19, String str20, Double d5, String str21, boolean z2, FeatureGatingBehavior featureGatingBehavior, PaywallCloseReason paywallCloseReason, List list3, List list4, List list5, PaywallPresentationInfo paywallPresentationInfo, String str22, String str23, boolean z3, Map map, CustomerInfo customerInfo, String str24, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, str, str2, str3, str4, experiment, list, list2, str5, str6, str7, str8, str9, str10, str11, str12, d3, str13, str14, str15, d4, str16, str17, str18, str19, str20, d5, str21, z2, featureGatingBehavior, paywallCloseReason, list3, list4, list5, paywallPresentationInfo, str22, str23, z3, map, customerInfo, str24, serializationConstructorMarker);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map eventParams$default(PaywallInfo paywallInfo, StoreProductType storeProductType, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            storeProductType = null;
        }
        if ((i3 & 2) != 0) {
            map = null;
        }
        return paywallInfo.eventParams(storeProductType, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eventParams$lambda$18(Object obj) {
        return obj == null;
    }

    @Serializable(with = AnyMapSerializer.class)
    public static /* synthetic */ void getState$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$26(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        return Unit.f139807a;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(PaywallInfo paywallInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, paywallInfo.databaseId);
        compositeEncoder.y(serialDescriptor, 1, paywallInfo.identifier);
        compositeEncoder.y(serialDescriptor, 2, paywallInfo.name);
        compositeEncoder.C(serialDescriptor, 3, PaywallURL$$serializer.INSTANCE, PaywallURL.m1296boximpl(paywallInfo.url));
        compositeEncoder.i(serialDescriptor, 4, Experiment$$serializer.INSTANCE, paywallInfo.experiment);
        compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], paywallInfo.products);
        compositeEncoder.C(serialDescriptor, 6, kSerializerArr[6], paywallInfo.productIds);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        compositeEncoder.i(serialDescriptor, 7, stringSerializer, paywallInfo.presentedByEventWithName);
        compositeEncoder.i(serialDescriptor, 8, stringSerializer, paywallInfo.presentedByEventWithId);
        compositeEncoder.i(serialDescriptor, 9, stringSerializer, paywallInfo.presentedByEventAt);
        compositeEncoder.y(serialDescriptor, 10, paywallInfo.presentedBy);
        compositeEncoder.i(serialDescriptor, 11, stringSerializer, paywallInfo.presentationSourceType);
        compositeEncoder.i(serialDescriptor, 12, stringSerializer, paywallInfo.responseLoadStartTime);
        compositeEncoder.i(serialDescriptor, 13, stringSerializer, paywallInfo.responseLoadCompleteTime);
        compositeEncoder.i(serialDescriptor, 14, stringSerializer, paywallInfo.responseLoadFailTime);
        DoubleSerializer doubleSerializer = DoubleSerializer.f142796a;
        compositeEncoder.i(serialDescriptor, 15, doubleSerializer, paywallInfo.responseLoadDuration);
        compositeEncoder.i(serialDescriptor, 16, stringSerializer, paywallInfo.webViewLoadStartTime);
        compositeEncoder.i(serialDescriptor, 17, stringSerializer, paywallInfo.webViewLoadCompleteTime);
        compositeEncoder.i(serialDescriptor, 18, stringSerializer, paywallInfo.webViewLoadFailTime);
        compositeEncoder.i(serialDescriptor, 19, doubleSerializer, paywallInfo.webViewLoadDuration);
        compositeEncoder.i(serialDescriptor, 20, stringSerializer, paywallInfo.productsLoadStartTime);
        compositeEncoder.i(serialDescriptor, 21, stringSerializer, paywallInfo.productsLoadCompleteTime);
        compositeEncoder.i(serialDescriptor, 22, stringSerializer, paywallInfo.productsLoadFailTime);
        compositeEncoder.i(serialDescriptor, 23, stringSerializer, paywallInfo.shimmerLoadStartTime);
        compositeEncoder.i(serialDescriptor, 24, stringSerializer, paywallInfo.shimmerLoadCompleteTime);
        compositeEncoder.i(serialDescriptor, 25, doubleSerializer, paywallInfo.productsLoadDuration);
        compositeEncoder.i(serialDescriptor, 26, stringSerializer, paywallInfo.paywalljsVersion);
        compositeEncoder.x(serialDescriptor, 27, paywallInfo.isFreeTrialAvailable);
        compositeEncoder.C(serialDescriptor, 28, FeatureGatingBehaviorSerializer.INSTANCE, paywallInfo.featureGatingBehavior);
        compositeEncoder.C(serialDescriptor, 29, kSerializerArr[29], paywallInfo.closeReason);
        compositeEncoder.C(serialDescriptor, 30, kSerializerArr[30], paywallInfo.localNotifications);
        compositeEncoder.C(serialDescriptor, 31, kSerializerArr[31], paywallInfo.computedPropertyRequests);
        compositeEncoder.C(serialDescriptor, 32, kSerializerArr[32], paywallInfo.surveys);
        compositeEncoder.C(serialDescriptor, 33, PaywallPresentationInfo$$serializer.INSTANCE, paywallInfo.presentation);
        compositeEncoder.y(serialDescriptor, 34, paywallInfo.buildId);
        compositeEncoder.y(serialDescriptor, 35, paywallInfo.cacheKey);
        compositeEncoder.x(serialDescriptor, 36, paywallInfo.isScrollEnabled);
        if (compositeEncoder.z(serialDescriptor, 37) || !Intrinsics.areEqual(paywallInfo.state, MapsKt.emptyMap())) {
            compositeEncoder.C(serialDescriptor, 37, AnyMapSerializer.INSTANCE, paywallInfo.state);
        }
        if (compositeEncoder.z(serialDescriptor, 38) || !Intrinsics.areEqual(paywallInfo.customerInfo, CustomerInfo.Companion.empty())) {
            compositeEncoder.C(serialDescriptor, 38, CustomerInfo$$serializer.INSTANCE, paywallInfo.customerInfo);
        }
        if (!compositeEncoder.z(serialDescriptor, 39) && paywallInfo.presentationId == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 39, stringSerializer, paywallInfo.presentationId);
    }

    public final Map<String, Object> audienceFilterParams() {
        String strB = json.b(FeatureGatingBehavior.Companion.serializer(), this.featureGatingBehavior);
        Pair pairA = TuplesKt.a("paywall_id", this.databaseId);
        Pair pairA2 = TuplesKt.a("paywall_name", this.name);
        String str = this.presentedByEventWithName;
        if (str == null) {
            str = "";
        }
        Map mapMutableMapOf = MapsKt.mutableMapOf(pairA, pairA2, TuplesKt.a("presented_by_event_name", str), TuplesKt.a("paywall_product_ids", CollectionsKt.joinToString$default(this.productIds, ",", null, null, 0, null, null, 62, null)), TuplesKt.a("is_free_trial_available", Boolean.valueOf(this.isFreeTrialAvailable)), TuplesKt.a("feature_gating", strB), TuplesKt.a("presented_by", this.presentedBy));
        mapMutableMapOf.put("primary_product_id", "");
        mapMutableMapOf.put("secondary_product_id", "");
        mapMutableMapOf.put("tertiary_product_id", "");
        int i3 = 0;
        for (Object obj : this.products) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProductItem productItem = (ProductItem) obj;
            if (i3 == 0) {
                mapMutableMapOf.put("primary_product_id", productItem.getFullProductId());
            } else if (i3 == 1) {
                mapMutableMapOf.put("secondary_product_id", productItem.getFullProductId());
            } else if (i3 == 2) {
                mapMutableMapOf.put("tertiary_product_id", productItem.getFullProductId());
            }
            mapMutableMapOf.put(productItem.getName() + "_product_id", productItem.getFullProductId());
            i3 = i4;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapMutableMapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return TypeIntrinsics.d(linkedHashMap);
    }

    public final String component1() {
        return this.databaseId;
    }

    public final String component10() {
        return this.presentedByEventAt;
    }

    public final String component11() {
        return this.presentedBy;
    }

    public final String component12() {
        return this.presentationSourceType;
    }

    public final String component13() {
        return this.responseLoadStartTime;
    }

    public final String component14() {
        return this.responseLoadCompleteTime;
    }

    public final String component15() {
        return this.responseLoadFailTime;
    }

    public final Double component16() {
        return this.responseLoadDuration;
    }

    public final String component17() {
        return this.webViewLoadStartTime;
    }

    public final String component18() {
        return this.webViewLoadCompleteTime;
    }

    public final String component19() {
        return this.webViewLoadFailTime;
    }

    public final String component2() {
        return this.identifier;
    }

    public final Double component20() {
        return this.webViewLoadDuration;
    }

    public final String component21() {
        return this.productsLoadStartTime;
    }

    public final String component22() {
        return this.productsLoadCompleteTime;
    }

    public final String component23() {
        return this.productsLoadFailTime;
    }

    public final String component24() {
        return this.shimmerLoadStartTime;
    }

    public final String component25() {
        return this.shimmerLoadCompleteTime;
    }

    public final Double component26() {
        return this.productsLoadDuration;
    }

    public final String component27() {
        return this.paywalljsVersion;
    }

    public final boolean component28() {
        return this.isFreeTrialAvailable;
    }

    public final FeatureGatingBehavior component29() {
        return this.featureGatingBehavior;
    }

    public final String component3() {
        return this.name;
    }

    public final PaywallCloseReason component30() {
        return this.closeReason;
    }

    public final List<LocalNotification> component31() {
        return this.localNotifications;
    }

    public final List<ComputedPropertyRequest> component32() {
        return this.computedPropertyRequests;
    }

    public final List<Survey> component33() {
        return this.surveys;
    }

    public final PaywallPresentationInfo component34() {
        return this.presentation;
    }

    public final String component35() {
        return this.buildId;
    }

    public final String component36() {
        return this.cacheKey;
    }

    public final boolean component37() {
        return this.isScrollEnabled;
    }

    public final Map<String, Object> component38() {
        return this.state;
    }

    public final CustomerInfo component39() {
        return this.customerInfo;
    }

    /* JADX INFO: renamed from: component4-24UBhI0, reason: not valid java name */
    public final String m1322component424UBhI0() {
        return this.url;
    }

    public final String component40() {
        return this.presentationId;
    }

    public final Experiment component5() {
        return this.experiment;
    }

    public final List<ProductItem> component6() {
        return this.products;
    }

    public final List<String> component7() {
        return this.productIds;
    }

    public final String component8() {
        return this.presentedByEventWithName;
    }

    public final String component9() {
        return this.presentedByEventWithId;
    }

    /* JADX INFO: renamed from: copy-BiBlP3E, reason: not valid java name */
    public final PaywallInfo m1323copyBiBlP3E(String databaseId, String identifier, String name, String url, Experiment experiment, List<ProductItem> products, List<String> productIds, String str, String str2, String str3, String presentedBy, String str4, String str5, String str6, String str7, Double d3, String str8, String str9, String str10, Double d4, String str11, String str12, String str13, String str14, String str15, Double d5, String str16, boolean z2, FeatureGatingBehavior featureGatingBehavior, PaywallCloseReason closeReason, List<LocalNotification> localNotifications, List<ComputedPropertyRequest> computedPropertyRequests, List<Survey> surveys, PaywallPresentationInfo presentation, String buildId, String cacheKey, boolean z3, Map<String, ? extends Object> state, CustomerInfo customerInfo, String str17) {
        Intrinsics.checkNotNullParameter(databaseId, "databaseId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(presentedBy, "presentedBy");
        Intrinsics.checkNotNullParameter(featureGatingBehavior, "featureGatingBehavior");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(localNotifications, "localNotifications");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        return new PaywallInfo(databaseId, identifier, name, url, experiment, products, productIds, str, str2, str3, presentedBy, str4, str5, str6, str7, d3, str8, str9, str10, d4, str11, str12, str13, str14, str15, d5, str16, z2, featureGatingBehavior, closeReason, localNotifications, computedPropertyRequests, surveys, presentation, buildId, cacheKey, z3, state, customerInfo, str17, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallInfo)) {
            return false;
        }
        PaywallInfo paywallInfo = (PaywallInfo) obj;
        return Intrinsics.areEqual(this.databaseId, paywallInfo.databaseId) && Intrinsics.areEqual(this.identifier, paywallInfo.identifier) && Intrinsics.areEqual(this.name, paywallInfo.name) && PaywallURL.m1299equalsimpl0(this.url, paywallInfo.url) && Intrinsics.areEqual(this.experiment, paywallInfo.experiment) && Intrinsics.areEqual(this.products, paywallInfo.products) && Intrinsics.areEqual(this.productIds, paywallInfo.productIds) && Intrinsics.areEqual(this.presentedByEventWithName, paywallInfo.presentedByEventWithName) && Intrinsics.areEqual(this.presentedByEventWithId, paywallInfo.presentedByEventWithId) && Intrinsics.areEqual(this.presentedByEventAt, paywallInfo.presentedByEventAt) && Intrinsics.areEqual(this.presentedBy, paywallInfo.presentedBy) && Intrinsics.areEqual(this.presentationSourceType, paywallInfo.presentationSourceType) && Intrinsics.areEqual(this.responseLoadStartTime, paywallInfo.responseLoadStartTime) && Intrinsics.areEqual(this.responseLoadCompleteTime, paywallInfo.responseLoadCompleteTime) && Intrinsics.areEqual(this.responseLoadFailTime, paywallInfo.responseLoadFailTime) && Intrinsics.areEqual((Object) this.responseLoadDuration, (Object) paywallInfo.responseLoadDuration) && Intrinsics.areEqual(this.webViewLoadStartTime, paywallInfo.webViewLoadStartTime) && Intrinsics.areEqual(this.webViewLoadCompleteTime, paywallInfo.webViewLoadCompleteTime) && Intrinsics.areEqual(this.webViewLoadFailTime, paywallInfo.webViewLoadFailTime) && Intrinsics.areEqual((Object) this.webViewLoadDuration, (Object) paywallInfo.webViewLoadDuration) && Intrinsics.areEqual(this.productsLoadStartTime, paywallInfo.productsLoadStartTime) && Intrinsics.areEqual(this.productsLoadCompleteTime, paywallInfo.productsLoadCompleteTime) && Intrinsics.areEqual(this.productsLoadFailTime, paywallInfo.productsLoadFailTime) && Intrinsics.areEqual(this.shimmerLoadStartTime, paywallInfo.shimmerLoadStartTime) && Intrinsics.areEqual(this.shimmerLoadCompleteTime, paywallInfo.shimmerLoadCompleteTime) && Intrinsics.areEqual((Object) this.productsLoadDuration, (Object) paywallInfo.productsLoadDuration) && Intrinsics.areEqual(this.paywalljsVersion, paywallInfo.paywalljsVersion) && this.isFreeTrialAvailable == paywallInfo.isFreeTrialAvailable && Intrinsics.areEqual(this.featureGatingBehavior, paywallInfo.featureGatingBehavior) && Intrinsics.areEqual(this.closeReason, paywallInfo.closeReason) && Intrinsics.areEqual(this.localNotifications, paywallInfo.localNotifications) && Intrinsics.areEqual(this.computedPropertyRequests, paywallInfo.computedPropertyRequests) && Intrinsics.areEqual(this.surveys, paywallInfo.surveys) && Intrinsics.areEqual(this.presentation, paywallInfo.presentation) && Intrinsics.areEqual(this.buildId, paywallInfo.buildId) && Intrinsics.areEqual(this.cacheKey, paywallInfo.cacheKey) && this.isScrollEnabled == paywallInfo.isScrollEnabled && Intrinsics.areEqual(this.state, paywallInfo.state) && Intrinsics.areEqual(this.customerInfo, paywallInfo.customerInfo) && Intrinsics.areEqual(this.presentationId, paywallInfo.presentationId);
    }

    public final Map<String, Object> eventParams(StoreProductType storeProductType, Map<String, ? extends Object> map) {
        Object obj;
        Experiment.Variant variant;
        Map<String, Object> mapAudienceFilterParams = audienceFilterParams();
        Pair[] pairArr = new Pair[26];
        Pair pairA = TuplesKt.a("paywalljs_version", this.paywalljsVersion);
        if (pairA == null) {
            pairA = "";
        }
        pairArr[0] = pairA;
        pairArr[1] = TuplesKt.a("paywall_identifier", this.identifier);
        pairArr[2] = TuplesKt.a("paywall_url", PaywallURL.m1301toStringimpl(this.url));
        pairArr[3] = TuplesKt.a("presented_by_event_id", this.presentedByEventWithId);
        pairArr[4] = TuplesKt.a("presented_by_event_timestamp", this.presentedByEventAt);
        pairArr[5] = TuplesKt.a("presentation_source_type", this.presentationSourceType);
        pairArr[6] = TuplesKt.a("paywall_response_load_start_time", this.responseLoadStartTime);
        pairArr[7] = TuplesKt.a("paywall_response_load_complete_time", this.responseLoadCompleteTime);
        pairArr[8] = TuplesKt.a("paywall_response_load_duration", this.responseLoadDuration);
        pairArr[9] = TuplesKt.a("paywall_webview_load_start_time", this.webViewLoadStartTime);
        pairArr[10] = TuplesKt.a("paywall_webview_load_complete_time", this.webViewLoadCompleteTime);
        pairArr[11] = TuplesKt.a("paywall_webview_load_fail_time", this.webViewLoadFailTime);
        pairArr[12] = TuplesKt.a("paywall_webview_load_duration", this.webViewLoadDuration);
        pairArr[13] = TuplesKt.a("paywall_products_load_start_time", this.productsLoadStartTime);
        pairArr[14] = TuplesKt.a("paywall_products_load_complete_time", this.productsLoadCompleteTime);
        pairArr[15] = TuplesKt.a("paywall_products_load_fail_time", this.productsLoadFailTime);
        pairArr[16] = TuplesKt.a("paywall_products_load_duration", this.productsLoadDuration);
        pairArr[17] = TuplesKt.a("trigger_session_id", "");
        Experiment experiment = this.experiment;
        pairArr[18] = TuplesKt.a("experiment_id", experiment != null ? experiment.getId() : null);
        Experiment experiment2 = this.experiment;
        pairArr[19] = TuplesKt.a("variant_id", (experiment2 == null || (variant = experiment2.getVariant()) == null) ? null : variant.getId());
        pairArr[20] = TuplesKt.a("is_scroll_enabled", Boolean.valueOf(this.isScrollEnabled));
        pairArr[21] = TuplesKt.a(ServerProtocol.DIALOG_PARAM_STATE, this.state);
        pairArr[22] = TuplesKt.a("presentation_id", this.presentationId);
        pairArr[23] = TuplesKt.a("close_reason", PaywallCloseReasonKt.getDescription(this.closeReason));
        pairArr[24] = TuplesKt.a("cache_key", this.cacheKey);
        pairArr[25] = TuplesKt.a("build_id", this.buildId);
        Map mapMutableMapOf = MapsKt.mutableMapOf(pairArr);
        Map<String, Object> params = this.customerInfo.toParams();
        if (!params.isEmpty()) {
            mapMutableMapOf.put("customer_info", params);
        }
        CollectionsKt.removeAll(mapMutableMapOf.values(), new Function1() { // from class: com.superwall.sdk.paywall.presentation.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(PaywallInfo.eventParams$lambda$18(obj2));
            }
        });
        Intrinsics.checkNotNull(mapMutableMapOf, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
        mapAudienceFilterParams.putAll(TypeIntrinsics.d(mapMutableMapOf));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : mapAudienceFilterParams.keySet()) {
            if (StringsKt.a0(str, "_load_", false, 2, null) && (obj = mapAudienceFilterParams.get(str)) != null) {
                linkedHashMap.put(str, obj);
            }
        }
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallEvents, "Paywall loading timestamps", linkedHashMap, (Throwable) null, 16, (Object) null);
        if (storeProductType != null) {
            mapAudienceFilterParams.put(DiagnosticsTracker.PRODUCT_ID_KEY, storeProductType.getFullIdentifier());
            for (String str2 : storeProductType.getAttributes().keySet()) {
                String str3 = storeProductType.getAttributes().get(str2);
                if (str3 != null) {
                    mapAudienceFilterParams.put("product_" + String_Helpers_ktKt.camelCaseToSnakeCase(str2), str3);
                }
            }
        }
        if (map != null) {
            for (String str4 : map.keySet()) {
                Object obj2 = map.get(str4);
                if (obj2 != null) {
                    mapAudienceFilterParams.put(str4, obj2);
                }
            }
        }
        return mapAudienceFilterParams;
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

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final String getDatabaseId() {
        return this.databaseId;
    }

    public final Experiment getExperiment() {
        return this.experiment;
    }

    public final FeatureGatingBehavior getFeatureGatingBehavior() {
        return this.featureGatingBehavior;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final List<LocalNotification> getLocalNotifications() {
        return this.localNotifications;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPaywalljsVersion() {
        return this.paywalljsVersion;
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

    public final String getPresentedBy() {
        return this.presentedBy;
    }

    public final String getPresentedByEventAt() {
        return this.presentedByEventAt;
    }

    public final String getPresentedByEventWithId() {
        return this.presentedByEventWithId;
    }

    public final String getPresentedByEventWithName() {
        return this.presentedByEventWithName;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final List<ProductItem> getProducts() {
        return this.products;
    }

    public final String getProductsLoadCompleteTime() {
        return this.productsLoadCompleteTime;
    }

    public final Double getProductsLoadDuration() {
        return this.productsLoadDuration;
    }

    public final String getProductsLoadFailTime() {
        return this.productsLoadFailTime;
    }

    public final String getProductsLoadStartTime() {
        return this.productsLoadStartTime;
    }

    public final String getResponseLoadCompleteTime() {
        return this.responseLoadCompleteTime;
    }

    public final Double getResponseLoadDuration() {
        return this.responseLoadDuration;
    }

    public final String getResponseLoadFailTime() {
        return this.responseLoadFailTime;
    }

    public final String getResponseLoadStartTime() {
        return this.responseLoadStartTime;
    }

    public final String getShimmerLoadCompleteTime() {
        return this.shimmerLoadCompleteTime;
    }

    public final String getShimmerLoadStartTime() {
        return this.shimmerLoadStartTime;
    }

    public final Map<String, Object> getState() {
        return this.state;
    }

    public final List<Survey> getSurveys() {
        return this.surveys;
    }

    /* JADX INFO: renamed from: getUrl-24UBhI0, reason: not valid java name */
    public final String m1324getUrl24UBhI0() {
        return this.url;
    }

    public final String getWebViewLoadCompleteTime() {
        return this.webViewLoadCompleteTime;
    }

    public final Double getWebViewLoadDuration() {
        return this.webViewLoadDuration;
    }

    public final String getWebViewLoadFailTime() {
        return this.webViewLoadFailTime;
    }

    public final String getWebViewLoadStartTime() {
        return this.webViewLoadStartTime;
    }

    public int hashCode() {
        int iHashCode = ((((((this.databaseId.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.name.hashCode()) * 31) + PaywallURL.m1300hashCodeimpl(this.url)) * 31;
        Experiment experiment = this.experiment;
        int iHashCode2 = (((((iHashCode + (experiment == null ? 0 : experiment.hashCode())) * 31) + this.products.hashCode()) * 31) + this.productIds.hashCode()) * 31;
        String str = this.presentedByEventWithName;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.presentedByEventWithId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.presentedByEventAt;
        int iHashCode5 = (((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.presentedBy.hashCode()) * 31;
        String str4 = this.presentationSourceType;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.responseLoadStartTime;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.responseLoadCompleteTime;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.responseLoadFailTime;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Double d3 = this.responseLoadDuration;
        int iHashCode10 = (iHashCode9 + (d3 == null ? 0 : d3.hashCode())) * 31;
        String str8 = this.webViewLoadStartTime;
        int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.webViewLoadCompleteTime;
        int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.webViewLoadFailTime;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Double d4 = this.webViewLoadDuration;
        int iHashCode14 = (iHashCode13 + (d4 == null ? 0 : d4.hashCode())) * 31;
        String str11 = this.productsLoadStartTime;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.productsLoadCompleteTime;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.productsLoadFailTime;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.shimmerLoadStartTime;
        int iHashCode18 = (iHashCode17 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.shimmerLoadCompleteTime;
        int iHashCode19 = (iHashCode18 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Double d5 = this.productsLoadDuration;
        int iHashCode20 = (iHashCode19 + (d5 == null ? 0 : d5.hashCode())) * 31;
        String str16 = this.paywalljsVersion;
        int iHashCode21 = (((((((((((((((((((((((((iHashCode20 + (str16 == null ? 0 : str16.hashCode())) * 31) + Boolean.hashCode(this.isFreeTrialAvailable)) * 31) + this.featureGatingBehavior.hashCode()) * 31) + this.closeReason.hashCode()) * 31) + this.localNotifications.hashCode()) * 31) + this.computedPropertyRequests.hashCode()) * 31) + this.surveys.hashCode()) * 31) + this.presentation.hashCode()) * 31) + this.buildId.hashCode()) * 31) + this.cacheKey.hashCode()) * 31) + Boolean.hashCode(this.isScrollEnabled)) * 31) + this.state.hashCode()) * 31) + this.customerInfo.hashCode()) * 31;
        String str17 = this.presentationId;
        return iHashCode21 + (str17 != null ? str17.hashCode() : 0);
    }

    public final boolean isFreeTrialAvailable() {
        return this.isFreeTrialAvailable;
    }

    public final boolean isScrollEnabled() {
        return this.isScrollEnabled;
    }

    public String toString() {
        return "PaywallInfo(databaseId=" + this.databaseId + ", identifier=" + this.identifier + ", name=" + this.name + ", url=" + PaywallURL.m1301toStringimpl(this.url) + ", experiment=" + this.experiment + ", products=" + this.products + ", productIds=" + this.productIds + ", presentedByEventWithName=" + this.presentedByEventWithName + ", presentedByEventWithId=" + this.presentedByEventWithId + ", presentedByEventAt=" + this.presentedByEventAt + ", presentedBy=" + this.presentedBy + ", presentationSourceType=" + this.presentationSourceType + ", responseLoadStartTime=" + this.responseLoadStartTime + ", responseLoadCompleteTime=" + this.responseLoadCompleteTime + ", responseLoadFailTime=" + this.responseLoadFailTime + ", responseLoadDuration=" + this.responseLoadDuration + ", webViewLoadStartTime=" + this.webViewLoadStartTime + ", webViewLoadCompleteTime=" + this.webViewLoadCompleteTime + ", webViewLoadFailTime=" + this.webViewLoadFailTime + ", webViewLoadDuration=" + this.webViewLoadDuration + ", productsLoadStartTime=" + this.productsLoadStartTime + ", productsLoadCompleteTime=" + this.productsLoadCompleteTime + ", productsLoadFailTime=" + this.productsLoadFailTime + ", shimmerLoadStartTime=" + this.shimmerLoadStartTime + ", shimmerLoadCompleteTime=" + this.shimmerLoadCompleteTime + ", productsLoadDuration=" + this.productsLoadDuration + ", paywalljsVersion=" + this.paywalljsVersion + ", isFreeTrialAvailable=" + this.isFreeTrialAvailable + ", featureGatingBehavior=" + this.featureGatingBehavior + ", closeReason=" + this.closeReason + ", localNotifications=" + this.localNotifications + ", computedPropertyRequests=" + this.computedPropertyRequests + ", surveys=" + this.surveys + ", presentation=" + this.presentation + ", buildId=" + this.buildId + ", cacheKey=" + this.cacheKey + ", isScrollEnabled=" + this.isScrollEnabled + ", state=" + this.state + ", customerInfo=" + this.customerInfo + ", presentationId=" + this.presentationId + ")";
    }

    public /* synthetic */ PaywallInfo(String str, String str2, String str3, String str4, Experiment experiment, List list, List list2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Double d3, String str13, String str14, String str15, Double d4, String str16, String str17, String str18, String str19, String str20, Double d5, String str21, boolean z2, FeatureGatingBehavior featureGatingBehavior, PaywallCloseReason paywallCloseReason, List list3, List list4, List list5, PaywallPresentationInfo paywallPresentationInfo, String str22, String str23, boolean z3, Map map, CustomerInfo customerInfo, String str24, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, experiment, list, list2, str5, str6, str7, str8, str9, str10, str11, str12, d3, str13, str14, str15, d4, str16, str17, str18, str19, str20, d5, str21, z2, featureGatingBehavior, paywallCloseReason, list3, list4, list5, paywallPresentationInfo, str22, str23, z3, map, customerInfo, str24);
    }

    public /* synthetic */ PaywallInfo(String str, String str2, String str3, String str4, List list, List list2, EventData eventData, Date date, Date date2, Date date3, Date date4, Date date5, Date date6, Date date7, Date date8, Date date9, Date date10, Date date11, Experiment experiment, String str5, boolean z2, String str6, FeatureGatingBehavior featureGatingBehavior, List list3, List list4, PaywallCloseReason paywallCloseReason, List list5, PaywallPresentationInfo paywallPresentationInfo, String str7, String str8, boolean z3, Map map, CustomerInfo customerInfo, String str9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, list, list2, eventData, date, date2, date3, date4, date5, date6, date7, date8, date9, date10, date11, experiment, str5, z2, str6, featureGatingBehavior, list3, list4, paywallCloseReason, list5, paywallPresentationInfo, str7, str8, z3, map, customerInfo, str9);
    }

    private /* synthetic */ PaywallInfo(int i3, int i4, String str, String str2, String str3, String str4, Experiment experiment, List list, List list2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Double d3, String str13, String str14, String str15, Double d4, String str16, String str17, String str18, String str19, String str20, Double d5, String str21, boolean z2, FeatureGatingBehavior featureGatingBehavior, PaywallCloseReason paywallCloseReason, List list3, List list4, List list5, PaywallPresentationInfo paywallPresentationInfo, String str22, String str23, boolean z3, Map map, CustomerInfo customerInfo, String str24, SerializationConstructorMarker serializationConstructorMarker) {
        if ((31 != (i4 & 31)) | (-1 != i3)) {
            PluginExceptionsKt.a(new int[]{i3, i4}, new int[]{-1, 31}, PaywallInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.databaseId = str;
        this.identifier = str2;
        this.name = str3;
        this.url = str4;
        this.experiment = experiment;
        this.products = list;
        this.productIds = list2;
        this.presentedByEventWithName = str5;
        this.presentedByEventWithId = str6;
        this.presentedByEventAt = str7;
        this.presentedBy = str8;
        this.presentationSourceType = str9;
        this.responseLoadStartTime = str10;
        this.responseLoadCompleteTime = str11;
        this.responseLoadFailTime = str12;
        this.responseLoadDuration = d3;
        this.webViewLoadStartTime = str13;
        this.webViewLoadCompleteTime = str14;
        this.webViewLoadFailTime = str15;
        this.webViewLoadDuration = d4;
        this.productsLoadStartTime = str16;
        this.productsLoadCompleteTime = str17;
        this.productsLoadFailTime = str18;
        this.shimmerLoadStartTime = str19;
        this.shimmerLoadCompleteTime = str20;
        this.productsLoadDuration = d5;
        this.paywalljsVersion = str21;
        this.isFreeTrialAvailable = z2;
        this.featureGatingBehavior = featureGatingBehavior;
        this.closeReason = paywallCloseReason;
        this.localNotifications = list3;
        this.computedPropertyRequests = list4;
        this.surveys = list5;
        this.presentation = paywallPresentationInfo;
        this.buildId = str22;
        this.cacheKey = str23;
        this.isScrollEnabled = z3;
        this.state = (i4 & 32) == 0 ? MapsKt.emptyMap() : map;
        this.customerInfo = (i4 & 64) == 0 ? CustomerInfo.Companion.empty() : customerInfo;
        this.presentationId = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0 ? null : str24;
    }

    private PaywallInfo(String databaseId, String identifier, String name, String url, Experiment experiment, List<ProductItem> products, List<String> productIds, String str, String str2, String str3, String presentedBy, String str4, String str5, String str6, String str7, Double d3, String str8, String str9, String str10, Double d4, String str11, String str12, String str13, String str14, String str15, Double d5, String str16, boolean z2, FeatureGatingBehavior featureGatingBehavior, PaywallCloseReason closeReason, List<LocalNotification> localNotifications, List<ComputedPropertyRequest> computedPropertyRequests, List<Survey> surveys, PaywallPresentationInfo presentation, String buildId, String cacheKey, boolean z3, Map<String, ? extends Object> state, CustomerInfo customerInfo, String str17) {
        Intrinsics.checkNotNullParameter(databaseId, "databaseId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(presentedBy, "presentedBy");
        Intrinsics.checkNotNullParameter(featureGatingBehavior, "featureGatingBehavior");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(localNotifications, "localNotifications");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.databaseId = databaseId;
        this.identifier = identifier;
        this.name = name;
        this.url = url;
        this.experiment = experiment;
        this.products = products;
        this.productIds = productIds;
        this.presentedByEventWithName = str;
        this.presentedByEventWithId = str2;
        this.presentedByEventAt = str3;
        this.presentedBy = presentedBy;
        this.presentationSourceType = str4;
        this.responseLoadStartTime = str5;
        this.responseLoadCompleteTime = str6;
        this.responseLoadFailTime = str7;
        this.responseLoadDuration = d3;
        this.webViewLoadStartTime = str8;
        this.webViewLoadCompleteTime = str9;
        this.webViewLoadFailTime = str10;
        this.webViewLoadDuration = d4;
        this.productsLoadStartTime = str11;
        this.productsLoadCompleteTime = str12;
        this.productsLoadFailTime = str13;
        this.shimmerLoadStartTime = str14;
        this.shimmerLoadCompleteTime = str15;
        this.productsLoadDuration = d5;
        this.paywalljsVersion = str16;
        this.isFreeTrialAvailable = z2;
        this.featureGatingBehavior = featureGatingBehavior;
        this.closeReason = closeReason;
        this.localNotifications = localNotifications;
        this.computedPropertyRequests = computedPropertyRequests;
        this.surveys = surveys;
        this.presentation = presentation;
        this.buildId = buildId;
        this.cacheKey = cacheKey;
        this.isScrollEnabled = z3;
        this.state = state;
        this.customerInfo = customerInfo;
        this.presentationId = str17;
    }

    public /* synthetic */ PaywallInfo(String str, String str2, String str3, String str4, Experiment experiment, List list, List list2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Double d3, String str13, String str14, String str15, Double d4, String str16, String str17, String str18, String str19, String str20, Double d5, String str21, boolean z2, FeatureGatingBehavior featureGatingBehavior, PaywallCloseReason paywallCloseReason, List list3, List list4, List list5, PaywallPresentationInfo paywallPresentationInfo, String str22, String str23, boolean z3, Map map, CustomerInfo customerInfo, String str24, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, experiment, list, list2, str5, str6, str7, str8, str9, str10, str11, str12, d3, str13, str14, str15, d4, str16, str17, str18, str19, str20, d5, str21, z2, featureGatingBehavior, paywallCloseReason, list3, list4, list5, paywallPresentationInfo, str22, str23, z3, (i4 & 32) != 0 ? MapsKt.emptyMap() : map, (i4 & 64) != 0 ? CustomerInfo.Companion.empty() : customerInfo, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str24, null);
    }

    public /* synthetic */ PaywallInfo(String str, String str2, String str3, String str4, List list, List list2, EventData eventData, Date date, Date date2, Date date3, Date date4, Date date5, Date date6, Date date7, Date date8, Date date9, Date date10, Date date11, Experiment experiment, String str5, boolean z2, String str6, FeatureGatingBehavior featureGatingBehavior, List list3, List list4, PaywallCloseReason paywallCloseReason, List list5, PaywallPresentationInfo paywallPresentationInfo, String str7, String str8, boolean z3, Map map, CustomerInfo customerInfo, String str9, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, list, list2, eventData, date, date2, date3, date4, date5, date6, date7, date8, date9, date10, date11, (i3 & 262144) != 0 ? null : experiment, (i3 & 524288) != 0 ? null : str5, z2, (i3 & 2097152) != 0 ? null : str6, (i3 & 4194304) != 0 ? FeatureGatingBehavior.NonGated.INSTANCE : featureGatingBehavior, list3, list4, paywallCloseReason, list5, paywallPresentationInfo, str7, str8, z3, (i3 & Integer.MIN_VALUE) != 0 ? MapsKt.emptyMap() : map, (i4 & 1) != 0 ? CustomerInfo.Companion.empty() : customerInfo, (i4 & 2) != 0 ? null : str9, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private PaywallInfo(String databaseId, String identifier, String name, String url, List<ProductItem> products, List<String> productIds, EventData eventData, Date date, Date date2, Date date3, Date date4, Date date5, Date date6, Date date7, Date date8, Date date9, Date date10, Date date11, Experiment experiment, String str, boolean z2, String str2, FeatureGatingBehavior featureGatingBehavior, List<LocalNotification> localNotifications, List<ComputedPropertyRequest> computedPropertyRequests, PaywallCloseReason closeReason, List<Survey> surveys, PaywallPresentationInfo presentation, String buildId, String str3, boolean z3, Map<String, ? extends Object> state, CustomerInfo customerInfo, String str4) {
        String str5;
        String str6;
        Double d3;
        Double d4;
        Double d5;
        String str7;
        String str8;
        Double dValueOf;
        String str9;
        String str10;
        String str11;
        Double dValueOf2;
        String str12;
        String str13;
        String str14;
        Double dValueOf3;
        String str15;
        String str16;
        String str17;
        String id;
        Date createdAt;
        Intrinsics.checkNotNullParameter(databaseId, "databaseId");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(featureGatingBehavior, "featureGatingBehavior");
        Intrinsics.checkNotNullParameter(localNotifications, "localNotifications");
        Intrinsics.checkNotNullParameter(computedPropertyRequests, "computedPropertyRequests");
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        Intrinsics.checkNotNullParameter(surveys, "surveys");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(buildId, "buildId");
        Intrinsics.checkNotNullParameter(str3, SbbqvQlxi.HOfQVz);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        String name2 = eventData != null ? eventData.getName() : null;
        String string = (eventData == null || (createdAt = eventData.getCreatedAt()) == null) ? null : createdAt.toString();
        if (eventData == null || (id = eventData.getId()) == null) {
            str5 = null;
        } else {
            String lowerCase = id.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            str5 = lowerCase;
        }
        String str18 = eventData != null ? "event" : "programmatically";
        String str19 = (date == null || (str17 = DateUtilsKt.getDateFormatterUtil().format(date)) == null) ? "" : str17;
        String str20 = (date == null || (str16 = DateUtilsKt.getDateFormatterUtil().format(date)) == null) ? "" : str16;
        String str21 = (date3 == null || (str15 = DateUtilsKt.getDateFormatterUtil().format(date3)) == null) ? "" : str15;
        if (date != null) {
            if (date2 != null) {
                str6 = "";
                long j3 = 1000;
                dValueOf3 = Double.valueOf((date2.getTime() / j3) - (date.getTime() / j3));
            } else {
                str6 = "";
                dValueOf3 = null;
            }
            d3 = dValueOf3;
        } else {
            str6 = "";
            d3 = null;
        }
        String str22 = (date4 == null || (str14 = DateUtilsKt.getDateFormatterUtil().format(date4)) == null) ? str6 : str14;
        String str23 = (date5 == null || (str13 = DateUtilsKt.getDateFormatterUtil().format(date5)) == null) ? str6 : str13;
        String str24 = (date6 == null || (str12 = DateUtilsKt.getDateFormatterUtil().format(date6)) == null) ? str6 : str12;
        if (date4 != null) {
            if (date5 != null) {
                long j4 = 1000;
                dValueOf2 = Double.valueOf((date5.getTime() / j4) - (date4.getTime() / j4));
            } else {
                dValueOf2 = null;
            }
            d4 = dValueOf2;
        } else {
            d4 = null;
        }
        String str25 = (date7 == null || (str11 = DateUtilsKt.getDateFormatterUtil().format(date7)) == null) ? str6 : str11;
        String str26 = (date9 == null || (str10 = DateUtilsKt.getDateFormatterUtil().format(date9)) == null) ? str6 : str10;
        String str27 = (date8 == null || (str9 = DateUtilsKt.getDateFormatterUtil().format(date8)) == null) ? str6 : str9;
        if (date7 != null) {
            if (date9 != null) {
                long j5 = 1000;
                dValueOf = Double.valueOf((date9.getTime() / j5) - (date7.getTime() / j5));
            } else {
                dValueOf = null;
            }
            d5 = dValueOf;
        } else {
            d5 = null;
        }
        this(databaseId, identifier, name, url, experiment, products, productIds, name2, str5, string, str18, str2, str19, str20, str21, d3, str22, str23, str24, d4, str25, str26, str27, (date4 == null || (str8 = DateUtilsKt.getDateFormatterUtil().format(date4)) == null) ? str6 : str8, (date4 == null || (str7 = DateUtilsKt.getDateFormatterUtil().format(date4)) == null) ? str6 : str7, d5, str, z2, featureGatingBehavior, closeReason, localNotifications, computedPropertyRequests, surveys, presentation, buildId, str3, z3, state, customerInfo, str4, null);
    }
}
