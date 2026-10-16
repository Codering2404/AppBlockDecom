package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ShapeAppearancePathProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ShapePath[] f81846a = new ShapePath[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f81847b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f81848c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f81849d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f81850e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f81851f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ShapePath f81852g = new ShapePath();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f81853h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f81854i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f81855j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f81856k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f81857l = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Lazy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ShapeAppearancePathProvider f81858a = new ShapeAppearancePathProvider();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PathListener {
        void a(ShapePath shapePath, Matrix matrix, int i3);

        void b(ShapePath shapePath, Matrix matrix, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ShapeAppearancePathSpec {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ShapeAppearanceModel f81859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f81860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f81861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final PathListener f81862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f81863e;

        ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel, float f3, RectF rectF, PathListener pathListener, Path path) {
            this.f81862d = pathListener;
            this.f81859a = shapeAppearanceModel;
            this.f81863e = f3;
            this.f81861c = rectF;
            this.f81860b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f81846a[i3] = new ShapePath();
            this.f81847b[i3] = new Matrix();
            this.f81848c[i3] = new Matrix();
        }
    }

    private float a(int i3) {
        return ((i3 + 1) % 4) * 90;
    }

    private void b(ShapeAppearancePathSpec shapeAppearancePathSpec, int i3) {
        this.f81853h[0] = this.f81846a[i3].k();
        this.f81853h[1] = this.f81846a[i3].l();
        this.f81847b[i3].mapPoints(this.f81853h);
        if (i3 == 0) {
            Path path = shapeAppearancePathSpec.f81860b;
            float[] fArr = this.f81853h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.f81860b;
            float[] fArr2 = this.f81853h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f81846a[i3].d(this.f81847b[i3], shapeAppearancePathSpec.f81860b);
        PathListener pathListener = shapeAppearancePathSpec.f81862d;
        if (pathListener != null) {
            pathListener.a(this.f81846a[i3], this.f81847b[i3], i3);
        }
    }

    private void c(ShapeAppearancePathSpec shapeAppearancePathSpec, int i3) {
        int i4 = (i3 + 1) % 4;
        this.f81853h[0] = this.f81846a[i3].i();
        this.f81853h[1] = this.f81846a[i3].j();
        this.f81847b[i3].mapPoints(this.f81853h);
        this.f81854i[0] = this.f81846a[i4].k();
        this.f81854i[1] = this.f81846a[i4].l();
        this.f81847b[i4].mapPoints(this.f81854i);
        float f3 = this.f81853h[0];
        float[] fArr = this.f81854i;
        float fMax = Math.max(((float) Math.hypot(f3 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fI = i(shapeAppearancePathSpec.f81861c, i3);
        this.f81852g.o(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentJ = j(i3, shapeAppearancePathSpec.f81859a);
        edgeTreatmentJ.b(fMax, fI, shapeAppearancePathSpec.f81863e, this.f81852g);
        this.f81855j.reset();
        this.f81852g.d(this.f81848c[i3], this.f81855j);
        if (this.f81857l && (edgeTreatmentJ.a() || l(this.f81855j, i3) || l(this.f81855j, i4))) {
            Path path = this.f81855j;
            path.op(path, this.f81851f, Path.Op.DIFFERENCE);
            this.f81853h[0] = this.f81852g.k();
            this.f81853h[1] = this.f81852g.l();
            this.f81848c[i3].mapPoints(this.f81853h);
            Path path2 = this.f81850e;
            float[] fArr2 = this.f81853h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f81852g.d(this.f81848c[i3], this.f81850e);
        } else {
            this.f81852g.d(this.f81848c[i3], shapeAppearancePathSpec.f81860b);
        }
        PathListener pathListener = shapeAppearancePathSpec.f81862d;
        if (pathListener != null) {
            pathListener.b(this.f81852g, this.f81848c[i3], i3);
        }
    }

    private void f(int i3, RectF rectF, PointF pointF) {
        if (i3 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i3 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i3 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private CornerSize g(int i3, ShapeAppearanceModel shapeAppearanceModel) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? shapeAppearanceModel.t() : shapeAppearanceModel.r() : shapeAppearanceModel.j() : shapeAppearanceModel.l();
    }

    private CornerTreatment h(int i3, ShapeAppearanceModel shapeAppearanceModel) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? shapeAppearanceModel.s() : shapeAppearanceModel.q() : shapeAppearanceModel.i() : shapeAppearanceModel.k();
    }

    private float i(RectF rectF, int i3) {
        float[] fArr = this.f81853h;
        ShapePath shapePath = this.f81846a[i3];
        fArr[0] = shapePath.f81866c;
        fArr[1] = shapePath.f81867d;
        this.f81847b[i3].mapPoints(fArr);
        return (i3 == 1 || i3 == 3) ? Math.abs(rectF.centerX() - this.f81853h[0]) : Math.abs(rectF.centerY() - this.f81853h[1]);
    }

    private EdgeTreatment j(int i3, ShapeAppearanceModel shapeAppearanceModel) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? shapeAppearanceModel.o() : shapeAppearanceModel.p() : shapeAppearanceModel.n() : shapeAppearanceModel.h();
    }

    public static ShapeAppearancePathProvider k() {
        return Lazy.f81858a;
    }

    private boolean l(Path path, int i3) {
        this.f81856k.reset();
        this.f81846a[i3].d(this.f81847b[i3], this.f81856k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f81856k.computeBounds(rectF, true);
        path.op(this.f81856k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    private void m(ShapeAppearancePathSpec shapeAppearancePathSpec, int i3) {
        h(i3, shapeAppearancePathSpec.f81859a).c(this.f81846a[i3], 90.0f, shapeAppearancePathSpec.f81863e, shapeAppearancePathSpec.f81861c, g(i3, shapeAppearancePathSpec.f81859a));
        float fA = a(i3);
        this.f81847b[i3].reset();
        f(i3, shapeAppearancePathSpec.f81861c, this.f81849d);
        Matrix matrix = this.f81847b[i3];
        PointF pointF = this.f81849d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f81847b[i3].preRotate(fA);
    }

    private void n(int i3) {
        this.f81853h[0] = this.f81846a[i3].i();
        this.f81853h[1] = this.f81846a[i3].j();
        this.f81847b[i3].mapPoints(this.f81853h);
        float fA = a(i3);
        this.f81848c[i3].reset();
        Matrix matrix = this.f81848c[i3];
        float[] fArr = this.f81853h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f81848c[i3].preRotate(fA);
    }

    public void d(ShapeAppearanceModel shapeAppearanceModel, float f3, RectF rectF, Path path) {
        e(shapeAppearanceModel, f3, rectF, null, path);
    }

    public void e(ShapeAppearanceModel shapeAppearanceModel, float f3, RectF rectF, PathListener pathListener, Path path) {
        path.rewind();
        this.f81850e.rewind();
        this.f81851f.rewind();
        this.f81851f.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f3, rectF, pathListener, path);
        for (int i3 = 0; i3 < 4; i3++) {
            m(shapeAppearancePathSpec, i3);
            n(i3);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            b(shapeAppearancePathSpec, i4);
            c(shapeAppearancePathSpec, i4);
        }
        path.close();
        this.f81850e.close();
        if (this.f81850e.isEmpty()) {
            return;
        }
        path.op(this.f81850e, Path.Op.UNION);
    }
}
