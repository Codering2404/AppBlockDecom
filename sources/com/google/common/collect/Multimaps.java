package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Multimaps {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Multimap f84470d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class EntrySet extends Maps.EntrySet<K, Collection<V>> {
            EntrySet() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            Map f() {
                return AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.k(AsMap.this.f84470d.keySet(), new Function() { // from class: com.google.common.collect.c0
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return Multimaps.AsMap.this.f84470d.get(obj);
                    }
                });
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AsMap.this.g(entry.getKey());
                return true;
            }
        }

        AsMap(Multimap multimap) {
            this.f84470d = (Multimap) Preconditions.t(multimap);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set a() {
            return new EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f84470d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f84470d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            if (containsKey(obj)) {
                return this.f84470d.get(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            if (containsKey(obj)) {
                return this.f84470d.a(obj);
            }
            return null;
        }

        void g(Object obj) {
            this.f84470d.keySet().remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f84470d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set h() {
            return this.f84470d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f84470d.keySet().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient Supplier f84472i;

        CustomListMultimap(Map map, Supplier supplier) {
            super(map);
            this.f84472i = (Supplier) Preconditions.t(supplier);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            this.f84472i = (Supplier) object;
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            z((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f84472i);
            objectOutputStream.writeObject(r());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        /* JADX INFO: renamed from: D */
        public List s() {
            return (List) this.f84472i.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map c() {
            return u();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set e() {
            return v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient Supplier f84473i;

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            this.f84473i = (Supplier) object;
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            z((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f84473i);
            objectOutputStream.writeObject(r());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        Collection A(Collection collection) {
            return collection instanceof NavigableSet ? Sets.q((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        Collection B(Object obj, Collection collection) {
            return collection instanceof List ? C(obj, (List) collection, null) : collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(obj, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.WrappedSortedSet(obj, (SortedSet) collection, null) : collection instanceof Set ? new AbstractMapBasedMultimap.WrappedSet(obj, (Set) collection) : new AbstractMapBasedMultimap.WrappedCollection(obj, collection, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map c() {
            return u();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set e() {
            return v();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        protected Collection s() {
            return (Collection) this.f84473i.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient Supplier f84474i;

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            this.f84474i = (Supplier) object;
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            z((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f84474i);
            objectOutputStream.writeObject(r());
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        Collection A(Collection collection) {
            return collection instanceof NavigableSet ? Sets.q((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        Collection B(Object obj, Collection collection) {
            return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(obj, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.WrappedSortedSet(obj, (SortedSet) collection, null) : new AbstractMapBasedMultimap.WrappedSet(obj, (Set) collection);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        /* JADX INFO: renamed from: D */
        public Set s() {
            return (Set) this.f84474i.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map c() {
            return u();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set e() {
            return v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient Supplier f84475i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        transient Comparator f84476j;

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            Objects.requireNonNull(object);
            Supplier supplier = (Supplier) object;
            this.f84475i = supplier;
            this.f84476j = ((SortedSet) supplier.get()).comparator();
            Object object2 = objectInputStream.readObject();
            Objects.requireNonNull(object2);
            z((Map) object2);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.f84475i);
            objectOutputStream.writeObject(r());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public SortedSet s() {
            return (SortedSet) this.f84475i.get();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Map c() {
            return u();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        Set e() {
            return v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        Entries() {
        }

        abstract Multimap a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().w1(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Keys<K, V> extends AbstractMultiset<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Multimap f84477c;

        Keys(Multimap multimap) {
            this.f84477c = multimap;
        }

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            Collection collection = (Collection) Maps.J(this.f84477c.a1(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f84477c.clear();
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public boolean contains(Object obj) {
            return this.f84477c.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultiset
        int d() {
            return this.f84477c.a1().size();
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator e() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        Iterator f() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this.f84477c.a1().entrySet().iterator()) { // from class: com.google.common.collect.Multimaps.Keys.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Multiset.Entry a(final Map.Entry entry) {
                    return new Multisets.AbstractEntry<K>(this) { // from class: com.google.common.collect.Multimaps.Keys.1.1

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f84480b;

                        {
                            this.f84480b = this;
                        }

                        @Override // com.google.common.collect.Multiset.Entry
                        public Object a() {
                            return entry.getKey();
                        }

                        @Override // com.google.common.collect.Multiset.Entry
                        public int getCount() {
                            return ((Collection) entry.getValue()).size();
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set i() {
            return this.f84477c.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
        public Iterator iterator() {
            return Maps.x(this.f84477c.b().iterator());
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int o1(Object obj, int i3) {
            CollectPreconditions.b(i3, "occurrences");
            if (i3 == 0) {
                return Y1(obj);
            }
            Collection collection = (Collection) Maps.J(this.f84477c.a1(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i3 >= size) {
                collection.clear();
                return size;
            }
            Iterator it = collection.iterator();
            for (int i4 = 0; i4 < i3; i4++) {
                it.next();
                it.remove();
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return this.f84477c.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Map f84481g;

        @Override // com.google.common.collect.AbstractMultimap
        Map c() {
            return new AsMap(this);
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f84481g.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.f84481g.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            return this.f84481g.containsValue(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection d() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.AbstractMultimap
        Set e() {
            return this.f84481g.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Multiset g() {
            return new Keys(this);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection h() {
            return this.f84481g.values();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public int hashCode() {
            return this.f84481g.hashCode();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Iterator i() {
            return this.f84481g.entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return this.f84481g.entrySet().remove(Maps.u(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f84481g.size();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean w1(Object obj, Object obj2) {
            return this.f84481g.entrySet().contains(Maps.u(obj, obj2));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set a(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.f84481g.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.f84481g.remove(obj));
            return hashSet;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public Set b() {
            return this.f84481g.entrySet();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(final Object obj) {
            return new Sets.ImprovedAbstractSet<V>(this) { // from class: com.google.common.collect.Multimaps.MapMultimap.1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ MapMultimap f84483b;

                {
                    this.f84483b = this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new Iterator<V>() { // from class: com.google.common.collect.Multimaps.MapMultimap.1.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f84484a;

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            if (this.f84484a != 0) {
                                return false;
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            return anonymousClass1.f84483b.f84481g.containsKey(obj);
                        }

                        @Override // java.util.Iterator
                        public Object next() {
                            if (!hasNext()) {
                                throw new NoSuchElementException();
                            }
                            this.f84484a++;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            return NullnessCasts.a(anonymousClass1.f84483b.f84481g.get(obj));
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            CollectPreconditions.e(this.f84484a == 1);
                            this.f84484a = -1;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            anonymousClass1.f84483b.f84481g.remove(obj);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return this.f84483b.f84481g.containsKey(obj) ? 1 : 0;
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
        TransformedEntriesListMultimap(ListMultimap listMultimap, Maps.EntryTransformer entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public List l(Object obj, Collection collection) {
            return Lists.p((List) collection, Maps.l(this.f84487h, obj));
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List a(Object obj) {
            return l(obj, this.f84486g.a(obj));
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            return l(obj, this.f84486g.get(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Multimap f84486g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Maps.EntryTransformer f84487h;

        TransformedEntriesMultimap(Multimap multimap, Maps.EntryTransformer entryTransformer) {
            this.f84486g = (Multimap) Preconditions.t(multimap);
            this.f84487h = (Maps.EntryTransformer) Preconditions.t(entryTransformer);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection a(Object obj) {
            return l(obj, this.f84486g.a(obj));
        }

        @Override // com.google.common.collect.AbstractMultimap
        Map c() {
            return Maps.M(this.f84486g.a1(), new Maps.EntryTransformer() { // from class: com.google.common.collect.d0
                @Override // com.google.common.collect.Maps.EntryTransformer
                public final Object a(Object obj, Object obj2) {
                    return this.f84867a.l(obj, (Collection) obj2);
                }
            });
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            this.f84486g.clear();
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            return this.f84486g.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection d() {
            return new AbstractMultimap.Entries();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Set e() {
            return this.f84486g.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        Multiset g() {
            return this.f84486g.keys();
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection get(Object obj) {
            return l(obj, this.f84486g.get(obj));
        }

        @Override // com.google.common.collect.AbstractMultimap
        Collection h() {
            return Collections2.j(this.f84486g.b(), Maps.f(this.f84487h));
        }

        @Override // com.google.common.collect.AbstractMultimap
        Iterator i() {
            return Iterators.N(this.f84486g.b().iterator(), Maps.e(this.f84487h));
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean isEmpty() {
            return this.f84486g.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Collection l(Object obj, Collection collection) {
            Function functionL = Maps.l(this.f84487h, obj);
            return collection instanceof List ? Lists.p((List) collection, functionL) : Collections2.j(collection, functionL);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            return this.f84486g.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap
        /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public ListMultimap I1() {
            return (ListMultimap) super.I1();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            return Collections.unmodifiableList(k2().get(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Multimap f84488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        transient Collection f84489b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient Multiset f84490c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set f84491d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Collection f84492f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient Map f84493g;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public Multimap k2() {
            return this.f84488a;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Map a1() {
            Map map = this.f84493g;
            if (map != null) {
                return map;
            }
            Map mapUnmodifiableMap = Collections.unmodifiableMap(Maps.Q(this.f84488a.a1(), new Function() { // from class: com.google.common.collect.e0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return Multimaps.h((Collection) obj);
                }
            }));
            this.f84493g = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection b() {
            Collection collection = this.f84489b;
            if (collection != null) {
                return collection;
            }
            Collection collectionG = Multimaps.g(this.f84488a.b());
            this.f84489b = collectionG;
            return collectionG;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection get(Object obj) {
            return Multimaps.h(this.f84488a.get(obj));
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set keySet() {
            Set set = this.f84491d;
            if (set != null) {
                return set;
            }
            Set setUnmodifiableSet = Collections.unmodifiableSet(this.f84488a.keySet());
            this.f84491d = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Multiset keys() {
            Multiset multiset = this.f84490c;
            if (multiset != null) {
                return multiset;
            }
            Multiset multisetP = Multisets.p(this.f84488a.keys());
            this.f84490c = multisetP;
            return multisetP;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection values() {
            Collection collection = this.f84492f;
            if (collection != null) {
                return collection;
            }
            Collection collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.f84488a.values());
            this.f84492f = collectionUnmodifiableCollection;
            return collectionUnmodifiableCollection;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap
        /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
        public SetMultimap I1() {
            return (SetMultimap) super.I1();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Set b() {
            return Maps.U(I1().b());
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(Object obj) {
            return Collections.unmodifiableSet(I1().get(obj));
        }
    }

    static boolean c(Multimap multimap, Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.a1().equals(((Multimap) obj).a1());
        }
        return false;
    }

    public static ListMultimap d(Map map, Supplier supplier) {
        return new CustomListMultimap(map, supplier);
    }

    public static ListMultimap e(ListMultimap listMultimap, Maps.EntryTransformer entryTransformer) {
        return new TransformedEntriesListMultimap(listMultimap, entryTransformer);
    }

    public static ListMultimap f(ListMultimap listMultimap, Function function) {
        Preconditions.t(function);
        return e(listMultimap, Maps.g(function));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection g(Collection collection) {
        return collection instanceof Set ? Maps.U((Set) collection) : new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(collection));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection h(Collection collection) {
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap
        /* JADX INFO: renamed from: V1, reason: merged with bridge method [inline-methods] */
        public SortedSetMultimap I1() {
            return (SortedSetMultimap) super.I1();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet a(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet get(Object obj) {
            return Collections.unmodifiableSortedSet(I1().get(obj));
        }
    }
}
