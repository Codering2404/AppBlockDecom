package com.appsflyer.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class AFg1jSDK {
    public static int AFInAppEventParameterName;
    public static final Object AFKeystoreWrapper = new Object();
    public static int valueOf;
    public static int values;

    public static void AFInAppEventParameterName(int[] iArr) {
        for (int i3 = 0; i3 < iArr.length / 2; i3++) {
            int i4 = iArr[i3];
            iArr[i3] = iArr[(iArr.length - i3) - 1];
            iArr[(iArr.length - i3) - 1] = i4;
        }
    }

    public static int valueOf(int i3) {
        int[][] iArr = AFg1sSDK.AFKeystoreWrapper.AFInAppEventParameterName;
        return ((iArr[0][i3 >>> 24] + iArr[1][(i3 >>> 16) & 255]) ^ iArr[2][(i3 >>> 8) & 255]) + iArr[3][i3 & 255];
    }
}
