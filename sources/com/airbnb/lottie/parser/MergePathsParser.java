package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class MergePathsParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56999a = JsonReader.Options.a("nm", "mm", "hd");

    static MergePaths a(JsonReader jsonReader) {
        String strR = null;
        boolean zK = false;
        MergePaths.MergePathsMode mergePathsModeB = null;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56999a);
            if (iJ == 0) {
                strR = jsonReader.r();
            } else if (iJ == 1) {
                mergePathsModeB = MergePaths.MergePathsMode.b(jsonReader.m());
            } else if (iJ != 2) {
                jsonReader.K();
                jsonReader.L();
            } else {
                zK = jsonReader.k();
            }
        }
        return new MergePaths(strR, mergePathsModeB, zK);
    }
}
