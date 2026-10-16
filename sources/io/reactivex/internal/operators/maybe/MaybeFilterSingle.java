package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFilterSingle<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f136839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f136840b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FilterMaybeObserver<T> implements SingleObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f136842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136843c;

        FilterMaybeObserver(MaybeObserver maybeObserver, Predicate predicate) {
            this.f136841a = maybeObserver;
            this.f136842b = predicate;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136843c, disposable)) {
                this.f136843c = disposable;
                this.f136841a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f136843c;
            this.f136843c = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136843c.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f136841a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                if (this.f136842b.test(obj)) {
                    this.f136841a.onSuccess(obj);
                } else {
                    this.f136841a.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136841a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136839a.b(new FilterMaybeObserver(maybeObserver, this.f136840b));
    }
}
