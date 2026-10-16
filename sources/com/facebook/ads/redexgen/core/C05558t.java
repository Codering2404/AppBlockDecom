package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05558t extends Exception {
    public static byte[] A03;
    public final int A00;
    public final C2208qI A01;
    public final boolean A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{60, Ascii.DEL, 119, Framer.STDIN_FRAME_PREFIX, 58, 60, 48, 41, 58, Framer.STDIN_FRAME_PREFIX, 62, 61, 51, 58, 118, 123, 126, 114, 60, 39, 63, Ascii.GS, 52, 19, 39, 54, 59, 61, 6, 32, 51, Framer.STDOUT_FRAME_PREFIX, 57, 19, 62, 62, 61, Framer.STDOUT_FRAME_PREFIX, 51, 38, 55, 54, 111, 42, 38, 86, 98, 115, 126, Framer.EXIT_FRAME_PREFIX, 67, 101, 118, 116, 124, 55, 126, 121, 126, 99, 55, 113, 118, 126, 123, 114, 115, 55, 44, 0, 1, 9, 6, 8, 71};
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @MetaExoPlayerCustomization(type = {"NEW_CLASS"}, value = "D23918943: Monitor the audio track usage")
    public C05558t(int i3, int i4, int i5, int i6, C2208qI c2208qI, boolean z2, Exception exc, int i7) {
        StringBuilder sbAppend = new StringBuilder().append(A00(45, 23, 86)).append(i3);
        String strA00 = A00(0, 1, 93);
        StringBuilder sbAppend2 = sbAppend.append(strA00).append(A00(68, 7, 46)).append(i4);
        String strA002 = A00(43, 2, 71);
        super(sbAppend2.append(strA002).append(i5).append(strA002).append(i6).append(A00(15, 28, 19)).append(i7).append(strA00).append(c2208qI).append(z2 ? A00(1, 14, 30) : A00(0, 0, 74)).toString(), exc);
        this.A00 = i3;
        this.A02 = z2;
        this.A01 = c2208qI;
    }
}
