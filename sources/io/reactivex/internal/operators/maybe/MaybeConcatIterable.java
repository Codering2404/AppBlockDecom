package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeConcatIterable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable f136764b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136765a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Iterator f136769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f136770g;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicLong f136766b = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SequentialDisposable f136768d = new SequentialDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136767c = new AtomicReference(NotificationLite.COMPLETE);

        ConcatMaybeObserver(Subscriber subscriber, Iterator it) {
            this.f136765a = subscriber;
            this.f136769f = it;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            this.f136768d.a(disposable);
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference atomicReference = this.f136767c;
            Subscriber subscriber = this.f136765a;
            SequentialDisposable sequentialDisposable = this.f136768d;
            while (!sequentialDisposable.e()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    if (obj != NotificationLite.COMPLETE) {
                        long j3 = this.f136770g;
                        if (j3 != this.f136766b.get()) {
                            this.f136770g = j3 + 1;
                            atomicReference.lazySet(null);
                            subscriber.h(obj);
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (!sequentialDisposable.e()) {
                        try {
                            if (this.f136769f.hasNext()) {
                                try {
                                    ((MaybeSource) ObjectHelper.d(this.f136769f.next(), "The source Iterator returned a null MaybeSource")).b(this);
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
                                subscriber.onComplete();
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136768d.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136767c.lazySet(NotificationLite.COMPLETE);
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136765a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136767c.lazySet(obj);
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136766b, j3);
                b();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        try {
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, (Iterator) ObjectHelper.d(this.f136764b.iterator(), "The sources Iterable returned a null Iterator"));
            subscriber.g(concatMaybeObserver);
            concatMaybeObserver.b();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
