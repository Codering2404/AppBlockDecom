package com.facebook.ads.redexgen.core;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1197Yp extends View {
    public int A00;
    public Paint A01;
    public Paint A02;
    public Paint A03;
    public boolean A04;

    public C1197Yp(C1648gi c1648gi) {
        this(c1648gi, 60, true);
    }

    public C1197Yp(C1648gi c1648gi, int i3, boolean z2) {
        super(c1648gi);
        this.A00 = i3;
        this.A04 = z2;
        if (z2) {
            this.A02 = new Paint();
            this.A02.setColor(-3355444);
            this.A02.setStyle(Paint.Style.STROKE);
            this.A02.setStrokeWidth(3.0f);
            this.A02.setAntiAlias(true);
            this.A01 = new Paint();
            this.A01.setColor(-1287371708);
            this.A01.setStyle(Paint.Style.FILL);
            this.A01.setAntiAlias(true);
            this.A03 = new Paint();
            this.A03.setColor(-1);
            this.A03.setStyle(Paint.Style.STROKE);
            this.A03.setStrokeWidth(6.0f);
            this.A03.setAntiAlias(true);
        }
    }

    public RelativeLayout.LayoutParams getDefaultLayoutParams() {
        float f3 = XX.A02;
        float density = this.A00;
        int i3 = (int) (density * f3);
        float density2 = this.A00;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, (int) (density2 * f3));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A04) {
            canvas.isHardwareAccelerated();
            int iMin = Math.min(canvas.getWidth(), canvas.getHeight());
            int i3 = iMin / 2;
            int i4 = iMin / 2;
            int edgeLength = i3 * 2;
            int i5 = edgeLength / 3;
            canvas.drawCircle(i3, i4, i5, this.A02);
            int edgeLength2 = i5 - 2;
            canvas.drawCircle(i3, i4, edgeLength2, this.A01);
            int centerY = iMin / 3;
            int centerX = iMin / 3;
            int edgeLength3 = centerY * 2;
            float f3 = edgeLength3;
            int edgeLength4 = centerX * 2;
            canvas.drawLine(centerY, centerX, f3, edgeLength4, this.A03);
            int edgeLength5 = centerY * 2;
            int edgeLength6 = centerX * 2;
            canvas.drawLine(edgeLength5, centerX, centerY, edgeLength6, this.A03);
        }
        super.onDraw(canvas);
    }
}
