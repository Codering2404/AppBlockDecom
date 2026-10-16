package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatableTextPropertiesParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56950a = JsonReader.Options.a("a");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56951b = JsonReader.Options.a("fc", "sc", "sw", "t");

    public static AnimatableTextProperties a(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.c();
        AnimatableTextProperties animatableTextPropertiesB = null;
        while (jsonReader.j()) {
            if (jsonReader.J(f56950a) != 0) {
                jsonReader.K();
                jsonReader.L();
            } else {
                animatableTextPropertiesB = b(jsonReader, lottieComposition);
            }
        }
        jsonReader.i();
        return animatableTextPropertiesB == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextPropertiesB;
    }

    private static AnimatableTextProperties b(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.c();
        AnimatableColorValue animatableColorValueC = null;
        AnimatableColorValue animatableColorValueC2 = null;
        AnimatableFloatValue animatableFloatValueE = null;
        AnimatableFloatValue animatableFloatValueE2 = null;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56951b);
            if (iJ == 0) {
                animatableColorValueC = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (iJ == 1) {
                animatableColorValueC2 = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (iJ == 2) {
                animatableFloatValueE = AnimatableValueParser.e(jsonReader, lottieComposition);
            } else if (iJ != 3) {
                jsonReader.K();
                jsonReader.L();
            } else {
                animatableFloatValueE2 = AnimatableValueParser.e(jsonReader, lottieComposition);
            }
        }
        jsonReader.i();
        return new AnimatableTextProperties(animatableColorValueC, animatableColorValueC2, animatableFloatValueE, animatableFloatValueE2);
    }
}
