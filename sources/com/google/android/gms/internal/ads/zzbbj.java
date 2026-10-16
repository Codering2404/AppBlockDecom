package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbbj extends zzazh {
    public Long zza;
    public Boolean zzb;
    public Boolean zzc;

    public zzbbj() {
    }

    @Override // com.google.android.gms.internal.ads.zzazh
    protected final HashMap zza() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        map.put(2, this.zzc);
        return map;
    }

    public zzbbj(String str) {
        HashMap mapZzb = zzazh.zzb(str);
        if (mapZzb != null) {
            this.zza = (Long) mapZzb.get(0);
            this.zzb = (Boolean) mapZzb.get(1);
            this.zzc = (Boolean) mapZzb.get(2);
        }
    }
}
