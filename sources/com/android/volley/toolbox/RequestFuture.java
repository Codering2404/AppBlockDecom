package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestFuture<T> implements Future<T>, Response.Listener<T>, Response.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Request f57850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f57851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f57852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VolleyError f57853d;

    private synchronized Object d(Long l3) {
        if (this.f57853d != null) {
            throw new ExecutionException(this.f57853d);
        }
        if (this.f57851b) {
            return this.f57852c;
        }
        if (l3 == null) {
            while (!isDone()) {
                wait(0L);
            }
        } else if (l3.longValue() > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jLongValue = l3.longValue() + jUptimeMillis;
            while (!isDone() && jUptimeMillis < jLongValue) {
                wait(jLongValue - jUptimeMillis);
                jUptimeMillis = SystemClock.uptimeMillis();
            }
        }
        if (this.f57853d != null) {
            throw new ExecutionException(this.f57853d);
        }
        if (!this.f57851b) {
            throw new TimeoutException();
        }
        return this.f57852c;
    }

    @Override // com.android.volley.Response.Listener
    public synchronized void b(Object obj) {
        this.f57851b = true;
        this.f57852c = obj;
        notifyAll();
    }

    @Override // com.android.volley.Response.ErrorListener
    public synchronized void c(VolleyError volleyError) {
        this.f57853d = volleyError;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z2) {
        if (this.f57850a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f57850a.c();
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        try {
            return d(null);
        } catch (TimeoutException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request request = this.f57850a;
        if (request == null) {
            return false;
        }
        return request.B();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0014  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f57851b     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L14
            com.android.volley.VolleyError r0 = r1.f57853d     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L14
            boolean r0 = r1.isCancelled()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            goto L14
        L10:
            r0 = 0
            goto L15
        L12:
            r0 = move-exception
            goto L17
        L14:
            r0 = 1
        L15:
            monitor-exit(r1)
            return r0
        L17:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.RequestFuture.isDone():boolean");
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return d(Long.valueOf(TimeUnit.MILLISECONDS.convert(j3, timeUnit)));
    }
}
