package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient ConcurrentMap f83859c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class EntrySet extends AbstractMultiset<E>.EntrySet {
        private EntrySet() {
            super();
        }

        private List h() {
            ArrayList arrayListN = Lists.n(size());
            Iterators.a(arrayListN, iterator());
            return arrayListN;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMultiset.EntrySet, com.google.common.collect.Multisets.EntrySet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public ConcurrentHashMultiset f() {
            return ConcurrentHashMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return h().toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return h().toArray(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FieldSettersHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Serialization.FieldSetter f83868a = Serialization.a(ConcurrentHashMultiset.class, "countMap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List h() {
        ArrayList arrayListN = Lists.n(size());
        for (Multiset.Entry entry : entrySet()) {
            Object objA = entry.a();
            for (int count = entry.getCount(); count > 0; count--) {
                arrayListN.add(objA);
            }
        }
        return arrayListN;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        FieldSettersHolder.f83868a.b(this, (ConcurrentMap) object);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f83859c);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public boolean L1(Object obj, int i3, int i4) {
        Preconditions.t(obj);
        CollectPreconditions.b(i3, "oldCount");
        CollectPreconditions.b(i4, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.J(this.f83859c, obj);
        if (atomicInteger == null) {
            if (i3 != 0) {
                return false;
            }
            return i4 == 0 || this.f83859c.putIfAbsent(obj, new AtomicInteger(i4)) == null;
        }
        int i5 = atomicInteger.get();
        if (i5 == i3) {
            if (i5 == 0) {
                if (i4 == 0) {
                    this.f83859c.remove(obj, atomicInteger);
                    return true;
                }
                AtomicInteger atomicInteger2 = new AtomicInteger(i4);
                return this.f83859c.putIfAbsent(obj, atomicInteger2) == null || this.f83859c.replace(obj, atomicInteger, atomicInteger2);
            }
            if (atomicInteger.compareAndSet(i5, i4)) {
                if (i4 == 0) {
                    this.f83859c.remove(obj, atomicInteger);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.J(this.f83859c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Set a() {
        final Set setKeySet = this.f83859c.keySet();
        return new ForwardingSet<E>(this) { // from class: com.google.common.collect.ConcurrentHashMultiset.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ConcurrentHashMultiset f83861b;

            {
                this.f83861b = this;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return obj != null && Collections2.g(setKeySet, obj);
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection collection) {
                return T1(collection);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
            /* JADX INFO: renamed from: k2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Set k2() {
                return setKeySet;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return obj != null && Collections2.h(setKeySet, obj);
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                return m2(collection);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    public Set b() {
        return new EntrySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f83859c.clear();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    int d() {
        return this.f83859c.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator e() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int e0(Object obj, int i3) {
        AtomicInteger atomicInteger;
        int i4;
        AtomicInteger atomicInteger2;
        Preconditions.t(obj);
        CollectPreconditions.b(i3, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.J(this.f83859c, obj);
            if (atomicInteger == null && (i3 == 0 || (atomicInteger = (AtomicInteger) this.f83859c.putIfAbsent(obj, new AtomicInteger(i3))) == null)) {
                return 0;
            }
            do {
                i4 = atomicInteger.get();
                if (i4 == 0) {
                    if (i3 != 0) {
                        atomicInteger2 = new AtomicInteger(i3);
                        if (this.f83859c.putIfAbsent(obj, atomicInteger2) == null) {
                            break;
                        }
                    } else {
                        return 0;
                    }
                }
            } while (!atomicInteger.compareAndSet(i4, i3));
            if (i3 == 0) {
                this.f83859c.remove(obj, atomicInteger);
            }
            return i4;
        } while (!this.f83859c.replace(obj, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator f() {
        final AbstractIterator<Multiset.Entry<E>> abstractIterator = new AbstractIterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.ConcurrentHashMultiset.2

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Iterator f83862c;

            {
                this.f83862c = ConcurrentHashMultiset.this.f83859c.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry a() {
                while (this.f83862c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f83862c.next();
                    int i3 = ((AtomicInteger) entry.getValue()).get();
                    if (i3 != 0) {
                        return Multisets.h(entry.getKey(), i3);
                    }
                }
                return (Multiset.Entry) b();
            }
        };
        return new ForwardingIterator<Multiset.Entry<E>>(this) { // from class: com.google.common.collect.ConcurrentHashMultiset.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Multiset.Entry f83864a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ConcurrentHashMultiset f83866c;

            {
                this.f83866c = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
            /* JADX INFO: renamed from: I1 */
            public Iterator k2() {
                return abstractIterator;
            }

            @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
            /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry next() {
                Multiset.Entry entry = (Multiset.Entry) super.next();
                this.f83864a = entry;
                return entry;
            }

            @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
            public void remove() {
                Preconditions.A(this.f83864a != null, "no calls to next() since the last call to remove()");
                this.f83866c.e0(this.f83864a.a(), 0);
                this.f83864a = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set i() {
        return super.i();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f83859c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator iterator() {
        return Multisets.j(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int o1(Object obj, int i3) {
        int i4;
        int iMax;
        if (i3 == 0) {
            return Y1(obj);
        }
        CollectPreconditions.d(i3, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.J(this.f83859c, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i4 = atomicInteger.get();
            if (i4 == 0) {
                return 0;
            }
            iMax = Math.max(0, i4 - i3);
        } while (!atomicInteger.compareAndSet(i4, iMax));
        if (iMax == 0) {
            this.f83859c.remove(obj, atomicInteger);
        }
        return i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        Iterator<E> it = this.f83859c.values().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += (long) ((AtomicInteger) it.next()).get();
        }
        return Ints.m(j3);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int t1(Object obj, int i3) {
        AtomicInteger atomicInteger;
        int i4;
        AtomicInteger atomicInteger2;
        Preconditions.t(obj);
        if (i3 == 0) {
            return Y1(obj);
        }
        CollectPreconditions.d(i3, "occurrences");
        do {
            atomicInteger = (AtomicInteger) Maps.J(this.f83859c, obj);
            if (atomicInteger == null && (atomicInteger = (AtomicInteger) this.f83859c.putIfAbsent(obj, new AtomicInteger(i3))) == null) {
                return 0;
            }
            do {
                i4 = atomicInteger.get();
                if (i4 == 0) {
                    atomicInteger2 = new AtomicInteger(i3);
                    if (this.f83859c.putIfAbsent(obj, atomicInteger2) == null) {
                        break;
                    }
                } else {
                    try {
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i3 + " occurrences to a count of " + i4);
                    }
                }
            } while (!atomicInteger.compareAndSet(i4, IntMath.b(i4, i3)));
            return i4;
        } while (!this.f83859c.replace(obj, atomicInteger, atomicInteger2));
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return h().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return h().toArray(objArr);
    }
}
