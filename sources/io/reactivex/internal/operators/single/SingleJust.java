package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposables;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleJust<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f138890a;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        singleObserver.a(Disposables.a());
        singleObserver.onSuccess(this.f138890a);
    }
}
