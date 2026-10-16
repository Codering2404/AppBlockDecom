package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f135941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135942c;

    public FlowableMapPublisher(Publisher publisher, Function function) {
        this.f135941b = publisher;
        this.f135942c = function;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135941b.i(new FlowableMap.MapSubscriber(subscriber, this.f135942c));
    }
}
