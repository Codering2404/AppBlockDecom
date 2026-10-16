package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class MaskParser {
    static Mask a(JsonReader jsonReader, LottieComposition lottieComposition) {
        String strN;
        jsonReader.c();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue animatableShapeValueK = null;
        AnimatableIntegerValue animatableIntegerValueH = null;
        boolean zK = false;
        while (jsonReader.j()) {
            strN = jsonReader.n();
            strN.getClass();
            switch (strN) {
                case "o":
                    animatableIntegerValueH = AnimatableValueParser.h(jsonReader, lottieComposition);
                    break;
                case "pt":
                    animatableShapeValueK = AnimatableValueParser.k(jsonReader, lottieComposition);
                    break;
                case "inv":
                    zK = jsonReader.k();
                    break;
                case "mode":
                    String strR = jsonReader.r();
                    strR.getClass();
                    switch (strR) {
                        case "a":
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case "i":
                            lottieComposition.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            Logger.c("Unknown mask mode " + strN + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.L();
                    break;
            }
        }
        jsonReader.i();
        return new Mask(maskMode, animatableShapeValueK, animatableIntegerValueH, zK);
    }
}
