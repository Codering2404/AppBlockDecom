package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.go, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1654go extends AbstractRunnableC1135Wc {
    public static byte[] A02;
    public final /* synthetic */ C1653gn A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.SO, 44, 46, 51, 48, -21, Framer.STDOUT_FRAME_PREFIX, 44, 52, 55, -7, -110, -80, -78, -73, -76, 111, -62, -60, -78, -78, -76, -62, -62, 125};
    }

    public C1654go(C1653gn c1653gn, AtomicBoolean atomicBoolean) {
        this.A00 = c1653gn;
        this.A01 = atomicBoolean;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        if (this.A00.A00 != null) {
            if (this.A01.get()) {
                this.A00.A02.A0I(VH.A0H);
                T0.A02(this.A00.A02.A04, this.A00.A01, T0.A00, A00(11, 14, 1), this.A00.A02.A00);
                this.A00.A02.A0U();
                this.A00.A00.ADT();
                return;
            }
            this.A00.A02.A0I(VH.A0G);
            T0.A02(this.A00.A02.A04, this.A00.A01, T0.A04, A00(0, 11, 125), this.A00.A02.A00);
            this.A00.A02.A0V();
            this.A00.A00.ADL();
        }
    }
}
