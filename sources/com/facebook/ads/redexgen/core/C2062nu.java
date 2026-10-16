package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2062nu implements DD {
    public static byte[] A03;
    public static String[] A04 = {"3Cx8VuBaAtU", "mtIvitx", "ijtxGWvqwx8wBPOmSGXshyr4piVUOT73", "1A2eWfmauMvQ3z4CiBElgktZxGJ5t0Vj", "NuAYfoZUoES6MxZb2vdyJB2K3PVOnnYD", "gczB0K5G5", "TBGYu08V4AAoblIa0rbrS9oc16PYokVw", "JGtQJ9cae1Y"};
    public H9 A00;
    public InterfaceC1999ms A01;
    public final HD A02;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{80, 89, Ascii.SUB, Ascii.SYN, Ascii.FF, Ascii.NAK, Ascii.GS, 89, Ascii.VT, Ascii.FS, Ascii.CAN, Ascii.GS, 89, Ascii.CR, 17, Ascii.FS, 89, 10, Ascii.CR, Ascii.VT, Ascii.FS, Ascii.CAN, Ascii.DC4, 87, 2, 35, 34, 41, 108, 35, 42, 108, 56, 36, 41, 108, Framer.STDIN_FRAME_PREFIX, 58, Framer.STDIN_FRAME_PREFIX, 37, 32, Framer.STDIN_FRAME_PREFIX, 46, 32, 41, 108, 41, 52, 56, 62, Framer.STDIN_FRAME_PREFIX, 47, 56, 35, 62, 63, 108, 100};
    }

    static {
        A01();
    }

    public C2062nu(HD hd) {
        this.A02 = hd;
    }

    @Override // com.facebook.ads.redexgen.core.DD
    @MetaExoPlayerCustomization("No op, we don't include mp3 extractor due to apk size")
    public final void A5y() {
    }

    @Override // com.facebook.ads.redexgen.core.DD
    public final long A7a() {
        if (this.A01 != null) {
            return this.A01.A8n();
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    @Override // com.facebook.ads.redexgen.core.DD
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AAB(@com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization(" To be replaced with DataReader after upstream is updated") com.facebook.ads.redexgen.core.InterfaceC2144pF r16, android.net.Uri r17, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r18, long r19, long r21, com.facebook.ads.redexgen.core.HA r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2062nu.AAB(com.facebook.ads.redexgen.X.pF, android.net.Uri, java.util.Map, long, long, com.facebook.ads.redexgen.X.HA):void");
    }

    @Override // com.facebook.ads.redexgen.core.DD
    public final int AHM(HV hv) throws IOException {
        return ((H9) AbstractC04323y.A01(this.A00)).AHL((InterfaceC1999ms) AbstractC04323y.A01(this.A01), hv);
    }

    @Override // com.facebook.ads.redexgen.core.DD
    public final void AHb() {
        if (this.A00 != null) {
            this.A00.AHb();
            this.A00 = null;
        }
        this.A01 = null;
    }

    @Override // com.facebook.ads.redexgen.core.DD
    public final void AJ6(long j3, long j4) {
        ((H9) AbstractC04323y.A01(this.A00)).AJ6(j3, j4);
    }
}
