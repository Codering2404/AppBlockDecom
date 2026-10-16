package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbpe implements zzbpq {
    zzbpe() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        if (map.containsKey("start")) {
            zzckuVar.zzas(true);
        }
        if (map.containsKey("stop")) {
            zzckuVar.zzas(false);
        }
    }
}
