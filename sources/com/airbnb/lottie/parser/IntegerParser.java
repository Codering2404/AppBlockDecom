package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class IntegerParser implements ValueParser<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IntegerParser f56983a = new IntegerParser();

    private IntegerParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f3) {
        return Integer.valueOf(Math.round(JsonUtils.g(jsonReader) * f3));
    }
}
