package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.math.ElementTypesAreNonnullByDefault;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1632gS {
    public static byte[] A00;
    public static String[] A01 = {"AE3RQ6SjoFsrAp99H6Zd4spKw", "3Pq1cGGFUNEEXAchrVP3Xf", "yX", "SQjo6b3iOf0URtZXiBRUVHbWf8EnkAui", "00", "u726MkM70Dw3XEWQiRy0H2gvugSd8Tre", "3sVZHBX6ZyruD1ikbvJFjqJz5AcrXt3h", "iwn02HMEBncjK0hVIYdCKaY5g2oqtZ"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            byte b3 = bArrCopyOfRange[i6];
            if (A01[7].length() == 5) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "H9pmIUr4yhuwQEnoSmBFmn";
            strArr[0] = "tMM9GmlwKAk4hf8HM9GRHGRZ0";
            bArrCopyOfRange[i6] = (byte) ((b3 - i5) - 100);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Framer.STDIN_FRAME_PREFIX, 47, 36, 37, -32, 55, Framer.ENTER_FRAME_PREFIX, 51, -32, Ascii.NAK, Ascii.SO, Ascii.SO, 5, 3, 5, 19, 19, 1, Ascii.DC2, Ascii.EM, -20, -32, 34, 53, 52, -32, Framer.STDERR_FRAME_PREFIX, 47, 53, 46, 36, 41, 46, 39, -32, 55, Framer.ENTER_FRAME_PREFIX, 51, -32, 46, 37, 35, 37, 51, 51, Framer.ENTER_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 57};
    }

    static {
        A01();
    }

    public static void A02(boolean condition) {
        if (condition) {
        } else {
            throw new ArithmeticException(A00(0, 48, 92));
        }
    }
}
