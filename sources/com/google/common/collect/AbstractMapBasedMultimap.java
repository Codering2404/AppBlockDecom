package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Map f83691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f83692h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient Map f83695d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return Collections2.g(AsMap.this.f83695d.entrySet(), obj);
            }

            @Override // com.google.common.collect.Maps.EntrySet
            Map f() {
                return AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return AsMap.this.new AsMapIterator();
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.y(entry.getKey());
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f83698a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection f83699b;

            AsMapIterator() {
                this.f83698a = AsMap.this.f83695d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f83698a.next();
                this.f83699b = (Collection) entry.getValue();
                return AsMap.this.f(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f83698a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.A(this.f83699b != null, "no calls to next() since the last call to remove()");
                this.f83698a.remove();
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, this.f83699b.size());
                this.f83699b.clear();
                this.f83699b = null;
            }
        }

        AsMap(Map map) {
            this.f83695d = map;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set a() {
            return new AsMapEntries();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f83695d == AbstractMapBasedMultimap.this.f83691g) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.e(new AsMapIterator());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.I(this.f83695d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) Maps.J(this.f83695d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.B(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.f83695d.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionS = AbstractMapBasedMultimap.this.s();
            collectionS.addAll(collection);
            AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, collection.size());
            collection.clear();
            return collectionS;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f83695d.equals(obj);
        }

        Map.Entry f(Map.Entry entry) {
            Object key = entry.getKey();
            return Maps.u(key, AbstractMapBasedMultimap.this.B(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f83695d.hashCode();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set h() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f83695d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f83695d.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class Itr<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator f83701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f83702b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection f83703c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Iterator f83704d = Iterators.o();

        Itr() {
            this.f83701a = AbstractMapBasedMultimap.this.f83691g.entrySet().iterator();
        }

        abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f83701a.hasNext() || this.f83704d.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f83704d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f83701a.next();
                this.f83702b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.f83703c = collection;
                this.f83704d = collection.iterator();
            }
            return a(NullnessCasts.a(this.f83702b), this.f83704d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f83704d.remove();
            Collection collection = this.f83703c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f83701a.remove();
            }
            AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class KeySet extends Maps.KeySet<K, Collection<V>> {
        KeySet(Map map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.e(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return g().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || g().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return g().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            final Iterator<Map.Entry<K, V>> it = g().entrySet().iterator();
            return new Iterator<K>(this) { // from class: com.google.common.collect.AbstractMapBasedMultimap.KeySet.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                Map.Entry f83707a;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ KeySet f83709c;

                {
                    this.f83709c = this;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public Object next() {
                    Map.Entry entry = (Map.Entry) it.next();
                    this.f83707a = entry;
                    return entry.getKey();
                }

                @Override // java.util.Iterator
                public void remove() {
                    Preconditions.A(this.f83707a != null, "no calls to next() since the last call to remove()");
                    Collection collection = (Collection) this.f83707a.getValue();
                    it.remove();
                    AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, collection.size());
                    collection.clear();
                    this.f83707a = null;
                }
            };
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) g().remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        NavigableAsMap(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry<K, V> entryCeilingEntry = i().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return f(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return i().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return new NavigableAsMap(i().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry<K, V> entryFirstEntry = i().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return f(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry<K, V> entryFloorEntry = i().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return f(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return i().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry<K, V> entryHigherEntry = i().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return f(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return i().higherKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return new NavigableKeySet(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        Map.Entry l(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionS = AbstractMapBasedMultimap.this.s();
            collectionS.addAll((Collection) entry.getValue());
            it.remove();
            return Maps.u(entry.getKey(), AbstractMapBasedMultimap.this.A(collectionS));
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry<K, V> entryLastEntry = i().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return f(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry<K, V> entryLowerEntry = i().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return f(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return i().lowerKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap i() {
            return (NavigableMap) super.i();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return h();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return l(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return l(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return new NavigableAsMap(i().headMap(obj, z2));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet h() {
            return (NavigableSet) super.h();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return new NavigableAsMap(i().subMap(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return new NavigableAsMap(i().tailMap(obj, z2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        NavigableKeySet(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return g().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return new NavigableKeySet(g().descendingMap());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return g().floorKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return g().higherKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableMap g() {
            return (NavigableMap) super.g();
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return g().lowerKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterators.G(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterators.G(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return new NavigableKeySet(g().headMap(obj, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return new NavigableKeySet(g().subMap(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return new NavigableKeySet(g().tailMap(obj, z2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        RandomAccessWrappedList(Object obj, List list, WrappedCollection wrappedCollection) {
            super(obj, list, wrappedCollection);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        SortedSet f83713g;

        SortedAsMap(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return i().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet g() {
            return new SortedKeySet(i());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet h() {
            SortedSet sortedSet = this.f83713g;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetG = g();
            this.f83713g = sortedSetG;
            return sortedSetG;
        }

        public SortedMap headMap(Object obj) {
            return new SortedAsMap(i().headMap(obj));
        }

        SortedMap i() {
            return (SortedMap) this.f83695d;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return i().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return new SortedAsMap(i().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return new SortedAsMap(i().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return g().firstKey();
        }

        SortedMap g() {
            return (SortedMap) super.g();
        }

        public SortedSet headSet(Object obj) {
            return new SortedKeySet(g().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return g().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return new SortedKeySet(g().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return new SortedKeySet(g().tailMap(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        WrappedNavigableSet(Object obj, NavigableSet navigableSet, WrappedCollection wrappedCollection) {
            super(obj, navigableSet, wrappedCollection);
        }

        private NavigableSet n(NavigableSet navigableSet) {
            return new WrappedNavigableSet(this.f83716a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return h().ceiling(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return new WrappedCollection.WrappedIterator(h().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return n(h().descendingSet());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return h().floor(obj);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return n(h().headSet(obj, z2));
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return h().higher(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public NavigableSet h() {
            return (NavigableSet) super.h();
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return h().lower(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Iterators.G(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Iterators.G(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return n(h().subSet(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return n(h().tailSet(obj, z2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        WrappedSet(Object obj, Set set) {
            super(obj, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zN = Sets.n((Set) this.f83717b, collection);
            if (zN) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, this.f83717b.size() - size);
                g();
            }
            return zN;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        WrappedSortedSet(Object obj, SortedSet sortedSet, WrappedCollection wrappedCollection) {
            super(obj, sortedSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            f();
            return h().first();
        }

        SortedSet h() {
            return (SortedSet) d();
        }

        @Override // java.util.SortedSet
        public SortedSet headSet(Object obj) {
            f();
            return new WrappedSortedSet(e(), h().headSet(obj), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public Object last() {
            f();
            return h().last();
        }

        @Override // java.util.SortedSet
        public SortedSet subSet(Object obj, Object obj2) {
            f();
            return new WrappedSortedSet(e(), h().subSet(obj, obj2), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet tailSet(Object obj) {
            f();
            return new WrappedSortedSet(e(), h().tailSet(obj), b() == null ? this : b());
        }
    }

    protected AbstractMapBasedMultimap(Map map) {
        Preconditions.d(map.isEmpty());
        this.f83691g = map;
    }

    static /* synthetic */ int m(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i3 = abstractMapBasedMultimap.f83692h;
        abstractMapBasedMultimap.f83692h = i3 + 1;
        return i3;
    }

    static /* synthetic */ int n(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i3 = abstractMapBasedMultimap.f83692h;
        abstractMapBasedMultimap.f83692h = i3 - 1;
        return i3;
    }

    static /* synthetic */ int o(AbstractMapBasedMultimap abstractMapBasedMultimap, int i3) {
        int i4 = abstractMapBasedMultimap.f83692h + i3;
        abstractMapBasedMultimap.f83692h = i4;
        return i4;
    }

    static /* synthetic */ int p(AbstractMapBasedMultimap abstractMapBasedMultimap, int i3) {
        int i4 = abstractMapBasedMultimap.f83692h - i3;
        abstractMapBasedMultimap.f83692h = i4;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator x(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Object obj) {
        Collection collection = (Collection) Maps.K(this.f83691g, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f83692h -= size;
        }
    }

    Collection A(Collection collection) {
        return Collections.unmodifiableCollection(collection);
    }

    Collection B(Object obj, Collection collection) {
        return new WrappedCollection(obj, collection, null);
    }

    final List C(Object obj, List list, WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(obj, list, wrappedCollection) : new WrappedList(obj, list, wrappedCollection);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection a(Object obj) {
        Collection collection = (Collection) this.f83691g.remove(obj);
        if (collection == null) {
            return w();
        }
        Collection collectionS = s();
        collectionS.addAll(collection);
        this.f83692h -= collection.size();
        collection.clear();
        return A(collectionS);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection b() {
        return super.b();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map c() {
        return new AsMap(this.f83691g);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Iterator<V> it = this.f83691g.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f83691g.clear();
        this.f83692h = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.f83691g.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection d() {
        return this instanceof SetMultimap ? new AbstractMultimap.EntrySet() : new AbstractMultimap.Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set e() {
        return new KeySet(this.f83691g);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset g() {
        return new Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection get(Object obj) {
        Collection collectionT = (Collection) this.f83691g.get(obj);
        if (collectionT == null) {
            collectionT = t(obj);
        }
        return B(obj, collectionT);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection h() {
        return new AbstractMultimap.Values();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator i() {
        return new AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>() { // from class: com.google.common.collect.AbstractMapBasedMultimap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry a(Object obj, Object obj2) {
                return Maps.u(obj, obj2);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator j() {
        return new AbstractMapBasedMultimap<K, V>.Itr<V>() { // from class: com.google.common.collect.AbstractMapBasedMultimap.1
            @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
            Object a(Object obj, Object obj2) {
                return obj2;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.f83691g.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f83692h++;
            return true;
        }
        Collection collectionT = t(obj);
        if (!collectionT.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f83692h++;
        this.f83691g.put(obj, collectionT);
        return true;
    }

    Map r() {
        return this.f83691g;
    }

    abstract Collection s();

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f83692h;
    }

    Collection t(Object obj) {
        return s();
    }

    final Map u() {
        Map map = this.f83691g;
        return map instanceof NavigableMap ? new NavigableAsMap((NavigableMap) this.f83691g) : map instanceof SortedMap ? new SortedAsMap((SortedMap) this.f83691g) : new AsMap(this.f83691g);
    }

    final Set v() {
        Map map = this.f83691g;
        return map instanceof NavigableMap ? new NavigableKeySet((NavigableMap) this.f83691g) : map instanceof SortedMap ? new SortedKeySet((SortedMap) this.f83691g) : new KeySet(this.f83691g);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection values() {
        return super.values();
    }

    Collection w() {
        return A(s());
    }

    final void z(Map map) {
        this.f83691g = map;
        this.f83692h = 0;
        for (V v2 : map.values()) {
            Preconditions.d(!v2.isEmpty());
            this.f83692h += v2.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class WrappedCollection extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection f83717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WrappedCollection f83718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection f83719d;

        WrappedCollection(Object obj, Collection collection, WrappedCollection wrappedCollection) {
            this.f83716a = obj;
            this.f83717b = collection;
            this.f83718c = wrappedCollection;
            this.f83719d = wrappedCollection == null ? null : wrappedCollection.d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            WrappedCollection wrappedCollection = this.f83718c;
            if (wrappedCollection != null) {
                wrappedCollection.a();
            } else {
                AbstractMapBasedMultimap.this.f83691g.put(this.f83716a, this.f83717b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            f();
            boolean zIsEmpty = this.f83717b.isEmpty();
            boolean zAdd = this.f83717b.add(obj);
            if (zAdd) {
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f83717b.addAll(collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, this.f83717b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        WrappedCollection b() {
            return this.f83718c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f83717b.clear();
            AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            f();
            return this.f83717b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            f();
            return this.f83717b.containsAll(collection);
        }

        Collection d() {
            return this.f83717b;
        }

        Object e() {
            return this.f83716a;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f83717b.equals(obj);
        }

        void f() {
            Collection collection;
            WrappedCollection wrappedCollection = this.f83718c;
            if (wrappedCollection != null) {
                wrappedCollection.f();
                if (this.f83718c.d() != this.f83719d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f83717b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.f83691g.get(this.f83716a)) == null) {
                    return;
                }
                this.f83717b = collection;
            }
        }

        void g() {
            WrappedCollection wrappedCollection = this.f83718c;
            if (wrappedCollection != null) {
                wrappedCollection.g();
            } else if (this.f83717b.isEmpty()) {
                AbstractMapBasedMultimap.this.f83691g.remove(this.f83716a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f83717b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            f();
            return new WrappedIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f();
            boolean zRemove = this.f83717b.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
                g();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f83717b.removeAll(collection);
            if (zRemoveAll) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, this.f83717b.size() - size);
                g();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Preconditions.t(collection);
            int size = size();
            boolean zRetainAll = this.f83717b.retainAll(collection);
            if (zRetainAll) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, this.f83717b.size() - size);
                g();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f83717b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f83717b.toString();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class WrappedIterator implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f83721a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection f83722b;

            WrappedIterator() {
                Collection collection = WrappedCollection.this.f83717b;
                this.f83722b = collection;
                this.f83721a = AbstractMapBasedMultimap.x(collection);
            }

            Iterator a() {
                b();
                return this.f83721a;
            }

            void b() {
                WrappedCollection.this.f();
                if (WrappedCollection.this.f83717b != this.f83722b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f83721a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.f83721a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f83721a.remove();
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
                WrappedCollection.this.g();
            }

            WrappedIterator(Iterator it) {
                this.f83722b = WrappedCollection.this.f83717b;
                this.f83721a = it;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            private ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = WrappedList.this.isEmpty();
                c().add(obj);
                AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    WrappedList.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }

            public WrappedListIterator(int i3) {
                super(WrappedList.this.h().listIterator(i3));
            }
        }

        WrappedList(Object obj, List list, WrappedCollection wrappedCollection) {
            super(obj, list, wrappedCollection);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            f();
            boolean zIsEmpty = d().isEmpty();
            h().add(i3, obj);
            AbstractMapBasedMultimap.m(AbstractMapBasedMultimap.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = h().addAll(i3, collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this, d().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public Object get(int i3) {
            f();
            return h().get(i3);
        }

        List h() {
            return (List) d();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            f();
            return h().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            f();
            return h().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            f();
            return new WrappedListIterator();
        }

        @Override // java.util.List
        public Object remove(int i3) {
            f();
            Object objRemove = h().remove(i3);
            AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
            g();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            f();
            return h().set(i3, obj);
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            f();
            return AbstractMapBasedMultimap.this.C(e(), h().subList(i3, i4), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            f();
            return new WrappedListIterator(i3);
        }
    }
}
