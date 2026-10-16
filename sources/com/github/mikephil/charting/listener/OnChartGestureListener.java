package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface OnChartGestureListener {
    void a(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void b(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4);

    void c(MotionEvent motionEvent);

    void d(MotionEvent motionEvent, float f3, float f4);

    void e(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void f(MotionEvent motionEvent, float f3, float f4);

    void g(MotionEvent motionEvent);

    void h(MotionEvent motionEvent);
}
