package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Booleans {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean[] f85435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85436b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85437c;

        BooleanArrayAsList(boolean[] zArr, int i3, int i4) {
            this.f85435a = zArr;
            this.f85436b = i3;
            this.f85437c = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean get(int i3) {
            Preconditions.r(i3, size());
            return Boolean.valueOf(this.f85435a[this.f85436b + i3]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean set(int i3, Boolean bool) {
            Preconditions.r(i3, size());
            boolean[] zArr = this.f85435a;
            int i4 = this.f85436b;
            boolean z2 = zArr[i4 + i3];
            zArr[i4 + i3] = ((Boolean) Preconditions.t(bool)).booleanValue();
            return Boolean.valueOf(z2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Boolean) && Booleans.e(this.f85435a, ((Boolean) obj).booleanValue(), this.f85436b, this.f85437c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BooleanArrayAsList)) {
                return super.equals(obj);
            }
            BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
            int size = size();
            if (booleanArrayAsList.size() != size) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (this.f85435a[this.f85436b + i3] != booleanArrayAsList.f85435a[booleanArrayAsList.f85436b + i3]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iD = 1;
            for (int i3 = this.f85436b; i3 < this.f85437c; i3++) {
                iD = (iD * 31) + Booleans.d(this.f85435a[i3]);
            }
            return iD;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iE;
            if (!(obj instanceof Boolean) || (iE = Booleans.e(this.f85435a, ((Boolean) obj).booleanValue(), this.f85436b, this.f85437c)) < 0) {
                return -1;
            }
            return iE - this.f85436b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iF;
            if (!(obj instanceof Boolean) || (iF = Booleans.f(this.f85435a, ((Boolean) obj).booleanValue(), this.f85436b, this.f85437c)) < 0) {
                return -1;
            }
            return iF - this.f85436b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f85437c - this.f85436b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i3, int i4) {
            Preconditions.y(i3, i4, size());
            if (i3 == i4) {
                return Collections.EMPTY_LIST;
            }
            boolean[] zArr = this.f85435a;
            int i5 = this.f85436b;
            return new BooleanArrayAsList(zArr, i3 + i5, i5 + i4);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 7);
            sb.append(this.f85435a[this.f85436b] ? "[true" : "[false");
            int i3 = this.f85436b;
            while (true) {
                i3++;
                if (i3 >= this.f85437c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(this.f85435a[i3] ? ", true" : ", false");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f85441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f85442b;

        BooleanComparator(int i3, String str) {
            this.f85441a = i3;
            this.f85442b = str;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(Boolean bool, Boolean bool2) {
            return (bool2.booleanValue() ? this.f85441a : 0) - (bool.booleanValue() ? this.f85441a : 0);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f85442b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int iMin = Math.min(zArr.length, zArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int iCompare = Boolean.compare(zArr[i3], zArr2[i3]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return zArr.length - zArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    public static boolean c(boolean[] zArr, boolean z2) {
        for (boolean z3 : zArr) {
            if (z3 == z2) {
                return true;
            }
        }
        return false;
    }

    public static int d(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(boolean[] zArr, boolean z2, int i3, int i4) {
        while (i3 < i4) {
            if (zArr[i3] == z2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(boolean[] zArr, boolean z2, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            if (zArr[i5] == z2) {
                return i5;
            }
        }
        return -1;
    }
}
