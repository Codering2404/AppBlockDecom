package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class RepeaterParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57004a = JsonReader.Options.a("nm", "c", "o", "tr", "hd");

    static Repeater a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strR = null;
        AnimatableFloatValue animatableFloatValueF = null;
        AnimatableFloatValue animatableFloatValueF2 = null;
        AnimatableTransform animatableTransformG = null;
        boolean zK = false;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57004a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                animatableFloatValueF = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (iJ == 2) {
                animatableFloatValueF2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (iJ == 3) {
                animatableTransformG = AnimatableTransformParser.g(jsonReader, lottieComposition);
            } else if (iJ != 4) {
                jsonReader.L();
            } else {
                zK = jsonReader.k();
            }
        }
        return new Repeater(strR, animatableFloatValueF, animatableFloatValueF2, animatableTransformG, zK);
    }
}
