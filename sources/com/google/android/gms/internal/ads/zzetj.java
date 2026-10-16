package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzetj implements zzetr {
    final /* synthetic */ zzetk zza;

    zzetj(zzetk zzetkVar) {
        Objects.requireNonNull(zzetkVar);
        this.zza = zzetkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzetk zzetkVar = this.zza;
        synchronized (zzetkVar) {
            zzetkVar.zzN(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzetk zzetkVar = this.zza;
        zzdlz zzdlzVar = (zzdlz) obj;
        synchronized (zzetkVar) {
            zzetkVar.zzN(zzdlzVar);
            zzetkVar.zzM().zzj();
        }
    }
}
