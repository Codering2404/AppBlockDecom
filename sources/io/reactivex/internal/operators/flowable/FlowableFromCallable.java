package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFromCallable<T> extends Flowable<T> implements Callable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f135755b;

    @Override // java.util.concurrent.Callable
    public Object call() {
        return ObjectHelper.d(this.f135755b.call(), "The callable returned a null value");
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.g(deferredScalarSubscription);
        try {
            deferredScalarSubscription.e(ObjectHelper.d(this.f135755b.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            Exceptions.b(th);
            if (deferredScalarSubscription.j()) {
                RxJavaPlugins.s(th);
            } else {
                subscriber.onError(th);
            }
        }
    }
}
