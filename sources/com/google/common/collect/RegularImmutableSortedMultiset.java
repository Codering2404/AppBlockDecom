package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long[] f84609j = {0};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final ImmutableSortedMultiset f84610k = new RegularImmutableSortedMultiset(Ordering.f());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient RegularImmutableSortedSet f84611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient long[] f84612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f84613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient int f84614i;

    RegularImmutableSortedMultiset(Comparator comparator) {
        this.f84611f = ImmutableSortedSet.M(comparator);
        this.f84612g = f84609j;
        this.f84613h = 0;
        this.f84614i = 0;
    }

    private int z(int i3) {
        long[] jArr = this.f84612g;
        int i4 = this.f84613h;
        return (int) (jArr[(i4 + i3) + 1] - jArr[i4 + i3]);
    }

    ImmutableSortedMultiset A(int i3, int i4) {
        Preconditions.y(i3, i4, this.f84614i);
        return i3 == i4 ? ImmutableSortedMultiset.v(comparator()) : (i3 == 0 && i4 == this.f84614i) ? this : new RegularImmutableSortedMultiset(this.f84611f.a0(i3, i4), this.f84612g, this.f84613h + i3, i4 - i3);
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        int iIndexOf = this.f84611f.indexOf(obj);
        if (iIndexOf >= 0) {
            return z(iIndexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return q(0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return this.f84613h > 0 || this.f84614i < this.f84612g.length - 1;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return q(this.f84614i - 1);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry q(int i3) {
        return Multisets.h(this.f84611f.a().get(i3), z(i3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        long[] jArr = this.f84612g;
        int i3 = this.f84613h;
        return Ints.m(jArr[this.f84614i + i3] - jArr[i3]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset
    /* JADX INFO: renamed from: u */
    public ImmutableSortedSet i() {
        return this.f84611f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: w */
    public ImmutableSortedMultiset Q1(Object obj, BoundType boundType) {
        return A(0, this.f84611f.b0(obj, Preconditions.t(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.SortedMultiset
    /* JADX INFO: renamed from: y */
    public ImmutableSortedMultiset h2(Object obj, BoundType boundType) {
        return A(this.f84611f.c0(obj, Preconditions.t(boundType) == BoundType.CLOSED), this.f84614i);
    }

    RegularImmutableSortedMultiset(RegularImmutableSortedSet regularImmutableSortedSet, long[] jArr, int i3, int i4) {
        this.f84611f = regularImmutableSortedSet;
        this.f84612g = jArr;
        this.f84613h = i3;
        this.f84614i = i4;
    }
}
