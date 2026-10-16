package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KC {
    public static byte[] A0A;
    public static String[] A0B = {"6HehIsk5UTdQ8YwGLZ8u", "HAdSfToap9UtbNGqUYR7rfHJagkNK6YB", "nRaQRY6nAt4CmU7uet6FlSe17FvhWZYJ", "8IXD4Lb5", "pveGGnyGJyzGs1AN", "NjeHfVTmziUN3gQJJf", "25ItPJi0PU1GUlSkVtogtpFEj7NyufcW", "xHU94vBDrMO8JpAh"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final Integer A03;
    public final Integer A04;
    public final String A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{47, 65, 118, 55, Ascii.DC2, 53, 61, 56, Framer.STDOUT_FRAME_PREFIX, 48, 116, 32, 59, 116, 36, 53, 38, 39, Framer.STDOUT_FRAME_PREFIX, 116, 54, 59, 59, 56, Framer.STDOUT_FRAME_PREFIX, 53, 58, 116, 34, 53, 56, Framer.ENTER_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 110, 116, 115, 38, 1, 9, Ascii.FF, 5, 4, 64, Ascii.DC4, Ascii.SI, 64, Ascii.DLE, 1, Ascii.DC2, 19, 5, 64, 3, Ascii.SI, Ascii.FF, Ascii.SI, Ascii.DC2, 64, 5, Ascii.CAN, Ascii.DLE, Ascii.DC2, 5, 19, 19, 9, Ascii.SI, Ascii.SO, 90, 64, 71, 101, 66, 74, 79, 70, 71, 3, 87, 76, 3, 83, 66, 81, 80, 70, 3, 69, 76, 77, 87, 3, 80, 74, 89, 70, Ascii.EM, 3, 4, 77, 99, 106, 107, 118, 109, 106, 99, 36, 113, 106, 111, 106, 107, 115, 106, 36, 70, 107, 118, 96, 97, 118, 87, 112, 125, 104, 97, 62, 36, 100, 74, 67, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 68, 67, 74, Ascii.CR, 88, 67, 70, 67, 66, 90, 67, Ascii.CR, 76, 65, 68, 74, 67, 64, 72, 67, 89, Ascii.ETB, Ascii.CR, Framer.EXIT_FRAME_PREFIX, 64, 66, 91, 91, 66, 69, 76, Ascii.VT, 70, 74, 71, 77, 68, 89, 70, 78, 79, Ascii.VT, Ascii.FF, Framer.EXIT_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX, 82, 71, 78, 17, Ascii.FF, Ascii.VT, 71, 66, 69, 78, Ascii.VT, 3, 78, 83, 91, 78, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 79, Ascii.VT, Ascii.SO, 88, Ascii.VT, 93, 74, 71, 94, 78, 88, 7, Ascii.VT, 77, 68, 94, 69, 79, Ascii.VT, Ascii.SO, 88, 2, 17, Ascii.VT, Ascii.FF, Ascii.SO, 88, Ascii.FF, 90, 98, 96, 121, 121, 96, 103, 110, 41, 100, 104, 101, 111, 102, 123, 100, 108, 109, 41, 46, 90, 125, 112, 101, 108, 51, 46, 41, 101, 96, 103, 108, 51, 41, 46, 90, 122, 104, 90, 125, 112, 101, 108, 56, Ascii.US, Ascii.DC2, 7, Ascii.SO, 81};
    }

    static {
        A07();
    }

    public KC(String str, int i3, Integer num, Integer num2, float f3, boolean z2, boolean z3, boolean z4, boolean z5, int i4) {
        this.A05 = str;
        this.A01 = i3;
        this.A04 = num;
        this.A03 = num2;
        this.A00 = f3;
        this.A06 = z2;
        this.A07 = z3;
        this.A09 = z4;
        this.A08 = z5;
        this.A02 = i4;
    }

    public static float A00(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e3) {
            AbstractC04404g.A0A(A06(261, 8, 80), A06(71, 28, 122) + str + A06(2, 1, 8), e3);
            return -3.4028235E38f;
        }
    }

    public static int A01(String str) {
        try {
            int i3 = Integer.parseInt(str.trim());
            if (A08(i3)) {
                return i3;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC04404g.A07(A06(261, 8, 80), A06(129, 28, 116) + str);
        return -1;
    }

    public static int A02(String str) {
        try {
            int i3 = Integer.parseInt(str.trim());
            if (A09(i3)) {
                return i3;
            }
        } catch (NumberFormatException unused) {
        }
        AbstractC04404g.A07(A06(261, 8, 80), A06(99, 30, 93) + str);
        return -1;
    }

    public static KC A04(String str, K8 k8) {
        int iA01;
        Integer numA05;
        Integer numA052;
        float fA00;
        String strA06 = A06(269, 6, 50);
        AbstractC04323y.A07(str.startsWith(strA06));
        String[] strArrSplit = TextUtils.split(str.substring(strA06.length()), A06(3, 1, 66));
        int length = strArrSplit.length;
        int i3 = k8.A05;
        String strA062 = A06(261, 8, 80);
        if (length != i3) {
            AbstractC04404g.A07(strA062, C5C.A0n(A06(157, 69, 114), Integer.valueOf(k8.A05), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[k8.A06].trim();
            if (k8.A00 != -1) {
                iA01 = A01(strArrSplit[k8.A00].trim());
            } else {
                iA01 = -1;
            }
            if (k8.A08 != -1) {
                numA05 = A05(strArrSplit[k8.A08].trim());
            } else {
                numA05 = null;
            }
            if (k8.A07 != -1) {
                numA052 = A05(strArrSplit[k8.A07].trim());
            } else {
                numA052 = null;
            }
            if (k8.A03 != -1) {
                fA00 = A00(strArrSplit[k8.A03].trim());
            } else {
                fA00 = -3.4028235E38f;
            }
            return new KC(strTrim, iA01, numA05, numA052, fA00, k8.A01 != -1 && A0A(strArrSplit[k8.A01].trim()), k8.A04 != -1 && A0A(strArrSplit[k8.A04].trim()), k8.A0A != -1 && A0A(strArrSplit[k8.A0A].trim()), k8.A09 != -1 && A0A(strArrSplit[k8.A09].trim()), k8.A02 != -1 ? A02(strArrSplit[k8.A02].trim()) : -1);
        } catch (RuntimeException e3) {
            AbstractC04404g.A0A(strA062, A06(226, 35, 80) + str + A06(2, 1, 8), e3);
            return null;
        }
    }

    public static Integer A05(String str) {
        long j3;
        try {
            if (str.startsWith(A06(0, 2, 80))) {
                j3 = Long.parseLong(str.substring(2), 16);
            } else {
                j3 = Long.parseLong(str);
            }
            AbstractC04323y.A07(j3 <= 4294967295L);
            int iA02 = AbstractC0592As.A02(((j3 >> 24) & 255) ^ 255);
            int iA022 = AbstractC0592As.A02((j3 >> 16) & 255);
            int b3 = AbstractC0592As.A02((j3 >> 8) & 255);
            int a3 = AbstractC0592As.A02(j3 & 255);
            return Integer.valueOf(Color.argb(iA02, a3, b3, iA022));
        } catch (IllegalArgumentException e3) {
            AbstractC04404g.A0A(A06(261, 8, 80), A06(36, 35, 57) + str + A06(2, 1, 8), e3);
            return null;
        }
    }

    public static boolean A08(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean A09(int i3) {
        switch (i3) {
            case 1:
            case 3:
                return true;
            case 2:
            default:
                String[] strArr = A0B;
                if (strArr[7].length() != strArr[4].length()) {
                    throw new RuntimeException();
                }
                A0B[6] = "OxYydzu443viAUiIiorbVSFSlAhvbuco";
                return false;
        }
    }

    public static boolean A0A(String str) {
        try {
            int value = Integer.parseInt(str);
            return value == 1 || value == -1;
        } catch (NumberFormatException e3) {
            AbstractC04404g.A0A(A06(261, 8, 80), A06(4, 32, 13) + str + A06(2, 1, 8), e3);
            return false;
        }
    }
}
