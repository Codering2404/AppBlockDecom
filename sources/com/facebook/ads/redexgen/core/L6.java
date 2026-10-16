package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L6 {
    public static byte[] A08;
    public static String[] A09 = {"voRQ6Eoiy", "dM5sUr3BWW4nkGo5nRVfbphD0FkiLgeI", "t4ngtozvUcRON5qFCPMw9NZHviWOcz8N", "2o", "HR4o0SgaegzvmEvMyBsSV3cy", "Fxd3YqblXENYapC", "iFe6DhKEBr1iW4qwRCto7Lk6hMgexe67", "drzzj9o5hc6Li6ZR2JGiBSJ"};
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final AnonymousClass53 A07 = new AnonymousClass53(0);
    public long A01 = -9223372036854775807L;
    public long A02 = -9223372036854775807L;
    public long A00 = -9223372036854775807L;
    public final C04554v A06 = new C04554v();

    public static String A08(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A08 = new byte[]{-19, -33, Ascii.DC4, Framer.STDERR_FRAME_PREFIX, 40, Framer.STDIN_FRAME_PREFIX, 38, -33, 19, 8, Ascii.FF, 4, Ascii.RS, Ascii.DC4, Ascii.CR, Ascii.DC2, 4, 19, -33, 40, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 36, 32, 35, -19, Ascii.DC2, 55, 63, 42, 53, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, -23, Framer.STDIN_FRAME_PREFIX, 62, 59, 42, 61, Framer.STDERR_FRAME_PREFIX, 56, 55, 3, -23, Ascii.SYN, 57, 10, 59, 56, 39, 58, 47, 53, 52, Ascii.CAN, 43, 39, 42, 43, 56};
    }

    static {
        A09();
    }

    private int A00(InterfaceC1999ms interfaceC1999ms) {
        this.A06.A0i(C5C.A07);
        this.A03 = true;
        interfaceC1999ms.AIl();
        return 0;
    }

    private int A01(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        int iMin = (int) Math.min(20000L, interfaceC1999ms.A8O());
        if (interfaceC1999ms.A8n() != 0) {
            hv.A00 = 0;
            return 1;
        }
        C04554v c04554v = this.A06;
        int bytesToSearch = A09[6].length();
        if (bytesToSearch == 30) {
            throw new RuntimeException();
        }
        A09[6] = "JjjcAHcIe3bphcpehmdhx0lOvmd2";
        c04554v.A0d(iMin);
        interfaceC1999ms.AIl();
        interfaceC1999ms.AGt(this.A06.A0l(), 0, iMin);
        this.A01 = A04(this.A06);
        this.A04 = true;
        return 0;
    }

    private int A02(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        long jA8O = interfaceC1999ms.A8O();
        int iMin = (int) Math.min(20000L, jA8O);
        long j3 = jA8O - ((long) iMin);
        long searchStartPosition = interfaceC1999ms.A8n();
        if (searchStartPosition != j3) {
            hv.A00 = j3;
            return 1;
        }
        this.A06.A0d(iMin);
        interfaceC1999ms.AIl();
        interfaceC1999ms.AGt(this.A06.A0l(), 0, iMin);
        long inputLength = A05(this.A06);
        this.A02 = inputLength;
        this.A05 = true;
        return 0;
    }

    private int A03(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8) | (bArr[i3 + 3] & 255);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A04(com.facebook.ads.redexgen.core.C04554v r8) {
        /*
            r7 = this;
            int r6 = r8.A09()
            int r5 = r8.A0A()
        L8:
            int r0 = r5 + (-3)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= r0) goto L2e
            byte[] r0 = r8.A0l()
            int r1 = r7.A03(r0, r6)
            r0 = 442(0x1ba, float:6.2E-43)
            if (r1 != r0) goto L2b
            int r0 = r6 + 4
            r8.A0f(r0)
            long r1 = A06(r8)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 == 0) goto L2b
            return r1
        L2b:
            int r6 = r6 + 1
            goto L8
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.L6.A04(com.facebook.ads.redexgen.X.4v):long");
    }

    private long A05(C04554v c04554v) {
        int iA09 = c04554v.A09();
        int searchStartPosition = c04554v.A0A();
        for (int nextStartCode = searchStartPosition - 4; nextStartCode >= iA09; nextStartCode--) {
            int searchEndPosition = A03(c04554v.A0l(), nextStartCode);
            if (searchEndPosition == 442) {
                int searchStartPosition2 = nextStartCode + 4;
                c04554v.A0f(searchStartPosition2);
                long jA06 = A06(c04554v);
                int searchEndPosition2 = A09[1].charAt(26);
                if (searchEndPosition2 != 107) {
                    throw new RuntimeException();
                }
                A09[6] = "fZ";
                if (jA06 != -9223372036854775807L) {
                    return jA06;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long A06(C04554v c04554v) {
        int iA09 = c04554v.A09();
        if (c04554v.A07() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        int originalPosition = bArr.length;
        c04554v.A0k(bArr, 0, originalPosition);
        c04554v.A0f(iA09);
        if (A0A(bArr)) {
            return A07(bArr);
        }
        return -9223372036854775807L;
    }

    public static long A07(byte[] bArr) {
        return (((((long) bArr[0]) & 56) >> 3) << 30) | ((((long) bArr[0]) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) bArr[2]) & 248) >> 3) << 15) | ((((long) bArr[2]) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public static boolean A0A(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public final int A0B(InterfaceC1999ms interfaceC1999ms, HV hv) throws IOException {
        if (!this.A05) {
            return A02(interfaceC1999ms, hv);
        }
        if (this.A02 == -9223372036854775807L) {
            return A00(interfaceC1999ms);
        }
        if (!this.A04) {
            return A01(interfaceC1999ms, hv);
        }
        if (this.A01 == -9223372036854775807L) {
            return A00(interfaceC1999ms);
        }
        this.A00 = this.A07.A06(this.A02) - this.A07.A06(this.A01);
        if (this.A00 < 0) {
            AbstractC04404g.A07(A08(45, 16, 119), A08(27, 18, 122) + this.A00 + A08(0, 27, 112));
            this.A00 = -9223372036854775807L;
        }
        return A00(interfaceC1999ms);
    }

    public final long A0C() {
        return this.A00;
    }

    public final AnonymousClass53 A0D() {
        return this.A07;
    }

    public final boolean A0E() {
        return this.A03;
    }
}
