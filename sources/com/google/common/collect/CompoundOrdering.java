package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Comparator[] f83858a;

    CompoundOrdering(Comparator comparator, Comparator comparator2) {
        this.f83858a = new Comparator[]{comparator, comparator2};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i3 = 0;
        while (true) {
            Comparator[] comparatorArr = this.f83858a;
            if (i3 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i3].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i3++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.f83858a, ((CompoundOrdering) obj).f83858a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f83858a);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f83858a) + ")";
    }
}
