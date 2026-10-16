package com.facebook.ads.redexgen.core;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class P5 {
    public static String[] A00 = {"nDiC2V", "xvPzB4voGkHgvzabNn8fejRwCVSwo6Ah", "OJIGMHO1ySc0mzACRtkWxwocBaSnW5m2", "JbsfTTx", "hwYl", "U04BYM1NuctRYg5sssH2", "d2TQ", "mxYxJu"};
    public static final int[] A01 = new int[0];
    public static final long[] A02 = new long[0];
    public static final Object[] A03 = new Object[0];

    public static int A00(int i3) {
        return A01(i3 * 8) / 8;
    }

    public static int A01(int i3) {
        int i4 = 4;
        while (A00[5].length() == 20) {
            A00[5] = "sf2HjvEbKVwFe9jamb5q";
            if (i4 >= 32) {
                return i3;
            }
            int i5 = 1 << i4;
            if (i3 <= i5 - 12) {
                int i6 = (1 << i4) - 12;
                return i6;
            }
            i4++;
        }
        throw new RuntimeException();
    }

    public static int A02(int[] iArr, int i3, int i4) {
        int midVal = 0;
        int i5 = i3 - 1;
        while (midVal <= i5) {
            int i6 = midVal + i5;
            String[] strArr = A00;
            String str = strArr[1];
            String str2 = strArr[2];
            int hi = str.charAt(26);
            int lo = str2.charAt(26);
            if (hi != lo) {
                throw new RuntimeException();
            }
            A00[3] = "GyF3CdngjgIBS8WP";
            int hi2 = i6 >>> 1;
            int lo2 = iArr[hi2];
            if (lo2 < i4) {
                midVal = hi2 + 1;
            } else if (lo2 > i4) {
                i5 = hi2 - 1;
            } else {
                return hi2;
            }
        }
        int lo3 = ~midVal;
        return lo3;
    }

    public static int A03(long[] jArr, int i3, long j3) {
        int i4 = 0;
        int i5 = i3 - 1;
        while (i4 <= i5) {
            int lo = i4 + i5;
            int i6 = lo >>> 1;
            long j4 = jArr[i6];
            if (j4 < j3) {
                i4 = i6 + 1;
            } else {
                String[] strArr = A00;
                String str = strArr[4];
                String str2 = strArr[6];
                int hi = str.length();
                int lo2 = str2.length();
                if (hi != lo2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[4] = "jlrm";
                strArr2[6] = "MXd0";
                if (j4 > j3) {
                    i5 = i6 - 1;
                } else {
                    return i6;
                }
            }
        }
        int lo3 = ~i4;
        return lo3;
    }

    public static boolean A04(@Nullable Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
