package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieCompositionMoshiParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56995a = JsonReader.Options.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static JsonReader.Options f56996b = JsonReader.Options.a("id", "layers", "w", "h", "p", "u");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final JsonReader.Options f56997c = JsonReader.Options.a("list");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final JsonReader.Options f56998d = JsonReader.Options.a("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0044. Please report as an issue. */
    public static LottieComposition a(JsonReader jsonReader) {
        float f3;
        JsonReader jsonReader2 = jsonReader;
        float fE = Utils.e();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader2.c();
        float fL = 0.0f;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        int iM = 0;
        int iM2 = 0;
        while (jsonReader2.j()) {
            switch (jsonReader2.J(f56995a)) {
                case 0:
                    iM = jsonReader.m();
                    jsonReader2 = jsonReader;
                    break;
                case 1:
                    iM2 = jsonReader.m();
                    jsonReader2 = jsonReader;
                    break;
                case 2:
                    f3 = fE;
                    fL = (float) jsonReader.l();
                    jsonReader2 = jsonReader;
                    fE = f3;
                    break;
                case 3:
                    f3 = fE;
                    fL2 = ((float) jsonReader.l()) - 0.01f;
                    jsonReader2 = jsonReader;
                    fE = f3;
                    break;
                case 4:
                    f3 = fE;
                    fL3 = (float) jsonReader.l();
                    jsonReader2 = jsonReader;
                    fE = f3;
                    break;
                case 5:
                    String[] strArrSplit = jsonReader2.r().split("\\.");
                    if (!Utils.i(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    jsonReader2 = jsonReader;
                    break;
                case 6:
                    e(jsonReader2, lottieComposition, arrayList, longSparseArray);
                    jsonReader2 = jsonReader;
                    break;
                case 7:
                    b(jsonReader2, lottieComposition, map, map2);
                    jsonReader2 = jsonReader;
                    break;
                case 8:
                    d(jsonReader2, map3);
                    jsonReader2 = jsonReader;
                    break;
                case 9:
                    c(jsonReader2, lottieComposition, sparseArrayCompat);
                    jsonReader2 = jsonReader;
                    break;
                case 10:
                    f(jsonReader2, arrayList2);
                    jsonReader2 = jsonReader;
                    break;
                default:
                    jsonReader2.K();
                    jsonReader2.L();
                    jsonReader2 = jsonReader;
                    break;
            }
        }
        float f4 = fE;
        lottieComposition.s(new Rect(0, 0, (int) (iM * f4), (int) (iM2 * f4)), fL, fL2, fL3, arrayList, longSparseArray, map, map2, sparseArrayCompat, map3, arrayList2);
        return lottieComposition;
    }

    private static void b(JsonReader jsonReader, LottieComposition lottieComposition, Map map, Map map2) {
        jsonReader.b();
        while (jsonReader.j()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.c();
            int iM = 0;
            int iM2 = 0;
            String strR = null;
            String strR2 = null;
            String strR3 = null;
            while (jsonReader.j()) {
                int iJ = jsonReader.J(f56996b);
                if (iJ == 0) {
                    strR = jsonReader.r();
                } else if (iJ == 1) {
                    jsonReader.b();
                    while (jsonReader.j()) {
                        Layer layerB = LayerParser.b(jsonReader, lottieComposition);
                        longSparseArray.m(layerB.d(), layerB);
                        arrayList.add(layerB);
                    }
                    jsonReader.f();
                } else if (iJ == 2) {
                    iM = jsonReader.m();
                } else if (iJ == 3) {
                    iM2 = jsonReader.m();
                } else if (iJ == 4) {
                    strR2 = jsonReader.r();
                } else if (iJ != 5) {
                    jsonReader.K();
                    jsonReader.L();
                } else {
                    strR3 = jsonReader.r();
                }
            }
            jsonReader.i();
            if (strR2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(iM, iM2, strR, strR2, strR3);
                map2.put(lottieImageAsset.d(), lottieImageAsset);
            } else {
                map.put(strR, arrayList);
            }
        }
        jsonReader.f();
    }

    private static void c(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat sparseArrayCompat) {
        jsonReader.b();
        while (jsonReader.j()) {
            FontCharacter fontCharacterA = FontCharacterParser.a(jsonReader, lottieComposition);
            sparseArrayCompat.m(fontCharacterA.hashCode(), fontCharacterA);
        }
        jsonReader.f();
    }

    private static void d(JsonReader jsonReader, Map map) {
        jsonReader.c();
        while (jsonReader.j()) {
            if (jsonReader.J(f56997c) != 0) {
                jsonReader.K();
                jsonReader.L();
            } else {
                jsonReader.b();
                while (jsonReader.j()) {
                    Font fontA = FontParser.a(jsonReader);
                    map.put(fontA.b(), fontA);
                }
                jsonReader.f();
            }
        }
        jsonReader.i();
    }

    private static void e(JsonReader jsonReader, LottieComposition lottieComposition, List list, LongSparseArray longSparseArray) {
        jsonReader.b();
        int i3 = 0;
        while (jsonReader.j()) {
            Layer layerB = LayerParser.b(jsonReader, lottieComposition);
            if (layerB.f() == Layer.LayerType.IMAGE) {
                i3++;
            }
            list.add(layerB);
            longSparseArray.m(layerB.d(), layerB);
            if (i3 > 4) {
                Logger.c("You have " + i3 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.f();
    }

    private static void f(JsonReader jsonReader, List list) {
        jsonReader.b();
        while (jsonReader.j()) {
            jsonReader.c();
            float fL = 0.0f;
            String strR = null;
            float fL2 = 0.0f;
            while (jsonReader.j()) {
                int iJ = jsonReader.J(f56998d);
                if (iJ == 0) {
                    strR = jsonReader.r();
                } else if (iJ == 1) {
                    fL = (float) jsonReader.l();
                } else if (iJ != 2) {
                    jsonReader.K();
                    jsonReader.L();
                } else {
                    fL2 = (float) jsonReader.l();
                }
            }
            jsonReader.i();
            list.add(new Marker(strR, fL, fL2));
        }
        jsonReader.f();
    }
}
