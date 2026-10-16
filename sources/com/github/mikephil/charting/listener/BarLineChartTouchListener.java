package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Matrix f68617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Matrix f68618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MPPointF f68619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MPPointF f68620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f68621k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f68622l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f68623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private IDataSet f68624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private VelocityTracker f68625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f68626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MPPointF f68627q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MPPointF f68628r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f68629s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f68630t;

    public BarLineChartTouchListener(BarLineChartBase barLineChartBase, Matrix matrix, float f3) {
        super(barLineChartBase);
        this.f68617g = new Matrix();
        this.f68618h = new Matrix();
        this.f68619i = MPPointF.c(0.0f, 0.0f);
        this.f68620j = MPPointF.c(0.0f, 0.0f);
        this.f68621k = 1.0f;
        this.f68622l = 1.0f;
        this.f68623m = 1.0f;
        this.f68626p = 0L;
        this.f68627q = MPPointF.c(0.0f, 0.0f);
        this.f68628r = MPPointF.c(0.0f, 0.0f);
        this.f68617g = matrix;
        this.f68629s = Utils.e(f3);
        this.f68630t = Utils.e(3.5f);
    }

    private static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float i(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private boolean j() {
        if (this.f68624n == null && ((BarLineChartBase) this.f68635f).E()) {
            return true;
        }
        IDataSet iDataSet = this.f68624n;
        return iDataSet != null && ((BarLineChartBase) this.f68635f).d(iDataSet.K());
    }

    private static void k(MPPointF mPPointF, MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) + motionEvent.getX(1);
        float y2 = motionEvent.getY(0) + motionEvent.getY(1);
        mPPointF.f68793c = x2 / 2.0f;
        mPPointF.f68794d = y2 / 2.0f;
    }

    private void l(MotionEvent motionEvent, float f3, float f4) {
        this.f68631a = ChartTouchListener.ChartGesture.DRAG;
        this.f68617g.set(this.f68618h);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.f68635f).getOnChartGestureListener();
        if (j()) {
            if (this.f68635f instanceof HorizontalBarChart) {
                f3 = -f3;
            } else {
                f4 = -f4;
            }
        }
        this.f68617g.postTranslate(f3, f4);
        if (onChartGestureListener != null) {
            onChartGestureListener.d(motionEvent, f3, f4);
        }
    }

    private void m(MotionEvent motionEvent) {
        Highlight highlightK = ((BarLineChartBase) this.f68635f).k(motionEvent.getX(), motionEvent.getY());
        if (highlightK == null || highlightK.a(this.f68633c)) {
            return;
        }
        this.f68633c = highlightK;
        ((BarLineChartBase) this.f68635f).m(highlightK, true);
    }

    private void n(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.f68635f).getOnChartGestureListener();
            float fP = p(motionEvent);
            if (fP > this.f68630t) {
                MPPointF mPPointF = this.f68620j;
                MPPointF mPPointFG = g(mPPointF.f68793c, mPPointF.f68794d);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.f68635f).getViewPortHandler();
                int i3 = this.f68632b;
                if (i3 == 4) {
                    this.f68631a = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f3 = fP / this.f68623m;
                    boolean z2 = f3 < 1.0f;
                    boolean zC = z2 ? viewPortHandler.c() : viewPortHandler.a();
                    boolean zD = z2 ? viewPortHandler.d() : viewPortHandler.b();
                    float f4 = ((BarLineChartBase) this.f68635f).N() ? f3 : 1.0f;
                    float f5 = ((BarLineChartBase) this.f68635f).O() ? f3 : 1.0f;
                    if (zD || zC) {
                        this.f68617g.set(this.f68618h);
                        this.f68617g.postScale(f4, f5, mPPointFG.f68793c, mPPointFG.f68794d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.f(motionEvent, f4, f5);
                        }
                    }
                } else if (i3 == 2 && ((BarLineChartBase) this.f68635f).N()) {
                    this.f68631a = ChartTouchListener.ChartGesture.X_ZOOM;
                    float fH = h(motionEvent) / this.f68621k;
                    if (fH < 1.0f ? viewPortHandler.c() : viewPortHandler.a()) {
                        this.f68617g.set(this.f68618h);
                        this.f68617g.postScale(fH, 1.0f, mPPointFG.f68793c, mPPointFG.f68794d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.f(motionEvent, fH, 1.0f);
                        }
                    }
                } else if (this.f68632b == 3 && ((BarLineChartBase) this.f68635f).O()) {
                    this.f68631a = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float fI = i(motionEvent) / this.f68622l;
                    if (fI < 1.0f ? viewPortHandler.d() : viewPortHandler.b()) {
                        this.f68617g.set(this.f68618h);
                        this.f68617g.postScale(1.0f, fI, mPPointFG.f68793c, mPPointFG.f68794d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.f(motionEvent, 1.0f, fI);
                        }
                    }
                }
                MPPointF.f(mPPointFG);
            }
        }
    }

    private void o(MotionEvent motionEvent) {
        this.f68618h.set(this.f68617g);
        this.f68619i.f68793c = motionEvent.getX();
        this.f68619i.f68794d = motionEvent.getY();
        this.f68624n = ((BarLineChartBase) this.f68635f).C(motionEvent.getX(), motionEvent.getY());
    }

    private static float p(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x2 * x2) + (y2 * y2));
    }

    public void f() {
        MPPointF mPPointF = this.f68628r;
        if (mPPointF.f68793c == 0.0f && mPPointF.f68794d == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f68628r.f68793c *= ((BarLineChartBase) this.f68635f).getDragDecelerationFrictionCoef();
        this.f68628r.f68794d *= ((BarLineChartBase) this.f68635f).getDragDecelerationFrictionCoef();
        float f3 = (jCurrentAnimationTimeMillis - this.f68626p) / 1000.0f;
        MPPointF mPPointF2 = this.f68628r;
        float f4 = mPPointF2.f68793c * f3;
        float f5 = mPPointF2.f68794d * f3;
        MPPointF mPPointF3 = this.f68627q;
        float f6 = mPPointF3.f68793c + f4;
        mPPointF3.f68793c = f6;
        float f7 = mPPointF3.f68794d + f5;
        mPPointF3.f68794d = f7;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, f6, f7, 0);
        l(motionEventObtain, ((BarLineChartBase) this.f68635f).I() ? this.f68627q.f68793c - this.f68619i.f68793c : 0.0f, ((BarLineChartBase) this.f68635f).J() ? this.f68627q.f68794d - this.f68619i.f68794d : 0.0f);
        motionEventObtain.recycle();
        this.f68617g = ((BarLineChartBase) this.f68635f).getViewPortHandler().J(this.f68617g, this.f68635f, false);
        this.f68626p = jCurrentAnimationTimeMillis;
        if (Math.abs(this.f68628r.f68793c) >= 0.01d || Math.abs(this.f68628r.f68794d) >= 0.01d) {
            Utils.x(this.f68635f);
            return;
        }
        ((BarLineChartBase) this.f68635f).f();
        ((BarLineChartBase) this.f68635f).postInvalidate();
        q();
    }

    public MPPointF g(float f3, float f4) {
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.f68635f).getViewPortHandler();
        return MPPointF.c(f3 - viewPortHandler.G(), j() ? -(f4 - viewPortHandler.I()) : -((((BarLineChartBase) this.f68635f).getMeasuredHeight() - f4) - viewPortHandler.F()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f68631a = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.f68635f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.h(motionEvent);
        }
        if (((BarLineChartBase) this.f68635f).G() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.f68635f).getData()).h() > 0) {
            MPPointF mPPointFG = g(motionEvent.getX(), motionEvent.getY());
            Chart chart = this.f68635f;
            ((BarLineChartBase) chart).R(((BarLineChartBase) chart).N() ? 1.4f : 1.0f, ((BarLineChartBase) this.f68635f).O() ? 1.4f : 1.0f, mPPointFG.f68793c, mPPointFG.f68794d);
            if (((BarLineChartBase) this.f68635f).r()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + mPPointFG.f68793c + ", y: " + mPPointFG.f68794d);
            }
            MPPointF.f(mPPointFG);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        this.f68631a = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.f68635f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, motionEvent2, f3, f4);
        }
        return super.onFling(motionEvent, motionEvent2, f3, f4);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f68631a = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.f68635f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.g(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f68631a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.f68635f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (!((BarLineChartBase) this.f68635f).q()) {
            return false;
        }
        c(((BarLineChartBase) this.f68635f).k(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f68625o == null) {
            this.f68625o = VelocityTracker.obtain();
        }
        this.f68625o.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f68625o) != null) {
            velocityTracker.recycle();
            this.f68625o = null;
        }
        if (this.f68632b == 0) {
            this.f68634d.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.f68635f).H() && !((BarLineChartBase) this.f68635f).N() && !((BarLineChartBase) this.f68635f).O()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            e(motionEvent);
            q();
            o(motionEvent);
        } else if (action == 1) {
            VelocityTracker velocityTracker2 = this.f68625o;
            int pointerId = motionEvent.getPointerId(0);
            velocityTracker2.computeCurrentVelocity(1000, Utils.o());
            float yVelocity = velocityTracker2.getYVelocity(pointerId);
            float xVelocity = velocityTracker2.getXVelocity(pointerId);
            if ((Math.abs(xVelocity) > Utils.p() || Math.abs(yVelocity) > Utils.p()) && this.f68632b == 1 && ((BarLineChartBase) this.f68635f).o()) {
                q();
                this.f68626p = AnimationUtils.currentAnimationTimeMillis();
                this.f68627q.f68793c = motionEvent.getX();
                this.f68627q.f68794d = motionEvent.getY();
                MPPointF mPPointF = this.f68628r;
                mPPointF.f68793c = xVelocity;
                mPPointF.f68794d = yVelocity;
                Utils.x(this.f68635f);
            }
            int i3 = this.f68632b;
            if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
                ((BarLineChartBase) this.f68635f).f();
                ((BarLineChartBase) this.f68635f).postInvalidate();
            }
            this.f68632b = 0;
            ((BarLineChartBase) this.f68635f).j();
            VelocityTracker velocityTracker3 = this.f68625o;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f68625o = null;
            }
            b(motionEvent);
        } else if (action == 2) {
            int i4 = this.f68632b;
            if (i4 == 1) {
                ((BarLineChartBase) this.f68635f).g();
                l(motionEvent, ((BarLineChartBase) this.f68635f).I() ? motionEvent.getX() - this.f68619i.f68793c : 0.0f, ((BarLineChartBase) this.f68635f).J() ? motionEvent.getY() - this.f68619i.f68794d : 0.0f);
            } else if (i4 == 2 || i4 == 3 || i4 == 4) {
                ((BarLineChartBase) this.f68635f).g();
                if (((BarLineChartBase) this.f68635f).N() || ((BarLineChartBase) this.f68635f).O()) {
                    n(motionEvent);
                }
            } else if (i4 == 0 && Math.abs(ChartTouchListener.a(motionEvent.getX(), this.f68619i.f68793c, motionEvent.getY(), this.f68619i.f68794d)) > this.f68629s && ((BarLineChartBase) this.f68635f).H()) {
                if (!((BarLineChartBase) this.f68635f).K() || !((BarLineChartBase) this.f68635f).D()) {
                    float fAbs = Math.abs(motionEvent.getX() - this.f68619i.f68793c);
                    float fAbs2 = Math.abs(motionEvent.getY() - this.f68619i.f68794d);
                    if ((((BarLineChartBase) this.f68635f).I() || fAbs2 >= fAbs) && (((BarLineChartBase) this.f68635f).J() || fAbs2 <= fAbs)) {
                        this.f68631a = ChartTouchListener.ChartGesture.DRAG;
                        this.f68632b = 1;
                    }
                } else if (((BarLineChartBase) this.f68635f).L()) {
                    this.f68631a = ChartTouchListener.ChartGesture.DRAG;
                    if (((BarLineChartBase) this.f68635f).L()) {
                        m(motionEvent);
                    }
                }
            }
        } else if (action == 3) {
            this.f68632b = 0;
            b(motionEvent);
        } else if (action != 5) {
            if (action == 6) {
                Utils.z(motionEvent, this.f68625o);
                this.f68632b = 5;
            }
        } else if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.f68635f).g();
            o(motionEvent);
            this.f68621k = h(motionEvent);
            this.f68622l = i(motionEvent);
            float fP = p(motionEvent);
            this.f68623m = fP;
            if (fP > 10.0f) {
                if (((BarLineChartBase) this.f68635f).M()) {
                    this.f68632b = 4;
                } else if (((BarLineChartBase) this.f68635f).N() != ((BarLineChartBase) this.f68635f).O()) {
                    this.f68632b = ((BarLineChartBase) this.f68635f).N() ? 2 : 3;
                } else {
                    this.f68632b = this.f68621k > this.f68622l ? 2 : 3;
                }
            }
            k(this.f68620j, motionEvent);
        }
        this.f68617g = ((BarLineChartBase) this.f68635f).getViewPortHandler().J(this.f68617g, this.f68635f, true);
        return true;
    }

    public void q() {
        MPPointF mPPointF = this.f68628r;
        mPPointF.f68793c = 0.0f;
        mPPointF.f68794d = 0.0f;
    }
}
