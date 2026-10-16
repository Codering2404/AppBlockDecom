package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PathParser implements ValueParser<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PathParser f57000a = new PathParser();

    private PathParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f3) {
        return JsonUtils.e(jsonReader, f3);
    }
}
