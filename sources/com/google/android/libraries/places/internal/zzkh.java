package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzkh {
    zzkh() {
    }

    static final List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzaww zzawwVar = (zzaww) it.next();
            int iG = zzawwVar.G();
            int iH = zzawwVar.H() - zzawwVar.G();
            com.google.android.libraries.places.api.model.zzfr zzfrVarE = com.google.android.libraries.places.api.model.zzfs.e();
            zzfrVarE.a(iG);
            zzfrVarE.b(iH);
            arrayList.add(zzfrVarE.c());
        }
        return arrayList;
    }
}
