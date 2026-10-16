package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class NA extends BroadcastReceiver {
    public static byte[] A04;
    public InterfaceC1844k8 A00;
    public N9 A01;
    public C1648gi A02;
    public String A03;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{Framer.EXIT_FRAME_PREFIX, 66, 78, 76, Ascii.SI, 71, 64, 66, 68, 67, 78, 78, 74, Ascii.SI, 64, 69, 82, Ascii.SI, 67, 64, 79, 79, 68, 83, Ascii.SI, 66, 77, 72, 66, 74, 68, 69};
    }

    public NA(C1648gi c1648gi, String str, InterfaceC1844k8 interfaceC1844k8, N9 n9) {
        this.A02 = c1648gi;
        this.A03 = str;
        this.A01 = n9;
        this.A00 = interfaceC1844k8;
    }

    public final void A02() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(A00(1, 31, 48) + A00(0, 1, 83) + this.A03);
        P2.A00(this.A02).A06(this, intentFilter);
    }

    public final void A03() {
        P2.A00(this.A02).A05(this);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        String intentAction = A00(0, 1, 83);
        String[] parts = action.split(intentAction);
        String str = parts[0];
        if (str == null) {
            return;
        }
        String intentAction2 = A00(1, 31, 48);
        if (intentAction2.equals(str)) {
            this.A01.ADC(this.A00);
        }
    }
}
