package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class WJ implements InterfaceC1600fw {
    public static byte[] A01;
    public static String[] A02 = {"Pvxnryfp5C2YJ", "58Tt8xWVSP1vJRxeZG7By0J4DHdpZFgc", "d8fJjrUVSDGdkyzleHZclvn63G4sHX0L", "2vkexQ2kDfwHm", "C5INcofoFkRix0Rm4DG2QIlt8jox4BBj", "", "Y25u3HoHlGlpJYy8Y", "MTcvQGxX9nLrxfee4M1dH5SKsx5IsifC"};
    public final /* synthetic */ T8 A00;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[5].length() == 8) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "YNZl3vrESdm0ZjqRAgqNuDMkNkDkDjcM";
            strArr[2] = "T4MR0Bp8ShJAOBNGhRUi97nIryoGWHBS";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 37);
            i6++;
        }
    }

    public static void A01() {
        A01 = new byte[]{Ascii.SUB, 56, 55, 126, Framer.STDIN_FRAME_PREFIX, 121, 61, 48, 42, 41, 56, Framer.STDIN_FRAME_PREFIX, 58, Framer.STDOUT_FRAME_PREFIX, 121, 58, 54, 44, 55, Framer.STDIN_FRAME_PREFIX, 60, 43, 42, 119, 77, 96, 122, 121, 104, 125, 106, 97, 108, 109, 41, 106, 102, 124, 103, 125, 108, 123, 122, 39, 41, 91, 108, 122, 121, 102, 103, 122, 108, 51, 41};
    }

    static {
        A01();
    }

    public WJ(T8 t8) {
        this.A00 = t8;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1600fw
    public final void ADR(InterfaceC1598fu interfaceC1598fu) {
        if (this.A00.A05().AAO() && interfaceC1598fu != null) {
            String str = A00(24, 31, 44) + interfaceC1598fu.A73();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1600fw
    public final void ADq(Exception exc) {
        if (this.A00.A05().AAO()) {
            Log.e(VL.A01, A00(0, 24, 124), exc);
        }
    }
}
