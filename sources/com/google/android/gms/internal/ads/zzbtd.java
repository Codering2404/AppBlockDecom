package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbtd implements zzcga {
    final /* synthetic */ zzbtt zza;
    final /* synthetic */ zzfpw zzb;
    final /* synthetic */ zzbtu zzc;

    zzbtd(zzbtu zzbtuVar, zzbtt zzbttVar, zzfpw zzfpwVar) {
        this.zza = zzbttVar;
        this.zzb = zzfpwVar;
        Objects.requireNonNull(zzbtuVar);
        this.zzc = zzbtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcga
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (success): Trying to acquire lock");
        zzbtu zzbtuVar = this.zzc;
        synchronized (zzbtuVar.zzg()) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (success): Lock acquired");
                zzbtuVar.zzl(0);
                if (zzbtuVar.zzi() != null && this.zza != zzbtuVar.zzi()) {
                    com.google.android.gms.ads.internal.util.zze.k("New JS engine is loaded, marking previous one as destroyable.");
                    zzbtuVar.zzi().zzc();
                }
                zzbtuVar.zzj(this.zza);
                if (((Boolean) zzbkj.zzd.zze()).booleanValue() && zzbtuVar.zzh() != null) {
                    zzfqj zzfqjVarZzh = zzbtuVar.zzh();
                    zzfpw zzfpwVar = this.zzb;
                    zzfpwVar.zzd(true);
                    zzfqjVarZzh.zzb(zzfpwVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (success): Lock released");
    }
}
