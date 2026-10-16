package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.ElementTypesAreNonnullByDefault;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class CC implements InterfaceC1879kj<Character> {
    public static byte[] A00;
    public static String[] A01 = {"hclkFSbi6Vg1BfvH0wmaDr4dbn73", "G9lpasi9RBaNNLModxK5K8gUTz14LheK", "Gftcr", "paUG0VLHuMGB0YhbqyP1Nk9wNO1yz", "Gk6etbpP6dMkcTEXSV9xUYuIVF", "di9Lt", "", "3ewjDWS3ktgbM1wBomSiDURsX5cxFOtv"};

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-80, -79, -78, -77, -76, -75, -74, -73, -72, -71, -63, -62, -61, -60, -59, -58};
    }

    public abstract boolean A09(char c3);

    static {
        A07();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.1C] */
    public static C1C A02(final char match) {
        return new C2S(match) { // from class: com.facebook.ads.redexgen.X.1C
            public static byte[] A01;
            public static String[] A02 = {"9yE19", "zOI7IBt", "QcxtIsV3beme0fSshBZEiAbzAb", "54lX5AjhAsj9h7", "50Stt6", "IBfS2nVlEcQ7MYOv0zA4iOMcJ", "2Gh0ygEYZnFezhOBR", "xA0qoezlN6x4dJxmGj9eAbu4w6XV572R"};
            public final char A00;

            public static String A00(int i3, int i4, int i5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
                for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                    byte b3 = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 115);
                    if (A02[2].length() != 26) {
                        throw new RuntimeException();
                    }
                    A02[1] = "Dls36CWZuql1";
                    bArrCopyOfRange[i6] = b3;
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                byte[] bArr = {55, 57, Ascii.EM, Framer.STDERR_FRAME_PREFIX, 59, 40, Ascii.ETB, 59, 46, 57, Framer.STDERR_FRAME_PREFIX, 63, 40, 116, 51, 41, 114, 125};
                if (A02[1].length() == 27) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[0] = "urSdB";
                strArr[6] = "hh6CYTzAaza6NCd4D";
                A01 = bArr;
            }

            static {
                A01();
            }

            {
                this.A00 = match;
            }

            @Override // com.facebook.ads.redexgen.core.CC
            public final boolean A09(char c3) {
                return c3 == this.A00;
            }

            public final String toString() {
                return A00(2, 16, 41) + CC.A04(this.A00) + A00(0, 2, 99);
            }
        };
    }

    public static CC A03() {
        CC cc = C0v.A01;
        if (A01[1].charAt(7) == 'R') {
            throw new RuntimeException();
        }
        A01[1] = "RCT2CzV9IWXJqUHkaSW8fbkoFpPJrj9F";
        return cc;
    }

    public static String A04(char c3) {
        String strA06 = A06(0, 16, 115);
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i3 = 0;
        while (A01[7].charAt(17) != '8') {
            A01[3] = "qYlA5j1UP55Q3fDxlHttfnhdcQNgK";
            if (i3 < 4) {
                cArr[5 - i3] = strA06.charAt(c3 & 15);
                c3 = (char) (c3 >> 4);
                i3++;
            } else {
                String hex = String.copyValueOf(cArr);
                return hex;
            }
        }
        throw new RuntimeException();
    }

    public int A08(CharSequence sequence, int start) {
        int length = sequence.length();
        AbstractC1878ki.A01(start, length);
        while (start < length) {
            char cCharAt = sequence.charAt(start);
            String[] strArr = A01;
            String str = strArr[2];
            String str2 = strArr[5];
            int i3 = str.length();
            int length2 = str2.length();
            if (i3 != length2) {
                throw new RuntimeException();
            }
            A01[1] = "6mJi9OgqL4fnjCQ1IPpC8dqdRNdbhMMp";
            if (A09(cCharAt)) {
                return start;
            }
            start++;
        }
        return -1;
    }

    @Deprecated
    public boolean A0A(Character character) {
        return A09(character.charValue());
    }
}
