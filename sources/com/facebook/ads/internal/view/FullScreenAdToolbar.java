package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.redexgen.core.AbstractC1183Yb;
import com.facebook.ads.redexgen.core.AbstractC1352bu;
import com.facebook.ads.redexgen.core.C0906Na;
import com.facebook.ads.redexgen.core.C0918Nm;
import com.facebook.ads.redexgen.core.C0924Ns;
import com.facebook.ads.redexgen.core.C1485e4;
import com.facebook.ads.redexgen.core.C1648gi;
import com.facebook.ads.redexgen.core.InterfaceC1182Ya;
import com.facebook.ads.redexgen.core.InterfaceC1189Yh;
import com.facebook.ads.redexgen.core.VI;
import com.facebook.ads.redexgen.core.ViewOnClickListenerC0846Kr;
import com.facebook.ads.redexgen.core.ViewOnClickListenerC1198Yq;
import com.facebook.ads.redexgen.core.XX;
import com.facebook.ads.redexgen.core.YB;
import com.facebook.ads.redexgen.core.YM;
import com.facebook.ads.redexgen.core.YZ;
import com.facebook.ads.redexgen.core.ZC;
import com.facebook.ads.redexgen.core.ZK;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class FullScreenAdToolbar extends AbstractC1183Yb {
    public static byte[] A0B;
    public static String[] A0C = {"bFTGQZCDUsZohbmTeIVqSIHEteTzH9ln", "yXw5A2C", "1AgOSkHO0Pb00RrFT9UOiqy", "TxDFqDHdXRoHKl2DTNxbpTLqI26RISWJ", "CWbWmw8OaNX6ff1fhEYiHQW6wjCjGro9", "znIzyGoGhCcdAsXYdQkLlPNG9alZ5sNL", "lf2qO9K", "XEgUxEHpppw1PxIgjlcxmDWHelwWu1Ow"};
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public YZ A00;
    public InterfaceC1182Ya A01;
    public InterfaceC1182Ya A02;
    public ZC A03;
    public boolean A04;
    public boolean A05;
    public final RelativeLayout A06;
    public final VI A07;
    public final InterfaceC1189Yh A08;
    public final ZK A09;
    public final C1485e4 A0A;

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {113, -102, -99, -95, -109, 78, 111, -110, -100, -81, -70, -71, -68, -66, 106, -117, -82, -71, -76, -76, -79, -89, -90, -73};
        if (A0C[5].charAt(20) != 'l') {
            throw new RuntimeException();
        }
        A0C[2] = "ATFpsL3dKIxr1CEZIKZeGPZ";
        A0B = bArr;
    }

    static {
        A03();
        A0D = (int) (XX.A02 * 10.0f);
        A0H = (int) (XX.A02 * 16.0f);
        A0F = A0H - A0D;
        A0G = (A0H * 2) - A0D;
        A0E = (int) (XX.A02 * 4.0f);
    }

    public FullScreenAdToolbar(C1648gi c1648gi, InterfaceC1189Yh interfaceC1189Yh, VI vi, int i3, int i4, boolean z2) {
        super(c1648gi);
        this.A01 = null;
        this.A04 = true;
        this.A05 = z2;
        this.A08 = interfaceC1189Yh;
        this.A07 = vi;
        setGravity(16);
        this.A09 = new ZK(c1648gi, i3, z2);
        this.A09.setContentDescription(A02(0, 8, 24));
        this.A09.setActionClickListener(new ViewOnClickListenerC1198Yq(this));
        if (!this.A05) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A09, layoutParams);
            this.A06 = new RelativeLayout(c1648gi);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            this.A0A = new C1485e4(c1648gi);
            YB.A0G(CloseCodes.CLOSED_ABNORMALLY, this.A0A);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            this.A0A.setLayoutParams(layoutParams3);
            this.A06.addView(this.A0A);
            addView(this.A06, layoutParams2);
            if (i4 != -1) {
                A0G(c1648gi, i4);
                return;
            }
            return;
        }
        if (i4 != -1) {
            A0G(c1648gi, i4);
        }
        this.A06 = new RelativeLayout(c1648gi);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.A0A = new C1485e4(c1648gi);
        YB.A0G(CloseCodes.CLOSED_ABNORMALLY, this.A0A);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        this.A0A.setLayoutParams(layoutParams5);
        this.A06.addView(this.A0A);
        addView(this.A06, layoutParams4);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
        addView(this.A09, layoutParams6);
    }

    private void A04(View view, boolean z2) {
        if (view == null) {
            return;
        }
        view.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A08() {
        super.A08();
        if (this.A00 != null) {
            this.A00.setVisibility(8);
        }
        if (this.A03 != null) {
            this.A03.setVisibility(8);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A09() {
        this.A09.A02();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0A() {
        if (this.A01 != null) {
            this.A02 = this.A01;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0B() {
        this.A01 = getToolbarListener();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0C(float f3, int i3) {
        this.A09.A03(f3, i3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final void A0D(C0906Na c0906Na, boolean z2) {
        boolean z3 = this.A04;
        int iA05 = c0906Na.A05(z3);
        this.A0A.A02(c0906Na.A0B(z3), iA05);
        boolean z4 = this.A05;
        String strA02 = A02(8, 9, 52);
        if (!z4) {
            if (this.A00 != null) {
                this.A00.setIconColors(iA05);
                this.A00.setContentDescription(strA02);
            }
        } else if (this.A03 != null) {
            this.A03.setIconColors(iA05);
            this.A03.setContentDescription(strA02);
        }
        this.A09.A04(c0906Na, z3, z2);
        if (z3) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            YB.A0V(this, gradientDrawable);
            boolean fullScreenEnabled = this.A05;
            setReportingViewColor(!fullScreenEnabled ? this.A00 : this.A03);
            return;
        }
        YB.A0N(this, 0);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public final boolean A0E() {
        return this.A09.A05();
    }

    public final void A0F(C0918Nm c0918Nm, String str, int i3) {
        this.A09.setInitialUnskippableSeconds(i3);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(c0918Nm, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(c0918Nm, str, this.A07, this.A08);
        }
    }

    public final void A0G(C1648gi c1648gi, int i3) {
        if (this.A00 != null) {
            YB.A0J(this.A00);
            this.A00.removeAllViews();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (!this.A05) {
            this.A00 = new YZ(c1648gi, i3);
            layoutParams.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
            addView(this.A00, layoutParams);
        } else {
            this.A03 = new ZC(c1648gi);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A03, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public int getToolbarActionMode() {
        return this.A09.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public int getToolbarHeight() {
        return AbstractC1183Yb.A00;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public InterfaceC1182Ya getToolbarListener() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setAdReportingVisible(boolean z2) {
        A04(!this.A05 ? this.A00 : this.A03, z2);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setCTAClickListener(View.OnClickListener onClickListener) {
        this.A0A.setOnClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setCTAClickListener(ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr) {
        this.A0A.setOnClickListener(AbstractC1352bu.A03(viewOnClickListenerC0846Kr, A02(17, 7, 47)));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setFullscreen(boolean z2) {
        this.A04 = z2;
    }

    public void setOnlyPageDetails(C0918Nm c0918Nm) {
        if (c0918Nm != null) {
            this.A0A.setPageDetails(c0918Nm);
        } else {
            this.A0A.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setPageDetails(C0918Nm c0918Nm, String str, int i3, C0924Ns c0924Ns) {
        this.A09.setInitialUnskippableSeconds(i3);
        this.A0A.setPageDetails(c0918Nm);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(c0918Nm, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(c0918Nm, str, this.A07, this.A08);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setPageDetailsVisible(boolean z2) {
        this.A06.removeAllViews();
        if (z2) {
            this.A06.addView(this.A0A);
        }
        this.A09.setToolbarMessageEnabled(!z2);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgress(float f3) {
        this.A09.setProgress(f3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A09.setProgressClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressImage(YM ym) {
        this.A09.setProgressImage(ym);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressImmediate(float f3) {
        this.A09.setProgressImmediate(f3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setProgressSpinnerInvisible(boolean z2) {
        this.A09.setProgressSpinnerInvisible(z2);
    }

    private void setReportingViewColor(View view) {
        if (view != null) {
            YB.A0S(view, 0, -16777216, A0E);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setToolbarActionMessage(String str) {
        this.A09.setToolbarMessage(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setToolbarActionMode(int i3) {
        this.A09.setToolbarActionMode(i3);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1183Yb
    public void setToolbarListener(InterfaceC1182Ya interfaceC1182Ya) {
        this.A02 = interfaceC1182Ya;
    }
}
