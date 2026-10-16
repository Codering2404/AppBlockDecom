package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BaseProgressIndicatorSpec f81541a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class ActiveIndicator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f81542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f81543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f81544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f81545d;

        protected ActiveIndicator() {
        }
    }

    public DrawingDelegate(BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f81541a = baseProgressIndicatorSpec;
    }

    abstract void a(Canvas canvas, Rect rect, float f3, boolean z2, boolean z3);

    abstract void b(Canvas canvas, Paint paint, int i3, int i4);

    abstract void c(Canvas canvas, Paint paint, ActiveIndicator activeIndicator, int i3);

    abstract void d(Canvas canvas, Paint paint, float f3, float f4, int i3, int i4, int i5);

    abstract int e();

    abstract int f();

    void g(Canvas canvas, Rect rect, float f3, boolean z2, boolean z3) {
        this.f81541a.e();
        a(canvas, rect, f3, z2, z3);
    }
}
