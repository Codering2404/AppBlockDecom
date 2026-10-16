package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnb {
    private final HashMap zza = new HashMap();

    public final zzfna zza(zzfmr zzfmrVar, Context context, zzfmj zzfmjVar, zzfng zzfngVar) {
        HashMap map = this.zza;
        zzfna zzfnaVar = (zzfna) map.get(zzfmrVar);
        if (zzfnaVar != null) {
            return zzfnaVar;
        }
        zzfmo zzfmoVar = new zzfmo(zzfmu.zza(zzfmrVar, context));
        zzfna zzfnaVar2 = new zzfna(zzfmoVar, new zzfnj(zzfmoVar, zzfmjVar, zzfngVar));
        map.put(zzfmrVar, zzfnaVar2);
        return zzfnaVar2;
    }
}
