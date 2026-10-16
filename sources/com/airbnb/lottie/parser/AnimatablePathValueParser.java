package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatablePathValueParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56949a = JsonReader.Options.a("k", "x", "y");

    public static AnimatablePathValue a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.C() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            while (jsonReader.j()) {
                arrayList.add(PathKeyframeParser.a(jsonReader, lottieComposition));
            }
            jsonReader.f();
            KeyframesParser.b(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.e(jsonReader, Utils.e())));
        }
        return new AnimatablePathValue(arrayList);
    }

    static AnimatableValue b(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.c();
        AnimatablePathValue animatablePathValueA = null;
        AnimatableFloatValue animatableFloatValueE = null;
        boolean z2 = false;
        AnimatableFloatValue animatableFloatValueE2 = null;
        while (jsonReader.C() != JsonReader.Token.END_OBJECT) {
            int iJ = jsonReader.J(f56949a);
            if (iJ == 0) {
                animatablePathValueA = a(jsonReader, lottieComposition);
            } else if (iJ != 1) {
                if (iJ != 2) {
                    jsonReader.K();
                    jsonReader.L();
                } else if (jsonReader.C() == JsonReader.Token.STRING) {
                    jsonReader.L();
                    z2 = true;
                } else {
                    animatableFloatValueE = AnimatableValueParser.e(jsonReader, lottieComposition);
                }
            } else if (jsonReader.C() == JsonReader.Token.STRING) {
                jsonReader.L();
                z2 = true;
            } else {
                animatableFloatValueE2 = AnimatableValueParser.e(jsonReader, lottieComposition);
            }
        }
        jsonReader.i();
        if (z2) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        return animatablePathValueA != null ? animatablePathValueA : new AnimatableSplitDimensionPathValue(animatableFloatValueE2, animatableFloatValueE);
    }
}
