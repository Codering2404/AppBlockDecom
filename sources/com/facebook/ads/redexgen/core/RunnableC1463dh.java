package com.facebook.ads.redexgen.core;

import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1463dh implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass56 A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{98, 93, 80, 81, 91, 100, 88, 85, 77, 86, 85, 87, Framer.STDIN_REQUEST_FRAME_PREFIX, 113, 70, 70, 91, 70};
    }

    public RunnableC1463dh(AnonymousClass56 anonymousClass56) {
        this.A00 = anonymousClass56;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0s(A00(0, 18, 82));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
