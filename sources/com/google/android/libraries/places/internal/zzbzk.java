package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzk extends zzbsp {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbzh f77287c;

    zzbzk(zzbmy zzbmyVar, zzbzh zzbzhVar, zzbnx zzbnxVar) {
        super(zzbmyVar);
        this.f77287c = zzbzhVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbsp, com.google.android.libraries.places.internal.zzbmy
    public final void b(zzbmu zzbmuVar) {
        super.b(new zzbzj(this, zzbmuVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbsp, com.google.android.libraries.places.internal.zzbmy
    public final void c() {
        super.c();
        this.f77287c.zzb();
    }

    final /* synthetic */ zzbzh e() {
        return this.f77287c;
    }
}
