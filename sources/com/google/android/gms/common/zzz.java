package com.google.android.gms.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzz {
    static int a(int i3) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i4 = 0; i4 < 6; i4++) {
            int i5 = iArr[i4];
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            if (i6 == i3) {
                return i5;
            }
        }
        return 1;
    }
}
