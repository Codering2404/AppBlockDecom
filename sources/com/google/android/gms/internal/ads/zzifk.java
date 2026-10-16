package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzifk {
    zzifk() {
    }

    public static final boolean zza(Object obj) {
        return !((zzifj) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzifj zzifjVarZzc = (zzifj) obj;
        zzifj zzifjVar = (zzifj) obj2;
        if (!zzifjVar.isEmpty()) {
            if (!zzifjVarZzc.zze()) {
                zzifjVarZzc = zzifjVarZzc.zzc();
            }
            zzifjVarZzc.zzb(zzifjVar);
        }
        return zzifjVarZzc;
    }
}
