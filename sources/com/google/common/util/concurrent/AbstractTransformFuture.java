package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ListenableFuture f85699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f85700j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        AsyncTransformFuture(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public ListenableFuture K(AsyncFunction asyncFunction, Object obj) {
            ListenableFuture listenableFutureApply = asyncFunction.apply(obj);
            Preconditions.v(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public void L(ListenableFuture listenableFuture) {
            D(listenableFuture);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        TransformFuture(ListenableFuture listenableFuture, Function function) {
            super(listenableFuture, function);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        void L(Object obj) {
            B(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public Object K(Function function, Object obj) {
            return function.apply(obj);
        }
    }

    AbstractTransformFuture(ListenableFuture listenableFuture, Object obj) {
        this.f85699i = (ListenableFuture) Preconditions.t(listenableFuture);
        this.f85700j = Preconditions.t(obj);
    }

    static ListenableFuture I(ListenableFuture listenableFuture, Function function, Executor executor) {
        Preconditions.t(function);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function);
        listenableFuture.addListener(transformFuture, MoreExecutors.h(executor, transformFuture));
        return transformFuture;
    }

    static ListenableFuture J(ListenableFuture listenableFuture, AsyncFunction asyncFunction, Executor executor) {
        Preconditions.t(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.h(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    abstract Object K(Object obj, Object obj2);

    abstract void L(Object obj);

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void m() {
        x(this.f85699i);
        this.f85699i = null;
        this.f85700j = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f85699i;
        Object obj = this.f85700j;
        if ((isCancelled() | (listenableFuture == null)) || (obj == null)) {
            return;
        }
        this.f85699i = null;
        if (listenableFuture.isCancelled()) {
            D(listenableFuture);
            return;
        }
        try {
            try {
                Object objK = K(obj, Futures.c(listenableFuture));
                this.f85700j = null;
                L(objK);
            } catch (Throwable th) {
                try {
                    Platform.b(th);
                    C(th);
                } finally {
                    this.f85700j = null;
                }
            }
        } catch (Error e3) {
            C(e3);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e4) {
            C(e4.getCause());
        } catch (Exception e5) {
            C(e5);
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String y() {
        String str;
        ListenableFuture listenableFuture = this.f85699i;
        Object obj = this.f85700j;
        String strY = super.y();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (obj != null) {
            return str + "function=[" + obj + "]";
        }
        if (strY == null) {
            return null;
        }
        return str + strY;
    }
}
