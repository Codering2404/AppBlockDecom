package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Api f71861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zau f71863c;

    public zat(Api api, boolean z2) {
        this.f71861a = api;
        this.f71862b = z2;
    }

    private final zau b() {
        Preconditions.n(this.f71863c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.f71863c;
    }

    public final void a(zau zauVar) {
        this.f71863c = zauVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        b().onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        b().x3(connectionResult, this.f71861a, this.f71862b);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        b().onConnectionSuspended(i3);
    }
}
