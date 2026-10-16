package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DataRenderer extends Renderer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ChartAnimator f68695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Paint f68696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f68697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Paint f68698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Paint f68699f;

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.f68695b = chartAnimator;
        Paint paint = new Paint(1);
        this.f68696c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f68698e = new Paint(4);
        Paint paint2 = new Paint(1);
        this.f68699f = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f68699f.setTextAlign(Paint.Align.CENTER);
        this.f68699f.setTextSize(Utils.e(9.0f));
        Paint paint3 = new Paint(1);
        this.f68697d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f68697d.setStrokeWidth(2.0f);
        this.f68697d.setColor(Color.rgb(255, 187, 115));
    }

    protected void a(IDataSet iDataSet) {
        this.f68699f.setTypeface(iDataSet.v());
        this.f68699f.setTextSize(iDataSet.i0());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    public abstract void d(Canvas canvas, Highlight[] highlightArr);

    public abstract void e(Canvas canvas);

    public abstract void f();

    protected boolean g(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().h()) < ((float) chartInterface.getMaxVisibleCount()) * this.f68749a.q();
    }
}
