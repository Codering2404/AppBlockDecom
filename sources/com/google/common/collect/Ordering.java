package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class Ordering<T> implements Comparator<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ArbitraryOrdering extends Ordering<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f84553a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentMap f84554b = Platform.h(new MapMaker()).i();

        ArbitraryOrdering() {
        }

        private Integer m(Object obj) {
            Integer numValueOf = (Integer) this.f84554b.get(obj);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.f84553a.getAndIncrement());
                Integer num = (Integer) this.f84554b.putIfAbsent(obj, numValueOf);
                if (num != null) {
                    return num;
                }
            }
            return numValueOf;
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int iN = n(obj);
            int iN2 = n(obj2);
            if (iN != iN2) {
                return iN < iN2 ? -1 : 1;
            }
            int iCompareTo = m(obj).compareTo(m(obj2));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            throw new AssertionError();
        }

        int n(Object obj) {
            return System.identityHashCode(obj);
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ArbitraryOrderingHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Ordering f84555a = new ArbitraryOrdering();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84556a;

        IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.f84556a = obj;
        }
    }

    protected Ordering() {
    }

    public static Ordering b(Comparator comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public static Ordering f() {
        return NaturalOrdering.f84534c;
    }

    public Ordering a(Comparator comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.t(comparator));
    }

    public ImmutableList c(Iterable iterable) {
        return ImmutableList.K(this, iterable);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public Object d(Object obj, Object obj2) {
        return compare(obj, obj2) >= 0 ? obj : obj2;
    }

    public Object e(Object obj, Object obj2) {
        return compare(obj, obj2) <= 0 ? obj : obj2;
    }

    public Ordering g() {
        return new NullsFirstOrdering(this);
    }

    public Ordering h() {
        return new NullsLastOrdering(this);
    }

    Ordering i() {
        return j(Maps.w());
    }

    public Ordering j(Function function) {
        return new ByFunctionOrdering(function, this);
    }

    public Ordering k() {
        return new ReverseOrdering(this);
    }

    public List l(Iterable iterable) {
        Object[] objArrU = Iterables.u(iterable);
        Arrays.sort(objArrU, this);
        return Lists.j(Arrays.asList(objArrU));
    }
}
