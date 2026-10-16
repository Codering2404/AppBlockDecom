package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class SortedLists {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            int b(int i3) {
                return i3 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int b(int i3) {
                return i3;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int b(int i3) {
                return ~i3;
            }
        };

        abstract int b(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            int b(Comparator comparator, Object obj, List list, int i3) {
                return i3;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            int b(Comparator comparator, Object obj, List list, int i3) {
                int size = list.size() - 1;
                while (i3 < size) {
                    int i4 = ((i3 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i4), obj) > 0) {
                        size = i4 - 1;
                    } else {
                        i3 = i4;
                    }
                }
                return i3;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            int b(Comparator comparator, Object obj, List list, int i3) {
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = (i4 + i3) >>> 1;
                    if (comparator.compare(list.get(i5), obj) < 0) {
                        i4 = i5 + 1;
                    } else {
                        i3 = i5;
                    }
                }
                return i4;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public int b(Comparator comparator, Object obj, List list, int i3) {
                return KeyPresentBehavior.LAST_PRESENT.b(comparator, obj, list, i3) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public int b(Comparator comparator, Object obj, List list, int i3) {
                return KeyPresentBehavior.FIRST_PRESENT.b(comparator, obj, list, i3) - 1;
            }
        };

        abstract int b(Comparator comparator, Object obj, List list, int i3);
    }

    public static int a(List list, Function function, Comparable comparable, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.t(comparable);
        return b(list, function, comparable, Ordering.f(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static int b(List list, Function function, Object obj, Comparator comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.p(list, function), obj, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static int c(List list, Object obj, Comparator comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.t(comparator);
        Preconditions.t(list);
        Preconditions.t(keyPresentBehavior);
        Preconditions.t(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = new ArrayList(list);
        }
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i4 = (i3 + size) >>> 1;
            int iCompare = comparator.compare(obj, list.get(i4));
            if (iCompare < 0) {
                size = i4 - 1;
            } else {
                if (iCompare <= 0) {
                    return i3 + keyPresentBehavior.b(comparator, obj, list.subList(i3, size + 1), i4 - i3);
                }
                i3 = i4 + 1;
            }
        }
        return keyAbsentBehavior.b(i3);
    }
}
