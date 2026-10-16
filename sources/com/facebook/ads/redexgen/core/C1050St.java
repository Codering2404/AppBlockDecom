package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.St, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1050St {
    public static byte[] A09;
    public long A00;
    public Integer A01;
    public String A02;
    public String A03;
    public boolean A04;
    public boolean A05;
    public final String A06;
    public final String A07;
    public final String A08;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{-107, -104, -118, -115};
    }

    public C1050St(String str, String str2, String str3) {
        this.A03 = A00(0, 0, 68);
        this.A02 = A00(0, 4, 27);
        this.A00 = -1L;
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
    }

    public C1050St(String str, String str2, String str3, long j3) {
        this.A03 = A00(0, 0, 68);
        this.A02 = A00(0, 4, 27);
        this.A00 = -1L;
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
        this.A00 = j3;
    }
}
