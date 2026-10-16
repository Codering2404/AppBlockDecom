package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfka implements zzetr {
    final /* synthetic */ zzfkc zza;

    zzfka(zzfkc zzfkcVar) {
        Objects.requireNonNull(zzfkcVar);
        this.zza = zzfkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzfkc zzfkcVar = this.zza;
        synchronized (zzfkcVar) {
            zzfkcVar.zzx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkc zzfkcVar = this.zza;
        zzdvm zzdvmVar = (zzdvm) obj;
        synchronized (zzfkcVar) {
            try {
                zzfkcVar.zzx(zzdvmVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzeu)).booleanValue()) {
                    zzdvmVar.zzh().zza = zzfkcVar.zzv();
                }
                zzfkcVar.zzw().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
