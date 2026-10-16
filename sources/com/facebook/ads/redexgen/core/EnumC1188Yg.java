package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1188Yg {
    A08(C0962Pe.A0D, -1, -15986668, 858468406, true),
    A09(C0962Pe.A0E, Integer.MIN_VALUE, -1, 452984831, false);

    public static byte[] A05;
    public static String[] A06 = {"V62FSpXyXg0rt4sPiNo", "6lq6AHOCdAk9akPwvyC", "nqUSJeC0aIJYgUKl2CPVEyh1brd6E0Ae", "x0NdoFH36D", "29PPikSq1e", "88nHmfXS0I", "EpErG0pNHZnmsJ1", "e2q5yIycFm4TxUxK8s9XbNDHLyuGtCe3"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final Integer A03;
    public final boolean A04;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-33, -30, -15, -34, -35, -30, -24, -21, -35, -16};
    }

    static {
        A01();
    }

    EnumC1188Yg(Integer num, int i3, int i4, int i5, boolean z2) {
        this.A03 = num;
        this.A00 = i3;
        this.A01 = i4;
        this.A02 = i5;
        this.A04 = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1188Yg[] valuesCustom() {
        EnumC1188Yg[] enumC1188YgArr = (EnumC1188Yg[]) values().clone();
        if (A06[3].length() != 10) {
            throw new RuntimeException();
        }
        A06[3] = "b4MYrm3ZFw";
        return enumC1188YgArr;
    }
}
