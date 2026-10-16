package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class DescendingMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Comparator f83897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient NavigableSet f83898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Set f83899c;

    DescendingMultiset() {
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset A1() {
        return r2();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset Q1(Object obj, BoundType boundType) {
        return r2().h2(obj, boundType).A1();
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator comparator() {
        Comparator comparator = this.f83897a;
        if (comparator != null) {
            return comparator;
        }
        Ordering orderingK = Ordering.b(r2().comparator()).k();
        this.f83897a = orderingK;
        return orderingK;
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public Set entrySet() {
        Set set = this.f83899c;
        if (set != null) {
            return set;
        }
        Set setM2 = m2();
        this.f83899c = setM2;
        return setM2;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        return r2().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset h2(Object obj, BoundType boundType) {
        return r2().Q1(obj, boundType).A1();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return r2().i1(obj2, boundType2, obj, boundType).A1();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return Multisets.j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.ForwardingCollection
    public Multiset k2() {
        return r2();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        return r2().firstEntry();
    }

    Set m2() {
        return new Multisets.EntrySet<E>() { // from class: com.google.common.collect.DescendingMultiset.1EntrySetImpl
            @Override // com.google.common.collect.Multisets.EntrySet
            Multiset f() {
                return DescendingMultiset.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return DescendingMultiset.this.o2();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DescendingMultiset.this.r2().entrySet().size();
            }
        };
    }

    abstract Iterator o2();

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollFirstEntry() {
        return r2().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollLastEntry() {
        return r2().pollFirstEntry();
    }

    abstract SortedMultiset r2();

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return b2();
    }

    @Override // com.google.common.collect.ForwardingObject
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        return c2(objArr);
    }

    @Override // com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet i() {
        NavigableSet navigableSet = this.f83898b;
        if (navigableSet != null) {
            return navigableSet;
        }
        SortedMultisets.NavigableElementSet navigableElementSet = new SortedMultisets.NavigableElementSet(this);
        this.f83898b = navigableElementSet;
        return navigableElementSet;
    }
}
