package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzepx implements zzelu {
    private final Map zza = new HashMap();
    private final zzdxc zzb;

    public zzepx(zzdxc zzdxcVar) {
        this.zzb = zzdxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final zzelv zza(String str, JSONObject jSONObject) throws zzflf {
        zzelv zzelvVar;
        synchronized (this) {
            try {
                Map map = this.zza;
                zzelvVar = (zzelv) map.get(str);
                if (zzelvVar == null) {
                    zzelvVar = new zzelv(this.zzb.zza(str, jSONObject), new zzeni(), str);
                    map.put(str, zzelvVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzelvVar;
    }
}
