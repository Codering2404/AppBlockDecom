package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multisets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Multimap f83928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Predicate f83929h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        AsMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set a() {
            return new Maps.EntrySet<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                Map f() {
                    return AsMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl.1

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final Iterator f83932c;

                        {
                            this.f83932c = FilteredEntryMultimap.this.f83928g.a1().entrySet().iterator();
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                        public Map.Entry a() {
                            while (this.f83932c.hasNext()) {
                                Map.Entry entry = (Map.Entry) this.f83932c.next();
                                Object key = entry.getKey();
                                Collection collectionL = FilteredEntryMultimap.l((Collection) entry.getValue(), new ValuePredicate(key));
                                if (!collectionL.isEmpty()) {
                                    return Maps.u(key, collectionL);
                                }
                            }
                            return (Map.Entry) b();
                        }
                    };
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection collection) {
                    return FilteredEntryMultimap.this.m(Predicates.g(collection));
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection collection) {
                    return FilteredEntryMultimap.this.m(Predicates.j(Predicates.g(collection)));
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.L(iterator());
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        Set g() {
            return new Maps.KeySet<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1KeySetImpl
                @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    return AsMap.this.remove(obj) != null;
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection collection) {
                    return FilteredEntryMultimap.this.m(Maps.z(Predicates.g(collection)));
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection collection) {
                    return FilteredEntryMultimap.this.m(Maps.z(Predicates.j(Predicates.g(collection))));
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection c() {
            return new Maps.Values<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1ValuesImpl
                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean remove(Object obj) {
                    if (!(obj instanceof Collection)) {
                        return false;
                    }
                    Collection collection = (Collection) obj;
                    Iterator<Map.Entry<K, V>> it = FilteredEntryMultimap.this.f83928g.a1().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<K, V> next = it.next();
                        Collection collectionL = FilteredEntryMultimap.l((Collection) next.getValue(), new ValuePredicate(next.getKey()));
                        if (!collectionL.isEmpty() && collection.equals(collectionL)) {
                            if (collectionL.size() == ((Collection) next.getValue()).size()) {
                                it.remove();
                                return true;
                            }
                            collectionL.clear();
                            return true;
                        }
                    }
                    return false;
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection collection) {
                    return FilteredEntryMultimap.this.m(Maps.a0(Predicates.g(collection)));
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection collection) {
                    return FilteredEntryMultimap.this.m(Maps.a0(Predicates.j(Predicates.g(collection))));
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) FilteredEntryMultimap.this.f83928g.a1().get(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionL = FilteredEntryMultimap.l(collection, new ValuePredicate(obj));
            if (collectionL.isEmpty()) {
                return null;
            }
            return collectionL;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) FilteredEntryMultimap.this.f83928g.a1().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList arrayListI = Lists.i();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (FilteredEntryMultimap.this.n(obj, next)) {
                    it.remove();
                    arrayListI.add(next);
                }
            }
            if (arrayListI.isEmpty()) {
                return null;
            }
            return FilteredEntryMultimap.this.f83928g instanceof SetMultimap ? Collections.unmodifiableSet(Sets.m(arrayListI)) : Collections.unmodifiableList(arrayListI);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Keys extends Multimaps.Keys<K, V> {

        /* JADX INFO: renamed from: com.google.common.collect.FilteredEntryMultimap$Keys$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends Multisets.EntrySet<K> {
            AnonymousClass1() {
            }

            private boolean h(final Predicate predicate) {
                return FilteredEntryMultimap.this.m(new Predicate() { // from class: com.google.common.collect.q
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        Map.Entry entry = (Map.Entry) obj;
                        return predicate.apply(Multisets.h(entry.getKey(), ((Collection) entry.getValue()).size()));
                    }
                });
            }

            @Override // com.google.common.collect.Multisets.EntrySet
            Multiset f() {
                return Keys.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Keys.this.f();
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                return h(Predicates.g(collection));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return h(Predicates.j(Predicates.g(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return FilteredEntryMultimap.this.keySet().size();
            }
        }

        Keys() {
            super(FilteredEntryMultimap.this);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set entrySet() {
            return new AnonymousClass1();
        }

        @Override // com.google.common.collect.Multimaps.Keys, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int o1(Object obj, int i3) {
            CollectPreconditions.b(i3, "occurrences");
            if (i3 == 0) {
                return Y1(obj);
            }
            Collection collection = (Collection) FilteredEntryMultimap.this.f83928g.a1().get(obj);
            int i4 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (FilteredEntryMultimap.this.n(obj, it.next()) && (i4 = i4 + 1) <= i3) {
                    it.remove();
                }
            }
            return i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValuePredicate implements Predicate<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f83938a;

        ValuePredicate(Object obj) {
            this.f83938a = obj;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(Object obj) {
            return FilteredEntryMultimap.this.n(this.f83938a, obj);
        }
    }

    static Collection l(Collection collection, Predicate predicate) {
        return collection instanceof Set ? Sets.d((Set) collection, predicate) : Collections2.d(collection, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(Object obj, Object obj2) {
        return this.f83929h.apply(Maps.u(obj, obj2));
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate R0() {
        return this.f83929h;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection a(Object obj) {
        return (Collection) MoreObjects.a((Collection) a1().remove(obj), o());
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map c() {
        return new AsMap();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        b().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return a1().get(obj) != null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection d() {
        return l(this.f83928g.b(), this.f83929h);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set e() {
        return a1().keySet();
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Multimap f() {
        return this.f83928g;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset g() {
        return new Keys();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection get(Object obj) {
        return l(this.f83928g.get(obj), new ValuePredicate(obj));
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection h() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator i() {
        throw new AssertionError("should never be called");
    }

    boolean m(Predicate predicate) {
        Iterator<Map.Entry<K, V>> it = this.f83928g.a1().entrySet().iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            K key = next.getKey();
            Collection collectionL = l((Collection) next.getValue(), new ValuePredicate(key));
            if (!collectionL.isEmpty() && predicate.apply(Maps.u(key, collectionL))) {
                if (collectionL.size() == ((Collection) next.getValue()).size()) {
                    it.remove();
                } else {
                    collectionL.clear();
                }
                z2 = true;
            }
        }
        return z2;
    }

    Collection o() {
        return this.f83928g instanceof SetMultimap ? Collections.EMPTY_SET : Collections.EMPTY_LIST;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return b().size();
    }
}
