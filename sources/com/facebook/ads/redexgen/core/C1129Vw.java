package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1129Vw extends N2 {
    public static byte[] A01;
    public final /* synthetic */ UK A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Framer.STDIN_REQUEST_FRAME_PREFIX, 112, 101, Framer.EXIT_FRAME_PREFIX, 103, 116, Framer.STDOUT_FRAME_PREFIX, 112, 117, 98, Framer.STDOUT_FRAME_PREFIX, 124, 112, Ascii.DEL, 112, 118, 116, 99, Framer.STDOUT_FRAME_PREFIX, 101, 121, 116, Framer.EXIT_FRAME_PREFIX, 99, Framer.STDOUT_FRAME_PREFIX, 126, 102, Ascii.DEL, Framer.STDOUT_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 124, 97, 99, 116, 98, 98, Framer.EXIT_FRAME_PREFIX, 126, Ascii.DEL, 98, 63};
    }

    public C1129Vw(UK uk) {
        this.A00 = uk;
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0B(C1830ju c1830ju) {
        this.A00.A1d(c1830ju);
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0C() {
        if (this.A00.A0I != null) {
            this.A00.A0I.ACm();
        }
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 15));
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0F(N1 n12) {
        if (this.A00.A0B != null) {
            this.A00.A0B.A0M();
        }
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0G(C1120Vm c1120Vm) {
        this.A00.A16().A0F().A3N(Y1.A01(this.A00.A00), c1120Vm.A03().getErrorCode(), c1120Vm.A04());
        if (this.A00.A0I != null) {
            this.A00.A0I.ADp(c1120Vm);
        }
    }
}
