package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSingleMaybe<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138175a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f138176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f138177b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138178c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138179d;

        SingleElementObserver(MaybeObserver maybeObserver) {
            this.f138176a = maybeObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138177b, disposable)) {
                this.f138177b = disposable;
                this.f138176a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138177b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138177b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138179d) {
                return;
            }
            if (this.f138178c == null) {
                this.f138178c = obj;
                return;
            }
            this.f138179d = true;
            this.f138177b.dispose();
            this.f138176a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138179d) {
                return;
            }
            this.f138179d = true;
            Object obj = this.f138178c;
            this.f138178c = null;
            if (obj == null) {
                this.f138176a.onComplete();
            } else {
                this.f138176a.onSuccess(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138179d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138179d = true;
                this.f138176a.onError(th);
            }
        }
    }

    public ObservableSingleMaybe(ObservableSource observableSource) {
        this.f138175a = observableSource;
    }

    @Override // io.reactivex.Maybe
    public void c(MaybeObserver maybeObserver) {
        this.f138175a.b(new SingleElementObserver(maybeObserver));
    }
}
