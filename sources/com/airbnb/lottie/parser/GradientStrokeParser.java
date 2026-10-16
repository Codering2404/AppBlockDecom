package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class GradientStrokeParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56980a = JsonReader.Options.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56981b = JsonReader.Options.a("p", "k");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final JsonReader.Options f56982c = JsonReader.Options.a("n", "v");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0027. Please report as an issue. */
    static GradientStroke a(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableIntegerValue animatableIntegerValue;
        ArrayList arrayList = new ArrayList();
        GradientType gradientType = null;
        String strR = null;
        AnimatableGradientColorValue animatableGradientColorValueG = null;
        AnimatablePointValue animatablePointValueI = null;
        AnimatablePointValue animatablePointValueI2 = null;
        AnimatableFloatValue animatableFloatValueE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        AnimatableFloatValue animatableFloatValue = null;
        float fL = 0.0f;
        boolean zK = false;
        AnimatableIntegerValue animatableIntegerValueH = null;
        while (jsonReader.j()) {
            GradientType gradientType2 = gradientType;
            switch (jsonReader.J(f56980a)) {
                case 0:
                    strR = jsonReader.r();
                    gradientType = gradientType2;
                    break;
                case 1:
                    animatableIntegerValue = animatableIntegerValueH;
                    jsonReader.c();
                    int iM = -1;
                    while (jsonReader.j()) {
                        int iJ = jsonReader.J(f56981b);
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
                    gradientType = gradientType2;
                    animatableIntegerValueH = animatableIntegerValue;
                    break;
                case 2:
                    animatableIntegerValueH = AnimatableValueParser.h(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 3:
                    animatableIntegerValue = animatableIntegerValueH;
                    gradientType = jsonReader.m() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    animatableIntegerValueH = animatableIntegerValue;
                    break;
                case 4:
                    animatablePointValueI = AnimatableValueParser.i(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 5:
                    animatablePointValueI2 = AnimatableValueParser.i(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 6:
                    animatableFloatValueE = AnimatableValueParser.e(jsonReader, lottieComposition);
                    gradientType = gradientType2;
                    break;
                case 7:
                    animatableIntegerValue = animatableIntegerValueH;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    gradientType = gradientType2;
                    animatableIntegerValueH = animatableIntegerValue;
                    break;
                case 8:
                    animatableIntegerValue = animatableIntegerValueH;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    gradientType = gradientType2;
                    animatableIntegerValueH = animatableIntegerValue;
                    break;
                case 9:
                    animatableIntegerValue = animatableIntegerValueH;
                    fL = (float) jsonReader.l();
                    gradientType = gradientType2;
                    animatableIntegerValueH = animatableIntegerValue;
                    break;
                case 10:
                    zK = jsonReader.k();
                    gradientType = gradientType2;
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.j()) {
                        jsonReader.c();
                        String strR2 = null;
                        AnimatableFloatValue animatableFloatValueE2 = null;
                        while (jsonReader.j()) {
                            int iJ2 = jsonReader.J(f56982c);
                            if (iJ2 != 0) {
                                AnimatableIntegerValue animatableIntegerValue2 = animatableIntegerValueH;
                                if (iJ2 != 1) {
                                    jsonReader.K();
                                    jsonReader.L();
                                } else {
                                    animatableFloatValueE2 = AnimatableValueParser.e(jsonReader, lottieComposition);
                                }
                                animatableIntegerValueH = animatableIntegerValue2;
                            } else {
                                strR2 = jsonReader.r();
                            }
                        }
                        AnimatableIntegerValue animatableIntegerValue3 = animatableIntegerValueH;
                        jsonReader.i();
                        if (strR2.equals("o")) {
                            animatableFloatValue = animatableFloatValueE2;
                        } else {
                            if (strR2.equals("d") || strR2.equals("g")) {
                                lottieComposition.u(true);
                                arrayList.add(animatableFloatValueE2);
                            }
                            animatableIntegerValueH = animatableIntegerValue3;
                        }
                        animatableIntegerValueH = animatableIntegerValue3;
                    }
                    animatableIntegerValue = animatableIntegerValueH;
                    jsonReader.f();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    gradientType = gradientType2;
                    animatableIntegerValueH = animatableIntegerValue;
                    break;
                default:
                    jsonReader.K();
                    jsonReader.L();
                    gradientType = gradientType2;
                    break;
            }
        }
        AnimatableIntegerValue animatableIntegerValue4 = animatableIntegerValueH;
        return new GradientStroke(strR, gradientType, animatableGradientColorValueG, animatableIntegerValue4 == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100))) : animatableIntegerValue4, animatablePointValueI, animatablePointValueI2, animatableFloatValueE, lineCapType, lineJoinType, fL, arrayList, animatableFloatValue, zK);
    }
}
