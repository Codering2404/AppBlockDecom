package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTakePublisher<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136427c;

    public FlowableTakePublisher(Publisher publisher, long j3) {
        this.f136426b = publisher;
        this.f136427c = j3;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f136426b.i(new FlowableTake.TakeSubscriber(subscriber, this.f136427c));
    }
}
