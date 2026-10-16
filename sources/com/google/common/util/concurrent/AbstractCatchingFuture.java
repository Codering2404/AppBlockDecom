package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.lang.Throwable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ListenableFuture f85614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Class f85615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f85616k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public ListenableFuture I(AsyncFunction asyncFunction, Throwable th) {
            ListenableFuture listenableFutureApply = asyncFunction.apply(th);
            Preconditions.v(listenableFutureApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction);
            return listenableFutureApply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public void J(ListenableFuture listenableFuture) {
            D(listenableFuture);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        void J(Object obj) {
            B(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public Object I(Function function, Throwable th) {
            return function.apply(th);
        }
    }

    abstract Object I(Object obj, Throwable th);

    abstract void J(Object obj);

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void m() {
        x(this.f85614i);
        this.f85614i = null;
        this.f85615j = null;
        this.f85616k = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f85614i;
        Class cls = this.f85615j;
        Object obj = this.f85616k;
        if (((obj == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.f85614i = null;
        try {
            th = listenableFuture instanceof InternalFutureFailureAccess ? InternalFutures.a((InternalFutureFailureAccess) listenableFuture) : null;
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + listenableFuture.getClass() + " threw " + e3.getClass() + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        Object objC = th == null ? Futures.c(listenableFuture) : null;
        if (th == null) {
            B(NullnessCasts.a(objC));
            return;
        }
        if (!Platform.a(th, cls)) {
            D(listenableFuture);
            return;
        }
        try {
            Object objI = I(obj, th);
            this.f85615j = null;
            this.f85616k = null;
            J(objI);
        } catch (Throwable th2) {
            try {
                Platform.b(th2);
                C(th2);
            } finally {
                this.f85615j = null;
                this.f85616k = null;
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String y() {
        String str;
        ListenableFuture listenableFuture = this.f85614i;
        Class cls = this.f85615j;
        Object obj = this.f85616k;
        String strY = super.y();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (strY == null) {
                return null;
            }
            return str + strY;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + obj + "]";
    }
}
