package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class JsonUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JsonReader.Options f56984a = JsonReader.Options.a("x", "y");

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.JsonUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f56985a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f56985a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56985a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56985a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f3) {
        jsonReader.b();
        float fL = (float) jsonReader.l();
        float fL2 = (float) jsonReader.l();
        while (jsonReader.C() != JsonReader.Token.END_ARRAY) {
            jsonReader.L();
        }
        jsonReader.f();
        return new PointF(fL * f3, fL2 * f3);
    }

    private static PointF b(JsonReader jsonReader, float f3) {
        float fL = (float) jsonReader.l();
        float fL2 = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.L();
        }
        return new PointF(fL * f3, fL2 * f3);
    }

    private static PointF c(JsonReader jsonReader, float f3) {
        jsonReader.c();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f56984a);
            if (iJ == 0) {
                fG = g(jsonReader);
            } else if (iJ != 1) {
                jsonReader.K();
                jsonReader.L();
            } else {
                fG2 = g(jsonReader);
            }
        }
        jsonReader.i();
        return new PointF(fG * f3, fG2 * f3);
    }

    static int d(JsonReader jsonReader) {
        jsonReader.b();
        int iL = (int) (jsonReader.l() * 255.0d);
        int iL2 = (int) (jsonReader.l() * 255.0d);
        int iL3 = (int) (jsonReader.l() * 255.0d);
        while (jsonReader.j()) {
            jsonReader.L();
        }
        jsonReader.f();
        return Color.argb(255, iL, iL2, iL3);
    }

    static PointF e(JsonReader jsonReader, float f3) {
        int i3 = AnonymousClass1.f56985a[jsonReader.C().ordinal()];
        if (i3 == 1) {
            return b(jsonReader, f3);
        }
        if (i3 == 2) {
            return a(jsonReader, f3);
        }
        if (i3 == 3) {
            return c(jsonReader, f3);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.C());
    }

    static List f(JsonReader jsonReader, float f3) {
        ArrayList arrayList = new ArrayList();
        jsonReader.b();
        while (jsonReader.C() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            arrayList.add(e(jsonReader, f3));
            jsonReader.f();
        }
        jsonReader.f();
        return arrayList;
    }

    static float g(JsonReader jsonReader) {
        JsonReader.Token tokenC = jsonReader.C();
        int i3 = AnonymousClass1.f56985a[tokenC.ordinal()];
        if (i3 == 1) {
            return (float) jsonReader.l();
        }
        if (i3 != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + tokenC);
        }
        jsonReader.b();
        float fL = (float) jsonReader.l();
        while (jsonReader.j()) {
            jsonReader.L();
        }
        jsonReader.f();
        return fL;
    }
}
