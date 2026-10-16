package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.google.android.material.canvas.CanvasCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ShapeableDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f81906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f81907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ShapeAppearanceModel f81908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    RectF f81909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Path f81910e;

    private boolean c() {
        RectF rectF = this.f81909d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void j() {
        if (!c() || this.f81908c == null) {
            return;
        }
        ShapeAppearancePathProvider.k().d(this.f81908c, 1.0f, this.f81909d, this.f81910e);
    }

    abstract void a(View view);

    public boolean b() {
        return this.f81906a;
    }

    public void d(Canvas canvas, CanvasCompat.CanvasOperation canvasOperation) {
        if (!i() || this.f81910e.isEmpty()) {
            canvasOperation.a(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(this.f81910e);
        canvasOperation.a(canvas);
        canvas.restore();
    }

    public void e(View view, RectF rectF) {
        this.f81909d = rectF;
        j();
        a(view);
    }

    public void f(View view, ShapeAppearanceModel shapeAppearanceModel) {
        this.f81908c = shapeAppearanceModel;
        j();
        a(view);
    }

    public void g(View view, boolean z2) {
        if (z2 != this.f81906a) {
            this.f81906a = z2;
            a(view);
        }
    }

    public void h(View view, boolean z2) {
        this.f81907b = z2;
        a(view);
    }

    abstract boolean i();
}
