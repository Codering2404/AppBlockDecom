package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.os.Build;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1773iq {

    @Nullable
    public static Boolean A00;
    public static byte[] A01;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{106, 77, 69, 64, 73, 72, Ascii.FF, 88, 67, Ascii.FF, 75, 73, 88, Ascii.FF, 65, 73, 72, 69, 77, Ascii.FF, 111, 67, 72, 73, 79, 7, 42, 61, 32, 10, 55, 32, Ascii.SUB, 59, 38, 35, 97, 114, 121, 115, Framer.EXIT_FRAME_PREFIX, 101, 57, 100, 114, 116, 58, 118, 126, 113, 101, 116, 58, 99, 101, 118, 121, 100, 113, 114, 101, 58, 101, 114, 102, 98, 114, 100, 99, 57, 97, 118, 123, 98, 114, 65, 94, 83, 82, 88, Ascii.CAN, 86, 65, 84};
    }

    static {
        A01();
        A00 = null;
    }

    public static boolean A02() {
        if (A00 != null) {
            return A00.booleanValue();
        }
        A00 = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(A00(75, 9, 74));
                Iterator<String> it = mediaCodecCreateDecoderByType.getSupportedVendorParameters().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String param = it.next();
                    if (param.equals(A00(36, 39, 106))) {
                        A00 = true;
                        break;
                    }
                }
                mediaCodecCreateDecoderByType.release();
            }
        } catch (IOException e3) {
            String param2 = A00(25, 11, 50);
            AbstractC1705hd.A02(param2, A00(0, 25, 81), e3);
        }
        return A00.booleanValue();
    }

    public static boolean A03(int i3, int i4) {
        if (i3 >= 480 && i4 >= 480 && i3 <= 3840 && i4 <= 2160) {
            return true;
        }
        return false;
    }
}
