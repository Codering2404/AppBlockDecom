package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzww {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzho zzc;

    public zzww(zzage zzageVar, zzanj zzanjVar) {
    }

    public final void zza(zzho zzhoVar) {
        if (zzhoVar != this.zzc) {
            this.zzc = zzhoVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
