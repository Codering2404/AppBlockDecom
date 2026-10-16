package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.platform.MaterialContainerTransform;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MaskEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f82721a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f82722b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f82723c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShapeAppearancePathProvider f82724d = ShapeAppearancePathProvider.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ShapeAppearanceModel f82725e;

    MaskEvaluator() {
    }

    void a(Canvas canvas) {
        canvas.clipPath(this.f82721a);
    }

    void b(float f3, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel shapeAppearanceModelP = TransitionUtils.p(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.d(), progressThresholds.c(), f3);
        this.f82725e = shapeAppearanceModelP;
        this.f82724d.d(shapeAppearanceModelP, 1.0f, rectF2, this.f82722b);
        this.f82724d.d(this.f82725e, 1.0f, rectF3, this.f82723c);
        this.f82721a.op(this.f82722b, this.f82723c, Path.Op.UNION);
    }

    ShapeAppearanceModel c() {
        return this.f82725e;
    }

    Path d() {
        return this.f82721a;
    }
}
