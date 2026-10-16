package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Set f83745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set f83746b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ElementSet extends Multisets.ElementSet<E> {
        ElementSet() {
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset f() {
            return AbstractMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AbstractMultiset.this.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class EntrySet extends Multisets.EntrySet<E> {
        EntrySet() {
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        Multiset f() {
            return AbstractMultiset.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return AbstractMultiset.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractMultiset.this.d();
        }
    }

    AbstractMultiset() {
    }

    public boolean L1(Object obj, int i3, int i4) {
        return Multisets.o(this, obj, i3, i4);
    }

    Set a() {
        return new ElementSet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        t1(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        return Multisets.c(this, collection);
    }

    Set b() {
        return new EntrySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(Object obj) {
        return Y1(obj) > 0;
    }

    abstract int d();

    abstract Iterator e();

    public int e0(Object obj, int i3) {
        return Multisets.n(this, obj, i3);
    }

    @Override // com.google.common.collect.Multiset
    public Set entrySet() {
        Set set = this.f83746b;
        if (set != null) {
            return set;
        }
        Set setB = b();
        this.f83746b = setB;
        return setB;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    abstract Iterator f();

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    public Set i() {
        Set set = this.f83745a;
        if (set != null) {
            return set;
        }
        Set setA = a();
        this.f83745a = setA;
        return setA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public int o1(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final boolean remove(Object obj) {
        return o1(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        return Multisets.l(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return Multisets.m(this, collection);
    }

    public int t1(Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}
