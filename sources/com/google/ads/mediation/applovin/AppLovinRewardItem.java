package com.google.ads.mediation.applovin;

import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AppLovinRewardItem implements RewardItem {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f68970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f68971c;

    public AppLovinRewardItem(int i3, String str) {
        this.f68970b = i3;
        this.f68971c = str;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public int getAmount() {
        return this.f68970b;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public String getType() {
        return this.f68971c;
    }
}
