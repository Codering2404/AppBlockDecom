package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFlatMapCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137683c;

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new FlatMapCompletableMainObserver(observer, this.f137682b, this.f137683c));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapCompletableMainObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137684a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f137686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f137687d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137689g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137690h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicThrowable f137685b = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f137688f = new CompositeDisposable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean e() {
                return DisposableHelper.b(get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapCompletableMainObserver.this.b(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainObserver.this.c(this, th);
            }
        }

        FlatMapCompletableMainObserver(Observer observer, Function function, boolean z2) {
            this.f137684a = observer;
            this.f137686c = function;
            this.f137687d = z2;
            lazySet(1);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137689g, disposable)) {
                this.f137689g = disposable;
                this.f137684a.a(this);
            }
        }

        void b(InnerObserver innerObserver) {
            this.f137688f.c(innerObserver);
            onComplete();
        }

        void c(InnerObserver innerObserver, Throwable th) {
            this.f137688f.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137690h = true;
            this.f137689g.dispose();
            this.f137688f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137689g.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f137686c.apply(obj), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f137690h || !this.f137688f.b(innerObserver)) {
                    return;
                }
                completableSource.b(innerObserver);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137689g.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return i3 & 2;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thB = this.f137685b.b();
                if (thB != null) {
                    this.f137684a.onError(thB);
                } else {
                    this.f137684a.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137685b.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137687d) {
                if (decrementAndGet() == 0) {
                    this.f137684a.onError(this.f137685b.b());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.f137684a.onError(this.f137685b.b());
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }
    }
}
