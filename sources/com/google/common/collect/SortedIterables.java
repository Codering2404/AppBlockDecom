package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class SortedIterables {
    public static Comparator a(SortedSet sortedSet) {
        Comparator comparator = sortedSet.comparator();
        return comparator == null ? Ordering.f() : comparator;
    }

    public static boolean b(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        Preconditions.t(comparator);
        Preconditions.t(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof SortedIterable)) {
                return false;
            }
            comparator2 = ((SortedIterable) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
