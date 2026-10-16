package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDefer<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f135535b;

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        try {
            ((Publisher) ObjectHelper.d(this.f135535b.call(), "The publisher supplied is null")).i(subscriber);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
