package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.du, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1475du implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C04384e A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.SYN, 41, 36, 37, 47, Ascii.DLE, 44, Framer.ENTER_FRAME_PREFIX, 57, 34, Framer.ENTER_FRAME_PREFIX, 35, 43, 5, Framer.STDERR_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 47, Framer.STDERR_FRAME_PREFIX};
    }

    public RunnableC1475du(C04384e c04384e) {
        this.A00 = c04384e;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0Q(A00(0, 18, 81));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
