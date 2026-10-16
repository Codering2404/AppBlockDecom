package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.zc;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ad extends Activity implements zc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.applovin.impl.sdk.j f58248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected zc f58249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected bd f58250c = new bd(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MaxAdapterListener f58251d;

    protected void a(View view, String str) {
        if (view == null) {
            a(str);
            return;
        }
        ((ViewGroup) findViewById(R.id.content)).addView(view);
        this.f58249b.bringToFront();
        MaxAdapterListener maxAdapterListener = this.f58251d;
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayed();
            return;
        }
        if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayed();
            return;
        }
        throw new IllegalStateException("Failed to fire display callback (" + this.f58251d + "): neither interstitial nor app open ad");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
        viewGroup.setBackgroundColor(this.f58250c.a());
        com.applovin.impl.sdk.j jVar = this.f58248a;
        r.a(jVar != null ? ((Boolean) jVar.a(sj.z2)).booleanValue() : true, this);
        zc zcVar = new zc(this.f58250c, this);
        this.f58249b = zcVar;
        zcVar.setListener(this);
        this.f58249b.setVisibility(4);
        viewGroup.addView(this.f58249b);
        zq.a(this.f58249b, this.f58250c.b());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        MaxAdapterListener maxAdapterListener = this.f58251d;
        if (maxAdapterListener != null) {
            if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
                ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdHidden();
            } else {
                if (!(maxAdapterListener instanceof MaxAppOpenAdapterListener)) {
                    throw new IllegalStateException("Failed to fire hidden callback (" + this.f58251d + "): neither interstitial nor app open ad");
                }
                ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdHidden();
            }
        }
        super.onDestroy();
    }

    private void a(String str) {
        MaxAdapterError maxAdapterError = new MaxAdapterError(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, "Null hybrid ad view (" + str + ")");
        MaxAdapterListener maxAdapterListener = this.f58251d;
        if (maxAdapterListener instanceof MaxInterstitialAdapterListener) {
            ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdDisplayFailed(maxAdapterError);
        } else if (maxAdapterListener instanceof MaxAppOpenAdapterListener) {
            ((MaxAppOpenAdapterListener) maxAdapterListener).onAppOpenAdDisplayFailed(maxAdapterError);
        } else {
            throw new IllegalStateException("Failed to fire display failed callback (" + this.f58251d + "): neither interstitial nor app open ad");
        }
        finish();
    }

    protected void a(bd bdVar, com.applovin.impl.sdk.j jVar, MaxAdapterListener maxAdapterListener) {
        this.f58248a = jVar;
        this.f58250c = bdVar;
        this.f58251d = maxAdapterListener;
    }

    @Override // com.applovin.impl.zc.a
    public void a(zc zcVar) {
        if (isFinishing()) {
            return;
        }
        finish();
    }
}
