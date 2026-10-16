package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BasePendingResult f71599a;

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        this.f71599a.addStatusListener(statusListener);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Result await(long j3, TimeUnit timeUnit) {
        return this.f71599a.await(j3, timeUnit);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        this.f71599a.cancel();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback resultCallback) {
        this.f71599a.setResultCallback(resultCallback);
    }
}
