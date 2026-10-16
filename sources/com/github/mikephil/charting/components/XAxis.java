package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class XAxis extends AxisBase {
    public int J = 1;
    public int K = 1;
    public int L = 1;
    public int M = 1;
    protected float N = 0.0f;
    private boolean O = false;
    private XAxisPosition P = XAxisPosition.TOP;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.f68397c = Utils.e(4.0f);
    }

    public float V() {
        return this.N;
    }

    public XAxisPosition W() {
        return this.P;
    }

    public boolean X() {
        return this.O;
    }

    public void Y(XAxisPosition xAxisPosition) {
        this.P = xAxisPosition;
    }
}
