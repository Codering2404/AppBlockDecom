package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeps extends zzbwx {
    private final zzelv zza;

    /* synthetic */ zzeps(zzept zzeptVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzeptVar);
        this.zza = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() throws RemoteException {
        ((zzenh) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf(String str) throws RemoteException {
        ((zzenh) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzenh) this.zza.zzc).zzx(zzeVar);
    }
}
