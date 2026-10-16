package io.reactivex.internal.operators.mixed;

import androidx.compose.animation.core.h;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSwitchMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f137223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137225c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final SwitchMapInnerObserver f137226i = new SwitchMapInnerObserver(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f137227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137230d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f137231f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f137232g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Disposable f137233h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SwitchMapCompletableObserver f137234a;

            SwitchMapInnerObserver(SwitchMapCompletableObserver switchMapCompletableObserver) {
                this.f137234a = switchMapCompletableObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137234a.c(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f137234a.d(this, th);
            }
        }

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function function, boolean z2) {
            this.f137227a = completableObserver;
            this.f137228b = function;
            this.f137229c = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137233h, disposable)) {
                this.f137233h = disposable;
                this.f137227a.a(this);
            }
        }

        void b() {
            AtomicReference atomicReference = this.f137231f;
            SwitchMapInnerObserver switchMapInnerObserver = f137226i;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver);
            if (switchMapInnerObserver2 == null || switchMapInnerObserver2 == switchMapInnerObserver) {
                return;
            }
            switchMapInnerObserver2.b();
        }

        void c(SwitchMapInnerObserver switchMapInnerObserver) {
            if (h.a(this.f137231f, switchMapInnerObserver, null) && this.f137232g) {
                Throwable thB = this.f137230d.b();
                if (thB == null) {
                    this.f137227a.onComplete();
                } else {
                    this.f137227a.onError(thB);
                }
            }
        }

        void d(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!h.a(this.f137231f, switchMapInnerObserver, null) || !this.f137230d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137229c) {
                if (this.f137232g) {
                    this.f137227a.onError(this.f137230d.b());
                    return;
                }
                return;
            }
            dispose();
            Throwable thB = this.f137230d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137227a.onError(thB);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137233h.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137231f.get() == f137226i;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f137228b.apply(obj), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = (SwitchMapInnerObserver) this.f137231f.get();
                    if (switchMapInnerObserver == f137226i) {
                        return;
                    }
                } while (!h.a(this.f137231f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.b();
                }
                completableSource.b(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137233h.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137232g = true;
            if (this.f137231f.get() == null) {
                Throwable thB = this.f137230d.b();
                if (thB == null) {
                    this.f137227a.onComplete();
                } else {
                    this.f137227a.onError(thB);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137230d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137229c) {
                onComplete();
                return;
            }
            b();
            Throwable thB = this.f137230d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137227a.onError(thB);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        if (ScalarXMapZHelper.a(this.f137223a, this.f137224b, completableObserver)) {
            return;
        }
        this.f137223a.b(new SwitchMapCompletableObserver(completableObserver, this.f137224b, this.f137225c));
    }
}
