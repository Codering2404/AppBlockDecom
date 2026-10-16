package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LayerParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56991a = JsonReader.Options.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", jTYhJgqLBN.ctJjGOZCld, "sr", UserDataStore.STATE, "w", "h", "ip", "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56992b = JsonReader.Options.a("d", "a");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final JsonReader.Options f56993c = JsonReader.Options.a("ty", "nm");

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56994a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f56994a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56994a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(LottieComposition lottieComposition) {
        Rect rectB = lottieComposition.b();
        List list = Collections.EMPTY_LIST;
        return new Layer(list, lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, list, new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, list, Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer b(JsonReader jsonReader, LottieComposition lottieComposition) {
        Float f3;
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.c();
        Layer.MatteType matteType2 = matteType;
        String strR = null;
        AnimatableTransform animatableTransformG = null;
        AnimatableTextFrame animatableTextFrameD = null;
        AnimatableTextProperties animatableTextPropertiesA = null;
        AnimatableFloatValue animatableFloatValueF = null;
        BlurEffect blurEffectB = null;
        DropShadowEffect dropShadowEffectB = null;
        float fL = 0.0f;
        float f4 = 0.0f;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        float fL4 = 0.0f;
        long jM = 0;
        int iM = 0;
        int iM2 = 0;
        int color = 0;
        boolean zK = false;
        long jM2 = -1;
        float fL5 = 1.0f;
        String strR2 = "UNSET";
        String strR3 = null;
        Layer.LayerType layerType = null;
        while (jsonReader.j()) {
            switch (jsonReader.J(f56991a)) {
                case 0:
                    strR2 = jsonReader.r();
                    break;
                case 1:
                    jM = jsonReader.m();
                    break;
                case 2:
                    strR = jsonReader.r();
                    break;
                case 3:
                    int iM3 = jsonReader.m();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (iM3 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iM3];
                    }
                    break;
                case 4:
                    jM2 = jsonReader.m();
                    break;
                case 5:
                    iM = (int) (jsonReader.m() * Utils.e());
                    break;
                case 6:
                    iM2 = (int) (jsonReader.m() * Utils.e());
                    break;
                case 7:
                    color = Color.parseColor(jsonReader.r());
                    break;
                case 8:
                    animatableTransformG = AnimatableTransformParser.g(jsonReader, lottieComposition);
                    break;
                case 9:
                    int iM4 = jsonReader.m();
                    if (iM4 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[iM4];
                        int i3 = AnonymousClass1.f56994a[matteType2.ordinal()];
                        if (i3 == 1) {
                            lottieComposition.a("Unsupported matte type: Luma");
                        } else if (i3 == 2) {
                            lottieComposition.a("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.r(1);
                    } else {
                        lottieComposition.a("Unsupported matte type: " + iM4);
                    }
                    break;
                case 10:
                    jsonReader.b();
                    while (jsonReader.j()) {
                        arrayList.add(MaskParser.a(jsonReader, lottieComposition));
                    }
                    lottieComposition.r(arrayList.size());
                    jsonReader.f();
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.j()) {
                        ContentModel contentModelA = ContentModelParser.a(jsonReader, lottieComposition);
                        if (contentModelA != null) {
                            arrayList2.add(contentModelA);
                        }
                    }
                    jsonReader.f();
                    break;
                case 12:
                    jsonReader.c();
                    while (jsonReader.j()) {
                        int iJ = jsonReader.J(f56992b);
                        if (iJ == 0) {
                            animatableTextFrameD = AnimatableValueParser.d(jsonReader, lottieComposition);
                        } else if (iJ != 1) {
                            jsonReader.K();
                            jsonReader.L();
                        } else {
                            jsonReader.b();
                            if (jsonReader.j()) {
                                animatableTextPropertiesA = AnimatableTextPropertiesParser.a(jsonReader, lottieComposition);
                            }
                            while (jsonReader.j()) {
                                jsonReader.L();
                            }
                            jsonReader.f();
                        }
                    }
                    jsonReader.i();
                    break;
                case 13:
                    jsonReader.b();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.j()) {
                        jsonReader.c();
                        while (jsonReader.j()) {
                            int iJ2 = jsonReader.J(f56993c);
                            if (iJ2 == 0) {
                                int iM5 = jsonReader.m();
                                if (iM5 == 29) {
                                    blurEffectB = BlurEffectParser.b(jsonReader, lottieComposition);
                                } else if (iM5 == 25) {
                                    dropShadowEffectB = new DropShadowEffectParser().b(jsonReader, lottieComposition);
                                }
                            } else if (iJ2 != 1) {
                                jsonReader.K();
                                jsonReader.L();
                            } else {
                                arrayList3.add(jsonReader.r());
                            }
                        }
                        jsonReader.i();
                    }
                    jsonReader.f();
                    lottieComposition.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    break;
                case 14:
                    fL5 = (float) jsonReader.l();
                    break;
                case 15:
                    fL4 = (float) jsonReader.l();
                    break;
                case 16:
                    fL2 = (float) (jsonReader.l() * ((double) Utils.e()));
                    break;
                case 17:
                    fL3 = (float) (jsonReader.l() * ((double) Utils.e()));
                    break;
                case 18:
                    fL = (float) jsonReader.l();
                    break;
                case 19:
                    f4 = (float) jsonReader.l();
                    break;
                case 20:
                    animatableFloatValueF = AnimatableValueParser.f(jsonReader, lottieComposition, false);
                    break;
                case 21:
                    strR3 = jsonReader.r();
                    break;
                case 22:
                    zK = jsonReader.k();
                    break;
                default:
                    jsonReader.K();
                    jsonReader.L();
                    break;
            }
        }
        jsonReader.i();
        ArrayList arrayList4 = new ArrayList();
        if (fL > 0.0f) {
            f3 = fValueOf;
            arrayList4.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fL)));
        } else {
            f3 = fValueOf;
        }
        if (f4 <= 0.0f) {
            f4 = lottieComposition.f();
        }
        arrayList4.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, fL, Float.valueOf(f4)));
        arrayList4.add(new Keyframe(lottieComposition, f3, f3, null, f4, Float.valueOf(Float.MAX_VALUE)));
        if (strR2.endsWith(".ai") || "ai".equals(strR3)) {
            lottieComposition.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList2, lottieComposition, strR2, jM, layerType, jM2, strR, arrayList, animatableTransformG, iM, iM2, color, fL5, fL4, fL2, fL3, animatableTextFrameD, animatableTextPropertiesA, arrayList4, matteType2, animatableFloatValueF, zK, blurEffectB, dropShadowEffectB);
    }
}
