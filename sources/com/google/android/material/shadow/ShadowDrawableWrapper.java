package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class ShadowDrawableWrapper extends DrawableWrapperCompat {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final double f81728q = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Paint f81729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Paint f81730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RectF f81731d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f81732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Path f81733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f81734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f81735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f81736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f81737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f81738l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f81739m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f81740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f81741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f81742p;

    private void c(Rect rect) {
        float f3 = this.f81734h;
        float f4 = 1.5f * f3;
        this.f81731d.set(rect.left + f3, rect.top + f4, rect.right - f3, rect.bottom - f4);
        Drawable drawableA = a();
        RectF rectF = this.f81731d;
        drawableA.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        d();
    }

    private void d() {
        float f3 = this.f81732f;
        RectF rectF = new RectF(-f3, -f3, f3, f3);
        RectF rectF2 = new RectF(rectF);
        float f4 = this.f81735i;
        rectF2.inset(-f4, -f4);
        Path path = this.f81733g;
        if (path == null) {
            this.f81733g = new Path();
        } else {
            path.reset();
        }
        this.f81733g.setFillType(Path.FillType.EVEN_ODD);
        this.f81733g.moveTo(-this.f81732f, 0.0f);
        this.f81733g.rLineTo(-this.f81735i, 0.0f);
        this.f81733g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f81733g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f81733g.close();
        float f5 = -rectF2.top;
        if (f5 > 0.0f) {
            float f6 = this.f81732f / f5;
            this.f81729b.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{0, this.f81738l, this.f81739m, this.f81740n}, new float[]{0.0f, f6, ((1.0f - f6) / 2.0f) + f6, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f81730c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f81738l, this.f81739m, this.f81740n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f81730c.setAntiAlias(false);
    }

    public static float e(float f3, float f4, boolean z2) {
        return z2 ? (float) (((double) f3) + ((1.0d - f81728q) * ((double) f4))) : f3;
    }

    public static float f(float f3, float f4, boolean z2) {
        return z2 ? (float) (((double) (f3 * 1.5f)) + ((1.0d - f81728q) * ((double) f4))) : f3 * 1.5f;
    }

    private void g(Canvas canvas) {
        float f3;
        int i3;
        int iSave = canvas.save();
        canvas.rotate(this.f81742p, this.f81731d.centerX(), this.f81731d.centerY());
        float f4 = this.f81732f;
        float f5 = (-f4) - this.f81735i;
        float f6 = f4 * 2.0f;
        boolean z2 = this.f81731d.width() - f6 > 0.0f;
        boolean z3 = this.f81731d.height() - f6 > 0.0f;
        float f7 = this.f81736j;
        float f8 = f4 / ((f7 - (0.5f * f7)) + f4);
        float f9 = f4 / ((f7 - (0.25f * f7)) + f4);
        float f10 = f4 / ((f7 - (f7 * 1.0f)) + f4);
        int iSave2 = canvas.save();
        RectF rectF = this.f81731d;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.scale(f8, f9);
        canvas.drawPath(this.f81733g, this.f81729b);
        if (z2) {
            canvas.scale(1.0f / f8, 1.0f);
            f3 = 1.0f;
            i3 = iSave2;
            canvas.drawRect(0.0f, f5, this.f81731d.width() - f6, -this.f81732f, this.f81730c);
        } else {
            f3 = 1.0f;
            i3 = iSave2;
        }
        canvas.restoreToCount(i3);
        int iSave3 = canvas.save();
        RectF rectF2 = this.f81731d;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.scale(f8, f10);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f81733g, this.f81729b);
        if (z2) {
            canvas.scale(f3 / f8, f3);
            canvas.drawRect(0.0f, f5, this.f81731d.width() - f6, this.f81735i + (-this.f81732f), this.f81730c);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF3 = this.f81731d;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.scale(f8, f10);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f81733g, this.f81729b);
        if (z3) {
            canvas.scale(1.0f / f10, 1.0f);
            canvas.drawRect(0.0f, f5, this.f81731d.height() - f6, -this.f81732f, this.f81730c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        RectF rectF4 = this.f81731d;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.scale(f8, f9);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f81733g, this.f81729b);
        if (z3) {
            canvas.scale(1.0f / f9, 1.0f);
            canvas.drawRect(0.0f, f5, this.f81731d.height() - f6, -this.f81732f, this.f81730c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(iSave);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f81737k) {
            c(getBounds());
            this.f81737k = false;
        }
        g(canvas);
        super.draw(canvas);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(f(this.f81734h, this.f81732f, this.f81741o));
        int iCeil2 = (int) Math.ceil(e(this.f81734h, this.f81732f, this.f81741o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f81737k = true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        super.setAlpha(i3);
        this.f81729b.setAlpha(i3);
        this.f81730c.setAlpha(i3);
    }
}
