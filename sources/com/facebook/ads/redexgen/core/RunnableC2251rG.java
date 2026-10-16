package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.rG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC2251rG implements Runnable {
    public static byte[] A03;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C2250rF A01;
    public final /* synthetic */ Exception A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{58, 56, 41, Ascii.EM, 56, Framer.STDOUT_FRAME_PREFIX, 60, 36};
    }

    public RunnableC2251rG(C2250rF c2250rF, int i3, Exception exc) {
        this.A01 = c2250rF;
        this.A00 = i3;
        this.A02 = exc;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            try {
                if (this.A01.A01) {
                    if (!C0588Ao.A07 || !this.A01.A0B()) {
                        this.A01.A08(this.A01.A05.ACf());
                        C2250rF.A03(this.A01);
                        if (0 == 0) {
                            int delay = this.A00;
                            this.A01.A04.postDelayed(this.A01.A0C, delay);
                            return;
                        } else {
                            C2250rF.A03(this.A01);
                            throw new NullPointerException(A00(0, 8, 12));
                        }
                    }
                    this.A01.A0F();
                }
            } catch (Exception ex) {
                ex.initCause(this.A02);
                throw ex;
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
