package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ListenableFuture f85971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ScheduledFuture f85972j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Fire<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TimeoutFuture f85973a;

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture listenableFuture;
            TimeoutFuture timeoutFuture = this.f85973a;
            if (timeoutFuture == null || (listenableFuture = timeoutFuture.f85971i) == null) {
                return;
            }
            this.f85973a = null;
            if (listenableFuture.isDone()) {
                timeoutFuture.D(listenableFuture);
                return;
            }
            try {
                ScheduledFuture scheduledFuture = timeoutFuture.f85972j;
                timeoutFuture.f85972j = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    try {
                        long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                        if (jAbs > 10) {
                            str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                        }
                    } catch (Throwable th) {
                        timeoutFuture.C(new TimeoutFutureException(str));
                        throw th;
                    }
                }
                timeoutFuture.C(new TimeoutFutureException(str + ": " + listenableFuture));
            } finally {
                listenableFuture.cancel(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TimeoutFutureException extends TimeoutException {
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }

        private TimeoutFutureException(String str) {
            super(str);
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void m() {
        x(this.f85971i);
        ScheduledFuture scheduledFuture = this.f85972j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f85971i = null;
        this.f85972j = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String y() {
        ListenableFuture listenableFuture = this.f85971i;
        ScheduledFuture scheduledFuture = this.f85972j;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture + "]";
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }
}
