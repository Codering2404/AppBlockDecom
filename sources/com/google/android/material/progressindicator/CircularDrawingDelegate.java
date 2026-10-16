package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f81494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f81495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f81496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f81497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f81498f;

    CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void h(Canvas canvas, Paint paint, float f3, float f4, int i3, int i4, int i5) {
        float f5 = f4 >= f3 ? f4 - f3 : (f4 + 1.0f) - f3;
        float f6 = f3 % 1.0f;
        if (this.f81498f < 1.0f) {
            float f7 = f6 + f5;
            if (f7 > 1.0f) {
                h(canvas, paint, f6, 1.0f, i3, i4, 0);
                h(canvas, paint, 1.0f, f7, i3, 0, i5);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f81495c / this.f81496d);
        if (f6 == 0.0f && f5 >= 0.99f) {
            f5 += ((f5 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / 0.01f;
        }
        float fD = MathUtils.d(1.0f - this.f81498f, 1.0f, f6);
        float fD2 = MathUtils.d(0.0f, this.f81498f, f5);
        float degrees2 = (float) Math.toDegrees(i4 / this.f81496d);
        float degrees3 = ((fD2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i5 / this.f81496d));
        float f8 = (fD * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setStrokeWidth(this.f81494b);
        float f9 = degrees * 2.0f;
        if (degrees3 < f9) {
            float f10 = degrees3 / f9;
            paint.setStyle(Paint.Style.FILL);
            j(canvas, paint, f8 + (degrees * f10), this.f81495c * 2.0f, this.f81494b, f10);
            return;
        }
        float f11 = this.f81496d;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.f81497e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f12 = f8 + degrees;
        canvas.drawArc(rectF, f12, degrees3 - f9, false, paint);
        if (this.f81497e || this.f81495c <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        i(canvas, paint, f12, this.f81495c * 2.0f, this.f81494b);
        i(canvas, paint, (f8 + degrees3) - degrees, this.f81495c * 2.0f, this.f81494b);
    }

    private void i(Canvas canvas, Paint paint, float f3, float f4, float f5) {
        j(canvas, paint, f3, f4, f5, 1.0f);
    }

    private void j(Canvas canvas, Paint paint, float f3, float f4, float f5, float f6) {
        float fMin = (int) Math.min(f5, this.f81494b);
        float f7 = f4 / 2.0f;
        float fMin2 = Math.min(f7, (this.f81495c * fMin) / this.f81494b);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f4) / 2.0f, fMin / 2.0f, f7);
        canvas.save();
        double d3 = f3;
        canvas.translate((float) (((double) this.f81496d) * Math.cos(Math.toRadians(d3))), (float) (((double) this.f81496d) * Math.sin(Math.toRadians(d3))));
        canvas.rotate(f3);
        canvas.scale(f6, f6);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    private int k() {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81541a;
        return ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81515h + (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81516i * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void a(Canvas canvas, Rect rect, float f3, boolean z2, boolean z3) {
        float fWidth = rect.width() / f();
        float fHeight = rect.height() / e();
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81541a;
        float f4 = (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81515h / 2.0f) + ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f81516i;
        canvas.translate((f4 * fWidth) + rect.left, (f4 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((CircularProgressIndicatorSpec) this.f81541a).f81517j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f5 = -f4;
        canvas.clipRect(f5, f5, f4, f4);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec2 = this.f81541a;
        this.f81497e = ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).f81487a / 2 <= ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).f81488b;
        this.f81494b = ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).f81487a * f3;
        this.f81495c = Math.min(((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).f81487a / 2, ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec2).f81488b) * f3;
        BaseProgressIndicatorSpec baseProgressIndicatorSpec3 = this.f81541a;
        float f6 = (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81515h - ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81487a) / 2.0f;
        this.f81496d = f6;
        if (z2 || z3) {
            if ((z2 && ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81491e == 2) || (z3 && ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81492f == 1)) {
                this.f81496d = f6 + (((1.0f - f3) * ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81487a) / 2.0f);
            } else if ((z2 && ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81491e == 1) || (z3 && ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81492f == 2)) {
                this.f81496d = f6 - (((1.0f - f3) * ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81487a) / 2.0f);
            }
        }
        if (z3 && ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec3).f81492f == 3) {
            this.f81498f = f3;
        } else {
            this.f81498f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void c(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i3) {
        int iA = MaterialColors.a(activeIndicator.f81544c, i3);
        float f3 = activeIndicator.f81542a;
        float f4 = activeIndicator.f81543b;
        int i4 = activeIndicator.f81545d;
        h(canvas, paint, f3, f4, iA, i4, i4);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void d(Canvas canvas, Paint paint, float f3, float f4, int i3, int i4, int i5) {
        h(canvas, paint, f3, f4, MaterialColors.a(i3, i4), i5, i5);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int e() {
        return k();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int f() {
        return k();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void b(Canvas canvas, Paint paint, int i3, int i4) {
    }
}
