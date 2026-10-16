package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzuk {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f78646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzuk f78647e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f78648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f78649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f78650c;

    static {
        long jCharAt = 0;
        for (int i3 = 0; i3 < 7; i3++) {
            jCharAt |= (((long) i3) + 1) << ((int) (((long) (" #(+,-0".charAt(i3) - ' ')) * 3));
        }
        f78646d = jCharAt;
        f78647e = new zzuk(0, -1, -1);
    }

    private zzuk(int i3, int i4, int i5) {
        this.f78648a = i3;
        this.f78649b = i4;
        this.f78650c = i5;
    }

    public static zzuk a() {
        return f78647e;
    }

    public static zzuk b(String str, int i3, int i4, boolean z2) {
        if (i3 == i4 && !z2) {
            return f78647e;
        }
        int i5 = true != z2 ? 0 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        while (i3 != i4) {
            int i6 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt < ' ' || cCharAt > '0') {
                if (cCharAt > '9') {
                    throw zzwy.b("invalid flag", str, i3);
                }
                int i7 = cCharAt - '0';
                while (i6 != i4) {
                    int i8 = i6 + 1;
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 == '.') {
                        return new zzuk(i5, i7, n(str, i8, i4));
                    }
                    char c3 = (char) (cCharAt2 - '0');
                    if (c3 >= '\n') {
                        throw zzwy.b("invalid width character", str, i6);
                    }
                    i7 = (i7 * 10) + c3;
                    if (i7 > 999999) {
                        throw zzwy.a("width too large", str, i3, i4);
                    }
                    i6 = i8;
                }
                return new zzuk(i5, i7, -1);
            }
            int iM = m(cCharAt);
            if (iM < 0) {
                if (cCharAt == '.') {
                    return new zzuk(i5, -1, n(str, i6, i4));
                }
                throw zzwy.b("invalid flag", str, i3);
            }
            int i9 = 1 << iM;
            if ((i5 & i9) != 0) {
                throw zzwy.b("repeated flag", str, i3);
            }
            i5 |= i9;
            i3 = i6;
        }
        return new zzuk(i5, -1, -1);
    }

    static int c(String str, boolean z2) {
        int i3 = true != z2 ? 0 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        for (int i4 = 0; i4 < str.length(); i4++) {
            int iM = m(str.charAt(i4));
            if (iM < 0) {
                throw new IllegalArgumentException("invalid flags: ".concat(str));
            }
            i3 |= 1 << iM;
        }
        return i3;
    }

    private static int m(char c3) {
        return ((int) ((f78646d >>> ((c3 - ' ') * 3)) & 7)) - 1;
    }

    private static int n(String str, int i3, int i4) {
        if (i3 == i4) {
            throw zzwy.b("missing precision", str, i3 - 1);
        }
        int i5 = 0;
        for (int i6 = i3; i6 < i4; i6++) {
            char cCharAt = (char) (str.charAt(i6) - '0');
            if (cCharAt >= '\n') {
                throw zzwy.b("invalid precision character", str, i6);
            }
            i5 = (i5 * 10) + cCharAt;
            if (i5 > 999999) {
                throw zzwy.a("precision too large", str, i3, i4);
            }
        }
        if (i5 != 0) {
            return i5;
        }
        if (i4 == i3 + 1) {
            return 0;
        }
        throw zzwy.a("invalid precision", str, i3, i4);
    }

    public final zzuk d(int i3, boolean z2, boolean z3) {
        if (!e()) {
            int i4 = this.f78648a;
            int i5 = i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 == 0) {
                return f78647e;
            }
            if (i5 != i4 || this.f78649b != -1 || this.f78650c != -1) {
                return new zzuk(i5, -1, -1);
            }
        }
        return this;
    }

    public final boolean e() {
        return this == f78647e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzuk) {
            zzuk zzukVar = (zzuk) obj;
            if (zzukVar.f78648a == this.f78648a && zzukVar.f78649b == this.f78649b && zzukVar.f78650c == this.f78650c) {
                return true;
            }
        }
        return false;
    }

    public final int f() {
        return this.f78649b;
    }

    public final int g() {
        return this.f78650c;
    }

    public final boolean h(int i3, boolean z2) {
        int i4;
        if (e()) {
            return true;
        }
        int i5 = this.f78648a;
        if (((~i3) & i5) != 0) {
            return false;
        }
        if (!z2 && this.f78650c != -1) {
            return false;
        }
        int i6 = this.f78649b;
        if ((i5 & 9) == 9 || (i4 = i5 & 96) == 96) {
            return false;
        }
        return i4 == 0 || i6 != -1;
    }

    public final int hashCode() {
        return (((this.f78648a * 31) + this.f78649b) * 31) + this.f78650c;
    }

    public final boolean i(zzuj zzujVar) {
        return h(zzujVar.d(), zzujVar.c().a());
    }

    public final int j() {
        return this.f78648a;
    }

    public final boolean k() {
        return (this.f78648a & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
    }

    public final StringBuilder l(StringBuilder sb) {
        if (!e()) {
            int i3 = this.f78648a;
            int i4 = 0;
            while (true) {
                int i5 = i3 & (-129);
                int i6 = 1 << i4;
                if (i6 > i5) {
                    break;
                }
                if ((i5 & i6) != 0) {
                    sb.append(" #(+,-0".charAt(i4));
                }
                i4++;
            }
            int i7 = this.f78649b;
            if (i7 != -1) {
                sb.append(i7);
            }
            int i8 = this.f78650c;
            if (i8 != -1) {
                sb.append('.');
                sb.append(i8);
            }
        }
        return sb;
    }
}
