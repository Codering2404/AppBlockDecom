package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.BuildConfig;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinInitializer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f68959d = "AppLovinInitializer";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static AppLovinInitializer f68960e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap f68962b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f68963c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinSdkWrapper f68961a = new AppLovinSdkWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InitializationStatus {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInitializeSuccessListener {
        void onInitializeSuccess(String str);
    }

    private AppLovinInitializer() {
    }

    public static AppLovinInitializer c() {
        if (f68960e == null) {
            f68960e = new AppLovinInitializer();
        }
        return f68960e;
    }

    public void d(Context context, final String str, OnInitializeSuccessListener onInitializeSuccessListener) {
        Integer num = 1;
        if (!this.f68962b.containsKey(str)) {
            this.f68962b.put(str, 0);
            this.f68963c.put(str, new ArrayList());
        }
        Integer num2 = 2;
        if (num2.equals(this.f68962b.get(str))) {
            onInitializeSuccessListener.onInitializeSuccess(str);
            return;
        }
        ((ArrayList) this.f68963c.get(str)).add(onInitializeSuccessListener);
        if (num.equals(this.f68962b.get(str))) {
            return;
        }
        this.f68962b.put(str, num);
        Log.d(f68959d, String.format("Attempting to initialize SDK with SDK Key: %s", str));
        AppLovinSdk appLovinSdkB = this.f68961a.b(str, this.f68961a.c(context), context);
        appLovinSdkB.setPluginVersion(BuildConfig.ADAPTER_VERSION);
        appLovinSdkB.setMediationProvider(AppLovinMediationProvider.ADMOB);
        appLovinSdkB.initializeSdk(new AppLovinSdk.SdkInitializationListener() { // from class: com.google.ads.mediation.applovin.AppLovinInitializer.1
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                AppLovinInitializer.this.f68962b.put(str, 2);
                ArrayList arrayList = (ArrayList) AppLovinInitializer.this.f68963c.get(str);
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        ((OnInitializeSuccessListener) obj).onInitializeSuccess(str);
                    }
                    arrayList.clear();
                }
            }
        });
    }

    public AppLovinSdk e(Bundle bundle, Context context) {
        String string = bundle != null ? bundle.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY) : null;
        AppLovinSdkSettings appLovinSdkSettingsC = this.f68961a.c(context);
        AppLovinSdk appLovinSdkB = !TextUtils.isEmpty(string) ? this.f68961a.b(string, appLovinSdkSettingsC, context) : this.f68961a.a(appLovinSdkSettingsC, context);
        appLovinSdkB.setPluginVersion(BuildConfig.ADAPTER_VERSION);
        appLovinSdkB.setMediationProvider(AppLovinMediationProvider.ADMOB);
        return appLovinSdkB;
    }
}
