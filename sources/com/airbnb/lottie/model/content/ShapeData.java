package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PointF f56815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f56816c;

    public ShapeData(PointF pointF, boolean z2, List list) {
        this.f56815b = pointF;
        this.f56816c = z2;
        this.f56814a = new ArrayList(list);
    }

    public List a() {
        return this.f56814a;
    }

    public PointF b() {
        return this.f56815b;
    }

    public void c(ShapeData shapeData, ShapeData shapeData2, float f3) {
        if (this.f56815b == null) {
            this.f56815b = new PointF();
        }
        this.f56816c = shapeData.d() || shapeData2.d();
        if (shapeData.a().size() != shapeData2.a().size()) {
            Logger.c("Curves must have the same number of control points. Shape 1: " + shapeData.a().size() + "\tShape 2: " + shapeData2.a().size());
        }
        int iMin = Math.min(shapeData.a().size(), shapeData2.a().size());
        if (this.f56814a.size() < iMin) {
            for (int size = this.f56814a.size(); size < iMin; size++) {
                this.f56814a.add(new CubicCurveData());
            }
        } else if (this.f56814a.size() > iMin) {
            for (int size2 = this.f56814a.size() - 1; size2 >= iMin; size2--) {
                List list = this.f56814a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFB = shapeData.b();
        PointF pointFB2 = shapeData2.b();
        f(MiscUtils.i(pointFB.x, pointFB2.x, f3), MiscUtils.i(pointFB.y, pointFB2.y, f3));
        for (int size3 = this.f56814a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = (CubicCurveData) shapeData.a().get(size3);
            CubicCurveData cubicCurveData2 = (CubicCurveData) shapeData2.a().get(size3);
            PointF pointFA = cubicCurveData.a();
            PointF pointFB3 = cubicCurveData.b();
            PointF pointFC = cubicCurveData.c();
            PointF pointFA2 = cubicCurveData2.a();
            PointF pointFB4 = cubicCurveData2.b();
            PointF pointFC2 = cubicCurveData2.c();
            ((CubicCurveData) this.f56814a.get(size3)).d(MiscUtils.i(pointFA.x, pointFA2.x, f3), MiscUtils.i(pointFA.y, pointFA2.y, f3));
            ((CubicCurveData) this.f56814a.get(size3)).e(MiscUtils.i(pointFB3.x, pointFB4.x, f3), MiscUtils.i(pointFB3.y, pointFB4.y, f3));
            ((CubicCurveData) this.f56814a.get(size3)).f(MiscUtils.i(pointFC.x, pointFC2.x, f3), MiscUtils.i(pointFC.y, pointFC2.y, f3));
        }
    }

    public boolean d() {
        return this.f56816c;
    }

    public void e(boolean z2) {
        this.f56816c = z2;
    }

    public void f(float f3, float f4) {
        if (this.f56815b == null) {
            this.f56815b = new PointF();
        }
        this.f56815b.set(f3, f4);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f56814a.size() + "closed=" + this.f56816c + '}';
    }

    public ShapeData() {
        this.f56814a = new ArrayList();
    }
}
