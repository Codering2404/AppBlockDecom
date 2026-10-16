package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DropShadowEffectParser {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final JsonReader.Options f56966f = JsonReader.Options.a("ef");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final JsonReader.Options f56967g = JsonReader.Options.a("nm", "v");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnimatableColorValue f56968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimatableFloatValue f56969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimatableFloatValue f56970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimatableFloatValue f56971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AnimatableFloatValue f56972e;

    private void a(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.c();
        String strR = "";
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56967g);
            if (iJ != 0) {
                if (iJ == 1) {
                    strR.getClass();
                    switch (strR) {
                        case "Distance":
                            this.f56971d = AnimatableValueParser.e(jsonReader, lottieComposition);
                            break;
                        case "Opacity":
                            this.f56969b = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                            break;
                        case "Direction":
                            this.f56970c = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                            break;
                        case "Shadow Color":
                            this.f56968a = AnimatableValueParser.c(jsonReader, lottieComposition);
                            break;
                        case "Softness":
                            this.f56972e = AnimatableValueParser.e(jsonReader, lottieComposition);
                            break;
                        default:
                            jsonReader.L();
                            break;
                    }
                } else {
                    jsonReader.K();
                    jsonReader.L();
                }
            } else {
                strR = jsonReader.r();
            }
        }
        jsonReader.i();
    }

    DropShadowEffect b(JsonReader jsonReader, LottieComposition lottieComposition) {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableFloatValue animatableFloatValue4;
        while (jsonReader.j()) {
            if (jsonReader.J(f56966f) != 0) {
                jsonReader.K();
                jsonReader.L();
            } else {
                jsonReader.b();
                while (jsonReader.j()) {
                    a(jsonReader, lottieComposition);
                }
                jsonReader.f();
            }
        }
        AnimatableColorValue animatableColorValue = this.f56968a;
        if (animatableColorValue == null || (animatableFloatValue = this.f56969b) == null || (animatableFloatValue2 = this.f56970c) == null || (animatableFloatValue3 = this.f56971d) == null || (animatableFloatValue4 = this.f56972e) == null) {
            return null;
        }
        return new DropShadowEffect(animatableColorValue, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4);
    }
}
