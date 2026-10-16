package org.commonmark.renderer.html;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultUrlSanitizer implements UrlSanitizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set f145571a;

    private boolean c(int i3) {
        return i3 == 9 || i3 == 10 || i3 == 12 || i3 == 13 || i3 == 32;
    }

    private String d(String str) {
        int length = str.length();
        while (length > 0 && c(str.charAt(length - 1))) {
            length--;
        }
        int i3 = 0;
        while (i3 < length && c(str.charAt(i3))) {
            i3++;
        }
        return (i3 == 0 && length == str.length()) ? str : str.substring(i3, length);
    }

    @Override // org.commonmark.renderer.html.UrlSanitizer
    public String a(String str) {
        String strD = d(str);
        int length = strD.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = strD.charAt(i3);
            if (cCharAt == '#' || cCharAt == '/') {
                return strD;
            }
            if (cCharAt == ':') {
                return !this.f145571a.contains(strD.substring(0, i3).toLowerCase()) ? "" : strD;
            }
            if (cCharAt == '?') {
                return strD;
            }
        }
        return strD;
    }

    @Override // org.commonmark.renderer.html.UrlSanitizer
    public String b(String str) {
        return a(str);
    }
}
