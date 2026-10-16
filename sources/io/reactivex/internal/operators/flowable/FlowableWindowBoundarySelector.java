package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f136601d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f136602f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainSubscriber f136603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final UnicastProcessor f136604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136605d;

        OperatorWindowBoundaryCloseSubscriber(WindowBoundaryMainSubscriber windowBoundaryMainSubscriber, UnicastProcessor unicastProcessor) {
            this.f136603b = windowBoundaryMainSubscriber;
            this.f136604c = unicastProcessor;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            a();
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136605d) {
                return;
            }
            this.f136605d = true;
            this.f136603b.q(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136605d) {
                RxJavaPlugins.s(th);
            } else {
                this.f136605d = true;
                this.f136603b.s(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainSubscriber f136606b;

        OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber windowBoundaryMainSubscriber) {
            this.f136606b = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136606b.t(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136606b.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136606b.s(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Publisher f136607i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Function f136608j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f136609k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final CompositeDisposable f136610l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Subscription f136611m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final AtomicReference f136612n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final List f136613o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final AtomicLong f136614p;

        WindowBoundaryMainSubscriber(Subscriber subscriber, Publisher publisher, Function function, int i3) {
            super(subscriber, new MpscLinkedQueue());
            this.f136612n = new AtomicReference();
            AtomicLong atomicLong = new AtomicLong();
            this.f136614p = atomicLong;
            this.f136607i = publisher;
            this.f136608j = function;
            this.f136609k = i3;
            this.f136610l = new CompositeDisposable();
            this.f136613o = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f139155f = true;
        }

        void dispose() {
            this.f136610l.dispose();
            DisposableHelper.a(this.f136612n);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        public boolean f(Subscriber subscriber, Object obj) {
            return false;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136611m, subscription)) {
                this.f136611m = subscription;
                this.f139153c.g(this);
                if (this.f139155f) {
                    return;
                }
                OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                if (h.a(this.f136612n, null, operatorWindowBoundaryOpenSubscriber)) {
                    this.f136614p.getAndIncrement();
                    subscription.y(Long.MAX_VALUE);
                    this.f136607i.i(operatorWindowBoundaryOpenSubscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f139156g) {
                return;
            }
            if (k()) {
                Iterator it = this.f136613o.iterator();
                while (it.hasNext()) {
                    ((UnicastProcessor) it.next()).h(obj);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f139154d.offer(NotificationLite.l(obj));
                if (!j()) {
                    return;
                }
            }
            r();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f139156g) {
                return;
            }
            this.f139156g = true;
            if (j()) {
                r();
            }
            if (this.f136614p.decrementAndGet() == 0) {
                this.f136610l.dispose();
            }
            this.f139153c.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f139156g) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f139157h = th;
            this.f139156g = true;
            if (j()) {
                r();
            }
            if (this.f136614p.decrementAndGet() == 0) {
                this.f136610l.dispose();
            }
            this.f139153c.onError(th);
        }

        void q(OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber) {
            this.f136610l.c(operatorWindowBoundaryCloseSubscriber);
            this.f139154d.offer(new WindowOperation(operatorWindowBoundaryCloseSubscriber.f136604c, null));
            if (j()) {
                r();
            }
        }

        void r() {
            SimplePlainQueue simplePlainQueue = this.f139154d;
            Subscriber subscriber = this.f139153c;
            List list = this.f136613o;
            int iB = 1;
            while (true) {
                boolean z2 = this.f139156g;
                Object objPoll = simplePlainQueue.poll();
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    dispose();
                    Throwable th = this.f139157h;
                    if (th != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((UnicastProcessor) it.next()).onError(th);
                        }
                    } else {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            ((UnicastProcessor) it2.next()).onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z3) {
                    iB = b(-iB);
                    if (iB == 0) {
                        return;
                    }
                } else if (objPoll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) objPoll;
                    UnicastProcessor unicastProcessor = windowOperation.f136615a;
                    if (unicastProcessor != null) {
                        if (list.remove(unicastProcessor)) {
                            windowOperation.f136615a.onComplete();
                            if (this.f136614p.decrementAndGet() == 0) {
                                dispose();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f139155f) {
                        UnicastProcessor unicastProcessorD = UnicastProcessor.D(this.f136609k);
                        long jA = a();
                        if (jA != 0) {
                            list.add(unicastProcessorD);
                            subscriber.h(unicastProcessorD);
                            if (jA != Long.MAX_VALUE) {
                                i(1L);
                            }
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.d(this.f136608j.apply(windowOperation.f136616b), "The publisher supplied is null");
                                OperatorWindowBoundaryCloseSubscriber operatorWindowBoundaryCloseSubscriber = new OperatorWindowBoundaryCloseSubscriber(this, unicastProcessorD);
                                if (this.f136610l.b(operatorWindowBoundaryCloseSubscriber)) {
                                    this.f136614p.getAndIncrement();
                                    publisher.i(operatorWindowBoundaryCloseSubscriber);
                                }
                            } catch (Throwable th2) {
                                this.f139155f = true;
                                subscriber.onError(th2);
                            }
                        } else {
                            this.f139155f = true;
                            subscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((UnicastProcessor) it3.next()).h(NotificationLite.i(objPoll));
                    }
                }
            }
        }

        void s(Throwable th) {
            this.f136611m.cancel();
            this.f136610l.dispose();
            DisposableHelper.a(this.f136612n);
            this.f139153c.onError(th);
        }

        void t(Object obj) {
            this.f139154d.offer(new WindowOperation(null, obj));
            if (j()) {
                r();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowOperation<T, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final UnicastProcessor f136615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f136616b;

        WindowOperation(UnicastProcessor unicastProcessor, Object obj) {
            this.f136615a = unicastProcessor;
            this.f136616b = obj;
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new WindowBoundaryMainSubscriber(new SerializedSubscriber(subscriber), this.f136600c, this.f136601d, this.f136602f));
    }
}
