package com.google.common.cache;

import com.google.common.collect.ForwardingObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Cache f83497a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public final Cache o2() {
            return this.f83497a;
        }
    }

    protected ForwardingCache() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public abstract Cache o2();
}
