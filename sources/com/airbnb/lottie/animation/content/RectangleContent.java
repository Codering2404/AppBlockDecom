package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f56538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f56539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LottieDrawable f56540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseKeyframeAnimation f56541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BaseKeyframeAnimation f56542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BaseKeyframeAnimation f56543h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f56546k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56536a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f56537b = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CompoundTrimPathContent f56544i = new CompoundTrimPathContent();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BaseKeyframeAnimation f56545j = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.f56538c = rectangleShape.c();
        this.f56539d = rectangleShape.f();
        this.f56540e = lottieDrawable;
        BaseKeyframeAnimation baseKeyframeAnimationA = rectangleShape.d().a();
        this.f56541f = baseKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA2 = rectangleShape.e().a();
        this.f56542g = baseKeyframeAnimationA2;
        BaseKeyframeAnimation baseKeyframeAnimationA3 = rectangleShape.b().a();
        this.f56543h = baseKeyframeAnimationA3;
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseLayer.j(baseKeyframeAnimationA3);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        baseKeyframeAnimationA3.a(this);
    }

    private void h() {
        this.f56546k = false;
        this.f56540e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.List r5, java.util.List r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            int r0 = r5.size()
            if (r6 >= r0) goto L34
            java.lang.Object r0 = r5.get(r6)
            com.airbnb.lottie.animation.content.Content r0 = (com.airbnb.lottie.animation.content.Content) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r1 == 0) goto L25
            r1 = r0
            com.airbnb.lottie.animation.content.TrimPathContent r1 = (com.airbnb.lottie.animation.content.TrimPathContent) r1
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r2 = r1.k()
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r3 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.SIMULTANEOUSLY
            if (r2 != r3) goto L25
            com.airbnb.lottie.animation.content.CompoundTrimPathContent r0 = r4.f56544i
            r0.a(r1)
            r1.d(r4)
            goto L31
        L25:
            boolean r1 = r0 instanceof com.airbnb.lottie.animation.content.RoundedCornersContent
            if (r1 == 0) goto L31
            com.airbnb.lottie.animation.content.RoundedCornersContent r0 = (com.airbnb.lottie.animation.content.RoundedCornersContent) r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r0 = r0.h()
            r4.f56545j = r0
        L31:
            int r6 = r6 + 1
            goto L1
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.RectangleContent.b(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        if (obj == LottieProperty.f56368l) {
            this.f56542g.n(lottieValueCallback);
        } else if (obj == LottieProperty.f56370n) {
            this.f56541f.n(lottieValueCallback);
        } else if (obj == LottieProperty.f56369m) {
            this.f56543h.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i3, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        BaseKeyframeAnimation baseKeyframeAnimation;
        if (this.f56546k) {
            return this.f56536a;
        }
        this.f56536a.reset();
        if (this.f56539d) {
            this.f56546k = true;
            return this.f56536a;
        }
        PointF pointF = (PointF) this.f56542g.h();
        float f3 = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56543h;
        float fP = baseKeyframeAnimation2 == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation2).p();
        if (fP == 0.0f && (baseKeyframeAnimation = this.f56545j) != null) {
            fP = Math.min(((Float) baseKeyframeAnimation.h()).floatValue(), Math.min(f3, f4));
        }
        float fMin = Math.min(f3, f4);
        if (fP > fMin) {
            fP = fMin;
        }
        PointF pointF2 = (PointF) this.f56541f.h();
        this.f56536a.moveTo(pointF2.x + f3, (pointF2.y - f4) + fP);
        this.f56536a.lineTo(pointF2.x + f3, (pointF2.y + f4) - fP);
        if (fP > 0.0f) {
            RectF rectF = this.f56537b;
            float f5 = pointF2.x;
            float f6 = fP * 2.0f;
            float f7 = pointF2.y;
            rectF.set((f5 + f3) - f6, (f7 + f4) - f6, f5 + f3, f7 + f4);
            this.f56536a.arcTo(this.f56537b, 0.0f, 90.0f, false);
        }
        this.f56536a.lineTo((pointF2.x - f3) + fP, pointF2.y + f4);
        if (fP > 0.0f) {
            RectF rectF2 = this.f56537b;
            float f8 = pointF2.x;
            float f9 = pointF2.y;
            float f10 = fP * 2.0f;
            rectF2.set(f8 - f3, (f9 + f4) - f10, (f8 - f3) + f10, f9 + f4);
            this.f56536a.arcTo(this.f56537b, 90.0f, 90.0f, false);
        }
        this.f56536a.lineTo(pointF2.x - f3, (pointF2.y - f4) + fP);
        if (fP > 0.0f) {
            RectF rectF3 = this.f56537b;
            float f11 = pointF2.x;
            float f12 = pointF2.y;
            float f13 = fP * 2.0f;
            rectF3.set(f11 - f3, f12 - f4, (f11 - f3) + f13, (f12 - f4) + f13);
            this.f56536a.arcTo(this.f56537b, 180.0f, 90.0f, false);
        }
        this.f56536a.lineTo((pointF2.x + f3) - fP, pointF2.y - f4);
        if (fP > 0.0f) {
            RectF rectF4 = this.f56537b;
            float f14 = pointF2.x;
            float f15 = fP * 2.0f;
            float f16 = pointF2.y;
            rectF4.set((f14 + f3) - f15, f16 - f4, f14 + f3, (f16 - f4) + f15);
            this.f56536a.arcTo(this.f56537b, 270.0f, 90.0f, false);
        }
        this.f56536a.close();
        this.f56544i.b(this.f56536a);
        this.f56546k = true;
        return this.f56536a;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56538c;
    }
}
