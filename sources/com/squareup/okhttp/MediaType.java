package com.squareup.okhttp;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class MediaType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f92945e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f92946f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f92948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f92949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f92950d;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f92947a = str;
        this.f92948b = str2;
        this.f92949c = str3;
        this.f92950d = str4;
    }

    public static MediaType a(String str) {
        Matcher matcher = f92945e.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = strGroup.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        Matcher matcher2 = f92946f.matcher(str);
        String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                String strGroup3 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple different charsets: " + str);
                }
                str2 = strGroup3;
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).f92947a.equals(this.f92947a);
    }

    public int hashCode() {
        return this.f92947a.hashCode();
    }

    public String toString() {
        return this.f92947a;
    }
}
