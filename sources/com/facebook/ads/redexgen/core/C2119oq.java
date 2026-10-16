package com.facebook.ads.redexgen.core;

import android.media.MediaFormat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2119oq implements G2, GR, InterfaceC05147c {
    public static byte[] A04;
    public static String[] A05 = {"s2pX1dUuV9yMGkOQMpNHWy9uhNawnk9Y", "g94kU4b", "NzGTwCFJguijRpsE4vnu2khyHl2vzHxI", "mcwg2", "3H7kdFWigyqN00XNlLPoaD6s2Om", "arwBjFb", "zwCIEju4cqvLZ8D4reT2LOc82uEYQHt6", "4voNbHG588W1rePZ0VIdJriIAfqG9T"};
    public G2 A00;
    public G2 A01;
    public GR A02;
    public GR A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{2, 0, 17, 51, Ascii.FF, 1, 0, 10, 35, Ascii.ETB, 4, 8, 0, 40, 0, 17, 4, 1, 4, 17, 4, 41, Ascii.FF, Ascii.SYN, 17, 0, Ascii.VT, 0, Ascii.ETB};
    }

    static {
        A01();
    }

    public C2119oq() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC05147c
    public final void A9i(int i3, Object obj) {
        switch (i3) {
            case 7:
                this.A01 = (G2) obj;
                return;
            case 8:
                this.A02 = (GR) obj;
                return;
            case ColorExtractionConstants.MAX_PIXEL_SAMPLES /* 10000 */:
                if (0 == 0) {
                    this.A00 = null;
                    this.A03 = null;
                    return;
                }
                throw new NullPointerException(A00(0, 29, 100));
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final void AGS(long j3, long j4, C2208qI c2208qI, MediaFormat mediaFormat) {
        if (this.A00 != null) {
            G2 g22 = this.A00;
            if (A05[0].charAt(20) != 'W') {
                throw new RuntimeException();
            }
            A05[4] = "rCzQpO90p93bI0FQ7tWj9IORt31";
            g22.AGS(j3, j4, c2208qI, mediaFormat);
        }
        if (this.A01 != null) {
            this.A01.AGS(j3, j4, c2208qI, mediaFormat);
        }
    }
}
