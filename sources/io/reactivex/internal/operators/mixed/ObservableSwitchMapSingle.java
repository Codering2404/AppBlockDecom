package io.reactivex.internal.operators.mixed;

import androidx.compose.animation.core.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSwitchMapSingle<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f137249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137251c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final SwitchMapSingleObserver f137252j = new SwitchMapSingleObserver(null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137256d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f137257f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137258g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137259h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137260i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SwitchMapSingleMainObserver f137261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            volatile Object f137262b;

            SwitchMapSingleObserver(SwitchMapSingleMainObserver switchMapSingleMainObserver) {
                this.f137261a = switchMapSingleMainObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f137261a.d(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f137262b = obj;
                this.f137261a.c();
            }
        }

        SwitchMapSingleMainObserver(Observer observer, Function function, boolean z2) {
            this.f137253a = observer;
            this.f137254b = function;
            this.f137255c = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137258g, disposable)) {
                this.f137258g = disposable;
                this.f137253a.a(this);
            }
        }

        void b() {
            AtomicReference atomicReference = this.f137257f;
            SwitchMapSingleObserver switchMapSingleObserver = f137252j;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 == null || switchMapSingleObserver2 == switchMapSingleObserver) {
                return;
            }
            switchMapSingleObserver2.b();
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f137253a;
            AtomicThrowable atomicThrowable = this.f137256d;
            AtomicReference atomicReference = this.f137257f;
            int iAddAndGet = 1;
            while (!this.f137260i) {
                if (atomicThrowable.get() != null && !this.f137255c) {
                    observer.onError(atomicThrowable.b());
                    return;
                }
                boolean z2 = this.f137259h;
                SwitchMapSingleObserver switchMapSingleObserver = (SwitchMapSingleObserver) atomicReference.get();
                boolean z3 = switchMapSingleObserver == null;
                if (z2 && z3) {
                    Throwable thB = atomicThrowable.b();
                    if (thB != null) {
                        observer.onError(thB);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                if (z3 || switchMapSingleObserver.f137262b == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    h.a(atomicReference, switchMapSingleObserver, null);
                    observer.h(switchMapSingleObserver.f137262b);
                }
            }
        }

        void d(SwitchMapSingleObserver switchMapSingleObserver, Throwable th) {
            if (!h.a(this.f137257f, switchMapSingleObserver, null) || !this.f137256d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137255c) {
                this.f137258g.dispose();
                b();
            }
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137260i = true;
            this.f137258g.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137260i;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            SwitchMapSingleObserver switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) this.f137257f.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.b();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.d(this.f137254b.apply(obj), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = (SwitchMapSingleObserver) this.f137257f.get();
                    if (switchMapSingleObserver == f137252j) {
                        return;
                    }
                } while (!h.a(this.f137257f, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.b(switchMapSingleObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137258g.dispose();
                this.f137257f.getAndSet(f137252j);
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137259h = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137256d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137255c) {
                b();
            }
            this.f137259h = true;
            c();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (ScalarXMapZHelper.c(this.f137249a, this.f137250b, observer)) {
            return;
        }
        this.f137249a.b(new SwitchMapSingleMainObserver(observer, this.f137250b, this.f137251c));
    }
}
