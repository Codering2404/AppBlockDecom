package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbvt implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationNativeAdCallback, MediationAppOpenAdCallback {
    private final zzbvi zza;

    public zzbvt(zzbvi zzbviVar) {
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

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdCallback, com.google.android.gms.ads.mediation.MediationAppOpenAdCallback
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

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdCallback, com.google.android.gms.ads.mediation.MediationInterstitialAdCallback, com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onAdLeftApplication() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
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

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdCallback
    public final void onVideoComplete() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onVideoComplete.");
        try {
            this.zza.zzt();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onVideoPause.");
        try {
            this.zza.zzq();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void onVideoUnmute() {
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

    public final void onVideoPlay() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a(cJfnYMIyomoWf.mXGhYk);
        try {
            this.zza.zzu();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
