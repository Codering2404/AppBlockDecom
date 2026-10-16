package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzys extends zzyu {
    /* synthetic */ zzys(zzyr zzyrVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.gtm.zzyu
    final List zza(Object obj, long j3) {
        zzyd zzydVar = (zzyd) zzaau.zzf(obj, j3);
        if (zzydVar.zzc()) {
            return zzydVar;
        }
        int size = zzydVar.size();
        zzyd zzydVarZzd = zzydVar.zzd(size == 0 ? 10 : size + size);
        zzaau.zzs(obj, j3, zzydVarZzd);
        return zzydVarZzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzyu
    final void zzb(Object obj, long j3) {
        ((zzyd) zzaau.zzf(obj, j3)).zzb();
    }

    @Override // com.google.android.gms.internal.gtm.zzyu
    final void zzc(Object obj, Object obj2, long j3) {
        zzyd zzydVarZzd = (zzyd) zzaau.zzf(obj, j3);
        zzyd zzydVar = (zzyd) zzaau.zzf(obj2, j3);
        int size = zzydVarZzd.size();
        int size2 = zzydVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzydVarZzd.zzc()) {
                zzydVarZzd = zzydVarZzd.zzd(size2 + size);
            }
            zzydVarZzd.addAll(zzydVar);
        }
        if (size > 0) {
            zzydVar = zzydVarZzd;
        }
        zzaau.zzs(obj, j3, zzydVar);
    }

    private zzys() {
        super(null);
    }
}
