package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbif implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f76237a;

    private zzbif(Object obj) {
        this.f76237a = obj;
    }

    public static zzbie a(Object obj) {
        if (obj != null) {
            return new zzbif(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final Object zzb() {
        return this.f76237a;
    }
}
