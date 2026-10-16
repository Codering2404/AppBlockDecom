package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.app.Activity;
import android.content.Context;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.customercenter.CustomActionData;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.StateFlow;

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
public interface CustomerCenterViewModel {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ Object loadAndDisplayPromotionalOffer$default(CustomerCenterViewModel customerCenterViewModel, Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAndDisplayPromotionalOffer");
            }
            if ((i3 & 16) != 0) {
                purchaseInformation = null;
            }
            return customerCenterViewModel.loadAndDisplayPromotionalOffer(context, storeProduct, promotionalOffer, helpPath, purchaseInformation, continuation);
        }

        public static /* synthetic */ void openURL$default(CustomerCenterViewModel customerCenterViewModel, Context context, String str, CustomerCenterConfigData.HelpPath.OpenMethod openMethod, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openURL");
            }
            if ((i3 & 4) != 0) {
                openMethod = CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL;
            }
            customerCenterViewModel.openURL(context, str, openMethod);
        }
    }

    void clearActionError();

    void contactSupport(Context context, String str);

    void dismissPromotionalOffer(Context context, CustomerCenterConfigData.HelpPath helpPath);

    Object dismissRestoreDialog(Continuation<? super Unit> continuation);

    void dismissSupportTicketSuccessSnackbar();

    State<PurchasesError> getActionError();

    StateFlow<CustomerCenterState> getState();

    Object loadAndDisplayPromotionalOffer(Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation<? super Boolean> continuation);

    Object loadCustomerCenter(Continuation<? super Unit> continuation);

    Object onAcceptedPromotionalOffer(SubscriptionOption subscriptionOption, Activity activity, Continuation<? super Unit> continuation);

    void onActivityResumed();

    void onActivityStarted();

    void onActivityStopped(boolean z2);

    void onCustomActionSelected(CustomActionData customActionData);

    void onNavigationButtonPressed(Context context, Function0<Unit> function0);

    void openURL(Context context, String str, CustomerCenterConfigData.HelpPath.OpenMethod openMethod);

    void pathButtonPressed(Context context, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation);

    void refreshColors(ColorScheme colorScheme, boolean z2);

    Object refreshCustomerCenter(Continuation<? super Unit> continuation);

    void refreshStateIfLocaleChanged();

    Object restorePurchases(Continuation<? super Unit> continuation);

    void selectPurchase(PurchaseInformation purchaseInformation);

    void showCreateSupportTicket();

    void showPaywall(Context context);

    void showVirtualCurrencyBalances();

    void trackImpressionIfNeeded();
}
