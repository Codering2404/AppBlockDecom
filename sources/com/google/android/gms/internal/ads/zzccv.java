package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccv extends zzcco {
    private final RewardedAdLoadCallback zza;
    private final RewardedAd zzb;

    public zzccv(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zza = rewardedAdLoadCallback;
        this.zzb = rewardedAd;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zza;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onAdLoaded(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zza;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onAdFailedToLoad(zzeVar.N());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i3) {
    }
}
