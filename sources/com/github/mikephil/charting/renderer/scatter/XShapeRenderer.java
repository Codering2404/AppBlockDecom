package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class XShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f3, float f4, Paint paint) {
        float fW = iScatterDataSet.w() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        float f5 = f3 - fW;
        float f6 = f4 - fW;
        float f7 = f3 + fW;
        float f8 = f4 + fW;
        canvas.drawLine(f5, f6, f7, f8, paint);
        canvas.drawLine(f7, f6, f5, f8, paint);
    }
}
