package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzena extends zzbwo {
    final /* synthetic */ zzenb zza;
    private final zzelv zzb;

    /* synthetic */ zzena(zzenb zzenbVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzenbVar);
        this.zza = zzenbVar;
        this.zzb = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzd((View) ObjectWrapper.h5(iObjectWrapper));
        ((zzenh) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zzf(String str) throws RemoteException {
        ((zzenh) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzenh) this.zzb.zzc).zzx(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final void zzh(zzbvl zzbvlVar) throws RemoteException {
        this.zza.zze(zzbvlVar);
        ((zzenh) this.zzb.zzc).zzj();
    }
}
