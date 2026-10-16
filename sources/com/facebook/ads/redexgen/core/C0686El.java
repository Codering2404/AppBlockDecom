package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.El, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0686El {
    public static byte[] A03;
    public final int A00;
    public final C2171pg A01;
    public final int[] A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-11, 4, 3, -12, Ascii.NAK, Ascii.SYN, Ascii.EM, Ascii.RS, Ascii.EM, 36, Ascii.EM, Ascii.US, Ascii.RS, 3, 43, 46, Framer.STDERR_FRAME_PREFIX, 55, -34, Framer.STDERR_FRAME_PREFIX, 48, Ascii.US, Framer.ENTER_FRAME_PREFIX, 41, Framer.STDOUT_FRAME_PREFIX, -34, Ascii.US, 48, 35, -34, 44, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, -34, Ascii.US, 42, 42, Framer.STDIN_FRAME_PREFIX, 53, 35, 34};
    }

    public C0686El(C2171pg c2171pg, int... iArr) {
        this(c2171pg, iArr, 0);
    }

    public C0686El(C2171pg c2171pg, int[] iArr, int i3) {
        if (iArr.length == 0) {
            AbstractC04404g.A08(A00(0, 13, 94), A00(13, 28, 108), new IllegalArgumentException());
        }
        this.A01 = c2171pg;
        this.A02 = iArr;
        this.A00 = i3;
    }
}
