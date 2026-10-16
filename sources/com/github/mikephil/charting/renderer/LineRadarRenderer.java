package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    public LineRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    private boolean k() {
        return Utils.s() >= 18;
    }

    protected void l(Canvas canvas, Path path, int i3, int i4) {
        int i5 = (i3 & 16777215) | (i4 << 24);
        if (k()) {
            int iSave = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i5);
            canvas.restoreToCount(iSave);
            return;
        }
        Paint.Style style = this.f68696c.getStyle();
        int color = this.f68696c.getColor();
        this.f68696c.setStyle(Paint.Style.FILL);
        this.f68696c.setColor(i5);
        canvas.drawPath(path, this.f68696c);
        this.f68696c.setColor(color);
        this.f68696c.setStyle(style);
    }

    protected void m(Canvas canvas, Path path, Drawable drawable) {
        if (!k()) {
            throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + Utils.s() + ".");
        }
        int iSave = canvas.save();
        canvas.clipPath(path);
        drawable.setBounds((int) this.f68749a.h(), (int) this.f68749a.j(), (int) this.f68749a.i(), (int) this.f68749a.f());
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
