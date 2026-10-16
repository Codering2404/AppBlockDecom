package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f3, float f4) {
        Highlight highlightA = super.a(f3, f4);
        if (highlightA == null) {
            return null;
        }
        MPPointD mPPointDJ = j(f3, f4);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.f68575a).getBarData().e(highlightA.d());
        if (iBarDataSet.F0()) {
            return l(highlightA, iBarDataSet, (float) mPPointDJ.f68789c, (float) mPPointDJ.f68790d);
        }
        MPPointD.c(mPPointDJ);
        return highlightA;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected BarLineScatterCandleBubbleData d() {
        return ((BarDataProvider) this.f68575a).getBarData();
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float e(float f3, float f4, float f5, float f6) {
        return Math.abs(f3 - f5);
    }

    protected int k(Range[] rangeArr, float f3) {
        if (rangeArr != null && rangeArr.length != 0) {
            int i3 = 0;
            for (Range range : rangeArr) {
                if (range.a(f3)) {
                    return i3;
                }
                i3++;
            }
            int iMax = Math.max(rangeArr.length - 1, 0);
            if (f3 > rangeArr[iMax].f68591b) {
                return iMax;
            }
        }
        return 0;
    }

    public Highlight l(Highlight highlight, IBarDataSet iBarDataSet, float f3, float f4) {
        BarEntry barEntry = (BarEntry) iBarDataSet.a0(f3, f4);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.o() == null) {
            return highlight;
        }
        Range[] rangeArrN = barEntry.n();
        if (rangeArrN.length <= 0) {
            return null;
        }
        int iK = k(rangeArrN, f4);
        MPPointD mPPointDE = ((BarDataProvider) this.f68575a).a(iBarDataSet.K()).e(highlight.h(), rangeArrN[iK].f68591b);
        Highlight highlight2 = new Highlight(barEntry.h(), barEntry.e(), (float) mPPointDE.f68789c, (float) mPPointDE.f68790d, highlight.d(), iK, highlight.b());
        MPPointD.c(mPPointDE);
        return highlight2;
    }
}
