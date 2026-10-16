package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final /* synthetic */ class zzil implements AsyncFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzja f77960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ LatLng f77961b;

    @Override // com.google.common.util.concurrent.AsyncFunction
    public final /* synthetic */ ListenableFuture apply(Object obj) {
        return this.f77960a.s(this.f77961b, (com.google.android.libraries.places.api.auth.zzb) obj);
    }
}
