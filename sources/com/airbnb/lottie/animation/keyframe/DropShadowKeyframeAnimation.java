package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Paint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseKeyframeAnimation.AnimationListener f56594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BaseKeyframeAnimation f56595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BaseKeyframeAnimation f56596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BaseKeyframeAnimation f56597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BaseKeyframeAnimation f56598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseKeyframeAnimation f56599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f56600g = true;

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.f56594a = animationListener;
        BaseKeyframeAnimation baseKeyframeAnimationA = dropShadowEffect.a().a();
        this.f56595b = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = dropShadowEffect.d().a();
        this.f56596c = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation baseKeyframeAnimationA3 = dropShadowEffect.b().a();
        this.f56597d = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
        BaseKeyframeAnimation baseKeyframeAnimationA4 = dropShadowEffect.c().a();
        this.f56598e = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a(this);
        baseLayer.j(baseKeyframeAnimationA4);
        BaseKeyframeAnimation baseKeyframeAnimationA5 = dropShadowEffect.e().a();
        this.f56599f = baseKeyframeAnimationA5;
        baseKeyframeAnimationA5.a(this);
        baseLayer.j(baseKeyframeAnimationA5);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56600g = true;
        this.f56594a.a();
    }

    public void b(Paint paint) {
        if (this.f56600g) {
            this.f56600g = false;
            double dFloatValue = ((double) ((Float) this.f56597d.h()).floatValue()) * 0.017453292519943295d;
            float fFloatValue = ((Float) this.f56598e.h()).floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = ((Integer) this.f56595b.h()).intValue();
            paint.setShadowLayer(((Float) this.f56599f.h()).floatValue(), fSin, fCos, Color.argb(Math.round(((Float) this.f56596c.h()).floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }

    public void c(LottieValueCallback lottieValueCallback) {
        this.f56595b.n(lottieValueCallback);
    }

    public void d(LottieValueCallback lottieValueCallback) {
        this.f56597d.n(lottieValueCallback);
    }

    public void e(LottieValueCallback lottieValueCallback) {
        this.f56598e.n(lottieValueCallback);
    }

    public void f(final LottieValueCallback lottieValueCallback) {
        if (lottieValueCallback == null) {
            this.f56596c.n(null);
        } else {
            this.f56596c.n(new LottieValueCallback<Float>() { // from class: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1
                @Override // com.airbnb.lottie.value.LottieValueCallback
                /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                public Float a(LottieFrameInfo lottieFrameInfo) {
                    Float f3 = (Float) lottieValueCallback.a(lottieFrameInfo);
                    if (f3 == null) {
                        return null;
                    }
                    return Float.valueOf(f3.floatValue() * 2.55f);
                }
            });
        }
    }

    public void g(LottieValueCallback lottieValueCallback) {
        this.f56599f.n(lottieValueCallback);
    }
}
