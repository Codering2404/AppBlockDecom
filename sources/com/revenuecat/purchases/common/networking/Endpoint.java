package com.revenuecat.purchases.common.networking;

import android.net.Uri;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public abstract class Endpoint {
    private final String fallbackPath;
    private final String name;
    private final String pathTemplate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AliasUsers extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AliasUsers(String userId) {
            super("/v1/subscribers/%s/alias", "alias_users", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ AliasUsers copy$default(AliasUsers aliasUsers, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = aliasUsers.userId;
            }
            return aliasUsers.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final AliasUsers copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new AliasUsers(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AliasUsers) && Intrinsics.areEqual(this.userId, ((AliasUsers) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "AliasUsers(userId=" + this.userId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetAmazonReceipt extends Endpoint {
        private final String receiptId;
        private final String userId;

        public static /* synthetic */ GetAmazonReceipt copy$default(GetAmazonReceipt getAmazonReceipt, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = getAmazonReceipt.userId;
            }
            if ((i3 & 2) != 0) {
                str2 = getAmazonReceipt.receiptId;
            }
            return getAmazonReceipt.copy(str, str2);
        }

        public final String component1() {
            return this.userId;
        }

        public final String component2() {
            return this.receiptId;
        }

        public final GetAmazonReceipt copy(String userId, String receiptId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(receiptId, "receiptId");
            return new GetAmazonReceipt(userId, receiptId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GetAmazonReceipt)) {
                return false;
            }
            GetAmazonReceipt getAmazonReceipt = (GetAmazonReceipt) obj;
            return Intrinsics.areEqual(this.userId, getAmazonReceipt.userId) && Intrinsics.areEqual(this.receiptId, getAmazonReceipt.receiptId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), this.receiptId}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getReceiptId() {
            return this.receiptId;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.receiptId.hashCode();
        }

        public String toString() {
            return "GetAmazonReceipt(userId=" + this.userId + ", receiptId=" + this.receiptId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAmazonReceipt(String userId, String str) {
            super("/v1/receipts/amazon/%s/%s", "get_amazon_receipt", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(str, QgXempTBEfV.dsa);
            this.userId = userId;
            this.receiptId = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetCustomerCenterConfig extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerCenterConfig(String userId) {
            super("/v1/customercenter/%s", "get_customer_center_config", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetCustomerCenterConfig copy$default(GetCustomerCenterConfig getCustomerCenterConfig, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = getCustomerCenterConfig.userId;
            }
            return getCustomerCenterConfig.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetCustomerCenterConfig copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetCustomerCenterConfig(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetCustomerCenterConfig) && Intrinsics.areEqual(this.userId, ((GetCustomerCenterConfig) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerCenterConfig(userId=" + this.userId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetCustomerInfo extends Endpoint {
        private final String userId;

        public static /* synthetic */ GetCustomerInfo copy$default(GetCustomerInfo getCustomerInfo, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = getCustomerInfo.userId;
            }
            return getCustomerInfo.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetCustomerInfo copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetCustomerInfo(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetCustomerInfo) && Intrinsics.areEqual(this.userId, ((GetCustomerInfo) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerInfo(userId=" + this.userId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerInfo(String str) {
            super("/v1/subscribers/%s", "get_customer", null, 4, null);
            Intrinsics.checkNotNullParameter(str, sKeKFMqmvNzY.pvpgBuDx);
            this.userId = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetOfferings extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetOfferings(String userId) {
            super("/v1/subscribers/%s/offerings", "get_offerings", "/v1/offerings", null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetOfferings copy$default(GetOfferings getOfferings, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = getOfferings.userId;
            }
            return getOfferings.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetOfferings copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetOfferings(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetOfferings) && Intrinsics.areEqual(this.userId, ((GetOfferings) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            if (z2 && getFallbackPath() != null) {
                return getFallbackPath();
            }
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetOfferings(userId=" + this.userId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetProductEntitlementMapping extends Endpoint {
        public static final GetProductEntitlementMapping INSTANCE = new GetProductEntitlementMapping();

        /* JADX WARN: Illegal instructions before constructor call */
        private GetProductEntitlementMapping() {
            String str = "/v1/product_entitlement_mapping";
            super(str, "get_product_entitlement_mapping", str, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return (!z2 || getFallbackPath() == null) ? getPathTemplate() : getFallbackPath();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetVirtualCurrencies extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetVirtualCurrencies(String userId) {
            super("/v1/subscribers/%s/virtual_currencies", "get_virtual_currencies", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetVirtualCurrencies copy$default(GetVirtualCurrencies getVirtualCurrencies, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = getVirtualCurrencies.userId;
            }
            return getVirtualCurrencies.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetVirtualCurrencies copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new GetVirtualCurrencies(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetVirtualCurrencies) && Intrinsics.areEqual(this.userId, ((GetVirtualCurrencies) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetVirtualCurrencies(userId=" + this.userId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetWorkflow extends Endpoint {
        private final String userId;
        private final String workflowId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetWorkflow(String userId, String workflowId) {
            super("/v1/subscribers/%s/workflows/%s", "get_workflow", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            this.userId = userId;
            this.workflowId = workflowId;
        }

        public static /* synthetic */ GetWorkflow copy$default(GetWorkflow getWorkflow, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = getWorkflow.userId;
            }
            if ((i3 & 2) != 0) {
                str2 = getWorkflow.workflowId;
            }
            return getWorkflow.copy(str, str2);
        }

        public final String component1() {
            return this.userId;
        }

        public final String component2() {
            return this.workflowId;
        }

        public final GetWorkflow copy(String userId, String workflowId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            return new GetWorkflow(userId, workflowId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GetWorkflow)) {
                return false;
            }
            GetWorkflow getWorkflow = (GetWorkflow) obj;
            return Intrinsics.areEqual(this.userId, getWorkflow.userId) && Intrinsics.areEqual(this.workflowId, getWorkflow.workflowId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), Uri.encode(this.workflowId)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public final String getWorkflowId() {
            return this.workflowId;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.workflowId.hashCode();
        }

        public String toString() {
            return "GetWorkflow(userId=" + this.userId + ", workflowId=" + this.workflowId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LogIn extends Endpoint {
        public static final LogIn INSTANCE = new LogIn();

        private LogIn() {
            super("/v1/subscribers/identify", "log_in", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return getPathTemplate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostAttributes extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAttributes(String userId) {
            super("/v1/subscribers/%s/attributes", "post_attributes", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ PostAttributes copy$default(PostAttributes postAttributes, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = postAttributes.userId;
            }
            return postAttributes.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final PostAttributes copy(String userId) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            return new PostAttributes(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PostAttributes) && Intrinsics.areEqual(this.userId, ((PostAttributes) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "PostAttributes(userId=" + this.userId + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostCreateSupportTicket extends Endpoint {
        public static final PostCreateSupportTicket INSTANCE = new PostCreateSupportTicket();

        private PostCreateSupportTicket() {
            super("/v1/customercenter/support/create-ticket", "post_create_support_ticket", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return getPathTemplate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostDiagnostics extends Endpoint {
        public static final PostDiagnostics INSTANCE = new PostDiagnostics();

        private PostDiagnostics() {
            super("/v1/diagnostics", "post_diagnostics", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return getPathTemplate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostEvents extends Endpoint {
        public static final PostEvents INSTANCE = new PostEvents();

        private PostEvents() {
            super("/v1/events", "post_paywall_events", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return getPathTemplate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostReceipt extends Endpoint {
        public static final PostReceipt INSTANCE = new PostReceipt();

        private PostReceipt() {
            super("/v1/receipts", "post_receipt", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return getPathTemplate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PostRedeemWebPurchase extends Endpoint {
        public static final PostRedeemWebPurchase INSTANCE = new PostRedeemWebPurchase();

        private PostRedeemWebPurchase() {
            super(CbYNFSEGaQj.UiUgPnSvEa, "post_redeem_web_purchase", null, 4, null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            return getPathTemplate();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WebBillingGetProducts extends Endpoint {
        private final Set<String> productIds;
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebBillingGetProducts(String userId, Set<String> productIds) {
            super("/rcbilling/v1/subscribers/%s/products?id=%s", "web_billing_get_products", null, 4, null);
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(productIds, "productIds");
            this.userId = userId;
            this.productIds = productIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WebBillingGetProducts copy$default(WebBillingGetProducts webBillingGetProducts, String str, Set set, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = webBillingGetProducts.userId;
            }
            if ((i3 & 2) != 0) {
                set = webBillingGetProducts.productIds;
            }
            return webBillingGetProducts.copy(str, set);
        }

        public final String component1() {
            return this.userId;
        }

        public final Set<String> component2() {
            return this.productIds;
        }

        public final WebBillingGetProducts copy(String userId, Set<String> productIds) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(productIds, "productIds");
            return new WebBillingGetProducts(userId, productIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebBillingGetProducts)) {
                return false;
            }
            WebBillingGetProducts webBillingGetProducts = (WebBillingGetProducts) obj;
            return Intrinsics.areEqual(this.userId, webBillingGetProducts.userId) && Intrinsics.areEqual(this.productIds, webBillingGetProducts.productIds);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath(boolean z2) {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), CollectionsKt.joinToString$default(this.productIds, "&id=", null, null, 0, null, new Function1<String, CharSequence>() { // from class: com.revenuecat.purchases.common.networking.Endpoint$WebBillingGetProducts$getPath$1
                @Override // kotlin.jvm.functions.Function1
                public final CharSequence invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String strEncode = Uri.encode(it);
                    Intrinsics.checkNotNullExpressionValue(strEncode, "encode(it)");
                    return strEncode;
                }
            }, 30, null)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final Set<String> getProductIds() {
            return this.productIds;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.productIds.hashCode();
        }

        public String toString() {
            return "WebBillingGetProducts(userId=" + this.userId + ", productIds=" + this.productIds + ')';
        }
    }

    public /* synthetic */ Endpoint(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public static /* synthetic */ String getPath$default(Endpoint endpoint, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPath");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return endpoint.getPath(z2);
    }

    public final String getFallbackPath() {
        return this.fallbackPath;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedsNonceToPerformSigning() {
        if (this instanceof GetCustomerInfo ? true : Intrinsics.areEqual(this, LogIn.INSTANCE) ? true : Intrinsics.areEqual(this, PostReceipt.INSTANCE) ? true : Intrinsics.areEqual(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetVirtualCurrencies) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof GetOfferings ? true : this instanceof GetWorkflow ? true : this instanceof PostAttributes ? true : Intrinsics.areEqual(this, PostDiagnostics.INSTANCE) ? true : Intrinsics.areEqual(this, PostEvents.INSTANCE) ? true : Intrinsics.areEqual(this, GetProductEntitlementMapping.INSTANCE) ? true : this instanceof GetCustomerCenterConfig ? true : Intrinsics.areEqual(this, PostCreateSupportTicket.INSTANCE) ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public abstract String getPath(boolean z2);

    public final String getPathTemplate() {
        return this.pathTemplate;
    }

    public final boolean getSupportsFallbackBaseURLs() {
        return this.fallbackPath != null;
    }

    public final boolean getSupportsSignatureVerification() {
        if (this instanceof GetCustomerInfo ? true : Intrinsics.areEqual(this, LogIn.INSTANCE) ? true : Intrinsics.areEqual(this, PostReceipt.INSTANCE) ? true : this instanceof GetOfferings ? true : this instanceof GetWorkflow ? true : Intrinsics.areEqual(this, GetProductEntitlementMapping.INSTANCE) ? true : Intrinsics.areEqual(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetVirtualCurrencies) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof PostAttributes ? true : Intrinsics.areEqual(this, PostDiagnostics.INSTANCE) ? true : Intrinsics.areEqual(this, PostEvents.INSTANCE) ? true : this instanceof GetCustomerCenterConfig ? true : Intrinsics.areEqual(this, PostCreateSupportTicket.INSTANCE) ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private Endpoint(String str, String str2, String str3) {
        this.pathTemplate = str;
        this.name = str2;
        this.fallbackPath = str3;
    }

    public /* synthetic */ Endpoint(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : str3, null);
    }
}
