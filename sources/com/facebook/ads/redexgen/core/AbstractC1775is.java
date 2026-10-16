package com.facebook.ads.redexgen.core;

import android.media.MediaFormat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Random;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.is, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1775is {
    public static String A00;
    public static String A01;
    public static byte[] A02;
    public static final Random A03;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{39, 0, 8, Ascii.CR, 4, 5, 65, Ascii.NAK, Ascii.SO, 65, 19, 4, Ascii.NAK, 19, 8, 4, Ascii.ETB, 4, 65, 44, 4, 5, 8, 0, 39, Ascii.SO, 19, Ascii.FF, 0, Ascii.NAK, 73, 100, 115, 110, 68, 121, 110, 84, 117, 104, 109, 9, 43, 54, Framer.ENTER_FRAME_PREFIX, 32, 116, 10, Framer.STDIN_FRAME_PREFIX, 56, Framer.STDIN_FRAME_PREFIX, 44, 42, 126, 72, 89, Ascii.CR, 108, 100, Ascii.CR, 107, Ascii.DEL, 110, Ascii.CR, 124, 107, 105, Ascii.CR, 65, 72, 91, 72, 65, Ascii.CR, 89, 66, Ascii.CR, 8, 73, 59, Ascii.CR, Ascii.FS, 72, 41, Framer.ENTER_FRAME_PREFIX, 72, 46, 58, 43, 72, Ascii.SUB, Ascii.CR, Ascii.EM, Ascii.GS, Ascii.CR, Ascii.ESC, Ascii.FS, 72, Ascii.FS, 7, 72, 89, Ascii.FF, 58, 43, Ascii.DEL, Ascii.RS, Ascii.SYN, Ascii.DEL, Ascii.EM, Ascii.CR, Ascii.FS, Ascii.DEL, 41, 54, 59, 58, 48, Ascii.DEL, 59, 42, Framer.STDIN_FRAME_PREFIX, 62, 43, 54, 48, Framer.STDOUT_FRAME_PREFIX, Ascii.DEL, 43, 48, Ascii.DEL, 122, 59, 37, 40, 36, 42, 37, 57, 19, Ascii.SO, 10, 2, 8, Ascii.DC2, 19, 56, 19, Ascii.NAK, Ascii.RS, Ascii.SO, 9, 0, 56, 19, 8, 56, 1, Ascii.SO, 9, 3, 56, Ascii.DC4, 2, 0, 10, 2, 9, 19, 56, Ascii.SO, 9, 56, 8, Ascii.SO, Ascii.VT, Ascii.SI, Ascii.FS, Ascii.ETB, Ascii.GS, Ascii.SYN, Ascii.VT, 87, 10, Ascii.FS, Ascii.SUB, 84, Ascii.CAN, Ascii.DLE, Ascii.US, Ascii.VT, Ascii.SUB, 84, Ascii.CR, Ascii.VT, Ascii.CAN, Ascii.ETB, 10, Ascii.US, Ascii.FS, Ascii.VT, 84, Ascii.VT, Ascii.FS, 8, Ascii.FF, Ascii.FS, 10, Ascii.CR, 87, Ascii.SI, Ascii.CAN, Ascii.NAK, Ascii.FF, Ascii.FS, 112, 99, 104, 98, 105, 116, 40, 117, 99, 101, 43, 103, 111, 96, 116, 101, 43, 112, 111, 98, 99, 105, 43, 98, 115, 116, 103, 114, 111, 105, 104, 40, 112, 103, 106, 115, 99, 78, 93, 86, 92, 87, 74, Ascii.SYN, 75, 93, 91, Ascii.NAK, 89, 81, 94, 74, 91, Ascii.NAK, 78, 81, 92, 93, 87, Ascii.NAK, 73, 94, 92, Ascii.NAK, 84, 93, 78, 93, 84, Ascii.SYN, 78, 89, 84, 77, 93, 89, 71, 74, 90, 70};
    }

    static {
        A02();
        A00 = A01(41, 12, 83);
        A01 = A01(139, 37, 109);
        A03 = new Random();
    }

    public static int A00(int i3, int i4) {
        if (i4 != 0) {
            return (int) ((Math.pow(2.0d, i3 - 1) * ((double) i4) * 1000.0d) + ((double) A03.nextInt(AdError.SERVER_ERROR_CODE)));
        }
        return (int) Math.min((((long) (i3 - 1)) * 1000) + 500, 5000L);
    }

    public static void A03(C1804jQ c1804jQ, MediaFormat mediaFormat) {
        String strA01 = A01(0, 30, 107);
        String strA012 = A01(30, 11, 11);
        if (!c1804jQ.A01) {
            return;
        }
        try {
            if (C1773iq.A02()) {
                if (c1804jQ.A0P && !C1773iq.A03(mediaFormat.getInteger(A01(290, 5, 36)), mediaFormat.getInteger(A01(133, 6, 71)))) {
                    return;
                }
                long j3 = c1804jQ.A00;
                if (j3 > 0) {
                    mediaFormat.setLong(A01(215, 37, 12), j3);
                    AbstractC1705hd.A01(strA012, A01(102, 31, 85), Long.valueOf(j3));
                }
                mediaFormat.setInteger(A01(252, 38, 50), c1804jQ.A02);
                AbstractC1705hd.A01(strA012, A01(53, 26, 39), Integer.valueOf(c1804jQ.A02));
                mediaFormat.setInteger(A01(176, 39, 115), 1);
                AbstractC1705hd.A00(strA012, A01(79, 23, 98));
            }
        } catch (ClassCastException e3) {
            AbstractC1705hd.A02(strA012, strA01, e3);
        } catch (NullPointerException e4) {
            AbstractC1705hd.A02(strA012, strA01, e4);
        }
    }

    public static boolean A04(C1804jQ c1804jQ, int i3, int i4, int i5, int i6) {
        if (c1804jQ.A01 && c1804jQ.A0P && C1773iq.A03(i3, i4) != C1773iq.A03(i5, i6)) {
            return true;
        }
        return false;
    }
}
