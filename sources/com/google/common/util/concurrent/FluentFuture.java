package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public abstract class FluentFuture<V> extends GwtFluentFutureCatchingSpecialization<V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class TrustedFuture<V> extends FluentFuture<V> implements AbstractFuture.Trusted<V> {
        TrustedFuture() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z2) {
            return super.cancel(z2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final Object get() {
            return super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final Object get(long j3, TimeUnit timeUnit) {
            return super.get(j3, timeUnit);
        }
    }

    FluentFuture() {
    }

    public static FluentFuture F(ListenableFuture listenableFuture) {
        return listenableFuture instanceof FluentFuture ? (FluentFuture) listenableFuture : new ForwardingFluentFuture(listenableFuture);
    }

    public final FluentFuture G(Function function, Executor executor) {
        return (FluentFuture) Futures.h(this, function, executor);
    }

    public final FluentFuture H(AsyncFunction asyncFunction, Executor executor) {
        return (FluentFuture) Futures.i(this, asyncFunction, executor);
    }
}
