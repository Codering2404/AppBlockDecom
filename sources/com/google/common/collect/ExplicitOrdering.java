package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ImmutableMap f83927a;

    private int m(Object obj) {
        Integer num = (Integer) this.f83927a.get(obj);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(obj);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return m(obj) - m(obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.f83927a.equals(((ExplicitOrdering) obj).f83927a);
        }
        return false;
    }

    public int hashCode() {
        return this.f83927a.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.f83927a.keySet() + ")";
    }
}
