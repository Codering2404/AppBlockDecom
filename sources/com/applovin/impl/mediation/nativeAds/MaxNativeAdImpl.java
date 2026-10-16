package com.applovin.impl.mediation.nativeAds;

import android.view.View;
import com.applovin.impl.mediation.ads.b;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNativeAdImpl {
    private b adViewTracker;
    private List<View> clickableViews;

    public b getAdViewTracker() {
        return this.adViewTracker;
    }

    public List<View> getClickableViews() {
        return this.clickableViews;
    }

    public void setAdViewTracker(b bVar) {
        this.adViewTracker = bVar;
    }

    public void setClickableViews(List<View> list) {
        this.clickableViews = list;
    }
}
