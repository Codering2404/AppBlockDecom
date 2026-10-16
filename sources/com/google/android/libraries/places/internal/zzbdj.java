package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbdj implements zzbev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzbdj f76079a = new zzbdj();

    private zzbdj() {
    }

    public static zzbdj a() {
        return f76079a;
    }

    @Override // com.google.android.libraries.places.internal.zzbev
    public final boolean zzb(Class cls) {
        return zzbdq.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.libraries.places.internal.zzbev
    public final zzbeu zzc(Class cls) {
        if (!zzbdq.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzbeu) zzbdq.C(cls.asSubclass(zzbdq.class)).l(3, null, null);
        } catch (Exception e3) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e3);
        }
    }
}
