package io.reactivex.internal.operators.parallel;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelSortedJoin<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ParallelFlowable f138713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Comparator f138714c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SortedJoinSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3481980673745556697L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SortedJoinInnerSubscriber[] f138718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final List[] f138719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int[] f138720d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Comparator f138721f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138723h;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f138722g = new AtomicLong();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicInteger f138724i = new AtomicInteger();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference f138725j = new AtomicReference();

        SortedJoinSubscription(Subscriber subscriber, int i3, Comparator comparator) {
            this.f138717a = subscriber;
            this.f138721f = comparator;
            SortedJoinInnerSubscriber[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                sortedJoinInnerSubscriberArr[i4] = new SortedJoinInnerSubscriber(this, i4);
            }
            this.f138718b = sortedJoinInnerSubscriberArr;
            this.f138719c = new List[i3];
            this.f138720d = new int[i3];
            this.f138724i.lazySet(i3);
        }

        void a() {
            for (SortedJoinInnerSubscriber sortedJoinInnerSubscriber : this.f138718b) {
                sortedJoinInnerSubscriber.a();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x00a8, code lost:
        
            if (r11 != r7) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ac, code lost:
        
            if (r19.f138723h == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00ae, code lost:
        
            java.util.Arrays.fill(r3, (java.lang.Object) null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00b3, code lost:
        
            r5 = (java.lang.Throwable) r19.f138725j.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00bc, code lost:
        
            if (r5 == null) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00be, code lost:
        
            a();
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onError(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00c8, code lost:
        
            if (r14 >= r4) goto L76;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
        
            if (r0[r14] == r3[r14].size()) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00d5, code lost:
        
            r14 = r14 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00d8, code lost:
        
            java.util.Arrays.fill(r3, (java.lang.Object) null);
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00df, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00e2, code lost:
        
            if (r11 == 0) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00eb, code lost:
        
            if (r7 == Long.MAX_VALUE) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00ed, code lost:
        
            r19.f138722g.addAndGet(-r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f3, code lost:
        
            r5 = get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00f7, code lost:
        
            if (r5 != r6) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f9, code lost:
        
            r5 = addAndGet(-r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00fe, code lost:
        
            if (r5 != 0) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
        
            return;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                Method dump skipped, instruction units count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelSortedJoin.SortedJoinSubscription.b():void");
        }

        void c(Throwable th) {
            if (h.a(this.f138725j, null, th)) {
                b();
            } else if (th != this.f138725j.get()) {
                RxJavaPlugins.s(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f138723h) {
                return;
            }
            this.f138723h = true;
            a();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.f138719c, (Object) null);
            }
        }

        void d(List list, int i3) {
            this.f138719c[i3] = list;
            if (this.f138724i.decrementAndGet() == 0) {
                b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f138722g, j3);
                if (this.f138724i.get() == 0) {
                    b();
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(subscriber, this.f138713b.a(), this.f138714c);
        subscriber.g(sortedJoinSubscription);
        this.f138713b.b(sortedJoinSubscription.f138718b);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SortedJoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SortedJoinSubscription f138715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138716b;

        SortedJoinInnerSubscriber(SortedJoinSubscription sortedJoinSubscription, int i3) {
            this.f138715a = sortedJoinSubscription;
            this.f138716b = i3;
        }

        void a() {
            SubscriptionHelper.a(this);
        }

        @Override // org.reactivestreams.Subscriber
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void h(List list) {
            this.f138715a.d(list, this.f138716b);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f138715a.c(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }
    }
}
