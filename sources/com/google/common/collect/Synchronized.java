package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Synchronized {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient Set f84721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        transient Collection f84722h;

        SynchronizedAsMap(Map map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set entrySet() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84721g == null) {
                        this.f84721g = new SynchronizedAsMapEntries(g().entrySet(), this.f84744b);
                    }
                    set = this.f84721g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection values() {
            Collection collection;
            synchronized (this.f84744b) {
                try {
                    if (this.f84722h == null) {
                        this.f84722h = new SynchronizedAsMapValues(g().values(), this.f84744b);
                    }
                    collection = this.f84722h;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection get(Object obj) {
            Collection collectionQ;
            synchronized (this.f84744b) {
                Collection collection = (Collection) super.get(obj);
                collectionQ = collection == null ? null : Synchronized.q(collection, this.f84744b);
            }
            return collectionQ;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Collection a(Collection collection) {
                    return Synchronized.q(collection, SynchronizedAsMapValues.this.f84744b);
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private transient Set f84727g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private transient BiMap f84728h;

        private SynchronizedBiMap(BiMap biMap, Object obj, BiMap biMap2) {
            super(biMap, obj);
            this.f84728h = biMap2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public BiMap g() {
            return (BiMap) super.g();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap u1() {
            BiMap biMap;
            synchronized (this.f84744b) {
                try {
                    if (this.f84728h == null) {
                        this.f84728h = new SynchronizedBiMap(e().u1(), this.f84744b, this);
                    }
                    biMap = this.f84728h;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return biMap;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set values() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84727g == null) {
                        this.f84727g = Synchronized.n(e().values(), this.f84744b);
                    }
                    set = this.f84727g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Collection
        public boolean add(Object obj) {
            boolean zAdd;
            synchronized (this.f84744b) {
                zAdd = g().add(obj);
            }
            return zAdd;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            boolean zAddAll;
            synchronized (this.f84744b) {
                zAddAll = g().addAll(collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.f84744b) {
                g().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean zContains;
            synchronized (this.f84744b) {
                zContains = g().contains(obj);
            }
            return zContains;
        }

        public boolean containsAll(Collection collection) {
            boolean zContainsAll;
            synchronized (this.f84744b) {
                zContainsAll = g().containsAll(collection);
            }
            return zContainsAll;
        }

        /* JADX INFO: renamed from: e */
        Collection g() {
            return (Collection) super.d();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f84744b) {
                zIsEmpty = g().isEmpty();
            }
            return zIsEmpty;
        }

        public Iterator iterator() {
            return g().iterator();
        }

        public boolean remove(Object obj) {
            boolean zRemove;
            synchronized (this.f84744b) {
                zRemove = g().remove(obj);
            }
            return zRemove;
        }

        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            synchronized (this.f84744b) {
                zRemoveAll = g().removeAll(collection);
            }
            return zRemoveAll;
        }

        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            synchronized (this.f84744b) {
                zRetainAll = g().retainAll(collection);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.f84744b) {
                size = g().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.f84744b) {
                array = g().toArray();
            }
            return array;
        }

        private SynchronizedCollection(Collection collection, Object obj) {
            super(collection, obj);
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array;
            synchronized (this.f84744b) {
                array = g().toArray(objArr);
            }
            return array;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Deque
        public void addFirst(Object obj) {
            synchronized (this.f84744b) {
                e().addFirst(obj);
            }
        }

        @Override // java.util.Deque
        public void addLast(Object obj) {
            synchronized (this.f84744b) {
                e().addLast(obj);
            }
        }

        @Override // java.util.Deque
        public Iterator descendingIterator() {
            Iterator<E> itDescendingIterator;
            synchronized (this.f84744b) {
                itDescendingIterator = e().descendingIterator();
            }
            return itDescendingIterator;
        }

        @Override // java.util.Deque
        public Object getFirst() {
            Object first;
            synchronized (this.f84744b) {
                first = e().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public Object getLast() {
            Object last;
            synchronized (this.f84744b) {
                last = e().getLast();
            }
            return last;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Deque g() {
            return (Deque) super.g();
        }

        @Override // java.util.Deque
        public boolean offerFirst(Object obj) {
            boolean zOfferFirst;
            synchronized (this.f84744b) {
                zOfferFirst = e().offerFirst(obj);
            }
            return zOfferFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(Object obj) {
            boolean zOfferLast;
            synchronized (this.f84744b) {
                zOfferLast = e().offerLast(obj);
            }
            return zOfferLast;
        }

        @Override // java.util.Deque
        public Object peekFirst() {
            Object objPeekFirst;
            synchronized (this.f84744b) {
                objPeekFirst = e().peekFirst();
            }
            return objPeekFirst;
        }

        @Override // java.util.Deque
        public Object peekLast() {
            Object objPeekLast;
            synchronized (this.f84744b) {
                objPeekLast = e().peekLast();
            }
            return objPeekLast;
        }

        @Override // java.util.Deque
        public Object pollFirst() {
            Object objPollFirst;
            synchronized (this.f84744b) {
                objPollFirst = e().pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.Deque
        public Object pollLast() {
            Object objPollLast;
            synchronized (this.f84744b) {
                objPollLast = e().pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.Deque
        public Object pop() {
            Object objPop;
            synchronized (this.f84744b) {
                objPop = e().pop();
            }
            return objPop;
        }

        @Override // java.util.Deque
        public void push(Object obj) {
            synchronized (this.f84744b) {
                e().push(obj);
            }
        }

        @Override // java.util.Deque
        public Object removeFirst() {
            Object objRemoveFirst;
            synchronized (this.f84744b) {
                objRemoveFirst = e().removeFirst();
            }
            return objRemoveFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean zRemoveFirstOccurrence;
            synchronized (this.f84744b) {
                zRemoveFirstOccurrence = e().removeFirstOccurrence(obj);
            }
            return zRemoveFirstOccurrence;
        }

        @Override // java.util.Deque
        public Object removeLast() {
            Object objRemoveLast;
            synchronized (this.f84744b) {
                objRemoveLast = e().removeLast();
            }
            return objRemoveLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean zRemoveLastOccurrence;
            synchronized (this.f84744b) {
                zRemoveLastOccurrence = e().removeLastOccurrence(obj);
            }
            return zRemoveLastOccurrence;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry entry, Object obj) {
            super(entry, obj);
        }

        Map.Entry e() {
            return (Map.Entry) super.d();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean zEquals;
            synchronized (this.f84744b) {
                zEquals = e().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            Object key;
            synchronized (this.f84744b) {
                key = e().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object value;
            synchronized (this.f84744b) {
                value = e().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = e().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object value;
            synchronized (this.f84744b) {
                value = e().setValue(obj);
            }
            return value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List list, Object obj) {
            super(list, obj);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            synchronized (this.f84744b) {
                g().add(i3, obj);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection collection) {
            boolean zAddAll;
            synchronized (this.f84744b) {
                zAddAll = g().addAll(i3, collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f84744b) {
                zEquals = g().equals(obj);
            }
            return zEquals;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public List g() {
            return (List) super.g();
        }

        @Override // java.util.List
        public Object get(int i3) {
            Object obj;
            synchronized (this.f84744b) {
                obj = g().get(i3);
            }
            return obj;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = g().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            synchronized (this.f84744b) {
                iIndexOf = g().indexOf(obj);
            }
            return iIndexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            synchronized (this.f84744b) {
                iLastIndexOf = g().lastIndexOf(obj);
            }
            return iLastIndexOf;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return g().listIterator();
        }

        @Override // java.util.List
        public Object remove(int i3) {
            Object objRemove;
            synchronized (this.f84744b) {
                objRemove = g().remove(i3);
            }
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            Object obj2;
            synchronized (this.f84744b) {
                obj2 = g().set(i3, obj);
            }
            return obj2;
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            List listH;
            synchronized (this.f84744b) {
                listH = Synchronized.h(g().subList(i3, i4), this.f84744b);
            }
            return listH;
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            return g().listIterator(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public ListMultimap e() {
            return (ListMultimap) super.e();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List a(Object obj) {
            List listA;
            synchronized (this.f84744b) {
                listA = e().a(obj);
            }
            return listA;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            List listH;
            synchronized (this.f84744b) {
                listH = Synchronized.h(e().get(obj), this.f84744b);
            }
            return listH;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient Set f84729c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Collection f84730d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Set f84731f;

        SynchronizedMap(Map map, Object obj) {
            super(map, obj);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.f84744b) {
                g().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f84744b) {
                zContainsKey = g().containsKey(obj);
            }
            return zContainsKey;
        }

        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f84744b) {
                zContainsValue = g().containsValue(obj);
            }
            return zContainsValue;
        }

        /* JADX INFO: renamed from: e */
        Map g() {
            return (Map) super.d();
        }

        public Set entrySet() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84731f == null) {
                        this.f84731f = Synchronized.n(g().entrySet(), this.f84744b);
                    }
                    set = this.f84731f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f84744b) {
                zEquals = g().equals(obj);
            }
            return zEquals;
        }

        public Object get(Object obj) {
            Object obj2;
            synchronized (this.f84744b) {
                obj2 = g().get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = g().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f84744b) {
                zIsEmpty = g().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map
        public Set keySet() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84729c == null) {
                        this.f84729c = Synchronized.n(g().keySet(), this.f84744b);
                    }
                    set = this.f84729c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut;
            synchronized (this.f84744b) {
                objPut = g().put(obj, obj2);
            }
            return objPut;
        }

        @Override // java.util.Map
        public void putAll(Map map) {
            synchronized (this.f84744b) {
                g().putAll(map);
            }
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            Object objRemove;
            synchronized (this.f84744b) {
                objRemove = g().remove(obj);
            }
            return objRemove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.f84744b) {
                size = g().size();
            }
            return size;
        }

        public Collection values() {
            Collection collection;
            synchronized (this.f84744b) {
                try {
                    if (this.f84730d == null) {
                        this.f84730d = Synchronized.g(g().values(), this.f84744b);
                    }
                    collection = this.f84730d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient Set f84732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Collection f84733d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        transient Collection f84734f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient Map f84735g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        transient Multiset f84736h;

        public Collection a(Object obj) {
            Collection collectionA;
            synchronized (this.f84744b) {
                collectionA = e().a(obj);
            }
            return collectionA;
        }

        @Override // com.google.common.collect.Multimap
        public Map a1() {
            Map map;
            synchronized (this.f84744b) {
                try {
                    if (this.f84735g == null) {
                        this.f84735g = new SynchronizedAsMap(e().a1(), this.f84744b);
                    }
                    map = this.f84735g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public Collection b() {
            Collection collection;
            synchronized (this.f84744b) {
                try {
                    if (this.f84734f == null) {
                        this.f84734f = Synchronized.q(e().b(), this.f84744b);
                    }
                    collection = this.f84734f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.f84744b) {
                e().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f84744b) {
                zContainsKey = e().containsKey(obj);
            }
            return zContainsKey;
        }

        Multimap e() {
            return (Multimap) super.d();
        }

        @Override // com.google.common.collect.Multimap
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f84744b) {
                zEquals = e().equals(obj);
            }
            return zEquals;
        }

        public Collection get(Object obj) {
            Collection collectionQ;
            synchronized (this.f84744b) {
                collectionQ = Synchronized.q(e().get(obj), this.f84744b);
            }
            return collectionQ;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = e().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f84744b) {
                zIsEmpty = e().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public Set keySet() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84732c == null) {
                        this.f84732c = Synchronized.r(e().keySet(), this.f84744b);
                    }
                    set = this.f84732c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset keys() {
            Multiset multiset;
            synchronized (this.f84744b) {
                try {
                    if (this.f84736h == null) {
                        this.f84736h = Synchronized.j(e().keys(), this.f84744b);
                    }
                    multiset = this.f84736h;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            boolean zPut;
            synchronized (this.f84744b) {
                zPut = e().put(obj, obj2);
            }
            return zPut;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.f84744b) {
                zRemove = e().remove(obj, obj2);
            }
            return zRemove;
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.f84744b) {
                size = e().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public Collection values() {
            Collection collection;
            synchronized (this.f84744b) {
                try {
                    if (this.f84733d == null) {
                        this.f84733d = Synchronized.g(e().values(), this.f84744b);
                    }
                    collection = this.f84733d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap
        public boolean w1(Object obj, Object obj2) {
            boolean zW1;
            synchronized (this.f84744b) {
                zW1 = e().w1(obj, obj2);
            }
            return zW1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient Set f84737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        transient Set f84738d;

        SynchronizedMultiset(Multiset multiset, Object obj) {
            super(multiset, obj);
        }

        @Override // com.google.common.collect.Multiset
        public boolean L1(Object obj, int i3, int i4) {
            boolean zL1;
            synchronized (this.f84744b) {
                zL1 = g().L1(obj, i3, i4);
            }
            return zL1;
        }

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            int iY1;
            synchronized (this.f84744b) {
                iY1 = g().Y1(obj);
            }
            return iY1;
        }

        @Override // com.google.common.collect.Multiset
        public int e0(Object obj, int i3) {
            int iE0;
            synchronized (this.f84744b) {
                iE0 = g().e0(obj, i3);
            }
            return iE0;
        }

        @Override // com.google.common.collect.Multiset
        public Set entrySet() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84738d == null) {
                        this.f84738d = Synchronized.r(g().entrySet(), this.f84744b);
                    }
                    set = this.f84738d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f84744b) {
                zEquals = g().equals(obj);
            }
            return zEquals;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public Multiset g() {
            return (Multiset) super.g();
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = g().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Multiset
        public Set i() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84737c == null) {
                        this.f84737c = Synchronized.r(g().i(), this.f84744b);
                    }
                    set = this.f84737c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public int o1(Object obj, int i3) {
            int iO1;
            synchronized (this.f84744b) {
                iO1 = g().o1(obj, i3);
            }
            return iO1;
        }

        @Override // com.google.common.collect.Multiset
        public int t1(Object obj, int i3) {
            int iT1;
            synchronized (this.f84744b) {
                iT1 = g().t1(obj, i3);
            }
            return iT1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f84744b;

        SynchronizedObject(Object obj, Object obj2) {
            this.f84743a = Preconditions.t(obj);
            this.f84744b = obj2 == null ? this : obj2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.f84744b) {
                objectOutputStream.defaultWriteObject();
            }
        }

        Object d() {
            return this.f84743a;
        }

        public String toString() {
            String string;
            synchronized (this.f84744b) {
                string = this.f84743a.toString();
            }
            return string;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        @Override // java.util.Queue
        public Object element() {
            Object objElement;
            synchronized (this.f84744b) {
                objElement = g().element();
            }
            return objElement;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public Queue g() {
            return (Queue) super.g();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            boolean zOffer;
            synchronized (this.f84744b) {
                zOffer = g().offer(obj);
            }
            return zOffer;
        }

        @Override // java.util.Queue
        public Object peek() {
            Object objPeek;
            synchronized (this.f84744b) {
                objPeek = g().peek();
            }
            return objPeek;
        }

        @Override // java.util.Queue
        public Object poll() {
            Object objPoll;
            synchronized (this.f84744b) {
                objPoll = g().poll();
            }
            return objPoll;
        }

        @Override // java.util.Queue
        public Object remove() {
            Object objRemove;
            synchronized (this.f84744b) {
                objRemove = g().remove();
            }
            return objRemove;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List list, Object obj) {
            super(list, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set set, Object obj) {
            super(set, obj);
        }

        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f84744b) {
                zEquals = g().equals(obj);
            }
            return zEquals;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        public Set g() {
            return (Set) super.g();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = g().hashCode();
            }
            return iHashCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient Set f84745i;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SetMultimap e() {
            return (SetMultimap) super.e();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set a(Object obj) {
            Set setA;
            synchronized (this.f84744b) {
                setA = e().a(obj);
            }
            return setA;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set b() {
            Set set;
            synchronized (this.f84744b) {
                try {
                    if (this.f84745i == null) {
                        this.f84745i = Synchronized.n(e().b(), this.f84744b);
                    }
                    set = this.f84745i;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(Object obj) {
            Set setN;
            synchronized (this.f84744b) {
                setN = Synchronized.n(e().get(obj), this.f84744b);
            }
            return setN;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            Comparator<? super K> comparator;
            synchronized (this.f84744b) {
                comparator = g().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            Object objFirstKey;
            synchronized (this.f84744b) {
                objFirstKey = g().firstKey();
            }
            return objFirstKey;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        public SortedMap g() {
            return (SortedMap) super.g();
        }

        public SortedMap headMap(Object obj) {
            SortedMap sortedMapO;
            synchronized (this.f84744b) {
                sortedMapO = Synchronized.o(g().headMap(obj), this.f84744b);
            }
            return sortedMapO;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            Object objLastKey;
            synchronized (this.f84744b) {
                objLastKey = g().lastKey();
            }
            return objLastKey;
        }

        public SortedMap subMap(Object obj, Object obj2) {
            SortedMap sortedMapO;
            synchronized (this.f84744b) {
                sortedMapO = Synchronized.o(g().subMap(obj, obj2), this.f84744b);
            }
            return sortedMapO;
        }

        public SortedMap tailMap(Object obj) {
            SortedMap sortedMapO;
            synchronized (this.f84744b) {
                sortedMapO = Synchronized.o(g().tailMap(obj), this.f84744b);
            }
            return sortedMapO;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            Comparator<? super E> comparator;
            synchronized (this.f84744b) {
                comparator = g().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public Object first() {
            Object objFirst;
            synchronized (this.f84744b) {
                objFirst = g().first();
            }
            return objFirst;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet g() {
            return (SortedSet) super.g();
        }

        public SortedSet headSet(Object obj) {
            SortedSet sortedSetP;
            synchronized (this.f84744b) {
                sortedSetP = Synchronized.p(g().headSet(obj), this.f84744b);
            }
            return sortedSetP;
        }

        @Override // java.util.SortedSet
        public Object last() {
            Object objLast;
            synchronized (this.f84744b) {
                objLast = g().last();
            }
            return objLast;
        }

        public SortedSet subSet(Object obj, Object obj2) {
            SortedSet sortedSetP;
            synchronized (this.f84744b) {
                sortedSetP = Synchronized.p(g().subSet(obj, obj2), this.f84744b);
            }
            return sortedSetP;
        }

        public SortedSet tailSet(Object obj) {
            SortedSet sortedSetP;
            synchronized (this.f84744b) {
                sortedSetP = Synchronized.p(g().tailSet(obj), this.f84744b);
            }
            return sortedSetP;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        @Override // com.google.common.collect.Table
        public Map C() {
            Map mapI;
            synchronized (this.f84744b) {
                mapI = Synchronized.i(Maps.Q(e().C(), new Function<Map<R, V>, Map<R, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.2
                    @Override // com.google.common.base.Function
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Map apply(Map map) {
                        return Synchronized.i(map, SynchronizedTable.this.f84744b);
                    }
                }), this.f84744b);
            }
            return mapI;
        }

        @Override // com.google.common.collect.Table
        public Set O0() {
            Set setN;
            synchronized (this.f84744b) {
                setN = Synchronized.n(e().O0(), this.f84744b);
            }
            return setN;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.f84744b) {
                e().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f84744b) {
                zContainsValue = e().containsValue(obj);
            }
            return zContainsValue;
        }

        Table e() {
            return (Table) super.d();
        }

        @Override // com.google.common.collect.Table
        public boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.f84744b) {
                zEquals = e().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int iHashCode;
            synchronized (this.f84744b) {
                iHashCode = e().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Table
        public Map l() {
            Map mapI;
            synchronized (this.f84744b) {
                mapI = Synchronized.i(Maps.Q(e().l(), new Function<Map<C, V>, Map<C, V>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.1
                    @Override // com.google.common.base.Function
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Map apply(Map map) {
                        return Synchronized.i(map, SynchronizedTable.this.f84744b);
                    }
                }), this.f84744b);
            }
            return mapI;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.f84744b) {
                size = e().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public Collection values() {
            Collection collectionG;
            synchronized (this.f84744b) {
                collectionG = Synchronized.g(e().values(), this.f84744b);
            }
            return collectionG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection g(Collection collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List h(List list, Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    static Map i(Map map, Object obj) {
        return new SynchronizedMap(map, obj);
    }

    static Multiset j(Multiset multiset, Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    static NavigableMap k(NavigableMap navigableMap, Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    static NavigableSet l(NavigableSet navigableSet, Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map.Entry m(Map.Entry entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    static Set n(Set set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    static SortedMap o(SortedMap sortedMap, Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SortedSet p(SortedSet sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection q(Collection collection, Object obj) {
        return collection instanceof SortedSet ? p((SortedSet) collection, obj) : collection instanceof Set ? n((Set) collection, obj) : collection instanceof List ? h((List) collection, obj) : g(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set r(Set set, Object obj) {
        return set instanceof SortedSet ? p((SortedSet) set, obj) : n(set, obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSetMultimap e() {
            return (SortedSetMultimap) super.e();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet a(Object obj) {
            SortedSet sortedSetA;
            synchronized (this.f84744b) {
                sortedSetA = e().a(obj);
            }
            return sortedSetA;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet get(Object obj) {
            SortedSet sortedSetP;
            synchronized (this.f84744b) {
                sortedSetP = Synchronized.p(e().get(obj), this.f84744b);
            }
            return sortedSetP;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set set, Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean zN;
            synchronized (this.f84744b) {
                zN = Maps.n(g(), obj);
            }
            return zN;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            boolean zB;
            synchronized (this.f84744b) {
                zB = Collections2.b(g(), collection);
            }
            return zB;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean zB;
            if (obj == this) {
                return true;
            }
            synchronized (this.f84744b) {
                zB = Sets.b(g(), obj);
            }
            return zB;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry a(final Map.Entry entry) {
                    return new ForwardingMapEntry<K, Collection<V>>(this) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f84725b;

                        {
                            this.f84725b = this;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        public Map.Entry I1() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        /* JADX INFO: renamed from: T1, reason: merged with bridge method [inline-methods] */
                        public Collection getValue() {
                            return Synchronized.q((Collection) entry.getValue(), SynchronizedAsMapEntries.this.f84744b);
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean zE;
            synchronized (this.f84744b) {
                zE = Maps.E(g(), obj);
            }
            return zE;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            boolean zH;
            synchronized (this.f84744b) {
                zH = Iterators.H(g().iterator(), collection);
            }
            return zH;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            boolean zJ;
            synchronized (this.f84744b) {
                zJ = Iterators.J(g().iterator(), collection);
            }
            return zJ;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] objArrH;
            synchronized (this.f84744b) {
                objArrH = ObjectArrays.h(g());
            }
            return objArrH;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            Object[] objArrI;
            synchronized (this.f84744b) {
                objArrI = ObjectArrays.i(g(), objArr);
            }
            return objArrI;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient NavigableSet f84739g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        transient NavigableMap f84740h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        transient NavigableSet f84741i;

        SynchronizedNavigableMap(NavigableMap navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().ceilingEntry(obj), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            Object objCeilingKey;
            synchronized (this.f84744b) {
                objCeilingKey = e().ceilingKey(obj);
            }
            return objCeilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            synchronized (this.f84744b) {
                try {
                    NavigableSet navigableSet = this.f84739g;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSetL = Synchronized.l(e().descendingKeySet(), this.f84744b);
                    this.f84739g = navigableSetL;
                    return navigableSetL;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            synchronized (this.f84744b) {
                try {
                    NavigableMap navigableMap = this.f84740h;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    NavigableMap navigableMapK = Synchronized.k(e().descendingMap(), this.f84744b);
                    this.f84740h = navigableMapK;
                    return navigableMapK;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().firstEntry(), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().floorEntry(obj), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            Object objFloorKey;
            synchronized (this.f84744b) {
                objFloorKey = e().floorKey(obj);
            }
            return objFloorKey;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap g() {
            return (NavigableMap) super.g();
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            NavigableMap navigableMapK;
            synchronized (this.f84744b) {
                navigableMapK = Synchronized.k(e().headMap(obj, z2), this.f84744b);
            }
            return navigableMapK;
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().higherEntry(obj), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            Object objHigherKey;
            synchronized (this.f84744b) {
                objHigherKey = e().higherKey(obj);
            }
            return objHigherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().lastEntry(), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().lowerEntry(obj), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            Object objLowerKey;
            synchronized (this.f84744b) {
                objLowerKey = e().lowerKey(obj);
            }
            return objLowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            synchronized (this.f84744b) {
                try {
                    NavigableSet navigableSet = this.f84741i;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSetL = Synchronized.l(e().navigableKeySet(), this.f84744b);
                    this.f84741i = navigableSetL;
                    return navigableSetL;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().pollFirstEntry(), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            Map.Entry entryM;
            synchronized (this.f84744b) {
                entryM = Synchronized.m(e().pollLastEntry(), this.f84744b);
            }
            return entryM;
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            NavigableMap navigableMapK;
            synchronized (this.f84744b) {
                navigableMapK = Synchronized.k(e().subMap(obj, z2, obj2, z3), this.f84744b);
            }
            return navigableMapK;
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            NavigableMap navigableMapK;
            synchronized (this.f84744b) {
                navigableMapK = Synchronized.k(e().tailMap(obj, z2), this.f84744b);
            }
            return navigableMapK;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        transient NavigableSet f84742c;

        SynchronizedNavigableSet(NavigableSet navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            Object objCeiling;
            synchronized (this.f84744b) {
                objCeiling = g().ceiling(obj);
            }
            return objCeiling;
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return g().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            synchronized (this.f84744b) {
                try {
                    NavigableSet navigableSet = this.f84742c;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSetL = Synchronized.l(g().descendingSet(), this.f84744b);
                    this.f84742c = navigableSetL;
                    return navigableSetL;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            Object objFloor;
            synchronized (this.f84744b) {
                objFloor = g().floor(obj);
            }
            return objFloor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            NavigableSet navigableSetL;
            synchronized (this.f84744b) {
                navigableSetL = Synchronized.l(g().headSet(obj, z2), this.f84744b);
            }
            return navigableSetL;
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            Object objHigher;
            synchronized (this.f84744b) {
                objHigher = g().higher(obj);
            }
            return objHigher;
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            Object objLower;
            synchronized (this.f84744b) {
                objLower = g().lower(obj);
            }
            return objLower;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            Object objPollFirst;
            synchronized (this.f84744b) {
                objPollFirst = g().pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            Object objPollLast;
            synchronized (this.f84744b) {
                objPollLast = g().pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            NavigableSet navigableSetL;
            synchronized (this.f84744b) {
                navigableSetL = Synchronized.l(g().subSet(obj, z2, obj2, z3), this.f84744b);
            }
            return navigableSetL;
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            NavigableSet navigableSetL;
            synchronized (this.f84744b) {
                navigableSetL = Synchronized.l(g().tailSet(obj, z2), this.f84744b);
            }
            return navigableSetL;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }
    }
}
