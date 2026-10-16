package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class JH {
    public static byte[] A00;
    public static String[] A01 = {"f", "wBzTr9isyWuzk0Was82fzP", "sjHXZ8xDB", "rmj8ZpQPq6N", "k0JnkexrU5JvppKLiAvWnmQe", "wOTrIZh22Rcriy8Kptm38zvp", "MO9vm10BV89BFpJ5cx5aSl", "G2cEiJ7mV"};

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {-68, -33, -33, -44, -83, -32, -37, -39, -63, -32, -43, -40, -20, 5, 10, Ascii.FF, 7, 7, 6, 9, Ascii.VT, -4, -5, -73, 7, 10, 10, -1, -73, Ascii.CR, -4, 9, 10, 0, 6, 5, -47, -73};
        String[] strArr = A01;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "tjOAGVDnT";
        strArr2[7] = "ur6F1gHbb";
        A00 = bArr;
    }

    static {
        A03();
    }

    public static JG A00(byte[] bArr) {
        C04554v c04554v = new C04554v(bArr);
        if (c04554v.A0A() < 32) {
            return null;
        }
        c04554v.A0f(0);
        if (c04554v.A0C() != c04554v.A07() + 4 || c04554v.A0C() != 1886614376) {
            return null;
        }
        int dataSize = AbstractC0797Iu.A01(c04554v.A0C());
        if (dataSize > 1) {
            AbstractC04404g.A07(A01(0, 12, 82), A01(12, 26, 125) + dataSize);
            return null;
        }
        UUID uuid = new UUID(c04554v.A0P(), c04554v.A0P());
        if (dataSize == 1) {
            c04554v.A0g(c04554v.A0L() * 16);
        }
        int atomType = c04554v.A0L();
        String[] strArr = A01;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A01[6] = "Op4nBnIC0DPoqkcvuw04qL";
        if (atomType != c04554v.A07()) {
            return null;
        }
        byte[] bArr2 = new byte[atomType];
        c04554v.A0k(bArr2, 0, atomType);
        return new JG(uuid, dataSize, bArr2);
    }

    public static UUID A02(byte[] bArr) {
        JG parsedAtom = A00(bArr);
        if (parsedAtom != null) {
            return parsedAtom.A01;
        }
        return null;
    }
}
