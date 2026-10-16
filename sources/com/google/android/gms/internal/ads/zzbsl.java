package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbsl extends AdManagerInterstitialAd {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final com.google.android.gms.ads.internal.client.zzbu zzc;
    private final AtomicReference zzd;
    private final zzbuy zze;
    private final long zzf;
    private AppEventListener zzg;
    private FullScreenContentCallback zzh;
    private OnPaidEventListener zzi;
    private final AtomicLong zzj;

    public zzbsl(Context context, com.google.android.gms.ads.internal.client.zzbu zzbuVar) {
        this.zze = new zzbuy();
        this.zzf = System.currentTimeMillis();
        this.zzj = new AtomicLong();
        this.zza = context;
        this.zzd = new AtomicReference();
        this.zzb = com.google.android.gms.ads.internal.client.zzq.f70003a;
        this.zzc = zzbuVar;
    }

    public final String getAdUnitId() {
        String strZzu;
        String str;
        AtomicReference atomicReference = this.zzd;
        if (atomicReference.get() != null) {
            return (String) atomicReference.get();
        }
        synchronized (this) {
            try {
                strZzu = this.zzc.zzu();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                strZzu = null;
            }
            if (strZzu == null) {
                this.zzd.set("");
            } else {
                this.zzd.set(strZzu);
            }
            str = (String) this.zzd.get();
        }
        return str;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzg;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzh;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzi;
    }

    public final long getPlacementId() {
        AtomicLong atomicLong = this.zzj;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                try {
                    com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
                    if (zzbuVar != null) {
                        long jZzU = zzbuVar.zzU();
                        AtomicLong atomicLong2 = this.zzj;
                        atomicLong2.set(jZzU);
                        return atomicLong2.get();
                    }
                } catch (RemoteException e3) {
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                }
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzt = null;
        try {
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzdxVarZzt = zzbuVar.zzt();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        return ResponseInfo.f(zzdxVarZzt);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzg = appEventListener;
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzbuVar.zzi(appEventListener != null ? new zzbff(appEventListener) : null);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzh = fullScreenContentCallback;
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzbuVar.zzS(new com.google.android.gms.ads.internal.client.zzbb(fullScreenContentCallback));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setImmersiveMode(boolean z2) {
        try {
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzbuVar.zzK(z2);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzi = onPaidEventListener;
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzbuVar.zzP(new com.google.android.gms.ads.internal.client.zzfo(onPaidEventListener));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setPlacementId(long j3) {
        try {
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzbuVar.zzT(j3);
                this.zzj.set(j3);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void show(Activity activity) {
        if (activity == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzbuVar.zzR(ObjectWrapper.i5(activity));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzeh zzehVar, AdLoadCallback adLoadCallback) {
        try {
            com.google.android.gms.ads.internal.client.zzbu zzbuVar = this.zzc;
            if (zzbuVar != null) {
                zzehVar.o(this.zzf);
                zzbuVar.zzQ(this.zzb.a(this.zza, zzehVar), new com.google.android.gms.ads.internal.client.zzh(adLoadCallback, this));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", "com.google.android.gms.ads", null, null));
        }
    }

    public zzbsl(Context context, String str) {
        zzbuy zzbuyVar = new zzbuy();
        this.zze = zzbuyVar;
        this.zzf = System.currentTimeMillis();
        this.zzj = new AtomicLong();
        this.zza = context;
        this.zzd = new AtomicReference(str);
        this.zzb = com.google.android.gms.ads.internal.client.zzq.f70003a;
        this.zzc = com.google.android.gms.ads.internal.client.zzay.b().b(context, new com.google.android.gms.ads.internal.client.zzr(), str, zzbuyVar);
    }

    public zzbsl(Context context, String str, com.google.android.gms.ads.internal.client.zzbu zzbuVar) {
        com.google.android.gms.ads.internal.client.zzq zzqVar = com.google.android.gms.ads.internal.client.zzq.f70003a;
        this.zze = new zzbuy();
        this.zzf = System.currentTimeMillis();
        this.zzj = new AtomicLong();
        this.zza = context;
        this.zzd = new AtomicReference(str);
        this.zzb = zzqVar;
        this.zzc = zzbuVar;
    }
}
