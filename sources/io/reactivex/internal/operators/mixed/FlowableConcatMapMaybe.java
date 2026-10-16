package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
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
public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Flowable f137079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ErrorMode f137081d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f137082f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -9140123220065488293L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f137083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f137085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f137086d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f137087f = new AtomicThrowable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final ConcatMapMaybeObserver f137088g = new ConcatMapMaybeObserver(this);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final SimplePlainQueue f137089h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ErrorMode f137090i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Subscription f137091j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137092k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f137093l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f137094m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f137095n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f137096o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        volatile int f137097p;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ConcatMapMaybeSubscriber f137098a;

            ConcatMapMaybeObserver(ConcatMapMaybeSubscriber concatMapMaybeSubscriber) {
                this.f137098a = concatMapMaybeSubscriber;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137098a.b();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f137098a.c(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f137098a.d(obj);
            }
        }

        ConcatMapMaybeSubscriber(Subscriber subscriber, Function function, int i3, ErrorMode errorMode) {
            this.f137083a = subscriber;
            this.f137084b = function;
            this.f137085c = i3;
            this.f137090i = errorMode;
            this.f137089h = new SpscArrayQueue(i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        
            r2.clear();
            r15.f137096o = null;
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe.ConcatMapMaybeSubscriber.a():void");
        }

        void b() {
            this.f137097p = 0;
            a();
        }

        void c(Throwable th) {
            if (!this.f137087f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137090i != ErrorMode.END) {
                this.f137091j.cancel();
            }
            this.f137097p = 0;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f137093l = true;
            this.f137091j.cancel();
            this.f137088g.b();
            if (getAndIncrement() == 0) {
                this.f137089h.clear();
                this.f137096o = null;
            }
        }

        void d(Object obj) {
            this.f137096o = obj;
            this.f137097p = 2;
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137091j, subscription)) {
                this.f137091j = subscription;
                this.f137083a.g(this);
                subscription.y(this.f137085c);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f137089h.offer(obj)) {
                a();
            } else {
                this.f137091j.cancel();
                onError(new MissingBackpressureException("queue full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137092k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f137087f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137090i == ErrorMode.IMMEDIATE) {
                this.f137088g.b();
            }
            this.f137092k = true;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f137086d, j3);
            a();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137079b.w(new ConcatMapMaybeSubscriber(subscriber, this.f137080c, this.f137082f, this.f137081d));
    }
}
