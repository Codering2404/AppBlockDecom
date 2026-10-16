package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableEmpty extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Completable f135082a = new CompletableEmpty();

    private CompletableEmpty() {
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        EmptyDisposable.a(completableObserver);
    }
}
