package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class FontParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56976a = JsonReader.Options.a("fFamily", "fName", "fStyle", "ascent");

    static Font a(JsonReader jsonReader) {
        jsonReader.c();
        String strR = null;
        String strR2 = null;
        float fL = 0.0f;
        String strR3 = null;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56976a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                strR3 = jsonReader.r();
            } else if (iJ == 2) {
                strR2 = jsonReader.r();
            } else if (iJ != 3) {
                jsonReader.K();
                jsonReader.L();
            } else {
                fL = (float) jsonReader.l();
            }
        }
        jsonReader.i();
        return new Font(strR, strR3, strR2, fL);
    }
}
