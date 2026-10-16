package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ShapeStrokeParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57012a = JsonReader.Options.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f57013b = JsonReader.Options.a("n", "v");

    /* JADX WARN: Multi-variable type inference failed */
    static ShapeStroke a(JsonReader jsonReader, LottieComposition lottieComposition) {
        Object objE;
        ArrayList arrayList = new ArrayList();
        String strR = null;
        Object obj = null;
        AnimatableColorValue animatableColorValueC = null;
        AnimatableFloatValue animatableFloatValueE = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        String str = null;
        float fL = 0.0f;
        boolean zK = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.j()) {
            switch (jsonReader.J(f57012a)) {
                case 0:
                    strR = jsonReader.r();
                    break;
                case 1:
                    animatableColorValueC = AnimatableValueParser.c(jsonReader, lottieComposition);
                    break;
                case 2:
                    animatableFloatValueE = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 3:
                    animatableIntegerValue = AnimatableValueParser.h(jsonReader, lottieComposition);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.m() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.m() - 1];
                    break;
                case 6:
                    fL = (float) jsonReader.l();
                    break;
                case 7:
                    zK = jsonReader.k();
                    break;
                case 8:
                    jsonReader.b();
                    while (jsonReader.j()) {
                        jsonReader.c();
                        String strR2 = str;
                        objE = strR2;
                        while (jsonReader.j()) {
                            int iJ = jsonReader.J(f57013b);
                            if (iJ == 0) {
                                strR2 = jsonReader.r();
                            } else if (iJ != 1) {
                                jsonReader.K();
                                jsonReader.L();
                            } else {
                                objE = AnimatableValueParser.e(jsonReader, lottieComposition);
                            }
                        }
                        jsonReader.i();
                        strR2.getClass();
                        switch (strR2) {
                            case "d":
                            case "g":
                                lottieComposition.u(true);
                                arrayList.add(objE);
                                break;
                            case "o":
                                obj = objE;
                                break;
                        }
                        str = null;
                    }
                    jsonReader.f();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    break;
                default:
                    jsonReader.L();
                    continue;
            }
            str = null;
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new ShapeStroke(strR, obj, arrayList, animatableColorValueC, animatableIntegerValue, animatableFloatValueE, lineCapType, lineJoinType, fL, zK);
    }
}
