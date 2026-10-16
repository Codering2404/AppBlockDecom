package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwf implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzbvi zza;
    private UnifiedNativeAdMapper zzb;
    private zzbmw zzc;

    public zzbwf(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i3) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 44);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.zza.zzg(i3);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzb;
        if (this.zzc == null) {
            if (unifiedNativeAdMapper == null) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", null);
                return;
            } else if (!unifiedNativeAdMapper.n()) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdImpression.");
        try {
            this.zza.zzk();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded.");
        try {
            this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.zza.zzi();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onVideoEnd.");
        try {
            this.zza.zzn();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAppEvent.");
        try {
            this.zza.zzl(str, str2);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final UnifiedNativeAdMapper zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zzc(MediationNativeAdapter mediationNativeAdapter, zzbmw zzbmwVar) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded with template id ".concat(String.valueOf(zzbmwVar.zzb())));
        this.zzc = zzbmwVar;
        try {
            this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zzd(MediationNativeAdapter mediationNativeAdapter, zzbmw zzbmwVar, String str) {
        try {
            this.zza.zzm(zzbmwVar.zza(), str);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final zzbmw zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, AdError adError) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        int iA = adError.a();
        String strC = adError.c();
        String strB = adError.b();
        int length = String.valueOf(iA).length();
        StringBuilder sb = new StringBuilder(length + 71 + String.valueOf(strC).length() + 15 + String.valueOf(strB).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(iA);
        sb.append(". ErrorMessage: ");
        sb.append(strC);
        sb.append(". ErrorDomain: ");
        sb.append(strB);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.zza.zzx(adError.d());
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded.");
        try {
            this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.zza.zzi();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzb;
        if (this.zzc == null) {
            if (unifiedNativeAdMapper == null) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", null);
                return;
            } else if (!unifiedNativeAdMapper.m()) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzh();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded.");
        this.zzb = unifiedNativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            VideoController videoController = new VideoController();
            videoController.b(new zzbvs());
            if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.s()) {
                unifiedNativeAdMapper.H(videoController);
            }
        }
        try {
            this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.zza.zzi();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i3) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 44);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i3);
        sb.append(".");
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.zza.zzg(i3);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        int iA = adError.a();
        String strC = adError.c();
        String strB = adError.b();
        int length = String.valueOf(iA).length();
        StringBuilder sb = new StringBuilder(length + 71 + String.valueOf(strC).length() + 15 + String.valueOf(strB).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(iA);
        sb.append(". ErrorMessage: ");
        sb.append(strC);
        sb.append(". ErrorDomain: ");
        sb.append(strB);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.zza.zzx(adError.d());
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i3) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 44);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i3);
        sb.append(".");
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.zza.zzg(i3);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, AdError adError) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        int iA = adError.a();
        String strC = adError.c();
        String strB = adError.b();
        int length = String.valueOf(iA).length();
        StringBuilder sb = new StringBuilder(length + 71 + String.valueOf(strC).length() + 15 + String.valueOf(strB).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(iA);
        sb.append(". ErrorMessage: ");
        sb.append(strC);
        sb.append(". ErrorDomain: ");
        sb.append(strB);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.zza.zzx(adError.d());
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
