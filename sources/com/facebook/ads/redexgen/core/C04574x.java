package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4x, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C04574x extends AbstractC0735Gj {
    public static byte[] A07;
    public static String[] A08 = {"opNTFb7MfNeLnBf1OFt8H8u3IMVbRu1d", "IWQCWQwp5ID5RPcOdaIzYqbwlbVDrClG", "KvkPuVSJhScWrt17epNc", "F0ODCmRg5uMMagWpVfR8fmvJ1OUGt5pq", "F5r", "wG3QjEZJL94bFBL8PiZK", "A8E1xGSXICDDUeWE8x490gS0hcqgXwJC", "2T9PYA9x4VF1QbksNYikemvLXt0jGXOu"};
    public AbstractC1361c3 A00;
    public DZ A01;
    public final ImageView A02;
    public final InterfaceC1016Rk A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;
    public final AtomicBoolean A06;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-17, -25, -27, -20};
    }

    static {
        A07();
    }

    public C04574x(C1648gi c1648gi, ZU zu, VA va, AbstractC1813jd abstractC1813jd, C1054Sx c1054Sx, InterfaceC1189Yh interfaceC1189Yh) {
        super(c1648gi, zu, va, abstractC1813jd, c1054Sx, interfaceC1189Yh);
        this.A03 = new C0728Gc(this);
        this.A05 = new AtomicBoolean(false);
        this.A04 = new AtomicBoolean(false);
        this.A06 = new AtomicBoolean(false);
        this.A02 = new ImageView(getContext());
        if (abstractC1813jd.A29().A0H().A04() > 0) {
            this.A01 = new DZ(c1648gi, abstractC1813jd.A29().A0H().A04() * 1000);
        }
        this.A02.setScaleType(ImageView.ScaleType.CENTER);
        this.A02.setAdjustViewBounds(true);
        new LM(this.A02, super.A05).A05(super.A03.A29().A0H().A00(), super.A03.A29().A0H().A01()).A06(new C0727Gb(this)).A07(super.A03.A29().A0H().A08());
    }

    private AbstractC1361c3 A01(int i3) {
        if (this.A02.getParent() != null) {
            YB.A0J(this.A02);
        }
        C1364c6 c1364c6A0M = new C1364c6(super.A05, super.A06, this.A0A, super.A03, this.A02, this.A0C, this.A08).A0J(this.A09.getToolbarHeight()).A0P(this.A09).A0I(i3).A0M(this.A07);
        if (this.A01 != null) {
            c1364c6A0M.A0R(this.A01);
        }
        c1364c6A0M.A0L(C0901Mu.A00(super.A05, super.A06, A03(0, 0, 52), XB.A00(super.A03.A29().A0J().A05()), new HashMap(), super.A03.A2A()));
        C1365c7 params = c1364c6A0M.A0U();
        return AbstractC1362c4.A00(params, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A05.get() && this.A04.get()) {
            A0e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A08(int r8) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C04574x.A08(int):void");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj
    public final AbstractC1183Yb A0c() {
        AbstractC1183Yb abstractC1183YbA0c = super.A0c();
        if (super.A03.A2T()) {
            abstractC1183YbA0c.setOnClickListener(new ViewOnClickListenerC1469dn(this));
        }
        return abstractC1183YbA0c;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj
    public final void A0g() {
        if (this.A00 != null) {
            this.A07.A04(VH.A0Y, null);
            EnumC0897Mq enumC0897MqA1B = this.A00.A1B(A03(0, 4, 63));
            if (super.A03.A2N()) {
                return;
            }
            EnumC0897Mq actionOutcome = EnumC0897Mq.A09;
            if (enumC0897MqA1B != actionOutcome) {
                EnumC0897Mq actionOutcome2 = EnumC0897Mq.A06;
                if (enumC0897MqA1B != actionOutcome2) {
                    A0f();
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj
    public final void A0h() {
        YB.A0L(this.A00);
        YB.A0L(this.A09);
        this.A04.set(true);
        A06();
        int iA04 = super.A03.A29().A0H().A04();
        int secondsForNextCta = super.A03.A29().A0H().A02();
        if (iA04 > 0) {
            if (this.A00 != null) {
                this.A00.A1G();
            }
            A0i(iA04, new C0726Ga(this), this.A01);
            if (secondsForNextCta == 0 || secondsForNextCta >= iA04) {
                super.A02 = true;
                this.A09.setToolbarActionMode(8);
                return;
            } else {
                if (secondsForNextCta <= 0) {
                    return;
                }
                this.A09.setProgressSpinnerInvisible(true);
                A0i(secondsForNextCta, new GZ(this), null);
                return;
            }
        }
        this.A06.set(true);
        AbstractC1183Yb abstractC1183Yb = this.A09;
        int unskippableSeconds = getCloseButtonStyle();
        abstractC1183Yb.setToolbarActionMode(unskippableSeconds);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj
    public final void A0k(C1010Re c1010Re) {
        FrameLayout.LayoutParams layoutParams;
        c1010Re.A0A(this.A03);
        int orientation = c1010Re.A05().getResources().getConfiguration().orientation;
        A08(orientation);
        if (A0m()) {
            YB.A0J(this.A09);
        }
        if (A0m()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            Rect requestedMargins = this.A09.getRequestedMargins();
            if (requestedMargins == null) {
                layoutParams.setMargins(0, XV.A0r, 0, 0);
            } else {
                int i3 = requestedMargins.left;
                int i4 = requestedMargins.top;
                int i5 = requestedMargins.right;
                int i6 = requestedMargins.bottom;
                if (A08[4].length() != 3) {
                    throw new RuntimeException();
                }
                A08[0] = "j24x2xTHwZJixq019qlFmxSWfXtsmamW";
                layoutParams.setMargins(i3, i4, i5, i6);
            }
        } else {
            int orientation2 = this.A09.getToolbarHeight();
            layoutParams = new FrameLayout.LayoutParams(-1, orientation2);
        }
        addView(this.A09, layoutParams);
        YB.A0H(this.A00);
        YB.A0H(this.A09);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj
    public final boolean A0l() {
        if (this.A00 == null) {
            return false;
        }
        AbstractC1361c3 abstractC1361c3 = this.A00;
        if (A08[4].length() != 3) {
            throw new RuntimeException();
        }
        A08[4] = "kMg";
        return abstractC1361c3.A1P(false);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj
    public final boolean A0m() {
        return super.A03.A1j() || super.A03.A1y();
    }

    public final /* synthetic */ void A0n() {
        A0f();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFA(boolean z2) {
        if (this.A00 != null) {
            this.A00.A1L(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void AFi(boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        if (this.A00 != null) {
            return this.A00.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A03.A29().A0T() && !A0m()) {
            A08(configuration.orientation);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0735Gj, com.facebook.ads.redexgen.core.InterfaceC1190Yi
    public final void onDestroy() {
        if (C1098Up.A1z(super.A05)) {
            super.A05.A0B().AKU(this.A02);
        }
        if (this.A00 != null) {
            AbstractC1361c3 abstractC1361c3 = this.A00;
            String[] strArr = A08;
            if (strArr[6].charAt(10) != strArr[1].charAt(10)) {
                throw new RuntimeException();
            }
            A08[4] = "hIQ";
            abstractC1361c3.A1C();
        }
        super.onDestroy();
    }
}
