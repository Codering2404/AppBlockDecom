package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRefCount<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ConnectableObservable f138008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f138009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f138010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f138011d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f138012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    RefConnection f138013g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ObservableRefCount f138014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f138015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f138016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138017d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138018f;

        RefConnection(ObservableRefCount observableRefCount) {
            this.f138014a = observableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Disposable disposable) {
            DisposableHelper.c(this, disposable);
            synchronized (this.f138014a) {
                try {
                    if (this.f138018f) {
                        ((ResettableConnectable) this.f138014a.f138008a).c(disposable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f138014a.C(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -7419642935409022375L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ObservableRefCount f138020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final RefConnection f138021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138022d;

        RefCountObserver(Observer observer, ObservableRefCount observableRefCount, RefConnection refConnection) {
            this.f138019a = observer;
            this.f138020b = observableRefCount;
            this.f138021c = refConnection;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138022d, disposable)) {
                this.f138022d = disposable;
                this.f138019a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138022d.dispose();
            if (compareAndSet(false, true)) {
                this.f138020b.A(this.f138021c);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138022d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138019a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f138020b.B(this.f138021c);
                this.f138019a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                this.f138020b.B(this.f138021c);
                this.f138019a.onError(th);
            }
        }
    }

    void A(RefConnection refConnection) {
        synchronized (this) {
            try {
                RefConnection refConnection2 = this.f138013g;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    long j3 = refConnection.f138016c - 1;
                    refConnection.f138016c = j3;
                    if (j3 == 0 && refConnection.f138017d) {
                        if (this.f138010c == 0) {
                            C(refConnection);
                            return;
                        }
                        SequentialDisposable sequentialDisposable = new SequentialDisposable();
                        refConnection.f138015b = sequentialDisposable;
                        sequentialDisposable.a(this.f138012f.f(refConnection, this.f138010c, this.f138011d));
                    }
                }
            } finally {
            }
        }
    }

    void B(RefConnection refConnection) {
        synchronized (this) {
            try {
                RefConnection refConnection2 = this.f138013g;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f138013g = null;
                    Disposable disposable = refConnection.f138015b;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                }
                long j3 = refConnection.f138016c - 1;
                refConnection.f138016c = j3;
                if (j3 == 0) {
                    ObservableSource observableSource = this.f138008a;
                    if (observableSource instanceof Disposable) {
                        ((Disposable) observableSource).dispose();
                    } else if (observableSource instanceof ResettableConnectable) {
                        ((ResettableConnectable) observableSource).c(refConnection.get());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void C(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.f138016c == 0 && refConnection == this.f138013g) {
                    this.f138013g = null;
                    Disposable disposable = refConnection.get();
                    DisposableHelper.a(refConnection);
                    ObservableSource observableSource = this.f138008a;
                    if (observableSource instanceof Disposable) {
                        ((Disposable) observableSource).dispose();
                    } else if (observableSource instanceof ResettableConnectable) {
                        if (disposable == null) {
                            refConnection.f138018f = true;
                        } else {
                            ((ResettableConnectable) observableSource).c(disposable);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        RefConnection refConnection;
        boolean z2;
        Disposable disposable;
        synchronized (this) {
            try {
                refConnection = this.f138013g;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.f138013g = refConnection;
                }
                long j3 = refConnection.f138016c;
                if (j3 == 0 && (disposable = refConnection.f138015b) != null) {
                    disposable.dispose();
                }
                long j4 = j3 + 1;
                refConnection.f138016c = j4;
                if (refConnection.f138017d || j4 != this.f138009b) {
                    z2 = false;
                } else {
                    z2 = true;
                    refConnection.f138017d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f138008a.b(new RefCountObserver(observer, this, refConnection));
        if (z2) {
            this.f138008a.A(refConnection);
        }
    }
}
