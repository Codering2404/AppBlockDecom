package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ImmutableRangeSet f84094b = new ImmutableRangeSet(ImmutableList.y());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ImmutableRangeSet f84095c = new ImmutableRangeSet(ImmutableList.z(Range.a()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final transient ImmutableList f84096a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AsSet extends ImmutableSortedSet<C> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final DiscreteDomain f84101f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private transient Integer f84102g;

        AsSet(DiscreteDomain discreteDomain) {
            super(Ordering.f());
            this.f84101f = discreteDomain;
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet J() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: K */
        public UnmodifiableIterator descendingIterator() {
            return new AbstractIterator<C>() { // from class: com.google.common.collect.ImmutableRangeSet.AsSet.2

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final Iterator f84107c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Iterator f84108d = Iterators.m();

                {
                    this.f84107c = ImmutableRangeSet.this.f84096a.J().iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Comparable a() {
                    while (!this.f84108d.hasNext()) {
                        if (!this.f84107c.hasNext()) {
                            return (Comparable) b();
                        }
                        this.f84108d = ContiguousSet.a0((Range) this.f84107c.next(), AsSet.this.f84101f).descendingIterator();
                    }
                    return (Comparable) this.f84108d.next();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet Q(Comparable comparable, boolean z2) {
            return c0(Range.A(comparable, BoundType.b(z2)));
        }

        ImmutableSortedSet c0(Range range) {
            return ImmutableRangeSet.this.m(range).g(this.f84101f);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.b((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet U(Comparable comparable, boolean z2, Comparable comparable2, boolean z3) {
            return (z2 || z3 || Range.h(comparable, comparable2) != 0) ? c0(Range.w(comparable, BoundType.b(z2), comparable2, BoundType.b(z3))) : ImmutableSortedSet.R();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet X(Comparable comparable, boolean z2) {
            return c0(Range.k(comparable, BoundType.b(z2)));
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return ImmutableRangeSet.this.f84096a.g();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return new AbstractIterator<C>() { // from class: com.google.common.collect.ImmutableRangeSet.AsSet.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final Iterator f84104c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                Iterator f84105d = Iterators.m();

                {
                    this.f84104c = ImmutableRangeSet.this.f84096a.iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Comparable a() {
                    while (!this.f84105d.hasNext()) {
                        if (!this.f84104c.hasNext()) {
                            return (Comparable) b();
                        }
                        this.f84105d = ContiguousSet.a0((Range) this.f84104c.next(), AsSet.this.f84101f).iterator();
                    }
                    return (Comparable) this.f84105d.next();
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer numValueOf = this.f84102g;
            if (numValueOf == null) {
                UnmodifiableIterator it = ImmutableRangeSet.this.f84096a.iterator();
                long size = 0;
                while (it.hasNext()) {
                    size += (long) ContiguousSet.a0((Range) it.next(), this.f84101f).size();
                    if (size >= 2147483647L) {
                        break;
                    }
                }
                numValueOf = Integer.valueOf(Ints.m(size));
                this.f84102g = numValueOf;
            }
            return numValueOf.intValue();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.f84096a.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.f84096a, this.f84101f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f84110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DiscreteDomain f84111b;

        AsSetSerializedForm(ImmutableList immutableList, DiscreteDomain discreteDomain) {
            this.f84110a = immutableList;
            this.f84111b = discreteDomain;
        }

        Object readResolve() {
            return new ImmutableRangeSet(this.f84110a).g(this.f84111b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<C extends Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f84112a = Lists.i();

        public Builder a(Range range) {
            Preconditions.m(!range.r(), "range must not be empty, but was %s", range);
            this.f84112a.add(range);
            return this;
        }

        public Builder b(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a((Range) it.next());
            }
            return this;
        }

        public ImmutableRangeSet c() {
            ImmutableList.Builder builder = new ImmutableList.Builder(this.f84112a.size());
            Collections.sort(this.f84112a, Range.x());
            PeekingIterator peekingIteratorF = Iterators.F(this.f84112a.iterator());
            while (peekingIteratorF.hasNext()) {
                Range rangeY = (Range) peekingIteratorF.next();
                while (peekingIteratorF.hasNext()) {
                    Range range = (Range) peekingIteratorF.peek();
                    if (rangeY.q(range)) {
                        Preconditions.o(rangeY.p(range).r(), "Overlapping ranges not permitted but found %s overlapping %s", rangeY, range);
                        rangeY = rangeY.y((Range) peekingIteratorF.next());
                    }
                }
                builder.a(rangeY);
            }
            ImmutableList immutableListM = builder.m();
            return immutableListM.isEmpty() ? ImmutableRangeSet.k() : (immutableListM.size() == 1 && ((Range) Iterables.m(immutableListM)).equals(Range.a())) ? ImmutableRangeSet.e() : new ImmutableRangeSet(immutableListM);
        }

        Builder d(Builder builder) {
            b(builder.f84112a);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ComplementRanges extends ImmutableList<Range<C>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f84113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f84114d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f84115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ImmutableRangeSet f84116g;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public Range get(int i3) {
            Preconditions.r(i3, this.f84115f);
            return Range.j(this.f84113c ? i3 == 0 ? Cut.c() : ((Range) this.f84116g.f84096a.get(i3 - 1)).f84559b : ((Range) this.f84116g.f84096a.get(i3)).f84559b, (this.f84114d && i3 == this.f84115f + (-1)) ? Cut.a() : ((Range) this.f84116g.f84096a.get(i3 + (!this.f84113c ? 1 : 0))).f84558a);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f84115f;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SerializedForm<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableList f84117a;

        SerializedForm(ImmutableList immutableList) {
            this.f84117a = immutableList;
        }

        Object readResolve() {
            return this.f84117a.isEmpty() ? ImmutableRangeSet.k() : this.f84117a.equals(ImmutableList.z(Range.a())) ? ImmutableRangeSet.e() : new ImmutableRangeSet(this.f84117a);
        }
    }

    ImmutableRangeSet(ImmutableList immutableList) {
        this.f84096a = immutableList;
    }

    static ImmutableRangeSet e() {
        return f84095c;
    }

    public static Builder h() {
        return new Builder();
    }

    private ImmutableList i(final Range range) {
        if (this.f84096a.isEmpty() || range.r()) {
            return ImmutableList.y();
        }
        if (range.l(l())) {
            return this.f84096a;
        }
        final int iA = range.n() ? SortedLists.a(this.f84096a, new Function() { // from class: com.google.common.collect.t
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((Range) obj).B();
            }
        }, range.f84558a, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        final int iA2 = (range.o() ? SortedLists.a(this.f84096a, new s(), range.f84559b, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : this.f84096a.size()) - iA;
        return iA2 == 0 ? ImmutableList.y() : new ImmutableList<Range<C>>(this) { // from class: com.google.common.collect.ImmutableRangeSet.1

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ ImmutableRangeSet f84100g;

            {
                this.f84100g = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.List
            /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
            public Range get(int i3) {
                Preconditions.r(i3, iA2);
                return (i3 == 0 || i3 == iA2 + (-1)) ? ((Range) this.f84100g.f84096a.get(i3 + iA)).p(range) : (Range) this.f84100g.f84096a.get(i3 + iA);
            }

            @Override // com.google.common.collect.ImmutableCollection
            boolean g() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return iA2;
            }

            @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
            Object writeReplace() {
                return super.writeReplace();
            }
        };
    }

    public static ImmutableRangeSet k() {
        return f84094b;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.AbstractRangeSet
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return super.b(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractRangeSet
    public Range c(Comparable comparable) {
        int iB = SortedLists.b(this.f84096a, new s(), Cut.d(comparable), Ordering.f(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (iB != -1) {
            Range range = (Range) this.f84096a.get(iB);
            if (range.i(comparable)) {
                return range;
            }
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractRangeSet
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.RangeSet
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ImmutableSet a() {
        return this.f84096a.isEmpty() ? ImmutableSet.z() : new RegularImmutableSortedSet(this.f84096a, Range.x());
    }

    public ImmutableSortedSet g(DiscreteDomain discreteDomain) {
        Preconditions.t(discreteDomain);
        if (j()) {
            return ImmutableSortedSet.R();
        }
        Range rangeE = l().e(discreteDomain);
        if (!rangeE.n()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!rangeE.o()) {
            try {
                discreteDomain.b();
            } catch (NoSuchElementException unused) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new AsSet(discreteDomain);
    }

    public boolean j() {
        return this.f84096a.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Range l() {
        if (this.f84096a.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.j(((Range) this.f84096a.get(0)).f84558a, ((Range) this.f84096a.get(r1.size() - 1)).f84559b);
    }

    public ImmutableRangeSet m(Range range) {
        if (!j()) {
            Range rangeL = l();
            if (range.l(rangeL)) {
                return this;
            }
            if (range.q(rangeL)) {
                return new ImmutableRangeSet(i(range));
            }
        }
        return k();
    }

    Object writeReplace() {
        return new SerializedForm(this.f84096a);
    }
}
