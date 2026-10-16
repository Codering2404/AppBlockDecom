package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CombinedFutureInterruptibleTask f85788o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AsyncCallable f85789d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CombinedFuture f85790f;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String f() {
            return this.f85789d.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.InterruptibleTask
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public ListenableFuture e() {
            return (ListenableFuture) Preconditions.v(this.f85789d.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.f85789d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void h(ListenableFuture listenableFuture) {
            this.f85790f.D(listenableFuture);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Callable f85791d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CombinedFuture f85792f;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        Object e() {
            return this.f85791d.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        String f() {
            return this.f85791d.toString();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        void h(Object obj) {
            this.f85792f.B(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CombinedFuture f85793c;

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void a(Throwable th) {
            this.f85793c.f85788o = null;
            if (th instanceof ExecutionException) {
                this.f85793c.C(((ExecutionException) th).getCause());
            } else if (th instanceof CancellationException) {
                this.f85793c.cancel(false);
            } else {
                this.f85793c.C(th);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final void b(Object obj) {
            this.f85793c.f85788o = null;
            h(obj);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        final boolean d() {
            return this.f85793c.isDone();
        }

        abstract void h(Object obj);
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void F(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.F(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.f85788o = null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void w() {
        CombinedFutureInterruptibleTask combinedFutureInterruptibleTask = this.f85788o;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.c();
        }
    }
}
