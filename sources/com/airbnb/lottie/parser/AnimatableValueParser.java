package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatableValueParser {
    private static List a(JsonReader jsonReader, float f3, LottieComposition lottieComposition, ValueParser valueParser) {
        return KeyframesParser.a(jsonReader, lottieComposition, f3, valueParser, false);
    }

    private static List b(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser valueParser) {
        return KeyframesParser.a(jsonReader, lottieComposition, 1.0f, valueParser, false);
    }

    static AnimatableColorValue c(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableColorValue(b(jsonReader, lottieComposition, ColorParser.f56957a));
    }

    static AnimatableTextFrame d(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableTextFrame(a(jsonReader, Utils.e(), lottieComposition, DocumentDataParser.f56959a));
    }

    public static AnimatableFloatValue e(JsonReader jsonReader, LottieComposition lottieComposition) {
        return f(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue f(JsonReader jsonReader, LottieComposition lottieComposition, boolean z2) {
        return new AnimatableFloatValue(a(jsonReader, z2 ? Utils.e() : 1.0f, lottieComposition, FloatParser.f56973a));
    }

    static AnimatableGradientColorValue g(JsonReader jsonReader, LottieComposition lottieComposition, int i3) {
        return new AnimatableGradientColorValue(b(jsonReader, lottieComposition, new GradientColorParser(i3)));
    }

    static AnimatableIntegerValue h(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableIntegerValue(b(jsonReader, lottieComposition, IntegerParser.f56983a));
    }

    static AnimatablePointValue i(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatablePointValue(KeyframesParser.a(jsonReader, lottieComposition, Utils.e(), PointFParser.f57001a, true));
    }

    static AnimatableScaleValue j(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableScaleValue(b(jsonReader, lottieComposition, ScaleXYParser.f57006a));
    }

    static AnimatableShapeValue k(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new AnimatableShapeValue(a(jsonReader, Utils.e(), lottieComposition, ShapeDataParser.f57007a));
    }
}
