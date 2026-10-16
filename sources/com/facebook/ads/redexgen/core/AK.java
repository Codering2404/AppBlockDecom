package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("non-final in Fb vs final in Exo since TigonDataSource uses FailoverStreamDryException that extends this exception")
public class AK extends C2134p5 {
    public static byte[] A04;
    public final int A00;
    public final String A01;
    public final Map<String, List<String>> A02;
    public final byte[] A03;

    static {
        A02();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{Ascii.DLE, 39, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 44, Framer.STDOUT_FRAME_PREFIX, 39, 98, Framer.ENTER_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 38, 39, Framer.EXIT_FRAME_PREFIX, 98};
    }

    public AK(int i3, String str, IOException iOException, Map<String, List<String>> map, C04685i c04685i, byte[] bArr) {
        super(A01(0, 15, 39) + i3, iOException, c04685i, AdError.INTERNAL_ERROR_2004, 1);
        this.A00 = i3;
        this.A01 = str;
        this.A02 = map;
        this.A03 = bArr;
    }
}
