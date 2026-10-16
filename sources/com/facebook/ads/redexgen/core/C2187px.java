package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.px, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2187px implements AnonymousClass24 {
    public static byte[] A03;
    public static String[] A04 = {"UnBMZo2POSkJfz8F5ORuhqz31kXq7ERt", "GIL9xJe6rQGrNyWVB8WflXUexCYVOXiL", "1YJSMghIf03NGeOR9kmJ9bGOSAOIDk9h", "FbkWhL7EvytxWPK79enAjrYaTxkw07sQ", "DvmeNztcauqB3GuZI4NFBZAXEAF", "3h1K0W52WnqAecgG5ddVr1SgL8ZiRxH3", "SzBXc", "YkLyJW6tcdkoyMoq5nPmYT201JvYdNzP"};
    public static final AnonymousClass23<C2187px> A05;
    public static final C2187px A06;
    public static final String A07;
    public static final String A08;
    public final float A00;
    public final float A01;
    public final int A02;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{109, 81, 92, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 92, 94, 86, 109, 92, 79, 92, 80, 88, 73, 88, 79, 78, Ascii.NAK, 78, 77, 88, 88, 89, 0, Ascii.CAN, 19, Ascii.SI, 91, 17, Ascii.GS, 77, 84, 73, 94, 85, 0, Ascii.CAN, 19, Ascii.SI, 91, Ascii.DC4};
    }

    static {
        A02();
        A06 = new C2187px(1.0f);
        A08 = C5C.A0h(0);
        A07 = C5C.A0h(1);
        A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.py
            @Override // com.facebook.ads.redexgen.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return C2187px.A00(bundle);
            }
        };
    }

    public C2187px(float f3) {
        this(f3, 1.0f);
    }

    public C2187px(float f3, float f4) {
        AbstractC04323y.A07(f3 > 0.0f);
        AbstractC04323y.A07(f4 > 0.0f);
        this.A01 = f3;
        this.A00 = f4;
        this.A02 = Math.round(1000.0f * f3);
    }

    public static /* synthetic */ C2187px A00(Bundle bundle) {
        float f3 = bundle.getFloat(A08, 1.0f);
        float pitch = bundle.getFloat(A07, 1.0f);
        return new C2187px(f3, pitch);
    }

    public final long A03(long j3) {
        return ((long) this.A02) * j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2187px c2187px = (C2187px) obj;
        if (this.A01 == c2187px.A01) {
            float f3 = this.A00;
            float f4 = c2187px.A00;
            if (A04[7].charAt(19) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "pC9U2";
            strArr[4] = "3ca7HvojzYBlvf3WwnTfkyYQmWq";
            if (f3 == f4) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = Float.floatToRawIntBits(this.A01);
        return (((17 * 31) + result) * 31) + Float.floatToRawIntBits(this.A00);
    }

    public final String toString() {
        return C5C.A0n(A01(0, 42, 46), Float.valueOf(this.A01), Float.valueOf(this.A00));
    }
}
