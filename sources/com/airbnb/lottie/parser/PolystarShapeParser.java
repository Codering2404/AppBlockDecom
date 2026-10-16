package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class PolystarShapeParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57002a = JsonReader.Options.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", "d");

    static PolystarShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i3) {
        boolean zK = false;
        boolean z2 = i3 == 3;
        String strR = null;
        PolystarShape.Type typeB = null;
        AnimatableFloatValue animatableFloatValueF = null;
        AnimatableValue animatableValueB = null;
        AnimatableFloatValue animatableFloatValueF2 = null;
        AnimatableFloatValue animatableFloatValueE = null;
        AnimatableFloatValue animatableFloatValueE2 = null;
        AnimatableFloatValue animatableFloatValueF3 = null;
        AnimatableFloatValue animatableFloatValueF4 = null;
        while (jsonReader.j()) {
            switch (jsonReader.J(f57002a)) {
                case 0:
                    strR = jsonReader.r();
                    break;
                case 1:
                    typeB = PolystarShape.Type.b(jsonReader.m());
                    break;
                case 2:
                    animatableFloatValueF = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValueB = AnimatablePathValueParser.b(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValueF2 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValueE2 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValueF4 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValueE = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValueF3 = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    zK = jsonReader.k();
                    break;
                case 10:
                    z2 = jsonReader.m() == 3;
                    break;
                default:
                    jsonReader.K();
                    jsonReader.L();
                    break;
            }
        }
        return new PolystarShape(strR, typeB, animatableFloatValueF, animatableValueB, animatableFloatValueF2, animatableFloatValueE, animatableFloatValueE2, animatableFloatValueF3, animatableFloatValueF4, zK, z2);
    }
}
