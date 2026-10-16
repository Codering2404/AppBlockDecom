package com.facebook.ads.redexgen.core;

import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1817jh implements N1 {
    public int A00;
    public long A01;
    public RewardData A02;

    public abstract int A0H();

    public abstract NQ A0I();

    public abstract boolean A0J();

    public final void A00(int i3) {
        this.A00 = i3;
    }

    public final void A01(long j3) {
        this.A01 = j3;
    }

    public final void A02(RewardData rewardData) {
        this.A02 = rewardData;
    }

    @Override // com.facebook.ads.redexgen.core.N1
    public final AdPlacementType A8k() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}
