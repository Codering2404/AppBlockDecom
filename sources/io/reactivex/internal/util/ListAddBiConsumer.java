package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    @Override // io.reactivex.functions.BiFunction
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List apply(List list, Object obj) {
        list.add(obj);
        return list;
    }
}
