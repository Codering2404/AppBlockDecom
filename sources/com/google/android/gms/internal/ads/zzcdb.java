package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdb extends zzcco {
    private final RewardedInterstitialAdLoadCallback zza;
    private final zzcdc zzb;

    public zzcdb(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzcdc zzcdcVar) {
        this.zza = rewardedInterstitialAdLoadCallback;
        this.zzb = zzcdcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() {
        zzcdc zzcdcVar;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback == null || (zzcdcVar = this.zzb) == null) {
            return;
        }
        rewardedInterstitialAdLoadCallback.onAdLoaded(zzcdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zza;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onAdFailedToLoad(zzeVar.N());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i3) {
    }
}
