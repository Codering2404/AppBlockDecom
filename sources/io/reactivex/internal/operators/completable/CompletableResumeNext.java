package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableResumeNext extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f135147b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f135150c;

        ResumeNextObserver(CompletableObserver completableObserver, Function function) {
            this.f135148a = completableObserver;
            this.f135149b = function;
        }

        @Override // io.reactivex.CompletableObserver
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135148a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.f135150c) {
                this.f135148a.onError(th);
                return;
            }
            this.f135150c = true;
            try {
                ((CompletableSource) ObjectHelper.d(this.f135149b.apply(th), "The errorMapper returned a null CompletableSource")).b(this);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f135148a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.f135147b);
        completableObserver.a(resumeNextObserver);
        this.f135146a.b(resumeNextObserver);
    }
}
