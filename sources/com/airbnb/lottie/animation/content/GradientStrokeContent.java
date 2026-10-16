package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    private final BaseKeyframeAnimation A;
    private ValueCallbackKeyframeAnimation B;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f56504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f56505s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LongSparseArray f56506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final LongSparseArray f56507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final RectF f56508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final GradientType f56509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final int f56510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final BaseKeyframeAnimation f56511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final BaseKeyframeAnimation f56512z;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.b().b(), gradientStroke.g().b(), gradientStroke.i(), gradientStroke.k(), gradientStroke.m(), gradientStroke.h(), gradientStroke.c());
        this.f56506t = new LongSparseArray();
        this.f56507u = new LongSparseArray();
        this.f56508v = new RectF();
        this.f56504r = gradientStroke.j();
        this.f56509w = gradientStroke.f();
        this.f56505s = gradientStroke.n();
        this.f56510x = (int) (lottieDrawable.D().d() / 32.0f);
        BaseKeyframeAnimation baseKeyframeAnimationA = gradientStroke.e().a();
        this.f56511y = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = gradientStroke.l().a();
        this.f56512z = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation baseKeyframeAnimationA3 = gradientStroke.d().a();
        this.A = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
    }

    private int[] k(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.B;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.h();
            int i3 = 0;
            if (iArr.length == numArr.length) {
                while (i3 < iArr.length) {
                    iArr[i3] = numArr[i3].intValue();
                    i3++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i3 < numArr.length) {
                    iArr[i3] = numArr[i3].intValue();
                    i3++;
                }
            }
        }
        return iArr;
    }

    private int l() {
        int iRound = Math.round(this.f56512z.f() * this.f56510x);
        int iRound2 = Math.round(this.A.f() * this.f56510x);
        int iRound3 = Math.round(this.f56511y.f() * this.f56510x);
        int i3 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i3 = i3 * 31 * iRound2;
        }
        return iRound3 != 0 ? i3 * 31 * iRound3 : i3;
    }

    private LinearGradient m() {
        long jL = l();
        LinearGradient linearGradient = (LinearGradient) this.f56506t.g(jL);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f56512z.h();
        PointF pointF2 = (PointF) this.A.h();
        GradientColor gradientColor = (GradientColor) this.f56511y.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, k(gradientColor.c()), gradientColor.d(), Shader.TileMode.CLAMP);
        this.f56506t.m(jL, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient n() {
        long jL = l();
        RadialGradient radialGradient = (RadialGradient) this.f56507u.g(jL);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f56512z.h();
        PointF pointF2 = (PointF) this.A.h();
        GradientColor gradientColor = (GradientColor) this.f56511y.h();
        int[] iArrK = k(gradientColor.c());
        float[] fArrD = gradientColor.d();
        RadialGradient radialGradient2 = new RadialGradient(pointF.x, pointF.y, (float) Math.hypot(pointF2.x - r7, pointF2.y - r8), iArrK, fArrD, Shader.TileMode.CLAMP);
        this.f56507u.m(jL, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        super.d(obj, lottieValueCallback);
        if (obj == LottieProperty.L) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.B;
            if (valueCallbackKeyframeAnimation != null) {
                this.f56436f.G(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.B = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.B = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f56436f.j(this.B);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56504r;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f56505s) {
            return;
        }
        f(this.f56508v, matrix, false);
        Shader shaderM = this.f56509w == GradientType.LINEAR ? m() : n();
        shaderM.setLocalMatrix(matrix);
        this.f56439i.setShader(shaderM);
        super.i(canvas, matrix, i3);
    }
}
