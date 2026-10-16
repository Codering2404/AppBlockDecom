package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeMergeArray<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource[] f136929b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -4025173261791142821L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f136930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicInteger f136931b = new AtomicInteger();

        ClqSimpleQueue() {
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void d() {
            poll();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int f() {
            return this.f136930a;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int n() {
            return this.f136931b.get();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            this.f136931b.getAndIncrement();
            return super.offer(obj);
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = super.poll();
            if (objPoll != null) {
                this.f136930a++;
            }
            return objPoll;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -660395290758764731L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136932a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SimpleQueueWithConsumerIndex f136935d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f136937g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136938h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f136939i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f136940j;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompositeDisposable f136933b = new CompositeDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicLong f136934c = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f136936f = new AtomicThrowable();

        MergeMaybeObserver(Subscriber subscriber, int i3, SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex) {
            this.f136932a = subscriber;
            this.f136937g = i3;
            this.f136935d = simpleQueueWithConsumerIndex;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            this.f136933b.b(disposable);
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f136939i) {
                e();
            } else {
                j();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136938h) {
                return;
            }
            this.f136938h = true;
            this.f136933b.dispose();
            if (getAndIncrement() == 0) {
                this.f136935d.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f136935d.clear();
        }

        void e() {
            Subscriber subscriber = this.f136932a;
            SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex = this.f136935d;
            int iAddAndGet = 1;
            while (!this.f136938h) {
                Throwable th = this.f136936f.get();
                if (th != null) {
                    simpleQueueWithConsumerIndex.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z2 = simpleQueueWithConsumerIndex.n() == this.f136937g;
                if (!simpleQueueWithConsumerIndex.isEmpty()) {
                    subscriber.h(null);
                }
                if (z2) {
                    subscriber.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            simpleQueueWithConsumerIndex.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f136935d.isEmpty();
        }

        void j() {
            Subscriber subscriber = this.f136932a;
            SimpleQueueWithConsumerIndex simpleQueueWithConsumerIndex = this.f136935d;
            long j3 = this.f136940j;
            int iAddAndGet = 1;
            do {
                long j4 = this.f136934c.get();
                while (j3 != j4) {
                    if (this.f136938h) {
                        simpleQueueWithConsumerIndex.clear();
                        return;
                    }
                    if (this.f136936f.get() != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(this.f136936f.b());
                        return;
                    } else {
                        if (simpleQueueWithConsumerIndex.f() == this.f136937g) {
                            subscriber.onComplete();
                            return;
                        }
                        Object objPoll = simpleQueueWithConsumerIndex.poll();
                        if (objPoll == null) {
                            break;
                        } else if (objPoll != NotificationLite.COMPLETE) {
                            subscriber.h(objPoll);
                            j3++;
                        }
                    }
                }
                if (j3 == j4) {
                    if (this.f136936f.get() != null) {
                        simpleQueueWithConsumerIndex.clear();
                        subscriber.onError(this.f136936f.b());
                        return;
                    } else {
                        while (simpleQueueWithConsumerIndex.peek() == NotificationLite.COMPLETE) {
                            simpleQueueWithConsumerIndex.d();
                        }
                        if (simpleQueueWithConsumerIndex.f() == this.f136937g) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f136940j = j3;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        boolean k() {
            return this.f136938h;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f136939i = true;
            return 2;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136935d.offer(NotificationLite.COMPLETE);
            c();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (!this.f136936f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136933b.dispose();
            this.f136935d.offer(NotificationLite.COMPLETE);
            c();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136935d.offer(obj);
            c();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll;
            do {
                objPoll = this.f136935d.poll();
            } while (objPoll == NotificationLite.COMPLETE);
            return objPoll;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136934c, j3);
                c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements SimpleQueueWithConsumerIndex<T> {
        private static final long serialVersionUID = -7969063454040569579L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicInteger f136941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f136942b;

        MpscFillOnceSimpleQueue(int i3) {
            super(i3);
            this.f136941a = new AtomicInteger();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public void d() {
            int i3 = this.f136942b;
            lazySet(i3, null);
            this.f136942b = i3 + 1;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int f() {
            return this.f136942b;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f136942b == n();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public int n() {
            return this.f136941a.get();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            ObjectHelper.d(obj, "value is null");
            int andIncrement = this.f136941a.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, obj);
            return true;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex
        public Object peek() {
            int i3 = this.f136942b;
            if (i3 == length()) {
                return null;
            }
            return get(i3);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, java.util.Queue, io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            int i3 = this.f136942b;
            if (i3 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.f136941a;
            do {
                T t2 = get(i3);
                if (t2 != null) {
                    this.f136942b = i3 + 1;
                    lazySet(i3, null);
                    return t2;
                }
            } while (atomicInteger.get() != i3);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface SimpleQueueWithConsumerIndex<T> extends SimpleQueue<T> {
        void d();

        int f();

        int n();

        Object peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.SimpleQueueWithConsumerIndex, io.reactivex.internal.fuseable.SimpleQueue
        Object poll();
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        MaybeSource[] maybeSourceArr = this.f136929b;
        int length = maybeSourceArr.length;
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(subscriber, length, length <= Flowable.a() ? new MpscFillOnceSimpleQueue(length) : new ClqSimpleQueue());
        subscriber.g(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.f136936f;
        for (MaybeSource maybeSource : maybeSourceArr) {
            if (mergeMaybeObserver.k() || atomicThrowable.get() != null) {
                return;
            }
            maybeSource.b(mergeMaybeObserver);
        }
    }
}
