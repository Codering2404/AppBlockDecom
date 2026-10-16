package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableReduceMaybe<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiFunction f137992b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReduceObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f137994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137995c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f137996d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f137997f;

        ReduceObserver(MaybeObserver maybeObserver, BiFunction biFunction) {
            this.f137993a = maybeObserver;
            this.f137994b = biFunction;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137997f, disposable)) {
                this.f137997f = disposable;
                this.f137993a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137997f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137997f.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137995c) {
                return;
            }
            Object obj2 = this.f137996d;
            if (obj2 == null) {
                this.f137996d = obj;
                return;
            }
            try {
                this.f137996d = ObjectHelper.d(this.f137994b.apply(obj2, obj), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137997f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137995c) {
                return;
            }
            this.f137995c = true;
            Object obj = this.f137996d;
            this.f137996d = null;
            if (obj != null) {
                this.f137993a.onSuccess(obj);
            } else {
                this.f137993a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137995c) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f137995c = true;
            this.f137996d = null;
            this.f137993a.onError(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f137991a.b(new ReduceObserver(maybeObserver, this.f137992b));
    }
}
