package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ShapePathParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static JsonReader.Options f57011a = JsonReader.Options.a("nm", "ind", "ks", "hd");

    static ShapePath a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strR = null;
        int iM = 0;
        boolean zK = false;
        AnimatableShapeValue animatableShapeValueK = null;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57011a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                iM = jsonReader.m();
            } else if (iJ == 2) {
                animatableShapeValueK = AnimatableValueParser.k(jsonReader, lottieComposition);
            } else if (iJ != 3) {
                jsonReader.L();
            } else {
                zK = jsonReader.k();
            }
        }
        return new ShapePath(strR, iM, animatableShapeValueK, zK);
    }
}
