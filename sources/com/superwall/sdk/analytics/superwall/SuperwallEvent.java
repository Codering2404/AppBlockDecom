package com.superwall.sdk.analytics.superwall;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.superwall.sdk.config.models.Survey;
import com.superwall.sdk.config.models.SurveyOption;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.triggers.TriggerResult;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatus;
import com.superwall.sdk.paywall.presentation.internal.PaywallPresentationRequestStatusReason;
import com.superwall.sdk.paywall.view.webview.WebviewError;
import com.superwall.sdk.paywall.view.webview.messaging.PageViewData;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.store.abstractions.transactions.StoreTransactionType;
import com.superwall.sdk.store.transactions.RestoreType;
import com.superwall.sdk.store.transactions.TransactionError;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.net.URI;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.experimental.kJ.HcgZcEUYo;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class SuperwallEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppClose extends SuperwallEvent {
        public AppClose() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "app_close";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppInstall extends SuperwallEvent {
        public AppInstall() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "app_install";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppLaunch extends SuperwallEvent {
        public AppLaunch() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "app_launch";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppOpen extends SuperwallEvent {
        public AppOpen() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "app_open";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigAttributes extends SuperwallEvent {
        public static final ConfigAttributes INSTANCE = new ConfigAttributes();

        private ConfigAttributes() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "config_attributes";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigFail extends SuperwallEvent {
        public static final ConfigFail INSTANCE = new ConfigFail();

        private ConfigFail() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "config_fail";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigRefresh extends SuperwallEvent {
        public static final ConfigRefresh INSTANCE = new ConfigRefresh();

        private ConfigRefresh() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "config_refresh";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfirmAllAssignments extends SuperwallEvent {
        public static final ConfirmAllAssignments INSTANCE = new ConfirmAllAssignments();

        private ConfirmAllAssignments() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "confirm_all_assignments";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomPlacement extends SuperwallEvent {
        private final Map<String, Object> params;
        private final PaywallInfo paywallInfo;
        private final String placementName;
        private final String rawName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPlacement(String placementName, PaywallInfo paywallInfo, Map<String, ? extends Object> params) {
            super(null);
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(params, "params");
            this.placementName = placementName;
            this.paywallInfo = paywallInfo;
            this.params = params;
            this.rawName = SuperwallEvents.CustomPlacement.getRawName();
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

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final String getPlacementName() {
            return this.placementName;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return this.rawName;
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
    public static final class CustomerInfoDidChange extends SuperwallEvent {
        private final CustomerInfo from;
        private final CustomerInfo to;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerInfoDidChange(CustomerInfo from, CustomerInfo to) {
            super(null);
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
            this.from = from;
            this.to = to;
        }

        public static /* synthetic */ CustomerInfoDidChange copy$default(CustomerInfoDidChange customerInfoDidChange, CustomerInfo customerInfo, CustomerInfo customerInfo2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                customerInfo = customerInfoDidChange.from;
            }
            if ((i3 & 2) != 0) {
                customerInfo2 = customerInfoDidChange.to;
            }
            return customerInfoDidChange.copy(customerInfo, customerInfo2);
        }

        public final CustomerInfo component1() {
            return this.from;
        }

        public final CustomerInfo component2() {
            return this.to;
        }

        public final CustomerInfoDidChange copy(CustomerInfo from, CustomerInfo to) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(to, "to");
            return new CustomerInfoDidChange(from, to);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomerInfoDidChange)) {
                return false;
            }
            CustomerInfoDidChange customerInfoDidChange = (CustomerInfoDidChange) obj;
            return Intrinsics.areEqual(this.from, customerInfoDidChange.from) && Intrinsics.areEqual(this.to, customerInfoDidChange.to);
        }

        public final CustomerInfo getFrom() {
            return this.from;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.CustomerInfoDidChange.getRawName();
        }

        public final CustomerInfo getTo() {
            return this.to;
        }

        public int hashCode() {
            return (this.from.hashCode() * 31) + this.to.hashCode();
        }

        public String toString() {
            return "CustomerInfoDidChange(from=" + this.from + ", to=" + this.to + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeepLink extends SuperwallEvent {
        private final URI uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeepLink(URI uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.uri = uri;
        }

        public static /* synthetic */ DeepLink copy$default(DeepLink deepLink, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = deepLink.uri;
            }
            return deepLink.copy(uri);
        }

        public final URI component1() {
            return this.uri;
        }

        public final DeepLink copy(URI uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new DeepLink(uri);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeepLink) && Intrinsics.areEqual(this.uri, ((DeepLink) obj).uri);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "deepLink_open";
        }

        public final URI getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return "DeepLink(uri=" + this.uri + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DeviceAttributes extends SuperwallEvent {
        private final Map<String, Object> attributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeviceAttributes(Map<String, ? extends Object> attributes) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.attributes = attributes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DeviceAttributes copy$default(DeviceAttributes deviceAttributes, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = deviceAttributes.attributes;
            }
            return deviceAttributes.copy(map);
        }

        public final Map<String, Object> component1() {
            return this.attributes;
        }

        public final DeviceAttributes copy(Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new DeviceAttributes(attributes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeviceAttributes) && Intrinsics.areEqual(this.attributes, ((DeviceAttributes) obj).attributes);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "device_attributes";
        }

        public int hashCode() {
            return this.attributes.hashCode();
        }

        public String toString() {
            return "DeviceAttributes(attributes=" + this.attributes + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnrichmentComplete extends SuperwallEvent {
        private final Map<String, Object> deviceEnrichment;
        private final Map<String, Object> userEnrichment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnrichmentComplete(Map<String, ? extends Object> userEnrichment, Map<String, ? extends Object> deviceEnrichment) {
            super(null);
            Intrinsics.checkNotNullParameter(userEnrichment, "userEnrichment");
            Intrinsics.checkNotNullParameter(deviceEnrichment, "deviceEnrichment");
            this.userEnrichment = userEnrichment;
            this.deviceEnrichment = deviceEnrichment;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EnrichmentComplete copy$default(EnrichmentComplete enrichmentComplete, Map map, Map map2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = enrichmentComplete.userEnrichment;
            }
            if ((i3 & 2) != 0) {
                map2 = enrichmentComplete.deviceEnrichment;
            }
            return enrichmentComplete.copy(map, map2);
        }

        public final Map<String, Object> component1() {
            return this.userEnrichment;
        }

        public final Map<String, Object> component2() {
            return this.deviceEnrichment;
        }

        public final EnrichmentComplete copy(Map<String, ? extends Object> userEnrichment, Map<String, ? extends Object> deviceEnrichment) {
            Intrinsics.checkNotNullParameter(userEnrichment, "userEnrichment");
            Intrinsics.checkNotNullParameter(deviceEnrichment, "deviceEnrichment");
            return new EnrichmentComplete(userEnrichment, deviceEnrichment);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnrichmentComplete)) {
                return false;
            }
            EnrichmentComplete enrichmentComplete = (EnrichmentComplete) obj;
            return Intrinsics.areEqual(this.userEnrichment, enrichmentComplete.userEnrichment) && Intrinsics.areEqual(this.deviceEnrichment, enrichmentComplete.deviceEnrichment);
        }

        public final Map<String, Object> getDeviceEnrichment() {
            return this.deviceEnrichment;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "enrichment_complete";
        }

        public final Map<String, Object> getUserEnrichment() {
            return this.userEnrichment;
        }

        public int hashCode() {
            return (this.userEnrichment.hashCode() * 31) + this.deviceEnrichment.hashCode();
        }

        public String toString() {
            return "EnrichmentComplete(userEnrichment=" + this.userEnrichment + ", deviceEnrichment=" + this.deviceEnrichment + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnrichmentFail extends SuperwallEvent {
        public static final EnrichmentFail INSTANCE = new EnrichmentFail();

        private EnrichmentFail() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "enrichment_fail";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class EnrichmentStart extends SuperwallEvent {
        public static final EnrichmentStart INSTANCE = new EnrichmentStart();

        private EnrichmentStart() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "enrichment_start";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ErrorThrown extends SuperwallEvent implements IsInternalEvent {
        public static final ErrorThrown INSTANCE = new ErrorThrown();

        private ErrorThrown() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "error_thrown";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ExpressionResult extends SuperwallEvent implements IsInternalEvent {
        public static final ExpressionResult INSTANCE = new ExpressionResult();

        private ExpressionResult() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "cel_expression_result";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FirstSeen extends SuperwallEvent {
        public FirstSeen() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return CustomerInfoResponseJsonKeys.FIRST_SEEN;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FreeTrialStart extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FreeTrialStart(StoreProduct product, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.product = product;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ FreeTrialStart copy$default(FreeTrialStart freeTrialStart, StoreProduct storeProduct, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeProduct = freeTrialStart.product;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = freeTrialStart.paywallInfo;
            }
            return freeTrialStart.copy(storeProduct, paywallInfo);
        }

        public final StoreProduct component1() {
            return this.product;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final FreeTrialStart copy(StoreProduct product, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new FreeTrialStart(product, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FreeTrialStart)) {
                return false;
            }
            FreeTrialStart freeTrialStart = (FreeTrialStart) obj;
            return Intrinsics.areEqual(this.product, freeTrialStart.product) && Intrinsics.areEqual(this.paywallInfo, freeTrialStart.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "freeTrial_start";
        }

        public int hashCode() {
            return (this.product.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "FreeTrialStart(product=" + this.product + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IdentityAlias extends SuperwallEvent {
        public IdentityAlias() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "identity_alias";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntegrationAttributes extends SuperwallEvent {
        private final Map<String, Object> audienceFilterParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationAttributes(Map<String, ? extends Object> audienceFilterParams) {
            super(null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IntegrationAttributes copy$default(IntegrationAttributes integrationAttributes, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = integrationAttributes.audienceFilterParams;
            }
            return integrationAttributes.copy(map);
        }

        public final Map<String, Object> component1() {
            return this.audienceFilterParams;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntegrationAttributes) && Intrinsics.areEqual(this.audienceFilterParams, ((IntegrationAttributes) obj).audienceFilterParams);
        }

        public final Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "integration_attributes";
        }

        public int hashCode() {
            return this.audienceFilterParams.hashCode();
        }

        public String toString() {
            return "IntegrationAttributes(audienceFilterParams=" + this.audienceFilterParams + ")";
        }

        public final IntegrationAttributes copy(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, HcgZcEUYo.jSdGF);
            return new IntegrationAttributes(map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    @Metadata
    public static final class IntegrationProps extends SuperwallEvent {
        private final Map<String, Object> audienceFilterParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrationProps(Map<String, ? extends Object> audienceFilterParams) {
            super(null);
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            this.audienceFilterParams = audienceFilterParams;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IntegrationProps copy$default(IntegrationProps integrationProps, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = integrationProps.audienceFilterParams;
            }
            return integrationProps.copy(map);
        }

        public final Map<String, Object> component1() {
            return this.audienceFilterParams;
        }

        public final IntegrationProps copy(Map<String, ? extends Object> audienceFilterParams) {
            Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
            return new IntegrationProps(audienceFilterParams);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntegrationProps) && Intrinsics.areEqual(this.audienceFilterParams, ((IntegrationProps) obj).audienceFilterParams);
        }

        public final Map<String, Object> getAudienceFilterParams() {
            return this.audienceFilterParams;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "integration_attributes";
        }

        public int hashCode() {
            return this.audienceFilterParams.hashCode();
        }

        public String toString() {
            return "IntegrationProps(audienceFilterParams=" + this.audienceFilterParams + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NonRecurringProductPurchase extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final TransactionProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NonRecurringProductPurchase(TransactionProduct product, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.product = product;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ NonRecurringProductPurchase copy$default(NonRecurringProductPurchase nonRecurringProductPurchase, TransactionProduct transactionProduct, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                transactionProduct = nonRecurringProductPurchase.product;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = nonRecurringProductPurchase.paywallInfo;
            }
            return nonRecurringProductPurchase.copy(transactionProduct, paywallInfo);
        }

        public final TransactionProduct component1() {
            return this.product;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final NonRecurringProductPurchase copy(TransactionProduct product, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new NonRecurringProductPurchase(product, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NonRecurringProductPurchase)) {
                return false;
            }
            NonRecurringProductPurchase nonRecurringProductPurchase = (NonRecurringProductPurchase) obj;
            return Intrinsics.areEqual(this.product, nonRecurringProductPurchase.product) && Intrinsics.areEqual(this.paywallInfo, nonRecurringProductPurchase.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final TransactionProduct getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "nonRecurringProduct_purchase";
        }

        public int hashCode() {
            return (this.product.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "NonRecurringProductPurchase(product=" + this.product + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallClose extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallClose(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallClose copy$default(PaywallClose paywallClose, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallClose.paywallInfo;
            }
            return paywallClose.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallClose copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallClose(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallClose) && Intrinsics.areEqual(this.paywallInfo, ((PaywallClose) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywall_close";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallClose(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallDecline extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallDecline(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallDecline copy$default(PaywallDecline paywallDecline, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallDecline.paywallInfo;
            }
            return paywallDecline.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallDecline copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallDecline(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallDecline) && Intrinsics.areEqual(this.paywallInfo, ((PaywallDecline) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywall_decline";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallDecline(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallOpen extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallOpen(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallOpen copy$default(PaywallOpen paywallOpen, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallOpen.paywallInfo;
            }
            return paywallOpen.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallOpen copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallOpen(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallOpen) && Intrinsics.areEqual(this.paywallInfo, ((PaywallOpen) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywall_open";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallOpen(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallPageView extends SuperwallEvent {
        private final PageViewData data;
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallPageView(PaywallInfo paywallInfo, PageViewData data) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(data, "data");
            this.paywallInfo = paywallInfo;
            this.data = data;
        }

        public static /* synthetic */ PaywallPageView copy$default(PaywallPageView paywallPageView, PaywallInfo paywallInfo, PageViewData pageViewData, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallPageView.paywallInfo;
            }
            if ((i3 & 2) != 0) {
                pageViewData = paywallPageView.data;
            }
            return paywallPageView.copy(paywallInfo, pageViewData);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PageViewData component2() {
            return this.data;
        }

        public final PaywallPageView copy(PaywallInfo paywallInfo, PageViewData data) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(data, "data");
            return new PaywallPageView(paywallInfo, data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallPageView)) {
                return false;
            }
            PaywallPageView paywallPageView = (PaywallPageView) obj;
            return Intrinsics.areEqual(this.paywallInfo, paywallPageView.paywallInfo) && Intrinsics.areEqual(this.data, paywallPageView.data);
        }

        public final PageViewData getData() {
            return this.data;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PaywallPageView.getRawName();
        }

        public int hashCode() {
            return (this.paywallInfo.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "PaywallPageView(paywallInfo=" + this.paywallInfo + ", data=" + this.data + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallPreloadComplete extends SuperwallEvent {
        private final int paywallCount;

        public PaywallPreloadComplete(int i3) {
            super(null);
            this.paywallCount = i3;
        }

        public static /* synthetic */ PaywallPreloadComplete copy$default(PaywallPreloadComplete paywallPreloadComplete, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = paywallPreloadComplete.paywallCount;
            }
            return paywallPreloadComplete.copy(i3);
        }

        public final int component1() {
            return this.paywallCount;
        }

        public final PaywallPreloadComplete copy(int i3) {
            return new PaywallPreloadComplete(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallPreloadComplete) && this.paywallCount == ((PaywallPreloadComplete) obj).paywallCount;
        }

        public final int getPaywallCount() {
            return this.paywallCount;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PaywallPreloadComplete.getRawName();
        }

        public int hashCode() {
            return Integer.hashCode(this.paywallCount);
        }

        public String toString() {
            return "PaywallPreloadComplete(paywallCount=" + this.paywallCount + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallPreloadStart extends SuperwallEvent {
        private final int paywallCount;

        public PaywallPreloadStart(int i3) {
            super(null);
            this.paywallCount = i3;
        }

        public static /* synthetic */ PaywallPreloadStart copy$default(PaywallPreloadStart paywallPreloadStart, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = paywallPreloadStart.paywallCount;
            }
            return paywallPreloadStart.copy(i3);
        }

        public final int component1() {
            return this.paywallCount;
        }

        public final PaywallPreloadStart copy(int i3) {
            return new PaywallPreloadStart(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallPreloadStart) && this.paywallCount == ((PaywallPreloadStart) obj).paywallCount;
        }

        public final int getPaywallCount() {
            return this.paywallCount;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PaywallPreloadStart.getRawName();
        }

        public int hashCode() {
            return Integer.hashCode(this.paywallCount);
        }

        public String toString() {
            return "PaywallPreloadStart(paywallCount=" + this.paywallCount + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallPresentationRequest extends SuperwallEvent {
        private final PaywallPresentationRequestStatusReason reason;
        private final PaywallPresentationRequestStatus status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallPresentationRequest(PaywallPresentationRequestStatus status, PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason) {
            super(null);
            Intrinsics.checkNotNullParameter(status, "status");
            this.status = status;
            this.reason = paywallPresentationRequestStatusReason;
        }

        public static /* synthetic */ PaywallPresentationRequest copy$default(PaywallPresentationRequest paywallPresentationRequest, PaywallPresentationRequestStatus paywallPresentationRequestStatus, PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallPresentationRequestStatus = paywallPresentationRequest.status;
            }
            if ((i3 & 2) != 0) {
                paywallPresentationRequestStatusReason = paywallPresentationRequest.reason;
            }
            return paywallPresentationRequest.copy(paywallPresentationRequestStatus, paywallPresentationRequestStatusReason);
        }

        public final PaywallPresentationRequestStatus component1() {
            return this.status;
        }

        public final PaywallPresentationRequestStatusReason component2() {
            return this.reason;
        }

        public final PaywallPresentationRequest copy(PaywallPresentationRequestStatus status, PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason) {
            Intrinsics.checkNotNullParameter(status, "status");
            return new PaywallPresentationRequest(status, paywallPresentationRequestStatusReason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallPresentationRequest)) {
                return false;
            }
            PaywallPresentationRequest paywallPresentationRequest = (PaywallPresentationRequest) obj;
            return Intrinsics.areEqual(this.status, paywallPresentationRequest.status) && Intrinsics.areEqual(this.reason, paywallPresentationRequest.reason);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallPresentationRequest";
        }

        public final PaywallPresentationRequestStatusReason getReason() {
            return this.reason;
        }

        public final PaywallPresentationRequestStatus getStatus() {
            return this.status;
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            PaywallPresentationRequestStatusReason paywallPresentationRequestStatusReason = this.reason;
            return iHashCode + (paywallPresentationRequestStatusReason == null ? 0 : paywallPresentationRequestStatusReason.hashCode());
        }

        public String toString() {
            return "PaywallPresentationRequest(status=" + this.status + ", reason=" + this.reason + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallProductsLoadComplete extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final String triggeredPlacementName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallProductsLoadComplete(String str, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.triggeredPlacementName = str;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallProductsLoadComplete copy$default(PaywallProductsLoadComplete paywallProductsLoadComplete, String str, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallProductsLoadComplete.triggeredPlacementName;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = paywallProductsLoadComplete.paywallInfo;
            }
            return paywallProductsLoadComplete.copy(str, paywallInfo);
        }

        public final String component1() {
            return this.triggeredPlacementName;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final PaywallProductsLoadComplete copy(String str, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallProductsLoadComplete(str, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallProductsLoadComplete)) {
                return false;
            }
            PaywallProductsLoadComplete paywallProductsLoadComplete = (PaywallProductsLoadComplete) obj;
            return Intrinsics.areEqual(this.triggeredPlacementName, paywallProductsLoadComplete.triggeredPlacementName) && Intrinsics.areEqual(this.paywallInfo, paywallProductsLoadComplete.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallProductsLoad_complete";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.triggeredPlacementName;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallProductsLoadComplete(triggeredPlacementName=" + this.triggeredPlacementName + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallProductsLoadFail extends SuperwallEvent {
        private final String errorMessage;
        private final PaywallInfo paywallInfo;
        private final String triggeredPlacementName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallProductsLoadFail(String str, String str2, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.errorMessage = str;
            this.triggeredPlacementName = str2;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallProductsLoadFail copy$default(PaywallProductsLoadFail paywallProductsLoadFail, String str, String str2, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallProductsLoadFail.errorMessage;
            }
            if ((i3 & 2) != 0) {
                str2 = paywallProductsLoadFail.triggeredPlacementName;
            }
            if ((i3 & 4) != 0) {
                paywallInfo = paywallProductsLoadFail.paywallInfo;
            }
            return paywallProductsLoadFail.copy(str, str2, paywallInfo);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final String component2() {
            return this.triggeredPlacementName;
        }

        public final PaywallInfo component3() {
            return this.paywallInfo;
        }

        public final PaywallProductsLoadFail copy(String str, String str2, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallProductsLoadFail(str, str2, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallProductsLoadFail)) {
                return false;
            }
            PaywallProductsLoadFail paywallProductsLoadFail = (PaywallProductsLoadFail) obj;
            return Intrinsics.areEqual(this.errorMessage, paywallProductsLoadFail.errorMessage) && Intrinsics.areEqual(this.triggeredPlacementName, paywallProductsLoadFail.triggeredPlacementName) && Intrinsics.areEqual(this.paywallInfo, paywallProductsLoadFail.paywallInfo);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallProductsLoad_fail";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.errorMessage;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.triggeredPlacementName;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallProductsLoadFail(errorMessage=" + this.errorMessage + ", triggeredPlacementName=" + this.triggeredPlacementName + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallProductsLoadStart extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final String triggeredPlacementName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallProductsLoadStart(String str, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.triggeredPlacementName = str;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallProductsLoadStart copy$default(PaywallProductsLoadStart paywallProductsLoadStart, String str, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallProductsLoadStart.triggeredPlacementName;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = paywallProductsLoadStart.paywallInfo;
            }
            return paywallProductsLoadStart.copy(str, paywallInfo);
        }

        public final String component1() {
            return this.triggeredPlacementName;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final PaywallProductsLoadStart copy(String str, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallProductsLoadStart(str, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallProductsLoadStart)) {
                return false;
            }
            PaywallProductsLoadStart paywallProductsLoadStart = (PaywallProductsLoadStart) obj;
            return Intrinsics.areEqual(this.triggeredPlacementName, paywallProductsLoadStart.triggeredPlacementName) && Intrinsics.areEqual(this.paywallInfo, paywallProductsLoadStart.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallProductsLoad_start";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.triggeredPlacementName;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallProductsLoadStart(triggeredPlacementName=" + this.triggeredPlacementName + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallResourceLoadFail extends SuperwallEvent {
        private final String error;
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallResourceLoadFail(String url, String error) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(error, "error");
            this.url = url;
            this.error = error;
        }

        public static /* synthetic */ PaywallResourceLoadFail copy$default(PaywallResourceLoadFail paywallResourceLoadFail, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallResourceLoadFail.url;
            }
            if ((i3 & 2) != 0) {
                str2 = paywallResourceLoadFail.error;
            }
            return paywallResourceLoadFail.copy(str, str2);
        }

        public final String component1() {
            return this.url;
        }

        public final String component2() {
            return this.error;
        }

        public final PaywallResourceLoadFail copy(String url, String error) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(error, "error");
            return new PaywallResourceLoadFail(url, error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallResourceLoadFail)) {
                return false;
            }
            PaywallResourceLoadFail paywallResourceLoadFail = (PaywallResourceLoadFail) obj;
            return Intrinsics.areEqual(this.url, paywallResourceLoadFail.url) && Intrinsics.areEqual(this.error, paywallResourceLoadFail.error);
        }

        public final String getError() {
            return this.error;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallResourceLoad_fail";
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            return "PaywallResourceLoadFail(url=" + this.url + ", error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallResponseLoadComplete extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final String triggeredPlacementName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallResponseLoadComplete(String str, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.triggeredPlacementName = str;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallResponseLoadComplete copy$default(PaywallResponseLoadComplete paywallResponseLoadComplete, String str, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallResponseLoadComplete.triggeredPlacementName;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = paywallResponseLoadComplete.paywallInfo;
            }
            return paywallResponseLoadComplete.copy(str, paywallInfo);
        }

        public final String component1() {
            return this.triggeredPlacementName;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final PaywallResponseLoadComplete copy(String str, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallResponseLoadComplete(str, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallResponseLoadComplete)) {
                return false;
            }
            PaywallResponseLoadComplete paywallResponseLoadComplete = (PaywallResponseLoadComplete) obj;
            return Intrinsics.areEqual(this.triggeredPlacementName, paywallResponseLoadComplete.triggeredPlacementName) && Intrinsics.areEqual(this.paywallInfo, paywallResponseLoadComplete.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallResponseLoad_complete";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.triggeredPlacementName;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallResponseLoadComplete(triggeredPlacementName=" + this.triggeredPlacementName + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallResponseLoadFail extends SuperwallEvent {
        private final String triggeredPlacementName;

        public PaywallResponseLoadFail(String str) {
            super(null);
            this.triggeredPlacementName = str;
        }

        public static /* synthetic */ PaywallResponseLoadFail copy$default(PaywallResponseLoadFail paywallResponseLoadFail, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallResponseLoadFail.triggeredPlacementName;
            }
            return paywallResponseLoadFail.copy(str);
        }

        public final String component1() {
            return this.triggeredPlacementName;
        }

        public final PaywallResponseLoadFail copy(String str) {
            return new PaywallResponseLoadFail(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallResponseLoadFail) && Intrinsics.areEqual(this.triggeredPlacementName, ((PaywallResponseLoadFail) obj).triggeredPlacementName);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallResponseLoad_fail";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.triggeredPlacementName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PaywallResponseLoadFail(triggeredPlacementName=" + this.triggeredPlacementName + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallResponseLoadNotFound extends SuperwallEvent {
        private final String triggeredPlacementName;

        public PaywallResponseLoadNotFound(String str) {
            super(null);
            this.triggeredPlacementName = str;
        }

        public static /* synthetic */ PaywallResponseLoadNotFound copy$default(PaywallResponseLoadNotFound paywallResponseLoadNotFound, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallResponseLoadNotFound.triggeredPlacementName;
            }
            return paywallResponseLoadNotFound.copy(str);
        }

        public final String component1() {
            return this.triggeredPlacementName;
        }

        public final PaywallResponseLoadNotFound copy(String str) {
            return new PaywallResponseLoadNotFound(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallResponseLoadNotFound) && Intrinsics.areEqual(this.triggeredPlacementName, ((PaywallResponseLoadNotFound) obj).triggeredPlacementName);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallResponseLoad_notFound";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.triggeredPlacementName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PaywallResponseLoadNotFound(triggeredPlacementName=" + this.triggeredPlacementName + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallResponseLoadStart extends SuperwallEvent {
        private final String triggeredPlacementName;

        public PaywallResponseLoadStart(String str) {
            super(null);
            this.triggeredPlacementName = str;
        }

        public static /* synthetic */ PaywallResponseLoadStart copy$default(PaywallResponseLoadStart paywallResponseLoadStart, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = paywallResponseLoadStart.triggeredPlacementName;
            }
            return paywallResponseLoadStart.copy(str);
        }

        public final String component1() {
            return this.triggeredPlacementName;
        }

        public final PaywallResponseLoadStart copy(String str) {
            return new PaywallResponseLoadStart(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallResponseLoadStart) && Intrinsics.areEqual(this.triggeredPlacementName, ((PaywallResponseLoadStart) obj).triggeredPlacementName);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallResponseLoad_start";
        }

        public final String getTriggeredPlacementName() {
            return this.triggeredPlacementName;
        }

        public int hashCode() {
            String str = this.triggeredPlacementName;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PaywallResponseLoadStart(triggeredPlacementName=" + this.triggeredPlacementName + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallWebviewLoadComplete extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallWebviewLoadComplete(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallWebviewLoadComplete copy$default(PaywallWebviewLoadComplete paywallWebviewLoadComplete, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallWebviewLoadComplete.paywallInfo;
            }
            return paywallWebviewLoadComplete.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallWebviewLoadComplete copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallWebviewLoadComplete(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallWebviewLoadComplete) && Intrinsics.areEqual(this.paywallInfo, ((PaywallWebviewLoadComplete) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallWebviewLoad_complete";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallWebviewLoadComplete(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallWebviewLoadFail extends SuperwallEvent {
        private final WebviewError errorMessage;
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallWebviewLoadFail(PaywallInfo paywallInfo, WebviewError webviewError) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
            this.errorMessage = webviewError;
        }

        public static /* synthetic */ PaywallWebviewLoadFail copy$default(PaywallWebviewLoadFail paywallWebviewLoadFail, PaywallInfo paywallInfo, WebviewError webviewError, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallWebviewLoadFail.paywallInfo;
            }
            if ((i3 & 2) != 0) {
                webviewError = paywallWebviewLoadFail.errorMessage;
            }
            return paywallWebviewLoadFail.copy(paywallInfo, webviewError);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final WebviewError component2() {
            return this.errorMessage;
        }

        public final PaywallWebviewLoadFail copy(PaywallInfo paywallInfo, WebviewError webviewError) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallWebviewLoadFail(paywallInfo, webviewError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallWebviewLoadFail)) {
                return false;
            }
            PaywallWebviewLoadFail paywallWebviewLoadFail = (PaywallWebviewLoadFail) obj;
            return Intrinsics.areEqual(this.paywallInfo, paywallWebviewLoadFail.paywallInfo) && Intrinsics.areEqual(this.errorMessage, paywallWebviewLoadFail.errorMessage);
        }

        public final WebviewError getErrorMessage() {
            return this.errorMessage;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallWebviewLoad_fail";
        }

        public int hashCode() {
            int iHashCode = this.paywallInfo.hashCode() * 31;
            WebviewError webviewError = this.errorMessage;
            return iHashCode + (webviewError == null ? 0 : webviewError.hashCode());
        }

        public String toString() {
            return "PaywallWebviewLoadFail(paywallInfo=" + this.paywallInfo + ", errorMessage=" + this.errorMessage + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallWebviewLoadFallback extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallWebviewLoadFallback(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallWebviewLoadFallback copy$default(PaywallWebviewLoadFallback paywallWebviewLoadFallback, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallWebviewLoadFallback.paywallInfo;
            }
            return paywallWebviewLoadFallback.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallWebviewLoadFallback copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallWebviewLoadFallback(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallWebviewLoadFallback) && Intrinsics.areEqual(this.paywallInfo, ((PaywallWebviewLoadFallback) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PaywallWebviewLoadFallback.getRawName();
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallWebviewLoadFallback(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallWebviewLoadStart extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallWebviewLoadStart(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallWebviewLoadStart copy$default(PaywallWebviewLoadStart paywallWebviewLoadStart, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallWebviewLoadStart.paywallInfo;
            }
            return paywallWebviewLoadStart.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallWebviewLoadStart copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallWebviewLoadStart(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallWebviewLoadStart) && Intrinsics.areEqual(this.paywallInfo, ((PaywallWebviewLoadStart) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallWebviewLoad_start";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallWebviewLoadStart(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    @Metadata
    public static final class PaywallWebviewLoadTimeout extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaywallWebviewLoadTimeout(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ PaywallWebviewLoadTimeout copy$default(PaywallWebviewLoadTimeout paywallWebviewLoadTimeout, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = paywallWebviewLoadTimeout.paywallInfo;
            }
            return paywallWebviewLoadTimeout.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallWebviewLoadTimeout copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new PaywallWebviewLoadTimeout(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallWebviewLoadTimeout) && Intrinsics.areEqual(this.paywallInfo, ((PaywallWebviewLoadTimeout) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "paywallWebviewLoad_timeout";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "PaywallWebviewLoadTimeout(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PermissionDenied extends SuperwallEvent {
        private final String paywallIdentifier;
        private final String permissionName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionDenied(String permissionName, String paywallIdentifier) {
            super(null);
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            this.permissionName = permissionName;
            this.paywallIdentifier = paywallIdentifier;
        }

        public static /* synthetic */ PermissionDenied copy$default(PermissionDenied permissionDenied, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = permissionDenied.permissionName;
            }
            if ((i3 & 2) != 0) {
                str2 = permissionDenied.paywallIdentifier;
            }
            return permissionDenied.copy(str, str2);
        }

        public final String component1() {
            return this.permissionName;
        }

        public final String component2() {
            return this.paywallIdentifier;
        }

        public final PermissionDenied copy(String permissionName, String paywallIdentifier) {
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            return new PermissionDenied(permissionName, paywallIdentifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionDenied)) {
                return false;
            }
            PermissionDenied permissionDenied = (PermissionDenied) obj;
            return Intrinsics.areEqual(this.permissionName, permissionDenied.permissionName) && Intrinsics.areEqual(this.paywallIdentifier, permissionDenied.paywallIdentifier);
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final String getPermissionName() {
            return this.permissionName;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PermissionDenied.getRawName();
        }

        public int hashCode() {
            return (this.permissionName.hashCode() * 31) + this.paywallIdentifier.hashCode();
        }

        public String toString() {
            return "PermissionDenied(permissionName=" + this.permissionName + ", paywallIdentifier=" + this.paywallIdentifier + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PermissionGranted extends SuperwallEvent {
        private final String paywallIdentifier;
        private final String permissionName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionGranted(String permissionName, String paywallIdentifier) {
            super(null);
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            this.permissionName = permissionName;
            this.paywallIdentifier = paywallIdentifier;
        }

        public static /* synthetic */ PermissionGranted copy$default(PermissionGranted permissionGranted, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = permissionGranted.permissionName;
            }
            if ((i3 & 2) != 0) {
                str2 = permissionGranted.paywallIdentifier;
            }
            return permissionGranted.copy(str, str2);
        }

        public final String component1() {
            return this.permissionName;
        }

        public final String component2() {
            return this.paywallIdentifier;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionGranted)) {
                return false;
            }
            PermissionGranted permissionGranted = (PermissionGranted) obj;
            return Intrinsics.areEqual(this.permissionName, permissionGranted.permissionName) && Intrinsics.areEqual(this.paywallIdentifier, permissionGranted.paywallIdentifier);
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final String getPermissionName() {
            return this.permissionName;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PermissionGranted.getRawName();
        }

        public int hashCode() {
            return (this.permissionName.hashCode() * 31) + this.paywallIdentifier.hashCode();
        }

        public String toString() {
            return "PermissionGranted(permissionName=" + this.permissionName + ", paywallIdentifier=" + this.paywallIdentifier + ")";
        }

        public final PermissionGranted copy(String permissionName, String str) {
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(str, MrGIhy.CFKiZFFnPj);
            return new PermissionGranted(permissionName, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PermissionRequested extends SuperwallEvent {
        private final String paywallIdentifier;
        private final String permissionName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PermissionRequested(String permissionName, String paywallIdentifier) {
            super(null);
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            this.permissionName = permissionName;
            this.paywallIdentifier = paywallIdentifier;
        }

        public static /* synthetic */ PermissionRequested copy$default(PermissionRequested permissionRequested, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = permissionRequested.permissionName;
            }
            if ((i3 & 2) != 0) {
                str2 = permissionRequested.paywallIdentifier;
            }
            return permissionRequested.copy(str, str2);
        }

        public final String component1() {
            return this.permissionName;
        }

        public final String component2() {
            return this.paywallIdentifier;
        }

        public final PermissionRequested copy(String permissionName, String paywallIdentifier) {
            Intrinsics.checkNotNullParameter(permissionName, "permissionName");
            Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
            return new PermissionRequested(permissionName, paywallIdentifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionRequested)) {
                return false;
            }
            PermissionRequested permissionRequested = (PermissionRequested) obj;
            return Intrinsics.areEqual(this.permissionName, permissionRequested.permissionName) && Intrinsics.areEqual(this.paywallIdentifier, permissionRequested.paywallIdentifier);
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final String getPermissionName() {
            return this.permissionName;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.PermissionRequested.getRawName();
        }

        public int hashCode() {
            return (this.permissionName.hashCode() * 31) + this.paywallIdentifier.hashCode();
        }

        public String toString() {
            return "PermissionRequested(permissionName=" + this.permissionName + ", paywallIdentifier=" + this.paywallIdentifier + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RedemptionComplete extends SuperwallEvent {
        public static final RedemptionComplete INSTANCE = new RedemptionComplete();

        private RedemptionComplete() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.RedemptionComplete.getRawName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RedemptionFail extends SuperwallEvent {
        public static final RedemptionFail INSTANCE = new RedemptionFail();

        private RedemptionFail() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.RedemptionFail.getRawName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RedemptionStart extends SuperwallEvent {
        public static final RedemptionStart INSTANCE = new RedemptionStart();

        private RedemptionStart() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.RedemptionStart.getRawName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Reset extends SuperwallEvent {
        public static final Reset INSTANCE = new Reset();

        private Reset() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "reset";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Restore extends SuperwallEvent {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Complete extends Restore {
            public static final Complete INSTANCE = new Complete();

            private Complete() {
                super(null);
            }

            @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
            public String getRawName() {
                return SuperwallEvents.RestoreComplete.getRawName();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Fail extends Restore {
            private final String reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Fail(String reason) {
                super(null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public static /* synthetic */ Fail copy$default(Fail fail, String str, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = fail.reason;
                }
                return fail.copy(str);
            }

            public final String component1() {
                return this.reason;
            }

            public final Fail copy(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new Fail(reason);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Fail) && Intrinsics.areEqual(this.reason, ((Fail) obj).reason);
            }

            @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
            public String getRawName() {
                return SuperwallEvents.RestoreFail.getRawName();
            }

            public final String getReason() {
                return this.reason;
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Fail(reason=" + this.reason + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Start extends Restore {
            public static final Start INSTANCE = new Start();

            private Start() {
                super(null);
            }

            @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
            public String getRawName() {
                return SuperwallEvents.RestoreStart.getRawName();
            }
        }

        public /* synthetic */ Restore(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Restore() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReviewDenied extends SuperwallEvent {
        private final int count;

        public ReviewDenied(int i3) {
            super(null);
            this.count = i3;
        }

        public static /* synthetic */ ReviewDenied copy$default(ReviewDenied reviewDenied, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = reviewDenied.count;
            }
            return reviewDenied.copy(i3);
        }

        public final int component1() {
            return this.count;
        }

        public final ReviewDenied copy(int i3) {
            return new ReviewDenied(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReviewDenied) && this.count == ((ReviewDenied) obj).count;
        }

        public final int getCount() {
            return this.count;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "review_denied";
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "ReviewDenied(count=" + this.count + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReviewGranted extends SuperwallEvent {
        private final int count;

        public ReviewGranted(int i3) {
            super(null);
            this.count = i3;
        }

        public static /* synthetic */ ReviewGranted copy$default(ReviewGranted reviewGranted, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = reviewGranted.count;
            }
            return reviewGranted.copy(i3);
        }

        public final int component1() {
            return this.count;
        }

        public final ReviewGranted copy(int i3) {
            return new ReviewGranted(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReviewGranted) && this.count == ((ReviewGranted) obj).count;
        }

        public final int getCount() {
            return this.count;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "review_granted";
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "ReviewGranted(count=" + this.count + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReviewRequested extends SuperwallEvent {
        private final int count;

        public ReviewRequested(int i3) {
            super(null);
            this.count = i3;
        }

        public static /* synthetic */ ReviewRequested copy$default(ReviewRequested reviewRequested, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = reviewRequested.count;
            }
            return reviewRequested.copy(i3);
        }

        public final int component1() {
            return this.count;
        }

        public final ReviewRequested copy(int i3) {
            return new ReviewRequested(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReviewRequested) && this.count == ((ReviewRequested) obj).count;
        }

        public final int getCount() {
            return this.count;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "review_requested";
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "ReviewRequested(count=" + this.count + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SessionStart extends SuperwallEvent {
        public SessionStart() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "session_start";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShimmerViewComplete extends SuperwallEvent {
        private final double duration;

        public ShimmerViewComplete(double d3) {
            super(null);
            this.duration = d3;
        }

        public static /* synthetic */ ShimmerViewComplete copy$default(ShimmerViewComplete shimmerViewComplete, double d3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                d3 = shimmerViewComplete.duration;
            }
            return shimmerViewComplete.copy(d3);
        }

        public final double component1() {
            return this.duration;
        }

        public final ShimmerViewComplete copy(double d3) {
            return new ShimmerViewComplete(d3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShimmerViewComplete) && Double.compare(this.duration, ((ShimmerViewComplete) obj).duration) == 0;
        }

        public final double getDuration() {
            return this.duration;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.ShimmerViewComplete.getRawName();
        }

        public int hashCode() {
            return Double.hashCode(this.duration);
        }

        public String toString() {
            return "ShimmerViewComplete(duration=" + this.duration + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShimmerViewStart extends SuperwallEvent {
        public static final ShimmerViewStart INSTANCE = new ShimmerViewStart();

        private ShimmerViewStart() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShimmerViewStart);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.ShimmerViewStart.getRawName();
        }

        public int hashCode() {
            return 1596588314;
        }

        public String toString() {
            return "ShimmerViewStart";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionStart extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProduct product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubscriptionStart(StoreProduct product, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.product = product;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ SubscriptionStart copy$default(SubscriptionStart subscriptionStart, StoreProduct storeProduct, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeProduct = subscriptionStart.product;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = subscriptionStart.paywallInfo;
            }
            return subscriptionStart.copy(storeProduct, paywallInfo);
        }

        public final StoreProduct component1() {
            return this.product;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final SubscriptionStart copy(StoreProduct product, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new SubscriptionStart(product, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscriptionStart)) {
                return false;
            }
            SubscriptionStart subscriptionStart = (SubscriptionStart) obj;
            return Intrinsics.areEqual(this.product, subscriptionStart.product) && Intrinsics.areEqual(this.paywallInfo, subscriptionStart.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProduct getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "subscription_start";
        }

        public int hashCode() {
            return (this.product.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "SubscriptionStart(product=" + this.product + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SubscriptionStatusDidChange extends SuperwallEvent {
        public SubscriptionStatusDidChange() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "subscriptionStatus_didChange";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SurveyClose extends SuperwallEvent {
        public SurveyClose() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "survey_close";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SurveyResponse extends SuperwallEvent {
        private final String customResponse;
        private final PaywallInfo paywallInfo;
        private final SurveyOption selectedOption;
        private final Survey survey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SurveyResponse(Survey survey, SurveyOption selectedOption, String str, PaywallInfo paywallInfo) {
            super(null);
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

        public final String getCustomResponse() {
            return this.customResponse;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "survey_response";
        }

        public final SurveyOption getSelectedOption() {
            return this.selectedOption;
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
    public static final class TestModeModalClose extends SuperwallEvent {
        public TestModeModalClose() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.TestModeModalClose.getRawName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TestModeModalOpen extends SuperwallEvent {
        public TestModeModalOpen() {
            super(null);
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return SuperwallEvents.TestModeModalOpen.getRawName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionAbandon extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProductType product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionAbandon(StoreProductType product, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.product = product;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ TransactionAbandon copy$default(TransactionAbandon transactionAbandon, StoreProductType storeProductType, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeProductType = transactionAbandon.product;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = transactionAbandon.paywallInfo;
            }
            return transactionAbandon.copy(storeProductType, paywallInfo);
        }

        public final StoreProductType component1() {
            return this.product;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final TransactionAbandon copy(StoreProductType product, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new TransactionAbandon(product, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionAbandon)) {
                return false;
            }
            TransactionAbandon transactionAbandon = (TransactionAbandon) obj;
            return Intrinsics.areEqual(this.product, transactionAbandon.product) && Intrinsics.areEqual(this.paywallInfo, transactionAbandon.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProductType getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "transaction_abandon";
        }

        public int hashCode() {
            return (this.product.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return KLAQHFCRAUejH.rEgKmoXN + this.product + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionComplete extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProductType product;
        private final StoreTransactionType transaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionComplete(StoreTransactionType storeTransactionType, StoreProductType product, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.transaction = storeTransactionType;
            this.product = product;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ TransactionComplete copy$default(TransactionComplete transactionComplete, StoreTransactionType storeTransactionType, StoreProductType storeProductType, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeTransactionType = transactionComplete.transaction;
            }
            if ((i3 & 2) != 0) {
                storeProductType = transactionComplete.product;
            }
            if ((i3 & 4) != 0) {
                paywallInfo = transactionComplete.paywallInfo;
            }
            return transactionComplete.copy(storeTransactionType, storeProductType, paywallInfo);
        }

        public final StoreTransactionType component1() {
            return this.transaction;
        }

        public final StoreProductType component2() {
            return this.product;
        }

        public final PaywallInfo component3() {
            return this.paywallInfo;
        }

        public final TransactionComplete copy(StoreTransactionType storeTransactionType, StoreProductType product, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new TransactionComplete(storeTransactionType, product, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionComplete)) {
                return false;
            }
            TransactionComplete transactionComplete = (TransactionComplete) obj;
            return Intrinsics.areEqual(this.transaction, transactionComplete.transaction) && Intrinsics.areEqual(this.product, transactionComplete.product) && Intrinsics.areEqual(this.paywallInfo, transactionComplete.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProductType getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "transaction_complete";
        }

        public final StoreTransactionType getTransaction() {
            return this.transaction;
        }

        public int hashCode() {
            StoreTransactionType storeTransactionType = this.transaction;
            return ((((storeTransactionType == null ? 0 : storeTransactionType.hashCode()) * 31) + this.product.hashCode()) * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "TransactionComplete(transaction=" + this.transaction + ", product=" + this.product + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionFail extends SuperwallEvent {
        private final TransactionError error;
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionFail(TransactionError error, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.error = error;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ TransactionFail copy$default(TransactionFail transactionFail, TransactionError transactionError, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                transactionError = transactionFail.error;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = transactionFail.paywallInfo;
            }
            return transactionFail.copy(transactionError, paywallInfo);
        }

        public final TransactionError component1() {
            return this.error;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final TransactionFail copy(TransactionError error, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new TransactionFail(error, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionFail)) {
                return false;
            }
            TransactionFail transactionFail = (TransactionFail) obj;
            return Intrinsics.areEqual(this.error, transactionFail.error) && Intrinsics.areEqual(this.paywallInfo, transactionFail.paywallInfo);
        }

        public final TransactionError getError() {
            return this.error;
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "transaction_fail";
        }

        public int hashCode() {
            return (this.error.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "TransactionFail(error=" + this.error + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionRestore extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final RestoreType restoreType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionRestore(RestoreType restoreType, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(restoreType, "restoreType");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.restoreType = restoreType;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ TransactionRestore copy$default(TransactionRestore transactionRestore, RestoreType restoreType, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                restoreType = transactionRestore.restoreType;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = transactionRestore.paywallInfo;
            }
            return transactionRestore.copy(restoreType, paywallInfo);
        }

        public final RestoreType component1() {
            return this.restoreType;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final TransactionRestore copy(RestoreType restoreType, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(restoreType, "restoreType");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new TransactionRestore(restoreType, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionRestore)) {
                return false;
            }
            TransactionRestore transactionRestore = (TransactionRestore) obj;
            return Intrinsics.areEqual(this.restoreType, transactionRestore.restoreType) && Intrinsics.areEqual(this.paywallInfo, transactionRestore.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "transaction_restore";
        }

        public final RestoreType getRestoreType() {
            return this.restoreType;
        }

        public int hashCode() {
            return (this.restoreType.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "TransactionRestore(restoreType=" + this.restoreType + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionStart extends SuperwallEvent {
        private final PaywallInfo paywallInfo;
        private final StoreProductType product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionStart(StoreProductType product, PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.product = product;
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ TransactionStart copy$default(TransactionStart transactionStart, StoreProductType storeProductType, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                storeProductType = transactionStart.product;
            }
            if ((i3 & 2) != 0) {
                paywallInfo = transactionStart.paywallInfo;
            }
            return transactionStart.copy(storeProductType, paywallInfo);
        }

        public final StoreProductType component1() {
            return this.product;
        }

        public final PaywallInfo component2() {
            return this.paywallInfo;
        }

        public final TransactionStart copy(StoreProductType product, PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new TransactionStart(product, paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransactionStart)) {
                return false;
            }
            TransactionStart transactionStart = (TransactionStart) obj;
            return Intrinsics.areEqual(this.product, transactionStart.product) && Intrinsics.areEqual(this.paywallInfo, transactionStart.paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final StoreProductType getProduct() {
            return this.product;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "transaction_start";
        }

        public int hashCode() {
            return (this.product.hashCode() * 31) + this.paywallInfo.hashCode();
        }

        public String toString() {
            return "TransactionStart(product=" + this.product + ", paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionTimeout extends SuperwallEvent {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionTimeout(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ TransactionTimeout copy$default(TransactionTimeout transactionTimeout, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = transactionTimeout.paywallInfo;
            }
            return transactionTimeout.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TransactionTimeout) && Intrinsics.areEqual(this.paywallInfo, ((TransactionTimeout) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "transaction_timeout";
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "TransactionTimeout(paywallInfo=" + this.paywallInfo + ")";
        }

        public final TransactionTimeout copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, MrGIhy.HkEiTcdYQNSYW);
            return new TransactionTimeout(paywallInfo);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TriggerFire extends SuperwallEvent {
        private final String placementName;
        private final TriggerResult result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TriggerFire(String placementName, TriggerResult result) {
            super(null);
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(result, "result");
            this.placementName = placementName;
            this.result = result;
        }

        public static /* synthetic */ TriggerFire copy$default(TriggerFire triggerFire, String str, TriggerResult triggerResult, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = triggerFire.placementName;
            }
            if ((i3 & 2) != 0) {
                triggerResult = triggerFire.result;
            }
            return triggerFire.copy(str, triggerResult);
        }

        public final String component1() {
            return this.placementName;
        }

        public final TriggerResult component2() {
            return this.result;
        }

        public final TriggerFire copy(String placementName, TriggerResult result) {
            Intrinsics.checkNotNullParameter(placementName, "placementName");
            Intrinsics.checkNotNullParameter(result, "result");
            return new TriggerFire(placementName, result);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TriggerFire)) {
                return false;
            }
            TriggerFire triggerFire = (TriggerFire) obj;
            return Intrinsics.areEqual(this.placementName, triggerFire.placementName) && Intrinsics.areEqual(this.result, triggerFire.result);
        }

        public final String getPlacementName() {
            return this.placementName;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "trigger_fire";
        }

        public final TriggerResult getResult() {
            return this.result;
        }

        public int hashCode() {
            return (this.placementName.hashCode() * 31) + this.result.hashCode();
        }

        public String toString() {
            return "TriggerFire(placementName=" + this.placementName + ", result=" + this.result + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UserAttributes extends SuperwallEvent {
        private final Map<String, Object> attributes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserAttributes(Map<String, ? extends Object> attributes) {
            super(null);
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.attributes = attributes;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserAttributes copy$default(UserAttributes userAttributes, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = userAttributes.attributes;
            }
            return userAttributes.copy(map);
        }

        public final Map<String, Object> component1() {
            return this.attributes;
        }

        public final UserAttributes copy(Map<String, ? extends Object> attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            return new UserAttributes(attributes);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserAttributes) && Intrinsics.areEqual(this.attributes, ((UserAttributes) obj).attributes);
        }

        public final Map<String, Object> getAttributes() {
            return this.attributes;
        }

        @Override // com.superwall.sdk.analytics.superwall.SuperwallEvent
        public String getRawName() {
            return "user_attributes";
        }

        public int hashCode() {
            return this.attributes.hashCode();
        }

        public String toString() {
            return "UserAttributes(attributes=" + this.attributes + ")";
        }
    }

    public /* synthetic */ SuperwallEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public SuperwallEvents getBackingEvent() {
        SuperwallEvents superwallEvents;
        SuperwallEvents[] superwallEventsArrValues = SuperwallEvents.values();
        int length = superwallEventsArrValues.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                superwallEvents = null;
                break;
            }
            superwallEvents = superwallEventsArrValues[i3];
            if (Intrinsics.areEqual(superwallEvents.getRawName(), getRawName())) {
                break;
            }
            i3++;
        }
        Intrinsics.checkNotNull(superwallEvents);
        return superwallEvents;
    }

    public final boolean getCanImplicitlyTriggerPaywall() {
        return (this instanceof AppInstall) || (this instanceof SessionStart) || (this instanceof AppLaunch) || (this instanceof DeepLink) || (this instanceof TransactionFail) || (this instanceof PaywallDecline) || (this instanceof TransactionAbandon) || (this instanceof SurveyResponse);
    }

    public String getRawName() {
        return toString();
    }

    private SuperwallEvent() {
    }
}
