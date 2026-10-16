package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class P3 {
    public static byte[] A00;
    public static String[] A01 = {"OxqqmxACKcMb9rgd4flgeoqO4FLkDXK8", "hO921EE08Z5YovLaOXzv", "4KPhJxryuqZouci8ltOnoaa6GepMOFR6", "Qaf3Cf9SMgDDqCFg3avrhgzCiMtnLJnE", "vZFktEahG3bWOXRkYAMaCi8nGdaO1v3Q", "tZHqmUfqpLYo8cwpqndw", "zlaA7TXYCJ", "adeIrckSIlUrZ7yW4ZooAIUWBthMSkAF"};
    public static final ThreadLocal<double[]> A02;

    public static String A07(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{Ascii.SUB, Ascii.ETB, Ascii.VT, 19, Ascii.SUB, 91, Ascii.SYN, Ascii.SO, 8, Ascii.SI, 91, Ascii.EM, Ascii.RS, 91, Ascii.EM, Ascii.RS, Ascii.SI, Ascii.FF, Ascii.RS, Ascii.RS, Ascii.NAK, 91, 75, 91, Ascii.SUB, Ascii.NAK, Ascii.US, 91, 73, 78, 78, 85, 59, 56, 58, Framer.STDERR_FRAME_PREFIX, 62, 43, 54, 44, 55, 61, 121, 58, 56, 55, 121, 55, 54, Framer.STDIN_FRAME_PREFIX, 121, 59, 60, 121, Framer.STDIN_FRAME_PREFIX, 43, 56, 55, 42, 53, 44, 58, 60, 55, Framer.STDIN_FRAME_PREFIX, 99, 121, 122, 63, 37, 36, 8, 41, 42, 112, 61, 37, 35, 36, 112, 56, Framer.STDOUT_FRAME_PREFIX, 38, 53, 112, Framer.STDOUT_FRAME_PREFIX, 112, 60, 53, 62, 55, 36, 56, 112, 63, 54, 112, 99, 126};
    }

    static {
        A08();
        A02 = new ThreadLocal<>();
    }

    public static double A00(int i3) {
        double[] dArrA0B = A0B();
        A0A(i3, dArrA0B);
        return dArrA0B[1] / 100.0d;
    }

    public static double A01(int i3, int i4) {
        if (Color.alpha(i4) == 255) {
            if (Color.alpha(i3) < 255) {
                i3 = A04(i3, i4);
            }
            double luminance2 = A00(i3) + 0.05d;
            double luminance1 = A00(i4) + 0.05d;
            return Math.max(luminance2, luminance1) / Math.min(luminance2, luminance1);
        }
        throw new IllegalArgumentException(A07(32, 36, 97) + Integer.toHexString(i4));
    }

    public static int A02(int i3, int i4) {
        if (i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException(A07(0, 32, 67));
        }
        String[] strArr = A01;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A01[0] = "DAqAm14HDJv7tSHiVIRuluRO44d0lStM";
        return (16777215 & i3) | (i4 << 24);
    }

    public static int A03(int i3, int i4) {
        return 255 - (((255 - i4) * (255 - i3)) / 255);
    }

    public static int A04(int i3, int i4) {
        int iAlpha = Color.alpha(i4);
        int iAlpha2 = Color.alpha(i3);
        int g3 = A03(iAlpha2, iAlpha);
        int fgAlpha = Color.red(i3);
        int bgAlpha = Color.red(i4);
        int r2 = A06(fgAlpha, iAlpha2, bgAlpha, iAlpha, g3);
        int fgAlpha2 = Color.green(i3);
        int bgAlpha2 = Color.green(i4);
        int a3 = A06(fgAlpha2, iAlpha2, bgAlpha2, iAlpha, g3);
        int fgAlpha3 = Color.blue(i3);
        int bgAlpha3 = Color.blue(i4);
        return Color.argb(g3, r2, a3, A06(fgAlpha3, iAlpha2, bgAlpha3, iAlpha, g3));
    }

    public static int A05(int i3, int i4, float f3) {
        float f4 = 1.0f - f3;
        float inverseRatio = Color.alpha(i4);
        float g3 = (Color.alpha(i3) * f4) + (inverseRatio * f3);
        float inverseRatio2 = Color.red(i4);
        float r2 = (Color.red(i3) * f4) + (inverseRatio2 * f3);
        float a3 = Color.green(i3);
        float inverseRatio3 = Color.green(i4);
        float a4 = (a3 * f4) + (inverseRatio3 * f3);
        float inverseRatio4 = Color.blue(i4);
        float b3 = (Color.blue(i3) * f4) + (inverseRatio4 * f3);
        return Color.argb((int) g3, (int) r2, (int) a4, (int) b3);
    }

    public static int A06(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        return (((i3 * 255) * i4) + ((i5 * i6) * (255 - i4))) / (i7 * 255);
    }

    public static void A09(int i3, int i4, int i5, double[] dArr) {
        double sb;
        double sr;
        double sb2;
        if (dArr.length == 3) {
            double sb3 = ((double) i3) / 255.0d;
            if (sb3 < 0.04045d) {
                sb = sb3 / 12.92d;
            } else {
                sb = Math.pow((sb3 + 0.055d) / 1.055d, 2.4d);
            }
            double sr2 = ((double) i4) / 255.0d;
            if (sr2 < 0.04045d) {
                sr = sr2 / 12.92d;
            } else {
                double sr3 = sr2 + 0.055d;
                if (A01[2].charAt(0) != 'Y') {
                    String[] strArr = A01;
                    strArr[3] = "aAOO9yx7jRsDtZ33Oh1YUTlwgCOJU7qQ";
                    strArr[4] = "tiIjGPCneBcQleUKUeg5FNX5aBHKyIuK";
                    sr = Math.pow(sr3 / 1.055d, 2.4d);
                }
                throw new RuntimeException();
            }
            double sb4 = ((double) i5) / 255.0d;
            if (sb4 >= 0.04045d) {
                String[] strArr2 = A01;
                if (strArr2[5].length() == strArr2[1].length()) {
                    String[] strArr3 = A01;
                    strArr3[5] = "axgx58ekBr3JsKBSYEIr";
                    strArr3[1] = "AyWuGeE7FNinezs3svxh";
                    double sg = 0.055d + sb4;
                    sb2 = Math.pow(sg / 1.055d, 2.4d);
                }
                throw new RuntimeException();
            }
            sb2 = sb4 / 12.92d;
            double sg2 = 0.4124d * sb;
            dArr[0] = (sg2 + (0.3576d * sr) + (0.1805d * sb2)) * 100.0d;
            double sg3 = 0.2126d * sb;
            dArr[1] = (sg3 + (0.7152d * sr) + (0.0722d * sb2)) * 100.0d;
            double sg4 = 0.0193d * sb;
            dArr[2] = (sg4 + (0.1192d * sr) + (0.9505d * sb2)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException(A07(68, 31, 104));
    }

    public static void A0A(int i3, double[] dArr) {
        A09(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    public static double[] A0B() {
        double[] dArr = A02.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            A02.set(dArr2);
            return dArr2;
        }
        return dArr;
    }
}
