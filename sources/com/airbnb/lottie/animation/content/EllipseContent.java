package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f56463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LottieDrawable f56464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BaseKeyframeAnimation f56465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BaseKeyframeAnimation f56466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CircleShape f56467f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f56469h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56462a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CompoundTrimPathContent f56468g = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.f56463b = circleShape.b();
        this.f56464c = lottieDrawable;
        BaseKeyframeAnimation baseKeyframeAnimationA = circleShape.d().a();
        this.f56465d = baseKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA2 = circleShape.c().a();
        this.f56466e = baseKeyframeAnimationA2;
        this.f56467f = circleShape;
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
    }

    private void h() {
        this.f56469h = false;
        this.f56464c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        h();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Content content = (Content) list.get(i3);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.k() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f56468g.a(trimPathContent);
                    trimPathContent.d(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        if (obj == LottieProperty.f56367k) {
            this.f56465d.n(lottieValueCallback);
        } else if (obj == LottieProperty.f56370n) {
            this.f56466e.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i3, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        if (this.f56469h) {
            return this.f56462a;
        }
        this.f56462a.reset();
        if (this.f56467f.e()) {
            this.f56469h = true;
            return this.f56462a;
        }
        PointF pointF = (PointF) this.f56465d.h();
        float f3 = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        float f5 = f3 * 0.55228f;
        float f6 = 0.55228f * f4;
        this.f56462a.reset();
        if (this.f56467f.f()) {
            float f7 = -f4;
            this.f56462a.moveTo(0.0f, f7);
            float f8 = 0.0f - f5;
            float f9 = -f3;
            float f10 = 0.0f - f6;
            this.f56462a.cubicTo(f8, f7, f9, f10, f9, 0.0f);
            float f11 = f6 + 0.0f;
            this.f56462a.cubicTo(f9, f11, f8, f4, 0.0f, f4);
            float f12 = f5 + 0.0f;
            this.f56462a.cubicTo(f12, f4, f3, f11, f3, 0.0f);
            this.f56462a.cubicTo(f3, f10, f12, f7, 0.0f, f7);
        } else {
            float f13 = -f4;
            this.f56462a.moveTo(0.0f, f13);
            float f14 = f5 + 0.0f;
            float f15 = 0.0f - f6;
            this.f56462a.cubicTo(f14, f13, f3, f15, f3, 0.0f);
            float f16 = f6 + 0.0f;
            this.f56462a.cubicTo(f3, f16, f14, f4, 0.0f, f4);
            float f17 = 0.0f - f5;
            float f18 = -f3;
            this.f56462a.cubicTo(f17, f4, f18, f16, f18, 0.0f);
            this.f56462a.cubicTo(f18, f15, f17, f13, 0.0f, f13);
        }
        PointF pointF2 = (PointF) this.f56466e.h();
        this.f56462a.offset(pointF2.x, pointF2.y);
        this.f56462a.close();
        this.f56468g.b(this.f56462a);
        this.f56469h = true;
        return this.f56462a;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56463b;
    }
}
