package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.sdk.ad.b;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class n9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.applovin.impl.sdk.j f61987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Activity f61988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.applovin.impl.sdk.ad.b f61989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ViewGroup f61990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final FrameLayout.LayoutParams f61991e;

    n9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.f61991e = layoutParams;
        this.f61989c = bVar;
        this.f61987a = jVar;
        this.f61988b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.f61990d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.setLayoutParams(layoutParams);
    }

    public void a(com.applovin.impl.adview.g gVar) {
        if (gVar == null || gVar.getParent() != null) {
            return;
        }
        a(this.f61989c.l(), (this.f61989c.A0() ? 3 : 5) | 48, gVar);
    }

    void a(b.d dVar, int i3, com.applovin.impl.adview.g gVar) {
        gVar.a(dVar.f63196a, dVar.f63200e, dVar.f63199d, i3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gVar.getLayoutParams());
        int i4 = dVar.f63198c;
        layoutParams.setMargins(i4, dVar.f63197b, i4, 0);
        layoutParams.gravity = i3;
        this.f61990d.addView(gVar, layoutParams);
    }

    public void a(View view) {
        this.f61990d.removeView(view);
    }
}
