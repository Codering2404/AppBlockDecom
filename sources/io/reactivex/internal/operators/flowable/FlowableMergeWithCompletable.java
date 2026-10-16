package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final CompletableSource f135943c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f135945b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherObserver f135946c = new OtherObserver(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f135947d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135948f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f135949g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f135950h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MergeWithSubscriber f135951a;

            OtherObserver(MergeWithSubscriber mergeWithSubscriber) {
                this.f135951a = mergeWithSubscriber;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f135951a.a();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f135951a.b(th);
            }
        }

        MergeWithSubscriber(Subscriber subscriber) {
            this.f135944a = subscriber;
        }

        void a() {
            this.f135950h = true;
            if (this.f135949g) {
                HalfSerializer.b(this.f135944a, this, this.f135947d);
            }
        }

        void b(Throwable th) {
            SubscriptionHelper.a(this.f135945b);
            HalfSerializer.d(this.f135944a, th, this, this.f135947d);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f135945b);
            DisposableHelper.a(this.f135946c);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f135945b, this.f135948f, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            HalfSerializer.f(this.f135944a, obj, this, this.f135947d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135949g = true;
            if (this.f135950h) {
                HalfSerializer.b(this.f135944a, this, this.f135947d);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f135945b);
            HalfSerializer.d(this.f135944a, th, this, this.f135947d);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f135945b, this.f135948f, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.g(mergeWithSubscriber);
        this.f135196b.w(mergeWithSubscriber);
        this.f135943c.b(mergeWithSubscriber.f135946c);
    }
}
