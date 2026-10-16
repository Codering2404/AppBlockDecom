package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatMapPublisher<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f135472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135474d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ErrorMode f135475f;

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (FlowableScalarXMap.a(this.f135472b, subscriber, this.f135473c)) {
            return;
        }
        this.f135472b.i(FlowableConcatMap.A(subscriber, this.f135473c, this.f135474d, this.f135475f));
    }
}
