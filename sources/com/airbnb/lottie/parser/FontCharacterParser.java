package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class FontCharacterParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56974a = JsonReader.Options.a("ch", "size", "w", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "fFamily", "data");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56975b = JsonReader.Options.a(jlWo.VyGqRuj);

    static FontCharacter a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        double dL = 0.0d;
        String strR = null;
        String strR2 = null;
        char cCharAt = 0;
        double dL2 = 0.0d;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56974a);
            if (iJ == 0) {
                cCharAt = jsonReader.r().charAt(0);
            } else if (iJ == 1) {
                dL2 = jsonReader.l();
            } else if (iJ == 2) {
                dL = jsonReader.l();
            } else if (iJ == 3) {
                strR = jsonReader.r();
            } else if (iJ == 4) {
                strR2 = jsonReader.r();
            } else if (iJ != 5) {
                jsonReader.K();
                jsonReader.L();
            } else {
                jsonReader.c();
                while (jsonReader.j()) {
                    if (jsonReader.J(f56975b) != 0) {
                        jsonReader.K();
                        jsonReader.L();
                    } else {
                        jsonReader.b();
                        while (jsonReader.j()) {
                            arrayList.add((ShapeGroup) ContentModelParser.a(jsonReader, lottieComposition));
                        }
                        jsonReader.f();
                    }
                }
                jsonReader.i();
            }
        }
        jsonReader.i();
        return new FontCharacter(arrayList, cCharAt, dL2, dL, strR, strR2);
    }
}
