package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapterError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxRewardedInterstitialAdapterListener extends MaxAdapterListener {
    void onRewardedInterstitialAdClicked();

    void onRewardedInterstitialAdClicked(Bundle bundle);

    void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError);

    void onRewardedInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle);

    void onRewardedInterstitialAdDisplayed();

    void onRewardedInterstitialAdDisplayed(Bundle bundle);

    void onRewardedInterstitialAdHidden();

    void onRewardedInterstitialAdHidden(Bundle bundle);

    void onRewardedInterstitialAdLoadFailed(MaxAdapterError maxAdapterError);

    void onRewardedInterstitialAdLoaded();

    void onRewardedInterstitialAdLoaded(Bundle bundle);

    void onUserRewarded(MaxReward maxReward);

    void onUserRewarded(MaxReward maxReward, Bundle bundle);
}
