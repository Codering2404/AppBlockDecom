package com.superwall.sdk.paywall.view.webview.messaging;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.superwall.sdk.models.paywall.LocalNotificationType;
import com.superwall.sdk.paywall.presentation.CustomCallbackBehavior;
import com.superwall.sdk.permissions.PermissionType;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;

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
public abstract class PaywallMessage {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BackButtonPressed extends PaywallMessage {
        public static final BackButtonPressed INSTANCE = new BackButtonPressed();

        private BackButtonPressed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close extends PaywallMessage {
        public static final Close INSTANCE = new Close();

        private Close() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Custom extends PaywallMessage {
        private final String data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public static /* synthetic */ Custom copy$default(Custom custom, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = custom.data;
            }
            return custom.copy(str);
        }

        public final String component1() {
            return this.data;
        }

        public final Custom copy(String data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new Custom(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Custom) && Intrinsics.areEqual(this.data, ((Custom) obj).data);
        }

        public final String getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "Custom(data=" + this.data + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomPlacement extends PaywallMessage {
        private final String name;
        private final JsonObject params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPlacement(String name, JsonObject params) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            this.name = name;
            this.params = params;
        }

        public static /* synthetic */ CustomPlacement copy$default(CustomPlacement customPlacement, String str, JsonObject jsonObject, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = customPlacement.name;
            }
            if ((i3 & 2) != 0) {
                jsonObject = customPlacement.params;
            }
            return customPlacement.copy(str, jsonObject);
        }

        public final String component1() {
            return this.name;
        }

        public final JsonObject component2() {
            return this.params;
        }

        public final CustomPlacement copy(String name, JsonObject params) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(params, "params");
            return new CustomPlacement(name, params);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomPlacement)) {
                return false;
            }
            CustomPlacement customPlacement = (CustomPlacement) obj;
            return Intrinsics.areEqual(this.name, customPlacement.name) && Intrinsics.areEqual(this.params, customPlacement.params);
        }

        public final String getName() {
            return this.name;
        }

        public final JsonObject getParams() {
            return this.params;
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.params.hashCode();
        }

        public String toString() {
            return "CustomPlacement(name=" + this.name + ", params=" + this.params + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HapticFeedback extends PaywallMessage {
        private final HapticType hapticType;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class HapticType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ HapticType[] $VALUES;
            public static final Companion Companion;
            private final String rawName;
            public static final HapticType LIGHT = new HapticType("LIGHT", 0, "light");
            public static final HapticType MEDIUM = new HapticType("MEDIUM", 1, "medium");
            public static final HapticType HEAVY = new HapticType("HEAVY", 2, "heavy");
            public static final HapticType SUCCESS = new HapticType("SUCCESS", 3, GraphResponse.SUCCESS_KEY);
            public static final HapticType WARNING = new HapticType("WARNING", 4, GraphRequest.DEBUG_SEVERITY_WARNING);
            public static final HapticType ERROR = new HapticType("ERROR", 5, "error");
            public static final HapticType SELECTION = new HapticType("SELECTION", 6, "selection");

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final HapticType fromRaw(String value) {
                    HapticType next;
                    Intrinsics.checkNotNullParameter(value, "value");
                    Iterator<HapticType> it = HapticType.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (Intrinsics.areEqual(next.getRawName(), value)) {
                            break;
                        }
                    }
                    return next;
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ HapticType[] $values() {
                return new HapticType[]{LIGHT, MEDIUM, HEAVY, SUCCESS, WARNING, ERROR, SELECTION};
            }

            static {
                HapticType[] hapticTypeArr$values = $values();
                $VALUES = hapticTypeArr$values;
                $ENTRIES = EnumEntriesKt.a(hapticTypeArr$values);
                Companion = new Companion(null);
            }

            private HapticType(String str, int i3, String str2) {
                this.rawName = str2;
            }

            public static EnumEntries<HapticType> getEntries() {
                return $ENTRIES;
            }

            public static HapticType valueOf(String str) {
                return (HapticType) Enum.valueOf(HapticType.class, str);
            }

            public static HapticType[] values() {
                return (HapticType[]) $VALUES.clone();
            }

            public final String getRawName() {
                return this.rawName;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HapticFeedback(HapticType hapticType) {
            super(null);
            Intrinsics.checkNotNullParameter(hapticType, "hapticType");
            this.hapticType = hapticType;
        }

        public static /* synthetic */ HapticFeedback copy$default(HapticFeedback hapticFeedback, HapticType hapticType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                hapticType = hapticFeedback.hapticType;
            }
            return hapticFeedback.copy(hapticType);
        }

        public final HapticType component1() {
            return this.hapticType;
        }

        public final HapticFeedback copy(HapticType hapticType) {
            Intrinsics.checkNotNullParameter(hapticType, "hapticType");
            return new HapticFeedback(hapticType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HapticFeedback) && this.hapticType == ((HapticFeedback) obj).hapticType;
        }

        public final HapticType getHapticType() {
            return this.hapticType;
        }

        public int hashCode() {
            return this.hapticType.hashCode();
        }

        public String toString() {
            return "HapticFeedback(hapticType=" + this.hapticType + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReady extends PaywallMessage {
        private final String paywallJsVersion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnReady(String paywallJsVersion) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallJsVersion, "paywallJsVersion");
            this.paywallJsVersion = paywallJsVersion;
        }

        public static /* synthetic */ OnReady copy$default(OnReady onReady, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = onReady.paywallJsVersion;
            }
            return onReady.copy(str);
        }

        public final String component1() {
            return this.paywallJsVersion;
        }

        public final OnReady copy(String paywallJsVersion) {
            Intrinsics.checkNotNullParameter(paywallJsVersion, "paywallJsVersion");
            return new OnReady(paywallJsVersion);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReady) && Intrinsics.areEqual(this.paywallJsVersion, ((OnReady) obj).paywallJsVersion);
        }

        public final String getPaywallJsVersion() {
            return this.paywallJsVersion;
        }

        public int hashCode() {
            return this.paywallJsVersion.hashCode();
        }

        public String toString() {
            return "OnReady(paywallJsVersion=" + this.paywallJsVersion + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenDeepLink extends PaywallMessage {
        private final URI url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenDeepLink(URI url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenDeepLink copy$default(OpenDeepLink openDeepLink, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openDeepLink.url;
            }
            return openDeepLink.copy(uri);
        }

        public final URI component1() {
            return this.url;
        }

        public final OpenDeepLink copy(URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenDeepLink(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenDeepLink) && Intrinsics.areEqual(this.url, ((OpenDeepLink) obj).url);
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenDeepLink(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenUrl extends PaywallMessage {
        private BrowserType browserType;
        private final URI url;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class BrowserType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ BrowserType[] $VALUES;
            public static final BrowserType PAYMENT_SHEET = new BrowserType("PAYMENT_SHEET", 0, "payment_sheet");
            private final String rawName;

            private static final /* synthetic */ BrowserType[] $values() {
                return new BrowserType[]{PAYMENT_SHEET};
            }

            static {
                BrowserType[] browserTypeArr$values = $values();
                $VALUES = browserTypeArr$values;
                $ENTRIES = EnumEntriesKt.a(browserTypeArr$values);
            }

            private BrowserType(String str, int i3, String str2) {
                this.rawName = str2;
            }

            public static EnumEntries<BrowserType> getEntries() {
                return $ENTRIES;
            }

            public static BrowserType valueOf(String str) {
                return (BrowserType) Enum.valueOf(BrowserType.class, str);
            }

            public static BrowserType[] values() {
                return (BrowserType[]) $VALUES.clone();
            }

            public final String getRawName() {
                return this.rawName;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenUrl(URI url, BrowserType browserType) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.browserType = browserType;
        }

        public static /* synthetic */ OpenUrl copy$default(OpenUrl openUrl, URI uri, BrowserType browserType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openUrl.url;
            }
            if ((i3 & 2) != 0) {
                browserType = openUrl.browserType;
            }
            return openUrl.copy(uri, browserType);
        }

        public final URI component1() {
            return this.url;
        }

        public final BrowserType component2() {
            return this.browserType;
        }

        public final OpenUrl copy(URI url, BrowserType browserType) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenUrl(url, browserType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenUrl)) {
                return false;
            }
            OpenUrl openUrl = (OpenUrl) obj;
            return Intrinsics.areEqual(this.url, openUrl.url) && this.browserType == openUrl.browserType;
        }

        public final BrowserType getBrowserType() {
            return this.browserType;
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = this.url.hashCode() * 31;
            BrowserType browserType = this.browserType;
            return iHashCode + (browserType == null ? 0 : browserType.hashCode());
        }

        public final void setBrowserType(BrowserType browserType) {
            this.browserType = browserType;
        }

        public String toString() {
            return "OpenUrl(url=" + this.url + ", browserType=" + this.browserType + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenUrlInBrowser extends PaywallMessage {
        private final URI url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenUrlInBrowser(URI url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenUrlInBrowser copy$default(OpenUrlInBrowser openUrlInBrowser, URI uri, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                uri = openUrlInBrowser.url;
            }
            return openUrlInBrowser.copy(uri);
        }

        public final URI component1() {
            return this.url;
        }

        public final OpenUrlInBrowser copy(URI url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenUrlInBrowser(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenUrlInBrowser) && Intrinsics.areEqual(this.url, ((OpenUrlInBrowser) obj).url);
        }

        public final URI getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenUrlInBrowser(url=" + this.url + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PageView extends PaywallMessage {
        private final PageViewData data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PageView(PageViewData data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public static /* synthetic */ PageView copy$default(PageView pageView, PageViewData pageViewData, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                pageViewData = pageView.data;
            }
            return pageView.copy(pageViewData);
        }

        public final PageViewData component1() {
            return this.data;
        }

        public final PageView copy(PageViewData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PageView(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PageView) && Intrinsics.areEqual(this.data, ((PageView) obj).data);
        }

        public final PageViewData getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "PageView(data=" + this.data + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallClose extends PaywallMessage {
        public static final PaywallClose INSTANCE = new PaywallClose();

        private PaywallClose() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PaywallOpen extends PaywallMessage {
        public static final PaywallOpen INSTANCE = new PaywallOpen();

        private PaywallOpen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Purchase extends PaywallMessage {
        private final String product;
        private final String productId;
        private final boolean shouldDismiss;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Purchase(String product, String productId, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(productId, "productId");
            this.product = product;
            this.productId = productId;
            this.shouldDismiss = z2;
        }

        public static /* synthetic */ Purchase copy$default(Purchase purchase, String str, String str2, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = purchase.product;
            }
            if ((i3 & 2) != 0) {
                str2 = purchase.productId;
            }
            if ((i3 & 4) != 0) {
                z2 = purchase.shouldDismiss;
            }
            return purchase.copy(str, str2, z2);
        }

        public final String component1() {
            return this.product;
        }

        public final String component2() {
            return this.productId;
        }

        public final boolean component3() {
            return this.shouldDismiss;
        }

        public final Purchase copy(String product, String productId, boolean z2) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(productId, "productId");
            return new Purchase(product, productId, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Purchase)) {
                return false;
            }
            Purchase purchase = (Purchase) obj;
            return Intrinsics.areEqual(this.product, purchase.product) && Intrinsics.areEqual(this.productId, purchase.productId) && this.shouldDismiss == purchase.shouldDismiss;
        }

        public final String getProduct() {
            return this.product;
        }

        public final String getProductId() {
            return this.productId;
        }

        public final boolean getShouldDismiss() {
            return this.shouldDismiss;
        }

        public int hashCode() {
            return (((this.product.hashCode() * 31) + this.productId.hashCode()) * 31) + Boolean.hashCode(this.shouldDismiss);
        }

        public String toString() {
            return "Purchase(product=" + this.product + ", productId=" + this.productId + ", shouldDismiss=" + this.shouldDismiss + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestCallback extends PaywallMessage {
        private final CustomCallbackBehavior behavior;
        private final String name;
        private final String requestId;
        private final Map<String, Object> variables;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestCallback(String requestId, String name, CustomCallbackBehavior behavior, Map<String, ? extends Object> map) {
            super(null);
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            this.requestId = requestId;
            this.name = name;
            this.behavior = behavior;
            this.variables = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestCallback copy$default(RequestCallback requestCallback, String str, String str2, CustomCallbackBehavior customCallbackBehavior, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = requestCallback.requestId;
            }
            if ((i3 & 2) != 0) {
                str2 = requestCallback.name;
            }
            if ((i3 & 4) != 0) {
                customCallbackBehavior = requestCallback.behavior;
            }
            if ((i3 & 8) != 0) {
                map = requestCallback.variables;
            }
            return requestCallback.copy(str, str2, customCallbackBehavior, map);
        }

        public final String component1() {
            return this.requestId;
        }

        public final String component2() {
            return this.name;
        }

        public final CustomCallbackBehavior component3() {
            return this.behavior;
        }

        public final Map<String, Object> component4() {
            return this.variables;
        }

        public final RequestCallback copy(String requestId, String name, CustomCallbackBehavior behavior, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            return new RequestCallback(requestId, name, behavior, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestCallback)) {
                return false;
            }
            RequestCallback requestCallback = (RequestCallback) obj;
            return Intrinsics.areEqual(this.requestId, requestCallback.requestId) && Intrinsics.areEqual(this.name, requestCallback.name) && this.behavior == requestCallback.behavior && Intrinsics.areEqual(this.variables, requestCallback.variables);
        }

        public final CustomCallbackBehavior getBehavior() {
            return this.behavior;
        }

        public final String getName() {
            return this.name;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final Map<String, Object> getVariables() {
            return this.variables;
        }

        public int hashCode() {
            int iHashCode = ((((this.requestId.hashCode() * 31) + this.name.hashCode()) * 31) + this.behavior.hashCode()) * 31;
            Map<String, Object> map = this.variables;
            return iHashCode + (map == null ? 0 : map.hashCode());
        }

        public String toString() {
            return "RequestCallback(requestId=" + this.requestId + ", name=" + this.name + ", behavior=" + this.behavior + ", variables=" + this.variables + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestPermission extends PaywallMessage {
        private final PermissionType permissionType;
        private final String requestId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestPermission(PermissionType permissionType, String requestId) {
            super(null);
            Intrinsics.checkNotNullParameter(permissionType, "permissionType");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            this.permissionType = permissionType;
            this.requestId = requestId;
        }

        public static /* synthetic */ RequestPermission copy$default(RequestPermission requestPermission, PermissionType permissionType, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                permissionType = requestPermission.permissionType;
            }
            if ((i3 & 2) != 0) {
                str = requestPermission.requestId;
            }
            return requestPermission.copy(permissionType, str);
        }

        public final PermissionType component1() {
            return this.permissionType;
        }

        public final String component2() {
            return this.requestId;
        }

        public final RequestPermission copy(PermissionType permissionType, String requestId) {
            Intrinsics.checkNotNullParameter(permissionType, "permissionType");
            Intrinsics.checkNotNullParameter(requestId, "requestId");
            return new RequestPermission(permissionType, requestId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestPermission)) {
                return false;
            }
            RequestPermission requestPermission = (RequestPermission) obj;
            return this.permissionType == requestPermission.permissionType && Intrinsics.areEqual(this.requestId, requestPermission.requestId);
        }

        public final PermissionType getPermissionType() {
            return this.permissionType;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public int hashCode() {
            return (this.permissionType.hashCode() * 31) + this.requestId.hashCode();
        }

        public String toString() {
            return "RequestPermission(permissionType=" + this.permissionType + ", requestId=" + this.requestId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RequestReview extends PaywallMessage {
        private final Type type;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Type {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;
            private final String rawName;
            public static final Type INAPP = new Type("INAPP", 0, "in-app");
            public static final Type EXTERNAL = new Type("EXTERNAL", 1, "external");

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{INAPP, EXTERNAL};
            }

            static {
                Type[] typeArr$values = $values();
                $VALUES = typeArr$values;
                $ENTRIES = EnumEntriesKt.a(typeArr$values);
            }

            private Type(String str, int i3, String str2) {
                this.rawName = str2;
            }

            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            public final String getRawName() {
                return this.rawName;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestReview(Type type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public static /* synthetic */ RequestReview copy$default(RequestReview requestReview, Type type, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                type = requestReview.type;
            }
            return requestReview.copy(type);
        }

        public final Type component1() {
            return this.type;
        }

        public final RequestReview copy(Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new RequestReview(type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RequestReview) && this.type == ((RequestReview) obj).type;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public String toString() {
            return "RequestReview(type=" + this.type + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Restore extends PaywallMessage {
        public static final Restore INSTANCE = new Restore();

        private Restore() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RestoreFailed extends PaywallMessage {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestoreFailed(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public static /* synthetic */ RestoreFailed copy$default(RestoreFailed restoreFailed, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = restoreFailed.message;
            }
            return restoreFailed.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final RestoreFailed copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new RestoreFailed(message);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RestoreFailed) && Intrinsics.areEqual(this.message, ((RestoreFailed) obj).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "RestoreFailed(message=" + this.message + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ScheduleNotification extends PaywallMessage {
        private final String body;
        private final long delay;
        private final String id;
        private final String subtitle;
        private final String title;
        private final LocalNotificationType type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScheduleNotification(String id, LocalNotificationType type, String title, String subtitle, String body, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(body, "body");
            this.id = id;
            this.type = type;
            this.title = title;
            this.subtitle = subtitle;
            this.body = body;
            this.delay = j3;
        }

        public static /* synthetic */ ScheduleNotification copy$default(ScheduleNotification scheduleNotification, String str, LocalNotificationType localNotificationType, String str2, String str3, String str4, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = scheduleNotification.id;
            }
            if ((i3 & 2) != 0) {
                localNotificationType = scheduleNotification.type;
            }
            if ((i3 & 4) != 0) {
                str2 = scheduleNotification.title;
            }
            if ((i3 & 8) != 0) {
                str3 = scheduleNotification.subtitle;
            }
            if ((i3 & 16) != 0) {
                str4 = scheduleNotification.body;
            }
            if ((i3 & 32) != 0) {
                j3 = scheduleNotification.delay;
            }
            long j4 = j3;
            String str5 = str4;
            String str6 = str2;
            return scheduleNotification.copy(str, localNotificationType, str6, str3, str5, j4);
        }

        public final String component1() {
            return this.id;
        }

        public final LocalNotificationType component2() {
            return this.type;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.subtitle;
        }

        public final String component5() {
            return this.body;
        }

        public final long component6() {
            return this.delay;
        }

        public final ScheduleNotification copy(String id, LocalNotificationType type, String title, String subtitle, String body, long j3) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics.checkNotNullParameter(body, "body");
            return new ScheduleNotification(id, type, title, subtitle, body, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ScheduleNotification)) {
                return false;
            }
            ScheduleNotification scheduleNotification = (ScheduleNotification) obj;
            return Intrinsics.areEqual(this.id, scheduleNotification.id) && Intrinsics.areEqual(this.type, scheduleNotification.type) && Intrinsics.areEqual(this.title, scheduleNotification.title) && Intrinsics.areEqual(this.subtitle, scheduleNotification.subtitle) && Intrinsics.areEqual(this.body, scheduleNotification.body) && this.delay == scheduleNotification.delay;
        }

        public final String getBody() {
            return this.body;
        }

        public final long getDelay() {
            return this.delay;
        }

        public final String getId() {
            return this.id;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTitle() {
            return this.title;
        }

        public final LocalNotificationType getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.body.hashCode()) * 31) + Long.hashCode(this.delay);
        }

        public String toString() {
            return "ScheduleNotification(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", subtitle=" + this.subtitle + ", body=" + this.body + ", delay=" + this.delay + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TemplateParamsAndUserAttributes extends PaywallMessage {
        public static final TemplateParamsAndUserAttributes INSTANCE = new TemplateParamsAndUserAttributes();

        private TemplateParamsAndUserAttributes() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionAbandon extends PaywallMessage {
        public static final TransactionAbandon INSTANCE = new TransactionAbandon();

        private TransactionAbandon() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionComplete extends PaywallMessage {
        private final String productIdentifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TransactionComplete(String productIdentifier) {
            super(null);
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            this.productIdentifier = productIdentifier;
        }

        public static /* synthetic */ TransactionComplete copy$default(TransactionComplete transactionComplete, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = transactionComplete.productIdentifier;
            }
            return transactionComplete.copy(str);
        }

        public final String component1() {
            return this.productIdentifier;
        }

        public final TransactionComplete copy(String productIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            return new TransactionComplete(productIdentifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TransactionComplete) && Intrinsics.areEqual(this.productIdentifier, ((TransactionComplete) obj).productIdentifier);
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public int hashCode() {
            return this.productIdentifier.hashCode();
        }

        public String toString() {
            return "TransactionComplete(productIdentifier=" + this.productIdentifier + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TransactionStart extends PaywallMessage {
        public static final TransactionStart INSTANCE = new TransactionStart();

        private TransactionStart() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrialStarted extends PaywallMessage {
        private final String productIdentifier;
        private final Long trialEndDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrialStarted(Long l3, String productIdentifier) {
            super(null);
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            this.trialEndDate = l3;
            this.productIdentifier = productIdentifier;
        }

        public static /* synthetic */ TrialStarted copy$default(TrialStarted trialStarted, Long l3, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                l3 = trialStarted.trialEndDate;
            }
            if ((i3 & 2) != 0) {
                str = trialStarted.productIdentifier;
            }
            return trialStarted.copy(l3, str);
        }

        public final Long component1() {
            return this.trialEndDate;
        }

        public final String component2() {
            return this.productIdentifier;
        }

        public final TrialStarted copy(Long l3, String productIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            return new TrialStarted(l3, productIdentifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TrialStarted)) {
                return false;
            }
            TrialStarted trialStarted = (TrialStarted) obj;
            return Intrinsics.areEqual(this.trialEndDate, trialStarted.trialEndDate) && Intrinsics.areEqual(this.productIdentifier, trialStarted.productIdentifier);
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public final Long getTrialEndDate() {
            return this.trialEndDate;
        }

        public int hashCode() {
            Long l3 = this.trialEndDate;
            return ((l3 == null ? 0 : l3.hashCode()) * 31) + this.productIdentifier.hashCode();
        }

        public String toString() {
            return "TrialStarted(trialEndDate=" + this.trialEndDate + ", productIdentifier=" + this.productIdentifier + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class UserAttributesUpdated extends PaywallMessage {
        private final Map<String, Object> data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserAttributesUpdated(Map<String, ? extends Object> data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserAttributesUpdated copy$default(UserAttributesUpdated userAttributesUpdated, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = userAttributesUpdated.data;
            }
            return userAttributesUpdated.copy(map);
        }

        public final Map<String, Object> component1() {
            return this.data;
        }

        public final UserAttributesUpdated copy(Map<String, ? extends Object> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new UserAttributesUpdated(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserAttributesUpdated) && Intrinsics.areEqual(this.data, ((UserAttributesUpdated) obj).data);
        }

        public final Map<String, Object> getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "UserAttributesUpdated(data=" + this.data + ")";
        }
    }

    public /* synthetic */ PaywallMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallMessage() {
    }
}
