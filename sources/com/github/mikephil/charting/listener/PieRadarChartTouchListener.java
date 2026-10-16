package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MPPointF f68647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f68648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList f68649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f68650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f68651k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AngularVelocitySample {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f68652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f68653b;

        public AngularVelocitySample(long j3, float f3) {
            this.f68652a = j3;
            this.f68653b = f3;
        }
    }

    public PieRadarChartTouchListener(PieRadarChartBase pieRadarChartBase) {
        super(pieRadarChartBase);
        this.f68647g = MPPointF.c(0.0f, 0.0f);
        this.f68648h = 0.0f;
        this.f68649i = new ArrayList();
        this.f68650j = 0L;
        this.f68651k = 0.0f;
    }

    private float f() {
        if (this.f68649i.isEmpty()) {
            return 0.0f;
        }
        AngularVelocitySample angularVelocitySample = (AngularVelocitySample) this.f68649i.get(0);
        ArrayList arrayList = this.f68649i;
        AngularVelocitySample angularVelocitySample2 = (AngularVelocitySample) arrayList.get(arrayList.size() - 1);
        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
        for (int size = this.f68649i.size() - 1; size >= 0; size--) {
            angularVelocitySample3 = (AngularVelocitySample) this.f68649i.get(size);
            if (angularVelocitySample3.f68653b != angularVelocitySample2.f68653b) {
                break;
            }
        }
        float f3 = (angularVelocitySample2.f68652a - angularVelocitySample.f68652a) / 1000.0f;
        if (f3 == 0.0f) {
            f3 = 0.1f;
        }
        boolean z2 = angularVelocitySample2.f68653b >= angularVelocitySample3.f68653b;
        if (Math.abs(r1 - r6) > 270.0d) {
            z2 = !z2;
        }
        float f4 = angularVelocitySample2.f68653b;
        float f5 = angularVelocitySample.f68653b;
        if (f4 - f5 > 180.0d) {
            angularVelocitySample.f68653b = (float) (((double) f5) + 360.0d);
        } else if (f5 - f4 > 180.0d) {
            angularVelocitySample2.f68653b = (float) (((double) f4) + 360.0d);
        }
        float fAbs = Math.abs((angularVelocitySample2.f68653b - angularVelocitySample.f68653b) / f3);
        return !z2 ? -fAbs : fAbs;
    }

    private void h() {
        this.f68649i.clear();
    }

    private void i(float f3, float f4) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f68649i.add(new AngularVelocitySample(jCurrentAnimationTimeMillis, ((PieRadarChartBase) this.f68635f).z(f3, f4)));
        for (int size = this.f68649i.size(); size - 2 > 0 && jCurrentAnimationTimeMillis - ((AngularVelocitySample) this.f68649i.get(0)).f68652a > 1000; size--) {
            this.f68649i.remove(0);
        }
    }

    public void g() {
        if (this.f68651k == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f68651k *= ((PieRadarChartBase) this.f68635f).getDragDecelerationFrictionCoef();
        Chart chart = this.f68635f;
        ((PieRadarChartBase) chart).setRotationAngle(((PieRadarChartBase) chart).getRotationAngle() + (this.f68651k * ((jCurrentAnimationTimeMillis - this.f68650j) / 1000.0f)));
        this.f68650j = jCurrentAnimationTimeMillis;
        if (Math.abs(this.f68651k) >= 0.001d) {
            Utils.x(this.f68635f);
        } else {
            k();
        }
    }

    public void j(float f3, float f4) {
        this.f68648h = ((PieRadarChartBase) this.f68635f).z(f3, f4) - ((PieRadarChartBase) this.f68635f).getRawRotationAngle();
    }

    public void k() {
        this.f68651k = 0.0f;
    }

    public void l(float f3, float f4) {
        Chart chart = this.f68635f;
        ((PieRadarChartBase) chart).setRotationAngle(((PieRadarChartBase) chart).z(f3, f4) - this.f68648h);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f68631a = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.f68635f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.g(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f68631a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.f68635f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (!((PieRadarChartBase) this.f68635f).q()) {
            return false;
        }
        c(((PieRadarChartBase) this.f68635f).k(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            android.view.GestureDetector r6 = r5.f68634d
            boolean r6 = r6.onTouchEvent(r7)
            r0 = 1
            if (r6 == 0) goto La
            return r0
        La:
            com.github.mikephil.charting.charts.Chart r6 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            boolean r6 = r6.D()
            if (r6 == 0) goto Lc2
            float r6 = r7.getX()
            float r1 = r7.getY()
            int r2 = r7.getAction()
            if (r2 == 0) goto La3
            if (r2 == r0) goto L6f
            r3 = 2
            if (r2 == r3) goto L29
            goto Lc2
        L29:
            com.github.mikephil.charting.charts.Chart r2 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r2 = (com.github.mikephil.charting.charts.PieRadarChartBase) r2
            boolean r2 = r2.o()
            if (r2 == 0) goto L36
            r5.i(r6, r1)
        L36:
            int r2 = r5.f68632b
            r3 = 6
            if (r2 != 0) goto L5d
            com.github.mikephil.charting.utils.MPPointF r2 = r5.f68647g
            float r4 = r2.f68793c
            float r2 = r2.f68794d
            float r2 = com.github.mikephil.charting.listener.ChartTouchListener.a(r6, r4, r1, r2)
            r4 = 1090519040(0x41000000, float:8.0)
            float r4 = com.github.mikephil.charting.utils.Utils.e(r4)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L5d
            com.github.mikephil.charting.listener.ChartTouchListener$ChartGesture r6 = com.github.mikephil.charting.listener.ChartTouchListener.ChartGesture.ROTATE
            r5.f68631a = r6
            r5.f68632b = r3
            com.github.mikephil.charting.charts.Chart r6 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            r6.g()
            goto L6b
        L5d:
            int r2 = r5.f68632b
            if (r2 != r3) goto L6b
            r5.l(r6, r1)
            com.github.mikephil.charting.charts.Chart r6 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            r6.invalidate()
        L6b:
            r5.b(r7)
            goto Lc2
        L6f:
            com.github.mikephil.charting.charts.Chart r2 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r2 = (com.github.mikephil.charting.charts.PieRadarChartBase) r2
            boolean r2 = r2.o()
            if (r2 == 0) goto L95
            r5.k()
            r5.i(r6, r1)
            float r6 = r5.f()
            r5.f68651k = r6
            r1 = 0
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 == 0) goto L95
            long r1 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
            r5.f68650j = r1
            com.github.mikephil.charting.charts.Chart r6 = r5.f68635f
            com.github.mikephil.charting.utils.Utils.x(r6)
        L95:
            com.github.mikephil.charting.charts.Chart r6 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r6 = (com.github.mikephil.charting.charts.PieRadarChartBase) r6
            r6.j()
            r6 = 0
            r5.f68632b = r6
            r5.b(r7)
            goto Lc2
        La3:
            r5.e(r7)
            r5.k()
            r5.h()
            com.github.mikephil.charting.charts.Chart r7 = r5.f68635f
            com.github.mikephil.charting.charts.PieRadarChartBase r7 = (com.github.mikephil.charting.charts.PieRadarChartBase) r7
            boolean r7 = r7.o()
            if (r7 == 0) goto Lb9
            r5.i(r6, r1)
        Lb9:
            r5.j(r6, r1)
            com.github.mikephil.charting.utils.MPPointF r7 = r5.f68647g
            r7.f68793c = r6
            r7.f68794d = r1
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.PieRadarChartTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
