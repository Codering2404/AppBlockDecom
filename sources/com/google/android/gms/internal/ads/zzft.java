package com.google.android.gms.internal.ads;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzft {
    public static boolean zza(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(str);
    }

    public static boolean zzb(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(str);
    }

    public static String zzc(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if (xmlPullParser.getAttributeName(i3).equals(str)) {
                return xmlPullParser.getAttributeValue(i3);
            }
        }
        return null;
    }
}
