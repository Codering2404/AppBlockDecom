package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K7 {
    public static byte[] A05;
    public static String[] A06 = {"rlpJzJvMZPS96752sWOw4hHmtt9HQE0Q", "UPlQWo", "ZXUw26V2c7", "6tEwv6Up9NP4MOjnWwfRMdieV7ltrfDK", "1MWXcVZusFrtXDSpfsJ6Y4yHAb", "3y9vGkKnNQnOlcIPORqt4hFWNeEUPhWe", "", "J1HUrfSw1j9IlDpk2TzINIeAn4Xj8ByV"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A06;
            if (strArr[0].charAt(28) == strArr[3].charAt(28)) {
                throw new RuntimeException();
            }
            A06[6] = "";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 99);
            i6++;
        }
    }

    public static void A02() {
        A05 = new byte[]{122, 107, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 64, 76, 89, Ascii.ETB, 89, 82, 88, 2, 5, Ascii.DLE, 3, 5, 118, 113, 124, 105, 96, Framer.ENTER_FRAME_PREFIX, 48, Framer.STDIN_FRAME_PREFIX, Framer.ENTER_FRAME_PREFIX};
    }

    static {
        A02();
    }

    public K7(int i3, int i4, int i5, int i6, int i7) {
        this.A02 = i3;
        this.A00 = i4;
        this.A03 = i5;
        this.A04 = i6;
        this.A01 = i7;
    }

    public static K7 A00(String str) {
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        String strA01 = A01(1, 7, 78);
        AbstractC04323y.A07(str.startsWith(strA01));
        int startTimeIndex = strA01.length();
        String[] keys = TextUtils.split(str.substring(startTimeIndex), A01(0, 1, 53));
        int i7 = 0;
        while (true) {
            int startTimeIndex2 = keys.length;
            int textIndex = -1;
            if (i7 < startTimeIndex2) {
                String strA012 = AbstractC1843k7.A01(keys[i7].trim());
                int startTimeIndex3 = strA012.hashCode();
                switch (startTimeIndex3) {
                    case 100571:
                        if (strA012.equals(A01(8, 3, 95))) {
                            textIndex = 1;
                        }
                        break;
                    case 3556653:
                        if (strA012.equals(A01(21, 4, 54))) {
                            textIndex = 3;
                        }
                        break;
                    case 109757538:
                        if (strA012.equals(A01(11, 5, 18))) {
                            textIndex = 0;
                        }
                        break;
                    case 109780401:
                        int endTimeIndex = A06[7].charAt(11);
                        if (endTimeIndex == 70) {
                            throw new RuntimeException();
                        }
                        A06[6] = "";
                        if (strA012.equals(A01(16, 5, 102))) {
                            textIndex = 2;
                        }
                        break;
                        break;
                }
                switch (textIndex) {
                    case 0:
                        i3 = i7;
                        break;
                    case 1:
                        i4 = i7;
                        break;
                    case 2:
                        i5 = i7;
                        break;
                    case 3:
                        i6 = i7;
                        break;
                }
                i7++;
            } else {
                if (i3 != -1 && i4 != -1 && i6 != -1) {
                    return new K7(i3, i4, i5, i6, keys.length);
                }
                return null;
            }
        }
    }
}
