package io.reactivex.internal.operators.mixed;

import androidx.compose.animation.core.h;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
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
public final class ObservableSwitchMapMaybe<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f137235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137237c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final SwitchMapMaybeObserver f137238j = new SwitchMapMaybeObserver(null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137242d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f137243f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137244g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137245h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137246i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SwitchMapMaybeMainObserver f137247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            volatile Object f137248b;

            SwitchMapMaybeObserver(SwitchMapMaybeMainObserver switchMapMaybeMainObserver) {
                this.f137247a = switchMapMaybeMainObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137247a.d(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f137247a.f(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f137248b = obj;
                this.f137247a.c();
            }
        }

        SwitchMapMaybeMainObserver(Observer observer, Function function, boolean z2) {
            this.f137239a = observer;
            this.f137240b = function;
            this.f137241c = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137244g, disposable)) {
                this.f137244g = disposable;
                this.f137239a.a(this);
            }
        }

        void b() {
            AtomicReference atomicReference = this.f137243f;
            SwitchMapMaybeObserver switchMapMaybeObserver = f137238j;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
                return;
            }
            switchMapMaybeObserver2.b();
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f137239a;
            AtomicThrowable atomicThrowable = this.f137242d;
            AtomicReference atomicReference = this.f137243f;
            int iAddAndGet = 1;
            while (!this.f137246i) {
                if (atomicThrowable.get() != null && !this.f137241c) {
                    observer.onError(atomicThrowable.b());
                    return;
                }
                boolean z2 = this.f137245h;
                SwitchMapMaybeObserver switchMapMaybeObserver = (SwitchMapMaybeObserver) atomicReference.get();
                boolean z3 = switchMapMaybeObserver == null;
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
                if (z3 || switchMapMaybeObserver.f137248b == null) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    h.a(atomicReference, switchMapMaybeObserver, null);
                    observer.h(switchMapMaybeObserver.f137248b);
                }
            }
        }

        void d(SwitchMapMaybeObserver switchMapMaybeObserver) {
            if (h.a(this.f137243f, switchMapMaybeObserver, null)) {
                c();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137246i = true;
            this.f137244g.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137246i;
        }

        void f(SwitchMapMaybeObserver switchMapMaybeObserver, Throwable th) {
            if (!h.a(this.f137243f, switchMapMaybeObserver, null) || !this.f137242d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137241c) {
                this.f137244g.dispose();
                b();
            }
            c();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            SwitchMapMaybeObserver switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = (SwitchMapMaybeObserver) this.f137243f.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.b();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f137240b.apply(obj), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = (SwitchMapMaybeObserver) this.f137243f.get();
                    if (switchMapMaybeObserver == f137238j) {
                        return;
                    }
                } while (!h.a(this.f137243f, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.b(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137244g.dispose();
                this.f137243f.getAndSet(f137238j);
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137245h = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137242d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137241c) {
                b();
            }
            this.f137245h = true;
            c();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (ScalarXMapZHelper.b(this.f137235a, this.f137236b, observer)) {
            return;
        }
        this.f137235a.b(new SwitchMapMaybeMainObserver(observer, this.f137236b, this.f137237c));
    }
}
