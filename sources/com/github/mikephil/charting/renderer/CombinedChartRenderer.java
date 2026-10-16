package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CombinedChartRenderer extends DataRenderer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected List f68691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected WeakReference f68692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected List f68693i;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68694a;

        static {
            int[] iArr = new int[CombinedChart.DrawOrder.values().length];
            f68694a = iArr;
            try {
                iArr[CombinedChart.DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68694a[CombinedChart.DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68694a[CombinedChart.DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68694a[CombinedChart.DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68694a[CombinedChart.DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68691g = new ArrayList(5);
        this.f68693i = new ArrayList();
        this.f68692h = new WeakReference(combinedChart);
        h();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        Iterator it = this.f68691g.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).b(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        Iterator it = this.f68691g.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).c(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        Chart chart = (Chart) this.f68692h.get();
        if (chart == null) {
            return;
        }
        for (DataRenderer dataRenderer : this.f68691g) {
            Object barData = dataRenderer instanceof BarChartRenderer ? ((BarChartRenderer) dataRenderer).f68670h.getBarData() : dataRenderer instanceof LineChartRenderer ? ((LineChartRenderer) dataRenderer).f68711i.getLineData() : dataRenderer instanceof CandleStickChartRenderer ? ((CandleStickChartRenderer) dataRenderer).f68685i.getCandleData() : dataRenderer instanceof ScatterChartRenderer ? ((ScatterChartRenderer) dataRenderer).f68750i.getScatterData() : dataRenderer instanceof BubbleChartRenderer ? ((BubbleChartRenderer) dataRenderer).f68681h.getBubbleData() : null;
            int iIndexOf = barData == null ? -1 : ((CombinedData) chart.getData()).t().indexOf(barData);
            this.f68693i.clear();
            for (Highlight highlight : highlightArr) {
                if (highlight.c() == iIndexOf || highlight.c() == -1) {
                    this.f68693i.add(highlight);
                }
            }
            List list = this.f68693i;
            dataRenderer.d(canvas, (Highlight[]) list.toArray(new Highlight[list.size()]));
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        Iterator it = this.f68691g.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).e(canvas);
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
        Iterator it = this.f68691g.iterator();
        while (it.hasNext()) {
            ((DataRenderer) it.next()).f();
        }
    }

    public void h() {
        this.f68691g.clear();
        CombinedChart combinedChart = (CombinedChart) this.f68692h.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i3 = AnonymousClass1.f68694a[drawOrder.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5 && combinedChart.getScatterData() != null) {
                                this.f68691g.add(new ScatterChartRenderer(combinedChart, this.f68695b, this.f68749a));
                            }
                        } else if (combinedChart.getCandleData() != null) {
                            this.f68691g.add(new CandleStickChartRenderer(combinedChart, this.f68695b, this.f68749a));
                        }
                    } else if (combinedChart.getLineData() != null) {
                        this.f68691g.add(new LineChartRenderer(combinedChart, this.f68695b, this.f68749a));
                    }
                } else if (combinedChart.getBubbleData() != null) {
                    this.f68691g.add(new BubbleChartRenderer(combinedChart, this.f68695b, this.f68749a));
                }
            } else if (combinedChart.getBarData() != null) {
                this.f68691g.add(new BarChartRenderer(combinedChart, this.f68695b, this.f68749a));
            }
        }
    }
}
