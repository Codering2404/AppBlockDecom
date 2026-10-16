package com.google.android.gms.internal.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzes implements zzfv {
    private static final zzes zza = new zzes();

    private zzes() {
    }

    public static zzes zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final zzfu zzb(Class cls) {
        if (!zzev.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzfu) zzev.zzb(cls.asSubclass(zzev.class)).zzn(3, null, null);
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e3);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzfv
    public final boolean zzc(Class cls) {
        return zzev.class.isAssignableFrom(cls);
    }
}
