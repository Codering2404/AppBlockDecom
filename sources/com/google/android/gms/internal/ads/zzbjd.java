package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbjd {
    private final Map zza = new HashMap();
    private final zzbjf zzb;

    public zzbjd(zzbjf zzbjfVar) {
        this.zzb = zzbjfVar;
    }

    public final void zza(String str, zzbjc zzbjcVar) {
        this.zza.put(str, zzbjcVar);
    }

    public final void zzb(String str, String str2, long j3) {
        Map map = this.zza;
        zzbjc zzbjcVar = (zzbjc) map.get(str2);
        String[] strArr = {str};
        if (zzbjcVar != null) {
            this.zzb.zzb(zzbjcVar, j3, strArr);
        }
        map.put(str, new zzbjc(j3, null, null));
    }

    public final zzbjf zzc() {
        return this.zzb;
    }
}
