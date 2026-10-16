package com.google.ads.mediation.facebook;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdSettings;
import com.facebook.ads.BidderTokenProvider;
import com.google.ads.mediation.facebook.FacebookInitializer;
import com.google.ads.mediation.facebook.rtb.FacebookRtbBannerAd;
import com.google.ads.mediation.facebook.rtb.FacebookRtbInterstitialAd;
import com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd;
import com.google.ads.mediation.facebook.rtb.MetaRtbAppOpenAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookMediationAdapter extends RtbAdapter {
    public static final int ERROR_ADVIEW_CONSTRUCTOR_EXCEPTION = 111;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 102;
    public static final int ERROR_CREATE_NATIVE_AD_FROM_BID_PAYLOAD = 109;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.facebook";
    public static final int ERROR_FACEBOOK_INITIALIZATION = 104;
    public static final int ERROR_FAILED_TO_PRESENT_AD = 110;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_MAPPING_NATIVE_ASSETS = 108;
    public static final int ERROR_NULL_CONTEXT = 107;
    public static final int ERROR_REQUIRES_ACTIVITY_CONTEXT = 103;
    public static final int ERROR_REQUIRES_UNIFIED_NATIVE_ADS = 105;
    public static final int ERROR_WRONG_NATIVE_TYPE = 106;
    public static final String FACEBOOK_SDK_ERROR_DOMAIN = "com.facebook.ads";
    public static final String KEY_ID = "id";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    public static final String PLACEMENT_PARAMETER = "pubid";
    public static final String RTB_PLACEMENT_PARAMETER = "placement_id";
    public static final String TAG = "FacebookMediationAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FacebookRtbBannerAd f68993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FacebookRtbInterstitialAd f68994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FacebookRtbNativeAd f68995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FacebookRewardedAd f68996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FacebookRewardedInterstitialAd f68997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MetaFactory f68998f = new MetaFactory();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    public static AdError getAdError(com.facebook.ads.AdError adError) {
        return new AdError(adError.getErrorCode(), adError.getErrorMessage(), "com.facebook.ads");
    }

    public static String getPlacementId(Bundle bundle) {
        String string = bundle.getString(RTB_PLACEMENT_PARAMETER);
        return string == null ? bundle.getString("pubid") : string;
    }

    public static void setMixedAudience(MediationAdConfiguration mediationAdConfiguration) {
        if (mediationAdConfiguration.f() == 1 || mediationAdConfiguration.g() == 1) {
            AdSettings.setMixedAudience(true);
        } else if (mediationAdConfiguration.f() == 0 || mediationAdConfiguration.g() == 0) {
            AdSettings.setMixedAudience(false);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        signalCallbacks.onSuccess(BidderTokenProvider.getBidderToken(rtbSignalData.a()));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String strA = FacebookSdkWrapper.a();
        String[] strArrSplit = strA.split("\\.");
        if (strArrSplit.length >= 3) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s.Returning 0.0.0 for SDK version.", strA));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        String strA = FacebookAdapterUtils.a();
        String[] strArrSplit = strA.split("\\.");
        if (strArrSplit.length >= 4) {
            return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s.Returning 0.0.0 for adapter version.", strA));
        return new VersionInfo(0, 0, 0);
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String placementId = getPlacementId(it.next().b());
            if (!TextUtils.isEmpty(placementId)) {
                arrayList.add(placementId);
            }
        }
        FacebookInitializer.a().b(context, arrayList, new FacebookInitializer.Listener() { // from class: com.google.ads.mediation.facebook.FacebookMediationAdapter.1
            @Override // com.google.ads.mediation.facebook.FacebookInitializer.Listener
            public void a(AdError adError) {
                initializationCompleteCallback.onInitializationFailed(adError.c());
            }

            @Override // com.google.ads.mediation.facebook.FacebookInitializer.Listener
            public void b() {
                initializationCompleteCallback.onInitializationSucceeded();
            }
        });
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbAppOpenAd(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback) {
        new MetaRtbAppOpenAd(mediationAdLoadCallback, this.f68998f).a(mediationAppOpenAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        FacebookRtbBannerAd facebookRtbBannerAd = new FacebookRtbBannerAd(mediationAdLoadCallback, this.f68998f);
        this.f68993a = facebookRtbBannerAd;
        facebookRtbBannerAd.c(mediationBannerAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        FacebookRtbInterstitialAd facebookRtbInterstitialAd = new FacebookRtbInterstitialAd(mediationAdLoadCallback, this.f68998f);
        this.f68994b = facebookRtbInterstitialAd;
        facebookRtbInterstitialAd.a(mediationInterstitialAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbNativeAdMapper(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<NativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        FacebookRtbNativeAd facebookRtbNativeAd = new FacebookRtbNativeAd(mediationAdLoadCallback, this.f68998f);
        this.f68995c = facebookRtbNativeAd;
        facebookRtbNativeAd.N(mediationNativeAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        FacebookRewardedAd facebookRewardedAd = new FacebookRewardedAd(mediationAdLoadCallback, this.f68998f);
        this.f68996d = facebookRewardedAd;
        facebookRewardedAd.b(mediationRewardedAdConfiguration);
    }

    @Override // com.google.android.gms.ads.mediation.rtb.RtbAdapter
    public void loadRtbRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        FacebookRewardedInterstitialAd facebookRewardedInterstitialAd = new FacebookRewardedInterstitialAd(mediationAdLoadCallback, this.f68998f);
        this.f68997e = facebookRewardedInterstitialAd;
        facebookRewardedInterstitialAd.b(mediationRewardedAdConfiguration);
    }
}
