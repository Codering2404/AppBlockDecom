package com.google.android.material.transition.platform;

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
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
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
    private static final String A = "MaterialContainerTransform";
    private static final String[] B = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    private static final ProgressThresholdsGroup C = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    private static final ProgressThresholdsGroup D = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    private static final ProgressThresholdsGroup E = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    private static final ProgressThresholdsGroup F = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f82726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f82727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f82728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f82729d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f82730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f82731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f82732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f82733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f82734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f82735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f82736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f82737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f82738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f82739o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f82740p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f82741q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ShapeAppearanceModel f82742r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ShapeAppearanceModel f82743s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ProgressThresholds f82744t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ProgressThresholds f82745u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ProgressThresholds f82746v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ProgressThresholds f82747w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f82748x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f82749y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f82750z;

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
        private final float f82758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f82759b;

        public ProgressThresholds(float f3, float f4) {
            this.f82758a = f3;
            this.f82759b = f4;
        }

        public float c() {
            return this.f82759b;
        }

        public float d() {
            return this.f82758a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ProgressThresholdsGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProgressThresholds f82760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProgressThresholds f82761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProgressThresholds f82762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProgressThresholds f82763d;

        private ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.f82760a = progressThresholds;
            this.f82761b = progressThresholds2;
            this.f82762c = progressThresholds3;
            this.f82763d = progressThresholds4;
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
        private final View f82764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RectF f82765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ShapeAppearanceModel f82766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f82767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final View f82768e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final RectF f82769f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ShapeAppearanceModel f82770g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final float f82771h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Paint f82772i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Paint f82773j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Paint f82774k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final Paint f82775l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final Paint f82776m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final MaskEvaluator f82777n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final PathMeasure f82778o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final float f82779p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final float[] f82780q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final boolean f82781r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final float f82782s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final float f82783t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final boolean f82784u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final MaterialShapeDrawable f82785v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final RectF f82786w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final RectF f82787x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private final RectF f82788y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private final RectF f82789z;

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
            canvas.clipPath(this.f82777n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            MaterialShapeDrawable materialShapeDrawable = this.f82785v;
            RectF rectF = this.I;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f82785v.Z(this.J);
            this.f82785v.i0((int) this.K);
            this.f82785v.setShapeAppearanceModel(this.f82777n.c());
            this.f82785v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel shapeAppearanceModelC = this.f82777n.c();
            if (!shapeAppearanceModelC.u(this.I)) {
                canvas.drawPath(this.f82777n.d(), this.f82775l);
            } else {
                float fA = shapeAppearanceModelC.r().a(this.I);
                canvas.drawRoundRect(this.I, fA, fA, this.f82775l);
            }
        }

        private void k(Canvas canvas) {
            n(canvas, this.f82774k);
            Rect bounds = getBounds();
            RectF rectF = this.f82788y;
            TransitionUtils.v(canvas, bounds, rectF.left, rectF.top, this.H.f82716b, this.G.f82695b, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f82768e.draw(canvas2);
                }
            });
        }

        private void l(Canvas canvas) {
            n(canvas, this.f82773j);
            Rect bounds = getBounds();
            RectF rectF = this.f82786w;
            TransitionUtils.v(canvas, bounds, rectF.left, rectF.top, this.H.f82715a, this.G.f82694a, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public void a(Canvas canvas2) {
                    TransitionDrawable.this.f82764a.draw(canvas2);
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
            this.f82776m.setAlpha((int) (this.f82781r ? TransitionUtils.l(0.0f, 255.0f, f3) : TransitionUtils.l(255.0f, 0.0f, f3)));
            this.f82778o.getPosTan(this.f82779p * f3, this.f82780q, null);
            float[] fArr = this.f82780q;
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
                this.f82778o.getPosTan(this.f82779p * f4, fArr, null);
                float[] fArr2 = this.f82780q;
                f6 += (f6 - fArr2[0]) * f5;
                f7 += (f7 - fArr2[1]) * f5;
            }
            float f8 = f6;
            float f9 = f7;
            FitModeResult fitModeResultA = this.C.a(f3, ((Float) Preconditions.h(Float.valueOf(this.A.f82761b.f82758a))).floatValue(), ((Float) Preconditions.h(Float.valueOf(this.A.f82761b.f82759b))).floatValue(), this.f82765b.width(), this.f82765b.height(), this.f82769f.width(), this.f82769f.height());
            this.H = fitModeResultA;
            RectF rectF = this.f82786w;
            float f10 = fitModeResultA.f82717c;
            rectF.set(f8 - (f10 / 2.0f), f9, (f10 / 2.0f) + f8, fitModeResultA.f82718d + f9);
            RectF rectF2 = this.f82788y;
            FitModeResult fitModeResult = this.H;
            float f11 = fitModeResult.f82719e;
            rectF2.set(f8 - (f11 / 2.0f), f9, f8 + (f11 / 2.0f), fitModeResult.f82720f + f9);
            this.f82787x.set(this.f82786w);
            this.f82789z.set(this.f82788y);
            float fFloatValue = ((Float) Preconditions.h(Float.valueOf(this.A.f82762c.f82758a))).floatValue();
            float fFloatValue2 = ((Float) Preconditions.h(Float.valueOf(this.A.f82762c.f82759b))).floatValue();
            boolean zB = this.C.b(this.H);
            RectF rectF3 = zB ? this.f82787x : this.f82789z;
            float fM = TransitionUtils.m(0.0f, 1.0f, fFloatValue, fFloatValue2, f3);
            if (!zB) {
                fM = 1.0f - fM;
            }
            this.C.c(rectF3, fM, this.H);
            this.I = new RectF(Math.min(this.f82787x.left, this.f82789z.left), Math.min(this.f82787x.top, this.f82789z.top), Math.max(this.f82787x.right, this.f82789z.right), Math.max(this.f82787x.bottom, this.f82789z.bottom));
            this.f82777n.b(f3, this.f82766c, this.f82770g, this.f82786w, this.f82787x, this.f82789z, this.A.f82763d);
            this.J = TransitionUtils.l(this.f82767d, this.f82771h, f3);
            float fD = d(this.I, this.f82782s);
            float fE = e(this.I, this.f82783t);
            float f12 = this.J;
            float f13 = (int) (fE * f12);
            this.K = f13;
            this.f82775l.setShadowLayer(f12, (int) (fD * f12), f13, 754974720);
            this.G = this.B.a(f3, ((Float) Preconditions.h(Float.valueOf(this.A.f82760a.f82758a))).floatValue(), ((Float) Preconditions.h(Float.valueOf(this.A.f82760a.f82759b))).floatValue(), 0.35f);
            if (this.f82773j.getColor() != 0) {
                this.f82773j.setAlpha(this.G.f82694a);
            }
            if (this.f82774k.getColor() != 0) {
                this.f82774k.setAlpha(this.G.f82695b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f82776m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f82776m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.f82784u && this.J > 0.0f) {
                h(canvas);
            }
            this.f82777n.a(canvas);
            n(canvas, this.f82772i);
            if (this.G.f82696c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                f(canvas, this.f82786w, this.F, -65281);
                g(canvas, this.f82787x, -256);
                g(canvas, this.f82786w, -16711936);
                g(canvas, this.f82789z, -16711681);
                g(canvas, this.f82788y, -16776961);
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
            this.f82772i = paint;
            Paint paint2 = new Paint();
            this.f82773j = paint2;
            Paint paint3 = new Paint();
            this.f82774k = paint3;
            this.f82775l = new Paint();
            Paint paint4 = new Paint();
            this.f82776m = paint4;
            this.f82777n = new MaskEvaluator();
            this.f82780q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f82785v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f82764a = view;
            this.f82765b = rectF;
            this.f82766c = shapeAppearanceModel;
            this.f82767d = f3;
            this.f82768e = view2;
            this.f82769f = rectF2;
            this.f82770g = shapeAppearanceModel2;
            this.f82771h = f4;
            this.f82781r = z2;
            this.f82784u = z3;
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = progressThresholdsGroup;
            this.D = z4;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.f82782s = r9.widthPixels;
            this.f82783t = r9.heightPixels;
            paint.setColor(i3);
            paint2.setColor(i4);
            paint3.setColor(i5);
            materialShapeDrawable.a0(ColorStateList.valueOf(0));
            materialShapeDrawable.h0(2);
            materialShapeDrawable.e0(false);
            materialShapeDrawable.f0(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f82786w = rectF3;
            this.f82787x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f82788y = rectF4;
            this.f82789z = new RectF(rectF4);
            PointF pointFM = m(rectF);
            PointF pointFM2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFM.x, pointFM.y, pointFM2.x, pointFM2.y), false);
            this.f82778o = pathMeasure;
            this.f82779p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(TransitionUtils.d(i6));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    private ProgressThresholdsGroup b(boolean z2) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) ? j(z2, E, F) : j(z2, C, D);
    }

    private static RectF c(View view, View view2, float f3, float f4) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFH = TransitionUtils.h(view2);
        rectFH.offset(f3, f4);
        return rectFH;
    }

    private static ShapeAppearanceModel e(View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel) {
        return TransitionUtils.c(i(view, shapeAppearanceModel), rectF);
    }

    private static void g(TransitionValues transitionValues, View view, int i3, ShapeAppearanceModel shapeAppearanceModel) {
        if (i3 != -1) {
            transitionValues.view = TransitionUtils.g(transitionValues.view, i3);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view2 = transitionValues.view;
            int i4 = R.id.T;
            if (view2.getTag(i4) instanceof View) {
                View view3 = (View) transitionValues.view.getTag(i4);
                transitionValues.view.setTag(i4, null);
                transitionValues.view = view3;
            }
        }
        View view4 = transitionValues.view;
        if (!ViewCompat.R(view4) && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        RectF rectFI = view4.getParent() == null ? TransitionUtils.i(view4) : TransitionUtils.h(view4);
        transitionValues.values.put("materialContainerTransition:bounds", rectFI);
        transitionValues.values.put("materialContainerTransition:shapeAppearance", e(view4, rectFI, shapeAppearanceModel));
    }

    private static float h(float f3, View view) {
        return f3 != -1.0f ? f3 : ViewCompat.t(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ShapeAppearanceModel i(View view, ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        int i3 = R.id.T;
        if (view.getTag(i3) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(i3);
        }
        Context context = view.getContext();
        int iK = k(context);
        return iK != -1 ? ShapeAppearanceModel.b(context, iK, 0).m() : view instanceof Shapeable ? ((Shapeable) view).getShapeAppearanceModel() : ShapeAppearanceModel.a().m();
    }

    private ProgressThresholdsGroup j(boolean z2, ProgressThresholdsGroup progressThresholdsGroup, ProgressThresholdsGroup progressThresholdsGroup2) {
        if (!z2) {
            progressThresholdsGroup = progressThresholdsGroup2;
        }
        return new ProgressThresholdsGroup((ProgressThresholds) TransitionUtils.e(this.f82744t, progressThresholdsGroup.f82760a), (ProgressThresholds) TransitionUtils.e(this.f82745u, progressThresholdsGroup.f82761b), (ProgressThresholds) TransitionUtils.e(this.f82746v, progressThresholdsGroup.f82762c), (ProgressThresholds) TransitionUtils.e(this.f82747w, progressThresholdsGroup.f82763d));
    }

    private static int k(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.H0});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean m(RectF rectF, RectF rectF2) {
        int i3 = this.f82737m;
        if (i3 == 0) {
            return TransitionUtils.b(rectF2) > TransitionUtils.b(rectF);
        }
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.f82737m);
    }

    private void o(Context context, boolean z2) {
        TransitionUtils.r(this, context, R.attr.f79487f0, AnimationUtils.f79850b);
        TransitionUtils.q(this, context, z2 ? R.attr.V : R.attr.Y);
        if (this.f82728c) {
            return;
        }
        TransitionUtils.s(this, context, R.attr.f79495j0);
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        g(transitionValues, this.f82741q, this.f82732h, this.f82743s);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        g(transitionValues, this.f82740p, this.f82731g, this.f82742r);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        final View viewF;
        View view = null;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF != null && shapeAppearanceModel != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF2 == null || shapeAppearanceModel2 == null) {
                    Log.w(A, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                final View view2 = transitionValues.view;
                final View view3 = transitionValues2.view;
                View view4 = view3.getParent() != null ? view3 : view2;
                if (this.f82730f == view4.getId()) {
                    viewF = (View) view4.getParent();
                    view = view4;
                } else {
                    viewF = TransitionUtils.f(view4, this.f82730f);
                }
                RectF rectFH = TransitionUtils.h(viewF);
                float f3 = -rectFH.left;
                float f4 = -rectFH.top;
                RectF rectFC = c(viewF, view, f3, f4);
                rectF.offset(f3, f4);
                rectF2.offset(f3, f4);
                boolean zM = m(rectF, rectF2);
                if (!this.f82729d) {
                    o(view4.getContext(), zM);
                }
                final TransitionDrawable transitionDrawable = new TransitionDrawable(getPathMotion(), view2, rectF, shapeAppearanceModel, h(this.f82749y, view2), view3, rectF2, shapeAppearanceModel2, h(this.f82750z, view3), this.f82733i, this.f82734j, this.f82735k, this.f82736l, zM, this.f82748x, FadeModeEvaluators.a(this.f82738n, zM), FitModeEvaluators.a(this.f82739o, zM, rectF, rectF2), b(zM), this.f82726a);
                transitionDrawable.setBounds(Math.round(rectFC.left), Math.round(rectFC.top), Math.round(rectFC.right), Math.round(rectFC.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        transitionDrawable.o(valueAnimator.getAnimatedFraction());
                    }
                });
                addListener(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.2
                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        MaterialContainerTransform.this.removeListener(this);
                        if (MaterialContainerTransform.this.f82727b) {
                            return;
                        }
                        view2.setAlpha(1.0f);
                        view3.setAlpha(1.0f);
                        ViewUtils.l(viewF).b(transitionDrawable);
                    }

                    @Override // com.google.android.material.transition.platform.TransitionListenerAdapter, android.transition.Transition.TransitionListener
                    public void onTransitionStart(Transition transition) {
                        ViewUtils.l(viewF).a(transitionDrawable);
                        view2.setAlpha(0.0f);
                        view3.setAlpha(0.0f);
                    }
                });
                return valueAnimatorOfFloat;
            }
            Log.w(A, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return B;
    }

    public void p(boolean z2) {
        this.f82727b = z2;
    }

    @Override // android.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f82728c = true;
    }
}
