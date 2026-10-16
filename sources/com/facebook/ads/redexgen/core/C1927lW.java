package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1927lW implements InterfaceC0850Kv {
    public static byte[] A0C;
    public static String[] A0D = {"zgZfEJGGgdHtew2g1FfNkkcnB", "zHXWmVVfspRqZTFEHweYGYwJXvEszQMx", "7abqffqd10TBp3FWdGN7VvMrN7O1UkYM", "p0MVW5l5", "JyEkXe6y14TztCHpc8kpfDGRXJv0nuKA", "euIGF7oBB7KZa", "ak0CBs2Ex4lMz9dSuXO", "PviIixxcvW6ZcpMh0sztGl9"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public C2208qI A05;
    public InterfaceC0755Hd A06;
    public String A07;
    public boolean A08;
    public final C04544u A09;
    public final C04554v A0A;
    public final String A0B;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{40, 60, Framer.STDIN_FRAME_PREFIX, 32, 38, 102, 40, 42, 122};
    }

    static {
        A02();
    }

    public C1927lW() {
        this(null);
    }

    public C1927lW(String str) {
        this.A09 = new C04544u(new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD]);
        this.A0A = new C04554v(this.A09.A00);
        this.A02 = 0;
        this.A04 = -9223372036854775807L;
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1927lW.A01():void");
    }

    private boolean A03(C04554v c04554v) {
        while (true) {
            if (c04554v.A07() <= 0) {
                return false;
            }
            boolean z2 = this.A08;
            if (A0D[3].length() != 8) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "9XFIg7618hJvvA4xETZzayJ4sl88kXfd";
            strArr[1] = "F6kFQyxnROPq81yNs7RnOkiGPjgAvEmB";
            if (!z2) {
                this.A08 = c04554v.A0I() == 11;
            } else {
                int iA0I = c04554v.A0I();
                if (iA0I == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = iA0I == 11;
            }
        }
    }

    private boolean A04(C04554v c04554v, byte[] bArr, int i3) {
        int iMin = Math.min(c04554v.A07(), i3 - this.A00);
        int bytesToRead = this.A00;
        c04554v.A0k(bArr, bytesToRead, iMin);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + iMin;
        int bytesToRead3 = this.A00;
        return bytesToRead3 == i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5A(C04554v c04554v) {
        AbstractC04323y.A02(this.A06);
        while (c04554v.A07() > 0) {
            int i3 = this.A02;
            String[] strArr = A0D;
            if (strArr[0].length() != strArr[5].length()) {
                String[] strArr2 = A0D;
                strArr2[0] = "xuhMWsLm7IhyfpFjlZpQdmw9F";
                strArr2[5] = "BOgMYXTSIypYk";
                switch (i3) {
                    case 0:
                        if (A03(c04554v)) {
                            this.A02 = 1;
                            this.A0A.A0l()[0] = Ascii.VT;
                            this.A0A.A0l()[1] = 119;
                            this.A00 = 2;
                        }
                        break;
                    case 1:
                        if (A04(c04554v, this.A0A.A0l(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) {
                            A01();
                            this.A0A.A0f(0);
                            this.A06.AIr(this.A0A, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                            this.A02 = 2;
                        }
                        break;
                    case 2:
                        int iMin = Math.min(c04554v.A07(), this.A01 - this.A00);
                        this.A06.AIr(c04554v, iMin);
                        this.A00 += iMin;
                        if (this.A00 == this.A01) {
                            if (this.A04 != -9223372036854775807L) {
                                this.A06.AIu(this.A04, 1, this.A01, 0, null);
                                this.A04 += this.A03;
                            }
                            this.A02 = 0;
                        }
                        break;
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A07 = lg.A04();
        this.A06 = ha.AKS(lg.A03(), 1);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AGq(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.A04 = j3;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0850Kv
    public final void AJ5() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
    }
}
