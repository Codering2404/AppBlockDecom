package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private Mode H;
    private List I;
    private int J;
    private float K;
    private float L;
    private float M;
    private DashPathEffect N;
    private IFillFormatter O;
    private boolean P;
    private boolean Q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int I0(int i3) {
        return ((Integer) this.I.get(i3)).intValue();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean L0() {
        return this.P;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float N0() {
        return this.L;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int R() {
        return this.I.size();
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean S0() {
        return this.Q;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public IFillFormatter X() {
        return this.O;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public DashPathEffect g0() {
        return this.N;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public boolean i() {
        return this.N != null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public int k() {
        return this.J;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float l0() {
        return this.K;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public float n() {
        return this.M;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineDataSet
    public Mode o0() {
        return this.H;
    }
}
