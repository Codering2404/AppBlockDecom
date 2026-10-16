package com.google.common.collect;

import java.lang.Comparable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    AbstractRangeSet() {
    }

    public boolean b(Comparable comparable) {
        return c(comparable) != null;
    }

    public abstract Range c(Comparable comparable);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return a().equals(((RangeSet) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
