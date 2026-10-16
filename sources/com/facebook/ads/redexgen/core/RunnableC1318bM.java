package com.facebook.ads.redexgen.core;

import android.animation.ObjectAnimator;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1318bM implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C6U A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.FF, 1, Ascii.GS, 5, Ascii.FF};
    }

    public RunnableC1318bM(C6U c6u) {
        this.A00 = c6u;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strA00 = A00(0, 5, 64);
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0U.A0F().AKi();
            ObjectAnimator.ofFloat(this.A00.A0Q, strA00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator.ofFloat(this.A00.A0P, strA00, 1.0f, 0.0f).setDuration(100L).start();
            ObjectAnimator duration = ObjectAnimator.ofFloat(((AbstractC1311bF) this.A00).A09, strA00, 1.0f, 0.0f).setDuration(100L);
            duration.addListener(new C1317bL(this));
            duration.start();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
