package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeErrorCallable<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f136834a;

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        maybeObserver.a(Disposables.a());
        try {
            th = (Throwable) ObjectHelper.d(this.f136834a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        maybeObserver.onError(th);
    }
}
