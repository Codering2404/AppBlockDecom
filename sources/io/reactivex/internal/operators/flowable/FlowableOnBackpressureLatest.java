package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 163080509307634843L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f136041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f136042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f136043d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f136044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f136045g = new AtomicLong();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f136046h = new AtomicReference();

        BackpressureLatestSubscriber(Subscriber subscriber) {
            this.f136040a = subscriber;
        }

        boolean a(boolean z2, boolean z3, Subscriber subscriber, AtomicReference atomicReference) {
            if (this.f136044f) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z2) {
                return false;
            }
            Throwable th = this.f136043d;
            if (th != null) {
                atomicReference.lazySet(null);
                subscriber.onError(th);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.f136042c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (a(r9, r10, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.e(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                goto L5e
            L7:
                org.reactivestreams.Subscriber r0 = r13.f136040a
                java.util.concurrent.atomic.AtomicLong r1 = r13.f136045g
                java.util.concurrent.atomic.AtomicReference r2 = r13.f136046h
                r3 = 1
                r4 = r3
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                r10 = 0
                if (r9 == 0) goto L38
                boolean r9 = r13.f136042c
                r11 = 0
                java.lang.Object r11 = r2.getAndSet(r11)
                if (r11 != 0) goto L26
                r12 = r3
                goto L27
            L26:
                r12 = r10
            L27:
                boolean r9 = r13.a(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                goto L5e
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.h(r11)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r11 = r1.get()
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 != 0) goto L50
                boolean r9 = r13.f136042c
                java.lang.Object r11 = r2.get()
                if (r11 != 0) goto L49
                r10 = r3
            L49:
                boolean r9 = r13.a(r9, r10, r0, r2)
                if (r9 == 0) goto L50
                goto L5e
            L50:
                int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r5 == 0) goto L57
                io.reactivex.internal.util.BackpressureHelper.e(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest.BackpressureLatestSubscriber.b():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136044f) {
                return;
            }
            this.f136044f = true;
            this.f136041b.cancel();
            if (getAndIncrement() == 0) {
                this.f136046h.lazySet(null);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136041b, subscription)) {
                this.f136041b = subscription;
                this.f136040a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136046h.lazySet(obj);
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136042c = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136043d = th;
            this.f136042c = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136045g, j3);
                b();
            }
        }
    }

    public FlowableOnBackpressureLatest(Flowable flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new BackpressureLatestSubscriber(subscriber));
    }
}
