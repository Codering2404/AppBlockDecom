package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzjq implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbih f78035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbih f78036b;

    private zzjq(zzbih zzbihVar, zzbih zzbihVar2) {
        this.f78035a = zzbihVar;
        this.f78036b = zzbihVar2;
    }

    public static zzjq a(zzbih zzbihVar, zzbih zzbihVar2) {
        return new zzjq(zzbihVar, zzbihVar2);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzjp(((zzms) this.f78035a).zzb(), (zzblw) this.f78036b.zzb());
    }
}
