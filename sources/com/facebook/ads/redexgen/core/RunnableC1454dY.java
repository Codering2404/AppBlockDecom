package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1454dY implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C5G A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{78, 113, 124, 125, 119, 72, 116, 121, 97, 122, 121, 123, 115, 93, 106, 106, 119, 106};
    }

    public RunnableC1454dY(C5G c5g) {
        this.A00 = c5g;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0Z.AGQ(A00(0, 18, 75));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
