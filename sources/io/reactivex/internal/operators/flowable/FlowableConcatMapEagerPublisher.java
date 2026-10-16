package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f135467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135469d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ErrorMode f135471g;

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135467b.i(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.f135468c, this.f135469d, this.f135470f, this.f135471g));
    }
}
