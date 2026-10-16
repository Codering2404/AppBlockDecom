package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import com.google.common.primitives.ElementTypesAreNonnullByDefault;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2152pN {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{0, 58, 59, 111, 32, 41, 111, 61, 46, Framer.ENTER_FRAME_PREFIX, 40, 42, 117, 111, 106, 60};
    }

    public static char A00(byte b12, byte b22) {
        return (char) ((b12 << 8) | (b22 & 255));
    }

    public static char A01(long value) {
        char c3 = (char) value;
        AbstractC1878ki.A0H(((long) c3) == value, A02(0, 16, 126), value);
        return c3;
    }

    public static boolean A04(char[] array, char target) {
        for (char c3 : array) {
            if (c3 == target) {
                return true;
            }
        }
        return false;
    }
}
