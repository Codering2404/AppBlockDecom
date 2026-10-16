package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TransformKeyframeAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f56628a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix f56629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f56630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f56631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f56632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseKeyframeAnimation f56633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BaseKeyframeAnimation f56634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BaseKeyframeAnimation f56635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaseKeyframeAnimation f56636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BaseKeyframeAnimation f56637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private FloatKeyframeAnimation f56638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private FloatKeyframeAnimation f56639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private BaseKeyframeAnimation f56640m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BaseKeyframeAnimation f56641n;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        this.f56633f = animatableTransform.c() == null ? null : animatableTransform.c().a();
        this.f56634g = animatableTransform.f() == null ? null : animatableTransform.f().a();
        this.f56635h = animatableTransform.h() == null ? null : animatableTransform.h().a();
        this.f56636i = animatableTransform.g() == null ? null : animatableTransform.g().a();
        FloatKeyframeAnimation floatKeyframeAnimation = animatableTransform.i() == null ? null : (FloatKeyframeAnimation) animatableTransform.i().a();
        this.f56638k = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.f56629b = new Matrix();
            this.f56630c = new Matrix();
            this.f56631d = new Matrix();
            this.f56632e = new float[9];
        } else {
            this.f56629b = null;
            this.f56630c = null;
            this.f56631d = null;
            this.f56632e = null;
        }
        this.f56639l = animatableTransform.j() == null ? null : (FloatKeyframeAnimation) animatableTransform.j().a();
        if (animatableTransform.e() != null) {
            this.f56637j = animatableTransform.e().a();
        }
        if (animatableTransform.k() != null) {
            this.f56640m = animatableTransform.k().a();
        } else {
            this.f56640m = null;
        }
        if (animatableTransform.d() != null) {
            this.f56641n = animatableTransform.d().a();
        } else {
            this.f56641n = null;
        }
    }

    private void d() {
        for (int i3 = 0; i3 < 9; i3++) {
            this.f56632e[i3] = 0.0f;
        }
    }

    public void a(BaseLayer baseLayer) {
        baseLayer.j(this.f56637j);
        baseLayer.j(this.f56640m);
        baseLayer.j(this.f56641n);
        baseLayer.j(this.f56633f);
        baseLayer.j(this.f56634g);
        baseLayer.j(this.f56635h);
        baseLayer.j(this.f56636i);
        baseLayer.j(this.f56638k);
        baseLayer.j(this.f56639l);
    }

    public void b(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56637j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56640m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.f56641n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.f56633f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.f56634g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.f56635h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.a(animationListener);
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = this.f56636i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f56638k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.a(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f56639l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(animationListener);
        }
    }

    public boolean c(Object obj, LottieValueCallback lottieValueCallback) {
        Float fValueOf = Float.valueOf(100.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        if (obj == LottieProperty.f56362f) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f56633f;
            if (baseKeyframeAnimation == null) {
                this.f56633f = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.f56363g) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56634g;
            if (baseKeyframeAnimation2 == null) {
                this.f56634g = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.f56364h) {
            BaseKeyframeAnimation baseKeyframeAnimation3 = this.f56634g;
            if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3).r(lottieValueCallback);
                return true;
            }
        }
        if (obj == LottieProperty.f56365i) {
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.f56634g;
            if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4).s(lottieValueCallback);
                return true;
            }
        }
        if (obj == LottieProperty.f56371o) {
            BaseKeyframeAnimation baseKeyframeAnimation5 = this.f56635h;
            if (baseKeyframeAnimation5 == null) {
                this.f56635h = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.f56372p) {
            BaseKeyframeAnimation baseKeyframeAnimation6 = this.f56636i;
            if (baseKeyframeAnimation6 == null) {
                this.f56636i = new ValueCallbackKeyframeAnimation(lottieValueCallback, fValueOf2);
                return true;
            }
            baseKeyframeAnimation6.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.f56359c) {
            BaseKeyframeAnimation baseKeyframeAnimation7 = this.f56637j;
            if (baseKeyframeAnimation7 == null) {
                this.f56637j = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.C) {
            BaseKeyframeAnimation baseKeyframeAnimation8 = this.f56640m;
            if (baseKeyframeAnimation8 == null) {
                this.f56640m = new ValueCallbackKeyframeAnimation(lottieValueCallback, fValueOf);
                return true;
            }
            baseKeyframeAnimation8.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.D) {
            BaseKeyframeAnimation baseKeyframeAnimation9 = this.f56641n;
            if (baseKeyframeAnimation9 == null) {
                this.f56641n = new ValueCallbackKeyframeAnimation(lottieValueCallback, fValueOf);
                return true;
            }
            baseKeyframeAnimation9.n(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.f56373q) {
            if (this.f56638k == null) {
                this.f56638k = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
            }
            this.f56638k.n(lottieValueCallback);
            return true;
        }
        if (obj != LottieProperty.f56374r) {
            return false;
        }
        if (this.f56639l == null) {
            this.f56639l = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(fValueOf2)));
        }
        this.f56639l.n(lottieValueCallback);
        return true;
    }

    public BaseKeyframeAnimation e() {
        return this.f56641n;
    }

    public Matrix f() {
        PointF pointF;
        PointF pointF2;
        this.f56628a.reset();
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56634g;
        if (baseKeyframeAnimation != null && (pointF2 = (PointF) baseKeyframeAnimation.h()) != null) {
            float f3 = pointF2.x;
            if (f3 != 0.0f || pointF2.y != 0.0f) {
                this.f56628a.preTranslate(f3, pointF2.y);
            }
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56636i;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation ? ((Float) baseKeyframeAnimation2.h()).floatValue() : ((FloatKeyframeAnimation) baseKeyframeAnimation2).p();
            if (fFloatValue != 0.0f) {
                this.f56628a.preRotate(fFloatValue);
            }
        }
        if (this.f56638k != null) {
            float fCos = this.f56639l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.p()) + 90.0f));
            float fSin = this.f56639l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.p()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.p()));
            d();
            float[] fArr = this.f56632e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f4 = -fSin;
            fArr[3] = f4;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f56629b.setValues(fArr);
            d();
            float[] fArr2 = this.f56632e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f56630c.setValues(fArr2);
            d();
            float[] fArr3 = this.f56632e;
            fArr3[0] = fCos;
            fArr3[1] = f4;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f56631d.setValues(fArr3);
            this.f56630c.preConcat(this.f56629b);
            this.f56631d.preConcat(this.f56630c);
            this.f56628a.preConcat(this.f56631d);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.f56635h;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY scaleXY = (ScaleXY) baseKeyframeAnimation3.h();
            if (scaleXY.b() != 1.0f || scaleXY.c() != 1.0f) {
                this.f56628a.preScale(scaleXY.b(), scaleXY.c());
            }
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.f56633f;
        if (baseKeyframeAnimation4 != null && (((pointF = (PointF) baseKeyframeAnimation4.h()) != null && pointF.x != 0.0f) || pointF.y != 0.0f)) {
            this.f56628a.preTranslate(-pointF.x, -pointF.y);
        }
        return this.f56628a;
    }

    public Matrix g(float f3) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56634g;
        PointF pointF = baseKeyframeAnimation == null ? null : (PointF) baseKeyframeAnimation.h();
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56635h;
        ScaleXY scaleXY = baseKeyframeAnimation2 == null ? null : (ScaleXY) baseKeyframeAnimation2.h();
        this.f56628a.reset();
        if (pointF != null) {
            this.f56628a.preTranslate(pointF.x * f3, pointF.y * f3);
        }
        if (scaleXY != null) {
            double d3 = f3;
            this.f56628a.preScale((float) Math.pow(scaleXY.b(), d3), (float) Math.pow(scaleXY.c(), d3));
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.f56636i;
        if (baseKeyframeAnimation3 != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation3.h()).floatValue();
            BaseKeyframeAnimation baseKeyframeAnimation4 = this.f56633f;
            PointF pointF2 = baseKeyframeAnimation4 != null ? (PointF) baseKeyframeAnimation4.h() : null;
            this.f56628a.preRotate(fFloatValue * f3, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return this.f56628a;
    }

    public BaseKeyframeAnimation h() {
        return this.f56637j;
    }

    public BaseKeyframeAnimation i() {
        return this.f56640m;
    }

    public void j(float f3) {
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56637j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.m(f3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56640m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.m(f3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation3 = this.f56641n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.m(f3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation4 = this.f56633f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.m(f3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation5 = this.f56634g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.m(f3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation6 = this.f56635h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.m(f3);
        }
        BaseKeyframeAnimation baseKeyframeAnimation7 = this.f56636i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.m(f3);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f56638k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.m(f3);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f56639l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.m(f3);
        }
    }
}
