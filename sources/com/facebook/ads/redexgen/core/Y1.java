package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Y1 {
    public static byte[] A00;
    public static String[] A01 = {"kzsYhm9LKsU0BkYF5GBD4cHOfO5I2S", "FiiX6q", "juV27aOscABEXHLMFQmBucT", "1EXxaj", "f1sOyyKe81qkTfSynlEtElAllv4GRKo", "lzeqJRba", "GXB72S", "F9UQYukVDOEwI1lxcupNtKixpZh4OtVr"};
    public static final Y0 A02 = null;

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{64, 75, 86, 3, Ascii.ETB, 8, Ascii.DC4, Ascii.NAK, Ascii.DC2, Ascii.DLE, Framer.STDERR_FRAME_PREFIX, 61, 116, 39, 115, 53, 60, Framer.ENTER_FRAME_PREFIX, 62, Framer.STDERR_FRAME_PREFIX, 39, 115, 39, 58, 62, 54, 125};
    }

    static {
        A08();
    }

    public static long A00() {
        if (A02 != null) {
            return A02.A5n();
        }
        return System.currentTimeMillis();
    }

    public static long A01(long j3) {
        return A02(j3, System.currentTimeMillis());
    }

    public static long A02(long j3, long j4) {
        if (j3 == -1) {
            return -1L;
        }
        return j4 - j3;
    }

    public static String A03(double d3) throws Exception {
        try {
            return String.format(Locale.US, A04(0, 4, 115), Double.valueOf(d3));
        } catch (Exception e3) {
            String simpleName = Y1.class.getSimpleName();
            if (A01[3].length() == 20) {
                Exception e4 = new RuntimeException();
                throw e4;
            }
            A01[0] = "ylDYykVZ0MQgZWbzvTC4Y0QCoTAruV";
            Log.e(simpleName, A04(9, 18, 69), e3);
            return A04(4, 5, 48);
        }
    }

    public static String A05(long j3) {
        return String.valueOf(A01(j3));
    }

    @Deprecated
    public static String A06(long j3) {
        return A03(j3 / 1000.0d);
    }

    public static String A07(long j3) {
        return Long.toString(j3);
    }
}
