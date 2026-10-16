package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected BarHighlighter f68577c;

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        this.f68577c = barDataProvider.getBarData() == null ? null : new BarHighlighter(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List h(float f3, float f4, float f5) {
        this.f68576b.clear();
        List listT = ((CombinedDataProvider) this.f68575a).getCombinedData().t();
        for (int i3 = 0; i3 < listT.size(); i3++) {
            ChartData chartData = (ChartData) listT.get(i3);
            BarHighlighter barHighlighter = this.f68577c;
            if (barHighlighter == null || !(chartData instanceof BarData)) {
                int iF = chartData.f();
                for (int i4 = 0; i4 < iF; i4++) {
                    IDataSet iDataSetE = ((BarLineScatterCandleBubbleData) listT.get(i3)).e(i4);
                    if (iDataSetE.M0()) {
                        for (Highlight highlight : b(iDataSetE, i4, f3, DataSet.Rounding.CLOSEST)) {
                            highlight.l(i3);
                            this.f68576b.add(highlight);
                        }
                    }
                }
            } else {
                Highlight highlightA = barHighlighter.a(f4, f5);
                if (highlightA != null) {
                    highlightA.l(i3);
                    this.f68576b.add(highlightA);
                }
            }
        }
        return this.f68576b;
    }
}
