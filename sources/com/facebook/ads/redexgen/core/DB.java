package com.facebook.ads.redexgen.core;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.TextView;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DB implements InterfaceC1562fK {
    public static byte[] A06;
    public ValueAnimator A00;
    public EnumC1561fJ A01 = EnumC1561fJ.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    static {
        A05();
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{Framer.STDOUT_FRAME_PREFIX, 32, 61, Framer.STDOUT_FRAME_PREFIX, 6, 42, 41, 42, 55};
    }

    public DB(View view, int i3, int i4, int i5) {
        this.A02 = i3;
        this.A05 = view;
        this.A04 = i4;
        this.A03 = i5;
    }

    private void A06(int i3, int i4) {
        this.A01 = i3 == this.A04 ? EnumC1561fJ.A03 : EnumC1561fJ.A05;
        this.A00 = ObjectAnimator.ofInt((TextView) this.A05, A04(0, 9, 85), i3, i4);
        this.A00.setEvaluator(new ArgbEvaluator());
        this.A00.setDuration(this.A02);
        this.A00.addListener(new C1568fQ(this, i3, i4));
        this.A00.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(int i3, int i4, boolean z2) {
        if (z2) {
            A06(i3, i4);
        } else {
            ((TextView) this.A05).setTextColor(i4);
            this.A01 = i4 == this.A03 ? EnumC1561fJ.A02 : EnumC1561fJ.A04;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void A4A(boolean z2, boolean z3) {
        int endColor = z3 ? this.A03 : this.A04;
        int startColor = z3 ? this.A04 : this.A03;
        A07(endColor, startColor, z2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final EnumC1561fJ A9B() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
