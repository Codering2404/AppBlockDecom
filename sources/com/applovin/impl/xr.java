package com.applovin.impl;

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
import com.applovin.impl.a5;
import com.applovin.impl.xr;
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
/* JADX INFO: loaded from: classes4.dex */
public abstract class xr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f65048a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f65049b = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f65050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f65051d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Comparator f65052c = new Comparator() { // from class: com.applovin.impl.w80
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return xr.b.a((xr.b) obj, (xr.b) obj2);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f65053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f65054b;

        private b(c cVar, int i3) {
            this.f65053a = cVar;
            this.f65054b = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(b bVar, b bVar2) {
            return Integer.compare(bVar.f65053a.f65056b, bVar2.f65053a.f65056b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vr f65060b;

        public d(int i3, vr vrVar) {
            this.f65059a = i3;
            this.f65060b = vrVar;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            return Integer.compare(this.f65059a, dVar.f65059a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f65063c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f65061a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f65062b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f65064d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f65065e = -3.4028235E38f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f65066f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f65067g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f65068h = -3.4028235E38f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f65069i = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f65070j = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f65071k = Integer.MIN_VALUE;

        private static float a(float f3, int i3) {
            if (f3 == -3.4028235E38f || i3 != 0 || (f3 >= 0.0f && f3 <= 1.0f)) {
                return f3 != -3.4028235E38f ? f3 : i3 == 0 ? 1.0f : -3.4028235E38f;
            }
            return 1.0f;
        }

        private static float b(int i3) {
            if (i3 != 4) {
                return i3 != 5 ? 0.5f : 1.0f;
            }
            return 0.0f;
        }

        private static int c(int i3) {
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

        private static Layout.Alignment a(int i3) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            oc.d("WebvttCueParser", "Unknown textAlignment: " + i3);
                            return null;
                        }
                    }
                }
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        public a5.b b() {
            float fB = this.f65068h;
            if (fB == -3.4028235E38f) {
                fB = b(this.f65064d);
            }
            int iC = this.f65069i;
            if (iC == Integer.MIN_VALUE) {
                iC = c(this.f65064d);
            }
            a5.b bVarC = new a5.b().b(a(this.f65064d)).a(a(this.f65065e, this.f65066f), this.f65066f).a(this.f65067g).b(fB).b(iC).d(Math.min(this.f65070j, a(iC, fB))).c(this.f65071k);
            CharSequence charSequence = this.f65063c;
            if (charSequence != null) {
                bVarC.a(charSequence);
            }
            return bVarC;
        }

        private static float a(int i3, float f3) {
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

        public wr a() {
            return new wr(b().a(), this.f65061a, this.f65062b);
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
        f65050c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f65051d = Collections.unmodifiableMap(map2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set set, int i3, int i4) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Map map = f65050c;
            if (map.containsKey(str)) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str)).intValue()), i3, i4, 33);
            } else {
                Map map2 = f65051d;
                if (map2.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str)).intValue()), i3, i4, 33);
                }
            }
        }
    }

    private static int b(List list, String str, c cVar) {
        List listA = a(list, str, cVar);
        for (int i3 = 0; i3 < listA.size(); i3++) {
            vr vrVar = ((d) listA.get(i3)).f65060b;
            if (vrVar.g() != -1) {
                return vrVar.g();
            }
        }
        return -1;
    }

    static a5.b c(String str) {
        e eVar = new e();
        a(str, eVar);
        return eVar.b();
    }

    private static int d(String str) {
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
                oc.d("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int e(String str) {
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
                oc.d("WebvttCueParser", "Invalid anchor value: " + str);
                return Integer.MIN_VALUE;
        }
    }

    private static int f(String str) {
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
                oc.d("WebvttCueParser", "Invalid alignment value: " + str);
                return 2;
        }
    }

    private static int g(String str) {
        str.getClass();
        if (str.equals("lr")) {
            return 2;
        }
        if (str.equals("rl")) {
            return 1;
        }
        oc.d("WebvttCueParser", "Invalid 'vertical' value: " + str);
        return Integer.MIN_VALUE;
    }

    private static void c(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f65069i = e(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        eVar.f65068h = zr.a(str);
    }

    private static boolean b(String str) {
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

    private static void b(String str, e eVar) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            eVar.f65067g = d(str.substring(iIndexOf + 1));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            eVar.f65065e = zr.a(str);
            eVar.f65066f = 0;
        } else {
            eVar.f65065e = Integer.parseInt(str);
            eVar.f65066f = 1;
        }
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
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
                oc.d("WebvttCueParser", "ignoring unsupported entity: '&" + str + ";'");
                break;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f65055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f65057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set f65058d;

        private c(String str, int i3, String str2, Set set) {
            this.f65056b = i3;
            this.f65055a = str;
            this.f65057c = str2;
            this.f65058d = set;
        }

        public static c a(String str, int i3) {
            String str2;
            String strTrim = str.trim();
            b1.a(!strTrim.isEmpty());
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            String[] strArrA = xp.a(strTrim, "\\.");
            String str3 = strArrA[0];
            HashSet hashSet = new HashSet();
            for (int i4 = 1; i4 < strArrA.length; i4++) {
                hashSet.add(strArrA[i4]);
            }
            return new c(str3, i3, str2, hashSet);
        }

        public static c a() {
            return new c("", 0, "", Collections.EMPTY_SET);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, c cVar, List list, List list2) {
        int iB = b(list2, str, cVar);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, b.f65052c);
        int i3 = cVar.f65056b;
        int length = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if ("rt".equals(((b) arrayList.get(i4)).f65053a.f65055a)) {
                b bVar = (b) arrayList.get(i4);
                int iA = a(b(list2, str, bVar.f65053a), iB, 1);
                int i5 = bVar.f65053a.f65056b - length;
                int i6 = bVar.f65054b - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i5, i6);
                spannableStringBuilder.delete(i5, i6);
                spannableStringBuilder.setSpan(new zi(charSequenceSubSequence.toString(), iA), i3, i5, 33);
                length += charSequenceSubSequence.length();
                i3 = i5;
            }
        }
    }

    private static void a(String str, c cVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i3;
        int length;
        i3 = cVar.f65056b;
        length = spannableStringBuilder.length();
        String str2 = cVar.f65055a;
        str2.getClass();
        switch (str2) {
            case "":
            case "v":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i3, length, 33);
                break;
            case "c":
                a(spannableStringBuilder, cVar.f65058d, i3, length);
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, length, 33);
                break;
            case "ruby":
                a(spannableStringBuilder, str, cVar, list, list2);
                break;
            default:
                return;
        }
        List listA = a(list2, str, cVar);
        for (int i4 = 0; i4 < listA.size(); i4++) {
            a(spannableStringBuilder, ((d) listA.get(i4)).f65060b, i3, length);
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, vr vrVar, int i3, int i4) {
        if (vrVar == null) {
            return;
        }
        if (vrVar.h() != -1) {
            pk.a(spannableStringBuilder, new StyleSpan(vrVar.h()), i3, i4, 33);
        }
        if (vrVar.k()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i3, i4, 33);
        }
        if (vrVar.l()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, 33);
        }
        if (vrVar.j()) {
            pk.a(spannableStringBuilder, new ForegroundColorSpan(vrVar.c()), i3, i4, 33);
        }
        if (vrVar.i()) {
            pk.a(spannableStringBuilder, new BackgroundColorSpan(vrVar.a()), i3, i4, 33);
        }
        if (vrVar.d() != null) {
            pk.a(spannableStringBuilder, new TypefaceSpan(vrVar.d()), i3, i4, 33);
        }
        int iF = vrVar.f();
        if (iF == 1) {
            pk.a(spannableStringBuilder, new AbsoluteSizeSpan((int) vrVar.e(), true), i3, i4, 33);
        } else if (iF == 2) {
            pk.a(spannableStringBuilder, new RelativeSizeSpan(vrVar.e()), i3, i4, 33);
        } else if (iF == 3) {
            pk.a(spannableStringBuilder, new RelativeSizeSpan(vrVar.e() / 100.0f), i3, i4, 33);
        }
        if (vrVar.b()) {
            spannableStringBuilder.setSpan(new oa(), i3, i4, 33);
        }
    }

    private static int a(String str, int i3) {
        int iIndexOf = str.indexOf(62, i3);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    private static int a(int i3, int i4, int i5) {
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

    private static String a(String str) {
        String strTrim = str.trim();
        b1.a(!strTrim.isEmpty());
        return xp.b(strTrim, "[ \\.]")[0];
    }

    public static wr a(ah ahVar, List list) {
        String strL = ahVar.l();
        if (strL == null) {
            return null;
        }
        Pattern pattern = f65048a;
        Matcher matcher = pattern.matcher(strL);
        if (matcher.matches()) {
            return a((String) null, matcher, ahVar, list);
        }
        String strL2 = ahVar.l();
        if (strL2 == null) {
            return null;
        }
        Matcher matcher2 = pattern.matcher(strL2);
        if (matcher2.matches()) {
            return a(strL.trim(), matcher2, ahVar, list);
        }
        return null;
    }

    private static wr a(String str, Matcher matcher, ah ahVar, List list) {
        e eVar = new e();
        try {
            eVar.f65061a = zr.b((String) b1.a((Object) matcher.group(1)));
            eVar.f65062b = zr.b((String) b1.a((Object) matcher.group(2)));
            a((String) b1.a((Object) matcher.group(3)), eVar);
            StringBuilder sb = new StringBuilder();
            String strL = ahVar.l();
            while (!TextUtils.isEmpty(strL)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strL.trim());
                strL = ahVar.l();
            }
            eVar.f65063c = a(str, sb.toString(), list);
            return eVar.a();
        } catch (NumberFormatException unused) {
            oc.d("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    static a5 a(CharSequence charSequence) {
        e eVar = new e();
        eVar.f65063c = charSequence;
        return eVar.b().a();
    }

    static SpannedString a(String str, String str2, List list) {
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
                    a(str2.substring(i3, iIndexOf), spannableStringBuilder);
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
                int iA = i3 + 1;
                if (iA < str2.length()) {
                    boolean z2 = str2.charAt(iA) == '/';
                    iA = a(str2, iA);
                    int i4 = iA - 2;
                    boolean z3 = str2.charAt(i4) == '/';
                    int i5 = i3 + (z2 ? 2 : 1);
                    if (!z3) {
                        i4 = iA - 1;
                    }
                    String strSubstring = str2.substring(i5, i4);
                    if (!strSubstring.trim().isEmpty()) {
                        String strA = a(strSubstring);
                        if (b(strA)) {
                            if (z2) {
                                while (!arrayDeque.isEmpty()) {
                                    c cVar = (c) arrayDeque.pop();
                                    a(str, cVar, arrayList, spannableStringBuilder, list);
                                    if (!arrayDeque.isEmpty()) {
                                        arrayList.add(new b(cVar, spannableStringBuilder.length()));
                                    } else {
                                        arrayList.clear();
                                    }
                                    if (cVar.f65055a.equals(strA)) {
                                        break;
                                    }
                                }
                            } else if (!z3) {
                                arrayDeque.push(c.a(strSubstring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i3 = iA;
            }
        }
        while (!arrayDeque.isEmpty()) {
            a(str, (c) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        a(str, c.a(), Collections.EMPTY_LIST, spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static void a(String str, e eVar) {
        Matcher matcher = f65049b.matcher(str);
        while (matcher.find()) {
            String str2 = (String) b1.a((Object) matcher.group(1));
            String str3 = (String) b1.a((Object) matcher.group(2));
            try {
                if ("line".equals(str2)) {
                    b(str3, eVar);
                } else if ("align".equals(str2)) {
                    eVar.f65064d = f(str3);
                } else if ("position".equals(str2)) {
                    c(str3, eVar);
                } else if ("size".equals(str2)) {
                    eVar.f65070j = zr.a(str3);
                } else if ("vertical".equals(str2)) {
                    eVar.f65071k = g(str3);
                } else {
                    oc.d("WebvttCueParser", "Unknown cue setting " + str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str3);
                }
            } catch (NumberFormatException unused) {
                oc.d("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    private static List a(List list, String str, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            vr vrVar = (vr) list.get(i3);
            int iA = vrVar.a(str, cVar.f65055a, cVar.f65058d, cVar.f65057c);
            if (iA > 0) {
                arrayList.add(new d(iA, vrVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
