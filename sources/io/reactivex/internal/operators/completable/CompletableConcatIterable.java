package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableConcatIterable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable f135046a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator f135048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SequentialDisposable f135049c = new SequentialDisposable();

        ConcatInnerObserver(CompletableObserver completableObserver, Iterator it) {
            this.f135047a = completableObserver;
            this.f135048b = it;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135049c.a(disposable);
        }

        void b() {
            if (!this.f135049c.e() && getAndIncrement() == 0) {
                Iterator it = this.f135048b;
                while (!this.f135049c.e()) {
                    try {
                        if (!it.hasNext()) {
                            this.f135047a.onComplete();
                            return;
                        }
                        try {
                            ((CompletableSource) ObjectHelper.d(it.next(), "The CompletableSource returned is null")).b(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f135047a.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        this.f135047a.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135047a.onError(th);
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        try {
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, (Iterator) ObjectHelper.d(this.f135046a.iterator(), "The iterator returned is null"));
            completableObserver.a(concatInnerObserver.f135049c);
            concatInnerObserver.b();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.g(th, completableObserver);
        }
    }
}
