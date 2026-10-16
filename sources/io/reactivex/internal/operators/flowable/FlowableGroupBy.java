package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f135780d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f135782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Function f135783h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue f135784a;

        EvictionAction(Queue queue) {
            this.f135784a = queue;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(GroupedUnicast groupedUnicast) {
            this.f135784a.offer(groupedUnicast);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final Object f135785r = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f135788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135789d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f135790f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Map f135791g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final SpscLinkedArrayQueue f135792h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Queue f135793i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Subscription f135794j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicBoolean f135795k = new AtomicBoolean();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicLong f135796l = new AtomicLong();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final AtomicInteger f135797m = new AtomicInteger(1);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Throwable f135798n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile boolean f135799o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f135800p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f135801q;

        public GroupBySubscriber(Subscriber subscriber, Function function, Function function2, int i3, boolean z2, Map map, Queue queue) {
            this.f135786a = subscriber;
            this.f135787b = function;
            this.f135788c = function2;
            this.f135789d = i3;
            this.f135790f = z2;
            this.f135791g = map;
            this.f135793i = queue;
            this.f135792h = new SpscLinkedArrayQueue(i3);
        }

        private void k() {
            if (this.f135793i != null) {
                int i3 = 0;
                while (true) {
                    GroupedUnicast groupedUnicast = (GroupedUnicast) this.f135793i.poll();
                    if (groupedUnicast == null) {
                        break;
                    }
                    groupedUnicast.onComplete();
                    i3++;
                }
                if (i3 != 0) {
                    this.f135797m.addAndGet(-i3);
                }
            }
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f135801q) {
                m();
            } else {
                p();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135795k.compareAndSet(false, true)) {
                k();
                if (this.f135797m.decrementAndGet() == 0) {
                    this.f135794j.cancel();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135792h.clear();
        }

        public void e(Object obj) {
            if (obj == null) {
                obj = f135785r;
            }
            this.f135791g.remove(obj);
            if (this.f135797m.decrementAndGet() == 0) {
                this.f135794j.cancel();
                if (getAndIncrement() == 0) {
                    this.f135792h.clear();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135794j, subscription)) {
                this.f135794j = subscription;
                this.f135786a.g(this);
                subscription.y(this.f135789d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            boolean z2;
            if (this.f135800p) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135792h;
            try {
                Object objApply = this.f135787b.apply(obj);
                Object obj2 = objApply != null ? objApply : f135785r;
                GroupedUnicast groupedUnicastA = (GroupedUnicast) this.f135791g.get(obj2);
                if (groupedUnicastA != null) {
                    z2 = false;
                } else {
                    if (this.f135795k.get()) {
                        return;
                    }
                    groupedUnicastA = GroupedUnicast.A(objApply, this.f135789d, this, this.f135790f);
                    this.f135791g.put(obj2, groupedUnicastA);
                    this.f135797m.getAndIncrement();
                    z2 = true;
                }
                try {
                    groupedUnicastA.h(ObjectHelper.d(this.f135788c.apply(obj), "The valueSelector returned null"));
                    k();
                    if (z2) {
                        spscLinkedArrayQueue.offer(groupedUnicastA);
                        c();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f135794j.cancel();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f135794j.cancel();
                onError(th2);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f135792h.isEmpty();
        }

        boolean j(boolean z2, boolean z3, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            if (this.f135795k.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (this.f135790f) {
                if (!z2 || !z3) {
                    return false;
                }
                Throwable th = this.f135798n;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            if (!z2) {
                return false;
            }
            Throwable th2 = this.f135798n;
            if (th2 != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f135801q = true;
            return 2;
        }

        void m() {
            Throwable th;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135792h;
            Subscriber subscriber = this.f135786a;
            int iAddAndGet = 1;
            while (!this.f135795k.get()) {
                boolean z2 = this.f135799o;
                if (z2 && !this.f135790f && (th = this.f135798n) != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                subscriber.h(null);
                if (z2) {
                    Throwable th2 = this.f135798n;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135800p) {
                return;
            }
            Iterator<V> it = this.f135791g.values().iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onComplete();
            }
            this.f135791g.clear();
            Queue queue = this.f135793i;
            if (queue != null) {
                queue.clear();
            }
            this.f135800p = true;
            this.f135799o = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135800p) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135800p = true;
            Iterator<V> it = this.f135791g.values().iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onError(th);
            }
            this.f135791g.clear();
            Queue queue = this.f135793i;
            if (queue != null) {
                queue.clear();
            }
            this.f135798n = th;
            this.f135799o = true;
            c();
        }

        void p() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135792h;
            Subscriber subscriber = this.f135786a;
            int iAddAndGet = 1;
            do {
                long j3 = this.f135796l.get();
                long j4 = 0;
                while (j4 != j3) {
                    boolean z2 = this.f135799o;
                    GroupedFlowable groupedFlowable = (GroupedFlowable) spscLinkedArrayQueue.poll();
                    boolean z3 = groupedFlowable == null;
                    if (j(z2, z3, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(groupedFlowable);
                    j4++;
                }
                if (j4 == j3 && j(this.f135799o, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j4 != 0) {
                    if (j3 != Long.MAX_VALUE) {
                        this.f135796l.addAndGet(-j4);
                    }
                    this.f135794j.y(j4);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public GroupedFlowable poll() {
            return (GroupedFlowable) this.f135792h.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135796l, j3);
                c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final State f135802c;

        protected GroupedUnicast(Object obj, State state) {
            super(obj);
            this.f135802c = state;
        }

        public static GroupedUnicast A(Object obj, int i3, GroupBySubscriber groupBySubscriber, boolean z2) {
            return new GroupedUnicast(obj, new State(i3, groupBySubscriber, obj, z2));
        }

        public void h(Object obj) {
            this.f135802c.h(obj);
        }

        public void onComplete() {
            this.f135802c.onComplete();
        }

        public void onError(Throwable th) {
            this.f135802c.onError(th);
        }

        @Override // io.reactivex.Flowable
        protected void x(Subscriber subscriber) {
            this.f135802c.i(subscriber);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f135803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f135804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final GroupBySubscriber f135805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f135806d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f135808g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Throwable f135809h;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f135813l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f135814m;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135807f = new AtomicLong();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f135810i = new AtomicBoolean();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference f135811j = new AtomicReference();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicBoolean f135812k = new AtomicBoolean();

        State(int i3, GroupBySubscriber groupBySubscriber, Object obj, boolean z2) {
            this.f135804b = new SpscLinkedArrayQueue(i3);
            this.f135805c = groupBySubscriber;
            this.f135803a = obj;
            this.f135806d = z2;
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f135813l) {
                j();
            } else {
                k();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135810i.compareAndSet(false, true)) {
                this.f135805c.e(this.f135803a);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135804b.clear();
        }

        boolean e(boolean z2, boolean z3, Subscriber subscriber, boolean z4) {
            if (this.f135810i.get()) {
                this.f135804b.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (z4) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.f135809h;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f135809h;
            if (th2 != null) {
                this.f135804b.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        public void h(Object obj) {
            this.f135804b.offer(obj);
            c();
        }

        @Override // org.reactivestreams.Publisher
        public void i(Subscriber subscriber) {
            if (!this.f135812k.compareAndSet(false, true)) {
                EmptySubscription.b(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
                return;
            }
            subscriber.g(this);
            this.f135811j.lazySet(subscriber);
            c();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f135804b.isEmpty();
        }

        void j() {
            Throwable th;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135804b;
            Subscriber subscriber = (Subscriber) this.f135811j.get();
            int iAddAndGet = 1;
            while (true) {
                if (subscriber != null) {
                    if (this.f135810i.get()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z2 = this.f135808g;
                    if (z2 && !this.f135806d && (th = this.f135809h) != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    subscriber.h(null);
                    if (z2) {
                        Throwable th2 = this.f135809h;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = (Subscriber) this.f135811j.get();
                }
            }
        }

        void k() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135804b;
            boolean z2 = this.f135806d;
            Subscriber subscriber = (Subscriber) this.f135811j.get();
            int iAddAndGet = 1;
            while (true) {
                if (subscriber != null) {
                    long j3 = this.f135807f.get();
                    long j4 = 0;
                    while (j4 != j3) {
                        boolean z3 = this.f135808g;
                        Object objPoll = spscLinkedArrayQueue.poll();
                        boolean z4 = objPoll == null;
                        if (e(z3, z4, subscriber, z2)) {
                            return;
                        }
                        if (z4) {
                            break;
                        }
                        subscriber.h(objPoll);
                        j4++;
                    }
                    if (j4 == j3 && e(this.f135808g, spscLinkedArrayQueue.isEmpty(), subscriber, z2)) {
                        return;
                    }
                    if (j4 != 0) {
                        if (j3 != Long.MAX_VALUE) {
                            this.f135807f.addAndGet(-j4);
                        }
                        this.f135805c.f135794j.y(j4);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = (Subscriber) this.f135811j.get();
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f135813l = true;
            return 2;
        }

        public void onComplete() {
            this.f135808g = true;
            c();
        }

        public void onError(Throwable th) {
            this.f135809h = th;
            this.f135808g = true;
            c();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f135804b.poll();
            if (objPoll != null) {
                this.f135814m++;
                return objPoll;
            }
            int i3 = this.f135814m;
            if (i3 == 0) {
                return null;
            }
            this.f135814m = 0;
            this.f135805c.f135794j.y(i3);
            return null;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135807f, j3);
                c();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map concurrentHashMap;
        try {
            if (this.f135783h == null) {
                concurrentHashMap = new ConcurrentHashMap();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                concurrentHashMap = (Map) this.f135783h.apply(new EvictionAction(concurrentLinkedQueue));
            }
            this.f135196b.w(new GroupBySubscriber(subscriber, this.f135779c, this.f135780d, this.f135781f, this.f135782g, concurrentHashMap, concurrentLinkedQueue));
        } catch (Exception e3) {
            Exceptions.b(e3);
            subscriber.g(EmptyComponent.INSTANCE);
            subscriber.onError(e3);
        }
    }
}
