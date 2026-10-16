package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableElementAtMaybe<T> extends Maybe<T> implements FuseToObservable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137636b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f137640d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f137641f;

        ElementAtObserver(MaybeObserver maybeObserver, long j3) {
            this.f137637a = maybeObserver;
            this.f137638b = j3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137639c, disposable)) {
                this.f137639c = disposable;
                this.f137637a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137639c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137639c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137641f) {
                return;
            }
            long j3 = this.f137640d;
            if (j3 != this.f137638b) {
                this.f137640d = j3 + 1;
                return;
            }
            this.f137641f = true;
            this.f137639c.dispose();
            this.f137637a.onSuccess(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137641f) {
                return;
            }
            this.f137641f = true;
            this.f137637a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137641f) {
                RxJavaPlugins.s(th);
            } else {
                this.f137641f = true;
                this.f137637a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    public void c(MaybeObserver maybeObserver) {
        this.f137635a.b(new ElementAtObserver(maybeObserver, this.f137636b));
    }
}
