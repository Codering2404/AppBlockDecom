package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    public AnimatableGradientColorValue(List list) {
        super(e(list));
    }

    private static Keyframe d(Keyframe keyframe) {
        GradientColor gradientColor = (GradientColor) keyframe.f57111b;
        GradientColor gradientColor2 = (GradientColor) keyframe.f57112c;
        if (gradientColor == null || gradientColor2 == null || gradientColor.d().length == gradientColor2.d().length) {
            return keyframe;
        }
        float[] fArrF = f(gradientColor.d(), gradientColor2.d());
        return keyframe.b(gradientColor.a(fArrF), gradientColor2.a(fArrF));
    }

    private static List e(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            list.set(i3, d((Keyframe) list.get(i3)));
        }
        return list;
    }

    static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f3 = Float.NaN;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            float f4 = fArr3[i4];
            if (f4 != f3) {
                fArr3[i3] = f4;
                i3++;
                f3 = fArr3[i4];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i3);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation a() {
        return new GradientColorKeyframeAnimation(this.f56734a);
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue, com.airbnb.lottie.model.animatable.AnimatableValue
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // com.airbnb.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
