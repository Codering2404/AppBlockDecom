package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f56547a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f56548b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LottieDrawable f56549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BaseLayer f56550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f56551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f56552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BaseKeyframeAnimation f56553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final BaseKeyframeAnimation f56554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TransformKeyframeAnimation f56555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ContentGroup f56556j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f56549c = lottieDrawable;
        this.f56550d = baseLayer;
        this.f56551e = repeater.c();
        this.f56552f = repeater.f();
        BaseKeyframeAnimation baseKeyframeAnimationA = repeater.b().a();
        this.f56553g = baseKeyframeAnimationA;
        baseLayer.j(baseKeyframeAnimationA);
        baseKeyframeAnimationA.a(this);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = repeater.d().a();
        this.f56554h = baseKeyframeAnimationA2;
        baseLayer.j(baseKeyframeAnimationA2);
        baseKeyframeAnimationA2.a(this);
        TransformKeyframeAnimation transformKeyframeAnimationB = repeater.e().b();
        this.f56555i = transformKeyframeAnimationB;
        transformKeyframeAnimationB.a(baseLayer);
        transformKeyframeAnimationB.b(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56549c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        this.f56556j.b(list, list2);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        if (this.f56555i.c(obj, lottieValueCallback)) {
            return;
        }
        if (obj == LottieProperty.f56377u) {
            this.f56553g.n(lottieValueCallback);
        } else if (obj == LottieProperty.f56378v) {
            this.f56554h.n(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        MiscUtils.k(keyPath, i3, list, keyPath2, this);
        for (int i4 = 0; i4 < this.f56556j.k().size(); i4++) {
            Content content = (Content) this.f56556j.k().get(i4);
            if (content instanceof KeyPathElementContent) {
                MiscUtils.k(keyPath, i3, list, keyPath2, (KeyPathElementContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        this.f56556j.f(rectF, matrix, z2);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        Path pathG = this.f56556j.g();
        this.f56548b.reset();
        float fFloatValue = ((Float) this.f56553g.h()).floatValue();
        float fFloatValue2 = ((Float) this.f56554h.h()).floatValue();
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            this.f56547a.set(this.f56555i.g(i3 + fFloatValue2));
            this.f56548b.addPath(pathG, this.f56547a);
        }
        return this.f56548b;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56551e;
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void h(ListIterator listIterator) {
        if (this.f56556j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((Content) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f56556j = new ContentGroup(this.f56549c, this.f56550d, "Repeater", this.f56552f, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        float fFloatValue = ((Float) this.f56553g.h()).floatValue();
        float fFloatValue2 = ((Float) this.f56554h.h()).floatValue();
        float fFloatValue3 = ((Float) this.f56555i.i().h()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) this.f56555i.e().h()).floatValue() / 100.0f;
        for (int i4 = ((int) fFloatValue) - 1; i4 >= 0; i4--) {
            this.f56547a.set(matrix);
            float f3 = i4;
            this.f56547a.preConcat(this.f56555i.g(f3 + fFloatValue2));
            this.f56556j.i(canvas, this.f56547a, (int) (i3 * MiscUtils.i(fFloatValue3, fFloatValue4, f3 / fFloatValue)));
        }
    }
}
