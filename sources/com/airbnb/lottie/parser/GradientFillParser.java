package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class GradientFillParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56978a = JsonReader.Options.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56979b = JsonReader.Options.a("p", "k");

    static GradientFill a(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableIntegerValue animatableIntegerValue = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String strR = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValueG = null;
        AnimatablePointValue animatablePointValueI = null;
        AnimatablePointValue animatablePointValueI2 = null;
        boolean zK = false;
        while (jsonReader.j()) {
            switch (jsonReader.J(f56978a)) {
                case 0:
                    strR = jsonReader.r();
                    break;
                case 1:
                    jsonReader.c();
                    int iM = -1;
                    while (jsonReader.j()) {
                        int iJ = jsonReader.J(f56979b);
                        if (iJ == 0) {
                            iM = jsonReader.m();
                        } else if (iJ != 1) {
                            jsonReader.K();
                            jsonReader.L();
                        } else {
                            animatableGradientColorValueG = AnimatableValueParser.g(jsonReader, lottieComposition, iM);
                        }
                    }
                    jsonReader.i();
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
                    break;
                case 3:
                    gradientType = jsonReader.m() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    animatablePointValueI = AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValueI2 = AnimatableValueParser.i(jsonReader, lottieComposition);
                    break;
                case 6:
                    fillType = jsonReader.m() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    zK = jsonReader.k();
                    break;
                default:
                    jsonReader.K();
                    jsonReader.L();
                    break;
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new GradientFill(strR, gradientType, fillType, animatableGradientColorValueG, animatableIntegerValue, animatablePointValueI, animatablePointValueI2, null, null, zK);
    }
}
