package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.escape.UnicodeEscaper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class PercentEscaper extends UnicodeEscaper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f85428d = {'+'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f85429e = "0123456789ABCDEF".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f85430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f85431c;

    public PercentEscaper(String str, boolean z2) {
        Preconditions.t(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String str2 = str + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        if (z2 && str2.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.f85430b = z2;
        this.f85431c = g(str2);
    }

    private static boolean[] g(String str) {
        char[] charArray = str.toCharArray();
        int iMax = -1;
        for (char c3 : charArray) {
            iMax = Math.max((int) c3, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c4 : charArray) {
            zArr[c4] = true;
        }
        return zArr;
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public String a(String str) {
        Preconditions.t(str);
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            boolean[] zArr = this.f85431c;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return d(str, i3);
            }
        }
        return str;
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected char[] c(int i3) {
        boolean[] zArr = this.f85431c;
        if (i3 < zArr.length && zArr[i3]) {
            return null;
        }
        if (i3 == 32 && this.f85430b) {
            return f85428d;
        }
        if (i3 <= 127) {
            char[] cArr = f85429e;
            return new char[]{'%', cArr[i3 >>> 4], cArr[i3 & 15]};
        }
        if (i3 <= 2047) {
            char[] cArr2 = f85429e;
            return new char[]{'%', cArr2[(i3 >>> 10) | 12], cArr2[(i3 >>> 6) & 15], '%', cArr2[((i3 >>> 4) & 3) | 8], cArr2[i3 & 15]};
        }
        if (i3 <= 65535) {
            char[] cArr3 = f85429e;
            return new char[]{'%', 'E', cArr3[i3 >>> 12], '%', cArr3[((i3 >>> 10) & 3) | 8], cArr3[(i3 >>> 6) & 15], '%', cArr3[((i3 >>> 4) & 3) | 8], cArr3[i3 & 15]};
        }
        if (i3 <= 1114111) {
            char[] cArr4 = f85429e;
            return new char[]{'%', 'F', cArr4[(i3 >>> 18) & 7], '%', cArr4[((i3 >>> 16) & 3) | 8], cArr4[(i3 >>> 12) & 15], '%', cArr4[((i3 >>> 10) & 3) | 8], cArr4[(i3 >>> 6) & 15], '%', cArr4[((i3 >>> 4) & 3) | 8], cArr4[i3 & 15]};
        }
        throw new IllegalArgumentException("Invalid unicode character value " + i3);
    }

    @Override // com.google.common.escape.UnicodeEscaper
    protected int f(CharSequence charSequence, int i3, int i4) {
        Preconditions.t(charSequence);
        while (i3 < i4) {
            char cCharAt = charSequence.charAt(i3);
            boolean[] zArr = this.f85431c;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i3++;
        }
        return i3;
    }
}
