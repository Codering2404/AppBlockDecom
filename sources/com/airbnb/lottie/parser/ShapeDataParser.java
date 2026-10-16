package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ShapeDataParser f57007a = new ShapeDataParser();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f57008b = JsonReader.Options.a("c", "v", "i", "o");

    private ShapeDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ShapeData a(JsonReader jsonReader, float f3) {
        if (jsonReader.C() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
        }
        jsonReader.c();
        List listF = null;
        List listF2 = null;
        List listF3 = null;
        boolean zK = false;
        while (jsonReader.j()) {
            int iJ = jsonReader.J(f57008b);
            if (iJ == 0) {
                zK = jsonReader.k();
            } else if (iJ == 1) {
                listF = JsonUtils.f(jsonReader, f3);
            } else if (iJ == 2) {
                listF2 = JsonUtils.f(jsonReader, f3);
            } else if (iJ != 3) {
                jsonReader.K();
                jsonReader.L();
            } else {
                listF3 = JsonUtils.f(jsonReader, f3);
            }
        }
        jsonReader.i();
        if (jsonReader.C() == JsonReader.Token.END_ARRAY) {
            jsonReader.f();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = listF.size();
        PointF pointF = (PointF) listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 1; i3 < size; i3++) {
            PointF pointF2 = (PointF) listF.get(i3);
            int i4 = i3 - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a((PointF) listF.get(i4), (PointF) listF3.get(i4)), MiscUtils.a(pointF2, (PointF) listF2.get(i3)), pointF2));
        }
        if (zK) {
            PointF pointF3 = (PointF) listF.get(0);
            int i5 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a((PointF) listF.get(i5), (PointF) listF3.get(i5)), MiscUtils.a(pointF3, (PointF) listF2.get(0)), pointF3));
        }
        return new ShapeData(pointF, zK, arrayList);
    }
}
