package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class TrustedListenableFutureTask<V> extends FluentFuture.TrustedFuture<V> implements RunnableFuture<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile InterruptibleTask f85974i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<ListenableFuture<V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AsyncCallable f85975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TrustedListenableFutureTask f85976d;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void a(Throwable th) {
            this.f85976d.C(th);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean d() {
            return this.f85976d.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String f() {
            return this.f85975c.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void b(ListenableFuture listenableFuture) {
            this.f85976d.D(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public ListenableFuture e() {
            return (ListenableFuture) Preconditions.v(this.f85975c.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.f85975c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Callable f85977c;

        TrustedFutureInterruptibleTask(Callable callable) {
            this.f85977c = (Callable) Preconditions.t(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void a(Throwable th) {
            TrustedListenableFutureTask.this.C(th);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        void b(Object obj) {
            TrustedListenableFutureTask.this.B(obj);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean d() {
            return TrustedListenableFutureTask.this.isDone();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        Object e() {
            return this.f85977c.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String f() {
            return this.f85977c.toString();
        }
    }

    TrustedListenableFutureTask(Callable callable) {
        this.f85974i = new TrustedFutureInterruptibleTask(callable);
    }

    static TrustedListenableFutureTask I(Runnable runnable, Object obj) {
        return new TrustedListenableFutureTask(Executors.callable(runnable, obj));
    }

    static TrustedListenableFutureTask J(Callable callable) {
        return new TrustedListenableFutureTask(callable);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void m() {
        InterruptibleTask interruptibleTask;
        super.m();
        if (E() && (interruptibleTask = this.f85974i) != null) {
            interruptibleTask.c();
        }
        this.f85974i = null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        InterruptibleTask interruptibleTask = this.f85974i;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.f85974i = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String y() {
        InterruptibleTask interruptibleTask = this.f85974i;
        if (interruptibleTask == null) {
            return super.y();
        }
        return "task=[" + interruptibleTask + "]";
    }
}
