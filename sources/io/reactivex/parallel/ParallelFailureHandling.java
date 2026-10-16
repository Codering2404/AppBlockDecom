package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParallelFailureHandling apply(Long l3, Throwable th) {
        return this;
    }
}
