package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Map f83667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient AbstractBiMap f83668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Set f83669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Set f83670d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient Set f83671f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class BiMapEntry extends ForwardingMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map.Entry f83675a;

        BiMapEntry(Map.Entry entry) {
            this.f83675a = entry;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Map.Entry k2() {
            return this.f83675a;
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            AbstractBiMap.this.r2(obj);
            Preconditions.A(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.a(obj, getValue())) {
                return obj;
            }
            Preconditions.m(!AbstractBiMap.this.containsValue(obj), "value already present: %s", obj);
            Object value = this.f83675a.setValue(obj);
            Preconditions.A(Objects.a(obj, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.O2(getKey(), true, value, obj);
            return value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set f83677a;

        private EntrySet() {
            this.f83677a = AbstractBiMap.this.f83667a.entrySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.n(k2(), obj);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return T1(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AbstractBiMap.this.z2();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            return this.f83677a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f83677a.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.f83668b.f83667a.remove(entry.getValue());
            this.f83677a.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return m2(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return V1(collection);
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
    static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        Inverse(Map map, AbstractBiMap abstractBiMap) {
            super(map, abstractBiMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Object object = objectInputStream.readObject();
            java.util.Objects.requireNonNull(object);
            N2((AbstractBiMap) object);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(u1());
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: B1 */
        protected /* bridge */ /* synthetic */ Object k2() {
            return super.k2();
        }

        @Override // com.google.common.collect.AbstractBiMap
        Object o2(Object obj) {
            return this.f83668b.r2(obj);
        }

        @Override // com.google.common.collect.AbstractBiMap
        Object r2(Object obj) {
            return this.f83668b.o2(obj);
        }

        Object readResolve() {
            return u1().u1();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.x(AbstractBiMap.this.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            return AbstractBiMap.this.f83667a.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.K2(obj);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return m2(collection);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return V1(collection);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ValueSet extends ForwardingSet<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Set f83680a;

        private ValueSet() {
            this.f83680a = AbstractBiMap.this.f83668b.keySet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return Maps.Y(AbstractBiMap.this.entrySet().iterator());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        public Set k2() {
            return this.f83680a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return b2();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return g2();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return c2(objArr);
        }
    }

    private Object J2(Object obj, Object obj2, boolean z2) {
        o2(obj);
        r2(obj2);
        boolean zContainsKey = containsKey(obj);
        if (zContainsKey && Objects.a(obj2, get(obj))) {
            return obj2;
        }
        if (z2) {
            u1().remove(obj2);
        } else {
            Preconditions.m(!containsValue(obj2), "value already present: %s", obj2);
        }
        Object objPut = this.f83667a.put(obj, obj2);
        O2(obj, zContainsKey, objPut, obj2);
        return objPut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object K2(Object obj) {
        Object objA = NullnessCasts.a(this.f83667a.remove(obj));
        L2(objA);
        return objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L2(Object obj) {
        this.f83668b.f83667a.remove(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O2(Object obj, boolean z2, Object obj2, Object obj3) {
        if (z2) {
            L2(NullnessCasts.a(obj2));
        }
        this.f83668b.f83667a.put(obj3, obj);
    }

    AbstractBiMap C2(Map map) {
        return new Inverse(map, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public Map k2() {
        return this.f83667a;
    }

    void M2(Map map, Map map2) {
        Preconditions.z(this.f83667a == null);
        Preconditions.z(this.f83668b == null);
        Preconditions.d(map.isEmpty());
        Preconditions.d(map2.isEmpty());
        Preconditions.d(map != map2);
        this.f83667a = map;
        this.f83668b = C2(map2);
    }

    void N2(AbstractBiMap abstractBiMap) {
        this.f83668b = abstractBiMap;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void clear() {
        this.f83667a.clear();
        this.f83668b.f83667a.clear();
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.f83668b.containsKey(obj);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set entrySet() {
        Set set = this.f83671f;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.f83671f = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set keySet() {
        Set set = this.f83669c;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f83669c = keySet;
        return keySet;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        return J2(obj, obj2, false);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Object remove(Object obj) {
        if (containsKey(obj)) {
            return K2(obj);
        }
        return null;
    }

    @Override // com.google.common.collect.BiMap
    public BiMap u1() {
        return this.f83668b;
    }

    Iterator z2() {
        final Iterator<Map.Entry<K, V>> it = this.f83667a.entrySet().iterator();
        return new Iterator<Map.Entry<K, V>>(this) { // from class: com.google.common.collect.AbstractBiMap.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Map.Entry f83672a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ AbstractBiMap f83674c;

            {
                this.f83674c = this;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) it.next();
                this.f83672a = entry;
                return new BiMapEntry(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                Map.Entry entry = this.f83672a;
                if (entry == null) {
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
                Object value = entry.getValue();
                it.remove();
                this.f83674c.L2(value);
                this.f83672a = null;
            }
        };
    }

    private AbstractBiMap(Map map, AbstractBiMap abstractBiMap) {
        this.f83667a = map;
        this.f83668b = abstractBiMap;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public Set values() {
        Set set = this.f83670d;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.f83670d = valueSet;
        return valueSet;
    }

    Object o2(Object obj) {
        return obj;
    }

    Object r2(Object obj) {
        return obj;
    }
}
