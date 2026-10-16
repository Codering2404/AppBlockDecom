package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final NavigableMap f84817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Set f84818b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection f84819a;

        AsRanges(Collection collection) {
            this.f84819a = collection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1 */
        public Collection k2() {
            return this.f84819a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.f(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class Complement extends TreeRangeSet<C> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap f84821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final NavigableMap f84822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Range f84823c;

        private ComplementRangesByLowerBound(NavigableMap navigableMap, Range range) {
            this.f84821a = navigableMap;
            this.f84822b = new RangesByUpperBound(navigableMap);
            this.f84823c = range;
        }

        private NavigableMap g(Range range) {
            if (!this.f84823c.q(range)) {
                return ImmutableSortedMap.K();
            }
            return new ComplementRangesByLowerBound(this.f84821a, range.p(this.f84823c));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            Collection collectionValues;
            Cut cutC;
            if (this.f84823c.n()) {
                collectionValues = this.f84822b.tailMap((Cut) this.f84823c.v(), this.f84823c.u() == BoundType.CLOSED).values();
            } else {
                collectionValues = this.f84822b.values();
            }
            PeekingIterator peekingIteratorF = Iterators.F(collectionValues.iterator());
            if (this.f84823c.i(Cut.c()) && (!peekingIteratorF.hasNext() || ((Range) peekingIteratorF.peek()).f84558a != Cut.c())) {
                cutC = Cut.c();
            } else {
                if (!peekingIteratorF.hasNext()) {
                    return Iterators.m();
                }
                cutC = ((Range) peekingIteratorF.next()).f84559b;
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, cutC, peekingIteratorF) { // from class: com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.1

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                Cut f84824c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Cut f84825d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ PeekingIterator f84826f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ ComplementRangesByLowerBound f84827g;

                {
                    this.f84825d = cutC;
                    this.f84826f = peekingIteratorF;
                    this.f84827g = this;
                    this.f84824c = cutC;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    Range rangeJ;
                    if (this.f84827g.f84823c.f84559b.k(this.f84824c) || this.f84824c == Cut.a()) {
                        return (Map.Entry) b();
                    }
                    if (this.f84826f.hasNext()) {
                        Range range = (Range) this.f84826f.next();
                        rangeJ = Range.j(this.f84824c, range.f84558a);
                        this.f84824c = range.f84559b;
                    } else {
                        rangeJ = Range.j(this.f84824c, Cut.a());
                        this.f84824c = Cut.a();
                    }
                    return Maps.u(rangeJ.f84558a, rangeJ);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator b() {
            Cut cut;
            PeekingIterator peekingIteratorF = Iterators.F(this.f84822b.headMap(this.f84823c.o() ? (Cut) this.f84823c.D() : Cut.a(), this.f84823c.o() && this.f84823c.C() == BoundType.CLOSED).descendingMap().values().iterator());
            if (peekingIteratorF.hasNext()) {
                cut = ((Range) peekingIteratorF.peek()).f84559b == Cut.a() ? ((Range) peekingIteratorF.next()).f84558a : (Cut) this.f84821a.higherKey(((Range) peekingIteratorF.peek()).f84559b);
            } else {
                if (!this.f84823c.i(Cut.c()) || this.f84821a.containsKey(Cut.c())) {
                    return Iterators.m();
                }
                cut = (Cut) this.f84821a.higherKey(Cut.c());
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this, (Cut) MoreObjects.a(cut, Cut.a()), peekingIteratorF) { // from class: com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.2

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                Cut f84828c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ Cut f84829d;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ PeekingIterator f84830f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ ComplementRangesByLowerBound f84831g;

                {
                    this.f84829d = cut;
                    this.f84830f = peekingIteratorF;
                    this.f84831g = this;
                    this.f84828c = cut;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    if (this.f84828c == Cut.c()) {
                        return (Map.Entry) b();
                    }
                    if (this.f84830f.hasNext()) {
                        Range range = (Range) this.f84830f.next();
                        Range rangeJ = Range.j(range.f84559b, this.f84828c);
                        this.f84828c = range.f84558a;
                        if (this.f84831g.f84823c.f84558a.k(rangeJ.f84558a)) {
                            return Maps.u(rangeJ.f84558a, rangeJ);
                        }
                    } else if (this.f84831g.f84823c.f84558a.k(Cut.c())) {
                        Range rangeJ2 = Range.j(Cut.c(), this.f84828c);
                        this.f84828c = Cut.c();
                        return Maps.u(Cut.c(), rangeJ2);
                    }
                    return (Map.Entry) b();
                }
            };
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.f();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    Map.Entry entryFirstEntry = tailMap(cut, true).firstEntry();
                    if (entryFirstEntry != null && ((Cut) entryFirstEntry.getKey()).equals(cut)) {
                        return (Range) entryFirstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Cut cut, boolean z2) {
            return g(Range.A(cut, BoundType.b(z2)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Cut cut, boolean z2, Cut cut2, boolean z3) {
            return g(Range.w(cut, BoundType.b(z2), cut2, BoundType.b(z3)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Cut cut, boolean z2) {
            return g(Range.k(cut, BoundType.b(z2)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.L(a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SubRangeSet extends TreeRangeSet<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Range f84838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ TreeRangeSet f84839d;

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet
        public Range c(Comparable comparable) {
            Range rangeC;
            if (this.f84838c.i(comparable) && (rangeC = this.f84839d.c(comparable)) != null) {
                return rangeC.p(this.f84838c);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Range f84840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Range f84841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final NavigableMap f84842c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final NavigableMap f84843d;

        private SubRangeSetRangesByLowerBound(Range range, Range range2, NavigableMap navigableMap) {
            this.f84840a = (Range) Preconditions.t(range);
            this.f84841b = (Range) Preconditions.t(range2);
            this.f84842c = (NavigableMap) Preconditions.t(navigableMap);
            this.f84843d = new RangesByUpperBound(navigableMap);
        }

        private NavigableMap h(Range range) {
            return !range.q(this.f84840a) ? ImmutableSortedMap.K() : new SubRangeSetRangesByLowerBound(this.f84840a.p(range), this.f84841b, this.f84842c);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            final Iterator it;
            if (this.f84841b.r()) {
                return Iterators.m();
            }
            if (this.f84840a.f84559b.k(this.f84841b.f84558a)) {
                return Iterators.m();
            }
            if (this.f84840a.f84558a.k(this.f84841b.f84558a)) {
                it = this.f84843d.tailMap(this.f84841b.f84558a, false).values().iterator();
            } else {
                it = this.f84842c.tailMap((Cut) this.f84840a.f84558a.i(), this.f84840a.u() == BoundType.CLOSED).values().iterator();
            }
            final Cut cut = (Cut) Ordering.f().e(this.f84840a.f84559b, Cut.d(this.f84841b.f84559b));
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this) { // from class: com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.1

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ SubRangeSetRangesByLowerBound f84846f;

                {
                    this.f84846f = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    if (!it.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it.next();
                    if (cut.k(range.f84558a)) {
                        return (Map.Entry) b();
                    }
                    Range rangeP = range.p(this.f84846f.f84841b);
                    return Maps.u(rangeP.f84558a, rangeP);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator b() {
            if (this.f84841b.r()) {
                return Iterators.m();
            }
            Cut cut = (Cut) Ordering.f().e(this.f84840a.f84559b, Cut.d(this.f84841b.f84559b));
            final Iterator it = this.f84842c.headMap((Cut) cut.i(), cut.n() == BoundType.CLOSED).descendingMap().values().iterator();
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this) { // from class: com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.2

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ SubRangeSetRangesByLowerBound f84848d;

                {
                    this.f84848d = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    if (!it.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it.next();
                    if (this.f84848d.f84841b.f84558a.compareTo(range.f84559b) >= 0) {
                        return (Map.Entry) b();
                    }
                    Range rangeP = range.p(this.f84848d.f84841b);
                    return this.f84848d.f84840a.i(rangeP.f84558a) ? Maps.u(rangeP.f84558a, rangeP) : (Map.Entry) b();
                }
            };
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.f();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (this.f84840a.i(cut) && cut.compareTo(this.f84841b.f84558a) >= 0 && cut.compareTo(this.f84841b.f84559b) < 0) {
                        if (cut.equals(this.f84841b.f84558a)) {
                            Range range = (Range) Maps.Z(this.f84842c.floorEntry(cut));
                            if (range != null && range.f84559b.compareTo(this.f84841b.f84558a) > 0) {
                                return range.p(this.f84841b);
                            }
                        } else {
                            Range range2 = (Range) this.f84842c.get(cut);
                            if (range2 != null) {
                                return range2.p(this.f84841b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Cut cut, boolean z2) {
            return h(Range.A(cut, BoundType.b(z2)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Cut cut, boolean z2, Cut cut2, boolean z3) {
            return h(Range.w(cut, BoundType.b(z2), cut2, BoundType.b(z3)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Cut cut, boolean z2) {
            return h(Range.k(cut, BoundType.b(z2)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.L(a());
        }
    }

    @Override // com.google.common.collect.RangeSet
    public Set a() {
        Set set = this.f84818b;
        if (set != null) {
            return set;
        }
        AsRanges asRanges = new AsRanges(this.f84817a.values());
        this.f84818b = asRanges;
        return asRanges;
    }

    @Override // com.google.common.collect.AbstractRangeSet
    public Range c(Comparable comparable) {
        Preconditions.t(comparable);
        Map.Entry entryFloorEntry = this.f84817a.floorEntry(Cut.d(comparable));
        if (entryFloorEntry == null || !((Range) entryFloorEntry.getValue()).i(comparable)) {
            return null;
        }
        return (Range) entryFloorEntry.getValue();
    }

    @Override // com.google.common.collect.AbstractRangeSet
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NavigableMap f84832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Range f84833b;

        RangesByUpperBound(NavigableMap navigableMap) {
            this.f84832a = navigableMap;
            this.f84833b = Range.a();
        }

        private NavigableMap g(Range range) {
            return range.q(this.f84833b) ? new RangesByUpperBound(this.f84832a, range.p(this.f84833b)) : ImmutableSortedMap.K();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            Map.Entry entryLowerEntry;
            final Iterator it = (this.f84833b.n() && (entryLowerEntry = this.f84832a.lowerEntry((Cut) this.f84833b.v())) != null) ? this.f84833b.f84558a.k(((Range) entryLowerEntry.getValue()).f84559b) ? this.f84832a.tailMap((Cut) entryLowerEntry.getKey(), true).values().iterator() : this.f84832a.tailMap((Cut) this.f84833b.v(), true).values().iterator() : this.f84832a.values().iterator();
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this) { // from class: com.google.common.collect.TreeRangeSet.RangesByUpperBound.1

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ RangesByUpperBound f84835d;

                {
                    this.f84835d = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    if (!it.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it.next();
                    return this.f84835d.f84833b.f84559b.k(range.f84559b) ? (Map.Entry) b() : Maps.u(range.f84559b, range);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator b() {
            final PeekingIterator peekingIteratorF = Iterators.F((this.f84833b.o() ? this.f84832a.headMap((Cut) this.f84833b.D(), false).descendingMap().values() : this.f84832a.descendingMap().values()).iterator());
            if (peekingIteratorF.hasNext() && this.f84833b.f84559b.k(((Range) peekingIteratorF.peek()).f84559b)) {
                peekingIteratorF.next();
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(this) { // from class: com.google.common.collect.TreeRangeSet.RangesByUpperBound.2

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ RangesByUpperBound f84837d;

                {
                    this.f84837d = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry a() {
                    if (!peekingIteratorF.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) peekingIteratorF.next();
                    return this.f84837d.f84833b.f84558a.k(range.f84559b) ? Maps.u(range.f84559b, range) : (Map.Entry) b();
                }
            };
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return Ordering.f();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Range get(Object obj) {
            Map.Entry entryLowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (this.f84833b.i(cut) && (entryLowerEntry = this.f84832a.lowerEntry(cut)) != null && ((Range) entryLowerEntry.getValue()).f84559b.equals(cut)) {
                        return (Range) entryLowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Cut cut, boolean z2) {
            return g(Range.A(cut, BoundType.b(z2)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Cut cut, boolean z2, Cut cut2, boolean z3) {
            return g(Range.w(cut, BoundType.b(z2), cut2, BoundType.b(z3)));
        }

        @Override // java.util.NavigableMap
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Cut cut, boolean z2) {
            return g(Range.k(cut, BoundType.b(z2)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f84833b.equals(Range.a()) ? this.f84832a.isEmpty() : !a().hasNext();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f84833b.equals(Range.a()) ? this.f84832a.size() : Iterators.L(a());
        }

        private RangesByUpperBound(NavigableMap navigableMap, Range range) {
            this.f84832a = navigableMap;
            this.f84833b = range;
        }
    }
}
