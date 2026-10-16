package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzrz;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeo implements zzeq {
    final /* synthetic */ Map zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ Map zzc;
    final /* synthetic */ Map zzd;

    zzeo(zzet zzetVar, Map map, Map map2, Map map3, Map map4) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = map4;
    }

    @Override // com.google.android.gms.tagmanager.zzeq
    public final void zza(zzrz zzrzVar, Set set, Set set2, zzdn zzdnVar) {
        List list = (List) this.zza.get(zzrzVar);
        if (list != null) {
            set.addAll(list);
        }
        List list2 = (List) this.zzc.get(zzrzVar);
        if (list2 != null) {
            set2.addAll(list2);
        }
    }
}
