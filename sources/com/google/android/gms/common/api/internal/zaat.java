package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zaaw f71667a;

    /* synthetic */ zaat(zaaw zaawVar, zaas zaasVar) {
        this.f71667a = zaawVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ((com.google.android.gms.signin.zae) Preconditions.m(this.f71667a.f71679k)).c(new zaar(this.f71667a));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f71667a.f71670b.lock();
        try {
            if (this.f71667a.q(connectionResult)) {
                this.f71667a.i();
                this.f71667a.n();
            } else {
                this.f71667a.l(connectionResult);
            }
            this.f71667a.f71670b.unlock();
        } catch (Throwable th) {
            this.f71667a.f71670b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
    }
}
