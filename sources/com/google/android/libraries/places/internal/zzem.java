package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzem implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f77788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ListenableFuture f77789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CancellationTokenSource f77790c;

    zzem(TaskCompletionSource taskCompletionSource, ListenableFuture listenableFuture, CancellationTokenSource cancellationTokenSource) {
        this.f77788a = taskCompletionSource;
        this.f77789b = listenableFuture;
        this.f77790c = cancellationTokenSource;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        if (this.f77789b.isCancelled()) {
            this.f77790c.cancel();
        } else if (th instanceof Exception) {
            this.f77788a.setException((Exception) th);
        } else {
            this.f77788a.setException(new ExecutionException(th));
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        this.f77788a.setResult(obj);
    }
}
