package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Flowable f137099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ErrorMode f137101d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f137102f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f137103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f137105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f137106d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f137107f = new AtomicThrowable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final ConcatMapSingleObserver f137108g = new ConcatMapSingleObserver(this);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final SimplePlainQueue f137109h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ErrorMode f137110i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Subscription f137111j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137112k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f137113l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f137114m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f137115n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f137116o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        volatile int f137117p;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ConcatMapSingleSubscriber f137118a;

            ConcatMapSingleObserver(ConcatMapSingleSubscriber concatMapSingleSubscriber) {
                this.f137118a = concatMapSingleSubscriber;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f137118a.b(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f137118a.c(obj);
            }
        }

        ConcatMapSingleSubscriber(Subscriber subscriber, Function function, int i3, ErrorMode errorMode) {
            this.f137103a = subscriber;
            this.f137104b = function;
            this.f137105c = i3;
            this.f137110i = errorMode;
            this.f137109h = new SpscArrayQueue(i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        
            r2.clear();
            r15.f137116o = null;
            r0.onError(r3.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a() {
            /*
                Method dump skipped, instruction units count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.FlowableConcatMapSingle.ConcatMapSingleSubscriber.a():void");
        }

        void b(Throwable th) {
            if (!this.f137107f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137110i != ErrorMode.END) {
                this.f137111j.cancel();
            }
            this.f137117p = 0;
            a();
        }

        void c(Object obj) {
            this.f137116o = obj;
            this.f137117p = 2;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f137113l = true;
            this.f137111j.cancel();
            this.f137108g.b();
            if (getAndIncrement() == 0) {
                this.f137109h.clear();
                this.f137116o = null;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137111j, subscription)) {
                this.f137111j = subscription;
                this.f137103a.g(this);
                subscription.y(this.f137105c);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f137109h.offer(obj)) {
                a();
            } else {
                this.f137111j.cancel();
                onError(new MissingBackpressureException("queue full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137112k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f137107f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137110i == ErrorMode.IMMEDIATE) {
                this.f137108g.b();
            }
            this.f137112k = true;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f137106d, j3);
            a();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137099b.w(new ConcatMapSingleSubscriber(subscriber, this.f137100c, this.f137102f, this.f137101d));
    }
}
