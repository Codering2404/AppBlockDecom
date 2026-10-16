package com.applovin.impl;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class x9 extends n9 {
    public x9(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    @Override // com.applovin.impl.n9
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    public void a(ImageView imageView, com.applovin.impl.adview.g gVar, com.applovin.impl.adview.g gVar2, o oVar, com.applovin.impl.adview.k kVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f61990d.addView(appLovinAdView);
        if (gVar != null) {
            a(this.f61989c.l(), (this.f61989c.I0() ? 3 : 5) | 48, gVar);
        }
        if (gVar2 != null) {
            a(this.f61989c.l(), (this.f61989c.A0() ? 3 : 5) | 48, gVar2);
        }
        if (imageView != null) {
            int iDpToPx = AppLovinSdkUtils.dpToPx(this.f61988b, ((Integer) this.f61987a.a(sj.f63784q2)).intValue());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx, ((Integer) this.f61987a.a(sj.s2)).intValue());
            int iDpToPx2 = AppLovinSdkUtils.dpToPx(this.f61988b, ((Integer) this.f61987a.a(sj.r2)).intValue());
            layoutParams.setMargins(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
            this.f61990d.addView(imageView, layoutParams);
        }
        if (oVar != null) {
            this.f61990d.addView(oVar, this.f61991e);
        }
        if (kVar != null) {
            this.f61990d.addView(kVar, new ViewGroup.LayoutParams(-1, -1));
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f61990d);
        } else {
            this.f61988b.setContentView(this.f61990d);
        }
    }
}
