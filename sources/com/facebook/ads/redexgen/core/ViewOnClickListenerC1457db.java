package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.db, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1457db implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass55 A00;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{115, 104, 104, 107, 101, 102, 117};
    }

    public ViewOnClickListenerC1457db(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0D) {
                this.A00.A0t(A00(0, 7, 8));
                this.A00.A0Z.ACQ();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
