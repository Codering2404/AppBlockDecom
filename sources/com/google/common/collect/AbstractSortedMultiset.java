package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Comparator f83751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient SortedMultiset f83752d;

    AbstractSortedMultiset() {
        this(Ordering.f());
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset A1() {
        SortedMultiset sortedMultiset = this.f83752d;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset sortedMultisetG = g();
        this.f83752d = sortedMultisetG;
        return sortedMultisetG;
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator comparator() {
        return this.f83751c;
    }

    Iterator descendingIterator() {
        return Multisets.j(A1());
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        Iterator itF = f();
        if (itF.hasNext()) {
            return (Multiset.Entry) itF.next();
        }
        return null;
    }

    SortedMultiset g() {
        return new DescendingMultiset<E>() { // from class: com.google.common.collect.AbstractSortedMultiset.1DescendingMultisetImpl
            @Override // com.google.common.collect.DescendingMultiset, com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return AbstractSortedMultiset.this.descendingIterator();
            }

            @Override // com.google.common.collect.DescendingMultiset
            Iterator o2() {
                return AbstractSortedMultiset.this.l();
            }

            @Override // com.google.common.collect.DescendingMultiset
            SortedMultiset r2() {
                return AbstractSortedMultiset.this;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public NavigableSet a() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        Preconditions.t(boundType);
        Preconditions.t(boundType2);
        return h2(obj, boundType).Q1(obj2, boundType2);
    }

    abstract Iterator l();

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        Iterator itL = l();
        if (itL.hasNext()) {
            return (Multiset.Entry) itL.next();
        }
        return null;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollFirstEntry() {
        Iterator itF = f();
        if (!itF.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) itF.next();
        Multiset.Entry entryH = Multisets.h(entry.a(), entry.getCount());
        itF.remove();
        return entryH;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollLastEntry() {
        Iterator itL = l();
        if (!itL.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) itL.next();
        Multiset.Entry entryH = Multisets.h(entry.a(), entry.getCount());
        itL.remove();
        return entryH;
    }

    AbstractSortedMultiset(Comparator comparator) {
        this.f83751c = (Comparator) Preconditions.t(comparator);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public NavigableSet i() {
        return (NavigableSet) super.i();
    }
}
