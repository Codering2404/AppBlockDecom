package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class Z0 implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ Z2 A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{124, Framer.EXIT_FRAME_PREFIX, 116, 114, 112};
    }

    public Z0(Z2 z2) {
        this.A00 = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A07.getCTAButton().A0E(A00(0, 5, 121));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
