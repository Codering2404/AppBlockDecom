package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f135318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f135319d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BufferExactBoundarySubscriber f135320b;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber bufferExactBoundarySubscriber) {
            this.f135320b = bufferExactBoundarySubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135320b.r();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135320b.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135320b.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f135321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Publisher f135322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Subscription f135323k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Disposable f135324l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Collection f135325m;

        BufferExactBoundarySubscriber(Subscriber subscriber, Callable callable, Publisher publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.f135321i = callable;
            this.f135322j = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f139155f) {
                return;
            }
            this.f139155f = true;
            this.f135324l.dispose();
            this.f135323k.cancel();
            if (j()) {
                this.f139154d.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139155f;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135323k, subscription)) {
                this.f135323k = subscription;
                try {
                    this.f135325m = (Collection) ObjectHelper.d(this.f135321i.call(), "The buffer supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.f135324l = bufferBoundarySubscriber;
                    this.f139153c.g(this);
                    if (this.f139155f) {
                        return;
                    }
                    subscription.y(Long.MAX_VALUE);
                    this.f135322j.i(bufferBoundarySubscriber);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f139155f = true;
                    subscription.cancel();
                    EmptySubscription.b(th, this.f139153c);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f135325m;
                    if (collection == null) {
                        return;
                    }
                    collection.add(obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            synchronized (this) {
                try {
                    Collection collection = this.f135325m;
                    if (collection == null) {
                        return;
                    }
                    this.f135325m = null;
                    this.f139154d.offer(collection);
                    this.f139156g = true;
                    if (j()) {
                        QueueDrainHelper.e(this.f139154d, this.f139153c, false, this, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            cancel();
            this.f139153c.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber subscriber, Collection collection) {
            this.f139153c.h(collection);
            return true;
        }

        void r() {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f135321i.call(), "The buffer supplied is null");
                synchronized (this) {
                    try {
                        Collection collection2 = this.f135325m;
                        if (collection2 == null) {
                            return;
                        }
                        this.f135325m = collection;
                        l(collection2, false, this);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                cancel();
                this.f139153c.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.f135319d, this.f135318c));
    }
}
