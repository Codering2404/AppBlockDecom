package com.google.common.collect;

import com.google.common.collect.Multiset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient ImmutableSortedMultiset f83895f;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset immutableSortedMultiset) {
        this.f83895f = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        return this.f83895f.Y1(obj);
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        return this.f83895f.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return this.f83895f.g();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        return this.f83895f.firstEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry q(int i3) {
        return (Multiset.Entry) this.f83895f.entrySet().a().J().get(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.f83895f.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMultiset A1() {
        return this.f83895f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet i() {
        return this.f83895f.i().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMultiset Q1(Object obj, BoundType boundType) {
        return this.f83895f.h2(obj, boundType).A1();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMultiset h2(Object obj, BoundType boundType) {
        return this.f83895f.Q1(obj, boundType).A1();
    }
}
