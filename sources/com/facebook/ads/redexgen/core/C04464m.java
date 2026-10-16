package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04464m {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-13, -21, -14, -15, -24};
    }

    public static void A02(Context context, C04494p c04494p) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) AbstractC04323y.A01((TelephonyManager) context.getSystemService(A00(0, 5, 11)));
            C04454l callback = new C04454l(c04494p);
            telephonyManager.registerTelephonyCallback(context.getMainExecutor(), callback);
            telephonyManager.unregisterTelephonyCallback(callback);
        } catch (RuntimeException unused) {
            c04494p.A07(5);
        }
    }
}
