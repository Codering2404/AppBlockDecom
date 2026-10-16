package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableToFlowable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f135179b;

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135179b.b(new SubscriberCompletableObserver(subscriber));
    }
}
