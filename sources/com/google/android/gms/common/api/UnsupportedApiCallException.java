package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Feature f71548a;

    public UnsupportedApiCallException(Feature feature) {
        this.f71548a = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f71548a));
    }
}
