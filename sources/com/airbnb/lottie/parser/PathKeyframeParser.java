package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class PathKeyframeParser {
    static PathKeyframe a(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new PathKeyframe(lottieComposition, KeyframeParser.c(jsonReader, lottieComposition, Utils.e(), PathParser.f57000a, jsonReader.C() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
