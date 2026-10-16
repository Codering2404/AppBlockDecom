package com.facebook.ads.redexgen.core;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class CI implements InterfaceC1698hW {
    public static byte[] A02;
    public static final CI A03;
    public String A01 = A01(1, 7, 98);
    public int A00 = 5;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A02 = new byte[]{-33, 1, -6, -9, -6, -5, 3, -6};
    }

    static {
        A05();
        A03 = new CI();
    }

    public static CI A00() {
        return A03;
    }

    private String A02(String str) {
        if (this.A01 != null) {
            return this.A01 + A01(0, 1, 123) + str;
        }
        return str;
    }

    public static String A03(String str, Throwable th) {
        return str + '\n' + A04(th);
    }

    public static String A04(Throwable th) {
        if (th == null) {
            return A01(0, 0, 21);
        }
        return Log.getStackTraceString(th);
    }

    private void A06(int i3, String str, String str2) {
        Log.println(i3, A02(str), str2);
    }

    private void A07(int i3, String str, String str2, Throwable th) {
        Log.println(i3, A02(str), A03(str2, th));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final void A9t(String str, String str2) {
        A06(4, str, str2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final void A9u(String str, String str2, Throwable th) {
        A07(4, str, str2, th);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final boolean AAY(int i3) {
        return this.A00 <= i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final void AJY(int i3) {
        this.A00 = i3;
    }
}
