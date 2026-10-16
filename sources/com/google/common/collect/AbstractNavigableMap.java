package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class DescendingMap extends Maps.DescendingMap<K, V> {
        private DescendingMap() {
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        Iterator g2() {
            return AbstractNavigableMap.this.b();
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap k2() {
            return AbstractNavigableMap.this;
        }
    }

    AbstractNavigableMap() {
    }

    abstract Iterator b();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public Object ceilingKey(Object obj) {
        return Maps.y(ceilingEntry(obj));
    }

    @Override // java.util.NavigableMap
    public NavigableSet descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap descendingMap() {
        return new DescendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry firstEntry() {
        return (Map.Entry) Iterators.x(a(), null);
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        Map.Entry entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public Object floorKey(Object obj) {
        return Maps.y(floorEntry(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public Object higherKey(Object obj) {
        return Maps.y(higherEntry(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry lastEntry() {
        return (Map.Entry) Iterators.x(b(), null);
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        Map.Entry entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public Object lowerKey(Object obj) {
        return Maps.y(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public NavigableSet navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry pollFirstEntry() {
        return (Map.Entry) Iterators.G(a());
    }

    @Override // java.util.NavigableMap
    public Map.Entry pollLastEntry() {
        return (Map.Entry) Iterators.G(b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
