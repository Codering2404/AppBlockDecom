package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzah {
    private static final Object zza = new Object();
    private static volatile boolean zzb = false;
    private static volatile zzag zzc = null;
    private static volatile boolean zzd = false;
    private static volatile zzag zze;

    static void zza() {
        zzd = true;
    }

    static void zzb() {
        if (zze == null) {
            zze = new zzag(null);
        }
    }

    static void zzc() {
        if (zzc == null) {
            zzc = new zzag(null);
        }
    }

    static boolean zzd() {
        synchronized (zza) {
        }
        return false;
    }
}
