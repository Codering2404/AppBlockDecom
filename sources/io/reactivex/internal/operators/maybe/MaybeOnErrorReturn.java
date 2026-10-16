package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeOnErrorReturn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136960b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136963c;

        OnErrorReturnMaybeObserver(MaybeObserver maybeObserver, Function function) {
            this.f136961a = maybeObserver;
            this.f136962b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136963c, disposable)) {
                this.f136963c = disposable;
                this.f136961a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136963c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136963c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136961a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            try {
                this.f136961a.onSuccess(ObjectHelper.d(this.f136962b.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f136961a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136961a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new OnErrorReturnMaybeObserver(maybeObserver, this.f136960b));
    }
}
