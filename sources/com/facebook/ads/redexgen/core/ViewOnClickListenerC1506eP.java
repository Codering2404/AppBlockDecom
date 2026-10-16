package com.facebook.ads.redexgen.core;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1506eP implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1509eS A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{4, Ascii.SI, 5, 2, 0, 19, 5, Ascii.DC2};
    }

    public ViewOnClickListenerC1506eP(C1509eS c1509eS) {
        this.A00 = c1509eS;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0l == null) {
                return;
            }
            this.A00.A0l.A0E(A00(0, 8, 44));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
