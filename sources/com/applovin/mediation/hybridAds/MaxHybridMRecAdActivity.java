package com.applovin.mediation.hybridAds;

import android.os.Bundle;
import android.view.View;
import com.applovin.impl.ad;
import com.applovin.impl.bd;
import com.applovin.impl.sdk.j;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxHybridMRecAdActivity extends ad {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f65519f;

    public void a(bd bdVar, View view, j jVar, MaxAdapterListener maxAdapterListener) {
        super.a(bdVar, jVar, maxAdapterListener);
        this.f65519f = view;
    }

    @Override // com.applovin.impl.ad, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.f65519f, "MaxHybridMRecAdActivity");
    }
}
