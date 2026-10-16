package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzod {
    zzod() {
    }

    public static final boolean zza(Object obj) {
        return !((zzoc) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzoc zzocVarZzb = (zzoc) obj;
        zzoc zzocVar = (zzoc) obj2;
        if (!zzocVar.isEmpty()) {
            if (!zzocVarZzb.zze()) {
                zzocVarZzb = zzocVarZzb.zzb();
            }
            zzocVarZzb.zzd(zzocVar);
        }
        return zzocVarZzb;
    }
}
