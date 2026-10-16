package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f136949b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorCompleteMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f136951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136952c;

        OnErrorCompleteMaybeObserver(MaybeObserver maybeObserver, Predicate predicate) {
            this.f136950a = maybeObserver;
            this.f136951b = predicate;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136952c, disposable)) {
                this.f136952c = disposable;
                this.f136950a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136952c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136952c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136950a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            try {
                if (this.f136951b.test(th)) {
                    this.f136950a.onComplete();
                } else {
                    this.f136950a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f136950a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136950a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new OnErrorCompleteMaybeObserver(maybeObserver, this.f136949b));
    }
}
