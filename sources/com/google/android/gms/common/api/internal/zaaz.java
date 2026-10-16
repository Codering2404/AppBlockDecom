package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaaz implements GoogleApiClient.ConnectionCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f71692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f71693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zabe f71694c;

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f71694c.C((GoogleApiClient) Preconditions.m((GoogleApiClient) this.f71692a.get()), this.f71693b, true);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
    }
}
