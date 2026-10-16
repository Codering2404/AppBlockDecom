package com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation;

import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.FeedbackSurveyData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PromotionalOfferData;
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
public abstract class CustomerCenterDestination {
    public static final int $stable = 0;
    private final CustomerCenterAnimationType animationType;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CreateSupportTicket extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final CreateSupportTicketData data;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CreateSupportTicket(CreateSupportTicketData data, String title) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            this.data = data;
            this.title = title;
        }

        public static /* synthetic */ CreateSupportTicket copy$default(CreateSupportTicket createSupportTicket, CreateSupportTicketData createSupportTicketData, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                createSupportTicketData = createSupportTicket.data;
            }
            if ((i3 & 2) != 0) {
                str = createSupportTicket.title;
            }
            return createSupportTicket.copy(createSupportTicketData, str);
        }

        public final CreateSupportTicketData component1() {
            return this.data;
        }

        public final String component2() {
            return this.title;
        }

        public final CreateSupportTicket copy(CreateSupportTicketData data, String title) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            return new CreateSupportTicket(data, title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreateSupportTicket)) {
                return false;
            }
            CreateSupportTicket createSupportTicket = (CreateSupportTicket) obj;
            return Intrinsics.areEqual(this.data, createSupportTicket.data) && Intrinsics.areEqual(this.title, createSupportTicket.title);
        }

        public final CreateSupportTicketData getData() {
            return this.data;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "CreateSupportTicket(data=" + this.data + ", title=" + this.title + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FeedbackSurvey extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final FeedbackSurveyData data;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FeedbackSurvey(FeedbackSurveyData data, String title) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            this.data = data;
            this.title = title;
        }

        public static /* synthetic */ FeedbackSurvey copy$default(FeedbackSurvey feedbackSurvey, FeedbackSurveyData feedbackSurveyData, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                feedbackSurveyData = feedbackSurvey.data;
            }
            if ((i3 & 2) != 0) {
                str = feedbackSurvey.title;
            }
            return feedbackSurvey.copy(feedbackSurveyData, str);
        }

        public final FeedbackSurveyData component1() {
            return this.data;
        }

        public final String component2() {
            return this.title;
        }

        public final FeedbackSurvey copy(FeedbackSurveyData data, String title) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(title, "title");
            return new FeedbackSurvey(data, title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FeedbackSurvey)) {
                return false;
            }
            FeedbackSurvey feedbackSurvey = (FeedbackSurvey) obj;
            return Intrinsics.areEqual(this.data, feedbackSurvey.data) && Intrinsics.areEqual(this.title, feedbackSurvey.title);
        }

        public final FeedbackSurveyData getData() {
            return this.data;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.data.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "FeedbackSurvey(data=" + this.data + ", title=" + this.title + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Main extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final String managementScreenTitle;
        private final boolean showingActivePurchasesScreen;
        private final String title;

        public Main(boolean z2, String str) {
            super(null);
            this.showingActivePurchasesScreen = z2;
            this.managementScreenTitle = str;
            this.title = z2 ? str : null;
        }

        private final boolean component1() {
            return this.showingActivePurchasesScreen;
        }

        private final String component2() {
            return this.managementScreenTitle;
        }

        public static /* synthetic */ Main copy$default(Main main, boolean z2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = main.showingActivePurchasesScreen;
            }
            if ((i3 & 2) != 0) {
                str = main.managementScreenTitle;
            }
            return main.copy(z2, str);
        }

        public final Main copy(boolean z2, String str) {
            return new Main(z2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Main)) {
                return false;
            }
            Main main = (Main) obj;
            return this.showingActivePurchasesScreen == main.showingActivePurchasesScreen && Intrinsics.areEqual(this.managementScreenTitle, main.managementScreenTitle);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.showingActivePurchasesScreen) * 31;
            String str = this.managementScreenTitle;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Main(showingActivePurchasesScreen=" + this.showingActivePurchasesScreen + ", managementScreenTitle=" + this.managementScreenTitle + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PromotionalOffer extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final PromotionalOfferData data;
        private final PurchaseInformation purchaseInformation;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PromotionalOffer(PromotionalOfferData data, PurchaseInformation purchaseInformation) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.purchaseInformation = purchaseInformation;
        }

        public static /* synthetic */ PromotionalOffer copy$default(PromotionalOffer promotionalOffer, PromotionalOfferData promotionalOfferData, PurchaseInformation purchaseInformation, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                promotionalOfferData = promotionalOffer.data;
            }
            if ((i3 & 2) != 0) {
                purchaseInformation = promotionalOffer.purchaseInformation;
            }
            return promotionalOffer.copy(promotionalOfferData, purchaseInformation);
        }

        public final PromotionalOfferData component1() {
            return this.data;
        }

        public final PurchaseInformation component2() {
            return this.purchaseInformation;
        }

        public final PromotionalOffer copy(PromotionalOfferData data, PurchaseInformation purchaseInformation) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new PromotionalOffer(data, purchaseInformation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PromotionalOffer)) {
                return false;
            }
            PromotionalOffer promotionalOffer = (PromotionalOffer) obj;
            return Intrinsics.areEqual(this.data, promotionalOffer.data) && Intrinsics.areEqual(this.purchaseInformation, promotionalOffer.purchaseInformation);
        }

        public final PromotionalOfferData getData() {
            return this.data;
        }

        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = this.data.hashCode() * 31;
            PurchaseInformation purchaseInformation = this.purchaseInformation;
            return iHashCode + (purchaseInformation == null ? 0 : purchaseInformation.hashCode());
        }

        public String toString() {
            return "PromotionalOffer(data=" + this.data + ", purchaseInformation=" + this.purchaseInformation + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SelectedPurchaseDetail extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final PurchaseInformation purchaseInformation;
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedPurchaseDetail(PurchaseInformation purchaseInformation, String title) {
            super(null);
            Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
            Intrinsics.checkNotNullParameter(title, "title");
            this.purchaseInformation = purchaseInformation;
            this.title = title;
        }

        public static /* synthetic */ SelectedPurchaseDetail copy$default(SelectedPurchaseDetail selectedPurchaseDetail, PurchaseInformation purchaseInformation, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                purchaseInformation = selectedPurchaseDetail.purchaseInformation;
            }
            if ((i3 & 2) != 0) {
                str = selectedPurchaseDetail.title;
            }
            return selectedPurchaseDetail.copy(purchaseInformation, str);
        }

        public final PurchaseInformation component1() {
            return this.purchaseInformation;
        }

        public final String component2() {
            return this.title;
        }

        public final SelectedPurchaseDetail copy(PurchaseInformation purchaseInformation, String title) {
            Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
            Intrinsics.checkNotNullParameter(title, "title");
            return new SelectedPurchaseDetail(purchaseInformation, title);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelectedPurchaseDetail)) {
                return false;
            }
            SelectedPurchaseDetail selectedPurchaseDetail = (SelectedPurchaseDetail) obj;
            return Intrinsics.areEqual(this.purchaseInformation, selectedPurchaseDetail.purchaseInformation) && Intrinsics.areEqual(this.title, selectedPurchaseDetail.title);
        }

        public final PurchaseInformation getPurchaseInformation() {
            return this.purchaseInformation;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.purchaseInformation.hashCode() * 31) + this.title.hashCode();
        }

        public String toString() {
            return "SelectedPurchaseDetail(purchaseInformation=" + this.purchaseInformation + ", title=" + this.title + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class VirtualCurrencyBalances extends CustomerCenterDestination {
        public static final int $stable = 0;
        private final String title;

        public VirtualCurrencyBalances(String str) {
            super(null);
            this.title = str;
        }

        public static /* synthetic */ VirtualCurrencyBalances copy$default(VirtualCurrencyBalances virtualCurrencyBalances, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = virtualCurrencyBalances.title;
            }
            return virtualCurrencyBalances.copy(str);
        }

        public final String component1() {
            return this.title;
        }

        public final VirtualCurrencyBalances copy(String str) {
            return new VirtualCurrencyBalances(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VirtualCurrencyBalances) && Intrinsics.areEqual(this.title, ((VirtualCurrencyBalances) obj).title);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination
        public String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "VirtualCurrencyBalances(title=" + this.title + ')';
        }
    }

    public /* synthetic */ CustomerCenterDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final CustomerCenterAnimationType getAnimationType() {
        return this.animationType;
    }

    public abstract String getTitle();

    private CustomerCenterDestination() {
        this.animationType = CustomerCenterAnimationType.SLIDE_HORIZONTAL;
    }
}
