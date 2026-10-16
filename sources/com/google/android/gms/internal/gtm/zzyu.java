package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzyu {
    private static final zzyu zza = new zzyq(null);
    private static final zzyu zzb = new zzys(0 == true ? 1 : 0);

    /* synthetic */ zzyu(zzyt zzytVar) {
    }

    static zzyu zzd() {
        return zza;
    }

    static zzyu zze() {
        return zzb;
    }

    abstract List zza(Object obj, long j3);

    abstract void zzb(Object obj, long j3);

    abstract void zzc(Object obj, Object obj2, long j3);
}
