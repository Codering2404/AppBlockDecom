package com.google.android.gms.maps;

import android.graphics.Bitmap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzq extends zzbv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GoogleMap.SnapshotReadyCallback f73347a;

    @Override // com.google.android.gms.maps.internal.zzbw
    public final void Z1(IObjectWrapper iObjectWrapper) {
        this.f73347a.a((Bitmap) ObjectWrapper.h5(iObjectWrapper));
    }

    @Override // com.google.android.gms.maps.internal.zzbw
    public final void b3(Bitmap bitmap) {
        this.f73347a.a(bitmap);
    }
}
