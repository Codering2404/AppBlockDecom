package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FloatParser implements ValueParser<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FloatParser f56973a = new FloatParser();

    private FloatParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f3) {
        return Float.valueOf(JsonUtils.g(jsonReader) * f3);
    }
}
