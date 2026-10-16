package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AV extends AbstractC2183pt {
    public static byte[] A01;
    public static final AnonymousClass23<AV> A02;
    public static final String A03;
    public final float A00;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{Ascii.SYN, 3, Ascii.DC4, 5, 3, 8, Ascii.DC2, 70, Ascii.VT, 19, Ascii.NAK, Ascii.DC2, 70, 4, 3, 70, Ascii.SI, 8, 70, Ascii.DC2, Ascii.SO, 3, 70, Ascii.DC4, 7, 8, 1, 3, 70, 9, 0, 70, 61, 86, 74, 70, 87, 86, 86, 59};
    }

    static {
        A03();
        A03 = C5C.A0h(1);
        A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.q1
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return AV.A00(bundle);
            }
        };
    }

    public AV() {
        this.A00 = -1.0f;
    }

    public AV(float f3) {
        AbstractC04323y.A09(f3 >= 0.0f && f3 <= 100.0f, A02(0, 40, 45));
        this.A00 = f3;
    }

    public static AV A00(Bundle bundle) {
        AbstractC04323y.A07(bundle.getInt(AbstractC2183pt.A02, -1) == 1);
        float f3 = bundle.getFloat(A03, -1.0f);
        return f3 == -1.0f ? new AV() : new AV(f3);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AV) && this.A00 == ((AV) obj).A00;
    }

    public final int hashCode() {
        return CB.A00(Float.valueOf(this.A00));
    }
}
