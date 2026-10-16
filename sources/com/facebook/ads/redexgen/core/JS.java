package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum JS {
    A03,
    A04;

    public static byte[] A00;
    public static String[] A01 = {"AGSeLGKSRVWHjwpJcBbRLkJfLT8WtSj5", "H7iAoy9xUjOjDwkyYn3gaRvOJ1nIBHLJ", "EVfEuZVSowgq13ZnxgimNyesiv2WPjJR", "wEMBUpOgjO3FJGZSz1OinbfqqxPYLP66", "CBkqendLt6fx", "OD9b4WhLx6uMipDOtSe029KXVXZlCbYX", "5yVEyiRs1KvMosNbPykruqGUah2O3DeM", "pqSqJaa9ICEXDKYBpEheNdvD5WKufuNj"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = (bArrCopyOfRange[i6] - i5) - 61;
            String[] strArr = A01;
            if (strArr[1].charAt(13) != strArr[0].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "ai0karKAJoeNx7Xk9C6gfqHAQPI6uXke";
            strArr2[7] = "u7OYJqR0ngtg88afXXFiWDXiPlKyUSBE";
            bArrCopyOfRange[i6] = (byte) i7;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-34, -35, -44, -73, -70, -78};
    }

    static {
        A01();
    }
}
