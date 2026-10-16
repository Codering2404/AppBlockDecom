package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC0890Mj {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{9, Ascii.FS, 19, 3, Ascii.DLE, 9, Ascii.DC2, 17, 36, Ascii.ESC, Ascii.VT, Ascii.RS, 17, Ascii.DLE, Ascii.NAK, Ascii.RS};
    }

    public static long A00(InterfaceC0891Mk interfaceC0891Mk) {
        return interfaceC0891Mk.A6h(A02(0, 7, 111), -1L);
    }

    public static Uri A01(InterfaceC0891Mk interfaceC0891Mk) {
        String strA6j = interfaceC0891Mk.A6j(A02(7, 9, 119), null);
        if (strA6j == null) {
            return null;
        }
        return Uri.parse(strA6j);
    }
}
