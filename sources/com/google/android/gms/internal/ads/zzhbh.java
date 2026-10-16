package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhbh extends zzhay {
    private List zza;

    zzhbh(zzgwi zzgwiVar, boolean z2) {
        super(zzgwiVar, z2, true);
        List listZzb = zzgwiVar.isEmpty() ? Collections.EMPTY_LIST : zzgxm.zzb(zzgwiVar.size());
        for (int i3 = 0; i3 < zzgwiVar.size(); i3++) {
            listZzb.add(null);
        }
        this.zza = listZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzA(int i3) {
        super.zzA(i3);
        this.zza = null;
    }

    abstract Object zzD(List list);

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzw(int i3, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i3, new zzhbg(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhay
    final void zzx() {
        List list = this.zza;
        if (list != null) {
            zza(zzD(list));
        }
    }
}
