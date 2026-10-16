package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f135309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f135310d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BufferBoundarySupplierSubscriber f135311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f135312c;

        BufferBoundarySubscriber(BufferBoundarySupplierSubscriber bufferBoundarySupplierSubscriber) {
            this.f135311b = bufferBoundarySupplierSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135312c) {
                return;
            }
            this.f135312c = true;
            a();
            this.f135311b.s();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135312c) {
                return;
            }
            this.f135312c = true;
            this.f135311b.s();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135312c) {
                RxJavaPlugins.s(th);
            } else {
                this.f135312c = true;
                this.f135311b.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundarySupplierSubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Subscription, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f135313i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Callable f135314j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Subscription f135315k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicReference f135316l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Collection f135317m;

        BufferBoundarySupplierSubscriber(Subscriber subscriber, Callable callable, Callable callable2) {
            super(subscriber, new MpscLinkedQueue());
            this.f135316l = new AtomicReference();
            this.f135313i = callable;
            this.f135314j = callable2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f139155f) {
                return;
            }
            this.f139155f = true;
            this.f135315k.cancel();
            r();
            if (j()) {
                this.f139154d.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135315k.cancel();
            r();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135316l.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135315k, subscription)) {
                this.f135315k = subscription;
                Subscriber subscriber = this.f139153c;
                try {
                    this.f135317m = (Collection) ObjectHelper.d(this.f135313i.call(), "The buffer supplied is null");
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.d(this.f135314j.call(), "The boundary publisher supplied is null");
                        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                        this.f135316l.set(bufferBoundarySubscriber);
                        subscriber.g(this);
                        if (this.f139155f) {
                            return;
                        }
                        subscription.y(Long.MAX_VALUE);
                        publisher.i(bufferBoundarySubscriber);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f139155f = true;
                        subscription.cancel();
                        EmptySubscription.b(th, subscriber);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f139155f = true;
                    subscription.cancel();
                    EmptySubscription.b(th2, subscriber);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f135317m;
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
                    Collection collection = this.f135317m;
                    if (collection == null) {
                        return;
                    }
                    this.f135317m = null;
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
            DisposableHelper.a(this.f135316l);
        }

        void s() {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f135313i.call(), "The buffer supplied is null");
                try {
                    Publisher publisher = (Publisher) ObjectHelper.d(this.f135314j.call(), "The boundary publisher supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    if (DisposableHelper.c(this.f135316l, bufferBoundarySubscriber)) {
                        synchronized (this) {
                            try {
                                Collection collection2 = this.f135317m;
                                if (collection2 == null) {
                                    return;
                                }
                                this.f135317m = collection;
                                publisher.i(bufferBoundarySubscriber);
                                l(collection2, false, this);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f139155f = true;
                    this.f135315k.cancel();
                    this.f139153c.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                cancel();
                this.f139153c.onError(th3);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new BufferBoundarySupplierSubscriber(new SerializedSubscriber(subscriber), this.f135310d, this.f135309c));
    }
}
