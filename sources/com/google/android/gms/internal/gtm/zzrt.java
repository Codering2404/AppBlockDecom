package com.google.android.gms.internal.gtm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrt {
    private final Map zza = new HashMap();
    private zzam zzb;

    private zzrt() {
    }

    public final zzrr zza() {
        return new zzrr(this.zza, this.zzb, null);
    }

    public final zzrt zzb(String str, zzam zzamVar) {
        this.zza.put(str, zzamVar);
        return this;
    }

    public final zzrt zzc(zzam zzamVar) {
        this.zzb = zzamVar;
        return this;
    }

    /* synthetic */ zzrt(zzrs zzrsVar) {
    }
}
