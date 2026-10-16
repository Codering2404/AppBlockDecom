package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1340bi extends FrameLayout {
    public static String[] A08 = {"Q8PK8a4jCXFMgXydViX", "2t", "0mtDJDWqZSrfiocTEOLDLA", "JwyFxt7bdt7eCUIm0ln", "fPboxvDBMmOISakSS", "MBnzPw5d2FxZEvBrnzM1TlMBrMh4WSuO", "jLpHRmCuYtO7UfmYbZzhe3ed5a74x24O", "3APcS373YHqcuLzV9G"};
    public AbstractC1183Yb A00;
    public Z3 A01;
    public final AbstractC1813jd A02;
    public final C1648gi A03;
    public final InterfaceC1189Yh A04;
    public final InterfaceC1339bh A05;
    public final C0685Ek A06;
    public final List<View> A07;

    public C1340bi(C1365c7 c1365c7, AbstractC1813jd abstractC1813jd, C0685Ek c0685Ek, DZ dz, AbstractC1311bF abstractC1311bF, InterfaceC1189Yh interfaceC1189Yh, InterfaceC1339bh interfaceC1339bh) {
        this(c1365c7, abstractC1813jd, c0685Ek, interfaceC1189Yh, interfaceC1339bh, dz, abstractC1311bF);
    }

    public C1340bi(C1365c7 c1365c7, AbstractC1813jd abstractC1813jd, C0685Ek c0685Ek, InterfaceC1189Yh interfaceC1189Yh, InterfaceC1339bh interfaceC1339bh, View... viewArr) {
        this(c1365c7.A06(), c1365c7.A0B(), abstractC1813jd, c0685Ek, interfaceC1189Yh, interfaceC1339bh, viewArr);
    }

    public C1340bi(C1648gi c1648gi, AbstractC1183Yb abstractC1183Yb, AbstractC1813jd abstractC1813jd, C0685Ek c0685Ek, InterfaceC1189Yh interfaceC1189Yh, InterfaceC1339bh interfaceC1339bh, View... viewArr) {
        super(c1648gi);
        this.A07 = new ArrayList();
        this.A03 = c1648gi;
        this.A00 = abstractC1183Yb;
        this.A02 = abstractC1813jd;
        for (View view : viewArr) {
            if (view != null) {
                this.A07.add(view);
            }
        }
        this.A04 = interfaceC1189Yh;
        this.A06 = c0685Ek;
        this.A05 = interfaceC1339bh;
        A04();
    }

    private void A04() {
        String strA06;
        RewardData rewardDataA0s = this.A02.A0s();
        if (rewardDataA0s == null) {
            strA06 = this.A02.A2B().A05();
        } else {
            strA06 = this.A02.A2B().A06(rewardDataA0s.getCurrency(), rewardDataA0s.getQuantity());
        }
        this.A01 = new Z3(this.A03, -1, -16777216, strA06, null, this.A02.A2B().A04(), this.A02.A2B().A03(), YN.A01(YM.REWARD_ICON));
        this.A01.A02.setOnClickListener(new ViewOnClickListenerC1337bf(this));
        this.A01.A01.setOnClickListener(new ViewOnClickListenerC1338bg(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.A01, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A06 != null) {
            this.A06.A0d(EnumC1527el.A07);
        }
        this.A05.ACt();
        if (!this.A02.A29().A0V()) {
            this.A02.A2H(this.A04);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0024 A[EDGE_INSN: B:23:0x0024->B:8:0x0024 BREAK  A[LOOP:0: B:15:0x004d->B:20:0x0074], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(android.view.ViewGroup r8) {
        /*
            r7 = this;
            com.facebook.ads.redexgen.X.Ek r0 = r7.A06
            r3 = 4
            if (r0 == 0) goto L3e
            com.facebook.ads.redexgen.X.Ek r0 = r7.A06
            boolean r0 = r0.A0o()
            if (r0 != 0) goto L3e
            com.facebook.ads.redexgen.X.Ek r6 = r7.A06
            r5 = 11
            r4 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1340bi.A08
            r0 = 0
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L2a
        L24:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1340bi.A08
            java.lang.String r1 = "1Ran1dt8ESvXQPCOL"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "wn"
            r0 = 1
            r2[r0] = r1
            r6.A0j(r4, r4, r5)
            com.facebook.ads.redexgen.X.Ek r0 = r7.A06
            com.facebook.ads.redexgen.core.YB.A0O(r0, r3)
        L3e:
            com.facebook.ads.redexgen.X.Yb r0 = r7.A00
            if (r0 == 0) goto L47
            com.facebook.ads.redexgen.X.Yb r0 = r7.A00
            com.facebook.ads.redexgen.core.YB.A0H(r0)
        L47:
            java.util.List<android.view.View> r0 = r7.A07
            java.util.Iterator r5 = r0.iterator()
        L4d:
            boolean r4 = r5.hasNext()
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1340bi.A08
            r0 = 5
            r1 = r2[r0]
            r0 = 6
            r2 = r2[r0]
            r0 = 31
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L66
            goto L24
        L66:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C1340bi.A08
            java.lang.String r1 = "6LHnkwVNW3v3BurcJpp"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "pBsoAnuzgJgS4JAM4BB"
            r0 = 3
            r2[r0] = r1
            if (r4 == 0) goto L81
            java.lang.Object r0 = r5.next()
            android.view.View r0 = (android.view.View) r0
            r0.clearAnimation()
            com.facebook.ads.redexgen.core.YB.A0O(r0, r3)
            goto L4d
        L81:
            r1 = -1
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r1, r1)
            r8.addView(r7, r0)
            com.facebook.ads.redexgen.X.bh r0 = r7.A05
            r0.AEn()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1340bi.A07(android.view.ViewGroup):void");
    }
}
