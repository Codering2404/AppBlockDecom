package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzk extends zzai {
    private final zzab zza;

    public zzk(zzab zzabVar) {
        super("internal.eventLogger");
        this.zza = zzabVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        zzh.zza(this.zzd, 3, list);
        String strZzc = zzgVar.zza((zzao) list.get(0)).zzc();
        long jZzi = (long) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
        zzao zzaoVarZza = zzgVar.zza((zzao) list.get(2));
        this.zza.zze(strZzc, jZzi, zzaoVarZza instanceof zzal ? zzh.zzk((zzal) zzaoVarZza) : new HashMap());
        return zzao.zzf;
    }
}
