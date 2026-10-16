package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzao;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzag extends zzao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TileProvider f73275a;

    zzag(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.f73275a = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzap
    public final Tile zzb(int i3, int i4, int i5) {
        return this.f73275a.a(i3, i4, i5);
    }
}
