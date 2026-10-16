package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableOnErrorComplete extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f135133b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class OnError implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CompletableObserver f135134a;

        OnError(CompletableObserver completableObserver) {
            this.f135134a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135134a.a(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135134a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.f135133b.test(th)) {
                    this.f135134a.onComplete();
                } else {
                    this.f135134a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f135134a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135132a.b(new OnError(completableObserver));
    }
}
