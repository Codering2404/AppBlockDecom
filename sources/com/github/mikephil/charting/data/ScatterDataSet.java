package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    private float C;
    protected IShapeRenderer D;
    private float E;
    private int F;

    /* JADX INFO: renamed from: com.github.mikephil.charting.data.ScatterDataSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68559a;

        static {
            int[] iArr = new int[ScatterChart.ScatterShape.values().length];
            f68559a = iArr;
            try {
                iArr[ScatterChart.ScatterShape.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68559a[ScatterChart.ScatterShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68559a[ScatterChart.ScatterShape.TRIANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68559a[ScatterChart.ScatterShape.CROSS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68559a[ScatterChart.ScatterShape.X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f68559a[ScatterChart.ScatterShape.CHEVRON_UP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f68559a[ScatterChart.ScatterShape.CHEVRON_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public IShapeRenderer B0() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public int D() {
        return this.F;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float R0() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IScatterDataSet
    public float w() {
        return this.C;
    }
}
