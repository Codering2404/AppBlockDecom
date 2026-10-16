package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxo implements zzze {
    private static final zzxo zza = new zzxo();

    private zzxo() {
    }

    public static zzxo zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzze
    public final zzzd zzb(Class cls) {
        if (!zzxv.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzzd) zzxv.zzac(cls.asSubclass(zzxv.class)).zzb(3, null, null);
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e3);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzze
    public final boolean zzc(Class cls) {
        return zzxv.class.isAssignableFrom(cls);
    }
}
