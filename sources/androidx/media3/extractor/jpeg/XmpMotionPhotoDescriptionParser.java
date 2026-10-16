package androidx.media3.extractor.jpeg;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.jpeg.MotionPhotoDescription;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class XmpMotionPhotoDescriptionParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f46409a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f46410b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f46411c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static MotionPhotoDescription a(String str) {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            Log.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static MotionPhotoDescription b(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!XmlPullParserUtil.e(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw ParserException.a("Couldn't find xmp metadata", null);
        }
        ImmutableList immutableListY = ImmutableList.y();
        long jE = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (XmlPullParserUtil.e(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!d(xmlPullParserNewPullParser)) {
                    return null;
                }
                jE = e(xmlPullParserNewPullParser);
                immutableListY = c(xmlPullParserNewPullParser);
            } else if (XmlPullParserUtil.e(xmlPullParserNewPullParser, "Container:Directory")) {
                immutableListY = f(xmlPullParserNewPullParser, "Container", "Item");
            } else if (XmlPullParserUtil.e(xmlPullParserNewPullParser, "GContainer:Directory")) {
                immutableListY = f(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!XmlPullParserUtil.c(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (immutableListY.isEmpty()) {
            return null;
        }
        return new MotionPhotoDescription(jE, immutableListY);
    }

    private static ImmutableList c(XmlPullParser xmlPullParser) {
        for (String str : f46411c) {
            String strA = XmlPullParserUtil.a(xmlPullParser, str);
            if (strA != null) {
                return ImmutableList.A(new MotionPhotoDescription.ContainerItem("image/jpeg", "Primary", 0L, 0L), new MotionPhotoDescription.ContainerItem("video/mp4", "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return ImmutableList.y();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f46409a) {
            String strA = XmlPullParserUtil.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String str : f46410b) {
            String strA = XmlPullParserUtil.a(xmlPullParser, str);
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

    private static ImmutableList f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        ImmutableList.Builder builderO = ImmutableList.o();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.e(xmlPullParser, str3)) {
                String strA = XmlPullParserUtil.a(xmlPullParser, str2 + ":Mime");
                String strA2 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Length");
                String strA4 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return ImmutableList.y();
                }
                builderO.a(new MotionPhotoDescription.ContainerItem(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!XmlPullParserUtil.c(xmlPullParser, str4));
        return builderO.m();
    }
}
