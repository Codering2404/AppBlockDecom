package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeoi extends zzbwu {
    final /* synthetic */ zzeoj zza;
    private final zzelv zzb;

    /* synthetic */ zzeoi(zzeoj zzeojVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzeojVar);
        this.zza = zzeojVar;
        this.zzb = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zze(zzbvr zzbvrVar) throws RemoteException {
        this.zza.zzc(zzbvrVar);
        ((zzenh) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzf(String str) throws RemoteException {
        ((zzenh) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzenh) this.zzb.zzc).zzx(zzeVar);
    }
}
