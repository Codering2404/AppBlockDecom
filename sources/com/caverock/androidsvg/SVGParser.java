package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class SVGParser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f67704d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SVG f67701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SVG.SvgContainer f67702b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f67703c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f67705e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SVGElem f67706f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private StringBuilder f67707g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f67708h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private StringBuilder f67709i = null;

    /* JADX INFO: renamed from: com.caverock.androidsvg.SVGParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f67711b;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            f67711b = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67711b[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67711b[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67711b[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67711b[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67711b[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f67711b[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f67711b[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f67711b[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f67711b[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f67711b[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f67711b[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f67711b[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f67711b[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f67711b[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f67711b[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f67711b[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f67711b[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f67711b[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f67711b[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f67711b[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f67711b[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f67711b[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f67711b[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f67711b[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f67711b[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f67711b[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f67711b[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f67711b[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f67711b[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f67711b[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f67711b[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f67711b[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f67711b[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f67711b[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f67711b[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f67711b[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f67711b[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                f67711b[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f67711b[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f67711b[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f67711b[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f67711b[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f67711b[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f67711b[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f67711b[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f67711b[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f67711b[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f67711b[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f67711b[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f67711b[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f67711b[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f67711b[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                f67711b[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f67711b[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f67711b[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                f67711b[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f67711b[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f67711b[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                f67711b[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                f67711b[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                f67711b[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                f67711b[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                f67711b[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                f67711b[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                f67711b[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                f67711b[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                f67711b[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                f67711b[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                f67711b[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                f67711b[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                f67711b[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                f67711b[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                f67711b[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                f67711b[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                f67711b[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                f67711b[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                f67711b[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                f67711b[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                f67711b[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                f67711b[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                f67711b[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                f67711b[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                f67711b[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                f67711b[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                f67711b[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                f67711b[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                f67711b[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                f67711b[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            f67710a = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                f67710a[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                f67710a[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                f67710a[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                f67710a[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                f67710a[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                f67710a[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                f67710a[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                f67710a[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                f67710a[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                f67710a[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                f67710a[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                f67710a[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                f67710a[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                f67710a[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                f67710a[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                f67710a[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                f67710a[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                f67710a[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                f67710a[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                f67710a[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                f67710a[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                f67710a[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                f67710a[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                f67710a[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                f67710a[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                f67710a[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                f67710a[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                f67710a[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                f67710a[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                f67710a[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AspectRatioKeywords {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map f67712a;

        static {
            HashMap map = new HashMap(10);
            f67712a = map;
            map.put(IntegrityManager.INTEGRITY_TYPE_NONE, PreserveAspectRatio.Alignment.none);
            map.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            map.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            map.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            map.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            map.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            map.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            map.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            map.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            map.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        static PreserveAspectRatio.Alignment a(String str) {
            return (PreserveAspectRatio.Alignment) f67712a.get(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ColourKeywords {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map f67713a;

        static Integer a(String str) {
            return (Integer) f67713a.get(str);
        }

        static {
            HashMap map = new HashMap(47);
            f67713a = map;
            map.put("aliceblue", -984833);
            map.put("antiquewhite", -332841);
            map.put("aqua", -16711681);
            map.put("aquamarine", -8388652);
            map.put("azure", -983041);
            map.put("beige", -657956);
            map.put("bisque", -6972);
            map.put("black", -16777216);
            map.put("blanchedalmond", -5171);
            map.put("blue", -16776961);
            map.put("blueviolet", -7722014);
            map.put("brown", -5952982);
            map.put("burlywood", -2180985);
            map.put("cadetblue", -10510688);
            map.put("chartreuse", -8388864);
            map.put(jTYhJgqLBN.XRxuKccKN, -2987746);
            map.put("coral", -32944);
            map.put("cornflowerblue", -10185235);
            map.put("cornsilk", -1828);
            map.put("crimson", -2354116);
            map.put("cyan", -16711681);
            map.put("darkblue", -16777077);
            map.put("darkcyan", -16741493);
            map.put("darkgoldenrod", -4684277);
            map.put("darkgray", -5658199);
            map.put("darkgreen", -16751616);
            map.put("darkgrey", -5658199);
            map.put("darkkhaki", -4343957);
            map.put("darkmagenta", -7667573);
            map.put("darkolivegreen", -11179217);
            map.put("darkorange", -29696);
            map.put("darkorchid", -6737204);
            map.put("darkred", -7667712);
            map.put("darksalmon", -1468806);
            map.put("darkseagreen", -7357297);
            map.put("darkslateblue", -12042869);
            map.put("darkslategray", -13676721);
            map.put("darkslategrey", -13676721);
            map.put("darkturquoise", -16724271);
            map.put("darkviolet", -7077677);
            map.put("deeppink", -60269);
            map.put("deepskyblue", -16728065);
            map.put("dimgray", -9868951);
            map.put("dimgrey", -9868951);
            map.put("dodgerblue", -14774017);
            map.put("firebrick", -5103070);
            map.put("floralwhite", -1296);
            map.put("forestgreen", -14513374);
            map.put("fuchsia", -65281);
            map.put("gainsboro", -2302756);
            map.put("ghostwhite", -460545);
            map.put("gold", -10496);
            map.put("goldenrod", -2448096);
            map.put("gray", -8355712);
            map.put("green", -16744448);
            map.put("greenyellow", -5374161);
            map.put("grey", -8355712);
            map.put("honeydew", -983056);
            map.put("hotpink", -38476);
            map.put("indianred", -3318692);
            map.put("indigo", -11861886);
            map.put("ivory", -16);
            map.put("khaki", -989556);
            map.put("lavender", -1644806);
            map.put("lavenderblush", -3851);
            map.put("lawngreen", -8586240);
            map.put("lemonchiffon", -1331);
            map.put("lightblue", -5383962);
            map.put("lightcoral", -1015680);
            map.put("lightcyan", -2031617);
            map.put("lightgoldenrodyellow", -329006);
            map.put("lightgray", -2894893);
            map.put("lightgreen", -7278960);
            map.put("lightgrey", -2894893);
            map.put("lightpink", -18751);
            map.put("lightsalmon", -24454);
            map.put("lightseagreen", -14634326);
            map.put("lightskyblue", -7876870);
            map.put("lightslategray", -8943463);
            map.put("lightslategrey", -8943463);
            map.put("lightsteelblue", -5192482);
            map.put("lightyellow", -32);
            map.put("lime", -16711936);
            map.put("limegreen", -13447886);
            map.put("linen", -331546);
            map.put("magenta", -65281);
            map.put("maroon", -8388608);
            map.put("mediumaquamarine", -10039894);
            map.put("mediumblue", -16777011);
            map.put("mediumorchid", -4565549);
            map.put("mediumpurple", -7114533);
            map.put("mediumseagreen", -12799119);
            map.put("mediumslateblue", -8689426);
            map.put("mediumspringgreen", -16713062);
            map.put("mediumturquoise", -12004916);
            map.put("mediumvioletred", -3730043);
            map.put("midnightblue", -15132304);
            map.put("mintcream", -655366);
            map.put("mistyrose", -6943);
            map.put("moccasin", -6987);
            map.put("navajowhite", -8531);
            map.put("navy", -16777088);
            map.put("oldlace", -133658);
            map.put("olive", -8355840);
            map.put("olivedrab", -9728477);
            map.put("orange", -23296);
            map.put("orangered", -47872);
            map.put("orchid", -2461482);
            map.put("palegoldenrod", -1120086);
            map.put("palegreen", -6751336);
            map.put("paleturquoise", -5247250);
            map.put("palevioletred", -2396013);
            map.put("papayawhip", -4139);
            map.put("peachpuff", -9543);
            map.put("peru", -3308225);
            map.put("pink", -16181);
            map.put("plum", -2252579);
            map.put("powderblue", -5185306);
            map.put("purple", -8388480);
            map.put("rebeccapurple", -10079335);
            map.put("red", -65536);
            map.put("rosybrown", -4419697);
            map.put("royalblue", -12490271);
            map.put("saddlebrown", -7650029);
            map.put("salmon", -360334);
            map.put("sandybrown", -744352);
            map.put("seagreen", -13726889);
            map.put("seashell", -2578);
            map.put("sienna", -6270419);
            map.put("silver", -4144960);
            map.put("skyblue", -7876885);
            map.put("slateblue", -9807155);
            map.put("slategray", -9404272);
            map.put("slategrey", -9404272);
            map.put("snow", -1286);
            map.put("springgreen", -16711809);
            map.put("steelblue", -12156236);
            map.put("tan", -2968436);
            map.put("teal", -16744320);
            map.put("thistle", -2572328);
            map.put("tomato", -40121);
            map.put("turquoise", -12525360);
            map.put("violet", -1146130);
            map.put("wheat", -663885);
            map.put("white", -1);
            map.put("whitesmoke", -657931);
            map.put("yellow", -256);
            map.put(QgXempTBEfV.DMMW, -6632142);
            map.put("transparent", 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FontSizeKeywords {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map f67714a;

        static {
            HashMap map = new HashMap(9);
            f67714a = map;
            SVG.Unit unit = SVG.Unit.pt;
            map.put("xx-small", new SVG.Length(0.694f, unit));
            map.put("x-small", new SVG.Length(0.833f, unit));
            map.put("small", new SVG.Length(10.0f, unit));
            map.put("medium", new SVG.Length(12.0f, unit));
            map.put("large", new SVG.Length(14.4f, unit));
            map.put("x-large", new SVG.Length(17.3f, unit));
            map.put("xx-large", new SVG.Length(20.7f, unit));
            SVG.Unit unit2 = SVG.Unit.percent;
            map.put("smaller", new SVG.Length(83.33f, unit2));
            map.put("larger", new SVG.Length(120.0f, unit2));
        }

        static SVG.Length a(String str) {
            return (SVG.Length) f67714a.get(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FontWeightKeywords {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map f67715a;

        static {
            HashMap map = new HashMap(13);
            f67715a = map;
            Integer numValueOf = Integer.valueOf(RCHTTPStatusCodes.BAD_REQUEST);
            map.put("normal", numValueOf);
            Integer numValueOf2 = Integer.valueOf(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD);
            map.put("bold", numValueOf2);
            map.put("bolder", 1);
            map.put("lighter", -1);
            map.put("100", 100);
            map.put("200", 200);
            map.put("300", 300);
            map.put("400", numValueOf);
            map.put("500", 500);
            map.put("600", 600);
            map.put("700", numValueOf2);
            map.put("800", 800);
            map.put("900", 900);
        }

        static Integer a(String str) {
            return (Integer) f67715a.get(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i4) {
            SVGParser.this.c1(new String(cArr, i3, i4));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            SVGParser.this.o();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            SVGParser.this.p(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            SVGParser.this.r(str, SVGParser.this.x0(new TextScanner(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            SVGParser.this.W0();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
            SVGParser.this.X0(str, str2, str3, attributes);
        }

        /* synthetic */ SAXHandler(SVGParser sVGParser, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        private static final Map P0 = new HashMap();

        static {
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    P0.put("class", sVGAttr);
                } else if (sVGAttr != UNSUPPORTED) {
                    P0.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                }
            }
        }

        public static SVGAttr a(String str) {
            SVGAttr sVGAttr = (SVGAttr) P0.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        private static final Map H = new HashMap();

        static {
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    H.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    H.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem a(String str) {
            SVGElem sVGElem = (SVGElem) H.get(str);
            return sVGElem != null ? sVGElem : UNSUPPORTED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TextScanner {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f67793a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f67795c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f67794b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private NumberParser f67796d = new NumberParser();

        TextScanner(String str) {
            this.f67795c = 0;
            String strTrim = str.trim();
            this.f67793a = strTrim;
            this.f67795c = strTrim.length();
        }

        void A() {
            while (true) {
                int i3 = this.f67794b;
                if (i3 >= this.f67795c || !k(this.f67793a.charAt(i3))) {
                    return;
                } else {
                    this.f67794b++;
                }
            }
        }

        int a() {
            int i3 = this.f67794b;
            int i4 = this.f67795c;
            if (i3 == i4) {
                return -1;
            }
            int i5 = i3 + 1;
            this.f67794b = i5;
            if (i5 < i4) {
                return this.f67793a.charAt(i5);
            }
            return -1;
        }

        String b() {
            int i3 = this.f67794b;
            while (!h() && !k(this.f67793a.charAt(this.f67794b))) {
                this.f67794b++;
            }
            String strSubstring = this.f67793a.substring(i3, this.f67794b);
            this.f67794b = i3;
            return strSubstring;
        }

        Boolean c(Object obj) {
            if (obj == null) {
                return null;
            }
            z();
            return m();
        }

        float d(float f3) {
            if (Float.isNaN(f3)) {
                return Float.NaN;
            }
            z();
            return n();
        }

        float e(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            z();
            return n();
        }

        boolean f(char c3) {
            int i3 = this.f67794b;
            boolean z2 = i3 < this.f67795c && this.f67793a.charAt(i3) == c3;
            if (z2) {
                this.f67794b++;
            }
            return z2;
        }

        boolean g(String str) {
            int length = str.length();
            int i3 = this.f67794b;
            boolean z2 = i3 <= this.f67795c - length && this.f67793a.substring(i3, i3 + length).equals(str);
            if (z2) {
                this.f67794b += length;
            }
            return z2;
        }

        boolean h() {
            return this.f67794b == this.f67795c;
        }

        boolean i() {
            int i3 = this.f67794b;
            if (i3 == this.f67795c) {
                return false;
            }
            char cCharAt = this.f67793a.charAt(i3);
            if (cCharAt < 'a' || cCharAt > 'z') {
                return cCharAt >= 'A' && cCharAt <= 'Z';
            }
            return true;
        }

        boolean j(int i3) {
            return i3 == 10 || i3 == 13;
        }

        boolean k(int i3) {
            return i3 == 32 || i3 == 10 || i3 == 13 || i3 == 9;
        }

        Integer l() {
            int i3 = this.f67794b;
            if (i3 == this.f67795c) {
                return null;
            }
            String str = this.f67793a;
            this.f67794b = i3 + 1;
            return Integer.valueOf(str.charAt(i3));
        }

        Boolean m() {
            int i3 = this.f67794b;
            if (i3 == this.f67795c) {
                return null;
            }
            char cCharAt = this.f67793a.charAt(i3);
            if (cCharAt != '0' && cCharAt != '1') {
                return null;
            }
            this.f67794b++;
            return Boolean.valueOf(cCharAt == '1');
        }

        float n() {
            float fB = this.f67796d.b(this.f67793a, this.f67794b, this.f67795c);
            if (!Float.isNaN(fB)) {
                this.f67794b = this.f67796d.a();
            }
            return fB;
        }

        String o() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            int iCharAt = this.f67793a.charAt(i3);
            while (true) {
                if ((iCharAt < 97 || iCharAt > 122) && (iCharAt < 65 || iCharAt > 90)) {
                    break;
                }
                iCharAt = a();
            }
            int i4 = this.f67794b;
            while (k(iCharAt)) {
                iCharAt = a();
            }
            if (iCharAt == 40) {
                this.f67794b++;
                return this.f67793a.substring(i3, i4);
            }
            this.f67794b = i3;
            return null;
        }

        SVG.Length p() {
            float fN = n();
            if (Float.isNaN(fN)) {
                return null;
            }
            SVG.Unit unitV = v();
            return unitV == null ? new SVG.Length(fN, SVG.Unit.px) : new SVG.Length(fN, unitV);
        }

        String q() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            char cCharAt = this.f67793a.charAt(i3);
            if (cCharAt != '\'' && cCharAt != '\"') {
                return null;
            }
            int iA = a();
            while (iA != -1 && iA != cCharAt) {
                iA = a();
            }
            if (iA == -1) {
                this.f67794b = i3;
                return null;
            }
            int i4 = this.f67794b;
            this.f67794b = i4 + 1;
            return this.f67793a.substring(i3 + 1, i4);
        }

        String r() {
            return t(' ', false);
        }

        String s(char c3) {
            return t(c3, false);
        }

        String t(char c3, boolean z2) {
            if (h()) {
                return null;
            }
            char cCharAt = this.f67793a.charAt(this.f67794b);
            if ((!z2 && k(cCharAt)) || cCharAt == c3) {
                return null;
            }
            int i3 = this.f67794b;
            int iA = a();
            while (iA != -1 && iA != c3 && (z2 || !k(iA))) {
                iA = a();
            }
            return this.f67793a.substring(i3, this.f67794b);
        }

        String u(char c3) {
            return t(c3, true);
        }

        SVG.Unit v() {
            if (h()) {
                return null;
            }
            if (this.f67793a.charAt(this.f67794b) == '%') {
                this.f67794b++;
                return SVG.Unit.percent;
            }
            int i3 = this.f67794b;
            if (i3 > this.f67795c - 2) {
                return null;
            }
            try {
                SVG.Unit unitValueOf = SVG.Unit.valueOf(this.f67793a.substring(i3, i3 + 2).toLowerCase(Locale.US));
                this.f67794b += 2;
                return unitValueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        String w() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            char cCharAt = this.f67793a.charAt(i3);
            if ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z')) {
                this.f67794b = i3;
                return null;
            }
            int iA = a();
            while (true) {
                if ((iA < 65 || iA > 90) && (iA < 97 || iA > 122)) {
                    break;
                }
                iA = a();
            }
            return this.f67793a.substring(i3, this.f67794b);
        }

        float x() {
            z();
            float fB = this.f67796d.b(this.f67793a, this.f67794b, this.f67795c);
            if (!Float.isNaN(fB)) {
                this.f67794b = this.f67796d.a();
            }
            return fB;
        }

        String y() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            this.f67794b = this.f67795c;
            return this.f67793a.substring(i3);
        }

        boolean z() {
            A();
            int i3 = this.f67794b;
            if (i3 == this.f67795c || this.f67793a.charAt(i3) != ',') {
                return false;
            }
            this.f67794b++;
            A();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class XPPAttributesWrapper implements Attributes {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private XmlPullParser f67797a;

        public XPPAttributesWrapper(XmlPullParser xmlPullParser) {
            this.f67797a = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.f67797a.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i3) {
            return this.f67797a.getAttributeName(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i3) {
            String attributeName = this.f67797a.getAttributeName(i3);
            if (this.f67797a.getAttributePrefix(i3) == null) {
                return attributeName;
            }
            return this.f67797a.getAttributePrefix(i3) + ':' + attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i3) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i3) {
            return this.f67797a.getAttributeNamespace(i3);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i3) {
            return this.f67797a.getAttributeValue(i3);
        }
    }

    SVGParser() {
    }

    private void A(SVG.Circle circle, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            switch (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()]) {
                case 12:
                    circle.f67444o = o0(strTrim);
                    break;
                case 13:
                    circle.f67445p = o0(strTrim);
                    break;
                case 14:
                    SVG.Length lengthO0 = o0(strTrim);
                    circle.f67446q = lengthO0;
                    if (lengthO0.i()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
                    break;
            }
        }
    }

    private static Set A0(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.h()) {
            hashSet.add(textScanner.r());
            textScanner.A();
        }
        return hashSet;
    }

    private void B(SVG.ClipPath clipPath, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            if (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(strTrim)) {
                    clipPath.f67447p = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(strTrim)) {
                        throw new SVGParseException("Invalid value for attribute clipPathUnits");
                    }
                    clipPath.f67447p = Boolean.TRUE;
                }
            }
        }
    }

    private static SVG.Length[] B0(String str) {
        SVG.Length lengthP;
        TextScanner textScanner = new TextScanner(str);
        textScanner.A();
        if (textScanner.h() || (lengthP = textScanner.p()) == null || lengthP.i()) {
            return null;
        }
        float fA = lengthP.a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(lengthP);
        while (!textScanner.h()) {
            textScanner.z();
            SVG.Length lengthP2 = textScanner.p();
            if (lengthP2 == null || lengthP2.i()) {
                return null;
            }
            arrayList.add(lengthP2);
            fA += lengthP2.a();
        }
        if (fA == 0.0f) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private void C(SVG.SvgConditional svgConditional, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            switch (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()]) {
                case 21:
                    svgConditional.e(z0(strTrim));
                    break;
                case 22:
                    svgConditional.j(strTrim);
                    break;
                case 23:
                    svgConditional.g(F0(strTrim));
                    break;
                case 24:
                    svgConditional.i(A0(strTrim));
                    break;
                case 25:
                    List listI0 = i0(strTrim);
                    svgConditional.c(listI0 != null ? new HashSet(listI0) : new HashSet(0));
                    break;
            }
        }
    }

    private static SVG.Style.LineCap C0(String str) {
        if ("butt".equals(str)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private void D(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String qName = attributes.getQName(i3);
            if (qName.equals("id") || qName.equals("xml:id")) {
                svgElementBase.f67592c = attributes.getValue(i3).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String strTrim = attributes.getValue(i3).trim();
                if ("default".equals(strTrim)) {
                    svgElementBase.f67593d = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(strTrim)) {
                        svgElementBase.f67593d = Boolean.TRUE;
                        return;
                    }
                    throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + strTrim);
                }
            }
        }
    }

    private static SVG.Style.LineJoin D0(String str) {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private void E(SVG.Ellipse ellipse, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            switch (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()]) {
                case 10:
                    SVG.Length lengthO0 = o0(strTrim);
                    ellipse.f67454q = lengthO0;
                    if (lengthO0.i()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                    break;
                case 11:
                    SVG.Length lengthO02 = o0(strTrim);
                    ellipse.f67455r = lengthO02;
                    if (lengthO02.i()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                    break;
                case 12:
                    ellipse.f67452o = o0(strTrim);
                    break;
                case 13:
                    ellipse.f67453p = o0(strTrim);
                    break;
            }
        }
    }

    private static void E0(SVG.SvgElementBase svgElementBase, String str) {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String strS = textScanner.s(':');
            textScanner.A();
            if (!textScanner.f(':')) {
                return;
            }
            textScanner.A();
            String strU = textScanner.u(';');
            if (strU == null) {
                return;
            }
            textScanner.A();
            if (textScanner.h() || textScanner.f(';')) {
                if (svgElementBase.f67595f == null) {
                    svgElementBase.f67595f = new SVG.Style();
                }
                S0(svgElementBase.f67595f, strS, strU);
                textScanner.A();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F(com.caverock.androidsvg.SVG.GradientElement r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L90
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.AnonymousClass1.f67711b
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.a(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 6
            if (r2 == r3) goto L72
            switch(r2) {
                case 32: goto L50;
                case 33: goto L49;
                case 34: goto L26;
                default: goto L25;
            }
        L25:
            goto L8c
        L26:
            com.caverock.androidsvg.SVG$GradientSpread r2 = com.caverock.androidsvg.SVG.GradientSpread.valueOf(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            r5.f67459k = r2     // Catch: java.lang.IllegalArgumentException -> L2d
            goto L8c
        L2d:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Invalid spreadMethod attribute. \""
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "\" is not a valid value."
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L49:
            android.graphics.Matrix r1 = r4.J0(r1)
            r5.f67458j = r1
            goto L8c
        L50:
            java.lang.String r2 = "objectBoundingBox"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L5d
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r5.f67457i = r1
            goto L8c
        L5d:
            java.lang.String r2 = "userSpaceOnUse"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L6a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r5.f67457i = r1
            goto L8c
        L6a:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid value for attribute gradientUnits"
            r5.<init>(r6)
            throw r5
        L72:
            java.lang.String r2 = ""
            java.lang.String r3 = r6.getURI(r0)
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L8a
            java.lang.String r2 = "http://www.w3.org/1999/xlink"
            java.lang.String r3 = r6.getURI(r0)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L8c
        L8a:
            r5.f67460l = r1
        L8c:
            int r0 = r0 + 1
            goto L1
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.F(com.caverock.androidsvg.SVG$GradientElement, org.xml.sax.Attributes):void");
    }

    private static Set F0(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.h()) {
            String strR = textScanner.r();
            int iIndexOf = strR.indexOf(45);
            if (iIndexOf != -1) {
                strR = strR.substring(0, iIndexOf);
            }
            hashSet.add(new Locale(strR, "", "").getLanguage());
            textScanner.A();
        }
        return hashSet;
    }

    private void G(SVG.Image image, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                image.f67468q = o0(strTrim);
            } else if (i4 == 2) {
                image.f67469r = o0(strTrim);
            } else if (i4 == 3) {
                SVG.Length lengthO0 = o0(strTrim);
                image.f67470s = lengthO0;
                if (lengthO0.i()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                SVG.Length lengthO02 = o0(strTrim);
                image.f67471t = lengthO02;
                if (lengthO02.i()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i4 != 6) {
                if (i4 == 7) {
                    w0(image, strTrim);
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                image.f67467p = strTrim;
            }
        }
    }

    private static SVG.Style.TextAnchor G0(String str) {
        str.getClass();
        switch (str) {
            case "middle":
                return SVG.Style.TextAnchor.Middle;
            case "end":
                return SVG.Style.TextAnchor.End;
            case "start":
                return SVG.Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    private void H(SVG.Line line, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            switch (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()]) {
                case 15:
                    line.f67475o = o0(strTrim);
                    break;
                case 16:
                    line.f67476p = o0(strTrim);
                    break;
                case 17:
                    line.f67477q = o0(strTrim);
                    break;
                case 18:
                    line.f67478r = o0(strTrim);
                    break;
            }
        }
    }

    private static SVG.Style.TextDecoration H0(String str) {
        str.getClass();
        switch (str) {
            case "line-through":
                return SVG.Style.TextDecoration.LineThrough;
            case "underline":
                return SVG.Style.TextDecoration.Underline;
            case "none":
                return SVG.Style.TextDecoration.None;
            case "blink":
                return SVG.Style.TextDecoration.Blink;
            case "overline":
                return SVG.Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    private void I(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            switch (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()]) {
                case 15:
                    svgLinearGradient.f67597m = o0(strTrim);
                    break;
                case 16:
                    svgLinearGradient.f67598n = o0(strTrim);
                    break;
                case 17:
                    svgLinearGradient.f67599o = o0(strTrim);
                    break;
                case 18:
                    svgLinearGradient.f67600p = o0(strTrim);
                    break;
            }
        }
    }

    private static SVG.Style.TextDirection I0(String str) {
        str.getClass();
        if (str.equals("ltr")) {
            return SVG.Style.TextDirection.LTR;
        }
        if (str.equals("rtl")) {
            return SVG.Style.TextDirection.RTL;
        }
        return null;
    }

    private void J(SVG.Marker marker, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            switch (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()]) {
                case 26:
                    marker.f67480r = o0(strTrim);
                    break;
                case 27:
                    marker.f67481s = o0(strTrim);
                    break;
                case 28:
                    SVG.Length lengthO0 = o0(strTrim);
                    marker.f67482t = lengthO0;
                    if (lengthO0.i()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                    break;
                case 29:
                    SVG.Length lengthO02 = o0(strTrim);
                    marker.f67483u = lengthO02;
                    if (lengthO02.i()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                    break;
                case 30:
                    if (!"strokeWidth".equals(strTrim)) {
                        if (!"userSpaceOnUse".equals(strTrim)) {
                            throw new SVGParseException("Invalid value for attribute markerUnits");
                        }
                        marker.f67479q = true;
                    } else {
                        marker.f67479q = false;
                    }
                    break;
                case 31:
                    if ("auto".equals(strTrim)) {
                        marker.f67484v = Float.valueOf(Float.NaN);
                    } else {
                        marker.f67484v = Float.valueOf(f0(strTrim));
                    }
                    break;
            }
        }
    }

    private Matrix J0(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.A();
        while (!textScanner.h()) {
            String strO = textScanner.o();
            if (strO == null) {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
            switch (strO) {
                case "matrix":
                    textScanner.A();
                    float fN = textScanner.n();
                    textScanner.z();
                    float fN2 = textScanner.n();
                    textScanner.z();
                    float fN3 = textScanner.n();
                    textScanner.z();
                    float fN4 = textScanner.n();
                    textScanner.z();
                    float fN5 = textScanner.n();
                    textScanner.z();
                    float fN6 = textScanner.n();
                    textScanner.A();
                    if (Float.isNaN(fN6) || !textScanner.f(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{fN, fN3, fN5, fN2, fN4, fN6, 0.0f, 0.0f, 1.0f});
                    matrix.preConcat(matrix2);
                    break;
                    break;
                case "rotate":
                    textScanner.A();
                    float fN7 = textScanner.n();
                    float fX = textScanner.x();
                    float fX2 = textScanner.x();
                    textScanner.A();
                    if (Float.isNaN(fN7) || !textScanner.f(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fX)) {
                        matrix.preRotate(fN7);
                    } else {
                        if (Float.isNaN(fX2)) {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        matrix.preRotate(fN7, fX, fX2);
                    }
                    break;
                    break;
                case "scale":
                    textScanner.A();
                    float fN8 = textScanner.n();
                    float fX3 = textScanner.x();
                    textScanner.A();
                    if (Float.isNaN(fN8) || !textScanner.f(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (!Float.isNaN(fX3)) {
                        matrix.preScale(fN8, fX3);
                    } else {
                        matrix.preScale(fN8, fN8);
                    }
                    break;
                    break;
                case "skewX":
                    textScanner.A();
                    float fN9 = textScanner.n();
                    textScanner.A();
                    if (Float.isNaN(fN9) || !textScanner.f(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians(fN9)), 0.0f);
                    break;
                    break;
                case "skewY":
                    textScanner.A();
                    float fN10 = textScanner.n();
                    textScanner.A();
                    if (Float.isNaN(fN10) || !textScanner.f(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians(fN10)));
                    break;
                    break;
                case "translate":
                    textScanner.A();
                    float fN11 = textScanner.n();
                    float fX4 = textScanner.x();
                    textScanner.A();
                    if (Float.isNaN(fN11) || !textScanner.f(')')) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (!Float.isNaN(fX4)) {
                        matrix.preTranslate(fN11, fX4);
                    } else {
                        matrix.preTranslate(fN11, 0.0f);
                    }
                    break;
                    break;
                default:
                    throw new SVGParseException("Invalid transform list fn: " + strO + ")");
            }
            if (textScanner.h()) {
                return matrix;
            }
            textScanner.z();
        }
        return matrix;
    }

    private void K(SVG.Mask mask, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                mask.f67487q = o0(strTrim);
            } else if (i4 == 2) {
                mask.f67488r = o0(strTrim);
            } else if (i4 == 3) {
                SVG.Length lengthO0 = o0(strTrim);
                mask.f67489s = lengthO0;
                if (lengthO0.i()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                SVG.Length lengthO02 = o0(strTrim);
                mask.f67490t = lengthO02;
                if (lengthO02.i()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i4 != 43) {
                if (i4 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(strTrim)) {
                    mask.f67486p = Boolean.FALSE;
                } else {
                    if (!"userSpaceOnUse".equals(strTrim)) {
                        throw new SVGParseException("Invalid value for attribute maskContentUnits");
                    }
                    mask.f67486p = Boolean.TRUE;
                }
            } else if ("objectBoundingBox".equals(strTrim)) {
                mask.f67485o = Boolean.FALSE;
            } else {
                if (!"userSpaceOnUse".equals(strTrim)) {
                    throw new SVGParseException("Invalid value for attribute maskUnits");
                }
                mask.f67485o = Boolean.TRUE;
            }
        }
    }

    private void K0(InputStream inputStream) throws SVGParseException {
        Log.d("SVGParser", "Falling back to SAX parser");
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler(this, null);
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e3) {
            throw new SVGParseException("Stream error", e3);
        } catch (ParserConfigurationException e4) {
            throw new SVGParseException("XML parser problem", e4);
        } catch (SAXException e5) {
            throw new SVGParseException("SVG parse error", e5);
        }
    }

    private void L(SVG.Path path, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 8) {
                path.f67493o = u0(strTrim);
            } else if (i4 != 9) {
                continue;
            } else {
                Float fValueOf = Float.valueOf(f0(strTrim));
                path.f67494p = fValueOf;
                if (fValueOf.floatValue() < 0.0f) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void L0(InputStream inputStream, boolean z2) throws SVGParseException {
        try {
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                XPPAttributesWrapper xPPAttributesWrapper = new XPPAttributesWrapper(xmlPullParserNewPullParser);
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                xmlPullParserNewPullParser.setInput(inputStream, null);
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.nextToken()) {
                    if (eventType == 0) {
                        W0();
                    } else if (eventType == 8) {
                        Log.d("SVGParser", "PROC INSTR: " + xmlPullParserNewPullParser.getText());
                        TextScanner textScanner = new TextScanner(xmlPullParserNewPullParser.getText());
                        r(textScanner.r(), x0(textScanner));
                    } else if (eventType == 10) {
                        if (z2 && this.f67701a.p() == null && xmlPullParserNewPullParser.getText().contains("<!ENTITY ")) {
                            try {
                                Log.d("SVGParser", "Switching to SAX parser to process entities");
                                inputStream.reset();
                                K0(inputStream);
                                return;
                            } catch (IOException unused) {
                                Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                                return;
                            }
                        }
                    } else if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.getPrefix() != null) {
                            name = xmlPullParserNewPullParser.getPrefix() + ':' + name;
                        }
                        X0(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name, xPPAttributesWrapper);
                    } else if (eventType == 3) {
                        String name2 = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.getPrefix() != null) {
                            name2 = xmlPullParserNewPullParser.getPrefix() + ':' + name2;
                        }
                        p(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name2);
                    } else if (eventType == 4) {
                        int[] iArr = new int[2];
                        e1(xmlPullParserNewPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                    } else if (eventType == 5) {
                        c1(xmlPullParserNewPullParser.getText());
                    }
                }
                o();
            } catch (IOException e3) {
                throw new SVGParseException("Stream error", e3);
            }
        } catch (XmlPullParserException e4) {
            throw new SVGParseException("XML parser problem", e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cf, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void M(com.caverock.androidsvg.SVG.Pattern r6, org.xml.sax.Attributes r7) throws com.caverock.androidsvg.SVGParseException {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.M(com.caverock.androidsvg.SVG$Pattern, org.xml.sax.Attributes):void");
    }

    private static SVG.Style.VectorEffect M0(String str) {
        str.getClass();
        if (str.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
            return SVG.Style.VectorEffect.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        return null;
    }

    private void N(SVG.PolyLine polyLine, Attributes attributes, String str) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (SVGAttr.a(attributes.getLocalName(i3)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i3));
                ArrayList arrayList = new ArrayList();
                textScanner.A();
                while (!textScanner.h()) {
                    float fN = textScanner.n();
                    if (Float.isNaN(fN)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    textScanner.z();
                    float fN2 = textScanner.n();
                    if (Float.isNaN(fN2)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    textScanner.z();
                    arrayList.add(Float.valueOf(fN));
                    arrayList.add(Float.valueOf(fN2));
                }
                polyLine.f67507o = new float[arrayList.size()];
                int size = arrayList.size();
                int i4 = 0;
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    polyLine.f67507o[i4] = ((Float) obj).floatValue();
                    i4++;
                }
            }
        }
    }

    private static SVG.Box N0(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.A();
        float fN = textScanner.n();
        textScanner.z();
        float fN2 = textScanner.n();
        textScanner.z();
        float fN3 = textScanner.n();
        textScanner.z();
        float fN4 = textScanner.n();
        if (Float.isNaN(fN) || Float.isNaN(fN2) || Float.isNaN(fN3) || Float.isNaN(fN4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (fN3 < 0.0f) {
            throw new SVGParseException("Invalid viewBox. width cannot be negative");
        }
        if (fN4 >= 0.0f) {
            return new SVG.Box(fN, fN2, fN3, fN4);
        }
        throw new SVGParseException("Invalid viewBox. height cannot be negative");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void O(com.caverock.androidsvg.SVG.SvgRadialGradient r5, org.xml.sax.Attributes r6) throws com.caverock.androidsvg.SVGParseException {
        /*
            r4 = this;
            r0 = 0
        L1:
            int r1 = r6.getLength()
            if (r0 >= r1) goto L5e
            java.lang.String r1 = r6.getValue(r0)
            java.lang.String r1 = r1.trim()
            int[] r2 = com.caverock.androidsvg.SVGParser.AnonymousClass1.f67711b
            java.lang.String r3 = r6.getLocalName(r0)
            com.caverock.androidsvg.SVGParser$SVGAttr r3 = com.caverock.androidsvg.SVGParser.SVGAttr.a(r3)
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 35
            if (r2 == r3) goto L55
            r3 = 36
            if (r2 == r3) goto L4e
            switch(r2) {
                case 12: goto L47;
                case 13: goto L40;
                case 14: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L5b
        L2b:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.f67606o = r1
            boolean r1 = r1.i()
            if (r1 != 0) goto L38
            goto L5b
        L38:
            com.caverock.androidsvg.SVGParseException r5 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r6 = "Invalid <radialGradient> element. r cannot be negative"
            r5.<init>(r6)
            throw r5
        L40:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.f67605n = r1
            goto L5b
        L47:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.f67604m = r1
            goto L5b
        L4e:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.f67608q = r1
            goto L5b
        L55:
            com.caverock.androidsvg.SVG$Length r1 = o0(r1)
            r5.f67607p = r1
        L5b:
            int r0 = r0 + 1
            goto L1
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.O(com.caverock.androidsvg.SVG$SvgRadialGradient, org.xml.sax.Attributes):void");
    }

    private void O0(Attributes attributes) throws SVGParseException {
        l("<path>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException(KqqtdetwHMIO.QVDSGWHUZzRjB);
        }
        SVG.Path path = new SVG.Path();
        path.f67601a = this.f67701a;
        path.f67602b = this.f67702b;
        D(path, attributes);
        S(path, attributes);
        W(path, attributes);
        C(path, attributes);
        L(path, attributes);
        this.f67702b.h(path);
    }

    private void P(SVG.Rect rect, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                rect.f67508o = o0(strTrim);
            } else if (i4 == 2) {
                rect.f67509p = o0(strTrim);
            } else if (i4 == 3) {
                SVG.Length lengthO0 = o0(strTrim);
                rect.f67510q = lengthO0;
                if (lengthO0.i()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                SVG.Length lengthO02 = o0(strTrim);
                rect.f67511r = lengthO02;
                if (lengthO02.i()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i4 == 10) {
                SVG.Length lengthO03 = o0(strTrim);
                rect.f67512s = lengthO03;
                if (lengthO03.i()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i4 != 11) {
                continue;
            } else {
                SVG.Length lengthO04 = o0(strTrim);
                rect.f67513t = lengthO04;
                if (lengthO04.i()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void P0(Attributes attributes) throws SVGParseException {
        l("<pattern>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Pattern pattern = new SVG.Pattern();
        pattern.f67601a = this.f67701a;
        pattern.f67602b = this.f67702b;
        D(pattern, attributes);
        S(pattern, attributes);
        C(pattern, attributes);
        Y(pattern, attributes);
        M(pattern, attributes);
        this.f67702b.h(pattern);
        this.f67702b = pattern;
    }

    private void Q(SVG.Svg svg, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                svg.f67575q = o0(strTrim);
            } else if (i4 == 2) {
                svg.f67576r = o0(strTrim);
            } else if (i4 == 3) {
                SVG.Length lengthO0 = o0(strTrim);
                svg.f67577s = lengthO0;
                if (lengthO0.i()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                SVG.Length lengthO02 = o0(strTrim);
                svg.f67578t = lengthO02;
                if (lengthO02.i()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i4 == 5) {
                svg.f67579u = strTrim;
            }
        }
    }

    private void Q0(Attributes attributes) throws SVGParseException {
        l("<polygon>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polygon = new SVG.Polygon();
        polygon.f67601a = this.f67701a;
        polygon.f67602b = this.f67702b;
        D(polygon, attributes);
        S(polygon, attributes);
        W(polygon, attributes);
        C(polygon, attributes);
        N(polygon, attributes, "polygon");
        this.f67702b.h(polygon);
    }

    private void R(SVG.Stop stop, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            if (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()] == 37) {
                stop.f67514h = n0(strTrim);
            }
        }
    }

    private void R0(Attributes attributes) throws SVGParseException {
        l("<polyline>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polyLine = new SVG.PolyLine();
        polyLine.f67601a = this.f67701a;
        polyLine.f67602b = this.f67702b;
        D(polyLine, attributes);
        S(polyLine, attributes);
        W(polyLine, attributes);
        C(polyLine, attributes);
        N(polyLine, attributes, "polyline");
        this.f67702b.h(polyLine);
    }

    private void S(SVG.SvgElementBase svgElementBase, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            if (strTrim.length() != 0) {
                int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
                if (i4 == 45) {
                    E0(svgElementBase, strTrim);
                } else if (i4 != 46) {
                    if (svgElementBase.f67594e == null) {
                        svgElementBase.f67594e = new SVG.Style();
                    }
                    S0(svgElementBase.f67594e, attributes.getLocalName(i3), attributes.getValue(i3).trim());
                } else {
                    svgElementBase.f67596g = CSSParser.f(strTrim);
                }
            }
        }
    }

    static void S0(SVG.Style style, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (AnonymousClass1.f67711b[SVGAttr.a(str).ordinal()]) {
                case 47:
                    SVG.SvgPaint svgPaintT0 = t0(str2);
                    style.f67516b = svgPaintT0;
                    if (svgPaintT0 != null) {
                        style.f67515a |= 1;
                    }
                    break;
                case 48:
                    SVG.Style.FillRule fillRuleE0 = e0(str2);
                    style.f67517c = fillRuleE0;
                    if (fillRuleE0 != null) {
                        style.f67515a |= 2;
                    }
                    break;
                case 49:
                    Float fR0 = r0(str2);
                    style.f67518d = fR0;
                    if (fR0 != null) {
                        style.f67515a |= 4;
                    }
                    break;
                case 50:
                    SVG.SvgPaint svgPaintT02 = t0(str2);
                    style.f67519f = svgPaintT02;
                    if (svgPaintT02 != null) {
                        style.f67515a |= 8;
                    }
                    break;
                case 51:
                    Float fR02 = r0(str2);
                    style.f67520g = fR02;
                    if (fR02 != null) {
                        style.f67515a |= 16;
                    }
                    break;
                case 52:
                    style.f67521h = o0(str2);
                    style.f67515a |= 32;
                    break;
                case 53:
                    SVG.Style.LineCap lineCapC0 = C0(str2);
                    style.f67522i = lineCapC0;
                    if (lineCapC0 != null) {
                        style.f67515a |= 64;
                    }
                    break;
                case 54:
                    SVG.Style.LineJoin lineJoinD0 = D0(str2);
                    style.f67523j = lineJoinD0;
                    if (lineJoinD0 != null) {
                        style.f67515a |= 128;
                    }
                    break;
                case 55:
                    style.f67524k = Float.valueOf(f0(str2));
                    style.f67515a |= 256;
                    break;
                case 56:
                    if (!IntegrityManager.INTEGRITY_TYPE_NONE.equals(str2)) {
                        SVG.Length[] lengthArrB0 = B0(str2);
                        style.f67525l = lengthArrB0;
                        if (lengthArrB0 != null) {
                            style.f67515a |= 512;
                        }
                    } else {
                        style.f67525l = null;
                        style.f67515a |= 512;
                    }
                    break;
                case 57:
                    style.f67526m = o0(str2);
                    style.f67515a |= 1024;
                    break;
                case 58:
                    style.f67527n = r0(str2);
                    style.f67515a |= 2048;
                    break;
                case 59:
                    style.f67528o = b0(str2);
                    style.f67515a |= 4096;
                    break;
                case 60:
                    h0(style, str2);
                    break;
                case 61:
                    List listI0 = i0(str2);
                    style.f67529p = listI0;
                    if (listI0 != null) {
                        style.f67515a |= 8192;
                    }
                    break;
                case 62:
                    SVG.Length lengthJ0 = j0(str2);
                    style.f67530q = lengthJ0;
                    if (lengthJ0 != null) {
                        style.f67515a |= 16384;
                    }
                    break;
                case 63:
                    Integer numL0 = l0(str2);
                    style.f67531r = numL0;
                    if (numL0 != null) {
                        style.f67515a |= 32768;
                    }
                    break;
                case 64:
                    SVG.Style.FontStyle fontStyleK0 = k0(str2);
                    style.f67532s = fontStyleK0;
                    if (fontStyleK0 != null) {
                        style.f67515a |= 65536;
                    }
                    break;
                case 65:
                    SVG.Style.TextDecoration textDecorationH0 = H0(str2);
                    style.f67533t = textDecorationH0;
                    if (textDecorationH0 != null) {
                        style.f67515a |= 131072;
                    }
                    break;
                case 66:
                    SVG.Style.TextDirection textDirectionI0 = I0(str2);
                    style.f67534u = textDirectionI0;
                    if (textDirectionI0 != null) {
                        style.f67515a |= 68719476736L;
                    }
                    break;
                case 67:
                    SVG.Style.TextAnchor textAnchorG0 = G0(str2);
                    style.f67535v = textAnchorG0;
                    if (textAnchorG0 != null) {
                        style.f67515a |= 262144;
                    }
                    break;
                case 68:
                    Boolean boolS0 = s0(str2);
                    style.f67536w = boolS0;
                    if (boolS0 != null) {
                        style.f67515a |= 524288;
                    }
                    break;
                case 69:
                    String strM0 = m0(str2, str);
                    style.f67538y = strM0;
                    style.f67539z = strM0;
                    style.A = strM0;
                    style.f67515a |= 14680064;
                    break;
                case 70:
                    style.f67538y = m0(str2, str);
                    style.f67515a |= 2097152;
                    break;
                case 71:
                    style.f67539z = m0(str2, str);
                    style.f67515a |= 4194304;
                    break;
                case 72:
                    style.A = m0(str2, str);
                    style.f67515a |= 8388608;
                    break;
                case 73:
                    if (str2.indexOf(124) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                            style.B = Boolean.valueOf(!str2.equals(IntegrityManager.INTEGRITY_TYPE_NONE));
                            style.f67515a |= 16777216;
                            break;
                        }
                    }
                    break;
                case 74:
                    if (str2.indexOf(124) < 0) {
                        if ("|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                            style.C = Boolean.valueOf(str2.equals("visible"));
                            style.f67515a |= 33554432;
                            break;
                        }
                    }
                    break;
                case 75:
                    if (str2.equals("currentColor")) {
                        style.D = SVG.CurrentColor.a();
                    } else {
                        try {
                            style.D = b0(str2);
                        } catch (SVGParseException e3) {
                            Log.w("SVGParser", e3.getMessage());
                            return;
                        }
                    }
                    style.f67515a |= 67108864;
                    break;
                case 76:
                    style.E = r0(str2);
                    style.f67515a |= 134217728;
                    break;
                case 77:
                    SVG.CSSClipRect cSSClipRectA0 = a0(str2);
                    style.f67537x = cSSClipRectA0;
                    if (cSSClipRectA0 != null) {
                        style.f67515a |= 1048576;
                    }
                    break;
                case 78:
                    style.F = m0(str2, str);
                    style.f67515a |= 268435456;
                    break;
                case 79:
                    style.G = e0(str2);
                    style.f67515a |= 536870912;
                    break;
                case 80:
                    style.H = m0(str2, str);
                    style.f67515a |= 1073741824;
                    break;
                case 81:
                    if (str2.equals("currentColor")) {
                        style.I = SVG.CurrentColor.a();
                    } else {
                        try {
                            style.I = b0(str2);
                        } catch (SVGParseException e4) {
                            Log.w("SVGParser", e4.getMessage());
                            return;
                        }
                    }
                    style.f67515a |= 2147483648L;
                    break;
                case 82:
                    style.J = r0(str2);
                    style.f67515a |= 4294967296L;
                    break;
                case 83:
                    if (str2.equals("currentColor")) {
                        style.K = SVG.CurrentColor.a();
                    } else {
                        try {
                            style.K = b0(str2);
                        } catch (SVGParseException e5) {
                            Log.w("SVGParser", e5.getMessage());
                            return;
                        }
                    }
                    style.f67515a |= 8589934592L;
                    break;
                case 84:
                    style.L = r0(str2);
                    style.f67515a |= 17179869184L;
                    break;
                case 85:
                    SVG.Style.VectorEffect vectorEffectM0 = M0(str2);
                    style.M = vectorEffectM0;
                    if (vectorEffectM0 != null) {
                        style.f67515a |= 34359738368L;
                    }
                    break;
                case 86:
                    SVG.Style.RenderQuality renderQualityY0 = y0(str2);
                    style.N = renderQualityY0;
                    if (renderQualityY0 != null) {
                        style.f67515a |= 137438953472L;
                    }
                    break;
            }
        } catch (SVGParseException unused) {
        }
    }

    private void T(SVG.TRef tRef, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            if (AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()] == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                tRef.f67610o = strTrim;
            }
        }
    }

    private void T0(Attributes attributes) throws SVGParseException {
        l("<radialGradient>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
        svgRadialGradient.f67601a = this.f67701a;
        svgRadialGradient.f67602b = this.f67702b;
        D(svgRadialGradient, attributes);
        S(svgRadialGradient, attributes);
        F(svgRadialGradient, attributes);
        O(svgRadialGradient, attributes);
        this.f67702b.h(svgRadialGradient);
        this.f67702b = svgRadialGradient;
    }

    private void U(SVG.TextPath textPath, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 != 6) {
                if (i4 == 39) {
                    textPath.f67615p = o0(strTrim);
                }
            } else if ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3))) {
                textPath.f67614o = strTrim;
            }
        }
    }

    private void U0(Attributes attributes) throws SVGParseException {
        l("<rect>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Rect rect = new SVG.Rect();
        rect.f67601a = this.f67701a;
        rect.f67602b = this.f67702b;
        D(rect, attributes);
        S(rect, attributes);
        W(rect, attributes);
        C(rect, attributes);
        P(rect, attributes);
        this.f67702b.h(rect);
    }

    private void V(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                textPositionedContainer.f67617o = p0(strTrim);
            } else if (i4 == 2) {
                textPositionedContainer.f67618p = p0(strTrim);
            } else if (i4 == 19) {
                textPositionedContainer.f67619q = p0(strTrim);
            } else if (i4 == 20) {
                textPositionedContainer.f67620r = p0(strTrim);
            }
        }
    }

    private void V0(Attributes attributes) throws SVGParseException {
        l("<solidColor>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SolidColor solidColor = new SVG.SolidColor();
        solidColor.f67601a = this.f67701a;
        solidColor.f67602b = this.f67702b;
        D(solidColor, attributes);
        S(solidColor, attributes);
        this.f67702b.h(solidColor);
        this.f67702b = solidColor;
    }

    private void W(SVG.HasTransform hasTransform, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            if (SVGAttr.a(attributes.getLocalName(i3)) == SVGAttr.transform) {
                hasTransform.k(J0(attributes.getValue(i3)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.f67701a = new SVG();
    }

    private void X(SVG.Use use, Attributes attributes) throws SVGParseException {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 1) {
                use.f67634q = o0(strTrim);
            } else if (i4 == 2) {
                use.f67635r = o0(strTrim);
            } else if (i4 == 3) {
                SVG.Length lengthO0 = o0(strTrim);
                use.f67636s = lengthO0;
                if (lengthO0.i()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i4 == 4) {
                SVG.Length lengthO02 = o0(strTrim);
                use.f67637t = lengthO02;
                if (lengthO02.i()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i4 == 6 && ("".equals(attributes.getURI(i3)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i3)))) {
                use.f67633p = strTrim;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        if (this.f67703c) {
            this.f67704d++;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem sVGElemA = SVGElem.a(str2);
            switch (AnonymousClass1.f67710a[sVGElemA.ordinal()]) {
                case 1:
                    a1(attributes);
                    break;
                case 2:
                case 3:
                    q(attributes);
                    break;
                case 4:
                    m(attributes);
                    break;
                case 5:
                    i1(attributes);
                    break;
                case 6:
                    O0(attributes);
                    break;
                case 7:
                    U0(attributes);
                    break;
                case 8:
                    i(attributes);
                    break;
                case 9:
                    n(attributes);
                    break;
                case 10:
                    v(attributes);
                    break;
                case 11:
                    R0(attributes);
                    break;
                case 12:
                    Q0(attributes);
                    break;
                case 13:
                    d1(attributes);
                    break;
                case 14:
                    h1(attributes);
                    break;
                case 15:
                    g1(attributes);
                    break;
                case 16:
                    k1(attributes);
                    break;
                case 17:
                    b1(attributes);
                    break;
                case 18:
                    x(attributes);
                    break;
                case 19:
                    w(attributes);
                    break;
                case 20:
                    T0(attributes);
                    break;
                case 21:
                    Y0(attributes);
                    break;
                case 22:
                case 23:
                    this.f67705e = true;
                    this.f67706f = sVGElemA;
                    break;
                case 24:
                    k(attributes);
                    break;
                case 25:
                    f1(attributes);
                    break;
                case 26:
                    P0(attributes);
                    break;
                case 27:
                    u(attributes);
                    break;
                case 28:
                    j1(attributes);
                    break;
                case 29:
                    y(attributes);
                    break;
                case 30:
                    Z0(attributes);
                    break;
                case 31:
                    V0(attributes);
                    break;
                default:
                    this.f67703c = true;
                    this.f67704d = 1;
                    break;
            }
        }
    }

    private void Y(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) {
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 7) {
                w0(svgViewBoxContainer, strTrim);
            } else if (i4 == 87) {
                svgViewBoxContainer.f67609p = N0(strTrim);
            }
        }
    }

    private void Y0(Attributes attributes) throws SVGParseException {
        l("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.f67702b;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.GradientElement)) {
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        SVG.Stop stop = new SVG.Stop();
        stop.f67601a = this.f67701a;
        stop.f67602b = this.f67702b;
        D(stop, attributes);
        S(stop, attributes);
        R(stop, attributes);
        this.f67702b.h(stop);
        this.f67702b = stop;
    }

    private void Z(String str) {
        this.f67701a.a(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).d(str));
    }

    private void Z0(Attributes attributes) throws SVGParseException {
        l("<style>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        String str = "all";
        boolean zEquals = true;
        for (int i3 = 0; i3 < attributes.getLength(); i3++) {
            String strTrim = attributes.getValue(i3).trim();
            int i4 = AnonymousClass1.f67711b[SVGAttr.a(attributes.getLocalName(i3)).ordinal()];
            if (i4 == 88) {
                zEquals = strTrim.equals("text/css");
            } else if (i4 == 89) {
                str = strTrim;
            }
        }
        if (zEquals && CSSParser.b(str, CSSParser.MediaType.screen)) {
            this.f67708h = true;
        } else {
            this.f67703c = true;
            this.f67704d = 1;
        }
    }

    private static SVG.CSSClipRect a0(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        TextScanner textScanner = new TextScanner(str.substring(5));
        textScanner.A();
        SVG.Length lengthQ0 = q0(textScanner);
        textScanner.z();
        SVG.Length lengthQ02 = q0(textScanner);
        textScanner.z();
        SVG.Length lengthQ03 = q0(textScanner);
        textScanner.z();
        SVG.Length lengthQ04 = q0(textScanner);
        textScanner.A();
        if (textScanner.f(')') || textScanner.h()) {
            return new SVG.CSSClipRect(lengthQ0, lengthQ02, lengthQ03, lengthQ04);
        }
        return null;
    }

    private void a1(Attributes attributes) throws SVGParseException {
        l("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.f67601a = this.f67701a;
        svg.f67602b = this.f67702b;
        D(svg, attributes);
        S(svg, attributes);
        C(svg, attributes);
        Y(svg, attributes);
        Q(svg, attributes);
        SVG.SvgContainer svgContainer = this.f67702b;
        if (svgContainer == null) {
            this.f67701a.C(svg);
        } else {
            svgContainer.h(svg);
        }
        this.f67702b = svg;
    }

    private static SVG.Colour b0(String str) throws SVGParseException {
        if (str.charAt(0) == '#') {
            IntegerParser integerParserB = IntegerParser.b(str, 1, str.length());
            if (integerParserB == null) {
                throw new SVGParseException("Bad hex colour value: " + str);
            }
            int iA = integerParserB.a();
            if (iA == 4) {
                int iD = integerParserB.d();
                int i3 = iD & 3840;
                int i4 = iD & 240;
                int i5 = iD & 15;
                return new SVG.Colour(i5 | (i3 << 8) | (-16777216) | (i3 << 12) | (i4 << 8) | (i4 << 4) | (i5 << 4));
            }
            if (iA == 5) {
                int iD2 = integerParserB.d();
                int i6 = 61440 & iD2;
                int i7 = iD2 & 3840;
                int i8 = iD2 & 240;
                int i9 = iD2 & 15;
                return new SVG.Colour((i9 << 24) | (i9 << 28) | (i6 << 8) | (i6 << 4) | (i7 << 4) | i7 | i8 | (i8 >> 4));
            }
            if (iA == 7) {
                return new SVG.Colour(integerParserB.d() | (-16777216));
            }
            if (iA == 9) {
                return new SVG.Colour((integerParserB.d() >>> 8) | (integerParserB.d() << 24));
            }
            throw new SVGParseException("Bad hex colour value: " + str);
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean zStartsWith = lowerCase.startsWith("rgba(");
        if (!zStartsWith && !lowerCase.startsWith("rgb(")) {
            boolean zStartsWith2 = lowerCase.startsWith("hsla(");
            if (!zStartsWith2 && !lowerCase.startsWith("hsl(")) {
                return c0(lowerCase);
            }
            TextScanner textScanner = new TextScanner(str.substring(zStartsWith2 ? 5 : 4));
            textScanner.A();
            float fN = textScanner.n();
            float fD = textScanner.d(fN);
            if (!Float.isNaN(fD)) {
                textScanner.f('%');
            }
            float fD2 = textScanner.d(fD);
            if (!Float.isNaN(fD2)) {
                textScanner.f('%');
            }
            if (!zStartsWith2) {
                textScanner.A();
                if (!Float.isNaN(fD2) && textScanner.f(')')) {
                    return new SVG.Colour(s(fN, fD, fD2) | (-16777216));
                }
                throw new SVGParseException("Bad hsl() colour value: " + str);
            }
            float fD3 = textScanner.d(fD2);
            textScanner.A();
            if (!Float.isNaN(fD3) && textScanner.f(')')) {
                return new SVG.Colour((j(fD3 * 256.0f) << 24) | s(fN, fD, fD2));
            }
            throw new SVGParseException("Bad hsla() colour value: " + str);
        }
        TextScanner textScanner2 = new TextScanner(str.substring(zStartsWith ? 5 : 4));
        textScanner2.A();
        float fN2 = textScanner2.n();
        if (!Float.isNaN(fN2) && textScanner2.f('%')) {
            fN2 = (fN2 * 256.0f) / 100.0f;
        }
        float fD4 = textScanner2.d(fN2);
        if (!Float.isNaN(fD4) && textScanner2.f('%')) {
            fD4 = (fD4 * 256.0f) / 100.0f;
        }
        float fD5 = textScanner2.d(fD4);
        if (!Float.isNaN(fD5) && textScanner2.f('%')) {
            fD5 = (fD5 * 256.0f) / 100.0f;
        }
        if (!zStartsWith) {
            textScanner2.A();
            if (!Float.isNaN(fD5) && textScanner2.f(')')) {
                return new SVG.Colour((j(fN2) << 16) | (-16777216) | (j(fD4) << 8) | j(fD5));
            }
            throw new SVGParseException("Bad rgb() colour value: " + str);
        }
        float fD6 = textScanner2.d(fD5);
        textScanner2.A();
        if (!Float.isNaN(fD6) && textScanner2.f(')')) {
            return new SVG.Colour((j(fD6 * 256.0f) << 24) | (j(fN2) << 16) | (j(fD4) << 8) | j(fD5));
        }
        throw new SVGParseException("Bad rgba() colour value: " + str);
    }

    private void b1(Attributes attributes) throws SVGParseException {
        l("<symbol>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgViewBoxContainer symbol = new SVG.Symbol();
        symbol.f67601a = this.f67701a;
        symbol.f67602b = this.f67702b;
        D(symbol, attributes);
        S(symbol, attributes);
        C(symbol, attributes);
        Y(symbol, attributes);
        this.f67702b.h(symbol);
        this.f67702b = symbol;
    }

    private static SVG.Colour c0(String str) throws SVGParseException {
        Integer numA = ColourKeywords.a(str);
        if (numA != null) {
            return new SVG.Colour(numA.intValue());
        }
        throw new SVGParseException("Invalid colour keyword: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(String str) {
        if (this.f67703c) {
            return;
        }
        if (this.f67705e) {
            if (this.f67707g == null) {
                this.f67707g = new StringBuilder(str.length());
            }
            this.f67707g.append(str);
        } else if (this.f67708h) {
            if (this.f67709i == null) {
                this.f67709i = new StringBuilder(str.length());
            }
            this.f67709i.append(str);
        } else if (this.f67702b instanceof SVG.TextContainer) {
            h(str);
        }
    }

    private static SVG.SvgPaint d0(String str) {
        str.getClass();
        if (str.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
            return SVG.Colour.f67449c;
        }
        if (str.equals("currentColor")) {
            return SVG.CurrentColor.a();
        }
        try {
            return b0(str);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private void d1(Attributes attributes) throws SVGParseException {
        l("<text>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Text text = new SVG.Text();
        text.f67601a = this.f67701a;
        text.f67602b = this.f67702b;
        D(text, attributes);
        S(text, attributes);
        W(text, attributes);
        C(text, attributes);
        V(text, attributes);
        this.f67702b.h(text);
        this.f67702b = text;
    }

    private static SVG.Style.FillRule e0(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private void e1(char[] cArr, int i3, int i4) {
        if (this.f67703c) {
            return;
        }
        if (this.f67705e) {
            if (this.f67707g == null) {
                this.f67707g = new StringBuilder(i4);
            }
            this.f67707g.append(cArr, i3, i4);
        } else if (this.f67708h) {
            if (this.f67709i == null) {
                this.f67709i = new StringBuilder(i4);
            }
            this.f67709i.append(cArr, i3, i4);
        } else if (this.f67702b instanceof SVG.TextContainer) {
            h(new String(cArr, i3, i4));
        }
    }

    private static float f0(String str) throws SVGParseException {
        int length = str.length();
        if (length != 0) {
            return g0(str, 0, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    private void f1(Attributes attributes) throws SVGParseException {
        l("<textPath>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.TextPath textPath = new SVG.TextPath();
        textPath.f67601a = this.f67701a;
        textPath.f67602b = this.f67702b;
        D(textPath, attributes);
        S(textPath, attributes);
        C(textPath, attributes);
        U(textPath, attributes);
        this.f67702b.h(textPath);
        this.f67702b = textPath;
        SVG.SvgContainer svgContainer = textPath.f67602b;
        if (svgContainer instanceof SVG.TextRoot) {
            textPath.o((SVG.TextRoot) svgContainer);
        } else {
            textPath.o(((SVG.TextChild) svgContainer).d());
        }
    }

    private static float g0(String str, int i3, int i4) throws SVGParseException {
        float fB = new NumberParser().b(str, i3, i4);
        if (!Float.isNaN(fB)) {
            return fB;
        }
        throw new SVGParseException("Invalid float value: " + str);
    }

    private void g1(Attributes attributes) throws SVGParseException {
        l("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.f67702b;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.TRef tRef = new SVG.TRef();
        tRef.f67601a = this.f67701a;
        tRef.f67602b = this.f67702b;
        D(tRef, attributes);
        S(tRef, attributes);
        C(tRef, attributes);
        T(tRef, attributes);
        this.f67702b.h(tRef);
        SVG.SvgContainer svgContainer2 = tRef.f67602b;
        if (svgContainer2 instanceof SVG.TextRoot) {
            tRef.o((SVG.TextRoot) svgContainer2);
        } else {
            tRef.o(((SVG.TextChild) svgContainer2).d());
        }
    }

    private void h(String str) {
        SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) this.f67702b;
        int size = svgConditionalContainer.f67580i.size();
        SVG.SvgObject svgObject = size == 0 ? null : (SVG.SvgObject) svgConditionalContainer.f67580i.get(size - 1);
        if (!(svgObject instanceof SVG.TextSequence)) {
            this.f67702b.h(new SVG.TextSequence(str));
            return;
        }
        StringBuilder sb = new StringBuilder();
        SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
        sb.append(textSequence.f67621c);
        sb.append(str);
        textSequence.f67621c = sb.toString();
    }

    private static void h0(SVG.Style style, String str) {
        String strS;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            TextScanner textScanner = new TextScanner(str);
            Integer numA = null;
            SVG.Style.FontStyle fontStyleK0 = null;
            String str2 = null;
            while (true) {
                strS = textScanner.s('/');
                textScanner.A();
                if (strS != null) {
                    if (numA != null && fontStyleK0 != null) {
                        break;
                    }
                    if (!strS.equals("normal") && (numA != null || (numA = FontWeightKeywords.a(strS)) == null)) {
                        if (fontStyleK0 != null || (fontStyleK0 = k0(strS)) == null) {
                            if (str2 != null || !strS.equals("small-caps")) {
                                break;
                            } else {
                                str2 = strS;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            SVG.Length lengthJ0 = j0(strS);
            if (textScanner.f('/')) {
                textScanner.A();
                String strR = textScanner.r();
                if (strR != null) {
                    try {
                        o0(strR);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                textScanner.A();
            }
            style.f67529p = i0(textScanner.y());
            style.f67530q = lengthJ0;
            style.f67531r = Integer.valueOf(numA == null ? RCHTTPStatusCodes.BAD_REQUEST : numA.intValue());
            if (fontStyleK0 == null) {
                fontStyleK0 = SVG.Style.FontStyle.Normal;
            }
            style.f67532s = fontStyleK0;
            style.f67515a |= 122880;
        }
    }

    private void h1(Attributes attributes) throws SVGParseException {
        l("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.f67702b;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.TSpan tSpan = new SVG.TSpan();
        tSpan.f67601a = this.f67701a;
        tSpan.f67602b = this.f67702b;
        D(tSpan, attributes);
        S(tSpan, attributes);
        C(tSpan, attributes);
        V(tSpan, attributes);
        this.f67702b.h(tSpan);
        this.f67702b = tSpan;
        SVG.SvgContainer svgContainer2 = tSpan.f67602b;
        if (svgContainer2 instanceof SVG.TextRoot) {
            tSpan.o((SVG.TextRoot) svgContainer2);
        } else {
            tSpan.o(((SVG.TextChild) svgContainer2).d());
        }
    }

    private void i(Attributes attributes) throws SVGParseException {
        l("<circle>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Circle circle = new SVG.Circle();
        circle.f67601a = this.f67701a;
        circle.f67602b = this.f67702b;
        D(circle, attributes);
        S(circle, attributes);
        W(circle, attributes);
        C(circle, attributes);
        A(circle, attributes);
        this.f67702b.h(circle);
    }

    private static List i0(String str) {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String strQ = textScanner.q();
            if (strQ == null) {
                strQ = textScanner.u(',');
            }
            if (strQ == null) {
                return arrayList;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strQ);
            textScanner.z();
        } while (!textScanner.h());
        return arrayList;
    }

    private void i1(Attributes attributes) throws SVGParseException {
        l("<use>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Use use = new SVG.Use();
        use.f67601a = this.f67701a;
        use.f67602b = this.f67702b;
        D(use, attributes);
        S(use, attributes);
        W(use, attributes);
        C(use, attributes);
        X(use, attributes);
        this.f67702b.h(use);
        this.f67702b = use;
    }

    private static int j(float f3) {
        if (f3 < 0.0f) {
            return 0;
        }
        if (f3 > 255.0f) {
            return 255;
        }
        return Math.round(f3);
    }

    private static SVG.Length j0(String str) {
        try {
            SVG.Length lengthA = FontSizeKeywords.a(str);
            return lengthA == null ? o0(str) : lengthA;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private void j1(Attributes attributes) throws SVGParseException {
        l("<view>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgViewBoxContainer view = new SVG.View();
        view.f67601a = this.f67701a;
        view.f67602b = this.f67702b;
        D(view, attributes);
        C(view, attributes);
        Y(view, attributes);
        this.f67702b.h(view);
        this.f67702b = view;
    }

    private void k(Attributes attributes) throws SVGParseException {
        l("<clipPath>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.ClipPath clipPath = new SVG.ClipPath();
        clipPath.f67601a = this.f67701a;
        clipPath.f67602b = this.f67702b;
        D(clipPath, attributes);
        S(clipPath, attributes);
        W(clipPath, attributes);
        C(clipPath, attributes);
        B(clipPath, attributes);
        this.f67702b.h(clipPath);
        this.f67702b = clipPath;
    }

    private static SVG.Style.FontStyle k0(String str) {
        str.getClass();
        switch (str) {
            case "oblique":
                return SVG.Style.FontStyle.Oblique;
            case "italic":
                return SVG.Style.FontStyle.Italic;
            case "normal":
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    private void k1(Attributes attributes) throws SVGParseException {
        l("<switch>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Switch r02 = new SVG.Switch();
        r02.f67601a = this.f67701a;
        r02.f67602b = this.f67702b;
        D(r02, attributes);
        S(r02, attributes);
        W(r02, attributes);
        C(r02, attributes);
        this.f67702b.h(r02);
        this.f67702b = r02;
    }

    private void l(String str, Object... objArr) {
    }

    private static Integer l0(String str) {
        return FontWeightKeywords.a(str);
    }

    private void m(Attributes attributes) throws SVGParseException {
        l("<defs>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Defs defs = new SVG.Defs();
        defs.f67601a = this.f67701a;
        defs.f67602b = this.f67702b;
        D(defs, attributes);
        S(defs, attributes);
        W(defs, attributes);
        this.f67702b.h(defs);
        this.f67702b = defs;
    }

    private static String m0(String str, String str2) {
        if (!str.equals(IntegrityManager.INTEGRITY_TYPE_NONE) && str.startsWith("url(")) {
            return str.endsWith(")") ? str.substring(4, str.length() - 1).trim() : str.substring(4).trim();
        }
        return null;
    }

    private void n(Attributes attributes) throws SVGParseException {
        l("<ellipse>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Ellipse ellipse = new SVG.Ellipse();
        ellipse.f67601a = this.f67701a;
        ellipse.f67602b = this.f67702b;
        D(ellipse, attributes);
        S(ellipse, attributes);
        W(ellipse, attributes);
        C(ellipse, attributes);
        E(ellipse, attributes);
        this.f67702b.h(ellipse);
    }

    private Float n0(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        boolean z2 = true;
        if (str.charAt(str.length() - 1) == '%') {
            length--;
        } else {
            z2 = false;
        }
        try {
            float fG0 = g0(str, 0, length);
            float f3 = 100.0f;
            if (z2) {
                fG0 /= 100.0f;
            }
            if (fG0 < 0.0f) {
                f3 = 0.0f;
            } else if (fG0 <= 100.0f) {
                f3 = fG0;
            }
            return Float.valueOf(f3);
        } catch (NumberFormatException e3) {
            throw new SVGParseException("Invalid offset value in <stop>: " + str, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
    }

    static SVG.Length o0(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length value (empty string)");
        }
        int length = str.length();
        SVG.Unit unitValueOf = SVG.Unit.px;
        char cCharAt = str.charAt(length - 1);
        if (cCharAt == '%') {
            length--;
            unitValueOf = SVG.Unit.percent;
        } else if (length > 2 && Character.isLetter(cCharAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                unitValueOf = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new SVGParseException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new SVG.Length(g0(str, 0, length), unitValueOf);
        } catch (NumberFormatException e3) {
            throw new SVGParseException("Invalid length value: " + str, e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, String str2, String str3) {
        if (this.f67703c) {
            int i3 = this.f67704d - 1;
            this.f67704d = i3;
            if (i3 == 0) {
                this.f67703c = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i4 = AnonymousClass1.f67710a[SVGElem.a(str2).ordinal()];
            if (i4 != 1 && i4 != 2 && i4 != 4 && i4 != 5 && i4 != 13 && i4 != 14) {
                switch (i4) {
                    case 22:
                    case 23:
                        this.f67705e = false;
                        StringBuilder sb = this.f67707g;
                        if (sb != null) {
                            SVGElem sVGElem = this.f67706f;
                            if (sVGElem == SVGElem.title) {
                                this.f67701a.D(sb.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.f67701a.w(sb.toString());
                            }
                            this.f67707g.setLength(0);
                        }
                        break;
                    case 30:
                        StringBuilder sb2 = this.f67709i;
                        if (sb2 != null) {
                            this.f67708h = false;
                            Z(sb2.toString());
                            this.f67709i.setLength(0);
                        }
                        break;
                }
                return;
            }
            this.f67702b = ((SVG.SvgObject) this.f67702b).f67602b;
        }
    }

    private static List p0(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        TextScanner textScanner = new TextScanner(str);
        textScanner.A();
        while (!textScanner.h()) {
            float fN = textScanner.n();
            if (Float.isNaN(fN)) {
                throw new SVGParseException("Invalid length list value: " + textScanner.b());
            }
            SVG.Unit unitV = textScanner.v();
            if (unitV == null) {
                unitV = SVG.Unit.px;
            }
            arrayList.add(new SVG.Length(fN, unitV));
            textScanner.z();
        }
        return arrayList;
    }

    private void q(Attributes attributes) throws SVGParseException {
        l("<g>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Group group = new SVG.Group();
        group.f67601a = this.f67701a;
        group.f67602b = this.f67702b;
        D(group, attributes);
        S(group, attributes);
        W(group, attributes);
        C(group, attributes);
        this.f67702b.h(group);
        this.f67702b = group;
    }

    private static SVG.Length q0(TextScanner textScanner) {
        return textScanner.g("auto") ? new SVG.Length(0.0f) : textScanner.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, Map map) {
        String str2;
        String strB;
        if (!str.equals("xml-stylesheet") || SVG.k() == null) {
            return;
        }
        if (((String) map.get("type")) == null || "text/css".equals(map.get("type"))) {
            if ((((String) map.get("alternate")) != null && !"no".equals(map.get("alternate"))) || (str2 = (String) map.get(ShareConstants.WEB_DIALOG_PARAM_HREF)) == null || (strB = SVG.k().b(str2)) == null) {
                return;
            }
            String str3 = (String) map.get(ShareConstants.WEB_DIALOG_PARAM_MEDIA);
            if (str3 != null && !"all".equals(str3.trim())) {
                strB = "@media " + str3 + " { " + strB + "}";
            }
            Z(strB);
        }
    }

    private static Float r0(String str) {
        try {
            float fF0 = f0(str);
            float f3 = 0.0f;
            if (fF0 < 0.0f) {
                fF0 = f3;
            } else {
                f3 = 1.0f;
                if (fF0 > 1.0f) {
                    fF0 = f3;
                }
            }
            return Float.valueOf(fF0);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static int s(float f3, float f4, float f5) {
        float f6 = f3 % 360.0f;
        if (f3 < 0.0f) {
            f6 += 360.0f;
        }
        float f7 = f6 / 60.0f;
        float f8 = f4 / 100.0f;
        float f9 = f5 / 100.0f;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        } else if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        float f10 = f9 >= 0.0f ? f9 > 1.0f ? 1.0f : f9 : 0.0f;
        float f11 = f10 <= 0.5f ? (f8 + 1.0f) * f10 : (f10 + f8) - (f8 * f10);
        float f12 = (f10 * 2.0f) - f11;
        return j(t(f12, f11, f7 - 2.0f) * 256.0f) | (j(t(f12, f11, f7 + 2.0f) * 256.0f) << 16) | (j(t(f12, f11, f7) * 256.0f) << 8);
    }

    private static Boolean s0(String str) {
        str.getClass();
        switch (str) {
            case "hidden":
            case "scroll":
                return Boolean.FALSE;
            case "auto":
            case "visible":
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static float t(float f3, float f4, float f5) {
        float f6;
        if (f5 < 0.0f) {
            f5 += 6.0f;
        }
        if (f5 >= 6.0f) {
            f5 -= 6.0f;
        }
        if (f5 < 1.0f) {
            f6 = (f4 - f3) * f5;
        } else {
            if (f5 < 3.0f) {
                return f4;
            }
            if (f5 >= 4.0f) {
                return f3;
            }
            f6 = (f4 - f3) * (4.0f - f5);
        }
        return f6 + f3;
    }

    private static SVG.SvgPaint t0(String str) {
        if (!str.startsWith("url(")) {
            return d0(str);
        }
        int iIndexOf = str.indexOf(")");
        if (iIndexOf == -1) {
            return new SVG.PaintReference(str.substring(4).trim(), null);
        }
        String strTrim = str.substring(4, iIndexOf).trim();
        String strTrim2 = str.substring(iIndexOf + 1).trim();
        return new SVG.PaintReference(strTrim, strTrim2.length() > 0 ? d0(strTrim2) : null);
    }

    private void u(Attributes attributes) throws SVGParseException {
        l("<image>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Image image = new SVG.Image();
        image.f67601a = this.f67701a;
        image.f67602b = this.f67702b;
        D(image, attributes);
        S(image, attributes);
        W(image, attributes);
        C(image, attributes);
        G(image, attributes);
        this.f67702b.h(image);
        this.f67702b = image;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0293, code lost:
    
        android.util.Log.e("SVGParser", "Bad path coords for " + ((char) r11) + " path segment");
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0280 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.caverock.androidsvg.SVG.PathDefinition u0(java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.SVGParser.u0(java.lang.String):com.caverock.androidsvg.SVG$PathDefinition");
    }

    private void v(Attributes attributes) throws SVGParseException {
        l("<line>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Line line = new SVG.Line();
        line.f67601a = this.f67701a;
        line.f67602b = this.f67702b;
        D(line, attributes);
        S(line, attributes);
        W(line, attributes);
        C(line, attributes);
        H(line, attributes);
        this.f67702b.h(line);
    }

    static PreserveAspectRatio v0(String str) throws SVGParseException {
        PreserveAspectRatio.Scale scale;
        TextScanner textScanner = new TextScanner(str);
        textScanner.A();
        String strR = textScanner.r();
        if ("defer".equals(strR)) {
            textScanner.A();
            strR = textScanner.r();
        }
        PreserveAspectRatio.Alignment alignmentA = AspectRatioKeywords.a(strR);
        textScanner.A();
        if (textScanner.h()) {
            scale = null;
        } else {
            String strR2 = textScanner.r();
            strR2.getClass();
            if (strR2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else {
                if (!strR2.equals("slice")) {
                    throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
                }
                scale = PreserveAspectRatio.Scale.slice;
            }
        }
        return new PreserveAspectRatio(alignmentA, scale);
    }

    private void w(Attributes attributes) throws SVGParseException {
        l("<linearGradient>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
        svgLinearGradient.f67601a = this.f67701a;
        svgLinearGradient.f67602b = this.f67702b;
        D(svgLinearGradient, attributes);
        S(svgLinearGradient, attributes);
        F(svgLinearGradient, attributes);
        I(svgLinearGradient, attributes);
        this.f67702b.h(svgLinearGradient);
        this.f67702b = svgLinearGradient;
    }

    private static void w0(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) {
        svgPreserveAspectRatioContainer.f67603o = v0(str);
    }

    private void x(Attributes attributes) throws SVGParseException {
        l("<marker>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Marker marker = new SVG.Marker();
        marker.f67601a = this.f67701a;
        marker.f67602b = this.f67702b;
        D(marker, attributes);
        S(marker, attributes);
        C(marker, attributes);
        Y(marker, attributes);
        J(marker, attributes);
        this.f67702b.h(marker);
        this.f67702b = marker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map x0(TextScanner textScanner) {
        HashMap map = new HashMap();
        textScanner.A();
        String strS = textScanner.s('=');
        while (strS != null) {
            textScanner.f('=');
            map.put(strS, textScanner.q());
            textScanner.A();
            strS = textScanner.s('=');
        }
        return map;
    }

    private void y(Attributes attributes) throws SVGParseException {
        l("<mask>", new Object[0]);
        if (this.f67702b == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Mask mask = new SVG.Mask();
        mask.f67601a = this.f67701a;
        mask.f67602b = this.f67702b;
        D(mask, attributes);
        S(mask, attributes);
        C(mask, attributes);
        K(mask, attributes);
        this.f67702b.h(mask);
        this.f67702b = mask;
    }

    private static SVG.Style.RenderQuality y0(String str) {
        str.getClass();
        switch (str) {
            case "optimizeQuality":
                return SVG.Style.RenderQuality.f67556b;
            case "auto":
                return SVG.Style.RenderQuality.f67555a;
            case "optimizeSpeed":
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    private static Set z0(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.h()) {
            String strR = textScanner.r();
            if (strR.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(strR.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.A();
        }
        return hashSet;
    }

    SVG z(InputStream inputStream, boolean z2) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int i3 = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (i3 == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            L0(inputStream, z2);
            return this.f67701a;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }
}
