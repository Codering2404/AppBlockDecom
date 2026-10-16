package com.google.android.gms.maps;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzt extends com.google.android.gms.maps.internal.zzj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocationSource f73350a;

    zzt(GoogleMap googleMap, LocationSource locationSource) {
        this.f73350a = locationSource;
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void deactivate() {
        this.f73350a.deactivate();
    }

    @Override // com.google.android.gms.maps.internal.ILocationSourceDelegate
    public final void w2(com.google.android.gms.maps.internal.zzaj zzajVar) {
        this.f73350a.a(new zzl(this, zzajVar));
    }
}
