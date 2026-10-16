package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyq extends zzyu {
    private static final Class zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    /* synthetic */ zzyq(zzyp zzypVar) {
        super(null);
    }

    private static List zzf(Object obj, long j3, int i3) {
        List list = (List) zzaau.zzf(obj, j3);
        if (list.isEmpty()) {
            List zzynVar = list instanceof zzyo ? new zzyn(i3) : ((list instanceof zzzo) && (list instanceof zzyd)) ? ((zzyd) list).zzd(i3) : new ArrayList(i3);
            zzaau.zzs(obj, j3, zzynVar);
            return zzynVar;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList = new ArrayList(list.size() + i3);
            arrayList.addAll(list);
            zzaau.zzs(obj, j3, arrayList);
            return arrayList;
        }
        if (list instanceof zzaap) {
            zzyn zzynVar2 = new zzyn(list.size() + i3);
            zzynVar2.addAll(zzynVar2.size(), (zzaap) list);
            zzaau.zzs(obj, j3, zzynVar2);
            return zzynVar2;
        }
        if ((list instanceof zzzo) && (list instanceof zzyd)) {
            zzyd zzydVar = (zzyd) list;
            if (!zzydVar.zzc()) {
                zzyd zzydVarZzd = zzydVar.zzd(list.size() + i3);
                zzaau.zzs(obj, j3, zzydVarZzd);
                return zzydVarZzd;
            }
        }
        return list;
    }

    @Override // com.google.android.gms.internal.gtm.zzyu
    final List zza(Object obj, long j3) {
        return zzf(obj, j3, 10);
    }

    @Override // com.google.android.gms.internal.gtm.zzyu
    final void zzb(Object obj, long j3) {
        Object objUnmodifiableList;
        List list = (List) zzaau.zzf(obj, j3);
        if (list instanceof zzyo) {
            objUnmodifiableList = ((zzyo) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzzo) && (list instanceof zzyd)) {
                zzyd zzydVar = (zzyd) list;
                if (zzydVar.zzc()) {
                    zzydVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzaau.zzs(obj, j3, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.gtm.zzyu
    final void zzc(Object obj, Object obj2, long j3) {
        List list = (List) zzaau.zzf(obj2, j3);
        List listZzf = zzf(obj, j3, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzaau.zzs(obj, j3, list);
    }

    private zzyq() {
        super(null);
    }
}
