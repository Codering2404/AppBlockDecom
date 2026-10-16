package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1895l0 implements LL {
    public static byte[] A08;
    public static String[] A09 = {"mF6wsmKEoSH0oaFjYCs54xiQsDf", "7fvgeHK83IOxRTsxSXxl4b3GDJCkJYIR", "3AWdxUjQjYm4RALX7ZxT6TNspaUhotFB", "ejd6qsjsHb99jkL857XJ5GpzVF9O4Dmm", "HjmRuX1Dl2gTeBJaQInX56gY9CThxDdt", "4dP72HMzoJKZI0lPLVreHOZSlD0czmst", "VabPsN9EmqWHNd02VeXfGkhVpY5qzzPo", "1TiSMCKkeVz3FItUT5PAcFJ22kgDAGxf"};
    public int A00;
    public long A01;
    public long A02;
    public final int A03;
    public final C2208qI A04;
    public final HA A05;
    public final InterfaceC0755Hd A06;
    public final LN A07;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-68, -95, -24, -16, -11, -69, -95, -34, 17, 9, -2, -4, Ascii.CR, -2, -3, -71, -5, 5, 8, -4, 4, -71, Ascii.FF, 2, 19, -2, -45, -71};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.LL
    public final boolean AIt(InterfaceC1999ms interfaceC1999ms, long j3) throws IOException {
        long j4 = j3;
        while (true) {
            String[] strArr = A09;
            if (strArr[6].charAt(28) != strArr[5].charAt(28)) {
                throw new RuntimeException();
            }
            A09[7] = "xyHijgDe1t0LZE27YhGAb5keyZPdsLp6";
            if (j4 <= 0 || this.A00 >= this.A03) {
                break;
            }
            int iAIp = this.A06.AIp(interfaceC1999ms, (int) Math.min(this.A03 - this.A00, j4), true);
            if (iAIp == -1) {
                j4 = 0;
            } else {
                this.A00 += iAIp;
                j4 -= (long) iAIp;
            }
        }
        int i3 = this.A07.A02;
        int i4 = this.A00 / i3;
        if (i4 > 0) {
            long jA0U = this.A02 + C5C.A0U(this.A01, 1000000L, this.A07.A04);
            int i5 = i4 * i3;
            int i6 = this.A00 - i5;
            this.A06.AIu(jA0U, 1, i5, i6, null);
            this.A01 += (long) i4;
            this.A00 = i6;
        }
        return j4 <= 0;
    }

    static {
        A01();
    }

    public C1895l0(HA ha, InterfaceC0755Hd interfaceC0755Hd, LN ln, String str, int i3) throws C3K {
        this.A05 = ha;
        this.A06 = interfaceC0755Hd;
        this.A07 = ln;
        int i4 = (ln.A05 * ln.A01) / 8;
        int bytesPerFrame = ln.A02;
        if (bytesPerFrame == i4) {
            int bytesPerFrame2 = ln.A04;
            int constantBitrate = bytesPerFrame2 * i4 * 8;
            int bytesPerFrame3 = ln.A04;
            this.A03 = Math.max(i4, (bytesPerFrame3 * i4) / 10);
            C03992p c03992pA0j = new C03992p().A11(str).A0a(constantBitrate).A0j(constantBitrate);
            int bytesPerFrame4 = this.A03;
            C03992p c03992pA0h = c03992pA0j.A0h(bytesPerFrame4);
            int bytesPerFrame5 = ln.A05;
            C03992p c03992pA0b = c03992pA0h.A0b(bytesPerFrame5);
            int bytesPerFrame6 = ln.A04;
            this.A04 = c03992pA0b.A0m(bytesPerFrame6).A0i(i3).A14();
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append(A00(7, 21, 72)).append(i4).append(A00(0, 7, 48));
        int bytesPerFrame7 = ln.A02;
        throw C3K.A01(sbAppend.append(bytesPerFrame7).toString(), null);
    }

    @Override // com.facebook.ads.redexgen.core.LL
    public final void AA8(int i3, long j3) {
        this.A05.AJ7(new C1893ky(this.A07, 1, i3, j3));
        this.A06.A6e(this.A04);
    }

    @Override // com.facebook.ads.redexgen.core.LL
    public final void AIk(long j3) {
        this.A02 = j3;
        this.A00 = 0;
        this.A01 = 0L;
    }
}
