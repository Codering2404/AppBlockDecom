package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.sb;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinInterstitialAd {
    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context != null) {
            return new sb(appLovinSdk, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public String toString() {
        return "AppLovinInterstitialAd{}";
    }
}
