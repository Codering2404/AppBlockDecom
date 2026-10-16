package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RangeMap f84800b = new RangeMap<Comparable<?>, Object>() { // from class: com.google.common.collect.TreeRangeMap.1
        @Override // com.google.common.collect.RangeMap
        public Map a() {
            return Collections.EMPTY_MAP;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NavigableMap f84801a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterable f84802a;

        AsMapOfRanges(Iterable iterable) {
            this.f84802a = iterable;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            return this.f84802a.iterator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            RangeMapEntry rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.f84801a.get(range.f84558a);
            if (rangeMapEntry == null || !rangeMapEntry.getKey().equals(range)) {
                return null;
            }
            return rangeMapEntry.getValue();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.this.f84801a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Range f84804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f84805b;

        RangeMapEntry(Cut cut, Cut cut2, Object obj) {
            this(Range.j(cut, cut2), obj);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Range getKey() {
            return this.f84804a;
        }

        Cut f() {
            return this.f84804a.f84558a;
        }

        Cut g() {
            return this.f84804a.f84559b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getValue() {
            return this.f84805b;
        }

        RangeMapEntry(Range range, Object obj) {
            this.f84804a = range;
            this.f84805b = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SubRangeMap implements RangeMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Range f84806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TreeRangeMap f84807b;

        /* JADX INFO: renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends TreeRangeMap<Comparable, Object>.SubRangeMap.SubRangeMapAsMap {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SubRangeMap f84808b;

            @Override // com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap
            Iterator b() {
                if (this.f84808b.f84806a.r()) {
                    return Iterators.m();
                }
                final Iterator<V> it = this.f84808b.f84807b.f84801a.headMap(this.f84808b.f84806a.f84559b, false).descendingMap().values().iterator();
                return new AbstractIterator<Map.Entry<Range<Comparable>, Object>>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.1.1

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f84810d;

                    {
                        this.f84810d = this;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Map.Entry a() {
                        if (!it.hasNext()) {
                            return (Map.Entry) b();
                        }
                        RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                        return rangeMapEntry.g().compareTo(this.f84810d.f84808b.f84806a.f84558a) <= 0 ? (Map.Entry) b() : Maps.u(rangeMapEntry.getKey().p(this.f84810d.f84808b.f84806a), rangeMapEntry.getValue());
                    }
                };
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            SubRangeMapAsMap() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c(Predicate predicate) {
                ArrayList arrayListI = Lists.i();
                for (Map.Entry entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        arrayListI.add((Range) entry.getKey());
                    }
                }
                int size = arrayListI.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListI.get(i3);
                    i3++;
                    SubRangeMap.this.f84807b.d((Range) obj);
                }
                return !arrayListI.isEmpty();
            }

            Iterator b() {
                if (SubRangeMap.this.f84806a.r()) {
                    return Iterators.m();
                }
                final Iterator<V> it = SubRangeMap.this.f84807b.f84801a.tailMap((Cut) MoreObjects.a((Cut) SubRangeMap.this.f84807b.f84801a.floorKey(SubRangeMap.this.f84806a.f84558a), SubRangeMap.this.f84806a.f84558a), true).values().iterator();
                return new AbstractIterator<Map.Entry<Range<K>, V>>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.3

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    final /* synthetic */ SubRangeMapAsMap f84815d;

                    {
                        this.f84815d = this;
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.common.collect.AbstractIterator
                    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                    public Map.Entry a() {
                        while (it.hasNext()) {
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                            if (rangeMapEntry.f().compareTo(SubRangeMap.this.f84806a.f84559b) >= 0) {
                                return (Map.Entry) b();
                            }
                            if (rangeMapEntry.g().compareTo(SubRangeMap.this.f84806a.f84558a) > 0) {
                                return Maps.u(rangeMapEntry.getKey().p(SubRangeMap.this.f84806a), rangeMapEntry.getValue());
                            }
                        }
                        return (Map.Entry) b();
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                SubRangeMap.this.c();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(Object obj) {
                return get(obj) != null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set entrySet() {
                return new Maps.EntrySet<Range<K>, V>() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2
                    @Override // com.google.common.collect.Maps.EntrySet
                    Map f() {
                        return SubRangeMapAsMap.this;
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean isEmpty() {
                        return !iterator().hasNext();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                    public Iterator iterator() {
                        return SubRangeMapAsMap.this.b();
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean retainAll(Collection collection) {
                        return SubRangeMapAsMap.this.c(Predicates.j(Predicates.g(collection)));
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public int size() {
                        return Iterators.L(iterator());
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Object get(Object obj) {
                RangeMapEntry rangeMapEntry;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (SubRangeMap.this.f84806a.l(range) && !range.r()) {
                            if (range.f84558a.compareTo(SubRangeMap.this.f84806a.f84558a) == 0) {
                                Map.Entry entryFloorEntry = SubRangeMap.this.f84807b.f84801a.floorEntry(range.f84558a);
                                rangeMapEntry = entryFloorEntry != null ? (RangeMapEntry) entryFloorEntry.getValue() : null;
                            } else {
                                rangeMapEntry = (RangeMapEntry) SubRangeMap.this.f84807b.f84801a.get(range.f84558a);
                            }
                            if (rangeMapEntry != null && rangeMapEntry.getKey().q(SubRangeMap.this.f84806a) && rangeMapEntry.getKey().p(SubRangeMap.this.f84806a).equals(range)) {
                                return rangeMapEntry.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set keySet() {
                return new Maps.KeySet<Range<K>, V>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1
                    @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(Object obj) {
                        return SubRangeMapAsMap.this.remove(obj) != null;
                    }

                    @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean retainAll(Collection collection) {
                        return SubRangeMapAsMap.this.c(Predicates.e(Predicates.j(Predicates.g(collection)), Maps.w()));
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Object remove(Object obj) {
                Object obj2 = get(obj);
                if (obj2 == null) {
                    return null;
                }
                Objects.requireNonNull(obj);
                SubRangeMap.this.f84807b.d((Range) obj);
                return obj2;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection values() {
                return new Maps.Values<Range<K>, V>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.4
                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public boolean removeAll(Collection collection) {
                        return SubRangeMapAsMap.this.c(Predicates.e(Predicates.g(collection), Maps.X()));
                    }

                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public boolean retainAll(Collection collection) {
                        return SubRangeMapAsMap.this.c(Predicates.e(Predicates.j(Predicates.g(collection)), Maps.X()));
                    }
                };
            }
        }

        @Override // com.google.common.collect.RangeMap
        public Map a() {
            return new SubRangeMapAsMap();
        }

        public void c() {
            this.f84807b.d(this.f84806a);
        }

        public boolean equals(Object obj) {
            if (obj instanceof RangeMap) {
                return a().equals(((RangeMap) obj).a());
            }
            return false;
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            return a().toString();
        }
    }

    private void c(Cut cut, Cut cut2, Object obj) {
        this.f84801a.put(cut, new RangeMapEntry(cut, cut2, obj));
    }

    @Override // com.google.common.collect.RangeMap
    public Map a() {
        return new AsMapOfRanges(this.f84801a.values());
    }

    public void d(Range range) {
        if (range.r()) {
            return;
        }
        Map.Entry entryLowerEntry = this.f84801a.lowerEntry(range.f84558a);
        if (entryLowerEntry != null) {
            RangeMapEntry rangeMapEntry = (RangeMapEntry) entryLowerEntry.getValue();
            if (rangeMapEntry.g().compareTo(range.f84558a) > 0) {
                if (rangeMapEntry.g().compareTo(range.f84559b) > 0) {
                    c(range.f84559b, rangeMapEntry.g(), ((RangeMapEntry) entryLowerEntry.getValue()).getValue());
                }
                c(rangeMapEntry.f(), range.f84558a, ((RangeMapEntry) entryLowerEntry.getValue()).getValue());
            }
        }
        Map.Entry entryLowerEntry2 = this.f84801a.lowerEntry(range.f84559b);
        if (entryLowerEntry2 != null) {
            RangeMapEntry rangeMapEntry2 = (RangeMapEntry) entryLowerEntry2.getValue();
            if (rangeMapEntry2.g().compareTo(range.f84559b) > 0) {
                c(range.f84559b, rangeMapEntry2.g(), ((RangeMapEntry) entryLowerEntry2.getValue()).getValue());
            }
        }
        this.f84801a.subMap(range.f84558a, range.f84559b).clear();
    }

    public boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return a().equals(((RangeMap) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return this.f84801a.values().toString();
    }
}
