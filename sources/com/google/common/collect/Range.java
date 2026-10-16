package com.google.common.collect;

import com.facebook.FacebookContentProvider;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.lang.Comparable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Range f84557c = new Range(Cut.c(), Cut.a());
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Cut f84558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Cut f84559b;

    /* JADX INFO: renamed from: com.google.common.collect.Range$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f84560a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f84560a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f84560a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Ordering f84561a = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public int compare(Range range, Range range2) {
            return ComparisonChain.k().f(range.f84558a, range2.f84558a).f(range.f84559b, range2.f84559b).j();
        }
    }

    private Range(Cut cut, Cut cut2) {
        this.f84558a = (Cut) Preconditions.t(cut);
        this.f84559b = (Cut) Preconditions.t(cut2);
        if (cut.compareTo(cut2) > 0 || cut == Cut.a() || cut2 == Cut.c()) {
            throw new IllegalArgumentException("Invalid range: " + z(cut, cut2));
        }
    }

    public static Range A(Comparable comparable, BoundType boundType) {
        int i3 = AnonymousClass1.f84560a[boundType.ordinal()];
        if (i3 == 1) {
            return s(comparable);
        }
        if (i3 == 2) {
            return d(comparable);
        }
        throw new AssertionError();
    }

    public static Range a() {
        return f84557c;
    }

    public static Range c(Comparable comparable) {
        return j(Cut.d(comparable), Cut.a());
    }

    public static Range d(Comparable comparable) {
        return j(Cut.c(), Cut.b(comparable));
    }

    public static Range f(Comparable comparable, Comparable comparable2) {
        return j(Cut.d(comparable), Cut.b(comparable2));
    }

    public static Range g(Comparable comparable, Comparable comparable2) {
        return j(Cut.d(comparable), Cut.d(comparable2));
    }

    static int h(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    static Range j(Cut cut, Cut cut2) {
        return new Range(cut, cut2);
    }

    public static Range k(Comparable comparable, BoundType boundType) {
        int i3 = AnonymousClass1.f84560a[boundType.ordinal()];
        if (i3 == 1) {
            return m(comparable);
        }
        if (i3 == 2) {
            return c(comparable);
        }
        throw new AssertionError();
    }

    public static Range m(Comparable comparable) {
        return j(Cut.b(comparable), Cut.a());
    }

    public static Range s(Comparable comparable) {
        return j(Cut.c(), Cut.d(comparable));
    }

    public static Range w(Comparable comparable, BoundType boundType, Comparable comparable2, BoundType boundType2) {
        Preconditions.t(boundType);
        Preconditions.t(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return j(boundType == boundType3 ? Cut.b(comparable) : Cut.d(comparable), boundType2 == boundType3 ? Cut.d(comparable2) : Cut.b(comparable2));
    }

    static Ordering x() {
        return RangeLexOrdering.f84561a;
    }

    private static String z(Cut cut, Cut cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.g(sb);
        sb.append(FacebookContentProvider.INVALID_FILE_NAME);
        cut2.h(sb);
        return sb.toString();
    }

    Cut B() {
        return this.f84559b;
    }

    public BoundType C() {
        return this.f84559b.n();
    }

    public Comparable D() {
        return this.f84559b.i();
    }

    @Override // com.google.common.base.Predicate
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean apply(Comparable comparable) {
        return i(comparable);
    }

    public Range e(DiscreteDomain discreteDomain) {
        Preconditions.t(discreteDomain);
        Cut cutE = this.f84558a.e(discreteDomain);
        Cut cutE2 = this.f84559b.e(discreteDomain);
        return (cutE == this.f84558a && cutE2 == this.f84559b) ? this : j(cutE, cutE2);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(Object obj) {
        if (obj instanceof Range) {
            Range range = (Range) obj;
            if (this.f84558a.equals(range.f84558a) && this.f84559b.equals(range.f84559b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f84558a.hashCode() * 31) + this.f84559b.hashCode();
    }

    public boolean i(Comparable comparable) {
        Preconditions.t(comparable);
        return this.f84558a.k(comparable) && !this.f84559b.k(comparable);
    }

    public boolean l(Range range) {
        return this.f84558a.compareTo(range.f84558a) <= 0 && this.f84559b.compareTo(range.f84559b) >= 0;
    }

    public boolean n() {
        return this.f84558a != Cut.c();
    }

    public boolean o() {
        return this.f84559b != Cut.a();
    }

    public Range p(Range range) {
        int iF = this.f84558a.compareTo(range.f84558a);
        int iF2 = this.f84559b.compareTo(range.f84559b);
        if (iF >= 0 && iF2 <= 0) {
            return this;
        }
        if (iF <= 0 && iF2 >= 0) {
            return range;
        }
        Cut cut = iF >= 0 ? this.f84558a : range.f84558a;
        Cut cut2 = iF2 <= 0 ? this.f84559b : range.f84559b;
        Preconditions.o(cut.compareTo(cut2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return j(cut, cut2);
    }

    public boolean q(Range range) {
        return this.f84558a.compareTo(range.f84559b) <= 0 && range.f84558a.compareTo(this.f84559b) <= 0;
    }

    public boolean r() {
        return this.f84558a.equals(this.f84559b);
    }

    Object readResolve() {
        return equals(f84557c) ? a() : this;
    }

    Cut t() {
        return this.f84558a;
    }

    public String toString() {
        return z(this.f84558a, this.f84559b);
    }

    public BoundType u() {
        return this.f84558a.m();
    }

    public Comparable v() {
        return this.f84558a.i();
    }

    public Range y(Range range) {
        int iF = this.f84558a.compareTo(range.f84558a);
        int iF2 = this.f84559b.compareTo(range.f84559b);
        if (iF <= 0 && iF2 >= 0) {
            return this;
        }
        if (iF < 0 || iF2 > 0) {
            return j(iF <= 0 ? this.f84558a : range.f84558a, iF2 >= 0 ? this.f84559b : range.f84559b);
        }
        return range;
    }
}
