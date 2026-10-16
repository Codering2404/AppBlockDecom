package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.UserDataStore;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class ContentModelParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56958a = JsonReader.Options.a("ty", "d");

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    static ContentModel a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ContentModel contentModelA;
        String strR;
        jsonReader.c();
        byte b3 = 2;
        int iM = 2;
        while (true) {
            contentModelA = null;
            if (!jsonReader.j()) {
                strR = null;
                break;
            }
            int iJ = jsonReader.J(f56958a);
            if (iJ == 0) {
                strR = jsonReader.r();
                break;
            }
            if (iJ != 1) {
                jsonReader.K();
                jsonReader.L();
            } else {
                iM = jsonReader.m();
            }
        }
        if (strR == null) {
            return null;
        }
        switch (strR.hashCode()) {
            case 3239:
                b3 = !strR.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b3 = !strR.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strR.equals("gf")) {
                    b3 = -1;
                }
                break;
            case 3307:
                b3 = !strR.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b3 = !strR.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b3 = !strR.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b3 = !strR.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3634:
                b3 = !strR.equals("rd") ? (byte) -1 : (byte) 7;
                break;
            case 3646:
                b3 = !strR.equals("rp") ? (byte) -1 : (byte) 8;
                break;
            case 3669:
                b3 = !strR.equals("sh") ? (byte) -1 : (byte) 9;
                break;
            case 3679:
                b3 = !strR.equals("sr") ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b3 = !strR.equals(UserDataStore.STATE) ? (byte) -1 : Ascii.VT;
                break;
            case 3705:
                b3 = !strR.equals("tm") ? (byte) -1 : Ascii.FF;
                break;
            case 3710:
                b3 = !strR.equals("tr") ? (byte) -1 : Ascii.CR;
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case 0:
                contentModelA = CircleShapeParser.a(jsonReader, lottieComposition, iM);
                break;
            case 1:
                contentModelA = ShapeFillParser.a(jsonReader, lottieComposition);
                break;
            case 2:
                contentModelA = GradientFillParser.a(jsonReader, lottieComposition);
                break;
            case 3:
                contentModelA = ShapeGroupParser.a(jsonReader, lottieComposition);
                break;
            case 4:
                contentModelA = GradientStrokeParser.a(jsonReader, lottieComposition);
                break;
            case 5:
                contentModelA = MergePathsParser.a(jsonReader);
                lottieComposition.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                contentModelA = RectangleShapeParser.a(jsonReader, lottieComposition);
                break;
            case 7:
                contentModelA = RoundedCornersParser.a(jsonReader, lottieComposition);
                break;
            case 8:
                contentModelA = RepeaterParser.a(jsonReader, lottieComposition);
                break;
            case 9:
                contentModelA = ShapePathParser.a(jsonReader, lottieComposition);
                break;
            case 10:
                contentModelA = PolystarShapeParser.a(jsonReader, lottieComposition, iM);
                break;
            case 11:
                contentModelA = ShapeStrokeParser.a(jsonReader, lottieComposition);
                break;
            case 12:
                contentModelA = ShapeTrimPathParser.a(jsonReader, lottieComposition);
                break;
            case 13:
                contentModelA = AnimatableTransformParser.g(jsonReader, lottieComposition);
                break;
            default:
                Logger.c("Unknown shape type " + strR);
                break;
        }
        while (jsonReader.j()) {
            jsonReader.L();
        }
        jsonReader.i();
        return contentModelA;
    }
}
