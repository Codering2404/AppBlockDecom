package com.google.android.play.core.integrity;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class bi extends com.google.android.play.integrity.internal.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TaskCompletionSource f83022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bn f83023b;

    bi(bn bnVar, TaskCompletionSource taskCompletionSource) {
        this.f83023b = bnVar;
        this.f83022a = taskCompletionSource;
    }

    @Override // com.google.android.play.integrity.internal.k
    public final void b(Bundle bundle) throws RemoteException {
        this.f83023b.f83031a.v(this.f83022a);
    }

    @Override // com.google.android.play.integrity.internal.k
    public void c(Bundle bundle) throws RemoteException {
        this.f83023b.f83031a.v(this.f83022a);
    }

    @Override // com.google.android.play.integrity.internal.k
    public final void d(Bundle bundle) throws RemoteException {
        this.f83023b.f83031a.v(this.f83022a);
    }

    @Override // com.google.android.play.integrity.internal.k
    public void e(Bundle bundle) throws RemoteException {
        this.f83023b.f83031a.v(this.f83022a);
    }
}
