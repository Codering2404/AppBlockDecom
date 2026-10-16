package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected XBounds f68676g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected class XBounds {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f68677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f68678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f68679c;

        protected XBounds() {
        }

        public void a(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
            float fMax = Math.max(0.0f, Math.min(1.0f, BarLineScatterCandleBubbleRenderer.this.f68695b.a()));
            float lowestVisibleX = barLineScatterCandleBubbleDataProvider.getLowestVisibleX();
            float highestVisibleX = barLineScatterCandleBubbleDataProvider.getHighestVisibleX();
            Entry entryV0 = iBarLineScatterCandleBubbleDataSet.v0(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            Entry entryV02 = iBarLineScatterCandleBubbleDataSet.v0(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            this.f68677a = entryV0 == null ? 0 : iBarLineScatterCandleBubbleDataSet.e(entryV0);
            this.f68678b = entryV02 != null ? iBarLineScatterCandleBubbleDataSet.e(entryV02) : 0;
            this.f68679c = (int) ((r2 - this.f68677a) * fMax);
        }
    }

    public BarLineScatterCandleBubbleRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68676g = new XBounds();
    }

    protected boolean h(Entry entry, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
        return entry != null && ((float) iBarLineScatterCandleBubbleDataSet.e(entry)) < ((float) iBarLineScatterCandleBubbleDataSet.J0()) * this.f68695b.a();
    }

    protected boolean i(IDataSet iDataSet) {
        if (iDataSet.isVisible()) {
            return iDataSet.I() || iDataSet.c0();
        }
        return false;
    }
}
