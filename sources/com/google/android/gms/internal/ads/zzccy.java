package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccy implements MediationRewardedAdCallback {
    private final zzbvi zza;

    public zzccy(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdClosed() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(AdError adError) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdFailedToShow.");
        int iA = adError.a();
        String strC = adError.c();
        String strB = adError.b();
        int length = String.valueOf(iA).length();
        StringBuilder sb = new StringBuilder(length + 60 + String.valueOf(strC).length() + 16 + String.valueOf(strB).length());
        sb.append("Mediation ad failed to show: Error Code = ");
        sb.append(iA);
        sb.append(". Error Message = ");
        sb.append(strC);
        sb.append(" Error Domain = ");
        sb.append(strB);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        try {
            this.zza.zzy(adError.d());
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdOpened() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.zza.zzi();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzz();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback, com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoComplete() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onVideoComplete.");
        try {
            this.zza.zzt();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoStart() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onVideoStart.");
        try {
            this.zza.zzo();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdClicked() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called reportAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdImpression() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called reportAdImpression.");
        try {
            this.zza.zzk();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward(RewardItem rewardItem) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onUserEarnedReward.");
        try {
            this.zza.zzr(new zzccz(rewardItem));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
