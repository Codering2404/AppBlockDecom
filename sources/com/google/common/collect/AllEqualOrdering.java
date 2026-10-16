package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class AllEqualOrdering extends Ordering<Object> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final AllEqualOrdering f83759a = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    AllEqualOrdering() {
    }

    private Object readResolve() {
        return f83759a;
    }

    @Override // com.google.common.collect.Ordering
    public ImmutableList c(Iterable iterable) {
        return ImmutableList.s(iterable);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public List l(Iterable iterable) {
        return Lists.j(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }

    @Override // com.google.common.collect.Ordering
    public Ordering k() {
        return this;
    }
}
