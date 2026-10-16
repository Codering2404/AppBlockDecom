package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.IndoorBuilding;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzk extends com.google.android.gms.maps.internal.zzaa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnIndoorStateChangeListener f73341a;

    zzk(GoogleMap googleMap, GoogleMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.f73341a = onIndoorStateChangeListener;
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void R1(com.google.android.gms.internal.maps.zzu zzuVar) {
        this.f73341a.a(new IndoorBuilding(zzuVar));
    }

    @Override // com.google.android.gms.maps.internal.zzab
    public final void zzb() {
        this.f73341a.b();
    }
}
