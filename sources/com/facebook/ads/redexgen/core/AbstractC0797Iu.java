package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class AbstractC0797Iu {
    public static byte[] A01;

    @MetaExoPlayerCustomization("Adding TYPE_xml")
    public static final int A02;
    public final int A00;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{-26, -37, -38, -114};
    }

    static {
        A04();
        A02 = C5C.A0D(A03(0, 4, 3));
    }

    public AbstractC0797Iu(int i3) {
        this.A00 = i3;
    }

    public static int A00(int i3) {
        return 16777215 & i3;
    }

    public static int A01(int i3) {
        return (i3 >> 24) & 255;
    }

    public static String A02(int i3) {
        return A03(0, 0, 9) + ((char) ((i3 >> 24) & 255)) + ((char) ((i3 >> 16) & 255)) + ((char) ((i3 >> 8) & 255)) + ((char) (i3 & 255));
    }

    public String toString() {
        return A02(this.A00);
    }
}
