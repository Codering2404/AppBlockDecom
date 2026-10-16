package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1335bd implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C6M A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{61, 48, 43, 44, 54};
    }

    public ViewOnClickListenerC1335bd(C6M c6m) {
        this.A00 = c6m;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.getCtaButton().A0E(A00(0, 5, 111));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
