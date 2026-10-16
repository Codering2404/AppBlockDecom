package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final NaturalOrdering f84534c = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Ordering f84535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Ordering f84536b;

    private NaturalOrdering() {
    }

    private Object readResolve() {
        return f84534c;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering g() {
        Ordering ordering = this.f84535a;
        if (ordering != null) {
            return ordering;
        }
        Ordering orderingG = super.g();
        this.f84535a = orderingG;
        return orderingG;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering h() {
        Ordering ordering = this.f84536b;
        if (ordering != null) {
            return ordering;
        }
        Ordering orderingH = super.h();
        this.f84536b = orderingH;
        return orderingH;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering k() {
        return ReverseNaturalOrdering.f84619a;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.t(comparable);
        Preconditions.t(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
