package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFromPublisher<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f135768b;

    public FlowableFromPublisher(Publisher publisher) {
        this.f135768b = publisher;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135768b.i(subscriber);
    }
}
