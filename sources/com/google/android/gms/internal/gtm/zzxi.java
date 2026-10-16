package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxi {
    private static final zzxg zza = new zzxh();
    private static final zzxg zzb;

    static {
        zzxg zzxgVar = null;
        try {
            zzxgVar = (zzxg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzxgVar;
    }

    static zzxg zza() {
        zzxg zzxgVar = zzb;
        if (zzxgVar != null) {
            return zzxgVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzxg zzb() {
        return zza;
    }
}
