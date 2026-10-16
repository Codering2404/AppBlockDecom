package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean D0;
    private StopLogic A;
    private View A0;
    private DecelerateInterpolator B;
    private Matrix B0;
    private DesignTool C;
    ArrayList C0;
    int D;
    int E;
    int F;
    int G;
    boolean H;
    float I;
    float J;
    long K;
    float L;
    private boolean M;
    private ArrayList N;
    private ArrayList O;
    private ArrayList P;
    private CopyOnWriteArrayList Q;
    private int R;
    private long S;
    private float T;
    private int U;
    private float V;
    boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MotionScene f32739a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected boolean f32740a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Interpolator f32741b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    int f32742b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Interpolator f32743c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    int f32744c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f32745d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    int f32746d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    int f32747e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32748f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    int f32749f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f32750g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    int f32751g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32752h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    float f32753h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32754i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private KeyCache f32755i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f32756j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private boolean f32757j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f32758k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private StateCache f32759k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    HashMap f32760l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private Runnable f32761l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f32762m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int[] f32763m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f32764n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    int f32765n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f32766o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private boolean f32767o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f32768p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    int f32769p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f32770q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    HashMap f32771q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f32772r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f32773r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f32774s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f32775s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    boolean f32776t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f32777t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TransitionListener f32778u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    Rect f32779u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f32780v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f32781v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f32782w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    TransitionState f32783w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f32784x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    Model f32785x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    DevModeDraw f32786y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private boolean f32787y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f32788z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private RectF f32789z0;

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MotionLayout f32791a;

        @Override // java.lang.Runnable
        public void run() {
            this.f32791a.f32767o0 = false;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32794a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f32794a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32794a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32794a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32794a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class DecelerateInterpolator extends MotionInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f32795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f32796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f32797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MotionLayout f32798d;

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float a() {
            return this.f32798d.f32745d;
        }

        public void b(float f3, float f4, float f5) {
            this.f32795a = f3;
            this.f32796b = f4;
            this.f32797c = f5;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4;
            float f5;
            float f6 = this.f32795a;
            if (f6 > 0.0f) {
                float f7 = this.f32797c;
                if (f6 / f7 < f3) {
                    f3 = f6 / f7;
                }
                this.f32798d.f32745d = f6 - (f7 * f3);
                f4 = (f6 * f3) - (((f7 * f3) * f3) / 2.0f);
                f5 = this.f32796b;
            } else {
                float f8 = this.f32797c;
                if ((-f6) / f8 < f3) {
                    f3 = (-f6) / f8;
                }
                this.f32798d.f32745d = (f8 * f3) + f6;
                f4 = (f6 * f3) + (((f8 * f3) * f3) / 2.0f);
                f5 = this.f32796b;
            }
            return f4 + f5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DevModeDraw {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f32799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int[] f32800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float[] f32801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Path f32802d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f32803e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Paint f32804f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Paint f32805g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Paint f32806h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Paint f32807i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float[] f32808j;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        DashPathEffect f32814p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f32815q;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f32818t;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f32809k = -21965;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f32810l = -2067046;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final int f32811m = -13391360;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final int f32812n = 1996488704;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final int f32813o = 10;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Rect f32816r = new Rect();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f32817s = false;

        public DevModeDraw() {
            this.f32818t = 1;
            Paint paint = new Paint();
            this.f32803e = paint;
            paint.setAntiAlias(true);
            this.f32803e.setColor(-21965);
            this.f32803e.setStrokeWidth(2.0f);
            Paint paint2 = this.f32803e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f32804f = paint3;
            paint3.setAntiAlias(true);
            this.f32804f.setColor(-2067046);
            this.f32804f.setStrokeWidth(2.0f);
            this.f32804f.setStyle(style);
            Paint paint4 = new Paint();
            this.f32805g = paint4;
            paint4.setAntiAlias(true);
            this.f32805g.setColor(-13391360);
            this.f32805g.setStrokeWidth(2.0f);
            this.f32805g.setStyle(style);
            Paint paint5 = new Paint();
            this.f32806h = paint5;
            paint5.setAntiAlias(true);
            this.f32806h.setColor(-13391360);
            this.f32806h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f32808j = new float[8];
            Paint paint6 = new Paint();
            this.f32807i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f32814p = dashPathEffect;
            this.f32805g.setPathEffect(dashPathEffect);
            this.f32801c = new float[100];
            this.f32800b = new int[50];
            if (this.f32817s) {
                this.f32803e.setStrokeWidth(8.0f);
                this.f32807i.setStrokeWidth(8.0f);
                this.f32804f.setStrokeWidth(8.0f);
                this.f32818t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f32799a, this.f32803e);
        }

        private void d(Canvas canvas) {
            boolean z2 = false;
            boolean z3 = false;
            for (int i3 = 0; i3 < this.f32815q; i3++) {
                int i4 = this.f32800b[i3];
                if (i4 == 1) {
                    z2 = true;
                }
                if (i4 == 0) {
                    z3 = true;
                }
            }
            if (z2) {
                g(canvas);
            }
            if (z3) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f32799a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f3, f5), Math.max(f4, f6), Math.max(f3, f5), Math.max(f4, f6), this.f32805g);
            canvas.drawLine(Math.min(f3, f5), Math.min(f4, f6), Math.min(f3, f5), Math.max(f4, f6), this.f32805g);
        }

        private void f(Canvas canvas, float f3, float f4) {
            float[] fArr = this.f32799a;
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            float fMin = Math.min(f5, f7);
            float fMax = Math.max(f6, f8);
            float fMin2 = f3 - Math.min(f5, f7);
            float fMax2 = Math.max(f6, f8) - f4;
            String str = "" + (((int) (((double) ((fMin2 * 100.0f) / Math.abs(f7 - f5))) + 0.5d)) / 100.0f);
            l(str, this.f32806h);
            canvas.drawText(str, ((fMin2 / 2.0f) - (this.f32816r.width() / 2)) + fMin, f4 - 20.0f, this.f32806h);
            canvas.drawLine(f3, f4, Math.min(f5, f7), f4, this.f32805g);
            String str2 = "" + (((int) (((double) ((fMax2 * 100.0f) / Math.abs(f8 - f6))) + 0.5d)) / 100.0f);
            l(str2, this.f32806h);
            canvas.drawText(str2, f3 + 5.0f, fMax - ((fMax2 / 2.0f) - (this.f32816r.height() / 2)), this.f32806h);
            canvas.drawLine(f3, f4, f3, Math.max(f6, f8), this.f32805g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f32799a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f32805g);
        }

        private void h(Canvas canvas, float f3, float f4) {
            float[] fArr = this.f32799a;
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[fArr.length - 2];
            float f8 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f5 - f7, f6 - f8);
            float f9 = f7 - f5;
            float f10 = f8 - f6;
            float f11 = (((f3 - f5) * f9) + ((f4 - f6) * f10)) / (fHypot * fHypot);
            float f12 = f5 + (f9 * f11);
            float f13 = f6 + (f11 * f10);
            Path path = new Path();
            path.moveTo(f3, f4);
            path.lineTo(f12, f13);
            float fHypot2 = (float) Math.hypot(f12 - f3, f13 - f4);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            l(str, this.f32806h);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f32816r.width() / 2), -20.0f, this.f32806h);
            canvas.drawLine(f3, f4, f12, f13, this.f32805g);
        }

        private void i(Canvas canvas, float f3, float f4, int i3, int i4) {
            String str = "" + (((int) (((double) (((f3 - (i3 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i3))) + 0.5d)) / 100.0f);
            l(str, this.f32806h);
            canvas.drawText(str, ((f3 / 2.0f) - (this.f32816r.width() / 2)) + 0.0f, f4 - 20.0f, this.f32806h);
            canvas.drawLine(f3, f4, Math.min(0.0f, 1.0f), f4, this.f32805g);
            String str2 = "" + (((int) (((double) (((f4 - (i4 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i4))) + 0.5d)) / 100.0f);
            l(str2, this.f32806h);
            canvas.drawText(str2, 5.0f + f3, 0.0f - ((f4 / 2.0f) - (this.f32816r.height() / 2)), this.f32806h);
            canvas.drawLine(f3, f4, f3, Math.max(0.0f, 1.0f), this.f32805g);
        }

        private void j(Canvas canvas, MotionController motionController) {
            this.f32802d.reset();
            for (int i3 = 0; i3 <= 50; i3++) {
                motionController.e(i3 / 50, this.f32808j, 0);
                Path path = this.f32802d;
                float[] fArr = this.f32808j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f32802d;
                float[] fArr2 = this.f32808j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f32802d;
                float[] fArr3 = this.f32808j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f32802d;
                float[] fArr4 = this.f32808j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f32802d.close();
            }
            this.f32803e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f32802d, this.f32803e);
            canvas.translate(-2.0f, -2.0f);
            this.f32803e.setColor(-65536);
            canvas.drawPath(this.f32802d, this.f32803e);
        }

        private void k(Canvas canvas, int i3, int i4, MotionController motionController) {
            int width;
            int height;
            View view = motionController.f32709b;
            if (view != null) {
                width = view.getWidth();
                height = motionController.f32709b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            for (int i5 = 1; i5 < i4 - 1; i5++) {
                if (i3 != 4 || this.f32800b[i5 - 1] != 0) {
                    float[] fArr = this.f32801c;
                    int i6 = i5 * 2;
                    float f3 = fArr[i6];
                    float f4 = fArr[i6 + 1];
                    this.f32802d.reset();
                    this.f32802d.moveTo(f3, f4 + 10.0f);
                    this.f32802d.lineTo(f3 + 10.0f, f4);
                    this.f32802d.lineTo(f3, f4 - 10.0f);
                    this.f32802d.lineTo(f3 - 10.0f, f4);
                    this.f32802d.close();
                    int i7 = i5 - 1;
                    motionController.q(i7);
                    if (i3 == 4) {
                        int i8 = this.f32800b[i7];
                        if (i8 == 1) {
                            h(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i8 == 0) {
                            f(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (i8 == 2) {
                            i(canvas, f3 - 0.0f, f4 - 0.0f, width, height);
                        }
                        canvas.drawPath(this.f32802d, this.f32807i);
                    }
                    if (i3 == 2) {
                        h(canvas, f3 - 0.0f, f4 - 0.0f);
                    }
                    if (i3 == 3) {
                        f(canvas, f3 - 0.0f, f4 - 0.0f);
                    }
                    if (i3 == 6) {
                        i(canvas, f3 - 0.0f, f4 - 0.0f, width, height);
                    }
                    canvas.drawPath(this.f32802d, this.f32807i);
                }
            }
            float[] fArr2 = this.f32799a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f32804f);
                float[] fArr3 = this.f32799a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f32804f);
            }
        }

        public void a(Canvas canvas, HashMap map, int i3, int i4) {
            if (map == null || map.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i4 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f32752h) + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f32806h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f32803e);
            }
            for (MotionController motionController : map.values()) {
                int iM = motionController.m();
                if (i4 > 0 && iM == 0) {
                    iM = 1;
                }
                if (iM != 0) {
                    this.f32815q = motionController.c(this.f32801c, this.f32800b);
                    if (iM >= 1) {
                        int i5 = i3 / 16;
                        float[] fArr = this.f32799a;
                        if (fArr == null || fArr.length != i5 * 2) {
                            this.f32799a = new float[i5 * 2];
                            this.f32802d = new Path();
                        }
                        int i6 = this.f32818t;
                        canvas.translate(i6, i6);
                        this.f32803e.setColor(1996488704);
                        this.f32807i.setColor(1996488704);
                        this.f32804f.setColor(1996488704);
                        this.f32805g.setColor(1996488704);
                        motionController.d(this.f32799a, i5);
                        b(canvas, iM, this.f32815q, motionController);
                        this.f32803e.setColor(-21965);
                        this.f32804f.setColor(-2067046);
                        this.f32807i.setColor(-2067046);
                        this.f32805g.setColor(-13391360);
                        int i7 = this.f32818t;
                        canvas.translate(-i7, -i7);
                        b(canvas, iM, this.f32815q, motionController);
                        if (iM == 5) {
                            j(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i3, int i4, MotionController motionController) {
            if (i3 == 4) {
                d(canvas);
            }
            if (i3 == 2) {
                g(canvas);
            }
            if (i3 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i3, i4, motionController);
        }

        void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f32816r);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Model {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintWidgetContainer f32820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ConstraintWidgetContainer f32821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ConstraintSet f32822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ConstraintSet f32823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f32824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f32825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MotionLayout f32826g;

        private void b(int i3, int i4) {
            int optimizationLevel = this.f32826g.getOptimizationLevel();
            MotionLayout motionLayout = this.f32826g;
            if (motionLayout.f32750g == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = this.f32826g;
                ConstraintWidgetContainer constraintWidgetContainer = this.f32821b;
                ConstraintSet constraintSet = this.f32823d;
                motionLayout2.resolveSystem(constraintWidgetContainer, optimizationLevel, (constraintSet == null || constraintSet.f33187d == 0) ? i3 : i4, (constraintSet == null || constraintSet.f33187d == 0) ? i4 : i3);
                ConstraintSet constraintSet2 = this.f32822c;
                if (constraintSet2 != null) {
                    MotionLayout motionLayout3 = this.f32826g;
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f32820a;
                    int i5 = constraintSet2.f33187d;
                    int i6 = i5 == 0 ? i3 : i4;
                    if (i5 == 0) {
                        i3 = i4;
                    }
                    motionLayout3.resolveSystem(constraintWidgetContainer2, optimizationLevel, i6, i3);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.f32822c;
            if (constraintSet3 != null) {
                MotionLayout motionLayout4 = this.f32826g;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f32820a;
                int i7 = constraintSet3.f33187d;
                motionLayout4.resolveSystem(constraintWidgetContainer3, optimizationLevel, i7 == 0 ? i3 : i4, i7 == 0 ? i4 : i3);
            }
            MotionLayout motionLayout5 = this.f32826g;
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f32821b;
            ConstraintSet constraintSet4 = this.f32823d;
            int i8 = (constraintSet4 == null || constraintSet4.f33187d == 0) ? i3 : i4;
            if (constraintSet4 == null || constraintSet4.f33187d == 0) {
                i3 = i4;
            }
            motionLayout5.resolveSystem(constraintWidgetContainer4, optimizationLevel, i8, i3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void j(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            int i3 = 0;
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(this.f32826g.getId(), constraintWidgetContainer);
            if (constraintSet != null && constraintSet.f33187d != 0) {
                MotionLayout motionLayout = this.f32826g;
                motionLayout.resolveSystem(this.f32821b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(this.f32826g.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f32826g.getWidth(), 1073741824));
            }
            ArrayList arrayListZ1 = constraintWidgetContainer.z1();
            int size = arrayListZ1.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayListZ1.get(i4);
                i4++;
                ConstraintWidget constraintWidget = (ConstraintWidget) obj;
                constraintWidget.G0(true);
                sparseArray.put(((View) constraintWidget.u()).getId(), constraintWidget);
            }
            ArrayList arrayListZ12 = constraintWidgetContainer.z1();
            int size2 = arrayListZ12.size();
            int i5 = 0;
            while (i5 < size2) {
                int i6 = i5 + 1;
                ConstraintWidget constraintWidget2 = (ConstraintWidget) arrayListZ12.get(i5);
                View view = (View) constraintWidget2.u();
                constraintSet.l(view.getId(), layoutParams);
                constraintWidget2.r1(constraintSet.E(view.getId()));
                constraintWidget2.S0(constraintSet.A(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.j((ConstraintHelper) view, constraintWidget2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).w();
                    }
                }
                layoutParams.resolveLayoutDirection(this.f32826g.getLayoutDirection());
                this.f32826g.applyConstraintsFromLayoutParams(false, view, constraintWidget2, layoutParams, sparseArray);
                if (constraintSet.D(view.getId()) == 1) {
                    constraintWidget2.q1(view.getVisibility());
                } else {
                    constraintWidget2.q1(constraintSet.C(view.getId()));
                }
                i5 = i6;
            }
            ArrayList arrayListZ13 = constraintWidgetContainer.z1();
            int size3 = arrayListZ13.size();
            while (i3 < size3) {
                Object obj2 = arrayListZ13.get(i3);
                i3++;
                ConstraintWidget constraintWidget3 = (ConstraintWidget) obj2;
                if (constraintWidget3 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) constraintWidget3.u();
                    Helper helper = (Helper) constraintWidget3;
                    constraintHelper.u(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).B1();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0133 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                Method dump skipped, instruction units count: 341
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Model.a():void");
        }

        void c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList arrayListZ1 = constraintWidgetContainer.z1();
            HashMap map = new HashMap();
            map.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.z1().clear();
            constraintWidgetContainer2.n(constraintWidgetContainer, map);
            int size = arrayListZ1.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayListZ1.get(i4);
                i4++;
                ConstraintWidget constraintWidget = (ConstraintWidget) obj;
                ConstraintWidget barrier = constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier ? new androidx.constraintlayout.core.widgets.Barrier() : constraintWidget instanceof Guideline ? new Guideline() : constraintWidget instanceof Flow ? new Flow() : constraintWidget instanceof Placeholder ? new Placeholder() : constraintWidget instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.a(barrier);
                map.put(constraintWidget, barrier);
            }
            int size2 = arrayListZ1.size();
            while (i3 < size2) {
                Object obj2 = arrayListZ1.get(i3);
                i3++;
                ConstraintWidget constraintWidget2 = (ConstraintWidget) obj2;
                ((ConstraintWidget) map.get(constraintWidget2)).n(constraintWidget2, map);
            }
        }

        ConstraintWidget d(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.u() == view) {
                return constraintWidgetContainer;
            }
            ArrayList arrayListZ1 = constraintWidgetContainer.z1();
            int size = arrayListZ1.size();
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i3);
                if (constraintWidget.u() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        void e(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f32822c = constraintSet;
            this.f32823d = constraintSet2;
            this.f32820a = new ConstraintWidgetContainer();
            this.f32821b = new ConstraintWidgetContainer();
            this.f32820a.e2(((ConstraintLayout) this.f32826g).mLayoutWidget.R1());
            this.f32821b.e2(((ConstraintLayout) this.f32826g).mLayoutWidget.R1());
            this.f32820a.C1();
            this.f32821b.C1();
            c(((ConstraintLayout) this.f32826g).mLayoutWidget, this.f32820a);
            c(((ConstraintLayout) this.f32826g).mLayoutWidget, this.f32821b);
            if (this.f32826g.f32768p > 0.5d) {
                if (constraintSet != null) {
                    j(this.f32820a, constraintSet);
                }
                j(this.f32821b, constraintSet2);
            } else {
                j(this.f32821b, constraintSet2);
                if (constraintSet != null) {
                    j(this.f32820a, constraintSet);
                }
            }
            this.f32820a.h2(this.f32826g.isRtl());
            this.f32820a.j2();
            this.f32821b.h2(this.f32826g.isRtl());
            this.f32821b.j2();
            ViewGroup.LayoutParams layoutParams = this.f32826g.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f32820a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.W0(dimensionBehaviour);
                    this.f32821b.W0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f32820a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.n1(dimensionBehaviour2);
                    this.f32821b.n1(dimensionBehaviour2);
                }
            }
        }

        public boolean f(int i3, int i4) {
            return (i3 == this.f32824e && i4 == this.f32825f) ? false : true;
        }

        public void g(int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            MotionLayout motionLayout = this.f32826g;
            motionLayout.f32749f0 = mode;
            motionLayout.f32751g0 = mode2;
            motionLayout.getOptimizationLevel();
            b(i3, i4);
            if (!(this.f32826g.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i3, i4);
                this.f32826g.f32742b0 = this.f32820a.a0();
                this.f32826g.f32744c0 = this.f32820a.z();
                this.f32826g.f32746d0 = this.f32821b.a0();
                this.f32826g.f32747e0 = this.f32821b.z();
                MotionLayout motionLayout2 = this.f32826g;
                motionLayout2.f32740a0 = (motionLayout2.f32742b0 == motionLayout2.f32746d0 && motionLayout2.f32744c0 == motionLayout2.f32747e0) ? false : true;
            }
            MotionLayout motionLayout3 = this.f32826g;
            int i5 = motionLayout3.f32742b0;
            int i6 = motionLayout3.f32744c0;
            int i7 = motionLayout3.f32749f0;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i5 = (int) (i5 + (motionLayout3.f32753h0 * (motionLayout3.f32746d0 - i5)));
            }
            int i8 = i5;
            int i9 = motionLayout3.f32751g0;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                i6 = (int) (i6 + (motionLayout3.f32753h0 * (motionLayout3.f32747e0 - i6)));
            }
            this.f32826g.resolveMeasuredDimension(i3, i4, i8, i6, this.f32820a.Z1() || this.f32821b.Z1(), this.f32820a.X1() || this.f32821b.X1());
        }

        public void h() {
            g(this.f32826g.f32754i, this.f32826g.f32756j);
            this.f32826g.i0();
        }

        public void i(int i3, int i4) {
            this.f32824e = i3;
            this.f32825f = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected interface MotionTracker {
        void a();

        void b(MotionEvent motionEvent);

        float c();

        float d();

        void e(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MyTracker implements MotionTracker {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static MyTracker f32827b = new MyTracker();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        VelocityTracker f32828a;

        private MyTracker() {
        }

        public static MyTracker f() {
            f32827b.f32828a = VelocityTracker.obtain();
            return f32827b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void a() {
            VelocityTracker velocityTracker = this.f32828a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f32828a = null;
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void b(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f32828a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float c() {
            VelocityTracker velocityTracker = this.f32828a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float d() {
            VelocityTracker velocityTracker = this.f32828a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void e(int i3) {
            VelocityTracker velocityTracker = this.f32828a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class StateCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f32829a = Float.NaN;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f32830b = Float.NaN;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f32831c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f32832d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final String f32833e = "motion.progress";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String f32834f = "motion.velocity";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final String f32835g = "motion.StartState";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final String f32836h = "motion.EndState";

        StateCache() {
        }

        void a() {
            int i3 = this.f32831c;
            if (i3 != -1 || this.f32832d != -1) {
                if (i3 == -1) {
                    MotionLayout.this.o0(this.f32832d);
                } else {
                    int i4 = this.f32832d;
                    if (i4 == -1) {
                        MotionLayout.this.setState(i3, -1, -1);
                    } else {
                        MotionLayout.this.h0(i3, i4);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f32830b)) {
                if (Float.isNaN(this.f32829a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f32829a);
            } else {
                MotionLayout.this.g0(this.f32829a, this.f32830b);
                this.f32829a = Float.NaN;
                this.f32830b = Float.NaN;
                this.f32831c = -1;
                this.f32832d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f32829a);
            bundle.putFloat("motion.velocity", this.f32830b);
            bundle.putInt("motion.StartState", this.f32831c);
            bundle.putInt("motion.EndState", this.f32832d);
            return bundle;
        }

        public void c() {
            this.f32832d = MotionLayout.this.f32752h;
            this.f32831c = MotionLayout.this.f32748f;
            this.f32830b = MotionLayout.this.getVelocity();
            this.f32829a = MotionLayout.this.getProgress();
        }

        public void d(int i3) {
            this.f32832d = i3;
        }

        public void e(float f3) {
            this.f32829a = f3;
        }

        public void f(int i3) {
            this.f32831c = i3;
        }

        public void g(Bundle bundle) {
            this.f32829a = bundle.getFloat("motion.progress");
            this.f32830b = bundle.getFloat("motion.velocity");
            this.f32831c = bundle.getInt("motion.StartState");
            this.f32832d = bundle.getInt("motion.EndState");
        }

        public void h(float f3) {
            this.f32830b = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TransitionListener {
        void a(MotionLayout motionLayout, int i3, int i4, float f3);

        void b(MotionLayout motionLayout, int i3);

        void c(MotionLayout motionLayout, int i3, int i4);

        void d(MotionLayout motionLayout, int i3, boolean z2, float f3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private boolean N(View view, MotionEvent motionEvent, float f3, float f4) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f3, f4);
            boolean zOnTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f3, -f4);
            return zOnTouchEvent;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(f3, f4);
        if (this.B0 == null) {
            this.B0 = new Matrix();
        }
        matrix.invert(this.B0);
        motionEventObtain.transform(this.B0);
        boolean zOnTouchEvent2 = view.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
        return zOnTouchEvent2;
    }

    private void O() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MotionController motionController = (MotionController) this.f32760l.get(childAt);
            if (motionController != null) {
                motionController.E(childAt);
            }
        }
    }

    private void R() {
        boolean z2;
        float fSignum = Math.signum(this.f32772r - this.f32768p);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f32741b;
        float interpolation = this.f32768p + (!(interpolator instanceof StopLogic) ? (((nanoTime - this.f32770q) * fSignum) * 1.0E-9f) / this.f32764n : 0.0f);
        if (this.f32774s) {
            interpolation = this.f32772r;
        }
        if ((fSignum <= 0.0f || interpolation < this.f32772r) && (fSignum > 0.0f || interpolation > this.f32772r)) {
            z2 = false;
        } else {
            interpolation = this.f32772r;
            z2 = true;
        }
        if (interpolator != null && !z2) {
            interpolation = this.f32788z ? interpolator.getInterpolation((nanoTime - this.f32762m) * 1.0E-9f) : interpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.f32772r) || (fSignum <= 0.0f && interpolation <= this.f32772r)) {
            interpolation = this.f32772r;
        }
        this.f32753h0 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f32743c;
        if (interpolator2 != null) {
            interpolation = interpolator2.getInterpolation(interpolation);
        }
        float f3 = interpolation;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            MotionController motionController = (MotionController) this.f32760l.get(childAt);
            if (motionController != null) {
                motionController.x(childAt, f3, nanoTime2, this.f32755i0);
            }
        }
        if (this.f32740a0) {
            requestLayout();
        }
    }

    private void S() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f32778u == null && ((copyOnWriteArrayList = this.Q) == null || copyOnWriteArrayList.isEmpty())) || this.V == this.f32766o) {
            return;
        }
        if (this.U != -1) {
            TransitionListener transitionListener = this.f32778u;
            if (transitionListener != null) {
                transitionListener.c(this, this.f32748f, this.f32752h);
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.Q;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((TransitionListener) it.next()).c(this, this.f32748f, this.f32752h);
                }
            }
            this.W = true;
        }
        this.U = -1;
        float f3 = this.f32766o;
        this.V = f3;
        TransitionListener transitionListener2 = this.f32778u;
        if (transitionListener2 != null) {
            transitionListener2.a(this, this.f32748f, this.f32752h, f3);
        }
        CopyOnWriteArrayList copyOnWriteArrayList3 = this.Q;
        if (copyOnWriteArrayList3 != null) {
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((TransitionListener) it2.next()).a(this, this.f32748f, this.f32752h, this.f32766o);
            }
        }
        this.W = true;
    }

    private boolean a0(float f3, float f4, View view, MotionEvent motionEvent) {
        boolean z2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (a0((r3.getLeft() + f3) - view.getScrollX(), (r3.getTop() + f4) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.f32789z0.set(f3, f4, (view.getRight() + f3) - view.getLeft(), (view.getBottom() + f4) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.f32789z0.contains(motionEvent.getX(), motionEvent.getY())) && N(view, motionEvent, -f3, -f4)) {
                return true;
            }
        }
        return z2;
    }

    private void e0() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.f32778u == null && ((copyOnWriteArrayList = this.Q) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        int i3 = 0;
        this.W = false;
        ArrayList arrayList = this.C0;
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Integer num = (Integer) obj;
            TransitionListener transitionListener = this.f32778u;
            if (transitionListener != null) {
                transitionListener.b(this, num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.Q;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((TransitionListener) it.next()).b(this, num.intValue());
                }
            }
        }
        this.C0.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        int childCount = getChildCount();
        this.f32785x0.a();
        this.f32776t = true;
        SparseArray sparseArray = new SparseArray();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            sparseArray.put(childAt.getId(), (MotionController) this.f32760l.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int iJ = this.f32739a.j();
        if (iJ != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                MotionController motionController = (MotionController) this.f32760l.get(getChildAt(i5));
                if (motionController != null) {
                    motionController.D(iJ);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f32760l.size()];
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            MotionController motionController2 = (MotionController) this.f32760l.get(getChildAt(i7));
            if (motionController2.h() != -1) {
                sparseBooleanArray.put(motionController2.h(), true);
                iArr[i6] = motionController2.h();
                i6++;
            }
        }
        if (this.P != null) {
            for (int i8 = 0; i8 < i6; i8++) {
                MotionController motionController3 = (MotionController) this.f32760l.get(findViewById(iArr[i8]));
                if (motionController3 != null) {
                    this.f32739a.t(motionController3);
                }
            }
            ArrayList arrayList = this.P;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                ((MotionHelper) obj).D(this, this.f32760l);
            }
            for (int i10 = 0; i10 < i6; i10++) {
                MotionController motionController4 = (MotionController) this.f32760l.get(findViewById(iArr[i10]));
                if (motionController4 != null) {
                    motionController4.I(width, height, this.f32764n, getNanoTime());
                }
            }
        } else {
            for (int i11 = 0; i11 < i6; i11++) {
                MotionController motionController5 = (MotionController) this.f32760l.get(findViewById(iArr[i11]));
                if (motionController5 != null) {
                    this.f32739a.t(motionController5);
                    motionController5.I(width, height, this.f32764n, getNanoTime());
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            MotionController motionController6 = (MotionController) this.f32760l.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.f32739a.t(motionController6);
                motionController6.I(width, height, this.f32764n, getNanoTime());
            }
        }
        float fE = this.f32739a.E();
        if (fE != 0.0f) {
            boolean z2 = ((double) fE) < 0.0d;
            float fAbs = Math.abs(fE);
            float fMax = -3.4028235E38f;
            float fMin = Float.MAX_VALUE;
            float fMax2 = -3.4028235E38f;
            float fMin2 = Float.MAX_VALUE;
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController7 = (MotionController) this.f32760l.get(getChildAt(i13));
                if (!Float.isNaN(motionController7.f32720m)) {
                    for (int i14 = 0; i14 < childCount; i14++) {
                        MotionController motionController8 = (MotionController) this.f32760l.get(getChildAt(i14));
                        if (!Float.isNaN(motionController8.f32720m)) {
                            fMin = Math.min(fMin, motionController8.f32720m);
                            fMax = Math.max(fMax, motionController8.f32720m);
                        }
                    }
                    while (i3 < childCount) {
                        MotionController motionController9 = (MotionController) this.f32760l.get(getChildAt(i3));
                        if (!Float.isNaN(motionController9.f32720m)) {
                            motionController9.f32722o = 1.0f / (1.0f - fAbs);
                            if (z2) {
                                motionController9.f32721n = fAbs - (((fMax - motionController9.f32720m) / (fMax - fMin)) * fAbs);
                            } else {
                                motionController9.f32721n = fAbs - (((motionController9.f32720m - fMin) * fAbs) / (fMax - fMin));
                            }
                        }
                        i3++;
                    }
                    return;
                }
                float fN = motionController7.n();
                float fO = motionController7.o();
                float f3 = z2 ? fO - fN : fO + fN;
                fMin2 = Math.min(fMin2, f3);
                fMax2 = Math.max(fMax2, f3);
            }
            while (i3 < childCount) {
                MotionController motionController10 = (MotionController) this.f32760l.get(getChildAt(i3));
                float fN2 = motionController10.n();
                float fO2 = motionController10.o();
                float f4 = z2 ? fO2 - fN2 : fO2 + fN2;
                motionController10.f32722o = 1.0f / (1.0f - fAbs);
                motionController10.f32721n = fAbs - (((f4 - fMin2) * fAbs) / (fMax2 - fMin2));
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect j0(ConstraintWidget constraintWidget) {
        this.f32779u0.top = constraintWidget.c0();
        this.f32779u0.left = constraintWidget.b0();
        Rect rect = this.f32779u0;
        int iA0 = constraintWidget.a0();
        Rect rect2 = this.f32779u0;
        rect.right = iA0 + rect2.left;
        int iZ = constraintWidget.z();
        Rect rect3 = this.f32779u0;
        rect2.bottom = iZ + rect3.top;
        return rect3;
    }

    private static boolean v0(float f3, float f4, float f5) {
        if (f3 > 0.0f) {
            float f6 = f3 / f5;
            return f4 + ((f3 * f6) - (((f5 * f6) * f6) / 2.0f)) > 1.0f;
        }
        float f7 = (-f3) / f5;
        return f4 + ((f3 * f7) + (((f5 * f7) * f7) / 2.0f)) < 0.0f;
    }

    void L(float f3) {
        if (this.f32739a == null) {
            return;
        }
        float f4 = this.f32768p;
        float f5 = this.f32766o;
        if (f4 != f5 && this.f32774s) {
            this.f32768p = f5;
        }
        float f6 = this.f32768p;
        if (f6 == f3) {
            return;
        }
        this.f32788z = false;
        this.f32772r = f3;
        this.f32764n = r0.p() / 1000.0f;
        setProgress(this.f32772r);
        this.f32741b = null;
        this.f32743c = this.f32739a.s();
        this.f32774s = false;
        this.f32762m = getNanoTime();
        this.f32776t = true;
        this.f32766o = f6;
        this.f32768p = f6;
        invalidate();
    }

    public boolean M(int i3, MotionController motionController) {
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            return motionScene.g(i3, motionController);
        }
        return false;
    }

    void P(boolean z2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            MotionController motionController = (MotionController) this.f32760l.get(getChildAt(i3));
            if (motionController != null) {
                motionController.f(z2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[PHI: r3
      0x00e2: PHI (r3v50 float) = (r3v49 float), (r3v51 float), (r3v51 float) binds: [B:47:0x00ae, B:58:0x00d6, B:60:0x00da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void Q(boolean r21) {
        /*
            Method dump skipped, instruction units count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.Q(boolean):void");
    }

    protected void T() {
        int iIntValue;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f32778u != null || ((copyOnWriteArrayList = this.Q) != null && !copyOnWriteArrayList.isEmpty())) && this.U == -1) {
            this.U = this.f32750g;
            if (this.C0.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList arrayList = this.C0;
                iIntValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            int i3 = this.f32750g;
            if (iIntValue != i3 && i3 != -1) {
                this.C0.add(Integer.valueOf(i3));
            }
        }
        e0();
        Runnable runnable = this.f32761l0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f32763m0;
        if (iArr == null || this.f32765n0 <= 0) {
            return;
        }
        o0(iArr[0]);
        int[] iArr2 = this.f32763m0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f32765n0--;
    }

    public void U(int i3, boolean z2, float f3) {
        TransitionListener transitionListener = this.f32778u;
        if (transitionListener != null) {
            transitionListener.d(this, i3, z2, f3);
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.Q;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TransitionListener) it.next()).d(this, i3, z2, f3);
            }
        }
    }

    void V(int i3, float f3, float f4, float f5, float[] fArr) {
        String resourceName;
        HashMap map = this.f32760l;
        View viewById = getViewById(i3);
        MotionController motionController = (MotionController) map.get(viewById);
        if (motionController != null) {
            motionController.l(f3, f4, f5, fArr);
            float y2 = viewById.getY();
            this.f32780v = f3;
            this.f32782w = y2;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i3;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i3);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    public ConstraintSet W(int i3) {
        MotionScene motionScene = this.f32739a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.l(i3);
    }

    MotionController X(int i3) {
        return (MotionController) this.f32760l.get(findViewById(i3));
    }

    public MotionScene.Transition Y(int i3) {
        return this.f32739a.G(i3);
    }

    public void Z(View view, float f3, float f4, float[] fArr, int i3) {
        float interpolation;
        float[] fArr2;
        float fA = this.f32745d;
        float f5 = this.f32768p;
        if (this.f32741b != null) {
            float fSignum = Math.signum(this.f32772r - f5);
            float interpolation2 = this.f32741b.getInterpolation(this.f32768p + 1.0E-5f);
            interpolation = this.f32741b.getInterpolation(this.f32768p);
            fA = (fSignum * ((interpolation2 - interpolation) / 1.0E-5f)) / this.f32764n;
        } else {
            interpolation = f5;
        }
        Interpolator interpolator = this.f32741b;
        if (interpolator instanceof MotionInterpolator) {
            fA = ((MotionInterpolator) interpolator).a();
        }
        MotionController motionController = (MotionController) this.f32760l.get(view);
        if ((i3 & 1) == 0) {
            fArr2 = fArr;
            motionController.r(interpolation, view.getWidth(), view.getHeight(), f3, f4, fArr2);
        } else {
            fArr2 = fArr;
            motionController.l(interpolation, f3, f4, fArr2);
        }
        if (i3 < 2) {
            fArr2[0] = fArr2[0] * fA;
            fArr2[1] = fArr2[1] * fA;
        }
    }

    public boolean b0() {
        return this.f32758k;
    }

    protected MotionTracker c0() {
        return MyTracker.f();
    }

    void d0() {
        MotionScene motionScene = this.f32739a;
        if (motionScene == null) {
            return;
        }
        if (motionScene.h(this, this.f32750g)) {
            requestLayout();
            return;
        }
        int i3 = this.f32750g;
        if (i3 != -1) {
            this.f32739a.f(this, i3);
        }
        if (this.f32739a.b0()) {
            this.f32739a.Z();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        ViewTransitionController viewTransitionController;
        ArrayList arrayList = this.P;
        int i3 = 0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                ((MotionHelper) obj).C(canvas);
            }
        }
        Q(false);
        MotionScene motionScene = this.f32739a;
        if (motionScene != null && (viewTransitionController = motionScene.f32881s) != null) {
            viewTransitionController.c();
        }
        super.dispatchDraw(canvas);
        if (this.f32739a == null) {
            return;
        }
        if ((this.f32784x & 1) == 1 && !isInEditMode()) {
            this.R++;
            long nanoTime = getNanoTime();
            long j3 = this.S;
            if (j3 != -1) {
                if (nanoTime - j3 > 200000000) {
                    this.T = ((int) ((this.R / (r5 * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.R = 0;
                    this.S = nanoTime;
                }
            } else {
                this.S = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.T + " fps " + Debug.e(this, this.f32748f) + " -> ";
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(Debug.e(this, this.f32752h));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i5 = this.f32750g;
            sb.append(i5 == -1 ? "undefined" : Debug.e(this, i5));
            String string = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(string, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(string, 10.0f, getHeight() - 30, paint);
        }
        if (this.f32784x > 1) {
            if (this.f32786y == null) {
                this.f32786y = new DevModeDraw();
            }
            this.f32786y.a(canvas, this.f32760l, this.f32739a.p(), this.f32784x);
        }
        ArrayList arrayList2 = this.P;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                ((MotionHelper) obj2).B(canvas);
            }
        }
    }

    public void f0() {
        this.f32785x0.h();
        invalidate();
    }

    public void g0(float f3, float f4) {
        if (!isAttachedToWindow()) {
            if (this.f32759k0 == null) {
                this.f32759k0 = new StateCache();
            }
            this.f32759k0.e(f3);
            this.f32759k0.h(f4);
            return;
        }
        setProgress(f3);
        setState(TransitionState.MOVING);
        this.f32745d = f4;
        if (f4 != 0.0f) {
            L(f4 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f3 == 0.0f || f3 == 1.0f) {
                return;
            }
            L(f3 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.f32739a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.n();
    }

    public int getCurrentState() {
        return this.f32750g;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.f32739a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.o();
    }

    public DesignTool getDesignTool() {
        if (this.C == null) {
            this.C = new DesignTool(this);
        }
        return this.C;
    }

    public int getEndState() {
        return this.f32752h;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f32768p;
    }

    public MotionScene getScene() {
        return this.f32739a;
    }

    public int getStartState() {
        return this.f32748f;
    }

    public float getTargetPosition() {
        return this.f32772r;
    }

    public Bundle getTransitionState() {
        if (this.f32759k0 == null) {
            this.f32759k0 = new StateCache();
        }
        this.f32759k0.c();
        return this.f32759k0.b();
    }

    public long getTransitionTimeMs() {
        if (this.f32739a != null) {
            this.f32764n = r0.p() / 1000.0f;
        }
        return (long) (this.f32764n * 1000.0f);
    }

    public float getVelocity() {
        return this.f32745d;
    }

    public void h0(int i3, int i4) {
        if (!isAttachedToWindow()) {
            if (this.f32759k0 == null) {
                this.f32759k0 = new StateCache();
            }
            this.f32759k0.f(i3);
            this.f32759k0.d(i4);
            return;
        }
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            this.f32748f = i3;
            this.f32752h = i4;
            motionScene.X(i3, i4);
            this.f32785x0.e(this.mLayoutWidget, this.f32739a.l(i3), this.f32739a.l(i4));
            f0();
            this.f32768p = 0.0f;
            n0();
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void j(View view, View view2, int i3, int i4) {
        this.K = getNanoTime();
        this.L = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void k(View view, int i3) {
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            float f3 = this.L;
            if (f3 == 0.0f) {
                return;
            }
            motionScene.Q(this.I / f3, this.J / f3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k0(int r10, float r11, float r12) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.k0(int, float, float):void");
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void l(final View view, int i3, int i4, int[] iArr, int i5) {
        MotionScene.Transition transition;
        TouchResponse touchResponseB;
        int iQ;
        MotionScene motionScene = this.f32739a;
        if (motionScene == null || (transition = motionScene.f32865c) == null || !transition.C()) {
            return;
        }
        int i6 = -1;
        if (!transition.C() || (touchResponseB = transition.B()) == null || (iQ = touchResponseB.q()) == -1 || view.getId() == iQ) {
            if (motionScene.w()) {
                TouchResponse touchResponseB2 = transition.B();
                if (touchResponseB2 != null && (touchResponseB2.e() & 4) != 0) {
                    i6 = i4;
                }
                float f3 = this.f32766o;
                if ((f3 == 1.0f || f3 == 0.0f) && view.canScrollVertically(i6)) {
                    return;
                }
            }
            if (transition.B() != null && (transition.B().e() & 1) != 0) {
                float fX = motionScene.x(i3, i4);
                float f4 = this.f32768p;
                if ((f4 <= 0.0f && fX < 0.0f) || (f4 >= 1.0f && fX > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable(this) { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f5 = this.f32766o;
            long nanoTime = getNanoTime();
            float f6 = i3;
            this.I = f6;
            float f7 = i4;
            this.J = f7;
            this.L = (float) ((nanoTime - this.K) * 1.0E-9d);
            this.K = nanoTime;
            motionScene.P(f6, f7);
            if (f5 != this.f32766o) {
                iArr[0] = i3;
                iArr[1] = i4;
            }
            Q(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.H = true;
        }
    }

    public void l0() {
        L(1.0f);
        this.f32761l0 = null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i3) {
        MotionScene.Transition transition;
        if (i3 == 0) {
            this.f32739a = null;
            return;
        }
        try {
            MotionScene motionScene = new MotionScene(getContext(), this, i3);
            this.f32739a = motionScene;
            if (this.f32750g == -1) {
                this.f32750g = motionScene.F();
                this.f32748f = this.f32739a.F();
                this.f32752h = this.f32739a.q();
            }
            if (!isAttachedToWindow()) {
                this.f32739a = null;
                return;
            }
            try {
                Display display = getDisplay();
                int i4 = 0;
                this.f32777t0 = display == null ? 0 : display.getRotation();
                MotionScene motionScene2 = this.f32739a;
                if (motionScene2 != null) {
                    ConstraintSet constraintSetL = motionScene2.l(this.f32750g);
                    this.f32739a.T(this);
                    ArrayList arrayList = this.P;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        while (i4 < size) {
                            Object obj = arrayList.get(i4);
                            i4++;
                            ((MotionHelper) obj).A(this);
                        }
                    }
                    if (constraintSetL != null) {
                        constraintSetL.i(this);
                    }
                    this.f32748f = this.f32750g;
                }
                d0();
                StateCache stateCache = this.f32759k0;
                if (stateCache != null) {
                    if (this.f32781v0) {
                        post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MotionLayout.this.f32759k0.a();
                            }
                        });
                        return;
                    } else {
                        stateCache.a();
                        return;
                    }
                }
                MotionScene motionScene3 = this.f32739a;
                if (motionScene3 == null || (transition = motionScene3.f32865c) == null || transition.x() != 4) {
                    return;
                }
                l0();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e3) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e3);
            }
        } catch (Exception e4) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e4);
        }
    }

    public void m0(Runnable runnable) {
        L(1.0f);
        this.f32761l0 = runnable;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void n(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (this.H || i3 != 0 || i4 != 0) {
            iArr[0] = iArr[0] + i5;
            iArr[1] = iArr[1] + i6;
        }
        this.H = false;
    }

    public void n0() {
        L(0.0f);
    }

    public void o0(int i3) {
        if (isAttachedToWindow()) {
            q0(i3, -1, -1);
            return;
        }
        if (this.f32759k0 == null) {
            this.f32759k0 = new StateCache();
        }
        this.f32759k0.d(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        MotionScene.Transition transition;
        int i3;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f32777t0 = display.getRotation();
        }
        MotionScene motionScene = this.f32739a;
        if (motionScene != null && (i3 = this.f32750g) != -1) {
            ConstraintSet constraintSetL = motionScene.l(i3);
            this.f32739a.T(this);
            ArrayList arrayList = this.P;
            if (arrayList != null) {
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    ((MotionHelper) obj).A(this);
                }
            }
            if (constraintSetL != null) {
                constraintSetL.i(this);
            }
            this.f32748f = this.f32750g;
        }
        d0();
        StateCache stateCache = this.f32759k0;
        if (stateCache != null) {
            if (this.f32781v0) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.f32759k0.a();
                    }
                });
                return;
            } else {
                stateCache.a();
                return;
            }
        }
        MotionScene motionScene2 = this.f32739a;
        if (motionScene2 == null || (transition = motionScene2.f32865c) == null || transition.x() != 4) {
            return;
        }
        l0();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponseB;
        int iQ;
        RectF rectFP;
        MotionScene motionScene = this.f32739a;
        if (motionScene != null && this.f32758k) {
            ViewTransitionController viewTransitionController = motionScene.f32881s;
            if (viewTransitionController != null) {
                viewTransitionController.h(motionEvent);
            }
            MotionScene.Transition transition = this.f32739a.f32865c;
            if (transition != null && transition.C() && (touchResponseB = transition.B()) != null && ((motionEvent.getAction() != 0 || (rectFP = touchResponseB.p(this, new RectF())) == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) && (iQ = touchResponseB.q()) != -1)) {
                View view = this.A0;
                if (view == null || view.getId() != iQ) {
                    this.A0 = findViewById(iQ);
                }
                if (this.A0 != null) {
                    this.f32789z0.set(r0.getLeft(), this.A0.getTop(), this.A0.getRight(), this.A0.getBottom());
                    if (this.f32789z0.contains(motionEvent.getX(), motionEvent.getY()) && !a0(this.A0.getLeft(), this.A0.getTop(), this.A0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) throws Throwable {
        MotionLayout motionLayout;
        this.f32757j0 = true;
        try {
            if (this.f32739a == null) {
                super.onLayout(z2, i3, i4, i5, i6);
                this.f32757j0 = false;
                return;
            }
            motionLayout = this;
            int i7 = i5 - i3;
            int i8 = i6 - i4;
            try {
                if (motionLayout.F != i7 || motionLayout.G != i8) {
                    f0();
                    Q(true);
                }
                motionLayout.F = i7;
                motionLayout.G = i8;
                motionLayout.D = i7;
                motionLayout.E = i8;
                motionLayout.f32757j0 = false;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            motionLayout = this;
        }
        Throwable th3 = th;
        motionLayout.f32757j0 = false;
        throw th3;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f32739a == null) {
            super.onMeasure(i3, i4);
            return;
        }
        boolean z2 = false;
        boolean z3 = (this.f32754i == i3 && this.f32756j == i4) ? false : true;
        if (this.f32787y0) {
            this.f32787y0 = false;
            d0();
            e0();
            z3 = true;
        }
        if (this.mDirtyHierarchy) {
            z3 = true;
        }
        this.f32754i = i3;
        this.f32756j = i4;
        int iF = this.f32739a.F();
        int iQ = this.f32739a.q();
        if ((z3 || this.f32785x0.f(iF, iQ)) && this.f32748f != -1) {
            super.onMeasure(i3, i4);
            this.f32785x0.e(this.mLayoutWidget, this.f32739a.l(iF), this.f32739a.l(iQ));
            this.f32785x0.h();
            this.f32785x0.i(iF, iQ);
        } else {
            if (z3) {
                super.onMeasure(i3, i4);
            }
            z2 = true;
        }
        if (this.f32740a0 || z2) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int iA0 = this.mLayoutWidget.a0() + getPaddingLeft() + getPaddingRight();
            int iZ = this.mLayoutWidget.z() + paddingTop;
            int i5 = this.f32749f0;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                iA0 = (int) (this.f32742b0 + (this.f32753h0 * (this.f32746d0 - r8)));
                requestLayout();
            }
            int i6 = this.f32751g0;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                iZ = (int) (this.f32744c0 + (this.f32753h0 * (this.f32747e0 - r8)));
                requestLayout();
            }
            setMeasuredDimension(iA0, iZ);
        }
        R();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f3, float f4, boolean z2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f3, float f4) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            motionScene.W(isRtl());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.f32739a;
        if (motionScene == null || !this.f32758k || !motionScene.b0()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.f32739a.f32865c;
        if (transition != null && !transition.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f32739a.R(motionEvent, getCurrentState(), this);
        if (this.f32739a.f32865c.D(4)) {
            return this.f32739a.f32865c.B().r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.Q == null) {
                this.Q = new CopyOnWriteArrayList();
            }
            this.Q.add(motionHelper);
            if (motionHelper.z()) {
                if (this.N == null) {
                    this.N = new ArrayList();
                }
                this.N.add(motionHelper);
            }
            if (motionHelper.y()) {
                if (this.O == null) {
                    this.O = new ArrayList();
                }
                this.O.add(motionHelper);
            }
            if (motionHelper.x()) {
                if (this.P == null) {
                    this.P = new ArrayList();
                }
                this.P.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.N;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.O;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean p(View view, View view2, int i3, int i4) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.f32739a;
        return (motionScene == null || (transition = motionScene.f32865c) == null || transition.B() == null || (this.f32739a.f32865c.B().e() & 2) != 0) ? false : true;
    }

    public void p0(int i3, int i4) {
        if (isAttachedToWindow()) {
            r0(i3, -1, -1, i4);
            return;
        }
        if (this.f32759k0 == null) {
            this.f32759k0 = new StateCache();
        }
        this.f32759k0.d(i3);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i3) {
        this.mConstraintLayoutSpec = null;
    }

    public void q0(int i3, int i4, int i5) {
        r0(i3, i4, i5, -1);
    }

    public void r0(int i3, int i4, int i5, int i6) {
        StateSet stateSet;
        int iA;
        MotionScene motionScene = this.f32739a;
        if (motionScene != null && (stateSet = motionScene.f32864b) != null && (iA = stateSet.a(this.f32750g, i3, i4, i5)) != -1) {
            i3 = iA;
        }
        int i7 = this.f32750g;
        if (i7 == i3) {
            return;
        }
        if (this.f32748f == i3) {
            L(0.0f);
            if (i6 > 0) {
                this.f32764n = i6 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f32752h == i3) {
            L(1.0f);
            if (i6 > 0) {
                this.f32764n = i6 / 1000.0f;
                return;
            }
            return;
        }
        this.f32752h = i3;
        if (i7 != -1) {
            h0(i7, i3);
            L(1.0f);
            this.f32768p = 0.0f;
            l0();
            if (i6 > 0) {
                this.f32764n = i6 / 1000.0f;
                return;
            }
            return;
        }
        this.f32788z = false;
        this.f32772r = 1.0f;
        this.f32766o = 0.0f;
        this.f32768p = 0.0f;
        this.f32770q = getNanoTime();
        this.f32762m = getNanoTime();
        this.f32774s = false;
        this.f32741b = null;
        if (i6 == -1) {
            this.f32764n = this.f32739a.p() / 1000.0f;
        }
        this.f32748f = -1;
        this.f32739a.X(-1, this.f32752h);
        SparseArray sparseArray = new SparseArray();
        if (i6 == 0) {
            this.f32764n = this.f32739a.p() / 1000.0f;
        } else if (i6 > 0) {
            this.f32764n = i6 / 1000.0f;
        }
        int childCount = getChildCount();
        this.f32760l.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            this.f32760l.put(childAt, new MotionController(childAt));
            sparseArray.put(childAt.getId(), (MotionController) this.f32760l.get(childAt));
        }
        this.f32776t = true;
        this.f32785x0.e(this.mLayoutWidget, null, this.f32739a.l(i3));
        f0();
        this.f32785x0.a();
        O();
        int width = getWidth();
        int height = getHeight();
        if (this.P != null) {
            for (int i9 = 0; i9 < childCount; i9++) {
                MotionController motionController = (MotionController) this.f32760l.get(getChildAt(i9));
                if (motionController != null) {
                    this.f32739a.t(motionController);
                }
            }
            ArrayList arrayList = this.P;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                ((MotionHelper) obj).D(this, this.f32760l);
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController2 = (MotionController) this.f32760l.get(getChildAt(i11));
                if (motionController2 != null) {
                    motionController2.I(width, height, this.f32764n, getNanoTime());
                }
            }
        } else {
            for (int i12 = 0; i12 < childCount; i12++) {
                MotionController motionController3 = (MotionController) this.f32760l.get(getChildAt(i12));
                if (motionController3 != null) {
                    this.f32739a.t(motionController3);
                    motionController3.I(width, height, this.f32764n, getNanoTime());
                }
            }
        }
        float fE = this.f32739a.E();
        if (fE != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController4 = (MotionController) this.f32760l.get(getChildAt(i13));
                float fO = motionController4.o() + motionController4.n();
                fMin = Math.min(fMin, fO);
                fMax = Math.max(fMax, fO);
            }
            for (int i14 = 0; i14 < childCount; i14++) {
                MotionController motionController5 = (MotionController) this.f32760l.get(getChildAt(i14));
                float fN = motionController5.n();
                float fO2 = motionController5.o();
                motionController5.f32722o = 1.0f / (1.0f - fE);
                motionController5.f32721n = fE - ((((fN + fO2) - fMin) * fE) / (fMax - fMin));
            }
        }
        this.f32766o = 0.0f;
        this.f32768p = 0.0f;
        this.f32776t = true;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.f32740a0 && this.f32750g == -1 && (motionScene = this.f32739a) != null && (transition = motionScene.f32865c) != null) {
            int iZ = transition.z();
            if (iZ == 0) {
                return;
            }
            if (iZ == 2) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    ((MotionController) this.f32760l.get(getChildAt(i3))).z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void s0() {
        this.f32785x0.e(this.mLayoutWidget, this.f32739a.l(this.f32748f), this.f32739a.l(this.f32752h));
        f0();
    }

    public void setDebugMode(int i3) {
        this.f32784x = i3;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z2) {
        this.f32781v0 = z2;
    }

    public void setInteractionEnabled(boolean z2) {
        this.f32758k = z2;
    }

    public void setInterpolatedProgress(float f3) {
        if (this.f32739a != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolatorS = this.f32739a.s();
            if (interpolatorS != null) {
                setProgress(interpolatorS.getInterpolation(f3));
                return;
            }
        }
        setProgress(f3);
    }

    public void setOnHide(float f3) {
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((MotionHelper) this.O.get(i3)).setProgress(f3);
            }
        }
    }

    public void setOnShow(float f3) {
        ArrayList arrayList = this.N;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((MotionHelper) this.N.get(i3)).setProgress(f3);
            }
        }
    }

    public void setProgress(float f3) {
        if (f3 < 0.0f || f3 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f32759k0 == null) {
                this.f32759k0 = new StateCache();
            }
            this.f32759k0.e(f3);
            return;
        }
        if (f3 <= 0.0f) {
            if (this.f32768p == 1.0f && this.f32750g == this.f32752h) {
                setState(TransitionState.MOVING);
            }
            this.f32750g = this.f32748f;
            if (this.f32768p == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f3 >= 1.0f) {
            if (this.f32768p == 0.0f && this.f32750g == this.f32748f) {
                setState(TransitionState.MOVING);
            }
            this.f32750g = this.f32752h;
            if (this.f32768p == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f32750g = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f32739a == null) {
            return;
        }
        this.f32774s = true;
        this.f32772r = f3;
        this.f32766o = f3;
        this.f32770q = -1L;
        this.f32762m = -1L;
        this.f32741b = null;
        this.f32776t = true;
        invalidate();
    }

    public void setScene(MotionScene motionScene) {
        this.f32739a = motionScene;
        motionScene.W(isRtl());
        f0();
    }

    void setStartState(int i3) {
        if (isAttachedToWindow()) {
            this.f32750g = i3;
            return;
        }
        if (this.f32759k0 == null) {
            this.f32759k0 = new StateCache();
        }
        this.f32759k0.f(i3);
        this.f32759k0.d(i3);
    }

    void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.f32750g == -1) {
            return;
        }
        TransitionState transitionState3 = this.f32783w0;
        this.f32783w0 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            S();
        }
        int i3 = AnonymousClass5.f32794a[transitionState3.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 && transitionState == transitionState2) {
                T();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            S();
        }
        if (transitionState == transitionState2) {
            T();
        }
    }

    public void setTransition(int i3) {
        if (this.f32739a != null) {
            MotionScene.Transition transitionY = Y(i3);
            this.f32748f = transitionY.A();
            this.f32752h = transitionY.y();
            if (!isAttachedToWindow()) {
                if (this.f32759k0 == null) {
                    this.f32759k0 = new StateCache();
                }
                this.f32759k0.f(this.f32748f);
                this.f32759k0.d(this.f32752h);
                return;
            }
            int i4 = this.f32750g;
            float f3 = i4 == this.f32748f ? 0.0f : i4 == this.f32752h ? 1.0f : Float.NaN;
            this.f32739a.Y(transitionY);
            this.f32785x0.e(this.mLayoutWidget, this.f32739a.l(this.f32748f), this.f32739a.l(this.f32752h));
            f0();
            if (this.f32768p != f3) {
                if (f3 == 0.0f) {
                    P(true);
                    this.f32739a.l(this.f32748f).i(this);
                } else if (f3 == 1.0f) {
                    P(false);
                    this.f32739a.l(this.f32752h).i(this);
                }
            }
            this.f32768p = Float.isNaN(f3) ? 0.0f : f3;
            if (!Float.isNaN(f3)) {
                setProgress(f3);
                return;
            }
            Log.v("MotionLayout", Debug.b() + " transitionToStart ");
            n0();
        }
    }

    public void setTransitionDuration(int i3) {
        MotionScene motionScene = this.f32739a;
        if (motionScene == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            motionScene.V(i3);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.f32778u = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f32759k0 == null) {
            this.f32759k0 = new StateCache();
        }
        this.f32759k0.g(bundle);
        if (isAttachedToWindow()) {
            this.f32759k0.a();
        }
    }

    public void t0(int i3, ConstraintSet constraintSet) {
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            motionScene.U(i3, constraintSet);
        }
        s0();
        if (this.f32750g == i3) {
            constraintSet.i(this);
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.c(context, this.f32748f) + "->" + Debug.c(context, this.f32752h) + " (pos:" + this.f32768p + " Dpos/Dt:" + this.f32745d;
    }

    public void u0(int i3, View... viewArr) {
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            motionScene.c0(i3, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i3, int i4, int i5) {
        setState(TransitionState.SETUP);
        this.f32750g = i3;
        this.f32748f = -1;
        this.f32752h = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.d(i3, i4, i5);
            return;
        }
        MotionScene motionScene = this.f32739a;
        if (motionScene != null) {
            motionScene.l(i3).i(this);
        }
    }

    protected void setTransition(MotionScene.Transition transition) {
        this.f32739a.Y(transition);
        setState(TransitionState.SETUP);
        if (this.f32750g == this.f32739a.q()) {
            this.f32768p = 1.0f;
            this.f32766o = 1.0f;
            this.f32772r = 1.0f;
        } else {
            this.f32768p = 0.0f;
            this.f32766o = 0.0f;
            this.f32772r = 0.0f;
        }
        this.f32770q = transition.D(1) ? -1L : getNanoTime();
        int iF = this.f32739a.F();
        int iQ = this.f32739a.q();
        if (iF == this.f32748f && iQ == this.f32752h) {
            return;
        }
        this.f32748f = iF;
        this.f32752h = iQ;
        this.f32739a.X(iF, iQ);
        this.f32785x0.e(this.mLayoutWidget, this.f32739a.l(this.f32748f), this.f32739a.l(this.f32752h));
        this.f32785x0.i(this.f32748f, this.f32752h);
        this.f32785x0.h();
        f0();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void o(View view, int i3, int i4, int i5, int i6, int i7) {
    }
}
