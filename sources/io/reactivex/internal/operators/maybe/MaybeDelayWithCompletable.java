package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDelayWithCompletable<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f136804b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelayWithMainObserver<T> implements MaybeObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f136805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeObserver f136806b;

        DelayWithMainObserver(AtomicReference atomicReference, MaybeObserver maybeObserver) {
            this.f136805a = atomicReference;
            this.f136806b = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f136805a, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136806b.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136806b.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136806b.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OtherObserver<T> extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 703409937383992161L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeSource f136808b;

        OtherObserver(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            this.f136807a = maybeObserver;
            this.f136808b = maybeSource;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136807a.a(this);
            }
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
            this.f136808b.b(new DelayWithMainObserver(this, this.f136807a));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f136807a.onError(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136804b.b(new OtherObserver(maybeObserver, this.f136803a));
    }
}
