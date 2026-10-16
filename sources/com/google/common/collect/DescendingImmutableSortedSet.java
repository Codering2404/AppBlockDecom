package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableSortedSet f83896f;

    DescendingImmutableSortedSet(ImmutableSortedSet immutableSortedSet) {
        super(Ordering.b(immutableSortedSet.comparator()).k());
        this.f83896f = immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet J() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: K */
    public UnmodifiableIterator descendingIterator() {
        return this.f83896f.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: L */
    public ImmutableSortedSet descendingSet() {
        return this.f83896f;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet Q(Object obj, boolean z2) {
        return this.f83896f.tailSet(obj, z2).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet U(Object obj, boolean z2, Object obj2, boolean z3) {
        return this.f83896f.subSet(obj2, z3, obj, z2).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet X(Object obj, boolean z2) {
        return this.f83896f.headSet(obj, z2).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object ceiling(Object obj) {
        return this.f83896f.floor(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f83896f.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object floor(Object obj) {
        return this.f83896f.ceiling(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return this.f83896f.g();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return this.f83896f.descendingIterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object higher(Object obj) {
        return this.f83896f.lower(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object lower(Object obj) {
        return this.f83896f.higher(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f83896f.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }
}
