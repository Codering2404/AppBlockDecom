package com.facebook.ads.redexgen.core;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class R1 implements InterfaceC1141Wi {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-100, -104, -105, -53, -70, -65, -69, -60, -71, -69, -92, -69, -54, -51, -59, -56, -63, -48, -23, -26, -23, -22, -14, -23, -101, -32, -13, -34, -32, -21, -17, -28, -22, -23, -87};
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1141Wi
    public final void AAx(int i3, Throwable th) {
        Log.e(A00(0, 17, 58), A00(17, 18, 95), th);
    }
}
