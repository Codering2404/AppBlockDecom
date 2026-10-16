package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ShapeTrimPathParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57014a = JsonReader.Options.a("s", "e", "o", "nm", "m", "hd");

    static ShapeTrimPath a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strR = null;
        ShapeTrimPath.Type typeB = null;
        AnimatableFloatValue animatableFloatValueF = null;
        AnimatableFloatValue animatableFloatValueF2 = null;
        AnimatableFloatValue animatableFloatValueF3 = null;
        boolean zK = false;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57014a);
            if (iJ == 0) {
                animatableFloatValueF = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (iJ == 1) {
                animatableFloatValueF2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (iJ == 2) {
                animatableFloatValueF3 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
            } else if (iJ == 3) {
                strR = jsonReader.r();
            } else if (iJ == 4) {
                typeB = ShapeTrimPath.Type.b(jsonReader.m());
            } else if (iJ != 5) {
                jsonReader.L();
            } else {
                zK = jsonReader.k();
            }
        }
        return new ShapeTrimPath(strR, typeB, animatableFloatValueF, animatableFloatValueF2, animatableFloatValueF3, zK);
    }
}
