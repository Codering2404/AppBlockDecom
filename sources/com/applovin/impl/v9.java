package com.applovin.impl;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class v9 extends n9 {
    public v9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // com.applovin.impl.n9
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.widget.ImageView r18, com.applovin.impl.adview.g r19, final com.applovin.impl.adview.l r20, com.applovin.impl.o r21, android.widget.ProgressBar r22, com.applovin.impl.h3 r23, android.view.View r24, com.applovin.adview.AppLovinAdView r25, com.applovin.impl.adview.k r26, android.widget.ImageView r27, android.view.ViewGroup r28) {
        /*
            Method dump skipped, instruction units count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.v9.a(android.widget.ImageView, com.applovin.impl.adview.g, com.applovin.impl.adview.l, com.applovin.impl.o, android.widget.ProgressBar, com.applovin.impl.h3, android.view.View, com.applovin.adview.AppLovinAdView, com.applovin.impl.adview.k, android.widget.ImageView, android.view.ViewGroup):void");
    }

    @Override // com.applovin.impl.n9
    public /* bridge */ /* synthetic */ void a(View view) {
        super.a(view);
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        e0.a(this.f61990d, view);
        if (gVar != null) {
            a(this.f61989c.l(), (this.f61989c.A0() ? 3 : 5) | 48, gVar);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, ((Boolean) this.f61987a.a(sj.D2)).booleanValue() ? 80 : 48);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.f61987a.a(sj.E2)).intValue());
            this.f61990d.addView(progressBar, layoutParams);
        }
        if (kVar != null) {
            this.f61990d.addView(kVar, this.f61991e);
        }
    }
}
