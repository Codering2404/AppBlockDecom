package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC04715l {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{52, 64, 57, 56, 69, 54, 73, 69, 43, Ascii.FS, 47, 43, -26, Framer.STDIN_FRAME_PREFIX, 43, 43, 32, Ascii.NAK, Ascii.DC4};
    }

    public static /* synthetic */ boolean A02(String str) {
        if (str == null) {
            return false;
        }
        String strA01 = AbstractC1843k7.A01(str);
        if (TextUtils.isEmpty(strA01)) {
            return false;
        }
        return ((strA01.contains(A00(4, 4, 105)) && !strA01.contains(A00(8, 8, 79))) || strA01.contains(A00(0, 4, 100)) || strA01.contains(A00(16, 3, 64))) ? false : true;
    }
}
