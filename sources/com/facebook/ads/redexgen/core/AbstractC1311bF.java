package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.AdError;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1311bF extends LinearLayout {
    public static byte[] A0A;
    public static final LinearLayout.LayoutParams A0B;
    public LinearLayout A00;
    public TextView A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final View.OnClickListener A05;
    public final RelativeLayout A06;
    public final C1648gi A07;
    public final ViewOnClickListenerC0846Kr A08;
    public final C1342bk A09;

    public static String A0h(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0i() {
        A0A = new byte[]{-96, -93, -93, -92, -77, -96, -88, -85, -78};
    }

    public abstract void A0l(int i3);

    static {
        A0i();
        A0B = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC1311bF(C1648gi c1648gi, ViewOnClickListenerC0846Kr viewOnClickListenerC0846Kr, int i3, C0906Na c0906Na, boolean z2, String str, VA va, InterfaceC1189Yh interfaceC1189Yh, C1593fp c1593fp, Y2 y2, C0912Ng c0912Ng, boolean z3, String str2) {
        super(c1648gi);
        this.A02 = A0h(0, 0, 37);
        YB.A0K(this);
        this.A07 = c1648gi;
        this.A04 = i3;
        this.A03 = z3;
        this.A02 = str2;
        this.A09 = new C1342bk(c1648gi);
        YB.A0N(this.A09, 0);
        YB.A0K(this.A09);
        if (z3) {
            this.A00 = new LinearLayout(c1648gi);
            this.A01 = new TextView(c1648gi);
            YB.A0K(this.A01);
        }
        if (viewOnClickListenerC0846Kr == null) {
            this.A08 = new ViewOnClickListenerC0846Kr(c1648gi, str, c0906Na, z2, va, interfaceC1189Yh, c1593fp, y2, c0912Ng);
        } else {
            this.A08 = viewOnClickListenerC0846Kr;
        }
        YB.A0G(AdError.NO_FILL_ERROR_CODE, this.A08);
        this.A05 = AbstractC1352bu.A03(this.A08, A0h(0, 9, 52));
        this.A06 = new RelativeLayout(c1648gi);
        this.A06.setLayoutParams(A0B);
        YB.A0K(this.A06);
    }

    public void A0j() {
    }

    public void A0k() {
        this.A09.setOnClickListener(this.A05);
    }

    public void A0m(boolean z2) {
    }

    public final ViewOnClickListenerC0846Kr getCTAButton() {
        return this.A08;
    }

    public View getExpandableLayout() {
        return null;
    }

    public final ImageView getIconView() {
        return this.A09;
    }

    public void setInfo(NY ny, C0908Nc c0908Nc, String str, String str2, InterfaceC1163Xh interfaceC1163Xh, InterfaceC1326bU interfaceC1326bU) {
        this.A08.setCta(c0908Nc, str, new HashMap(), interfaceC1163Xh, interfaceC1326bU);
        new LM(this.A09, this.A07).A05(this.A04, this.A04).A07(str2);
    }

    public void setTitleMaxLines(int i3) {
    }
}
