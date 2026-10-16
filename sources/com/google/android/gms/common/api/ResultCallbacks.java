package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    @Override // com.google.android.gms.common.api.ResultCallback
    public final void a(Result result) {
        Status status = result.getStatus();
        if (status.w0()) {
            c(result);
            return;
        }
        b(status);
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e3) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(result)), e3);
            }
        }
    }

    public abstract void b(Status status);

    public abstract void c(Result result);
}
