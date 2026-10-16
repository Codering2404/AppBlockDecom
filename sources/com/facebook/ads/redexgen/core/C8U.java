package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8U implements InterfaceC1972mF {
    public static byte[] A06;
    public static String[] A07 = {"QubeI9WU03qBZcNvE4IUkWvlw0NRrBK6", "F1d068LLA73yClDAGmhas6o", "9YpbVeLOd0f6m", "7Ycu3nAZXESMUbUrutcG9271koISuOhT", "QjcyZL4t35rbWMpE5hp6oYgD7sVhkS0D", "M48I8dHdEQTg0rHaHaNT6qI1", "cVfJzOsNywAlxLknvQSr1dDTMZn5TIAU", "kJeh17rnzHgOQ2HfO7oDpw4wPPnH7lFe"};
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long[] A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C8U A01(long j3, long j4, HN hn, C04554v c04554v) {
        int iA0L;
        int i3 = hn.A04;
        int i4 = hn.A03;
        int iA0C = c04554v.A0C();
        if ((iA0C & 1) != 1 || (iA0L = c04554v.A0L()) == 0) {
            return null;
        }
        long jA0U = C5C.A0U(iA0L, ((long) i3) * 1000000, i4);
        if ((iA0C & 6) != 6) {
            return new C8U(j4, hn.A02, jA0U);
        }
        long jA0Q = c04554v.A0Q();
        long[] jArr = new long[100];
        for (int i5 = 0; i5 < 100; i5++) {
            jArr[i5] = c04554v.A0I();
        }
        if (j3 != -1 && j3 != j4 + jA0Q) {
            AbstractC04404g.A07(A02(27, 10, 78), A02(2, 25, 105) + j3 + A02(0, 2, 40) + (j4 + jA0Q));
        }
        return new C8U(j4, hn.A02, jA0U, jA0Q, jArr);
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A07;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A07[2] = "La6";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 30);
            i6++;
        }
    }

    public static void A03() {
        A06 = new byte[]{114, 102, -33, -48, -43, -50, -89, -21, -24, -5, -24, -89, -6, -16, 1, -20, -89, -12, -16, -6, -12, -24, -5, -22, -17, -63, -89, -60, -43, -38, -45, -65, -47, -47, -41, -47, -34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        double d3;
        if (!AAj()) {
            return new HX(new HZ(0L, this.A03 + ((long) this.A00)));
        }
        long jA0T = C5C.A0T(j3, 0L, this.A04);
        double d4 = (jA0T * 100.0d) / this.A04;
        if (d4 <= 0.0d) {
            d3 = 0.0d;
        } else if (d4 >= 100.0d) {
            d3 = 256.0d;
        } else {
            int i3 = (int) d4;
            double d5 = ((long[]) AbstractC04323y.A02(this.A05))[i3];
            d3 = (((i3 == 99 ? 256.0d : r9[i3 + 1]) - d5) * (d4 - ((double) i3))) + d5;
        }
        return new HX(new HZ(jA0T, this.A03 + C5C.A0T(Math.round((d3 / 256.0d) * this.A02), this.A00, this.A02 - 1)));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A9H(long j3) {
        long j4 = j3 - this.A03;
        if (!AAj() || j4 <= this.A00) {
            return 0L;
        }
        long[] jArr = (long[]) AbstractC04323y.A02(this.A05);
        double d3 = (j4 * 256.0d) / this.A02;
        int iA0L = C5C.A0L(jArr, (long) d3, true, true);
        long jA00 = A00(iA0L);
        long j5 = jArr[iA0L];
        long jA002 = A00(iA0L + 1);
        long j6 = iA0L == 99 ? 256L : jArr[iA0L + 1];
        String[] strArr = A07;
        if (strArr[0].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A07[6] = "PlWtaQzxKmV3LAe12cSeUsJTirSwbfkK";
        return Math.round((jA002 - jA00) * (j5 == j6 ? 0.0d : (d3 - j5) / (j6 - j5))) + jA00;
    }

    static {
        A03();
    }

    public C8U(long j3, int i3, long j4) {
        this(j3, i3, j4, -1L, null);
    }

    public C8U(long j3, int i3, long j4, long j5, long[] jArr) {
        this.A03 = j3;
        this.A00 = i3;
        this.A04 = j4;
        this.A05 = jArr;
        this.A02 = j5;
        this.A01 = j5 != -1 ? j3 + j5 : -1L;
    }

    private long A00(int i3) {
        return (this.A04 * ((long) i3)) / 100;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A7j() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return this.A05 != null;
    }
}
