package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    protected ForwardingConcurrentMap() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap
    /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
    public abstract ConcurrentMap k2();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        return k2().putIfAbsent(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return k2().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        return k2().replace(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        return k2().replace(obj, obj2, obj3);
    }
}
