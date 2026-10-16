package com.google.android.play.core.integrity;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class bh extends bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f83017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f83018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f83019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f83020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ bn f83021e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bh(bn bnVar, TaskCompletionSource taskCompletionSource, Bundle bundle, Activity activity, TaskCompletionSource taskCompletionSource2, int i3) {
        super(bnVar, taskCompletionSource);
        this.f83021e = bnVar;
        this.f83017a = bundle;
        this.f83018b = activity;
        this.f83019c = taskCompletionSource2;
        this.f83020d = i3;
    }

    @Override // com.google.android.play.integrity.internal.t
    protected final void b() {
        if (bn.k(this.f83021e)) {
            super.a(new StandardIntegrityException(-2, null));
            return;
        }
        try {
            bn bnVar = this.f83021e;
            com.google.android.play.integrity.internal.ae aeVar = bnVar.f83031a;
            ((com.google.android.play.integrity.internal.i) aeVar.e()).k(this.f83017a, bnVar.f83035e.a(this.f83018b, this.f83019c, aeVar));
        } catch (RemoteException e3) {
            this.f83021e.f83032b.c(e3, "requestAndShowDialog(%s)", Integer.valueOf(this.f83020d));
            this.f83019c.trySetException(new StandardIntegrityException(-100, e3));
        }
    }
}
