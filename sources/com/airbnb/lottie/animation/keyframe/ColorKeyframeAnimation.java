package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(Keyframe keyframe, float f3) {
        float f4;
        if (keyframe.f57111b == null || keyframe.f57112c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback lottieValueCallback = this.f56584e;
        if (lottieValueCallback != null) {
            f4 = f3;
            Integer num = (Integer) lottieValueCallback.b(keyframe.f57116g, keyframe.f57117h.floatValue(), (Integer) keyframe.f57111b, (Integer) keyframe.f57112c, f4, e(), f());
            if (num != null) {
                return num.intValue();
            }
        } else {
            f4 = f3;
        }
        return GammaEvaluator.c(MiscUtils.b(f4, 0.0f, 1.0f), ((Integer) keyframe.f57111b).intValue(), ((Integer) keyframe.f57112c).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(Keyframe keyframe, float f3) {
        return Integer.valueOf(q(keyframe, f3));
    }
}
