package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1921lQ implements InterfaceC0850Kv {
    public static byte[] A0L;
    public static String[] A0M = {"mrTKvxULVENuxsX20WcrAJ4v", "LussONYVy0olIUlKNuZbFssmQ2DfHEVf", "zvJRCSTXMBsZ1hE0Mr7ze3FhUb04dJIh", "L0YacQwQPMjWe9KaI5mJ2LmFBjZFt0ZK", "1hx48ZBneHnM7bdYLzCUfsF2U1nSOVt0", "UVBTZnk6apz1fVZpxMzmfRHtaRIycLGw", "Y7M7p8C63xXJXfMDaPj4j21Etz7HrkAn", "dpgmp2dWdChOdFvADkjRIu4gRUIL2TAI"};
    public static final byte[] A0N;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public InterfaceC0755Hd A0A;
    public InterfaceC0755Hd A0B;
    public InterfaceC0755Hd A0C;
    public String A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public final C04544u A0H;
    public final C04554v A0I;
    public final String A0J;
    public final boolean A0K;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0L = new byte[]{99, 87, -103, -84, -85, 87, -104, -86, -86, -84, -92, -96, -91, -98, 87, Framer.EXIT_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 122, 87, -125, 122, 101, -98, -63, -47, -48, -81, -62, -66, -63, -62, -49, 77, 110, 125, 110, 108, 125, 110, 109, 41, 106, 126, 109, 114, Framer.EXIT_FRAME_PREFIX, 41, Framer.EXIT_FRAME_PREFIX, 107, 115, 110, 108, 125, 41, 125, -126, 121, 110, 67, 41, -47, -32, -32, -36, -39, -45, -47, -28, -39, -33, -34, -97, -39, -44, -93, -74, -54, -71, -66, -60, -124, -62, -59, -119, -74, -126, -63, -74, -55, -62};
    }

    static {
        A09();
        A0N = new byte[]{73, 68, 51};
    }

    public C1921lQ(boolean z2) {
        this(z2, null);
    }

    public C1921lQ(boolean z2, String str) {
        this.A0H = new C04544u(new byte[7]);
        this.A0I = new C04554v(Arrays.copyOf(A0N, 10));
        A06();
        this.A03 = -1;
        this.A02 = -1;
        this.A08 = -9223372036854775807L;
        this.A09 = -9223372036854775807L;
        this.A0K = z2;
        this.A0J = str;
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void A01() {
        AbstractC04323y.A01(this.A0C);
    }

    @RequiresNonNull({"output"})
    private void A02() throws C3K {
        this.A0H.A08(0);
        if (!this.A0G) {
            int iA04 = this.A0H.A04(2) + 1;
            if (iA04 != 2) {
                AbstractC04404g.A07(A00(22, 10, 84), A00(32, 28, 0) + iA04 + A00(0, 22, 46));
                iA04 = 2;
            }
            this.A0H.A09(5);
            int iA042 = this.A0H.A04(3);
            int audioObjectType = this.A02;
            byte[] bArrA07 = AbstractC0739Gn.A07(iA04, audioObjectType, iA042);
            C0738Gm aacConfig = AbstractC0739Gn.A03(bArrA07);
            C03992p c03992pA0w = new C03992p().A0y(this.A0D).A11(A00(75, 15, 76)).A0w(aacConfig.A02);
            int audioObjectType2 = aacConfig.A00;
            C03992p c03992pA0b = c03992pA0w.A0b(audioObjectType2);
            int audioObjectType3 = aacConfig.A01;
            C2208qI c2208qIA14 = c03992pA0b.A0m(audioObjectType3).A12(Collections.singletonList(bArrA07)).A10(this.A0J).A14();
            int audioObjectType4 = c2208qIA14.A0G;
            this.A08 = 1024000000 / ((long) audioObjectType4);
            this.A0C.A6e(c2208qIA14);
            this.A0G = true;
        } else {
            this.A0H.A09(10);
        }
        this.A0H.A09(4);
        int iA043 = (this.A0H.A04(13) - 2) - 5;
        boolean z2 = this.A0F;
        String[] strArr = A0M;
        String str = strArr[5];
        String str2 = strArr[1];
        int iCharAt = str.charAt(31);
        int sampleSize = str2.charAt(31);
        if (iCharAt == sampleSize) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0M;
        strArr2[5] = "giOljvViomSrN4IHC4QybJTR7ABLuXqE";
        strArr2[1] = "jFLriiyuw9puslkouPTFj8AuXirD2Rvz";
        if (z2) {
            iA043 -= 2;
        }
        A0D(this.A0C, this.A08, 0, iA043);
    }

    @RequiresNonNull({"id3Output"})
    private void A03() {
        this.A0B.AIr(this.A0I, 10);
        this.A0I.A0f(6);
        A0D(this.A0B, 0L, 10, this.A0I.A0H() + 10);
    }

    private void A04() {
        this.A0E = false;
        A06();
    }

    private void A05() {
        this.A06 = 1;
        this.A00 = 0;
    }

    private void A06() {
        this.A06 = 0;
        this.A00 = 0;
        this.A04 = Function.MAX_NARGS;
    }

    private void A07() {
        this.A06 = 3;
        this.A00 = 0;
    }

    private void A08() {
        this.A06 = 2;
        this.A00 = A0N.length;
        this.A05 = 0;
        this.A0I.A0f(0);
    }

    private void A0A(C04554v c04554v) {
        if (c04554v.A07() == 0) {
            return;
        }
        this.A0H.A00[0] = c04554v.A0l()[c04554v.A09()];
        this.A0H.A08(2);
        int iA04 = this.A0H.A04(4);
        if (this.A02 != -1) {
            int i3 = this.A02;
            String[] strArr = A0M;
            String str = strArr[5];
            String str2 = strArr[1];
            int iCharAt = str.charAt(31);
            int currentFrameSampleRateIndex = str2.charAt(31);
            if (iCharAt == currentFrameSampleRateIndex) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[2] = "gsvCXwBusIGEB1WA3fanWinNUC0stLKn";
            strArr2[4] = "jdr5Xoms36XQNA1pdvYLzBfLUyE1GaLW";
            if (iA04 != i3) {
                A04();
                return;
            }
        }
        if (!this.A0E) {
            this.A0E = true;
            int currentFrameSampleRateIndex2 = this.A01;
            this.A03 = currentFrameSampleRateIndex2;
            this.A02 = iA04;
        }
        A07();
    }

    private void A0B(C04554v c04554v) {
        byte[] bArrA0l = c04554v.A0l();
        int iA09 = c04554v.A09();
        int iA0A = c04554v.A0A();
        while (iA09 < iA0A) {
            int endOffset = iA09 + 1;
            int i3 = bArrA0l[iA09] & 255;
            if (this.A04 == 512 && A0E((byte) -1, (byte) i3) && (this.A0E || A0G(c04554v, endOffset - 2))) {
                this.A01 = (i3 & 8) >> 3;
                this.A0F = (i3 & 1) == 0;
                if (!this.A0E) {
                    A05();
                } else {
                    A07();
                }
                c04554v.A0f(endOffset);
                return;
            }
            switch (this.A04 | i3) {
                case 329:
                    this.A04 = 768;
                    iA09 = endOffset;
                    break;
                case 511:
                    this.A04 = 512;
                    iA09 = endOffset;
                    break;
                case 836:
                    this.A04 = 1024;
                    iA09 = endOffset;
                    break;
                case 1075:
                    A08();
                    c04554v.A0f(endOffset);
                    return;
                default:
                    int data = this.A04;
                    if (data != 256) {
                        this.A04 = Function.MAX_NARGS;
                        iA09 = endOffset - 1;
                        int data2 = A0M[3].charAt(30);
                        if (data2 == 52) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A0M;
                        strArr[5] = "GFWHNKn9X7s15i1eiUIDtSq2eHiOoz5U";
                        strArr[1] = "NE8NIWAGBkU3RGGIPZnBOUiADBs4e2Uh";
                    } else {
                        iA09 = endOffset;
                    }
                    break;
            }
        }
        c04554v.A0f(iA09);
    }

    @RequiresNonNull({"currentOutput"})
    private void A0C(C04554v c04554v) {
        int iMin = Math.min(c04554v.A07(), this.A05 - this.A00);
        this.A0A.AIr(c04554v, iMin);
        int bytesToRead = this.A00;
        this.A00 = bytesToRead + iMin;
        int i3 = this.A00;
        int bytesToRead2 = this.A05;
        if (i3 == bytesToRead2) {
            if (this.A09 != -9223372036854775807L) {
                this.A0A.AIu(this.A09, 1, this.A05, 0, null);
                this.A09 += this.A07;
            }
            A06();
        }
    }

    private void A0D(InterfaceC0755Hd interfaceC0755Hd, long j3, int i3, int i4) {
        this.A06 = 4;
        this.A00 = i3;
        this.A0A = interfaceC0755Hd;
        this.A07 = j3;
        this.A05 = i4;
    }

    private boolean A0E(byte b3, byte b4) {
        return A0F(((b3 & 255) << 8) | (b4 & 255));
    }

    public static boolean A0F(int i3) {
        return (65526 & i3) == 65520;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0G(com.facebook.ads.redexgen.core.C04554v r11, int r12) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1921lQ.A0G(com.facebook.ads.redexgen.X.4v, int):boolean");
    }

    private boolean A0H(C04554v c04554v, byte[] bArr, int i3) {
        int iMin = Math.min(c04554v.A07(), i3 - this.A00);
        int bytesToRead = this.A00;
        c04554v.A0k(bArr, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        return bytesToRead3 == i3;
    }

    private boolean A0I(C04554v c04554v, byte[] bArr, int i3) {
        if (c04554v.A07() < i3) {
            return false;
        }
        c04554v.A0k(bArr, 0, i3);
        return true;
    }

    public final long A0J() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5A(C04554v c04554v) throws C3K {
        A01();
        while (c04554v.A07() > 0) {
            switch (this.A06) {
                case 0:
                    A0B(c04554v);
                    break;
                case 1:
                    A0A(c04554v);
                    break;
                case 2:
                    if (A0H(c04554v, this.A0I.A0l(), 10)) {
                        A03();
                    }
                    break;
                case 3:
                    if (A0H(c04554v, this.A0H.A00, this.A0F ? 7 : 5)) {
                        A02();
                    }
                    break;
                case 4:
                    A0C(c04554v);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A0D = lg.A04();
        this.A0C = ha.AKS(lg.A03(), 1);
        this.A0A = this.A0C;
        if (this.A0K) {
            lg.A05();
            this.A0B = ha.AKS(lg.A03(), 5);
            this.A0B.A6e(new C03992p().A0y(lg.A04()).A11(A00(60, 15, 103)).A14());
            return;
        }
        this.A0B = new C2000mt();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGq(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.A09 = j3;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AJ5() {
        this.A09 = -9223372036854775807L;
        A04();
    }
}
