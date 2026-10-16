package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableFromAction extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Action f135085a;

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        Disposable disposableB = Disposables.b();
        completableObserver.a(disposableB);
        try {
            this.f135085a.run();
            if (disposableB.e()) {
                return;
            }
            completableObserver.onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            if (disposableB.e()) {
                return;
            }
            completableObserver.onError(th);
        }
    }
}
