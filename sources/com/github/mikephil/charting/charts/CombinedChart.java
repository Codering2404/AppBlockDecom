package com.github.mikephil.charting.charts;

import android.graphics.Canvas;
import android.util.Log;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private boolean f68347s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    protected boolean f68348t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f68349u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    protected DrawOrder[] f68350v0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean b() {
        return this.f68347s0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean c() {
        return this.f68348t0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean e() {
        return this.f68349u0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        ChartData chartData = this.f68321b;
        if (chartData == null) {
            return null;
        }
        return ((CombinedData) chartData).u();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider
    public BubbleData getBubbleData() {
        ChartData chartData = this.f68321b;
        if (chartData == null) {
            return null;
        }
        return ((CombinedData) chartData).v();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider
    public CandleData getCandleData() {
        ChartData chartData = this.f68321b;
        if (chartData == null) {
            return null;
        }
        return ((CombinedData) chartData).w();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider
    public CombinedData getCombinedData() {
        return (CombinedData) this.f68321b;
    }

    public DrawOrder[] getDrawOrder() {
        return this.f68350v0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        ChartData chartData = this.f68321b;
        if (chartData == null) {
            return null;
        }
        return ((CombinedData) chartData).z();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        ChartData chartData = this.f68321b;
        if (chartData == null) {
            return null;
        }
        return ((CombinedData) chartData).A();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void i(Canvas canvas) {
        if (this.E == null || !p() || !w()) {
            return;
        }
        int i3 = 0;
        while (true) {
            Highlight[] highlightArr = this.B;
            if (i3 >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i3];
            IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSetY = ((CombinedData) this.f68321b).y(highlight);
            Entry entryI = ((CombinedData) this.f68321b).i(highlight);
            if (entryI != null && iBarLineScatterCandleBubbleDataSetY.e(entryI) <= iBarLineScatterCandleBubbleDataSetY.J0() * this.f68340v.a()) {
                float[] fArrL = l(highlight);
                if (this.f68339u.x(fArrL[0], fArrL[1])) {
                    this.E.b(entryI, highlight);
                    this.E.a(canvas, fArrL[0], fArrL[1]);
                }
            }
            i3++;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight k(float f3, float f4) {
        if (this.f68321b == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        Highlight highlightA = getHighlighter().a(f3, f4);
        return (highlightA == null || !c()) ? highlightA : new Highlight(highlightA.h(), highlightA.j(), highlightA.i(), highlightA.k(), highlightA.d(), -1, highlightA.b());
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68350v0 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new CombinedHighlighter(this, this));
        setHighlightFullBarEnabled(true);
        this.f68337s = new CombinedChartRenderer(this, this.f68340v, this.f68339u);
    }

    public void setDrawBarShadow(boolean z2) {
        this.f68349u0 = z2;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.f68350v0 = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z2) {
        this.f68347s0 = z2;
    }

    public void setHighlightFullBarEnabled(boolean z2) {
        this.f68348t0 = z2;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(CombinedData combinedData) {
        super.setData(combinedData);
        setHighlighter(new CombinedHighlighter(this, this));
        ((CombinedChartRenderer) this.f68337s).h();
        this.f68337s.f();
    }
}
