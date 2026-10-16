package org.commonmark.internal.util;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.common.Utf8Charset;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Escaping {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f145502a = Pattern.compile("[\\\\&]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f145503b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f145504c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f145505d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f145506e = Pattern.compile("[ \t\r\n]+");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Replacer f145507f = new Replacer() { // from class: org.commonmark.internal.util.Escaping.1
        @Override // org.commonmark.internal.util.Escaping.Replacer
        public void a(String str, StringBuilder sb) {
            if (str.charAt(0) == '\\') {
                sb.append((CharSequence) str, 1, str.length());
            } else {
                sb.append(Html5Entities.a(str));
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Replacer f145508g = new Replacer() { // from class: org.commonmark.internal.util.Escaping.2
        @Override // org.commonmark.internal.util.Escaping.Replacer
        public void a(String str, StringBuilder sb) {
            if (str.startsWith("%")) {
                if (str.length() == 3) {
                    sb.append(str);
                    return;
                } else {
                    sb.append("%25");
                    sb.append((CharSequence) str, 1, str.length());
                    return;
                }
            }
            for (byte b3 : str.getBytes(Charset.forName(Utf8Charset.NAME))) {
                sb.append('%');
                sb.append(Escaping.f145505d[(b3 >> 4) & 15]);
                sb.append(Escaping.f145505d[b3 & Ascii.SI]);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Replacer {
        void a(String str, StringBuilder sb);
    }

    public static String b(String str) {
        String str2;
        StringBuilder sb = null;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '\"') {
                str2 = "&quot;";
            } else if (cCharAt == '&') {
                str2 = "&amp;";
            } else if (cCharAt == '<') {
                str2 = "&lt;";
            } else if (cCharAt != '>') {
                if (sb != null) {
                    sb.append(cCharAt);
                }
            } else {
                str2 = "&gt;";
            }
            if (sb == null) {
                sb = new StringBuilder();
                sb.append((CharSequence) str, 0, i3);
            }
            sb.append(str2);
        }
        return sb != null ? sb.toString() : str;
    }

    public static String c(String str) {
        String strTrim = str.trim();
        Locale locale = Locale.ROOT;
        return f145506e.matcher(strTrim.toLowerCase(locale).toUpperCase(locale)).replaceAll(" ");
    }

    public static String d(String str) {
        return e(f145504c, str, f145508g);
    }

    private static String e(Pattern pattern, String str, Replacer replacer) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 16);
        int iEnd = 0;
        do {
            sb.append((CharSequence) str, iEnd, matcher.start());
            replacer.a(matcher.group(), sb);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd != str.length()) {
            sb.append((CharSequence) str, iEnd, str.length());
        }
        return sb.toString();
    }

    public static String f(String str) {
        return f145502a.matcher(str).find() ? e(f145503b, str, f145507f) : str;
    }
}
