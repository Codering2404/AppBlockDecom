package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScaleXYParser f57006a = new ScaleXYParser();

    private ScaleXYParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScaleXY a(JsonReader jsonReader, float f3) {
        boolean z2 = jsonReader.C() == JsonReader.Token.BEGIN_ARRAY;
        if (z2) {
            jsonReader.b();
        }
        float fL = (float) jsonReader.l();
        float fL2 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.L();
        }
        if (z2) {
            jsonReader.f();
        }
        return new ScaleXY((fL / 100.0f) * f3, (fL2 / 100.0f) * f3);
    }
}
