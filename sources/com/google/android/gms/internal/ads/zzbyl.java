package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.comparisons.xn.YvFRmou;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyl extends NativeAd {
    private final zzbnv zza;
    private final zzbyk zzc;
    private final NativeAd.AdChoicesInfo zzd;
    private final List zzb = new ArrayList();
    private final List zze = new ArrayList();
    private final AtomicLong zzf = new AtomicLong();

    public zzbyl(zzbnv zzbnvVar) {
        zzbme zzbmeVarZzh;
        this.zza = zzbnvVar;
        zzbyi zzbyiVar = null;
        try {
            List listZzf = zzbnvVar.zzf();
            if (listZzf != null) {
                for (Object obj : listZzf) {
                    zzbme zzbmeVarZzh2 = obj instanceof IBinder ? zzbmd.zzh((IBinder) obj) : null;
                    if (zzbmeVarZzh2 != null) {
                        this.zzb.add(new zzbyk(zzbmeVarZzh2));
                    }
                }
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        try {
            List listZzz = this.zza.zzz();
            if (listZzz != null) {
                for (Object obj2 : listZzz) {
                    com.google.android.gms.ads.internal.client.zzdg zzdgVarX3 = obj2 instanceof IBinder ? com.google.android.gms.ads.internal.client.zzdf.x3((IBinder) obj2) : null;
                    if (zzdgVarX3 != null) {
                        this.zze.add(new com.google.android.gms.ads.internal.client.zzdh(zzdgVarX3));
                    }
                }
            }
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
        try {
            zzbmeVarZzh = this.zza.zzh();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
        }
        zzbyk zzbykVar = zzbmeVarZzh != null ? new zzbyk(zzbmeVarZzh) : null;
        this.zzc = zzbykVar;
        try {
            if (this.zza.zzq() != null) {
                zzbyiVar = new zzbyi(this.zza.zzq());
            }
        } catch (RemoteException e6) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e6);
        }
        this.zzd = zzbyiVar;
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzy();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to cancelUnconfirmedClick", e3);
        }
    }

    public final void destroy() {
        try {
            this.zza.zzp();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzD();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzd;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getBody() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final String getHeadline() {
        try {
            return this.zza.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final MediaContent getMediaContent() {
        try {
            zzbnv zzbnvVar = this.zza;
            if (zzbnvVar.zzF() != null) {
                return new com.google.android.gms.ads.internal.client.zzfb(zzbnvVar.zzF(), null);
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        return null;
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
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
                    long jZzK = this.zza.zzK();
                    AtomicLong atomicLong2 = this.zzf;
                    atomicLong2.set(jZzK);
                    j3 = atomicLong2.get();
                } catch (RemoteException e3) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("Failed to getPlacementId", e3);
                    return 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return j3;
    }

    public final String getPrice() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    public final ResponseInfo getResponseInfo() {
        com.google.android.gms.ads.internal.client.zzdx zzdxVarZzH;
        try {
            zzdxVarZzH = this.zza.zzH();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            zzdxVarZzH = null;
        }
        return ResponseInfo.e(zzdxVarZzH);
    }

    public final Double getStarRating() {
        try {
            double dZzk = this.zza.zzk();
            if (dZzk == -1.0d) {
                return null;
            }
            return Double.valueOf(dZzk);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzA();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            try {
                if (this.zza.zzA()) {
                    if (muteThisAdReason == null) {
                        this.zza.zzB(null);
                        return;
                    } else if (muteThisAdReason instanceof com.google.android.gms.ads.internal.client.zzdh) {
                        this.zza.zzB(((com.google.android.gms.ads.internal.client.zzdh) muteThisAdReason).a());
                        return;
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzo.c("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                        return;
                    }
                }
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            }
            com.google.android.gms.ads.internal.util.client.zzo.c("Ad is not custom mute enabled");
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzr(bundle);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzE();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    protected final void recordEvent(Bundle bundle) {
        try {
            this.zza.zzJ(bundle);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to record native event", e3);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzs(bundle);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzt(bundle);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zza.zzC(new com.google.android.gms.ads.internal.client.zzdd(muteThisAdListener));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzI(new com.google.android.gms.ads.internal.client.zzfo(onPaidEventListener));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to setOnPaidEventListener", e3);
        }
    }

    public final void setPlacementId(long j3) {
        try {
            this.zza.zzL(j3);
            this.zzf.set(j3);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to setPlacementId", e3);
        }
    }

    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzx(new zzbyr(unconfirmedClickListener));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to setUnconfirmedClickListener", e3);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd
    protected final /* bridge */ /* synthetic */ Object zza() {
        try {
            return this.zza.zzu();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle bundleZzw = this.zza.zzw();
            if (bundleZzw != null) {
                return bundleZzw;
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d(YvFRmou.cNPFXrzc, e3);
        }
        return new Bundle();
    }
}
