package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SquareShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f3, float f4, Paint paint) {
        float fW = iScatterDataSet.w();
        float f5 = fW / 2.0f;
        float fE = Utils.e(iScatterDataSet.R0());
        float f6 = (fW - (fE * 2.0f)) / 2.0f;
        float f7 = f6 / 2.0f;
        int iD = iScatterDataSet.D();
        if (fW <= 0.0d) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f3 - f5, f4 - f5, f3 + f5, f4 + f5, paint);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f6);
        float f8 = f3 - fE;
        float f9 = f4 - fE;
        float f10 = f3 + fE;
        float f11 = f4 + fE;
        canvas.drawRect(f8 - f7, f9 - f7, f10 + f7, f11 + f7, paint);
        if (iD != 1122867) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(iD);
            canvas.drawRect(f8, f9, f10, f11, paint);
        }
    }
}
