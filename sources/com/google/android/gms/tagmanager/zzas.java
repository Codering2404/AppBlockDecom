package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzas implements zzav {
    final /* synthetic */ DataLayer zza;

    zzas(DataLayer dataLayer) {
        this.zza = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzav
    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzat zzatVar = (zzat) it.next();
            DataLayer dataLayer = this.zza;
            dataLayer.zzi(dataLayer.zza(zzatVar.zza, zzatVar.zzb));
        }
        this.zza.zzh.countDown();
    }
}
