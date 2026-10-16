package com.facebook.ads.redexgen.core;

import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1344bm extends LinearLayout {
    public static final int A06 = (int) (XX.A02 * 4.0f);
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final C1648gi A04;
    public final C1345bn[] A05;

    public C1344bm(C1648gi c1648gi, int i3, int i4, int i5, int i6) {
        super(c1648gi);
        this.A00 = A06;
        this.A04 = c1648gi;
        setOrientation(0);
        this.A03 = i3;
        this.A01 = i5;
        this.A02 = i6;
        this.A05 = new C1345bn[i4];
        for (int i7 = 0; i7 < i4; i7++) {
            this.A05[i7] = A00();
            addView(this.A05[i7]);
        }
        A01();
    }

    private C1345bn A00() {
        C1345bn c1345bn = new C1345bn(this.A04, this.A01, this.A02);
        LinearLayout.LayoutParams starRatingViewParams = new LinearLayout.LayoutParams(this.A03, this.A03);
        starRatingViewParams.gravity = 16;
        c1345bn.setLayoutParams(starRatingViewParams);
        return c1345bn;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A01() {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.bn[] r0 = r3.A05
            int r0 = r0.length
            if (r2 >= r0) goto L1b
            com.facebook.ads.redexgen.X.bn[] r0 = r3.A05
            r0 = r0[r2]
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
            if (r2 != 0) goto L18
            r0 = 0
        L13:
            r1.leftMargin = r0
            int r2 = r2 + 1
            goto L1
        L18:
            int r0 = r3.A00
            goto L13
        L1b:
            r3.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1344bm.A01():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02(float r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.bn[] r0 = r3.A05
            int r0 = r0.length
            if (r2 >= r0) goto L1f
            float r0 = (float) r2
            float r1 = r4 - r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = java.lang.Math.min(r0, r1)
            r0 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L15
            r1 = 0
        L15:
            com.facebook.ads.redexgen.X.bn[] r0 = r3.A05
            r0 = r0[r2]
            r0.setFillRatio(r1)
            int r2 = r2 + 1
            goto L1
        L1f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1344bm.A02(float):void");
    }

    public void setItemSpacing(int i3) {
        this.A00 = i3;
        A01();
    }

    public void setRating(float f3) {
        A02(f3);
    }
}
