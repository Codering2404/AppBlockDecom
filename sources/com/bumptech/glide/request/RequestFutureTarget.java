package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Waiter f67130l = new Waiter();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f67131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f67132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f67133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Waiter f67134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f67135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Request f67136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f67137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f67138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f67139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private GlideException f67140k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Waiter {
        Waiter() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j3) throws InterruptedException {
            obj.wait(j3);
        }
    }

    private synchronized Object e(Long l3) {
        try {
            if (this.f67133c && !isDone()) {
                Util.a();
            }
            if (this.f67137h) {
                throw new CancellationException();
            }
            if (this.f67139j) {
                throw new ExecutionException(this.f67140k);
            }
            if (this.f67138i) {
                return this.f67135f;
            }
            if (l3 == null) {
                this.f67134d.b(this, 0L);
            } else if (l3.longValue() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jLongValue = l3.longValue() + jCurrentTimeMillis;
                while (!isDone() && jCurrentTimeMillis < jLongValue) {
                    this.f67134d.b(this, jLongValue - jCurrentTimeMillis);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.f67139j) {
                throw new ExecutionException(this.f67140k);
            }
            if (this.f67137h) {
                throw new CancellationException();
            }
            if (!this.f67138i) {
                throw new TimeoutException();
            }
            return this.f67135f;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean a(GlideException glideException, Object obj, Target target, boolean z2) {
        this.f67139j = true;
        this.f67140k = glideException;
        this.f67134d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized Request b() {
        return this.f67136g;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        synchronized (this) {
            try {
                if (isDone()) {
                    return false;
                }
                this.f67137h = true;
                this.f67134d.a(this);
                Request request = null;
                if (z2) {
                    Request request2 = this.f67136g;
                    this.f67136g = null;
                    request = request2;
                }
                if (request != null) {
                    request.clear();
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestListener
    public synchronized boolean d(Object obj, Object obj2, Target target, DataSource dataSource, boolean z2) {
        this.f67138i = true;
        this.f67135f = obj;
        this.f67134d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        try {
            return e(null);
        } catch (TimeoutException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void h(Object obj, Transition transition) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void i(Request request) {
        this.f67136g = request;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f67137h;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f67137h     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f67138i     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f67139j     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L15
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.isDone():boolean");
    }

    @Override // com.bumptech.glide.request.target.Target
    public synchronized void j(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void k(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.d(this.f67131a, this.f67132b);
    }

    public String toString() {
        Request request;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            try {
                request = null;
                if (this.f67137h) {
                    str = "CANCELLED";
                } else if (this.f67139j) {
                    str = "FAILURE";
                } else if (this.f67138i) {
                    str = "SUCCESS";
                } else {
                    str = "PENDING";
                    request = this.f67136g;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (request == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + request + "]]";
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return e(Long.valueOf(timeUnit.toMillis(j3)));
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void c(SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void g(Drawable drawable) {
    }
}
