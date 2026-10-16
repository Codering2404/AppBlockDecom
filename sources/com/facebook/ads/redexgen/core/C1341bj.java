package com.facebook.ads.redexgen.core;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1341bj extends LinearLayout {
    public int A00;
    public List<GradientDrawable> A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public C1341bj(C1648gi c1648gi, C0906Na c0906Na, int i3) {
        super(c1648gi);
        this.A00 = -1;
        setOrientation(0);
        setGravity(17);
        float f3 = XX.A02;
        int i4 = (int) (8.0f * f3);
        this.A02 = (int) (1.0f * f3);
        this.A04 = c0906Na.A05(false);
        this.A03 = P3.A02(this.A04, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        this.A01 = new ArrayList();
        for (int i5 = 0; i5 < i3; i5++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i4, i4);
            gradientDrawable.setStroke(this.A02, 0);
            ImageView imageView = new ImageView(c1648gi);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, XV.A0t, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.A01.add(gradientDrawable);
            addView(imageView);
        }
        A00(0);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A00(int r6) {
        /*
            r5 = this;
            int r0 = r5.A00
            if (r0 != r6) goto L5
            return
        L5:
            r5.A00 = r6
            r4 = 0
        L8:
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            int r0 = r0.size()
            if (r4 >= r0) goto L40
            if (r4 != r6) goto L3c
            int r3 = r5.A04
            int r2 = r5.A04
        L16:
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r1 = r0.get(r4)
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r0 = r5.A02
            r1.setStroke(r0, r2)
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r0 = r0.get(r4)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r0.setColor(r3)
            java.util.List<android.graphics.drawable.GradientDrawable> r0 = r5.A01
            java.lang.Object r0 = r0.get(r4)
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            r0.invalidateSelf()
            int r4 = r4 + 1
            goto L8
        L3c:
            int r3 = r5.A03
            r2 = 0
            goto L16
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1341bj.A00(int):void");
    }
}
