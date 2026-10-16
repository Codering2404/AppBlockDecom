package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LineData f68530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BarData f68531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ScatterData f68532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private CandleData f68533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BubbleData f68534n;

    public ScatterData A() {
        return this.f68532l;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void b() {
        if (this.f68529i == null) {
            this.f68529i = new ArrayList();
        }
        this.f68529i.clear();
        this.f68521a = -3.4028235E38f;
        this.f68522b = Float.MAX_VALUE;
        this.f68523c = -3.4028235E38f;
        this.f68524d = Float.MAX_VALUE;
        this.f68525e = -3.4028235E38f;
        this.f68526f = Float.MAX_VALUE;
        this.f68527g = -3.4028235E38f;
        this.f68528h = Float.MAX_VALUE;
        for (ChartData chartData : t()) {
            chartData.b();
            this.f68529i.addAll(chartData.g());
            if (chartData.o() > this.f68521a) {
                this.f68521a = chartData.o();
            }
            if (chartData.q() < this.f68522b) {
                this.f68522b = chartData.q();
            }
            if (chartData.m() > this.f68523c) {
                this.f68523c = chartData.m();
            }
            if (chartData.n() < this.f68524d) {
                this.f68524d = chartData.n();
            }
            float f3 = chartData.f68525e;
            if (f3 > this.f68525e) {
                this.f68525e = f3;
            }
            float f4 = chartData.f68526f;
            if (f4 < this.f68526f) {
                this.f68526f = f4;
            }
            float f5 = chartData.f68527g;
            if (f5 > this.f68527g) {
                this.f68527g = f5;
            }
            float f6 = chartData.f68528h;
            if (f6 < this.f68528h) {
                this.f68528h = f6;
            }
        }
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public Entry i(Highlight highlight) {
        if (highlight.c() >= t().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleDataX = x(highlight.c());
        if (highlight.d() >= barLineScatterCandleBubbleDataX.f()) {
            return null;
        }
        for (Entry entry : barLineScatterCandleBubbleDataX.e(highlight.d()).E(highlight.h())) {
            if (entry.e() == highlight.j() || Float.isNaN(highlight.j())) {
                return entry;
            }
        }
        return null;
    }

    @Override // com.github.mikephil.charting.data.ChartData
    public void s() {
        LineData lineData = this.f68530j;
        if (lineData != null) {
            lineData.s();
        }
        BarData barData = this.f68531k;
        if (barData != null) {
            barData.s();
        }
        CandleData candleData = this.f68533m;
        if (candleData != null) {
            candleData.s();
        }
        ScatterData scatterData = this.f68532l;
        if (scatterData != null) {
            scatterData.s();
        }
        BubbleData bubbleData = this.f68534n;
        if (bubbleData != null) {
            bubbleData.s();
        }
        b();
    }

    public List t() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.f68530j;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.f68531k;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.f68532l;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.f68533m;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.f68534n;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarData u() {
        return this.f68531k;
    }

    public BubbleData v() {
        return this.f68534n;
    }

    public CandleData w() {
        return this.f68533m;
    }

    public BarLineScatterCandleBubbleData x(int i3) {
        return (BarLineScatterCandleBubbleData) t().get(i3);
    }

    public IBarLineScatterCandleBubbleDataSet y(Highlight highlight) {
        if (highlight.c() >= t().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleDataX = x(highlight.c());
        if (highlight.d() >= barLineScatterCandleBubbleDataX.f()) {
            return null;
        }
        return (IBarLineScatterCandleBubbleDataSet) barLineScatterCandleBubbleDataX.g().get(highlight.d());
    }

    public LineData z() {
        return this.f68530j;
    }
}
