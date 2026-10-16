package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f56471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BaseLayer f56472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f56473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f56474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f56475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BaseKeyframeAnimation f56476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BaseKeyframeAnimation f56477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BaseKeyframeAnimation f56478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LottieDrawable f56479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private BaseKeyframeAnimation f56480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f56481l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private DropShadowKeyframeAnimation f56482m;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path = new Path();
        this.f56470a = path;
        this.f56471b = new LPaint(1);
        this.f56475f = new ArrayList();
        this.f56472c = baseLayer;
        this.f56473d = shapeFill.d();
        this.f56474e = shapeFill.f();
        this.f56479j = lottieDrawable;
        if (baseLayer.w() != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA = baseLayer.w().a().a();
            this.f56480k = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            baseLayer.j(this.f56480k);
        }
        if (baseLayer.y() != null) {
            this.f56482m = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.y());
        }
        if (shapeFill.b() == null || shapeFill.e() == null) {
            this.f56476g = null;
            this.f56477h = null;
            return;
        }
        path.setFillType(shapeFill.c());
        BaseKeyframeAnimation baseKeyframeAnimationA2 = shapeFill.b().a();
        this.f56476g = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.j(baseKeyframeAnimationA2);
        BaseKeyframeAnimation baseKeyframeAnimationA3 = shapeFill.e().a();
        this.f56477h = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.j(baseKeyframeAnimationA3);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56479j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        for (int i3 = 0; i3 < list2.size(); i3++) {
            Content content = (Content) list2.get(i3);
            if (content instanceof PathContent) {
                this.f56475f.add((PathContent) content);
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
        if (obj == LottieProperty.f56357a) {
            this.f56476g.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.f56360d) {
            this.f56477h.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.K) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f56478i;
            if (baseKeyframeAnimation != null) {
                this.f56472c.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f56478i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56478i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f56472c.j(this.f56478i);
            return;
        }
        if (obj == LottieProperty.f56366j) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56480k;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.n(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56480k = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f56472c.j(this.f56480k);
            return;
        }
        if (obj == LottieProperty.f56361e && (dropShadowKeyframeAnimation5 = this.f56482m) != null) {
            dropShadowKeyframeAnimation5.c(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.G && (dropShadowKeyframeAnimation4 = this.f56482m) != null) {
            dropShadowKeyframeAnimation4.f(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.H && (dropShadowKeyframeAnimation3 = this.f56482m) != null) {
            dropShadowKeyframeAnimation3.d(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.I && (dropShadowKeyframeAnimation2 = this.f56482m) != null) {
            dropShadowKeyframeAnimation2.e(lottieValueCallback);
        } else {
            if (obj != LottieProperty.J || (dropShadowKeyframeAnimation = this.f56482m) == null) {
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
        this.f56470a.reset();
        for (int i3 = 0; i3 < this.f56475f.size(); i3++) {
            this.f56470a.addPath(((PathContent) this.f56475f.get(i3)).g(), matrix);
        }
        this.f56470a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56473d;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f56474e) {
            return;
        }
        L.a("FillContent#draw");
        this.f56471b.setColor((MiscUtils.c((int) ((((i3 / 255.0f) * ((Integer) this.f56477h.h()).intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((ColorKeyframeAnimation) this.f56476g).p() & 16777215));
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56478i;
        if (baseKeyframeAnimation != null) {
            this.f56471b.setColorFilter((ColorFilter) baseKeyframeAnimation.h());
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56480k;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation2.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.f56471b.setMaskFilter(null);
            } else if (fFloatValue != this.f56481l) {
                this.f56471b.setMaskFilter(this.f56472c.x(fFloatValue));
            }
            this.f56481l = fFloatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f56482m;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.b(this.f56471b);
        }
        this.f56470a.reset();
        for (int i4 = 0; i4 < this.f56475f.size(); i4++) {
            this.f56470a.addPath(((PathContent) this.f56475f.get(i4)).g(), matrix);
        }
        canvas.drawPath(this.f56470a, this.f56471b);
        L.b("FillContent#draw");
    }
}
