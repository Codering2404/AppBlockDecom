package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DocumentDataParser f56959a = new DocumentDataParser();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JsonReader.Options f56960b = JsonReader.Options.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private DocumentDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f3) {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.c();
        DocumentData.Justification justification2 = justification;
        String strR = null;
        String strR2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fL = 0.0f;
        float fL2 = 0.0f;
        float fL3 = 0.0f;
        float fL4 = 0.0f;
        int iM = 0;
        int iD = 0;
        int iD2 = 0;
        boolean zK = true;
        while (jsonReader.j()) {
            switch (jsonReader.J(f56960b)) {
                case 0:
                    strR = jsonReader.r();
                    break;
                case 1:
                    strR2 = jsonReader.r();
                    break;
                case 2:
                    fL = (float) jsonReader.l();
                    break;
                case 3:
                    int iM2 = jsonReader.m();
                    justification2 = DocumentData.Justification.CENTER;
                    if (iM2 <= justification2.ordinal() && iM2 >= 0) {
                        justification2 = DocumentData.Justification.values()[iM2];
                    }
                    break;
                case 4:
                    iM = jsonReader.m();
                    break;
                case 5:
                    fL2 = (float) jsonReader.l();
                    break;
                case 6:
                    fL3 = (float) jsonReader.l();
                    break;
                case 7:
                    iD = JsonUtils.d(jsonReader);
                    break;
                case 8:
                    iD2 = JsonUtils.d(jsonReader);
                    break;
                case 9:
                    fL4 = (float) jsonReader.l();
                    break;
                case 10:
                    zK = jsonReader.k();
                    break;
                case 11:
                    jsonReader.b();
                    PointF pointF3 = new PointF(((float) jsonReader.l()) * f3, ((float) jsonReader.l()) * f3);
                    jsonReader.f();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.b();
                    PointF pointF4 = new PointF(((float) jsonReader.l()) * f3, ((float) jsonReader.l()) * f3);
                    jsonReader.f();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.K();
                    jsonReader.L();
                    break;
            }
        }
        jsonReader.i();
        return new DocumentData(strR, strR2, fL, justification2, iM, fL2, fL3, iD, iD2, fL4, zK, pointF, pointF2);
    }
}
