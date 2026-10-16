package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f56484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BaseLayer f56485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LongSparseArray f56486d = new LongSparseArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LongSparseArray f56487e = new LongSparseArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f56488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f56489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f56490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f56491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final GradientType f56492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BaseKeyframeAnimation f56493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final BaseKeyframeAnimation f56494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final BaseKeyframeAnimation f56495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final BaseKeyframeAnimation f56496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private BaseKeyframeAnimation f56497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ValueCallbackKeyframeAnimation f56498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LottieDrawable f56499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f56500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private BaseKeyframeAnimation f56501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    float f56502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private DropShadowKeyframeAnimation f56503u;

    public GradientFillContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.f56488f = path;
        this.f56489g = new LPaint(1);
        this.f56490h = new RectF();
        this.f56491i = new ArrayList();
        this.f56502t = 0.0f;
        this.f56485c = baseLayer;
        this.f56483a = gradientFill.f();
        this.f56484b = gradientFill.i();
        this.f56499q = lottieDrawable;
        this.f56492j = gradientFill.e();
        path.setFillType(gradientFill.c());
        this.f56500r = (int) (lottieComposition.d() / 32.0f);
        BaseKeyframeAnimation baseKeyframeAnimationA = gradientFill.d().a();
        this.f56493k = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = gradientFill.g().a();
        this.f56494l = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation baseKeyframeAnimationA3 = gradientFill.h().a();
        this.f56495m = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
        BaseKeyframeAnimation baseKeyframeAnimationA4 = gradientFill.b().a();
        this.f56496n = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        baseLayer.j(baseKeyframeAnimationA4);
        if (baseLayer.w() != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA5 = baseLayer.w().a().a();
            this.f56501s = baseKeyframeAnimationA5;
            baseKeyframeAnimationA5.a(this);
            baseLayer.j(this.f56501s);
        }
        if (baseLayer.y() != null) {
            this.f56503u = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.y());
        }
    }

    private int[] h(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f56498p;
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

    private int j() {
        int iRound = Math.round(this.f56495m.f() * this.f56500r);
        int iRound2 = Math.round(this.f56496n.f() * this.f56500r);
        int iRound3 = Math.round(this.f56493k.f() * this.f56500r);
        int i3 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i3 = i3 * 31 * iRound2;
        }
        return iRound3 != 0 ? i3 * 31 * iRound3 : i3;
    }

    private LinearGradient k() {
        long j3 = j();
        LinearGradient linearGradient = (LinearGradient) this.f56486d.g(j3);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.f56495m.h();
        PointF pointF2 = (PointF) this.f56496n.h();
        GradientColor gradientColor = (GradientColor) this.f56493k.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, h(gradientColor.c()), gradientColor.d(), Shader.TileMode.CLAMP);
        this.f56486d.m(j3, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient l() {
        long j3 = j();
        RadialGradient radialGradient = (RadialGradient) this.f56487e.g(j3);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.f56495m.h();
        PointF pointF2 = (PointF) this.f56496n.h();
        GradientColor gradientColor = (GradientColor) this.f56493k.h();
        int[] iArrH = h(gradientColor.c());
        float[] fArrD = gradientColor.d();
        float f3 = pointF.x;
        float f4 = pointF.y;
        float fHypot = (float) Math.hypot(pointF2.x - f3, pointF2.y - f4);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f3, f4, fHypot, iArrH, fArrD, Shader.TileMode.CLAMP);
        this.f56487e.m(j3, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56499q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        for (int i3 = 0; i3 < list2.size(); i3++) {
            Content content = (Content) list2.get(i3);
            if (content instanceof PathContent) {
                this.f56491i.add((PathContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (obj == LottieProperty.f56360d) {
            this.f56494l.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.K) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f56497o;
            if (baseKeyframeAnimation != null) {
                this.f56485c.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f56497o = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56497o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f56485c.j(this.f56497o);
            return;
        }
        if (obj == LottieProperty.L) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.f56498p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.f56485c.G(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.f56498p = null;
                return;
            }
            this.f56486d.b();
            this.f56487e.b();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56498p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            this.f56485c.j(this.f56498p);
            return;
        }
        if (obj == LottieProperty.f56366j) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56501s;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.n(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56501s = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.a(this);
            this.f56485c.j(this.f56501s);
            return;
        }
        if (obj == LottieProperty.f56361e && (dropShadowKeyframeAnimation5 = this.f56503u) != null) {
            dropShadowKeyframeAnimation5.c(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.G && (dropShadowKeyframeAnimation4 = this.f56503u) != null) {
            dropShadowKeyframeAnimation4.f(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.H && (dropShadowKeyframeAnimation3 = this.f56503u) != null) {
            dropShadowKeyframeAnimation3.d(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.I && (dropShadowKeyframeAnimation2 = this.f56503u) != null) {
            dropShadowKeyframeAnimation2.e(lottieValueCallback);
        } else {
            if (obj != LottieProperty.J || (dropShadowKeyframeAnimation = this.f56503u) == null) {
                return;
            }
            dropShadowKeyframeAnimation.g(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i3, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        this.f56488f.reset();
        for (int i3 = 0; i3 < this.f56491i.size(); i3++) {
            this.f56488f.addPath(((PathContent) this.f56491i.get(i3)).g(), matrix);
        }
        this.f56488f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56483a;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f56484b) {
            return;
        }
        L.a("GradientFillContent#draw");
        this.f56488f.reset();
        for (int i4 = 0; i4 < this.f56491i.size(); i4++) {
            this.f56488f.addPath(((PathContent) this.f56491i.get(i4)).g(), matrix);
        }
        this.f56488f.computeBounds(this.f56490h, false);
        Shader shaderK = this.f56492j == GradientType.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.f56489g.setShader(shaderK);
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56497o;
        if (baseKeyframeAnimation != null) {
            this.f56489g.setColorFilter((ColorFilter) baseKeyframeAnimation.h());
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56501s;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation2.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.f56489g.setMaskFilter(null);
            } else if (fFloatValue != this.f56502t) {
                this.f56489g.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f56502t = fFloatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f56503u;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.b(this.f56489g);
        }
        this.f56489g.setAlpha(MiscUtils.c((int) ((((i3 / 255.0f) * ((Integer) this.f56494l.h()).intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f56488f, this.f56489g);
        L.b("GradientFillContent#draw");
    }
}
