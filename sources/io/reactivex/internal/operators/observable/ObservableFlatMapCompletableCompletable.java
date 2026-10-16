package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends Completable implements FuseToObservable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137694c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements Disposable, Observer<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f137695a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f137697c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f137698d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137700g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137701h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicThrowable f137696b = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f137699f = new CompositeDisposable();

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

        FlatMapCompletableMainObserver(CompletableObserver completableObserver, Function function, boolean z2) {
            this.f137695a = completableObserver;
            this.f137697c = function;
            this.f137698d = z2;
            lazySet(1);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137700g, disposable)) {
                this.f137700g = disposable;
                this.f137695a.a(this);
            }
        }

        void b(InnerObserver innerObserver) {
            this.f137699f.c(innerObserver);
            onComplete();
        }

        void c(InnerObserver innerObserver, Throwable th) {
            this.f137699f.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137701h = true;
            this.f137700g.dispose();
            this.f137699f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137700g.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f137697c.apply(obj), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f137701h || !this.f137699f.b(innerObserver)) {
                    return;
                }
                completableSource.b(innerObserver);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137700g.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thB = this.f137696b.b();
                if (thB != null) {
                    this.f137695a.onError(thB);
                } else {
                    this.f137695a.onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137696b.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137698d) {
                if (decrementAndGet() == 0) {
                    this.f137695a.onError(this.f137696b.b());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.f137695a.onError(this.f137696b.b());
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f137692a.b(new FlatMapCompletableMainObserver(completableObserver, this.f137693b, this.f137694c));
    }
}
