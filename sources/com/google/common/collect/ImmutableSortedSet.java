package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedSet<E> extends ImmutableSet<E> implements NavigableSet<E>, SortedIterable<E> {
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Comparator f84146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient ImmutableSortedSet f84147d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator f84149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object[] f84150b;

        public SerializedForm(Comparator comparator, Object[] objArr) {
            this.f84149a = comparator;
            this.f84150b = objArr;
        }

        Object readResolve() {
            return new Builder(this.f84149a).j(this.f84150b).n();
        }
    }

    ImmutableSortedSet(Comparator comparator) {
        this.f84146c = comparator;
    }

    static ImmutableSortedSet I(Comparator comparator, int i3, Object... objArr) {
        if (i3 == 0) {
            return M(comparator);
        }
        ObjectArrays.c(objArr, i3);
        Arrays.sort(objArr, 0, i3, comparator);
        int i4 = 1;
        for (int i5 = 1; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (comparator.compare(obj, objArr[i4 - 1]) != 0) {
                objArr[i4] = obj;
                i4++;
            }
        }
        Arrays.fill(objArr, i4, i3, (Object) null);
        if (i4 < objArr.length / 2) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new RegularImmutableSortedSet(ImmutableList.n(objArr, i4), comparator);
    }

    static RegularImmutableSortedSet M(Comparator comparator) {
        return Ordering.f().equals(comparator) ? RegularImmutableSortedSet.f84615g : new RegularImmutableSortedSet(ImmutableList.y(), comparator);
    }

    public static ImmutableSortedSet R() {
        return RegularImmutableSortedSet.f84615g;
    }

    static int Z(Comparator comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    abstract ImmutableSortedSet J();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: K */
    public abstract UnmodifiableIterator descendingIterator();

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet descendingSet() {
        ImmutableSortedSet immutableSortedSet = this.f84147d;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet immutableSortedSetJ = J();
        this.f84147d = immutableSortedSetJ;
        immutableSortedSetJ.f84147d = this;
        return immutableSortedSetJ;
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet headSet(Object obj, boolean z2) {
        return Q(Preconditions.t(obj), z2);
    }

    abstract ImmutableSortedSet Q(Object obj, boolean z2);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        Preconditions.d(this.f84146c.compare(obj, obj2) <= 0);
        return U(obj, z2, obj2, z3);
    }

    abstract ImmutableSortedSet U(Object obj, boolean z2, Object obj2, boolean z3);

    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet tailSet(Object obj, boolean z2) {
        return X(Preconditions.t(obj), z2);
    }

    abstract ImmutableSortedSet X(Object obj, boolean z2);

    int Y(Object obj, Object obj2) {
        return Z(this.f84146c, obj, obj2);
    }

    public Object ceiling(Object obj) {
        return Iterables.i(tailSet(obj, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.SortedIterable
    public Comparator comparator() {
        return this.f84146c;
    }

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        return Iterators.x(headSet(obj, true).descendingIterator(), null);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public abstract UnmodifiableIterator iterator();

    public Object higher(Object obj) {
        return Iterables.i(tailSet(obj, false), null);
    }

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        return Iterators.x(headSet(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.f84146c, toArray());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder<E> extends ImmutableSet.Builder<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Comparator f84148f;

        public Builder(Comparator comparator) {
            this.f84148f = (Comparator) Preconditions.t(comparator);
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Builder e(Object obj) {
            super.e(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Builder j(Object... objArr) {
            super.j(objArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Builder k(Iterable iterable) {
            super.k(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Builder l(Iterator it) {
            super.l(it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet n() {
            ImmutableSortedSet immutableSortedSetI = ImmutableSortedSet.I(this.f84148f, this.f84006b, this.f84005a);
            this.f84006b = immutableSortedSetI.size();
            this.f84007c = true;
            return immutableSortedSetI;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet.Builder
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Builder o(ImmutableSet.Builder builder) {
            super.o(builder);
            return this;
        }

        Builder(Comparator comparator, int i3) {
            super(i3, false);
            this.f84148f = (Comparator) Preconditions.t(comparator);
        }
    }
}
