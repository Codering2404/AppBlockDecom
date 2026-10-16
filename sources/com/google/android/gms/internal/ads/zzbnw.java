package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbnw extends UnifiedNativeAd {
    private final zzbnv zza;
    private final zzbmf zzc;
    private final List zzb = new ArrayList();
    private final VideoController zzd = new VideoController();
    private final List zze = new ArrayList();

    public zzbnw(zzbnv zzbnvVar) {
        zzbme zzbmcVar;
        this.zza = zzbnvVar;
        zzbmf zzbmfVar = null;
        try {
            List listZzf = zzbnvVar.zzf();
            if (listZzf != null) {
                for (Object obj : listZzf) {
                    if (obj instanceof IBinder) {
                        IBinder iBinder = (IBinder) obj;
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzbmcVar = iInterfaceQueryLocalInterface instanceof zzbme ? (zzbme) iInterfaceQueryLocalInterface : new zzbmc(iBinder);
                    } else {
                        zzbmcVar = null;
                    }
                    if (zzbmcVar != null) {
                        this.zzb.add(new zzbmf(zzbmcVar));
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
            zzbme zzbmeVarZzh = this.zza.zzh();
            if (zzbmeVarZzh != null) {
                zzbmfVar = new zzbmf(zzbmeVarZzh);
            }
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e5);
        }
        this.zzc = zzbmfVar;
        try {
            if (this.zza.zzq() != null) {
                new zzbly(this.zza.zzq());
            }
        } catch (RemoteException e6) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e6);
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzr(bundle);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zza() {
        try {
            return this.zza.zze();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzc() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zze() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzf() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double zzg() {
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

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzh() {
        try {
            return this.zza.zzl();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzi() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController zzj() {
        try {
            zzbnv zzbnvVar = this.zza;
            if (zzbnvVar.zzn() != null) {
                this.zzd.b(zzbnvVar.zzn());
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception occurred while getting video controller", e3);
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzk() {
        try {
            IObjectWrapper iObjectWrapperZzv = this.zza.zzv();
            if (iObjectWrapperZzv != null) {
                return ObjectWrapper.h5(iObjectWrapperZzv);
            }
            return null;
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            return null;
        }
    }
}
