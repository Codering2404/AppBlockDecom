package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class RectangleShapeParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57003a = JsonReader.Options.a("nm", "p", "s", "r", "hd");

    static RectangleShape a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strR = null;
        AnimatableValue animatableValueB = null;
        AnimatablePointValue animatablePointValueI = null;
        AnimatableFloatValue animatableFloatValueE = null;
        boolean zK = false;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57003a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                animatableValueB = AnimatablePathValueParser.b(jsonReader, lottieComposition);
            } else if (iJ == 2) {
                animatablePointValueI = AnimatableValueParser.i(jsonReader, lottieComposition);
            } else if (iJ == 3) {
                animatableFloatValueE = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (iJ != 4) {
                jsonReader.L();
            } else {
                zK = jsonReader.k();
            }
        }
        return new RectangleShape(strR, animatableValueB, animatablePointValueI, animatableFloatValueE, zK);
    }
}
