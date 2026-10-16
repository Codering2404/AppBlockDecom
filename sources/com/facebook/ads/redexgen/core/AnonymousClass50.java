package com.facebook.ads.redexgen.core;

import android.view.Surface;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.50, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass50 {
    public static byte[] A04;
    public static String[] A05 = {"rYnPbEfuSaTBbvatyKmqENn8mgRSZdek", "ofstc3luVQLhDPNdocOCjRxToKRzk7nB", "Fnbmz9sIEw5y7N9QBLdBg", "MRjsdls7eSgWLCoo8pA3j", "UfW8AgM42njlyNRr2q7EB3IdvayipkgN", "kcxrVmXx561a0K31f6UYVe0sWhenvrT2", "", "AcILJL5UwW37jf1DZrUjVyU1aBx980VR"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final Surface A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 33);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{66, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 72, 67, 89, 76, 89, 68, 66, 67, 105, 72, 74, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, 72, 94, Ascii.CR, 64, 88, 94, 89, Ascii.CR, 79, 72, Ascii.CR, Ascii.GS, 1, Ascii.CR, Ascii.DC4, Ascii.GS, 1, Ascii.CR, Ascii.FS, Ascii.NAK, Ascii.GS, 1, Ascii.CR, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.CR, Ascii.US, Ascii.SUB, Ascii.GS};
    }

    static {
        A01();
    }

    public AnonymousClass50(Surface surface, int i3, int i4) {
        this(surface, i3, i4, 0);
    }

    public AnonymousClass50(Surface surface, int i3, int i4, int i5) {
        AbstractC04323y.A09(i5 == 0 || i5 == 90 || i5 == 180 || i5 == 270, A00(0, 45, 12));
        this.A03 = surface;
        this.A02 = i3;
        this.A00 = i4;
        this.A01 = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnonymousClass50)) {
            return false;
        }
        AnonymousClass50 anonymousClass50 = (AnonymousClass50) obj;
        if (this.A02 == anonymousClass50.A02 && this.A00 == anonymousClass50.A00) {
            int i3 = this.A01;
            int i4 = anonymousClass50.A01;
            if (A05[7].charAt(29) == 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[2] = "IfmXZsmHB8xObc4DA1o6c";
            strArr[3] = "9bmF1UX1T4riDJeOAx7tH";
            if (i3 == i4 && this.A03.equals(anonymousClass50.A03)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A03.hashCode();
        int i3 = result * 31;
        int result2 = this.A02;
        int result3 = (((i3 + result2) * 31) + this.A00) * 31;
        int result4 = this.A01;
        return result3 + result4;
    }
}
