package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDefer<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f136781a;

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        try {
            ((MaybeSource) ObjectHelper.d(this.f136781a.call(), "The maybeSupplier returned a null MaybeSource")).b(maybeObserver);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, maybeObserver);
        }
    }
}
