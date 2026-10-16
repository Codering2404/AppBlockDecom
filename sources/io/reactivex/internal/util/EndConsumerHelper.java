package io.reactivex.internal.util;

import androidx.compose.animation.core.h;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class EndConsumerHelper {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class cls) {
        RxJavaPlugins.s(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference atomicReference, Disposable disposable, Class cls) {
        ObjectHelper.d(disposable, "next is null");
        if (h.a(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean d(AtomicReference atomicReference, Subscription subscription, Class cls) {
        ObjectHelper.d(subscription, "next is null");
        if (h.a(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean e(Disposable disposable, Disposable disposable2, Class cls) {
        ObjectHelper.d(disposable2, "next is null");
        if (disposable == null) {
            return true;
        }
        disposable2.dispose();
        if (disposable == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean f(Subscription subscription, Subscription subscription2, Class cls) {
        ObjectHelper.d(subscription2, "next is null");
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        if (subscription == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }
}
