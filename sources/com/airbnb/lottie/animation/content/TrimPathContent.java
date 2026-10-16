package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f56573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f56574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f56575c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShapeTrimPath.Type f56576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BaseKeyframeAnimation f56577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseKeyframeAnimation f56578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BaseKeyframeAnimation f56579g;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.f56573a = shapeTrimPath.c();
        this.f56574b = shapeTrimPath.g();
        this.f56576d = shapeTrimPath.f();
        BaseKeyframeAnimation baseKeyframeAnimationA = shapeTrimPath.e().a();
        this.f56577e = baseKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA2 = shapeTrimPath.b().a();
        this.f56578f = baseKeyframeAnimationA2;
        BaseKeyframeAnimation baseKeyframeAnimationA3 = shapeTrimPath.d().a();
        this.f56579g = baseKeyframeAnimationA3;
        baseLayer.j(baseKeyframeAnimationA);
        baseLayer.j(baseKeyframeAnimationA2);
        baseLayer.j(baseKeyframeAnimationA3);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        baseKeyframeAnimationA3.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void a() {
        for (int i3 = 0; i3 < this.f56575c.size(); i3++) {
            ((BaseKeyframeAnimation.AnimationListener) this.f56575c.get(i3)).a();
        }
    }

    void d(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.f56575c.add(animationListener);
    }

    public BaseKeyframeAnimation e() {
        return this.f56578f;
    }

    public BaseKeyframeAnimation h() {
        return this.f56579g;
    }

    public BaseKeyframeAnimation j() {
        return this.f56577e;
    }

    ShapeTrimPath.Type k() {
        return this.f56576d;
    }

    public boolean l() {
        return this.f56574b;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List list, List list2) {
    }
}
