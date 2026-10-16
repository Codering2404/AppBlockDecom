package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DL {
    public static String[] A07 = {"1TUPUvqjuckMieKxy618dXqeho2I2nXO", "1tw", "Rv8BHxt03y9lIrpcW4kHhbfWsqmFKBVK", "r8Px", "D2vXeeTjlCXB4Odv", "hN", "uuD40", "TpLNmCJV5wG1YwTXf3toM93vl9iWeWk7"};
    public long A00;
    public C2050ni A01;
    public C2050ni A02;
    public C2050ni A03;
    public final int A04;
    public final C04554v A05 = new C04554v(32);
    public final F0 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2050ni A04(C2050ni c2050ni, C2129p0 c2129p0, DN dn, C04554v c04554v) {
        int iA0M;
        long j3 = dn.A01;
        c04554v.A0d(1);
        C2050ni c2050niA03 = A03(c2050ni, j3, c04554v.A0l(), 1);
        long j4 = j3 + 1;
        byte b3 = c04554v.A0l()[0];
        boolean z2 = (b3 & 128) != 0;
        int i3 = b3 & Ascii.DEL;
        C04855z c04855z = c2129p0.A05;
        if (c04855z.A04 == null) {
            c04855z.A04 = new byte[16];
        } else {
            Arrays.fill(c04855z.A04, (byte) 0);
        }
        C2050ni c2050niA032 = A03(c2050niA03, j4, c04855z.A04, i3);
        long j5 = j4 + ((long) i3);
        if (z2) {
            c04554v.A0d(2);
            c2050niA032 = A03(c2050niA032, j5, c04554v.A0l(), 2);
            j5 += 2;
            iA0M = c04554v.A0M();
        } else {
            iA0M = 1;
            if (A07[7].charAt(5) == 'i') {
                throw new RuntimeException();
            }
            A07[7] = "Hpyz1f8ALnZx1iP9R6alck8MxH3P54oK";
        }
        int[] iArr = c04855z.A06;
        if (iArr == null || iArr.length < iA0M) {
            iArr = new int[iA0M];
        }
        int[] iArr2 = c04855z.A07;
        if (iArr2 == null || iArr2.length < iA0M) {
            iArr2 = new int[iA0M];
        }
        if (z2) {
            int i4 = iA0M * 6;
            c04554v.A0d(i4);
            c2050niA032 = A03(c2050niA032, j5, c04554v.A0l(), i4);
            j5 += (long) i4;
            c04554v.A0f(0);
            for (int i5 = 0; i5 < iA0M; i5++) {
                iArr[i5] = c04554v.A0M();
                iArr2[i5] = c04554v.A0L();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = dn.A00 - ((int) (j5 - dn.A01));
        }
        C0753Hb c0753Hb = (C0753Hb) C5C.A0f(dn.A02);
        c04855z.A02(iA0M, iArr, iArr2, c0753Hb.A03, c04855z.A04, c0753Hb.A01, c0753Hb.A02, c0753Hb.A00);
        int i6 = (int) (j5 - dn.A01);
        dn.A01 += (long) i6;
        if (A07[0].charAt(1) == 'T') {
            A07[0] = "nTpP9ibfF3cbwjVbkTA4UIhNPpZui5fl";
            dn.A00 -= i6;
            return c2050niA032;
        }
        String[] strArr = A07;
        strArr[3] = "b8i1";
        strArr[6] = "bRWrT";
        dn.A00 -= i6;
        return c2050niA032;
    }

    public DL(F0 f02) {
        this.A06 = f02;
        this.A04 = f02.A8I();
        this.A01 = new C2050ni(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
    }

    private int A00(int i3) {
        if (this.A03.A03 == null) {
            this.A03.A03(this.A06.A49(), new C2050ni(this.A03.A00, this.A04));
        }
        return Math.min(i3, (int) (this.A03.A00 - this.A00));
    }

    public static C2050ni A01(C2050ni c2050ni, long j3) {
        while (j3 >= c2050ni.A00) {
            c2050ni = c2050ni.A02;
        }
        return c2050ni;
    }

    public static C2050ni A02(C2050ni c2050ni, long j3, ByteBuffer byteBuffer, int i3) {
        C2050ni c2050niA01 = A01(c2050ni, j3);
        while (i3 > 0) {
            int remaining = (int) (c2050niA01.A00 - j3);
            int iMin = Math.min(i3, remaining);
            byte[] bArr = c2050niA01.A03.A01;
            int remaining2 = c2050niA01.A00(j3);
            byteBuffer.put(bArr, remaining2, iMin);
            i3 -= iMin;
            j3 += (long) iMin;
            if (j3 == c2050niA01.A00) {
                c2050niA01 = c2050niA01.A02;
            }
        }
        return c2050niA01;
    }

    public static C2050ni A03(C2050ni c2050ni, long j3, byte[] bArr, int i3) {
        C2050ni c2050niA01 = A01(c2050ni, j3);
        int i4 = i3;
        while (i4 > 0) {
            int iMin = Math.min(i4, (int) (c2050niA01.A00 - j3));
            byte[] bArr2 = c2050niA01.A03.A01;
            int toCopy = c2050niA01.A00(j3);
            int remaining = i3 - i4;
            System.arraycopy(bArr2, toCopy, bArr, remaining, iMin);
            i4 -= iMin;
            j3 += (long) iMin;
            if (j3 == c2050niA01.A00) {
                c2050niA01 = c2050niA01.A02;
            }
        }
        return c2050niA01;
    }

    public static C2050ni A05(C2050ni c2050ni, C2129p0 c2129p0, DN dn, C04554v c04554v) {
        if (c2129p0.A0E()) {
            c2050ni = A04(c2050ni, c2129p0, dn, c04554v);
        }
        if (c2129p0.A03()) {
            c04554v.A0d(4);
            C2050ni c2050niA03 = A03(c2050ni, dn.A01, c04554v.A0l(), 4);
            int iA0L = c04554v.A0L();
            dn.A01 += 4;
            dn.A00 -= 4;
            c2129p0.A0C(iA0L);
            C2050ni c2050niA02 = A02(c2050niA03, dn.A01, c2129p0.A02, iA0L);
            dn.A01 += (long) iA0L;
            dn.A00 -= iA0L;
            c2129p0.A0D(dn.A00);
            return A02(c2050niA02, dn.A01, c2129p0.A03, dn.A00);
        }
        c2129p0.A0C(dn.A00);
        return A02(c2050ni, dn.A01, c2129p0.A02, dn.A00);
    }

    private void A06(int i3) {
        this.A00 += (long) i3;
        if (this.A00 == this.A03.A00) {
            this.A03 = this.A03.A02;
        }
    }

    private void A07(C2050ni c2050ni) {
        if (c2050ni.A03 == null) {
            return;
        }
        this.A06.AHe(c2050ni);
        c2050ni.A01();
    }

    public final int A08(InterfaceC03882c interfaceC03882c, int i3, boolean z2) throws IOException {
        int i4 = interfaceC03882c.read(this.A03.A03.A01, this.A03.A00(this.A00), A00(i3));
        if (i4 == -1) {
            if (z2) {
                return -1;
            }
            throw new EOFException();
        }
        A06(i4);
        return i4;
    }

    public final long A09() {
        return this.A00;
    }

    public final void A0A() {
        A07(this.A01);
        this.A01.A02(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
        this.A00 = 0L;
        this.A06.AKT();
    }

    public final void A0B() {
        this.A02 = this.A01;
    }

    public final void A0C(long j3) {
        if (j3 == -1) {
            return;
        }
        while (j3 >= this.A01.A00) {
            this.A06.AHd(this.A01.A03);
            this.A01 = this.A01.A01();
        }
        long j4 = this.A02.A01;
        long j5 = this.A01.A01;
        String[] strArr = A07;
        if (strArr[3].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[3] = "kTcq";
        strArr2[6] = "Dj6YZ";
        if (j4 < j5) {
            this.A02 = this.A01;
        }
    }

    public final void A0D(C04554v c04554v, int i3) {
        while (i3 > 0) {
            int iA00 = A00(i3);
            byte[] bArr = this.A03.A03.A01;
            int bytesAppended = this.A03.A00(this.A00);
            c04554v.A0k(bArr, bytesAppended, iA00);
            i3 -= iA00;
            A06(iA00);
        }
    }

    public final void A0E(C2129p0 c2129p0, DN dn) {
        A05(this.A02, c2129p0, dn, this.A05);
    }

    public final void A0F(C2129p0 c2129p0, DN dn) {
        this.A02 = A05(this.A02, c2129p0, dn, this.A05);
    }
}
