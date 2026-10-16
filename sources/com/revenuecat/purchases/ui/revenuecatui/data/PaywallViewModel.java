package com.revenuecat.purchases.ui.revenuecatui.data;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.State;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public interface PaywallViewModel {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ void closePaywall$default(PaywallViewModel paywallViewModel, PaywallResult paywallResult, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closePaywall");
            }
            if ((i3 & 1) != 0) {
                paywallResult = null;
            }
            paywallViewModel.closePaywall(paywallResult);
        }

        public static /* synthetic */ Object handlePackagePurchase$default(PaywallViewModel paywallViewModel, Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handlePackagePurchase");
            }
            if ((i3 & 4) != 0) {
                resolvedOffer = null;
            }
            return paywallViewModel.handlePackagePurchase(activity, r2, resolvedOffer, continuation);
        }

        public static void trackComponentInteraction(PaywallViewModel paywallViewModel, PaywallComponentType componentType, String str, String componentValue, String str2) {
            Intrinsics.checkNotNullParameter(componentType, "componentType");
            Intrinsics.checkNotNullParameter(componentValue, "componentValue");
            paywallViewModel.trackComponentInteraction(new PaywallComponentInteractionData(componentType, str, componentValue, str2, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524272, (DefaultConstructorMarker) null));
        }

        public static /* synthetic */ void trackComponentInteraction$default(PaywallViewModel paywallViewModel, PaywallComponentType paywallComponentType, String str, String str2, String str3, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackComponentInteraction");
            }
            if ((i3 & 8) != 0) {
                str3 = null;
            }
            paywallViewModel.trackComponentInteraction(paywallComponentType, str, str2, str3);
        }
    }

    void clearActionError();

    void closePaywall(PaywallResult paywallResult);

    State<PurchasesError> getActionError();

    State<Boolean> getActionInProgress();

    State<Offering> getPreloadedExitOffering();

    State<Boolean> getPurchaseCompleted();

    ResourceProvider getResourceProvider();

    StateFlow<PaywallState> getState();

    String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout);

    boolean handleBackNavigation();

    Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation);

    Object handleRestorePurchases(Continuation<? super Unit> continuation);

    void handleWorkflowAction(String str, WorkflowTriggerType workflowTriggerType);

    void invalidateCustomerInfoCache();

    void preloadExitOffering();

    void purchaseSelectedPackage(Activity activity);

    void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean z2);

    void refreshStateIfLocaleChanged();

    void restorePurchases();

    void selectPackage(TemplateConfiguration.PackageInfo packageInfo);

    void trackComponentInteraction(PaywallComponentInteractionData paywallComponentInteractionData);

    void trackComponentInteraction(PaywallComponentType paywallComponentType, String str, String str2, String str3);

    void trackExitOffer(ExitOfferType exitOfferType, String str);

    void trackPaywallImpressionIfNeeded();
}
