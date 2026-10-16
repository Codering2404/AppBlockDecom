package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ShapeGroupParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f57010a = JsonReader.Options.a("nm", "hd", "it");

    static ShapeGroup a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        String strR = null;
        boolean zK = false;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57010a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                zK = jsonReader.k();
            } else if (iJ != 2) {
                jsonReader.L();
            } else {
                jsonReader.b();
                while (jsonReader.j()) {
                    ContentModel contentModelA = ContentModelParser.a(jsonReader, lottieComposition);
                    if (contentModelA != null) {
                        arrayList.add(contentModelA);
                    }
                }
                jsonReader.f();
            }
        }
        return new ShapeGroup(strR, arrayList, zK);
    }
}
