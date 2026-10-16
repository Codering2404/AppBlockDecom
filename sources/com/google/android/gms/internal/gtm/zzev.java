package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzev {
    private final zzeu zza;
    private final Object zzb;
    private final Object zzc;
    private final Object zzd = new Object();

    private zzev(Object obj, Object obj2, zzeu zzeuVar) {
        this.zzb = obj;
        this.zzc = obj2;
        this.zza = zzeuVar;
    }

    static zzev zza(Object obj, Object obj2, zzeu zzeuVar) {
        return new zzev(obj, obj2, zzeuVar);
    }

    public final Object zzb() {
        synchronized (this.zzd) {
        }
        return this.zzb;
    }
}
