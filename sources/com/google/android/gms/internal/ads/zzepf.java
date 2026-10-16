package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzepf {
    private final zzflr zza;
    private final zzdwz zzb;
    private final zzdzl zzc;

    public zzepf(zzflr zzflrVar, zzdwz zzdwzVar, zzdzl zzdzlVar) {
        this.zza = zzflrVar;
        this.zzb = zzdwzVar;
        this.zzc = zzdzlVar;
    }

    public final void zza(zzfki zzfkiVar, zzfkf zzfkfVar, int i3, @Nullable zzelw zzelwVar, long j3) {
        zzdwy zzdwyVarZzc;
        zzdzk zzdzkVarZza = this.zzc.zza();
        zzdzkVarZza.zza(zzfkiVar);
        zzdzkVarZza.zzb(zzfkfVar);
        zzdzkVarZza.zzc("action", "adapter_status");
        zzdzkVarZza.zzc("adapter_l", String.valueOf(j3));
        zzdzkVarZza.zzc("sc", Integer.toString(i3));
        if (zzelwVar != null) {
            zzdzkVarZza.zzc("arec", Integer.toString(zzelwVar.zzb().f69851a));
            String strZza = this.zza.zza(zzelwVar.getMessage());
            if (strZza != null) {
                zzdzkVarZza.zzc("areec", strZza);
            }
        }
        zzdwz zzdwzVar = this.zzb;
        Iterator it = zzfkfVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdwyVarZzc = null;
                break;
            } else {
                zzdwyVarZzc = zzdwzVar.zzc((String) it.next());
                if (zzdwyVarZzc != null) {
                    break;
                }
            }
        }
        if (zzdwyVarZzc != null) {
            zzdzkVarZza.zzc("ancn", zzdwyVarZzc.zza);
            zzbxq zzbxqVar = zzdwyVarZzc.zzb;
            if (zzbxqVar != null) {
                zzdzkVarZza.zzc("adapter_v", zzbxqVar.toString());
            }
            zzbxq zzbxqVar2 = zzdwyVarZzc.zzc;
            if (zzbxqVar2 != null) {
                zzdzkVarZza.zzc("adapter_sv", zzbxqVar2.toString());
            }
        }
        zzdzkVarZza.zzd();
    }
}
