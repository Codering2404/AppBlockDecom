package com.facebook.ads.redexgen.core;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class XY {
    public static byte[] A00;
    public static String[] A01 = {"fKOq3CLbRisV2HCvxbP8DswDC3h61WtS", "qQcG8iivYcbnleQXnFNfPBjKpUSTKwt1", "90Y8NMpYXvys60lz4Y4AY7bkcR6rkmkz", "C2raqoqRf1xXuaxgLg", "Co6wMAKL4SYYucOnnpwSDFFGSy", "pPL6tu27HuVGqH4ILm", "ywYYaeUt5bOEJr09A3", "jMc4mNTDFQmf2DaMzWYBnxz0IZlySjfz"};
    public static final String A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.ESC, 57, 54, Ascii.DEL, 44, Framer.EXIT_FRAME_PREFIX, 60, 61, 44, 61, 42, 53, Framer.STDOUT_FRAME_PREFIX, 54, 61, Framer.EXIT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 62, Framer.EXIT_FRAME_PREFIX, 57, 40, 40, Framer.EXIT_FRAME_PREFIX, Framer.STDOUT_FRAME_PREFIX, 43, Framer.EXIT_FRAME_PREFIX, Ascii.CR, 54, Framer.STDOUT_FRAME_PREFIX, 44, Framer.ENTER_FRAME_PREFIX, 118, 55, Ascii.CR, 94, 43, Ascii.DLE, Ascii.ETB, 10, 7, 94, Ascii.US, Ascii.SO, Ascii.SO, 68, 94, 88, 84, 86, Ascii.NAK, 93, 90, 88, 94, 89, 84, 84, 80, Ascii.NAK, 73, 94, 90, 88, 79, Ascii.NAK, 105, 94, 90, 88, 79, 122, 88, 79, 82, 77, 82, 79, 66, Ascii.DC2, Ascii.RS, Ascii.FS, Framer.STDIN_REQUEST_FRAME_PREFIX, 4, Ascii.US, Ascii.CAN, 5, 8, 66, Ascii.NAK, Framer.STDIN_REQUEST_FRAME_PREFIX, 1, Ascii.GS, Ascii.DLE, 8, Ascii.DC4, 3, Framer.STDIN_REQUEST_FRAME_PREFIX, 36, Ascii.US, Ascii.CAN, 5, 8, Framer.ENTER_FRAME_PREFIX, Ascii.GS, Ascii.DLE, 8, Ascii.DC4, 3, 48, Ascii.DC2, 5, Ascii.CAN, 7, Ascii.CAN, 5, 8};
    }

    static {
        A01();
        A02 = XY.class.getSimpleName();
    }

    public static boolean A02() {
        try {
            Class.forName(A00(46, 32, 44));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A03() {
        try {
            Class.forName(A00(78, 38, 102));
            if (A01[2].charAt(21) != '7') {
                throw new RuntimeException();
            }
            A01[2] = "fqSGPLRwldKX66WDmKKlg7YQ1V3cstss";
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean A04(int i3, int i4) {
        return i3 >= 640 && i4 >= 640;
    }

    public static boolean A05(T8 t8) {
        boolean z2 = false;
        try {
            PackageManager packageManager = t8.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            boolean isUnity = true;
            ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(t8.getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                int length = activityInfoArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    boolean activityDeclared = A00(78, 38, 102).equals(activityInfoArr[i3].name);
                    if (!activityDeclared) {
                        i3++;
                    } else {
                        z2 = true;
                        break;
                    }
                }
            }
            if (!z2) {
                boolean activityDeclared2 = A03();
                if (!activityDeclared2) {
                    isUnity = false;
                }
            }
            boolean activityDeclared3 = t8.A05().AAO();
            if (activityDeclared3) {
                String str = A00(32, 14, 105) + isUnity;
            }
            return isUnity;
        } catch (Throwable th) {
            if (t8.A05().AAO()) {
                Log.e(A02, A00(0, 32, 79), th);
            }
            return false;
        }
    }
}
