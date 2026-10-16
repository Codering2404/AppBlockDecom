package com.applovin.impl;

import android.app.Activity;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class q9 extends n9 {
    public q9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    @Override // com.applovin.impl.n9
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f61990d.addView(appLovinAdView);
        if (gVar != null) {
            a(this.f61989c.l(), (this.f61989c.A0() ? 3 : 5) | 48, gVar);
        }
        if (kVar != null) {
            this.f61990d.addView(kVar, this.f61991e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f61990d);
        } else {
            this.f61988b.setContentView(this.f61990d);
        }
    }
}
