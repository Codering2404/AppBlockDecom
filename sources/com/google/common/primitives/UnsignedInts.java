package com.google.common.primitives;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedInts {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                int i4 = iArr[i3];
                int i5 = iArr2[i3];
                if (i4 != i5) {
                    return UnsignedInts.a(i4, i5);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    public static int a(int i3, int i4) {
        return Ints.e(b(i3), b(i4));
    }

    static int b(int i3) {
        return i3 ^ Integer.MIN_VALUE;
    }

    public static int c(int i3, int i4) {
        return (int) (d(i3) % d(i4));
    }

    public static long d(int i3) {
        return ((long) i3) & 4294967295L;
    }

    public static String e(int i3, int i4) {
        return Long.toString(((long) i3) & 4294967295L, i4);
    }
}
