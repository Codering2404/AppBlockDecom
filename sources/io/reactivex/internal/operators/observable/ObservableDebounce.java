package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDebounce<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137537b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceObserver<T, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f137541d = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f137542f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f137543g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class DebounceInnerObserver<T, U> extends DisposableObserver<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final DebounceObserver f137544b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f137545c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final Object f137546d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            boolean f137547f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final AtomicBoolean f137548g = new AtomicBoolean();

            DebounceInnerObserver(DebounceObserver debounceObserver, long j3, Object obj) {
                this.f137544b = debounceObserver;
                this.f137545c = j3;
                this.f137546d = obj;
            }

            void c() {
                if (this.f137548g.compareAndSet(false, true)) {
                    this.f137544b.b(this.f137545c, this.f137546d);
                }
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                if (this.f137547f) {
                    return;
                }
                this.f137547f = true;
                dispose();
                c();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.f137547f) {
                    return;
                }
                this.f137547f = true;
                c();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (this.f137547f) {
                    RxJavaPlugins.s(th);
                } else {
                    this.f137547f = true;
                    this.f137544b.onError(th);
                }
            }
        }

        DebounceObserver(Observer observer, Function function) {
            this.f137538a = observer;
            this.f137539b = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137540c, disposable)) {
                this.f137540c = disposable;
                this.f137538a.a(this);
            }
        }

        void b(long j3, Object obj) {
            if (j3 == this.f137542f) {
                this.f137538a.h(obj);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137540c.dispose();
            DisposableHelper.a(this.f137541d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137540c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137543g) {
                return;
            }
            long j3 = this.f137542f + 1;
            this.f137542f = j3;
            Disposable disposable = (Disposable) this.f137541d.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137539b.apply(obj), "The ObservableSource supplied is null");
                DebounceInnerObserver debounceInnerObserver = new DebounceInnerObserver(this, j3, obj);
                if (h.a(this.f137541d, disposable, debounceInnerObserver)) {
                    observableSource.b(debounceInnerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f137538a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137543g) {
                return;
            }
            this.f137543g = true;
            Disposable disposable = (Disposable) this.f137541d.get();
            if (disposable != DisposableHelper.DISPOSED) {
                ((DebounceInnerObserver) disposable).c();
                DisposableHelper.a(this.f137541d);
                this.f137538a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f137541d);
            this.f137538a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new DebounceObserver(new SerializedObserver(observer), this.f137537b));
    }
}
