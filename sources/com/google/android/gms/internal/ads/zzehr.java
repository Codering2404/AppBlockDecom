package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzehr implements zzhbt {
    final /* synthetic */ zzcam zza;
    final /* synthetic */ zzcav zzb;

    zzehr(zzeii zzeiiVar, zzcav zzcavVar, zzcam zzcamVar) {
        this.zzb = zzcavVar;
        this.zza = zzcamVar;
        Objects.requireNonNull(zzeiiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        try {
            this.zzb.zzf(com.google.android.gms.ads.internal.util.zzba.M(th));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zzb.zze((String) obj, this.zza);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e3);
        }
    }
}
