package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeLift<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeOperator f136923b;

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        try {
            this.f136730a.b((MaybeObserver) ObjectHelper.d(this.f136923b.a(maybeObserver), "The operator returned a null MaybeObserver"));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, maybeObserver);
        }
    }
}
