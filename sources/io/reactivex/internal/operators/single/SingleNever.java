package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleNever extends Single<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Single f138898a = new SingleNever();

    private SingleNever() {
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        singleObserver.a(EmptyDisposable.NEVER);
    }
}
