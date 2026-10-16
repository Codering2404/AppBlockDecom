package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbxp implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationRewardedAdCallback, MediationNativeAdCallback, MediationAppOpenAdCallback {
    final zzbvi zza;

    zzbxp(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdClosed() {
        try {
            this.zza.zzf();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdCallback, com.google.android.gms.ads.mediation.MediationAppOpenAdCallback
    public final void onAdFailedToShow(AdError adError) {
        try {
            int iA = adError.a();
            String strC = adError.c();
            String strB = adError.b();
            StringBuilder sb = new StringBuilder(String.valueOf(iA).length() + 59 + String.valueOf(strC).length() + 16 + String.valueOf(strB).length());
            sb.append("Mediated ad failed to show: Error Code = ");
            sb.append(iA);
            sb.append(". Error Message = ");
            sb.append(strC);
            sb.append(" Error Domain = ");
            sb.append(strB);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            this.zza.zzy(adError.d());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdCallback, com.google.android.gms.ads.mediation.MediationInterstitialAdCallback, com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onAdLeftApplication() {
        try {
            this.zza.zzh();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdOpened() {
        try {
            this.zza.zzi();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward() {
        try {
            this.zza.zzz();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback, com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoComplete() {
        try {
            this.zza.zzn();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPause() {
        try {
            this.zza.zzq();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zza.zzu();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoStart() {
        try {
            this.zza.zzo();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdClicked() {
        try {
            this.zza.zze();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdImpression() {
        try {
            this.zza.zzk();
        } catch (RemoteException unused) {
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zza.zzr(new zzccz(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoUnmute() {
    }
}
