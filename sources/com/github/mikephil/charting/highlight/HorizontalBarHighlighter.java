package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f3, float f4) {
        BarData barData = ((BarDataProvider) this.f68575a).getBarData();
        MPPointD mPPointDJ = j(f4, f3);
        Highlight highlightF = f((float) mPPointDJ.f68790d, f4, f3);
        if (highlightF == null) {
            return null;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) barData.e(highlightF.d());
        if (iBarDataSet.F0()) {
            return l(highlightF, iBarDataSet, (float) mPPointDJ.f68790d, (float) mPPointDJ.f68789c);
        }
        MPPointD.c(mPPointDJ);
        return highlightF;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List b(IDataSet iDataSet, int i3, float f3, DataSet.Rounding rounding) {
        Entry entryV0;
        ArrayList arrayList = new ArrayList();
        List<Entry> listE = iDataSet.E(f3);
        if (listE.size() == 0 && (entryV0 = iDataSet.v0(f3, Float.NaN, rounding)) != null) {
            listE = iDataSet.E(entryV0.h());
        }
        if (listE.size() != 0) {
            for (Entry entry : listE) {
                MPPointD mPPointDE = ((BarDataProvider) this.f68575a).a(iDataSet.K()).e(entry.e(), entry.h());
                arrayList.add(new Highlight(entry.h(), entry.e(), (float) mPPointDE.f68789c, (float) mPPointDE.f68790d, i3, iDataSet.K()));
            }
        }
        return arrayList;
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter
    protected float e(float f3, float f4, float f5, float f6) {
        return Math.abs(f4 - f6);
    }
}
