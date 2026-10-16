package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7C extends C1677hB {
    public InterfaceC1520ee A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A08(NativeAdLayout nativeAdLayout, C1648gi c1648gi, NativeAd nativeAd, C1112Vd c1112Vd) {
        C1342bk c1342bk = new C1342bk(c1648gi);
        MediaView mediaView = new MediaView(c1648gi);
        AdOptionsView adOptionsView = new AdOptionsView(c1648gi, nativeAd, nativeAdLayout);
        c1112Vd.A09(adOptionsView, 28);
        this.A00 = new F2(c1648gi, nativeAd, c1112Vd, UK.A0L(nativeAd.getInternalNativeAd()).A1C(), c1342bk, mediaView, adOptionsView);
        YB.A0N(nativeAdLayout, c1112Vd.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c1342bk, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.C1018Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
