package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFlatMapMaybe<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f135700d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135701f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 8600231336733376951L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f135703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135704c;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Function f135709i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Subscription f135711k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135712l;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f135705d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f135706f = new CompositeDisposable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicThrowable f135708h = new AtomicThrowable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f135707g = new AtomicInteger(1);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference f135710j = new AtomicReference();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
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

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapMaybeSubscriber.this.e(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeSubscriber.this.f(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                FlatMapMaybeSubscriber.this.i(this, obj);
            }
        }

        FlatMapMaybeSubscriber(Subscriber subscriber, Function function, boolean z2, int i3) {
            this.f135702a = subscriber;
            this.f135709i = function;
            this.f135703b = z2;
            this.f135704c = i3;
        }

        void a() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f135710j.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                c();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
        
            if (r10 != r6) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
        
            if (r17.f135712l == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
        
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        
            if (r17.f135703b != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
        
            if (r17.f135708h.get() == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
        
            r2 = r17.f135708h.b();
            a();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
        
            if (r2.get() != 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
        
            r7 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
        
            if (r7 == null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b3, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
        
            if (r6 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b6, code lost:
        
            if (r13 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
        
            r2 = r17.f135708h.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00be, code lost:
        
            if (r2 == null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c3, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        
            if (r10 == 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.e(r17.f135705d, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
        
            if (r17.f135704c == Integer.MAX_VALUE) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
        
            r17.f135711k.y(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.c():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135712l = true;
            this.f135711k.cancel();
            this.f135706f.dispose();
        }

        SpscLinkedArrayQueue d() {
            SpscLinkedArrayQueue spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) this.f135710j.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Flowable.a());
            } while (!h.a(this.f135710j, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        void e(InnerObserver innerObserver) {
            this.f135706f.c(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z2 = this.f135707g.decrementAndGet() == 0;
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f135710j.get();
                    if (z2 && (spscLinkedArrayQueue == null || spscLinkedArrayQueue.isEmpty())) {
                        Throwable thB = this.f135708h.b();
                        if (thB != null) {
                            this.f135702a.onError(thB);
                            return;
                        } else {
                            this.f135702a.onComplete();
                            return;
                        }
                    }
                    if (this.f135704c != Integer.MAX_VALUE) {
                        this.f135711k.y(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    c();
                    return;
                }
            }
            this.f135707g.decrementAndGet();
            if (this.f135704c != Integer.MAX_VALUE) {
                this.f135711k.y(1L);
            }
            b();
        }

        void f(InnerObserver innerObserver, Throwable th) {
            this.f135706f.c(innerObserver);
            if (!this.f135708h.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f135703b) {
                this.f135711k.cancel();
                this.f135706f.dispose();
            } else if (this.f135704c != Integer.MAX_VALUE) {
                this.f135711k.y(1L);
            }
            this.f135707g.decrementAndGet();
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135711k, subscription)) {
                this.f135711k = subscription;
                this.f135702a.g(this);
                int i3 = this.f135704c;
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
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f135709i.apply(obj), "The mapper returned a null MaybeSource");
                this.f135707g.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f135712l || !this.f135706f.b(innerObserver)) {
                    return;
                }
                maybeSource.b(innerObserver);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135711k.cancel();
                onError(th);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void i(io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.InnerObserver r5, java.lang.Object r6) {
            /*
                r4 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r4.f135706f
                r0.c(r5)
                int r5 = r4.get()
                if (r5 != 0) goto L7a
                r5 = 0
                r0 = 1
                boolean r1 = r4.compareAndSet(r5, r0)
                if (r1 == 0) goto L7a
                java.util.concurrent.atomic.AtomicInteger r1 = r4.f135707g
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L1c
                r5 = r0
            L1c:
                java.util.concurrent.atomic.AtomicLong r0 = r4.f135705d
                long r0 = r0.get()
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L67
                org.reactivestreams.Subscriber r0 = r4.f135702a
                r0.h(r6)
                java.util.concurrent.atomic.AtomicReference r6 = r4.f135710j
                java.lang.Object r6 = r6.get()
                io.reactivex.internal.queue.SpscLinkedArrayQueue r6 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r6
                if (r5 == 0) goto L53
                if (r6 == 0) goto L3f
                boolean r5 = r6.isEmpty()
                if (r5 == 0) goto L53
            L3f:
                io.reactivex.internal.util.AtomicThrowable r5 = r4.f135708h
                java.lang.Throwable r5 = r5.b()
                if (r5 == 0) goto L4d
                org.reactivestreams.Subscriber r6 = r4.f135702a
                r6.onError(r5)
                return
            L4d:
                org.reactivestreams.Subscriber r5 = r4.f135702a
                r5.onComplete()
                return
            L53:
                java.util.concurrent.atomic.AtomicLong r5 = r4.f135705d
                r0 = 1
                io.reactivex.internal.util.BackpressureHelper.e(r5, r0)
                int r5 = r4.f135704c
                r6 = 2147483647(0x7fffffff, float:NaN)
                if (r5 == r6) goto L70
                org.reactivestreams.Subscription r5 = r4.f135711k
                r5.y(r0)
                goto L70
            L67:
                io.reactivex.internal.queue.SpscLinkedArrayQueue r5 = r4.d()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            L70:
                int r5 = r4.decrementAndGet()
                if (r5 != 0) goto L8f
                goto L8e
            L77:
                r6 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
                throw r6
            L7a:
                io.reactivex.internal.queue.SpscLinkedArrayQueue r5 = r4.d()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L93
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                java.util.concurrent.atomic.AtomicInteger r5 = r4.f135707g
                r5.decrementAndGet()
                int r5 = r4.getAndIncrement()
                if (r5 == 0) goto L8f
            L8e:
                return
            L8f:
                r4.c()
                return
            L93:
                r6 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe.FlatMapMaybeSubscriber.i(io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe$FlatMapMaybeSubscriber$InnerObserver, java.lang.Object):void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135707g.decrementAndGet();
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135707g.decrementAndGet();
            if (!this.f135708h.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f135703b) {
                this.f135706f.dispose();
            }
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135705d, j3);
                b();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new FlatMapMaybeSubscriber(subscriber, this.f135699c, this.f135700d, this.f135701f));
    }
}
