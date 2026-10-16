package com.applovin.impl;

import android.text.Layout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class fp extends ek {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Pattern f59767p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f59768q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Pattern f59769r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final Pattern f59770s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final Pattern f59771t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Pattern f59772u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Pattern f59773v = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final b f59774w = new b(30.0f, 1, 1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final a f59775x = new a(32, 15);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final XmlPullParserFactory f59776o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f59777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f59778b;

        a(int i3, int i4) {
            this.f59777a = i3;
            this.f59778b = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f59779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f59780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f59781c;

        b(float f3, int i3, int i4) {
            this.f59779a = f3;
            this.f59780b = i3;
            this.f59781c = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f59782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f59783b;

        c(int i3, int i4) {
            this.f59782a = i3;
            this.f59783b = i4;
        }
    }

    public fp() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f59776o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e3) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e3);
        }
    }

    private static jp a(jp jpVar) {
        return jpVar == null ? new jp() : jpVar;
    }

    private static Layout.Alignment b(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.getClass();
        switch (lowerCase) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static float c(String str) {
        Matcher matcher = f59770s.matcher(str);
        if (!matcher.matches()) {
            oc.d("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) b1.a((Object) matcher.group(1)))));
        } catch (NumberFormatException e3) {
            oc.c("TtmlDecoder", "Failed to parse shear: " + str, e3);
            return Float.MAX_VALUE;
        }
    }

    private static String[] d(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : xp.a(strTrim, "\\s+");
    }

    @Override // com.applovin.impl.ek
    protected nl a(byte[] bArr, int i3, boolean z2) throws pl {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f59776o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new hp(""));
            int i4 = 0;
            c cVarB = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i3), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarA = f59774w;
            a aVarA = f59775x;
            kp kpVar = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                gp gpVar = (gp) arrayDeque.peek();
                if (i4 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarA = a(xmlPullParserNewPullParser);
                            aVarA = a(xmlPullParserNewPullParser, f59775x);
                            cVarB = b(xmlPullParserNewPullParser);
                        }
                        b bVar = bVarA;
                        c cVar = cVarB;
                        a aVar = aVarA;
                        if (a(name)) {
                            if ("head".equals(name)) {
                                a(xmlPullParserNewPullParser, map, aVar, cVar, map2, map3);
                            } else {
                                try {
                                    gp gpVarA = a(xmlPullParserNewPullParser, gpVar, map2, bVar);
                                    arrayDeque.push(gpVarA);
                                    if (gpVar != null) {
                                        gpVar.a(gpVarA);
                                    }
                                } catch (pl e3) {
                                    oc.c("TtmlDecoder", "Suppressing parser error", e3);
                                    aVarA = aVar;
                                    cVarB = cVar;
                                    bVarA = bVar;
                                    i4++;
                                }
                            }
                            aVarA = aVar;
                            cVarB = cVar;
                            bVarA = bVar;
                        } else {
                            oc.c("TtmlDecoder", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        }
                        aVarA = aVar;
                        cVarB = cVar;
                        bVarA = bVar;
                        i4++;
                    } else if (eventType == 4) {
                        ((gp) b1.a(gpVar)).a(gp.a(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            kpVar = new kp((gp) b1.a((gp) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i4++;
                } else if (eventType == 3) {
                    i4--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (kpVar != null) {
                return kpVar;
            }
            throw new pl("No TTML subtitles found");
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        } catch (XmlPullParserException e5) {
            throw new pl("Unable to decode source", e5);
        }
    }

    private static c b(XmlPullParser xmlPullParser) {
        String strA = gs.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = f59772u.matcher(strA);
        if (!matcher.matches()) {
            oc.d("TtmlDecoder", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new c(Integer.parseInt((String) b1.a((Object) matcher.group(1))), Integer.parseInt((String) b1.a((Object) matcher.group(2))));
        } catch (NumberFormatException unused) {
            oc.d("TtmlDecoder", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    private static boolean a(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static a a(XmlPullParser xmlPullParser, a aVar) throws pl {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f59773v.matcher(attributeValue);
        if (!matcher.matches()) {
            oc.d("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i3 = Integer.parseInt((String) b1.a((Object) matcher.group(1)));
            int i4 = Integer.parseInt((String) b1.a((Object) matcher.group(2)));
            if (i3 != 0 && i4 != 0) {
                return new a(i3, i4);
            }
            throw new pl("Invalid cell resolution " + i3 + " " + i4);
        } catch (NumberFormatException unused) {
            oc.d("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static void a(String str, jp jpVar) throws pl {
        Matcher matcher;
        String str2;
        String[] strArrA = xp.a(str, "\\s+");
        if (strArrA.length == 1) {
            matcher = f59769r.matcher(str);
        } else if (strArrA.length == 2) {
            matcher = f59769r.matcher(strArrA[1]);
            oc.d("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new pl("Invalid number of entries for fontSize: " + strArrA.length + ".");
        }
        if (matcher.matches()) {
            str2 = (String) b1.a((Object) matcher.group(3));
            str2.getClass();
            switch (str2) {
                case "%":
                    jpVar.c(3);
                    break;
                case "em":
                    jpVar.c(2);
                    break;
                case "px":
                    jpVar.c(1);
                    break;
                default:
                    throw new pl("Invalid unit for fontSize: '" + str2 + "'.");
            }
            jpVar.a(Float.parseFloat((String) b1.a((Object) matcher.group(1))));
            return;
        }
        throw new pl("Invalid expression for fontSize: '" + str + "'.");
    }

    private static b a(XmlPullParser xmlPullParser) throws pl {
        float f3;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i3 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (xp.a(attributeValue2, " ").length == 2) {
                f3 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
            } else {
                throw new pl("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f3 = 1.0f;
        }
        b bVar = f59774w;
        int i4 = bVar.f59780b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i4 = Integer.parseInt(attributeValue3);
        }
        int i5 = bVar.f59781c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i5 = Integer.parseInt(attributeValue4);
        }
        return new b(i3 * f3, i4, i5);
    }

    private static Map a(XmlPullParser xmlPullParser, Map map, a aVar, c cVar, Map map2, Map map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (gs.c(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                String strA = gs.a(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                jp jpVarA = a(xmlPullParser, new jp());
                if (strA != null) {
                    for (String str : d(strA)) {
                        jpVarA.a((jp) map.get(str));
                    }
                }
                String strF = jpVarA.f();
                if (strF != null) {
                    map.put(strF, jpVarA);
                }
            } else if (gs.c(xmlPullParser, "region")) {
                hp hpVarA = a(xmlPullParser, aVar, cVar);
                if (hpVarA != null) {
                    map2.put(hpVarA.f60233a, hpVarA);
                }
            } else if (gs.c(xmlPullParser, "metadata")) {
                a(xmlPullParser, map3);
            }
        } while (!gs.b(xmlPullParser, "head"));
        return map;
    }

    private static void a(XmlPullParser xmlPullParser, Map map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (gs.c(xmlPullParser, "image") && (strA = gs.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!gs.b(xmlPullParser, "metadata"));
    }

    private static gp a(XmlPullParser xmlPullParser, gp gpVar, Map map, b bVar) throws pl {
        String attributeValue;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser2.getAttributeCount();
        String strSubstring = null;
        jp jpVarA = a(xmlPullParser2, (jp) null);
        long jA = -9223372036854775807L;
        long jA2 = -9223372036854775807L;
        long jA3 = -9223372036854775807L;
        String[] strArr = null;
        String str = "";
        int i3 = 0;
        while (i3 < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i3);
            int i4 = attributeCount;
            attributeValue = xmlPullParser2.getAttributeValue(i3);
            attributeName.getClass();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    i3++;
                    xmlPullParser2 = xmlPullParser;
                    attributeCount = i4;
                    break;
                case "dur":
                    jA3 = a(attributeValue, bVar);
                    break;
                case "end":
                    jA2 = a(attributeValue, bVar);
                    break;
                case "begin":
                    jA = a(attributeValue, bVar);
                    break;
                case "style":
                    String[] strArrD = d(attributeValue);
                    if (strArrD.length > 0) {
                        strArr = strArrD;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
            i3++;
            xmlPullParser2 = xmlPullParser;
            attributeCount = i4;
        }
        if (gpVar != null) {
            long j3 = gpVar.f60032d;
            if (j3 != -9223372036854775807L) {
                if (jA != -9223372036854775807L) {
                    jA += j3;
                }
                if (jA2 != -9223372036854775807L) {
                    jA2 += j3;
                }
            }
        }
        long j4 = jA;
        if (jA2 == -9223372036854775807L) {
            if (jA3 != -9223372036854775807L) {
                jA2 = j4 + jA3;
            } else if (gpVar != null) {
                long j5 = gpVar.f60033e;
                if (j5 != -9223372036854775807L) {
                    jA2 = j5;
                }
            }
        }
        return gp.a(xmlPullParser.getName(), j4, jA2, jpVarA, strArr, str, strSubstring, gpVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.applovin.impl.hp a(org.xmlpull.v1.XmlPullParser r17, com.applovin.impl.fp.a r18, com.applovin.impl.fp.c r19) {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.fp.a(org.xmlpull.v1.XmlPullParser, com.applovin.impl.fp$a, com.applovin.impl.fp$c):com.applovin.impl.hp");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static jp a(XmlPullParser xmlPullParser, jp jpVar) {
        byte b3;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            String attributeName = xmlPullParser.getAttributeName(i3);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    b3 = attributeName.equals("fontStyle") ? (byte) 0 : (byte) -1;
                    break;
                case -1224696685:
                    b3 = attributeName.equals("fontFamily") ? (byte) 1 : (byte) -1;
                    break;
                case -1065511464:
                    b3 = attributeName.equals("textAlign") ? (byte) 2 : (byte) -1;
                    break;
                case -879295043:
                    b3 = attributeName.equals("textDecoration") ? (byte) 3 : (byte) -1;
                    break;
                case -734428249:
                    b3 = attributeName.equals("fontWeight") ? (byte) 4 : (byte) -1;
                    break;
                case 3355:
                    b3 = attributeName.equals("id") ? (byte) 5 : (byte) -1;
                    break;
                case 3511770:
                    b3 = attributeName.equals("ruby") ? (byte) 6 : (byte) -1;
                    break;
                case 94842723:
                    b3 = attributeName.equals("color") ? (byte) 7 : (byte) -1;
                    break;
                case 109403361:
                    b3 = attributeName.equals("shear") ? (byte) 8 : (byte) -1;
                    break;
                case 110138194:
                    b3 = attributeName.equals("textCombine") ? (byte) 9 : (byte) -1;
                    break;
                case 365601008:
                    b3 = attributeName.equals("fontSize") ? (byte) 10 : (byte) -1;
                    break;
                case 921125321:
                    b3 = attributeName.equals("textEmphasis") ? Ascii.VT : (byte) -1;
                    break;
                case 1115953443:
                    b3 = attributeName.equals("rubyPosition") ? Ascii.FF : (byte) -1;
                    break;
                case 1287124693:
                    b3 = attributeName.equals("backgroundColor") ? Ascii.CR : (byte) -1;
                    break;
                case 1754920356:
                    b3 = attributeName.equals("multiRowAlign") ? Ascii.SO : (byte) -1;
                    break;
                default:
                    b3 = -1;
                    break;
            }
            switch (b3) {
                case 0:
                    jpVar = a(jpVar).b("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    jpVar = a(jpVar).a(attributeValue);
                    break;
                case 2:
                    jpVar = a(jpVar).b(b(attributeValue));
                    break;
                case 3:
                    String lowerCase = Ascii.toLowerCase(attributeValue);
                    lowerCase.getClass();
                    switch (lowerCase) {
                        case "nounderline":
                            jpVar = a(jpVar).e(false);
                            break;
                        case "underline":
                            jpVar = a(jpVar).e(true);
                            break;
                        case "nolinethrough":
                            jpVar = a(jpVar).c(false);
                            break;
                        case "linethrough":
                            jpVar = a(jpVar).c(true);
                            break;
                    }
                    break;
                case 4:
                    jpVar = a(jpVar).a("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        jpVar = a(jpVar).b(attributeValue);
                    }
                    break;
                case 6:
                    String lowerCase2 = Ascii.toLowerCase(attributeValue);
                    lowerCase2.getClass();
                    switch (lowerCase2) {
                        case "baseContainer":
                        case "base":
                            jpVar = a(jpVar).e(2);
                            break;
                        case "container":
                            jpVar = a(jpVar).e(1);
                            break;
                        case "delimiter":
                            jpVar = a(jpVar).e(4);
                            break;
                        case "textContainer":
                        case "text":
                            jpVar = a(jpVar).e(3);
                            break;
                    }
                    break;
                case 7:
                    jpVar = a(jpVar);
                    try {
                        jpVar.b(s3.b(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        oc.d("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    jpVar = a(jpVar).b(c(attributeValue));
                    break;
                case 9:
                    String lowerCase3 = Ascii.toLowerCase(attributeValue);
                    lowerCase3.getClass();
                    if (lowerCase3.equals("all")) {
                        jpVar = a(jpVar).d(true);
                    } else if (lowerCase3.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                        jpVar = a(jpVar).d(false);
                    }
                    break;
                case 10:
                    try {
                        jpVar = a(jpVar);
                        a(attributeValue, jpVar);
                    } catch (pl unused2) {
                        oc.d("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    jpVar = a(jpVar).a(xn.a(attributeValue));
                    break;
                case 12:
                    String lowerCase4 = Ascii.toLowerCase(attributeValue);
                    lowerCase4.getClass();
                    if (lowerCase4.equals("before")) {
                        jpVar = a(jpVar).d(1);
                    } else if (lowerCase4.equals("after")) {
                        jpVar = a(jpVar).d(2);
                    }
                    break;
                case 13:
                    jpVar = a(jpVar);
                    try {
                        jpVar.a(s3.b(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        oc.d("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    jpVar = a(jpVar).a(b(attributeValue));
                    break;
            }
        }
        return jpVar;
    }

    private static long a(String str, b bVar) throws pl {
        double d3;
        double d4;
        double d5;
        Matcher matcher = f59767p.matcher(str);
        if (matcher.matches()) {
            double d6 = (Long.parseLong((String) b1.a((Object) matcher.group(1))) * 3600) + (Long.parseLong((String) b1.a((Object) matcher.group(2))) * 60) + Long.parseLong((String) b1.a((Object) matcher.group(3)));
            String strGroup = matcher.group(4);
            return (long) ((d6 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / bVar.f59779a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / ((double) bVar.f59780b)) / ((double) bVar.f59779a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f59768q.matcher(str);
        if (matcher2.matches()) {
            d3 = Double.parseDouble((String) b1.a((Object) matcher2.group(1)));
            String str2 = (String) b1.a((Object) matcher2.group(2));
            str2.getClass();
            switch (str2) {
                case "f":
                    d4 = bVar.f59779a;
                    d3 /= d4;
                    return (long) (d3 * 1000000.0d);
                case "h":
                    d5 = 3600.0d;
                    break;
                case "m":
                    d5 = 60.0d;
                    break;
                case "t":
                    d4 = bVar.f59781c;
                    d3 /= d4;
                    return (long) (d3 * 1000000.0d);
                case "ms":
                    d4 = 1000.0d;
                    d3 /= d4;
                    return (long) (d3 * 1000000.0d);
                default:
                    return (long) (d3 * 1000000.0d);
            }
            d3 *= d5;
            return (long) (d3 * 1000000.0d);
        }
        throw new pl("Malformed time expression: " + str);
    }
}
