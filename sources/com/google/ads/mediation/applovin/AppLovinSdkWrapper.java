package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinSdkWrapper {
    public AppLovinSdk a(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        return AppLovinSdk.getInstance(appLovinSdkSettings, context);
    }

    public AppLovinSdk b(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        return AppLovinSdk.getInstance(str, appLovinSdkSettings, context);
    }

    public AppLovinSdkSettings c(Context context) {
        if (AppLovinMediationAdapter.appLovinSdkSettings == null) {
            AppLovinMediationAdapter.appLovinSdkSettings = new AppLovinSdkSettings(context);
        }
        return AppLovinMediationAdapter.appLovinSdkSettings;
    }

    public String d() {
        return AppLovinSdk.VERSION;
    }
}
