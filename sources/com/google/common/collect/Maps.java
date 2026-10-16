package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Converter;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Maps {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map f84380d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Predicate f84381f;

        AbstractFilteredMap(Map map, Predicate predicate) {
            this.f84380d = map;
            this.f84381f = predicate;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection c() {
            return new FilteredMapValues(this, this.f84380d, this.f84381f);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f84380d.containsKey(obj) && d(obj, this.f84380d.get(obj));
        }

        boolean d(Object obj, Object obj2) {
            return this.f84381f.apply(Maps.u(obj, obj2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f84380d.get(obj);
            if (obj2 == null || !d(obj, obj2)) {
                return null;
            }
            return obj2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Preconditions.d(d(obj, obj2));
            return this.f84380d.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                Preconditions.d(d(entry.getKey(), entry.getValue()));
            }
            this.f84380d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (containsKey(obj)) {
                return this.f84380d.remove(obj);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Set f84382d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Function f84383f;

        AsMapView(Set set, Function function) {
            this.f84382d = (Set) Preconditions.t(set);
            this.f84383f = (Function) Preconditions.t(function);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set a() {
            return new EntrySet<K, V>() { // from class: com.google.common.collect.Maps.AsMapView.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                Map f() {
                    return AsMapView.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return Maps.k(AsMapView.this.d(), AsMapView.this.f84383f);
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        public Set g() {
            return Maps.G(d());
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection c() {
            return Collections2.j(this.f84382d, this.f84383f);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return d().contains(obj);
        }

        Set d() {
            return this.f84382d;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (Collections2.g(d(), obj)) {
                return this.f84383f.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (d().remove(obj)) {
                return this.f84383f.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return d().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BiMap f84385b;

        private static Object h(BiMap biMap, Object obj) {
            V v2 = biMap.get(obj);
            Preconditions.m(v2 != 0, "No non-null mapping present for input: %s", obj);
            return v2;
        }

        @Override // com.google.common.base.Converter
        protected Object d(Object obj) {
            return h(this.f84385b.u1(), obj);
        }

        @Override // com.google.common.base.Converter
        protected Object e(Object obj) {
            return h(this.f84385b, obj);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.f84385b.equals(((BiMapConverter) obj).f84385b);
            }
            return false;
        }

        public int hashCode() {
            return this.f84385b.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.f84385b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Comparator f84386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set f84387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient NavigableSet f84388c;

        DescendingMap() {
        }

        private static Ordering m2(Comparator comparator) {
            return Ordering.b(comparator).k();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public final Map k2() {
            return k2();
        }

        Set c2() {
            return new EntrySet<K, V>() { // from class: com.google.common.collect.Maps.DescendingMap.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                Map f() {
                    return DescendingMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return DescendingMap.this.g2();
                }
            };
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            return k2().floorEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return k2().floorKey(obj);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            Comparator comparator = this.f84386a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = k2().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.f();
            }
            Ordering orderingM2 = m2(comparator2);
            this.f84386a = orderingM2;
            return orderingM2;
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return k2().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return k2();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set entrySet() {
            Set set = this.f84387b;
            if (set != null) {
                return set;
            }
            Set setC2 = c2();
            this.f84387b = setC2;
            return setC2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            return k2().lastEntry();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return k2().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            return k2().ceilingEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return k2().ceilingKey(obj);
        }

        abstract Iterator g2();

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return k2().tailMap(obj, z2).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            return k2().lowerEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return k2().lowerKey(obj);
        }

        abstract NavigableMap k2();

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            return k2().firstEntry();
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return k2().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            return k2().higherEntry(obj);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return k2().higherKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            NavigableSet navigableSet = this.f84388c;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableKeySet navigableKeySet = new NavigableKeySet(this);
            this.f84388c = navigableKeySet;
            return navigableKeySet;
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return k2().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return k2().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return k2().subMap(obj2, z3, obj, z2).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return k2().headMap(obj, z2).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return b2();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Collection values() {
            return new Values(this);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object objJ = Maps.J(f(), key);
                if (Objects.a(objJ, entry.getValue()) && (objJ != null || f().containsKey(key))) {
                    return true;
                }
            }
            return false;
        }

        abstract Map f();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return f().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) Preconditions.t(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.o(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) Preconditions.t(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetJ = Sets.j(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetJ.add(((Map.Entry) obj).getKey());
                    }
                }
                return f().keySet().retainAll(hashSetJ);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EntryTransformer<K, V1, V2> {
        Object a(Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final BiMap f84393h;

        /* JADX INFO: renamed from: com.google.common.collect.Maps$FilteredEntryBiMap$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Predicate<Map.Entry<Object, Object>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Predicate f84394a;

            @Override // com.google.common.base.Predicate
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Map.Entry entry) {
                return this.f84394a.apply(Maps.u(entry.getValue(), entry.getKey()));
            }
        }

        @Override // com.google.common.collect.BiMap
        public BiMap u1() {
            return this.f84393h;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set values() {
            return this.f84393h.keySet();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Set f84395g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            private EntrySet() {
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(FilteredEntryMap.this.f84395g.iterator()) { // from class: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Override // com.google.common.collect.TransformedIterator
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Map.Entry a(final Map.Entry entry) {
                        return new ForwardingMapEntry<K, V>(this) { // from class: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1.1

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            final /* synthetic */ AnonymousClass1 f84399b;

                            {
                                this.f84399b = this;
                            }

                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                            /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
                            public Map.Entry k2() {
                                return entry;
                            }

                            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                            public Object setValue(Object obj) {
                                Preconditions.d(FilteredEntryMap.this.d(getKey(), obj));
                                return super.setValue(obj);
                            }
                        };
                    }
                };
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
            /* JADX INFO: renamed from: k2 */
            public Set k2() {
                return FilteredEntryMap.this.f84395g;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class KeySet extends KeySet<K, V> {
            KeySet() {
                super(FilteredEntryMap.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!FilteredEntryMap.this.containsKey(obj)) {
                    return false;
                }
                FilteredEntryMap.this.f84380d.remove(obj);
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                return FilteredEntryMap.e(filteredEntryMap.f84380d, filteredEntryMap.f84381f, collection);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                return FilteredEntryMap.f(filteredEntryMap.f84380d, filteredEntryMap.f84381f, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.k(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray(Object[] objArr) {
                return Lists.k(iterator()).toArray(objArr);
            }
        }

        FilteredEntryMap(Map map, Predicate predicate) {
            super(map, predicate);
            this.f84395g = Sets.d(map.entrySet(), this.f84381f);
        }

        static boolean e(Map map, Predicate predicate, Collection collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        static boolean f(Map map, Predicate predicate, Collection collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set a() {
            return new EntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        Set g() {
            return new KeySet();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap f84401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Predicate f84402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f84403c;

        FilteredEntryNavigableMap(NavigableMap navigableMap, Predicate predicate) {
            this.f84401a = (NavigableMap) Preconditions.t(navigableMap);
            this.f84402b = predicate;
            this.f84403c = new FilteredEntryMap(navigableMap, predicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            return Iterators.p(this.f84401a.entrySet().iterator(), this.f84402b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator b() {
            return Iterators.p(this.f84401a.descendingMap().entrySet().iterator(), this.f84402b);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f84403c.clear();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return this.f84401a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f84403c.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap descendingMap() {
            return Maps.q(this.f84401a.descendingMap(), this.f84402b);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set entrySet() {
            return this.f84403c.entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return this.f84403c.get(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return Maps.q(this.f84401a.headMap(obj, z2), this.f84402b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !Iterables.b(this.f84401a.entrySet(), this.f84402b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return new NavigableKeySet<K, V>(this) { // from class: com.google.common.collect.Maps.FilteredEntryNavigableMap.1
                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection collection) {
                    return FilteredEntryMap.e(FilteredEntryNavigableMap.this.f84401a, FilteredEntryNavigableMap.this.f84402b, collection);
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection collection) {
                    return FilteredEntryMap.f(FilteredEntryNavigableMap.this.f84401a, FilteredEntryNavigableMap.this.f84402b, collection);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return (Map.Entry) Iterables.o(this.f84401a.entrySet(), this.f84402b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return (Map.Entry) Iterables.o(this.f84401a.descendingMap().entrySet(), this.f84402b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return this.f84403c.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map map) {
            this.f84403c.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return this.f84403c.remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f84403c.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return Maps.q(this.f84401a.subMap(obj, z2, obj2, z3), this.f84402b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return Maps.q(this.f84401a.tailMap(obj, z2), this.f84402b);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection values() {
            return new FilteredMapValues(this, this.f84401a, this.f84402b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            SortedKeySet() {
                super();
            }

            @Override // java.util.SortedSet
            public Comparator comparator() {
                return FilteredEntrySortedMap.this.i().comparator();
            }

            @Override // java.util.SortedSet
            public Object first() {
                return FilteredEntrySortedMap.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet headSet(Object obj) {
                return (SortedSet) FilteredEntrySortedMap.this.headMap(obj).keySet();
            }

            @Override // java.util.SortedSet
            public Object last() {
                return FilteredEntrySortedMap.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet subSet(Object obj, Object obj2) {
                return (SortedSet) FilteredEntrySortedMap.this.subMap(obj, obj2).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet tailSet(Object obj) {
                return (SortedSet) FilteredEntrySortedMap.this.tailMap(obj).keySet();
            }
        }

        FilteredEntrySortedMap(SortedMap sortedMap, Predicate predicate) {
            super(sortedMap, predicate);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return h().iterator().next();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet g() {
            return new SortedKeySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet h() {
            return (SortedSet) super.h();
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return new FilteredEntrySortedMap(i().headMap(obj), this.f84381f);
        }

        SortedMap i() {
            return (SortedMap) this.f84380d;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            SortedMap<K, V> sortedMapI = i();
            while (true) {
                K kLastKey = sortedMapI.lastKey();
                if (d(kLastKey, NullnessCasts.a(this.f84380d.get(kLastKey)))) {
                    return kLastKey;
                }
                sortedMapI = i().headMap(kLastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return new FilteredEntrySortedMap(i().subMap(obj, obj2), this.f84381f);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return new FilteredEntrySortedMap(i().tailMap(obj), this.f84381f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Predicate f84406g;

        FilteredKeyMap(Map map, Predicate predicate, Predicate predicate2) {
            super(map, predicate2);
            this.f84406g = predicate;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set a() {
            return Sets.d(this.f84380d.entrySet(), this.f84381f);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        Set g() {
            return Sets.d(this.f84380d.keySet(), this.f84406g);
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f84380d.containsKey(obj) && this.f84406g.apply(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FilteredMapValues<K, V> extends Values<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f84407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Predicate f84408c;

        FilteredMapValues(Map map, Map map2, Predicate predicate) {
            super(map);
            this.f84407b = map2;
            this.f84408c = predicate;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            Iterator<Map.Entry<K, V>> it = this.f84407b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f84408c.apply(next) && Objects.a(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            Iterator<Map.Entry<K, V>> it = this.f84407b.entrySet().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f84408c.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Iterator<Map.Entry<K, V>> it = this.f84407b.entrySet().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f84408c.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.k(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return Lists.k(iterator()).toArray(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        IteratorBasedAbstractMap() {
        }

        abstract Iterator a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.e(a());
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set entrySet() {
            return new EntrySet<K, V>() { // from class: com.google.common.collect.Maps.IteratorBasedAbstractMap.1
                @Override // com.google.common.collect.Maps.EntrySet
                Map f() {
                    return IteratorBasedAbstractMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return IteratorBasedAbstractMap.this.a();
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f84410a;

        KeySet(Map map) {
            this.f84410a = (Map) Preconditions.t(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g().containsKey(obj);
        }

        /* JADX INFO: renamed from: f */
        Map g() {
            return this.f84410a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.x(g().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            g().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f84411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f84412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map f84413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map f84414d;

        @Override // com.google.common.collect.MapDifference
        public Map a() {
            return this.f84412b;
        }

        @Override // com.google.common.collect.MapDifference
        public Map b() {
            return this.f84411a;
        }

        @Override // com.google.common.collect.MapDifference
        public Map c() {
            return this.f84414d;
        }

        @Override // com.google.common.collect.MapDifference
        public Map d() {
            return this.f84413c;
        }

        public boolean e() {
            return this.f84411a.isEmpty() && this.f84412b.isEmpty() && this.f84414d.isEmpty();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MapDifference) {
                MapDifference mapDifference = (MapDifference) obj;
                if (b().equals(mapDifference.b()) && a().equals(mapDifference.a()) && d().equals(mapDifference.d()) && c().equals(mapDifference.c())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(b(), a(), d(), c());
        }

        public String toString() {
            if (e()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.f84411a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.f84411a);
            }
            if (!this.f84412b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.f84412b);
            }
            if (!this.f84414d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.f84414d);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableSet f84415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function f84416b;

        NavigableAsMapView(NavigableSet navigableSet, Function function) {
            this.f84415a = (NavigableSet) Preconditions.t(navigableSet);
            this.f84416b = (Function) Preconditions.t(function);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            return Maps.k(this.f84415a, this.f84416b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator b() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f84415a.clear();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return this.f84415a.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap descendingMap() {
            return Maps.i(this.f84415a.descendingSet(), this.f84416b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (Collections2.g(this.f84415a, obj)) {
                return this.f84416b.apply(obj);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return Maps.i(this.f84415a.headSet(obj, z2), this.f84416b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return Maps.F(this.f84415a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f84415a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return Maps.i(this.f84415a.subSet(obj, z2, obj2, z3), this.f84416b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return Maps.i(this.f84415a.tailSet(obj, z2), this.f84416b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        NavigableKeySet(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return f().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return f().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return f().floorKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.SortedKeySet
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap g() {
            return (NavigableMap) this.f84410a;
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return f().headMap(obj, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return f().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return f().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return Maps.y(f().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return Maps.y(f().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return f().subMap(obj, z2, obj2, z3).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return f().tailMap(obj, z2).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        SortedAsMapView(SortedSet sortedSet, Function function) {
            super(sortedSet, function);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return d().comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AsMapView
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public SortedSet d() {
            return (SortedSet) super.d();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return d().first();
        }

        @Override // java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return Maps.j(d().headSet(obj), this.f84383f);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set h() {
            return Maps.H(d());
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return d().last();
        }

        @Override // java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return Maps.j(d().subSet(obj, obj2), this.f84383f);
        }

        @Override // java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return Maps.j(d().tailSet(obj), this.f84383f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.KeySet
        public SortedMap g() {
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
    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap a() {
            return (SortedMap) super.a();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap b() {
            return (SortedMap) super.b();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap c() {
            return (SortedMap) super.c();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap d() {
            return (SortedMap) super.d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f84417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final EntryTransformer f84418b;

        TransformedEntriesMap(Map map, EntryTransformer entryTransformer) {
            this.f84417a = (Map) Preconditions.t(map);
            this.f84418b = (EntryTransformer) Preconditions.t(entryTransformer);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            return Iterators.N(this.f84417a.entrySet().iterator(), Maps.e(this.f84418b));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f84417a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f84417a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f84417a.get(obj);
            if (obj2 != null || this.f84417a.containsKey(obj)) {
                return this.f84418b.a(obj, NullnessCasts.a(obj2));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return this.f84417a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            if (this.f84417a.containsKey(obj)) {
                return this.f84418b.a(obj, NullnessCasts.a(this.f84417a.remove(obj)));
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f84417a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            return new Values(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        TransformedEntriesNavigableMap(NavigableMap navigableMap, EntryTransformer entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        private Map.Entry g(Map.Entry entry) {
            if (entry == null) {
                return null;
            }
            return Maps.P(this.f84418b, entry);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableMap b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            return g(b().ceilingEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return b().ceilingKey(obj);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return Maps.N(b().descendingMap(), this.f84418b);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            return g(b().firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            return g(b().floorEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return b().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            return g(b().higherEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return b().higherKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            return g(b().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            return g(b().lowerEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return b().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return b().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return g(b().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return g(b().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return Maps.N(b().headMap(obj, z2), this.f84418b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return Maps.N(b().subMap(obj, z2, obj2, z3), this.f84418b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return Maps.N(b().tailMap(obj, z2), this.f84418b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        TransformedEntriesSortedMap(SortedMap sortedMap, EntryTransformer entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        protected SortedMap b() {
            return (SortedMap) this.f84417a;
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return b().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return Maps.O(b().headMap(obj), this.f84418b);
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return b().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return Maps.O(b().subMap(obj, obj2), this.f84418b);
        }

        public SortedMap tailMap(Object obj) {
            return Maps.O(b().tailMap(obj), this.f84418b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f84419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiMap f84420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        BiMap f84421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set f84422d;

        UnmodifiableBiMap(BiMap biMap, BiMap biMap2) {
            this.f84419a = Collections.unmodifiableMap(biMap);
            this.f84420b = biMap;
            this.f84421c = biMap2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Map k2() {
            return this.f84419a;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap u1() {
            BiMap biMap = this.f84421c;
            if (biMap != null) {
                return biMap;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.f84420b.u1(), this);
            this.f84421c = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Set values() {
            Set set = this.f84422d;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.f84420b.values());
            this.f84422d = setUnmodifiableSet;
            return setUnmodifiableSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Collection f84423a;

        UnmodifiableEntries(Collection collection) {
            this.f84423a = collection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Collection k2() {
            return this.f84423a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.T(this.f84423a.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return b2();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return c2(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set set) {
            super(set);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.f(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap f84424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient UnmodifiableNavigableMap f84425b;

        UnmodifiableNavigableMap(NavigableMap navigableMap) {
            this.f84424a = navigableMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap
        /* JADX INFO: renamed from: c2, reason: merged with bridge method [inline-methods] */
        public SortedMap k2() {
            return Collections.unmodifiableSortedMap(this.f84424a);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            return Maps.W(this.f84424a.ceilingEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return this.f84424a.ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return Sets.q(this.f84424a.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            UnmodifiableNavigableMap unmodifiableNavigableMap = this.f84425b;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap unmodifiableNavigableMap2 = new UnmodifiableNavigableMap(this.f84424a.descendingMap(), this);
            this.f84425b = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            return Maps.W(this.f84424a.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            return Maps.W(this.f84424a.floorEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return this.f84424a.floorKey(obj);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            return Maps.W(this.f84424a.higherEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return this.f84424a.higherKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            return Maps.W(this.f84424a.lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            return Maps.W(this.f84424a.lowerEntry(obj));
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return this.f84424a.lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return Sets.q(this.f84424a.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return Maps.V(this.f84424a.headMap(obj, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return Maps.V(this.f84424a.subMap(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return Maps.V(this.f84424a.tailMap(obj, z2));
        }

        UnmodifiableNavigableMap(NavigableMap navigableMap, UnmodifiableNavigableMap unmodifiableNavigableMap) {
            this.f84424a = navigableMap;
            this.f84425b = unmodifiableNavigableMap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f84427b;

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public Object a() {
            return this.f84426a;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public Object b() {
            return this.f84427b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof MapDifference.ValueDifference) {
                MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
                if (Objects.a(this.f84426a, valueDifference.a()) && Objects.a(this.f84427b, valueDifference.b())) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.b(this.f84426a, this.f84427b);
        }

        public String toString() {
            return "(" + this.f84426a + ", " + this.f84427b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Values<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map f84428a;

        Values(Map map) {
            this.f84428a = (Map) Preconditions.t(map);
        }

        final Map a() {
            return this.f84428a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return Maps.Y(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (Objects.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) Preconditions.t(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetI = Sets.i();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetI.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetI);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) Preconditions.t(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetI = Sets.i();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetI.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetI);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set f84429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Set f84430b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private transient Collection f84431c;

        ViewCachingAbstractMap() {
        }

        abstract Set a();

        /* JADX INFO: renamed from: b */
        Set g() {
            return new KeySet(this);
        }

        Collection c() {
            return new Values(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.f84429a;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.f84429a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set h() {
            Set set = this.f84430b;
            if (set != null) {
                return set;
            }
            Set setG = g();
            this.f84430b = setG;
            return setG;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Collection values() {
            Collection collection = this.f84431c;
            if (collection != null) {
                return collection;
            }
            Collection collectionC = c();
            this.f84431c = collectionC;
            return collectionC;
        }
    }

    public static HashMap A() {
        return new HashMap();
    }

    public static IdentityHashMap B() {
        return new IdentityHashMap();
    }

    public static LinkedHashMap C() {
        return new LinkedHashMap();
    }

    public static LinkedHashMap D(int i3) {
        return new LinkedHashMap(m(i3));
    }

    static boolean E(Collection collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.remove(S((Map.Entry) obj));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NavigableSet F(final NavigableSet navigableSet) {
        return new ForwardingNavigableSet<Object>() { // from class: com.google.common.collect.Maps.6
            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
            public boolean add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
            public boolean addAll(Collection collection) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet descendingSet() {
                return Maps.F(super.descendingSet());
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet headSet(Object obj) {
                return Maps.H(super.headSet(obj));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet
            /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public NavigableSet o2() {
                return navigableSet;
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet subSet(Object obj, Object obj2) {
                return Maps.H(super.subSet(obj, obj2));
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet tailSet(Object obj) {
                return Maps.H(super.tailSet(obj));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet headSet(Object obj, boolean z2) {
                return Maps.F(super.headSet(obj, z2));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
                return Maps.F(super.subSet(obj, z2, obj2, z3));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet tailSet(Object obj, boolean z2) {
                return Maps.F(super.tailSet(obj, z2));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set G(final Set set) {
        return new ForwardingSet<Object>() { // from class: com.google.common.collect.Maps.4
            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
            public boolean add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
            public boolean addAll(Collection collection) {
                throw new UnsupportedOperationException();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
            /* JADX INFO: renamed from: k2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Set k2() {
                return set;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SortedSet H(final SortedSet sortedSet) {
        return new ForwardingSortedSet<Object>() { // from class: com.google.common.collect.Maps.5
            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
            public boolean add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
            public boolean addAll(Collection collection) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet headSet(Object obj) {
                return Maps.H(super.headSet(obj));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet
            public SortedSet o2() {
                return sortedSet;
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet subSet(Object obj, Object obj2) {
                return Maps.H(super.subSet(obj, obj2));
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet tailSet(Object obj) {
                return Maps.H(super.tailSet(obj));
            }
        };
    }

    static boolean I(Map map, Object obj) {
        Preconditions.t(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static Object J(Map map, Object obj) {
        Preconditions.t(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static Object K(Map map, Object obj) {
        Preconditions.t(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static String L(Map map) {
        StringBuilder sbF = Collections2.f(map.size());
        sbF.append('{');
        boolean z2 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z2) {
                sbF.append(", ");
            }
            sbF.append(entry.getKey());
            sbF.append('=');
            sbF.append(entry.getValue());
            z2 = false;
        }
        sbF.append('}');
        return sbF.toString();
    }

    public static Map M(Map map, EntryTransformer entryTransformer) {
        return new TransformedEntriesMap(map, entryTransformer);
    }

    public static NavigableMap N(NavigableMap navigableMap, EntryTransformer entryTransformer) {
        return new TransformedEntriesNavigableMap(navigableMap, entryTransformer);
    }

    public static SortedMap O(SortedMap sortedMap, EntryTransformer entryTransformer) {
        return new TransformedEntriesSortedMap(sortedMap, entryTransformer);
    }

    static Map.Entry P(final EntryTransformer entryTransformer, final Map.Entry entry) {
        Preconditions.t(entryTransformer);
        Preconditions.t(entry);
        return new AbstractMapEntry<Object, Object>() { // from class: com.google.common.collect.Maps.12
            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public Object getKey() {
                return entry.getKey();
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public Object getValue() {
                return entryTransformer.a(entry.getKey(), entry.getValue());
            }
        };
    }

    public static Map Q(Map map, Function function) {
        return M(map, g(function));
    }

    public static SortedMap R(SortedMap sortedMap, Function function) {
        return O(sortedMap, g(function));
    }

    static Map.Entry S(final Map.Entry entry) {
        Preconditions.t(entry);
        return new AbstractMapEntry<Object, Object>() { // from class: com.google.common.collect.Maps.7
            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public Object getKey() {
                return entry.getKey();
            }

            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public Object getValue() {
                return entry.getValue();
            }
        };
    }

    static UnmodifiableIterator T(final Iterator it) {
        return new UnmodifiableIterator<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.Maps.8
            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return Maps.S((Map.Entry) it.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }
        };
    }

    static Set U(Set set) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(set));
    }

    public static NavigableMap V(NavigableMap navigableMap) {
        Preconditions.t(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map.Entry W(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return S(entry);
    }

    static Function X() {
        return EntryFunction.VALUE;
    }

    static Iterator Y(Iterator it) {
        return new TransformedIterator<Map.Entry<Object, Object>, Object>(it) { // from class: com.google.common.collect.Maps.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.TransformedIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object a(Map.Entry entry) {
                return entry.getValue();
            }
        };
    }

    static Object Z(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    static Predicate a0(Predicate predicate) {
        return Predicates.e(predicate, X());
    }

    static Function e(final EntryTransformer entryTransformer) {
        Preconditions.t(entryTransformer);
        return new Function<Map.Entry<Object, Object>, Map.Entry<Object, Object>>() { // from class: com.google.common.collect.Maps.13
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry apply(Map.Entry entry) {
                return Maps.P(entryTransformer, entry);
            }
        };
    }

    static Function f(final EntryTransformer entryTransformer) {
        Preconditions.t(entryTransformer);
        return new Function<Map.Entry<Object, Object>, Object>() { // from class: com.google.common.collect.Maps.11
            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entryTransformer.a(entry.getKey(), entry.getValue());
            }
        };
    }

    static EntryTransformer g(final Function function) {
        Preconditions.t(function);
        return new EntryTransformer<Object, Object, Object>() { // from class: com.google.common.collect.Maps.9
            @Override // com.google.common.collect.Maps.EntryTransformer
            public Object a(Object obj, Object obj2) {
                return function.apply(obj2);
            }
        };
    }

    public static Map h(Set set, Function function) {
        return new AsMapView(set, function);
    }

    public static NavigableMap i(NavigableSet navigableSet, Function function) {
        return new NavigableAsMapView(navigableSet, function);
    }

    public static SortedMap j(SortedSet sortedSet, Function function) {
        return new SortedAsMapView(sortedSet, function);
    }

    static Iterator k(Set set, final Function function) {
        return new TransformedIterator<Object, Map.Entry<Object, Object>>(set.iterator()) { // from class: com.google.common.collect.Maps.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.TransformedIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry a(Object obj) {
                return Maps.u(obj, function.apply(obj));
            }
        };
    }

    static Function l(final EntryTransformer entryTransformer, final Object obj) {
        Preconditions.t(entryTransformer);
        return new Function<Object, Object>() { // from class: com.google.common.collect.Maps.10
            @Override // com.google.common.base.Function
            public Object apply(Object obj2) {
                return entryTransformer.a(obj, obj2);
            }
        };
    }

    static int m(int i3) {
        if (i3 >= 3) {
            return i3 < 1073741824 ? (int) Math.ceil(((double) i3) / 0.75d) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        CollectPreconditions.b(i3, "expectedSize");
        return i3 + 1;
    }

    static boolean n(Collection collection, Object obj) {
        if (obj instanceof Map.Entry) {
            return collection.contains(S((Map.Entry) obj));
        }
        return false;
    }

    static boolean o(Map map, Object obj) {
        return Iterators.j(Y(map.entrySet().iterator()), obj);
    }

    static boolean p(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static NavigableMap q(NavigableMap navigableMap, Predicate predicate) {
        Preconditions.t(predicate);
        return navigableMap instanceof FilteredEntryNavigableMap ? s((FilteredEntryNavigableMap) navigableMap, predicate) : new FilteredEntryNavigableMap((NavigableMap) Preconditions.t(navigableMap), predicate);
    }

    private static Map r(AbstractFilteredMap abstractFilteredMap, Predicate predicate) {
        return new FilteredEntryMap(abstractFilteredMap.f84380d, Predicates.c(abstractFilteredMap.f84381f, predicate));
    }

    private static NavigableMap s(FilteredEntryNavigableMap filteredEntryNavigableMap, Predicate predicate) {
        return new FilteredEntryNavigableMap(filteredEntryNavigableMap.f84401a, Predicates.c(filteredEntryNavigableMap.f84402b, predicate));
    }

    public static Map t(Map map, Predicate predicate) {
        Preconditions.t(predicate);
        Predicate predicateZ = z(predicate);
        return map instanceof AbstractFilteredMap ? r((AbstractFilteredMap) map, predicateZ) : new FilteredKeyMap((Map) Preconditions.t(map), predicate, predicateZ);
    }

    public static Map.Entry u(Object obj, Object obj2) {
        return new ImmutableEntry(obj, obj2);
    }

    static ImmutableMap v(Collection collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            builder.g(it.next(), Integer.valueOf(i3));
            i3++;
        }
        return builder.d();
    }

    static Function w() {
        return EntryFunction.KEY;
    }

    static Iterator x(Iterator it) {
        return new TransformedIterator<Map.Entry<Object, Object>, Object>(it) { // from class: com.google.common.collect.Maps.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.TransformedIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Object a(Map.Entry entry) {
                return entry.getKey();
            }
        };
    }

    static Object y(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    static Predicate z(Predicate predicate) {
        return Predicates.e(predicate, w());
    }
}
