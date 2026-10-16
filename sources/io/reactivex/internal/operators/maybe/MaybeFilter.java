package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFilter<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f136835b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FilterMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f136837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136838c;

        FilterMaybeObserver(MaybeObserver maybeObserver, Predicate predicate) {
            this.f136836a = maybeObserver;
            this.f136837b = predicate;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136838c, disposable)) {
                this.f136838c = disposable;
                this.f136836a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f136838c;
            this.f136838c = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136838c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136836a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136836a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                if (this.f136837b.test(obj)) {
                    this.f136836a.onSuccess(obj);
                } else {
                    this.f136836a.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136836a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new FilterMaybeObserver(maybeObserver, this.f136835b));
    }
}
