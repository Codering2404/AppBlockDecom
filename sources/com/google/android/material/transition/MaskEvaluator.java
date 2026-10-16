package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.MaterialContainerTransform;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MaskEvaluator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f82600a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f82601b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f82602c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShapeAppearancePathProvider f82603d = ShapeAppearancePathProvider.k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ShapeAppearanceModel f82604e;

    MaskEvaluator() {
    }

    void a(Canvas canvas) {
        canvas.clipPath(this.f82600a);
    }

    void b(float f3, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel shapeAppearanceModelO = TransitionUtils.o(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.d(), progressThresholds.c(), f3);
        this.f82604e = shapeAppearanceModelO;
        this.f82603d.d(shapeAppearanceModelO, 1.0f, rectF2, this.f82601b);
        this.f82603d.d(this.f82604e, 1.0f, rectF3, this.f82602c);
        this.f82600a.op(this.f82601b, this.f82602c, Path.Op.UNION);
    }

    ShapeAppearanceModel c() {
        return this.f82604e;
    }

    Path d() {
        return this.f82600a;
    }
}
