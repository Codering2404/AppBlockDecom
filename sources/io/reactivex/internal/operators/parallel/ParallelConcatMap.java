package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ErrorMode f138566d;

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138563a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                subscriberArr2[i3] = FlowableConcatMap.A(subscriberArr[i3], this.f138564b, this.f138565c, this.f138566d);
            }
            this.f138563a.b(subscriberArr2);
        }
    }
}
