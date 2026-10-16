package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import java.lang.reflect.Field;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0964Pg {
    public static Field A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"02HXzqXk73QVshK", "Vd3PIQVGbymKr1peOQp46bHqBe5g9xLl", "HcoaSp9EGPDRlMz", "LE49K9mUXs4bvL0Dhr0uWsVmH5LUwBm4", "LDPLoHz6UrHGmx6GMbvpIivkJ6REIOLV", "AJsKzOma0c3h", "nSSDOEXzoGvtoIqz4QDa0TtkmnPlbH1G", "jHxdDI4CDuwq"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-28, -72, -38, -38, -36, -22, -22, -32, -39, -32, -29, -32, -21, -16, -69, -36, -29, -36, -34, -40, -21, -36};
    }

    public abstract int A02(View view);

    public abstract int A03(View view);

    public abstract int A04(View view);

    public abstract int A05(View view);

    public abstract Display A06(View view);

    public abstract C0979Py A07(View view, C0979Py c0979Py);

    public abstract C0979Py A08(View view, C0979Py c0979Py);

    public abstract void A09(View view);

    public abstract void A0A(View view);

    public abstract void A0B(View view, int i3);

    public abstract void A0C(View view, Drawable drawable);

    public abstract void A0E(View view, PR pr);

    public abstract void A0F(View view, Runnable runnable);

    public abstract void A0G(View view, Runnable runnable, long j3);

    public abstract boolean A0I(View view);

    public abstract boolean A0J(View view);

    static {
        A01();
        A01 = false;
    }

    public final void A0D(View view, PL pl) {
        view.setAccessibilityDelegate(pl == null ? null : pl.A00());
    }

    public final boolean A0H(View view) {
        if (A01) {
            return false;
        }
        Field field = A00;
        if (A03[6].charAt(21) == 'T') {
            A03[1] = "Q1ruOHxOk6WILPvKf2GjHGHRzmp539Hk";
            if (field == null) {
                try {
                    A00 = View.class.getDeclaredField(A00(0, 22, 90));
                    A00.setAccessible(true);
                } catch (Throwable unused) {
                    A01 = true;
                    if (A03[6].charAt(21) == 'T') {
                        String[] strArr = A03;
                        strArr[0] = "nDS37f2fXP1nkU7";
                        strArr[2] = "CEc31ZmnNMQB0dp";
                        return false;
                    }
                }
            }
            try {
                return A00.get(view) != null;
            } catch (Throwable unused2) {
                A01 = true;
                return false;
            }
        }
        throw new RuntimeException();
    }
}
