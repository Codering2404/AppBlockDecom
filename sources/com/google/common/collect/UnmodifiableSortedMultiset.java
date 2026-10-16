package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements SortedMultiset<E> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient UnmodifiableSortedMultiset f84864d;

    UnmodifiableSortedMultiset(SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset A1() {
        UnmodifiableSortedMultiset unmodifiableSortedMultiset = this.f84864d;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset(k2().A1());
        unmodifiableSortedMultiset2.f84864d = this;
        this.f84864d = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset Q1(Object obj, BoundType boundType) {
        return Multisets.q(k2().Q1(obj, boundType));
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator comparator() {
        return k2().comparator();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        return k2().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset h2(Object obj, BoundType boundType) {
        return Multisets.q(k2().h2(obj, boundType));
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return Multisets.q(k2().i1(obj, boundType, obj2, boundType2));
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        return k2().lastEntry();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    /* JADX INFO: renamed from: o2, reason: merged with bridge method [inline-methods] */
    public NavigableSet m2() {
        return Sets.q(k2().i());
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset
    /* JADX INFO: renamed from: r2, reason: merged with bridge method [inline-methods] */
    public SortedMultiset k2() {
        return (SortedMultiset) super.k2();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ForwardingMultiset, com.google.common.collect.Multiset
    public NavigableSet i() {
        return (NavigableSet) super.i();
    }
}
