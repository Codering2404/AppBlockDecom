package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFg1vSDK {
    public static void AFKeystoreWrapper(int i3, int i4, boolean z2, int i5, int[] iArr, int[][] iArr2, int[] iArr3) {
        if (!z2) {
            AFKeystoreWrapper(iArr);
        }
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i3 ^ iArr[i6];
            int iAFKeystoreWrapper = i4 ^ AFKeystoreWrapper(i7, iArr2);
            i6++;
            i4 = i7;
            i3 = iAFKeystoreWrapper;
        }
        int i8 = i3 ^ iArr[iArr.length - 2];
        int i9 = i4 ^ iArr[iArr.length - 1];
        if (!z2) {
            AFKeystoreWrapper(iArr);
        }
        iArr3[0] = i9;
        iArr3[1] = i8;
    }

    private static void AFKeystoreWrapper(int[] iArr) {
        for (int i3 = 0; i3 < iArr.length / 2; i3++) {
            int i4 = iArr[i3];
            iArr[i3] = iArr[(iArr.length - i3) - 1];
            iArr[(iArr.length - i3) - 1] = i4;
        }
    }

    private static int AFKeystoreWrapper(int i3, int[][] iArr) {
        return ((iArr[0][i3 >>> 24] + iArr[1][(i3 >>> 16) & 255]) ^ iArr[2][(i3 >>> 8) & 255]) + iArr[3][i3 & 255];
    }
}
