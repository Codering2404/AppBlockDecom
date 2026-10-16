package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ShapeData f56615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f56616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f56617k;

    public ShapeKeyframeAnimation(List list) {
        super(list);
        this.f56615i = new ShapeData();
        this.f56616j = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(Keyframe keyframe, float f3) {
        this.f56615i.c((ShapeData) keyframe.f57111b, (ShapeData) keyframe.f57112c, f3);
        ShapeData shapeDataC = this.f56615i;
        List list = this.f56617k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                shapeDataC = ((ShapeModifierContent) this.f56617k.get(size)).c(shapeDataC);
            }
        }
        MiscUtils.h(shapeDataC, this.f56616j);
        return this.f56616j;
    }

    public void q(List list) {
        this.f56617k = list;
    }
}
