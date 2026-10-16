package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator f139223a;

    @Override // io.reactivex.functions.Function
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List apply(List list) {
        Collections.sort(list, this.f139223a);
        return list;
    }
}
