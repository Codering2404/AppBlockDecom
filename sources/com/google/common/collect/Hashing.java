package com.google.common.collect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Hashing {
    static int a(int i3, double d3) {
        int iMax = Math.max(i3, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d3 * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i4 = iHighestOneBit << 1;
        if (i4 > 0) {
            return i4;
        }
        return 1073741824;
    }

    static boolean b(int i3, int i4, double d3) {
        return ((double) i3) > d3 * ((double) i4) && i4 < 1073741824;
    }

    static int c(int i3) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i3) * (-862048943)), 15)) * 461845907);
    }

    static int d(Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
