package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final DiscreteDomain f83870f;

    ContiguousSet(DiscreteDomain discreteDomain) {
        super(Ordering.f());
        this.f83870f = discreteDomain;
    }

    public static ContiguousSet a0(Range range, DiscreteDomain discreteDomain) {
        Preconditions.t(range);
        Preconditions.t(discreteDomain);
        try {
            Range rangeP = !range.n() ? range.p(Range.c(discreteDomain.c())) : range;
            if (!range.o()) {
                rangeP = rangeP.p(Range.d(discreteDomain.b()));
            }
            if (!rangeP.r()) {
                Comparable comparableL = range.f84558a.l(discreteDomain);
                Objects.requireNonNull(comparableL);
                Comparable comparableJ = range.f84559b.j(discreteDomain);
                Objects.requireNonNull(comparableJ);
                if (Range.h(comparableL, comparableJ) <= 0) {
                    return new RegularContiguousSet(rangeP, discreteDomain);
                }
            }
            return new EmptyContiguousSet(discreteDomain);
        } catch (NoSuchElementException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet J() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public ContiguousSet headSet(Comparable comparable) {
        return Q((Comparable) Preconditions.t(comparable), false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public ContiguousSet headSet(Comparable comparable, boolean z2) {
        return Q((Comparable) Preconditions.t(comparable), z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public abstract ContiguousSet Q(Comparable comparable, boolean z2);

    public abstract Range f0();

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public ContiguousSet subSet(Comparable comparable, Comparable comparable2) {
        Preconditions.t(comparable);
        Preconditions.t(comparable2);
        Preconditions.d(comparator().compare(comparable, comparable2) <= 0);
        return U(comparable, true, comparable2, false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public ContiguousSet subSet(Comparable comparable, boolean z2, Comparable comparable2, boolean z3) {
        Preconditions.t(comparable);
        Preconditions.t(comparable2);
        Preconditions.d(comparator().compare(comparable, comparable2) <= 0);
        return U(comparable, z2, comparable2, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public abstract ContiguousSet U(Comparable comparable, boolean z2, Comparable comparable2, boolean z3);

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public ContiguousSet tailSet(Comparable comparable) {
        return X((Comparable) Preconditions.t(comparable), true);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public ContiguousSet tailSet(Comparable comparable, boolean z2) {
        return X((Comparable) Preconditions.t(comparable), z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public abstract ContiguousSet X(Comparable comparable, boolean z2);

    @Override // java.util.AbstractCollection
    public String toString() {
        return f0().toString();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }
}
