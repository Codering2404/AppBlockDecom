package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzji {
    private static zzjh zza;

    public static synchronized void zza(zzjh zzjhVar) {
        if (zza != null) {
            throw new IllegalStateException("init() already called");
        }
        zza = zzjhVar;
    }

    public static synchronized zzjh zzb() {
        try {
            if (zza == null) {
                zza(new zzjl());
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
