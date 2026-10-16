package com.google.android.play.core.integrity;

import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class af extends com.google.android.play.integrity.internal.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f82954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Long f82955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f82956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f82957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f82958e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    af(aj ajVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l3, Parcelable parcelable, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f82958e = ajVar;
        this.f82954a = bArr;
        this.f82955b = l3;
        this.f82956c = taskCompletionSource2;
        this.f82957d = integrityTokenRequest;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void a(Exception exc) {
        if (exc instanceof com.google.android.play.integrity.internal.af) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        try {
            ((com.google.android.play.integrity.internal.n) this.f82958e.f82968a.e()).R(aj.a(this.f82958e, this.f82954a, this.f82955b, null), new ai(this.f82958e, this.f82956c));
        } catch (RemoteException e3) {
            this.f82958e.f82969b.c(e3, "requestIntegrityToken(%s)", this.f82957d);
            this.f82956c.trySetException(new IntegrityServiceException(-100, e3));
        }
    }
}
