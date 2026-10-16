package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableDoOnEvent extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f135079b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class DoOnEvent implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CompletableObserver f135080a;

        DoOnEvent(CompletableObserver completableObserver) {
            this.f135080a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135080a.a(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                CompletableDoOnEvent.this.f135079b.accept(null);
                this.f135080a.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135080a.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            try {
                CompletableDoOnEvent.this.f135079b.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f135080a.onError(th);
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135078a.b(new DoOnEvent(completableObserver));
    }
}
