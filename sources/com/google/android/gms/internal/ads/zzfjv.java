package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfjv implements zzetr {
    final /* synthetic */ zzfjw zza;

    zzfjv(zzfjw zzfjwVar) {
        Objects.requireNonNull(zzfjwVar);
        this.zza = zzfjwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzfjw zzfjwVar = this.zza;
        synchronized (zzfjwVar) {
            zzfjwVar.zzx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfjw zzfjwVar = this.zza;
        zzdvm zzdvmVar = (zzdvm) obj;
        synchronized (zzfjwVar) {
            try {
                zzfjwVar.zzx(zzdvmVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeu)).booleanValue()) {
                    zzdvmVar.zzh().zza = zzfjwVar.zzv();
                }
                zzfjwVar.zzw().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
