package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f138238d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SwitchMapObserver f138239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138240b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138241c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile SimpleQueue f138242d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f138243f;

        SwitchMapInnerObserver(SwitchMapObserver switchMapObserver, long j3, int i3) {
            this.f138239a = switchMapObserver;
            this.f138240b = j3;
            this.f138241c = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int iL = queueDisposable.l(7);
                    if (iL == 1) {
                        this.f138242d = queueDisposable;
                        this.f138243f = true;
                        this.f138239a.c();
                        return;
                    } else if (iL == 2) {
                        this.f138242d = queueDisposable;
                        return;
                    }
                }
                this.f138242d = new SpscLinkedArrayQueue(this.f138241c);
            }
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138240b == this.f138239a.f138254k) {
                if (obj != null) {
                    this.f138242d.offer(obj);
                }
                this.f138239a.c();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138240b == this.f138239a.f138254k) {
                this.f138243f = true;
                this.f138239a.c();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138239a.d(this, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final SwitchMapInnerObserver f138244l;
        private static final long serialVersionUID = -3491074160481096299L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f138248d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f138250g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138251h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Disposable f138252i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile long f138254k;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference f138253j = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f138249f = new AtomicThrowable();

        static {
            SwitchMapInnerObserver switchMapInnerObserver = new SwitchMapInnerObserver(null, -1L, 1);
            f138244l = switchMapInnerObserver;
            switchMapInnerObserver.b();
        }

        SwitchMapObserver(Observer observer, Function function, int i3, boolean z2) {
            this.f138245a = observer;
            this.f138246b = function;
            this.f138247c = i3;
            this.f138248d = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138252i, disposable)) {
                this.f138252i = disposable;
                this.f138245a.a(this);
            }
        }

        void b() {
            SwitchMapInnerObserver switchMapInnerObserver;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) this.f138253j.get();
            SwitchMapInnerObserver switchMapInnerObserver3 = f138244l;
            if (switchMapInnerObserver2 == switchMapInnerObserver3 || (switchMapInnerObserver = (SwitchMapInnerObserver) this.f138253j.getAndSet(switchMapInnerObserver3)) == switchMapInnerObserver3 || switchMapInnerObserver == null) {
                return;
            }
            switchMapInnerObserver.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0010 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x00ee A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                Method dump skipped, instruction units count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.c():void");
        }

        void d(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.f138240b != this.f138254k || !this.f138249f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f138248d) {
                this.f138252i.dispose();
            }
            switchMapInnerObserver.f138243f = true;
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138251h) {
                return;
            }
            this.f138251h = true;
            this.f138252i.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138251h;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            SwitchMapInnerObserver switchMapInnerObserver;
            long j3 = this.f138254k + 1;
            this.f138254k = j3;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) this.f138253j.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.b();
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138246b.apply(obj), "The ObservableSource returned is null");
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j3, this.f138247c);
                do {
                    switchMapInnerObserver = (SwitchMapInnerObserver) this.f138253j.get();
                    if (switchMapInnerObserver == f138244l) {
                        return;
                    }
                } while (!h.a(this.f138253j, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.b(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138252i.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138250g) {
                return;
            }
            this.f138250g = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138250g || !this.f138249f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f138248d) {
                b();
            }
            this.f138250g = true;
            c();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        if (ObservableScalarXMap.a(this.f137267a, observer, this.f138236b)) {
            return;
        }
        this.f137267a.b(new SwitchMapObserver(observer, this.f138236b, this.f138237c, this.f138238d));
    }
}
