package com.applovin.impl;

import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class gs {
    public static String a(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if (xmlPullParser.getAttributeName(i3).equals(str)) {
                return xmlPullParser.getAttributeValue(i3);
            }
        }
        return null;
    }

    public static boolean b(XmlPullParser xmlPullParser, String str) {
        return a(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) {
        return b(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    public static boolean b(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 2;
    }

    public static boolean a(XmlPullParser xmlPullParser) {
        return xmlPullParser.getEventType() == 3;
    }
}
