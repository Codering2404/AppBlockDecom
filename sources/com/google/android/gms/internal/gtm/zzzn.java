package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzn {
    private static final zzzm zza;
    private static final zzzm zzb;

    static {
        zzzm zzzmVar = null;
        try {
            zzzmVar = (zzzm) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzzmVar;
        zzb = new zzzm();
    }

    static zzzm zza() {
        return zza;
    }

    static zzzm zzb() {
        return zzb;
    }
}
