package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GradientColor f56603i;

    public GradientColorKeyframeAnimation(List list) {
        super(list);
        GradientColor gradientColor = (GradientColor) ((Keyframe) list.get(0)).f57111b;
        int iE = gradientColor != null ? gradientColor.e() : 0;
        this.f56603i = new GradientColor(new float[iE], new int[iE]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public GradientColor i(Keyframe keyframe, float f3) {
        this.f56603i.f((GradientColor) keyframe.f57111b, (GradientColor) keyframe.f57112c, f3);
        return this.f56603i;
    }
}
