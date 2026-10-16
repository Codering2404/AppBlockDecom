package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class J8 extends AbstractRunnableC1135Wc {
    public static byte[] A01;
    public final /* synthetic */ C1424d4 A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{87, 104, 101, 100, 110, Framer.ENTER_FRAME_PREFIX, 118, 96, 114, Framer.ENTER_FRAME_PREFIX, 111, 100, 119, 100, 115, Framer.ENTER_FRAME_PREFIX, 113, 115, 100, 113, 96, 115, 100, 101};
    }

    public J8(C1424d4 c1424d4) {
        this.A00 = c1424d4;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (this.A00.A03) {
            return;
        }
        this.A00.A0I(A00(0, 24, 115));
    }
}
