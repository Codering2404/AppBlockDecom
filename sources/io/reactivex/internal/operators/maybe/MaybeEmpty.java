package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeEmpty extends Maybe<Object> implements ScalarCallable<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MaybeEmpty f136823a = new MaybeEmpty();

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        EmptyDisposable.b(maybeObserver);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
