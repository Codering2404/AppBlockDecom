package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1192Yk implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ ViewOnClickListenerC05096x A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-106, -108, -122, -109, -128, -125, -106, -121, -121, -122, -109, -122, -123, -128, -124, -115, -118, -124, -116, -128, -126, -121, -107, -122, -109, -128, -123, -122, -115, -126, -102};
    }

    public RunnableC1192Yk(ViewOnClickListenerC05096x viewOnClickListenerC05096x) {
        this.A00 = viewOnClickListenerC05096x;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0I(A00(0, 31, 20));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
