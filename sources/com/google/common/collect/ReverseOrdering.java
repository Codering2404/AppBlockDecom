package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Ordering f84620a;

    ReverseOrdering(Ordering ordering) {
        this.f84620a = (Ordering) Preconditions.t(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f84620a.compare(obj2, obj);
    }

    @Override // com.google.common.collect.Ordering
    public Object d(Object obj, Object obj2) {
        return this.f84620a.e(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Object e(Object obj, Object obj2) {
        return this.f84620a.d(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.f84620a.equals(((ReverseOrdering) obj).f84620a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f84620a.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public Ordering k() {
        return this.f84620a;
    }

    public String toString() {
        return this.f84620a + ".reverse()";
    }
}
