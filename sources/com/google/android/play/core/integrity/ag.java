package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ag extends com.google.android.play.integrity.internal.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f82959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f82960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f82961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f82962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ aj f82963e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ag(aj ajVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i3) {
        super(taskCompletionSource);
        this.f82963e = ajVar;
        this.f82959a = bundle;
        this.f82960b = activity;
        this.f82961c = taskCompletionSource2;
        this.f82962d = i3;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        try {
            com.google.android.play.integrity.internal.n nVar = (com.google.android.play.integrity.internal.n) this.f82963e.f82968a.e();
            Bundle bundle = this.f82959a;
            aj ajVar = this.f82963e;
            nVar.k(bundle, ajVar.f82971d.a(this.f82960b, this.f82961c, ajVar.f82968a));
        } catch (RemoteException e3) {
            this.f82963e.f82969b.c(e3, "requestAndShowDialog(%s)", Integer.valueOf(this.f82962d));
            this.f82961c.trySetException(new IntegrityServiceException(-100, e3));
        }
    }
}
