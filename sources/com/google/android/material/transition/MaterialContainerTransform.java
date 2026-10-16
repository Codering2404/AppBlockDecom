package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialContainerTransform extends Transition {

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private static final String f82605q0 = "MaterialContainerTransform";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private static final String[] f82606r0 = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private static final ProgressThresholdsGroup f82607s0 = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private static final ProgressThresholdsGroup f82608t0 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private static final ProgressThresholdsGroup f82609u0 = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static final ProgressThresholdsGroup f82610v0 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private int f82611a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private int f82612b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f82613c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private int f82614d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f82615e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private View f82616f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private View f82617g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private ShapeAppearanceModel f82618h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private ShapeAppearanceModel f82619i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ProgressThresholds f82620j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private ProgressThresholds f82621k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private ProgressThresholds f82622l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private ProgressThresholds f82623m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f82624n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private float f82625o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private float f82626p0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ProgressThresholds {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f82634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f82635b;

        public ProgressThresholds(float f3, float f4) {
            this.f82634a = f3;
            this.f82635b = f4;
        }

        public float c() {
            return this.f82635b;
        }

        public float d() {
            return this.f82634a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ProgressThresholdsGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProgressThresholds f82636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProgressThresholds f82637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProgressThresholds f82638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProgressThresholds f82639d;

        private ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.f82636a = progressThresholds;
            this.f82637b = progressThresholds2;
            this.f82638c = progressThresholds3;
            this.f82639d = progressThresholds4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TransitionDrawable extends Drawable {
        private final ProgressThresholdsGroup A;
        private final FadeModeEvaluator B;
        private final FitModeEvaluator C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private FadeModeResult G;
        private FitModeResult H;
        private RectF I;
        private float J;
        private float K;
        private float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f82640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RectF f82641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ShapeAppearanceModel f82642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f82643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f82644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final RectF f82645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ShapeAppearanceModel f82646g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f82647h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Paint f82648i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Paint f82649j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Paint f82650k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Paint f82651l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Paint f82652m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final MaskEvaluator f82653n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final PathMeasure f82654o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final float f82655p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final float[] f82656q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f82657r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f82658s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f82659t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f82660u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final MaterialShapeDrawable f82661v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f82662w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final RectF f82663x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final RectF f82664y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final RectF f82665z;

        private static float d(RectF rectF, float f3) {
            return ((rectF.centerX() / (f3 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float e(RectF rectF, float f3) {
            return (rectF.centerY() / f3) * 1.5f;
        }

        private void f(Canvas canvas, RectF rectF, Path path, int i3) {
            PointF pointFM = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(pointFM.x, pointFM.y);
            } else {
                path.lineTo(pointFM.x, pointFM.y);
                this.E.setColor(i3);
                canvas.drawPath(path, this.E);
            }
        }

        private void g(Canvas canvas, RectF rectF, int i3) {
            this.E.setColor(i3);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f82653n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            MaterialShapeDrawable materialShapeDrawable = this.f82661v;
            RectF rectF = this.I;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f82661v.Z(this.J);
            this.f82661v.i0((int) this.K);
            this.f82661v.setShapeAppearanceModel(this.f82653n.c());
            this.f82661v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel shapeAppearanceModelC = this.f82653n.c();
            if (!shapeAppearanceModelC.u(this.I)) {
                canvas.drawPath(this.f82653n.d(), this.f82651l);
            } else {
                float fA = shapeAppearanceModelC.r().a(this.I);
                canvas.drawRoundRect(this.I, fA, fA, this.f82651l);
            }
        }

        private void k(Canvas canvas) {
            n(canvas, this.f82650k);
            Rect bounds = getBounds();
            RectF rectF = this.f82664y;
            TransitionUtils.u(canvas, bounds, rectF.left, rectF.top, this.H.f82595b, this.G.f82574b, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f82644e.draw(canvas2);
                }
            });
        }

        private void l(Canvas canvas) {
            n(canvas, this.f82649j);
            Rect bounds = getBounds();
            RectF rectF = this.f82662w;
            TransitionUtils.u(canvas, bounds, rectF.left, rectF.top, this.H.f82594a, this.G.f82573a, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f82640a.draw(canvas2);
                }
            });
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(float f3) {
            if (this.L != f3) {
                p(f3);
            }
        }

        private void p(float f3) {
            float f4;
            float f5;
            this.L = f3;
            this.f82652m.setAlpha((int) (this.f82657r ? TransitionUtils.k(0.0f, 255.0f, f3) : TransitionUtils.k(255.0f, 0.0f, f3)));
            this.f82654o.getPosTan(this.f82655p * f3, this.f82656q, null);
            float[] fArr = this.f82656q;
            float f6 = fArr[0];
            float f7 = fArr[1];
            if (f3 > 1.0f || f3 < 0.0f) {
                if (f3 > 1.0f) {
                    f5 = (f3 - 1.0f) / 0.00999999f;
                    f4 = 0.99f;
                } else {
                    f4 = 0.01f;
                    f5 = (f3 / 0.01f) * (-1.0f);
                }
                this.f82654o.getPosTan(this.f82655p * f4, fArr, null);
                float[] fArr2 = this.f82656q;
                f6 += (f6 - fArr2[0]) * f5;
                f7 += (f7 - fArr2[1]) * f5;
            }
            float f8 = f6;
            float f9 = f7;
            FitModeResult fitModeResultA = this.C.a(f3, ((Float) Preconditions.h(Float.valueOf(this.A.f82637b.f82634a))).floatValue(), ((Float) Preconditions.h(Float.valueOf(this.A.f82637b.f82635b))).floatValue(), this.f82641b.width(), this.f82641b.height(), this.f82645f.width(), this.f82645f.height());
            this.H = fitModeResultA;
            RectF rectF = this.f82662w;
            float f10 = fitModeResultA.f82596c;
            rectF.set(f8 - (f10 / 2.0f), f9, (f10 / 2.0f) + f8, fitModeResultA.f82597d + f9);
            RectF rectF2 = this.f82664y;
            FitModeResult fitModeResult = this.H;
            float f11 = fitModeResult.f82598e;
            rectF2.set(f8 - (f11 / 2.0f), f9, f8 + (f11 / 2.0f), fitModeResult.f82599f + f9);
            this.f82663x.set(this.f82662w);
            this.f82665z.set(this.f82664y);
            float fFloatValue = ((Float) Preconditions.h(Float.valueOf(this.A.f82638c.f82634a))).floatValue();
            float fFloatValue2 = ((Float) Preconditions.h(Float.valueOf(this.A.f82638c.f82635b))).floatValue();
            boolean zB = this.C.b(this.H);
            RectF rectF3 = zB ? this.f82663x : this.f82665z;
            float fL = TransitionUtils.l(0.0f, 1.0f, fFloatValue, fFloatValue2, f3);
            if (!zB) {
                fL = 1.0f - fL;
            }
            this.C.c(rectF3, fL, this.H);
            this.I = new RectF(Math.min(this.f82663x.left, this.f82665z.left), Math.min(this.f82663x.top, this.f82665z.top), Math.max(this.f82663x.right, this.f82665z.right), Math.max(this.f82663x.bottom, this.f82665z.bottom));
            this.f82653n.b(f3, this.f82642c, this.f82646g, this.f82662w, this.f82663x, this.f82665z, this.A.f82639d);
            this.J = TransitionUtils.k(this.f82643d, this.f82647h, f3);
            float fD = d(this.I, this.f82658s);
            float fE = e(this.I, this.f82659t);
            float f12 = this.J;
            float f13 = (int) (fE * f12);
            this.K = f13;
            this.f82651l.setShadowLayer(f12, (int) (fD * f12), f13, 754974720);
            this.G = this.B.a(f3, ((Float) Preconditions.h(Float.valueOf(this.A.f82636a.f82634a))).floatValue(), ((Float) Preconditions.h(Float.valueOf(this.A.f82636a.f82635b))).floatValue(), 0.35f);
            if (this.f82649j.getColor() != 0) {
                this.f82649j.setAlpha(this.G.f82573a);
            }
            if (this.f82650k.getColor() != 0) {
                this.f82650k.setAlpha(this.G.f82574b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f82652m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f82652m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.f82660u && this.J > 0.0f) {
                h(canvas);
            }
            this.f82653n.a(canvas);
            n(canvas, this.f82648i);
            if (this.G.f82575c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                f(canvas, this.f82662w, this.F, -65281);
                g(canvas, this.f82663x, -256);
                g(canvas, this.f82662w, -16711936);
                g(canvas, this.f82665z, -16711681);
                g(canvas, this.f82664y, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f3, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f4, int i3, int i4, int i5, int i6, boolean z2, boolean z3, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup, boolean z4) {
            Paint paint = new Paint();
            this.f82648i = paint;
            Paint paint2 = new Paint();
            this.f82649j = paint2;
            Paint paint3 = new Paint();
            this.f82650k = paint3;
            this.f82651l = new Paint();
            Paint paint4 = new Paint();
            this.f82652m = paint4;
            this.f82653n = new MaskEvaluator();
            this.f82656q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f82661v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f82640a = view;
            this.f82641b = rectF;
            this.f82642c = shapeAppearanceModel;
            this.f82643d = f3;
            this.f82644e = view2;
            this.f82645f = rectF2;
            this.f82646g = shapeAppearanceModel2;
            this.f82647h = f4;
            this.f82657r = z2;
            this.f82660u = z3;
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = progressThresholdsGroup;
            this.D = z4;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.f82658s = r9.widthPixels;
            this.f82659t = r9.heightPixels;
            paint.setColor(i3);
            paint2.setColor(i4);
            paint3.setColor(i5);
            materialShapeDrawable.a0(ColorStateList.valueOf(0));
            materialShapeDrawable.h0(2);
            materialShapeDrawable.e0(false);
            materialShapeDrawable.f0(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f82662w = rectF3;
            this.f82663x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f82664y = rectF4;
            this.f82665z = new RectF(rectF4);
            PointF pointFM = m(rectF);
            PointF pointFM2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.a(pointFM.x, pointFM.y, pointFM2.x, pointFM2.y), false);
            this.f82654o = pathMeasure;
            this.f82655p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(TransitionUtils.d(i6));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    private ProgressThresholdsGroup q0(boolean z2) {
        PathMotion pathMotionZ = z();
        return ((pathMotionZ instanceof ArcMotion) || (pathMotionZ instanceof MaterialArcMotion)) ? w0(z2, f82609u0, f82610v0) : w0(z2, f82607s0, f82608t0);
    }

    private static RectF r0(View view, View view2, float f3, float f4) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFH = TransitionUtils.h(view2);
        rectFH.offset(f3, f4);
        return rectFH;
    }

    private static ShapeAppearanceModel s0(View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.c(v0(view, shapeAppearanceModel), rectF);
    }

    private static void t0(TransitionValues transitionValues, View view, int i3, ShapeAppearanceModel shapeAppearanceModel) {
        if (i3 != -1) {
            transitionValues.f53546b = TransitionUtils.g(transitionValues.f53546b, i3);
        } else if (view != null) {
            transitionValues.f53546b = view;
        } else {
            View view2 = transitionValues.f53546b;
            int i4 = R.id.T;
            if (view2.getTag(i4) instanceof View) {
                View view3 = (View) transitionValues.f53546b.getTag(i4);
                transitionValues.f53546b.setTag(i4, null);
                transitionValues.f53546b = view3;
            }
        }
        View view4 = transitionValues.f53546b;
        if (!ViewCompat.R(view4) && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        RectF rectFI = view4.getParent() == null ? TransitionUtils.i(view4) : TransitionUtils.h(view4);
        transitionValues.f53545a.put("materialContainerTransition:bounds", rectFI);
        transitionValues.f53545a.put("materialContainerTransition:shapeAppearance", s0(view4, rectFI, shapeAppearanceModel));
    }

    private static float u0(float f3, View view) {
        return f3 != -1.0f ? f3 : ViewCompat.t(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel v0(View view, ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i3 = R.id.T;
        if (view.getTag(i3) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(i3);
        }
        Context context = view.getContext();
        int iX0 = x0(context);
        return iX0 != -1 ? ShapeAppearanceModel.b(context, iX0, 0).m() : view instanceof Shapeable ? ((Shapeable) view).getShapeAppearanceModel() : ShapeAppearanceModel.a().m();
    }

    private ProgressThresholdsGroup w0(boolean z2, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z2) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.e(this.f82620j0, progressThresholdsGroup.f82636a), (ProgressThresholds) TransitionUtils.e(this.f82621k0, progressThresholdsGroup.f82637b), (ProgressThresholds) TransitionUtils.e(this.f82622l0, progressThresholdsGroup.f82638c), (ProgressThresholds) TransitionUtils.e(this.f82623m0, progressThresholdsGroup.f82639d));
    }

    private static int x0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.H0});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean y0(RectF rectF, RectF rectF2) {
        int i3 = this.f82613c0;
        if (i3 == 0) {
            return TransitionUtils.b(rectF2) > TransitionUtils.b(rectF);
        }
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.f82613c0);
    }

    private void z0(Context context, boolean z2) {
        TransitionUtils.q(this, context, R.attr.f79487f0, AnimationUtils.f79850b);
        TransitionUtils.p(this, context, z2 ? R.attr.V : R.attr.Y);
        if (this.T) {
            return;
        }
        TransitionUtils.r(this, context, R.attr.f79495j0);
    }

    @Override // androidx.transition.Transition
    public String[] K() {
        return f82606r0;
    }

    @Override // androidx.transition.Transition
    public void h(TransitionValues transitionValues) {
        t0(transitionValues, this.f82617g0, this.X, this.f82619i0);
    }

    @Override // androidx.transition.Transition
    public void k(TransitionValues transitionValues) {
        t0(transitionValues, this.f82616f0, this.W, this.f82618h0);
    }

    @Override // androidx.transition.Transition
    public void k0(PathMotion pathMotion) {
        super.k0(pathMotion);
        this.T = true;
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        final View viewF;
        View view = null;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.f53545a.get("materialContainerTransition:bounds");
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.f53545a.get("materialContainerTransition:shapeAppearance");
            if (rectF != null && shapeAppearanceModel != null) {
                RectF rectF2 = (RectF) transitionValues2.f53545a.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.f53545a.get("materialContainerTransition:shapeAppearance");
                if (rectF2 == null || shapeAppearanceModel2 == null) {
                    Log.w(f82605q0, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                final View view2 = transitionValues.f53546b;
                final View view3 = transitionValues2.f53546b;
                View view4 = view3.getParent() != null ? view3 : view2;
                if (this.V == view4.getId()) {
                    viewF = (View) view4.getParent();
                    view = view4;
                } else {
                    viewF = TransitionUtils.f(view4, this.V);
                }
                RectF rectFH = TransitionUtils.h(viewF);
                float f3 = -rectFH.left;
                float f4 = -rectFH.top;
                RectF rectFR0 = r0(viewF, view, f3, f4);
                rectF.offset(f3, f4);
                rectF2.offset(f3, f4);
                boolean zY0 = y0(rectF, rectF2);
                if (!this.U) {
                    z0(view4.getContext(), zY0);
                }
                final TransitionDrawable transitionDrawable = new TransitionDrawable(z(), view2, rectF, shapeAppearanceModel, u0(this.f82625o0, view2), view3, rectF2, shapeAppearanceModel2, u0(this.f82626p0, view3), this.Y, this.Z, this.f82611a0, this.f82612b0, zY0, this.f82624n0, FadeModeEvaluators.a(this.f82614d0, zY0), FitModeEvaluators.a(this.f82615e0, zY0, rectF, rectF2), q0(zY0), this.R);
                transitionDrawable.setBounds(Math.round(rectFR0.left), Math.round(rectFR0.top), Math.round(rectFR0.right), Math.round(rectFR0.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.MaterialContainerTransform.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        transitionDrawable.o(valueAnimator.getAnimatedFraction());
                    }
                });
                a(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransform.2
                    @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void c(Transition transition) {
                        ViewUtils.l(viewF).a(transitionDrawable);
                        view2.setAlpha(0.0f);
                        view3.setAlpha(0.0f);
                    }

                    @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public void f(Transition transition) {
                        MaterialContainerTransform.this.b0(this);
                        if (MaterialContainerTransform.this.S) {
                            return;
                        }
                        view2.setAlpha(1.0f);
                        view3.setAlpha(1.0f);
                        ViewUtils.l(viewF).b(transitionDrawable);
                    }
                });
                return valueAnimatorOfFloat;
            }
            Log.w(f82605q0, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }
}
