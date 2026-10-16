package io.reactivex.internal.subscribers;

import androidx.compose.animation.core.h;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f139139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f139140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139141c;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        SubscriptionHelper.g(this.f139141c, subscription, Long.MAX_VALUE);
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            BlockingHelper.a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f139140b;
        if (th == null) {
            return this.f139139a;
        }
        throw new ExecutionException(th);
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139139a == null) {
            this.f139139a = obj;
        } else {
            ((Subscription) this.f139141c.get()).cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f139141c.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription;
        if (this.f139139a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            subscription = (Subscription) this.f139141c.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!h.a(this.f139141c, subscription, this));
        countDown();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription;
        do {
            subscription = (Subscription) this.f139141c.get();
            if (subscription == this || subscription == SubscriptionHelper.CANCELLED) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f139140b = th;
        } while (!h.a(this.f139141c, subscription, this));
        countDown();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        Subscription subscription;
        SubscriptionHelper subscriptionHelper;
        do {
            subscription = (Subscription) this.f139141c.get();
            if (subscription == this || subscription == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!h.a(this.f139141c, subscription, subscriptionHelper));
        if (subscription != null) {
            subscription.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.a();
            if (!await(j3, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.d(j3, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f139140b;
            if (th == null) {
                return this.f139139a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
    }
}
