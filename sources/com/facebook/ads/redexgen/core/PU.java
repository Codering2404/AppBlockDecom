package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class PU extends AbstractC1183Yb {
    public static byte[] A03;
    public C1648gi A00;
    public InterfaceC1182Ya A01;
    public final ZM A02;

    static {
        A05();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-75, -34, -31, -27, -41, -110, -77, -42};
    }

    public PU(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, int i3) {
        super(c1648gi);
        this.A00 = c1648gi;
        setGravity(16);
        A04();
        this.A02 = new ZM(this.A00, abstractC1813jd, i3);
        A03();
    }

    private void A03() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.A02.setContentDescription(A02(0, 8, 39));
        this.A02.setActionClickListener(new ViewOnClickListenerC1199Yr(this));
        addView(this.A02, layoutParams);
    }

    private void A04() {
        View view = new View(this.A00);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        addView(view);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0A() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0B() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0C(float f3, int i3) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0D(C0906Na c0906Na, boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final boolean A0E() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public int getToolbarActionMode() {
        return this.A02.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public int getToolbarHeight() {
        return AbstractC1183Yb.A01;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public InterfaceC1182Ya getToolbarListener() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setAdReportingVisible(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setCTAClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setCTAClickListener(ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setFullscreen(boolean z2) {
    }

    public void setInitialUnskippableSeconds(int i3) {
        this.A02.setInitialUnskippableSeconds(i3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setPageDetails(C0918Nm c0918Nm, String str, int i3, C0924Ns c0924Ns) {
        this.A02.setInitialUnskippableSeconds(i3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setPageDetailsVisible(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgress(float f3) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressImage(YM ym) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressImmediate(float f3) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressSpinnerInvisible(boolean z2) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setToolbarActionMode(int i3) {
        this.A02.setToolbarActionMode(i3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setToolbarListener(InterfaceC1182Ya interfaceC1182Ya) {
        this.A01 = interfaceC1182Ya;
    }
}
