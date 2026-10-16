package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapterError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxRewardedAdapterListener extends MaxAdapterListener {
    void onRewardedAdClicked();

    void onRewardedAdClicked(Bundle bundle);

    void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError);

    void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle);

    void onRewardedAdDisplayed();

    void onRewardedAdDisplayed(Bundle bundle);

    void onRewardedAdHidden();

    void onRewardedAdHidden(Bundle bundle);

    void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError);

    void onRewardedAdLoaded();

    void onRewardedAdLoaded(Bundle bundle);

    void onUserRewarded(MaxReward maxReward);

    void onUserRewarded(MaxReward maxReward, Bundle bundle);
}
