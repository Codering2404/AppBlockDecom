package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.il, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1769il extends AbstractRunnableC1135Wc {
    public static byte[] A01;
    public final /* synthetic */ AbstractC1768ik A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{7, 38, 48, 55, Framer.STDOUT_FRAME_PREFIX, 44, 58, 99, 52, 34, 48, 99, Framer.STDIN_FRAME_PREFIX, 44, 55, 99, 32, 34, 47, 47, 38, 39, 109, 123, Ascii.DEL, 124, 72, 89, 84, 88, 83, 94, 88, 115, 88, 73, 74, 82, 79, 86, 86, 96, 122, 47, 107, 102, 107, 97, 40, 123, 47, 108, 110, 99, 99, 47, 107, 106, 124, 123, 125, 96, 118, 39, 38, 47, 105, 96, 125, 47, 78, 107, 47, 64, 109, 101, 106, 108, 123, Framer.ENTER_FRAME_PREFIX, 47, 91, 103, 102, 124, 47, 98, 110, 118, 47, 99, 106, 110, 107, 47, 123, 96, 47, 99, 106, 110, 100, 102, 97, 104, 47, 98, 106, 98, 96, 125, 118, Framer.ENTER_FRAME_PREFIX, 47, Framer.STDIN_REQUEST_FRAME_PREFIX, 99, 106, 110, 124, 106, 35, 47, 110, 99, Framer.EXIT_FRAME_PREFIX, 110, 118, 124, 47, 108, 110, 99, 99, 47, 107, 106, 124, 123, 125, 96, 118, 39, 38, 47, Framer.EXIT_FRAME_PREFIX, 103, 106, 97, 47, 118, 96, 122, 47, 107, 96, 97, 40, 123, 47, 97, 106, 106, 107, 47, 123, 103, 102, 124, 47, 78, 107, 47, 64, 109, 101, 106, 108, 123, 47, 110, 97, 118, 47, 98, 96, 125, 106, Framer.ENTER_FRAME_PREFIX, 56, 41, 48};
    }

    public C1769il(AbstractC1768ik abstractC1768ik) {
        this.A00 = abstractC1768ik;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A00.A02.A0F().A3V();
        if (this.A00.A00.A6p() == OD.A03) {
            return;
        }
        if (!BuildConfigApi.isDebug()) {
            this.A00.A02.A08().ABz(A00(188, 3, 107), AbstractC1060Td.A0Y, new C1061Te(A00(0, 23, 113)));
        }
        Log.e(A00(23, 17, 15), A00(40, 148, 61));
        this.A00.A08();
    }
}
