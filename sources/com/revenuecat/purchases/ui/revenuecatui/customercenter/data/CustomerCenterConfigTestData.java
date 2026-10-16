package com.revenuecat.purchases.ui.revenuecatui.customercenter.data;

import android.net.Uri;
import coil.target.Yb.oUcQRqOVfOC;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.TestStoreProduct;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.ExpirationOrRenewal;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PriceDetails;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrency;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CustomerCenterConfigTestData {
    public static final int $stable;
    private static final VirtualCurrencies fiveVirtualCurrencies;
    private static final VirtualCurrencies fourVirtualCurrencies;
    private static final PurchaseInformation purchaseInformationFreeTrial;
    private static final PurchaseInformation purchaseInformationLifetime;
    private static final PurchaseInformation purchaseInformationMonthlyRenewing;
    private static final PurchaseInformation purchaseInformationPromotional;
    private static final PurchaseInformation purchaseInformationYearlyExpired;
    private static final PurchaseInformation purchaseInformationYearlyExpiring;
    public static final CustomerCenterConfigTestData INSTANCE = new CustomerCenterConfigTestData();
    private static final CustomerCenterConfigData.Appearance standardAppearance = new CustomerCenterConfigData.Appearance(new CustomerCenterConfigData.Appearance.ColorInformation(new PaywallColor("#007AFF"), new PaywallColor("#000000"), new PaywallColor("#f5f5f7"), new PaywallColor("#7A0000"), new PaywallColor("#287aff")), new CustomerCenterConfigData.Appearance.ColorInformation(new PaywallColor("#FFFFFF"), new PaywallColor("#FFFFFF"), new PaywallColor("#A96800"), new PaywallColor("#FF2600"), new PaywallColor("#000000")));

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PriceDetails.Paid paid = new PriceDetails.Paid("$4.99");
        ExpirationOrRenewal.Renewal renewal = new ExpirationOrRenewal.Renewal("June 1st, 2024");
        Store store = Store.PLAY_STORE;
        purchaseInformationMonthlyRenewing = new PurchaseInformation("Basic", paid, renewal, new TestStoreProduct("monthly_product_id", "Basic", "title", "description", new Price("$4.99", 4990000L, "US"), new Period(1, Period.Unit.MONTH, "P1M"), null, null, 192, null), store, true, Uri.parse("https://play.google.com/store/account/subscriptions"), false, false, false, false);
        PriceDetails.Paid paid2 = new PriceDetails.Paid("$40.99");
        ExpirationOrRenewal.Expiration expiration = new ExpirationOrRenewal.Expiration("June 1st, 2024");
        Uri uri = Uri.parse("https://play.google.com/store/account/subscriptions");
        Price price = new Price("$40.99", 40990000L, "US");
        Period.Unit unit = Period.Unit.YEAR;
        int i3 = 192;
        Period period = null;
        purchaseInformationYearlyExpiring = new PurchaseInformation("Basic", paid2, expiration, new TestStoreProduct("yearly_product_id", "Basic", "title", "description", price, new Period(1, unit, "P1Y"), period, 0 == true ? 1 : 0, i3, null), store, true, uri, false, false, true, false);
        purchaseInformationYearlyExpired = new PurchaseInformation("Basic", new PriceDetails.Paid("$40.99"), new ExpirationOrRenewal.Expiration("June 1st, 2024"), new TestStoreProduct("yearly_product_id", "Basic", "title", "description", new Price("$40.99", 40990000L, "US"), new Period(1, unit, "P1Y"), period, 0 == true ? 1 : 0, i3, 0 == true ? 1 : 0), store, true, Uri.parse("https://play.google.com/store/account/subscriptions"), true, false, true, false);
        purchaseInformationLifetime = new PurchaseInformation("Lifetime", new PriceDetails.Paid("$100.99"), null, null, Store.APP_STORE, false, Uri.parse("https://play.google.com/store/account/subscriptions"), false, false, false, true);
        PriceDetails.Free free = PriceDetails.Free.INSTANCE;
        purchaseInformationFreeTrial = new PurchaseInformation("Premium", free, new ExpirationOrRenewal.Expiration("June 15th, 2024"), new TestStoreProduct("premium_yearly_product_id", "Premium", "title", "description", new Price("$59.99", 59990000L, "US"), new Period(1, unit, "P1Y"), null, 0 == true ? 1 : 0, 192, null), store, true, Uri.parse("https://play.google.com/store/account/subscriptions"), false, true, false, false);
        purchaseInformationPromotional = new PurchaseInformation("rc_promo_Test1_lifetime", free, new ExpirationOrRenewal.Expiration("April 24th, 2225"), null, Store.PROMOTIONAL, false, null, false, false, true, false);
        fourVirtualCurrencies = new VirtualCurrencies(MapsKt.mapOf(TuplesKt.a("GLD", new VirtualCurrency(100, "Gold", "GLD", "It's gold")), TuplesKt.a("SLV", new VirtualCurrency(200, "Silver", "SLV", "It's silver")), TuplesKt.a("BRNZ", new VirtualCurrency(300, "Bronze", "BRNZ", "It's bronze")), TuplesKt.a("PLTNM", new VirtualCurrency(RCHTTPStatusCodes.BAD_REQUEST, "Platinum", "PLTNM", "It's platinum"))));
        fiveVirtualCurrencies = new VirtualCurrencies(MapsKt.mapOf(TuplesKt.a("GLD", new VirtualCurrency(100, "Gold", "GLD", "It's gold")), TuplesKt.a("SLV", new VirtualCurrency(200, "Silver", "SLV", "It's silver")), TuplesKt.a("BRNZ", new VirtualCurrency(300, "Bronze", "BRNZ", "It's bronze")), TuplesKt.a("PLTNM", new VirtualCurrency(RCHTTPStatusCodes.BAD_REQUEST, "Platinum", "PLTNM", "It's platinum")), TuplesKt.a("RC_COIN", new VirtualCurrency(1, "RC Coin", "RC_COIN", "RevenueCat Coin"))));
        $stable = 8;
    }

    private CustomerCenterConfigTestData() {
    }

    public static /* synthetic */ CustomerCenterConfigData customerCenterData$default(CustomerCenterConfigTestData customerCenterConfigTestData, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return customerCenterConfigTestData.customerCenterData(z2, z3);
    }

    public final VirtualCurrencies getFiveVirtualCurrencies() {
        return fiveVirtualCurrencies;
    }

    public final VirtualCurrencies getFourVirtualCurrencies() {
        return fourVirtualCurrencies;
    }

    public final PurchaseInformation getPurchaseInformationFreeTrial() {
        return purchaseInformationFreeTrial;
    }

    public final PurchaseInformation getPurchaseInformationLifetime() {
        return purchaseInformationLifetime;
    }

    public final PurchaseInformation getPurchaseInformationMonthlyRenewing() {
        return purchaseInformationMonthlyRenewing;
    }

    public final PurchaseInformation getPurchaseInformationPromotional() {
        return purchaseInformationPromotional;
    }

    public final PurchaseInformation getPurchaseInformationYearlyExpired() {
        return purchaseInformationYearlyExpired;
    }

    public final PurchaseInformation getPurchaseInformationYearlyExpiring() {
        return purchaseInformationYearlyExpiring;
    }

    public final CustomerCenterConfigData.Appearance getStandardAppearance() {
        return standardAppearance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CustomerCenterConfigData customerCenterData(boolean z2, boolean z3) {
        CustomerCenterConfigData.Screen.ScreenType screenType = CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT;
        CustomerCenterConfigData.HelpPath.PathType pathType = CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE;
        CustomerCenterConfigData.HelpPath helpPath = new CustomerCenterConfigData.HelpPath(AppEventsConstants.EVENT_PARAM_VALUE_YES, "Check for previous purchases", pathType, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 248, (DefaultConstructorMarker) null);
        CustomerCenterConfigData.HelpPath.PathType pathType2 = CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST;
        String str = oUcQRqOVfOC.JQT;
        CustomerCenterConfigData.HelpPath helpPath2 = new CustomerCenterConfigData.HelpPath("2", "Request a refund", pathType2, new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer("offer_id", true, "Wait a minute...", "Before you cancel, please consider accepting this one time offer", MapsKt.mapOf(TuplesKt.a(str, "offer_id"))), (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 240, (DefaultConstructorMarker) null);
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        Object[] objArr4 = 0 == true ? 1 : 0;
        CustomerCenterConfigData.HelpPath helpPath3 = new CustomerCenterConfigData.HelpPath("3", "Change plans", CustomerCenterConfigData.HelpPath.PathType.CHANGE_PLANS, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) objArr, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) objArr2, (String) objArr3, (CustomerCenterConfigData.HelpPath.OpenMethod) objArr4, (String) null, 248, (DefaultConstructorMarker) null);
        CustomerCenterConfigData.HelpPath.PathType pathType3 = CustomerCenterConfigData.HelpPath.PathType.CANCEL;
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option = new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option(AppEventsConstants.EVENT_PARAM_VALUE_YES, "Too expensive", new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer("offer_id", true, "Wait a minute...", "Before you cancel, please consider accepting this offer", MapsKt.mapOf(TuplesKt.a(str, "offer_id"))));
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Object[] objArr5 = 0 == true ? 1 : 0;
        Object[] objArr6 = 0 == true ? 1 : 0;
        Object[] objArr7 = 0 == true ? 1 : 0;
        String str2 = "Manage Subscription";
        String str3 = null;
        CustomerCenterConfigData.ScreenOffering screenOffering = null;
        Pair pairA = TuplesKt.a(screenType, new CustomerCenterConfigData.Screen(screenType, str2, str3, CollectionsKt.listOf((Object[]) new CustomerCenterConfigData.HelpPath[]{helpPath, helpPath2, helpPath3, new CustomerCenterConfigData.HelpPath("4", "Cancel subscription", pathType3, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey("Why are you cancelling?", CollectionsKt.listOf((Object[]) new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option[]{option, new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option("2", "Don't use the app", (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, i3, defaultConstructorMarker), new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option("3", "Bought by mistake", (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) (0 == true ? 1 : 0), i3, defaultConstructorMarker)})), (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) objArr5, (String) null, 232, (DefaultConstructorMarker) null), new CustomerCenterConfigData.HelpPath("5", "FAQ", CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) objArr6, "https://www.revenuecat.com/docs/customer-center-faq", (CustomerCenterConfigData.HelpPath.OpenMethod) objArr7, (String) null, 216, (DefaultConstructorMarker) null)}), screenOffering, 16, (DefaultConstructorMarker) null));
        CustomerCenterConfigData.Screen.ScreenType screenType2 = CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE;
        Object[] objArr8 = 0 == true ? 1 : 0;
        String str4 = "No subscriptions found";
        String str5 = "We can try checking your account for any previous purchases";
        CustomerCenterConfigData.ScreenOffering screenOffering2 = null;
        return new CustomerCenterConfigData(MapsKt.mapOf(pairA, TuplesKt.a(screenType2, new CustomerCenterConfigData.Screen(screenType2, str4, str5, CollectionsKt.listOf(new CustomerCenterConfigData.HelpPath("9q9719171o", "Check for previous purchases", pathType, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) objArr8, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 248, (DefaultConstructorMarker) null)), screenOffering2, 16, (DefaultConstructorMarker) (0 == true ? 1 : 0)))), standardAppearance, new CustomerCenterConfigData.Localization("en_US", MapsKt.mapOf(TuplesKt.a("cancel", "Cancel"), TuplesKt.a("back", "Back"))), new CustomerCenterConfigData.Support("test-support@revenuecat.com", Boolean.valueOf(z2), (Boolean) (0 == true ? 1 : 0), new CustomerCenterConfigData.Support.SupportTickets(z3, new CustomerCenterConfigData.Support.SupportTickets.CustomerDetails(false, false, false, false, false, false, false, false, false, false, false, false, false, false), CustomerCenterConfigData.Support.SupportTickets.CustomerType.NOT_ACTIVE), 4, (DefaultConstructorMarker) null), (String) null, 16, (DefaultConstructorMarker) null);
    }
}
