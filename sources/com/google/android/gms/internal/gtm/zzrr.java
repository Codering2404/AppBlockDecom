package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrr {
    private final Map zza;
    private final zzam zzb;

    /* synthetic */ zzrr(Map map, zzam zzamVar, zzrq zzrqVar) {
        this.zza = map;
        this.zzb = zzamVar;
    }

    public static zzrt zzb() {
        return new zzrt(null);
    }

    public final String toString() {
        return "Properties: " + String.valueOf(Collections.unmodifiableMap(this.zza)) + " pushAfterEvaluate: " + String.valueOf(this.zzb);
    }

    public final zzam zza() {
        return this.zzb;
    }

    public final Map zzc() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final void zzd(String str, zzam zzamVar) {
        this.zza.put(str, zzamVar);
    }
}
