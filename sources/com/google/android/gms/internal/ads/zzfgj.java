package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfgj implements zzetr {
    final /* synthetic */ zzfgm zza;

    zzfgj(zzfgm zzfgmVar) {
        Objects.requireNonNull(zzfgmVar);
        this.zza = zzfgmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzfgm zzfgmVar = this.zza;
        synchronized (zzfgmVar) {
            zzfgmVar.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcvf zzcvfVar = (zzcvf) obj;
        zzfgm zzfgmVar = this.zza;
        synchronized (zzfgmVar) {
            try {
                zzcvf zzcvfVar2 = zzfgmVar.zza;
                if (zzcvfVar2 != null) {
                    zzcvfVar2.zzd();
                }
                zzfgmVar.zza = zzcvfVar;
                zzcvfVar.zza(zzfgmVar);
                zzfgmVar.zzO().zzt(new zzcvg(zzcvfVar, zzfgmVar, zzfgmVar.zzO(), zzfgmVar.zzV()));
                zzcvfVar.zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
