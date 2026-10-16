package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PendingResult<R extends Result> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StatusListener {
        void a(Status status);
    }

    public void addStatusListener(StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    public abstract Result await(long j3, TimeUnit timeUnit);

    public abstract void cancel();

    public abstract void setResultCallback(ResultCallback resultCallback);
}
