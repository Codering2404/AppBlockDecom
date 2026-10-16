package com.facebook.ads.redexgen.core;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1164Xi {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{62, Framer.STDERR_FRAME_PREFIX, 48, 115, 59, 60, 62, 56, 63, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 54, 115, 54, 60, 41, 60, 51, 60};
    }

    public static PackageInfo A00(T8 t8) {
        return A01(t8, A02(0, 19, 49));
    }

    public static PackageInfo A01(T8 t8, String str) {
        PackageManager packageManager;
        if (TextUtils.isEmpty(str) || (packageManager = t8.getPackageManager()) == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(str, 1);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        } catch (RuntimeException unused2) {
            return null;
        }
    }

    public static boolean A04(T8 t8, String str) {
        PackageInfo packageInfo = A01(t8, str);
        return packageInfo != null;
    }
}
