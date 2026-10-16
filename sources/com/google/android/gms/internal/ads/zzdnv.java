package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdnv implements zzcxw {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzinj zzd;
    private final zzdqd zze;

    zzdnv(Map map, Map map2, Map map3, zzinj zzinjVar, zzdqd zzdqdVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzinjVar;
        this.zze = zzdqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcxw
    public final zzels zza(int i3, String str) {
        zzels zzelsVarZza;
        zzels zzelsVar = (zzels) this.zza.get(str);
        if (zzelsVar != null) {
            return zzelsVar;
        }
        if (i3 != 1) {
            if (i3 != 4) {
                return null;
            }
            zzeny zzenyVar = (zzeny) this.zzc.get(str);
            if (zzenyVar != null) {
                return zzcyb.zza(zzenyVar);
            }
            zzelsVarZza = (zzels) this.zzb.get(str);
            if (zzelsVarZza == null) {
                return null;
            }
        } else if (this.zze.zzd() == null || (zzelsVarZza = ((zzcxw) this.zzd.zzb()).zza(i3, str)) == null) {
            return null;
        }
        return zzcyb.zzb(zzelsVarZza);
    }
}
