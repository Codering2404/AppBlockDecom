package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfh extends zzfl {
    private static final Class zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    /* synthetic */ zzfh(zzfg zzfgVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zza(Object obj, long j3) {
        Object objUnmodifiableList;
        List list = (List) zzhj.zzf(obj, j3);
        if (list instanceof zzff) {
            objUnmodifiableList = ((zzff) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzge) && (list instanceof zzez)) {
                zzez zzezVar = (zzez) list;
                if (zzezVar.zzc()) {
                    zzezVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhj.zzp(obj, j3, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    final void zzb(Object obj, Object obj2, long j3) {
        List list;
        List list2;
        List list3 = (List) zzhj.zzf(obj2, j3);
        int size = list3.size();
        List list4 = (List) zzhj.zzf(obj, j3);
        if (list4.isEmpty()) {
            List zzfeVar = list4 instanceof zzff ? new zzfe(size) : ((list4 instanceof zzge) && (list4 instanceof zzez)) ? ((zzez) list4).zzd(size) : new ArrayList(size);
            zzhj.zzp(obj, j3, zzfeVar);
            list2 = zzfeVar;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzhj.zzp(obj, j3, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzhe) {
                zzfe zzfeVar2 = new zzfe(list4.size() + size);
                zzfeVar2.addAll(zzfeVar2.size(), (zzhe) list4);
                zzhj.zzp(obj, j3, zzfeVar2);
                list = zzfeVar2;
            } else {
                boolean z2 = list4 instanceof zzge;
                list2 = list4;
                if (z2) {
                    boolean z3 = list4 instanceof zzez;
                    list2 = list4;
                    if (z3) {
                        zzez zzezVar = (zzez) list4;
                        list2 = list4;
                        if (!zzezVar.zzc()) {
                            zzez zzezVarZzd = zzezVar.zzd(list4.size() + size);
                            zzhj.zzp(obj, j3, zzezVarZzd);
                            list2 = zzezVarZzd;
                        }
                    }
                }
            }
            list2 = list;
        }
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzhj.zzp(obj, j3, list3);
    }

    private zzfh() {
        super(null);
    }
}
