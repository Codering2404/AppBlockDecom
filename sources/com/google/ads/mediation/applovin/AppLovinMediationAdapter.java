package com.google.ads.mediation.applovin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.BuildConfig;
import com.applovin.mediation.rtb.AppLovinRtbInterstitialRenderer;
import com.applovin.mediation.rtb.AppLovinRtbRewardedRenderer;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinMediationAdapter extends RtbAdapter {
    public static final String APPLOVIN_SDK_ERROR_DOMAIN = "com.applovin.sdk";
    public static final int ERROR_AD_ALREADY_REQUESTED = 105;
    public static final int ERROR_AD_FORMAT_UNSUPPORTED = 108;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 101;
    public static final int ERROR_CHILD_USER = 112;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.applovin";
    public static final int ERROR_EMPTY_BID_TOKEN = 104;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 110;
    static final String ERROR_MSG_BANNER_SIZE_MISMATCH = "Failed to request banner with unsupported size.";
    static final String ERROR_MSG_MISSING_SDK = "Missing or invalid SDK Key.";
    public static final int ERROR_PRESENTATON_AD_NOT_READY = 106;
    private static final String TAG = "AppLovinMediationAdapter";
    public static AppLovinSdkSettings appLovinSdkSettings;
    private AppLovinBannerAd bannerAd;
    private AppLovinWaterfallRewardedRenderer rewardedRenderer;
    private AppLovinRtbInterstitialRenderer rtbInterstitialRenderer;
    private AppLovinRtbRewardedRenderer rtbRewardedRenderer;
    private AppLovinWaterfallInterstitialAd waterfallInterstitialAd;
    private final AppLovinInitializer appLovinInitializer = AppLovinInitializer.c();
    private final AppLovinAdFactory appLovinAdFactory = new AppLovinAdFactory();
    private final AppLovinSdkWrapper appLovinSdkWrapper = new AppLovinSdkWrapper();
    private final AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper = new AppLovinSdkUtilsWrapper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    public static AppLovinSdkSettings getSdkSettings(Context context) {
        if (appLovinSdkSettings == null) {
            appLovinSdkSettings = new AppLovinSdkSettings(context);
        }
        return appLovinSdkSettings;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        if (AppLovinUtils.isChildUser()) {
            signalCallbacks.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        MediationConfiguration configuration = rtbSignalData.getConfiguration();
        if (configuration.a() == AdFormat.NATIVE) {
            AdError adError = new AdError(108, "Requested to collect signal for unsupported native ad format. Ignoring...", ERROR_DOMAIN);
            Log.e(TAG, adError.c());
            signalCallbacks.onFailure(adError);
            return;
        }
        String str = TAG;
        Log.i(str, "Extras for signal collection: " + rtbSignalData.b());
        String bidToken = this.appLovinInitializer.e(configuration.b(), rtbSignalData.a()).getAdService().getBidToken();
        if (TextUtils.isEmpty(bidToken)) {
            AdError adError2 = new AdError(104, "Failed to generate bid token.", ERROR_DOMAIN);
            Log.e(str, adError2.c());
            signalCallbacks.onFailure(adError2);
        } else {
            Log.i(str, "Generated bid token: " + bidToken);
            signalCallbacks.onSuccess(bidToken);
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String strD = this.appLovinSdkWrapper.d();
        String[] strArrSplit = strD.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", strD));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        return getVersionInfo(BuildConfig.ADAPTER_VERSION);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (AppLovinUtils.isChildUser()) {
            initializationCompleteCallback.onInitializationFailed(AppLovinUtils.ERROR_MSG_CHILD_USER);
            return;
        }
        final HashSet hashSet = new HashSet();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().b().getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        if (hashSet.isEmpty()) {
            AdError adError = new AdError(110, ERROR_MSG_MISSING_SDK, ERROR_DOMAIN);
            Log.w(TAG, adError.c());
            initializationCompleteCallback.onInitializationFailed(adError.c());
        } else {
            final HashSet hashSet2 = new HashSet();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                this.appLovinInitializer.d(context, (String) it2.next(), new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinMediationAdapter.1
                    @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
                    public void onInitializeSuccess(String str) {
                        hashSet2.add(str);
                        if (hashSet2.equals(hashSet)) {
                            initializationCompleteCallback.onInitializationSucceeded();
                        }
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinBannerAd appLovinBannerAdN = AppLovinBannerAd.n(mediationBannerAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory);
        this.bannerAd = appLovinBannerAdN;
        appLovinBannerAdN.m();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinWaterfallInterstitialAd appLovinWaterfallInterstitialAd = new AppLovinWaterfallInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory);
        this.waterfallInterstitialAd = appLovinWaterfallInterstitialAd;
        appLovinWaterfallInterstitialAd.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer = new AppLovinWaterfallRewardedRenderer(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory, this.appLovinSdkUtilsWrapper);
        this.rewardedRenderer = appLovinWaterfallRewardedRenderer;
        appLovinWaterfallRewardedRenderer.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinRtbInterstitialRenderer appLovinRtbInterstitialRenderer = new AppLovinRtbInterstitialRenderer(mediationInterstitialAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory);
        this.rtbInterstitialRenderer = appLovinRtbInterstitialRenderer;
        appLovinRtbInterstitialRenderer.loadAd();
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        if (AppLovinUtils.isChildUser()) {
            mediationAdLoadCallback.onFailure(AppLovinUtils.getChildUserError());
            return;
        }
        AppLovinRtbRewardedRenderer appLovinRtbRewardedRenderer = new AppLovinRtbRewardedRenderer(mediationRewardedAdConfiguration, mediationAdLoadCallback, this.appLovinInitializer, this.appLovinAdFactory, this.appLovinSdkUtilsWrapper);
        this.rtbRewardedRenderer = appLovinRtbRewardedRenderer;
        appLovinRtbRewardedRenderer.loadAd();
    }

    VersionInfo getVersionInfo(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", str));
        return new VersionInfo(0, 0, 0);
    }
}
