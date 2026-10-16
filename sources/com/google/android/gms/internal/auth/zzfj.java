package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfj extends zzfl {
    /* synthetic */ zzfj(zzfi zzfiVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zza(Object obj, long j3) {
        ((zzez) zzhj.zzf(obj, j3)).zzb();
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zzb(Object obj, Object obj2, long j3) {
        zzez zzezVarZzd = (zzez) zzhj.zzf(obj, j3);
        zzez zzezVar = (zzez) zzhj.zzf(obj2, j3);
        int size = zzezVarZzd.size();
        int size2 = zzezVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzezVarZzd.zzc()) {
                zzezVarZzd = zzezVarZzd.zzd(size2 + size);
            }
            zzezVarZzd.addAll(zzezVar);
        }
        if (size > 0) {
            zzezVar = zzezVarZzd;
        }
        zzhj.zzp(obj, j3, zzezVar);
    }

    private zzfj() {
        super(null);
    }
}
