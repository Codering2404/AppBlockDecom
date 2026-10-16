package com.applovin.impl.mediation;

import com.applovin.mediation.MaxReward;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxRewardImpl implements MaxReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f61443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f61444b;

    private MaxRewardImpl(int i3, String str) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
        }
        this.f61443a = str;
        this.f61444b = i3;
    }

    public static MaxReward create(int i3, String str) {
        return new MaxRewardImpl(i3, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    @Override // com.applovin.mediation.MaxReward
    public final int getAmount() {
        return this.f61444b;
    }

    @Override // com.applovin.mediation.MaxReward
    public final String getLabel() {
        return this.f61443a;
    }

    public String toString() {
        return "MaxReward{amount=" + this.f61444b + ", label=" + this.f61443a + "}";
    }
}
