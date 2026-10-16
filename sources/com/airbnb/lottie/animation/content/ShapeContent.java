package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.layer.BaseLayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f56562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f56563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LottieDrawable f56564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ShapeKeyframeAnimation f56565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f56566f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f56561a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CompoundTrimPathContent f56567g = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.f56562b = shapePath.b();
        this.f56563c = shapePath.d();
        this.f56564d = lottieDrawable;
        ShapeKeyframeAnimation shapeKeyframeAnimationA = shapePath.c().a();
        this.f56565e = shapeKeyframeAnimationA;
        baseLayer.j(shapeKeyframeAnimationA);
        shapeKeyframeAnimationA.a(this);
    }

    private void d() {
        this.f56566f = false;
        this.f56564d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.List r6, java.util.List r7) {
        /*
            r5 = this;
            r7 = 0
            r0 = 0
        L2:
            int r1 = r6.size()
            if (r0 >= r1) goto L39
            java.lang.Object r1 = r6.get(r0)
            com.airbnb.lottie.animation.content.Content r1 = (com.airbnb.lottie.animation.content.Content) r1
            boolean r2 = r1 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r2 == 0) goto L26
            r2 = r1
            com.airbnb.lottie.animation.content.TrimPathContent r2 = (com.airbnb.lottie.animation.content.TrimPathContent) r2
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r3 = r2.k()
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r4 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.SIMULTANEOUSLY
            if (r3 != r4) goto L26
            com.airbnb.lottie.animation.content.CompoundTrimPathContent r1 = r5.f56567g
            r1.a(r2)
            r2.d(r5)
            goto L36
        L26:
            boolean r2 = r1 instanceof com.airbnb.lottie.animation.content.ShapeModifierContent
            if (r2 == 0) goto L36
            if (r7 != 0) goto L31
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L31:
            com.airbnb.lottie.animation.content.ShapeModifierContent r1 = (com.airbnb.lottie.animation.content.ShapeModifierContent) r1
            r7.add(r1)
        L36:
            int r0 = r0 + 1
            goto L2
        L39:
            com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation r6 = r5.f56565e
            r6.q(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.ShapeContent.b(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        if (this.f56566f) {
            return this.f56561a;
        }
        this.f56561a.reset();
        if (this.f56563c) {
            this.f56566f = true;
            return this.f56561a;
        }
        Path path = (Path) this.f56565e.h();
        if (path == null) {
            return this.f56561a;
        }
        this.f56561a.set(path);
        this.f56561a.setFillType(Path.FillType.EVEN_ODD);
        this.f56567g.b(this.f56561a);
        this.f56566f = true;
        return this.f56561a;
    }
}
