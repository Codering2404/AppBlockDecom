package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableCreate<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final FlowableOnSubscribe f135494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BackpressureStrategy f135495c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f135496a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f135496a = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f135496a[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f135496a[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f135496a[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SpscLinkedArrayQueue f135499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f135500d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f135501f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f135502g;

        BufferAsyncEmitter(Subscriber subscriber, int i3) {
            super(subscriber);
            this.f135499c = new SpscLinkedArrayQueue(i3);
            this.f135502g = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void e() {
            h();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void f() {
            if (this.f135502g.getAndIncrement() == 0) {
                this.f135499c.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean g(Throwable th) {
            if (this.f135501f || c()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f135500d = th;
            this.f135501f = true;
            h();
            return true;
        }

        void h() {
            if (this.f135502g.getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f135497a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135499c;
            int iAddAndGet = 1;
            do {
                long j3 = get();
                long j4 = 0;
                while (j4 != j3) {
                    if (c()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z2 = this.f135501f;
                    Object objPoll = spscLinkedArrayQueue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable th = this.f135500d;
                        if (th != null) {
                            b(th);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(objPoll);
                    j4++;
                }
                if (j4 == j3) {
                    if (c()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z4 = this.f135501f;
                    boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                    if (z4 && zIsEmpty) {
                        Throwable th2 = this.f135500d;
                        if (th2 != null) {
                            b(th2);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                }
                if (j4 != 0) {
                    BackpressureHelper.e(this, j4);
                }
                iAddAndGet = this.f135502g.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(Subscriber subscriber) {
            super(subscriber);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber subscriber) {
            super(subscriber);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f135503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f135504d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f135505f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f135506g;

        LatestAsyncEmitter(Subscriber subscriber) {
            super(subscriber);
            this.f135503c = new AtomicReference();
            this.f135506g = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void e() {
            h();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void f() {
            if (this.f135506g.getAndIncrement() == 0) {
                this.f135503c.lazySet(null);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public boolean g(Throwable th) {
            if (this.f135505f || c()) {
                return false;
            }
            if (th == null) {
                d(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f135504d = th;
            this.f135505f = true;
            h();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        
            if (r9 != r5) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        
            if (c() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
        
            r5 = r17.f135505f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (r2.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        
            if (r5 == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
        
            if (r12 == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0069, code lost:
        
            r1 = r17.f135504d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006b, code lost:
        
            if (r1 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
        
            b(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
        
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
        
            if (r9 == 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.e(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007c, code lost:
        
            r4 = r17.f135506g.addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void h() {
            /*
                r17 = this;
                r0 = r17
                java.util.concurrent.atomic.AtomicInteger r1 = r0.f135506g
                int r1 = r1.getAndIncrement()
                if (r1 == 0) goto Lc
                goto L85
            Lc:
                org.reactivestreams.Subscriber r1 = r0.f135497a
                java.util.concurrent.atomic.AtomicReference r2 = r0.f135503c
                r3 = 1
                r4 = r3
            L12:
                long r5 = r0.get()
                r7 = 0
                r9 = r7
            L19:
                int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                r12 = 0
                r13 = 0
                if (r11 == 0) goto L50
                boolean r14 = r0.c()
                if (r14 == 0) goto L29
                r2.lazySet(r13)
                return
            L29:
                boolean r14 = r0.f135505f
                java.lang.Object r15 = r2.getAndSet(r13)
                if (r15 != 0) goto L34
                r16 = r3
                goto L36
            L34:
                r16 = r12
            L36:
                if (r14 == 0) goto L46
                if (r16 == 0) goto L46
                java.lang.Throwable r1 = r0.f135504d
                if (r1 == 0) goto L42
                r0.b(r1)
                return
            L42:
                r0.a()
                return
            L46:
                if (r16 == 0) goto L49
                goto L50
            L49:
                r1.h(r15)
                r11 = 1
                long r9 = r9 + r11
                goto L19
            L50:
                if (r11 != 0) goto L75
                boolean r5 = r0.c()
                if (r5 == 0) goto L5c
                r2.lazySet(r13)
                return
            L5c:
                boolean r5 = r0.f135505f
                java.lang.Object r6 = r2.get()
                if (r6 != 0) goto L65
                r12 = r3
            L65:
                if (r5 == 0) goto L75
                if (r12 == 0) goto L75
                java.lang.Throwable r1 = r0.f135504d
                if (r1 == 0) goto L71
                r0.b(r1)
                return
            L71:
                r0.a()
                return
            L75:
                int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r5 == 0) goto L7c
                io.reactivex.internal.util.BackpressureHelper.e(r0, r9)
            L7c:
                java.util.concurrent.atomic.AtomicInteger r5 = r0.f135506g
                int r4 = -r4
                int r4 = r5.addAndGet(r4)
                if (r4 != 0) goto L12
            L85:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.h():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber subscriber) {
            super(subscriber);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(Subscriber subscriber) {
            super(subscriber);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseEmitter f135507a;

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.f135507a.toString();
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        int i3 = AnonymousClass1.f135496a[this.f135495c.ordinal()];
        BaseEmitter bufferAsyncEmitter = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? new BufferAsyncEmitter(subscriber, Flowable.a()) : new LatestAsyncEmitter(subscriber) : new DropAsyncEmitter(subscriber) : new ErrorAsyncEmitter(subscriber) : new MissingEmitter(subscriber);
        subscriber.g(bufferAsyncEmitter);
        try {
            this.f135494b.a(bufferAsyncEmitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            bufferAsyncEmitter.d(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f135498b = new SequentialDisposable();

        BaseEmitter(Subscriber subscriber) {
            this.f135497a = subscriber;
        }

        protected void a() {
            if (c()) {
                return;
            }
            try {
                this.f135497a.onComplete();
            } finally {
                this.f135498b.dispose();
            }
        }

        protected boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (c()) {
                return false;
            }
            try {
                this.f135497a.onError(th);
                this.f135498b.dispose();
                return true;
            } catch (Throwable th2) {
                this.f135498b.dispose();
                throw th2;
            }
        }

        public final boolean c() {
            return this.f135498b.e();
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f135498b.dispose();
            f();
        }

        public final void d(Throwable th) {
            if (g(th)) {
                return;
            }
            RxJavaPlugins.s(th);
        }

        public boolean g(Throwable th) {
            return b(th);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
                e();
            }
        }

        void e() {
        }

        void f() {
        }
    }
}
