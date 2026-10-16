package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f56451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f56452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f56453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Path f56454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f56455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f56456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f56457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f56458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LottieDrawable f56459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f56460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TransformKeyframeAnimation f56461k;

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup, LottieComposition lottieComposition) {
        this(lottieDrawable, baseLayer, shapeGroup.c(), shapeGroup.d(), h(lottieDrawable, lottieComposition, baseLayer, shapeGroup.b()), j(shapeGroup.b()));
    }

    private static List h(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            Content contentA = ((ContentModel) list.get(i3)).a(lottieDrawable, lottieComposition, baseLayer);
            if (contentA != null) {
                arrayList.add(contentA);
            }
        }
        return arrayList;
    }

    static AnimatableTransform j(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            ContentModel contentModel = (ContentModel) list.get(i3);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean n() {
        int i3 = 0;
        for (int i4 = 0; i4 < this.f56458h.size(); i4++) {
            if ((this.f56458h.get(i4) instanceof DrawingContent) && (i3 = i3 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        this.f56459i.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f56458h.size());
        arrayList.addAll(list);
        for (int size = this.f56458h.size() - 1; size >= 0; size--) {
            Content content = (Content) this.f56458h.get(size);
            content.b(arrayList, this.f56458h.subList(0, size));
            arrayList.add(content);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(Object obj, LottieValueCallback lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f56461k;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.c(obj, lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void e(KeyPath keyPath, int i3, List list, KeyPath keyPath2) {
        if (keyPath.g(getName(), i3) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.a(getName());
                if (keyPath.c(getName(), i3)) {
                    list.add(keyPath2.i(this));
                }
            }
            if (keyPath.h(getName(), i3)) {
                int iE = i3 + keyPath.e(getName(), i3);
                for (int i4 = 0; i4 < this.f56458h.size(); i4++) {
                    Content content = (Content) this.f56458h.get(i4);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).e(keyPath, iE, list, keyPath2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void f(RectF rectF, Matrix matrix, boolean z2) {
        this.f56453c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f56461k;
        if (transformKeyframeAnimation != null) {
            this.f56453c.preConcat(transformKeyframeAnimation.f());
        }
        this.f56455e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f56458h.size() - 1; size >= 0; size--) {
            Content content = (Content) this.f56458h.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).f(this.f56455e, this.f56453c, z2);
                rectF.union(this.f56455e);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path g() {
        this.f56453c.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f56461k;
        if (transformKeyframeAnimation != null) {
            this.f56453c.set(transformKeyframeAnimation.f());
        }
        this.f56454d.reset();
        if (this.f56457g) {
            return this.f56454d;
        }
        for (int size = this.f56458h.size() - 1; size >= 0; size--) {
            Content content = (Content) this.f56458h.get(size);
            if (content instanceof PathContent) {
                this.f56454d.addPath(((PathContent) content).g(), this.f56453c);
            }
        }
        return this.f56454d;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f56456f;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void i(Canvas canvas, Matrix matrix, int i3) {
        if (this.f56457g) {
            return;
        }
        this.f56453c.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.f56461k;
        if (transformKeyframeAnimation != null) {
            this.f56453c.preConcat(transformKeyframeAnimation.f());
            i3 = (int) (((((this.f56461k.h() == null ? 100 : ((Integer) this.f56461k.h().h()).intValue()) / 100.0f) * i3) / 255.0f) * 255.0f);
        }
        boolean z2 = this.f56459i.Y() && n() && i3 != 255;
        if (z2) {
            this.f56452b.set(0.0f, 0.0f, 0.0f, 0.0f);
            f(this.f56452b, this.f56453c, true);
            this.f56451a.setAlpha(i3);
            Utils.l(canvas, this.f56452b, this.f56451a);
        }
        if (z2) {
            i3 = 255;
        }
        for (int size = this.f56458h.size() - 1; size >= 0; size--) {
            Object obj = this.f56458h.get(size);
            if (obj instanceof DrawingContent) {
                ((DrawingContent) obj).i(canvas, this.f56453c, i3);
            }
        }
        if (z2) {
            canvas.restore();
        }
    }

    public List k() {
        return this.f56458h;
    }

    List l() {
        if (this.f56460j == null) {
            this.f56460j = new ArrayList();
            for (int i3 = 0; i3 < this.f56458h.size(); i3++) {
                Content content = (Content) this.f56458h.get(i3);
                if (content instanceof PathContent) {
                    this.f56460j.add((PathContent) content);
                }
            }
        }
        return this.f56460j;
    }

    Matrix m() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f56461k;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.f();
        }
        this.f56453c.reset();
        return this.f56453c;
    }

    ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z2, List list, AnimatableTransform animatableTransform) {
        this.f56451a = new LPaint();
        this.f56452b = new RectF();
        this.f56453c = new Matrix();
        this.f56454d = new Path();
        this.f56455e = new RectF();
        this.f56456f = str;
        this.f56459i = lottieDrawable;
        this.f56457g = z2;
        this.f56458h = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimationB = animatableTransform.b();
            this.f56461k = transformKeyframeAnimationB;
            transformKeyframeAnimationB.a(baseLayer);
            this.f56461k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = (Content) list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).h(list.listIterator(list.size()));
        }
    }
}
