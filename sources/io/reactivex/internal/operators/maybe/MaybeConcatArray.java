package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeConcatArray<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource[] f136747b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = 3520831347801429610L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136748a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final MaybeSource[] f136752f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f136753g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f136754h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicLong f136749b = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SequentialDisposable f136751d = new SequentialDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136750c = new AtomicReference(NotificationLite.COMPLETE);

        ConcatMaybeObserver(Subscriber subscriber, MaybeSource[] maybeSourceArr) {
            this.f136748a = subscriber;
            this.f136752f = maybeSourceArr;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            this.f136751d.a(disposable);
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference atomicReference = this.f136750c;
            Subscriber subscriber = this.f136748a;
            SequentialDisposable sequentialDisposable = this.f136751d;
            while (!sequentialDisposable.e()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    if (obj != NotificationLite.COMPLETE) {
                        long j3 = this.f136754h;
                        if (j3 != this.f136749b.get()) {
                            this.f136754h = j3 + 1;
                            atomicReference.lazySet(null);
                            subscriber.h(obj);
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (!sequentialDisposable.e()) {
                        int i3 = this.f136753g;
                        MaybeSource[] maybeSourceArr = this.f136752f;
                        if (i3 == maybeSourceArr.length) {
                            subscriber.onComplete();
                            return;
                        } else {
                            this.f136753g = i3 + 1;
                            maybeSourceArr[i3].b(this);
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
            this.f136751d.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136750c.lazySet(NotificationLite.COMPLETE);
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136748a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136750c.lazySet(obj);
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136749b, j3);
                b();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.f136747b);
        subscriber.g(concatMaybeObserver);
        concatMaybeObserver.b();
    }
}
