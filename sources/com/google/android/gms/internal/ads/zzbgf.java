package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbgf extends AppOpenAd {
    FullScreenContentCallback zza;
    private final zzbgj zzb;
    private final AtomicReference zzc;
    private final zzbgg zzd;
    private OnPaidEventListener zze;
    private final AtomicLong zzf;

    public zzbgf(zzbgj zzbgjVar) {
        this.zzd = new zzbgg();
        this.zzf = new AtomicLong();
        this.zzb = zzbgjVar;
        this.zzc = new AtomicReference();
    }

    public final String getAdUnitId() {
        String strZzj;
        String str;
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() != null) {
            return (String) atomicReference.get();
        }
        synchronized (this) {
            try {
                strZzj = this.zzb.zzj();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                strZzj = null;
            }
            if (strZzj == null) {
                this.zzc.set("");
            } else {
                this.zzc.set(strZzj);
            }
            str = (String) this.zzc.get();
        }
        return str;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zza;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zze;
    }

    public final long getPlacementId() {
        long j3;
        AtomicLong atomicLong = this.zzf;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                try {
                    long jZzk = this.zzb.zzk();
                    AtomicLong atomicLong2 = this.zzf;
                    atomicLong2.set(jZzk);
                    j3 = atomicLong2.get();
                } catch (RemoteException e3) {
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                    return 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j3;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzg;
        try {
            zzdxVarZzg = this.zzb.zzg();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            zzdxVarZzg = null;
        }
        return ResponseInfo.f(zzdxVarZzg);
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z2) {
        try {
            this.zzb.zzh(z2);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zze = onPaidEventListener;
        try {
            this.zzb.zzi(new com.google.android.gms.ads.internal.client.zzfo(onPaidEventListener));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setPlacementId(long j3) {
        try {
            this.zzb.zzl(j3);
            this.zzf.set(j3);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void show(Activity activity) {
        try {
            this.zzb.zzf(ObjectWrapper.i5(activity), this.zzd);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public zzbgf(zzbgj zzbgjVar, String str) {
        this.zzd = new zzbgg();
        this.zzf = new AtomicLong();
        this.zzb = zzbgjVar;
        this.zzc = new AtomicReference(str);
    }
}
