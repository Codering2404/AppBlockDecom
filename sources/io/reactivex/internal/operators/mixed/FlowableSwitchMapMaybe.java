package io.reactivex.internal.operators.mixed;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Flowable f137131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f137133d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final SwitchMapMaybeObserver f137134l = new SwitchMapMaybeObserver(null);
        private static final long serialVersionUID = -5402190102429853762L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f137135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137136b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137137c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137138d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f137139f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f137140g = new AtomicReference();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f137141h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137142i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137143j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f137144k;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = 8042919737683345351L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SwitchMapMaybeSubscriber f137145a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            volatile Object f137146b;

            SwitchMapMaybeObserver(SwitchMapMaybeSubscriber switchMapMaybeSubscriber) {
                this.f137145a = switchMapMaybeSubscriber;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137145a.c(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f137145a.d(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f137146b = obj;
                this.f137145a.b();
            }
        }

        SwitchMapMaybeSubscriber(Subscriber subscriber, Function function, boolean z2) {
            this.f137135a = subscriber;
            this.f137136b = function;
            this.f137137c = z2;
        }

        void a() {
            AtomicReference atomicReference = this.f137140g;
            SwitchMapMaybeObserver switchMapMaybeObserver = f137134l;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = (SwitchMapMaybeObserver) atomicReference.getAndSet(switchMapMaybeObserver);
            if (switchMapMaybeObserver2 == null || switchMapMaybeObserver2 == switchMapMaybeObserver) {
                return;
            }
            switchMapMaybeObserver2.b();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f137135a;
            AtomicThrowable atomicThrowable = this.f137138d;
            AtomicReference atomicReference = this.f137140g;
            AtomicLong atomicLong = this.f137139f;
            long j3 = this.f137144k;
            int iAddAndGet = 1;
            while (!this.f137143j) {
                if (atomicThrowable.get() != null && !this.f137137c) {
                    subscriber.onError(atomicThrowable.b());
                    return;
                }
                boolean z2 = this.f137142i;
                SwitchMapMaybeObserver switchMapMaybeObserver = (SwitchMapMaybeObserver) atomicReference.get();
                boolean z3 = switchMapMaybeObserver == null;
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
                if (z3 || switchMapMaybeObserver.f137146b == null || j3 == atomicLong.get()) {
                    this.f137144k = j3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    h.a(atomicReference, switchMapMaybeObserver, null);
                    subscriber.h(switchMapMaybeObserver.f137146b);
                    j3++;
                }
            }
        }

        void c(SwitchMapMaybeObserver switchMapMaybeObserver) {
            if (h.a(this.f137140g, switchMapMaybeObserver, null)) {
                b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f137143j = true;
            this.f137141h.cancel();
            a();
        }

        void d(SwitchMapMaybeObserver switchMapMaybeObserver, Throwable th) {
            if (!h.a(this.f137140g, switchMapMaybeObserver, null) || !this.f137138d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137137c) {
                this.f137141h.cancel();
                a();
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137141h, subscription)) {
                this.f137141h = subscription;
                this.f137135a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            SwitchMapMaybeObserver switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = (SwitchMapMaybeObserver) this.f137140g.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.b();
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f137136b.apply(obj), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = (SwitchMapMaybeObserver) this.f137140g.get();
                    if (switchMapMaybeObserver == f137134l) {
                        return;
                    }
                } while (!h.a(this.f137140g, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.b(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137141h.cancel();
                this.f137140g.getAndSet(f137134l);
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137142i = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f137138d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137137c) {
                a();
            }
            this.f137142i = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f137139f, j3);
            b();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137131b.w(new SwitchMapMaybeSubscriber(subscriber, this.f137132c, this.f137133d));
    }
}
