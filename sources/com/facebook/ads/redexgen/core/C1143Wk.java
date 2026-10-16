package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1143Wk {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-19, -7, -9, -72, -16, -21, -19, -17, -20, -7, -7, -11, -72, -21, -18, -3, -72, -13, -8, -2, -17, -4, -8, -21, -10, -72, -21, -18, -3, -23, -3, -6, -23, -3, -2, -7, -4, -21, -15, -17};
    }

    public static SharedPreferences A00(T8 t8) {
        return t8.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(0, 40, 89), t8), 0);
    }

    public final int A03(T8 t8, String str, int i3) {
        return A00(t8).getInt(str, i3);
    }

    public final String A04(T8 t8, String str, String str2) {
        return A00(t8).getString(str, str2);
    }

    public final void A05(T8 t8, String str, int i3) {
        SharedPreferences btSP = A00(t8);
        btSP.edit().putInt(str, i3).apply();
    }

    public final void A06(T8 t8, String str, String str2) {
        SharedPreferences btSP = A00(t8);
        btSP.edit().putString(str, str2).apply();
    }
}
