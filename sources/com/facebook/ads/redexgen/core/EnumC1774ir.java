package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1774ir {
    A09(A00(173, 7, 111)),
    A07(A00(145, 11, 71)),
    A0A(A00(SensibleDefaults.X_OFFSET, 16, 94)),
    A06(A00(129, 16, 114)),
    A08(A00(156, 17, 64)),
    A05(A00(120, 9, 118)),
    A04(A00(98, 22, 15));

    public static byte[] A01;
    public static String[] A02 = {"3irfHjb1xBggEOYppIC20CVGO", "PvTwVw4l1egAAUgNiEJHpQxcY", "Z83jj4f2UJi7iIzCa97fW954cYyfIvRS", "Pn3ECjM654pG8xNfJs7iPR6nvOfTtg4S", "rnvCizUmlaJkbQ0LWt7EGYvIVwvlRHSU", "Y4v1TwA3VTqRjFpvhM1P5mrv4yN1Kb1i", "iJ3TP1yTdydKb8xTTpNjz5p9ilImmlzt", "3Fyn3bOdC3lEL0zKVakbNgp9AIkAOPYu"};
    public final String A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = bArrCopyOfRange[i6] ^ i5;
            String[] strArr = A02;
            if (strArr[4].charAt(18) != strArr[3].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[4] = "9Fh1XlTwmrAkPSBsBt7sR6HEZ4z1EPMB";
            strArr2[3] = "w0XpqxyBnVeSACOsJ07N96wKg89kpHEO";
            bArrCopyOfRange[i6] = (byte) (i7 ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{71, 80, 67, 67, 64, 87, 90, 71, 64, 73, 74, 82, 90, 81, 77, 87, 64, 86, 77, 74, 73, 65, Ascii.EM, Ascii.DLE, Ascii.CR, Ascii.FS, Ascii.SUB, 0, Ascii.SUB, 17, Ascii.ESC, Framer.ENTER_FRAME_PREFIX, 32, 48, 32, 58, 59, 63, 58, 59, 48, Framer.STDIN_FRAME_PREFIX, 58, 41, 41, 42, 61, 103, 124, 101, 101, 118, 111, 102, 123, 100, 104, 125, 79, 73, 78, 90, 93, Framer.STDIN_REQUEST_FRAME_PREFIX, 89, 67, 82, 83, 72, 67, 78, 89, 93, 88, 69, 2, Ascii.EM, Ascii.FS, Ascii.EM, Ascii.CAN, 0, Ascii.EM, Ascii.DEL, 105, 97, 124, 97, 102, 111, 119, 110, 103, 122, 119, 99, 109, 113, 123, 86, 65, 82, 82, 81, 70, 107, 86, 81, 88, 91, 67, 107, 64, 92, 70, 81, 71, 92, 91, 88, 80, 43, 34, 63, 46, 40, Ascii.DC2, 40, 35, 41, 39, 38, Ascii.SYN, 38, 60, 61, 57, 60, 61, Ascii.SYN, 43, 60, 47, 47, 44, 59, Ascii.DC2, 9, Ascii.DLE, Ascii.DLE, 35, Ascii.SUB, 19, Ascii.SO, 17, Ascii.GS, 8, 8, Ascii.SO, 9, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.RS, 36, Ascii.NAK, Ascii.DC4, Ascii.SI, 36, 9, Ascii.RS, Ascii.SUB, Ascii.US, 2, Framer.ENTER_FRAME_PREFIX, 58, 63, 58, 59, 35, 58, Ascii.DC2, 4, Ascii.FF, 17, Ascii.FF, Ascii.VT, 2, 58, 3, 10, Ascii.ETB, 58, Ascii.SO, 0, Ascii.FS, Ascii.SYN};
    }

    static {
        A01();
    }

    EnumC1774ir(String str) {
        this.A00 = str;
    }
}
