package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import com.facebook.ads.Ad;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AdViewApi extends AdViewParentApi, Ad {
    AdView.AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdView.AdViewLoadConfig adViewLoadConfig);

    @Override // com.facebook.ads.internal.api.AdViewParentApi
    void onConfigurationChanged(Configuration configuration);

    @Override // com.facebook.ads.Ad
    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
