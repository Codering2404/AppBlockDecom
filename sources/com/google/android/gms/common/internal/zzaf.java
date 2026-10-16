package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaf extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectionResult f72091a;

    public zzaf(ConnectionResult connectionResult) {
        Preconditions.b(connectionResult.j0(), "ResolvableConnectionException can only be created with a connection result containing a resolution.");
        this.f72091a = connectionResult;
    }
}
