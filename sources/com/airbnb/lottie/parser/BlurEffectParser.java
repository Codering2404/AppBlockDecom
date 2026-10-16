package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class BlurEffectParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56954a = JsonReader.Options.a("ef");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56955b = JsonReader.Options.a("ty", "v");

    private static BlurEffect a(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.c();
        BlurEffect blurEffect = null;
        while (true) {
            boolean z2 = false;
            while (jsonReader.j()) {
                int iJ = jsonReader.J(f56955b);
                if (iJ != 0) {
                    if (iJ != 1) {
                        jsonReader.K();
                        jsonReader.L();
                    } else if (z2) {
                        blurEffect = new BlurEffect(AnimatableValueParser.e(jsonReader, lottieComposition));
                    } else {
                        jsonReader.L();
                    }
                } else if (jsonReader.m() == 0) {
                    z2 = true;
                }
            }
            jsonReader.i();
            return blurEffect;
        }
    }

    static BlurEffect b(JsonReader jsonReader, LottieComposition lottieComposition) {
        BlurEffect blurEffect = null;
        while (jsonReader.j()) {
            if (jsonReader.J(f56954a) != 0) {
                jsonReader.K();
                jsonReader.L();
            } else {
                jsonReader.b();
                while (jsonReader.j()) {
                    BlurEffect blurEffectA = a(jsonReader, lottieComposition);
                    if (blurEffectA != null) {
                        blurEffect = blurEffectA;
                    }
                }
                jsonReader.f();
            }
        }
        return blurEffect;
    }
}
