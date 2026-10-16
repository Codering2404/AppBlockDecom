package com.superwall.sdk.paywall.view;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.superwall.sdk.misc.Color_HelpersKt;
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
public final class PaywallShimmerViewKt {
    public static final <T extends View & PaywallShimmerView> void setupFor(T t2, PaywallView paywallView, PaywallLoadingState loadingState) {
        Intrinsics.checkNotNullParameter(t2, "<this>");
        Intrinsics.checkNotNullParameter(paywallView, "paywallView");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        ViewParent parent = t2.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(t2);
        }
        if (t2 instanceof ShimmerView) {
            ShimmerView shimmerView = (ShimmerView) t2;
            if (shimmerView.getBackground() != paywallView.getBackgroundColor()) {
                shimmerView.setBackground(paywallView.getBackgroundColor());
                t2.setBackgroundColor(shimmerView.getBackground());
                shimmerView.setLightBackground(!Color_HelpersKt.isDarkColor(shimmerView.getBackground()));
                shimmerView.setTintColor(Color_HelpersKt.readableOverlayColor(shimmerView.getBackground()));
                shimmerView.setTintColorFilter(BlendModeColorFilterCompat.a(Color.argb(64, Color.red(shimmerView.getTintColor()), Color.green(shimmerView.getTintColor()), Color.blue(shimmerView.getTintColor())), BlendModeCompat.SRC_IN));
            }
        }
        t2.setVisibility(loadingState instanceof PaywallLoadingState.LoadingURL ? 0 : 8);
        paywallView.addView(t2);
        t2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        t2.checkForOrientationChanges();
    }
}
