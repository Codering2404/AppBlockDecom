package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class I7 extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public static String[] A03 = {"", "vSeS2rx23zUd4am5Wdo", "UtlZDzt7", "dNEruPHPdkyj182N7GwirLXq8Db2eecB", "b1VGcsOgsecYYY6uN1zNid8VodysKnsR", "yg", "RqC1uxvv784HDfNbZXUq5U9jCsQW0kUg", "5jFX4DLWV5nBObgEbVC73yk5ncCVY3Kv"};
    public final /* synthetic */ C5S A00;
    public final /* synthetic */ C4A A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{51, 4, Ascii.ETB, Ascii.ETB, Ascii.DC4, 3, Ascii.CAN, Ascii.US, Ascii.SYN, 81, Ascii.CAN, Ascii.US, Ascii.NAK, Ascii.DC4, Ascii.ETB, Ascii.CAN, Ascii.US, Ascii.CAN, 5, Ascii.DC4, Ascii.GS, 8};
    }

    static {
        A01();
    }

    public I7(C5S c5s, C4A c4a) {
        this.A00 = c5s;
        this.A01 = c4a;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (this.A00.A0S.getState() == EnumC1590fm.A02) {
            int currentPositionInMillis = this.A00.A0S.getCurrentPositionInMillis();
            if (A03[2].length() != 8) {
                throw new RuntimeException();
            }
            A03[7] = "iv52OwD8pgB4ao6bV3eWAeQD9PjHFRbz";
            if (currentPositionInMillis == A00()) {
                this.A00.A0S(A00(0, 22, 57));
            }
        }
    }
}
