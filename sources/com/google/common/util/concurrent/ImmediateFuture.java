package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class ImmediateFuture<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final ListenableFuture f85863b = new ImmediateFuture(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LazyLogger f85864c = new LazyLogger(ImmediateFuture.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f85865a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImmediateCancelledFuture<V> extends AbstractFuture.TrustedFuture<V> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final ImmediateCancelledFuture f85866i;

        static {
            f85866i = AbstractFuture.f85620d ? null : new ImmediateCancelledFuture();
        }

        ImmediateCancelledFuture() {
            cancel(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImmediateFailedFuture<V> extends AbstractFuture.TrustedFuture<V> {
        ImmediateFailedFuture(Throwable th) {
            C(th);
        }
    }

    ImmediateFuture(Object obj) {
        this.f85865a = obj;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.u(runnable, "Runnable was null.");
        Preconditions.u(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Exception e3) {
            f85864c.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e3);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f85865a;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        return super.toString() + "[status=SUCCESS, result=[" + this.f85865a + "]]";
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        Preconditions.t(timeUnit);
        return get();
    }
}
