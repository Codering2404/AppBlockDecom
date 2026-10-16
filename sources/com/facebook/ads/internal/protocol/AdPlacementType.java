package com.facebook.ads.internal.protocol;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum AdPlacementType {
    BANNER(A00(74, 6, 36)),
    MEDIUM_RECTANGLE(A00(92, 16, 88)),
    INTERSTITIAL(A00(80, 12, 40)),
    NATIVE(A00(108, 6, 13)),
    NATIVE_BANNER(A00(114, 13, 119)),
    REWARDED_VIDEO(A00(127, 14, 85)),
    UNKNOWN(A00(141, 7, 17));

    public static byte[] A01;
    public static String[] A02 = {"CWC1iyAzuHCyWu1B0SYAHTA3miIxyRDu", "FO468KlqU7YYiE83Le7T5pQKY2foYhCa", "4lSmmc8pBcjbV0on62ZikVJFYVLsdMQp", "9H0k66zkYNaHG7pLFG5T73JVLywfdj", "IkTzUK68woTPnHHBk", "q5XpLTEZbHtnyzZXCKIvrGbFL2My8Wb0", "rdQ7fJEKRbVHtvxpiCxMwn5qtJ9qGM1n", "xGvuYGSPJhOX4"};
    public String A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[6].charAt(3) != '7') {
                throw new RuntimeException();
            }
            A02[7] = "CTk8rnXs6cBCh";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 127);
            i6++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-35, -36, -23, -23, -32, -19, -49, -44, -38, -53, -40, -39, -38, -49, -38, -49, -57, -46, Ascii.ETB, Ascii.SI, Ascii.SO, 19, Ascii.US, Ascii.ETB, 41, Ascii.FS, Ascii.SI, Ascii.CR, Ascii.RS, Ascii.VT, Ascii.CAN, 17, Ascii.SYN, Ascii.SI, -33, -46, -27, -38, -25, -42, -13, -26, -7, -18, -5, -22, 4, -25, -26, -13, -13, -22, -9, 44, Ascii.US, Framer.STDOUT_FRAME_PREFIX, Ascii.ESC, 44, Ascii.RS, Ascii.US, Ascii.RS, 57, 48, 35, Ascii.RS, Ascii.US, 41, Ascii.DLE, 9, 6, 9, 10, Ascii.DC2, 9, 5, 4, 17, 17, 8, Ascii.NAK, Ascii.DLE, Ascii.NAK, Ascii.ESC, Ascii.FF, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.DLE, Ascii.ESC, Ascii.DLE, 8, 19, 68, 60, 59, 64, 76, 68, 54, 73, 60, 58, 75, 56, 69, 62, 67, 60, -6, -19, 0, -11, 2, -15, 100, 87, 106, Framer.STDIN_REQUEST_FRAME_PREFIX, 108, 91, 85, 88, 87, 100, 100, 91, 104, 70, 57, 75, 53, 70, 56, 57, 56, 51, 74, 61, 56, 57, 67, 5, -2, -5, -2, -1, 7, -2};
    }

    static {
        A01();
    }

    AdPlacementType(String str) {
        this.A00 = str;
    }

    public static AdPlacementType fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.A00;
    }
}
