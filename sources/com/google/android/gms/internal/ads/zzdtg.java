package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzdtg implements zzgta {
    static final /* synthetic */ zzdtg zza = new zzdtg();

    private /* synthetic */ zzdtg() {
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzdte zzdteVar : (List) obj) {
            if (zzdteVar != null) {
                arrayList.add(zzdteVar);
            }
        }
        return arrayList;
    }
}
