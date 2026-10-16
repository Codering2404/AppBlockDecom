package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum MaybeToPublisher implements Function<MaybeSource<Object>, Publisher<Object>> {
    INSTANCE;

    @Override // io.reactivex.functions.Function
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Publisher apply(MaybeSource maybeSource) {
        return new MaybeToFlowable(maybeSource);
    }
}
