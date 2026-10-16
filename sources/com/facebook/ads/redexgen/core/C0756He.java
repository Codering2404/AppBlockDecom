package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.He, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0756He {
    public static byte[] A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public final byte[] A06 = new byte[10];

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 90);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{78, 104, 111, Ascii.DEL, 82, 94, 58, 121, 114, 111, 116, 113, 58, 105, 123, 119, 106, 118, Ascii.DEL, 105, 58, 119, 111, 105, 110, 58, Framer.EXIT_FRAME_PREFIX, Ascii.DEL, 58, 121, 117, 116, 110, 115, 125, 111, 117, 111, 105, 58, 115, 116, 58, 110, 114, Ascii.DEL, 58, 105, 123, 119, 106, 118, Ascii.DEL, 58, 107, 111, Ascii.DEL, 111, Ascii.DEL, 52};
    }

    public final void A02() {
        this.A05 = false;
        this.A02 = 0;
    }

    public final void A03(InterfaceC1999ms interfaceC1999ms) throws IOException {
        if (this.A05) {
            return;
        }
        interfaceC1999ms.AGt(this.A06, 0, 10);
        interfaceC1999ms.AIl();
        if (AbstractC0743Gr.A06(this.A06) == 0) {
            return;
        }
        this.A05 = true;
    }

    public final void A04(InterfaceC0755Hd interfaceC0755Hd, long j3, int i3, int i4, int i5, C0753Hb c0753Hb) {
        AbstractC04323y.A0A(this.A01 <= i4 + i5, A00(0, 60, 64));
        if (!this.A05) {
            return;
        }
        int i6 = this.A02;
        this.A02 = i6 + 1;
        if (i6 == 0) {
            this.A04 = j3;
            this.A00 = i3;
            this.A03 = 0;
        }
        this.A03 += i4;
        this.A01 = i5;
        if (this.A02 >= 16) {
            A05(interfaceC0755Hd, c0753Hb);
        }
    }

    public final void A05(InterfaceC0755Hd interfaceC0755Hd, C0753Hb c0753Hb) {
        if (this.A02 > 0) {
            interfaceC0755Hd.AIu(this.A04, this.A00, this.A03, this.A01, c0753Hb);
            this.A02 = 0;
        }
    }
}
