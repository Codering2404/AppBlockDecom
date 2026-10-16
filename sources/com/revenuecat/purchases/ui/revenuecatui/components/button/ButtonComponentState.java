package com.revenuecat.purchases.ui.revenuecatui.components.button;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.intl.Locale;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public final class ButtonComponentState {
    public static final int $stable = 0;
    private final State action$delegate;
    private final Function0<Locale> localeProvider;
    private final ButtonComponentStyle style;

    public ButtonComponentState(ButtonComponentStyle style, Function0<Locale> localeProvider) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        this.style = style;
        this.localeProvider = localeProvider;
        this.action$delegate = SnapshotStateKt.e(new Function0<PaywallAction>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentState$action$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaywallAction invoke() {
                ButtonComponentState buttonComponentState = this.this$0;
                return buttonComponentState.m704toPaywallActionuY6zL4k(buttonComponentState.style.getAction(), LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke()), this.this$0.style.getComponentId());
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toPaywallAction-64pKzr8, reason: not valid java name */
    private final PaywallAction m703toPaywallAction64pKzr8(ButtonComponentStyle.Action.NavigateTo navigateTo, String str) {
        ButtonComponentStyle.Action.NavigateTo.Destination destination = navigateTo.getDestination();
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter) {
            return new PaywallAction.External.NavigateTo(PaywallAction.External.NavigateTo.Destination.CustomerCenter.INSTANCE);
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Url) {
            NonEmptyMap urls = ((ButtonComponentStyle.Action.NavigateTo.Destination.Url) navigateTo.getDestination()).getUrls();
            return new PaywallAction.External.NavigateTo(new PaywallAction.External.NavigateTo.Destination.Url((String) urls.getOrDefault(LocaleId.m612boximpl(str), urls.getEntry().getValue()), ((ButtonComponentStyle.Action.NavigateTo.Destination.Url) navigateTo.getDestination()).getMethod()));
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Sheet) {
            return new PaywallAction.Internal.NavigateTo(new PaywallAction.Internal.NavigateTo.Destination.Sheet((ButtonComponentStyle.Action.NavigateTo.Destination.Sheet) navigateTo.getDestination()));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toPaywallAction-uY6zL4k, reason: not valid java name */
    public final PaywallAction m704toPaywallActionuY6zL4k(ButtonComponentStyle.Action action, String str, String str2) {
        if (action instanceof ButtonComponentStyle.Action.NavigateBack) {
            return PaywallAction.External.NavigateBack.INSTANCE;
        }
        if (action instanceof ButtonComponentStyle.Action.NavigateTo) {
            return m703toPaywallAction64pKzr8((ButtonComponentStyle.Action.NavigateTo) action, str);
        }
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage) {
            ButtonComponentStyle.Action.PurchasePackage purchasePackage = (ButtonComponentStyle.Action.PurchasePackage) action;
            return new PaywallAction.External.PurchasePackage(purchasePackage.getRcPackage(), purchasePackage.getResolvedOffer());
        }
        if (action instanceof ButtonComponentStyle.Action.RestorePurchases) {
            return PaywallAction.External.RestorePurchases.INSTANCE;
        }
        if (action instanceof ButtonComponentStyle.Action.WebCheckout) {
            ButtonComponentStyle.Action.WebCheckout webCheckout = (ButtonComponentStyle.Action.WebCheckout) action;
            return new PaywallAction.External.LaunchWebCheckout(null, webCheckout.getOpenMethod(), webCheckout.getAutoDismiss(), new PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append(webCheckout.getRcPackage(), null));
        }
        if (action instanceof ButtonComponentStyle.Action.WebProductSelection) {
            ButtonComponentStyle.Action.WebProductSelection webProductSelection = (ButtonComponentStyle.Action.WebProductSelection) action;
            return new PaywallAction.External.LaunchWebCheckout(null, webProductSelection.getOpenMethod(), webProductSelection.getAutoDismiss(), PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.DoNotAppend.INSTANCE);
        }
        if (action instanceof ButtonComponentStyle.Action.CustomWebCheckout) {
            ButtonComponentStyle.Action.CustomWebCheckout customWebCheckout = (ButtonComponentStyle.Action.CustomWebCheckout) action;
            NonEmptyMap<LocaleId, String> urls = customWebCheckout.getUrls();
            return new PaywallAction.External.LaunchWebCheckout((String) urls.getOrDefault(LocaleId.m612boximpl(str), urls.getEntry().getValue()), customWebCheckout.getOpenMethod(), customWebCheckout.getAutoDismiss(), new PaywallAction.External.LaunchWebCheckout.PackageParamBehavior.Append(customWebCheckout.getRcPackage(), customWebCheckout.getPackageParam()));
        }
        if (!(action instanceof ButtonComponentStyle.Action.WorkflowTrigger)) {
            throw new NoWhenBranchMatchedException();
        }
        if (str2 != null) {
            return new PaywallAction.External.WorkflowTrigger(str2, WorkflowTriggerType.ON_PRESS);
        }
        return null;
    }

    public final /* synthetic */ PaywallAction getAction() {
        return (PaywallAction) this.action$delegate.getValue();
    }
}
