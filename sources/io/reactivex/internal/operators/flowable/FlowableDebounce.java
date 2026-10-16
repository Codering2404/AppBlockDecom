package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135508c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 6725975399620862591L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f135512d = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f135513f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f135514g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final DebounceSubscriber f135515b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f135516c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final Object f135517d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            boolean f135518f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final AtomicBoolean f135519g = new AtomicBoolean();

            DebounceInnerSubscriber(DebounceSubscriber debounceSubscriber, long j3, Object obj) {
                this.f135515b = debounceSubscriber;
                this.f135516c = j3;
                this.f135517d = obj;
            }

            void c() {
                if (this.f135519g.compareAndSet(false, true)) {
                    this.f135515b.a(this.f135516c, this.f135517d);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void h(Object obj) {
                if (this.f135518f) {
                    return;
                }
                this.f135518f = true;
                a();
                c();
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (this.f135518f) {
                    return;
                }
                this.f135518f = true;
                c();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (this.f135518f) {
                    RxJavaPlugins.s(th);
                } else {
                    this.f135518f = true;
                    this.f135515b.onError(th);
                }
            }
        }

        DebounceSubscriber(Subscriber subscriber, Function function) {
            this.f135509a = subscriber;
            this.f135510b = function;
        }

        void a(long j3, Object obj) {
            if (j3 == this.f135513f) {
                if (get() != 0) {
                    this.f135509a.h(obj);
                    BackpressureHelper.e(this, 1L);
                } else {
                    cancel();
                    this.f135509a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135511c.cancel();
            DisposableHelper.a(this.f135512d);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135511c, subscription)) {
                this.f135511c = subscription;
                this.f135509a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135514g) {
                return;
            }
            long j3 = this.f135513f + 1;
            this.f135513f = j3;
            Disposable disposable = (Disposable) this.f135512d.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.d(this.f135510b.apply(obj), "The publisher supplied is null");
                DebounceInnerSubscriber debounceInnerSubscriber = new DebounceInnerSubscriber(this, j3, obj);
                if (h.a(this.f135512d, disposable, debounceInnerSubscriber)) {
                    publisher.i(debounceInnerSubscriber);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                this.f135509a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135514g) {
                return;
            }
            this.f135514g = true;
            Disposable disposable = (Disposable) this.f135512d.get();
            if (DisposableHelper.b(disposable)) {
                return;
            }
            ((DebounceInnerSubscriber) disposable).c();
            DisposableHelper.a(this.f135512d);
            this.f135509a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.a(this.f135512d);
            this.f135509a.onError(th);
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
        this.f135196b.w(new DebounceSubscriber(new SerializedSubscriber(subscriber), this.f135508c));
    }
}
