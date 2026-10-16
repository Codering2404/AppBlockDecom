package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzepb implements zzhbt {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfki zzb;
    final /* synthetic */ zzfkf zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfry zze;
    final /* synthetic */ zzfkq zzf;
    final /* synthetic */ zzepd zzg;

    zzepb(zzepd zzepdVar, long j3, zzfki zzfkiVar, zzfkf zzfkfVar, String str, zzfry zzfryVar, zzfkq zzfkqVar) {
        this.zza = j3;
        this.zzb = zzfkiVar;
        this.zzc = zzfkfVar;
        this.zzd = str;
        this.zze = zzfryVar;
        this.zzf = zzfkqVar;
        Objects.requireNonNull(zzepdVar);
        this.zzg = zzepdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Throwable r14) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepb.zza(java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        long j3;
        zzepd zzepdVar = this.zzg;
        long jA = zzepdVar.zzj().a() - this.zza;
        synchronized (zzepdVar) {
            try {
                if (zzepdVar.zzn()) {
                    j3 = jA;
                    zzepdVar.zzk().zza(this.zzb, this.zzc, 0, null, j3);
                } else {
                    j3 = jA;
                }
                if (zzepdVar.zzp()) {
                    return;
                }
                zzfkf zzfkfVar = this.zzc;
                if (zzepdVar.zzi(zzfkfVar)) {
                    ((zzepc) zzepdVar.zzm().get(zzfkfVar)).zzd = j3;
                } else {
                    long j4 = j3;
                    j3 = j4;
                    zzepdVar.zzm().put(zzfkfVar, new zzepc(this.zzd, zzfkfVar.zzaf, 0, j4, null));
                }
                zzepdVar.zzo().zzd(zzfkfVar, j3, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
