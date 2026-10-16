package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
    }

    protected ForwardingSortedMap() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap
    /* JADX INFO: renamed from: c2 */
    public abstract SortedMap k2();

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return k2().comparator();
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        return k2().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return k2().headMap(obj);
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return k2().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return k2().subMap(obj, obj2);
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return k2().tailMap(obj);
    }
}
