package com.facebook.ads.redexgen.core;

import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.AccessTokenManager;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ViewOnAttachStateChangeListenerC1160Xe extends AbstractC2255rL implements View.OnAttachStateChangeListener {
    public static byte[] A02;
    public final View A00;
    public final C1644ge A01;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.DEL, 64, 76, 94, 89, 70, 64, 71, 93, 9, Ascii.DEL, 64, 76, 94, 9, 69, 64, 79, 76, 74, 80, 74, 69, 76, 9, 74, 91, 72, 90, 65, 64, 71, 78, 9, 90, 93, 72, 91, 93, 122, 74, 72, 71, 9, 9, Ascii.VT, 52, 56, 42, Framer.STDIN_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 52, 51, 41, 125, Ascii.VT, 52, 56, 42, 125, Framer.STDOUT_FRAME_PREFIX, 52, 59, 56, 62, 36, 62, Framer.STDOUT_FRAME_PREFIX, 56, 125, 62, 47, 60, 46, 53, 52, 51, 58, 125, 46, 41, 60, 47, 41, Ascii.SO, 62, 60, 51, 19, Framer.STDERR_FRAME_PREFIX, 42, 125, 125, 103, 88, 84, 70, 65, 94, 88, Framer.STDIN_REQUEST_FRAME_PREFIX, 69, 17, 103, 88, 84, 70, 17, 93, 88, 87, 84, 82, 72, 82, 93, 84, 17, 82, 67, 80, 66, 89, 88, Framer.STDIN_REQUEST_FRAME_PREFIX, 86, 17, 66, 69, 94, 65, 98, 82, 80, Framer.STDIN_REQUEST_FRAME_PREFIX, 17, 17, 8, Ascii.RS, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.US, 36, Ascii.CAN, 19, Ascii.SUB, Ascii.NAK, Ascii.NAK, Ascii.RS, Ascii.ETB};
    }

    public ViewOnAttachStateChangeListenerC1160Xe(View view, C1644ge c1644ge) {
        this.A00 = view;
        this.A01 = c1644ge;
        this.A00.addOnAttachStateChangeListener(this);
        if (A05()) {
            try {
                A00();
            } catch (Throwable th) {
                this.A01.A08().ABC(A00(137, 14, 83), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(0, 45, 1) + th.getMessage()));
            }
        }
    }

    public final void A04() {
        try {
            A00();
        } catch (Throwable th) {
            this.A01.A08().ABC(A00(137, 14, 83), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(45, 48, 117) + th.getMessage()));
        }
    }

    public final boolean A05() {
        return Ph.A0H(this.A00);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        try {
            A00();
        } catch (Throwable th) {
            this.A01.A08().ABC(A00(137, 14, 83), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(0, 45, 1) + th.getMessage()));
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        try {
            A02();
        } catch (Throwable th) {
            this.A01.A08().ABC(A00(137, 14, 83), AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, new C1061Te(A00(93, 44, 25) + th.getMessage()));
        }
    }
}
