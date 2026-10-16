package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PointFParser implements ValueParser<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointFParser f57001a = new PointFParser();

    private PointFParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f3) {
        JsonReader.Token tokenC = jsonReader.C();
        if (tokenC == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.e(jsonReader, f3);
        }
        if (tokenC == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.e(jsonReader, f3);
        }
        if (tokenC == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.l()) * f3, ((float) jsonReader.l()) * f3);
            while (jsonReader.j()) {
                jsonReader.L();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + tokenC);
    }
}
