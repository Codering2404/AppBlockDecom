package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzccr extends RewardedAd {
    private final AtomicReference zza;
    private final zzcci zzb;
    private final Context zzc;
    private final zzcda zzd;
    private OnAdMetadataChangedListener zze;
    private OnPaidEventListener zzf;
    private FullScreenContentCallback zzg;
    private final long zzh;
    private final AtomicLong zzi;

    public zzccr(Context context, zzcci zzcciVar) {
        this.zzh = System.currentTimeMillis();
        this.zzi = new AtomicLong();
        this.zzc = context.getApplicationContext();
        this.zza = new AtomicReference();
        this.zzb = zzcciVar;
        this.zzd = new zzcda();
    }

    public final Bundle getAdMetadata() {
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                return zzcciVar.zzg();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        String strZzn;
        String str;
        AtomicReference atomicReference = this.zza;
        if (atomicReference.get() != null) {
            return (String) atomicReference.get();
        }
        synchronized (this) {
            try {
                strZzn = this.zzb.zzn();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                strZzn = null;
            }
            if (strZzn == null) {
                this.zza.set("");
            } else {
                this.zza.set(strZzn);
            }
            str = (String) this.zza.get();
        }
        return str;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
    }

    public final long getPlacementId() {
        long j3;
        zzcci zzcciVar;
        AtomicLong atomicLong = this.zzi;
        long jZzq = 0;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                zzcciVar = this.zzb;
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
            if (zzcciVar != null) {
                jZzq = zzcciVar.zzq();
                AtomicLong atomicLong2 = this.zzi;
                atomicLong2.set(jZzq);
                j3 = atomicLong2.get();
            } else {
                AtomicLong atomicLong22 = this.zzi;
                atomicLong22.set(jZzq);
                j3 = atomicLong22.get();
            }
        }
        return j3;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzm = null;
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzdxVarZzm = zzcciVar.zzm();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        return ResponseInfo.f(zzdxVarZzm);
    }

    public final RewardItem getRewardItem() {
        try {
            zzcci zzcciVar = this.zzb;
            zzccf zzccfVarZzl = zzcciVar != null ? zzcciVar.zzl() : null;
            return zzccfVarZzl == null ? RewardItem.f70829a : new zzccs(zzccfVarZzl);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            return RewardItem.f70829a;
        }
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z2) {
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zzp(z2);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zze = onAdMetadataChangedListener;
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zzf(new com.google.android.gms.ads.internal.client.zzfn(onAdMetadataChangedListener));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zzo(new com.google.android.gms.ads.internal.client.zzfo(onPaidEventListener));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setPlacementId(long j3) {
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zzr(j3);
                this.zzi.set(j3);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzcci zzcciVar = this.zzb;
                if (zzcciVar != null) {
                    zzcciVar.zzh(new zzccw(serverSideVerificationOptions));
                }
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzcda zzcdaVar = this.zzd;
        zzcdaVar.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zze(zzcdaVar);
                zzcciVar.zzb(ObjectWrapper.i5(activity));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzeh zzehVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzehVar.o(this.zzh);
                zzcciVar.zzc(com.google.android.gms.ads.internal.client.zzq.f70003a.a(this.zzc, zzehVar), new zzccv(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public zzccr(Context context, String str) {
        this(context, str, com.google.android.gms.ads.internal.client.zzay.b().f(context, str, new zzbuy()));
    }

    public zzccr(Context context, String str, zzcci zzcciVar) {
        this.zzh = System.currentTimeMillis();
        this.zzi = new AtomicLong();
        this.zzc = context.getApplicationContext();
        this.zza = new AtomicReference(str);
        this.zzb = zzcciVar;
        this.zzd = new zzcda();
    }
}
