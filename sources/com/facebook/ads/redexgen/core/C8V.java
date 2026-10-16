package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8V implements InterfaceC1972mF {
    public static byte[] A04;
    public final long A00;
    public final long A01;
    public final long[] A02;
    public final long[] A03;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C8V A00(long j3, long j4, HN hn, C04554v c04554v) {
        int iA0I;
        long j5 = j4;
        c04554v.A0g(10);
        int iA0C = c04554v.A0C();
        if (iA0C <= 0) {
            return null;
        }
        int i3 = hn.A03;
        long jA0U = C5C.A0U(iA0C, ((long) (i3 >= 32000 ? 1152 : 576)) * 1000000, i3);
        int iA0M = c04554v.A0M();
        int iA0M2 = c04554v.A0M();
        int iA0M3 = c04554v.A0M();
        c04554v.A0g(2);
        long j6 = j5 + ((long) hn.A02);
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        for (int i4 = 0; i4 < iA0M; i4++) {
            jArr[i4] = (((long) i4) * jA0U) / ((long) iA0M);
            jArr2[i4] = Math.max(j5, j6);
            switch (iA0M3) {
                case 1:
                    iA0I = c04554v.A0I();
                    break;
                case 2:
                    iA0I = c04554v.A0M();
                    break;
                case 3:
                    iA0I = c04554v.A0K();
                    break;
                case 4:
                    iA0I = c04554v.A0L();
                    break;
                default:
                    return null;
            }
            j5 += ((long) iA0I) * ((long) iA0M2);
        }
        if (j3 != -1 && j3 != j5) {
            AbstractC04404g.A07(A01(27, 10, 89), A01(2, 25, 50) + j3 + A01(0, 2, 80) + j5);
        }
        return new C8V(jArr, jArr2, jA0U, j5);
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-89, -101, -77, -97, -81, -90, 125, -63, -66, -47, -66, 125, -48, -58, -41, -62, 125, -54, -58, -48, -54, -66, -47, -64, -59, -105, 125, -38, -26, -10, -19, -41, -23, -23, -17, -23, -10};
    }

    public C8V(long[] jArr, long[] jArr2, long j3, long j4) {
        this.A03 = jArr;
        this.A02 = jArr2;
        this.A01 = j3;
        this.A00 = j4;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A7j() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        int iA0L = C5C.A0L(this.A03, j3, true, true);
        HZ hz = new HZ(this.A03[iA0L], this.A02[iA0L]);
        if (hz.A01 < j3) {
            int tableIndex = this.A03.length;
            if (iA0L != tableIndex - 1) {
                int tableIndex2 = iA0L + 1;
                long j4 = this.A03[tableIndex2];
                int tableIndex3 = iA0L + 1;
                HZ nextSeekPoint = new HZ(j4, this.A02[tableIndex3]);
                return new HX(hz, nextSeekPoint);
            }
        }
        return new HX(hz);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1972mF
    public final long A9H(long j3) {
        return this.A03[C5C.A0L(this.A02, j3, true, true)];
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}
