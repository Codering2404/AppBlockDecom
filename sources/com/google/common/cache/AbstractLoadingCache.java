package com.google.common.cache;

import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    public Object a(Object obj) {
        try {
            return get(obj);
        } catch (ExecutionException e3) {
            throw new UncheckedExecutionException(e3.getCause());
        }
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final Object apply(Object obj) {
        return a(obj);
    }
}
