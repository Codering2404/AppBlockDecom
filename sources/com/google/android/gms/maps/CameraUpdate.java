package com.google.android.gms.maps;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class CameraUpdate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IObjectWrapper f73039a;

    CameraUpdate(IObjectWrapper iObjectWrapper) {
        this.f73039a = (IObjectWrapper) Preconditions.m(iObjectWrapper);
    }

    public final IObjectWrapper a() {
        return this.f73039a;
    }
}
