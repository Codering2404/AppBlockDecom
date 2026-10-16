package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleFromUnsafeSource<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138878a;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138878a.b(singleObserver);
    }
}
