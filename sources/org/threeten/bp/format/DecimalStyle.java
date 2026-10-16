package org.threeten.bp.format;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class DecimalStyle {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DecimalStyle f146451e = new DecimalStyle('0', '+', '-', '.');

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ConcurrentMap f146452f = new ConcurrentHashMap(16, 0.75f, 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f146453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f146454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final char f146455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char f146456d;

    private DecimalStyle(char c3, char c4, char c5, char c6) {
        this.f146453a = c3;
        this.f146454b = c4;
        this.f146455c = c5;
        this.f146456d = c6;
    }

    String a(String str) {
        char c3 = this.f146453a;
        if (c3 == '0') {
            return str;
        }
        int i3 = c3 - '0';
        char[] charArray = str.toCharArray();
        for (int i4 = 0; i4 < charArray.length; i4++) {
            charArray[i4] = (char) (charArray[i4] + i3);
        }
        return new String(charArray);
    }

    int b(char c3) {
        int i3 = c3 - this.f146453a;
        if (i3 < 0 || i3 > 9) {
            return -1;
        }
        return i3;
    }

    public char c() {
        return this.f146456d;
    }

    public char d() {
        return this.f146455c;
    }

    public char e() {
        return this.f146454b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DecimalStyle) {
            DecimalStyle decimalStyle = (DecimalStyle) obj;
            if (this.f146453a == decimalStyle.f146453a && this.f146454b == decimalStyle.f146454b && this.f146455c == decimalStyle.f146455c && this.f146456d == decimalStyle.f146456d) {
                return true;
            }
        }
        return false;
    }

    public char f() {
        return this.f146453a;
    }

    public int hashCode() {
        return this.f146453a + this.f146454b + this.f146455c + this.f146456d;
    }

    public String toString() {
        return "DecimalStyle[" + this.f146453a + this.f146454b + this.f146455c + this.f146456d + "]";
    }
}
