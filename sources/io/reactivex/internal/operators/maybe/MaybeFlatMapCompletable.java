package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136852b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -2177128922851101253L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f136853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136854b;

        FlatMapCompletableObserver(CompletableObserver completableObserver, Function function) {
            this.f136853a = completableObserver;
            this.f136854b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136853a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136853a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f136854b.apply(obj), "The mapper returned a null CompletableSource");
                if (e()) {
                    return;
                }
                completableSource.b(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        FlatMapCompletableObserver flatMapCompletableObserver = new FlatMapCompletableObserver(completableObserver, this.f136852b);
        completableObserver.a(flatMapCompletableObserver);
        this.f136851a.b(flatMapCompletableObserver);
    }
}
