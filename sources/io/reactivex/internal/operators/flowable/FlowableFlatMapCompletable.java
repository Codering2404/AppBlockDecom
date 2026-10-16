package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFlatMapCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135675d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f135676f;

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new FlatMapCompletableMainSubscriber(subscriber, this.f135674c, this.f135676f, this.f135675d));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8443155186132538303L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135677a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f135679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f135680d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f135682g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f135683h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f135684i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicThrowable f135678b = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f135681f = new CompositeDisposable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerConsumer() {
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
                FlatMapCompletableMainSubscriber.this.e(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.j(this, th);
            }
        }

        FlatMapCompletableMainSubscriber(Subscriber subscriber, Function function, boolean z2, int i3) {
            this.f135677a = subscriber;
            this.f135679c = function;
            this.f135680d = z2;
            this.f135682g = i3;
            lazySet(1);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135684i = true;
            this.f135683h.cancel();
            this.f135681f.dispose();
        }

        void e(InnerConsumer innerConsumer) {
            this.f135681f.c(innerConsumer);
            onComplete();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135683h, subscription)) {
                this.f135683h = subscription;
                this.f135677a.g(this);
                int i3 = this.f135682g;
                if (i3 == Integer.MAX_VALUE) {
                    subscription.y(Long.MAX_VALUE);
                } else {
                    subscription.y(i3);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f135679c.apply(obj), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerConsumer innerConsumer = new InnerConsumer();
                if (this.f135684i || !this.f135681f.b(innerConsumer)) {
                    return;
                }
                completableSource.b(innerConsumer);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135683h.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        void j(InnerConsumer innerConsumer, Throwable th) {
            this.f135681f.c(innerConsumer);
            onError(th);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return i3 & 2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.f135682g != Integer.MAX_VALUE) {
                    this.f135683h.y(1L);
                }
            } else {
                Throwable thB = this.f135678b.b();
                if (thB != null) {
                    this.f135677a.onError(thB);
                } else {
                    this.f135677a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135678b.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f135680d) {
                cancel();
                if (getAndSet(0) > 0) {
                    this.f135677a.onError(this.f135678b.b());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.f135677a.onError(this.f135678b.b());
            } else if (this.f135682g != Integer.MAX_VALUE) {
                this.f135683h.y(1L);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
        }
    }
}
