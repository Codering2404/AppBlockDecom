package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTimer extends Flowable<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f136522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136524d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile boolean f136526b;

        TimerSubscriber(Subscriber subscriber) {
            this.f136525a = subscriber;
        }

        public void a(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            DisposableHelper.a(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                if (!this.f136526b) {
                    lazySet(EmptyDisposable.INSTANCE);
                    this.f136525a.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
                } else {
                    this.f136525a.h(0L);
                    lazySet(EmptyDisposable.INSTANCE);
                    this.f136525a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                this.f136526b = true;
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.g(timerSubscriber);
        timerSubscriber.a(this.f136522b.f(timerSubscriber, this.f136523c, this.f136524d));
    }
}
