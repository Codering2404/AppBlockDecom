package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight b(int i3, float f3, float f4) {
        List listC = c(i3);
        float fY = ((RadarChart) this.f68588a).y(f3, f4) / ((RadarChart) this.f68588a).getFactor();
        Highlight highlight = null;
        float f5 = Float.MAX_VALUE;
        for (int i4 = 0; i4 < listC.size(); i4++) {
            Highlight highlight2 = (Highlight) listC.get(i4);
            float fAbs = Math.abs(highlight2.j() - fY);
            if (fAbs < f5) {
                highlight = highlight2;
                f5 = fAbs;
            }
        }
        return highlight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected List c(int i3) {
        this.f68589b.clear();
        float fA = ((RadarChart) this.f68588a).getAnimator().a();
        float fB = ((RadarChart) this.f68588a).getAnimator().b();
        float sliceAngle = ((RadarChart) this.f68588a).getSliceAngle();
        float factor = ((RadarChart) this.f68588a).getFactor();
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        for (int i4 = 0; i4 < ((RadarData) ((RadarChart) this.f68588a).getData()).f(); i4++) {
            IDataSet iDataSetE = ((RadarData) ((RadarChart) this.f68588a).getData()).e(i4);
            Entry entryR = iDataSetE.r(i3);
            float f3 = i3;
            Utils.r(((RadarChart) this.f68588a).getCenterOffsets(), (entryR.e() - ((RadarChart) this.f68588a).getYChartMin()) * factor * fB, (sliceAngle * f3 * fA) + ((RadarChart) this.f68588a).getRotationAngle(), mPPointFC);
            this.f68589b.add(new Highlight(f3, entryR.e(), mPPointFC.f68793c, mPPointFC.f68794d, i4, iDataSetE.K()));
        }
        return this.f68589b;
    }
}
