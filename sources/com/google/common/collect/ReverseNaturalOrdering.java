package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ReverseNaturalOrdering f84619a = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    private ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return f84619a;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering k() {
        return Ordering.f();
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.t(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Comparable d(Comparable comparable, Comparable comparable2) {
        return (Comparable) NaturalOrdering.f84534c.e(comparable, comparable2);
    }

    @Override // com.google.common.collect.Ordering
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Comparable e(Comparable comparable, Comparable comparable2) {
        return (Comparable) NaturalOrdering.f84534c.d(comparable, comparable2);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
