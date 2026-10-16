package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ui {
    public static int a(int i3, int i4) {
        for (int i5 = 1; i5 <= 2; i5++) {
            int i6 = (i3 + i5) % 3;
            if (b(i6, i4)) {
                return i6;
            }
        }
        return i3;
    }

    public static boolean b(int i3, int i4) {
        if (i3 != 0) {
            return i3 != 1 ? i3 == 2 && (i4 & 2) != 0 : (i4 & 1) != 0;
        }
        return true;
    }
}
