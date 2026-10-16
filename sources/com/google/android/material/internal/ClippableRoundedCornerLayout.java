package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ClippableRoundedCornerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Path f81134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f81135b;

    public ClippableRoundedCornerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        this.f81134a = null;
        this.f81135b = 0.0f;
        invalidate();
    }

    public void b(float f3, float f4, float f5, float f6, float f7) {
        d(new RectF(f3, f4, f5, f6), f7);
    }

    public void c(Rect rect, float f3) {
        b(rect.left, rect.top, rect.right, rect.bottom, f3);
    }

    public void d(RectF rectF, float f3) {
        if (this.f81134a == null) {
            this.f81134a = new Path();
        }
        this.f81135b = f3;
        this.f81134a.reset();
        this.f81134a.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        this.f81134a.close();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f81134a == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.f81134a);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public void e(float f3) {
        b(getLeft(), getTop(), getRight(), getBottom(), f3);
    }

    public float getCornerRadius() {
        return this.f81135b;
    }
}
