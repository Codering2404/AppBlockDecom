package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f81551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f81552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f81553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f81554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f81555f;

    private void h(Canvas canvas, Paint paint, float f3, float f4, int i3, int i4, int i5) {
        float f5;
        float fA = MathUtils.a(f3, 0.0f, 1.0f);
        float fA2 = MathUtils.a(f4, 0.0f, 1.0f);
        float fD = com.google.android.material.math.MathUtils.d(1.0f - this.f81555f, 1.0f, fA);
        float fD2 = com.google.android.material.math.MathUtils.d(1.0f - this.f81555f, 1.0f, fA2);
        int iA = (int) ((i4 * MathUtils.a(fD, 0.0f, 0.01f)) / 0.01f);
        int iA2 = (int) ((i5 * (1.0f - MathUtils.a(fD2, 0.99f, 1.0f))) / 0.01f);
        float f6 = this.f81551b;
        int i6 = (int) ((fD * f6) + iA);
        int i7 = (int) ((fD2 * f6) - iA2);
        float f7 = (-f6) / 2.0f;
        if (i6 <= i7) {
            float f8 = this.f81553d;
            float f9 = i6 + f8;
            float f10 = i7 - f8;
            float f11 = f8 * 2.0f;
            paint.setColor(i3);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f81552c);
            if (f9 >= f10) {
                j(canvas, paint, new PointF(f9 + f7, 0.0f), new PointF(f10 + f7, 0.0f), f11, this.f81552c);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.f81554e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f12 = f9 + f7;
            float f13 = f10 + f7;
            canvas.drawLine(f12, 0.0f, f13, 0.0f, paint);
            if (this.f81554e || this.f81553d <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f9 > 0.0f) {
                f5 = f11;
                i(canvas, paint, new PointF(f12, 0.0f), f5, this.f81552c);
            } else {
                f5 = f11;
            }
            if (f10 < this.f81551b) {
                i(canvas, paint, new PointF(f13, 0.0f), f5, this.f81552c);
            }
        }
    }

    private void i(Canvas canvas, Paint paint, PointF pointF, float f3, float f4) {
        j(canvas, paint, pointF, null, f3, f4);
    }

    private void j(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f3, float f4) {
        float fMin = Math.min(f4, this.f81552c);
        float f5 = f3 / 2.0f;
        float fMin2 = Math.min(f5, (this.f81553d * fMin) / this.f81552c);
        RectF rectF = new RectF((-f3) / 2.0f, (-fMin) / 2.0f, f5, fMin / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void a(Canvas canvas, Rect rect, float f3, boolean z2, boolean z3) {
        this.f81551b = rect.width();
        float f4 = ((LinearProgressIndicatorSpec) this.f81541a).f81487a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - f4) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f81541a).f81580j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f5 = this.f81551b / 2.0f;
        float f6 = f4 / 2.0f;
        canvas.clipRect(-f5, -f6, f5, f6);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81541a;
        this.f81554e = ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81487a / 2 == ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81488b;
        this.f81552c = ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81487a * f3;
        this.f81553d = Math.min(((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81487a / 2, ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81488b) * f3;
        if (z2 || z3) {
            if ((z2 && ((LinearProgressIndicatorSpec) this.f81541a).f81491e == 2) || (z3 && ((LinearProgressIndicatorSpec) this.f81541a).f81492f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z2 || (z3 && ((LinearProgressIndicatorSpec) this.f81541a).f81492f != 3)) {
                canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f81541a).f81487a * (1.0f - f3)) / 2.0f);
            }
        }
        if (z3 && ((LinearProgressIndicatorSpec) this.f81541a).f81492f == 3) {
            this.f81555f = f3;
        } else {
            this.f81555f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void b(Canvas canvas, Paint paint, int i3, int i4) {
        int iA = MaterialColors.a(i3, i4);
        if (((LinearProgressIndicatorSpec) this.f81541a).f81581k <= 0 || iA == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iA);
        PointF pointF = new PointF((this.f81551b / 2.0f) - (this.f81552c / 2.0f), 0.0f);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81541a;
        i(canvas, paint, pointF, ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81581k, ((LinearProgressIndicatorSpec) baseProgressIndicatorSpec).f81581k);
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
        return ((LinearProgressIndicatorSpec) this.f81541a).f81487a;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    int f() {
        return -1;
    }
}
