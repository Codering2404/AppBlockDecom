package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbf extends zzhbh {
    zzhbf(zzgwi zzgwiVar, boolean z2) {
        super(zzgwiVar, z2);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzhbh
    public final /* bridge */ /* synthetic */ Object zzD(List list) {
        ArrayList arrayListZzb = zzgxm.zzb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhbg zzhbgVar = (zzhbg) it.next();
            arrayListZzb.add(zzhbgVar != null ? zzhbgVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZzb);
    }
}
