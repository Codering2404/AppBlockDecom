package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class KeyframesParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static JsonReader.Options f56990a = JsonReader.Options.a("k");

    static List a(JsonReader jsonReader, LottieComposition lottieComposition, float f3, ValueParser valueParser, boolean z2) {
        JsonReader jsonReader2;
        LottieComposition lottieComposition2;
        float f4;
        ValueParser valueParser2;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.C() == JsonReader.Token.STRING) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.c();
        while (jsonReader.j()) {
            if (jsonReader.J(f56990a) != 0) {
                jsonReader.L();
            } else if (jsonReader.C() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.b();
                if (jsonReader.C() == JsonReader.Token.NUMBER) {
                    JsonReader jsonReader3 = jsonReader;
                    LottieComposition lottieComposition3 = lottieComposition;
                    float f5 = f3;
                    ValueParser valueParser3 = valueParser;
                    boolean z4 = z2;
                    Keyframe keyframeC = KeyframeParser.c(jsonReader3, lottieComposition3, f5, valueParser3, false, z4);
                    jsonReader2 = jsonReader3;
                    lottieComposition2 = lottieComposition3;
                    f4 = f5;
                    valueParser2 = valueParser3;
                    z3 = z4;
                    arrayList.add(keyframeC);
                } else {
                    jsonReader2 = jsonReader;
                    lottieComposition2 = lottieComposition;
                    f4 = f3;
                    valueParser2 = valueParser;
                    z3 = z2;
                    while (jsonReader2.j()) {
                        arrayList.add(KeyframeParser.c(jsonReader2, lottieComposition2, f4, valueParser2, true, z3));
                    }
                }
                jsonReader2.f();
                jsonReader = jsonReader2;
                lottieComposition = lottieComposition2;
                f3 = f4;
                valueParser = valueParser2;
                z2 = z3;
            } else {
                JsonReader jsonReader4 = jsonReader;
                arrayList.add(KeyframeParser.c(jsonReader4, lottieComposition, f3, valueParser, false, z2));
                jsonReader = jsonReader4;
            }
        }
        jsonReader.i();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i3;
        Object obj;
        int size = list.size();
        int i4 = 0;
        while (true) {
            i3 = size - 1;
            if (i4 >= i3) {
                break;
            }
            Keyframe keyframe = (Keyframe) list.get(i4);
            i4++;
            Keyframe keyframe2 = (Keyframe) list.get(i4);
            keyframe.f57117h = Float.valueOf(keyframe2.f57116g);
            if (keyframe.f57112c == null && (obj = keyframe2.f57111b) != null) {
                keyframe.f57112c = obj;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).j();
                }
            }
        }
        Keyframe keyframe3 = (Keyframe) list.get(i3);
        if ((keyframe3.f57111b == null || keyframe3.f57112c == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
