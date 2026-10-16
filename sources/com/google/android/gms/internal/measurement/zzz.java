package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzz {
    final TreeMap zza = new TreeMap();
    final TreeMap zzb = new TreeMap();

    private static final int zzc(zzg zzgVar, zzan zzanVar, zzao zzaoVar) {
        zzao zzaoVarZza = zzanVar.zza(zzgVar, Collections.singletonList(zzaoVar));
        if (zzaoVarZza instanceof zzah) {
            return zzh.zzg(zzaoVarZza.zzd().doubleValue());
        }
        return -1;
    }

    public final void zza(String str, int i3, zzan zzanVar, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.zzb;
        } else {
            if (!"edit".equals(str2)) {
                throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(str2)));
            }
            treeMap = this.zza;
        }
        if (treeMap.containsKey(Integer.valueOf(i3))) {
            i3 = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i3), zzanVar);
    }

    public final void zzb(zzg zzgVar, zzab zzabVar) {
        zzl zzlVar = new zzl(zzabVar);
        TreeMap treeMap = this.zza;
        for (Integer num : treeMap.keySet()) {
            zzaa zzaaVarClone = zzabVar.zzc().clone();
            int iZzc = zzc(zzgVar, (zzan) treeMap.get(num), zzlVar);
            if (iZzc == 2 || iZzc == -1) {
                zzabVar.zzd(zzaaVarClone);
            }
        }
        TreeMap treeMap2 = this.zzb;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            zzc(zzgVar, (zzan) treeMap2.get((Integer) it.next()), zzlVar);
        }
    }
}
