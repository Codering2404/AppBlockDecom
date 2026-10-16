package com.applovin.impl;

import com.applovin.impl.db;
import com.applovin.impl.lf;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f60253a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f60254b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f60255c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static lf a(String str) {
        try {
            return b(str);
        } catch (ch | NumberFormatException | XmlPullParserException unused) {
            oc.d("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static lf b(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!gs.c(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ch.a("Couldn't find xmp metadata", null);
        }
        db dbVarH = db.h();
        long jC = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (gs.c(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!b(xmlPullParserNewPullParser)) {
                    return null;
                }
                jC = c(xmlPullParserNewPullParser);
                dbVarH = a(xmlPullParserNewPullParser);
            } else if (gs.c(xmlPullParserNewPullParser, "Container:Directory")) {
                dbVarH = a(xmlPullParserNewPullParser, "Container", "Item");
            } else if (gs.c(xmlPullParserNewPullParser, "GContainer:Directory")) {
                dbVarH = a(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!gs.b(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (dbVarH.isEmpty()) {
            return null;
        }
        return new lf(jC, dbVarH);
    }

    private static long c(XmlPullParser xmlPullParser) {
        for (String str : f60254b) {
            String strA = gs.a(xmlPullParser, str);
            if (strA != null) {
                long j3 = Long.parseLong(strA);
                if (j3 == -1) {
                    return -9223372036854775807L;
                }
                return j3;
            }
        }
        return -9223372036854775807L;
    }

    private static db a(XmlPullParser xmlPullParser) {
        for (String str : f60255c) {
            String strA = gs.a(xmlPullParser, str);
            if (strA != null) {
                return db.a(new lf.a("image/jpeg", "Primary", 0L, 0L), new lf.a("video/mp4", "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return db.h();
    }

    private static db a(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        db.a aVarF = db.f();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (gs.c(xmlPullParser, str3)) {
                String strA = gs.a(xmlPullParser, str2 + ":Mime");
                String strA2 = gs.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = gs.a(xmlPullParser, str2 + ":Length");
                String strA4 = gs.a(xmlPullParser, str2 + ":Padding");
                if (strA != null && strA2 != null) {
                    aVarF.b(new lf.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
                } else {
                    return db.h();
                }
            }
        } while (!gs.b(xmlPullParser, str4));
        return aVarF.a();
    }

    private static boolean b(XmlPullParser xmlPullParser) {
        for (String str : f60253a) {
            String strA = gs.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }
}
