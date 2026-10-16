package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AI implements InterfaceC2144pF {
    public static byte[] A00;
    public static final C5Y A01;
    public static final AI A02;

    public static /* synthetic */ AI A00() {
        return new AI();
    }

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{Ascii.ETB, 43, 38, 36, 34, 47, 40, 43, 35, 34, 53, 3, 38, 51, 38, Ascii.DC4, 40, Framer.STDERR_FRAME_PREFIX, 53, 36, 34, 103, 36, 38, 41, 41, 40, 51, 103, 37, 34, 103, 40, 55, 34, 41, 34, 35};
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final /* synthetic */ Map A8t() {
        return C5X.A00(this);
    }

    static {
        A02();
        A02 = new AI();
        A01 = new C5Y() { // from class: com.facebook.ads.redexgen.X.p4
            @Override // com.facebook.ads.redexgen.core.C5Y
            public final InterfaceC2144pF A5I() {
                return AI.A00();
            }
        };
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void A43(InterfaceC04795t interfaceC04795t) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Uri A9P() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final long AGi(C04685i c04685i) throws IOException {
        throw new IOException(A01(0, 38, 57));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void close() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC03882c
    public final int read(byte[] bArr, int i3, int i4) {
        throw new UnsupportedOperationException();
    }
}
