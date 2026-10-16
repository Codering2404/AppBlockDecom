package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzz implements zzbwo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbzx f77313a;

    private zzbzz(zzbzx zzbzxVar) {
        this.f77313a = zzbzxVar;
    }

    public static zzbzz a(zzbzx zzbzxVar) {
        return new zzbzz(zzbzxVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbwo
    public final Object zza() {
        return zzbzy.a(this.f77313a);
    }

    @Override // com.google.android.libraries.places.internal.zzbwo
    public final Object zzb(Object obj) {
        zzbzy.b(this.f77313a, obj);
        return null;
    }
}
