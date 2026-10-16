package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StrokeContent extends BaseStrokeContent {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final BaseLayer f56568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f56569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final boolean f56570t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final BaseKeyframeAnimation f56571u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BaseKeyframeAnimation f56572v;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.b().b(), shapeStroke.e().b(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f56568r = baseLayer;
        this.f56569s = shapeStroke.h();
        this.f56570t = shapeStroke.k();
        BaseKeyframeAnimation baseKeyframeAnimationA = shapeStroke.c().a();
        this.f56571u = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.j(baseKeyframeAnimationA);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        super.d(obj, lottieValueCallback);
        if (obj == LottieProperty.f56358b) {
            this.f56571u.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.K) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f56572v;
            if (baseKeyframeAnimation != null) {
                this.f56568r.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f56572v = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56572v = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f56568r.j(this.f56571u);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56569s;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f56570t) {
            return;
        }
        this.f56439i.setColor(((ColorKeyframeAnimation) this.f56571u).p());
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56572v;
        if (baseKeyframeAnimation != null) {
            this.f56439i.setColorFilter((ColorFilter) baseKeyframeAnimation.h());
        }
        super.i(canvas, matrix, i3);
    }
}
