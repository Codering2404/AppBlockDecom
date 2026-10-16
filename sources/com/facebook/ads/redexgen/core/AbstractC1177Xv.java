package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.StringTokenizer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1177Xv {
    public static byte[] A00;
    public static String[] A01 = {"4IRJGuEovS11eWhLlTHcTHgAIcL0Dfrc", "lMuOXcilHIakoSNiM9TiHcKlty4yon92", "2r", AppEventsConstants.EVENT_PARAM_VALUE_NO, "YIb1Fa9ANLl8YhZPR0dNpX70Iddjh9PH", "Y", "pnRx8X5Hy3x4IRuF7DDbibtYxh7eaWKw", "bsDursaggw8Ai2drbHqfQpiV"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 85);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{76, Ascii.ETB, Ascii.ETB, Ascii.ETB};
    }

    static {
        A02();
    }

    public static String A01(String str) {
        if (str != null) {
            String truncatedBody = A00(0, 1, 57);
            StringTokenizer stringTokenizer = new StringTokenizer(str, truncatedBody, true);
            int tokenLength = 0;
            int maxLength = str.length();
            if (maxLength > 90) {
                int length = str.length();
                String[] strArr = A01;
                String truncatedBody2 = strArr[1];
                String str2 = strArr[0];
                int iCharAt = truncatedBody2.charAt(16);
                int maxLength2 = str2.charAt(16);
                if (iCharAt == maxLength2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[7] = "q4cROosmp2j6ascm330FkUlu";
                strArr2[5] = "E";
                String strA00 = A00(1, 3, 108);
                if (length > 93 || !str.endsWith(strA00)) {
                    while (stringTokenizer.hasMoreTokens()) {
                        String truncatedBody3 = stringTokenizer.nextToken();
                        int length2 = truncatedBody3.length();
                        if (tokenLength + length2 < 90) {
                            tokenLength += length2;
                        }
                    }
                    if (tokenLength == 0) {
                        StringBuilder sb = new StringBuilder();
                        String truncatedBody4 = str.substring(0, 90);
                        return sb.append(truncatedBody4).append(strA00).toString();
                    }
                    StringBuilder sb2 = new StringBuilder();
                    String truncatedBody5 = str.substring(0, tokenLength);
                    return sb2.append(truncatedBody5).append(strA00).toString();
                }
                return str;
            }
            return str;
        }
        return str;
    }
}
