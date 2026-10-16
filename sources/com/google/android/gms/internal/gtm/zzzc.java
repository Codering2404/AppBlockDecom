package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzc {
    private static final zzzb zza;
    private static final zzzb zzb;

    static {
        zzzb zzzbVar = null;
        try {
            zzzbVar = (zzzb) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zza = zzzbVar;
        zzb = new zzzb();
    }

    static zzzb zza() {
        return zza;
    }

    static zzzb zzb() {
        return zzb;
    }
}
