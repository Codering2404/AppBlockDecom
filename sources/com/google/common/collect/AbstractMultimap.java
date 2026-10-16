package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Collection f83737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set f83738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Multiset f83739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Collection f83740d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient Map f83741f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Entries extends Multimaps.Entries<K, V> {
        Entries() {
        }

        @Override // com.google.common.collect.Multimaps.Entries
        Multimap a() {
            return AbstractMultimap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractMultimap.this.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class EntrySet extends AbstractMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        EntrySet() {
            super();
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
    class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractMultimap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractMultimap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractMultimap.this.j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractMultimap.this.size();
        }
    }

    AbstractMultimap() {
    }

    @Override // com.google.common.collect.Multimap
    public Map a1() {
        Map map = this.f83741f;
        if (map != null) {
            return map;
        }
        Map mapC = c();
        this.f83741f = mapC;
        return mapC;
    }

    @Override // com.google.common.collect.Multimap
    public Collection b() {
        Collection collection = this.f83737a;
        if (collection != null) {
            return collection;
        }
        Collection collectionD = d();
        this.f83737a = collectionD;
        return collectionD;
    }

    abstract Map c();

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        Iterator<V> it = a1().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Collection d();

    abstract Set e();

    @Override // com.google.common.collect.Multimap
    public boolean equals(Object obj) {
        return Multimaps.c(this, obj);
    }

    abstract Multiset g();

    abstract Collection h();

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return a1().hashCode();
    }

    abstract Iterator i();

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return size() == 0;
    }

    Iterator j() {
        return Maps.Y(b().iterator());
    }

    @Override // com.google.common.collect.Multimap
    public Set keySet() {
        Set set = this.f83738b;
        if (set != null) {
            return set;
        }
        Set setE = e();
        this.f83738b = setE;
        return setE;
    }

    @Override // com.google.common.collect.Multimap
    public Multiset keys() {
        Multiset multiset = this.f83739c;
        if (multiset != null) {
            return multiset;
        }
        Multiset multisetG = g();
        this.f83739c = multisetG;
        return multisetG;
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        return get(obj).add(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) a1().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return a1().toString();
    }

    @Override // com.google.common.collect.Multimap
    public Collection values() {
        Collection collection = this.f83740d;
        if (collection != null) {
            return collection;
        }
        Collection collectionH = h();
        this.f83740d = collectionH;
        return collectionH;
    }

    @Override // com.google.common.collect.Multimap
    public boolean w1(Object obj, Object obj2) {
        Collection collection = (Collection) a1().get(obj);
        return collection != null && collection.contains(obj2);
    }
}
