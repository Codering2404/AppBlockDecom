package com.facebook.ads.redexgen.core;

import android.view.Surface;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class G3 {
    public static byte[] A00;
    public static String[] A01 = {"C9RGb7NCXIcFkq487TbtOiV6wJyl5V", "dIw4BKlzmuU3zMuMzRjmW2qgnJuCAgWy", "9uTfiPT", "rJUClzDzuXOVG7xlKmzeqZnP5Peloa5p", "Z", "9S6veErjLDkLbxAihnisBS", "TmmUyGbb1uzRJUdaHSZi2e0nreAYvBIE", "B53ji15DIU9T3sUrLFCN0rmnX0Pwja5D"};

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            int i7 = (bArrCopyOfRange[i6] ^ i5) ^ 94;
            if (A01[0].length() != 30) {
                throw new RuntimeException();
            }
            A01[0] = "TD1mTFY2qo3QaoZPZEPw0mbH2R8uHE";
            bArrCopyOfRange[i6] = (byte) i7;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {Ascii.DC4, 51, 59, 62, 55, 54, 114, 38, 61, 114, Framer.STDOUT_FRAME_PREFIX, 51, 62, 62, 114, 1, 39, 32, 52, 51, Framer.STDOUT_FRAME_PREFIX, 55, 124, Framer.ENTER_FRAME_PREFIX, 55, 38, Ascii.DC4, 32, 51, 63, 55, 0, 51, 38, 55, 77, 114, Ascii.DEL, 126, 116, 93, 105, 122, 118, 126, 73, 126, 119, 126, 122, 104, 126, 83, 126, 119, 107, 126, 105};
        if (A01[2].length() != 7) {
            throw new RuntimeException();
        }
        A01[5] = "Lq9CeCJTygMtbBn2m02oyI";
        A00 = bArr;
    }

    static {
        A01();
    }

    public static void A02(Surface surface, float f3) {
        int compatibility;
        if (f3 == 0.0f) {
            compatibility = 0;
        } else {
            compatibility = 1;
        }
        try {
            surface.setFrameRate(f3, compatibility);
        } catch (IllegalStateException e3) {
            AbstractC04404g.A08(A00(35, 23, 69), A00(0, 35, 12), e3);
        }
    }
}
