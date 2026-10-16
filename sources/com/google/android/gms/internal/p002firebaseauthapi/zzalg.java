package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzalf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalg implements zzamj {
    private static final zzalg zza = new zzalg();

    private zzalg() {
    }

    public static zzalg zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamj
    public final boolean zzb(Class<?> cls) {
        return zzalf.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamj
    public final zzamk zza(Class<?> cls) {
        if (!zzalf.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzamk) zzalf.zza(cls.asSubclass(zzalf.class)).zza(zzalf.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e3);
        }
    }
}
