package androidx.media3.common.util;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConditionVariable f41586a = new ConditionVariable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConditionVariable f41587b = new ConditionVariable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f41588c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Exception f41589d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f41590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Thread f41591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f41592h;

    protected RunnableFutureTask() {
    }

    private Object e() throws ExecutionException {
        if (this.f41592h) {
            throw new CancellationException();
        }
        if (this.f41589d == null) {
            return this.f41590f;
        }
        throw new ExecutionException(this.f41589d);
    }

    public final void a() {
        this.f41587b.c();
    }

    public final void b() {
        this.f41586a.c();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        synchronized (this.f41588c) {
            try {
                if (!this.f41592h && !this.f41587b.e()) {
                    this.f41592h = true;
                    c();
                    Thread thread = this.f41591g;
                    if (thread == null) {
                        this.f41586a.f();
                        this.f41587b.f();
                    } else if (z2) {
                        thread.interrupt();
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    protected abstract Object d();

    @Override // java.util.concurrent.Future
    public final Object get() {
        this.f41587b.a();
        return e();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f41592h;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f41587b.e();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.f41588c) {
            try {
                if (this.f41592h) {
                    return;
                }
                this.f41591g = Thread.currentThread();
                this.f41586a.f();
                try {
                    try {
                        this.f41590f = d();
                        synchronized (this.f41588c) {
                            this.f41587b.f();
                            this.f41591g = null;
                            Thread.interrupted();
                        }
                    } catch (Throwable th) {
                        synchronized (this.f41588c) {
                            this.f41587b.f();
                            this.f41591g = null;
                            Thread.interrupted();
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    this.f41589d = e3;
                    synchronized (this.f41588c) {
                        this.f41587b.f();
                        this.f41591g = null;
                        Thread.interrupted();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j3, TimeUnit timeUnit) throws TimeoutException {
        if (this.f41587b.b(TimeUnit.MILLISECONDS.convert(j3, timeUnit))) {
            return e();
        }
        throw new TimeoutException();
    }

    protected void c() {
    }
}
