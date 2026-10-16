package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.transition.PathMotion;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialArcMotion extends PathMotion {
    private static PointF b(float f3, float f4, float f5, float f6) {
        return f4 > f6 ? new PointF(f5, f4) : new PointF(f3, f6);
    }

    @Override // androidx.transition.PathMotion
    public Path a(float f3, float f4, float f5, float f6) {
        Path path = new Path();
        path.moveTo(f3, f4);
        PointF pointFB = b(f3, f4, f5, f6);
        path.quadTo(pointFB.x, pointFB.y, f5, f6);
        return path;
    }
}
