package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zap implements PendingResult.StatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PendingResult f72064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f72065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PendingResultUtil.ResultConverter f72066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zas f72067d;

    zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, zas zasVar) {
        this.f72064a = pendingResult;
        this.f72065b = taskCompletionSource;
        this.f72066c = resultConverter;
        this.f72067d = zasVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        if (!status.w0()) {
            this.f72065b.setException(ApiExceptionUtil.a(status));
        } else {
            this.f72065b.setResult(this.f72066c.a(this.f72064a.await(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
