package com.superwall.sdk.paywall.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import kotlin.Metadata;
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
public final class LoadingViewKt {
    public static final <T extends View & PaywallPurchaseLoadingView> void setupFor(T t2, PaywallView paywallView, PaywallLoadingState loadingState) {
        Intrinsics.checkNotNullParameter(t2, "<this>");
        Intrinsics.checkNotNullParameter(paywallView, "paywallView");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        ViewParent parent = t2.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(t2);
        }
        paywallView.addView(t2);
        t2.setVisibility(((loadingState instanceof PaywallLoadingState.LoadingPurchase) || (loadingState instanceof PaywallLoadingState.ManualLoading)) ? 0 : 8);
    }
}
