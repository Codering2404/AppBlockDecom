package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f135521d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f135522f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f135523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final DebounceTimedSubscriber f135525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f135526d = new AtomicBoolean();

        DebounceEmitter(Object obj, long j3, DebounceTimedSubscriber debounceTimedSubscriber) {
            this.f135523a = obj;
            this.f135524b = j3;
            this.f135525c = debounceTimedSubscriber;
        }

        void a() {
            if (this.f135526d.compareAndSet(false, true)) {
                this.f135525c.a(this.f135524b, this.f135523a, this);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9102637559663639004L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f135529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f135530d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f135531f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f135532g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f135533h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f135534i;

        DebounceTimedSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f135527a = subscriber;
            this.f135528b = j3;
            this.f135529c = timeUnit;
            this.f135530d = worker;
        }

        void a(long j3, Object obj, DebounceEmitter debounceEmitter) {
            if (j3 == this.f135533h) {
                if (get() == 0) {
                    cancel();
                    this.f135527a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                } else {
                    this.f135527a.h(obj);
                    BackpressureHelper.e(this, 1L);
                    debounceEmitter.dispose();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135531f.cancel();
            this.f135530d.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135531f, subscription)) {
                this.f135531f = subscription;
                this.f135527a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135534i) {
                return;
            }
            long j3 = this.f135533h + 1;
            this.f135533h = j3;
            Disposable disposable = this.f135532g;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(obj, j3, this);
            this.f135532g = debounceEmitter;
            debounceEmitter.b(this.f135530d.c(debounceEmitter, this.f135528b, this.f135529c));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135534i) {
                return;
            }
            this.f135534i = true;
            Disposable disposable = this.f135532g;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.a();
            }
            this.f135527a.onComplete();
            this.f135530d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135534i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135534i = true;
            Disposable disposable = this.f135532g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f135527a.onError(th);
            this.f135530d.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f135520c, this.f135521d, this.f135522f.b()));
    }
}
