package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f137062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f137064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137065d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f137066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ErrorMode f137068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137069d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ConcatMapInnerObserver f137070f = new ConcatMapInnerObserver(this);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f137071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final SimplePlainQueue f137072h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Subscription f137073i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137074j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137075k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f137076l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f137077m;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ConcatMapCompletableObserver f137078a;

            ConcatMapInnerObserver(ConcatMapCompletableObserver concatMapCompletableObserver) {
                this.f137078a = concatMapCompletableObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137078a.b();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f137078a.c(th);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function function, ErrorMode errorMode, int i3) {
            this.f137066a = completableObserver;
            this.f137067b = function;
            this.f137068c = errorMode;
            this.f137071g = i3;
            this.f137072h = new SpscArrayQueue(i3);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f137076l) {
                if (!this.f137074j) {
                    if (this.f137068c == ErrorMode.BOUNDARY && this.f137069d.get() != null) {
                        this.f137072h.clear();
                        this.f137066a.onError(this.f137069d.b());
                        return;
                    }
                    boolean z2 = this.f137075k;
                    Object objPoll = this.f137072h.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable thB = this.f137069d.b();
                        if (thB != null) {
                            this.f137066a.onError(thB);
                            return;
                        } else {
                            this.f137066a.onComplete();
                            return;
                        }
                    }
                    if (!z3) {
                        int i3 = this.f137071g;
                        int i4 = i3 - (i3 >> 1);
                        int i5 = this.f137077m + 1;
                        if (i5 == i4) {
                            this.f137077m = 0;
                            this.f137073i.y(i4);
                        } else {
                            this.f137077m = i5;
                        }
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f137067b.apply(objPoll), "The mapper returned a null CompletableSource");
                            this.f137074j = true;
                            completableSource.b(this.f137070f);
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f137072h.clear();
                            this.f137073i.cancel();
                            this.f137069d.a(th);
                            this.f137066a.onError(this.f137069d.b());
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f137072h.clear();
        }

        void b() {
            this.f137074j = false;
            a();
        }

        void c(Throwable th) {
            if (!this.f137069d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137068c != ErrorMode.IMMEDIATE) {
                this.f137074j = false;
                a();
                return;
            }
            this.f137073i.cancel();
            Throwable thB = this.f137069d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137066a.onError(thB);
            }
            if (getAndIncrement() == 0) {
                this.f137072h.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137076l = true;
            this.f137073i.cancel();
            this.f137070f.b();
            if (getAndIncrement() == 0) {
                this.f137072h.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137076l;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137073i, subscription)) {
                this.f137073i = subscription;
                this.f137066a.a(this);
                subscription.y(this.f137071g);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f137072h.offer(obj)) {
                a();
            } else {
                this.f137073i.cancel();
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137075k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f137069d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137068c != ErrorMode.IMMEDIATE) {
                this.f137075k = true;
                a();
                return;
            }
            this.f137070f.b();
            Throwable thB = this.f137069d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137066a.onError(thB);
            }
            if (getAndIncrement() == 0) {
                this.f137072h.clear();
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f137062a.w(new ConcatMapCompletableObserver(completableObserver, this.f137063b, this.f137064c, this.f137065d));
    }
}
