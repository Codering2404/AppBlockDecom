package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposables;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeError<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Throwable f136833a;

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        maybeObserver.a(Disposables.a());
        maybeObserver.onError(this.f136833a);
    }
}
