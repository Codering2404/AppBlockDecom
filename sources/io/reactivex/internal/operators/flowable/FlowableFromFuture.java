package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFromFuture<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Future f135756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f135758d;

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription(subscriber);
        subscriber.g(deferredScalarSubscription);
        try {
            TimeUnit timeUnit = this.f135758d;
            Object obj = timeUnit != null ? this.f135756b.get(this.f135757c, timeUnit) : this.f135756b.get();
            if (obj == null) {
                subscriber.onError(new NullPointerException("The future returned null"));
            } else {
                deferredScalarSubscription.e(obj);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            if (deferredScalarSubscription.j()) {
                return;
            }
            subscriber.onError(th);
        }
    }
}
