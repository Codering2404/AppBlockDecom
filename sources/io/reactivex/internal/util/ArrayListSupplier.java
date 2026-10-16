package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum ArrayListSupplier implements Callable<List<Object>>, Function<Object, List<Object>> {
    INSTANCE;

    @Override // io.reactivex.functions.Function
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List apply(Object obj) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public List call() {
        return new ArrayList();
    }
}
