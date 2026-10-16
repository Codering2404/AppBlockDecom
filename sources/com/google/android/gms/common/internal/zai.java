package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zai implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnConnectionFailedListener f72052a;

    zai(OnConnectionFailedListener onConnectionFailedListener) {
        this.f72052a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f72052a.onConnectionFailed(connectionResult);
    }
}
