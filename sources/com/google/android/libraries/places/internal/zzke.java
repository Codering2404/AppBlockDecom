package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzke implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbih f78056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbih f78057b;

    private zzke(zzbih zzbihVar, zzbih zzbihVar2) {
        this.f78056a = zzbihVar;
        this.f78057b = zzbihVar2;
    }

    public static zzke a(zzbih zzbihVar, zzbih zzbihVar2) {
        return new zzke(zzbihVar, zzbihVar2);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbih zzbihVar = this.f78057b;
        return new zzkd((zzhq) this.f78056a.zzb(), (zzjy) zzbihVar.zzb());
    }
}
