package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableUsing<T, D> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f136539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f136541d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f136542f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 5904473792286235046L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f136544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Consumer f136545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f136546d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f136547f;

        UsingSubscriber(Subscriber subscriber, Object obj, Consumer consumer, boolean z2) {
            this.f136543a = subscriber;
            this.f136544b = obj;
            this.f136545c = consumer;
            this.f136546d = z2;
        }

        void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f136545c.accept(this.f136544b);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            a();
            this.f136547f.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136547f, subscription)) {
                this.f136547f = subscription;
                this.f136543a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136543a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f136546d) {
                this.f136543a.onComplete();
                this.f136547f.cancel();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f136545c.accept(this.f136544b);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f136543a.onError(th);
                    return;
                }
            }
            this.f136547f.cancel();
            this.f136543a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f136546d) {
                this.f136543a.onError(th);
                this.f136547f.cancel();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f136545c.accept(this.f136544b);
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                    Exceptions.b(th);
                }
            } else {
                th = null;
            }
            this.f136547f.cancel();
            if (th != null) {
                this.f136543a.onError(new CompositeException(th, th));
            } else {
                this.f136543a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136547f.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        try {
            Object objCall = this.f136539b.call();
            try {
                ((Publisher) ObjectHelper.d(this.f136540c.apply(objCall), "The sourceSupplier returned a null Publisher")).i(new UsingSubscriber(subscriber, objCall, this.f136541d, this.f136542f));
            } catch (Throwable th) {
                Exceptions.b(th);
                try {
                    this.f136541d.accept(objCall);
                    EmptySubscription.b(th, subscriber);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    EmptySubscription.b(new CompositeException(th, th2), subscriber);
                }
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            EmptySubscription.b(th3, subscriber);
        }
    }
}
