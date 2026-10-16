package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzab extends com.google.android.gms.maps.internal.zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GoogleMap.CancelableCallback f73281a;

    zzab(GoogleMap.CancelableCallback cancelableCallback) {
        this.f73281a = cancelableCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzd
    public final void zzb() {
        this.f73281a.onCancel();
    }

    @Override // com.google.android.gms.maps.internal.zzd
    public final void zzc() {
        this.f73281a.a();
    }
}
