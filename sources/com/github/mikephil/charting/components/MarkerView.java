package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MarkerView extends RelativeLayout implements IMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MPPointF f68470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MPPointF f68471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference f68472c;

    private void setupLayoutResource(int i3) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i3, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void a(Canvas canvas, float f3, float f4) {
        MPPointF mPPointFC = c(f3, f4);
        int iSave = canvas.save();
        canvas.translate(f3 + mPPointFC.f68793c, f4 + mPPointFC.f68794d);
        draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void b(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public MPPointF c(float f3, float f4) {
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.f68471b;
        mPPointF.f68793c = offset.f68793c;
        mPPointF.f68794d = offset.f68794d;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        MPPointF mPPointF2 = this.f68471b;
        float f5 = mPPointF2.f68793c;
        if (f3 + f5 < 0.0f) {
            mPPointF2.f68793c = -f3;
        } else if (chartView != null && f3 + width + f5 > chartView.getWidth()) {
            this.f68471b.f68793c = (chartView.getWidth() - f3) - width;
        }
        MPPointF mPPointF3 = this.f68471b;
        float f6 = mPPointF3.f68794d;
        if (f4 + f6 < 0.0f) {
            mPPointF3.f68794d = -f4;
        } else if (chartView != null && f4 + height + f6 > chartView.getHeight()) {
            this.f68471b.f68794d = (chartView.getHeight() - f4) - height;
        }
        return this.f68471b;
    }

    public Chart getChartView() {
        WeakReference weakReference = this.f68472c;
        if (weakReference == null) {
            return null;
        }
        return (Chart) weakReference.get();
    }

    public MPPointF getOffset() {
        return this.f68470a;
    }

    public void setChartView(Chart chart) {
        this.f68472c = new WeakReference(chart);
    }

    public void setOffset(MPPointF mPPointF) {
        this.f68470a = mPPointF;
        if (mPPointF == null) {
            this.f68470a = new MPPointF();
        }
    }
}
