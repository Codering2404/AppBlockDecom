package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ForwardingNavigableMap f83954d;

        @Override // com.google.common.collect.Maps.DescendingMap
        protected Iterator g2() {
            return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private Map.Entry f83955a = null;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private Map.Entry f83956b;

                {
                    this.f83956b = StandardDescendingMap.this.k2().lastEntry();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry next() {
                    Map.Entry entry = this.f83956b;
                    if (entry == null) {
                        throw new NoSuchElementException();
                    }
                    this.f83955a = entry;
                    this.f83956b = StandardDescendingMap.this.k2().lowerEntry(this.f83956b.getKey());
                    return entry;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f83956b != null;
                }

                @Override // java.util.Iterator
                public void remove() {
                    if (this.f83955a == null) {
                        throw new IllegalStateException("no calls to next() since the last call to remove()");
                    }
                    StandardDescendingMap.this.k2().remove(this.f83955a.getKey());
                    this.f83955a = null;
                }
            };
        }

        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap k2() {
            return this.f83954d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
    }

    @Override // java.util.NavigableMap
    public Map.Entry ceilingEntry(Object obj) {
        return k2().ceilingEntry(obj);
    }

    @Override // java.util.NavigableMap
    public Object ceilingKey(Object obj) {
        return k2().ceilingKey(obj);
    }

    @Override // java.util.NavigableMap
    public NavigableSet descendingKeySet() {
        return k2().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap descendingMap() {
        return k2().descendingMap();
    }

    @Override // java.util.NavigableMap
    public Map.Entry firstEntry() {
        return k2().firstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry floorEntry(Object obj) {
        return k2().floorEntry(obj);
    }

    @Override // java.util.NavigableMap
    public Object floorKey(Object obj) {
        return k2().floorKey(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedMap
    /* JADX INFO: renamed from: g2, reason: merged with bridge method [inline-methods] */
    public abstract NavigableMap k2();

    @Override // java.util.NavigableMap
    public NavigableMap headMap(Object obj, boolean z2) {
        return k2().headMap(obj, z2);
    }

    @Override // java.util.NavigableMap
    public Map.Entry higherEntry(Object obj) {
        return k2().higherEntry(obj);
    }

    @Override // java.util.NavigableMap
    public Object higherKey(Object obj) {
        return k2().higherKey(obj);
    }

    @Override // java.util.NavigableMap
    public Map.Entry lastEntry() {
        return k2().lastEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry lowerEntry(Object obj) {
        return k2().lowerEntry(obj);
    }

    @Override // java.util.NavigableMap
    public Object lowerKey(Object obj) {
        return k2().lowerKey(obj);
    }

    @Override // java.util.NavigableMap
    public NavigableSet navigableKeySet() {
        return k2().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry pollFirstEntry() {
        return k2().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    public Map.Entry pollLastEntry() {
        return k2().pollLastEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
        return k2().subMap(obj, z2, obj2, z3);
    }

    @Override // java.util.NavigableMap
    public NavigableMap tailMap(Object obj, boolean z2) {
        return k2().tailMap(obj, z2);
    }
}
