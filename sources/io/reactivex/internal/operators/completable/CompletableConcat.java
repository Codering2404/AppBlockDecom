package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableConcat extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f135028b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = 9032184911934499404L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f135030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConcatInnerObserver f135032d = new ConcatInnerObserver(this);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicBoolean f135033f = new AtomicBoolean();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f135034g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f135035h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        SimpleQueue f135036i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Subscription f135037j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f135038k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135039l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -5454794857847146511L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final CompletableConcatSubscriber f135040a;

            ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.f135040a = completableConcatSubscriber;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f135040a.b();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f135040a.c(th);
            }
        }

        CompletableConcatSubscriber(CompletableObserver completableObserver, int i3) {
            this.f135029a = completableObserver;
            this.f135030b = i3;
            this.f135031c = i3 - (i3 >> 2);
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!e()) {
                if (!this.f135039l) {
                    boolean z2 = this.f135038k;
                    try {
                        CompletableSource completableSource = (CompletableSource) this.f135036i.poll();
                        boolean z3 = completableSource == null;
                        if (z2 && z3) {
                            if (this.f135033f.compareAndSet(false, true)) {
                                this.f135029a.onComplete();
                                return;
                            }
                            return;
                        } else if (!z3) {
                            this.f135039l = true;
                            completableSource.b(this.f135032d);
                            f();
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        c(th);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void b() {
            this.f135039l = false;
            a();
        }

        void c(Throwable th) {
            if (!this.f135033f.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135037j.cancel();
                this.f135029a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void h(CompletableSource completableSource) {
            if (this.f135034g != 0 || this.f135036i.offer(completableSource)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135037j.cancel();
            DisposableHelper.a(this.f135032d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(this.f135032d.get());
        }

        void f() {
            if (this.f135034g != 1) {
                int i3 = this.f135035h + 1;
                if (i3 != this.f135031c) {
                    this.f135035h = i3;
                } else {
                    this.f135035h = 0;
                    this.f135037j.y(i3);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135037j, subscription)) {
                this.f135037j = subscription;
                int i3 = this.f135030b;
                long j3 = i3 == Integer.MAX_VALUE ? Long.MAX_VALUE : i3;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(3);
                    if (iL == 1) {
                        this.f135034g = iL;
                        this.f135036i = queueSubscription;
                        this.f135038k = true;
                        this.f135029a.a(this);
                        a();
                        return;
                    }
                    if (iL == 2) {
                        this.f135034g = iL;
                        this.f135036i = queueSubscription;
                        this.f135029a.a(this);
                        subscription.y(j3);
                        return;
                    }
                }
                if (this.f135030b == Integer.MAX_VALUE) {
                    this.f135036i = new SpscLinkedArrayQueue(Flowable.a());
                } else {
                    this.f135036i = new SpscArrayQueue(this.f135030b);
                }
                this.f135029a.a(this);
                subscription.y(j3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135038k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135033f.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this.f135032d);
                this.f135029a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        this.f135027a.i(new CompletableConcatSubscriber(completableObserver, this.f135028b));
    }
}
