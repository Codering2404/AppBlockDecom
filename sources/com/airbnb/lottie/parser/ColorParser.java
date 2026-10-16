package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ColorParser implements ValueParser<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ColorParser f56957a = new ColorParser();

    private ColorParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f3) {
        boolean z2 = jsonReader.C() == JsonReader.Token.BEGIN_ARRAY;
        if (z2) {
            jsonReader.b();
        }
        double dL = jsonReader.l();
        double dL2 = jsonReader.l();
        double dL3 = jsonReader.l();
        double dL4 = jsonReader.C() == JsonReader.Token.NUMBER ? jsonReader.l() : 1.0d;
        if (z2) {
            jsonReader.f();
        }
        if (dL <= 1.0d && dL2 <= 1.0d && dL3 <= 1.0d) {
            dL *= 255.0d;
            dL2 *= 255.0d;
            dL3 *= 255.0d;
            if (dL4 <= 1.0d) {
                dL4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dL4, (int) dL, (int) dL2, (int) dL3));
    }
}
