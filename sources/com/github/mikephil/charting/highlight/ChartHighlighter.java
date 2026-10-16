package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BarLineScatterCandleBubbleDataProvider f68575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List f68576b = new ArrayList();

    public ChartHighlighter(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider) {
        this.f68575a = barLineScatterCandleBubbleDataProvider;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f3, float f4) {
        MPPointD mPPointDJ = j(f3, f4);
        float f5 = (float) mPPointDJ.f68789c;
        MPPointD.c(mPPointDJ);
        return f(f5, f3, f4);
    }

    protected List b(IDataSet iDataSet, int i3, float f3, DataSet.Rounding rounding) {
        Entry entryV0;
        ArrayList arrayList = new ArrayList();
        List<Entry> listE = iDataSet.E(f3);
        if (listE.size() == 0 && (entryV0 = iDataSet.v0(f3, Float.NaN, rounding)) != null) {
            listE = iDataSet.E(entryV0.h());
        }
        if (listE.size() != 0) {
            for (Entry entry : listE) {
                MPPointD mPPointDE = this.f68575a.a(iDataSet.K()).e(entry.h(), entry.e());
                arrayList.add(new Highlight(entry.h(), entry.e(), (float) mPPointDE.f68789c, (float) mPPointDE.f68790d, i3, iDataSet.K()));
            }
        }
        return arrayList;
    }

    public Highlight c(List list, float f3, float f4, YAxis.AxisDependency axisDependency, float f5) {
        Highlight highlight = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Highlight highlight2 = (Highlight) list.get(i3);
            if (axisDependency == null || highlight2.b() == axisDependency) {
                float fE = e(f3, f4, highlight2.i(), highlight2.k());
                if (fE < f5) {
                    highlight = highlight2;
                    f5 = fE;
                }
            }
        }
        return highlight;
    }

    protected BarLineScatterCandleBubbleData d() {
        return this.f68575a.getData();
    }

    protected float e(float f3, float f4, float f5, float f6) {
        return (float) Math.hypot(f3 - f5, f4 - f6);
    }

    protected Highlight f(float f3, float f4, float f5) {
        List listH = h(f3, f4, f5);
        if (listH.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float fI = i(listH, f5, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return c(listH, f4, f5, fI < i(listH, f5, axisDependency2) ? axisDependency : axisDependency2, this.f68575a.getMaxHighlightDistance());
    }

    protected float g(Highlight highlight) {
        return highlight.k();
    }

    protected List h(float f3, float f4, float f5) {
        this.f68576b.clear();
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleDataD = d();
        if (barLineScatterCandleBubbleDataD == null) {
            return this.f68576b;
        }
        int iF = barLineScatterCandleBubbleDataD.f();
        for (int i3 = 0; i3 < iF; i3++) {
            IDataSet iDataSetE = barLineScatterCandleBubbleDataD.e(i3);
            if (iDataSetE.M0()) {
                this.f68576b.addAll(b(iDataSetE, i3, f3, DataSet.Rounding.CLOSEST));
            }
        }
        return this.f68576b;
    }

    protected float i(List list, float f3, YAxis.AxisDependency axisDependency) {
        float f4 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Highlight highlight = (Highlight) list.get(i3);
            if (highlight.b() == axisDependency) {
                float fAbs = Math.abs(g(highlight) - f3);
                if (fAbs < f4) {
                    f4 = fAbs;
                }
            }
        }
        return f4;
    }

    protected MPPointD j(float f3, float f4) {
        return this.f68575a.a(YAxis.AxisDependency.LEFT).g(f3, f4);
    }
}
