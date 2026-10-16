package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabb implements ResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f71696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f71697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleApiClient f71698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zabe f71699d;

    zabb(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z2, GoogleApiClient googleApiClient) {
        this.f71699d = zabeVar;
        this.f71696a = statusPendingResult;
        this.f71697b = z2;
        this.f71698c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void a(Result result) {
        Status status = (Status) result;
        Storage.b(this.f71699d.f71706f).i();
        if (status.w0() && this.f71699d.l()) {
            zabe zabeVar = this.f71699d;
            zabeVar.e();
            zabeVar.d();
        }
        this.f71696a.setResult(status);
        if (this.f71697b) {
            this.f71698c.e();
        }
    }
}
