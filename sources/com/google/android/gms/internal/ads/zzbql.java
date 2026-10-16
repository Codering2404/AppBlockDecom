package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbql implements zzbpq {
    private final zzecr zza;

    public zzbql(zzecr zzecrVar) {
        Preconditions.n(zzecrVar, "The Inspector Manager must not be null");
        this.zza = zzecrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey("extras")) {
            return;
        }
        long j3 = Long.MAX_VALUE;
        if (map.containsKey("expires")) {
            try {
                j3 = Long.parseLong((String) map.get("expires"));
            } catch (NumberFormatException unused) {
            }
        }
        this.zza.zzi((String) map.get("extras"), j3);
    }
}
