package com.evernote.android.job.util.support;

import android.util.Xml;
import com.facebook.LegacyTokenHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class XmlUtils {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ReadMapCallback {
        Object a(XmlPullParser xmlPullParser, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface WriteMapCallback {
        void a(Object obj, String str, XmlSerializer xmlSerializer);
    }

    private static final void A(Object obj, String str, XmlSerializer xmlSerializer, WriteMapCallback writeMapCallback) throws IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag(null, "null");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, "null");
            return;
        }
        if (obj instanceof String) {
            xmlSerializer.startTag(null, LegacyTokenHelper.TYPE_STRING);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, LegacyTokenHelper.TYPE_STRING);
            return;
        }
        if (obj instanceof Integer) {
            str2 = LegacyTokenHelper.TYPE_INTEGER;
        } else if (obj instanceof Long) {
            str2 = LegacyTokenHelper.TYPE_LONG;
        } else if (obj instanceof Float) {
            str2 = LegacyTokenHelper.TYPE_FLOAT;
        } else if (obj instanceof Double) {
            str2 = LegacyTokenHelper.TYPE_DOUBLE;
        } else {
            if (!(obj instanceof Boolean)) {
                if (obj instanceof byte[]) {
                    o((byte[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof int[]) {
                    q((int[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof long[]) {
                    s((long[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof double[]) {
                    p((double[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof String[]) {
                    y((String[]) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof Map) {
                    u((Map) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof List) {
                    r((List) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof Set) {
                    x((Set) obj, str, xmlSerializer);
                    return;
                }
                if (obj instanceof CharSequence) {
                    xmlSerializer.startTag(null, LegacyTokenHelper.TYPE_STRING);
                    if (str != null) {
                        xmlSerializer.attribute(null, "name", str);
                    }
                    xmlSerializer.text(obj.toString());
                    xmlSerializer.endTag(null, LegacyTokenHelper.TYPE_STRING);
                    return;
                }
                if (writeMapCallback != null) {
                    writeMapCallback.a(obj, str, xmlSerializer);
                    return;
                }
                throw new RuntimeException("writeValueXml: unable to write value " + obj);
            }
            str2 = "boolean";
        }
        xmlSerializer.startTag(null, str2);
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "value", obj.toString());
        xmlSerializer.endTag(null, str2);
    }

    public static final HashMap a(InputStream inputStream) throws XmlPullParserException {
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        xmlPullParserNewPullParser.setInput(inputStream, null);
        return (HashMap) n(xmlPullParserNewPullParser, new String[1]);
    }

    public static final double[] b(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int i3 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            double[] dArr = new double[i3];
            int eventType = xmlPullParser.getEventType();
            int i4 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        dArr[i4] = Double.parseDouble(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (NullPointerException unused) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException unused2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return dArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i4++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in double-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in double-array");
        }
    }

    public static final int[] c(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int i3 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            int[] iArr = new int[i3];
            int eventType = xmlPullParser.getEventType();
            int i4 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        iArr[i4] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (NullPointerException unused) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException unused2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i4++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    public static final ArrayList d(XmlPullParser xmlPullParser, String str, String[] strArr) {
        return e(xmlPullParser, str, strArr, null);
    }

    private static final ArrayList e(XmlPullParser xmlPullParser, String str, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(m(xmlPullParser, strArr, readMapCallback));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final long[] f(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int i3 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            long[] jArr = new long[i3];
            int eventType = xmlPullParser.getEventType();
            int i4 = 0;
            do {
                if (eventType == 2) {
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                    try {
                        jArr[i4] = Long.parseLong(xmlPullParser.getAttributeValue(null, "value"));
                    } catch (NullPointerException unused) {
                        throw new XmlPullParserException("Need value attribute in item");
                    } catch (NumberFormatException unused2) {
                        throw new XmlPullParserException("Not a number in value attribute in item");
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return jArr;
                    }
                    if (!xmlPullParser.getName().equals("item")) {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i4++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in long-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in long-array");
        }
    }

    public static final HashMap g(XmlPullParser xmlPullParser, String str, String[] strArr) {
        return h(xmlPullParser, str, strArr, null);
    }

    public static final HashMap h(XmlPullParser xmlPullParser, String str, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                map.put(strArr[0], m(xmlPullParser, strArr, readMapCallback));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return map;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static final Object i(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        try {
            if (str.equals(LegacyTokenHelper.TYPE_INTEGER)) {
                return Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            }
            if (str.equals(LegacyTokenHelper.TYPE_LONG)) {
                return Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals(LegacyTokenHelper.TYPE_FLOAT)) {
                return Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals(LegacyTokenHelper.TYPE_DOUBLE)) {
                return Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            if (str.equals("boolean")) {
                return Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            }
            return null;
        } catch (NullPointerException unused) {
            throw new XmlPullParserException("Need value attribute in <" + str + ">");
        } catch (NumberFormatException unused2) {
            throw new XmlPullParserException("Not a number in value attribute in <" + str + ">");
        }
    }

    public static final HashSet j(XmlPullParser xmlPullParser, String str, String[] strArr) {
        return k(xmlPullParser, str, strArr, null);
    }

    private static final HashSet k(XmlPullParser xmlPullParser, String str, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(m(xmlPullParser, strArr, readMapCallback));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashSet;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final String[] l(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int i3 = Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"));
            xmlPullParser.next();
            String[] strArr2 = new String[i3];
            int eventType = xmlPullParser.getEventType();
            int i4 = 0;
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            strArr2[i4] = xmlPullParser.getAttributeValue(null, "value");
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        if (!xmlPullParser.getName().equals("null")) {
                            throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                        }
                        strArr2[i4] = null;
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return strArr2;
                    }
                    if (!xmlPullParser.getName().equals("item") && !xmlPullParser.getName().equals("null")) {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                    i4++;
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in string-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in string-array");
        }
    }

    private static final Object m(XmlPullParser xmlPullParser, String[] strArr, ReadMapCallback readMapCallback) throws XmlPullParserException, IOException {
        int next;
        Object objI = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            if (name.equals(LegacyTokenHelper.TYPE_STRING)) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    }
                    if (next2 == 3) {
                        if (xmlPullParser.getName().equals(LegacyTokenHelper.TYPE_STRING)) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    }
                    if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else {
                objI = i(xmlPullParser, name);
                if (objI == null) {
                    if (name.equals("int-array")) {
                        int[] iArrC = c(xmlPullParser, "int-array", strArr);
                        strArr[0] = attributeValue;
                        return iArrC;
                    }
                    if (name.equals("long-array")) {
                        long[] jArrF = f(xmlPullParser, "long-array", strArr);
                        strArr[0] = attributeValue;
                        return jArrF;
                    }
                    if (name.equals("double-array")) {
                        double[] dArrB = b(xmlPullParser, "double-array", strArr);
                        strArr[0] = attributeValue;
                        return dArrB;
                    }
                    if (name.equals("string-array")) {
                        String[] strArrL = l(xmlPullParser, "string-array", strArr);
                        strArr[0] = attributeValue;
                        return strArrL;
                    }
                    if (name.equals("map")) {
                        xmlPullParser.next();
                        HashMap mapG = g(xmlPullParser, "map", strArr);
                        strArr[0] = attributeValue;
                        return mapG;
                    }
                    if (name.equals("list")) {
                        xmlPullParser.next();
                        ArrayList arrayListD = d(xmlPullParser, "list", strArr);
                        strArr[0] = attributeValue;
                        return arrayListD;
                    }
                    if (name.equals("set")) {
                        xmlPullParser.next();
                        HashSet hashSetJ = j(xmlPullParser, "set", strArr);
                        strArr[0] = attributeValue;
                        return hashSetJ;
                    }
                    if (readMapCallback != null) {
                        Object objA = readMapCallback.a(xmlPullParser, name);
                        strArr[0] = attributeValue;
                        return objA;
                    }
                    throw new XmlPullParserException("Unknown tag: " + name);
                }
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + ">");
            }
            if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return objI;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            }
            if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }

    public static final Object n(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            }
            if (eventType == 4) {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                throw new XmlPullParserException("Unexpected end of document");
            }
        }
        return m(xmlPullParser, strArr, null);
    }

    public static final void o(byte[] bArr, String str, XmlSerializer xmlSerializer) throws IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(bArr.length));
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            int i3 = b3 >> 4;
            sb.append(i3 >= 10 ? i3 + 87 : i3 + 48);
            int i4 = b3 & 255;
            sb.append(i4 >= 10 ? i4 + 87 : i4 + 48);
        }
        xmlSerializer.text(sb.toString());
        xmlSerializer.endTag(null, "byte-array");
    }

    public static final void p(double[] dArr, String str, XmlSerializer xmlSerializer) throws IOException {
        if (dArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "double-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(dArr.length));
        for (double d3 : dArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Double.toString(d3));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "double-array");
    }

    public static final void q(int[] iArr, String str, XmlSerializer xmlSerializer) throws IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(iArr.length));
        for (int i3 : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Integer.toString(i3));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
    }

    public static final void r(List list, String str, XmlSerializer xmlSerializer) throws IOException {
        if (list == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            z(list.get(i3), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "list");
    }

    public static final void s(long[] jArr, String str, XmlSerializer xmlSerializer) throws IOException {
        if (jArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "long-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(jArr.length));
        for (long j3 : jArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Long.toString(j3));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "long-array");
    }

    public static final void t(Map map, OutputStream outputStream) throws IOException {
        FastXmlSerializer fastXmlSerializer = new FastXmlSerializer();
        fastXmlSerializer.setOutput(outputStream, "utf-8");
        fastXmlSerializer.startDocument(null, Boolean.TRUE);
        fastXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        u(map, null, fastXmlSerializer);
        fastXmlSerializer.endDocument();
    }

    public static final void u(Map map, String str, XmlSerializer xmlSerializer) throws IOException {
        v(map, str, xmlSerializer, null);
    }

    public static final void v(Map map, String str, XmlSerializer xmlSerializer, WriteMapCallback writeMapCallback) throws IOException {
        if (map == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        w(map, xmlSerializer, writeMapCallback);
        xmlSerializer.endTag(null, "map");
    }

    public static final void w(Map map, XmlSerializer xmlSerializer, WriteMapCallback writeMapCallback) throws IOException {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            A(entry.getValue(), (String) entry.getKey(), xmlSerializer, writeMapCallback);
        }
    }

    public static final void x(Set set, String str, XmlSerializer xmlSerializer) throws IOException {
        if (set == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "set");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            z(it.next(), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "set");
    }

    public static final void y(String[] strArr, String str, XmlSerializer xmlSerializer) throws IOException {
        if (strArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "string-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int length = strArr.length;
        xmlSerializer.attribute(null, "num", Integer.toString(length));
        for (int i3 = 0; i3 < length; i3++) {
            if (strArr[i3] == null) {
                xmlSerializer.startTag(null, "null");
                xmlSerializer.endTag(null, "null");
            } else {
                xmlSerializer.startTag(null, "item");
                xmlSerializer.attribute(null, "value", strArr[i3]);
                xmlSerializer.endTag(null, "item");
            }
        }
        xmlSerializer.endTag(null, "string-array");
    }

    public static final void z(Object obj, String str, XmlSerializer xmlSerializer) throws IOException {
        A(obj, str, xmlSerializer, null);
    }
}
