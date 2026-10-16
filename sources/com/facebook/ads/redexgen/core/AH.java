package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AH implements InterfaceC2144pF {
    public static byte[] A03;
    public final int A00;
    public final AbstractC04133d A01;
    public final InterfaceC2144pF A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{1, 3, 0, -12, -10, -10, -11, -32, 3, -27, -7, 3, 0, 8};
    }

    public AH(InterfaceC2144pF interfaceC2144pF, AbstractC04133d abstractC04133d, int i3) {
        this.A02 = (InterfaceC2144pF) AbstractC04323y.A01(interfaceC2144pF);
        AbstractC04323y.A01(abstractC04133d);
        this.A01 = null;
        this.A00 = i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void A43(InterfaceC04795t interfaceC04795t) {
        AbstractC04323y.A01(interfaceC04795t);
        this.A02.A43(interfaceC04795t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Map<String, List<String>> A8t() {
        return this.A02.A8t();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final Uri A9P() {
        return this.A02.A9P();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final long AGi(C04685i c04685i) throws IOException {
        throw new NullPointerException(A00(0, 14, 104));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2144pF
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC03882c
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        throw new NullPointerException(A00(0, 14, 104));
    }
}
