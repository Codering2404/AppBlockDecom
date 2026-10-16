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
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzcdc extends RewardedInterstitialAd {
    private final String zza;
    private final zzcci zzb;
    private final Context zzc;
    private FullScreenContentCallback zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;
    private final long zzh = System.currentTimeMillis();
    private final AtomicLong zzi = new AtomicLong();
    private final zzcda zzd = new zzcda();

    public zzcdc(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = com.google.android.gms.ads.internal.client.zzay.b().f(context, str, new zzbuy());
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
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final long getPlacementId() {
        AtomicLong atomicLong = this.zzi;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        synchronized (this) {
            try {
                try {
                    zzcci zzcciVar = this.zzb;
                    if (zzcciVar != null) {
                        long jZzq = zzcciVar.zzq();
                        AtomicLong atomicLong2 = this.zzi;
                        atomicLong2.set(jZzq);
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

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
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
            if (zzccfVarZzl != null) {
                return new zzccs(zzccfVarZzl);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
        return RewardItem.f70829a;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
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
        this.zzf = onAdMetadataChangedListener;
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zzf(new com.google.android.gms.ads.internal.client.zzfn(onAdMetadataChangedListener));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
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
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzcciVar.zzh(new zzccw(serverSideVerificationOptions));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzcda zzcdaVar = this.zzd;
        zzcdaVar.zzc(onUserEarnedRewardListener);
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

    public final void zza(com.google.android.gms.ads.internal.client.zzeh zzehVar, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzcci zzcciVar = this.zzb;
            if (zzcciVar != null) {
                zzehVar.o(this.zzh);
                zzcciVar.zzd(com.google.android.gms.ads.internal.client.zzq.f70003a.a(this.zzc, zzehVar), new zzcdb(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
