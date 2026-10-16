package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TriangleShapeRenderer implements IShapeRenderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Path f68778a;

    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f3, float f4, Paint paint) {
        float fW = iScatterDataSet.w();
        float f5 = fW / 2.0f;
        float fE = (fW - (Utils.e(iScatterDataSet.R0()) * 2.0f)) / 2.0f;
        int iD = iScatterDataSet.D();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.f68778a;
        path.reset();
        float f6 = f4 - f5;
        path.moveTo(f3, f6);
        float f7 = f3 + f5;
        float f8 = f4 + f5;
        path.lineTo(f7, f8);
        float f9 = f3 - f5;
        path.lineTo(f9, f8);
        double d3 = fW;
        if (d3 > 0.0d) {
            path.lineTo(f3, f6);
            float f10 = f9 + fE;
            float f11 = f8 - fE;
            path.moveTo(f10, f11);
            path.lineTo(f7 - fE, f11);
            path.lineTo(f3, f6 + fE);
            path.lineTo(f10, f11);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (d3 <= 0.0d || iD == 1122867) {
            return;
        }
        paint.setColor(iD);
        path.moveTo(f3, f6 + fE);
        float f12 = f8 - fE;
        path.lineTo(f7 - fE, f12);
        path.lineTo(f9 + fE, f12);
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
    }
}
