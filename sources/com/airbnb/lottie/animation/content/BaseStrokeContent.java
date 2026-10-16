package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LottieDrawable f56435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final BaseLayer f56436f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f56438h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Paint f56439i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BaseKeyframeAnimation f56440j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BaseKeyframeAnimation f56441k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f56442l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final BaseKeyframeAnimation f56443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private BaseKeyframeAnimation f56444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private BaseKeyframeAnimation f56445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f56446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private DropShadowKeyframeAnimation f56447q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PathMeasure f56431a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f56432b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f56433c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f56434d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f56437g = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PathGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f56448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TrimPathContent f56449b;

        private PathGroup(TrimPathContent trimPathContent) {
            this.f56448a = new ArrayList();
            this.f56449b = trimPathContent;
        }
    }

    BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f3, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f56439i = lPaint;
        this.f56446p = 0.0f;
        this.f56435e = lottieDrawable;
        this.f56436f = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f3);
        this.f56441k = animatableIntegerValue.a();
        this.f56440j = animatableFloatValue.a();
        if (animatableFloatValue2 == null) {
            this.f56443m = null;
        } else {
            this.f56443m = animatableFloatValue2.a();
        }
        this.f56442l = new ArrayList(list.size());
        this.f56438h = new float[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f56442l.add(((AnimatableFloatValue) list.get(i3)).a());
        }
        baseLayer.j(this.f56441k);
        baseLayer.j(this.f56440j);
        for (int i4 = 0; i4 < this.f56442l.size(); i4++) {
            baseLayer.j((BaseKeyframeAnimation) this.f56442l.get(i4));
        }
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56443m;
        if (baseKeyframeAnimation != null) {
            baseLayer.j(baseKeyframeAnimation);
        }
        this.f56441k.a(this);
        this.f56440j.a(this);
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((BaseKeyframeAnimation) this.f56442l.get(i5)).a(this);
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56443m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.a(this);
        }
        if (baseLayer.w() != null) {
            BaseKeyframeAnimation baseKeyframeAnimationA = baseLayer.w().a().a();
            this.f56445o = baseKeyframeAnimationA;
            baseKeyframeAnimationA.a(this);
            baseLayer.j(this.f56445o);
        }
        if (baseLayer.y() != null) {
            this.f56447q = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.y());
        }
    }

    private void h(Matrix matrix) {
        L.a("StrokeContent#applyDashPattern");
        if (this.f56442l.isEmpty()) {
            L.b("StrokeContent#applyDashPattern");
            return;
        }
        float f3 = Utils.f(matrix);
        for (int i3 = 0; i3 < this.f56442l.size(); i3++) {
            this.f56438h[i3] = ((Float) ((BaseKeyframeAnimation) this.f56442l.get(i3)).h()).floatValue();
            if (i3 % 2 == 0) {
                float[] fArr = this.f56438h;
                if (fArr[i3] < 1.0f) {
                    fArr[i3] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f56438h;
                if (fArr2[i3] < 0.1f) {
                    fArr2[i3] = 0.1f;
                }
            }
            float[] fArr3 = this.f56438h;
            fArr3[i3] = fArr3[i3] * f3;
        }
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56443m;
        this.f56439i.setPathEffect(new DashPathEffect(this.f56438h, baseKeyframeAnimation == null ? 0.0f : f3 * ((Float) baseKeyframeAnimation.h()).floatValue()));
        L.b("StrokeContent#applyDashPattern");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(android.graphics.Canvas r17, com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup r18, android.graphics.Matrix r19) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.BaseStrokeContent.j(android.graphics.Canvas, com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup, android.graphics.Matrix):void");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56435e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.List r8, java.util.List r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            com.airbnb.lottie.animation.content.Content r3 = (com.airbnb.lottie.animation.content.Content) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r4 == 0) goto L1f
            com.airbnb.lottie.animation.content.TrimPathContent r3 = (com.airbnb.lottie.animation.content.TrimPathContent) r3
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r4 = r3.k()
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r5 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.d(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            com.airbnb.lottie.animation.content.Content r3 = (com.airbnb.lottie.animation.content.Content) r3
            boolean r4 = r3 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r4 == 0) goto L55
            r4 = r3
            com.airbnb.lottie.animation.content.TrimPathContent r4 = (com.airbnb.lottie.animation.content.TrimPathContent) r4
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r5 = r4.k()
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r6 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List r3 = r7.f56437g
            r3.add(r0)
        L4c:
            com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup r0 = new com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup
            r0.<init>(r4)
            r4.d(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof com.airbnb.lottie.animation.content.PathContent
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup r0 = new com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup
            r0.<init>(r2)
        L60:
            java.util.List r4 = com.airbnb.lottie.animation.content.BaseStrokeContent.PathGroup.a(r0)
            com.airbnb.lottie.animation.content.PathContent r3 = (com.airbnb.lottie.animation.content.PathContent) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List r8 = r7.f56437g
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.BaseStrokeContent.b(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (obj == LottieProperty.f56360d) {
            this.f56441k.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.f56375s) {
            this.f56440j.n(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.K) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f56444n;
            if (baseKeyframeAnimation != null) {
                this.f56436f.G(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f56444n = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56444n = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a(this);
            this.f56436f.j(this.f56444n);
            return;
        }
        if (obj == LottieProperty.f56366j) {
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56445o;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.n(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.f56445o = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            this.f56436f.j(this.f56445o);
            return;
        }
        if (obj == LottieProperty.f56361e && (dropShadowKeyframeAnimation5 = this.f56447q) != null) {
            dropShadowKeyframeAnimation5.c(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.G && (dropShadowKeyframeAnimation4 = this.f56447q) != null) {
            dropShadowKeyframeAnimation4.f(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.H && (dropShadowKeyframeAnimation3 = this.f56447q) != null) {
            dropShadowKeyframeAnimation3.d(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.I && (dropShadowKeyframeAnimation2 = this.f56447q) != null) {
            dropShadowKeyframeAnimation2.e(lottieValueCallback);
        } else {
            if (obj != LottieProperty.J || (dropShadowKeyframeAnimation = this.f56447q) == null) {
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
        L.a("StrokeContent#getBounds");
        this.f56432b.reset();
        for (int i3 = 0; i3 < this.f56437g.size(); i3++) {
            PathGroup pathGroup = (PathGroup) this.f56437g.get(i3);
            for (int i4 = 0; i4 < pathGroup.f56448a.size(); i4++) {
                this.f56432b.addPath(((PathContent) pathGroup.f56448a.get(i4)).g(), matrix);
            }
        }
        this.f56432b.computeBounds(this.f56434d, false);
        float fP = ((FloatKeyframeAnimation) this.f56440j).p();
        RectF rectF2 = this.f56434d;
        float f3 = fP / 2.0f;
        rectF2.set(rectF2.left - f3, rectF2.top - f3, rectF2.right + f3, rectF2.bottom + f3);
        rectF.set(this.f56434d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.b("StrokeContent#getBounds");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        L.a("StrokeContent#draw");
        if (Utils.g(matrix)) {
            L.b("StrokeContent#draw");
            return;
        }
        this.f56439i.setAlpha(MiscUtils.c((int) ((((i3 / 255.0f) * ((IntegerKeyframeAnimation) this.f56441k).p()) / 100.0f) * 255.0f), 0, 255));
        this.f56439i.setStrokeWidth(((FloatKeyframeAnimation) this.f56440j).p() * Utils.f(matrix));
        if (this.f56439i.getStrokeWidth() <= 0.0f) {
            L.b("StrokeContent#draw");
            return;
        }
        h(matrix);
        BaseKeyframeAnimation baseKeyframeAnimation = this.f56444n;
        if (baseKeyframeAnimation != null) {
            this.f56439i.setColorFilter((ColorFilter) baseKeyframeAnimation.h());
        }
        BaseKeyframeAnimation baseKeyframeAnimation2 = this.f56445o;
        if (baseKeyframeAnimation2 != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation2.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.f56439i.setMaskFilter(null);
            } else if (fFloatValue != this.f56446p) {
                this.f56439i.setMaskFilter(this.f56436f.x(fFloatValue));
            }
            this.f56446p = fFloatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f56447q;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.b(this.f56439i);
        }
        for (int i4 = 0; i4 < this.f56437g.size(); i4++) {
            PathGroup pathGroup = (PathGroup) this.f56437g.get(i4);
            if (pathGroup.f56449b != null) {
                j(canvas, pathGroup, matrix);
            } else {
                L.a("StrokeContent#buildPath");
                this.f56432b.reset();
                for (int size = pathGroup.f56448a.size() - 1; size >= 0; size--) {
                    this.f56432b.addPath(((PathContent) pathGroup.f56448a.get(size)).g(), matrix);
                }
                L.b("StrokeContent#buildPath");
                L.a("StrokeContent#drawPath");
                canvas.drawPath(this.f56432b, this.f56439i);
                L.b("StrokeContent#drawPath");
            }
        }
        L.b("StrokeContent#draw");
    }
}
