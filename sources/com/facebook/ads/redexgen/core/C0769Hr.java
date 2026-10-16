package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0769Hr implements InterfaceC1286aq {
    public static byte[] A01;
    public static String[] A02 = {"lymitVL5Elx23yNuagrdcc1tj4byFzuO", "OtHhm4I6MY8qhok47NcALtT", "GJmhN4rXhrf709OMeDU9UKBK4KfDlX2Y", "UKN", "ioCWBc07RK8NAgZ7uqzQ2Ov99bHrMaFb", "vsb8Ufoa8H", "zp4FcHB1hqlJdpy7ZALmHMQwB62WRf78", "qbR"};
    public final /* synthetic */ AnonymousClass55 A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A02[1].length() != 23) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "68tvMXLM0DzUKrc9PEEpmru8eIlurAzh";
        strArr[2] = "oZlS45uLmtttWs7KR8Y8sKnmk93hftbi";
        A01 = new byte[]{51, Framer.STDOUT_FRAME_PREFIX, 35, 48, Ascii.GS, 44, Ascii.US, 52, 39, 37, Ascii.US, Framer.STDERR_FRAME_PREFIX, 39, Framer.STDIN_FRAME_PREFIX, 44, Ascii.GS, 39, Ascii.US, 32};
    }

    static {
        A01();
    }

    public C0769Hr(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AF7(String str) {
        this.A00.A0H = false;
        if (this.A00.A05 != null) {
            this.A00.A05.setProgress(100);
        }
        YB.A0O(this.A00.A05, 8);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AF9(String str) {
        this.A00.A0H = true;
        YB.A0O(this.A00.A05, 0);
        if (this.A00.A04 != null) {
            this.A00.A04.setUrl(str);
        }
        if (!this.A00.A0G && this.A00.A01 > 1) {
            this.A00.A0G = true;
            this.A00.A0r(A00(0, 19, 88));
        }
        AnonymousClass55 anonymousClass55 = this.A00;
        if (A02[1].length() != 23) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[7] = "Ijw";
        strArr[3] = "65M";
        AnonymousClass55.A03(anonymousClass55);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFY(int i3) {
        if (this.A00.A0H && this.A00.A05 != null) {
            this.A00.A05.setProgress(i3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFb(String str) {
        if (this.A00.A04 != null) {
            this.A00.A04.setTitle(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1286aq
    public final void AFe() {
        ((AbstractC0787Ij) this.A00).A0B.ADJ(14);
    }
}
