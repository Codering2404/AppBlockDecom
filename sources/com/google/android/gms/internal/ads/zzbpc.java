package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbpc implements zzbpq {
    zzbpc() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzckuVar.zzdk();
        } else if ("resume".equals(str)) {
            zzckuVar.zzdl();
        }
    }
}
