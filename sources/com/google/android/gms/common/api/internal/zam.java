package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f71850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConnectionResult f71851b;

    zam(ConnectionResult connectionResult, int i3) {
        Preconditions.m(connectionResult);
        this.f71851b = connectionResult;
        this.f71850a = i3;
    }

    final int a() {
        return this.f71850a;
    }

    final ConnectionResult b() {
        return this.f71851b;
    }
}
