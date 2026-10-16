package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ChartGesture f68631a = ChartGesture.NONE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f68632b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Highlight f68633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected GestureDetector f68634d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Chart f68635f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(Chart chart) {
        this.f68635f = chart;
        this.f68634d = new GestureDetector(chart.getContext(), this);
    }

    protected static float a(float f3, float f4, float f5, float f6) {
        float f7 = f3 - f4;
        float f8 = f5 - f6;
        return (float) Math.sqrt((f7 * f7) + (f8 * f8));
    }

    public void b(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.f68635f.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.e(motionEvent, this.f68631a);
        }
    }

    protected void c(Highlight highlight, MotionEvent motionEvent) {
        if (highlight == null || highlight.a(this.f68633c)) {
            this.f68635f.m(null, true);
            this.f68633c = null;
        } else {
            this.f68635f.m(highlight, true);
            this.f68633c = highlight;
        }
    }

    public void d(Highlight highlight) {
        this.f68633c = highlight;
    }

    public void e(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.f68635f.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f68631a);
        }
    }
}
