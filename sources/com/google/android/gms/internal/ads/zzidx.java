package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidx implements zzifn {
    private static final zzidx zza = new zzidx();

    private zzidx() {
    }

    public static zzidx zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzifn
    public final boolean zzb(Class cls) {
        return zziee.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzifn
    public final zzifm zzc(Class cls) {
        if (!zziee.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzifm) zziee.zzbt(cls.asSubclass(zziee.class)).zzbs();
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e3);
        }
    }
}
