package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class KeyframeParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SparseArrayCompat f56987b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Interpolator f56986a = new LinearInterpolator();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static JsonReader.Options f56988c = JsonReader.Options.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static JsonReader.Options f56989d = JsonReader.Options.a("x", "y");

    private static WeakReference a(int i3) {
        WeakReference weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = (WeakReference) g().g(i3);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorA;
        pointF.x = MiscUtils.b(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.b(pointF2.x, -1.0f, 1.0f);
        float fB = MiscUtils.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        int iH = Utils.h(pointF.x, pointF.y, pointF2.x, fB);
        WeakReference weakReferenceA = L.c() ? null : a(iH);
        Interpolator interpolator = weakReferenceA != null ? (Interpolator) weakReferenceA.get() : null;
        if (weakReferenceA != null && interpolator != null) {
            return interpolator;
        }
        try {
            interpolatorA = PathInterpolatorCompat.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e3) {
            interpolatorA = "The Path cannot loop back on itself.".equals(e3.getMessage()) ? PathInterpolatorCompat.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
        }
        if (!L.c()) {
            try {
                h(iH, new WeakReference(interpolatorA));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolatorA;
    }

    static Keyframe c(JsonReader jsonReader, LottieComposition lottieComposition, float f3, ValueParser valueParser, boolean z2, boolean z3) {
        return (z2 && z3) ? e(lottieComposition, jsonReader, f3, valueParser) : z2 ? d(lottieComposition, jsonReader, f3, valueParser) : f(jsonReader, f3, valueParser);
    }

    private static Keyframe d(LottieComposition lottieComposition, JsonReader jsonReader, float f3, ValueParser valueParser) {
        Interpolator interpolatorB;
        Object obj;
        jsonReader.c();
        PointF pointFE = null;
        Object objA = null;
        Object objA2 = null;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        float fL = 0.0f;
        boolean z2 = false;
        PointF pointFE4 = null;
        while (jsonReader.j()) {
            switch (jsonReader.J(f56988c)) {
                case 0:
                    fL = (float) jsonReader.l();
                    break;
                case 1:
                    objA2 = valueParser.a(jsonReader, f3);
                    break;
                case 2:
                    objA = valueParser.a(jsonReader, f3);
                    break;
                case 3:
                    pointFE = JsonUtils.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointFE4 = JsonUtils.e(jsonReader, 1.0f);
                    break;
                case 5:
                    z2 = jsonReader.m() == 1;
                    break;
                case 6:
                    pointFE2 = JsonUtils.e(jsonReader, f3);
                    break;
                case 7:
                    pointFE3 = JsonUtils.e(jsonReader, f3);
                    break;
                default:
                    jsonReader.L();
                    break;
            }
        }
        jsonReader.i();
        if (z2) {
            interpolatorB = f56986a;
            obj = objA2;
        } else {
            interpolatorB = (pointFE == null || pointFE4 == null) ? f56986a : b(pointFE, pointFE4);
            obj = objA;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, objA2, obj, interpolatorB, fL, null);
        keyframe.f57124o = pointFE2;
        keyframe.f57125p = pointFE3;
        return keyframe;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.airbnb.lottie.value.Keyframe e(com.airbnb.lottie.LottieComposition r21, com.airbnb.lottie.parser.moshi.JsonReader r22, float r23, com.airbnb.lottie.parser.ValueParser r24) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.e(com.airbnb.lottie.LottieComposition, com.airbnb.lottie.parser.moshi.JsonReader, float, com.airbnb.lottie.parser.ValueParser):com.airbnb.lottie.value.Keyframe");
    }

    private static Keyframe f(JsonReader jsonReader, float f3, ValueParser valueParser) {
        return new Keyframe(valueParser.a(jsonReader, f3));
    }

    private static SparseArrayCompat g() {
        if (f56987b == null) {
            f56987b = new SparseArrayCompat();
        }
        return f56987b;
    }

    private static void h(int i3, WeakReference weakReference) {
        synchronized (KeyframeParser.class) {
            f56987b.m(i3, weakReference);
        }
    }
}
