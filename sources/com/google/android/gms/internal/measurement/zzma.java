package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzma implements zznk {
    private static final zzma zza = new zzma();

    private zzma() {
    }

    public static zzma zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zzb(Class cls) {
        return zzmf.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final zznj zzc(Class cls) {
        if (!zzmf.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zznj) zzmf.zzco(cls.asSubclass(zzmf.class)).zzl(3, null, null);
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e3);
        }
    }
}
