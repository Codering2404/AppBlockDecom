package com.facebook.ads.redexgen.core;

import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum VW {
    A05(0, NativeAdBase.MediaCacheFlag.NONE),
    A04(1, NativeAdBase.MediaCacheFlag.ALL);

    public static byte[] A02;
    public final long A00;
    public final NativeAdBase.MediaCacheFlag A01;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{117, -128, -128, -123, -122, -123, 124};
    }

    static {
        A02();
    }

    VW(long j3, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = j3;
        this.A01 = mediaCacheFlag;
    }

    @Nullable
    public static VW A00(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        for (VW vw : values()) {
            if (vw.A01 == mediaCacheFlag) {
                return vw;
            }
        }
        return null;
    }
}
