package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f135714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f135716d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f135718g;

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (FlowableScalarXMap.a(this.f135714b, subscriber, this.f135715c)) {
            return;
        }
        this.f135714b.i(FlowableFlatMap.A(subscriber, this.f135715c, this.f135716d, this.f135717f, this.f135718g));
    }
}
