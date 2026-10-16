package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final RegularImmutableSortedSet f84615g = new RegularImmutableSortedSet(ImmutableList.y(), Ordering.f());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient ImmutableList f84616f;

    RegularImmutableSortedSet(ImmutableList immutableList, Comparator comparator) {
        super(comparator);
        this.f84616f = immutableList;
    }

    private int d0(Object obj) {
        return Collections.binarySearch(this.f84616f, obj, f0());
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet J() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f84146c);
        return isEmpty() ? ImmutableSortedSet.M(comparatorReverseOrder) : new RegularImmutableSortedSet(this.f84616f.J(), comparatorReverseOrder);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator descendingIterator() {
        return this.f84616f.J().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet Q(Object obj, boolean z2) {
        return a0(0, b0(obj, z2));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet U(Object obj, boolean z2, Object obj2, boolean z3) {
        return X(obj, z2).Q(obj2, z3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet X(Object obj, boolean z2) {
        return a0(c0(obj, z2), size());
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList a() {
        return this.f84616f;
    }

    RegularImmutableSortedSet a0(int i3, int i4) {
        return (i3 == 0 && i4 == size()) ? this : i3 < i4 ? new RegularImmutableSortedSet(this.f84616f.subList(i3, i4), this.f84146c) : ImmutableSortedSet.M(this.f84146c);
    }

    @Override // com.google.common.collect.ImmutableCollection
    int b(Object[] objArr, int i3) {
        return this.f84616f.b(objArr, i3);
    }

    int b0(Object obj, boolean z2) {
        int iBinarySearch = Collections.binarySearch(this.f84616f, Preconditions.t(obj), comparator());
        return iBinarySearch >= 0 ? z2 ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    int c0(Object obj, boolean z2) {
        int iBinarySearch = Collections.binarySearch(this.f84616f, Preconditions.t(obj), comparator());
        return iBinarySearch >= 0 ? z2 ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object ceiling(Object obj) {
        int iC0 = c0(obj, true);
        if (iC0 == size()) {
            return null;
        }
        return this.f84616f.get(iC0);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (d0(obj) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).i();
        }
        if (!SortedIterables.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator it = iterator();
        Iterator<E> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        E next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iY = Y(next2, next);
                if (iY < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iY == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iY > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] d() {
        return this.f84616f.d();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int e() {
        return this.f84616f.e();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!SortedIterables.b(this.f84146c, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            UnmodifiableIterator it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || Y(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    int f() {
        return this.f84616f.f();
    }

    Comparator f0() {
        return this.f84146c;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f84616f.get(0);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object floor(Object obj) {
        int iB0 = b0(obj, true) - 1;
        if (iB0 == -1) {
            return null;
        }
        return this.f84616f.get(iB0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return this.f84616f.g();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return this.f84616f.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object higher(Object obj) {
        int iC0 = c0(obj, false);
        if (iC0 == size()) {
            return null;
        }
        return this.f84616f.get(iC0);
    }

    int indexOf(Object obj) {
        int iBinarySearch;
        if (obj == null) {
            return -1;
        }
        try {
            iBinarySearch = Collections.binarySearch(this.f84616f, obj, f0());
        } catch (ClassCastException unused) {
        }
        if (iBinarySearch >= 0) {
            return iBinarySearch;
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f84616f.get(size() - 1);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public Object lower(Object obj) {
        int iB0 = b0(obj, false) - 1;
        if (iB0 == -1) {
            return null;
        }
        return this.f84616f.get(iB0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f84616f.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return super.writeReplace();
    }
}
