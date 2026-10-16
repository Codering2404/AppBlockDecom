package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    float q(Keyframe keyframe, float f3) {
        float f4;
        if (keyframe.f57111b == null || keyframe.f57112c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback lottieValueCallback = this.f56584e;
        if (lottieValueCallback != null) {
            f4 = f3;
            Float f5 = (Float) lottieValueCallback.b(keyframe.f57116g, keyframe.f57117h.floatValue(), (Float) keyframe.f57111b, (Float) keyframe.f57112c, f4, e(), f());
            if (f5 != null) {
                return f5.floatValue();
            }
        } else {
            f4 = f3;
        }
        return MiscUtils.i(keyframe.g(), keyframe.d(), f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(Keyframe keyframe, float f3) {
        return Float.valueOf(q(keyframe, f3));
    }
}
