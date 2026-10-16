package androidx.media3.extractor.text.webvtt;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.appcompat.app.jE.vxrlPPpdv;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.HorizontalTextInVerticalContextSpan;
import androidx.media3.common.text.RubySpan;
import androidx.media3.common.text.SpanUtil;
import androidx.media3.common.text.VoiceSpan;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class WebvttCueParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f47301a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f47302b = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f47303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f47304d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static class Element {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator f47305c = new Comparator() { // from class: androidx.media3.extractor.text.webvtt.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((WebvttCueParser.Element) obj).f47306a.f47309b, ((WebvttCueParser.Element) obj2).f47306a.f47309b);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StartTag f47306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f47307b;

        private Element(StartTag startTag, int i3) {
            this.f47306a = startTag;
            this.f47307b = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static final class StartTag {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f47308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f47309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f47310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set f47311d;

        private StartTag(String str, int i3, String str2, Set set) {
            this.f47309b = i3;
            this.f47308a = str;
            this.f47310c = str2;
            this.f47311d = set;
        }

        public static StartTag a(String str, int i3) {
            String str2;
            String strTrim = str.trim();
            Assertions.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrH1 = Util.h1(strTrim, "\\.");
            String str3 = strArrH1[0];
            HashSet hashSet = new HashSet();
            for (int i4 = 1; i4 < strArrH1.length; i4++) {
                hashSet.add(strArrH1[i4]);
            }
            return new StartTag(str3, i3, str2, hashSet);
        }

        public static StartTag b() {
            return new StartTag("", 0, "", Collections.EMPTY_SET);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class StyleMatch implements Comparable<StyleMatch> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WebvttCssStyle f47313b;

        public StyleMatch(int i3, WebvttCssStyle webvttCssStyle) {
            this.f47312a = i3;
            this.f47313b = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(StyleMatch styleMatch) {
            return Integer.compare(this.f47312a, styleMatch.f47312a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class WebvttCueInfoBuilder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f47316c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f47314a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f47315b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f47317d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f47318e = -3.4028235E38f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f47319f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f47320g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f47321h = -3.4028235E38f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f47322i = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f47323j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f47324k = Integer.MIN_VALUE;

        private static float b(float f3, int i3) {
            if (f3 == -3.4028235E38f || i3 != 0 || (f3 >= 0.0f && f3 <= 1.0f)) {
                return f3 != -3.4028235E38f ? f3 : i3 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static Layout.Alignment c(int i3) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            Log.i("WebvttCueParser", "Unknown textAlignment: " + i3);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i3, float f3) {
            if (i3 == 0) {
                return 1.0f - f3;
            }
            if (i3 == 1) {
                return f3 <= 0.5f ? f3 * 2.0f : (1.0f - f3) * 2.0f;
            }
            if (i3 == 2) {
                return f3;
            }
            throw new IllegalStateException(String.valueOf(i3));
        }

        private static float e(int i3) {
            if (i3 != 4) {
                return i3 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int f(int i3) {
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 3) {
                return 2;
            }
            if (i3 != 4) {
                return i3 != 5 ? 1 : 2;
            }
            return 0;
        }

        public WebvttCueInfo a() {
            return new WebvttCueInfo(g().a(), this.f47314a, this.f47315b);
        }

        public Cue.Builder g() {
            float fE = this.f47321h;
            if (fE == -3.4028235E38f) {
                fE = e(this.f47317d);
            }
            int iF = this.f47322i;
            if (iF == Integer.MIN_VALUE) {
                iF = f(this.f47317d);
            }
            Cue.Builder builderR = new Cue.Builder().p(c(this.f47317d)).h(b(this.f47318e, this.f47319f), this.f47319f).i(this.f47320g).k(fE).l(iF).n(Math.min(this.f47323j, d(iF, fE))).r(this.f47324k);
            CharSequence charSequence = this.f47316c;
            if (charSequence != null) {
                builderR.o(charSequence);
            }
            return builderR;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f47303c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f47304d = Collections.unmodifiableMap(map2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i3, int i4) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = f47303c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str)).intValue()), i3, i4, 33);
            } else {
                Map map2 = f47304d;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str)).intValue()), i3, i4, 33);
                }
            }
        }
    }

    private static void b(String str, SpannableStringBuilder spannableStringBuilder) {
        str.getClass();
        switch (str) {
            case "gt":
                spannableStringBuilder.append('>');
                break;
            case "lt":
                spannableStringBuilder.append('<');
                break;
            case "amp":
                spannableStringBuilder.append('&');
                break;
            case "nbsp":
                spannableStringBuilder.append(' ');
                break;
            default:
                Log.i("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String str, StartTag startTag, List list, List list2) {
        int iJ = j(list2, str, startTag);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, Element.f47305c);
        int i3 = startTag.f47309b;
        int length = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if ("rt".equals(((Element) arrayList.get(i4)).f47306a.f47308a)) {
                Element element = (Element) arrayList.get(i4);
                int iH = h(j(list2, str, element.f47306a), iJ, 1);
                int i5 = element.f47306a.f47309b - length;
                int i6 = element.f47307b - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i5, i6);
                spannableStringBuilder.delete(i5, i6);
                spannableStringBuilder.setSpan(new RubySpan(charSequenceSubSequence.toString(), iH), i3, i5, 33);
                length += charSequenceSubSequence.length();
                i3 = i5;
            }
        }
    }

    private static void d(String str, StartTag startTag, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i3;
        int length;
        i3 = startTag.f47309b;
        length = spannableStringBuilder.length();
        String str2 = startTag.f47308a;
        str2.getClass();
        switch (str2) {
            case "":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i3, length, 33);
                break;
            case "c":
                a(spannableStringBuilder, startTag.f47311d, i3, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, length, 33);
                break;
            case "v":
                f(spannableStringBuilder, startTag.f47310c, i3, length);
                break;
            case "ruby":
                c(spannableStringBuilder, str, startTag, list, list2);
                break;
            default:
                return;
        }
        List listI = i(list2, str, startTag);
        for (int i4 = 0; i4 < listI.size(); i4++) {
            e(spannableStringBuilder, ((StyleMatch) listI.get(i4)).f47313b, i3, length);
        }
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, WebvttCssStyle webvttCssStyle, int i3, int i4) {
        if (webvttCssStyle == null) {
            return;
        }
        if (webvttCssStyle.i() != -1) {
            SpanUtil.b(spannableStringBuilder, new StyleSpan(webvttCssStyle.i()), i3, i4, 33);
        }
        if (webvttCssStyle.l()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i3, i4, 33);
        }
        if (webvttCssStyle.m()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, 33);
        }
        if (webvttCssStyle.k()) {
            SpanUtil.b(spannableStringBuilder, new ForegroundColorSpan(webvttCssStyle.c()), i3, i4, 33);
        }
        if (webvttCssStyle.j()) {
            SpanUtil.b(spannableStringBuilder, new BackgroundColorSpan(webvttCssStyle.a()), i3, i4, 33);
        }
        if (webvttCssStyle.d() != null) {
            SpanUtil.b(spannableStringBuilder, new TypefaceSpan(webvttCssStyle.d()), i3, i4, 33);
        }
        int iF = webvttCssStyle.f();
        if (iF == 1) {
            SpanUtil.b(spannableStringBuilder, new AbsoluteSizeSpan((int) webvttCssStyle.e(), true), i3, i4, 33);
        } else if (iF == 2) {
            SpanUtil.b(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e()), i3, i4, 33);
        } else if (iF == 3) {
            SpanUtil.b(spannableStringBuilder, new RelativeSizeSpan(webvttCssStyle.e() / 100.0f), i3, i4, 33);
        }
        if (webvttCssStyle.b()) {
            spannableStringBuilder.setSpan(new HorizontalTextInVerticalContextSpan(), i3, i4, 33);
        }
    }

    private static void f(SpannableStringBuilder spannableStringBuilder, String str, int i3, int i4) {
        spannableStringBuilder.setSpan(new VoiceSpan(str), i3, i4, 33);
    }

    private static int g(String str, int i3) {
        int iIndexOf = str.indexOf(62, i3);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    private static int h(int i3, int i4, int i5) {
        if (i3 != -1) {
            return i3;
        }
        if (i4 != -1) {
            return i4;
        }
        if (i5 != -1) {
            return i5;
        }
        throw new IllegalArgumentException();
    }

    private static List i(List list, String str, StartTag startTag) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            WebvttCssStyle webvttCssStyle = (WebvttCssStyle) list.get(i3);
            int iH = webvttCssStyle.h(str, startTag.f47308a, startTag.f47311d, startTag.f47310c);
            if (iH > 0) {
                arrayList.add(new StyleMatch(iH, webvttCssStyle));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int j(List list, String str, StartTag startTag) {
        List listI = i(list, str, startTag);
        for (int i3 = 0; i3 < listI.size(); i3++) {
            WebvttCssStyle webvttCssStyle = ((StyleMatch) listI.get(i3)).f47313b;
            if (webvttCssStyle.g() != -1) {
                return webvttCssStyle.g();
            }
        }
        return -1;
    }

    private static String k(String str) {
        String strTrim = str.trim();
        Assertions.a(!strTrim.isEmpty());
        return Util.i1(strTrim, "[ \\.]")[0];
    }

    private static boolean l(String str) {
        str.getClass();
        switch (str) {
            case "b":
            case "c":
            case "i":
            case "u":
            case "v":
            case "rt":
            case "lang":
            case "ruby":
                return true;
            default:
                return false;
        }
    }

    public static Cue m(CharSequence charSequence) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        webvttCueInfoBuilder.f47316c = charSequence;
        return webvttCueInfoBuilder.g().a();
    }

    public static WebvttCueInfo n(ParsableByteArray parsableByteArray, List list) {
        String strS = parsableByteArray.s();
        if (strS == null) {
            return null;
        }
        Pattern pattern = f47301a;
        Matcher matcher = pattern.matcher(strS);
        if (matcher.matches()) {
            return o(null, matcher, parsableByteArray, list);
        }
        String strS2 = parsableByteArray.s();
        if (strS2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strS2);
        if (matcher2.matches()) {
            return o(strS.trim(), matcher2, parsableByteArray, list);
        }
        return null;
    }

    private static WebvttCueInfo o(String str, Matcher matcher, ParsableByteArray parsableByteArray, List list) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            webvttCueInfoBuilder.f47314a = WebvttParserUtil.c((String) Assertions.e(matcher.group(1)));
            webvttCueInfoBuilder.f47315b = WebvttParserUtil.c((String) Assertions.e(matcher.group(2)));
            q((String) Assertions.e(matcher.group(3)), webvttCueInfoBuilder);
            StringBuilder sb = new StringBuilder();
            String strS = parsableByteArray.s();
            while (!TextUtils.isEmpty(strS)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strS.trim());
                strS = parsableByteArray.s();
            }
            webvttCueInfoBuilder.f47316c = r(str, sb.toString(), list);
            return webvttCueInfoBuilder.a();
        } catch (IllegalArgumentException unused) {
            Log.i("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    static Cue.Builder p(String str) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        q(str, webvttCueInfoBuilder);
        return webvttCueInfoBuilder.g();
    }

    static SpannedString r(String str, String str2, List list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < str2.length()) {
            char cCharAt = str2.charAt(i3);
            if (cCharAt == '&') {
                i3++;
                int iIndexOf = str2.indexOf(59, i3);
                int iIndexOf2 = str2.indexOf(32, i3);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    b(str2.substring(i3, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i3 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i3++;
            } else {
                int iG = i3 + 1;
                if (iG < str2.length()) {
                    boolean z2 = str2.charAt(iG) == '/';
                    iG = g(str2, iG);
                    int i4 = iG - 2;
                    boolean z3 = str2.charAt(i4) == '/';
                    int i5 = i3 + (z2 ? 2 : 1);
                    if (!z3) {
                        i4 = iG - 1;
                    }
                    String strSubstring = str2.substring(i5, i4);
                    if (!strSubstring.trim().isEmpty()) {
                        String strK = k(strSubstring);
                        if (l(strK)) {
                            if (z2) {
                                while (!arrayDeque.isEmpty()) {
                                    StartTag startTag = (StartTag) arrayDeque.pop();
                                    d(str, startTag, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new Element(startTag, spannableStringBuilder.length()));
                                    }
                                    if (startTag.f47308a.equals(strK)) {
                                        break;
                                    }
                                }
                            } else if (!z3) {
                                arrayDeque.push(StartTag.a(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i3 = iG;
            }
        }
        while (!arrayDeque.isEmpty()) {
            d(str, (StartTag) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        d(str, StartTag.b(), Collections.EMPTY_LIST, spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int s(String str) {
        str.getClass();
        switch (str) {
            case "center":
            case "middle":
                return 1;
            case "end":
                return 2;
            case "start":
                return 0;
            default:
                Log.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void t(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            webvttCueInfoBuilder.f47320g = s(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.f47318e = WebvttParserUtil.b(str);
            webvttCueInfoBuilder.f47319f = 0;
        } else {
            webvttCueInfoBuilder.f47318e = Integer.parseInt(str);
            webvttCueInfoBuilder.f47319f = 1;
        }
    }

    private static int u(String str) {
        str.getClass();
        switch (str) {
            case "line-left":
            case "start":
                return 0;
            case "center":
            case "middle":
                return 1;
            case "line-right":
            case "end":
                return 2;
            default:
                Log.i("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static void v(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            webvttCueInfoBuilder.f47322i = u(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        webvttCueInfoBuilder.f47321h = WebvttParserUtil.b(str);
    }

    private static int w(String str) {
        str.getClass();
        switch (str) {
            case "center":
            case "middle":
                return 2;
            case "end":
                return 3;
            case "left":
                return 4;
            case "right":
                return 5;
            case "start":
                return 1;
            default:
                Log.i("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int x(String str) {
        str.getClass();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        Log.i("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }

    private static void q(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        Matcher matcher = f47302b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) Assertions.e(matcher.group(1));
            String str3 = (String) Assertions.e(matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    t(str3, webvttCueInfoBuilder);
                } else if ("align".equals(str2)) {
                    webvttCueInfoBuilder.f47317d = w(str3);
                } else if ("position".equals(str2)) {
                    v(str3, webvttCueInfoBuilder);
                } else if ("size".equals(str2)) {
                    webvttCueInfoBuilder.f47323j = WebvttParserUtil.b(str3);
                } else if ("vertical".equals(str2)) {
                    webvttCueInfoBuilder.f47324k = x(str3);
                } else {
                    Log.i("WebvttCueParser", "Unknown cue setting " + str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str3);
                }
            } catch (NumberFormatException unused) {
                Log.i("WebvttCueParser", vxrlPPpdv.WufasFSIRlLL + matcher.group());
            }
        }
    }
}
