package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class ja {
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

    static int a(int i3) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i3) * (-862048943)), 15)) * 461845907);
    }

    static int a(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
