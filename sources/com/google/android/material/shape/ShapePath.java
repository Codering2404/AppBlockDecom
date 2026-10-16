package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ShapePath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f81864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f81865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f81866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f81867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f81868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f81869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f81870g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f81871h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f81872i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ArcShadowOperation extends ShadowCompatOperation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PathArcOperation f81876c;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.f81876c = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i3, Canvas canvas) {
            shadowRenderer.a(canvas, matrix, new RectF(this.f81876c.k(), this.f81876c.o(), this.f81876c.l(), this.f81876c.j()), i3, this.f81876c.m(), this.f81876c.n());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InnerCornerShadowOperation extends ShadowCompatOperation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PathLineOperation f81877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PathLineOperation f81878d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f81879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final float f81880f;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f3, float f4) {
            this.f81877c = pathLineOperation;
            this.f81878d = pathLineOperation2;
            this.f81879e = f3;
            this.f81880f = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i3, Canvas canvas) {
            int i4;
            float fE = e();
            if (fE > 0.0f) {
                return;
            }
            double dHypot = Math.hypot(this.f81877c.f81897b - this.f81879e, this.f81877c.f81898c - this.f81880f);
            double dHypot2 = Math.hypot(this.f81878d.f81897b - this.f81877c.f81897b, this.f81878d.f81898c - this.f81877c.f81898c);
            float fMin = (float) Math.min(i3, Math.min(dHypot, dHypot2));
            double d3 = fMin;
            double dTan = Math.tan(Math.toRadians((-fE) / 2.0f)) * d3;
            if (dHypot > dTan) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) (dHypot - dTan), 0.0f);
                this.f81905a.set(matrix);
                this.f81905a.preTranslate(this.f81879e, this.f81880f);
                this.f81905a.preRotate(d());
                i4 = i3;
                shadowRenderer.b(canvas, this.f81905a, rectF, i4);
            } else {
                i4 = i3;
            }
            float f3 = fMin * 2.0f;
            RectF rectF2 = new RectF(0.0f, 0.0f, f3, f3);
            this.f81905a.set(matrix);
            this.f81905a.preTranslate(this.f81877c.f81897b, this.f81877c.f81898c);
            this.f81905a.preRotate(d());
            this.f81905a.preTranslate((float) ((-dTan) - d3), (-2.0f) * fMin);
            shadowRenderer.c(canvas, this.f81905a, rectF2, (int) fMin, 450.0f, fE, new float[]{(float) (d3 + dTan), f3});
            if (dHypot2 > dTan) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) (dHypot2 - dTan), 0.0f);
                this.f81905a.set(matrix);
                this.f81905a.preTranslate(this.f81877c.f81897b, this.f81877c.f81898c);
                this.f81905a.preRotate(c());
                this.f81905a.preTranslate((float) dTan, 0.0f);
                shadowRenderer.b(canvas, this.f81905a, rectF3, i4);
            }
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f81878d.f81898c - this.f81877c.f81898c) / (this.f81878d.f81897b - this.f81877c.f81897b)));
        }

        float d() {
            return (float) Math.toDegrees(Math.atan((this.f81877c.f81898c - this.f81880f) / (this.f81877c.f81897b - this.f81879e)));
        }

        float e() {
            float fC = ((c() - d()) + 360.0f) % 360.0f;
            return fC <= 180.0f ? fC : fC - 360.0f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LineShadowOperation extends ShadowCompatOperation {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PathLineOperation f81881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f81882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f81883e;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f3, float f4) {
            this.f81881c = pathLineOperation;
            this.f81882d = f3;
            this.f81883e = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i3, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f81881c.f81898c - this.f81883e, this.f81881c.f81897b - this.f81882d), 0.0f);
            this.f81905a.set(matrix);
            this.f81905a.preTranslate(this.f81882d, this.f81883e);
            this.f81905a.preRotate(c());
            shadowRenderer.b(canvas, this.f81905a, rectF, i3);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f81881c.f81898c - this.f81883e) / (this.f81881c.f81897b - this.f81882d)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathArcOperation extends PathOperation {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f81884h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f81885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f81886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f81887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f81888e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f81889f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f81890g;

        public PathArcOperation(float f3, float f4, float f5, float f6) {
            q(f3);
            u(f4);
            r(f5);
            p(f6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f81888e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f81885b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f81887d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f81889f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f81890g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f81886c;
        }

        private void p(float f3) {
            this.f81888e = f3;
        }

        private void q(float f3) {
            this.f81885b = f3;
        }

        private void r(float f3) {
            this.f81887d = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f3) {
            this.f81889f = f3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f3) {
            this.f81890g = f3;
        }

        private void u(float f3) {
            this.f81886c = f3;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f81899a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f81884h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathCubicOperation extends PathOperation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f81891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f81892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f81893d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f81894e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f81895f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f81896g;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f81899a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f81891b, this.f81892c, this.f81893d, this.f81894e, this.f81895f, this.f81896g);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathLineOperation extends PathOperation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f81897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f81898c;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f81899a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f81897b, this.f81898c);
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class PathOperation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f81899a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathQuadOperation extends PathOperation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f81900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f81901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f81902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f81903e;

        private float b() {
            return this.f81900b;
        }

        private float c() {
            return this.f81901c;
        }

        private float d() {
            return this.f81902d;
        }

        private float e() {
            return this.f81903e;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f81899a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(b(), c(), d(), e());
            path.transform(matrix);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class ShadowCompatOperation {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Matrix f81904b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f81905a = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i3, Canvas canvas);

        public final void b(ShadowRenderer shadowRenderer, int i3, Canvas canvas) {
            a(f81904b, shadowRenderer, i3, canvas);
        }
    }

    public ShapePath() {
        o(0.0f, 0.0f);
    }

    private void b(float f3) {
        if (g() == f3) {
            return;
        }
        float fG = ((f3 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(i(), j(), i(), j());
        pathArcOperation.s(g());
        pathArcOperation.t(fG);
        this.f81871h.add(new ArcShadowOperation(pathArcOperation));
        q(f3);
    }

    private void c(ShadowCompatOperation shadowCompatOperation, float f3, float f4) {
        b(f3);
        this.f81871h.add(shadowCompatOperation);
        q(f4);
    }

    private float g() {
        return this.f81868e;
    }

    private float h() {
        return this.f81869f;
    }

    private void q(float f3) {
        this.f81868e = f3;
    }

    private void r(float f3) {
        this.f81869f = f3;
    }

    private void s(float f3) {
        this.f81866c = f3;
    }

    private void t(float f3) {
        this.f81867d = f3;
    }

    private void u(float f3) {
        this.f81864a = f3;
    }

    private void v(float f3) {
        this.f81865b = f3;
    }

    public void a(float f3, float f4, float f5, float f6, float f7, float f8) {
        PathArcOperation pathArcOperation = new PathArcOperation(f3, f4, f5, f6);
        pathArcOperation.s(f7);
        pathArcOperation.t(f8);
        this.f81870g.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f9 = f7 + f8;
        boolean z2 = f8 < 0.0f;
        if (z2) {
            f7 = (f7 + 180.0f) % 360.0f;
        }
        c(arcShadowOperation, f7, z2 ? (180.0f + f9) % 360.0f : f9);
        double d3 = f9;
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.cos(Math.toRadians(d3)))));
        t(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.sin(Math.toRadians(d3)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f81870g.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((PathOperation) this.f81870g.get(i3)).a(matrix, path);
        }
    }

    boolean e() {
        return this.f81872i;
    }

    ShadowCompatOperation f(Matrix matrix) {
        b(h());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.f81871h);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void a(Matrix matrix3, ShadowRenderer shadowRenderer, int i3, Canvas canvas) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ShadowCompatOperation) it.next()).a(matrix2, shadowRenderer, i3, canvas);
                }
            }
        };
    }

    float i() {
        return this.f81866c;
    }

    float j() {
        return this.f81867d;
    }

    float k() {
        return this.f81864a;
    }

    float l() {
        return this.f81865b;
    }

    public void m(float f3, float f4) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f81897b = f3;
        pathLineOperation.f81898c = f4;
        this.f81870g.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, i(), j());
        c(lineShadowOperation, lineShadowOperation.c() + 270.0f, lineShadowOperation.c() + 270.0f);
        s(f3);
        t(f4);
    }

    public void n(float f3, float f4, float f5, float f6) {
        if ((Math.abs(f3 - i()) < 0.001f && Math.abs(f4 - j()) < 0.001f) || (Math.abs(f3 - f5) < 0.001f && Math.abs(f4 - f6) < 0.001f)) {
            m(f5, f6);
            return;
        }
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f81897b = f3;
        pathLineOperation.f81898c = f4;
        this.f81870g.add(pathLineOperation);
        PathLineOperation pathLineOperation2 = new PathLineOperation();
        pathLineOperation2.f81897b = f5;
        pathLineOperation2.f81898c = f6;
        this.f81870g.add(pathLineOperation2);
        InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, i(), j());
        if (innerCornerShadowOperation.e() > 0.0f) {
            m(f3, f4);
            m(f5, f6);
        } else {
            c(innerCornerShadowOperation, innerCornerShadowOperation.d() + 270.0f, innerCornerShadowOperation.c() + 270.0f);
            s(f5);
            t(f6);
        }
    }

    public void o(float f3, float f4) {
        p(f3, f4, 270.0f, 0.0f);
    }

    public void p(float f3, float f4, float f5, float f6) {
        u(f3);
        v(f4);
        s(f3);
        t(f4);
        q(f5);
        r((f5 + f6) % 360.0f);
        this.f81870g.clear();
        this.f81871h.clear();
        this.f81872i = false;
    }
}
