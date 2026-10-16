package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ShapeFillParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57009a = JsonReader.Options.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static ShapeFill a(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableIntegerValue animatableIntegerValue = null;
        String strR = null;
        AnimatableColorValue animatableColorValueC = null;
        boolean zK = false;
        boolean zK2 = false;
        int iM = 1;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57009a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                animatableColorValueC = AnimatableValueParser.c(jsonReader, lottieComposition);
            } else if (iJ == 2) {
                animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
            } else if (iJ == 3) {
                zK = jsonReader.k();
            } else if (iJ == 4) {
                iM = jsonReader.m();
            } else if (iJ != 5) {
                jsonReader.K();
                jsonReader.L();
            } else {
                zK2 = jsonReader.k();
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new ShapeFill(strR, zK, iM == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValueC, animatableIntegerValue, zK2);
    }
}
