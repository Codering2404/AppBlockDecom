package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzb {
    zzzb() {
    }

    public static final boolean zza(Object obj) {
        return !((zzza) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzza zzzaVarZzb = (zzza) obj;
        zzza zzzaVar = (zzza) obj2;
        if (!zzzaVar.isEmpty()) {
            if (!zzzaVarZzb.zze()) {
                zzzaVarZzb = zzzaVarZzb.zzb();
            }
            zzzaVarZzb.zzd(zzzaVar);
        }
        return zzzaVarZzb;
    }
}
