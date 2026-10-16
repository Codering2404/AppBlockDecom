package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaj implements GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleApiClient f71841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GoogleApiClient.OnConnectionFailedListener f71842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zak f71843d;

    public zaj(zak zakVar, int i3, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f71843d = zakVar;
        this.f71840a = i3;
        this.f71841b = googleApiClient;
        this.f71842c = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("AutoManageHelper", "beginFailureResolution for ".concat(String.valueOf(connectionResult)));
        this.f71843d.h(connectionResult, this.f71840a);
    }
}
