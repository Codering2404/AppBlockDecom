package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaal implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f71654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Api f71655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f71656c;

    public zaal(zaaw zaawVar, Api api, boolean z2) {
        this.f71654a = new WeakReference(zaawVar);
        this.f71655b = api;
        this.f71656c = z2;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void a(ConnectionResult connectionResult) {
        zaaw zaawVar = (zaaw) this.f71654a.get();
        if (zaawVar == null) {
            return;
        }
        Preconditions.r(Looper.myLooper() == zaawVar.f71669a.f71741o.k(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zaawVar.f71670b.lock();
        try {
            if (zaawVar.o(0)) {
                if (!connectionResult.w0()) {
                    zaawVar.m(connectionResult, this.f71655b, this.f71656c);
                }
                if (zaawVar.p()) {
                    zaawVar.n();
                }
            }
        } finally {
            zaawVar.f71670b.unlock();
        }
    }
}
