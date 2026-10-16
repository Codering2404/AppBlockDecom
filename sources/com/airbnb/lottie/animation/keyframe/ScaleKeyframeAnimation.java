package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScaleXY f56614i;

    public ScaleKeyframeAnimation(List list) {
        super(list);
        this.f56614i = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ScaleXY i(Keyframe keyframe, float f3) {
        Object obj;
        float f4;
        Object obj2 = keyframe.f57111b;
        if (obj2 == null || (obj = keyframe.f57112c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY = (ScaleXY) obj2;
        ScaleXY scaleXY2 = (ScaleXY) obj;
        LottieValueCallback lottieValueCallback = this.f56584e;
        if (lottieValueCallback != null) {
            f4 = f3;
            ScaleXY scaleXY3 = (ScaleXY) lottieValueCallback.b(keyframe.f57116g, keyframe.f57117h.floatValue(), scaleXY, scaleXY2, f4, e(), f());
            if (scaleXY3 != null) {
                return scaleXY3;
            }
        } else {
            f4 = f3;
        }
        this.f56614i.d(MiscUtils.i(scaleXY.b(), scaleXY2.b(), f4), MiscUtils.i(scaleXY.c(), scaleXY2.c(), f4));
        return this.f56614i;
    }
}
