package com.google.android.gms.tagmanager;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaq extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.FUNCTION_CALL.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.FUNCTION_CALL_NAME.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ADDITIONAL_PARAMS.toString();
    private final zzap zzd;

    public zzaq(zzap zzapVar) {
        super(zza, zzb);
        this.zzd = zzapVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        String strZzm = zzfu.zzm(zzfu.zzk((com.google.android.gms.internal.gtm.zzam) map.get(zzb)));
        HashMap map2 = new HashMap();
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        if (zzamVar != null) {
            Object objZzk = zzfu.zzk(zzamVar);
            if (!(objZzk instanceof Map)) {
                Log.w("GoogleTagManager", "FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzfu.zza();
            }
            for (Map.Entry entry : ((Map) objZzk).entrySet()) {
                map2.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzfu.zzb(this.zzd.zza(strZzm, map2));
        } catch (Exception e3) {
            Log.w("GoogleTagManager", "Custom macro/tag " + strZzm + " threw exception " + e3.getMessage());
            return zzfu.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return false;
    }
}
