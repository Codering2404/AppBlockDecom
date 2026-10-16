package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MapCapabilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzs extends com.google.android.gms.maps.internal.zzak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.OnMapCapabilitiesChangedListener f73349a;

    @Override // com.google.android.gms.maps.internal.zzal
    public final void M1(com.google.android.gms.internal.maps.zzaa zzaaVar) {
        this.f73349a.a(new MapCapabilities(zzaaVar));
    }
}
