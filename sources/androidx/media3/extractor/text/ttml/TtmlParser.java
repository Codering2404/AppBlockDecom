package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.base.Ascii;
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
/* JADX INFO: loaded from: classes2.dex */
public final class TtmlParser implements SubtitleParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f47204b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f47205c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f47206d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Pattern f47207e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Pattern f47208f = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f47209g = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f47210h = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final FrameAndTickRate f47211i = new FrameAndTickRate(30.0f, 1, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f47212a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class FrameAndTickRate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f47213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f47214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f47215c;

        FrameAndTickRate(float f3, int i3, int i4) {
            this.f47213a = f3;
            this.f47214b = i3;
            this.f47215c = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class TtsExtent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f47216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f47217b;

        TtsExtent(int i3, int i4) {
            this.f47216a = i3;
            this.f47217b = i4;
        }
    }

    public TtmlParser() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f47212a = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e3) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e3);
        }
    }

    private static TtmlStyle d(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static boolean e(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static Layout.Alignment f(String str) {
        String strE = Ascii.e(str);
        strE.getClass();
        switch (strE) {
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

    private static int g(XmlPullParser xmlPullParser, int i3) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return i3;
        }
        Matcher matcher = f47210h.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.i("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i3;
        }
        boolean z2 = true;
        try {
            int i4 = Integer.parseInt((String) Assertions.e(matcher.group(1)));
            int i5 = Integer.parseInt((String) Assertions.e(matcher.group(2)));
            if (i4 == 0 || i5 == 0) {
                z2 = false;
            }
            Assertions.b(z2, "Invalid cell resolution " + i4 + " " + i5);
            return i5;
        } catch (NumberFormatException unused) {
            Log.i("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i3;
        }
    }

    private static void h(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String str2;
        String[] strArrH1 = Util.h1(str, "\\s+");
        if (strArrH1.length == 1) {
            matcher = f47206d.matcher(str);
        } else {
            if (strArrH1.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrH1.length + ".");
            }
            matcher = f47206d.matcher(strArrH1[1]);
            Log.i("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) Assertions.e(matcher.group(3));
        str2.getClass();
        switch (str2) {
            case "%":
                ttmlStyle.C(3);
                break;
            case "em":
                ttmlStyle.C(2);
                break;
            case "px":
                ttmlStyle.C(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        ttmlStyle.B(Float.parseFloat((String) Assertions.e(matcher.group(1))));
    }

    private static FrameAndTickRate i(XmlPullParser xmlPullParser) {
        float f3;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i3 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            Assertions.b(Util.h1(attributeValue2, " ").length == 2, "frameRateMultiplier doesn't have 2 parts");
            f3 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f3 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = f47211i;
        int i4 = frameAndTickRate.f47214b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i4 = Integer.parseInt(attributeValue3);
        }
        int i5 = frameAndTickRate.f47215c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i5 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i3 * f3, i4, i5);
    }

    private static Map j(XmlPullParser xmlPullParser, Map map, int i3, TtsExtent ttsExtent, Map map2, Map map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.e(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                String strA = XmlPullParserUtil.a(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                TtmlStyle ttmlStyleO = o(xmlPullParser, new TtmlStyle());
                if (strA != null) {
                    for (String str : p(strA)) {
                        ttmlStyleO.a((TtmlStyle) map.get(str));
                    }
                }
                String strH = ttmlStyleO.h();
                if (strH != null) {
                    map.put(strH, ttmlStyleO);
                }
            } else if (XmlPullParserUtil.e(xmlPullParser, "region")) {
                TtmlRegion ttmlRegionM = m(xmlPullParser, i3, ttsExtent, map);
                if (ttmlRegionM != null) {
                    map2.put(ttmlRegionM.f47218a, ttmlRegionM);
                }
            } else if (XmlPullParserUtil.e(xmlPullParser, "metadata")) {
                k(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.c(xmlPullParser, "head"));
        return map;
    }

    private static void k(XmlPullParser xmlPullParser, Map map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.e(xmlPullParser, "image") && (strA = XmlPullParserUtil.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.c(xmlPullParser, "metadata"));
    }

    private static TtmlNode l(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        String attributeValue;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser2.getAttributeCount();
        String strSubstring = null;
        TtmlStyle ttmlStyleO = o(xmlPullParser2, null);
        long jQ = -9223372036854775807L;
        long jQ2 = -9223372036854775807L;
        long jQ3 = -9223372036854775807L;
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
                    jQ3 = q(attributeValue, frameAndTickRate);
                    break;
                case "end":
                    jQ2 = q(attributeValue, frameAndTickRate);
                    break;
                case "begin":
                    jQ = q(attributeValue, frameAndTickRate);
                    break;
                case "style":
                    String[] strArrP = p(attributeValue);
                    if (strArrP.length > 0) {
                        strArr = strArrP;
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
        if (ttmlNode != null) {
            long j3 = ttmlNode.f47194d;
            if (j3 != -9223372036854775807L) {
                if (jQ != -9223372036854775807L) {
                    jQ += j3;
                }
                if (jQ2 != -9223372036854775807L) {
                    jQ2 += j3;
                }
            }
        }
        long j4 = jQ;
        if (jQ2 == -9223372036854775807L) {
            if (jQ3 != -9223372036854775807L) {
                jQ2 = j4 + jQ3;
            } else if (ttmlNode != null) {
                long j5 = ttmlNode.f47195e;
                if (j5 != -9223372036854775807L) {
                    jQ2 = j5;
                }
            }
        }
        return TtmlNode.c(xmlPullParser.getName(), j4, jQ2, ttmlStyleO, strArr, str, strSubstring, ttmlNode);
    }

    private static float n(String str) {
        Matcher matcher = f47207e.matcher(str);
        if (!matcher.matches()) {
            Log.i("TtmlParser", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.e(matcher.group(1)))));
        } catch (NumberFormatException e3) {
            Log.j("TtmlParser", "Failed to parse shear: " + str, e3);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static TtmlStyle o(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
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
                case -1289044182:
                    b3 = attributeName.equals("extent") ? (byte) 1 : (byte) -1;
                    break;
                case -1224696685:
                    b3 = attributeName.equals("fontFamily") ? (byte) 2 : (byte) -1;
                    break;
                case -1065511464:
                    b3 = attributeName.equals("textAlign") ? (byte) 3 : (byte) -1;
                    break;
                case -1008619738:
                    b3 = attributeName.equals("origin") ? (byte) 4 : (byte) -1;
                    break;
                case -879295043:
                    b3 = attributeName.equals("textDecoration") ? (byte) 5 : (byte) -1;
                    break;
                case -734428249:
                    b3 = attributeName.equals("fontWeight") ? (byte) 6 : (byte) -1;
                    break;
                case 3355:
                    b3 = attributeName.equals("id") ? (byte) 7 : (byte) -1;
                    break;
                case 3511770:
                    b3 = attributeName.equals("ruby") ? (byte) 8 : (byte) -1;
                    break;
                case 94842723:
                    b3 = attributeName.equals("color") ? (byte) 9 : (byte) -1;
                    break;
                case 109403361:
                    b3 = attributeName.equals("shear") ? (byte) 10 : (byte) -1;
                    break;
                case 110138194:
                    b3 = attributeName.equals("textCombine") ? com.applovin.exoplayer2.common.base.Ascii.VT : (byte) -1;
                    break;
                case 365601008:
                    b3 = attributeName.equals("fontSize") ? com.applovin.exoplayer2.common.base.Ascii.FF : (byte) -1;
                    break;
                case 921125321:
                    b3 = attributeName.equals("textEmphasis") ? com.applovin.exoplayer2.common.base.Ascii.CR : (byte) -1;
                    break;
                case 1115953443:
                    b3 = attributeName.equals("rubyPosition") ? com.applovin.exoplayer2.common.base.Ascii.SO : (byte) -1;
                    break;
                case 1287124693:
                    b3 = attributeName.equals("backgroundColor") ? com.applovin.exoplayer2.common.base.Ascii.SI : (byte) -1;
                    break;
                case 1754920356:
                    b3 = attributeName.equals("multiRowAlign") ? com.applovin.exoplayer2.common.base.Ascii.DLE : (byte) -1;
                    break;
                default:
                    b3 = -1;
                    break;
            }
            switch (b3) {
                case 0:
                    ttmlStyle = d(ttmlStyle).E("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    ttmlStyle = d(ttmlStyle).y(attributeValue);
                    break;
                case 2:
                    ttmlStyle = d(ttmlStyle).A(attributeValue);
                    break;
                case 3:
                    ttmlStyle = d(ttmlStyle).L(f(attributeValue));
                    break;
                case 4:
                    ttmlStyle = d(ttmlStyle).H(attributeValue);
                    break;
                case 5:
                    String strE = Ascii.e(attributeValue);
                    strE.getClass();
                    switch (strE) {
                        case "nounderline":
                            ttmlStyle = d(ttmlStyle).O(false);
                            break;
                        case "underline":
                            ttmlStyle = d(ttmlStyle).O(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = d(ttmlStyle).F(false);
                            break;
                        case "linethrough":
                            ttmlStyle = d(ttmlStyle).F(true);
                            break;
                    }
                    break;
                case 6:
                    ttmlStyle = d(ttmlStyle).x("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        ttmlStyle = d(ttmlStyle).D(attributeValue);
                    }
                    break;
                case 8:
                    String strE2 = Ascii.e(attributeValue);
                    strE2.getClass();
                    switch (strE2) {
                        case "baseContainer":
                        case "base":
                            ttmlStyle = d(ttmlStyle).J(2);
                            break;
                        case "container":
                            ttmlStyle = d(ttmlStyle).J(1);
                            break;
                        case "delimiter":
                            ttmlStyle = d(ttmlStyle).J(4);
                            break;
                        case "textContainer":
                        case "text":
                            ttmlStyle = d(ttmlStyle).J(3);
                            break;
                    }
                    break;
                case 9:
                    ttmlStyle = d(ttmlStyle);
                    try {
                        ttmlStyle.z(ColorParser.c(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        Log.i("TtmlParser", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 10:
                    ttmlStyle = d(ttmlStyle).K(n(attributeValue));
                    break;
                case 11:
                    String strE3 = Ascii.e(attributeValue);
                    strE3.getClass();
                    if (strE3.equals("all")) {
                        ttmlStyle = d(ttmlStyle).M(true);
                    } else if (strE3.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                        ttmlStyle = d(ttmlStyle).M(false);
                    }
                    break;
                case 12:
                    try {
                        ttmlStyle = d(ttmlStyle);
                        h(attributeValue, ttmlStyle);
                    } catch (SubtitleDecoderException unused2) {
                        Log.i("TtmlParser", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 13:
                    ttmlStyle = d(ttmlStyle).N(TextEmphasis.a(attributeValue));
                    break;
                case 14:
                    String strE4 = Ascii.e(attributeValue);
                    strE4.getClass();
                    if (strE4.equals("before")) {
                        ttmlStyle = d(ttmlStyle).I(1);
                    } else if (strE4.equals("after")) {
                        ttmlStyle = d(ttmlStyle).I(2);
                    }
                    break;
                case 15:
                    ttmlStyle = d(ttmlStyle);
                    try {
                        ttmlStyle.w(ColorParser.c(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        Log.i("TtmlParser", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 16:
                    ttmlStyle = d(ttmlStyle).G(f(attributeValue));
                    break;
            }
        }
        return ttmlStyle;
    }

    private static String[] p(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : Util.h1(strTrim, "\\s+");
    }

    private static long q(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d3;
        double d4;
        double d5;
        Matcher matcher = f47204b.matcher(str);
        if (matcher.matches()) {
            double d6 = (Long.parseLong((String) Assertions.e(matcher.group(1))) * 3600) + (Long.parseLong((String) Assertions.e(matcher.group(2))) * 60) + Long.parseLong((String) Assertions.e(matcher.group(3)));
            String strGroup = matcher.group(4);
            return (long) ((d6 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / frameAndTickRate.f47213a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / ((double) frameAndTickRate.f47214b)) / ((double) frameAndTickRate.f47213a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = f47205c.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        d3 = Double.parseDouble((String) Assertions.e(matcher2.group(1)));
        String str2 = (String) Assertions.e(matcher2.group(2));
        str2.getClass();
        switch (str2) {
            case "f":
                d4 = frameAndTickRate.f47213a;
                d3 /= d4;
                return (long) (d3 * 1000000.0d);
            case "h":
                d5 = 3600.0d;
                break;
            case "m":
                d5 = 60.0d;
                break;
            case "t":
                d4 = frameAndTickRate.f47215c;
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

    private static TtsExtent r(XmlPullParser xmlPullParser) {
        String strA = XmlPullParserUtil.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = f47209g.matcher(strA);
        if (!matcher.matches()) {
            Log.i("TtmlParser", "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.e(matcher.group(1))), Integer.parseInt((String) Assertions.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.i("TtmlParser", "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        LegacySubtitleUtil.c(b(bArr, i3, i4), outputOptions, consumer);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public Subtitle b(byte[] bArr, int i3, int i4) {
        char c3;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f47212a.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion(""));
            TtmlSubtitle ttmlSubtitle = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i3, i4), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            int i5 = 0;
            int iG = 15;
            FrameAndTickRate frameAndTickRateI = f47211i;
            TtsExtent ttsExtentR = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i5 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRateI = i(xmlPullParserNewPullParser);
                            c3 = 15;
                            iG = g(xmlPullParserNewPullParser, 15);
                            ttsExtentR = r(xmlPullParserNewPullParser);
                        } else {
                            c3 = 15;
                        }
                        FrameAndTickRate frameAndTickRate = frameAndTickRateI;
                        TtsExtent ttsExtent = ttsExtentR;
                        int i6 = iG;
                        if (e(name)) {
                            if ("head".equals(name)) {
                                j(xmlPullParserNewPullParser, map, i6, ttsExtent, map2, map3);
                            } else {
                                try {
                                    TtmlNode ttmlNodeL = l(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate);
                                    arrayDeque.push(ttmlNodeL);
                                    if (ttmlNode != null) {
                                        ttmlNode.a(ttmlNodeL);
                                    }
                                } catch (SubtitleDecoderException e3) {
                                    Log.j("TtmlParser", "Suppressing parser error", e3);
                                    i5++;
                                }
                            }
                            iG = i6;
                            ttsExtentR = ttsExtent;
                            frameAndTickRateI = frameAndTickRate;
                        } else {
                            Log.g("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        }
                        i5++;
                        iG = i6;
                        ttsExtentR = ttsExtent;
                        frameAndTickRateI = frameAndTickRate;
                    } else {
                        c3 = 15;
                        if (eventType == 4) {
                            ((TtmlNode) Assertions.e(ttmlNode)).a(TtmlNode.d(xmlPullParserNewPullParser.getText()));
                        } else if (eventType == 3) {
                            if (xmlPullParserNewPullParser.getName().equals("tt")) {
                                ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.e((TtmlNode) arrayDeque.peek()), map, map2, map3);
                            }
                            arrayDeque.pop();
                        }
                    }
                } else if (eventType == 2) {
                    i5++;
                } else if (eventType == 3) {
                    i5--;
                }
                xmlPullParserNewPullParser.next();
            }
            return (Subtitle) Assertions.e(ttmlSubtitle);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        } catch (XmlPullParserException e5) {
            throw new IllegalStateException("Unable to decode source", e5);
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 1;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:90:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.media3.extractor.text.ttml.TtmlRegion m(org.xmlpull.v1.XmlPullParser r17, int r18, androidx.media3.extractor.text.ttml.TtmlParser.TtsExtent r19, java.util.Map r20) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.m(org.xmlpull.v1.XmlPullParser, int, androidx.media3.extractor.text.ttml.TtmlParser$TtsExtent, java.util.Map):androidx.media3.extractor.text.ttml.TtmlRegion");
    }
}
