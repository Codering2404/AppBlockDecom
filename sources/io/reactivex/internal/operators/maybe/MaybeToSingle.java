package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeToSingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f137023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f137024b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToSingleMaybeSubscriber<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f137026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137027c;

        ToSingleMaybeSubscriber(SingleObserver singleObserver, Object obj) {
            this.f137025a = singleObserver;
            this.f137026b = obj;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137027c, disposable)) {
                this.f137027c = disposable;
                this.f137025a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137027c.dispose();
            this.f137027c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137027c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f137027c = DisposableHelper.DISPOSED;
            Object obj = this.f137026b;
            if (obj != null) {
                this.f137025a.onSuccess(obj);
            } else {
                this.f137025a.onError(new NoSuchElementException("The MaybeSource is empty"));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f137027c = DisposableHelper.DISPOSED;
            this.f137025a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f137027c = DisposableHelper.DISPOSED;
            this.f137025a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f137023a.b(new ToSingleMaybeSubscriber(singleObserver, this.f137024b));
    }
}
