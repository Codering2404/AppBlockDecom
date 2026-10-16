package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaf implements TileProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzap f73273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TileOverlayOptions f73274c;

    zzaf(TileOverlayOptions tileOverlayOptions) {
        this.f73274c = tileOverlayOptions;
        this.f73273b = tileOverlayOptions.f73259a;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile a(int i3, int i4, int i5) {
        try {
            return this.f73273b.zzb(i3, i4, i5);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
