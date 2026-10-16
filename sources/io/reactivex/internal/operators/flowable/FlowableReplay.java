package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import com.google.android.gms.common.api.Api;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableReplay<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T>, ResettableConnectable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Callable f136168g = new DefaultUnboundedFactory();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Flowable f136169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f136170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f136171d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Publisher f136172f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConnectableFlowableReplay<T> extends ConnectableFlowable<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConnectableFlowable f136176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Flowable f136177c;

        @Override // io.reactivex.flowables.ConnectableFlowable
        public void A(Consumer consumer) {
            this.f136176b.A(consumer);
        }

        @Override // io.reactivex.Flowable
        protected void x(Subscriber subscriber) {
            this.f136177c.i(subscriber);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DefaultUnboundedFactory implements Callable<Object> {
        DefaultUnboundedFactory() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerSubscription<T> extends AtomicLong implements Subscription, Disposable {
        private static final long serialVersionUID = -4453897557930727610L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReplaySubscriber f136178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Subscriber f136179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f136180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f136181d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f136182f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f136183g;

        InnerSubscription(ReplaySubscriber replaySubscriber, Subscriber subscriber) {
            this.f136178a = replaySubscriber;
            this.f136179b = subscriber;
        }

        Object a() {
            return this.f136180c;
        }

        public long b(long j3) {
            return BackpressureHelper.f(this, j3);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f136178a.c(this);
                this.f136178a.b();
                this.f136180c = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (!SubscriptionHelper.h(j3) || BackpressureHelper.b(this, j3) == Long.MIN_VALUE) {
                return;
            }
            BackpressureHelper.a(this.f136181d, j3);
            this.f136178a.b();
            this.f136178a.f136195a.g(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MulticastFlowable<R, U> extends Flowable<R> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callable f136184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function f136185c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class DisposableConsumer implements Consumer<Disposable> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final SubscriberResourceWrapper f136186a;

            DisposableConsumer(SubscriberResourceWrapper subscriberResourceWrapper) {
                this.f136186a = subscriberResourceWrapper;
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Disposable disposable) {
                this.f136186a.a(disposable);
            }
        }

        @Override // io.reactivex.Flowable
        protected void x(Subscriber subscriber) {
            try {
                ConnectableFlowable connectableFlowable = (ConnectableFlowable) ObjectHelper.d(this.f136184b.call(), "The connectableFactory returned null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.d(this.f136185c.apply(connectableFlowable), "The selector returned a null Publisher");
                    SubscriberResourceWrapper subscriberResourceWrapper = new SubscriberResourceWrapper(subscriber);
                    publisher.i(subscriberResourceWrapper);
                    connectableFlowable.A(new DisposableConsumer(subscriberResourceWrapper));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    EmptySubscription.b(th, subscriber);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                EmptySubscription.b(th2, subscriber);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f136188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136189b;

        Node(Object obj, long j3) {
            this.f136188a = obj;
            this.f136189b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ReplayBuffer<T> {
        void a(Throwable th);

        void b();

        void e(Object obj);

        void g(InnerSubscription innerSubscription);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f136190a;

        ReplayBufferTask(int i3) {
            this.f136190a = i3;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReplayBuffer call() {
            return new SizeBoundReplayBuffer(this.f136190a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplayPublisher<T> implements Publisher<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference f136191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Callable f136192b;

        ReplayPublisher(AtomicReference atomicReference, Callable callable) {
            this.f136191a = atomicReference;
            this.f136192b = callable;
        }

        @Override // org.reactivestreams.Publisher
        public void i(Subscriber subscriber) {
            ReplaySubscriber replaySubscriber;
            while (true) {
                replaySubscriber = (ReplaySubscriber) this.f136191a.get();
                if (replaySubscriber != null) {
                    break;
                }
                try {
                    ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) this.f136192b.call());
                    if (h.a(this.f136191a, null, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    EmptySubscription.b(th, subscriber);
                    return;
                }
            }
            InnerSubscription innerSubscription = new InnerSubscription(replaySubscriber, subscriber);
            subscriber.g(innerSubscription);
            replaySubscriber.a(innerSubscription);
            if (innerSubscription.e()) {
                replaySubscriber.c(innerSubscription);
            } else {
                replaySubscriber.b();
                replaySubscriber.f136195a.g(innerSubscription);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplaySubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final InnerSubscription[] f136193i = new InnerSubscription[0];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final InnerSubscription[] f136194j = new InnerSubscription[0];
        private static final long serialVersionUID = 7224554242710036740L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReplayBuffer f136195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f136196b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f136200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f136201h;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicInteger f136199f = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136197c = new AtomicReference(f136193i);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f136198d = new AtomicBoolean();

        ReplaySubscriber(ReplayBuffer replayBuffer) {
            this.f136195a = replayBuffer;
        }

        boolean a(InnerSubscription innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            innerSubscription.getClass();
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f136197c.get();
                if (innerSubscriptionArr == f136194j) {
                    return false;
                }
                int length = innerSubscriptionArr.length;
                innerSubscriptionArr2 = new InnerSubscription[length + 1];
                System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr2, 0, length);
                innerSubscriptionArr2[length] = innerSubscription;
            } while (!h.a(this.f136197c, innerSubscriptionArr, innerSubscriptionArr2));
            return true;
        }

        void b() {
            if (this.f136199f.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            while (!e()) {
                InnerSubscription[] innerSubscriptionArr = (InnerSubscription[]) this.f136197c.get();
                long j3 = this.f136200g;
                long jMax = j3;
                for (InnerSubscription innerSubscription : innerSubscriptionArr) {
                    jMax = Math.max(jMax, innerSubscription.f136181d.get());
                }
                long j4 = this.f136201h;
                Subscription subscription = get();
                long j5 = jMax - j3;
                if (j5 != 0) {
                    this.f136200g = jMax;
                    if (subscription == null) {
                        long j6 = j4 + j5;
                        if (j6 < 0) {
                            j6 = Long.MAX_VALUE;
                        }
                        this.f136201h = j6;
                    } else if (j4 != 0) {
                        this.f136201h = 0L;
                        subscription.y(j4 + j5);
                    } else {
                        subscription.y(j5);
                    }
                } else if (j4 != 0 && subscription != null) {
                    this.f136201h = 0L;
                    subscription.y(j4);
                }
                iAddAndGet = this.f136199f.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void c(InnerSubscription innerSubscription) {
            InnerSubscription[] innerSubscriptionArr;
            InnerSubscription[] innerSubscriptionArr2;
            do {
                innerSubscriptionArr = (InnerSubscription[]) this.f136197c.get();
                int length = innerSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (innerSubscriptionArr[i3].equals(innerSubscription)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriptionArr2 = f136193i;
                } else {
                    InnerSubscription[] innerSubscriptionArr3 = new InnerSubscription[length - 1];
                    System.arraycopy(innerSubscriptionArr, 0, innerSubscriptionArr3, 0, i3);
                    System.arraycopy(innerSubscriptionArr, i3 + 1, innerSubscriptionArr3, i3, (length - i3) - 1);
                    innerSubscriptionArr2 = innerSubscriptionArr3;
                }
            } while (!h.a(this.f136197c, innerSubscriptionArr, innerSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136197c.set(f136194j);
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136197c.get() == f136194j;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this, subscription)) {
                b();
                for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f136197c.get()) {
                    this.f136195a.g(innerSubscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136196b) {
                return;
            }
            this.f136195a.e(obj);
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f136197c.get()) {
                this.f136195a.g(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136196b) {
                return;
            }
            this.f136196b = true;
            this.f136195a.b();
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f136197c.getAndSet(f136194j)) {
                this.f136195a.g(innerSubscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136196b) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136196b = true;
            this.f136195a.a(th);
            for (InnerSubscription innerSubscription : (InnerSubscription[]) this.f136197c.getAndSet(f136194j)) {
                this.f136195a.g(innerSubscription);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScheduledReplayBufferTask<T> implements Callable<ReplayBuffer<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f136202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f136203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f136204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Scheduler f136205d;

        ScheduledReplayBufferTask(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f136202a = i3;
            this.f136203b = j3;
            this.f136204c = timeUnit;
            this.f136205d = scheduler;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReplayBuffer call() {
            return new SizeAndTimeBoundReplayBuffer(this.f136202a, this.f136203b, this.f136204c, this.f136205d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f136206d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f136207f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final TimeUnit f136208g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f136209h;

        SizeAndTimeBoundReplayBuffer(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f136206d = scheduler;
            this.f136209h = i3;
            this.f136207f = j3;
            this.f136208g = timeUnit;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object d(Object obj) {
            return new Timed(obj, this.f136206d.c(this.f136208g), this.f136208g);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Node f() {
            Node node;
            long jC = this.f136206d.c(this.f136208g) - this.f136207f;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null) {
                    break;
                }
                Timed timed = (Timed) node2.f136188a;
                if (NotificationLite.j(timed.b()) || NotificationLite.k(timed.b()) || timed.a() > jC) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        Object h(Object obj) {
            return ((Timed) obj).b();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void l() {
            Node node;
            long jC = this.f136206d.c(this.f136208g) - this.f136207f;
            Node node2 = get();
            Node node3 = node2.get();
            int i3 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i4 = this.f136174b;
                    if (i4 <= this.f136209h) {
                        if (((Timed) node2.f136188a).a() > jC) {
                            break;
                        }
                        i3++;
                        this.f136174b--;
                        node3 = node2.get();
                    } else {
                        i3++;
                        this.f136174b = i4 - 1;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i3 != 0) {
                j(node);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void m() {
            Node node;
            long jC = this.f136206d.c(this.f136208g) - this.f136207f;
            Node node2 = get();
            Node node3 = node2.get();
            int i3 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || this.f136174b <= 1 || ((Timed) node2.f136188a).a() > jC) {
                    break;
                }
                i3++;
                this.f136174b--;
                node3 = node2.get();
            }
            if (i3 != 0) {
                j(node);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f136210d;

        SizeBoundReplayBuffer(int i3) {
            this.f136210d = i3;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.BoundedReplayBuffer
        void l() {
            if (this.f136174b > this.f136210d) {
                i();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile int f136211a;

        UnboundedReplayBuffer(int i3) {
            super(i3);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void a(Throwable th) {
            add(NotificationLite.g(th));
            this.f136211a++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void b() {
            add(NotificationLite.e());
            this.f136211a++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void e(Object obj) {
            add(NotificationLite.l(obj));
            this.f136211a++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public void g(InnerSubscription innerSubscription) {
            synchronized (innerSubscription) {
                try {
                    if (innerSubscription.f136182f) {
                        innerSubscription.f136183g = true;
                        return;
                    }
                    innerSubscription.f136182f = true;
                    Subscriber subscriber = innerSubscription.f136179b;
                    while (!innerSubscription.e()) {
                        int i3 = this.f136211a;
                        Integer num = (Integer) innerSubscription.a();
                        int iIntValue = num != null ? num.intValue() : 0;
                        long j3 = innerSubscription.get();
                        long j4 = j3;
                        long j5 = 0;
                        while (j4 != 0 && iIntValue < i3) {
                            Object obj = get(iIntValue);
                            try {
                                if (NotificationLite.b(obj, subscriber) || innerSubscription.e()) {
                                    return;
                                }
                                iIntValue++;
                                j4--;
                                j5++;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                innerSubscription.dispose();
                                if (NotificationLite.k(obj) || NotificationLite.j(obj)) {
                                    return;
                                }
                                subscriber.onError(th);
                                return;
                            }
                        }
                        if (j5 != 0) {
                            innerSubscription.f136180c = Integer.valueOf(iIntValue);
                            if (j3 != Long.MAX_VALUE) {
                                innerSubscription.b(j5);
                            }
                        }
                        synchronized (innerSubscription) {
                            try {
                                if (!innerSubscription.f136183g) {
                                    innerSubscription.f136182f = false;
                                    return;
                                }
                                innerSubscription.f136183g = false;
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    private FlowableReplay(Publisher publisher, Flowable flowable, AtomicReference atomicReference, Callable callable) {
        this.f136172f = publisher;
        this.f136169b = flowable;
        this.f136170c = atomicReference;
        this.f136171d = callable;
    }

    public static ConnectableFlowable B(Flowable flowable, int i3) {
        return i3 == Integer.MAX_VALUE ? F(flowable) : E(flowable, new ReplayBufferTask(i3));
    }

    public static ConnectableFlowable C(Flowable flowable, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return D(flowable, j3, timeUnit, scheduler, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static ConnectableFlowable D(Flowable flowable, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3) {
        return E(flowable, new ScheduledReplayBufferTask(i3, j3, timeUnit, scheduler));
    }

    static ConnectableFlowable E(Flowable flowable, Callable callable) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.p(new FlowableReplay(new ReplayPublisher(atomicReference, callable), flowable, atomicReference, callable));
    }

    public static ConnectableFlowable F(Flowable flowable) {
        return E(flowable, f136168g);
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void A(Consumer consumer) {
        ReplaySubscriber replaySubscriber;
        while (true) {
            replaySubscriber = (ReplaySubscriber) this.f136170c.get();
            if (replaySubscriber != null && !replaySubscriber.e()) {
                break;
            }
            try {
                ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) this.f136171d.call());
                if (h.a(this.f136170c, replaySubscriber, replaySubscriber2)) {
                    replaySubscriber = replaySubscriber2;
                    break;
                }
            } finally {
                Exceptions.b(th);
                RuntimeException runtimeExceptionE = ExceptionHelper.e(th);
            }
        }
        boolean z2 = !replaySubscriber.f136198d.get() && replaySubscriber.f136198d.compareAndSet(false, true);
        try {
            consumer.accept(replaySubscriber);
            if (z2) {
                this.f136169b.w(replaySubscriber);
            }
        } catch (Throwable th) {
            if (z2) {
                replaySubscriber.f136198d.compareAndSet(true, false);
            }
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void c(Disposable disposable) {
        h.a(this.f136170c, (ReplaySubscriber) disposable, null);
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f136172f.i(subscriber);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Node f136173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f136174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f136175c;

        BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.f136173a = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void a(Throwable th) {
            Object objD = d(NotificationLite.g(th));
            long j3 = this.f136175c + 1;
            this.f136175c = j3;
            c(new Node(objD, j3));
            m();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void b() {
            Object objD = d(NotificationLite.e());
            long j3 = this.f136175c + 1;
            this.f136175c = j3;
            c(new Node(objD, j3));
            m();
        }

        final void c(Node node) {
            this.f136173a.set(node);
            this.f136173a = node;
            this.f136174b++;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void e(Object obj) {
            Object objD = d(NotificationLite.l(obj));
            long j3 = this.f136175c + 1;
            this.f136175c = j3;
            c(new Node(objD, j3));
            l();
        }

        Node f() {
            return get();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableReplay.ReplayBuffer
        public final void g(InnerSubscription innerSubscription) {
            Node node;
            synchronized (innerSubscription) {
                try {
                    if (innerSubscription.f136182f) {
                        innerSubscription.f136183g = true;
                        return;
                    }
                    innerSubscription.f136182f = true;
                    while (!innerSubscription.e()) {
                        long j3 = innerSubscription.get();
                        boolean z2 = j3 == Long.MAX_VALUE;
                        Node nodeF = (Node) innerSubscription.a();
                        if (nodeF == null) {
                            nodeF = f();
                            innerSubscription.f136180c = nodeF;
                            BackpressureHelper.a(innerSubscription.f136181d, nodeF.f136189b);
                        }
                        long j4 = 0;
                        while (j3 != 0 && (node = nodeF.get()) != null) {
                            Object objH = h(node.f136188a);
                            try {
                                if (NotificationLite.b(objH, innerSubscription.f136179b)) {
                                    innerSubscription.f136180c = null;
                                    return;
                                }
                                j4++;
                                j3--;
                                if (innerSubscription.e()) {
                                    innerSubscription.f136180c = null;
                                    return;
                                }
                                nodeF = node;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                innerSubscription.f136180c = null;
                                innerSubscription.dispose();
                                if (NotificationLite.k(objH) || NotificationLite.j(objH)) {
                                    return;
                                }
                                innerSubscription.f136179b.onError(th);
                                return;
                            }
                        }
                        if (j4 != 0) {
                            innerSubscription.f136180c = nodeF;
                            if (!z2) {
                                innerSubscription.b(j4);
                            }
                        }
                        synchronized (innerSubscription) {
                            try {
                                if (!innerSubscription.f136183g) {
                                    innerSubscription.f136182f = false;
                                    return;
                                }
                                innerSubscription.f136183g = false;
                            } finally {
                            }
                        }
                    }
                    innerSubscription.f136180c = null;
                } finally {
                }
            }
        }

        final void i() {
            Node node = get().get();
            if (node == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.f136174b--;
            j(node);
        }

        final void j(Node node) {
            set(node);
        }

        final void k() {
            Node node = get();
            if (node.f136188a != null) {
                Node node2 = new Node(null, 0L);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        void m() {
            k();
        }

        void l() {
        }

        Object d(Object obj) {
            return obj;
        }

        Object h(Object obj) {
            return obj;
        }
    }
}
