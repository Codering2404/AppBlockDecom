package com.revenuecat.purchases.ui.revenuecatui.components.button;

import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class ButtonComponentInteractionKt {
    public static final ButtonComponentInteraction componentInteraction(ButtonComponentStyle.Action action, String str) {
        Intrinsics.checkNotNullParameter(action, "<this>");
        if (action instanceof ButtonComponentStyle.Action.RestorePurchases) {
            return new ButtonComponentInteraction(PaywallLegacyComponentInteraction.Value.RESTORE_PURCHASES, null, 2, null);
        }
        if (action instanceof ButtonComponentStyle.Action.NavigateBack) {
            return new ButtonComponentInteraction("navigate_back", null, 2, null);
        }
        if (action instanceof ButtonComponentStyle.Action.NavigateTo) {
            return componentInteraction(((ButtonComponentStyle.Action.NavigateTo) action).getDestination(), str);
        }
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage ? true : action instanceof ButtonComponentStyle.Action.WebCheckout ? true : action instanceof ButtonComponentStyle.Action.WebProductSelection ? true : action instanceof ButtonComponentStyle.Action.CustomWebCheckout ? true : action instanceof ButtonComponentStyle.Action.WorkflowTrigger) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isPurchaseRelated(ButtonComponentStyle.Action action) {
        Intrinsics.checkNotNullParameter(action, "<this>");
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage ? true : action instanceof ButtonComponentStyle.Action.WebCheckout ? true : action instanceof ButtonComponentStyle.Action.WebProductSelection ? true : action instanceof ButtonComponentStyle.Action.CustomWebCheckout) {
            return true;
        }
        if (action instanceof ButtonComponentStyle.Action.RestorePurchases ? true : action instanceof ButtonComponentStyle.Action.NavigateBack ? true : action instanceof ButtonComponentStyle.Action.NavigateTo ? true : action instanceof ButtonComponentStyle.Action.WorkflowTrigger) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final ButtonComponentInteraction componentInteraction(ButtonComponentStyle.Action.NavigateTo.Destination destination, String str) {
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.CustomerCenter) {
            return new ButtonComponentInteraction("navigate_to_customer_center", null, 2, null);
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Url) {
            return new ButtonComponentInteraction(((ButtonComponentStyle.Action.NavigateTo.Destination.Url) destination).getComponentInteractionValue(), str);
        }
        if (destination instanceof ButtonComponentStyle.Action.NavigateTo.Destination.Sheet) {
            return new ButtonComponentInteraction("navigate_to_sheet", null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
