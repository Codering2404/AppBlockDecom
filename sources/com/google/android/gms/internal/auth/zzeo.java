package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeo {
    private static final zzem zza = new zzen();
    private static final zzem zzb;

    static {
        zzem zzemVar = null;
        try {
            zzemVar = (zzem) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzemVar;
    }

    static zzem zza() {
        zzem zzemVar = zzb;
        if (zzemVar != null) {
            return zzemVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzem zzb() {
        return zza;
    }
}
