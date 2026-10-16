package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Futures extends GwtFuturesCatchingSpecialization {

    /* JADX INFO: renamed from: com.google.common.util.concurrent.Futures$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Future<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Future f85846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function f85847b;

        private Object a(Object obj) throws ExecutionException {
            try {
                return this.f85847b.apply(obj);
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            return this.f85846a.cancel(z2);
        }

        @Override // java.util.concurrent.Future
        public Object get() {
            return a(this.f85846a.get());
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f85846a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f85846a.isDone();
        }

        @Override // java.util.concurrent.Future
        public Object get(long j3, TimeUnit timeUnit) {
            return a(this.f85846a.get(j3, timeUnit));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CallbackListener<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Future f85848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final FutureCallback f85849b;

        CallbackListener(Future future, FutureCallback futureCallback) {
            this.f85848a = future;
            this.f85849b = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Object obj = this.f85848a;
            if ((obj instanceof InternalFutureFailureAccess) && (thA = InternalFutures.a((InternalFutureFailureAccess) obj)) != null) {
                this.f85849b.onFailure(thA);
                return;
            }
            try {
                this.f85849b.onSuccess(Futures.c(this.f85848a));
            } catch (ExecutionException e3) {
                this.f85849b.onFailure(e3.getCause());
            } catch (Throwable th) {
                this.f85849b.onFailure(th);
            }
        }

        public String toString() {
            return MoreObjects.c(this).k(this.f85849b).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class FutureCombiner<V> {

        /* JADX INFO: renamed from: com.google.common.util.concurrent.Futures$FutureCombiner$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f85850a;

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() {
                this.f85850a.run();
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private InCompletionOrderState f85851i;

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            InCompletionOrderState inCompletionOrderState = this.f85851i;
            if (!super.cancel(z2)) {
                return false;
            }
            Objects.requireNonNull(inCompletionOrderState);
            inCompletionOrderState.e(z2);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void m() {
            this.f85851i = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String y() {
            InCompletionOrderState inCompletionOrderState = this.f85851i;
            if (inCompletionOrderState == null) {
                return null;
            }
            return "inputCount=[" + inCompletionOrderState.f85855d.length + "], remaining=[" + inCompletionOrderState.f85854c.get() + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InCompletionOrderState<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f85852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f85853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicInteger f85854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ListenableFuture[] f85855d;

        private void d() {
            if (this.f85854c.decrementAndGet() == 0 && this.f85852a) {
                for (ListenableFuture listenableFuture : this.f85855d) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.f85853b);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(boolean z2) {
            this.f85852a = true;
            if (!z2) {
                this.f85853b = false;
            }
            d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ListenableFuture f85856i;

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected void m() {
            this.f85856i = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture listenableFuture = this.f85856i;
            if (listenableFuture != null) {
                D(listenableFuture);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        protected String y() {
            ListenableFuture listenableFuture = this.f85856i;
            if (listenableFuture == null) {
                return null;
            }
            return "delegate=[" + listenableFuture + "]";
        }
    }

    public static void a(ListenableFuture listenableFuture, FutureCallback futureCallback, Executor executor) {
        Preconditions.t(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static Object b(Future future, Class cls, long j3, TimeUnit timeUnit) {
        return FuturesGetChecked.f(future, cls, j3, timeUnit);
    }

    public static Object c(Future future) {
        Preconditions.D(future.isDone(), "Future was expected to be done: %s", future);
        return Uninterruptibles.a(future);
    }

    public static ListenableFuture d() {
        ImmediateFuture.ImmediateCancelledFuture immediateCancelledFuture = ImmediateFuture.ImmediateCancelledFuture.f85866i;
        return immediateCancelledFuture != null ? immediateCancelledFuture : new ImmediateFuture.ImmediateCancelledFuture();
    }

    public static ListenableFuture e(Throwable th) {
        Preconditions.t(th);
        return new ImmediateFuture.ImmediateFailedFuture(th);
    }

    public static ListenableFuture f(Object obj) {
        return obj == null ? ImmediateFuture.f85863b : new ImmediateFuture(obj);
    }

    public static ListenableFuture g() {
        return ImmediateFuture.f85863b;
    }

    public static ListenableFuture h(ListenableFuture listenableFuture, Function function, Executor executor) {
        return AbstractTransformFuture.I(listenableFuture, function, executor);
    }

    public static ListenableFuture i(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        return AbstractTransformFuture.J(listenableFuture, asyncFunction, executor);
    }
}
