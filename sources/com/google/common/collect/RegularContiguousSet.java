package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Range f84562g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SerializedForm<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Range f84568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final DiscreteDomain f84569b;

        private Object readResolve() {
            return new RegularContiguousSet(this.f84568a, this.f84569b);
        }

        private SerializedForm(Range range, DiscreteDomain discreteDomain) {
            this.f84568a = range;
            this.f84569b = discreteDomain;
        }
    }

    RegularContiguousSet(Range range, DiscreteDomain discreteDomain) {
        super(discreteDomain);
        this.f84562g = range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o0(Comparable comparable, Comparable comparable2) {
        return comparable2 != null && Range.h(comparable, comparable2) == 0;
    }

    private ContiguousSet r0(Range range) {
        return this.f84562g.q(range) ? ContiguousSet.a0(this.f84562g.p(range), this.f83870f) : new EmptyContiguousSet(this.f83870f);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    /* JADX INFO: renamed from: K */
    public UnmodifiableIterator descendingIterator() {
        return new AbstractSequentialIterator<C>(last()) { // from class: com.google.common.collect.RegularContiguousSet.2

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Comparable f84565b;

            {
                this.f84565b = RegularContiguousSet.this.first();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractSequentialIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Comparable a(Comparable comparable) {
                if (RegularContiguousSet.o0(comparable, this.f84565b)) {
                    return null;
                }
                return RegularContiguousSet.this.f83870f.f(comparable);
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f84562g.i((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        return Collections2.b(this, collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* JADX INFO: renamed from: d0 */
    public ContiguousSet Q(Comparable comparable, boolean z2) {
        return r0(Range.A(comparable, BoundType.b(z2)));
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.f83870f.equals(regularContiguousSet.f83870f)) {
                return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
            }
        }
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range f0() {
        BoundType boundType = BoundType.CLOSED;
        return t0(boundType, boundType);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* JADX INFO: renamed from: h */
    public UnmodifiableIterator iterator() {
        return new AbstractSequentialIterator<C>(first()) { // from class: com.google.common.collect.RegularContiguousSet.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Comparable f84563b;

            {
                this.f84563b = RegularContiguousSet.this.last();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractSequentialIterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Comparable a(Comparable comparable) {
                if (RegularContiguousSet.o0(comparable, this.f84563b)) {
                    return null;
                }
                return RegularContiguousSet.this.f83870f.d(comparable);
            }
        };
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.f(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* JADX INFO: renamed from: j0 */
    public ContiguousSet U(Comparable comparable, boolean z2, Comparable comparable2, boolean z3) {
        return (comparable.compareTo(comparable2) != 0 || z2 || z3) ? r0(Range.w(comparable, BoundType.b(z2), comparable2, BoundType.b(z3))) : new EmptyContiguousSet(this.f83870f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    /* JADX INFO: renamed from: m0 */
    public ContiguousSet X(Comparable comparable, boolean z2) {
        return r0(Range.k(comparable, BoundType.b(z2)));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public Comparable first() {
        Comparable comparableL = this.f84562g.f84558a.l(this.f83870f);
        Objects.requireNonNull(comparableL);
        return comparableL;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public Comparable last() {
        Comparable comparableJ = this.f84562g.f84559b.j(this.f83870f);
        Objects.requireNonNull(comparableJ);
        return comparableJ;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long jA = this.f83870f.a(first(), last());
        return jA >= 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : ((int) jA) + 1;
    }

    public Range t0(BoundType boundType, BoundType boundType2) {
        return Range.j(this.f84562g.f84558a.o(boundType, this.f83870f), this.f84562g.f84559b.p(boundType2, this.f83870f));
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.f84562g, this.f83870f);
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList x() {
        return this.f83870f.f83901a ? new ImmutableAsList<C>() { // from class: com.google.common.collect.RegularContiguousSet.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableAsList
            /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
            public ImmutableSortedSet P() {
                return RegularContiguousSet.this;
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
            public Comparable get(int i3) {
                Preconditions.r(i3, size());
                RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
                return regularContiguousSet.f83870f.e(regularContiguousSet.first(), i3);
            }

            @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
            Object writeReplace() {
                return super.writeReplace();
            }
        } : super.x();
    }
}
