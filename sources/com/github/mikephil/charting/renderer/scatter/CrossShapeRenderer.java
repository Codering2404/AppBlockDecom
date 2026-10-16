package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CrossShapeRenderer implements IShapeRenderer {
    @Override // com.github.mikephil.charting.renderer.scatter.IShapeRenderer
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f3, float f4, Paint paint) {
        float fW = iScatterDataSet.w() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        canvas.drawLine(f3 - fW, f4, f3 + fW, f4, paint);
        canvas.drawLine(f3, f4 - fW, f3, f4 + fW, paint);
    }
}
