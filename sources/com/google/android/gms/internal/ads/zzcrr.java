package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcrr {
    private final Map zza;
    private final Map zzb;

    zzcrr(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfkq zzfkqVar) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        for (zzfko zzfkoVar : zzfkqVar.zzb.zzc) {
            Map map = this.zza;
            String str = zzfkoVar.zza;
            if (!map.containsKey(str) || (jSONObject2 = zzfkoVar.zzb) == null) {
                Map map2 = this.zzb;
                if (map2.containsKey(str) && (jSONObject = zzfkoVar.zzb) != null) {
                    zzcrt zzcrtVar = (zzcrt) map2.get(str);
                    HashMap map3 = new HashMap();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObject.optString(next);
                        if (strOptString != null) {
                            map3.put(next, strOptString);
                        }
                    }
                    zzcrtVar.zza(map3);
                }
            } else {
                ((zzcru) map.get(str)).zza(jSONObject2);
            }
        }
    }
}
