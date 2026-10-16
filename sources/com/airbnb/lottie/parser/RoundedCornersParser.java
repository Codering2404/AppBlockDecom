package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RoundedCornersParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57005a = JsonReader.Options.a("nm", "r", "hd");

    static RoundedCorners a(JsonReader jsonReader, LottieComposition lottieComposition) {
        boolean zK = false;
        String strR = null;
        AnimatableFloatValue animatableFloatValueF = null;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57005a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                animatableFloatValueF = AnimatableValueParser.f(jsonReader, lottieComposition, true);
            } else if (iJ != 2) {
                jsonReader.L();
            } else {
                zK = jsonReader.k();
            }
        }
        if (zK) {
            return null;
        }
        return new RoundedCorners(strR, animatableFloatValueF);
    }
}
