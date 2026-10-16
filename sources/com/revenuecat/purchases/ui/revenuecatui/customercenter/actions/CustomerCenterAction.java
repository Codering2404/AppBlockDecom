package com.revenuecat.purchases.ui.revenuecatui.customercenter.actions;

import com.revenuecat.purchases.customercenter.CustomActionData;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class CustomerCenterAction {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ContactSupport extends CustomerCenterAction {
        public static final int $stable = 0;
        private final String email;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactSupport(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.email = email;
        }

        public static /* synthetic */ ContactSupport copy$default(ContactSupport contactSupport, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = contactSupport.email;
            }
            return contactSupport.copy(str);
        }

        public final String component1() {
            return this.email;
        }

        public final ContactSupport copy(String email) {
            Intrinsics.checkNotNullParameter(email, "email");
            return new ContactSupport(email);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContactSupport) && Intrinsics.areEqual(this.email, ((ContactSupport) obj).email);
        }

        public final String getEmail() {
            return this.email;
        }

        public int hashCode() {
            return this.email.hashCode();
        }

        public String toString() {
            return "ContactSupport(email=" + this.email + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomActionSelected extends CustomerCenterAction {
        public static final int $stable = 8;
        private final CustomActionData customActionData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomActionSelected(CustomActionData customActionData) {
            super(null);
            Intrinsics.checkNotNullParameter(customActionData, "customActionData");
            this.customActionData = customActionData;
        }

        public static /* synthetic */ CustomActionSelected copy$default(CustomActionSelected customActionSelected, CustomActionData customActionData, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                customActionData = customActionSelected.customActionData;
            }
            return customActionSelected.copy(customActionData);
        }

        public final CustomActionData component1() {
            return this.customActionData;
        }

        public final CustomActionSelected copy(CustomActionData customActionData) {
            Intrinsics.checkNotNullParameter(customActionData, "customActionData");
            return new CustomActionSelected(customActionData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomActionSelected) && Intrinsics.areEqual(this.customActionData, ((CustomActionSelected) obj).customActionData);
        }

        public final CustomActionData getCustomActionData() {
            return this.customActionData;
        }

        public int hashCode() {
            return this.customActionData.hashCode();
        }

        public String toString() {
            return "CustomActionSelected(customActionData=" + this.customActionData + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DismissPromotionalOffer extends CustomerCenterAction {
        public static final int $stable = 8;
        private final CustomerCenterConfigData.HelpPath originalPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DismissPromotionalOffer(CustomerCenterConfigData.HelpPath originalPath) {
            super(null);
            Intrinsics.checkNotNullParameter(originalPath, "originalPath");
            this.originalPath = originalPath;
        }

        public static /* synthetic */ DismissPromotionalOffer copy$default(DismissPromotionalOffer dismissPromotionalOffer, CustomerCenterConfigData.HelpPath helpPath, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                helpPath = dismissPromotionalOffer.originalPath;
            }
            return dismissPromotionalOffer.copy(helpPath);
        }

        public final CustomerCenterConfigData.HelpPath component1() {
            return this.originalPath;
        }

        public final DismissPromotionalOffer copy(CustomerCenterConfigData.HelpPath originalPath) {
            Intrinsics.checkNotNullParameter(originalPath, "originalPath");
            return new DismissPromotionalOffer(originalPath);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DismissPromotionalOffer) && Intrinsics.areEqual(this.originalPath, ((DismissPromotionalOffer) obj).originalPath);
        }

        public final CustomerCenterConfigData.HelpPath getOriginalPath() {
            return this.originalPath;
        }

        public int hashCode() {
            return this.originalPath.hashCode();
        }

        public String toString() {
            return "DismissPromotionalOffer(originalPath=" + this.originalPath + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DismissRestoreDialog extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final DismissRestoreDialog INSTANCE = new DismissRestoreDialog();

        private DismissRestoreDialog() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DismissSupportTicketSuccessSnackbar extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final DismissSupportTicketSuccessSnackbar INSTANCE = new DismissSupportTicketSuccessSnackbar();

        private DismissSupportTicketSuccessSnackbar() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigationButtonPressed extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final NavigationButtonPressed INSTANCE = new NavigationButtonPressed();

        private NavigationButtonPressed() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenURL extends CustomerCenterAction {
        public static final int $stable = 0;
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenURL(String url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public static /* synthetic */ OpenURL copy$default(OpenURL openURL, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = openURL.url;
            }
            return openURL.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final OpenURL copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new OpenURL(url);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenURL) && Intrinsics.areEqual(this.url, ((OpenURL) obj).url);
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "OpenURL(url=" + this.url + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PathButtonPressed extends CustomerCenterAction {
        public static final int $stable = 8;
        private final CustomerCenterConfigData.HelpPath path;
        private final PurchaseInformation purchaseInformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PathButtonPressed(CustomerCenterConfigData.HelpPath path, PurchaseInformation purchaseInformation) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
            this.purchaseInformation = purchaseInformation;
        }

        public static /* synthetic */ PathButtonPressed copy$default(PathButtonPressed pathButtonPressed, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                helpPath = pathButtonPressed.path;
            }
            if ((i3 & 2) != 0) {
                purchaseInformation = pathButtonPressed.purchaseInformation;
            }
            return pathButtonPressed.copy(helpPath, purchaseInformation);
        }

        public final CustomerCenterConfigData.HelpPath component1() {
            return this.path;
        }

        public final PurchaseInformation component2() {
            return this.purchaseInformation;
        }

        public final PathButtonPressed copy(CustomerCenterConfigData.HelpPath path, PurchaseInformation purchaseInformation) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new PathButtonPressed(path, purchaseInformation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PathButtonPressed)) {
                return false;
            }
            PathButtonPressed pathButtonPressed = (PathButtonPressed) obj;
            return Intrinsics.areEqual(this.path, pathButtonPressed.path) && Intrinsics.areEqual(this.purchaseInformation, pathButtonPressed.purchaseInformation);
        }

        public final CustomerCenterConfigData.HelpPath getPath() {
            return this.path;
        }

        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        public int hashCode() {
            int iHashCode = this.path.hashCode() * 31;
            PurchaseInformation purchaseInformation = this.purchaseInformation;
            return iHashCode + (purchaseInformation == null ? 0 : purchaseInformation.hashCode());
        }

        public String toString() {
            return "PathButtonPressed(path=" + this.path + ", purchaseInformation=" + this.purchaseInformation + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PerformRestore extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final PerformRestore INSTANCE = new PerformRestore();

        private PerformRestore() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchasePromotionalOffer extends CustomerCenterAction {
        public static final int $stable = 8;
        private final SubscriptionOption subscriptionOption;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PurchasePromotionalOffer(SubscriptionOption subscriptionOption) {
            super(null);
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
            this.subscriptionOption = subscriptionOption;
        }

        public static /* synthetic */ PurchasePromotionalOffer copy$default(PurchasePromotionalOffer purchasePromotionalOffer, SubscriptionOption subscriptionOption, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                subscriptionOption = purchasePromotionalOffer.subscriptionOption;
            }
            return purchasePromotionalOffer.copy(subscriptionOption);
        }

        public final SubscriptionOption component1() {
            return this.subscriptionOption;
        }

        public final PurchasePromotionalOffer copy(SubscriptionOption subscriptionOption) {
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
            return new PurchasePromotionalOffer(subscriptionOption);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PurchasePromotionalOffer) && Intrinsics.areEqual(this.subscriptionOption, ((PurchasePromotionalOffer) obj).subscriptionOption);
        }

        public final SubscriptionOption getSubscriptionOption() {
            return this.subscriptionOption;
        }

        public int hashCode() {
            return this.subscriptionOption.hashCode();
        }

        public String toString() {
            return "PurchasePromotionalOffer(subscriptionOption=" + this.subscriptionOption + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SelectPurchase extends CustomerCenterAction {
        public static final int $stable = 8;
        private final PurchaseInformation purchase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectPurchase(PurchaseInformation purchase) {
            super(null);
            Intrinsics.checkNotNullParameter(purchase, "purchase");
            this.purchase = purchase;
        }

        public static /* synthetic */ SelectPurchase copy$default(SelectPurchase selectPurchase, PurchaseInformation purchaseInformation, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                purchaseInformation = selectPurchase.purchase;
            }
            return selectPurchase.copy(purchaseInformation);
        }

        public final PurchaseInformation component1() {
            return this.purchase;
        }

        public final SelectPurchase copy(PurchaseInformation purchase) {
            Intrinsics.checkNotNullParameter(purchase, "purchase");
            return new SelectPurchase(purchase);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SelectPurchase) && Intrinsics.areEqual(this.purchase, ((SelectPurchase) obj).purchase);
        }

        public final PurchaseInformation getPurchase() {
            return this.purchase;
        }

        public int hashCode() {
            return this.purchase.hashCode();
        }

        public String toString() {
            return "SelectPurchase(purchase=" + this.purchase + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPaywall extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final ShowPaywall INSTANCE = new ShowPaywall();

        private ShowPaywall() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSupportTicketCreation extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final ShowSupportTicketCreation INSTANCE = new ShowSupportTicketCreation();

        private ShowSupportTicketCreation() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowVirtualCurrencyBalances extends CustomerCenterAction {
        public static final int $stable = 0;
        public static final ShowVirtualCurrencyBalances INSTANCE = new ShowVirtualCurrencyBalances();

        private ShowVirtualCurrencyBalances() {
            super(null);
        }
    }

    public /* synthetic */ CustomerCenterAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomerCenterAction() {
    }
}
