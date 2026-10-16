package io.reactivex.internal.subscriptions;

import androidx.compose.animation.core.h;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static boolean a(AtomicReference atomicReference) {
        Subscription subscription;
        Subscription subscription2 = (Subscription) atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription2 == subscriptionHelper || (subscription = (Subscription) atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription.cancel();
        return true;
    }

    public static void b(AtomicReference atomicReference, AtomicLong atomicLong, long j3) {
        Subscription subscription = (Subscription) atomicReference.get();
        if (subscription != null) {
            subscription.y(j3);
            return;
        }
        if (h(j3)) {
            BackpressureHelper.a(atomicLong, j3);
            Subscription subscription2 = (Subscription) atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.y(andSet);
                }
            }
        }
    }

    public static boolean c(AtomicReference atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!f(atomicReference, subscription)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0L);
        if (andSet == 0) {
            return true;
        }
        subscription.y(andSet);
        return true;
    }

    public static void d(long j3) {
        RxJavaPlugins.s(new ProtocolViolationException("More produced than requested: " + j3));
    }

    public static void e() {
        RxJavaPlugins.s(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean f(AtomicReference atomicReference, Subscription subscription) {
        ObjectHelper.d(subscription, "s is null");
        if (h.a(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        e();
        return false;
    }

    public static boolean g(AtomicReference atomicReference, Subscription subscription, long j3) {
        if (!f(atomicReference, subscription)) {
            return false;
        }
        subscription.y(j3);
        return true;
    }

    public static boolean h(long j3) {
        if (j3 > 0) {
            return true;
        }
        RxJavaPlugins.s(new IllegalArgumentException("n > 0 required but it was " + j3));
        return false;
    }

    public static boolean i(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.s(new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        e();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
    }
}
