package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MiscUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PointF f57102a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f3, float f4, float f5) {
        return Math.max(f4, Math.min(f5, f3));
    }

    public static int c(int i3, int i4, int i5) {
        return Math.max(i4, Math.min(i5, i3));
    }

    public static boolean d(float f3, float f4, float f5) {
        return f3 >= f4 && f3 <= f5;
    }

    private static int e(int i3, int i4) {
        int i5 = i3 / i4;
        return (((i3 ^ i4) >= 0) || i3 % i4 == 0) ? i5 : i5 - 1;
    }

    static int f(float f3, float f4) {
        return g((int) f3, (int) f4);
    }

    private static int g(int i3, int i4) {
        return i3 - (i4 * e(i3, i4));
    }

    public static void h(ShapeData shapeData, Path path) {
        Path path2;
        path.reset();
        PointF pointFB = shapeData.b();
        path.moveTo(pointFB.x, pointFB.y);
        f57102a.set(pointFB.x, pointFB.y);
        int i3 = 0;
        while (i3 < shapeData.a().size()) {
            CubicCurveData cubicCurveData = (CubicCurveData) shapeData.a().get(i3);
            PointF pointFA = cubicCurveData.a();
            PointF pointFB2 = cubicCurveData.b();
            PointF pointFC = cubicCurveData.c();
            PointF pointF = f57102a;
            if (pointFA.equals(pointF) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            pointF.set(pointFC.x, pointFC.y);
            i3++;
            path = path2;
        }
        Path path3 = path;
        if (shapeData.d()) {
            path3.close();
        }
    }

    public static float i(float f3, float f4, float f5) {
        return f3 + (f5 * (f4 - f3));
    }

    public static int j(int i3, int i4, float f3) {
        return (int) (i3 + (f3 * (i4 - i3)));
    }

    public static void k(KeyPath keyPath, int i3, List list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.c(keyPathElementContent.getName(), i3)) {
            list.add(keyPath2.a(keyPathElementContent.getName()).i(keyPathElementContent));
        }
    }
}
