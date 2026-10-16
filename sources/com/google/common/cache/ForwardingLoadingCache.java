package com.google.common.cache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoadingCache f83498a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache
        /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final LoadingCache o2() {
            return this.f83498a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.cache.ForwardingCache
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
    public abstract LoadingCache o2();

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public Object apply(Object obj) {
        return o2().apply(obj);
    }
}
