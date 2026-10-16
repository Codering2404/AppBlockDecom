package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class CircleShapeParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56956a = JsonReader.Options.a("nm", "p", "s", "hd", "d");

    static CircleShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i3) {
        boolean z2 = i3 == 3;
        boolean zK = false;
        String strR = null;
        AnimatableValue animatableValueB = null;
        AnimatablePointValue animatablePointValueI = null;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56956a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                animatableValueB = AnimatablePathValueParser.b(jsonReader, lottieComposition);
            } else if (iJ == 2) {
                animatablePointValueI = AnimatableValueParser.i(jsonReader, lottieComposition);
            } else if (iJ == 3) {
                zK = jsonReader.k();
            } else if (iJ != 4) {
                jsonReader.K();
                jsonReader.L();
            } else {
                z2 = jsonReader.m() == 3;
            }
        }
        return new CircleShape(strR, animatableValueB, animatablePointValueI, z2, zK);
    }
}
