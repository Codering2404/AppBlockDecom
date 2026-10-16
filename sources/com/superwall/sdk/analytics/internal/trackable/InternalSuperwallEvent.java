package com.superwall.sdk.analytics.internal.trackable;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import coil.target.Yb.oUcQRqOVfOC;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.sun.jna.Function;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.superwall.SuperwallEvent;
import com.superwall.sdk.analytics.superwall.TransactionProduct;
import com.superwall.sdk.config.models.Survey;
import com.superwall.sdk.config.models.SurveyOption;
import com.superwall.sdk.config.options.SuperwallOptions;
import com.superwall.sdk.config.options.SuperwallOptionsKt;
import com.superwall.sdk.dependencies.ComputedPropertyRequestsFactory;
import com.superwall.sdk.dependencies.FeatureFlagsFactory;
import com.superwall.sdk.dependencies.RuleAttributesFactory;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.Entitlement$$serializer;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.models.triggers.InternalTriggerResult;
import com.superwall.sdk.network.JsonFactory;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatus;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequestType;
import com.superwall.sdk.paywall.view.survey.SurveyPresentationResult;
import com.superwall.sdk.paywall.view.webview.WebviewError;
import com.superwall.sdk.paywall.view.webview.messaging.PageViewData;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import com.superwall.sdk.store.abstractions.transactions.GoogleBillingPurchaseTransaction;
import com.superwall.sdk.store.abstractions.transactions.StoreTransaction;
import com.superwall.sdk.store.abstractions.transactions.StoreTransactionType;
import com.superwall.sdk.store.transactions.RestoreType;
import com.superwall.sdk.store.transactions.TransactionError;
import com.superwall.sdk.web.WebPaywallRedeemer;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;

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
public abstract class InternalSuperwallEvent implements TrackableSuperwallEvent {
    private final SuperwallEvent superwallPlacement;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppClose extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public AppClose() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public /* synthetic */ AppClose(HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppClose(HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.AppClose(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppInstall extends InternalSuperwallEvent {
        private final String appInstalledAtString;
        private HashMap<String, Object> audienceFilterParams;
        private final boolean hasExternalPurchaseController;

        public /* synthetic */ AppInstall(String str, boolean z2, HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z2, (i3 & 4) != 0 ? new HashMap() : map);
        }

        public final String getAppInstalledAtString() {
            return this.appInstalledAtString;
        }

        public final boolean getHasExternalPurchaseController() {
            return this.hasExternalPurchaseController;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return MapsKt.hashMapOf(TuplesKt.a("application_installed_at", this.appInstalledAtString), TuplesKt.a("using_purchase_controller", Boxing.a(this.hasExternalPurchaseController)));
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppInstall(String appInstalledAtString, boolean z2, HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.AppInstall(), null);
            Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.appInstalledAtString = appInstalledAtString;
            this.hasExternalPurchaseController = z2;
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppLaunch extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public AppLaunch() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public /* synthetic */ AppLaunch(HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppLaunch(HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.AppLaunch(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppOpen extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public AppOpen() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public /* synthetic */ AppOpen(HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppOpen(HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.AppOpen(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Attributes extends InternalSuperwallEvent {
        private final String appInstalledAtString;
        private HashMap<String, Object> audienceFilterParams;

        public /* synthetic */ Attributes(String str, HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? new HashMap() : map);
        }

        public final String getAppInstalledAtString() {
            return this.appInstalledAtString;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return MapsKt.hashMapOf(TuplesKt.a("application_installed_at", this.appInstalledAtString));
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Attributes(String appInstalledAtString, HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.UserAttributes(audienceFilterParams), null);
            Intrinsics.checkNotNullParameter(appInstalledAtString, "appInstalledAtString");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.appInstalledAtString = appInstalledAtString;
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigAttributes extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final boolean hasDelegate;
        private final boolean hasExternalPurchaseController;
        private final SuperwallOptions options;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigAttributes(SuperwallOptions options, boolean z2, boolean z3) {
            super(SuperwallEvent.ConfigAttributes.INSTANCE, null);
            Intrinsics.checkNotNullParameter(options, "options");
            this.options = options;
            this.hasExternalPurchaseController = z2;
            this.hasDelegate = z3;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final boolean getHasDelegate() {
            return this.hasDelegate;
        }

        public final boolean getHasExternalPurchaseController() {
            return this.hasExternalPurchaseController;
        }

        public final SuperwallOptions getOptions() {
            return this.options;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            Pair[] pairArr = (Pair[]) MapsKt.toList(MapsKt.plus(SuperwallOptionsKt.toMap(this.options), MapsKt.mapOf(TuplesKt.a("using_purchase_controller", Boxing.a(this.hasExternalPurchaseController)), TuplesKt.a("has_delegate", Boxing.a(this.hasDelegate))))).toArray(new Pair[0]);
            return MapsKt.hashMapOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigFail extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final String errorMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigFail(String errorMessage) {
            super(SuperwallEvent.ConfigFail.INSTANCE, null);
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ ConfigFail copy$default(ConfigFail configFail, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = configFail.errorMessage;
            }
            return configFail.copy(str);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final ConfigFail copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new ConfigFail(errorMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfigFail) && Intrinsics.areEqual(this.errorMessage, ((ConfigFail) obj).errorMessage);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.mapOf(TuplesKt.a("error_message", this.errorMessage));
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "ConfigFail(errorMessage=" + this.errorMessage + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigRefresh extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final String buildId;
        private final long fetchDuration;
        private final boolean isCached;
        private final int retryCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigRefresh(boolean z2, String buildId, int i3, long j3) {
            super(SuperwallEvent.ConfigRefresh.INSTANCE, null);
            Intrinsics.checkNotNullParameter(buildId, "buildId");
            this.isCached = z2;
            this.buildId = buildId;
            this.retryCount = i3;
            this.fetchDuration = j3;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ ConfigRefresh copy$default(ConfigRefresh configRefresh, boolean z2, String str, int i3, long j3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                z2 = configRefresh.isCached;
            }
            if ((i4 & 2) != 0) {
                str = configRefresh.buildId;
            }
            if ((i4 & 4) != 0) {
                i3 = configRefresh.retryCount;
            }
            if ((i4 & 8) != 0) {
                j3 = configRefresh.fetchDuration;
            }
            int i5 = i3;
            return configRefresh.copy(z2, str, i5, j3);
        }

        public final boolean component1() {
            return this.isCached;
        }

        public final String component2() {
            return this.buildId;
        }

        public final int component3() {
            return this.retryCount;
        }

        public final long component4() {
            return this.fetchDuration;
        }

        public final ConfigRefresh copy(boolean z2, String buildId, int i3, long j3) {
            Intrinsics.checkNotNullParameter(buildId, "buildId");
            return new ConfigRefresh(z2, buildId, i3, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConfigRefresh)) {
                return false;
            }
            ConfigRefresh configRefresh = (ConfigRefresh) obj;
            return this.isCached == configRefresh.isCached && Intrinsics.areEqual(this.buildId, configRefresh.buildId) && this.retryCount == configRefresh.retryCount && this.fetchDuration == configRefresh.fetchDuration;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final String getBuildId() {
            return this.buildId;
        }

        public final long getFetchDuration() {
            return this.fetchDuration;
        }

        public final int getRetryCount() {
            return this.retryCount;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.mapOf(TuplesKt.a(DiagnosticsTracker.CACHE_STATUS_KEY, this.isCached ? "CACHED" : "NOT_CACHED"), TuplesKt.a("config_build_id", this.buildId), TuplesKt.a("retry_count", Boxing.d(this.retryCount)), TuplesKt.a("fetch_duration", Boxing.e(this.fetchDuration)));
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.isCached) * 31) + this.buildId.hashCode()) * 31) + Integer.hashCode(this.retryCount)) * 31) + Long.hashCode(this.fetchDuration);
        }

        public final boolean isCached() {
            return this.isCached;
        }

        public String toString() {
            return "ConfigRefresh(isCached=" + this.isCached + ", buildId=" + this.buildId + ", retryCount=" + this.retryCount + ", fetchDuration=" + this.fetchDuration + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfirmAllAssignments extends InternalSuperwallEvent {
        public static final ConfirmAllAssignments INSTANCE = new ConfirmAllAssignments();
        private static final Map<String, Object> audienceFilterParams = MapsKt.emptyMap();

        private ConfirmAllAssignments() {
            super(SuperwallEvent.ConfirmAllAssignments.INSTANCE, null);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomPlacement extends InternalSuperwallEvent {
        private final boolean canImplicitlyTriggerPaywall;
        private final Map<String, Object> params;
        private final PaywallInfo paywallInfo;
        private final String placementName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPlacement(String placementName, PaywallInfo paywallInfo, Map<String, ? extends Object> params) {
            super(new SuperwallEvent.CustomPlacement(placementName, paywallInfo, params), null);
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(params, "params");
            this.placementName = placementName;
            this.paywallInfo = paywallInfo;
            this.params = params;
            this.canImplicitlyTriggerPaywall = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomPlacement copy$default(CustomPlacement customPlacement, String str, PaywallInfo paywallInfo, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = customPlacement.placementName;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = customPlacement.paywallInfo;
            }
            if ((i3 & 4) != 0) {
                map = customPlacement.params;
            }
            return customPlacement.copy(str, paywallInfo, map);
        }

        public final String component1() {
            return this.placementName;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final Map<String, Object> component3() {
            return this.params;
        }

        public final CustomPlacement copy(String placementName, PaywallInfo paywallInfo, Map<String, ? extends Object> params) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(params, "params");
            return new CustomPlacement(placementName, paywallInfo, params);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomPlacement)) {
                return false;
            }
            CustomPlacement customPlacement = (CustomPlacement) obj;
            return Intrinsics.areEqual(this.placementName, customPlacement.placementName) && Intrinsics.areEqual(this.paywallInfo, customPlacement.paywallInfo) && Intrinsics.areEqual(this.params, customPlacement.params);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return MapsKt.plus(this.paywallInfo.audienceFilterParams(), this.params);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.Trackable
        public boolean getCanImplicitlyTriggerPaywall() {
            return this.canImplicitlyTriggerPaywall;
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final String getPlacementName() {
            return this.placementName;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.Trackable
        public String getRawName() {
            return this.placementName;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.plus(MapsKt.plus(PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null), this.params), MapsKt.mapOf(TuplesKt.a("name", this.placementName)));
        }

        public int hashCode() {
            return (((this.placementName.hashCode() * 31) + this.paywallInfo.hashCode()) * 31) + this.params.hashCode();
        }

        public String toString() {
            return "CustomPlacement(placementName=" + this.placementName + ", paywallInfo=" + this.paywallInfo + ", params=" + this.params + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeepLink extends InternalSuperwallEvent {
        public static final Companion Companion = new Companion(null);
        private HashMap<String, Object> audienceFilterParams;
        private final URI uri;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final HashMap<String, Object> extractQueryParameters(URI uri) {
                String query = uri.getQuery();
                if (query == null) {
                    query = "";
                }
                List listV0 = StringsKt.V0(query, new String[]{"&"}, false, 0, 6, null);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listV0, 10)), 16));
                Iterator it = listV0.iterator();
                while (it.hasNext()) {
                    List listV02 = StringsKt.V0((String) it.next(), new String[]{"="}, false, 0, 6, null);
                    Pair pairA = TuplesKt.a(listV02.get(0), CollectionsKt.getOrNull(listV02, 1));
                    linkedHashMap.put(pairA.e(), pairA.f());
                }
                ArrayList arrayList = new ArrayList(linkedHashMap.size());
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    arrayList.add(str2 == null ? null : StringsKt.F(str2, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, true) ? TuplesKt.a(str, Boolean.TRUE) : StringsKt.F(str2, "false", true) ? TuplesKt.a(str, Boolean.FALSE) : StringsKt.u(str2) != null ? TuplesKt.a(str, Integer.valueOf(Integer.parseInt(str2))) : StringsKt.r(str2) != null ? TuplesKt.a(str, Double.valueOf(Double.parseDouble(str2))) : TuplesKt.a(str, str2));
                }
                return new HashMap<>(MapsKt.toMap(CollectionsKt.filterNotNull(arrayList)));
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeepLink(URI uri) {
            super(new SuperwallEvent.DeepLink(uri), null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
            this.audienceFilterParams = new HashMap<>(MapsKt.plus(Companion.extractQueryParameters(uri), extractedParams()));
        }

        private final HashMap<String, Object> extractedParams() {
            String strI1;
            String strJ1;
            String strJ12;
            Pair pairA = TuplesKt.a("url", this.uri.toString());
            String path = this.uri.getPath();
            if (path == null) {
                path = "";
            }
            Pair pairA2 = TuplesKt.a("path", path);
            String path2 = this.uri.getPath();
            if (path2 == null || (strJ12 = StringsKt.j1(path2, "/", null, 2, null)) == null || (strI1 = StringsKt.i1(strJ12, '.', null, 2, null)) == null) {
                strI1 = "";
            }
            Pair pairA3 = TuplesKt.a("pathExtension", strI1);
            String path3 = this.uri.getPath();
            if (path3 == null || (strJ1 = StringsKt.j1(path3, "/", null, 2, null)) == null) {
                strJ1 = "";
            }
            Pair pairA4 = TuplesKt.a("lastPathComponent", strJ1);
            String host = this.uri.getHost();
            if (host == null) {
                host = "";
            }
            Pair pairA5 = TuplesKt.a(DiagnosticsTracker.HOST_KEY, host);
            String query = this.uri.getQuery();
            if (query == null) {
                query = "";
            }
            Pair pairA6 = TuplesKt.a(AppLovinEventParameters.SEARCH_QUERY, query);
            String fragment = this.uri.getFragment();
            return MapsKt.hashMapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, TuplesKt.a("fragment", fragment != null ? fragment : ""));
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return extractedParams();
        }

        public final URI getUri() {
            return this.uri;
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeviceAttributes extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;
        private final HashMap<String, Object> deviceAttributes;

        public /* synthetic */ DeviceAttributes(HashMap map, HashMap map2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i3 & 2) != 0 ? new HashMap() : map2);
        }

        public final HashMap<String, Object> getDeviceAttributes() {
            return this.deviceAttributes;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return this.deviceAttributes;
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceAttributes(HashMap<String, Object> deviceAttributes, HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.DeviceAttributes(deviceAttributes), null);
            Intrinsics.checkNotNullParameter(deviceAttributes, "deviceAttributes");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.deviceAttributes = deviceAttributes;
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnrichmentLoad extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final State state;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class State {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends State {
                private final Enrichment enrichment;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Complete(Enrichment enrichment) {
                    super(null);
                    Intrinsics.checkNotNullParameter(enrichment, "enrichment");
                    this.enrichment = enrichment;
                }

                public static /* synthetic */ Complete copy$default(Complete complete, Enrichment enrichment, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        enrichment = complete.enrichment;
                    }
                    return complete.copy(enrichment);
                }

                public final Enrichment component1() {
                    return this.enrichment;
                }

                public final Complete copy(Enrichment enrichment) {
                    Intrinsics.checkNotNullParameter(enrichment, "enrichment");
                    return new Complete(enrichment);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Complete) && Intrinsics.areEqual(this.enrichment, ((Complete) obj).enrichment);
                }

                public final Enrichment getEnrichment() {
                    return this.enrichment;
                }

                public int hashCode() {
                    return this.enrichment.hashCode();
                }

                public String toString() {
                    return "Complete(enrichment=" + this.enrichment + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fail extends State {
                public static final Fail INSTANCE = new Fail();

                private Fail() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends State {
                public static final Start INSTANCE = new Start();

                private Start() {
                    super(null);
                }
            }

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private State() {
            }
        }

        public EnrichmentLoad(State state) {
            SuperwallEvent enrichmentComplete;
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof State.Complete) {
                State.Complete complete = (State.Complete) state;
                enrichmentComplete = new SuperwallEvent.EnrichmentComplete(complete.getEnrichment().getUser(), complete.getEnrichment().getDevice());
            } else if (Intrinsics.areEqual(state, State.Fail.INSTANCE)) {
                enrichmentComplete = SuperwallEvent.EnrichmentFail.INSTANCE;
            } else {
                if (!Intrinsics.areEqual(state, State.Start.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                enrichmentComplete = SuperwallEvent.EnrichmentStart.INSTANCE;
            }
            super(enrichmentComplete, null);
            this.state = state;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ EnrichmentLoad copy$default(EnrichmentLoad enrichmentLoad, State state, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                state = enrichmentLoad.state;
            }
            return enrichmentLoad.copy(state);
        }

        public final State component1() {
            return this.state;
        }

        public final EnrichmentLoad copy(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new EnrichmentLoad(state);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EnrichmentLoad) && Intrinsics.areEqual(this.state, ((EnrichmentLoad) obj).state);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            State state = this.state;
            if (!(state instanceof State.Complete)) {
                return MapsKt.emptyMap();
            }
            Map<String, Object> user = ((State.Complete) state).getEnrichment().getUser();
            ArrayList arrayList = new ArrayList(user.size());
            for (Map.Entry<String, Object> entry : user.entrySet()) {
                arrayList.add(TuplesKt.a("user_" + ((Object) entry.getKey()), entry.getValue()));
            }
            Map<String, Object> device = ((State.Complete) this.state).getEnrichment().getDevice();
            ArrayList arrayList2 = new ArrayList(device.size());
            for (Map.Entry<String, Object> entry2 : device.entrySet()) {
                arrayList2.add(TuplesKt.a("device_" + ((Object) entry2.getKey()), entry2.getValue()));
            }
            return MapsKt.toMap(CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2));
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "EnrichmentLoad(state=" + this.state + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ErrorThrown extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final boolean isFatal;
        private final String message;
        private final long occuredAt;
        private final String stacktrace;
        private final String type;

        public static /* synthetic */ ErrorThrown copy$default(ErrorThrown errorThrown, String str, String str2, long j3, String str3, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = errorThrown.message;
            }
            if ((i3 & 2) != 0) {
                str2 = errorThrown.stacktrace;
            }
            if ((i3 & 4) != 0) {
                j3 = errorThrown.occuredAt;
            }
            if ((i3 & 8) != 0) {
                str3 = errorThrown.type;
            }
            if ((i3 & 16) != 0) {
                z2 = errorThrown.isFatal;
            }
            long j4 = j3;
            return errorThrown.copy(str, str2, j4, str3, z2);
        }

        public final String component1() {
            return this.message;
        }

        public final String component2() {
            return this.stacktrace;
        }

        public final long component3() {
            return this.occuredAt;
        }

        public final String component4() {
            return this.type;
        }

        public final boolean component5() {
            return this.isFatal;
        }

        public final ErrorThrown copy(String message, String stacktrace, long j3, String type, boolean z2) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
            Intrinsics.checkNotNullParameter(type, "type");
            return new ErrorThrown(message, stacktrace, j3, type, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ErrorThrown)) {
                return false;
            }
            ErrorThrown errorThrown = (ErrorThrown) obj;
            return Intrinsics.areEqual(this.message, errorThrown.message) && Intrinsics.areEqual(this.stacktrace, errorThrown.stacktrace) && this.occuredAt == errorThrown.occuredAt && Intrinsics.areEqual(this.type, errorThrown.type) && this.isFatal == errorThrown.isFatal;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final String getMessage() {
            return this.message;
        }

        public final long getOccuredAt() {
            return this.occuredAt;
        }

        public final String getStacktrace() {
            return this.stacktrace;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.mapOf(TuplesKt.a("exception_type", this.type), TuplesKt.a("error_message", this.message), TuplesKt.a("error_stack_trace", this.stacktrace), TuplesKt.a("occured_at", Boxing.e(this.occuredAt)), TuplesKt.a("is_fatal", Boxing.a(this.isFatal)));
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((((this.message.hashCode() * 31) + this.stacktrace.hashCode()) * 31) + Long.hashCode(this.occuredAt)) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isFatal);
        }

        public final boolean isFatal() {
            return this.isFatal;
        }

        public String toString() {
            return "ErrorThrown(message=" + this.message + ", stacktrace=" + this.stacktrace + ", occuredAt=" + this.occuredAt + ", type=" + this.type + ", isFatal=" + this.isFatal + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorThrown(String str, String stacktrace, long j3, String type, boolean z2) {
            super(SuperwallEvent.ErrorThrown.INSTANCE, null);
            Intrinsics.checkNotNullParameter(str, oUcQRqOVfOC.xrYAlnPwXwljg);
            Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
            Intrinsics.checkNotNullParameter(type, "type");
            this.message = str;
            this.stacktrace = stacktrace;
            this.occuredAt = j3;
            this.type = type;
            this.isFatal = z2;
            this.audienceFilterParams = MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExpressionResult extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final String celExpression;
        private final Boolean celExpressionResult;
        private final String errorMessage;
        private final String jsExpression;
        private final Boolean jsExpressionResult;
        private final String liquidExpression;
        private final Boolean liquidExpressionResult;

        public ExpressionResult() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ ExpressionResult copy$default(ExpressionResult expressionResult, String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = expressionResult.celExpression;
            }
            if ((i3 & 2) != 0) {
                str2 = expressionResult.liquidExpression;
            }
            if ((i3 & 4) != 0) {
                str3 = expressionResult.jsExpression;
            }
            if ((i3 & 8) != 0) {
                bool = expressionResult.celExpressionResult;
            }
            if ((i3 & 16) != 0) {
                bool2 = expressionResult.liquidExpressionResult;
            }
            if ((i3 & 32) != 0) {
                bool3 = expressionResult.jsExpressionResult;
            }
            if ((i3 & 64) != 0) {
                str4 = expressionResult.errorMessage;
            }
            Boolean bool4 = bool3;
            String str5 = str4;
            Boolean bool5 = bool2;
            String str6 = str3;
            return expressionResult.copy(str, str2, str6, bool, bool5, bool4, str5);
        }

        public final String component1() {
            return this.celExpression;
        }

        public final String component2() {
            return this.liquidExpression;
        }

        public final String component3() {
            return this.jsExpression;
        }

        public final Boolean component4() {
            return this.celExpressionResult;
        }

        public final Boolean component5() {
            return this.liquidExpressionResult;
        }

        public final Boolean component6() {
            return this.jsExpressionResult;
        }

        public final String component7() {
            return this.errorMessage;
        }

        public final ExpressionResult copy(String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, String str4) {
            return new ExpressionResult(str, str2, str3, bool, bool2, bool3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExpressionResult)) {
                return false;
            }
            ExpressionResult expressionResult = (ExpressionResult) obj;
            return Intrinsics.areEqual(this.celExpression, expressionResult.celExpression) && Intrinsics.areEqual(this.liquidExpression, expressionResult.liquidExpression) && Intrinsics.areEqual(this.jsExpression, expressionResult.jsExpression) && Intrinsics.areEqual(this.celExpressionResult, expressionResult.celExpressionResult) && Intrinsics.areEqual(this.liquidExpressionResult, expressionResult.liquidExpressionResult) && Intrinsics.areEqual(this.jsExpressionResult, expressionResult.jsExpressionResult) && Intrinsics.areEqual(this.errorMessage, expressionResult.errorMessage);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final String getCelExpression() {
            return this.celExpression;
        }

        public final Boolean getCelExpressionResult() {
            return this.celExpressionResult;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getJsExpression() {
            return this.jsExpression;
        }

        public final Boolean getJsExpressionResult() {
            return this.jsExpressionResult;
        }

        public final String getLiquidExpression() {
            return this.liquidExpression;
        }

        public final Boolean getLiquidExpressionResult() {
            return this.liquidExpressionResult;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            String str = this.celExpression;
            if (str == null) {
                str = "";
            }
            Pair pairA = TuplesKt.a("cel_expression", str);
            String str2 = this.liquidExpression;
            if (str2 == null) {
                str2 = "";
            }
            Pair pairA2 = TuplesKt.a("liquid_expression", str2);
            String str3 = this.jsExpression;
            if (str3 == null) {
                str3 = "";
            }
            Pair pairA3 = TuplesKt.a("js_expression", str3);
            Object obj = this.celExpressionResult;
            if (obj == null) {
                obj = "";
            }
            Pair pairA4 = TuplesKt.a("cel_expression_result", obj);
            Object obj2 = this.liquidExpressionResult;
            if (obj2 == null) {
                obj2 = "";
            }
            Pair pairA5 = TuplesKt.a("liquid_expression_result", obj2);
            Object obj3 = this.jsExpressionResult;
            if (obj3 == null) {
                obj3 = "";
            }
            Pair pairA6 = TuplesKt.a("js_expression_result", obj3);
            String str4 = this.errorMessage;
            return MapsKt.mapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, TuplesKt.a("error_message", str4 != null ? str4 : ""));
        }

        public int hashCode() {
            String str = this.celExpression;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.liquidExpression;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.jsExpression;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.celExpressionResult;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.liquidExpressionResult;
            int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.jsExpressionResult;
            int iHashCode6 = (iHashCode5 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            String str4 = this.errorMessage;
            return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "ExpressionResult(celExpression=" + this.celExpression + ", liquidExpression=" + this.liquidExpression + ", jsExpression=" + this.jsExpression + ", celExpressionResult=" + this.celExpressionResult + ", liquidExpressionResult=" + this.liquidExpressionResult + ", jsExpressionResult=" + this.jsExpressionResult + ", errorMessage=" + this.errorMessage + ")";
        }

        public /* synthetic */ ExpressionResult(String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : bool, (i3 & 16) != 0 ? null : bool2, (i3 & 32) != 0 ? null : bool3, (i3 & 64) != 0 ? null : str4);
        }

        public ExpressionResult(String str, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, String str4) {
            super(SuperwallEvent.ExpressionResult.INSTANCE, null);
            this.celExpression = str;
            this.liquidExpression = str2;
            this.jsExpression = str3;
            this.celExpressionResult = bool;
            this.liquidExpressionResult = bool2;
            this.jsExpressionResult = bool3;
            this.errorMessage = str4;
            this.audienceFilterParams = MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FirstSeen extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public FirstSeen() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public /* synthetic */ FirstSeen(HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FirstSeen(HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.FirstSeen(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FreeTrialStart extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FreeTrialStart(PaywallInfo paywallInfo, StoreProduct product) {
            super(new SuperwallEvent.FreeTrialStart(product, paywallInfo), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(product, "product");
            this.paywallInfo = paywallInfo;
            this.product = product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, this.product, null, 2, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IdentityAlias extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public IdentityAlias() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public /* synthetic */ IdentityAlias(HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IdentityAlias(HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.IdentityAlias(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntegrationAttributes extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;
        private Map<String, ? extends Object> params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationAttributes(Map<String, ? extends Object> params) {
            super(new SuperwallEvent.IntegrationAttributes(params), null);
            Intrinsics.checkNotNullParameter(params, "params");
            this.params = params;
            this.audienceFilterParams = new HashMap<>(this.params);
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public final void setParams(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.params = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NonRecurringProductPurchase extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonRecurringProductPurchase(PaywallInfo paywallInfo, StoreProduct product) {
            super(new SuperwallEvent.NonRecurringProductPurchase(new TransactionProduct(product), paywallInfo), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(product, "product");
            this.paywallInfo = paywallInfo;
            this.product = product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, this.product, null, 2, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallClose extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final SurveyPresentationResult surveyPresentationResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallClose(PaywallInfo paywallInfo, SurveyPresentationResult surveyPresentationResult) {
            super(new SuperwallEvent.PaywallClose(paywallInfo), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(surveyPresentationResult, "surveyPresentationResult");
            this.paywallInfo = paywallInfo;
            this.surveyPresentationResult = surveyPresentationResult;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("survey_attached", Boxing.a(!this.paywallInfo.getSurveys().isEmpty())));
            SurveyPresentationResult surveyPresentationResult = this.surveyPresentationResult;
            if (surveyPresentationResult != SurveyPresentationResult.NOSHOW) {
                mapMutableMapOf.put("survey_presentation", surveyPresentationResult.getRawValue());
            }
            mapMutableMapOf.putAll(PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null));
            return new HashMap(mapMutableMapOf);
        }

        public final SurveyPresentationResult getSurveyPresentationResult() {
            return this.surveyPresentationResult;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallDecline extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallDecline(PaywallInfo paywallInfo) {
            super(new SuperwallEvent.PaywallDecline(paywallInfo), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallLoad extends InternalSuperwallEvent {
        private final EventData eventData;
        private final State state;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class State {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends State {
                private final PaywallInfo paywallInfo;

                public final PaywallInfo getPaywallInfo() {
                    return this.paywallInfo;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Complete(PaywallInfo paywallInfo) {
                    super(null);
                    Intrinsics.checkNotNullParameter(paywallInfo, KqqtdetwHMIO.eRkvAAMVfZ);
                    this.paywallInfo = paywallInfo;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fail extends State {
                public Fail() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class NotFound extends State {
                public NotFound() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends State {
                public Start() {
                    super(null);
                }
            }

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private State() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallLoad(State state, EventData eventData) {
            super(new SuperwallEvent.PaywallResponseLoadStart(eventData != null ? eventData.getName() : null), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.eventData = eventData;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            State state = this.state;
            return state instanceof State.Complete ? ((State.Complete) state).getPaywallInfo().audienceFilterParams() : MapsKt.emptyMap();
        }

        public final EventData getEventData() {
            return this.eventData;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.a("is_triggered_from_event", Boxing.a(this.eventData != null)));
            State state = this.state;
            if ((state instanceof State.Start) || (state instanceof State.NotFound) || (state instanceof State.Fail)) {
                return mapHashMapOf;
            }
            if (state instanceof State.Complete) {
                return new HashMap(PaywallInfo.eventParams$default(((State.Complete) this.state).getPaywallInfo(), null, mapHashMapOf, 1, null));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            State state = this.state;
            if (state instanceof State.Start) {
                EventData eventData = this.eventData;
                return new SuperwallEvent.PaywallResponseLoadStart(eventData != null ? eventData.getName() : null);
            }
            if (state instanceof State.Complete) {
                EventData eventData2 = this.eventData;
                return new SuperwallEvent.PaywallResponseLoadComplete(eventData2 != null ? eventData2.getName() : null, ((State.Complete) this.state).getPaywallInfo());
            }
            if (state instanceof State.Fail) {
                EventData eventData3 = this.eventData;
                return new SuperwallEvent.PaywallResponseLoadFail(eventData3 != null ? eventData3.getName() : null);
            }
            if (!(state instanceof State.NotFound)) {
                throw new NoWhenBranchMatchedException();
            }
            EventData eventData4 = this.eventData;
            return new SuperwallEvent.PaywallResponseLoadNotFound(eventData4 != null ? eventData4.getName() : null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallOpen extends InternalSuperwallEvent {
        private final Integer demandScore;
        private final String demandTier;
        private final PaywallInfo paywallInfo;
        private final Map<String, Object> userAttributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallOpen(PaywallInfo paywallInfo, Map<String, ? extends Object> userAttributes, String str, Integer num) {
            super(new SuperwallEvent.PaywallOpen(paywallInfo), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(userAttributes, "userAttributes");
            this.paywallInfo = paywallInfo;
            this.userAttributes = userAttributes;
            this.demandTier = str;
            this.demandScore = num;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final Integer getDemandScore() {
            return this.demandScore;
        }

        public final String getDemandTier() {
            return this.demandTier;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            Map mapEventParams$default = PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null);
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("user_attributes", this.userAttributes));
            String str = this.demandTier;
            if (str != null) {
                mapMutableMapOf.put("attr_demandTier", str);
            }
            Integer num = this.demandScore;
            if (num != null) {
                mapMutableMapOf.put("attr_demandScore", num);
            }
            return new HashMap(MapsKt.plus(mapEventParams$default, mapMutableMapOf));
        }

        public final Map<String, Object> getUserAttributes() {
            return this.userAttributes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallPageView extends InternalSuperwallEvent {
        private final PageViewData data;
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallPageView(PaywallInfo paywallInfo, PageViewData data) {
            super(new SuperwallEvent.PaywallPageView(paywallInfo, data), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(data, "data");
            this.paywallInfo = paywallInfo;
            this.data = data;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PageViewData getData() {
            return this.data;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            HashMap map = new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null));
            map.put("page_node_id", this.data.getPageNodeId());
            map.put("flow_position", Boxing.d(this.data.getFlowPosition()));
            map.put("page_name", this.data.getPageName());
            map.put("navigation_node_id", this.data.getNavigationNodeId());
            map.put("navigation_type", this.data.getNavigationType());
            String previousPageNodeId = this.data.getPreviousPageNodeId();
            if (previousPageNodeId != null) {
                map.put("previous_page_node_id", previousPageNodeId);
            }
            Integer previousFlowPosition = this.data.getPreviousFlowPosition();
            if (previousFlowPosition != null) {
                map.put("previous_flow_position", Boxing.d(previousFlowPosition.intValue()));
            }
            Integer timeOnPreviousPageMs = this.data.getTimeOnPreviousPageMs();
            if (timeOnPreviousPageMs != null) {
                map.put("time_on_previous_page_ms", Boxing.d(timeOnPreviousPageMs.intValue()));
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallPreload extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final int paywallCount;
        private final State state;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class State {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ State[] $VALUES;
            public static final State Start = new State("Start", 0);
            public static final State Complete = new State("Complete", 1);

            private static final /* synthetic */ State[] $values() {
                return new State[]{Start, Complete};
            }

            static {
                State[] stateArr$values = $values();
                $VALUES = stateArr$values;
                $ENTRIES = EnumEntriesKt.a(stateArr$values);
            }

            private State(String str, int i3) {
            }

            public static EnumEntries<State> getEntries() {
                return $ENTRIES;
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[State.values().length];
                try {
                    iArr[State.Start.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[State.Complete.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallPreload(State state, int i3) {
            super(new SuperwallEvent.PaywallPreloadStart(i3), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.paywallCount = i3;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ PaywallPreload copy$default(PaywallPreload paywallPreload, State state, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                state = paywallPreload.state;
            }
            if ((i4 & 2) != 0) {
                i3 = paywallPreload.paywallCount;
            }
            return paywallPreload.copy(state, i3);
        }

        public final State component1() {
            return this.state;
        }

        public final int component2() {
            return this.paywallCount;
        }

        public final PaywallPreload copy(State state, int i3) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new PaywallPreload(state, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallPreload)) {
                return false;
            }
            PaywallPreload paywallPreload = (PaywallPreload) obj;
            return this.state == paywallPreload.state && this.paywallCount == paywallPreload.paywallCount;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final int getPaywallCount() {
            return this.paywallCount;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.mapOf(TuplesKt.a("paywall_count", Boxing.d(this.paywallCount)));
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i3 == 1) {
                return new SuperwallEvent.PaywallPreloadStart(this.paywallCount);
            }
            if (i3 == 2) {
                return new SuperwallEvent.PaywallPreloadComplete(this.paywallCount);
            }
            throw new NoWhenBranchMatchedException();
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + Integer.hashCode(this.paywallCount);
        }

        public String toString() {
            return "PaywallPreload(state=" + this.state + ", paywallCount=" + this.paywallCount + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallProductsLoad extends InternalSuperwallEvent {
        private final EventData eventData;
        private final PaywallInfo paywallInfo;
        private final State state;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class State {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends State {
                public Complete() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fail extends State {
                private final String errorMessage;

                public Fail(String str) {
                    super(null);
                    this.errorMessage = str;
                }

                public final String getErrorMessage() {
                    return this.errorMessage;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends State {
                public Start() {
                    super(null);
                }
            }

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private State() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallProductsLoad(State state, PaywallInfo paywallInfo, EventData eventData) {
            super(new SuperwallEvent.PaywallProductsLoadStart(eventData != null ? eventData.getName() : null, paywallInfo), null);
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.state = state;
            this.paywallInfo = paywallInfo;
            this.eventData = eventData;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final EventData getEventData() {
            return this.eventData;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.a("is_triggered_from_event", Boxing.a(this.eventData != null)));
            State state = this.state;
            if ((state instanceof State.Fail) && ((State.Fail) state).getErrorMessage() != null) {
                mapHashMapOf.put("error_message", ((State.Fail) this.state).getErrorMessage());
            }
            mapHashMapOf.putAll(PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null));
            return mapHashMapOf;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            State state = this.state;
            if (state instanceof State.Start) {
                EventData eventData = this.eventData;
                return new SuperwallEvent.PaywallProductsLoadStart(eventData != null ? eventData.getName() : null, this.paywallInfo);
            }
            if (state instanceof State.Fail) {
                String errorMessage = ((State.Fail) state).getErrorMessage();
                EventData eventData2 = this.eventData;
                return new SuperwallEvent.PaywallProductsLoadFail(errorMessage, eventData2 != null ? eventData2.getName() : null, this.paywallInfo);
            }
            if (!(state instanceof State.Complete)) {
                throw new NoWhenBranchMatchedException();
            }
            EventData eventData3 = this.eventData;
            return new SuperwallEvent.PaywallProductsLoadComplete(eventData3 != null ? eventData3.getName() : null, this.paywallInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallResourceLoadFail extends InternalSuperwallEvent {
        private final String error;
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallResourceLoadFail(String url, String error) {
            super(new SuperwallEvent.PaywallResourceLoadFail(url, error), null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(error, "error");
            this.url = url;
            this.error = error;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return MapsKt.emptyMap();
        }

        public final String getError() {
            return this.error;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.mapOf(TuplesKt.a("url", this.url), TuplesKt.a("error", this.error));
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallWebviewLoad extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final State state;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class State {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends State {
                public Complete() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fail extends State {
                private final WebviewError error;
                private final List<String> urls;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Fail(WebviewError error, List<String> urls) {
                    super(null);
                    Intrinsics.checkNotNullParameter(error, "error");
                    Intrinsics.checkNotNullParameter(urls, "urls");
                    this.error = error;
                    this.urls = urls;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ Fail copy$default(Fail fail, WebviewError webviewError, List list, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        webviewError = fail.error;
                    }
                    if ((i3 & 2) != 0) {
                        list = fail.urls;
                    }
                    return fail.copy(webviewError, list);
                }

                public final WebviewError component1() {
                    return this.error;
                }

                public final List<String> component2() {
                    return this.urls;
                }

                public final Fail copy(WebviewError error, List<String> urls) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    Intrinsics.checkNotNullParameter(urls, "urls");
                    return new Fail(error, urls);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Fail)) {
                        return false;
                    }
                    Fail fail = (Fail) obj;
                    return Intrinsics.areEqual(this.error, fail.error) && Intrinsics.areEqual(this.urls, fail.urls);
                }

                public final WebviewError getError() {
                    return this.error;
                }

                public final List<String> getUrls() {
                    return this.urls;
                }

                public int hashCode() {
                    return (this.error.hashCode() * 31) + this.urls.hashCode();
                }

                public String toString() {
                    return "Fail(error=" + this.error + ", urls=" + this.urls + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fallback extends State {
                public static final Fallback INSTANCE = new Fallback();

                private Fallback() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends State {
                public Start() {
                    super(null);
                }
            }

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private State() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallWebviewLoad(State state, PaywallInfo paywallInfo) {
            super(new SuperwallEvent.PaywallWebviewLoadStart(paywallInfo), null);
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.state = state;
            this.paywallInfo = paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            Map mapEmptyMap;
            if (this.state instanceof State.Fail) {
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.a(TuplesKt.a("error_message", ((State.Fail) this.state).getError().toString()));
                List<String> urls = ((State.Fail) this.state).getUrls();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(urls, 10));
                int i3 = 0;
                for (Object obj : urls) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(TuplesKt.a("url_" + i3, (String) obj));
                    i3 = i4;
                }
                spreadBuilder.b(arrayList.toArray(new Pair[0]));
                mapEmptyMap = MapsKt.mapOf((Pair[]) spreadBuilder.d(new Pair[spreadBuilder.c()]));
            } else {
                mapEmptyMap = MapsKt.emptyMap();
            }
            return new HashMap(MapsKt.plus(PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null), mapEmptyMap));
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            State state = this.state;
            if (state instanceof State.Start) {
                return new SuperwallEvent.PaywallWebviewLoadStart(this.paywallInfo);
            }
            if (state instanceof State.Fail) {
                return new SuperwallEvent.PaywallWebviewLoadFail(this.paywallInfo, ((State.Fail) state).getError());
            }
            if (state instanceof State.Complete) {
                return new SuperwallEvent.PaywallWebviewLoadComplete(this.paywallInfo);
            }
            if (state instanceof State.Fallback) {
                return new SuperwallEvent.PaywallWebviewLoadFallback(this.paywallInfo);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Permission extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final String paywallIdentifier;
        private final String permissionName;
        private final State state;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class State {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ State[] $VALUES;
            public static final State Requested = new State("Requested", 0);
            public static final State Granted = new State("Granted", 1);
            public static final State Denied = new State("Denied", 2);

            private static final /* synthetic */ State[] $values() {
                return new State[]{Requested, Granted, Denied};
            }

            static {
                State[] stateArr$values = $values();
                $VALUES = stateArr$values;
                $ENTRIES = EnumEntriesKt.a(stateArr$values);
            }

            private State(String str, int i3) {
            }

            public static EnumEntries<State> getEntries() {
                return $ENTRIES;
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[State.values().length];
                try {
                    iArr[State.Requested.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[State.Granted.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[State.Denied.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Permission(State state, String permissionName, String paywallIdentifier) {
            super(new SuperwallEvent.PermissionRequested(permissionName, paywallIdentifier), null);
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            this.state = state;
            this.permissionName = permissionName;
            this.paywallIdentifier = paywallIdentifier;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ Permission copy$default(Permission permission, State state, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                state = permission.state;
            }
            if ((i3 & 2) != 0) {
                str = permission.permissionName;
            }
            if ((i3 & 4) != 0) {
                str2 = permission.paywallIdentifier;
            }
            return permission.copy(state, str, str2);
        }

        public final State component1() {
            return this.state;
        }

        public final String component2() {
            return this.permissionName;
        }

        public final String component3() {
            return this.paywallIdentifier;
        }

        public final Permission copy(State state, String permissionName, String paywallIdentifier) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            return new Permission(state, permissionName, paywallIdentifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Permission)) {
                return false;
            }
            Permission permission = (Permission) obj;
            return this.state == permission.state && Intrinsics.areEqual(this.permissionName, permission.permissionName) && Intrinsics.areEqual(this.paywallIdentifier, permission.paywallIdentifier);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final String getPermissionName() {
            return this.permissionName;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.mapOf(TuplesKt.a("permission_name", this.permissionName), TuplesKt.a("paywall_identifier", this.paywallIdentifier));
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i3 == 1) {
                return new SuperwallEvent.PermissionRequested(this.permissionName, this.paywallIdentifier);
            }
            if (i3 == 2) {
                return new SuperwallEvent.PermissionGranted(this.permissionName, this.paywallIdentifier);
            }
            if (i3 == 3) {
                return new SuperwallEvent.PermissionDenied(this.permissionName, this.paywallIdentifier);
            }
            throw new NoWhenBranchMatchedException();
        }

        public int hashCode() {
            return (((this.state.hashCode() * 31) + this.permissionName.hashCode()) * 31) + this.paywallIdentifier.hashCode();
        }

        public String toString() {
            return "Permission(state=" + this.state + ", permissionName=" + this.permissionName + ", paywallIdentifier=" + this.paywallIdentifier + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PresentationRequest extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;
        private final EventData eventData;
        private final Factory factory;
        private final PaywallPresentationRequestStatus status;
        private final PaywallPresentationRequestStatusReason statusReason;
        private final PresentationRequestType type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public interface Factory extends RuleAttributesFactory, FeatureFlagsFactory, ComputedPropertyRequestsFactory {
        }

        public /* synthetic */ PresentationRequest(EventData eventData, PresentationRequestType presentationRequestType, PaywallPresentationRequestStatus paywallPresentationRequestStatus, PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason, Factory factory, HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(eventData, presentationRequestType, paywallPresentationRequestStatus, paywallPresentationRequestStatusReason, factory, (i3 & 32) != 0 ? new HashMap() : map);
        }

        public final EventData getEventData() {
            return this.eventData;
        }

        public final Factory getFactory() {
            return this.factory;
        }

        public final PaywallPresentationRequestStatus getStatus() {
            return this.status;
        }

        public final PaywallPresentationRequestStatusReason getStatusReason() {
            return this.statusReason;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            String name;
            String description;
            EventData eventData = this.eventData;
            String str = "";
            if (eventData == null || (name = eventData.getName()) == null) {
                name = "";
            }
            Pair pairA = TuplesKt.a("source_event_name", name);
            Pair pairA2 = TuplesKt.a("pipeline_type", this.type.getDescription());
            Pair pairA3 = TuplesKt.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.status.getStatus());
            PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason = this.statusReason;
            if (paywallPresentationRequestStatusReason != null && (description = paywallPresentationRequestStatusReason.getDescription()) != null) {
                str = description;
            }
            return MapsKt.hashMapOf(pairA, pairA2, pairA3, TuplesKt.a("status_reason", str));
        }

        public final PresentationRequestType getType() {
            return this.type;
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PresentationRequest(EventData eventData, PresentationRequestType type, PaywallPresentationRequestStatus status, PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason, Factory factory, HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.PaywallPresentationRequest(status, paywallPresentationRequestStatusReason), null);
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.eventData = eventData;
            this.type = type;
            this.status = status;
            this.statusReason = paywallPresentationRequestStatusReason;
            this.factory = factory;
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Redemptions extends InternalSuperwallEvent {
        private final RedemptionState state;
        private final WebPaywallRedeemer.RedeemType type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class RedemptionState {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends RedemptionState {
                public static final Complete INSTANCE = new Complete();

                private Complete() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fail extends RedemptionState {
                public static final Fail INSTANCE = new Fail();

                private Fail() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends RedemptionState {
                public static final Start INSTANCE = new Start();

                private Start() {
                    super(null);
                }
            }

            public /* synthetic */ RedemptionState(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private RedemptionState() {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Redemptions(RedemptionState state, WebPaywallRedeemer.RedeemType type) {
            SuperwallEvent superwallEvent;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(type, "type");
            if (Intrinsics.areEqual(state, RedemptionState.Start.INSTANCE)) {
                superwallEvent = SuperwallEvent.RedemptionStart.INSTANCE;
            } else if (state instanceof RedemptionState.Complete) {
                superwallEvent = SuperwallEvent.RedemptionComplete.INSTANCE;
            } else {
                if (!(state instanceof RedemptionState.Fail)) {
                    throw new NoWhenBranchMatchedException();
                }
                superwallEvent = SuperwallEvent.RedemptionFail.INSTANCE;
            }
            super(superwallEvent, null);
            this.state = state;
            this.type = type;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return MapsKt.emptyMap();
        }

        public final RedemptionState getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a("type", this.type.getDescription()));
            if (this.type.getCode() != null) {
                String code = this.type.getCode();
                Intrinsics.checkNotNull(code);
                mapMutableMapOf.put("code", code);
            }
            return MapsKt.toMap(mapMutableMapOf);
        }

        public final WebPaywallRedeemer.RedeemType getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Reset extends InternalSuperwallEvent {
        public static final Reset INSTANCE = new Reset();
        private static final Map<String, Object> audienceFilterParams = MapsKt.emptyMap();

        private Reset() {
            super(SuperwallEvent.Reset.INSTANCE, null);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Restore extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final State state;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class State {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends State {
                public static final Complete INSTANCE = new Complete();

                private Complete() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Failure extends State {
                private final String reason;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Failure(String reason) {
                    super(null);
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    this.reason = reason;
                }

                public static /* synthetic */ Failure copy$default(Failure failure, String str, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        str = failure.reason;
                    }
                    return failure.copy(str);
                }

                public final String component1() {
                    return this.reason;
                }

                public final Failure copy(String reason) {
                    Intrinsics.checkNotNullParameter(reason, "reason");
                    return new Failure(reason);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Failure) && Intrinsics.areEqual(this.reason, ((Failure) obj).reason);
                }

                public final String getReason() {
                    return this.reason;
                }

                public int hashCode() {
                    return this.reason.hashCode();
                }

                public String toString() {
                    return "Failure(reason=" + this.reason + ")";
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends State {
                public static final Start INSTANCE = new Start();

                private Start() {
                    super(null);
                }
            }

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private State() {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Restore(State state, PaywallInfo paywallInfo) {
            SuperwallEvent fail;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            if (state instanceof State.Complete) {
                fail = SuperwallEvent.Restore.Complete.INSTANCE;
            } else if (state instanceof State.Failure) {
                fail = new SuperwallEvent.Restore.Fail(((State.Failure) state).getReason());
            } else {
                if (!(state instanceof State.Start)) {
                    throw new NoWhenBranchMatchedException();
                }
                fail = SuperwallEvent.Restore.Start.INSTANCE;
            }
            super(fail, null);
            this.state = state;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ Restore copy$default(Restore restore, State state, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                state = restore.state;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = restore.paywallInfo;
            }
            return restore.copy(state, paywallInfo);
        }

        public final State component1() {
            return this.state;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final Restore copy(State state, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new Restore(state, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Restore)) {
                return false;
            }
            Restore restore = (Restore) obj;
            return Intrinsics.areEqual(this.state, restore.state) && Intrinsics.areEqual(this.paywallInfo, restore.paywallInfo);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            Map mapEventParams$default = PaywallInfo.eventParams$default(this.paywallInfo, null, null, 3, null);
            State state = this.state;
            return state instanceof State.Failure ? MapsKt.plus(mapEventParams$default, MapsKt.mapOf(TuplesKt.a("error_message", ((State.Failure) state).getReason()))) : mapEventParams$default;
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "Restore(state=" + this.state + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReviewRequested extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final int count;
        private final String type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReviewRequested(int i3, String type) {
            super(new SuperwallEvent.ReviewRequested(i3), null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.count = i3;
            this.type = type;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final int getCount() {
            return this.count;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return MapsKt.hashMapOf(TuplesKt.a("count", Boxing.d(this.count)), TuplesKt.a("type", this.type));
        }

        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SessionStart extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public SessionStart() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap();
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        public /* synthetic */ SessionStart(HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionStart(HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.SessionStart(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShimmerLoad extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final boolean canImplicitlyTriggerPaywall;
        private final double delay;
        private final String paywallId;
        private final boolean preloadingEnabled;
        private final State state;
        private final Double visibleDuration;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class State {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ State[] $VALUES;
            public static final State Started = new State("Started", 0);
            public static final State Complete = new State("Complete", 1);

            private static final /* synthetic */ State[] $values() {
                return new State[]{Started, Complete};
            }

            static {
                State[] stateArr$values = $values();
                $VALUES = stateArr$values;
                $ENTRIES = EnumEntriesKt.a(stateArr$values);
            }

            private State(String str, int i3) {
            }

            public static EnumEntries<State> getEntries() {
                return $ENTRIES;
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public ShimmerLoad(State state, String paywallId, Double d3, double d4, boolean z2) {
            SuperwallEvent shimmerViewComplete;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallId, "paywallId");
            if (state == State.Started) {
                shimmerViewComplete = SuperwallEvent.ShimmerViewStart.INSTANCE;
            } else {
                shimmerViewComplete = new SuperwallEvent.ShimmerViewComplete(d3 != null ? d3.doubleValue() : 0.0d);
            }
            super(shimmerViewComplete, null);
            this.state = state;
            this.paywallId = paywallId;
            this.visibleDuration = d3;
            this.delay = d4;
            this.preloadingEnabled = z2;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ ShimmerLoad copy$default(ShimmerLoad shimmerLoad, State state, String str, Double d3, double d4, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                state = shimmerLoad.state;
            }
            if ((i3 & 2) != 0) {
                str = shimmerLoad.paywallId;
            }
            if ((i3 & 4) != 0) {
                d3 = shimmerLoad.visibleDuration;
            }
            if ((i3 & 8) != 0) {
                d4 = shimmerLoad.delay;
            }
            if ((i3 & 16) != 0) {
                z2 = shimmerLoad.preloadingEnabled;
            }
            boolean z3 = z2;
            Double d5 = d3;
            return shimmerLoad.copy(state, str, d5, d4, z3);
        }

        public final State component1() {
            return this.state;
        }

        public final String component2() {
            return this.paywallId;
        }

        public final Double component3() {
            return this.visibleDuration;
        }

        public final double component4() {
            return this.delay;
        }

        public final boolean component5() {
            return this.preloadingEnabled;
        }

        public final ShimmerLoad copy(State state, String paywallId, Double d3, double d4, boolean z2) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallId, "paywallId");
            return new ShimmerLoad(state, paywallId, d3, d4, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ShimmerLoad)) {
                return false;
            }
            ShimmerLoad shimmerLoad = (ShimmerLoad) obj;
            return this.state == shimmerLoad.state && Intrinsics.areEqual(this.paywallId, shimmerLoad.paywallId) && Intrinsics.areEqual((Object) this.visibleDuration, (Object) shimmerLoad.visibleDuration) && Double.compare(this.delay, shimmerLoad.delay) == 0 && this.preloadingEnabled == shimmerLoad.preloadingEnabled;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.Trackable
        public boolean getCanImplicitlyTriggerPaywall() {
            return this.canImplicitlyTriggerPaywall;
        }

        public final double getDelay() {
            return this.delay;
        }

        public final String getPaywallId() {
            return this.paywallId;
        }

        public final boolean getPreloadingEnabled() {
            return this.preloadingEnabled;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.Trackable
        public String getRawName() {
            return getSuperwallPlacement().getRawName();
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            Map mapMapOf = MapsKt.mapOf(TuplesKt.a("paywall_id", this.paywallId), TuplesKt.a("preloading_enabled", Boxing.a(this.preloadingEnabled)), TuplesKt.a("visible_duration", this.visibleDuration), TuplesKt.a("unit", "ms"));
            ArrayList arrayList = new ArrayList(mapMapOf.size());
            for (Map.Entry entry : mapMapOf.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                arrayList.add(value != null ? TuplesKt.a(str, value) : null);
            }
            return MapsKt.toMap(CollectionsKt.filterNotNull(arrayList));
        }

        public final Double getVisibleDuration() {
            return this.visibleDuration;
        }

        public int hashCode() {
            int iHashCode = ((this.state.hashCode() * 31) + this.paywallId.hashCode()) * 31;
            Double d3 = this.visibleDuration;
            return ((((iHashCode + (d3 == null ? 0 : d3.hashCode())) * 31) + Double.hashCode(this.delay)) * 31) + Boolean.hashCode(this.preloadingEnabled);
        }

        public String toString() {
            return "ShimmerLoad(state=" + this.state + ", paywallId=" + this.paywallId + ", visibleDuration=" + this.visibleDuration + ", delay=" + this.delay + ", preloadingEnabled=" + this.preloadingEnabled + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionStart extends InternalSuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubscriptionStart(PaywallInfo paywallInfo, StoreProduct product) {
            super(new SuperwallEvent.SubscriptionStart(product, paywallInfo), null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(product, "product");
            this.paywallInfo = paywallInfo;
            this.product = product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.paywallInfo.audienceFilterParams();
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            return new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, this.product, null, 2, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionStatusDidChange extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;
        private final SubscriptionStatus subscriptionStatus;

        public /* synthetic */ SubscriptionStatusDidChange(SubscriptionStatus subscriptionStatus, HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(subscriptionStatus, (i3 & 2) != 0 ? new HashMap() : map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence getSuperwallParameters$lambda$1$lambda$0(Entitlement it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getId();
        }

        public final SubscriptionStatus getSubscriptionStatus() {
            return this.subscriptionStatus;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            String str;
            SubscriptionStatus subscriptionStatus = this.subscriptionStatus;
            if (subscriptionStatus instanceof SubscriptionStatus.Active) {
                str = "active";
            } else if (subscriptionStatus instanceof SubscriptionStatus.Inactive) {
                str = "inactive";
            } else {
                if (!(subscriptionStatus instanceof SubscriptionStatus.Unknown)) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "unknown";
            }
            HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.a("subscription_status", str));
            SubscriptionStatus subscriptionStatus2 = this.subscriptionStatus;
            if (subscriptionStatus2 instanceof SubscriptionStatus.Active) {
                mapHashMapOf.put("active_entitlement_ids", CollectionsKt.joinToString$default(((SubscriptionStatus.Active) subscriptionStatus2).getEntitlements(), ",", null, null, 0, null, new Function1() { // from class: com.superwall.sdk.analytics.internal.trackable.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return InternalSuperwallEvent.SubscriptionStatusDidChange.getSuperwallParameters$lambda$1$lambda$0((Entitlement) obj);
                    }
                }, 30, null));
            }
            return mapHashMapOf;
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubscriptionStatusDidChange(SubscriptionStatus subscriptionStatus, HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.SubscriptionStatusDidChange(), null);
            Intrinsics.checkNotNullParameter(subscriptionStatus, "subscriptionStatus");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.subscriptionStatus = subscriptionStatus;
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SurveyClose extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;

        /* JADX WARN: Multi-variable type inference failed */
        public SurveyClose() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.emptyMap();
        }

        public /* synthetic */ SurveyClose(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new LinkedHashMap() : map);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SurveyClose(Map<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.SurveyClose(), null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SurveyResponse extends InternalSuperwallEvent {
        private final String customResponse;
        private final PaywallInfo paywallInfo;
        private final SurveyOption selectedOption;
        private final Survey survey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SurveyResponse(Survey survey, SurveyOption selectedOption, String str, PaywallInfo paywallInfo) {
            super(new SuperwallEvent.SurveyResponse(survey, selectedOption, str, paywallInfo), null);
            Intrinsics.checkNotNullParameter(survey, "survey");
            Intrinsics.checkNotNullParameter(selectedOption, "selectedOption");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.survey = survey;
            this.selectedOption = selectedOption;
            this.customResponse = str;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ SurveyResponse copy$default(SurveyResponse surveyResponse, Survey survey, SurveyOption surveyOption, String str, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                survey = surveyResponse.survey;
            }
            if ((i3 & 2) != 0) {
                surveyOption = surveyResponse.selectedOption;
            }
            if ((i3 & 4) != 0) {
                str = surveyResponse.customResponse;
            }
            if ((i3 & 8) != 0) {
                paywallInfo = surveyResponse.paywallInfo;
            }
            return surveyResponse.copy(survey, surveyOption, str, paywallInfo);
        }

        public final Survey component1() {
            return this.survey;
        }

        public final SurveyOption component2() {
            return this.selectedOption;
        }

        public final String component3() {
            return this.customResponse;
        }

        public final PaywallInfo component4() {
            return this.paywallInfo;
        }

        public final SurveyResponse copy(Survey survey, SurveyOption selectedOption, String str, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(survey, "survey");
            Intrinsics.checkNotNullParameter(selectedOption, "selectedOption");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new SurveyResponse(survey, selectedOption, str, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SurveyResponse)) {
                return false;
            }
            SurveyResponse surveyResponse = (SurveyResponse) obj;
            return Intrinsics.areEqual(this.survey, surveyResponse.survey) && Intrinsics.areEqual(this.selectedOption, surveyResponse.selectedOption) && Intrinsics.areEqual(this.customResponse, surveyResponse.customResponse) && Intrinsics.areEqual(this.paywallInfo, surveyResponse.paywallInfo);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            Map<String, Object> mapAudienceFilterParams = this.paywallInfo.audienceFilterParams();
            Map mapMapOf = MapsKt.mapOf(TuplesKt.a("survey_selected_option_title", this.selectedOption.getTitle()), TuplesKt.a("survey_custom_response", this.customResponse));
            ArrayList arrayList = new ArrayList(mapMapOf.size());
            for (Map.Entry entry : mapMapOf.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                arrayList.add(str2 != null ? TuplesKt.a(str, str2) : null);
            }
            return MapsKt.plus(mapAudienceFilterParams, MapsKt.toMap(CollectionsKt.filterNotNull(arrayList)));
        }

        public final String getCustomResponse() {
            return this.customResponse;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final SurveyOption getSelectedOption() {
            return this.selectedOption;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return PaywallInfo.eventParams$default(this.paywallInfo, null, MapsKt.mapOf(TuplesKt.a("survey_id", this.survey.getId()), TuplesKt.a("survey_assignment_key", this.survey.getAssignmentKey()), TuplesKt.a("survey_selected_option_id", this.selectedOption.getId())), 1, null);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            return new SuperwallEvent.SurveyResponse(this.survey, this.selectedOption, this.customResponse, this.paywallInfo);
        }

        public final Survey getSurvey() {
            return this.survey;
        }

        public int hashCode() {
            int iHashCode = ((this.survey.hashCode() * 31) + this.selectedOption.hashCode()) * 31;
            String str = this.customResponse;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "SurveyResponse(survey=" + this.survey + ", selectedOption=" + this.selectedOption + ", customResponse=" + this.customResponse + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TestModeModal extends InternalSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final State state;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class State {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ State[] $VALUES;
            public static final State Open = new State("Open", 0);
            public static final State Close = new State("Close", 1);

            private static final /* synthetic */ State[] $values() {
                return new State[]{Open, Close};
            }

            static {
                State[] stateArr$values = $values();
                $VALUES = stateArr$values;
                $ENTRIES = EnumEntriesKt.a(stateArr$values);
            }

            private State(String str, int i3) {
            }

            public static EnumEntries<State> getEntries() {
                return $ENTRIES;
            }

            public static State valueOf(String str) {
                return (State) Enum.valueOf(State.class, str);
            }

            public static State[] values() {
                return (State[]) $VALUES.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[State.values().length];
                try {
                    iArr[State.Open.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[State.Close.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TestModeModal(State state) {
            super(new SuperwallEvent.TestModeModalOpen(), null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            this.audienceFilterParams = MapsKt.emptyMap();
        }

        public static /* synthetic */ TestModeModal copy$default(TestModeModal testModeModal, State state, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                state = testModeModal.state;
            }
            return testModeModal.copy(state);
        }

        public final State component1() {
            return this.state;
        }

        public final TestModeModal copy(State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new TestModeModal(state);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TestModeModal) && this.state == ((TestModeModal) obj).state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        public final State getState() {
            return this.state;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            return MapsKt.emptyMap();
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent, com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i3 == 1) {
                return new SuperwallEvent.TestModeModalOpen();
            }
            if (i3 == 2) {
                return new SuperwallEvent.TestModeModalClose();
            }
            throw new NoWhenBranchMatchedException();
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "TestModeModal(state=" + this.state + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TriggerFire extends InternalSuperwallEvent {
        private HashMap<String, Object> audienceFilterParams;
        private final String triggerName;
        private final InternalTriggerResult triggerResult;

        public /* synthetic */ TriggerFire(InternalTriggerResult internalTriggerResult, String str, HashMap map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(internalTriggerResult, str, (i3 & 4) != 0 ? new HashMap() : map);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.a("trigger_name", this.triggerName));
            InternalTriggerResult internalTriggerResult = this.triggerResult;
            if (internalTriggerResult instanceof InternalTriggerResult.NoAudienceMatch) {
                mapHashMapOf.put("result", "no_rule_match");
                return mapHashMapOf;
            }
            if (internalTriggerResult instanceof InternalTriggerResult.Holdout) {
                mapHashMapOf.put("variant_id", ((InternalTriggerResult.Holdout) internalTriggerResult).getExperiment().getVariant().getId());
                mapHashMapOf.put("experiment_id", ((InternalTriggerResult.Holdout) this.triggerResult).getExperiment().getId());
                mapHashMapOf.put("result", "holdout");
                return mapHashMapOf;
            }
            if (!(internalTriggerResult instanceof InternalTriggerResult.Paywall)) {
                if (internalTriggerResult instanceof InternalTriggerResult.PlacementNotFound) {
                    mapHashMapOf.put("result", "eventNotFound");
                    return mapHashMapOf;
                }
                if (!(internalTriggerResult instanceof InternalTriggerResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                mapHashMapOf.put("result", "error");
                return mapHashMapOf;
            }
            mapHashMapOf.put("variant_id", ((InternalTriggerResult.Paywall) internalTriggerResult).getExperiment().getVariant().getId());
            mapHashMapOf.put("experiment_id", ((InternalTriggerResult.Paywall) this.triggerResult).getExperiment().getId());
            String paywallId = ((InternalTriggerResult.Paywall) this.triggerResult).getExperiment().getVariant().getPaywallId();
            if (paywallId == null) {
                paywallId = "";
            }
            mapHashMapOf.put("paywall_identifier", paywallId);
            mapHashMapOf.put("result", "present");
            return mapHashMapOf;
        }

        public final String getTriggerName() {
            return this.triggerName;
        }

        public final InternalTriggerResult getTriggerResult() {
            return this.triggerResult;
        }

        public void setAudienceFilterParams(HashMap<String, Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.audienceFilterParams = map;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public HashMap<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TriggerFire(InternalTriggerResult triggerResult, String triggerName, HashMap<String, Object> audienceFilterParams) {
            super(new SuperwallEvent.TriggerFire(triggerName, triggerResult.toPublicType()), null);
            Intrinsics.checkNotNullParameter(triggerResult, "triggerResult");
            Intrinsics.checkNotNullParameter(triggerName, "triggerName");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.triggerResult = triggerResult;
            this.triggerName = triggerName;
            this.audienceFilterParams = audienceFilterParams;
        }
    }

    public /* synthetic */ InternalSuperwallEvent(SuperwallEvent superwallEvent, DefaultConstructorMarker defaultConstructorMarker) {
        this(superwallEvent);
    }

    @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
    public boolean getCanImplicitlyTriggerPaywall() {
        return getSuperwallPlacement().getCanImplicitlyTriggerPaywall();
    }

    @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
    public String getRawName() {
        return getSuperwallPlacement().getRawName();
    }

    @Override // com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
    public SuperwallEvent getSuperwallPlacement() {
        return this.superwallPlacement;
    }

    private InternalSuperwallEvent(SuperwallEvent superwallEvent) {
        this.superwallPlacement = superwallEvent;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomerInfoDidChange implements TrackableSuperwallEvent {
        private final Map<String, Object> audienceFilterParams;
        private final boolean canImplicitlyTriggerPaywall;
        private final CustomerInfo fromCustomerInfo;
        private final String rawName;
        private final SuperwallEvent superwallPlacement;
        private final CustomerInfo toCustomerInfo;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        static final class EntitlementsSnapshot {
            private final List<Entitlement> entitlements;
            private final boolean isPlaceholder;
            public static final Companion Companion = new Companion(null);
            private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Entitlement$$serializer.INSTANCE), null};

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<EntitlementsSnapshot> serializer() {
                    return InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ EntitlementsSnapshot(int i3, List list, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i3 & 3)) {
                    PluginExceptionsKt.b(i3, 3, InternalSuperwallEvent$CustomerInfoDidChange$EntitlementsSnapshot$$serializer.INSTANCE.getDescriptor());
                }
                this.entitlements = list;
                this.isPlaceholder = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EntitlementsSnapshot copy$default(EntitlementsSnapshot entitlementsSnapshot, List list, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    list = entitlementsSnapshot.entitlements;
                }
                if ((i3 & 2) != 0) {
                    z2 = entitlementsSnapshot.isPlaceholder;
                }
                return entitlementsSnapshot.copy(list, z2);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(EntitlementsSnapshot entitlementsSnapshot, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], entitlementsSnapshot.entitlements);
                compositeEncoder.x(serialDescriptor, 1, entitlementsSnapshot.isPlaceholder);
            }

            public final List<Entitlement> component1() {
                return this.entitlements;
            }

            public final boolean component2() {
                return this.isPlaceholder;
            }

            public final EntitlementsSnapshot copy(List<Entitlement> entitlements, boolean z2) {
                Intrinsics.checkNotNullParameter(entitlements, "entitlements");
                return new EntitlementsSnapshot(entitlements, z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof EntitlementsSnapshot)) {
                    return false;
                }
                EntitlementsSnapshot entitlementsSnapshot = (EntitlementsSnapshot) obj;
                return Intrinsics.areEqual(this.entitlements, entitlementsSnapshot.entitlements) && this.isPlaceholder == entitlementsSnapshot.isPlaceholder;
            }

            public final List<Entitlement> getEntitlements() {
                return this.entitlements;
            }

            public int hashCode() {
                return (this.entitlements.hashCode() * 31) + Boolean.hashCode(this.isPlaceholder);
            }

            public final boolean isPlaceholder() {
                return this.isPlaceholder;
            }

            public String toString() {
                return "EntitlementsSnapshot(entitlements=" + this.entitlements + ", isPlaceholder=" + this.isPlaceholder + ")";
            }

            public EntitlementsSnapshot(List<Entitlement> entitlements, boolean z2) {
                Intrinsics.checkNotNullParameter(entitlements, "entitlements");
                this.entitlements = entitlements;
                this.isPlaceholder = z2;
            }
        }

        public CustomerInfoDidChange(CustomerInfo fromCustomerInfo, CustomerInfo toCustomerInfo, Map<String, ? extends Object> audienceFilterParams) {
            Intrinsics.checkNotNullParameter(fromCustomerInfo, "fromCustomerInfo");
            Intrinsics.checkNotNullParameter(toCustomerInfo, "toCustomerInfo");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.fromCustomerInfo = fromCustomerInfo;
            this.toCustomerInfo = toCustomerInfo;
            this.audienceFilterParams = audienceFilterParams;
            this.superwallPlacement = new SuperwallEvent.CustomerInfoDidChange(fromCustomerInfo, toCustomerInfo);
            this.rawName = new SuperwallEvent.CustomerInfoDidChange(fromCustomerInfo, toCustomerInfo).getRawName();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomerInfoDidChange copy$default(CustomerInfoDidChange customerInfoDidChange, CustomerInfo customerInfo, CustomerInfo customerInfo2, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                customerInfo = customerInfoDidChange.fromCustomerInfo;
            }
            if ((i3 & 2) != 0) {
                customerInfo2 = customerInfoDidChange.toCustomerInfo;
            }
            if ((i3 & 4) != 0) {
                map = customerInfoDidChange.audienceFilterParams;
            }
            return customerInfoDidChange.copy(customerInfo, customerInfo2, map);
        }

        public final CustomerInfo component1() {
            return this.fromCustomerInfo;
        }

        public final CustomerInfo component2() {
            return this.toCustomerInfo;
        }

        public final Map<String, Object> component3() {
            return this.audienceFilterParams;
        }

        public final CustomerInfoDidChange copy(CustomerInfo fromCustomerInfo, CustomerInfo toCustomerInfo, Map<String, ? extends Object> audienceFilterParams) {
            Intrinsics.checkNotNullParameter(fromCustomerInfo, "fromCustomerInfo");
            Intrinsics.checkNotNullParameter(toCustomerInfo, "toCustomerInfo");
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            return new CustomerInfoDidChange(fromCustomerInfo, toCustomerInfo, audienceFilterParams);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomerInfoDidChange)) {
                return false;
            }
            CustomerInfoDidChange customerInfoDidChange = (CustomerInfoDidChange) obj;
            return Intrinsics.areEqual(this.fromCustomerInfo, customerInfoDidChange.fromCustomerInfo) && Intrinsics.areEqual(this.toCustomerInfo, customerInfoDidChange.toCustomerInfo) && Intrinsics.areEqual(this.audienceFilterParams, customerInfoDidChange.audienceFilterParams);
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public boolean getCanImplicitlyTriggerPaywall() {
            return this.canImplicitlyTriggerPaywall;
        }

        public final CustomerInfo getFromCustomerInfo() {
            return this.fromCustomerInfo;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public String getRawName() {
            return this.rawName;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super Map<String, ? extends Object>> continuation) {
            String strB;
            String strB2 = JsonUtils.EMPTY_JSON;
            EntitlementsSnapshot entitlementsSnapshot = new EntitlementsSnapshot(this.fromCustomerInfo.getEntitlements(), this.fromCustomerInfo.isPlaceholder$superwall_release());
            EntitlementsSnapshot entitlementsSnapshot2 = new EntitlementsSnapshot(this.toCustomerInfo.getEntitlements(), this.toCustomerInfo.isPlaceholder$superwall_release());
            try {
                Json json = JsonFactory.Companion.getJSON();
                json.a();
                strB = json.b(EntitlementsSnapshot.Companion.serializer(), entitlementsSnapshot);
            } catch (Exception e3) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.customerInfo, "Unable to serialize customer info \"from\" - " + e3.getMessage(), (Map) null, (Throwable) null, 24, (Object) null);
                strB = JsonUtils.EMPTY_JSON;
            }
            try {
                Json json2 = JsonFactory.Companion.getJSON();
                json2.a();
                strB2 = json2.b(EntitlementsSnapshot.Companion.serializer(), entitlementsSnapshot2);
            } catch (Exception e4) {
                Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.customerInfo, "Unable to serialize customer info \"to\" - " + e4.getMessage(), (Map) null, (Throwable) null, 24, (Object) null);
            }
            return MapsKt.mapOf(TuplesKt.a("from", strB), TuplesKt.a("to", strB2));
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            return this.superwallPlacement;
        }

        public final CustomerInfo getToCustomerInfo() {
            return this.toCustomerInfo;
        }

        public int hashCode() {
            return (((this.fromCustomerInfo.hashCode() * 31) + this.toCustomerInfo.hashCode()) * 31) + this.audienceFilterParams.hashCode();
        }

        public String toString() {
            return "CustomerInfoDidChange(fromCustomerInfo=" + this.fromCustomerInfo + ", toCustomerInfo=" + this.toCustomerInfo + ", audienceFilterParams=" + this.audienceFilterParams + ")";
        }

        public /* synthetic */ CustomerInfoDidChange(CustomerInfo customerInfo, CustomerInfo customerInfo2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(customerInfo, customerInfo2, (i3 & 4) != 0 ? MapsKt.emptyMap() : map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Transaction implements TrackableSuperwallEvent {
        private Integer demandScore;
        private String demandTier;
        private final boolean isObserved;
        private final StoreTransaction model;
        private final PaywallInfo paywallInfo;
        private final StoreProductType product;
        private final TransactionSource source;
        private final State state;
        private String store;
        private final String storefrontCountryCode;
        private Map<String, ? extends Object> userAttributes;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static abstract class State {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Abandon extends State {
                private final StoreProductType product;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Abandon(StoreProductType product) {
                    super(null);
                    Intrinsics.checkNotNullParameter(product, "product");
                    this.product = product;
                }

                public final StoreProductType getProduct() {
                    return this.product;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Complete extends State {
                private final StoreProductType product;
                private final StoreTransactionType transaction;

                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[SubscriptionPeriod.Unit.values().length];
                        try {
                            iArr[SubscriptionPeriod.Unit.day.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[SubscriptionPeriod.Unit.week.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[SubscriptionPeriod.Unit.month.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[SubscriptionPeriod.Unit.year.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: Illegal instructions before constructor call */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r13v0, types: [java.util.Date] */
                /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
                /* JADX WARN: Type inference failed for: r3v2 */
                /* JADX WARN: Type inference failed for: r3v6 */
                /* JADX WARN: Type inference failed for: r3v7 */
                public Complete(StoreProductType product, StoreTransactionType storeTransactionType) {
                    StoreTransactionType storeTransactionTypeCopy$default;
                    SubscriptionPeriod subscriptionPeriod;
                    Intrinsics.checkNotNullParameter(product, "product");
                    ?? time = 0;
                    time = 0;
                    super(time);
                    this.product = product;
                    if (storeTransactionType instanceof GoogleBillingPurchaseTransaction) {
                        RawStoreProduct rawStoreProduct = product instanceof RawStoreProduct ? (RawStoreProduct) product : null;
                        if (rawStoreProduct == null) {
                            storeTransactionTypeCopy$default = (GoogleBillingPurchaseTransaction) storeTransactionType;
                        } else {
                            GoogleBillingPurchaseTransaction googleBillingPurchaseTransaction = (GoogleBillingPurchaseTransaction) storeTransactionType;
                            Date transactionDate = googleBillingPurchaseTransaction.getTransactionDate();
                            if (transactionDate != null && (subscriptionPeriod = ((RawStoreProduct) product).getSubscriptionPeriod()) != null) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(transactionDate);
                                int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()];
                                if (i3 == 1) {
                                    calendar.add(6, subscriptionPeriod.getValue());
                                } else if (i3 == 2) {
                                    calendar.add(3, subscriptionPeriod.getValue());
                                } else if (i3 == 3) {
                                    calendar.add(2, subscriptionPeriod.getValue());
                                } else {
                                    if (i3 != 4) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    calendar.add(1, subscriptionPeriod.getValue());
                                }
                                time = calendar.getTime();
                            }
                            storeTransactionTypeCopy$default = GoogleBillingPurchaseTransaction.copy$default(googleBillingPurchaseTransaction, null, null, null, null, null, null, null, null, rawStoreProduct.getBasePlanId(), null, time, rawStoreProduct.getOfferId$superwall_release(), null, null, null, null, null, 127743, null);
                        }
                    } else {
                        storeTransactionTypeCopy$default = storeTransactionType;
                    }
                    this.transaction = storeTransactionTypeCopy$default;
                }

                public final StoreProductType getProduct() {
                    return this.product;
                }

                public final StoreTransactionType getTransaction() {
                    return this.transaction;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Fail extends State {
                private final TransactionError error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Fail(TransactionError error) {
                    super(null);
                    Intrinsics.checkNotNullParameter(error, "error");
                    this.error = error;
                }

                public final TransactionError getError() {
                    return this.error;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Restore extends State {
                private final RestoreType restoreType;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Restore(RestoreType restoreType) {
                    super(null);
                    Intrinsics.checkNotNullParameter(restoreType, "restoreType");
                    this.restoreType = restoreType;
                }

                public final RestoreType getRestoreType() {
                    return this.restoreType;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Start extends State {
                private final StoreProductType product;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Start(StoreProductType product) {
                    super(null);
                    Intrinsics.checkNotNullParameter(product, "product");
                    this.product = product;
                }

                public final StoreProductType getProduct() {
                    return this.product;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Timeout extends State {
                public Timeout() {
                    super(null);
                }
            }

            public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private State() {
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TransactionSource {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ TransactionSource[] $VALUES;
            private final String raw;
            public static final TransactionSource INTERNAL = new TransactionSource("INTERNAL", 0, "SUPERWALL");
            public static final TransactionSource OBSERVER = new TransactionSource("OBSERVER", 1, "OBSERVER");
            public static final TransactionSource EXTERNAL = new TransactionSource("EXTERNAL", 2, "APP");

            private static final /* synthetic */ TransactionSource[] $values() {
                return new TransactionSource[]{INTERNAL, OBSERVER, EXTERNAL};
            }

            static {
                TransactionSource[] transactionSourceArr$values = $values();
                $VALUES = transactionSourceArr$values;
                $ENTRIES = EnumEntriesKt.a(transactionSourceArr$values);
            }

            private TransactionSource(String str, int i3, String str2) {
                this.raw = str2;
            }

            public static EnumEntries<TransactionSource> getEntries() {
                return $ENTRIES;
            }

            public static TransactionSource valueOf(String str) {
                return (TransactionSource) Enum.valueOf(TransactionSource.class, str);
            }

            public static TransactionSource[] values() {
                return (TransactionSource[]) $VALUES.clone();
            }

            public final String getRaw() {
                return this.raw;
            }
        }

        public Transaction(State state, PaywallInfo paywallInfo, StoreProductType storeProductType, StoreTransaction storeTransaction, TransactionSource source, boolean z2, Integer num, String str, Map<String, ? extends Object> map, String store, String str2) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(store, "store");
            this.state = state;
            this.paywallInfo = paywallInfo;
            this.product = storeProductType;
            this.model = storeTransaction;
            this.source = source;
            this.isObserved = z2;
            this.demandScore = num;
            this.demandTier = str;
            this.userAttributes = map;
            this.store = store;
            this.storefrontCountryCode = str2;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Map<String, Object> getAudienceFilterParams() {
            String fullIdentifier;
            Map<String, Object> mapAudienceFilterParams = this.paywallInfo.audienceFilterParams();
            if (!(getSuperwallPlacement() instanceof SuperwallEvent.TransactionAbandon)) {
                return mapAudienceFilterParams;
            }
            StoreProductType storeProductType = this.product;
            if (storeProductType == null || (fullIdentifier = storeProductType.getFullIdentifier()) == null) {
                fullIdentifier = "";
            }
            return MapsKt.plus(mapAudienceFilterParams, TuplesKt.a("abandoned_product_id", fullIdentifier));
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public boolean getCanImplicitlyTriggerPaywall() {
            if (this.isObserved) {
                return false;
            }
            return getSuperwallPlacement().getCanImplicitlyTriggerPaywall();
        }

        public final Integer getDemandScore() {
            return this.demandScore;
        }

        public final String getDemandTier() {
            return this.demandTier;
        }

        public final StoreTransaction getModel() {
            return this.model;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProductType getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public String getRawName() {
            return getSuperwallPlacement().getRawName();
        }

        public final TransactionSource getSource() {
            return this.source;
        }

        public final State getState() {
            return this.state;
        }

        public final String getStore() {
            return this.store;
        }

        public final String getStorefrontCountryCode() {
            return this.storefrontCountryCode;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.Trackable
        public Object getSuperwallParameters(Continuation<? super HashMap<String, Object>> continuation) {
            Map<String, Object> dictionary;
            Map<String, Object> dictionary2;
            State state = this.state;
            if (state instanceof State.Restore) {
                HashMap map = new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, this.product, null, 2, null));
                StoreTransaction storeTransaction = this.model;
                if (storeTransaction != null && (dictionary2 = storeTransaction.toDictionary()) != null) {
                    map.putAll(dictionary2);
                }
                map.put(ProductResponseJsonKeys.STORE, this.store);
                map.put("restore_via_purchase_attempt", Boxing.a(this.model != null));
                return map;
            }
            if (!(state instanceof State.Start) && !(state instanceof State.Abandon) && !(state instanceof State.Complete) && !(state instanceof State.Timeout)) {
                if (!(state instanceof State.Fail)) {
                    throw new NoWhenBranchMatchedException();
                }
                TransactionError error = ((State.Fail) state).getError();
                if (!(error instanceof TransactionError.Failure) && !(error instanceof TransactionError.Pending)) {
                    throw new NoWhenBranchMatchedException();
                }
                HashMap map2 = new HashMap(this.paywallInfo.eventParams(this.product, MapsKt.mapOf(TuplesKt.a("message", ((State.Fail) this.state).getError().getMessage()))));
                Integer num = this.demandScore;
                if (num != null) {
                    map2.put("attr_demandScore", num);
                }
                String str = this.demandTier;
                if (str != null) {
                    map2.put("attr_demandTier", str);
                }
                map2.put(ProductResponseJsonKeys.STORE, this.store);
                return map2;
            }
            HashMap map3 = new HashMap(PaywallInfo.eventParams$default(this.paywallInfo, this.product, null, 2, null));
            StoreTransaction storeTransaction2 = this.model;
            if (storeTransaction2 != null && (dictionary = storeTransaction2.toDictionary()) != null) {
                map3.putAll(dictionary);
            }
            Integer num2 = this.demandScore;
            if (num2 != null) {
                map3.put("attr_demandScore", num2);
            }
            String str2 = this.demandTier;
            if (str2 != null) {
                map3.put("attr_demandTier", str2);
            }
            map3.put(ProductResponseJsonKeys.STORE, this.store);
            map3.put("source", this.source.getRaw());
            if (this.state instanceof State.Complete) {
                map3.put("user_attributes", this.userAttributes);
                String str3 = this.storefrontCountryCode;
                if (str3 == null) {
                    str3 = "";
                }
                map3.put("storefront_countryCode", str3);
            }
            return map3;
        }

        @Override // com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent
        public SuperwallEvent getSuperwallPlacement() {
            State state = this.state;
            if (state instanceof State.Start) {
                return new SuperwallEvent.TransactionStart(((State.Start) state).getProduct(), this.paywallInfo);
            }
            if (state instanceof State.Fail) {
                return new SuperwallEvent.TransactionFail(((State.Fail) state).getError(), this.paywallInfo);
            }
            if (state instanceof State.Abandon) {
                return new SuperwallEvent.TransactionAbandon(((State.Abandon) state).getProduct(), this.paywallInfo);
            }
            if (state instanceof State.Complete) {
                return new SuperwallEvent.TransactionComplete(((State.Complete) state).getTransaction(), ((State.Complete) this.state).getProduct(), this.paywallInfo);
            }
            if (state instanceof State.Restore) {
                return new SuperwallEvent.TransactionRestore(((State.Restore) state).getRestoreType(), this.paywallInfo);
            }
            if (state instanceof State.Timeout) {
                return new SuperwallEvent.TransactionTimeout(this.paywallInfo);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final Map<String, Object> getUserAttributes() {
            return this.userAttributes;
        }

        public final boolean isObserved() {
            return this.isObserved;
        }

        public final void setDemandScore(Integer num) {
            this.demandScore = num;
        }

        public final void setDemandTier(String str) {
            this.demandTier = str;
        }

        public final void setStore(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.store = str;
        }

        public final void setUserAttributes(Map<String, ? extends Object> map) {
            this.userAttributes = map;
        }

        public /* synthetic */ Transaction(State state, PaywallInfo paywallInfo, StoreProductType storeProductType, StoreTransaction storeTransaction, TransactionSource transactionSource, boolean z2, Integer num, String str, Map map, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, paywallInfo, storeProductType, storeTransaction, transactionSource, z2, num, str, (i3 & Function.MAX_NARGS) != 0 ? null : map, (i3 & 512) != 0 ? "PLAY_STORE" : str2, (i3 & 1024) != 0 ? null : str3);
        }
    }
}
