package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzba extends com.google.android.gms.analytics.zzj {
    private final Map zza = new HashMap(4);

    public final String toString() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.zza.entrySet()) {
            String strValueOf = String.valueOf(entry.getKey());
            map.put("metric".concat(strValueOf), entry.getValue());
        }
        return com.google.android.gms.analytics.zzj.zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        ((zzba) zzjVar).zza.putAll(this.zza);
    }

    public final Map zzd() {
        return Collections.unmodifiableMap(this.zza);
    }
}
