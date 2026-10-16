package io.reactivex.internal.operators.mixed;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSwitchMapSingle<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Flowable f137147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f137149d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final SwitchMapSingleObserver f137150l = new SwitchMapSingleObserver(null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f137151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137154d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f137155f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f137156g = new AtomicReference();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f137157h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137158i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137159j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f137160k;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SwitchMapSingleSubscriber f137161a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            volatile Object f137162b;

            SwitchMapSingleObserver(SwitchMapSingleSubscriber switchMapSingleSubscriber) {
                this.f137161a = switchMapSingleSubscriber;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f137161a.c(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f137162b = obj;
                this.f137161a.b();
            }
        }

        SwitchMapSingleSubscriber(Subscriber subscriber, Function function, boolean z2) {
            this.f137151a = subscriber;
            this.f137152b = function;
            this.f137153c = z2;
        }

        void a() {
            AtomicReference atomicReference = this.f137156g;
            SwitchMapSingleObserver switchMapSingleObserver = f137150l;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) atomicReference.getAndSet(switchMapSingleObserver);
            if (switchMapSingleObserver2 == null || switchMapSingleObserver2 == switchMapSingleObserver) {
                return;
            }
            switchMapSingleObserver2.b();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f137151a;
            AtomicThrowable atomicThrowable = this.f137154d;
            AtomicReference atomicReference = this.f137156g;
            AtomicLong atomicLong = this.f137155f;
            long j3 = this.f137160k;
            int iAddAndGet = 1;
            while (!this.f137159j) {
                if (atomicThrowable.get() != null && !this.f137153c) {
                    subscriber.onError(atomicThrowable.b());
                    return;
                }
                boolean z2 = this.f137158i;
                SwitchMapSingleObserver switchMapSingleObserver = (SwitchMapSingleObserver) atomicReference.get();
                boolean z3 = switchMapSingleObserver == null;
                if (z2 && z3) {
                    Throwable thB = atomicThrowable.b();
                    if (thB != null) {
                        subscriber.onError(thB);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (z3 || switchMapSingleObserver.f137162b == null || j3 == atomicLong.get()) {
                    this.f137160k = j3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    h.a(atomicReference, switchMapSingleObserver, null);
                    subscriber.h(switchMapSingleObserver.f137162b);
                    j3++;
                }
            }
        }

        void c(SwitchMapSingleObserver switchMapSingleObserver, Throwable th) {
            if (!h.a(this.f137156g, switchMapSingleObserver, null) || !this.f137154d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137153c) {
                this.f137157h.cancel();
                a();
            }
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f137159j = true;
            this.f137157h.cancel();
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137157h, subscription)) {
                this.f137157h = subscription;
                this.f137151a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            SwitchMapSingleObserver switchMapSingleObserver;
            SwitchMapSingleObserver switchMapSingleObserver2 = (SwitchMapSingleObserver) this.f137156g.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.b();
            }
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.d(this.f137152b.apply(obj), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
                do {
                    switchMapSingleObserver = (SwitchMapSingleObserver) this.f137156g.get();
                    if (switchMapSingleObserver == f137150l) {
                        return;
                    }
                } while (!h.a(this.f137156g, switchMapSingleObserver, switchMapSingleObserver3));
                singleSource.b(switchMapSingleObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137157h.cancel();
                this.f137156g.getAndSet(f137150l);
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137158i = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f137154d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137153c) {
                a();
            }
            this.f137158i = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f137155f, j3);
            b();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137147b.w(new SwitchMapSingleSubscriber(subscriber, this.f137148c, this.f137149d));
    }
}
