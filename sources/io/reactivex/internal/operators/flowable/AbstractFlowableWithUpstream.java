package io.reactivex.internal.operators.flowable;

import androidx.legacy.content.Werj.QgXempTBEfV;
import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class AbstractFlowableWithUpstream<T, R> extends Flowable<R> implements HasUpstreamPublisher<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Flowable f135196b;

    AbstractFlowableWithUpstream(Flowable flowable) {
        this.f135196b = (Flowable) ObjectHelper.d(flowable, QgXempTBEfV.rpWLSQj);
    }
}
