package com.facebook.ads.redexgen.core;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1329bX extends View {
    public static byte[] A0E;
    public static String[] A0F = {"6CPTD", "fXgP9xh", "ib2e4in6DthWL0Q8yAPc5xfntbPyX", "G2AJONpeKHBBwjt4Sz8dsS7zReejT0Uv", "ehyeN", "WBwJl6", "LCSmLTdRFMhZrs9WeNkLEUS62n49AyUU", "TtqxlXaAwuHndX0DwnqxXM3nrIfVxGxz"};
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public float A00;
    public int A01;
    public int A02;
    public ObjectAnimator A03;
    public Bitmap A04;
    public boolean A05;
    public final float A06;
    public final float A07;
    public final Paint A08;
    public final Paint A09;
    public final Paint A0A;
    public final Paint A0B;
    public final RectF A0C;
    public final RectF A0D;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i3, i3 + i4);
        int i6 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0F;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0F[2] = "SahMn6yRzkp23Kmva3Z5gQPUDBgZr";
            if (i6 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 123);
            i6++;
        }
    }

    public static void A01() {
        A0E = new byte[]{96, 98, Ascii.DEL, 119, 98, 117, 99, 99};
    }

    static {
        A01();
        A0G = (int) (XX.A02 * 5.0f);
        A0H = (int) (XX.A02 * 4.0f);
        A0I = (int) (XX.A02 * 10.0f);
    }

    public C1329bX(C1648gi c1648gi, boolean z2) {
        super(c1648gi);
        this.A07 = Resources.getSystem().getDisplayMetrics().density * 3.0f;
        this.A06 = Resources.getSystem().getDisplayMetrics().density * 2.0f;
        this.A00 = 0.0f;
        this.A03 = null;
        this.A02 = -1;
        this.A05 = z2;
        this.A0C = new RectF();
        this.A0D = new RectF();
        this.A08 = new Paint(1);
        this.A08.setStyle(Paint.Style.STROKE);
        this.A08.setStrokeWidth(!this.A05 ? this.A07 : this.A06);
        this.A09 = new Paint(1);
        this.A09.setStyle(Paint.Style.STROKE);
        this.A09.setStrokeWidth(!this.A05 ? this.A07 : this.A06);
        this.A0A = new Paint(1);
        this.A0B = new Paint();
        this.A0B.setAntiAlias(true);
        this.A0B.setColor(-1);
        this.A0B.setTextSize(A0I);
        this.A01 = !this.A05 ? A0G : A0H;
    }

    public final void A02(float f3, int i3) {
        this.A02 = i3;
        setProgressWithAnimation(f3);
    }

    public final void A03(int i3, int i4, int i5, boolean z2) {
        this.A08.setColor(i3);
        this.A09.setColor(i4);
        if (z2) {
            this.A0A.setColorFilter(new PorterDuffColorFilter(P3.A02(i4, i5), PorterDuff.Mode.SRC_ATOP));
        }
    }

    @Override // android.view.View
    public final void clearAnimation() {
        if (this.A03 != null) {
            this.A03.cancel();
            this.A03 = null;
        }
    }

    public float getProgress() {
        return this.A00;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.A0C, 0.0f, 360.0f, false, this.A08);
        canvas.drawArc(this.A0C, -90.0f, ((100.0f - this.A00) * 360.0f) / 100.0f, false, this.A09);
        if (this.A04 != null) {
            canvas.drawBitmap(this.A04, new Rect(0, 0, this.A04.getWidth(), this.A04.getHeight()), this.A0D, this.A0A);
        }
        if (this.A02 >= 0) {
            String str = this.A02 + A00(0, 0, 8);
            float f3 = this.A0C.left;
            float f4 = this.A0C.right;
            float sweepAngle = this.A0C.left;
            float f5 = f3 + ((f4 - sweepAngle) / 2.0f);
            float sweepAngle2 = this.A0B.measureText(str);
            float f6 = f5 - (sweepAngle2 / 2.0f);
            float f7 = this.A0C.top;
            float sweepAngle3 = A0H;
            float f8 = f7 + sweepAngle3;
            float f9 = this.A0C.bottom;
            float sweepAngle4 = this.A0C.top;
            canvas.drawText(str, f6, f8 + ((f9 - sweepAngle4) / 2.0f), this.A0B);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i4) {
        int iMin = Math.min(getDefaultSize(getSuggestedMinimumHeight(), i4), getDefaultSize(getSuggestedMinimumWidth(), i3));
        setMeasuredDimension(iMin, iMin);
        float f3 = !this.A05 ? this.A07 : this.A06;
        RectF rectF = this.A0C;
        int min = getPaddingLeft();
        float f4 = (f3 / 2.0f) + 0.0f + min;
        int min2 = getPaddingTop();
        float f5 = (f3 / 2.0f) + 0.0f + min2;
        int min3 = getPaddingRight();
        float f6 = (iMin - (f3 / 2.0f)) - min3;
        float strokeWidth = iMin;
        int min4 = getPaddingBottom();
        rectF.set(f4, f5, f6, (strokeWidth - (f3 / 2.0f)) - min4);
        int i5 = this.A01;
        RectF rectF2 = this.A0D;
        float f7 = this.A0C.left + i5;
        float f8 = this.A0C.top + i5;
        float f9 = this.A0C.right - i5;
        float strokeWidth2 = this.A0C.bottom;
        rectF2.set(f7, f8, f9, strokeWidth2 - i5);
    }

    public void setImage(YM ym) {
        this.A04 = ym == null ? null : YN.A01(ym);
        invalidate();
    }

    public void setImagePadding(int i3) {
        this.A01 = i3;
        invalidate();
    }

    public void setProgress(float f3) {
        this.A00 = Math.min(f3, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f3) {
        this.A03 = ObjectAnimator.ofFloat(this, A00(0, 8, 107), f3);
        this.A03.setDuration(400L);
        this.A03.setInterpolator(new LinearInterpolator());
        this.A03.start();
    }
}
