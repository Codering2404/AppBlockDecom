package com.google.ads.mediation.facebook;

import com.facebook.ads.AdExperienceType;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookRewardedInterstitialAd extends FacebookRewardedAd {
    public FacebookRewardedInterstitialAd(MediationAdLoadCallback mediationAdLoadCallback, MetaFactory metaFactory) {
        super(mediationAdLoadCallback, metaFactory);
    }

    @Override // com.google.ads.mediation.facebook.FacebookRewardedAd
    AdExperienceType a() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL;
    }
}
