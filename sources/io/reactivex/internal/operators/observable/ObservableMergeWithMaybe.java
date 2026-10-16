package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableMergeWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f137914b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f137916b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherObserver f137917c = new OtherObserver(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137918d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile SimplePlainQueue f137919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f137920g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137921h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137922i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile int f137923j;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MergeWithObserver f137924a;

            OtherObserver(MergeWithObserver mergeWithObserver) {
                this.f137924a = mergeWithObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137924a.f();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f137924a.g(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f137924a.i(obj);
            }
        }

        MergeWithObserver(Observer observer) {
            this.f137915a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f137916b, disposable);
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        void c() {
            Observer observer = this.f137915a;
            int iAddAndGet = 1;
            while (!this.f137921h) {
                if (this.f137918d.get() != null) {
                    this.f137920g = null;
                    this.f137919f = null;
                    observer.onError(this.f137918d.b());
                    return;
                }
                int i3 = this.f137923j;
                if (i3 == 1) {
                    Object obj = this.f137920g;
                    this.f137920g = null;
                    this.f137923j = 2;
                    observer.h(obj);
                    i3 = 2;
                }
                boolean z2 = this.f137922i;
                SimplePlainQueue simplePlainQueue = this.f137919f;
                Object objPoll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                boolean z3 = objPoll == null;
                if (z2 && z3 && i3 == 2) {
                    this.f137919f = null;
                    observer.onComplete();
                    return;
                } else if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    observer.h(objPoll);
                }
            }
            this.f137920g = null;
            this.f137919f = null;
        }

        SimplePlainQueue d() {
            SimplePlainQueue simplePlainQueue = this.f137919f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.d());
            this.f137919f = spscLinkedArrayQueue;
            return spscLinkedArrayQueue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137921h = true;
            DisposableHelper.a(this.f137916b);
            DisposableHelper.a(this.f137917c);
            if (getAndIncrement() == 0) {
                this.f137919f = null;
                this.f137920g = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f137916b.get());
        }

        void f() {
            this.f137923j = 2;
            b();
        }

        void g(Throwable th) {
            if (!this.f137918d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this.f137916b);
                b();
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (compareAndSet(0, 1)) {
                this.f137915a.h(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                d().offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            c();
        }

        void i(Object obj) {
            if (compareAndSet(0, 1)) {
                this.f137915a.h(obj);
                this.f137923j = 2;
            } else {
                this.f137920g = obj;
                this.f137923j = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            c();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137922i = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137918d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this.f137916b);
                b();
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.a(mergeWithObserver);
        this.f137267a.b(mergeWithObserver);
        this.f137914b.b(mergeWithObserver.f137917c);
    }
}
