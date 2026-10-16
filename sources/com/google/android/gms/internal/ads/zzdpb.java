package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdpb extends zzbma {
    private final zzdpt zza;
    private IObjectWrapper zzb;

    public zzdpb(zzdpt zzdptVar) {
        this.zza = zzdptVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.h5(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final float zze() throws RemoteException {
        zzcne zzcneVarZzN;
        int i3;
        int i4;
        zzdpt zzdptVar = this.zza;
        if (zzdptVar.zzab() != 0.0f) {
            return zzdptVar.zzab();
        }
        if (zzdptVar.zzy() != null) {
            try {
                return zzdptVar.zzy().zzm();
            } catch (RemoteException e3) {
                int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Remote exception getting video controller aspect ratio.", e3);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznP)).booleanValue() && zzdptVar.zzU() != null && (zzcneVarZzN = zzdptVar.zzU().zzN()) != null && (i3 = zzcneVarZzN.zzb) >= 0 && (i4 = zzcneVarZzN.zza) > 0) {
            return i3 / i4;
        }
        zzbme zzbmeVarZzD = zzdptVar.zzD();
        if (zzbmeVarZzD == null) {
            return 0.0f;
        }
        float fZze = (zzbmeVarZzD.zze() == -1 || zzbmeVarZzD.zzf() == -1) ? 0.0f : zzbmeVarZzD.zze() / zzbmeVarZzD.zzf();
        return fZze == 0.0f ? zzb(zzbmeVarZzD.zzb()) : fZze;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final IObjectWrapper zzg() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbme zzbmeVarZzD = this.zza.zzD();
        if (zzbmeVarZzD == null) {
            return null;
        }
        return zzbmeVarZzD.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final float zzh() throws RemoteException {
        zzdpt zzdptVar = this.zza;
        if (zzdptVar.zzy() != null) {
            return zzdptVar.zzy().zzj();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final float zzi() throws RemoteException {
        zzdpt zzdptVar = this.zza;
        if (zzdptVar.zzy() != null) {
            return zzdptVar.zzy().zzk();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final com.google.android.gms.ads.internal.client.zzea zzj() throws RemoteException {
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final boolean zzk() throws RemoteException {
        return this.zza.zzy() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final boolean zzl() throws RemoteException {
        return this.zza.zzV();
    }

    @Override // com.google.android.gms.internal.ads.zzbmb
    public final void zzm(zzbnj zzbnjVar) {
        zzdpt zzdptVar = this.zza;
        if (zzdptVar.zzy() instanceof zzcma) {
            ((zzcma) zzdptVar.zzy()).zzv(zzbnjVar);
        }
    }
}
